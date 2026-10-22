package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class x50 extends SSettingKey<j51> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x50 f121578a = null;

    static {
        x50 r100 = new x50();
        f121578a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public x50() {
        super("live_linkmic_dynamic_config", j51.class, "直播多人场景动态化配置", new j51(), new j51());
    }
}
