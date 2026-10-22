package com.stepos.ability.task.executor;

import C7.r;
import S7.k;
import com.stepos.ability.bean.InternalTask;
import com.stepos.ability.bean.Task;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@J7.c(c = "com.stepos.ability.task.executor.ToolTaskExecutor$execute$2$terminalResponse$1", f = "ToolTaskExecutor.kt", l = {249}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/stepos/ability/beaninternal/ability/FunctionCallResult;"}, k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class ToolTaskExecutor$execute$2$terminalResponse$1 extends SuspendLambda implements k {

    /* renamed from: a, reason: collision with root package name */
    public int f3303a;
    public final /* synthetic */ g b;
    public final /* synthetic */ InternalTask c;
    public final /* synthetic */ Task d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ Long g;
    public final /* synthetic */ Boolean h;
    public final /* synthetic */ int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolTaskExecutor$execute$2$terminalResponse$1(g gVar, InternalTask internalTask, Task task, String str, String str2, Long l, Boolean bool, int i, H7.c cVar) {
        super(1, cVar);
        this.b = gVar;
        this.c = internalTask;
        this.d = task;
        this.e = str;
        this.f = str2;
        this.g = l;
        this.h = bool;
        this.i = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(H7.c cVar) {
        return new ToolTaskExecutor$execute$2$terminalResponse$1(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, cVar);
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        return ((ToolTaskExecutor$execute$2$terminalResponse$1) create((H7.c) obj)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3303a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return obj;
        }
        kotlin.b.b(obj);
        InternalTask internalTask = this.c;
        Long abilityId = internalTask.getAbilityId();
        String toolName = internalTask.getToolName();
        if (toolName == null) {
            toolName = "";
        }
        Task task = this.d;
        String str = toolName;
        String params = task.getParams();
        String taskId = task.getTaskId();
        String toolCallId = internalTask.getToolCallId();
        Boolean bool = this.h;
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        this.f3303a = 1;
        Object objC = this.b.c(abilityId, str, params, taskId, this.e, this.f, this.g, toolCallId, this.d, zBooleanValue, this.i, this);
        return objC == coroutineSingletons ? coroutineSingletons : objC;
    }
}
