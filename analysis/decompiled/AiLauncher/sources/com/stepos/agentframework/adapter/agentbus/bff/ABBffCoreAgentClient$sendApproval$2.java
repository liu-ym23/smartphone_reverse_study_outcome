package com.stepos.agentframework.adapter.agentbus.bff;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lkotlin/Result;", "", "<anonymous>", "(LUa/M;)Lkotlin/Result;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$sendApproval$2", f = "ABBffCoreAgentClient.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ABBffCoreAgentClient$sendApproval$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Result<? extends Integer>>, Object> {
    final /* synthetic */ byte[] $streamMsg;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ABBffCoreAgentClient$sendApproval$2(byte[] bArr, InterfaceC4014c<? super ABBffCoreAgentClient$sendApproval$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$streamMsg = bArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ABBffCoreAgentClient$sendApproval$2 aBBffCoreAgentClient$sendApproval$2 = new ABBffCoreAgentClient$sendApproval$2(this.$streamMsg, interfaceC4014c);
        aBBffCoreAgentClient$sendApproval$2.L$0 = obj;
        return aBBffCoreAgentClient$sendApproval$2;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super Result<Integer>> interfaceC4014c) {
        return ((ABBffCoreAgentClient$sendApproval$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        byte[] bArr = this.$streamMsg;
        try {
            Result.Companion companion = Result.INSTANCE;
            com.stepos.agentframework.protobuf.g gVarF = com.stepos.agentframework.protobuf.g.f(bArr);
            int length = bArr.length;
            kotlin.jvm.internal.p.f(gVarF);
            objB = Result.b(C4109a.f(C4148a.k("ReceiveTextViewHolder", "sendApproval#8 payload(bytes=" + length + "): " + f.f(gVarF), false, 4, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        byte[] bArr2 = this.$streamMsg;
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u("ReceiveTextViewHolder", "sendApproval#8 payload decode failed: " + thE.getMessage() + ", bytes=" + bArr2.length, false, 4, null);
        }
        return Result.a(objB);
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super Result<? extends Integer>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super Result<Integer>>) interfaceC4014c);
    }
}
