package com.bytedance.android.live.revenue.platform.room.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0096@"}, d2 = {"Lkotlin/coroutines/Continuation;", "", "continuation", "", "onStartAsync"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.bytedance.android.live.revenue.platform.room.impl.RoomMessageService", f = "RoomMessageService.kt", i = {0}, l = {39}, m = "onStartAsync", n = {"this"}, s = {"L$0"})
public final class RoomMessageService$onStartAsync$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RoomMessageService this$0;

    public RoomMessageService$onStartAsync$1(RoomMessageService r100, Continuation r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.o0(this);
    }
}
