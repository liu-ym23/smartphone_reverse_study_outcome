package com.bytedance.android.live.profit.taskcenter;

import com.bytedance.android.scope.o;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;
import yz0.m;

/* JADX INFO: loaded from: classes47.dex */
public final class h implements o, m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cy0.f f89027a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // yz0.m
    public final void onViewReady() {
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
    }

    @Override // yz0.m
    public final void x() {
    }

    @Override // yz0.m
    public final void i() {
        l r100 = new l(this.f89027a);
        Intrinsics.checkNotNullParameter(r100, "scope");
        Object r101 = e33.k.f470908a;
        if (r100.f89038e != r101) goto L6;
        String r102 = "revenueInstance";
    L12:
        if (r102 != null) goto L16;
        com.bytedance.android.scope.l.a(r100);
        return;
    L16:
        throw new UninitializedPropertyAccessException(r102);
    L6:
        if (r100.f89039f != r101) goto L9;
        r102 = "revenueInstanceExt";
        goto L12
    L9:
        if (r100.f89040g != r101) goto L11;
        r102 = "roomInstance";
        goto L12
    L11:
        r102 = null;
        goto L12
    }

    public h(cy0.f r100) {
        Intrinsics.checkNotNullParameter(r100, "instScope");
        this.f89027a = r100;
    }
}
