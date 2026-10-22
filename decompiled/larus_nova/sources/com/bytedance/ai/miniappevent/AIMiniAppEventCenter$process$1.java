package com.bytedance.ai.miniappevent;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.miniappevent.AIMiniAppEventCenter", f = "AIMiniAppEventCenter.kt", i = {0, 0, 0}, l = {145}, m = "process", n = {"eventNotify", "dispatchContext", WsConstants.KEY_PAYLOAD}, s = {"L$0", "L$1", "L$2"})
final class AIMiniAppEventCenter$process$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIMiniAppEventCenter this$0;

    public AIMiniAppEventCenter$process$1(AIMiniAppEventCenter r100, Continuation<? super AIMiniAppEventCenter$process$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return AIMiniAppEventCenter.a(this.this$0, null, null, this);
    }
}
