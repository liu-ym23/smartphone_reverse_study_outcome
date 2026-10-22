package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.LiveRadioGiftCommentWallConfig;

/* JADX INFO: loaded from: classes45.dex */
public final class u1 extends SSettingKey<LiveRadioGiftCommentWallConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u1 f65421a = null;

    static {
        f65421a = new u1();
    }

    public u1() {
        super("live_gift_comment_wall_config", "电台礼物留言上墙配置", new LiveRadioGiftCommentWallConfig(), new LiveRadioGiftCommentWallConfig());
    }
}
