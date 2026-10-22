package com.bytedance.android.live.ktv.common.model.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiChorusInfo$leadUserIdString$2 extends MutablePropertyReference0Impl {
    public MultiChorusInfo$leadUserIdString$2(i0 r100) {
        super(r100, i0.class, "leadOpenId", "getLeadOpenId()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return ((i0) this.receiver).leadOpenId;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        i0 r101 = (i0) this.receiver;
        String r102 = (String) r100;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.leadOpenId = r102;
    }
}
