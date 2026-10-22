package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class t80 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t80 f121278a = null;

    static {
        f121278a = new t80();
    }

    public t80() {
        Boolean r100 = Boolean.FALSE;
        super("live_message_start_before_room_enter", "直播消息建连在进房之前", r100, r100);
    }
}
