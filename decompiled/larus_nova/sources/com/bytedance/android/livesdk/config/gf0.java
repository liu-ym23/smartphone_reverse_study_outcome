package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class gf0 extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gf0 f120283a = null;

    public gf0() {
        super("live_paid_live_message_config", "付费直播消息通道控制设置 0-对照只依赖ping接口,1-只依赖消息，2-消息和ping接口共存", 2, 2);
    }

    static {
        f120283a = new gf0();
    }
}
