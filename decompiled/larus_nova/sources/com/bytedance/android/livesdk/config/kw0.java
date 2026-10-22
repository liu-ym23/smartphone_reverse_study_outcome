package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class kw0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kw0 f120634a = null;

    static {
        f120634a = new kw0();
    }

    public kw0() {
        Boolean r100 = Boolean.TRUE;
        super("live_value_animator_scale_enable", "重置ValueAnimator中的DurationScale", r100, r100);
    }
}
