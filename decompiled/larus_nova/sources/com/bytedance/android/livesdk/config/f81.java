package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class f81 extends SSettingKey<z81> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f81 f120182a = null;

    static {
        f81 r100 = new f81();
        f120182a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public f81() {
        super("live_unlogin_scene_guide_config", "未登录用户直播场景引导登录配置", new z81(), new z81());
    }
}
