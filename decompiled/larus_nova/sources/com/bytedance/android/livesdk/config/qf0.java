package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class qf0 extends SSettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qf0 f121051a = null;

    static {
        f121051a = new qf0();
    }

    public qf0() {
        Float r100 = Float.valueOf(0.19f);
        super("live_pc_anchor_interact_video_margin_top", "PC伴侣主播连麦横屏流VideoView顶部占画幅比例", r100, r100);
    }
}
