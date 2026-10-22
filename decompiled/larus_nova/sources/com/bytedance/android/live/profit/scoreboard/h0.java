package com.bytedance.android.live.profit.scoreboard;

import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h0<T1, T2> implements ttc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dv0.n f88886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m1 f88887b;

    public h0(dv0.n r100, com.bytedance.android.live.broadcastgame.opengame.openapi.b1.a r101) {
        this.f88886a = r100;
        this.f88887b = r101;
    }

    @Override // ttc.a
    public final void accept(Object r100, Object r101) {
        com.bytedance.android.live.profit.scoreboard.dto.g r102 = (com.bytedance.android.live.profit.scoreboard.dto.g) r100;
        Throwable r103 = (Throwable) r101;
        if (r103 == null) goto L10;
        dv0.n r104 = this.f88886a;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, LynxError.LYNX_THROWABLE);
        r104.f470131a.onError(r103);
        m1 r105 = this.f88887b;
        int r106 = com.bytedance.android.live.revenue.common.r0.a(r103);
        String r107 = com.bytedance.android.live.revenue.common.q0.a(r103);
        if (r107 != null) goto L7;
        r107 = r103.getMessage();
    L7:
        if (r107 != null) goto L9;
        r107 = "";
    L9:
        r105.onFailed(r106, r107);
        return;
    L10:
        dv0.n r108 = this.f88886a;
        long r109 = r102.getRoundId();
        r108.f470131a.onSuccess(Long.valueOf(r109));
        this.f88887b.onSuccess(String.valueOf(r102.getRoundId()));
    }
}
