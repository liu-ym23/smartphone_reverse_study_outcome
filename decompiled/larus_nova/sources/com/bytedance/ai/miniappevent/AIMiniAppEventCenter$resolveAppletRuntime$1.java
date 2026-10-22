package com.bytedance.ai.miniappevent;

import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.miniappevent.AIMiniAppEventCenter", f = "AIMiniAppEventCenter.kt", i = {0}, l = {157}, m = "resolveAppletRuntime", n = {IFlowAppIntentIDL.PARAM_APPLET_ID}, s = {"L$0"})
public final class AIMiniAppEventCenter$resolveAppletRuntime$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIMiniAppEventCenter this$0;

    public AIMiniAppEventCenter$resolveAppletRuntime$1(AIMiniAppEventCenter r100, Continuation<? super AIMiniAppEventCenter$resolveAppletRuntime$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        AIMiniAppEventCenter r101 = this.this$0;
        AIMiniAppEventCenter r102 = AIMiniAppEventCenter.f36687a;
        return r101.i(null, false, this);
    }
}
