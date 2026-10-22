package com.stepos.ability.mcpserver.endpoint;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.mcpserver.endpoint.JsonRpcRouter$handleToolsDescribe$desc$1", f = "JsonRpcRouter.kt", l = {182}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lcom/stepos/ability/mcpserver/model/ToolDescription;", "<anonymous>", "(Lm9/z;)Lcom/stepos/ability/mcpserver/model/ToolDescription;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class JsonRpcRouter$handleToolsDescribe$desc$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3174a;
    public final /* synthetic */ a b;
    public final /* synthetic */ String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonRpcRouter$handleToolsDescribe$desc$1(a aVar, String str, H7.c cVar) {
        super(2, cVar);
        this.b = aVar;
        this.c = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new JsonRpcRouter$handleToolsDescribe$desc$1(this.b, this.c, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((JsonRpcRouter$handleToolsDescribe$desc$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3174a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return obj;
        }
        kotlin.b.b(obj);
        com.stepos.ability.mcpserver.describe.a aVar = this.b.b;
        this.f3174a = 1;
        Object objA = aVar.a(this.c, this);
        return objA == coroutineSingletons ? coroutineSingletons : objA;
    }
}
