package com.bytedance.android.live.broadcastgame.api;

import com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService;
import com.bytedance.android.live.broadcastgame.api.model.i;
import com.bytedance.android.live.broadcastgame.api.model.i0;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayExternalContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;

/* JADX INFO: loaded from: classes45.dex */
public class b implements IGameDataService {
    public b() {
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService
    public m<Boolean> getClearScreen() {
        XplayExternalContext r100 = XplayExternalContext.Companion.getContext();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getClearScreen();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService
    public i getGameOpenInfo() {
        InteractGameContext r100 = InteractGameContext.Companion.getContext();
        if (r100 == null) goto L7;
        n<i> r101 = r100.getGameOpenInfo();
        if (r101 == null) goto L7;
        return r101.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService
    public i0 getOpenPlatformAppInfo() {
        InteractGameContext r100 = InteractGameContext.Companion.getContext();
        if (r100 == null) goto L7;
        n<i0> r101 = r100.getCurrentOpenPlatformAppInfo();
        if (r101 == null) goto L7;
        return r101.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService
    public m<Boolean> getXplayRunning() {
        XplayExternalContext r100 = XplayExternalContext.Companion.getContext();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getXplayRunning();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService
    public boolean isAnchorPlayingGame() {
        return InteractGameContext.Companion.b();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService
    public boolean isGameFullPanelShowing() {
        InteractGameContext r100 = InteractGameContext.Companion.getContext();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.getGameFullPanelIsShowing();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService
    public m<Boolean> isPlayingGame() {
        InteractGameContext r100 = InteractGameContext.Companion.getContext();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.isPlayingGame();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService
    public boolean isRunningPlugin() {
        return InteractGameContext.Companion.g();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService
    public String isRunningPluginName() {
        return InteractGameContext.Companion.i();
    }
}
