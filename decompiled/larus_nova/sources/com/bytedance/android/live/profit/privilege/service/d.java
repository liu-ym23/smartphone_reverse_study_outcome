package com.bytedance.android.live.profit.privilege.service;

import com.bytedance.android.scope.l;
import com.bytedance.android.scope.o;
import e33.k;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;
import yz0.m;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements o, m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cy0.f f88455a;

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
        xu0.b r100 = new xu0.b(this.f88455a);
        Intrinsics.checkNotNullParameter(r100, "scope");
        Object r101 = k.f470908a;
        if (r100.f565075e != r101) goto L6;
        String r102 = "revenueInstance";
    L12:
        if (r102 != null) goto L16;
        l.a(r100);
        return;
    L16:
        throw new UninitializedPropertyAccessException(r102);
    L6:
        if (r100.f565076f != r101) goto L9;
        r102 = "revenueInstanceExt";
        goto L12
    L9:
        if (r100.f565077g != r101) goto L11;
        r102 = "roomInstance";
        goto L12
    L11:
        r102 = null;
        goto L12
    }

    public d(cy0.f r100) {
        Intrinsics.checkNotNullParameter(r100, "instScope");
        this.f88455a = r100;
    }
}
