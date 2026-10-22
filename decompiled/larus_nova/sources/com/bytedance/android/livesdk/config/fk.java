package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class fk extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fk f120210a = null;

    static {
        f120210a = new fk();
    }

    public fk() {
        Boolean r100 = Boolean.TRUE;
        super("live_chat_channel_gift_block_fix", "修复聊天频道横屏切竖屏时没有屏蔽礼物特效的问题", r100, r100);
    }
}
