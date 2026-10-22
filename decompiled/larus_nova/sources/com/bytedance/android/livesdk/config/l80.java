package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class l80 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l80 f120659a = null;

    static {
        f120659a = new l80();
    }

    public l80() {
        Boolean r100 = Boolean.TRUE;
        super("live_message_dispatch_control_ignore_state", "消息dispatch控制无视消息状态", r100, r100);
    }
}
