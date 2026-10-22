package com.bytedance.android.live.broadcastgame.opengame;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d extends b7.a {
    public d() {
    }

    @Override // b7.a, b7.b
    public final boolean onFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        int r102 = q.f60744a;
        q.e("AudiencePluginManager", new Object[]{"show magic box lynx dialog failed, errorCode: " + r100 + ", errorMesage: " + r101});
        return super.onFallback(r100, r101);
    }
}
