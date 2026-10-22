package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class q60 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q60 f121032a = null;

    static {
        f121032a = new q60();
    }

    public q60() {
        Boolean r100 = Boolean.TRUE;
        super("live_link_message_decode_error_log", "LinkMessage解析失败Trace上报", r100, r100);
    }
}
