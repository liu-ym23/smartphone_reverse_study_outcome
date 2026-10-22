package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class le extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final le f120672a = null;

    static {
        f120672a = new le();
    }

    public le() {
        Boolean r100 = Boolean.FALSE;
        super("live_assets_async_preload_enable", "直播资源预热开关", r100, r100);
    }
}
