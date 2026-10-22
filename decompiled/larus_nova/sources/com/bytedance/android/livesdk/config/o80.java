package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class o80 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o80 f120884a = null;

    static {
        f120884a = new o80();
    }

    public o80() {
        Boolean r100 = Boolean.FALSE;
        super("live_message_manager_dispatch_priority_chat", "MessageManager支持优先分发Chat消息", r100, r100);
    }
}
