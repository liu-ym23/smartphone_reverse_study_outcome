package com.stepos.ability.mcpserver.endpoint;

import C7.r;
import D7.v;
import D7.w;
import J7.c;
import S7.n;
import com.stepos.ability.mcpserver.model.ToolDescriptionKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.mcpserver.endpoint.JsonRpcRouter$handleToolsList$tools$1", f = "JsonRpcRouter.kt", l = {88}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lcom/stepos/ability/mcpserver/model/ToolDescription;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class JsonRpcRouter$handleToolsList$tools$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3175a;
    public final /* synthetic */ a b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonRpcRouter$handleToolsList$tools$1(a aVar, H7.c cVar) {
        super(2, cVar);
        this.b = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new JsonRpcRouter$handleToolsList$tools$1(this.b, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((JsonRpcRouter$handleToolsList$tools$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, java.util.Map] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3175a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return obj;
        }
        kotlin.b.b(obj);
        com.stepos.ability.mcpserver.search.b bVar = this.b.f3178a;
        this.f3175a = 1;
        List listF1 = v.f1(bVar.c.f.values());
        ArrayList arrayList = new ArrayList(w.c0(listF1, 10));
        Iterator it = listF1.iterator();
        while (it.hasNext()) {
            arrayList.add(ToolDescriptionKt.toToolDescription((J3.a) it.next()));
        }
        return arrayList == coroutineSingletons ? coroutineSingletons : arrayList;
    }
}
