package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class e7 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e7 f123290a = null;

    static {
        f123290a = new e7();
    }

    public e7() {
        Boolean r100 = Boolean.TRUE;
        super("live_public_screen_click_send_event", "公屏点击发送埋点开关", r100, r100);
    }
}
