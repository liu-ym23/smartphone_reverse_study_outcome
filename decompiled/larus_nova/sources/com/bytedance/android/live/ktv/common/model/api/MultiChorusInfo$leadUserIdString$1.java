package com.bytedance.android.live.ktv.common.model.api;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiChorusInfo$leadUserIdString$1 extends MutablePropertyReference0Impl {
    public MultiChorusInfo$leadUserIdString$1(i0 r100) {
        super(r100, i0.class, "leadUserId", "getLeadUserId()J", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return Long.valueOf(((i0) this.receiver).leadUserId);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        i0 r101 = (i0) this.receiver;
        r101.leadUserId = ((Number) r100).longValue();
    }
}
