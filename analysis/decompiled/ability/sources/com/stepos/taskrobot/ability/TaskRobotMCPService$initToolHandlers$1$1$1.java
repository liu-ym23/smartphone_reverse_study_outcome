package com.stepos.taskrobot.ability;

import C7.r;
import J7.c;
import S7.n;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.C1687E;
import m9.InterfaceC1733z;
import reactor.core.publisher.Mono;

@c(c = "com.stepos.taskrobot.ability.TaskRobotMCPService$initToolHandlers$1$1$1", f = "TaskRobotMCPService.kt", l = {43}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lm9/z;", "Lreactor/core/publisher/Mono;", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "kotlin.jvm.PlatformType", "<anonymous>", "(Lm9/z;)Lreactor/core/publisher/Mono;"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class TaskRobotMCPService$initToolHandlers$1$1$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f3999a;
    public final /* synthetic */ TaskRobotMCPService b;
    public final /* synthetic */ TaskRobotMcpTool c;
    public final /* synthetic */ McpSchema.CallToolRequest d;

    @c(c = "com.stepos.taskrobot.ability.TaskRobotMCPService$initToolHandlers$1$1$1$1", f = "TaskRobotMCPService.kt", l = {42}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lm9/z;", "Lreactor/core/publisher/Mono;", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "kotlin.jvm.PlatformType", "<anonymous>", "(Lm9/z;)Lreactor/core/publisher/Mono;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.ability.TaskRobotMCPService$initToolHandlers$1$1$1$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements n {

        /* renamed from: a, reason: collision with root package name */
        public int f4000a;
        public final /* synthetic */ TaskRobotMcpTool b;
        public final /* synthetic */ TaskRobotMCPService c;
        public final /* synthetic */ McpSchema.CallToolRequest d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(H7.c cVar, TaskRobotMCPService taskRobotMCPService, TaskRobotMcpTool taskRobotMcpTool, McpSchema.CallToolRequest callToolRequest) {
            super(2, cVar);
            this.b = taskRobotMcpTool;
            this.c = taskRobotMCPService;
            this.d = callToolRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new AnonymousClass1(cVar, this.c, this.b, this.d);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        /* JADX WARN: Type inference failed for: r5v2, types: [S7.o, kotlin.coroutines.jvm.internal.SuspendLambda] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f4000a;
            if (i == 0) {
                kotlin.b.b(obj);
                ?? r5 = this.b.b;
                a aVar = this.c.mdiAbility;
                if (aVar == null) {
                    k.n("mdiAbility");
                    throw null;
                }
                Map<String, Object> mapArguments = this.d.arguments();
                if (mapArguments == null) {
                    mapArguments = kotlin.collections.a.M();
                }
                this.f4000a = 1;
                obj = r5.invoke(aVar, mapArguments, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return Mono.just(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskRobotMCPService$initToolHandlers$1$1$1(H7.c cVar, TaskRobotMCPService taskRobotMCPService, TaskRobotMcpTool taskRobotMcpTool, McpSchema.CallToolRequest callToolRequest) {
        super(2, cVar);
        this.b = taskRobotMCPService;
        this.c = taskRobotMcpTool;
        this.d = callToolRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new TaskRobotMCPService$initToolHandlers$1$1$1(cVar, this.b, this.c, this.d);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((TaskRobotMCPService$initToolHandlers$1$1$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f3999a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return obj;
        }
        kotlin.b.b(obj);
        TaskRobotMCPService taskRobotMCPService = this.b;
        C1687E c1687eD = AbstractC1683A.d(taskRobotMCPService.scope, null, new AnonymousClass1(null, taskRobotMCPService, this.c, this.d), 3);
        this.f3999a = 1;
        Object objZ = c1687eD.z(this);
        return objZ == coroutineSingletons ? coroutineSingletons : objZ;
    }
}
