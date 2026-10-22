package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class uh1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final uh1 f121375a = null;

    static {
        f121375a = new uh1();
    }

    public uh1() {
        Boolean r100 = Boolean.TRUE;
        super("talk_room_rtc_sei_enable", "聊天室开启非关键帧SEI", r100, r100);
    }
}
