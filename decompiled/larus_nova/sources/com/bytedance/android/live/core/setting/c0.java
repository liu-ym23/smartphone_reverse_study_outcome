package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class c0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f65268a = null;

    static {
        f65268a = new c0();
    }

    public c0() {
        Boolean r100 = Boolean.FALSE;
        super("live_close_widget_leak_opt", "RoomClose泄漏修改", r100, r100, false);
    }
}
