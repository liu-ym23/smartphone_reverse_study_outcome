package com.stepos.config.dag;

import android.util.Log;
import com.stepos.config.dag.ConfigNode;
import com.stepos.config.dag.loader.ConfigLoader;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class ConfigurationRegistry {
    private static volatile ConfigurationRegistry INSTANCE = null;
    private static final String TAG = "ConfigRegistry";
    private final Map<String, ConfigNode> configNodes = new ConcurrentHashMap();
    private final DependencyGraphBuilder graphBuilder = new DependencyGraphBuilder();
    private final List<ConfigChangeListener> listeners = new CopyOnWriteArrayList();
    private volatile boolean initialized = false;
    private final InitializationExecutor executor = new InitializationExecutor(this);
    private final ConfigMonitor monitor = new ConfigMonitor(this);

    private ConfigurationRegistry() {
    }

    public static ConfigurationRegistry getInstance() {
        if (INSTANCE == null) {
            synchronized (ConfigurationRegistry.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ConfigurationRegistry();
                }
            }
        }
        return INSTANCE;
    }

    public void registerConfig(ConfigNode node) {
        synchronized (this) {
            if (this.initialized) {
                throw new IllegalStateException("Cannot register config after initialization");
            }
            String configName = node.getConfigName();
            if (this.configNodes.containsKey(configName)) {
                Log.w(TAG, "Config already registered: " + configName);
                return;
            }
            this.configNodes.put(configName, node);
            this.graphBuilder.addNode(node);
            for (String dep : node.getDependencies()) {
                this.graphBuilder.addDependency(configName, dep);
            }
            Log.d(TAG, "Registered config: " + configName + ", strategy=" + node.getStrategy() + ", dependencies=" + node.getDependencies());
        }
    }

    public void lateAddAndInit(ConfigNode node) {
        synchronized (this) {
            String configName = node.getConfigName();
            if (this.configNodes.containsKey(configName)) {
                Log.w(TAG, "Config already registered (late): " + configName);
                return;
            }
            this.configNodes.put(configName, node);
            try {
                this.executor.executeOnDemand(node);
            } catch (ConfigInitException e) {
                Log.e(TAG, "Late init failed for " + node.getConfigName(), e);
            }
        }
    }

    public void registerMissingDependencyPlaceholder(String configName) {
        synchronized (this) {
            if (!this.configNodes.containsKey(configName)) {
                this.graphBuilder.addMissingPlaceholder(configName);
            }
        }
    }

    public void buildAndInitialize() throws ConfigInitException {
        synchronized (this) {
            if (this.initialized) {
                Log.w(TAG, "Already initialized");
                return;
            }
            Log.i(TAG, "Building dependency graph for " + this.configNodes.size() + " configs");
            CycleDetectionResult cycleResult = this.graphBuilder.detectCycle();
            if (cycleResult.hasCycle()) {
                throw new ConfigInitException("Circular dependency detected: " + cycleResult);
            }
            validateMissingDependencies();
            List<String> initOrder = this.graphBuilder.topologicalSort();
            Log.d(TAG, "Initialization order: " + initOrder);
            this.executor.executeEagerInit(initOrder);
            this.initialized = true;
            Log.i(TAG, "Configuration initialization completed");
            this.executor.scheduleLazyInit(initOrder);
        }
    }

    private void validateMissingDependencies() throws ConfigInitException {
        Set<String> missing = this.graphBuilder.getMissingDependencies();
        if (!missing.isEmpty()) {
            throw new ConfigInitException("Missing dependencies: " + missing + ". Please register these configs before initialization.");
        }
    }

    public <T extends ConfigBean> T getConfig(String str) throws ConfigInitException {
        ConfigNode configNode = this.configNodes.get(str);
        if (configNode == null) {
            throw new ConfigInitException("Config not found: " + str);
        }
        if (configNode.getState() == ConfigNode.InitState.UNINITIALIZED && configNode.getStrategy() == InitializationStrategy.ON_DEMAND) {
            this.executor.executeOnDemand(configNode);
        }
        return (T) waitForInitialization(configNode);
    }

    private <T extends ConfigBean> T waitForInitialization(ConfigNode configNode) throws ConfigInitException {
        T t = (T) configNode.getBeanInstance();
        if (t != null) {
            return t;
        }
        ConfigNode.InitState state = configNode.getState();
        if (state == ConfigNode.InitState.FAILED || state == ConfigNode.InitState.RECOVERING) {
            throw new ConfigInitException("Config initialization failed: " + configNode.getConfigName(), configNode.getInitException());
        }
        if (state == ConfigNode.InitState.INITIALIZING) {
            throw new ConfigInitException("Config is being initialized, please retry later: " + configNode.getConfigName());
        }
        throw new ConfigInitException("Config not initialized: " + configNode.getConfigName());
    }

    public void reloadConfig(String configName) throws ConfigInitException {
        ConfigNode node = this.configNodes.get(configName);
        if (node == null) {
            throw new ConfigInitException("Config not found: " + configName);
        }
        ConfigBean oldBean = node.getBeanInstance();
        this.executor.reloadConfig(node);
        ConfigBean newBean = node.getBeanInstance();
        notifyConfigReloaded(configName, oldBean, newBean);
    }

    public boolean retryFailedConfig(String configName) throws ConfigInitException {
        ConfigNode node = this.configNodes.get(configName);
        if (node == null || !node.canRetry()) {
            return false;
        }
        this.executor.retryFailed(node);
        return node.getState() == ConfigNode.InitState.INITIALIZED;
    }

    public ConfigNode getConfigNode(String configName) {
        return this.configNodes.get(configName);
    }

    public boolean isInitialized(String configName) {
        ConfigNode node = this.configNodes.get(configName);
        return node != null && node.getState() == ConfigNode.InitState.INITIALIZED;
    }

    public Set<String> getAllConfigNames() {
        return Collections.unmodifiableSet(this.configNodes.keySet());
    }

    public void addListener(ConfigChangeListener listener) {
        this.listeners.add(listener);
    }

    public void removeListener(ConfigChangeListener listener) {
        this.listeners.remove(listener);
    }

    void notifyConfigLoaded(String configName, ConfigBean config) {
        for (ConfigChangeListener listener : this.listeners) {
            try {
                listener.onConfigLoaded(configName, config);
            } catch (Exception e) {
                Log.e(TAG, "Listener error for " + configName, e);
            }
        }
    }

    void notifyConfigReloaded(String configName, ConfigBean oldConfig, ConfigBean newConfig) {
        for (ConfigChangeListener listener : this.listeners) {
            try {
                listener.onConfigReloaded(configName, oldConfig, newConfig);
            } catch (Exception e) {
                Log.e(TAG, "Listener error for " + configName, e);
            }
        }
    }

    void notifyConfigFailed(String configName, Throwable error) {
        for (ConfigChangeListener listener : this.listeners) {
            try {
                listener.onConfigFailed(configName, error);
            } catch (Exception e) {
                Log.e(TAG, "Listener error for " + configName, e);
            }
        }
    }

    public ConfigMonitor getMonitor() {
        return this.monitor;
    }

    public void registerConfigLoader(String configName, ConfigLoader loader) {
        this.executor.registerConfigLoader(configName, loader);
    }

    public void unregisterConfigLoader(String configName) {
        this.executor.unregisterConfigLoader(configName);
    }

    public ConfigLoader getConfigLoader(String configName) {
        return this.executor.getConfigLoader(configName);
    }

    public void shutdown() {
        this.executor.shutdown();
        this.configNodes.clear();
        this.listeners.clear();
        this.initialized = false;
    }

    public boolean isFrameworkInitialized() {
        return this.initialized;
    }
}
