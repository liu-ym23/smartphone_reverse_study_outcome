package stepai.aios.guiagent.tracer;

import N9.j;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import va.InterfaceC2078a;
import wa.C2110a;
import wa.e;
import xa.InterfaceC2124a;
import za.c;
import za.d;
import za.g;
import za.i;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 >2\u00020\u0001:\u0002?>B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\nJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001f\u001a\u00020\u0017¢\u0006\u0004\b!\u0010\"J\u0013\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001c¢\u0006\u0004\b#\u0010\u001eJ\u001b\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00190\u001c2\u0006\u0010\u001f\u001a\u00020\u0017¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\b¢\u0006\u0004\b(\u0010\nJ\u001f\u0010*\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010)\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b*\u0010+J%\u0010/\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u00172\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00101R\"\u00104\u001a\u0010\u0012\f\u0012\n 3*\u0004\u0018\u00010\u00040\u0004028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010:\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006@"}, d2 = {"Lstepai/aios/guiagent/tracer/GuiTracerManager;", "", "Lwa/a;", "eventManager", "Lstepai/aios/guiagent/tracer/GuiTracerConfig;", "initialConfig", AppAgent.CONSTRUCT, "(Lwa/a;Lstepai/aios/guiagent/tracer/GuiTracerConfig;)V", "LC7/r;", "initializeIfNeeded", "()V", "newConfig", "updateConfig", "(Lstepai/aios/guiagent/tracer/GuiTracerConfig;)V", "shutdown", "", "isTracingEnabled", "()Z", "Lstepai/aios/guiagent/tracer/GuiTraceListener;", "listener", "addTraceListener", "(Lstepai/aios/guiagent/tracer/GuiTraceListener;)V", "removeTraceListener", "", "sessionId", "Lstepai/aios/guiagent/tracer/GuiTaskNodeTraceSnapshot;", "getTaskNodeTrace", "(Ljava/lang/String;)Lstepai/aios/guiagent/tracer/GuiTaskNodeTraceSnapshot;", "", "getAllTaskNodeTraces", "()Ljava/util/List;", "treeId", "Lstepai/aios/guiagent/tracer/GuiTaskTreeTraceSnapshot;", "getTaskTreeTrace", "(Ljava/lang/String;)Lstepai/aios/guiagent/tracer/GuiTaskTreeTraceSnapshot;", "getAllTaskTreeTraces", "getTaskTreeNodes", "(Ljava/lang/String;)Ljava/util/List;", "clearTaskTrace", "(Ljava/lang/String;)V", "clearAllTraces", "externalTraceId", "associateSessionToExternalTrace", "(Ljava/lang/String;Ljava/lang/String;)V", "stepId", "Lstepai/aios/guiagent/tracer/GuiStepScreenshotRef;", "screenshotRef", "onScreenshotCaptured", "(Ljava/lang/String;Ljava/lang/String;Lstepai/aios/guiagent/tracer/GuiStepScreenshotRef;)V", "Lwa/a;", "Ljava/util/concurrent/atomic/AtomicReference;", "kotlin.jvm.PlatformType", "configRef", "Ljava/util/concurrent/atomic/AtomicReference;", "Lstepai/aios/guiagent/tracer/GuiTaskTracer;", "taskTracer", "Lstepai/aios/guiagent/tracer/GuiTaskTracer;", "Lstepai/aios/guiagent/tracer/GuiTracerManager$TaskTraceListener;", "combinedListener", "Lstepai/aios/guiagent/tracer/GuiTracerManager$TaskTraceListener;", "initialized", "Z", "Companion", "TaskTraceListener", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GuiTracerManager {
    private static final String TAG = "GuiTracerManager";
    private final TaskTraceListener combinedListener;
    private final AtomicReference<GuiTracerConfig> configRef;
    private final C2110a eventManager;
    private volatile boolean initialized;
    private final GuiTaskTracer taskTracer;

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0012\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\"\u0010\u001dJ\u0017\u0010#\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b#\u0010\u0010J\u001f\u0010&\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u001f\u0010(\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b(\u0010'J\u001f\u0010)\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b)\u0010'J'\u0010*\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010%\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b*\u0010+J'\u0010.\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010%\u001a\u00020$2\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J'\u00100\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010%\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b0\u00101J\u001f\u00102\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b2\u0010'J\u001f\u00105\u001a\u00020\n2\u0006\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u001aH\u0016¢\u0006\u0004\b5\u00106J\u001f\u00107\u001a\u00020\n2\u0006\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u001aH\u0016¢\u0006\u0004\b7\u00106J\u0017\u00108\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b:\u00109R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010;R\u0016\u0010<\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006>"}, d2 = {"Lstepai/aios/guiagent/tracer/GuiTracerManager$TaskTraceListener;", "Lxa/a;", "Lva/a;", "Lstepai/aios/guiagent/tracer/GuiTaskTracer;", "taskTracer", "Lstepai/aios/guiagent/tracer/GuiTracerConfig;", "initialConfig", AppAgent.CONSTRUCT, "(Lstepai/aios/guiagent/tracer/GuiTaskTracer;Lstepai/aios/guiagent/tracer/GuiTracerConfig;)V", "newConfig", "LC7/r;", "updateConfig", "(Lstepai/aios/guiagent/tracer/GuiTracerConfig;)V", "Lza/i;", "taskInfo", "onTaskCreated", "(Lza/i;)V", "onTaskStarted", "Lza/c;", "progress", "onTaskRunning", "(Lza/i;Lza/c;)V", "Lza/d;", "result", "onTaskCompleted", "(Lza/i;Lza/d;)V", "", "reason", "onTaskCancelled", "(Lza/i;Ljava/lang/String;)V", "", "error", "onTaskFailed", "(Lza/i;Ljava/lang/Throwable;)V", "onTaskTakenOver", "onTaskRecoveredFromTakeover", "Lza/g;", "stepInfo", "onStepStarted", "(Lza/i;Lza/g;)V", "onStepExecuting", "onStepCompleted", "onStepFailed", "(Lza/i;Lza/g;Ljava/lang/Throwable;)V", "", "retryCount", "onStepRetrying", "(Lza/i;Lza/g;I)V", "onStepSkipped", "(Lza/i;Lza/g;Ljava/lang/String;)V", "onStepCancelled", "sessionId", "stepId", "beforeCapture", "(Ljava/lang/String;Ljava/lang/String;)V", "afterCapture", "afterPerformAccessibilityAction", "(Ljava/lang/String;)V", "beforePerformAccessibilityAction", "Lstepai/aios/guiagent/tracer/GuiTaskTracer;", "config", "Lstepai/aios/guiagent/tracer/GuiTracerConfig;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class TaskTraceListener implements InterfaceC2124a, InterfaceC2078a {
        private volatile GuiTracerConfig config;
        private final GuiTaskTracer taskTracer;

        public TaskTraceListener(GuiTaskTracer taskTracer, GuiTracerConfig initialConfig) {
            k.f(taskTracer, "taskTracer");
            k.f(initialConfig, "initialConfig");
            this.taskTracer = taskTracer;
            this.config = initialConfig;
        }

        @Override // va.InterfaceC2078a
        public void afterCapture(String sessionId, String stepId) {
            k.f(sessionId, "sessionId");
            k.f(stepId, "stepId");
        }

        @Override // va.InterfaceC2078a
        public void afterPerformAccessibilityAction(String reason) {
            k.f(reason, "reason");
        }

        @Override // va.InterfaceC2078a
        public void beforeCapture(String sessionId, String stepId) {
            k.f(sessionId, "sessionId");
            k.f(stepId, "stepId");
        }

        @Override // va.InterfaceC2078a
        public void beforePerformAccessibilityAction(String reason) {
            k.f(reason, "reason");
        }

        @Override // xa.InterfaceC2124a
        public void onStepCancelled(i taskInfo, g stepInfo) {
            k.f(taskInfo, "taskInfo");
            k.f(stepInfo, "stepInfo");
            this.taskTracer.onStepUpdated(taskInfo, stepInfo);
        }

        @Override // xa.InterfaceC2124a
        public void onStepCompleted(i taskInfo, g stepInfo) {
            k.f(taskInfo, "taskInfo");
            k.f(stepInfo, "stepInfo");
            this.taskTracer.onStepUpdated(taskInfo, stepInfo);
        }

        @Override // xa.InterfaceC2124a
        public void onStepExecuting(i taskInfo, g stepInfo) {
            k.f(taskInfo, "taskInfo");
            k.f(stepInfo, "stepInfo");
            this.taskTracer.onStepUpdated(taskInfo, stepInfo);
        }

        @Override // xa.InterfaceC2124a
        public void onStepFailed(i taskInfo, g stepInfo, Throwable error) throws Throwable {
            k.f(taskInfo, "taskInfo");
            k.f(stepInfo, "stepInfo");
            k.f(error, "error");
            this.taskTracer.onStepFailed(taskInfo, stepInfo, error);
        }

        @Override // xa.InterfaceC2124a
        public void onStepRetrying(i taskInfo, g stepInfo, int retryCount) {
            k.f(taskInfo, "taskInfo");
            k.f(stepInfo, "stepInfo");
            this.taskTracer.onStepUpdated(taskInfo, stepInfo);
        }

        public void onStepSkipped(i taskInfo, g stepInfo, String reason) {
            k.f(taskInfo, "taskInfo");
            k.f(stepInfo, "stepInfo");
            k.f(reason, "reason");
            this.taskTracer.onStepUpdated(taskInfo, stepInfo);
        }

        @Override // xa.InterfaceC2124a
        public void onStepStarted(i taskInfo, g stepInfo) {
            k.f(taskInfo, "taskInfo");
            k.f(stepInfo, "stepInfo");
            this.taskTracer.onStepUpdated(taskInfo, stepInfo);
        }

        @Override // xa.InterfaceC2124a
        public void onTaskCancelled(i taskInfo, String reason) {
            k.f(taskInfo, "taskInfo");
            k.f(reason, "reason");
            this.taskTracer.onTaskCancelled(taskInfo, reason);
        }

        @Override // xa.InterfaceC2124a
        public void onTaskCompleted(i taskInfo, d result) {
            k.f(taskInfo, "taskInfo");
            k.f(result, "result");
            this.taskTracer.onTaskCompleted(taskInfo, result);
        }

        @Override // xa.InterfaceC2124a
        public void onTaskCreated(i taskInfo) {
            k.f(taskInfo, "taskInfo");
            this.taskTracer.onTaskCreated(taskInfo);
        }

        @Override // xa.InterfaceC2124a
        public void onTaskFailed(i taskInfo, Throwable error) {
            k.f(taskInfo, "taskInfo");
            k.f(error, "error");
            this.taskTracer.onTaskFailed(taskInfo, error);
        }

        @Override // xa.InterfaceC2124a
        public void onTaskPaused(i taskInfo) {
            k.f(taskInfo, "taskInfo");
        }

        @Override // xa.InterfaceC2124a
        public void onTaskRecoveredFromTakeover(i taskInfo) {
            k.f(taskInfo, "taskInfo");
            this.taskTracer.onTaskRecovered(taskInfo);
        }

        @Override // xa.InterfaceC2124a
        public void onTaskRecoveryStarted(i taskInfo) {
            k.f(taskInfo, "taskInfo");
        }

        @Override // xa.InterfaceC2124a
        public void onTaskResumed(i taskInfo) {
            k.f(taskInfo, "taskInfo");
        }

        @Override // xa.InterfaceC2124a
        public void onTaskRunning(i taskInfo, c progress) {
            k.f(taskInfo, "taskInfo");
            k.f(progress, "progress");
            this.taskTracer.onTaskUpdated(taskInfo);
        }

        @Override // xa.InterfaceC2124a
        public void onTaskStarted(i taskInfo) {
            k.f(taskInfo, "taskInfo");
            this.taskTracer.onTaskUpdated(taskInfo);
        }

        @Override // xa.InterfaceC2124a
        public void onTaskTakenOver(i taskInfo, String reason) {
            k.f(taskInfo, "taskInfo");
            k.f(reason, "reason");
            this.taskTracer.onTaskTakenOver(taskInfo, reason);
        }

        public final void updateConfig(GuiTracerConfig newConfig) {
            k.f(newConfig, "newConfig");
            this.config = newConfig;
        }
    }

    public GuiTracerManager(C2110a eventManager, GuiTracerConfig initialConfig) {
        k.f(eventManager, "eventManager");
        k.f(initialConfig, "initialConfig");
        this.eventManager = eventManager;
        this.configRef = new AtomicReference<>(initialConfig);
        GuiTaskTracer guiTaskTracer = new GuiTaskTracer(initialConfig);
        this.taskTracer = guiTaskTracer;
        this.combinedListener = new TaskTraceListener(guiTaskTracer, initialConfig);
    }

    public final void addTraceListener(GuiTraceListener listener) {
        k.f(listener, "listener");
        this.taskTracer.addListener(listener);
    }

    public final void associateSessionToExternalTrace(String sessionId, String externalTraceId) {
        k.f(sessionId, "sessionId");
        this.taskTracer.associateWithExternalTrace(sessionId, externalTraceId);
    }

    public final void clearAllTraces() {
        this.taskTracer.clearAll();
    }

    public final void clearTaskTrace(String sessionId) {
        k.f(sessionId, "sessionId");
        this.taskTracer.clearTaskTrace(sessionId);
    }

    public final List<GuiTaskNodeTraceSnapshot> getAllTaskNodeTraces() {
        return this.taskTracer.getAllNodeTraces();
    }

    public final List<GuiTaskTreeTraceSnapshot> getAllTaskTreeTraces() {
        return this.taskTracer.getAllTaskTreeTraces();
    }

    public final GuiTaskNodeTraceSnapshot getTaskNodeTrace(String sessionId) {
        k.f(sessionId, "sessionId");
        return this.taskTracer.getTaskNodeTrace(sessionId);
    }

    public final List<GuiTaskNodeTraceSnapshot> getTaskTreeNodes(String treeId) {
        k.f(treeId, "treeId");
        return this.taskTracer.getNodesByTree(treeId);
    }

    public final GuiTaskTreeTraceSnapshot getTaskTreeTrace(String treeId) {
        k.f(treeId, "treeId");
        return this.taskTracer.getTaskTreeTrace(treeId);
    }

    public final void initializeIfNeeded() {
        if (!this.configRef.get().getEnabled() || this.initialized) {
            return;
        }
        e eVar = this.eventManager.c;
        TaskTraceListener listener = this.combinedListener;
        eVar.getClass();
        k.f(listener, "listener");
        eVar.f6861a.add(listener);
        e eVar2 = this.eventManager.c;
        TaskTraceListener callback = this.combinedListener;
        eVar2.getClass();
        k.f(callback, "callback");
        eVar2.b.add(callback);
        this.initialized = true;
        j.H("GuiTracerManager initialized", TAG);
    }

    public final boolean isTracingEnabled() {
        return this.initialized && this.configRef.get().getEnabled();
    }

    public final void onScreenshotCaptured(String sessionId, String stepId, GuiStepScreenshotRef screenshotRef) {
        k.f(sessionId, "sessionId");
        k.f(stepId, "stepId");
        k.f(screenshotRef, "screenshotRef");
        this.taskTracer.onScreenshotCaptured(sessionId, stepId, screenshotRef);
    }

    public final void removeTraceListener(GuiTraceListener listener) {
        k.f(listener, "listener");
        this.taskTracer.removeListener(listener);
    }

    public final void shutdown() {
        this.taskTracer.clearAll();
        if (this.initialized) {
            e eVar = this.eventManager.c;
            TaskTraceListener listener = this.combinedListener;
            eVar.getClass();
            k.f(listener, "listener");
            eVar.f6861a.remove(listener);
            e eVar2 = this.eventManager.c;
            TaskTraceListener callback = this.combinedListener;
            eVar2.getClass();
            k.f(callback, "callback");
            eVar2.b.remove(callback);
            this.initialized = false;
            j.H("GuiTracerManager shutdown", TAG);
        }
    }

    public final void updateConfig(GuiTracerConfig newConfig) {
        k.f(newConfig, "newConfig");
        GuiTracerConfig andSet = this.configRef.getAndSet(newConfig);
        this.taskTracer.updateConfig(newConfig);
        this.combinedListener.updateConfig(newConfig);
        if (!andSet.getEnabled() && newConfig.getEnabled()) {
            initializeIfNeeded();
        } else {
            if (!andSet.getEnabled() || newConfig.getEnabled()) {
                return;
            }
            shutdown();
        }
    }
}
