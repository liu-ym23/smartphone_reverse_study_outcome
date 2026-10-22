package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class k80 extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k80 f120581a = null;

    public k80() {
        super("live_message_custom_dispatch_limit_duration", "直播间消息分发限制执行时长(<=0视为不限制)", -1, 16);
    }

    static {
        f120581a = new k80();
    }
}
