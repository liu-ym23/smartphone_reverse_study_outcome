package com.stepos.agentcache.sdk.api;

import C7.r;
import M4.b;
import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.core.dsl.a;
import androidx.core.app.NotificationCompat;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.agentcache.ipc.ILogIngestService;
import com.stepos.agentcache.ipc.LogEventParcel;
import com.stepos.agentcache.ipc.LogRecordParcel;
import j9.m;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0011\u001a\u00020\u0010*\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u001cH\u0002¢\u0006\u0004\b\u0011\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0001H\u0002¢\u0006\u0004\b \u0010!J\u0019\u0010#\u001a\u00020\"2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b#\u0010$J+\u0010+\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%2\b\b\u0002\u0010(\u001a\u00020'2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b+\u0010,Jg\u00105\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u00102\u0014\b\u0002\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u001c2\u0014\b\u0002\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u001c2\b\b\u0002\u00101\u001a\u00020\u00102\b\b\u0002\u00102\u001a\u00020\u00102\b\b\u0002\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J/\u00107\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u000203¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020\"¢\u0006\u0004\b9\u0010:R\u0018\u0010;\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010@R\u0018\u0010A\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010D\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00060F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000b0F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010H¨\u0006J"}, d2 = {"Lcom/stepos/agentcache/sdk/api/AgentCacheSdk;", "", AppAgent.CONSTRUCT, "()V", "LC7/r;", "flushPendingEvents", "Lcom/stepos/agentcache/ipc/LogEventParcel;", NotificationCompat.CATEGORY_EVENT, "enqueuePending", "(Lcom/stepos/agentcache/ipc/LogEventParcel;)V", "flushPendingLogs", "Lcom/stepos/agentcache/ipc/LogRecordParcel;", "log", "enqueuePendingLog", "(Lcom/stepos/agentcache/ipc/LogRecordParcel;)V", "Lcom/stepos/agentcache/sdk/api/LogMessage;", "", "toJsonString", "(Lcom/stepos/agentcache/sdk/api/LogMessage;)Ljava/lang/String;", "Lcom/stepos/agentcache/sdk/api/AgentCacheSendResult;", "result", "emitResult", "(Lcom/stepos/agentcache/sdk/api/AgentCacheSendResult;)V", "message", "logD", "(Ljava/lang/String;)V", "buildTimestamp", "()Ljava/lang/String;", "", "map", "(Ljava/util/Map;)Ljava/lang/String;", "value", "normalizeJsonValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "containsNullValue", "(Ljava/lang/Object;)Z", "Landroid/content/Context;", "context", "Lcom/stepos/agentcache/sdk/api/AgentCacheConfig;", "config", "Lcom/stepos/agentcache/sdk/api/AgentCacheResultListener;", "listener", "init", "(Landroid/content/Context;Lcom/stepos/agentcache/sdk/api/AgentCacheConfig;Lcom/stepos/agentcache/sdk/api/AgentCacheResultListener;)V", AgentBusWakeContract.EXTRA_TRACE_ID, "nodeName", "commonFields", "bizData", "inputText", "outputText", "", "statusCode", "reportEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;I)Z", "reportLog", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentcache/sdk/api/LogMessage;I)Z", "isInitialized", "()Z", "appContext", "Landroid/content/Context;", "LM4/b;", "client", "LM4/b;", "Lcom/stepos/agentcache/sdk/api/AgentCacheConfig;", "resultListener", "Lcom/stepos/agentcache/sdk/api/AgentCacheResultListener;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "pendingQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "pendingLogQueue", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentCacheSdk {
    private static volatile Context appContext;
    private static volatile b client;
    private static volatile AgentCacheResultListener resultListener;
    public static final AgentCacheSdk INSTANCE = new AgentCacheSdk();
    private static volatile AgentCacheConfig config = new AgentCacheConfig(null, 0, false, 7, null);
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static final ConcurrentLinkedQueue<LogEventParcel> pendingQueue = new ConcurrentLinkedQueue<>();
    private static final ConcurrentLinkedQueue<LogRecordParcel> pendingLogQueue = new ConcurrentLinkedQueue<>();

    private AgentCacheSdk() {
    }

    private final String buildTimestamp() {
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis()));
        k.e(str, "format(...)");
        return str;
    }

    private final boolean containsNullValue(Object value) {
        if (value == null) {
            return true;
        }
        if (value instanceof Map) {
            Collection collectionValues = ((Map) value).values();
            if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
                return false;
            }
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                if (INSTANCE.containsNullValue(it.next())) {
                    return true;
                }
            }
            return false;
        }
        if (value instanceof Iterable) {
            Iterable iterable = (Iterable) value;
            if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
                return false;
            }
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                if (INSTANCE.containsNullValue(it2.next())) {
                    return true;
                }
            }
            return false;
        }
        if (value instanceof Object[]) {
            for (Object obj : (Object[]) value) {
                if (INSTANCE.containsNullValue(obj)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void emitResult(AgentCacheSendResult result) {
        AgentCacheResultListener agentCacheResultListener = resultListener;
        if (agentCacheResultListener != null) {
            agentCacheResultListener.onResult(result);
        }
        logD("sendResult=" + result);
    }

    private final void enqueuePending(LogEventParcel event) {
        while (true) {
            ConcurrentLinkedQueue<LogEventParcel> concurrentLinkedQueue = pendingQueue;
            if (concurrentLinkedQueue.size() < config.getMaxPendingEvents()) {
                concurrentLinkedQueue.offer(event);
                return;
            }
            concurrentLinkedQueue.poll();
        }
    }

    private final void enqueuePendingLog(LogRecordParcel log) {
        while (true) {
            ConcurrentLinkedQueue<LogRecordParcel> concurrentLinkedQueue = pendingLogQueue;
            if (concurrentLinkedQueue.size() < config.getMaxPendingEvents()) {
                concurrentLinkedQueue.offer(log);
                return;
            }
            concurrentLinkedQueue.poll();
        }
    }

    private final void flushPendingEvents() {
        Object objA;
        LogEventParcel logEventParcelPoll;
        b bVar = client;
        if (bVar == null || pendingQueue.isEmpty()) {
            return;
        }
        bVar.a();
        ArrayList arrayList = new ArrayList();
        while (arrayList.size() < config.getMaxPendingEvents() && (logEventParcelPoll = pendingQueue.poll()) != null) {
            arrayList.add(logEventParcelPoll);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        AtomicReference atomicReference = bVar.c;
        try {
            ILogIngestService iLogIngestService = (ILogIngestService) atomicReference.get();
            if (iLogIngestService != null) {
                iLogIngestService.cacheEvents(new ArrayList(arrayList));
            }
            boolean z10 = atomicReference.get() != null;
            Log.d("LogSdkClient", "cacheEvents count=" + arrayList.size() + ", success=" + z10);
            objA = Boolean.valueOf(z10);
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            a.w("cacheEvents failed: ", thA.getMessage(), "LogSdkClient");
            objA = Boolean.FALSE;
        }
        if (((Boolean) objA).booleanValue()) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            INSTANCE.enqueuePending((LogEventParcel) it.next());
        }
    }

    private final void flushPendingLogs() {
        Object objA;
        LogRecordParcel logRecordParcelPoll;
        b bVar = client;
        if (bVar == null || pendingLogQueue.isEmpty()) {
            return;
        }
        bVar.a();
        ArrayList arrayList = new ArrayList();
        while (arrayList.size() < config.getMaxPendingEvents() && (logRecordParcelPoll = pendingLogQueue.poll()) != null) {
            arrayList.add(logRecordParcelPoll);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        AtomicReference atomicReference = bVar.c;
        try {
            ILogIngestService iLogIngestService = (ILogIngestService) atomicReference.get();
            if (iLogIngestService != null) {
                iLogIngestService.cacheLogs(new ArrayList(arrayList));
            }
            boolean z10 = atomicReference.get() != null;
            Log.d("LogSdkClient", "cacheLogs count=" + arrayList.size() + ", success=" + z10);
            objA = Boolean.valueOf(z10);
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            a.w("cacheLogs failed: ", thA.getMessage(), "LogSdkClient");
            objA = Boolean.FALSE;
        }
        if (((Boolean) objA).booleanValue()) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            INSTANCE.enqueuePendingLog((LogRecordParcel) it.next());
        }
    }

    public static /* synthetic */ void init$default(AgentCacheSdk agentCacheSdk, Context context, AgentCacheConfig agentCacheConfig, AgentCacheResultListener agentCacheResultListener, int i, Object obj) {
        if ((i & 2) != 0) {
            agentCacheConfig = new AgentCacheConfig(null, 0, false, 7, null);
        }
        if ((i & 4) != 0) {
            agentCacheResultListener = null;
        }
        agentCacheSdk.init(context, agentCacheConfig, agentCacheResultListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r init$lambda$0() {
        AgentCacheSdk agentCacheSdk = INSTANCE;
        agentCacheSdk.flushPendingEvents();
        agentCacheSdk.flushPendingLogs();
        return r.f317a;
    }

    private final void logD(String message) {
        if (config.getEnableDebugLog()) {
            Log.d("AgentCacheSdk", message);
        }
    }

    private final Object normalizeJsonValue(Object value) throws JSONException {
        if ((value instanceof Number) || (value instanceof String) || (value instanceof Boolean)) {
            return value;
        }
        if (value instanceof Map) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : ((Map) value).entrySet()) {
                Object key = entry.getKey();
                Object value2 = entry.getValue();
                if (key != null && value2 != null) {
                    jSONObject.put(key.toString(), INSTANCE.normalizeJsonValue(value2));
                }
            }
            return jSONObject;
        }
        if (value instanceof Iterable) {
            JSONArray jSONArray = new JSONArray();
            for (Object obj : (Iterable) value) {
                if (obj != null) {
                    jSONArray.put(INSTANCE.normalizeJsonValue(obj));
                }
            }
            return jSONArray;
        }
        if (!(value instanceof Object[])) {
            return value.toString();
        }
        JSONArray jSONArray2 = new JSONArray();
        for (Object obj2 : (Object[]) value) {
            if (obj2 != null) {
                jSONArray2.put(INSTANCE.normalizeJsonValue(obj2));
            }
        }
        return jSONArray2;
    }

    public static /* synthetic */ boolean reportEvent$default(AgentCacheSdk agentCacheSdk, String str, String str2, Map map, Map map2, String str3, String str4, int i, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            map = kotlin.collections.a.M();
        }
        Map map3 = map;
        if ((i6 & 8) != 0) {
            map2 = kotlin.collections.a.M();
        }
        return agentCacheSdk.reportEvent(str, str2, map3, map2, (i6 & 16) != 0 ? "" : str3, (i6 & 32) != 0 ? "" : str4, (i6 & 64) != 0 ? 200 : i);
    }

    public static /* synthetic */ boolean reportLog$default(AgentCacheSdk agentCacheSdk, String str, String str2, LogMessage logMessage, int i, int i6, Object obj) {
        if ((i6 & 8) != 0) {
            i = 200;
        }
        return agentCacheSdk.reportLog(str, str2, logMessage, i);
    }

    private final String toJsonString(LogMessage logMessage) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("level", logMessage.getLevel().name());
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, logMessage.getEvent());
        jSONObject.put("log", logMessage.getLog());
        String stack = logMessage.getStack();
        if (stack != null && !m.s0(stack)) {
            jSONObject.put("stack", logMessage.getStack());
        }
        String string = jSONObject.toString();
        k.e(string, "toString(...)");
        return string;
    }

    public final synchronized void init(Context context, AgentCacheConfig config2, AgentCacheResultListener listener) {
        k.f(context, "context");
        k.f(config2, "config");
        config = config2;
        resultListener = listener;
        appContext = context.getApplicationContext();
        Context context2 = appContext;
        k.c(context2);
        b bVar = new b(context2, config2.getServicePackageName(), new Ba.a(26));
        bVar.a();
        client = bVar;
        initialized.set(true);
        logD("init completed, servicePackage=" + config2.getServicePackageName());
    }

    public final boolean isInitialized() {
        return initialized.get();
    }

    public final boolean reportEvent(String traceId, String nodeName, Map<String, ? extends Object> commonFields, Map<String, ? extends Object> bizData, String inputText, String outputText, int statusCode) {
        b bVar;
        Object objA;
        Object objA2;
        Object objA3;
        k.f(traceId, "traceId");
        k.f(nodeName, "nodeName");
        k.f(commonFields, "commonFields");
        k.f(bizData, "bizData");
        k.f(inputText, "inputText");
        k.f(outputText, "outputText");
        if (m.s0(traceId) || m.s0(nodeName)) {
            emitResult(new AgentCacheSendResult(false, "invalid_params", traceId));
            return false;
        }
        if (containsNullValue(commonFields) || containsNullValue(bizData)) {
            emitResult(new AgentCacheSendResult(false, "invalid_params_null_value", traceId));
            return false;
        }
        Context context = appContext;
        if (context == null || (bVar = client) == null) {
            return false;
        }
        try {
            objA = context.getPackageName();
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        boolean z10 = objA instanceof Result.Failure;
        Object obj = EnvironmentCompat.MEDIA_UNKNOWN;
        if (z10) {
            objA = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        String str = (String) objA;
        StringBuilder sbW = B7.a.w("reportEvent: traceId=", traceId, ", nodeName=", nodeName, ", statusCode=");
        sbW.append(statusCode);
        logD(sbW.toString());
        try {
            objA2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (objA2 == null) {
                objA2 = EnvironmentCompat.MEDIA_UNKNOWN;
            }
        } catch (Throwable th2) {
            objA2 = kotlin.b.a(th2);
        }
        if (!(objA2 instanceof Result.Failure)) {
            obj = objA2;
        }
        String str2 = (String) obj;
        LinkedHashMap linkedHashMap = new LinkedHashMap(commonFields);
        if (!m.s0(inputText)) {
            linkedHashMap.put("input_text", inputText);
        }
        if (!m.s0(outputText)) {
            linkedHashMap.put("output_text", outputText);
        }
        String string = m.R0(traceId).toString();
        String string2 = m.R0(nodeName).toString();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strBuildTimestamp = buildTimestamp();
        k.c(str);
        LogEventParcel logEventParcel = new LogEventParcel(string, string2, jCurrentTimeMillis, strBuildTimestamp, statusCode, str, str2, toJsonString(linkedHashMap), toJsonString(bizData));
        bVar.a();
        AtomicReference atomicReference = bVar.c;
        try {
            ILogIngestService iLogIngestService = (ILogIngestService) atomicReference.get();
            if (iLogIngestService != null) {
                iLogIngestService.cacheEvent(logEventParcel);
            }
            boolean z11 = atomicReference.get() != null;
            Log.d("LogSdkClient", "cacheEvent traceId=" + logEventParcel.getTraceId() + ", success=" + z11);
            objA3 = Boolean.valueOf(z11);
        } catch (Throwable th3) {
            objA3 = kotlin.b.a(th3);
        }
        Throwable thA = Result.a(objA3);
        if (thA != null) {
            a.w("cacheEvent failed: ", thA.getMessage(), "LogSdkClient");
            objA3 = Boolean.FALSE;
        }
        if (((Boolean) objA3).booleanValue()) {
            emitResult(new AgentCacheSendResult(true, "sent", traceId));
            flushPendingEvents();
            return true;
        }
        enqueuePending(logEventParcel);
        emitResult(new AgentCacheSendResult(true, "service_unavailable_queued", traceId));
        return true;
    }

    public final boolean reportLog(String traceId, String nodeName, LogMessage message, int statusCode) {
        b bVar;
        Object objA;
        Object objA2;
        Object objA3;
        k.f(traceId, "traceId");
        k.f(nodeName, "nodeName");
        k.f(message, "message");
        if (m.s0(traceId) || m.s0(nodeName) || m.s0(message.getEvent()) || m.s0(message.getLog())) {
            emitResult(new AgentCacheSendResult(false, "invalid_params", traceId));
            return false;
        }
        Context context = appContext;
        if (context == null || (bVar = client) == null) {
            return false;
        }
        try {
            objA = context.getPackageName();
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        boolean z10 = objA instanceof Result.Failure;
        Object obj = EnvironmentCompat.MEDIA_UNKNOWN;
        if (z10) {
            objA = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        String str = (String) objA;
        try {
            objA2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (objA2 == null) {
                objA2 = EnvironmentCompat.MEDIA_UNKNOWN;
            }
        } catch (Throwable th2) {
            objA2 = kotlin.b.a(th2);
        }
        if (!(objA2 instanceof Result.Failure)) {
            obj = objA2;
        }
        String string = m.R0(traceId).toString();
        String string2 = m.R0(nodeName).toString();
        String strBuildTimestamp = buildTimestamp();
        k.c(str);
        LogRecordParcel logRecordParcel = new LogRecordParcel(string, string2, strBuildTimestamp, statusCode, str, (String) obj, toJsonString(message));
        bVar.a();
        AtomicReference atomicReference = bVar.c;
        try {
            ILogIngestService iLogIngestService = (ILogIngestService) atomicReference.get();
            if (iLogIngestService != null) {
                iLogIngestService.cacheLog(logRecordParcel);
            }
            boolean z11 = atomicReference.get() != null;
            Log.d("LogSdkClient", "cacheLog traceId=" + logRecordParcel.getTraceId() + ", success=" + z11);
            objA3 = Boolean.valueOf(z11);
        } catch (Throwable th3) {
            objA3 = kotlin.b.a(th3);
        }
        Throwable thA = Result.a(objA3);
        if (thA != null) {
            a.w("cacheLog failed: ", thA.getMessage(), "LogSdkClient");
            objA3 = Boolean.FALSE;
        }
        if (((Boolean) objA3).booleanValue()) {
            emitResult(new AgentCacheSendResult(true, "sent", traceId));
            flushPendingLogs();
            return true;
        }
        enqueuePendingLog(logRecordParcel);
        emitResult(new AgentCacheSendResult(true, "service_unavailable_queued", traceId));
        return true;
    }

    private final String toJsonString(Map<String, ? extends Object> map) throws JSONException {
        if (map.isEmpty()) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), INSTANCE.normalizeJsonValue(entry.getValue()));
        }
        String string = jSONObject.toString();
        k.e(string, "toString(...)");
        return string;
    }
}
