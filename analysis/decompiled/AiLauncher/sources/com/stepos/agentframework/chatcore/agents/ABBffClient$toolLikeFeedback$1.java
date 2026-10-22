package com.stepos.agentframework.chatcore.agents;

import Ua.M;
import com.stepos.agentframework.adapter.ApiManager;
import com.stepos.agentframework.adapter.netcore.ApiType;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.VoteRequest;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.agents.ABBffClient$toolLikeFeedback$1", f = "ABBffClient.kt", l = {326}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ABBffClient$toolLikeFeedback$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ VoteRequest $voteRequest;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ABBffClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ABBffClient$toolLikeFeedback$1(VoteRequest voteRequest, ABBffClient aBBffClient, InterfaceC4014c<? super ABBffClient$toolLikeFeedback$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$voteRequest = voteRequest;
        this.this$0 = aBBffClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ABBffClient$toolLikeFeedback$1 aBBffClient$toolLikeFeedback$1 = new ABBffClient$toolLikeFeedback$1(this.$voteRequest, this.this$0, interfaceC4014c);
        aBBffClient$toolLikeFeedback$1.L$0 = obj;
        return aBBffClient$toolLikeFeedback$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ABBffClient$toolLikeFeedback$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
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
                VoteRequest voteRequest = this.$voteRequest;
                Result.Companion companion = Result.INSTANCE;
                ApiManager apiManager = ApiManager.INSTANCE;
                ApiType apiType = ApiType.AGENTBUS_BFF;
                this.L$0 = g9.h.a(m10);
                this.L$1 = g9.h.a(m10);
                this.I$0 = 0;
                this.label = 1;
                obj = apiManager.r0(apiType, voteRequest, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            objB = Result.b(C4109a.a(((Boolean) obj).booleanValue()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        ABBffClient aBBffClient = this.this$0;
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.h(aBBffClient.tag, "toolLikeFeedback failed: " + thE.getMessage(), false, 4, null);
        }
        return Y8.t.f7040a;
    }
}
