package com.stepos.ability.mcpserver.endpoint;

import C7.r;
import J7.c;
import S7.n;
import com.stepos.ability.mcpserver.model.McpSession;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.mcpserver.endpoint.JsonRpcRouter$handleToolsCall$executed$1", f = "JsonRpcRouter.kt", l = {143}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lcom/stepos/ability/beaninternal/ability/FunctionCallResult;", "<anonymous>", "(Lm9/z;)Lcom/stepos/ability/beaninternal/ability/FunctionCallResult;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class JsonRpcRouter$handleToolsCall$executed$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3173a;
    public final /* synthetic */ a b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Map d;
    public final /* synthetic */ McpSession e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonRpcRouter$handleToolsCall$executed$1(a aVar, String str, Map map, McpSession mcpSession, H7.c cVar) {
        super(2, cVar);
        this.b = aVar;
        this.c = str;
        this.d = map;
        this.e = mcpSession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new JsonRpcRouter$handleToolsCall$executed$1(this.b, this.c, this.d, this.e, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((JsonRpcRouter$handleToolsCall$executed$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3173a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return obj;
        }
        kotlin.b.b(obj);
        com.stepos.ability.mcpserver.executor.b bVar = this.b.c;
        String sessionId = this.e.getSessionId();
        this.f3173a = 1;
        Object objA = bVar.a(this.c, this.d, "", sessionId, "", this);
        return objA == coroutineSingletons ? coroutineSingletons : objA;
    }
}
