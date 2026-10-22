package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class s80 extends SSettingKey<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s80 f121189a = null;

    static {
        f121189a = new s80();
    }

    public s80() {
        super("live_message_smoothly_dispatch_interval", "消息分发时延", 200L, 200L);
    }
}
