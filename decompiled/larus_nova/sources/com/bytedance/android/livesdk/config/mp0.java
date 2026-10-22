package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class mp0 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final mp0 f120774a = null;

    static {
        f120774a = new mp0();
    }

    public mp0() {
        Boolean r100 = Boolean.FALSE;
        super("live_rx_compat_share_opt", "RxCompat的share不走反射", r100, r100);
    }
}
