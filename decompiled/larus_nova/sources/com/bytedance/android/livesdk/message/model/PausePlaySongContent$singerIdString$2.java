package com.bytedance.android.livesdk.message.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class PausePlaySongContent$singerIdString$2 extends MutablePropertyReference0Impl {
    public PausePlaySongContent$singerIdString$2(yh r100) {
        super(r100, yh.class, "singerOpenId", "getSingerOpenId()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return ((yh) this.receiver).singerOpenId;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        yh r101 = (yh) this.receiver;
        String r102 = (String) r100;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.singerOpenId = r102;
    }
}
