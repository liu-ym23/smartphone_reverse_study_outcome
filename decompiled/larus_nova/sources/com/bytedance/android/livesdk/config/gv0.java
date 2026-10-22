package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class gv0 extends SSettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gv0 f120317a = null;

    static {
        f120317a = new gv0();
    }

    public gv0() {
        Float r100 = Float.valueOf(0.24f);
        super("live_top_gradient_layer_alpha", "看播端竖屏上蒙层透明度", r100, r100);
    }
}
