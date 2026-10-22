package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class di extends SSettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final di f120034a = null;

    static {
        f120034a = new di();
    }

    public di() {
        Float r100 = Float.valueOf(8.0f);
        super("live_broadcast_stable_mode_bad_fps_threshold", "开播稳定模式性能差阈值", r100, r100);
    }
}
