package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class mn0 extends SSettingKey<com.bytedance.android.livesdk.performance.v0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final mn0 f120770a = null;

    static {
        f120770a = new mn0();
        yu.f121716a.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public mn0() {
        super("live_rig_hprof_setting", "直播上报hprof到rig配置", new com.bytedance.android.livesdk.performance.v0(), new com.bytedance.android.livesdk.performance.v0(), true);
    }
}
