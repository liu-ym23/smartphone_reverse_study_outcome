package com.bytedance.android.livesdk.revenue.service.broadcast;

import android.content.Context;
import com.bytedance.android.live.profit.scoreboard.s0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Single;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public interface a extends dy0.a {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.revenue.service.broadcast.a$a, reason: collision with other inner class name */
    public interface InterfaceC2406a {
        void onFailure(Throwable r100);

        void onSuccess();
    }

    xp2.g X6(xp2.e r100);

    String getCurrentGameName();

    String getCurrentSonicGameAppId();

    xp2.c getOpenGameClient();

    Map<String, String> getOpenPlatformGameCommonLogMap();

    void hidePlugin(boolean r100);

    Boolean isOpenPlatformGameOpeningLynxPanelInGame();

    Single<Boolean> od(Context r100, DataCenter r101, xp2.b r102);

    void showPlugin(boolean r100);

    void stopGameCastToAudience();

    void v4(Context r100, String r101, s0.a r102);

    xp2.g za(String r100, DataCenter r101);
}
