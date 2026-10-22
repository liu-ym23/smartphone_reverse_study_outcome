package com.bytedance.android.live.ktv.common.model.api;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiChorusSongListItem$userBaseMapString$1 extends MutablePropertyReference0Impl {
    public MultiChorusSongListItem$userBaseMapString$1(k0 r100) {
        super(r100, k0.class, "userBaseMap", "getUserBaseMap()Ljava/util/Map;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return ((k0) this.receiver).userBaseMap;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        Map<Long, l0> r101 = (Map) r100;
        ((k0) this.receiver).userBaseMap = r101;
    }
}
