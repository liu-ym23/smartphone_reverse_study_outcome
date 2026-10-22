package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class l7 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l7 f146991a = null;

    static {
        f146991a = new l7();
    }

    public l7() {
        Boolean r100 = Boolean.TRUE;
        super("live_public_screen_user_ignore_emoji", "公屏解析User时忽略Emoji", r100, r100);
    }
}
