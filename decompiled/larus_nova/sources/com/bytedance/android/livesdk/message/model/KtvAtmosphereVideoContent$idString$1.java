package com.bytedance.android.livesdk.message.model;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvAtmosphereVideoContent$idString$1 extends MutablePropertyReference0Impl {
    public KtvAtmosphereVideoContent$idString$1(dd r100) {
        super(r100, dd.class, "uid", "getUid()J", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return Long.valueOf(((dd) this.receiver).uid);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        dd r101 = (dd) this.receiver;
        r101.uid = ((Number) r100).longValue();
    }
}
