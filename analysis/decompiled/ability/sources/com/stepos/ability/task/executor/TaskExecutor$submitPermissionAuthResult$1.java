package com.stepos.ability.task.executor;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "com.stepos.ability.task.executor.TaskExecutor", f = "TaskExecutor.kt", l = {212}, m = "submitPermissionAuthResult", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class TaskExecutor$submitPermissionAuthResult$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f3291a;
    public final /* synthetic */ f b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskExecutor$submitPermissionAuthResult$1(f fVar, H7.c cVar) {
        super(cVar);
        this.b = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3291a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.submitPermissionAuthResult(false, null, null, this);
    }
}
