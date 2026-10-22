package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class k6 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k6 f65342a = null;

    static {
        f65342a = new k6();
    }

    public k6() {
        Boolean r100 = Boolean.TRUE;
        super("live_widget_callback_leak_fix", "widgetCallback内存泄漏修改", r100, r100);
    }
}
