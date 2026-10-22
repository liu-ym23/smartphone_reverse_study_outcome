package com.stepos.ability.task.scheduler;

import J7.c;
import com.stepos.ability.bean.InternalTask;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import w9.e;

@c(c = "com.stepos.ability.task.scheduler.TaskScheduler", f = "TaskScheduler.kt", l = {52, 42}, m = "schedule", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class TaskScheduler$schedule$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public InternalTask f3317a;
    public e b;
    public int c;
    public int d;
    public int e;
    public /* synthetic */ Object f;
    public final /* synthetic */ a g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskScheduler$schedule$1(a aVar, H7.c cVar) {
        super(cVar);
        this.g = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f = obj;
        this.h |= Integer.MIN_VALUE;
        return this.g.schedule(null, 0, 0, this);
    }
}
