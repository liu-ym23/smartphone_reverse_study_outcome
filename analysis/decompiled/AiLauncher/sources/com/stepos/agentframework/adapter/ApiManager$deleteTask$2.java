package com.stepos.agentframework.adapter;

import Y8.t;
import com.stepos.agentframework.adapter.netcore.o;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.TaskDeleteRequest;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/o;", "it", "", "<anonymous>", "(Lcom/stepos/agentframework/adapter/netcore/o;)Z"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.ApiManager$deleteTask$2", f = "ApiManager.kt", l = {681}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ApiManager$deleteTask$2 extends SuspendLambda implements p<o, InterfaceC4014c<? super Boolean>, Object> {
    final /* synthetic */ TaskDeleteRequest $request;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApiManager$deleteTask$2(TaskDeleteRequest taskDeleteRequest, InterfaceC4014c<? super ApiManager$deleteTask$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$request = taskDeleteRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ApiManager$deleteTask$2 apiManager$deleteTask$2 = new ApiManager$deleteTask$2(this.$request, interfaceC4014c);
        apiManager$deleteTask$2.L$0 = obj;
        return apiManager$deleteTask$2;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(o oVar, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((ApiManager$deleteTask$2) create(oVar, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        o oVar = (o) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        TaskDeleteRequest taskDeleteRequest = this.$request;
        this.L$0 = h.a(oVar);
        this.label = 1;
        Object objF = oVar.f(taskDeleteRequest, this);
        return objF == objG ? objG : objF;
    }
}
