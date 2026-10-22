package com.stepos.config.dag;

/* loaded from: classes.dex */
public class ConfigFrameworkSettings {
    private int threadPoolSize = 4;
    private long lazyInitDelayMs = 5000;
    private long onDemandTimeoutMs = 10000;
    private boolean enableParallelInit = true;
    private boolean enableDetailedLog = false;

    public static ConfigFrameworkSettings defaultSettings() {
        return new ConfigFrameworkSettings();
    }

    public ConfigFrameworkSettings threadPoolSize(int size) {
        this.threadPoolSize = size;
        return this;
    }

    public ConfigFrameworkSettings lazyInitDelayMs(long delayMs) {
        this.lazyInitDelayMs = delayMs;
        return this;
    }

    public ConfigFrameworkSettings onDemandTimeoutMs(long timeoutMs) {
        this.onDemandTimeoutMs = timeoutMs;
        return this;
    }

    public ConfigFrameworkSettings enableParallelInit(boolean enable) {
        this.enableParallelInit = enable;
        return this;
    }

    public ConfigFrameworkSettings enableDetailedLog(boolean enable) {
        this.enableDetailedLog = enable;
        return this;
    }

    public int getThreadPoolSize() {
        return this.threadPoolSize;
    }

    public long getLazyInitDelayMs() {
        return this.lazyInitDelayMs;
    }

    public long getOnDemandTimeoutMs() {
        return this.onDemandTimeoutMs;
    }

    public boolean isEnableParallelInit() {
        return this.enableParallelInit;
    }

    public boolean isEnableDetailedLog() {
        return this.enableDetailedLog;
    }
}
