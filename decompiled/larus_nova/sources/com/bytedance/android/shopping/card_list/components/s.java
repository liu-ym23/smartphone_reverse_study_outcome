package com.bytedance.android.shopping.card_list.components;

import com.bytedance.android.shopping.card_list.slice.widgets.ProductCardContainerView;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<WeakReference<ProductCardContainerView>> f171481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<WeakReference<ProductCardContainerView>, Unit> f171482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<String, Unit> f171483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Boolean, Unit> f171484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<Integer, Unit> f171485e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<WeakReference<ProductCardContainerView>> f171486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<WeakReference<ProductCardContainerView>, Unit> f171487g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Integer> f171488h;

    /* JADX WARN: Multi-variable type inference failed */
    public s(Function0<? extends WeakReference<ProductCardContainerView>> r100, Function1<? super WeakReference<ProductCardContainerView>, Unit> r101, Function1<? super String, Unit> r102, Function1<? super Boolean, Unit> r103, Function1<? super Integer, Unit> r104, Function0<? extends WeakReference<ProductCardContainerView>> r105, Function1<? super WeakReference<ProductCardContainerView>, Unit> r106, Function0<Integer> r107) {
        Intrinsics.checkNotNullParameter(r100, "getExpandProductCard");
        Intrinsics.checkNotNullParameter(r101, "setExpandProductCard");
        Intrinsics.checkNotNullParameter(r102, "setSelectedTabType");
        Intrinsics.checkNotNullParameter(r103, "setHasCounterExpand");
        Intrinsics.checkNotNullParameter(r104, "updateBackToTopButtonBottom");
        Intrinsics.checkNotNullParameter(r105, "getFirstTouchProductCard");
        Intrinsics.checkNotNullParameter(r106, "setFirstTouchProductCard");
        Intrinsics.checkNotNullParameter(r107, "getScreenWidth");
        this.f171481a = r100;
        this.f171482b = r101;
        this.f171483c = r102;
        this.f171484d = r103;
        this.f171485e = r104;
        this.f171486f = r105;
        this.f171487g = r106;
        this.f171488h = r107;
    }
}
