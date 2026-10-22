package com.stepos.config.dag;

/* loaded from: classes.dex */
public class ConfigInitException extends Exception {
    private final String configName;

    public ConfigInitException(String message) {
        super(message);
        this.configName = null;
    }

    public ConfigInitException(String message, Throwable cause) {
        super(message, cause);
        this.configName = null;
    }

    public ConfigInitException(String configName, String message) {
        super(message);
        this.configName = configName;
    }

    public ConfigInitException(String configName, String message, Throwable cause) {
        super(message, cause);
        this.configName = configName;
    }

    public String getConfigName() {
        return this.configName;
    }
}
