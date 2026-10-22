package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class pw extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final pw f121011a = null;

    static {
        f121011a = new pw();
    }

    public pw() {
        Boolean r100 = Boolean.TRUE;
        super("live_fix_multi_camera_message_fetch_error", "修复横屏下切竖屏机位不断链的问题", r100, r100);
    }
}
