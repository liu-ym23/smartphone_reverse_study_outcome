package com.stepos.ability.mcpserver.executor;

import C7.r;
import D7.w;
import J7.c;
import S7.n;
import com.stepos.ability.mcpserver.model.ExecutionLayer;
import com.stepos.ability.mcpserver.model.ExecutionTask;
import com.stepos.ability.mcpserver.model.McpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import u9.d;
import w9.f;

@c(c = "com.stepos.ability.mcpserver.executor.BatchExecutor$execute$2$layerResults$1", f = "BatchExecutor.kt", l = {40}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lm9/z;", "", "Lkotlin/Pair;", "", "Lcom/stepos/ability/mcpserver/model/TaskResult;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class BatchExecutor$execute$2$layerResults$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3182a;
    public /* synthetic */ Object b;
    public final /* synthetic */ ExecutionLayer c;
    public final /* synthetic */ f d;
    public final /* synthetic */ a e;
    public final /* synthetic */ ConcurrentHashMap f;
    public final /* synthetic */ McpSession g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BatchExecutor$execute$2$layerResults$1(ExecutionLayer executionLayer, f fVar, a aVar, ConcurrentHashMap concurrentHashMap, McpSession mcpSession, H7.c cVar) {
        super(2, cVar);
        this.c = executionLayer;
        this.d = fVar;
        this.e = aVar;
        this.f = concurrentHashMap;
        this.g = mcpSession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        BatchExecutor$execute$2$layerResults$1 batchExecutor$execute$2$layerResults$1 = new BatchExecutor$execute$2$layerResults$1(this.c, this.d, this.e, this.f, this.g, cVar);
        batchExecutor$execute$2$layerResults$1.b = obj;
        return batchExecutor$execute$2$layerResults$1;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((BatchExecutor$execute$2$layerResults$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.b;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3182a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return obj;
        }
        kotlin.b.b(obj);
        List<ExecutionTask> tasks = this.c.getTasks();
        ArrayList arrayList = new ArrayList(w.c0(tasks, 10));
        for (ExecutionTask executionTask : tasks) {
            d dVar = AbstractC1691I.f5315a;
            arrayList.add(AbstractC1683A.d(interfaceC1733z, u9.c.f6743a, new BatchExecutor$execute$2$layerResults$1$1$1(this.d, this.e, executionTask, this.f, this.g, null), 2));
        }
        this.b = null;
        this.f3182a = 1;
        Object objB = kotlinx.coroutines.a.b(arrayList, this);
        return objB == coroutineSingletons ? coroutineSingletons : objB;
    }
}
