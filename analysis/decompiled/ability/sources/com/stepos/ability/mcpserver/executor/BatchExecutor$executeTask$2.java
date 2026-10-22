package com.stepos.ability.mcpserver.executor;

import C7.r;
import J7.c;
import S7.n;
import com.stepos.ability.beaninternal.ability.FunctionCallResult;
import com.stepos.ability.mcpserver.model.ExecutionTask;
import com.stepos.ability.mcpserver.model.McpSession;
import com.stepos.ability.mcpserver.model.TaskResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.ability.mcpserver.executor.BatchExecutor$executeTask$2", f = "BatchExecutor.kt", l = {72}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lm9/z;", "Lkotlin/Pair;", "", "Lcom/stepos/ability/mcpserver/model/TaskResult;", "<anonymous>", "(Lm9/z;)Lkotlin/Pair;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
final class BatchExecutor$executeTask$2 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3186a;
    public final /* synthetic */ a b;
    public final /* synthetic */ ExecutionTask c;
    public final /* synthetic */ Map d;
    public final /* synthetic */ McpSession e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BatchExecutor$executeTask$2(a aVar, ExecutionTask executionTask, Map map, McpSession mcpSession, H7.c cVar) {
        super(2, cVar);
        this.b = aVar;
        this.c = executionTask;
        this.d = map;
        this.e = mcpSession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new BatchExecutor$executeTask$2(this.b, this.c, this.d, this.e, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((BatchExecutor$executeTask$2) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3186a;
        ExecutionTask executionTask = this.c;
        if (i == 0) {
            kotlin.b.b(obj);
            b bVar = this.b.f3189a;
            String toolName = executionTask.getToolName();
            McpSession mcpSession = this.e;
            String strB = B7.a.B(mcpSession.getSessionId(), "_", executionTask.getId());
            String sessionId = mcpSession.getSessionId();
            String id = executionTask.getId();
            this.f3186a = 1;
            obj = bVar.a(toolName, this.d, strB, sessionId, id, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        FunctionCallResult functionCallResult = (FunctionCallResult) obj;
        if (!functionCallResult.getSuccess()) {
            return new Pair(executionTask.getId(), TaskResult.INSTANCE.error(functionCallResult.getErrorCode(), functionCallResult.getErrorMsg()));
        }
        String id2 = executionTask.getId();
        TaskResult.Companion companion = TaskResult.INSTANCE;
        Object structuredContent = functionCallResult.getStructuredContent();
        if (structuredContent == null) {
            structuredContent = functionCallResult.getContent();
        }
        return new Pair(id2, companion.ok(structuredContent));
    }
}
