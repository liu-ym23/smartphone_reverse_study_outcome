package com.bytedance.android.live.profit.format;

import com.bytedance.android.scope.l;
import com.bytedance.android.scope.o;
import e33.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements o, dy0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f87604a;

    public b() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        cy0.e.f465759a.getClass();
        f r100 = new f(cy0.e.a.f465760a);
        Intrinsics.checkNotNullParameter(r100, "scope");
        Object r101 = k.f470908a;
        l.a(r100);
        Unit r102 = Unit.INSTANCE;
        this.f87604a = r100;
    }
}
