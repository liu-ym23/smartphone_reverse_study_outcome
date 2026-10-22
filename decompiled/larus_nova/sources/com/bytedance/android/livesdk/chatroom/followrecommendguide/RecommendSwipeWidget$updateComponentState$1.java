package com.bytedance.android.livesdk.chatroom.followrecommendguide;

import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class RecommendSwipeWidget$updateComponentState$1 extends MutablePropertyReference0Impl {
    public RecommendSwipeWidget$updateComponentState$1(RecommendSwipeWidget r100) {
        super(r100, RecommendSwipeWidget.class, "linearTop", "getLinearTop()Landroid/widget/LinearLayout;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        LinearLayout r100 = ((RecommendSwipeWidget) this.receiver).f106213d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linearTop");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        RecommendSwipeWidget r101 = (RecommendSwipeWidget) this.receiver;
        LinearLayout r102 = (LinearLayout) r100;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f106213d = r102;
    }
}
