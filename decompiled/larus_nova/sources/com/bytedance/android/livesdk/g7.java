package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.model.com.bytedance.android.livesdk.model.LiveFirstMessageOptConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class g7 extends SettingKey<LiveFirstMessageOptConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g7 f125384a = null;

    static {
        f125384a = new g7();
    }

    public g7() {
        super("live_public_screen_first_message_show_opt_for_android", "公屏区首屏消息优化开关", new LiveFirstMessageOptConfig(), new LiveFirstMessageOptConfig());
    }
}
