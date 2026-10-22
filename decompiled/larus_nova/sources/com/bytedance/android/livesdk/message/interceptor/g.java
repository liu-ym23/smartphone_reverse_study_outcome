package com.bytedance.android.livesdk.message.interceptor;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes11.dex */
public final class g extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f153535a = null;

    static {
        f153535a = new g();
    }

    public g() {
        Boolean r100 = Boolean.FALSE;
        super("live_subscribe_emoji_hot_chat_message_enable", "会员表情热评聚合支持", r100, r100);
    }
}
