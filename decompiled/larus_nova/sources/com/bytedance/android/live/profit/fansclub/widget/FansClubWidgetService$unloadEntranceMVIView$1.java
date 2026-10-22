package com.bytedance.android.live.profit.fansclub.widget;

import com.bytedance.android.anya.BaseMVIComposableView;
import eu0.h;
import eu0.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class FansClubWidgetService$unloadEntranceMVIView$1 extends MutablePropertyReference0Impl {
    public FansClubWidgetService$unloadEntranceMVIView$1(a r100) {
        super(r100, a.class, "entranceView", "getEntranceView()Lcom/bytedance/android/anya/BaseMVIComposableView;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        BaseMVIComposableView<j, h> r100 = ((a) this.receiver).f87397b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("entranceView");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        BaseMVIComposableView<j, h> r101 = (BaseMVIComposableView) r100;
        ((a) this.receiver).f87397b = r101;
    }
}
