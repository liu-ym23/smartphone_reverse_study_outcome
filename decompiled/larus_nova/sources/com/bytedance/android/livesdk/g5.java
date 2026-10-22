package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class g5 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g5 f125382a = null;

    static {
        f125382a = new g5();
    }

    public g5() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_common_landscape_publicscreen", "节目横屏是否支持分屏", r100, r100);
    }
}
