package com.stepos.ability.mcpserver.executor;

import J7.c;
import com.stepos.ability.mcpserver.model.ExecutionPlan;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.ability.mcpserver.executor.BatchExecutor", f = "BatchExecutor.kt", l = {33}, m = "execute", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class BatchExecutor$execute$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ExecutionPlan f3180a;
    public ConcurrentHashMap b;
    public long c;
    public /* synthetic */ Object d;
    public final /* synthetic */ a e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BatchExecutor$execute$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.e = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.b(null, null, this);
    }
}
