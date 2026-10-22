package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.GameStickerSetting;

/* JADX INFO: loaded from: classes8.dex */
public final class iy extends SSettingKey<GameStickerSetting> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final iy f120487a = null;

    static {
        f120487a = new iy();
    }

    public iy() {
        super("live_game_sticker_setting", "游戏贴纸AB配置", new GameStickerSetting(), new GameStickerSetting());
    }
}
