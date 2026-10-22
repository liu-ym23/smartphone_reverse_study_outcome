package com.bytedance.android.ec.adapter.impl.converter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class SingleTonConverter$convert$1 extends MutablePropertyReference0Impl {
    public SingleTonConverter$convert$1(o r100) {
        super(r100, o.class, "singleTon", "getSingleTon()Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        Target r100 = ((o) this.receiver).f42791b;
        if (r100 != 0) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("singleTon");
    L5:
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        ((o) this.receiver).f42791b = r100;
    }
}
