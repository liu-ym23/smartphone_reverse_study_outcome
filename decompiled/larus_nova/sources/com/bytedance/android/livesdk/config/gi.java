package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class gi extends SSettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gi f120289a = null;

    static {
        f120289a = new gi();
    }

    public gi() {
        Float r100 = Float.valueOf(13.0f);
        super("live_broadcast_stable_mode_risk_fps_threshold", "开播稳定模式性能存在低风险阈值", r100, r100);
    }
}
