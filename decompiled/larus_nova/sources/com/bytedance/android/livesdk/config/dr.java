package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class dr extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dr f120058a = null;

    static {
        f120058a = new dr();
    }

    public dr() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_brightness_change", "是否允许直播视频亮度调节", r100, r100);
    }
}
