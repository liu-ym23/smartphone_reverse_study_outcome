package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.DislikeConfig;

/* JADX INFO: loaded from: classes45.dex */
public final class k2 extends SSettingKey<DislikeConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k2 f65338a = null;

    static {
        f65338a = new k2();
    }

    public k2() {
        super("live_long_press_dislike", "直播间满意度反馈相关配置", new DislikeConfig(), new DislikeConfig());
    }
}
