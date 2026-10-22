package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class t5 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t5 f158508a = null;

    static {
        f158508a = new t5();
    }

    public t5() {
        Boolean r100 = Boolean.TRUE;
        super("live_gift_tray_set_invisible_when_clear_screen", "清屏时礼物托盘设为Invisible", r100, r100);
    }
}
