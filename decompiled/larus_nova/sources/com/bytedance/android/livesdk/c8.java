package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class c8 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c8 f104417a = null;

    static {
        f104417a = new c8();
    }

    public c8() {
        Boolean r100 = Boolean.FALSE;
        super("live_open_user_card_need_login", "直播未登陆用户打开资料卡时引导到登录", r100, r100);
    }
}
