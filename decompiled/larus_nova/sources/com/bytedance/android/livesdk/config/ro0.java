package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ro0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ro0 f121147a = null;

    static {
        f121147a = new ro0();
    }

    public ro0() {
        Boolean r100 = Boolean.FALSE;
        super("live_room_message_force_http", "直播消息强制使用http", r100, r100);
    }
}
