package com.bytedance.android.ec.window.base.shop;

import androidx.customview.widget.ViewDragHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class WindowTabKitBottomSheetBehavior$onInterceptTouchEvent$b$1 extends MutablePropertyReference0Impl {
    public WindowTabKitBottomSheetBehavior$onInterceptTouchEvent$b$1(WindowTabKitBottomSheetBehavior r100) {
        super(r100, WindowTabKitBottomSheetBehavior.class, "dragHelper", "getDragHelper()Landroidx/customview/widget/ViewDragHelper;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return WindowTabKitBottomSheetBehavior.a((WindowTabKitBottomSheetBehavior) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        ViewDragHelper r101 = (ViewDragHelper) r100;
        ((WindowTabKitBottomSheetBehavior) this.receiver).f49610p = r101;
    }
}
