package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class tg extends SSettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final tg f121296a = null;

    static {
        f121296a = new tg();
    }

    public tg() {
        Float r100 = Float.valueOf(0.3f);
        super("live_bottom_gradient_layer_alpha", "看播端竖屏下蒙层透明度", r100, r100);
    }
}
