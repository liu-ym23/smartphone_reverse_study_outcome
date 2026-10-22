package com.bytedance.android.live.messagewindow.business.tetris;

import h71.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class MsgWindowCardTetris$unloadAll$1 extends MutablePropertyReference0Impl {
    public MsgWindowCardTetris$unloadAll$1(MsgWindowCardTetris r100) {
        super(r100, MsgWindowCardTetris.class, "msgWindowPositionAdjuster", "getMsgWindowPositionAdjuster()Lcom/bytedance/android/live/room/api/messagewindow/process/IMsgWindowPositionAdjuster;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        d r100 = ((MsgWindowCardTetris) this.receiver).f82984v;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("msgWindowPositionAdjuster");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        d r101 = (d) r100;
        ((MsgWindowCardTetris) this.receiver).f82984v = r101;
    }
}
