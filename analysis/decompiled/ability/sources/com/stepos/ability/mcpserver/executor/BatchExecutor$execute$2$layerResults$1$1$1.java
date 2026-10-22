package com.stepos.ability.mcpserver.executor;

import C7.r;
import J7.c;
import S7.n;
import com.stepos.ability.mcpserver.model.ExecutionTask;
import com.stepos.ability.mcpserver.model.McpSession;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;
import w9.e;
import w9.f;

@c(c = "com.stepos.ability.mcpserver.executor.BatchExecutor$execute$2$layerResults$1$1$1", f = "BatchExecutor.kt", l = {97, 38}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lm9/z;", "Lkotlin/Pair;", "", "Lcom/stepos/ability/mcpserver/model/TaskResult;", "<anonymous>", "(Lm9/z;)Lkotlin/Pair;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class BatchExecutor$execute$2$layerResults$1$1$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public e f3183a;
    public a b;
    public ExecutionTask c;
    public ConcurrentHashMap d;
    public McpSession e;
    public int f;
    public int g;
    public final /* synthetic */ f h;
    public final /* synthetic */ a i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ ExecutionTask f3184j;
    public final /* synthetic */ ConcurrentHashMap k;
    public final /* synthetic */ McpSession l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BatchExecutor$execute$2$layerResults$1$1$1(f fVar, a aVar, ExecutionTask executionTask, ConcurrentHashMap concurrentHashMap, McpSession mcpSession, H7.c cVar) {
        super(2, cVar);
        this.h = fVar;
        this.i = aVar;
        this.f3184j = executionTask;
        this.k = concurrentHashMap;
        this.l = mcpSession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new BatchExecutor$execute$2$layerResults$1$1$1(this.h, this.i, this.f3184j, this.k, this.l, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((BatchExecutor$execute$2$layerResults$1$1$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [w9.e] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        f fVar;
        a aVar;
        ExecutionTask executionTask;
        ConcurrentHashMap concurrentHashMap;
        McpSession mcpSession;
        int i;
        Throwable th;
        Object obj2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i6 = this.g;
        try {
            if (i6 == 0) {
                kotlin.b.b(obj);
                fVar = this.h;
                this.f3183a = fVar;
                aVar = this.i;
                this.b = aVar;
                executionTask = this.f3184j;
                this.c = executionTask;
                concurrentHashMap = this.k;
                this.d = concurrentHashMap;
                McpSession mcpSession2 = this.l;
                this.e = mcpSession2;
                this.f = 0;
                this.g = 1;
                if (fVar.a(this) != coroutineSingletons) {
                    mcpSession = mcpSession2;
                    i = 0;
                }
                return coroutineSingletons;
            }
            if (i6 != 1) {
                if (i6 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj2 = this.f3183a;
                try {
                    kotlin.b.b(obj);
                    Pair pair = (Pair) obj;
                    ((kotlinx.coroutines.sync.b) obj2).c();
                    return pair;
                } catch (Throwable th2) {
                    th = th2;
                    ((kotlinx.coroutines.sync.b) obj2).c();
                    throw th;
                }
            }
            i = this.f;
            mcpSession = this.e;
            concurrentHashMap = this.d;
            executionTask = this.c;
            aVar = this.b;
            ?? r72 = this.f3183a;
            kotlin.b.b(obj);
            fVar = r72;
            this.f3183a = fVar;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = i;
            this.g = 2;
            Serializable serializableA = a.a(aVar, executionTask, concurrentHashMap, mcpSession, this);
            if (serializableA != coroutineSingletons) {
                f fVar2 = fVar;
                obj = serializableA;
                obj2 = fVar2;
                Pair pair2 = (Pair) obj;
                ((kotlinx.coroutines.sync.b) obj2).c();
                return pair2;
            }
            return coroutineSingletons;
        } catch (Throwable th3) {
            f fVar3 = fVar;
            th = th3;
            obj2 = fVar3;
            ((kotlinx.coroutines.sync.b) obj2).c();
            throw th;
        }
    }
}
