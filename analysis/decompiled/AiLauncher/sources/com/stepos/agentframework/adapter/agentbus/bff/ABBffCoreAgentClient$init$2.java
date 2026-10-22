package com.stepos.agentframework.adapter.agentbus.bff;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "byteArray", "LY8/t;", "<anonymous>", "([B)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$init$2", f = "ABBffCoreAgentClient.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ABBffCoreAgentClient$init$2 extends SuspendLambda implements p9.p<byte[], InterfaceC4014c<? super t>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ABBffCoreAgentClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ABBffCoreAgentClient$init$2(ABBffCoreAgentClient aBBffCoreAgentClient, InterfaceC4014c<? super ABBffCoreAgentClient$init$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = aBBffCoreAgentClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ABBffCoreAgentClient$init$2 aBBffCoreAgentClient$init$2 = new ABBffCoreAgentClient$init$2(this.this$0, interfaceC4014c);
        aBBffCoreAgentClient$init$2.L$0 = obj;
        return aBBffCoreAgentClient$init$2;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(byte[] bArr, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ABBffCoreAgentClient$init$2) create(bArr, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        byte[] bArr = (byte[]) this.L$0;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        this.this$0.U0(bArr);
        return t.f7040a;
    }
}
