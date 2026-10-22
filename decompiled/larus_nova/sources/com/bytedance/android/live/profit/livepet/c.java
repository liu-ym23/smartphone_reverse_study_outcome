package com.bytedance.android.live.profit.livepet;

import com.bytedance.android.scope.l;
import com.bytedance.android.scope.o;
import cy0.f;
import e33.k;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;
import yz0.m;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements o, m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f87818a;

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
        if (qu0.b.f534836c.a().getEnabled() == false) goto L18;
        f r100 = this.f87818a;
        Intrinsics.checkNotNullParameter(r100, "parent");
        ru0.c r101 = new ru0.c(r100);
        Intrinsics.checkNotNullParameter(r101, "scope");
        Object r102 = k.f470908a;
        if (r101.f539244e != r102) goto L8;
        String r103 = "revenueInstance";
    L14:
        if (r103 != null) goto L17;
        l.a(r101);
        return;
    L17:
        throw new UninitializedPropertyAccessException(r103);
    L8:
        if (r101.f539245f != r102) goto L11;
        r103 = "revenueInstanceExt";
        goto L14
    L11:
        if (r101.f539246g != r102) goto L13;
        r103 = "roomInstance";
        goto L14
    L13:
        r103 = null;
        goto L14
    }

    public c(f r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f87818a = r100;
    }
}
