package com.bytedance.android.ec.core.imagex;

import com.facebook.imagepipeline.drawable.DrawableFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class SlcImageLoaderHookImpl$checkInitDrawableFactory$1 extends MutablePropertyReference0Impl {
    public SlcImageLoaderHookImpl$checkInitDrawableFactory$1(SlcImageLoaderHookImpl r100) {
        super(r100, SlcImageLoaderHookImpl.class, "defaultDrawableFactory", "getDefaultDrawableFactory()Lcom/facebook/imagepipeline/drawable/DrawableFactory;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        SlcImageLoaderHookImpl r100 = (SlcImageLoaderHookImpl) this.receiver;
        DrawableFactory r101 = SlcImageLoaderHookImpl.f44487a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("defaultDrawableFactory");
    L5:
        return r101;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        SlcImageLoaderHookImpl r101 = (SlcImageLoaderHookImpl) this.receiver;
        SlcImageLoaderHookImpl.f44487a = (DrawableFactory) r100;
    }
}
