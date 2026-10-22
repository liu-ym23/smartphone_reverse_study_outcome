package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class s30 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s30 f121180a = null;

    static {
        f121180a = new s30();
    }

    public s30() {
        Boolean r100 = Boolean.TRUE;
        super("live_is_xplay_full_screen_size_default_1080p", "xplay全屏沉浸式模式的参数默认1080P", r100, r100, true);
    }
}
