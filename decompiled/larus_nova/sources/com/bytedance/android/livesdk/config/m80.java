package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class m80 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m80 f120735a = null;

    static {
        f120735a = new m80();
    }

    public m80() {
        Boolean r100 = Boolean.FALSE;
        super("live_message_dispatch_stop_when_scroll", "上下滑停止消息分发", r100, r100);
    }
}
