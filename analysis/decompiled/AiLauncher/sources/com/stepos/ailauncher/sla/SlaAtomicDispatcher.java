package com.stepos.ailauncher.sla;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ability.ITaskListener;
import com.stepos.ability.bean.ExplainSnapshot;
import com.stepos.ability.bean.Task;
import com.stepos.ability.bean.TaskError;
import com.stepos.ability.bean.ToolCallEvent;
import com.stepos.ability.common.TaskStatus;
import com.stepos.ability.sdk.client.AgentServiceClient;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import com.stepos.core.download.ModelFlowMeta;
import h8.C4148a;
import h9.InterfaceC4149a;
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
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t*\u0001F\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001QB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ]\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000e2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001b\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001c\u0010\u0018J#\u0010\u001d\u001a\u00020\t2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000eH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ-\u0010 \u001a\u00020\u001f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\"\u0010#J\u0019\u0010&\u001a\u0004\u0018\u00010\u00132\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\t2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b(\u0010)J\u0019\u0010+\u001a\u00020\u00012\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b+\u0010,J\u0019\u0010-\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b-\u0010,J\u0017\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020\u001fH\u0002¢\u0006\u0004\b0\u00101R\u0014\u00102\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00104\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b4\u00103R\u0014\u00106\u001a\u0002058\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00108\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00103R\u0014\u00109\u001a\u0002058\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R&\u0010>\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130=0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R&\u0010A\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010@0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010?R\u001c\u0010D\u001a\n C*\u0004\u0018\u00010B0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010J\u001a\u00020I8\u0002X\u0082T¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020I8\u0002X\u0082T¢\u0006\u0006\n\u0004\bL\u0010KR\u0014\u0010M\u001a\u00020I8\u0002X\u0082T¢\u0006\u0006\n\u0004\bM\u0010KR\u0014\u0010N\u001a\u00020I8\u0002X\u0082T¢\u0006\u0006\n\u0004\bN\u0010KR\u0014\u0010O\u001a\u00020I8\u0002X\u0082T¢\u0006\u0006\n\u0004\bO\u0010KR\u0014\u0010P\u001a\u00020I8\u0002X\u0082T¢\u0006\u0006\n\u0004\bP\u0010K¨\u0006R"}, d2 = {"Lcom/stepos/ailauncher/sla/SlaAtomicDispatcher;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", "o", "(Landroid/content/Context;)V", "", "s", "()Ljava/lang/String;", "function", "text", "", "params", "extras", DidiCardProvider.KEY_TRACE_ID, "toolCallId", "Lcom/stepos/ailauncher/sla/SlaAtomicDispatcher$DispatchResult;", "k", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/sla/SlaAtomicDispatcher$DispatchResult;", "", "n", "()Z", "p", "(Landroid/content/Context;)Z", "m", "l", "u", "(Ljava/util/Map;)Ljava/lang/String;", "Landroid/os/Bundle;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/Map;Ljava/lang/String;)Landroid/os/Bundle;", "v", "(Ljava/lang/String;)V", "Lcom/stepos/ability/bean/Task;", "task", "r", "(Lcom/stepos/ability/bean/Task;)Lcom/stepos/ailauncher/sla/SlaAtomicDispatcher$DispatchResult;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ability/bean/Task;)Ljava/lang/String;", "obj", "t", "(Ljava/lang/Object;)Ljava/lang/Object;", "q", "bundle", "Lorg/json/JSONObject;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/os/Bundle;)Lorg/json/JSONObject;", "TAG", "Ljava/lang/String;", "EXECUTOR_ID", "", "TIMEOUT_MS", "J", "PERMISSION_ACCESS_AGENT_SERVICE", "LATE_RETENTION_MS", "appContext", "Landroid/content/Context;", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CompletableFuture;", AuthSessionDto.STATUS_PENDING, "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "toolEventsCache", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "cleanupExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "com/stepos/ailauncher/sla/SlaAtomicDispatcher$taskListener$1", "taskListener", "Lcom/stepos/ailauncher/sla/SlaAtomicDispatcher$taskListener$1;", "", "ERR_CANCELLED", "I", "ERR_TIMEOUT", "ERR_UNKNOWN", "ERR_NOT_INITIALIZED", "ERR_INFERENCE_FAILED", "ERR_IPC_NOT_CONNECTED", "DispatchResult", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SlaAtomicDispatcher {
    private static final int ERR_CANCELLED = -100;
    private static final int ERR_INFERENCE_FAILED = 220001;
    private static final int ERR_IPC_NOT_CONNECTED = 230001;
    private static final int ERR_NOT_INITIALIZED = 100007;
    private static final int ERR_TIMEOUT = -101;
    private static final int ERR_UNKNOWN = 100000;
    public static final String EXECUTOR_ID = "stepos-ability";
    private static final long LATE_RETENTION_MS = 60000;
    private static final String PERMISSION_ACCESS_AGENT_SERVICE = "com.stepos.ability.permission.ACCESS_AGENT_SERVICE";
    private static final String TAG = "SLA";
    private static final long TIMEOUT_MS = 30000;
    private static volatile Context appContext;
    public static final SlaAtomicDispatcher INSTANCE = new SlaAtomicDispatcher();
    private static final ConcurrentHashMap<String, CompletableFuture<DispatchResult>> pending = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, CopyOnWriteArrayList<Object>> toolEventsCache = new ConcurrentHashMap<>();
    private static final ScheduledExecutorService cleanupExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: com.stepos.ailauncher.sla.a
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return SlaAtomicDispatcher.j(runnable);
        }
    });
    private static final SlaAtomicDispatcher$taskListener$1 taskListener = new ITaskListener.Stub() { // from class: com.stepos.ailauncher.sla.SlaAtomicDispatcher$taskListener$1
        @Override // com.stepos.ability.ITaskListener
        public void onExplainUpdated(String p02, ExplainSnapshot p12) {
        }

        @Override // com.stepos.ability.ITaskListener
        public void onInfoDismissed(String p02, String p12, String p22, String p32) {
        }

        @Override // com.stepos.ability.ITaskListener
        public void onInfoRequested(String p02, String p12, String p22, String p32, String p42, long p52, String p62) {
        }

        @Override // com.stepos.ability.ITaskListener
        public void onPackageConflict(int p02, String p12, String p22, String p32, String p42, String p52) {
        }

        @Override // com.stepos.ability.ITaskListener
        public void onRequestRelaunch(String p02, String p12, String p22) {
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x00a7  */
        @Override // com.stepos.ability.ITaskListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onTaskEvent(com.stepos.ability.bean.Task r13) {
            /*
                r12 = this;
                if (r13 != 0) goto L4
                goto L8e
            L4:
                h9.a r12 = com.stepos.ability.common.TaskStatus.getEntries()
                java.util.Iterator r12 = r12.iterator()
            Lc:
                boolean r0 = r12.hasNext()
                r1 = 0
                if (r0 == 0) goto L25
                java.lang.Object r0 = r12.next()
                r2 = r0
                com.stepos.ability.common.TaskStatus r2 = (com.stepos.ability.common.TaskStatus) r2
                int r2 = r2.getCode()
                int r3 = r13.getStatus()
                if (r2 != r3) goto Lc
                goto L26
            L25:
                r0 = r1
            L26:
                com.stepos.ability.common.TaskStatus r0 = (com.stepos.ability.common.TaskStatus) r0
                if (r0 == 0) goto L30
                java.lang.String r12 = r0.name()
                if (r12 != 0) goto L4a
            L30:
                int r12 = r13.getStatus()
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "UNKNOWN("
                r0.append(r2)
                r0.append(r12)
                java.lang.String r12 = ")"
                r0.append(r12)
                java.lang.String r12 = r0.toString()
            L4a:
                java.util.concurrent.ConcurrentHashMap r0 = com.stepos.ailauncher.sla.SlaAtomicDispatcher.c()
                java.lang.String r2 = r13.getTaskId()
                boolean r0 = r0.containsKey(r2)
                java.lang.String r2 = r13.getTaskId()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "onTaskEvent: status="
                r3.append(r4)
                r3.append(r12)
                java.lang.String r4 = " matched="
                r3.append(r4)
                r3.append(r0)
                java.lang.String r4 = " taskId="
                r3.append(r4)
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                java.lang.String r3 = "SLA"
                r4 = 0
                r5 = 4
                h8.C4148a.d(r3, r2, r4, r5, r1)
                if (r0 != 0) goto L86
                goto L8e
            L86:
                com.stepos.ailauncher.sla.SlaAtomicDispatcher r0 = com.stepos.ailauncher.sla.SlaAtomicDispatcher.INSTANCE
                com.stepos.ailauncher.sla.SlaAtomicDispatcher$DispatchResult r0 = com.stepos.ailauncher.sla.SlaAtomicDispatcher.e(r0, r13)
                if (r0 != 0) goto L8f
            L8e:
                return
            L8f:
                java.util.concurrent.ConcurrentHashMap r2 = com.stepos.ailauncher.sla.SlaAtomicDispatcher.c()
                java.lang.String r6 = r13.getTaskId()
                java.lang.Object r2 = r2.get(r6)
                java.util.concurrent.CompletableFuture r2 = (java.util.concurrent.CompletableFuture) r2
                if (r2 == 0) goto La7
                boolean r2 = r2.complete(r0)
                r6 = 1
                if (r2 != r6) goto La7
                goto La8
            La7:
                r6 = r4
            La8:
                java.lang.String r2 = r13.getTaskId()
                com.stepos.ailauncher.sla.SlaAtomicDispatcher$DispatchResult$Status r7 = r0.getStatus()
                int r8 = r0.getErrorCode()
                java.lang.String r9 = r0.getErrorMsg()
                java.lang.String r0 = r0.getResultJson()
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                java.lang.String r11 = "[LOCAL][ABILITY_RESULT_CALLBACK] toolCallId="
                r10.append(r11)
                r10.append(r2)
                java.lang.String r2 = " taskStatus="
                r10.append(r2)
                r10.append(r12)
                java.lang.String r12 = " resultStatus="
                r10.append(r12)
                r10.append(r7)
                java.lang.String r12 = " errorCode="
                r10.append(r12)
                r10.append(r8)
                java.lang.String r12 = " errorMsg="
                r10.append(r12)
                r10.append(r9)
                java.lang.String r12 = " delivered="
                r10.append(r12)
                r10.append(r6)
                java.lang.String r12 = " resultJson="
                r10.append(r12)
                r10.append(r0)
                java.lang.String r12 = r10.toString()
                h8.C4148a.k(r3, r12, r4, r5, r1)
                java.util.concurrent.ConcurrentHashMap r12 = com.stepos.ailauncher.sla.SlaAtomicDispatcher.d()
                java.lang.String r13 = r13.getTaskId()
                r12.remove(r13)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.sla.SlaAtomicDispatcher$taskListener$1.onTaskEvent(com.stepos.ability.bean.Task):void");
        }

        @Override // com.stepos.ability.ITaskListener
        public void onToolCallEvent(ToolCallEvent event) {
            Object objPutIfAbsent;
            if (event == null) {
                return;
            }
            String simpleName = event.getClass().getSimpleName();
            boolean zContainsKey = SlaAtomicDispatcher.pending.containsKey(event.getToolCallId());
            C4148a.d(SlaGate.TAG, "onToolCallEvent: kind=" + simpleName + " matched=" + zContainsKey + " toolCallId=" + event.getToolCallId(), false, 4, null);
            if (zContainsKey) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    ConcurrentHashMap concurrentHashMap = SlaAtomicDispatcher.toolEventsCache;
                    String toolCallId = event.getToolCallId();
                    Object copyOnWriteArrayList = concurrentHashMap.get(toolCallId);
                    if (copyOnWriteArrayList == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(toolCallId, (copyOnWriteArrayList = new CopyOnWriteArrayList()))) != null) {
                        copyOnWriteArrayList = objPutIfAbsent;
                    }
                    Result.b(Boolean.valueOf(((CopyOnWriteArrayList) copyOnWriteArrayList).add(SlaAtomicDispatcher.INSTANCE.t(event))));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
            }
        }
    };

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TaskStatus.values().length];
            try {
                iArr[TaskStatus.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TaskStatus.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TaskStatus.CANCELLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TaskStatus.REMOVED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Thread j(Runnable runnable) {
        Thread thread = new Thread(runnable, "SlaAtomicDispatcher-cleanup");
        thread.setDaemon(true);
        return thread;
    }

    public static final void w(String str) {
        if (pending.remove(str) != null) {
            C4148a.u("SLA", "late-arrival cleanup: no terminal event for " + str + " within 60000ms — dropping pending entry", false, 4, null);
        }
    }

    public final Bundle g(Map<String, String> extras, String traceId) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("handle_input_schema", true);
        if (traceId.length() > 0) {
            bundle.putString("trace_id", traceId);
        }
        if (extras != null) {
            for (Map.Entry<String, String> entry : extras.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
        }
        return bundle;
    }

    public final String h(Task task) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("task", t(task));
            CopyOnWriteArrayList<Object> copyOnWriteArrayList = toolEventsCache.get(task.getTaskId());
            if (copyOnWriteArrayList != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator<T> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                Y8.t tVar = Y8.t.f7040a;
                jSONObject.put("toolCallEvents", jSONArray);
            }
            objB = Result.b(jSONObject.toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            objB = "{\"taskId\":\"" + task.getTaskId() + "\",\"_serializeError\":\"" + thE.getMessage() + "\"}";
        }
        return (String) objB;
    }

    public final JSONObject i(Bundle bundle) {
        Object objB;
        JSONObject jSONObject = new JSONObject();
        try {
            Result.Companion companion = Result.INSTANCE;
            bundle.setClassLoader(SlaAtomicDispatcher.class.getClassLoader());
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        try {
            for (String str : bundle.keySet()) {
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    objB = Result.b(bundle.get(str));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th2));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    objB = "<unparcel failed: " + thE.getClass().getSimpleName() + ">";
                }
                jSONObject.put(str, q(objB));
            }
            Result.b(Y8.t.f7040a);
        } catch (Throwable th3) {
            Result.Companion companion5 = Result.INSTANCE;
            Result.b(C4849c.a(th3));
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0192 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.sla.SlaAtomicDispatcher.DispatchResult k(java.lang.String r28, java.lang.String r29, java.util.Map<java.lang.String, java.lang.String> r30, java.util.Map<java.lang.String, java.lang.String> r31, java.lang.String r32, java.lang.String r33) {
        /*
            Method dump skipped, instructions count: 583
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.sla.SlaAtomicDispatcher.k(java.lang.String, java.lang.String, java.util.Map, java.util.Map, java.lang.String, java.lang.String):com.stepos.ailauncher.sla.SlaAtomicDispatcher$DispatchResult");
    }

    public final boolean l() {
        AgentServiceClient agentServiceClient = AgentServiceClient.f22085a;
        if (agentServiceClient.W()) {
            return true;
        }
        Context context = appContext;
        if (context == null) {
            return false;
        }
        synchronized (this) {
            try {
                if (!agentServiceClient.W()) {
                    AgentServiceClient.T(agentServiceClient, context, null, 2, null);
                    C4148a.k("SLA", "AgentServiceClient.init() submitted; bind is async", false, 4, null);
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return agentServiceClient.W();
    }

    public final boolean m() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (!l()) {
            throw new IllegalStateException("AgentServiceClient has no application context");
        }
        AgentServiceClient.f22085a.a0(taskListener);
        objB = Result.b(Boolean.TRUE);
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g("SLA", "registerTaskListener failed: " + thE.getMessage() + " — service likely unavailable", thE, false, 8, null);
            objB = Boolean.FALSE;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final boolean n() {
        Object objB;
        Context context = appContext;
        boolean z10 = true;
        if (context == null || !p(context)) {
            return true;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            if (context.checkSelfPermission(PERMISSION_ACCESS_AGENT_SERVICE) != 0) {
                z10 = false;
            }
            objB = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t("SLA", "checkSelfPermission failed: " + thE.getMessage(), thE, false, 8, null);
            objB = Boolean.TRUE;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final void o(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        appContext = context.getApplicationContext();
        l();
    }

    public final boolean p(Context context) {
        try {
            context.getPackageManager().getPermissionInfo(PERMISSION_ACCESS_AGENT_SERVICE, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            C4148a.k("SLA", "com.stepos.ability.permission.ACCESS_AGENT_SERVICE 未被任何包声明（ability 版本较旧，AgentService 未挂该权限）-> 按有权限放行", false, 4, null);
            return false;
        } catch (Throwable th) {
            C4148a.t("SLA", "getPermissionInfo failed: " + th.getMessage(), th, false, 8, null);
            return false;
        }
    }

    public final Object q(Object v10) {
        Object objB;
        if (v10 == null) {
            Object NULL = JSONObject.NULL;
            kotlin.jvm.internal.p.h(NULL, "NULL");
            return NULL;
        }
        if (v10 instanceof Bundle) {
            return i((Bundle) v10);
        }
        if ((v10 instanceof String) || (v10 instanceof Boolean) || (v10 instanceof Integer) || (v10 instanceof Long) || (v10 instanceof Double) || (v10 instanceof Float) || (v10 instanceof Short) || (v10 instanceof Byte)) {
            return v10;
        }
        String string = v10.toString();
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(new JSONObject(string));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.e(objB) != null) {
            try {
                objB = Result.b(new JSONArray(string));
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th2));
            }
        }
        return Result.e(objB) == null ? objB : string;
    }

    public final DispatchResult r(Task task) {
        TaskStatus next;
        String string;
        Iterator<TaskStatus> it = TaskStatus.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next.getCode() == task.getStatus()) {
                break;
            }
        }
        TaskStatus taskStatus = next;
        if (taskStatus == null) {
            return null;
        }
        int i10 = a.$EnumSwitchMapping$0[taskStatus.ordinal()];
        if (i10 == 1) {
            return new DispatchResult(EXECUTOR_ID, DispatchResult.Status.SUCCESS, 0, null, h(task), 0L, 44, null);
        }
        if (i10 == 2) {
            DispatchResult.Status status = DispatchResult.Status.FAILED;
            TaskError error = task.getError();
            if (error == null || (string = error.toString()) == null) {
                string = "task failed";
            }
            return new DispatchResult(EXECUTOR_ID, status, 220001, string, h(task), 0L, 32, null);
        }
        if (i10 != 3 && i10 != 4) {
            return null;
        }
        DispatchResult.Status status2 = DispatchResult.Status.FAILED;
        String lowerCase = taskStatus.name().toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        return new DispatchResult(EXECUTOR_ID, status2, -100, "task " + lowerCase, null, 0L, 48, null);
    }

    public final String s() {
        return "sla-" + UUID.randomUUID();
    }

    public final Object t(Object obj) {
        Object objB;
        if (obj == null) {
            Object NULL = JSONObject.NULL;
            kotlin.jvm.internal.p.h(NULL, "NULL");
            return NULL;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject = new JSONObject();
            for (Class<?> superclass = obj.getClass(); superclass != null && !kotlin.jvm.internal.p.d(superclass, Object.class); superclass = superclass.getSuperclass()) {
                Field[] declaredFields = superclass.getDeclaredFields();
                kotlin.jvm.internal.p.h(declaredFields, "getDeclaredFields(...)");
                for (Field field : declaredFields) {
                    if (!Modifier.isStatic(field.getModifiers())) {
                        field.setAccessible(true);
                        if (!jSONObject.has(field.getName())) {
                            jSONObject.put(field.getName(), q(field.get(obj)));
                        }
                    }
                }
            }
            objB = Result.b(jSONObject);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return Result.e(objB) == null ? objB : obj.toString();
    }

    public final String u(Map<String, String> params) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(new JSONObject(params).toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = "{}";
        }
        return (String) objB;
    }

    public final void v(final String toolCallId) {
        cleanupExecutor.schedule(new Runnable() { // from class: com.stepos.ailauncher.sla.b
            @Override // java.lang.Runnable
            public final void run() {
                SlaAtomicDispatcher.w(toolCallId);
            }
        }, 60000L, TimeUnit.MILLISECONDS);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001:\u0001$BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJP\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u0013R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u001f\u0010\u0011R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b \u0010\u0011R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/stepos/ailauncher/sla/SlaAtomicDispatcher$DispatchResult;", "", "", "executor", "Lcom/stepos/ailauncher/sla/SlaAtomicDispatcher$DispatchResult$Status;", "status", "", "errorCode", C3081a.ERROR_MSG, "resultJson", "", "elapsedMs", "<init>", "(Ljava/lang/String;Lcom/stepos/ailauncher/sla/SlaAtomicDispatcher$DispatchResult$Status;ILjava/lang/String;Ljava/lang/String;J)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Lcom/stepos/ailauncher/sla/SlaAtomicDispatcher$DispatchResult$Status;ILjava/lang/String;Ljava/lang/String;J)Lcom/stepos/ailauncher/sla/SlaAtomicDispatcher$DispatchResult;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "f", "Lcom/stepos/ailauncher/sla/SlaAtomicDispatcher$DispatchResult$Status;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lcom/stepos/ailauncher/sla/SlaAtomicDispatcher$DispatchResult$Status;", "I", Const.INTENT_KEY_UMID, "e", Const.INTENT_KEY_BACKGROUND_COMMAND, "J", "c", "()J", "Status", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class DispatchResult {
        private final long elapsedMs;
        private final int errorCode;
        private final String errorMsg;
        private final String executor;
        private final String resultJson;
        private final Status status;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/sla/SlaAtomicDispatcher$DispatchResult$Status;", "", "<init>", "(Ljava/lang/String;I)V", AMapLocationStaticsEntity.SUCCESS_STATUS, "FAILED", ModelFlowMeta.PLAN_UNAVAILABLE, "NOT_DISPATCHED", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Status {
            private static final /* synthetic */ InterfaceC4149a $ENTRIES;
            private static final /* synthetic */ Status[] $VALUES;
            public static final Status SUCCESS = new Status(AMapLocationStaticsEntity.SUCCESS_STATUS, 0);
            public static final Status FAILED = new Status("FAILED", 1);
            public static final Status UNAVAILABLE = new Status(ModelFlowMeta.PLAN_UNAVAILABLE, 2);
            public static final Status NOT_DISPATCHED = new Status("NOT_DISPATCHED", 3);

            private static final /* synthetic */ Status[] $values() {
                return new Status[]{SUCCESS, FAILED, UNAVAILABLE, NOT_DISPATCHED};
            }

            static {
                Status[] statusArr$values = $values();
                $VALUES = statusArr$values;
                $ENTRIES = kotlin.enums.a.a(statusArr$values);
            }

            private Status(String str, int i10) {
            }

            public static InterfaceC4149a<Status> getEntries() {
                return $ENTRIES;
            }

            public static Status valueOf(String str) {
                return (Status) Enum.valueOf(Status.class, str);
            }

            public static Status[] values() {
                return (Status[]) $VALUES.clone();
            }
        }

        public DispatchResult(String executor, Status status, int i10, String str, String str2, long j10) {
            kotlin.jvm.internal.p.i(executor, "executor");
            kotlin.jvm.internal.p.i(status, "status");
            this.executor = executor;
            this.status = status;
            this.errorCode = i10;
            this.errorMsg = str;
            this.resultJson = str2;
            this.elapsedMs = j10;
        }

        public static /* synthetic */ DispatchResult b(DispatchResult dispatchResult, String str, Status status, int i10, String str2, String str3, long j10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = dispatchResult.executor;
            }
            if ((i11 & 2) != 0) {
                status = dispatchResult.status;
            }
            if ((i11 & 4) != 0) {
                i10 = dispatchResult.errorCode;
            }
            if ((i11 & 8) != 0) {
                str2 = dispatchResult.errorMsg;
            }
            if ((i11 & 16) != 0) {
                str3 = dispatchResult.resultJson;
            }
            if ((i11 & 32) != 0) {
                j10 = dispatchResult.elapsedMs;
            }
            long j11 = j10;
            String str4 = str3;
            int i12 = i10;
            return dispatchResult.a(str, status, i12, str2, str4, j11);
        }

        public final DispatchResult a(String executor, Status status, int errorCode, String errorMsg, String resultJson, long elapsedMs) {
            kotlin.jvm.internal.p.i(executor, "executor");
            kotlin.jvm.internal.p.i(status, "status");
            return new DispatchResult(executor, status, errorCode, errorMsg, resultJson, elapsedMs);
        }

        /* renamed from: c, reason: from getter */
        public final long getElapsedMs() {
            return this.elapsedMs;
        }

        /* renamed from: d, reason: from getter */
        public final int getErrorCode() {
            return this.errorCode;
        }

        /* renamed from: e, reason: from getter */
        public final String getErrorMsg() {
            return this.errorMsg;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DispatchResult)) {
                return false;
            }
            DispatchResult dispatchResult = (DispatchResult) other;
            return kotlin.jvm.internal.p.d(this.executor, dispatchResult.executor) && this.status == dispatchResult.status && this.errorCode == dispatchResult.errorCode && kotlin.jvm.internal.p.d(this.errorMsg, dispatchResult.errorMsg) && kotlin.jvm.internal.p.d(this.resultJson, dispatchResult.resultJson) && this.elapsedMs == dispatchResult.elapsedMs;
        }

        /* renamed from: f, reason: from getter */
        public final String getExecutor() {
            return this.executor;
        }

        /* renamed from: g, reason: from getter */
        public final String getResultJson() {
            return this.resultJson;
        }

        /* renamed from: h, reason: from getter */
        public final Status getStatus() {
            return this.status;
        }

        public int hashCode() {
            int iHashCode = ((((this.executor.hashCode() * 31) + this.status.hashCode()) * 31) + Integer.hashCode(this.errorCode)) * 31;
            String str = this.errorMsg;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.resultJson;
            return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Long.hashCode(this.elapsedMs);
        }

        public String toString() {
            return "DispatchResult(executor=" + this.executor + ", status=" + this.status + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ", resultJson=" + this.resultJson + ", elapsedMs=" + this.elapsedMs + ")";
        }

        public /* synthetic */ DispatchResult(String str, Status status, int i10, String str2, String str3, long j10, int i11, kotlin.jvm.internal.i iVar) {
            this(str, status, (i11 & 4) != 0 ? 0 : i10, (i11 & 8) != 0 ? null : str2, (i11 & 16) != 0 ? null : str3, (i11 & 32) != 0 ? 0L : j10);
        }
    }
}
