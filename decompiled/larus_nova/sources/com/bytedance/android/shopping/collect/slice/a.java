package com.bytedance.android.shopping.collect.slice;

import com.bytedance.android.shopping.collect.slice.widgets.ProductCardContainerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<ProductCardContainerView> f172277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<ProductCardContainerView, Unit> f172278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<ProductCardContainerView> f172279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<ProductCardContainerView, Unit> f172280d;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<ProductCardContainerView> r100, Function1<? super ProductCardContainerView, Unit> r101, Function0<ProductCardContainerView> r102, Function1<? super ProductCardContainerView, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "getExpandProductCard");
        Intrinsics.checkNotNullParameter(r101, "setExpandProductCard");
        Intrinsics.checkNotNullParameter(r102, "getFirstTouchProductCard");
        Intrinsics.checkNotNullParameter(r103, "setFirstTouchProductCard");
        this.f172277a = r100;
        this.f172278b = r101;
        this.f172279c = r102;
        this.f172280d = r103;
    }
}
