package com.stepos.ability.task.executor;

import com.stepos.ability.bean.InternalTask;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.ability.task.executor.TaskExecutor", f = "TaskExecutor.kt", l = {28}, m = "execute", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class TaskExecutor$execute$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public InternalTask f3285a;
    public /* synthetic */ Object b;
    public final /* synthetic */ f c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskExecutor$execute$1(f fVar, H7.c cVar) {
        super(cVar);
        this.c = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.execute(null, 0, 0, this);
    }
}
