package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class tn0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final tn0 f121313a = null;

    static {
        f121313a = new tn0();
    }

    public tn0() {
        Boolean r100 = Boolean.TRUE;
        super("live_room_battle_enable_rtc_mcu", "跨房厅战使用mcu方案", r100, r100);
    }
}
