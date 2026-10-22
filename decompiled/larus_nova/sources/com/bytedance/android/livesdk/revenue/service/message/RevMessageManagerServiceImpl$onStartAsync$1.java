package com.bytedance.android.livesdk.revenue.service.message;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0096@"}, d2 = {"Lkotlin/coroutines/Continuation;", "", "continuation", "", "onStartAsync"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.revenue.service.message.RevMessageManagerServiceImpl", f = "RevMessageManagerServiceImpl.kt", i = {0, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4}, l = {45, 46, 47, 58, 61}, m = "onStartAsync", n = {"this", "this", "roomContext", "this", "roomContext", "original", "this", "roomContext", "rtcRoomOriginal", "this", "rtcRoomOriginal", "isAnchor"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "Z$0"})
public final class RevMessageManagerServiceImpl$onStartAsync$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RevMessageManagerServiceImpl this$0;

    public RevMessageManagerServiceImpl$onStartAsync$1(RevMessageManagerServiceImpl r100, Continuation r101) {
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
