package com.bytedance.android.livesdk.interactivity.publicscreen.preview;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class PhotoDraweeView$scaleFactorRetriever$1 extends MutablePropertyReference0Impl {
    public PhotoDraweeView$scaleFactorRetriever$1(PhotoDraweeView r100) {
        super(r100, PhotoDraweeView.class, "defaultGestureHandler", "getDefaultGestureHandler()Lcom/bytedance/android/livesdk/interactivity/publicscreen/preview/gestures/DefaultGestureHandler;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        ba2.a r100 = ((PhotoDraweeView) this.receiver).f139298g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("defaultGestureHandler");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        ba2.a r101 = (ba2.a) r100;
        ((PhotoDraweeView) this.receiver).f139298g = r101;
    }
}
