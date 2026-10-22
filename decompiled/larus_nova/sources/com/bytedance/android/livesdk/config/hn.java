package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class hn extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final hn f120390a = null;

    static {
        f120390a = new hn();
    }

    public hn() {
        super("live_detect_rts_room_max_retry_count", "探测RTS房间最大重试次数", 0, 0, new String[]{""});
    }
}
