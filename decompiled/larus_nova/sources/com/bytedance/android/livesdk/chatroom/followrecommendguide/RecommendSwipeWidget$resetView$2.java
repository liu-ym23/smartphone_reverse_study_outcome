package com.bytedance.android.livesdk.chatroom.followrecommendguide;

import com.bytedance.android.live.core.widget.LiveTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class RecommendSwipeWidget$resetView$2 extends MutablePropertyReference0Impl {
    public RecommendSwipeWidget$resetView$2(RecommendSwipeWidget r100) {
        super(r100, RecommendSwipeWidget.class, "dragDownTv", "getDragDownTv()Lcom/bytedance/android/live/core/widget/LiveTextView;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        LiveTextView r100 = ((RecommendSwipeWidget) this.receiver).f106217h;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dragDownTv");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        RecommendSwipeWidget r101 = (RecommendSwipeWidget) this.receiver;
        LiveTextView r102 = (LiveTextView) r100;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f106217h = r102;
    }
}
