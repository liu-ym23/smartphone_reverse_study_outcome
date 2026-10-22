package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class u50 extends SSettingKey<g51> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u50 f121347a = null;

    static {
        u50 r100 = new u50();
        f121347a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public u50() {
        super("live_light_feedback_config_v2", "满意度轻交互V2配置", new g51(), new g51());
    }
}
