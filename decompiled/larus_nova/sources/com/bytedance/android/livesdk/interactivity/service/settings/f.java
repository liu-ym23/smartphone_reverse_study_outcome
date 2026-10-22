package com.bytedance.android.livesdk.interactivity.service.settings;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class f extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f140994a = null;

    static {
        f140994a = new f();
    }

    public f() {
        Boolean r100 = Boolean.TRUE;
        super("live_public_screen_bottom_touch_fix", "直播间公屏底部滑动优化", r100, r100);
    }
}
