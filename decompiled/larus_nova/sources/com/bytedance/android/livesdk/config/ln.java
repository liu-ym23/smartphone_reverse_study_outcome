package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ln extends SSettingKey<ss1.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ln f120694a = null;

    static {
        ln r100 = new ln();
        f120694a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public ln() {
        super("live_digg_anim_opt_config", "点赞动画优化开关", new ss1.c(), new ss1.c());
    }
}
