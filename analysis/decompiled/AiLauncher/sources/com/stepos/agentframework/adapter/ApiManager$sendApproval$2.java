package com.stepos.agentframework.adapter;

import Ua.M;
import Y8.t;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.adapter.netcore.o;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import g9.h;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m4.AbstractC4898a;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)Z"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.ApiManager$sendApproval$2", f = "ApiManager.kt", l = {552}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ApiManager$sendApproval$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super Boolean>, Object> {
    final /* synthetic */ String $askUserQuestion;
    final /* synthetic */ String $decision;
    final /* synthetic */ String $reason;
    final /* synthetic */ String $requestId;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ ApiType $type;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApiManager$sendApproval$2(ApiType apiType, String str, String str2, String str3, String str4, String str5, InterfaceC4014c<? super ApiManager$sendApproval$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$type = apiType;
        this.$sessionId = str;
        this.$requestId = str2;
        this.$decision = str3;
        this.$reason = str4;
        this.$askUserQuestion = str5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ApiManager$sendApproval$2(this.$type, this.$sessionId, this.$requestId, this.$decision, this.$reason, this.$askUserQuestion, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((ApiManager$sendApproval$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        boolean z10 = false;
        try {
        } catch (Throwable th) {
            C4148a.g("ApiManager", "sendApproval failed. Err:" + new AbstractC4898a.AgentInternalError(th.getMessage()).message, th, false, 8, null);
        }
        if (i10 == 0) {
            C4849c.b(obj);
            ApiManager.INSTANCE.X(this.$type);
            o oVar = (o) ApiManager.clientMap.get(this.$type);
            if (oVar != null) {
                String str = this.$sessionId;
                String str2 = this.$requestId;
                String str3 = this.$decision;
                String str4 = this.$reason;
                String str5 = this.$askUserQuestion;
                this.L$0 = h.a(oVar);
                this.label = 1;
                obj = oVar.c(str, str2, str3, str4, str5, this);
                if (obj == objG) {
                    return objG;
                }
            }
            return C4109a.a(z10);
        }
        if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        if (((Boolean) obj).booleanValue()) {
            z10 = true;
        }
        return C4109a.a(z10);
    }
}
