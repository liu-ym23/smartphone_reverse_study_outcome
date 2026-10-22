package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class kx extends SSettingKey<h31> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kx f120635a = null;

    static {
        kx r100 = new kx();
        f120635a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public kx() {
        super("live_follow_empty_recommend_guide_config", "关注页直播内流刷空时引导看推荐直播", new h31(), new h31());
    }
}
