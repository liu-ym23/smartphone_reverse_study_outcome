package com.bytedance.android.livesdk.revenue.service.broadcast;

import com.bytedance.android.live.broadcastgame.api.interactgame.p;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.profit.scoreboard.s0;
import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RevGameServiceImpl f157293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC2406a f157294b;

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.p
    public final void onSuccess() {
        this.f157294b.onSuccess();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.interactgame.p
    public final void onFail(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        if (v.a() == false) goto L5;
        f2.c(r100.getMessage(), 0);
    L5:
        ALogger.e(this.f157293a.f157289a, "loadScoreboardGame fail message: " + r100.getMessage());
        this.f157294b.onFailure(r100);
    }

    public f(RevGameServiceImpl r100, s0.a r101) {
        this.f157293a = r100;
        this.f157294b = r101;
    }
}
