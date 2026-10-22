package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class tk extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final tk f121306a = null;

    static {
        f121306a = new tk();
    }

    public tk() {
        Boolean r100 = Boolean.TRUE;
        super("live_clean_room_after_enter_enable", "是否支持进房完成后清屏", r100, r100);
    }
}
