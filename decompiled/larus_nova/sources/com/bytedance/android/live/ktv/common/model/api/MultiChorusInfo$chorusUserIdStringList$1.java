package com.bytedance.android.live.ktv.common.model.api;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiChorusInfo$chorusUserIdStringList$1 extends MutablePropertyReference0Impl {
    public MultiChorusInfo$chorusUserIdStringList$1(i0 r100) {
        super(r100, i0.class, "chorusUsers", "getChorusUsers()Ljava/util/List;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return ((i0) this.receiver).chorusUsers;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        List<Long> r101 = (List) r100;
        ((i0) this.receiver).chorusUsers = r101;
    }
}
