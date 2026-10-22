package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class h7 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h7 f120344a = null;

    static {
        f120344a = new h7();
    }

    public h7() {
        Boolean r100 = Boolean.FALSE;
        super("host_ws_message_debug_enable", "消息宿主长连调试开关", r100, r100);
    }
}
