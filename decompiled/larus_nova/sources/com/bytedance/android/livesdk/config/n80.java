package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class n80 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n80 f120812a = null;

    static {
        f120812a = new n80();
    }

    public n80() {
        super("live_message_enable_anchor_switch", "是否开启主播端消息拆分", Boolean.FALSE, Boolean.TRUE);
    }
}
