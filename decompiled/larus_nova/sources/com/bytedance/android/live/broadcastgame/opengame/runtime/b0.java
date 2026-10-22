package com.bytedance.android.live.broadcastgame.opengame.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class b0 implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.opengame.panel.h f60822a;

    public b0() {
    }

    public abstract Function0<com.bytedance.android.live.broadcastgame.opengame.panel.h> b();

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.l
    public final void q0() {
        int r100 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("SyncCreatePanelFactory", new Object[]{"create panel"});
        this.f60822a = b().invoke();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.l
    public final void r0(Function0<Unit> r100, Function1<? super com.bytedance.android.live.broadcastgame.opengame.panel.h, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        com.bytedance.android.live.broadcastgame.opengame.panel.h r102 = this.f60822a;
        if (r102 == null) goto L6;
        Unit r103 = r101.invoke(r102);
        return;
    }
}
