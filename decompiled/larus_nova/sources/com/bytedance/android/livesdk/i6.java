package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class i6 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i6 f132643a = null;

    static {
        f132643a = new i6();
    }

    public i6() {
        Boolean r100 = Boolean.TRUE;
        super("live_media_spilt_mode_enable", "媒体横屏是否支持分屏", r100, r100, true);
    }
}
