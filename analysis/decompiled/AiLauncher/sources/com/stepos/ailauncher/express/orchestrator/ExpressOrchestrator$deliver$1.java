package com.stepos.ailauncher.express.orchestrator;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.express.orchestrator.ExpressOrchestrator", f = "ExpressOrchestrator.kt", l = {110}, m = "deliver", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ExpressOrchestrator$deliver$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ExpressOrchestrator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpressOrchestrator$deliver$1(ExpressOrchestrator expressOrchestrator, InterfaceC4014c<? super ExpressOrchestrator$deliver$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = expressOrchestrator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(null, null, null, this);
    }
}
