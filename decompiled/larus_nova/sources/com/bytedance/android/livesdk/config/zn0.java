package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class zn0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zn0 f121779a = null;

    static {
        f121779a = new zn0();
    }

    public zn0() {
        Boolean r100 = Boolean.TRUE;
        super("live_room_channel_ws_message_push_enable", "房间频道消息是否支持长连接", r100, r100);
    }
}
