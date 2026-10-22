package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class jn extends SSettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jn f120538a = null;

    static {
        f120538a = new jn();
    }

    public jn() {
        Float r100 = Float.valueOf(0.3f);
        super("live_digg_frequence", "点赞动画丢弃概率，用来控制密度，0～1.0", r100, r100);
    }
}
