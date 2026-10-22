package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class vy extends SSettingKey<LiveGiftConsumerRemindConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vy f121486a = null;

    static {
        f121486a = new vy();
    }

    public vy() {
        super("live_gift_consume_remind_config", "是否显示礼物消费提醒入口", new LiveGiftConsumerRemindConfig(false, 0, null, 7, null), new LiveGiftConsumerRemindConfig(false, 0, null, 7, null));
    }
}
