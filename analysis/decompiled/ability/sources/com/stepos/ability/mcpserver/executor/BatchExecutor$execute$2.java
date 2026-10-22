package com.stepos.ability.mcpserver.executor;

import C7.r;
import J7.c;
import S7.n;
import com.stepos.ability.mcpserver.model.ExecutionPlan;
import com.stepos.ability.mcpserver.model.McpSession;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;
import w9.f;

@c(c = "com.stepos.ability.mcpserver.executor.BatchExecutor$execute$2", f = "BatchExecutor.kt", l = {35}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class BatchExecutor$execute$2 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public Iterator f3181a;
    public int b;
    public final /* synthetic */ ExecutionPlan c;
    public final /* synthetic */ f d;
    public final /* synthetic */ a e;
    public final /* synthetic */ ConcurrentHashMap f;
    public final /* synthetic */ McpSession g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BatchExecutor$execute$2(ExecutionPlan executionPlan, f fVar, a aVar, ConcurrentHashMap concurrentHashMap, McpSession mcpSession, H7.c cVar) {
        super(2, cVar);
        this.c = executionPlan;
        this.d = fVar;
        this.e = aVar;
        this.f = concurrentHashMap;
        this.g = mcpSession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new BatchExecutor$execute$2(this.c, this.d, this.e, this.f, this.g, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((BatchExecutor$execute$2) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005e A[LOOP:0: B:15:0x0058->B:17:0x005e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x004d -> B:14:0x0050). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r10.b
            java.util.concurrent.ConcurrentHashMap r6 = r10.f
            r9 = 1
            if (r1 == 0) goto L1b
            if (r1 != r9) goto L13
            java.util.Iterator r1 = r10.f3181a
            java.util.Iterator r1 = (java.util.Iterator) r1
            kotlin.b.b(r11)
            goto L50
        L13:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L1b:
            kotlin.b.b(r11)
            com.stepos.ability.mcpserver.model.ExecutionPlan r11 = r10.c
            java.util.List r11 = r11.getLayers()
            java.util.Iterator r11 = r11.iterator()
            r1 = r11
        L29:
            boolean r11 = r1.hasNext()
            if (r11 == 0) goto L70
            java.lang.Object r11 = r1.next()
            r3 = r11
            com.stepos.ability.mcpserver.model.ExecutionLayer r3 = (com.stepos.ability.mcpserver.model.ExecutionLayer) r3
            com.stepos.ability.mcpserver.executor.BatchExecutor$execute$2$layerResults$1 r2 = new com.stepos.ability.mcpserver.executor.BatchExecutor$execute$2$layerResults$1
            com.stepos.ability.mcpserver.model.McpSession r7 = r10.g
            r8 = 0
            w9.f r4 = r10.d
            com.stepos.ability.mcpserver.executor.a r5 = r10.e
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r11 = r1
            java.util.Iterator r11 = (java.util.Iterator) r11
            r10.f3181a = r11
            r10.b = r9
            java.lang.Object r11 = m9.AbstractC1683A.f(r2, r10)
            if (r11 != r0) goto L50
            return r0
        L50:
            java.util.List r11 = (java.util.List) r11
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Iterator r11 = r11.iterator()
        L58:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto L29
            java.lang.Object r2 = r11.next()
            kotlin.Pair r2 = (kotlin.Pair) r2
            java.lang.Object r3 = r2.f4886a
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.b
            com.stepos.ability.mcpserver.model.TaskResult r2 = (com.stepos.ability.mcpserver.model.TaskResult) r2
            r6.put(r3, r2)
            goto L58
        L70:
            C7.r r10 = C7.r.f317a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.mcpserver.executor.BatchExecutor$execute$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
