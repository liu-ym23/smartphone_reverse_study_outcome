package com.stepos.ailauncher.agent.aispace.connect.data;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository", f = "AgentDeviceRepository.kt", l = {498, 500}, m = "getFileSync-BWLJW6A", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentDeviceRepository$getFileSync$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AgentDeviceRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentDeviceRepository$getFileSync$1(AgentDeviceRepository agentDeviceRepository, InterfaceC4014c<? super AgentDeviceRepository$getFileSync$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = agentDeviceRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objW = this.this$0.w(null, null, null, this);
        return objW == C4063a.g() ? objW : Result.a(objW);
    }
}
