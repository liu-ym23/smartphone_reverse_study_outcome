package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class a6 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a6 f65208a = null;

    static {
        f65208a = new a6();
    }

    public a6() {
        Boolean r100 = Boolean.TRUE;
        super("live_fix_timor_enable", "修复iOS主播开播小程序投屏安卓看播画面异常问题", r100, r100);
    }
}
