package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class o4 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o4 f154127a = null;

    static {
        f154127a = new o4();
    }

    public o4() {
        Boolean r100 = Boolean.TRUE;
        super("live_ban_user_card_enable", "是否开启禁止打开用户个人卡片", r100, r100);
    }
}
