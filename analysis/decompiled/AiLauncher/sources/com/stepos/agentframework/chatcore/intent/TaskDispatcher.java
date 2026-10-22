package com.stepos.agentframework.chatcore.intent;

import android.content.Context;
import android.graphics.Bitmap;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ability.ITaskListener;
import com.stepos.ability.bean.ExplainSnapshot;
import com.stepos.ability.bean.ToolCallEvent;
import com.stepos.ability.common.TaskStatus;
import com.stepos.ability.sdk.client.AgentServiceClient;
import com.stepos.ability.sdk.client.GuiTaskConfig;
import h8.C4148a;
import java.util.HashMap;
import kotlin.C4848b;
import kotlin.Function2;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0019\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\r¢\u0006\u0004\b\u001e\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001f\u0010\u001cJ=\u0010%\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\r2\b\u0010\"\u001a\u0004\u0018\u00010\r2\b\u0010$\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\r8\u0002X\u0082D¢\u0006\u0006\n\u0004\b'\u0010(RH\u0010,\u001a6\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120*0)j\u001a\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120*`+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R0\u0010/\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020.0)j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020.`+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010-R\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00104\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0017\u00107\u001a\u0002068\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/stepos/agentframework/chatcore/intent/TaskDispatcher;", "", "<init>", "()V", "", "m", "()Z", "Landroid/content/Context;", "context", "LY8/t;", "p", "(Landroid/content/Context;)V", "u", "", "taskId", "Lcom/stepos/agentframework/chatcore/intent/j;", "k", "(Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/intent/j;", "Lcom/stepos/ability/sdk/client/r;", "l", "(Ljava/lang/String;)Lcom/stepos/ability/sdk/client/r;", "config", "v", "(Ljava/lang/String;Lcom/stepos/ability/sdk/client/r;)V", "callback", "s", "(Ljava/lang/String;Lcom/stepos/ability/sdk/client/r;Lcom/stepos/agentframework/chatcore/intent/j;)V", "q", "(Ljava/lang/String;)V", "toolCallId", "r", "w", "action", "taskName", "message", "Landroid/graphics/Bitmap;", "bitmap", "o", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;)V", "TAG", "Ljava/lang/String;", "Ljava/util/HashMap;", "Lkotlin/Pair;", "Lkotlin/collections/HashMap;", "submittedGuiHistory", "Ljava/util/HashMap;", "Lcom/stepos/agentframework/chatcore/intent/k;", "toolCallBackMap", "Lcom/stepos/agentframework/chatcore/intent/h;", "infoListener", "Lcom/stepos/agentframework/chatcore/intent/h;", "Lcom/stepos/agentframework/chatcore/intent/i;", "packageConflictListener", "Lcom/stepos/agentframework/chatcore/intent/i;", "Lcom/stepos/ability/ITaskListener$Stub;", "taskListener", "Lcom/stepos/ability/ITaskListener$Stub;", "getTaskListener", "()Lcom/stepos/ability/ITaskListener$Stub;", "Companion", Const.INTENT_KEY_APIKEY, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TaskDispatcher {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Y8.h<TaskDispatcher> instance$delegate = C4848b.a(LazyThreadSafetyMode.SYNCHRONIZED, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.intent.u
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return TaskDispatcher.n();
        }
    });
    private volatile h infoListener;
    private volatile i packageConflictListener;
    private final String TAG = "TaskDispatcher";
    private final HashMap<String, Pair<j, GuiTaskConfig>> submittedGuiHistory = new HashMap<>();
    private final HashMap<String, k> toolCallBackMap = new HashMap<>();
    private final ITaskListener.Stub taskListener = new ITaskListener.Stub() { // from class: com.stepos.agentframework.chatcore.intent.TaskDispatcher$taskListener$1
        @Override // com.stepos.ability.ITaskListener
        public void onExplainUpdated(String p02, ExplainSnapshot p12) {
        }

        @Override // com.stepos.ability.ITaskListener
        public void onInfoDismissed(String taskId, String requestId, String reason, String chatSessionId) {
            if (taskId == null || taskId.length() == 0 || requestId == null || requestId.length() == 0) {
                C4148a.u(this.this$0.TAG, "onInfoDismissed dropped: empty taskId/requestId reason=" + reason, false, 4, null);
                return;
            }
            TaskDispatcher.d(this.this$0);
            C4148a.u(this.this$0.TAG, "onInfoDismissed ignored: no infoListener set, taskId=" + taskId + " requestId=" + requestId, false, 4, null);
        }

        @Override // com.stepos.ability.ITaskListener
        public void onInfoRequested(String taskId, String requestId, String inputType, String message, String payloadJson, long timeoutMs, String chatSessionId) {
            if (taskId == null || taskId.length() == 0 || requestId == null || requestId.length() == 0) {
                C4148a.u(this.this$0.TAG, "onInfoRequested dropped: empty taskId/requestId", false, 4, null);
                return;
            }
            TaskDispatcher.d(this.this$0);
            C4148a.u(this.this$0.TAG, "onInfoRequested ignored: no infoListener set, taskId=" + taskId + " requestId=" + requestId, false, 4, null);
        }

        @Override // com.stepos.ability.ITaskListener
        public void onPackageConflict(int conflictKind, String newTaskId, String newTaskName, String runningTaskId, String packageName, String hint) {
            if (newTaskId == null || newTaskId.length() == 0 || packageName == null || packageName.length() == 0) {
                C4148a.u(this.this$0.TAG, "onPackageConflict dropped: empty newTaskId/packageName", false, 4, null);
                return;
            }
            TaskDispatcher.f(this.this$0);
            C4148a.u(this.this$0.TAG, "onPackageConflict ignored: no packageConflictListener set, newTaskId=" + newTaskId + " conflictKind=" + conflictKind + " packageName=" + packageName, false, 4, null);
        }

        @Override // com.stepos.ability.ITaskListener
        public void onRequestRelaunch(String taskId, String chatSessionId, String reason) {
            TaskDispatcher.f(this.this$0);
            C4148a.u(this.this$0.TAG, "onPackageConflict ignored: no packageConflictListener set, ", false, 4, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:62:0x013e  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0144  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0147  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x014d  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0150  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0156  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0159  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0167  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0182  */
        @Override // com.stepos.ability.ITaskListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onTaskEvent(com.stepos.ability.bean.Task r14) {
            /*
                Method dump skipped, instructions count: 404
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.intent.TaskDispatcher$taskListener$1.onTaskEvent(com.stepos.ability.bean.Task):void");
        }

        @Override // com.stepos.ability.ITaskListener
        public void onToolCallEvent(ToolCallEvent p02) {
        }

        public final String statusToAction(int status) {
            return status == TaskStatus.COMPLETED.getCode() ? J4.a.INSTANCE.d() : status == TaskStatus.FAILED.getCode() ? J4.a.INSTANCE.b() : status == TaskStatus.TAKE_OVER.getCode() ? J4.a.INSTANCE.m() : status == TaskStatus.CANCELLED.getCode() ? J4.a.INSTANCE.a() : status == TaskStatus.SCREEN_SHOT.getCode() ? J4.a.INSTANCE.k() : status == TaskStatus.EXPLAIN.getCode() ? J4.a.INSTANCE.c() : status == TaskStatus.LLM_TAKE_OVER.getCode() ? J4.a.INSTANCE.f() : status == TaskStatus.RECOVER_FROM_TAKEOVER.getCode() ? J4.a.INSTANCE.g() : J4.a.INSTANCE.l();
        }
    };

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R!\u0010\n\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/stepos/agentframework/chatcore/intent/TaskDispatcher$a;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/intent/TaskDispatcher;", "instance$delegate", "LY8/h;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/chatcore/intent/TaskDispatcher;", "getInstance$annotations", "instance", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.intent.TaskDispatcher$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final TaskDispatcher a() {
            return (TaskDispatcher) TaskDispatcher.instance$delegate.getValue();
        }

        public Companion() {
        }
    }

    public static final /* synthetic */ h d(TaskDispatcher taskDispatcher) {
        taskDispatcher.getClass();
        return null;
    }

    public static final /* synthetic */ i f(TaskDispatcher taskDispatcher) {
        taskDispatcher.getClass();
        return null;
    }

    public static final TaskDispatcher n() {
        return new TaskDispatcher();
    }

    public static final Y8.t t(String str, GuiTaskConfig guiTaskConfig) {
        AgentServiceClient.f22085a.r0(str, guiTaskConfig);
        return Y8.t.f7040a;
    }

    public static final Y8.t x(String str, GuiTaskConfig guiTaskConfig) {
        AgentServiceClient.f22085a.r0(str, guiTaskConfig);
        return Y8.t.f7040a;
    }

    public final j k(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        Pair<j, GuiTaskConfig> pair = this.submittedGuiHistory.get(taskId);
        if (pair != null) {
            return pair.e();
        }
        return null;
    }

    public final GuiTaskConfig l(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        Pair<j, GuiTaskConfig> pair = this.submittedGuiHistory.get(taskId);
        if (pair != null) {
            return pair.f();
        }
        return null;
    }

    public final boolean m() {
        return (this.submittedGuiHistory.isEmpty() && this.toolCallBackMap.isEmpty()) ? false : true;
    }

    public final void o(String taskId, String action, String taskName, String message, Bitmap bitmap) {
        J4.a aVar = J4.a.INSTANCE;
        if (kotlin.jvm.internal.p.d(action, aVar.k())) {
            if (bitmap == null) {
                return;
            }
            C4148a.k(this.TAG, "persistOrphanGuiTaskStatus: taskId=" + taskId + " action=screenshot, saving bitmap", false, 4, null);
            Function2.a(new TaskDispatcher$persistOrphanGuiTaskStatus$1(taskId, bitmap, taskName, null));
            return;
        }
        if (kotlin.jvm.internal.p.d(action, aVar.d()) || kotlin.jvm.internal.p.d(action, aVar.b()) || kotlin.jvm.internal.p.d(action, aVar.a())) {
            String str = kotlin.jvm.internal.p.d(action, aVar.d()) ? "complete" : kotlin.jvm.internal.p.d(action, aVar.b()) ? "fail" : "canceled";
            C4148a.k(this.TAG, "persistOrphanGuiTaskStatus: taskId=" + taskId + " action=" + action + " dbStatus=" + str, false, 4, null);
            Function2.a(new TaskDispatcher$persistOrphanGuiTaskStatus$2(taskId, str, action, message, taskName, null));
        }
    }

    public final void p(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        AgentServiceClient.f22085a.a0(this.taskListener);
    }

    public final void q(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        this.submittedGuiHistory.remove(taskId);
        d.INSTANCE.j();
    }

    public final void r(String toolCallId) {
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        this.toolCallBackMap.remove(toolCallId);
        d.INSTANCE.j();
    }

    public final void s(final String taskId, final GuiTaskConfig config, j callback) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(config, "config");
        kotlin.jvm.internal.p.i(callback, "callback");
        d dVar = d.INSTANCE;
        dVar.n(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.intent.v
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return TaskDispatcher.t(taskId, config);
            }
        });
        this.submittedGuiHistory.put(taskId, new Pair<>(callback, config));
        dVar.j();
    }

    public final void u(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        AgentServiceClient.f22085a.n0(this.taskListener);
    }

    public final void v(String taskId, GuiTaskConfig config) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(config, "config");
        Pair<j, GuiTaskConfig> pair = this.submittedGuiHistory.get(taskId);
        if (pair == null) {
            return;
        }
        this.submittedGuiHistory.put(taskId, Pair.d(pair, null, config, 1, null));
    }

    public final void w(final String taskId) {
        final GuiTaskConfig guiTaskConfigF;
        kotlin.jvm.internal.p.i(taskId, "taskId");
        C4148a.k(this.TAG, "reUpdateGuiTask: " + taskId, false, 4, null);
        Pair<j, GuiTaskConfig> pair = this.submittedGuiHistory.get(taskId);
        if (pair == null || (guiTaskConfigF = pair.f()) == null) {
            return;
        }
        C4148a.k(this.TAG, "reUpdateGuiTask: " + guiTaskConfigF.getSurface(), false, 4, null);
        d.INSTANCE.n(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.intent.w
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return TaskDispatcher.x(taskId, guiTaskConfigF);
            }
        });
    }
}
