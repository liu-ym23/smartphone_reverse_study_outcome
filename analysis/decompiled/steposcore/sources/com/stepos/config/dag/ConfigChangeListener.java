package com.stepos.config.dag;

/* loaded from: classes.dex */
public interface ConfigChangeListener {
    void onConfigFailed(String str, Throwable th);

    void onConfigLoaded(String str, ConfigBean configBean);

    void onConfigReloaded(String str, ConfigBean configBean, ConfigBean configBean2);
}
