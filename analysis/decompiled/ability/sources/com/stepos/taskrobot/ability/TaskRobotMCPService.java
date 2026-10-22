package com.stepos.taskrobot.ability;

import C7.r;
import J7.c;
import S7.n;
import Z5.e;
import android.content.Context;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.mcp.sdk.java.service.AbsMCPService;
import f6.AbstractC1436a;
import io.modelcontextprotocol.server.McpAsyncServerExchange;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import m9.r0;
import reactor.core.publisher.Mono;
import u9.d;
import z2.l;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0003R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/stepos/taskrobot/ability/TaskRobotMCPService;", "Lcom/stepos/mcp/sdk/java/service/AbsMCPService;", AppAgent.CONSTRUCT, "()V", "LC7/r;", "startStaleTaskCleanupIfEnabled", AppAgent.ON_CREATE, "initToolHandlers", "onServiceCleanup", "Lcom/stepos/taskrobot/ability/a;", "mdiAbility", "Lcom/stepos/taskrobot/ability/a;", "Lm9/z;", "scope", "Lm9/z;", "Companion", "Z5/e", "ability_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskRobotMCPService extends AbsMCPService {
    public static final e Companion = new e();
    private static final boolean STALE_TASK_CLEANUP_ENABLED = true;
    private static final long STALE_TASK_CLEANUP_INTERVAL_MS = 300000;
    private static final String TAG = "ability";
    private a mdiAbility;
    private final InterfaceC1733z scope;

    @c(c = "com.stepos.taskrobot.ability.TaskRobotMCPService$startStaleTaskCleanupIfEnabled$1", f = "TaskRobotMCPService.kt", l = {54}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.ability.TaskRobotMCPService$startStaleTaskCleanupIfEnabled$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {

        /* renamed from: a, reason: collision with root package name */
        public int f4001a;
        public /* synthetic */ Object b;

        public AnonymousClass1(H7.c cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            AnonymousClass1 anonymousClass1 = TaskRobotMCPService.this.new AnonymousClass1(cVar);
            anonymousClass1.b = obj;
            return anonymousClass1;
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x003a A[Catch: all -> 0x003f, TryCatch #0 {all -> 0x003f, blocks: (B:15:0x0034, B:17:0x003a, B:20:0x0041, B:21:0x0047), top: B:27:0x0034 }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0041 A[Catch: all -> 0x003f, TryCatch #0 {all -> 0x003f, blocks: (B:15:0x0034, B:17:0x003a, B:20:0x0041, B:21:0x0047), top: B:27:0x0034 }] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005a A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x002f -> B:14:0x0032). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = r7.b
                m9.z r0 = (m9.InterfaceC1733z) r0
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r2 = r7.f4001a
                C7.r r3 = C7.r.f317a
                r4 = 1
                if (r2 == 0) goto L1b
                if (r2 != r4) goto L13
                kotlin.b.b(r8)
                goto L32
            L13:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1b:
                kotlin.b.b(r8)
            L1e:
                boolean r8 = m9.AbstractC1683A.l(r0)
                if (r8 == 0) goto L5a
                r7.b = r0
                r7.f4001a = r4
                r5 = 300000(0x493e0, double:1.482197E-318)
                java.lang.Object r8 = kotlinx.coroutines.a.f(r5, r7)
                if (r8 != r1) goto L32
                return r1
            L32:
                com.stepos.taskrobot.ability.TaskRobotMCPService r8 = com.stepos.taskrobot.ability.TaskRobotMCPService.this
                com.stepos.taskrobot.ability.a r8 = com.stepos.taskrobot.ability.TaskRobotMCPService.access$getMdiAbility$p(r8)     // Catch: java.lang.Throwable -> L3f
                if (r8 == 0) goto L41
                r8.a()     // Catch: java.lang.Throwable -> L3f
                r8 = r3
                goto L4c
            L3f:
                r8 = move-exception
                goto L48
            L41:
                java.lang.String r8 = "mdiAbility"
                kotlin.jvm.internal.k.n(r8)     // Catch: java.lang.Throwable -> L3f
                r8 = 0
                throw r8     // Catch: java.lang.Throwable -> L3f
            L48:
                kotlin.Result$Failure r8 = kotlin.b.a(r8)
            L4c:
                java.lang.Throwable r8 = kotlin.Result.a(r8)
                if (r8 == 0) goto L1e
                java.lang.String r2 = "ability"
                java.lang.String r5 = "cleanupStaleTasks failed"
                f6.AbstractC1436a.c(r2, r5, r8)
                goto L1e
            L5a:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.ability.TaskRobotMCPService.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public TaskRobotMCPService() {
        r0 r0VarC = AbstractC1683A.c();
        d dVar = AbstractC1691I.f5315a;
        this.scope = AbstractC1683A.b(l.H(r0VarC, u9.c.f6743a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Mono initToolHandlers$lambda$0$0(TaskRobotMCPService taskRobotMCPService, TaskRobotMcpTool taskRobotMcpTool, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.CallToolRequest callToolRequest) {
        return (Mono) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new TaskRobotMCPService$initToolHandlers$1$1$1(null, taskRobotMCPService, taskRobotMcpTool, callToolRequest));
    }

    private final void startStaleTaskCleanupIfEnabled() {
        AbstractC1683A.n(this.scope, null, new AnonymousClass1(null), 3);
    }

    @Override // com.stepos.mcp.sdk.java.service.AbsMCPService
    public void initToolHandlers() {
        for (TaskRobotMcpTool taskRobotMcpTool : TaskRobotMcpTool.d) {
            this.mcpServer.addToolHandler(taskRobotMcpTool.f4002a, new Z5.d(this, taskRobotMcpTool, 0));
        }
        AbstractC1436a.d(TAG, "Registered " + TaskRobotMcpTool.d.size() + " MCP tools", true);
    }

    @Override // com.stepos.mcp.sdk.java.service.AbsMCPService, android.app.Service
    public void onCreate() throws Exception {
        super.onCreate();
        Context applicationContext = getApplicationContext();
        k.e(applicationContext, "getApplicationContext(...)");
        this.mdiAbility = Z5.b.f1595a.a(applicationContext);
        startStaleTaskCleanupIfEnabled();
    }

    @Override // com.stepos.mcp.sdk.java.service.AbsMCPService
    public void onServiceCleanup() {
        AbstractC1683A.e(this.scope, null);
        a aVar = this.mdiAbility;
        if (aVar != null) {
            for (Map.Entry entry : aVar.c.entrySet()) {
                String str = (String) entry.getKey();
                Z5.a aVar2 = (Z5.a) entry.getValue();
                if (aVar.d.contains(str)) {
                    AbstractC1436a.d(TAG, "cleanupAllTasks: skip protected task: " + str, true);
                } else {
                    try {
                        aVar2.f1594a.finish(true);
                    } catch (Throwable unused) {
                    }
                    aVar.c.remove(str);
                }
            }
            aVar.e = null;
        }
    }
}
