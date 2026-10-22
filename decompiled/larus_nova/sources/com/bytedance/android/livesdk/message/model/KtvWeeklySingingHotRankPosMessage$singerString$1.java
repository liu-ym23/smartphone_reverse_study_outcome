package com.bytedance.android.livesdk.message.model;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvWeeklySingingHotRankPosMessage$singerString$1 extends MutablePropertyReference0Impl {
    public KtvWeeklySingingHotRankPosMessage$singerString$1(ud r100) {
        super(r100, ud.class, "singer", "getSinger()J", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return Long.valueOf(((ud) this.receiver).singer);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        ud r101 = (ud) this.receiver;
        r101.singer = ((Number) r100).longValue();
    }
}
