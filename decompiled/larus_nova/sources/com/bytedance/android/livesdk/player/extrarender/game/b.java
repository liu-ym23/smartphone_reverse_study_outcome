package com.bytedance.android.livesdk.player.extrarender.game;

import android.view.View;
import com.bytedance.android.livesdkapi.model.PlayerExtraRenderLayoutConfig;
import com.bytedance.android.livesdkapi.model.PlayerMainApplyConfig;
import com.bytedance.android.livesdkapi.model.PlayerMainRenderLayoutConfig;

/* JADX INFO: loaded from: classes11.dex */
public interface b {
    PlayerMainApplyConfig calculateMainRenderSize(PlayerMainRenderLayoutConfig r100);

    PlayerMainApplyConfig d(PlayerMainRenderLayoutConfig r100);

    void updateExtraRenderBackground(View r100);

    void updateExtraRenderLayoutConfig(PlayerMainRenderLayoutConfig r100, PlayerExtraRenderLayoutConfig r101);
}
