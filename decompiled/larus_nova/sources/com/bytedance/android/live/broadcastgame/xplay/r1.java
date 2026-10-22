package com.bytedance.android.live.broadcastgame.xplay;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class r1 extends b7.a {
    public r1() {
    }

    @Override // b7.a, b7.b
    public final boolean onFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        int r102 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.e("XplayUtils", new Object[]{"show lynx dialog failed, errorCode: " + r100 + ", errorMesage: " + r101});
        return super.onFallback(r100, r101);
    }
}
