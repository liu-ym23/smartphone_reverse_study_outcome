package com.bytedance.android.ui.ec.widget.photodraweeview;

import com.bytedance.android.ui.ec.widget.photodraweeview.gestures.DefaultGestureHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class PhotoDraweeView$scaleFactorRetriever$1 extends MutablePropertyReference0Impl {
    public PhotoDraweeView$scaleFactorRetriever$1(PhotoDraweeView r100) {
        super(r100, PhotoDraweeView.class, "defaultGestureHandler", "getDefaultGestureHandler()Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/DefaultGestureHandler;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return PhotoDraweeView.access$getDefaultGestureHandler$p((PhotoDraweeView) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        PhotoDraweeView.access$setDefaultGestureHandler$p((PhotoDraweeView) this.receiver, (DefaultGestureHandler) r100);
    }
}
