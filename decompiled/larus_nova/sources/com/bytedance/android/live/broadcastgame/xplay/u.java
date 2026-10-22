package com.bytedance.android.live.broadcastgame.xplay;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f62475c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f62476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.broadcastgame.api.xplay.p f62477b;

    public static final class a {
    }

    static {
    }

    public u(com.bytedance.android.live.broadcastgame.api.xplay.p r100) {
        Intrinsics.checkNotNullParameter(r100, "newEnv");
        this.f62477b = r100;
        this.f62476a = new e0();
    }

    public final void a(boolean r100) {
        Object r101 = null;
        if (r100 == false) goto L10;
        t1 r102 = this.f62476a.f62068b;
        if (r102 == null) goto L7;
        r101 = com.bytedance.android.scope.m.f163449e.d(r102, IXplayCoreService.class);
    L7:
        IXplayCoreService r103 = (IXplayCoreService) r101;
        if (r103 == null) goto L17;
        r103.pauseGame();
        return;
    L17:
        return;
    L10:
        t1 r104 = this.f62476a.f62068b;
        if (r104 == null) goto L13;
        r101 = com.bytedance.android.scope.m.f163449e.d(r104, IXplayCoreService.class);
    L13:
        IXplayCoreService r105 = (IXplayCoreService) r101;
        if (r105 == null) goto L19;
        r105.resumeGame();
        return;
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "stopReason");
        t1 r101 = this.f62476a.f62068b;
        if (r101 == null) goto L5;
        Object r102 = com.bytedance.android.scope.m.f163449e.d(r101, k20.b.class);
    L6:
        k20.b r103 = (k20.b) r102;
        if (r103 == null) goto L10;
        r103.a(r100);
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
