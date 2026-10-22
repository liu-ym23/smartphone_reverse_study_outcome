package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class lv0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final lv0 f120711a = null;

    static {
        f120711a = new lv0();
    }

    public lv0() {
        Boolean r100 = Boolean.TRUE;
        super("live_turn_on_opt_enable", "开启RTC超时leave channel", r100, r100);
    }
}
