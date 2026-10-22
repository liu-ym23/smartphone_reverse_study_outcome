package com.stepos.ability.task.executor;

import C7.r;
import S7.n;
import com.stepos.ability.bean.InternalTask;
import com.stepos.ability.bean.Task;
import com.stepos.ability.bean.TaskError;
import com.stepos.ability.common.TaskStatus;
import com.stepos.ability.commoninternal.AgentCache;
import com.stepos.ability.report.event.AgentCacheTaskEvent;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.ability.task.executor.ToolTaskExecutor$execute$5", f = "ToolTaskExecutor.kt", l = {}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class ToolTaskExecutor$execute$5 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f3305a;
    public final /* synthetic */ InternalTask b;
    public final /* synthetic */ Exception c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Task e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolTaskExecutor$execute$5(g gVar, InternalTask internalTask, Exception exc, String str, Task task, H7.c cVar) {
        super(2, cVar);
        this.f3305a = gVar;
        this.b = internalTask;
        this.c = exc;
        this.d = str;
        this.e = task;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new ToolTaskExecutor$execute$5(this.f3305a, this.b, this.c, this.d, this.e, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        ToolTaskExecutor$execute$5 toolTaskExecutor$execute$5 = (ToolTaskExecutor$execute$5) create((InterfaceC1733z) obj, (H7.c) obj2);
        r rVar = r.f317a;
        toolTaskExecutor$execute$5.invokeSuspend(rVar);
        return rVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.b.b(obj);
        TaskStatus taskStatus = TaskStatus.i;
        String message = this.c.getMessage();
        if (message == null) {
            message = "ToolTaskExecutor failed";
        }
        TaskError taskError = new TaskError(0, "UNKNOWN", message, false, 9, null);
        g gVar = this.f3305a;
        gVar.a(taskStatus, this.b, taskError);
        gVar.f.reportTaskEvent(new AgentCacheTaskEvent(this.d, this.e.getTaskId(), AgentCache.AGENT_CACHE_TASK_TYPE_TOOL, true, Boolean.FALSE, AgentCache.AGENT_CACHE_MSG_TYPE_DOWN_LINK));
        return r.f317a;
    }
}
