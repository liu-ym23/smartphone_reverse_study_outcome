package stepai.aios.guiagent.tracer;

import D7.v;
import D7.w;
import F7.a;
import N9.j;
import androidx.compose.foundation.b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.RequestInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.model.SessionState;
import za.d;
import za.g;
import za.i;

@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001W\b\u0000\u0018\u00002\u00020\u0001:\u0002]^B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0005J\u0015\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0011J\u001d\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001f\u0010\u001aJ\u0015\u0010 \u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b \u0010\u0011J\u001d\u0010#\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J%\u0010%\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b%\u0010&J%\u0010+\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u00172\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u001f\u0010.\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u0004\u0018\u0001002\u0006\u0010'\u001a\u00020\u0017¢\u0006\u0004\b1\u00102J\u0013\u00104\u001a\b\u0012\u0004\u0012\u00020003¢\u0006\u0004\b4\u00105J\u0017\u00108\u001a\u0004\u0018\u0001072\u0006\u00106\u001a\u00020\u0017¢\u0006\u0004\b8\u00109J\u0013\u0010:\u001a\b\u0012\u0004\u0012\u00020703¢\u0006\u0004\b:\u00105J\u001b\u0010;\u001a\b\u0012\u0004\u0012\u000200032\u0006\u00106\u001a\u00020\u0017¢\u0006\u0004\b;\u0010<J\u0015\u0010=\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0017¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020\u0007¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0007H\u0002¢\u0006\u0004\bA\u0010@J,\u0010E\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020\u00070BH\u0082\b¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\u00020C2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u0007H\u0002¢\u0006\u0004\bI\u0010@J\u0017\u0010L\u001a\u00020K2\u0006\u0010J\u001a\u00020CH\u0002¢\u0006\u0004\bL\u0010MJ\u0017\u0010O\u001a\u00020\u00072\u0006\u0010N\u001a\u00020KH\u0002¢\u0006\u0004\bO\u0010PJ\u0019\u0010Q\u001a\u0004\u0018\u0001072\u0006\u00106\u001a\u00020\u0017H\u0002¢\u0006\u0004\bQ\u00109J\u001d\u0010R\u001a\b\u0012\u0004\u0012\u000200032\u0006\u00106\u001a\u00020\u0017H\u0002¢\u0006\u0004\bR\u0010<R\"\u0010U\u001a\u0010\u0012\f\u0012\n T*\u0004\u0018\u00010\u00020\u00020S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020\t0Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\¨\u0006_"}, d2 = {"Lstepai/aios/guiagent/tracer/GuiTaskTracer;", "", "Lstepai/aios/guiagent/tracer/GuiTracerConfig;", "initialConfig", AppAgent.CONSTRUCT, "(Lstepai/aios/guiagent/tracer/GuiTracerConfig;)V", "newConfig", "LC7/r;", "updateConfig", "Lstepai/aios/guiagent/tracer/GuiTraceListener;", "listener", "addListener", "(Lstepai/aios/guiagent/tracer/GuiTraceListener;)V", "removeListener", "Lza/i;", "taskInfo", "onTaskCreated", "(Lza/i;)V", "onTaskUpdated", "Lza/d;", "result", "onTaskCompleted", "(Lza/i;Lza/d;)V", "", "reason", "onTaskCancelled", "(Lza/i;Ljava/lang/String;)V", "", "error", "onTaskFailed", "(Lza/i;Ljava/lang/Throwable;)V", "onTaskTakenOver", "onTaskRecovered", "Lza/g;", "stepInfo", "onStepUpdated", "(Lza/i;Lza/g;)V", "onStepFailed", "(Lza/i;Lza/g;Ljava/lang/Throwable;)V", "sessionId", "stepId", "Lstepai/aios/guiagent/tracer/GuiStepScreenshotRef;", "screenshotRef", "onScreenshotCaptured", "(Ljava/lang/String;Ljava/lang/String;Lstepai/aios/guiagent/tracer/GuiStepScreenshotRef;)V", "externalTraceId", "associateWithExternalTrace", "(Ljava/lang/String;Ljava/lang/String;)V", "Lstepai/aios/guiagent/tracer/GuiTaskNodeTraceSnapshot;", "getTaskNodeTrace", "(Ljava/lang/String;)Lstepai/aios/guiagent/tracer/GuiTaskNodeTraceSnapshot;", "", "getAllNodeTraces", "()Ljava/util/List;", "treeId", "Lstepai/aios/guiagent/tracer/GuiTaskTreeTraceSnapshot;", "getTaskTreeTrace", "(Ljava/lang/String;)Lstepai/aios/guiagent/tracer/GuiTaskTreeTraceSnapshot;", "getAllTaskTreeTraces", "getNodesByTree", "(Ljava/lang/String;)Ljava/util/List;", "clearTaskTrace", "(Ljava/lang/String;)V", "clearAll", "()V", "trimNodeTraces", "Lkotlin/Function1;", "Lstepai/aios/guiagent/tracer/GuiTaskTracer$InternalNodeTrace;", "block", "updateTrace", "(Lza/i;LS7/k;)V", "updateNodeTraceLocked", "(Lza/i;)Lstepai/aios/guiagent/tracer/GuiTaskTracer$InternalNodeTrace;", "trimNodeTracesLocked", "trace", "Lstepai/aios/guiagent/tracer/GuiTraceUpdate;", "createTraceUpdateLocked", "(Lstepai/aios/guiagent/tracer/GuiTaskTracer$InternalNodeTrace;)Lstepai/aios/guiagent/tracer/GuiTraceUpdate;", "update", "dispatchTraceUpdate", "(Lstepai/aios/guiagent/tracer/GuiTraceUpdate;)V", "buildTaskTreeTraceLocked", "snapshotNodesForTree", "Ljava/util/concurrent/atomic/AtomicReference;", "kotlin.jvm.PlatformType", "configRef", "Ljava/util/concurrent/atomic/AtomicReference;", "stepai/aios/guiagent/tracer/GuiTaskTracer$nodeTraces$1", "nodeTraces", "Lstepai/aios/guiagent/tracer/GuiTaskTracer$nodeTraces$1;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "InternalNodeTrace", "InternalStepTrace", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GuiTaskTracer {
    private final AtomicReference<GuiTracerConfig> configRef;
    private final CopyOnWriteArrayList<GuiTraceListener> listeners;
    private final GuiTaskTracer$nodeTraces$1 nodeTraces;

    public GuiTaskTracer(GuiTracerConfig initialConfig) {
        k.f(initialConfig, "initialConfig");
        this.configRef = new AtomicReference<>(initialConfig);
        this.nodeTraces = new GuiTaskTracer$nodeTraces$1(this);
        this.listeners = new CopyOnWriteArrayList<>();
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0177 A[EDGE_INSN: B:83:0x0177->B:84:0x0178 BREAK  A[LOOP:5: B:75:0x015d->B:123:0x015d]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final stepai.aios.guiagent.tracer.GuiTaskTreeTraceSnapshot buildTaskTreeTraceLocked(java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.tracer.GuiTaskTracer.buildTaskTreeTraceLocked(java.lang.String):stepai.aios.guiagent.tracer.GuiTaskTreeTraceSnapshot");
    }

    private final GuiTraceUpdate createTraceUpdateLocked(InternalNodeTrace trace) {
        String treeId;
        GuiTaskNodeTraceSnapshot guiTaskNodeTraceSnapshotSnapshot = trace.snapshot();
        GuiTaskNodeMetadata metadata = trace.getMetadata();
        return new GuiTraceUpdate(guiTaskNodeTraceSnapshotSnapshot, (metadata == null || (treeId = metadata.getTreeId()) == null) ? null : buildTaskTreeTraceLocked(treeId));
    }

    private final void dispatchTraceUpdate(GuiTraceUpdate update) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            try {
                ((GuiTraceListener) it.next()).onTraceUpdated(update);
            } catch (Exception unused) {
            }
        }
    }

    private final List<GuiTaskNodeTraceSnapshot> snapshotNodesForTree(String treeId) {
        a aVar = new a(new S7.k[]{new m5.a(22), new m5.a(23), new m5.a(24)}, 0);
        Collection<InternalNodeTrace> collectionValues = this.nodeTraces.values();
        k.e(collectionValues, "<get-values>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            GuiTaskNodeMetadata metadata = ((InternalNodeTrace) obj).getMetadata();
            if (k.b(metadata != null ? metadata.getTreeId() : null, treeId)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(w.c0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((InternalNodeTrace) it.next()).snapshot());
        }
        return v.Z0(arrayList2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable snapshotNodesForTree$lambda$0(GuiTaskNodeTraceSnapshot it) {
        Integer nodeIndex;
        k.f(it, "it");
        GuiTaskNodeMetadata nodeMetadata = it.getNodeMetadata();
        if (nodeMetadata == null || (nodeIndex = nodeMetadata.getNodeIndex()) == null) {
            return Integer.MAX_VALUE;
        }
        return nodeIndex;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable snapshotNodesForTree$lambda$1(GuiTaskNodeTraceSnapshot it) {
        k.f(it, "it");
        return Long.valueOf(it.getCreatedAt());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable snapshotNodesForTree$lambda$2(GuiTaskNodeTraceSnapshot it) {
        k.f(it, "it");
        return it.getSessionId();
    }

    private final void trimNodeTraces() {
        synchronized (this.nodeTraces) {
            trimNodeTracesLocked();
        }
    }

    private final void trimNodeTracesLocked() {
        Iterator<Map.Entry<String, InternalNodeTrace>> it = this.nodeTraces.entrySet().iterator();
        while (this.nodeTraces.size() > this.configRef.get().getMaxTaskTraces() && it.hasNext()) {
            Map.Entry<String, InternalNodeTrace> next = it.next();
            k.e(next, "next(...)");
            it.remove();
            TraceScreenshotStore.INSTANCE.deleteSession(next.getKey());
        }
    }

    private final InternalNodeTrace updateNodeTraceLocked(i taskInfo) {
        SessionState sessionState;
        String str;
        GuiTaskNodeMetadata guiTaskNodeMetadataExtractNodeMetadata = GuiTraceMetadataHelper.INSTANCE.extractNodeMetadata(taskInfo);
        String str2 = taskInfo.f7018a;
        SessionState sessionState2 = taskInfo.c;
        j.H("updateNodeTraceLocked: sessionId=" + str2 + ", state=" + sessionState2, "GuiTaskTracer");
        GuiTaskTracer$nodeTraces$1 guiTaskTracer$nodeTraces$1 = this.nodeTraces;
        String str3 = taskInfo.f7018a;
        InternalNodeTrace internalNodeTrace = guiTaskTracer$nodeTraces$1.get((Object) str3);
        if (internalNodeTrace == null) {
            sessionState = sessionState2;
            str = "GuiTaskTracer";
            InternalNodeTrace internalNodeTrace2 = new InternalNodeTrace(taskInfo.f7018a, taskInfo, 0L, 0L, null, null, null, guiTaskNodeMetadataExtractNodeMetadata, null, 380, null);
            guiTaskTracer$nodeTraces$1.put(str3, internalNodeTrace2);
            internalNodeTrace = internalNodeTrace2;
        } else {
            sessionState = sessionState2;
            str = "GuiTaskTracer";
        }
        InternalNodeTrace internalNodeTrace3 = internalNodeTrace;
        boolean zA = internalNodeTrace3.getTaskInfo().c.a();
        boolean zA2 = sessionState.a();
        if (!zA || zA2) {
            internalNodeTrace3.setTaskInfo(taskInfo);
            internalNodeTrace3.setUpdatedAt(System.currentTimeMillis());
            if (internalNodeTrace3.getMetadata() == null) {
                internalNodeTrace3.setMetadata(guiTaskNodeMetadataExtractNodeMetadata);
            }
        } else {
            i iVarA = i.a(internalNodeTrace3.getTaskInfo(), null, null, taskInfo.f, taskInfo.g, taskInfo.h, taskInfo.i, null, null, null, false, 65055);
            j.H("updateNodeTraceLocked: merge progress into terminal state: currentStep=" + taskInfo.f + ", totalSteps=" + taskInfo.g, str);
            internalNodeTrace3.setTaskInfo(iVarA);
            internalNodeTrace3.setUpdatedAt(System.currentTimeMillis());
        }
        trimNodeTracesLocked();
        return internalNodeTrace3;
    }

    private final void updateTrace(i taskInfo, S7.k block) {
        GuiTraceUpdate guiTraceUpdateCreateTraceUpdateLocked;
        synchronized (this.nodeTraces) {
            InternalNodeTrace internalNodeTraceUpdateNodeTraceLocked = updateNodeTraceLocked(taskInfo);
            block.invoke(internalNodeTraceUpdateNodeTraceLocked);
            guiTraceUpdateCreateTraceUpdateLocked = createTraceUpdateLocked(internalNodeTraceUpdateNodeTraceLocked);
        }
        dispatchTraceUpdate(guiTraceUpdateCreateTraceUpdateLocked);
    }

    public final void addListener(GuiTraceListener listener) {
        k.f(listener, "listener");
        this.listeners.addIfAbsent(listener);
    }

    public final void associateWithExternalTrace(String sessionId, String externalTraceId) {
        k.f(sessionId, "sessionId");
        synchronized (this.nodeTraces) {
            InternalNodeTrace internalNodeTrace = (InternalNodeTrace) this.nodeTraces.get((Object) sessionId);
            if (internalNodeTrace == null) {
                return;
            }
            internalNodeTrace.setExternalTraceId(externalTraceId);
            dispatchTraceUpdate(createTraceUpdateLocked(internalNodeTrace));
        }
    }

    public final void clearAll() {
        List<String> listF1;
        synchronized (this.nodeTraces) {
            Set<String> setKeySet = this.nodeTraces.keySet();
            k.e(setKeySet, "<get-keys>(...)");
            listF1 = v.f1(setKeySet);
            this.nodeTraces.clear();
        }
        for (String str : listF1) {
            TraceScreenshotStore traceScreenshotStore = TraceScreenshotStore.INSTANCE;
            k.c(str);
            traceScreenshotStore.deleteSession(str);
        }
    }

    public final void clearTaskTrace(String sessionId) {
        InternalNodeTrace internalNodeTrace;
        k.f(sessionId, "sessionId");
        synchronized (this.nodeTraces) {
            internalNodeTrace = (InternalNodeTrace) this.nodeTraces.remove((Object) sessionId);
        }
        if (internalNodeTrace != null) {
            TraceScreenshotStore.INSTANCE.deleteSession(sessionId);
        }
    }

    public final List<GuiTaskNodeTraceSnapshot> getAllNodeTraces() {
        ArrayList arrayList;
        synchronized (this.nodeTraces) {
            Collection<InternalNodeTrace> collectionValues = this.nodeTraces.values();
            k.e(collectionValues, "<get-values>(...)");
            Collection<InternalNodeTrace> collection = collectionValues;
            arrayList = new ArrayList(w.c0(collection, 10));
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(((InternalNodeTrace) it.next()).snapshot());
            }
        }
        return arrayList;
    }

    public final List<GuiTaskTreeTraceSnapshot> getAllTaskTreeTraces() {
        ArrayList arrayList;
        synchronized (this.nodeTraces) {
            try {
                Collection<InternalNodeTrace> collectionValues = this.nodeTraces.values();
                k.e(collectionValues, "<get-values>(...)");
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it = collectionValues.iterator();
                while (it.hasNext()) {
                    GuiTaskNodeMetadata metadata = ((InternalNodeTrace) it.next()).getMetadata();
                    String treeId = metadata != null ? metadata.getTreeId() : null;
                    if (treeId != null) {
                        arrayList2.add(treeId);
                    }
                }
                Set setJ1 = v.j1(arrayList2);
                arrayList = new ArrayList();
                Iterator it2 = setJ1.iterator();
                while (it2.hasNext()) {
                    GuiTaskTreeTraceSnapshot guiTaskTreeTraceSnapshotBuildTaskTreeTraceLocked = buildTaskTreeTraceLocked((String) it2.next());
                    if (guiTaskTreeTraceSnapshotBuildTaskTreeTraceLocked != null) {
                        arrayList.add(guiTaskTreeTraceSnapshotBuildTaskTreeTraceLocked);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public final List<GuiTaskNodeTraceSnapshot> getNodesByTree(String treeId) {
        List<GuiTaskNodeTraceSnapshot> listSnapshotNodesForTree;
        k.f(treeId, "treeId");
        synchronized (this.nodeTraces) {
            listSnapshotNodesForTree = snapshotNodesForTree(treeId);
        }
        return listSnapshotNodesForTree;
    }

    public final GuiTaskNodeTraceSnapshot getTaskNodeTrace(String sessionId) {
        GuiTaskNodeTraceSnapshot guiTaskNodeTraceSnapshotSnapshot;
        k.f(sessionId, "sessionId");
        synchronized (this.nodeTraces) {
            InternalNodeTrace internalNodeTrace = (InternalNodeTrace) this.nodeTraces.get((Object) sessionId);
            guiTaskNodeTraceSnapshotSnapshot = internalNodeTrace != null ? internalNodeTrace.snapshot() : null;
        }
        return guiTaskNodeTraceSnapshotSnapshot;
    }

    public final GuiTaskTreeTraceSnapshot getTaskTreeTrace(String treeId) {
        GuiTaskTreeTraceSnapshot guiTaskTreeTraceSnapshotBuildTaskTreeTraceLocked;
        k.f(treeId, "treeId");
        synchronized (this.nodeTraces) {
            guiTaskTreeTraceSnapshotBuildTaskTreeTraceLocked = buildTaskTreeTraceLocked(treeId);
        }
        return guiTaskTreeTraceSnapshotBuildTaskTreeTraceLocked;
    }

    public final void onScreenshotCaptured(String sessionId, String stepId, GuiStepScreenshotRef screenshotRef) {
        k.f(sessionId, "sessionId");
        k.f(stepId, "stepId");
        k.f(screenshotRef, "screenshotRef");
        synchronized (this.nodeTraces) {
            InternalNodeTrace internalNodeTrace = (InternalNodeTrace) this.nodeTraces.get((Object) sessionId);
            if (internalNodeTrace == null) {
                return;
            }
            internalNodeTrace.updateScreenshot(stepId, screenshotRef);
            dispatchTraceUpdate(createTraceUpdateLocked(internalNodeTrace));
        }
    }

    public final void onStepFailed(i taskInfo, g stepInfo, Throwable error) throws Throwable {
        GuiTaskTracer$nodeTraces$1 guiTaskTracer$nodeTraces$1;
        InternalNodeTrace internalNodeTraceUpdateNodeTraceLocked;
        String message;
        k.f(taskInfo, "taskInfo");
        k.f(stepInfo, "stepInfo");
        k.f(error, "error");
        GuiTaskTracer$nodeTraces$1 guiTaskTracer$nodeTraces$12 = this.nodeTraces;
        synchronized (guiTaskTracer$nodeTraces$12) {
            try {
                internalNodeTraceUpdateNodeTraceLocked = updateNodeTraceLocked(taskInfo);
                message = error.getMessage();
                if (message == null) {
                    message = stepInfo.f7016j;
                }
                guiTaskTracer$nodeTraces$1 = guiTaskTracer$nodeTraces$12;
            } catch (Throwable th) {
                th = th;
                guiTaskTracer$nodeTraces$1 = guiTaskTracer$nodeTraces$12;
            }
            try {
                internalNodeTraceUpdateNodeTraceLocked.updateStep(g.a(stepInfo, null, null, null, null, 0L, null, message, null, null, null, null, 63487), this.configRef.get().getMaxStepTracesPerTask());
                internalNodeTraceUpdateNodeTraceLocked.setLastErrorMessage(error.getMessage());
                GuiTraceUpdate guiTraceUpdateCreateTraceUpdateLocked = createTraceUpdateLocked(internalNodeTraceUpdateNodeTraceLocked);
                dispatchTraceUpdate(guiTraceUpdateCreateTraceUpdateLocked);
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public final void onStepUpdated(i taskInfo, g stepInfo) {
        GuiTraceUpdate guiTraceUpdateCreateTraceUpdateLocked;
        k.f(taskInfo, "taskInfo");
        k.f(stepInfo, "stepInfo");
        synchronized (this.nodeTraces) {
            InternalNodeTrace internalNodeTraceUpdateNodeTraceLocked = updateNodeTraceLocked(taskInfo);
            internalNodeTraceUpdateNodeTraceLocked.updateStep(stepInfo, this.configRef.get().getMaxStepTracesPerTask());
            guiTraceUpdateCreateTraceUpdateLocked = createTraceUpdateLocked(internalNodeTraceUpdateNodeTraceLocked);
        }
        dispatchTraceUpdate(guiTraceUpdateCreateTraceUpdateLocked);
    }

    public final void onTaskCancelled(i taskInfo, String reason) {
        GuiTraceUpdate guiTraceUpdateCreateTraceUpdateLocked;
        k.f(taskInfo, "taskInfo");
        k.f(reason, "reason");
        synchronized (this.nodeTraces) {
            InternalNodeTrace internalNodeTraceUpdateNodeTraceLocked = updateNodeTraceLocked(taskInfo);
            internalNodeTraceUpdateNodeTraceLocked.setLastErrorMessage(reason);
            guiTraceUpdateCreateTraceUpdateLocked = createTraceUpdateLocked(internalNodeTraceUpdateNodeTraceLocked);
        }
        dispatchTraceUpdate(guiTraceUpdateCreateTraceUpdateLocked);
    }

    public final void onTaskCompleted(i taskInfo, d result) {
        GuiTraceUpdate guiTraceUpdateCreateTraceUpdateLocked;
        k.f(taskInfo, "taskInfo");
        k.f(result, "result");
        j.H("onTaskCompleted: sessionId=" + taskInfo.f7018a + ", state=" + taskInfo.c, "GuiTaskTracer");
        synchronized (this.nodeTraces) {
            InternalNodeTrace internalNodeTraceUpdateNodeTraceLocked = updateNodeTraceLocked(taskInfo);
            internalNodeTraceUpdateNodeTraceLocked.setLastResult(result);
            internalNodeTraceUpdateNodeTraceLocked.setLastErrorMessage(null);
            guiTraceUpdateCreateTraceUpdateLocked = createTraceUpdateLocked(internalNodeTraceUpdateNodeTraceLocked);
        }
        dispatchTraceUpdate(guiTraceUpdateCreateTraceUpdateLocked);
        j.H("onTaskCompleted done: sessionId=" + taskInfo.f7018a, "GuiTaskTracer");
    }

    public final void onTaskCreated(i taskInfo) {
        k.f(taskInfo, "taskInfo");
        synchronized (this.nodeTraces) {
            updateNodeTraceLocked(taskInfo);
        }
    }

    public final void onTaskFailed(i taskInfo, Throwable error) {
        GuiTraceUpdate guiTraceUpdateCreateTraceUpdateLocked;
        k.f(taskInfo, "taskInfo");
        k.f(error, "error");
        synchronized (this.nodeTraces) {
            try {
                InternalNodeTrace internalNodeTraceUpdateNodeTraceLocked = updateNodeTraceLocked(taskInfo);
                String message = error.getMessage();
                if (message == null) {
                    message = "Unknown error";
                }
                internalNodeTraceUpdateNodeTraceLocked.setLastErrorMessage(message);
                guiTraceUpdateCreateTraceUpdateLocked = createTraceUpdateLocked(internalNodeTraceUpdateNodeTraceLocked);
            } catch (Throwable th) {
                throw th;
            }
        }
        dispatchTraceUpdate(guiTraceUpdateCreateTraceUpdateLocked);
    }

    public final void onTaskRecovered(i taskInfo) {
        GuiTraceUpdate guiTraceUpdateCreateTraceUpdateLocked;
        k.f(taskInfo, "taskInfo");
        synchronized (this.nodeTraces) {
            InternalNodeTrace internalNodeTraceUpdateNodeTraceLocked = updateNodeTraceLocked(taskInfo);
            internalNodeTraceUpdateNodeTraceLocked.setLastErrorMessage(null);
            guiTraceUpdateCreateTraceUpdateLocked = createTraceUpdateLocked(internalNodeTraceUpdateNodeTraceLocked);
        }
        dispatchTraceUpdate(guiTraceUpdateCreateTraceUpdateLocked);
    }

    public final void onTaskTakenOver(i taskInfo, String reason) {
        GuiTraceUpdate guiTraceUpdateCreateTraceUpdateLocked;
        k.f(taskInfo, "taskInfo");
        k.f(reason, "reason");
        synchronized (this.nodeTraces) {
            InternalNodeTrace internalNodeTraceUpdateNodeTraceLocked = updateNodeTraceLocked(taskInfo);
            internalNodeTraceUpdateNodeTraceLocked.setLastErrorMessage(reason);
            guiTraceUpdateCreateTraceUpdateLocked = createTraceUpdateLocked(internalNodeTraceUpdateNodeTraceLocked);
        }
        dispatchTraceUpdate(guiTraceUpdateCreateTraceUpdateLocked);
    }

    public final void onTaskUpdated(i taskInfo) {
        k.f(taskInfo, "taskInfo");
        synchronized (this.nodeTraces) {
            updateNodeTraceLocked(taskInfo);
        }
    }

    public final void removeListener(GuiTraceListener listener) {
        k.f(listener, "listener");
        this.listeners.remove(listener);
    }

    public final void updateConfig(GuiTracerConfig newConfig) {
        k.f(newConfig, "newConfig");
        this.configRef.set(newConfig);
        trimNodeTraces();
        synchronized (this.nodeTraces) {
            Collection<InternalNodeTrace> collectionValues = this.nodeTraces.values();
            k.e(collectionValues, "<get-values>(...)");
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                ((InternalNodeTrace) it.next()).trimSteps(newConfig.getMaxStepTracesPerTask());
            }
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018JD\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0011J\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010'\u001a\u0004\b(\u0010\u0015R\"\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010'\u001a\u0004\b)\u0010\u0015\"\u0004\b*\u0010+R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010,\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010/¨\u00060"}, d2 = {"Lstepai/aios/guiagent/tracer/GuiTaskTracer$InternalStepTrace;", "", "", "stepId", "Lza/g;", "stepInfo", "", "createdAt", "updatedAt", "Lstepai/aios/guiagent/tracer/GuiStepScreenshotRef;", "screenshotRef", AppAgent.CONSTRUCT, "(Ljava/lang/String;Lza/g;JJLstepai/aios/guiagent/tracer/GuiStepScreenshotRef;)V", "Lstepai/aios/guiagent/tracer/GuiNodeStepTraceSnapshot;", RequestInfo.FUNCTION_SNAPSHOT, "()Lstepai/aios/guiagent/tracer/GuiNodeStepTraceSnapshot;", "component1", "()Ljava/lang/String;", "component2", "()Lza/g;", "component3", "()J", "component4", "component5", "()Lstepai/aios/guiagent/tracer/GuiStepScreenshotRef;", "copy", "(Ljava/lang/String;Lza/g;JJLstepai/aios/guiagent/tracer/GuiStepScreenshotRef;)Lstepai/aios/guiagent/tracer/GuiTaskTracer$InternalStepTrace;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getStepId", "Lza/g;", "getStepInfo", "J", "getCreatedAt", "getUpdatedAt", "setUpdatedAt", "(J)V", "Lstepai/aios/guiagent/tracer/GuiStepScreenshotRef;", "getScreenshotRef", "setScreenshotRef", "(Lstepai/aios/guiagent/tracer/GuiStepScreenshotRef;)V", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class InternalStepTrace {
        private final long createdAt;
        private GuiStepScreenshotRef screenshotRef;
        private final String stepId;
        private final g stepInfo;
        private long updatedAt;

        public InternalStepTrace(String stepId, g stepInfo, long j5, long j6, GuiStepScreenshotRef guiStepScreenshotRef) {
            k.f(stepId, "stepId");
            k.f(stepInfo, "stepInfo");
            this.stepId = stepId;
            this.stepInfo = stepInfo;
            this.createdAt = j5;
            this.updatedAt = j6;
            this.screenshotRef = guiStepScreenshotRef;
        }

        public static /* synthetic */ InternalStepTrace copy$default(InternalStepTrace internalStepTrace, String str, g gVar, long j5, long j6, GuiStepScreenshotRef guiStepScreenshotRef, int i, Object obj) {
            if ((i & 1) != 0) {
                str = internalStepTrace.stepId;
            }
            if ((i & 2) != 0) {
                gVar = internalStepTrace.stepInfo;
            }
            if ((i & 4) != 0) {
                j5 = internalStepTrace.createdAt;
            }
            if ((i & 8) != 0) {
                j6 = internalStepTrace.updatedAt;
            }
            if ((i & 16) != 0) {
                guiStepScreenshotRef = internalStepTrace.screenshotRef;
            }
            GuiStepScreenshotRef guiStepScreenshotRef2 = guiStepScreenshotRef;
            long j10 = j6;
            return internalStepTrace.copy(str, gVar, j5, j10, guiStepScreenshotRef2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getStepId() {
            return this.stepId;
        }

        /* renamed from: component2, reason: from getter */
        public final g getStepInfo() {
            return this.stepInfo;
        }

        /* renamed from: component3, reason: from getter */
        public final long getCreatedAt() {
            return this.createdAt;
        }

        /* renamed from: component4, reason: from getter */
        public final long getUpdatedAt() {
            return this.updatedAt;
        }

        /* renamed from: component5, reason: from getter */
        public final GuiStepScreenshotRef getScreenshotRef() {
            return this.screenshotRef;
        }

        public final InternalStepTrace copy(String stepId, g stepInfo, long createdAt, long updatedAt, GuiStepScreenshotRef screenshotRef) {
            k.f(stepId, "stepId");
            k.f(stepInfo, "stepInfo");
            return new InternalStepTrace(stepId, stepInfo, createdAt, updatedAt, screenshotRef);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InternalStepTrace)) {
                return false;
            }
            InternalStepTrace internalStepTrace = (InternalStepTrace) other;
            return k.b(this.stepId, internalStepTrace.stepId) && k.b(this.stepInfo, internalStepTrace.stepInfo) && this.createdAt == internalStepTrace.createdAt && this.updatedAt == internalStepTrace.updatedAt && k.b(this.screenshotRef, internalStepTrace.screenshotRef);
        }

        public final long getCreatedAt() {
            return this.createdAt;
        }

        public final GuiStepScreenshotRef getScreenshotRef() {
            return this.screenshotRef;
        }

        public final String getStepId() {
            return this.stepId;
        }

        public final g getStepInfo() {
            return this.stepInfo;
        }

        public final long getUpdatedAt() {
            return this.updatedAt;
        }

        public int hashCode() {
            int iC = androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c((this.stepInfo.hashCode() + (this.stepId.hashCode() * 31)) * 31, 31, this.createdAt), 31, this.updatedAt);
            GuiStepScreenshotRef guiStepScreenshotRef = this.screenshotRef;
            return iC + (guiStepScreenshotRef == null ? 0 : guiStepScreenshotRef.hashCode());
        }

        public final void setScreenshotRef(GuiStepScreenshotRef guiStepScreenshotRef) {
            this.screenshotRef = guiStepScreenshotRef;
        }

        public final void setUpdatedAt(long j5) {
            this.updatedAt = j5;
        }

        public final GuiNodeStepTraceSnapshot snapshot() {
            String str = this.stepId;
            g gVar = this.stepInfo;
            GuiStepScreenshotRef guiStepScreenshotRef = this.screenshotRef;
            long j5 = this.updatedAt;
            Object obj = gVar.n.get("model_trace_id");
            String str2 = obj instanceof String ? (String) obj : null;
            if (str2 == null) {
                str2 = "";
            }
            return new GuiNodeStepTraceSnapshot(str, gVar, guiStepScreenshotRef, j5, str2);
        }

        public String toString() {
            String str = this.stepId;
            g gVar = this.stepInfo;
            long j5 = this.createdAt;
            long j6 = this.updatedAt;
            GuiStepScreenshotRef guiStepScreenshotRef = this.screenshotRef;
            StringBuilder sb = new StringBuilder("InternalStepTrace(stepId=");
            sb.append(str);
            sb.append(", stepInfo=");
            sb.append(gVar);
            sb.append(", createdAt=");
            sb.append(j5);
            b.y(j6, ", updatedAt=", ", screenshotRef=", sb);
            sb.append(guiStepScreenshotRef);
            sb.append(")");
            return sb.toString();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ InternalStepTrace(String str, g gVar, long j5, long j6, GuiStepScreenshotRef guiStepScreenshotRef, int i, e eVar) {
            long jCurrentTimeMillis = (i & 4) != 0 ? System.currentTimeMillis() : j5;
            this(str, gVar, jCurrentTimeMillis, (i & 8) != 0 ? jCurrentTimeMillis : j6, (i & 16) != 0 ? null : guiStepScreenshotRef);
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0082\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b \u0010!J\r\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b+\u0010*J\u0012\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b,\u0010-J\u0012\u0010.\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b.\u0010&J\u0012\u0010/\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b/\u0010&J\u0012\u00100\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b0\u00101J\u001c\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003¢\u0006\u0004\b2\u00103J~\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0001¢\u0006\u0004\b4\u00105J\u0010\u00106\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b6\u0010&J\u0010\u00107\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b7\u00108J\u001a\u0010;\u001a\u00020:2\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b;\u0010<R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010=\u001a\u0004\b>\u0010&R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010?\u001a\u0004\b@\u0010(\"\u0004\bA\u0010BR\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010C\u001a\u0004\bD\u0010*\"\u0004\bE\u0010FR\"\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010C\u001a\u0004\bG\u0010*\"\u0004\bH\u0010FR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010I\u001a\u0004\bJ\u0010-\"\u0004\bK\u0010LR$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010=\u001a\u0004\bM\u0010&\"\u0004\bN\u0010OR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010=\u001a\u0004\bP\u0010&\"\u0004\bQ\u0010OR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010R\u001a\u0004\bS\u00101\"\u0004\bT\u0010UR#\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010V\u001a\u0004\bW\u00103¨\u0006X"}, d2 = {"Lstepai/aios/guiagent/tracer/GuiTaskTracer$InternalNodeTrace;", "", "", "sessionId", "Lza/i;", "taskInfo", "", "createdAt", "updatedAt", "Lza/d;", "lastResult", "lastErrorMessage", "externalTraceId", "Lstepai/aios/guiagent/tracer/GuiTaskNodeMetadata;", "metadata", "Ljava/util/LinkedHashMap;", "Lstepai/aios/guiagent/tracer/GuiTaskTracer$InternalStepTrace;", "steps", AppAgent.CONSTRUCT, "(Ljava/lang/String;Lza/i;JJLza/d;Ljava/lang/String;Ljava/lang/String;Lstepai/aios/guiagent/tracer/GuiTaskNodeMetadata;Ljava/util/LinkedHashMap;)V", "Lza/g;", "stepInfo", "", "maxSteps", "LC7/r;", "updateStep", "(Lza/g;I)V", "stepId", "Lstepai/aios/guiagent/tracer/GuiStepScreenshotRef;", "screenshotRef", "updateScreenshot", "(Ljava/lang/String;Lstepai/aios/guiagent/tracer/GuiStepScreenshotRef;)V", "trimSteps", "(I)V", "Lstepai/aios/guiagent/tracer/GuiTaskNodeTraceSnapshot;", RequestInfo.FUNCTION_SNAPSHOT, "()Lstepai/aios/guiagent/tracer/GuiTaskNodeTraceSnapshot;", "component1", "()Ljava/lang/String;", "component2", "()Lza/i;", "component3", "()J", "component4", "component5", "()Lza/d;", "component6", "component7", "component8", "()Lstepai/aios/guiagent/tracer/GuiTaskNodeMetadata;", "component9", "()Ljava/util/LinkedHashMap;", "copy", "(Ljava/lang/String;Lza/i;JJLza/d;Ljava/lang/String;Ljava/lang/String;Lstepai/aios/guiagent/tracer/GuiTaskNodeMetadata;Ljava/util/LinkedHashMap;)Lstepai/aios/guiagent/tracer/GuiTaskTracer$InternalNodeTrace;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "Lza/i;", "getTaskInfo", "setTaskInfo", "(Lza/i;)V", "J", "getCreatedAt", "setCreatedAt", "(J)V", "getUpdatedAt", "setUpdatedAt", "Lza/d;", "getLastResult", "setLastResult", "(Lza/d;)V", "getLastErrorMessage", "setLastErrorMessage", "(Ljava/lang/String;)V", "getExternalTraceId", "setExternalTraceId", "Lstepai/aios/guiagent/tracer/GuiTaskNodeMetadata;", "getMetadata", "setMetadata", "(Lstepai/aios/guiagent/tracer/GuiTaskNodeMetadata;)V", "Ljava/util/LinkedHashMap;", "getSteps", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class InternalNodeTrace {
        private long createdAt;
        private String externalTraceId;
        private String lastErrorMessage;
        private d lastResult;
        private GuiTaskNodeMetadata metadata;
        private final String sessionId;
        private final LinkedHashMap<String, InternalStepTrace> steps;
        private i taskInfo;
        private long updatedAt;

        public InternalNodeTrace(String sessionId, i taskInfo, long j5, long j6, d dVar, String str, String str2, GuiTaskNodeMetadata guiTaskNodeMetadata, LinkedHashMap<String, InternalStepTrace> steps) {
            k.f(sessionId, "sessionId");
            k.f(taskInfo, "taskInfo");
            k.f(steps, "steps");
            this.sessionId = sessionId;
            this.taskInfo = taskInfo;
            this.createdAt = j5;
            this.updatedAt = j6;
            this.lastResult = dVar;
            this.lastErrorMessage = str;
            this.externalTraceId = str2;
            this.metadata = guiTaskNodeMetadata;
            this.steps = steps;
        }

        public static /* synthetic */ InternalNodeTrace copy$default(InternalNodeTrace internalNodeTrace, String str, i iVar, long j5, long j6, d dVar, String str2, String str3, GuiTaskNodeMetadata guiTaskNodeMetadata, LinkedHashMap linkedHashMap, int i, Object obj) {
            if ((i & 1) != 0) {
                str = internalNodeTrace.sessionId;
            }
            if ((i & 2) != 0) {
                iVar = internalNodeTrace.taskInfo;
            }
            if ((i & 4) != 0) {
                j5 = internalNodeTrace.createdAt;
            }
            if ((i & 8) != 0) {
                j6 = internalNodeTrace.updatedAt;
            }
            if ((i & 16) != 0) {
                dVar = internalNodeTrace.lastResult;
            }
            if ((i & 32) != 0) {
                str2 = internalNodeTrace.lastErrorMessage;
            }
            if ((i & 64) != 0) {
                str3 = internalNodeTrace.externalTraceId;
            }
            if ((i & 128) != 0) {
                guiTaskNodeMetadata = internalNodeTrace.metadata;
            }
            if ((i & 256) != 0) {
                linkedHashMap = internalNodeTrace.steps;
            }
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            String str4 = str3;
            d dVar2 = dVar;
            long j10 = j6;
            long j11 = j5;
            return internalNodeTrace.copy(str, iVar, j11, j10, dVar2, str2, str4, guiTaskNodeMetadata, linkedHashMap2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: component2, reason: from getter */
        public final i getTaskInfo() {
            return this.taskInfo;
        }

        /* renamed from: component3, reason: from getter */
        public final long getCreatedAt() {
            return this.createdAt;
        }

        /* renamed from: component4, reason: from getter */
        public final long getUpdatedAt() {
            return this.updatedAt;
        }

        /* renamed from: component5, reason: from getter */
        public final d getLastResult() {
            return this.lastResult;
        }

        /* renamed from: component6, reason: from getter */
        public final String getLastErrorMessage() {
            return this.lastErrorMessage;
        }

        /* renamed from: component7, reason: from getter */
        public final String getExternalTraceId() {
            return this.externalTraceId;
        }

        /* renamed from: component8, reason: from getter */
        public final GuiTaskNodeMetadata getMetadata() {
            return this.metadata;
        }

        public final LinkedHashMap<String, InternalStepTrace> component9() {
            return this.steps;
        }

        public final InternalNodeTrace copy(String sessionId, i taskInfo, long createdAt, long updatedAt, d lastResult, String lastErrorMessage, String externalTraceId, GuiTaskNodeMetadata metadata, LinkedHashMap<String, InternalStepTrace> steps) {
            k.f(sessionId, "sessionId");
            k.f(taskInfo, "taskInfo");
            k.f(steps, "steps");
            return new InternalNodeTrace(sessionId, taskInfo, createdAt, updatedAt, lastResult, lastErrorMessage, externalTraceId, metadata, steps);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InternalNodeTrace)) {
                return false;
            }
            InternalNodeTrace internalNodeTrace = (InternalNodeTrace) other;
            return k.b(this.sessionId, internalNodeTrace.sessionId) && k.b(this.taskInfo, internalNodeTrace.taskInfo) && this.createdAt == internalNodeTrace.createdAt && this.updatedAt == internalNodeTrace.updatedAt && k.b(this.lastResult, internalNodeTrace.lastResult) && k.b(this.lastErrorMessage, internalNodeTrace.lastErrorMessage) && k.b(this.externalTraceId, internalNodeTrace.externalTraceId) && k.b(this.metadata, internalNodeTrace.metadata) && k.b(this.steps, internalNodeTrace.steps);
        }

        public final long getCreatedAt() {
            return this.createdAt;
        }

        public final String getExternalTraceId() {
            return this.externalTraceId;
        }

        public final String getLastErrorMessage() {
            return this.lastErrorMessage;
        }

        public final d getLastResult() {
            return this.lastResult;
        }

        public final GuiTaskNodeMetadata getMetadata() {
            return this.metadata;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final LinkedHashMap<String, InternalStepTrace> getSteps() {
            return this.steps;
        }

        public final i getTaskInfo() {
            return this.taskInfo;
        }

        public final long getUpdatedAt() {
            return this.updatedAt;
        }

        public int hashCode() {
            int iC = androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c((this.taskInfo.hashCode() + (this.sessionId.hashCode() * 31)) * 31, 31, this.createdAt), 31, this.updatedAt);
            d dVar = this.lastResult;
            int iHashCode = (iC + (dVar == null ? 0 : dVar.hashCode())) * 31;
            String str = this.lastErrorMessage;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.externalTraceId;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            GuiTaskNodeMetadata guiTaskNodeMetadata = this.metadata;
            return this.steps.hashCode() + ((iHashCode3 + (guiTaskNodeMetadata != null ? guiTaskNodeMetadata.hashCode() : 0)) * 31);
        }

        public final void setCreatedAt(long j5) {
            this.createdAt = j5;
        }

        public final void setExternalTraceId(String str) {
            this.externalTraceId = str;
        }

        public final void setLastErrorMessage(String str) {
            this.lastErrorMessage = str;
        }

        public final void setLastResult(d dVar) {
            this.lastResult = dVar;
        }

        public final void setMetadata(GuiTaskNodeMetadata guiTaskNodeMetadata) {
            this.metadata = guiTaskNodeMetadata;
        }

        public final void setTaskInfo(i iVar) {
            k.f(iVar, "<set-?>");
            this.taskInfo = iVar;
        }

        public final void setUpdatedAt(long j5) {
            this.updatedAt = j5;
        }

        public final GuiTaskNodeTraceSnapshot snapshot() {
            j.H("InternalNodeTrace.snapshot: sessionId=" + this.sessionId + ", taskInfo.state=" + this.taskInfo.c, "GuiTaskTracer");
            String str = this.sessionId;
            i iVar = this.taskInfo;
            Collection<InternalStepTrace> collectionValues = this.steps.values();
            k.e(collectionValues, "<get-values>(...)");
            Collection<InternalStepTrace> collection = collectionValues;
            ArrayList arrayList = new ArrayList(w.c0(collection, 10));
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(((InternalStepTrace) it.next()).snapshot());
            }
            return new GuiTaskNodeTraceSnapshot(str, iVar, arrayList, this.createdAt, this.updatedAt, this.lastResult, this.lastErrorMessage, this.externalTraceId, this.metadata);
        }

        public String toString() {
            String str = this.sessionId;
            i iVar = this.taskInfo;
            long j5 = this.createdAt;
            long j6 = this.updatedAt;
            d dVar = this.lastResult;
            String str2 = this.lastErrorMessage;
            String str3 = this.externalTraceId;
            GuiTaskNodeMetadata guiTaskNodeMetadata = this.metadata;
            LinkedHashMap<String, InternalStepTrace> linkedHashMap = this.steps;
            StringBuilder sb = new StringBuilder("InternalNodeTrace(sessionId=");
            sb.append(str);
            sb.append(", taskInfo=");
            sb.append(iVar);
            sb.append(", createdAt=");
            sb.append(j5);
            b.y(j6, ", updatedAt=", ", lastResult=", sb);
            sb.append(dVar);
            sb.append(", lastErrorMessage=");
            sb.append(str2);
            sb.append(", externalTraceId=");
            sb.append(str3);
            sb.append(", metadata=");
            sb.append(guiTaskNodeMetadata);
            sb.append(", steps=");
            sb.append(linkedHashMap);
            sb.append(")");
            return sb.toString();
        }

        public final void trimSteps(int maxSteps) {
            Iterator<Map.Entry<String, InternalStepTrace>> it = this.steps.entrySet().iterator();
            while (this.steps.size() > maxSteps && it.hasNext()) {
                Map.Entry<String, InternalStepTrace> next = it.next();
                k.e(next, "next(...)");
                it.remove();
                TraceScreenshotStore.INSTANCE.deleteScreenshot(next.getValue().getScreenshotRef());
            }
        }

        public final void updateScreenshot(String stepId, GuiStepScreenshotRef screenshotRef) {
            k.f(stepId, "stepId");
            k.f(screenshotRef, "screenshotRef");
            InternalStepTrace internalStepTrace = this.steps.get(stepId);
            if (internalStepTrace == null) {
                j.J("Screenshot ignored for missing step: ".concat(stepId), "GuiTaskTracer");
            } else {
                this.steps.put(stepId, InternalStepTrace.copy$default(internalStepTrace, null, null, 0L, System.currentTimeMillis(), screenshotRef, 7, null));
                this.updatedAt = System.currentTimeMillis();
            }
        }

        public final void updateStep(g stepInfo, int maxSteps) {
            g gVar;
            InternalStepTrace internalStepTrace;
            k.f(stepInfo, "stepInfo");
            LinkedHashMap<String, InternalStepTrace> linkedHashMap = this.steps;
            String str = stepInfo.f7015a;
            InternalStepTrace internalStepTrace2 = linkedHashMap.get(str);
            if (internalStepTrace2 != null) {
                gVar = stepInfo;
                internalStepTrace = InternalStepTrace.copy$default(internalStepTrace2, null, gVar, 0L, System.currentTimeMillis(), null, 21, null);
                if (internalStepTrace == null) {
                }
                this.steps.put(str, internalStepTrace);
                trimSteps(maxSteps);
                this.updatedAt = System.currentTimeMillis();
            }
            gVar = stepInfo;
            internalStepTrace = new InternalStepTrace(gVar.f7015a, gVar, 0L, 0L, null, 28, null);
            this.steps.put(str, internalStepTrace);
            trimSteps(maxSteps);
            this.updatedAt = System.currentTimeMillis();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ InternalNodeTrace(String str, i iVar, long j5, long j6, d dVar, String str2, String str3, GuiTaskNodeMetadata guiTaskNodeMetadata, LinkedHashMap linkedHashMap, int i, e eVar) {
            long jCurrentTimeMillis = (i & 4) != 0 ? System.currentTimeMillis() : j5;
            this(str, iVar, jCurrentTimeMillis, (i & 8) != 0 ? jCurrentTimeMillis : j6, (i & 16) != 0 ? null : dVar, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : guiTaskNodeMetadata, (i & 256) != 0 ? new LinkedHashMap() : linkedHashMap);
        }
    }
}
