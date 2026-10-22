package com.stepos.ability.mcpserver.executor;

import J7.c;
import com.stepos.ability.mcpserver.model.ExecutionTask;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "com.stepos.ability.mcpserver.executor.BatchExecutor", f = "BatchExecutor.kt", l = {71}, m = "executeTask", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class BatchExecutor$executeTask$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ExecutionTask f3185a;
    public /* synthetic */ Object b;
    public final /* synthetic */ a c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BatchExecutor$executeTask$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.c = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return a.a(this.c, null, null, null, this);
    }
}
