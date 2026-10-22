package com.bytedance.android.livesdk.ktvimpl.multichorus.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiChorusCommonContent$userIdString$2 extends MutablePropertyReference0Impl {
    public MultiChorusCommonContent$userIdString$2(e r100) {
        super(r100, e.class, "userOpenId", "getUserOpenId()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return ((e) this.receiver).userOpenId;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        e r101 = (e) this.receiver;
        String r102 = (String) r100;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.userOpenId = r102;
    }
}
