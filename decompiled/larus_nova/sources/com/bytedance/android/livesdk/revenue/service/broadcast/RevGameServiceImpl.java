package com.bytedance.android.livesdk.revenue.service.broadcast;

import android.content.Context;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.interactgame.j;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.profit.scoreboard.s0;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Single;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class RevGameServiceImpl implements o, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f157289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f157290b;

    @Override // com.bytedance.android.livesdk.revenue.service.broadcast.a
    public final xp2.c getOpenGameClient() {
        return (xp2.c) this.f157290b.getValue();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public static IInteractGameService a() {
        return (IInteractGameService) k.n(IInteractGameService.class);
    }

    public RevGameServiceImpl() {
        this.f157289a = "IRevGameService";
        this.f157290b = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new RevGameServiceImpl$openGameClient$2(this));
    }

    @Override // com.bytedance.android.livesdk.revenue.service.broadcast.a
    public final String getCurrentGameName() {
        return a().getCurrentGameName();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.broadcast.a
    public final String getCurrentSonicGameAppId() {
        return a().getCurrentSonicGameAppId();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.broadcast.a
    public final Map<String, String> getOpenPlatformGameCommonLogMap() {
        return a().getOpenPlatformGameCommonLogMap();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.broadcast.a
    public final Boolean isOpenPlatformGameOpeningLynxPanelInGame() {
        return a().isOpenPlatformGameOpeningLynxPanelInGame();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.broadcast.a
    public final void stopGameCastToAudience() {
        a().stopGameCastToAudience();
        com.bytedance.android.live.broadcastgame.api.xplay.e r100 = a().getXplayGlobalService();
        if (r100 == null) goto L6;
        r100.e("stop game cast to audience");
        return;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.broadcast.a
    public final xp2.g X6(xp2.e r110) {
        Intrinsics.checkNotNullParameter(r110, "$this$toInteractItem");
        int r100 = r110.f564699a;
        String r101 = r110.f564700b;
        String r102 = r110.f564701c;
        py.k r103 = r110.f564702d;
        if ((r103 instanceof ImageModel) == true) goto L6;
        r103 = null;
    L6:
        return new xp2.g(new InteractEntranceCell(r100, r101, r102, (ImageModel) r103, 0, r110.f564703e, 130992).i());
    }

    @Override // com.bytedance.android.livesdk.revenue.service.broadcast.a
    public final void hidePlugin(boolean r100) {
        a().hidePlugin(true);
    }

    @Override // com.bytedance.android.livesdk.revenue.service.broadcast.a
    public final void showPlugin(boolean r100) {
        a().showPlugin(r100);
    }

    @Override // com.bytedance.android.livesdk.revenue.service.broadcast.a
    public final xp2.g za(String r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        u r102 = j.d(r100, r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return new xp2.g(r102);
    }

    @Override // com.bytedance.android.livesdk.revenue.service.broadcast.a
    public final Single<Boolean> od(Context r100, DataCenter r101, xp2.b r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, "gameItem");
        return a().showOpenGameAuthDialog(r100, r101, r102.a());
    }

    @Override // com.bytedance.android.livesdk.revenue.service.broadcast.a
    public final void v4(Context r100, String r101, s0.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "miniAppId");
        Intrinsics.checkNotNullParameter(r102, "callback");
        a().startOpenPlatformSonicPlugin(r100, r101, new f(this, r102));
    }
}
