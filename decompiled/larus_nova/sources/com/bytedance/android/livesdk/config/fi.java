package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class fi extends SSettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fi f120204a = null;

    static {
        f120204a = new fi();
    }

    public fi() {
        Float r100 = Float.valueOf(12.0f);
        super("live_broadcast_stable_mode_poor_fps_threshold", "开播稳定模式性能存在风险阈值", r100, r100);
    }
}
