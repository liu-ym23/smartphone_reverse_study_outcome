package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class kn extends SSettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kn f120615a = null;

    static {
        f120615a = new kn();
    }

    public kn() {
        Float r100 = Float.valueOf(0.4f);
        super("live_digg_frequence_all", "点赞动画丢弃概率，用来控制密度（全局），0～1.0", r100, r100);
    }
}
