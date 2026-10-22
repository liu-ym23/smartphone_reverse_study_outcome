package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class h6 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h6 f65317a = null;

    static {
        f65317a = new h6();
    }

    public h6() {
        Boolean r100 = Boolean.TRUE;
        super("live_vs_fix_multi_tab_pad_landscape_hide", "pad横屏多tab不消失", r100, r100);
    }
}
