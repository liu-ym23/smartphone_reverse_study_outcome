package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class m50 extends SSettingKey<d51> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m50 f120732a = null;

    static {
        m50 r100 = new m50();
        f120732a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public m50() {
        super("live_landscape_opt_config", "横屏体验框架优化配置", new d51(), new d51());
    }
}
