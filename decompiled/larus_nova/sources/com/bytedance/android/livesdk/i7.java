package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class i7 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i7 f132644a = null;

    static {
        f132644a = new i7();
    }

    public i7() {
        Boolean r100 = Boolean.FALSE;
        super("live_public_screen_personalized_log_enable", "公屏区个性化分发容器日志开关", r100, r100);
    }
}
