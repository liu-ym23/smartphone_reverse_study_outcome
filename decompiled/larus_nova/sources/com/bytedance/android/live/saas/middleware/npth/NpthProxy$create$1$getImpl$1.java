package com.bytedance.android.live.saas.middleware.npth;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class NpthProxy$create$1$getImpl$1 extends MutablePropertyReference0Impl {
    public NpthProxy$create$1$getImpl$1(NpthProxy r100) {
        super(r100, NpthProxy.class, "mFunctionMap", "getMFunctionMap()Ljava/util/Map;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return ((NpthProxy) this.receiver).getMFunctionMap();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        ((NpthProxy) this.receiver).setMFunctionMap((Map) r100);
    }
}
