package com.bytedance.android.livesdk.player.game.layout;

import com.bytedance.android.livesdk.player.game.MultiRenderSeiFrame;
import com.bytedance.android.livesdk.player.game.f;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext;
import com.bytedance.android.livesdkapi.model.LiveGameUniversalLayoutConfig;
import com.bytedance.android.livesdkapi.model.PlayerMainApplyConfig;
import com.bytedance.android.livesdkapi.model.PlayerMultiDisplay;
import com.bytedance.android.livesdkapi.model.PlayerMultiLayoutConfig;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class GameMultiRenderLayout implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f155397a;

    @Override // com.bytedance.android.livesdk.player.game.f
    public final void reset() {
    }

    @Override // com.bytedance.android.livesdk.player.game.f
    public final List<Integer> b() {
        return ((LiveGameUniversalLayoutConfig) this.f155397a.getValue()).getMultiRenderLegalId();
    }

    public GameMultiRenderLayout() {
        this.f155397a = LazyKt.lazy(GameMultiRenderLayout$config$2.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.player.game.f
    public final PlayerMultiDisplay a(MultiRenderSeiFrame r100, com.bytedance.android.live.platformplayer.layout.f r101) {
        Intrinsics.checkNotNullParameter(r100, "seiFrame");
        Intrinsics.checkNotNullParameter(r101, "layoutContext");
        PlayerMultiDisplay r102 = r100.c(r101.f85613d);
        if (r101.f85613d == false) goto L11;
        if (r102 != null) goto L6;
        return r102;
    L6:
        if (r100.d() != null) goto L8;
        return r102;
    L8:
        if ((r102.getHeight() / r102.getWidth()) > ((r101.f85620k / r101.f85619j) * ((LiveGameUniversalLayoutConfig) this.f155397a.getValue()).getMultiStyleThreshold())) goto L10;
        return r102;
    L10:
        return r100.d();
    L11:
        return r102;
    }

    @Override // com.bytedance.android.livesdk.player.game.f
    public final PlayerMultiDisplay c(PlayerMultiDisplay r110, com.bytedance.android.live.platformplayer.layout.f r111) {
        Intrinsics.checkNotNullParameter(r110, "display");
        Intrinsics.checkNotNullParameter(r111, "layoutContext");
        if (r111.f85613d == true) goto L5;
        return r110;
    L5:
        if (r110.isLandscape() == false) goto L8;
        return PlayerMultiDisplay.copy$default(r110, 0, 0, 0, 0, 2, null, true, 47, null);
    L8:
        return PlayerMultiDisplay.copy$default(r110, 0, 0, 0, 0, 0, null, true, 63, null);
    }

    @Override // com.bytedance.android.livesdk.player.game.f
    public final void d(IGameStickerContext r100, com.bytedance.android.live.platformplayer.layout.f r101, PlayerMultiDisplay r102, PlayerMainApplyConfig r103, PlayerMultiLayoutConfig r104) {
        Intrinsics.checkNotNullParameter(r101, "layoutContext");
        Intrinsics.checkNotNullParameter(r102, "display");
        Intrinsics.checkNotNullParameter(r104, "layoutConfig");
        Intrinsics.checkNotNullParameter(r101, "layoutContext");
        Intrinsics.checkNotNullParameter(r102, "display");
        Intrinsics.checkNotNullParameter(r104, "layoutConfig");
    }
}
