package com.bytedance.android.live.broadcastgame.api.interactgame;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.broadcastgame.api.model.i0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0002H&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH&R\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/interactgame/IGameDataService;", "Lcom/bytedance/android/live/base/IService;", "", "isRunningPlugin", "isAnchorPlayingGame", "", "isRunningPluginName", "isGameFullPanelShowing", "Lcom/bytedance/android/live/broadcastgame/api/model/i;", "getGameOpenInfo", "Lcom/bytedance/android/live/broadcastgame/api/model/i0;", "getOpenPlatformAppInfo", "Lcom/bytedance/live/datacontext/m;", "getXplayRunning", "()Lcom/bytedance/live/datacontext/m;", "xplayRunning", "getClearScreen", "clearScreen", "isPlayingGame", "livebroadcastgame-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGameDataService extends IService {
    com.bytedance.live.datacontext.m<Boolean> getClearScreen();

    com.bytedance.android.live.broadcastgame.api.model.i getGameOpenInfo();

    i0 getOpenPlatformAppInfo();

    com.bytedance.live.datacontext.m<Boolean> getXplayRunning();

    boolean isAnchorPlayingGame();

    boolean isGameFullPanelShowing();

    com.bytedance.live.datacontext.m<Boolean> isPlayingGame();

    boolean isRunningPlugin();

    String isRunningPluginName();
}
