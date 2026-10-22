package com.bytedance.android.livesdk.ktvimpl.multichorus.model;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiChorusCommonContent$userIdString$1 extends MutablePropertyReference0Impl {
    public MultiChorusCommonContent$userIdString$1(e r100) {
        super(r100, e.class, "userID", "getUserID()J", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return Long.valueOf(((e) this.receiver).userID);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        e r101 = (e) this.receiver;
        r101.userID = ((Number) r100).longValue();
    }
}
