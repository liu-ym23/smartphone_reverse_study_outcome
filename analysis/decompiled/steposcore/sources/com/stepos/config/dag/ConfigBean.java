package com.stepos.config.dag;

/* loaded from: classes.dex */
public interface ConfigBean {
    String getConfigName();

    default void onInitialized() {
    }

    default void onUnload() {
    }

    default boolean validate() {
        return true;
    }
}
