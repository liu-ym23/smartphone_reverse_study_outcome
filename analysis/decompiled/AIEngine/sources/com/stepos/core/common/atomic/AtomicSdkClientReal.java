package com.stepos.core.common.atomic;

import a6.d;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.appcompat.widget.y0;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.ability.ITaskListener;
import com.stepos.ability.bean.ExplainSnapshot;
import com.stepos.ability.bean.Task;
import com.stepos.ability.bean.TaskError;
import com.stepos.ability.bean.TaskUiInfo;
import com.stepos.ability.bean.ToolCallEvent;
import com.stepos.ability.common.TaskStatus;
import com.stepos.ability.sdk.client.f;
import com.stepos.core.common.atomic.AtomicDispatchResult;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.error.AIEngineError;
import com.stepos.core.ota.download.control.HysteresisStrategy;
import f.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import lb.n;
import mb.c;
import org.json.JSONArray;
import org.json.JSONObject;
import v5.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public final class AtomicSdkClientReal implements IAtomicSdkClient {
    public static final String EXECUTOR_ID = "stepos-ability";
    private static final long IDLE_RELEASE_DELAY_MS = 60000;
    private static final long LATE_ARRIVAL_RETENTION_MS = 60000;
    private static final String TAG = "AtomicSdkClientReal";
    private static final long TIMEOUT_MS = 30000;
    private static final ScheduledExecutorService cleanupExecutor;
    private static final Object idleLock;
    private static volatile ScheduledFuture<?> idleReleaseFuture;
    private static final AtomicInteger inFlight;
    private static final AtomicSdkClientReal$Companion$taskListener$1 taskListener;
    private final String executorId = EXECUTOR_ID;
    public static final Companion Companion = new Companion(null);
    private static final ConcurrentHashMap<String, CompletableFuture<AtomicDispatchResult>> pending = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, CopyOnWriteArrayList<Object>> toolEventsCache = new ConcurrentHashMap<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[TaskStatus.values().length];
                try {
                    TaskStatus taskStatus = TaskStatus.f5558b;
                    iArr[4] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    TaskStatus taskStatus2 = TaskStatus.f5558b;
                    iArr[5] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    TaskStatus taskStatus3 = TaskStatus.f5558b;
                    iArr[6] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    TaskStatus taskStatus4 = TaskStatus.f5558b;
                    iArr[7] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void beginRequest() {
            AtomicSdkClientReal.inFlight.incrementAndGet();
            synchronized (AtomicSdkClientReal.idleLock) {
                try {
                    ScheduledFuture scheduledFuture = AtomicSdkClientReal.idleReleaseFuture;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    AtomicSdkClientReal.idleReleaseFuture = null;
                    n nVar = n.f10413a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private final String buildResultJson(Task task) {
            Object objA;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("task", objectToJson(task));
                CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) AtomicSdkClientReal.toolEventsCache.get(task.getTaskId());
                if (copyOnWriteArrayList != null) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next());
                    }
                    n nVar = n.f10413a;
                    jSONObject.put("toolCallEvents", jSONArray);
                }
                objA = jSONObject.toString();
            } catch (Throwable th) {
                objA = c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                objA = h0.e.c("{\"taskId\":\"", task.getTaskId(), "\",\"_serializeError\":\"", thB.getMessage(), "\"}");
            }
            return (String) objA;
        }

        private final JSONObject bundleToJson(Bundle bundle) {
            Object objA;
            JSONObject jSONObject = new JSONObject();
            try {
                bundle.setClassLoader(AtomicSdkClientReal.class.getClassLoader());
                n nVar = n.f10413a;
            } catch (Throwable th) {
                c.a(th);
            }
            try {
                for (String str : bundle.keySet()) {
                    try {
                        objA = bundle.get(str);
                    } catch (Throwable th2) {
                        objA = c.a(th2);
                    }
                    Throwable thB = Result.b(objA);
                    if (thB != null) {
                        objA = "<unparcel failed: " + thB.getClass().getSimpleName() + ">";
                    }
                    jSONObject.put(str, jsonValue(objA));
                }
                n nVar2 = n.f10413a;
            } catch (Throwable th3) {
                c.a(th3);
            }
            return jSONObject;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void endRequest() {
            if (AtomicSdkClientReal.inFlight.decrementAndGet() > 0) {
                return;
            }
            scheduleIdleRelease();
        }

        private final Object jsonValue(Object obj) {
            Object objA;
            if (obj == null) {
                Object NULL = JSONObject.NULL;
                g.e(NULL, "NULL");
                return NULL;
            }
            if (obj instanceof Bundle) {
                return bundleToJson((Bundle) obj);
            }
            if ((obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Short) || (obj instanceof Byte)) {
                return obj;
            }
            String string = obj.toString();
            try {
                objA = new JSONObject(string);
            } catch (Throwable th) {
                objA = c.a(th);
            }
            if (Result.b(objA) != null) {
                try {
                    objA = new JSONArray(string);
                } catch (Throwable th2) {
                    objA = c.a(th2);
                }
            }
            return Result.b(objA) == null ? objA : string;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final AtomicDispatchResult mapTaskStatusToResult(Task task) {
            Object next;
            String string;
            mb.c cVar = (mb.c) TaskStatus.f5563k;
            cVar.getClass();
            c.b bVar = new c.b();
            while (true) {
                if (!bVar.hasNext()) {
                    next = null;
                    break;
                }
                next = bVar.next();
                if (((TaskStatus) next).f5564a == task.getStatus()) {
                    break;
                }
            }
            TaskStatus taskStatus = (TaskStatus) next;
            if (taskStatus != null) {
                int iOrdinal = taskStatus.ordinal();
                if (iOrdinal == 4) {
                    return new AtomicDispatchResult(AtomicSdkClientReal.EXECUTOR_ID, AtomicDispatchResult.Status.SUCCESS, 0, null, buildResultJson(task), 0L, 44, null);
                }
                if (iOrdinal == 5) {
                    AtomicDispatchResult.Status status = AtomicDispatchResult.Status.FAILED;
                    TaskError error = task.getError();
                    if (error == null || (string = error.toString()) == null) {
                        string = "task failed";
                    }
                    return new AtomicDispatchResult(AtomicSdkClientReal.EXECUTOR_ID, status, AIEngineError.INFERENCE_FAILED, string, buildResultJson(task), 0L, 32, null);
                }
                if (iOrdinal == 6 || iOrdinal == 7) {
                    AtomicDispatchResult.Status status2 = AtomicDispatchResult.Status.FAILED;
                    String lowerCase = taskStatus.name().toLowerCase(Locale.ROOT);
                    g.e(lowerCase, "toLowerCase(...)");
                    return new AtomicDispatchResult(AtomicSdkClientReal.EXECUTOR_ID, status2, -100, "task ".concat(lowerCase), null, 0L, 48, null);
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.Result$Failure] */
        /* JADX WARN: Type inference failed for: r0v3, types: [org.json.JSONObject] */
        public final Object objectToJson(Object obj) {
            Object objA;
            if (obj == null) {
                Object NULL = JSONObject.NULL;
                g.e(NULL, "NULL");
                return NULL;
            }
            try {
                objA = new JSONObject();
                for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                    if (superclass.equals(Object.class)) {
                        break;
                    }
                    kotlin.jvm.internal.a aVarO = b1.O(superclass.getDeclaredFields());
                    while (aVarO.hasNext()) {
                        Field field = (Field) aVarO.next();
                        if (!Modifier.isStatic(field.getModifiers())) {
                            field.setAccessible(true);
                            if (!objA.has(field.getName())) {
                                objA.put(field.getName(), jsonValue(field.get(obj)));
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            return Result.b(objA) == null ? objA : obj.toString();
        }

        private final void scheduleIdleRelease() {
            synchronized (AtomicSdkClientReal.idleLock) {
                try {
                    ScheduledFuture scheduledFuture = AtomicSdkClientReal.idleReleaseFuture;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    AtomicSdkClientReal.idleReleaseFuture = AtomicSdkClientReal.cleanupExecutor.schedule(new com.stepos.aicgroup.e(2), HysteresisStrategy.DEFAULT_DWELL_MS, TimeUnit.MILLISECONDS);
                    n nVar = n.f10413a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void scheduleIdleRelease$lambda$2$lambda$1() {
            if (AtomicSdkClientReal.inFlight.get() == 0) {
                AIEngineLogger.i(LogModule.ABILITY, AtomicSdkClientReal.TAG, "idle 60000ms, releasing AgentService binding");
                AtomicSdkBootstrap.INSTANCE.release();
            }
        }

        private Companion() {
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.stepos.core.common.atomic.AtomicSdkClientReal$Companion$taskListener$1] */
    static {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new d(8));
        g.e(scheduledExecutorServiceNewSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor(...)");
        cleanupExecutor = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        inFlight = new AtomicInteger(0);
        idleLock = new Object();
        taskListener = new ITaskListener.Stub() { // from class: com.stepos.core.common.atomic.AtomicSdkClientReal$Companion$taskListener$1
            @Override // com.stepos.ability.ITaskListener
            public void onTaskEvent(Task task) {
                Object next;
                String strG;
                AtomicDispatchResult atomicDispatchResultMapTaskStatusToResult;
                if (task == null) {
                    return;
                }
                mb.c cVar = (mb.c) TaskStatus.f5563k;
                cVar.getClass();
                c.b bVar = new c.b();
                while (true) {
                    if (!bVar.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = bVar.next();
                        if (((TaskStatus) next).f5564a == task.getStatus()) {
                            break;
                        }
                    }
                }
                TaskStatus taskStatus = (TaskStatus) next;
                if (taskStatus == null || (strG = taskStatus.name()) == null) {
                    strG = ai.onnxruntime.a.g(task.getStatus(), "UNKNOWN(", ")");
                }
                boolean zContainsKey = AtomicSdkClientReal.pending.containsKey(task.getTaskId());
                LogModule logModule = LogModule.ABILITY;
                StringBuilder sbM = com.stepos.core.ota.d.m("onTaskEvent: status=", strG, " matched=", " task=", zContainsKey);
                sbM.append(task);
                AIEngineLogger.d(logModule, "AtomicSdkClientReal", sbM.toString());
                if (zContainsKey && (atomicDispatchResultMapTaskStatusToResult = AtomicSdkClientReal.Companion.mapTaskStatusToResult(task)) != null) {
                    CompletableFuture completableFuture = (CompletableFuture) AtomicSdkClientReal.pending.get(task.getTaskId());
                    if (completableFuture != null) {
                        completableFuture.complete(atomicDispatchResultMapTaskStatusToResult);
                    }
                    AtomicSdkClientReal.toolEventsCache.remove(task.getTaskId());
                }
            }

            @Override // com.stepos.ability.ITaskListener
            public void onToolCallEvent(ToolCallEvent toolCallEvent) {
                Object objPutIfAbsent;
                if (toolCallEvent == null) {
                    return;
                }
                String simpleName = toolCallEvent.getClass().getSimpleName();
                boolean zContainsKey = AtomicSdkClientReal.pending.containsKey(toolCallEvent.getToolCallId());
                LogModule logModule = LogModule.ABILITY;
                StringBuilder sbM = com.stepos.core.ota.d.m("onToolCallEvent: kind=", simpleName, " matched=", " event=", zContainsKey);
                sbM.append(toolCallEvent);
                AIEngineLogger.d(logModule, "AtomicSdkClientReal", sbM.toString());
                if (zContainsKey) {
                    try {
                        ConcurrentHashMap concurrentHashMap = AtomicSdkClientReal.toolEventsCache;
                        String toolCallId = toolCallEvent.getToolCallId();
                        Object copyOnWriteArrayList = concurrentHashMap.get(toolCallId);
                        if (copyOnWriteArrayList == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(toolCallId, (copyOnWriteArrayList = new CopyOnWriteArrayList()))) != null) {
                            copyOnWriteArrayList = objPutIfAbsent;
                        }
                        ((CopyOnWriteArrayList) copyOnWriteArrayList).add(AtomicSdkClientReal.Companion.objectToJson(toolCallEvent));
                    } catch (Throwable th) {
                        kotlin.c.a(th);
                    }
                }
            }

            @Override // com.stepos.ability.ITaskListener
            public void onExplainUpdated(String str, ExplainSnapshot explainSnapshot) {
            }

            @Override // com.stepos.ability.ITaskListener
            public void onRequestRelaunch(String str, String str2, String str3) {
            }

            @Override // com.stepos.ability.ITaskListener
            public void onInfoDismissed(String str, String str2, String str3, String str4) {
            }

            @Override // com.stepos.ability.ITaskListener
            public void onPackageConflict(int i10, String str, String str2, String str3, String str4, String str5) {
            }

            @Override // com.stepos.ability.ITaskListener
            public void onInfoRequested(String str, String str2, String str3, String str4, String str5, long j10, String str6) {
            }
        };
    }

    private final Bundle buildExtra(AtomicDispatchRequest atomicDispatchRequest) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("handle_input_schema", true);
        Map<String, String> extras = atomicDispatchRequest.getExtras();
        if (extras != null) {
            for (Map.Entry<String, String> entry : extras.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread cleanupExecutor$lambda$9(Runnable runnable) {
        return com.stepos.core.ota.d.n(runnable, "AtomicSdkClientReal-cleanup", true);
    }

    private final AtomicDispatchResult dispatchInternal(AtomicDispatchRequest atomicDispatchRequest) {
        Object objA;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        LogModule logModule = LogModule.ABILITY;
        ConcurrentHashMap<String, CompletableFuture<AtomicDispatchResult>> concurrentHashMap = pending;
        AIEngineLogger.i(logModule, TAG, "dispatch ENTER pendingSize=" + concurrentHashMap.size());
        if (!AtomicSdkBootstrap.INSTANCE.ensureInitialized() || !ensureListenerRegistered()) {
            return new AtomicDispatchResult(getExecutorId(), AtomicDispatchResult.Status.UNAVAILABLE, AIEngineError.NOT_INITIALIZED, "AgentServiceClient not initialized or unavailable", null, SystemClock.elapsedRealtime() - jElapsedRealtime, 16, null);
        }
        String str = "sla-" + UUID.randomUUID();
        String strParamsToJson = paramsToJson(atomicDispatchRequest.getParams());
        CompletableFuture<AtomicDispatchResult> completableFuture = new CompletableFuture<>();
        concurrentHashMap.put(str, completableFuture);
        scheduleLateArrivalCleanup(str);
        String function = atomicDispatchRequest.getFunction();
        int size = concurrentHashMap.size();
        StringBuilder sbS = ai.onnxruntime.a.s("dispatch SUBMIT toolCallId=", str, " function=", function, " pendingSize=");
        sbS.append(size);
        AIEngineLogger.i(logModule, TAG, sbS.toString());
        if (atomicDispatchRequest.getExtras() != null) {
            AIEngineLogger.d(logModule, TAG, "dispatch extras=" + atomicDispatchRequest.getExtras());
        }
        try {
            com.stepos.ability.sdk.client.d dVar = com.stepos.ability.sdk.client.d.f5570a;
            f fVar = new f(atomicDispatchRequest.getFunction(), str, strParamsToJson, new com.stepos.ability.sdk.client.e(str, new TaskUiInfo("SLA: " + atomicDispatchRequest.getFunction(), "AIEngine SLA dispatch", atomicDispatchRequest.getText()), buildExtra(atomicDispatchRequest)));
            dVar.getClass();
            com.stepos.ability.sdk.client.d.d();
            b.b("SDK version=1.8");
            b.a("submitToolTask " + fVar);
            com.stepos.ability.sdk.client.d.b(new androidx.compose.runtime.g(fVar, 6));
            objA = Boolean.TRUE;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.ABILITY, TAG, ai.onnxruntime.a.k("submitToolTask threw: ", thB.getMessage()), thB);
        }
        Boolean bool = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = bool;
        }
        if (!((Boolean) objA).booleanValue()) {
            pending.remove(str);
            return new AtomicDispatchResult(getExecutorId(), AtomicDispatchResult.Status.UNAVAILABLE, AIEngineError.IPC_NOT_CONNECTED, "submitToolTask failed (service not bound or threw)", null, SystemClock.elapsedRealtime() - jElapsedRealtime, 16, null);
        }
        try {
            AtomicDispatchResult atomicDispatchResult = completableFuture.get(30000L, TimeUnit.MILLISECONDS);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            AIEngineLogger.i(LogModule.ABILITY, TAG, "dispatch SUCCESS toolCallId=" + str + " elapsedMs=" + jElapsedRealtime2 + " status=" + atomicDispatchResult.getStatus());
            return AtomicDispatchResult.copy$default(atomicDispatchResult, null, null, 0, null, null, jElapsedRealtime2, 31, null);
        } catch (TimeoutException unused) {
            long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            LogModule logModule2 = LogModule.ABILITY;
            StringBuilder sbL = com.stepos.core.ota.d.l("dispatch TIMEOUT toolCallId=", jElapsedRealtime3, str, " elapsedMs=");
            sbL.append(" (still tracking for late-arrival)");
            AIEngineLogger.w(logModule2, TAG, sbL.toString());
            return new AtomicDispatchResult(getExecutorId(), AtomicDispatchResult.Status.FAILED, AIEngineError.TIMEOUT, "atomic dispatch timeout after 30000ms", null, jElapsedRealtime3, 16, null);
        } catch (Throwable th2) {
            String executorId = getExecutorId();
            AtomicDispatchResult.Status status = AtomicDispatchResult.Status.FAILED;
            String message = th2.getMessage();
            if (message == null) {
                message = th2.getClass().getSimpleName();
            }
            return new AtomicDispatchResult(executorId, status, AIEngineError.UNKNOWN, message, null, SystemClock.elapsedRealtime() - jElapsedRealtime, 16, null);
        }
    }

    private final boolean ensureListenerRegistered() {
        Object objA;
        try {
            com.stepos.ability.sdk.client.d dVar = com.stepos.ability.sdk.client.d.f5570a;
            AtomicSdkClientReal$Companion$taskListener$1 atomicSdkClientReal$Companion$taskListener$1 = taskListener;
            dVar.getClass();
            com.stepos.ability.sdk.client.d.g(atomicSdkClientReal$Companion$taskListener$1);
            objA = Boolean.TRUE;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.e(LogModule.ABILITY, TAG, a0.a.k("registerTaskListener failed: ", thB.getMessage(), " — service likely unavailable"), thB);
            objA = Boolean.FALSE;
        }
        return ((Boolean) objA).booleanValue();
    }

    private final String paramsToJson(Map<String, String> map) {
        Object objA;
        try {
            g.d(map, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            objA = new JSONObject(map).toString();
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = "{}";
        }
        return (String) objA;
    }

    private final void scheduleLateArrivalCleanup(String str) {
        cleanupExecutor.schedule(new y0(str, 14), HysteresisStrategy.DEFAULT_DWELL_MS, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleLateArrivalCleanup$lambda$7(String str) {
        if (pending.remove(str) != null) {
            AIEngineLogger.w(LogModule.ABILITY, TAG, "late-arrival cleanup: no terminal event for " + str + " within 60000ms — dropping pending entry");
        }
    }

    @Override // com.stepos.core.common.atomic.IAtomicSdkClient
    public AtomicDispatchResult dispatch(AtomicDispatchRequest request) {
        g.f(request, "request");
        Companion companion = Companion;
        companion.beginRequest();
        try {
            AtomicDispatchResult atomicDispatchResultDispatchInternal = dispatchInternal(request);
            companion.endRequest();
            return atomicDispatchResultDispatchInternal;
        } catch (Throwable th) {
            Companion.endRequest();
            throw th;
        }
    }

    @Override // com.stepos.core.common.atomic.IAtomicSdkClient
    public String getExecutorId() {
        return this.executorId;
    }
}
