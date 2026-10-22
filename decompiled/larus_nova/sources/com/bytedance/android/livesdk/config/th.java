package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class th extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final th f121299a = null;

    static {
        f121299a = new th();
    }

    public th() {
        Boolean r100 = Boolean.TRUE;
        super("live_broadcast_red_packet_enable", "主播群红包", r100, r100, true);
    }
}
