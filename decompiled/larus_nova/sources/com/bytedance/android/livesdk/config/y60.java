package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class y60 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y60 f121659a = null;

    static {
        f121659a = new y60();
    }

    public y60() {
        Boolean r100 = Boolean.TRUE;
        super(LiveInitSettingKeys.LIVE_LITE_ENABLE_PLUGIN_ENV_LOAD, "抖音极速版是否开启插件环境加载动态库能力", r100, r100);
    }
}
