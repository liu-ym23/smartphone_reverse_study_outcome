package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class b4 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b4 f104233a = null;

    static {
        f104233a = new b4();
    }

    public b4() {
        Boolean r100 = Boolean.TRUE;
        super("live_activity_emoji_auto_test_enable", "活动表情自动化测试开关", r100, r100);
    }
}
