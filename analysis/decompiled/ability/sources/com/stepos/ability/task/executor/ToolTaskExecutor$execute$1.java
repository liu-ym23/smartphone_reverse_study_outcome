package com.stepos.ability.task.executor;

import com.stepos.ability.bean.InternalTask;
import com.stepos.ability.bean.Task;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$ObjectRef;

@J7.c(c = "com.stepos.ability.task.executor.ToolTaskExecutor", f = "ToolTaskExecutor.kt", l = {184}, m = "execute", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class ToolTaskExecutor$execute$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public InternalTask f3297a;
    public Task b;
    public String c;
    public String d;
    public Long e;
    public Boolean f;
    public String g;
    public Ref$ObjectRef h;
    public Ref$ObjectRef i;

    /* renamed from: j, reason: collision with root package name */
    public int f3298j;
    public boolean k;
    public /* synthetic */ Object l;
    public final /* synthetic */ g m;
    public int n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolTaskExecutor$execute$1(g gVar, H7.c cVar) {
        super(cVar);
        this.m = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.l = obj;
        this.n |= Integer.MIN_VALUE;
        return this.m.execute(null, 0, 0, this);
    }
}
