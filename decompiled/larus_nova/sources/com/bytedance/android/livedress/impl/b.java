package com.bytedance.android.livedress.impl;

import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements com.bytedance.android.scope.o, yz0.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cy0.f f102889a;

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
        u r100 = new u(this.f102889a);
        Intrinsics.checkNotNullParameter(r100, "scope");
        Object r101 = e33.k.f470908a;
        if (r100.f102920e != r101) goto L6;
        String r102 = "revenueInstance";
    L12:
        if (r102 != null) goto L16;
        com.bytedance.android.scope.l.a(r100);
        return;
    L16:
        throw new UninitializedPropertyAccessException(r102);
    L6:
        if (r100.f102921f != r101) goto L9;
        r102 = "revenueInstanceExt";
        goto L12
    L9:
        if (r100.f102922g != r101) goto L11;
        r102 = "roomInstance";
        goto L12
    L11:
        r102 = null;
        goto L12
    }

    public b(cy0.f r100) {
        Intrinsics.checkNotNullParameter(r100, "instScope");
        this.f102889a = r100;
    }
}
