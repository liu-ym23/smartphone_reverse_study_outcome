package com.stepos.ailauncher.agent.aispace.connect.data;

import com.zyql.ai.selector.widget.longimage.SubsamplingScaleImageView;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.data.AgentDeviceRepository", f = "AgentDeviceRepository.kt", l = {SubsamplingScaleImageView.ORIENTATION_270, 274, 279, 286, 298, 302, 307, 911}, m = "listDevices-IoAF18A", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentDeviceRepository$listDevices$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AgentDeviceRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentDeviceRepository$listDevices$1(AgentDeviceRepository agentDeviceRepository, InterfaceC4014c<? super AgentDeviceRepository$listDevices$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = agentDeviceRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objD = this.this$0.D(this);
        return objD == C4063a.g() ? objD : Result.a(objD);
    }
}
