package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ah extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ah f119789a = null;

    static {
        f119789a = new ah();
    }

    public ah() {
        Boolean r100 = Boolean.TRUE;
        super("live_broadcast_enable_toolbar_dot_message", "直播黄点支持消息下发", r100, r100, false);
    }
}
