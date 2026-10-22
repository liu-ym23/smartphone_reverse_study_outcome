package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class t00 extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t00 f121265a = null;

    static {
        f121265a = new t00();
    }

    public t00() {
        super("live_hybrid_send_subscriber_threshold", "Hybrid数据共享方案单位时间内发送订阅阈值", 100, 100);
    }
}
