package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class uj extends SSettingKey<ng2.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final uj f121379a = null;

    static {
        uj r100 = new uj();
        f121379a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public uj() {
        super("live_enable_open_topic", "直播支持话题AB", new ng2.b(), new ng2.b());
    }
}
