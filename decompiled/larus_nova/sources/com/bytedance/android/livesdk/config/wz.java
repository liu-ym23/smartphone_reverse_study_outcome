package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class wz extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wz f121563a = null;

    static {
        f121563a = new wz();
    }

    public wz() {
        Boolean r100 = Boolean.TRUE;
        super("live_hamlet_avatar_v2_enable_rtc_ignore_sei", "hamlet avata二期是否支持丢弃云游SEI(rtc)", r100, r100);
    }
}
