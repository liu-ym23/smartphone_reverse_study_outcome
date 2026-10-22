package com.bytedance.android.ec.core.imagex.opt;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECDomainOperateTools$resultUrl$1 extends MutablePropertyReference0Impl {
    public ECDomainOperateTools$resultUrl$1(q r100) {
        super(r100, q.class, "customDomain", "getCustomDomain()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        String r100 = ((q) this.receiver).f44889a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("customDomain");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        String r101 = (String) r100;
        ((q) this.receiver).f44889a = r101;
    }
}
