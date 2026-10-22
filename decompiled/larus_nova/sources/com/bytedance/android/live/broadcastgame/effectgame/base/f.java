package com.bytedance.android.live.broadcastgame.effectgame.base;

import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class f<T1, T2> implements ttc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f59624a;

    public f(g r100) {
        this.f59624a = r100;
    }

    @Override // ttc.a
    public final void accept(Object r100, Object r101) {
        Throwable r102 = (Throwable) r101;
        c.b r103 = this.f59624a.f59625a;
        r103.onSuccess((List) r100);
    }
}
