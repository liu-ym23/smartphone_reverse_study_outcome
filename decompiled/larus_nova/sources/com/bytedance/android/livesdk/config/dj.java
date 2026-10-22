package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class dj extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dj f120037a = null;

    static {
        f120037a = new dj();
    }

    public dj() {
        Boolean r100 = Boolean.TRUE;
        super("live_byte_sync_message_enable", "是否支持ByteSync消息", r100, r100);
    }
}
