package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ck extends SSettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ck f119959a = null;

    static {
        f119959a = new ck();
    }

    public ck() {
        Float r100 = Float.valueOf(550.0f);
        super("live_chat_channel_config_message_scroll_speed", "好友频道配置-消息列表滚动速度", r100, r100);
    }
}
