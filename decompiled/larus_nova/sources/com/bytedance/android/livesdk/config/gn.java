package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class gn extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gn f120300a = null;

    static {
        f120300a = new gn();
    }

    public gn() {
        super("live_detect_rts_room_delayed_time", "探测RTS房间延迟时间", 0, 0, new String[]{"0:0s"});
    }
}
