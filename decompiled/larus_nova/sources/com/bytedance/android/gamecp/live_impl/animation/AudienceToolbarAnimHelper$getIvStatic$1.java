package com.bytedance.android.gamecp.live_impl.animation;

import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class AudienceToolbarAnimHelper$getIvStatic$1 extends MutablePropertyReference0Impl {
    public AudienceToolbarAnimHelper$getIvStatic$1(b r100) {
        super(r100, b.class, "mIvStatic", "getMIvStatic()Landroid/widget/ImageView;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        ImageView r100 = ((b) this.receiver).f57787a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mIvStatic");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        ImageView r101 = (ImageView) r100;
        ((b) this.receiver).f57787a = r101;
    }
}
