package com.bytedance.android.live.broadcastgame.openplatform.behavior;

import com.bytedance.android.live.broadcastgame.opengame.q;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c extends b7.a {
    public c() {
    }

    @Override // b7.a, b7.b
    public final boolean onFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        int r102 = q.f60744a;
        q.e("ToolbarInteractPlayControlBehavior", new Object[]{"show rev link lynx dialog failed, errorCode: " + r100 + ", errorMesage: " + r101});
        return super.onFallback(r100, r101);
    }
}
