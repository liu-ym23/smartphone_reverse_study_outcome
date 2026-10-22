package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ei extends SSettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ei f120128a = null;

    static {
        f120128a = new ei();
    }

    public ei() {
        Float r100 = Float.valueOf(15.0f);
        super("live_broadcast_stable_mode_good_fps_threshold", "开播稳定模式性能良好阈值", r100, r100);
    }
}
