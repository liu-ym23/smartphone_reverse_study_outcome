package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ub0 extends SSettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ub0 f121359a = null;

    static {
        f121359a = new ub0();
    }

    public ub0() {
        Float r100 = Float.valueOf(0.5f);
        super("live_multi_link_seat_space", "默认的麦位间距", r100, r100);
    }
}
