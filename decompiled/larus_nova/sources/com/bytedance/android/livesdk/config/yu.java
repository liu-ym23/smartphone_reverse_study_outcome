package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class yu extends SSettingKey<com.bytedance.android.livesdk.performance.j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final yu f121716a = null;

    static {
        yu r100 = new yu();
        f121716a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public yu() {
        super("live_eris_setting", "直播eris监控的设置", new com.bytedance.android.livesdk.performance.j(), new com.bytedance.android.livesdk.performance.j(), true);
    }
}
