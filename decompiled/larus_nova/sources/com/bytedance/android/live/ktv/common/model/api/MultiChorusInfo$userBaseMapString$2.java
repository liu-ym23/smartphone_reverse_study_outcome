package com.bytedance.android.live.ktv.common.model.api;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiChorusInfo$userBaseMapString$2 extends MutablePropertyReference0Impl {
    public MultiChorusInfo$userBaseMapString$2(i0 r100) {
        super(r100, i0.class, "openUserBaseMap", "getOpenUserBaseMap()Ljava/util/Map;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return ((i0) this.receiver).openUserBaseMap;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        Map<String, l0> r101 = (Map) r100;
        ((i0) this.receiver).openUserBaseMap = r101;
    }
}
