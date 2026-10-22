package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import android.graphics.Rect;
import android.view.View;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements Function1<View, com.bytedance.android.shopping.prepurchase.arch.exposure.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f182097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<View> f182098b;

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function0<? extends View> r100) {
        Intrinsics.checkNotNullParameter(r100, "topSliceView");
        this.f182098b = r100;
        this.f182097a = new Rect();
    }

    @Override // kotlin.jvm.functions.Function1
    public final com.bytedance.android.shopping.prepurchase.arch.exposure.c invoke(View r100) {
        View r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "view");
        r101.getGlobalVisibleRect(this.f182097a);
        View r102 = this.f182098b.invoke();
        if (r102 != null) goto L5;
        int r103 = r101.getHeight() * r101.getWidth();
        Rect r104 = this.f182097a;
        return new com.bytedance.android.shopping.prepurchase.arch.exposure.c(r103, Math.max((r104.bottom - r104.top) * (r104.right - r104.left), 0));
    L5:
        int r105 = r102.getHeight();
        if (this.f182097a.top <= r105) goto L8;
    L15:
        int r106 = r101.getHeight() * r101.getWidth();
        Rect r107 = this.f182097a;
        return new com.bytedance.android.shopping.prepurchase.arch.exposure.c(r106, Math.max((r107.bottom - r107.top) * (r107.right - r107.left), 0));
    L8:
        if (r102.getVisibility() != 0) goto L10;
        boolean r108 = true;
    L11:
        if (r108 != true) goto L15;
        if (r102.getAlpha() < com.bytedance.android.ec.core.abtest.d.m()) goto L15;
        int r109 = r101.getHeight() * r101.getWidth();
        Rect r110 = this.f182097a;
        int r111 = r110.bottom;
        int r112 = r110.top;
        return new com.bytedance.android.shopping.prepurchase.arch.exposure.c(r109, Math.max(((r111 - r112) - (r105 - r112)) * (r110.right - r110.left), 0));
    L10:
        r108 = false;
        goto L11
    }
}
