package com.bytedance.android.live.broadcastgame.api.interactgame;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/interactgame/IAudienceGameDataService;", "Lcom/bytedance/android/live/broadcastgame/api/interactgame/IGameDataService;", "currentGameId", "", "getCurrentGameId", "()J", "currentGameName", "", "getCurrentGameName", "()Ljava/lang/String;", "livebroadcastgame-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAudienceGameDataService extends IGameDataService {
    long getCurrentGameId();

    String getCurrentGameName();
}
