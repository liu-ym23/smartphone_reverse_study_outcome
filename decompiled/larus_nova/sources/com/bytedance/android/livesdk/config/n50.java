package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class n50 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n50 f120807a = null;

    static {
        f120807a = new n50();
    }

    public n50() {
        Boolean r100 = Boolean.TRUE;
        super("live_landscape_picture_scale_gesture_enabled", "横屏直播间手动放大拉伸能力开关", r100, r100);
    }
}
