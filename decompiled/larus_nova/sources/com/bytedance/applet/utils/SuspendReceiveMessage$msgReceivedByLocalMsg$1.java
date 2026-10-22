package com.bytedance.applet.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.utils.SuspendReceiveMessage", f = "SuspendReceiveMessage.kt", i = {}, l = {34}, m = "msgReceivedByLocalMsg", n = {}, s = {})
public final class SuspendReceiveMessage$msgReceivedByLocalMsg$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SuspendReceiveMessage this$0;

    public SuspendReceiveMessage$msgReceivedByLocalMsg$1(SuspendReceiveMessage r100, Continuation<? super SuspendReceiveMessage$msgReceivedByLocalMsg$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
