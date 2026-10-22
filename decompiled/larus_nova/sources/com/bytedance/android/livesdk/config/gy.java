package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.GameStickerInvisibleCodes;

/* JADX INFO: loaded from: classes8.dex */
public final class gy extends SSettingKey<GameStickerInvisibleCodes> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gy f120322a = null;

    static {
        f120322a = new gy();
    }

    public gy() {
        super("live_game_sticker_invisible_code", "游戏贴纸隐藏Code配置", new GameStickerInvisibleCodes(), new GameStickerInvisibleCodes());
    }
}
