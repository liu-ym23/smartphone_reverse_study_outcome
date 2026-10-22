package com.bytedance.android.live.broadcastgame.opengame;

import com.bytedance.android.live.broadcastgame.InteractGameService;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.w;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class r implements a20.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f60745a;

    @Override // a20.a
    public final void onFailed() {
        this.f60745a.onFail();
    }

    public r(InteractGameService.e r100) {
        this.f60745a = r100;
    }

    @Override // a20.a
    public final void a(u r100) {
        Intrinsics.checkNotNullParameter(r100, "gameItem");
        this.f60745a.a(r100);
    }
}
