package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveSecretChatReplySuffixConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class q7 extends SettingKey<LiveSecretChatReplySuffixConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q7 f156880a = null;

    static {
        f156880a = new q7();
    }

    public q7() {
        super("live_secret_chat_reply_suffix_config", "快捷回复后缀配置项", new LiveSecretChatReplySuffixConfig(), new LiveSecretChatReplySuffixConfig());
    }
}
