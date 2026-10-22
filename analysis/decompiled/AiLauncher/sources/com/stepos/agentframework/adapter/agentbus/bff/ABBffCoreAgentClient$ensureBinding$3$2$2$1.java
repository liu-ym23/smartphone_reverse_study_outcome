package com.stepos.agentframework.adapter.agentbus.bff;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "byteArray", "LY8/t;", "<anonymous>", "([B)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$ensureBinding$3$2$2$1", f = "ABBffCoreAgentClient.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ABBffCoreAgentClient$ensureBinding$3$2$2$1 extends SuspendLambda implements p9.p<byte[], InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ ABBffCoreAgentClient $this_runCatching;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ABBffCoreAgentClient$ensureBinding$3$2$2$1(ABBffCoreAgentClient aBBffCoreAgentClient, InterfaceC4014c<? super ABBffCoreAgentClient$ensureBinding$3$2$2$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$this_runCatching = aBBffCoreAgentClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ABBffCoreAgentClient$ensureBinding$3$2$2$1 aBBffCoreAgentClient$ensureBinding$3$2$2$1 = new ABBffCoreAgentClient$ensureBinding$3$2$2$1(this.$this_runCatching, interfaceC4014c);
        aBBffCoreAgentClient$ensureBinding$3$2$2$1.L$0 = obj;
        return aBBffCoreAgentClient$ensureBinding$3$2$2$1;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(byte[] bArr, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ABBffCoreAgentClient$ensureBinding$3$2$2$1) create(bArr, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        byte[] bArr = (byte[]) this.L$0;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        this.$this_runCatching.U0(bArr);
        return t.f7040a;
    }
}
