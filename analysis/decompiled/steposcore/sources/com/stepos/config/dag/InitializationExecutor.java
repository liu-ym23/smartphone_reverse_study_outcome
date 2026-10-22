package com.stepos.config.dag;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.stepos.config.dag.ConfigNode;
import com.stepos.config.dag.loader.ConfigLoader;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class InitializationExecutor {
    private static final String TAG = "ConfigInitExecutor";
    private final Handler lazyInitHandler;
    private final ConfigurationRegistry registry;
    private final Map<String, ConfigLoader> configLoaders = new ConcurrentHashMap();
    private final ConfigFrameworkSettings settings = ConfigFrameworkSettings.defaultSettings();
    private final ExecutorService executorService = Executors.newFixedThreadPool(this.settings.getThreadPoolSize(), new ThreadFactory() { // from class: com.stepos.config.dag.InitializationExecutor$$ExternalSyntheticLambda1
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return InitializationExecutor.lambda$new$0(runnable);
        }
    });

    public InitializationExecutor(ConfigurationRegistry registry) {
        this.registry = registry;
        HandlerThread lazyThread = new HandlerThread("ConfigInit-Lazy");
        lazyThread.start();
        this.lazyInitHandler = new Handler(lazyThread.getLooper());
    }

    static /* synthetic */ Thread lambda$new$0(Runnable r) {
        return new Thread(r, "ConfigInit-Worker");
    }

    public void registerConfigLoader(String configName, ConfigLoader loader) {
        this.configLoaders.put(configName, loader);
    }

    public void unregisterConfigLoader(String configName) {
        this.configLoaders.remove(configName);
    }

    public ConfigLoader getConfigLoader(String configName) {
        return this.configLoaders.get(configName);
    }

    public void setSettings(ConfigFrameworkSettings settings) {
    }

    public void executeEagerInit(List<String> initOrder) throws ConfigInitException {
        Log.i(TAG, "Starting EAGER initialization");
        for (String configName : initOrder) {
            ConfigNode node = this.registry.getConfigNode(configName);
            if (node != null && node.getStrategy() == InitializationStrategy.EAGER) {
                initializeNode(node);
            }
        }
    }

    public void scheduleLazyInit(final List<String> initOrder) {
        this.lazyInitHandler.postDelayed(new Runnable() { // from class: com.stepos.config.dag.InitializationExecutor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$scheduleLazyInit$1(initOrder);
            }
        }, this.settings.getLazyInitDelayMs());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleLazyInit$1(List initOrder) {
        Log.i(TAG, "Starting LAZY initialization");
        Iterator it = initOrder.iterator();
        while (it.hasNext()) {
            String configName = (String) it.next();
            ConfigNode node = this.registry.getConfigNode(configName);
            if (node != null && node.getStrategy() == InitializationStrategy.LAZY && node.getState() == ConfigNode.InitState.UNINITIALIZED) {
                try {
                    initializeNode(node);
                } catch (ConfigInitException e) {
                    Log.e(TAG, "LAZY init failed for " + configName, e);
                }
            }
        }
    }

    public void executeOnDemand(ConfigNode node) throws ConfigInitException {
        node.getInitLock().lock();
        while (true) {
            try {
                ConfigNode.InitState state = node.getState();
                if (state == ConfigNode.InitState.INITIALIZED) {
                    return;
                }
                if (state == ConfigNode.InitState.INITIALIZING) {
                    try {
                        Thread.sleep(100L);
                        if (node.getState() == ConfigNode.InitState.INITIALIZED) {
                            return;
                        }
                        if (System.currentTimeMillis() - node.getInitStartTime() > this.settings.getOnDemandTimeoutMs()) {
                            throw new ConfigInitException("Initialization timeout: " + node.getConfigName());
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new ConfigInitException("Initialization interrupted: " + node.getConfigName());
                    }
                } else {
                    if (state == ConfigNode.InitState.FAILED) {
                        throw new ConfigInitException("Config previously failed: " + node.getConfigName(), node.getInitException());
                    }
                    if (node.compareAndSetState(ConfigNode.InitState.UNINITIALIZED, ConfigNode.InitState.INITIALIZING)) {
                        initializeNodeInternal(node);
                        return;
                    }
                }
            } finally {
                node.getInitLock().unlock();
            }
        }
    }

    public void reloadConfig(ConfigNode node) throws ConfigInitException {
        node.getInitLock().lock();
        try {
            ConfigBean oldBean = node.getBeanInstance();
            if (oldBean != null) {
                oldBean.onUnload();
            }
            node.setBeanInstance(null);
            node.setInitException(null);
            node.setState(ConfigNode.InitState.UNINITIALIZED);
            node.setState(ConfigNode.InitState.INITIALIZING);
            initializeNodeInternal(node);
        } finally {
            node.getInitLock().unlock();
        }
    }

    public void retryFailed(ConfigNode node) throws ConfigInitException {
        node.getInitLock().lock();
        try {
            if (!node.canRetry()) {
                throw new ConfigInitException("Config cannot be retried: " + node.getConfigName());
            }
            node.resetForRetry();
            node.setState(ConfigNode.InitState.INITIALIZING);
            initializeNodeInternal(node);
        } finally {
            node.getInitLock().unlock();
        }
    }

    private void initializeNode(ConfigNode node) throws ConfigInitException {
        node.getInitLock().lock();
        try {
            if (node.compareAndSetState(ConfigNode.InitState.UNINITIALIZED, ConfigNode.InitState.INITIALIZING)) {
                initializeNodeInternal(node);
                return;
            }
            ConfigNode.InitState state = node.getState();
            if (state == ConfigNode.InitState.INITIALIZED) {
                return;
            }
            if (state == ConfigNode.InitState.INITIALIZING) {
                throw new ConfigInitException("Config is being initialized: " + node.getConfigName());
            }
            if (state == ConfigNode.InitState.FAILED) {
                throw new ConfigInitException("Config previously failed: " + node.getConfigName(), node.getInitException());
            }
        } finally {
            node.getInitLock().unlock();
        }
    }

    private void initializeNodeInternal(ConfigNode node) throws IllegalAccessException, InstantiationException, IllegalArgumentException, ConfigInitException, InvocationTargetException {
        String configName = node.getConfigName();
        Log.d(TAG, "Initializing config: " + configName);
        node.setInitStartTime(System.currentTimeMillis());
        try {
            for (String depName : node.getDependencies()) {
                ConfigNode depNode = this.registry.getConfigNode(depName);
                if (depNode == null) {
                    throw new ConfigInitException("Dependency not found: " + depName);
                }
                if (depNode.getState() != ConfigNode.InitState.INITIALIZED) {
                    if (depNode.getStrategy() == InitializationStrategy.ON_DEMAND && depNode.getState() == ConfigNode.InitState.UNINITIALIZED) {
                        executeOnDemand(depNode);
                    } else {
                        throw new ConfigInitException("Dependency not ready: " + depName + " (state=" + depNode.getState() + ")");
                    }
                }
            }
            ConfigBean bean = node.getBeanClass().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            ConfigLoader configLoader = this.configLoaders.get(configName);
            if (configLoader != null) {
                configLoader.parseConfig(configName, bean, this.registry);
            } else {
                Log.d(TAG, "No config loader found for: " + configName + ", using defaults");
            }
            if (!bean.validate()) {
                throw new ConfigInitException("Config validation failed: " + configName);
            }
            bean.onInitialized();
            node.setBeanInstance(bean);
            node.setInitDuration(System.currentTimeMillis() - node.getInitStartTime());
            node.setState(ConfigNode.InitState.INITIALIZED);
            Log.i(TAG, "Config initialized successfully: " + configName + " (duration=" + node.getInitDuration() + "ms)");
            this.registry.notifyConfigLoaded(configName, bean);
        } catch (ConfigInitException e) {
            handleInitFailure(node, e);
            throw e;
        } catch (Exception e2) {
            ConfigInitException cie = new ConfigInitException("Failed to initialize config: " + configName, e2);
            handleInitFailure(node, cie);
            throw cie;
        }
    }

    private void handleInitFailure(ConfigNode node, ConfigInitException e) {
        node.setInitException(e);
        node.setInitDuration(System.currentTimeMillis() - node.getInitStartTime());
        node.setState(ConfigNode.InitState.FAILED);
        Log.e(TAG, "Config initialization failed: " + node.getConfigName(), e);
        this.registry.notifyConfigFailed(node.getConfigName(), e);
    }

    public void shutdown() {
        this.executorService.shutdown();
        try {
            if (!this.executorService.awaitTermination(5L, TimeUnit.SECONDS)) {
                this.executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            this.executorService.shutdownNow();
        }
        this.lazyInitHandler.getLooper().quitSafely();
    }
}
