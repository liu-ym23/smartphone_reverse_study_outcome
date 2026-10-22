package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class iz0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final iz0 f120490a = null;

    static {
        f120490a = new iz0();
    }

    public iz0() {
        Boolean r100 = Boolean.TRUE;
        super("live_ws_message_push_enable", "房间消息是否支持长连接", r100, r100);
    }
}
