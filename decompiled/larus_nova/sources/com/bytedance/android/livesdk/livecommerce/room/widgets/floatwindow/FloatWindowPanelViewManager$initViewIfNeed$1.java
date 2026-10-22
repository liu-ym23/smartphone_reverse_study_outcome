package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class FloatWindowPanelViewManager$initViewIfNeed$1 extends MutablePropertyReference0Impl {
    public FloatWindowPanelViewManager$initViewIfNeed$1(a r100) {
        super(r100, a.class, "rootView", "getRootView()Landroid/view/View;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        View r100 = ((a) this.receiver).f152093a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        View r101 = (View) r100;
        ((a) this.receiver).f152093a = r101;
    }
}
