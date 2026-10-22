package com.bytedance.android.window.shop.home.module;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECWindowBaseModule$onCreateView$1 extends MutablePropertyReference0Impl {
    public ECWindowBaseModule$onCreateView$1(a r100) {
        super(r100, a.class, "rootView", "getRootView()Landroid/view/View;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return ((a) this.receiver).l();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        a r101 = (a) this.receiver;
        View r102 = (View) r100;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f188233l = r102;
    }
}
