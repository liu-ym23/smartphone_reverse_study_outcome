package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class lx0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final lx0 f120715a = null;

    static {
        f120715a = new lx0();
    }

    public lx0() {
        Boolean r100 = Boolean.TRUE;
        super("live_vr_degrade_observer_enable", "是否开启VR降级策略因子监听", r100, r100);
    }
}
