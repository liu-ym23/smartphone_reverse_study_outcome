package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class sh extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sh f121228a = null;

    static {
        f121228a = new sh();
    }

    public sh() {
        Boolean r100 = Boolean.TRUE;
        super("live_broadcast_red_packet_bug_fix_enable", "主播群红包", r100, r100, true);
    }
}
