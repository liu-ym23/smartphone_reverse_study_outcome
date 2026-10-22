package com.bytedance.android.shopping.store.tabkit.container;

import androidx.customview.widget.ViewDragHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class TabKitBottomSheetBehavior$onInterceptTouchEvent$b$1 extends MutablePropertyReference0Impl {
    public TabKitBottomSheetBehavior$onInterceptTouchEvent$b$1(TabKitBottomSheetBehavior r100) {
        super(r100, TabKitBottomSheetBehavior.class, "dragHelper", "getDragHelper()Landroidx/customview/widget/ViewDragHelper;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return TabKitBottomSheetBehavior.a((TabKitBottomSheetBehavior) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        ViewDragHelper r101 = (ViewDragHelper) r100;
        ((TabKitBottomSheetBehavior) this.receiver).f186677t = r101;
    }
}
