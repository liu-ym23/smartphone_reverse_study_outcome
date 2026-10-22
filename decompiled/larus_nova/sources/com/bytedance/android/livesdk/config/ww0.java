package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ww0 extends SSettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ww0 f121558a = null;

    static {
        f121558a = new ww0();
    }

    public ww0() {
        Float r100 = Float.valueOf(0.25f);
        super("live_video_chorus_public_screen_height_ratio", "视频合唱手机公屏高度比", r100, r100);
    }
}
