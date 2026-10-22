package com.bytedance.android.live.ktv.common.model.api;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiChorusUserBase$userIdString$1 extends MutablePropertyReference0Impl {
    public MultiChorusUserBase$userIdString$1(l0 r100) {
        super(r100, l0.class, "userId", "getUserId()J", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return Long.valueOf(((l0) this.receiver).userId);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        l0 r101 = (l0) this.receiver;
        r101.userId = ((Number) r100).longValue();
    }
}
