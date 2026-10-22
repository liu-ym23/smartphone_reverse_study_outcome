package com.bytedance.android.shopping.new_cart.container;

import com.bytedance.android.shopping.new_cart.slice.widgets.ProductCardContainerView;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<WeakReference<ProductCardContainerView>> f178997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<WeakReference<ProductCardContainerView>, Unit> f178998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<String, Unit> f178999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Boolean, Unit> f179000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<Integer, Unit> f179001e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Integer> f179002f;

    /* JADX WARN: Multi-variable type inference failed */
    public b0(Function0<? extends WeakReference<ProductCardContainerView>> r100, Function1<? super WeakReference<ProductCardContainerView>, Unit> r101, Function1<? super String, Unit> r102, Function1<? super Boolean, Unit> r103, Function1<? super Integer, Unit> r104, Function0<Integer> r105) {
        Intrinsics.checkNotNullParameter(r100, "getExpandProductCard");
        Intrinsics.checkNotNullParameter(r101, "setExpandProductCard");
        Intrinsics.checkNotNullParameter(r102, "setSelectedTabType");
        Intrinsics.checkNotNullParameter(r103, "setHasCounterExpand");
        Intrinsics.checkNotNullParameter(r104, "updateBackToTopButtonBottom");
        Intrinsics.checkNotNullParameter(r105, "getScreenWidth");
        this.f178997a = r100;
        this.f178998b = r101;
        this.f178999c = r102;
        this.f179000d = r103;
        this.f179001e = r104;
        this.f179002f = r105;
    }
}
