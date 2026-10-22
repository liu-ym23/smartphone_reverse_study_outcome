package com.bytedance.android.livesdk.player.game;

import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext;
import com.bytedance.android.livesdkapi.model.PlayerMainApplyConfig;
import com.bytedance.android.livesdkapi.model.PlayerMultiDisplay;
import com.bytedance.android.livesdkapi.model.PlayerMultiLayoutConfig;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public interface f {
    PlayerMultiDisplay a(MultiRenderSeiFrame r100, com.bytedance.android.live.platformplayer.layout.f r101);

    List<Integer> b();

    PlayerMultiDisplay c(PlayerMultiDisplay r100, com.bytedance.android.live.platformplayer.layout.f r101);

    void d(IGameStickerContext r100, com.bytedance.android.live.platformplayer.layout.f r101, PlayerMultiDisplay r102, PlayerMainApplyConfig r103, PlayerMultiLayoutConfig r104);

    void reset();
}
