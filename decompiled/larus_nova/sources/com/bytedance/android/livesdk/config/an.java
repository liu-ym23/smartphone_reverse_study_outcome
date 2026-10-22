package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class an extends SSettingKey<com.bytedance.android.livesdk.performance.u> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final an f119805a = null;

    static {
        f119805a = new an();
    }

    public an() {
        super("live_degrade_threshold_setting", "性能降级阈值配置", new com.bytedance.android.livesdk.performance.u(), new com.bytedance.android.livesdk.performance.u());
    }
}
