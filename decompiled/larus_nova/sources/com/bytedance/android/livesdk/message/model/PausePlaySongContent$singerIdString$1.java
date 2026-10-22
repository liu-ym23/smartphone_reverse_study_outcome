package com.bytedance.android.livesdk.message.model;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class PausePlaySongContent$singerIdString$1 extends MutablePropertyReference0Impl {
    public PausePlaySongContent$singerIdString$1(yh r100) {
        super(r100, yh.class, "singerId", "getSingerId()J", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return Long.valueOf(((yh) this.receiver).singerId);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        yh r101 = (yh) this.receiver;
        r101.singerId = ((Number) r100).longValue();
    }
}
