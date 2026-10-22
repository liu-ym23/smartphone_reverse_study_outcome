package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class xi1 extends SSettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xi1 f121608a = null;

    static {
        f121608a = new xi1();
    }

    public xi1() {
        Float r100 = Float.valueOf(5.5f);
        super("video_camera_effect_score", "摄像头美颜低端机阈值", r100, r100);
    }
}
