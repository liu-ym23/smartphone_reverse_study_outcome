package com.stepos.agentframework.adapter.agentbus.bff;

import Ua.M;
import Y8.t;
import com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$CancelHandle$cancel$1", f = "ABBffCoreAgentClient.kt", l = {142}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ABBffCoreAgentClient$CancelHandle$cancel$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ABBffCoreAgentClient this$0;
    final /* synthetic */ ABBffCoreAgentClient.CancelHandle this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ABBffCoreAgentClient$CancelHandle$cancel$1(ABBffCoreAgentClient aBBffCoreAgentClient, ABBffCoreAgentClient.CancelHandle cancelHandle, InterfaceC4014c<? super ABBffCoreAgentClient$CancelHandle$cancel$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = aBBffCoreAgentClient;
        this.this$1 = cancelHandle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ABBffCoreAgentClient$CancelHandle$cancel$1 aBBffCoreAgentClient$CancelHandle$cancel$1 = new ABBffCoreAgentClient$CancelHandle$cancel$1(this.this$0, this.this$1, interfaceC4014c);
        aBBffCoreAgentClient$CancelHandle$cancel$1.L$0 = obj;
        return aBBffCoreAgentClient$CancelHandle$cancel$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ABBffCoreAgentClient$CancelHandle$cancel$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        M m10 = (M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                ABBffCoreAgentClient aBBffCoreAgentClient = this.this$0;
                ABBffCoreAgentClient.CancelHandle cancelHandle = this.this$1;
                Result.Companion companion = Result.INSTANCE;
                String str = cancelHandle.sessionId;
                String str2 = cancelHandle.messageId;
                this.L$0 = g9.h.a(m10);
                this.L$1 = g9.h.a(m10);
                this.I$0 = 0;
                this.label = 1;
                if (aBBffCoreAgentClient.d1(str, str2, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.h("ABBffCoreAgentClient", "abort failed: " + thE.getMessage(), false, 4, null);
        }
        return t.f7040a;
    }
}
