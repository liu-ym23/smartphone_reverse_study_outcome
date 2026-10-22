package com.stepos.config.dag;

import android.util.Log;
import com.stepos.config.dag.ConfigNode;

/* loaded from: classes.dex */
public class ConfigurationInitializer {
    private static final String TAG = "ConfigInitializer";
    private final ConfigurationRegistry registry;

    public ConfigurationInitializer(ConfigurationRegistry registry) {
        this.registry = registry;
    }

    public static ConfigurationInitializer getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final ConfigurationInitializer INSTANCE = new ConfigurationInitializer(ConfigurationRegistry.getInstance());

        private SingletonHolder() {
        }
    }

    public void registerConfig(ConfigNode node) {
        this.registry.registerConfig(node);
    }

    public void initializeConfigurations() throws ConfigInitException {
        Log.i(TAG, "开始配置初始化");
        this.registry.buildAndInitialize();
        Log.i(TAG, "配置初始化完成");
    }

    public void initializeNode(ConfigNode node) throws ConfigInitException {
        if (node.getState() == ConfigNode.InitState.UNINITIALIZED) {
            Log.d(TAG, "按需初始化配置: " + node.getConfigName());
            this.registry.getConfig(node.getConfigName());
        }
    }

    public <T extends ConfigBean> T getConfig(String str) throws ConfigInitException {
        return (T) this.registry.getConfig(str);
    }

    public void reloadConfig(String configName) throws ConfigInitException {
        this.registry.reloadConfig(configName);
    }

    public boolean retryFailedConfig(String configName) throws ConfigInitException {
        return this.registry.retryFailedConfig(configName);
    }

    public boolean isInitialized(String configName) {
        return this.registry.isInitialized(configName);
    }

    public void addListener(ConfigChangeListener listener) {
        this.registry.addListener(listener);
    }

    public void removeListener(ConfigChangeListener listener) {
        this.registry.removeListener(listener);
    }

    public ConfigMonitor getMonitor() {
        return this.registry.getMonitor();
    }

    public ConfigurationRegistry getRegistry() {
        return this.registry;
    }

    public void shutdown() {
        Log.i(TAG, "关闭配置初始化器");
        this.registry.shutdown();
    }
}
