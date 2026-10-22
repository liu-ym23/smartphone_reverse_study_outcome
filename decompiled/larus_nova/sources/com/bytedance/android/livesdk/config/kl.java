package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class kl extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kl f120611a = null;

    static {
        kl r100 = new kl();
        f120611a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public kl() {
        Boolean r100 = Boolean.FALSE;
        super("live_cold_start_widget_load_opt", "冷启widget加载优化", r100, r100);
    }
}
