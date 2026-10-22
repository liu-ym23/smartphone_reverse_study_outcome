package com.stepos.agentcache.sdk.api;

import a0.a;
import android.content.Context;
import android.util.Log;
import com.stepos.agentcache.ipc.ILogIngestService;
import com.stepos.agentcache.ipc.LogEventParcel;
import com.stepos.agentcache.ipc.LogRecordParcel;
import gc.q;
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
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.n;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import z5.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
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
        g.e(str, "format(...)");
        return str;
    }

    private final boolean containsNullValue(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof Map) {
            Collection collectionValues = ((Map) obj).values();
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
        if (obj instanceof Iterable) {
            Iterable iterable = (Iterable) obj;
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
        if (obj instanceof Object[]) {
            for (Object obj2 : (Object[]) obj) {
                if (INSTANCE.containsNullValue(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void emitResult(AgentCacheSendResult agentCacheSendResult) {
        AgentCacheResultListener agentCacheResultListener = resultListener;
        if (agentCacheResultListener != null) {
            agentCacheResultListener.onResult(agentCacheSendResult);
        }
        logD("sendResult=" + agentCacheSendResult);
    }

    private final void enqueuePending(LogEventParcel logEventParcel) {
        while (true) {
            ConcurrentLinkedQueue<LogEventParcel> concurrentLinkedQueue = pendingQueue;
            if (concurrentLinkedQueue.size() < config.getMaxPendingEvents()) {
                concurrentLinkedQueue.offer(logEventParcel);
                return;
            }
            concurrentLinkedQueue.poll();
        }
    }

    private final void enqueuePendingLog(LogRecordParcel logRecordParcel) {
        while (true) {
            ConcurrentLinkedQueue<LogRecordParcel> concurrentLinkedQueue = pendingLogQueue;
            if (concurrentLinkedQueue.size() < config.getMaxPendingEvents()) {
                concurrentLinkedQueue.offer(logRecordParcel);
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
        AtomicReference<ILogIngestService> atomicReference = bVar.f14264c;
        int i10 = 0;
        try {
            ILogIngestService iLogIngestService = atomicReference.get();
            if (iLogIngestService != null) {
                iLogIngestService.cacheEvents(new ArrayList(arrayList));
            }
            boolean z = atomicReference.get() != null;
            Log.d("LogSdkClient", "cacheEvents count=" + arrayList.size() + ", success=" + z);
            objA = Boolean.valueOf(z);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            a.A("cacheEvents failed: ", thB.getMessage(), "LogSdkClient");
            objA = Boolean.FALSE;
        }
        if (((Boolean) objA).booleanValue()) {
            return;
        }
        int size = arrayList.size();
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            INSTANCE.enqueuePending((LogEventParcel) obj);
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
        AtomicReference<ILogIngestService> atomicReference = bVar.f14264c;
        int i10 = 0;
        try {
            ILogIngestService iLogIngestService = atomicReference.get();
            if (iLogIngestService != null) {
                iLogIngestService.cacheLogs(new ArrayList(arrayList));
            }
            boolean z = atomicReference.get() != null;
            Log.d("LogSdkClient", "cacheLogs count=" + arrayList.size() + ", success=" + z);
            objA = Boolean.valueOf(z);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            a.A("cacheLogs failed: ", thB.getMessage(), "LogSdkClient");
            objA = Boolean.FALSE;
        }
        if (((Boolean) objA).booleanValue()) {
            return;
        }
        int size = arrayList.size();
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            INSTANCE.enqueuePendingLog((LogRecordParcel) obj);
        }
    }

    public static /* synthetic */ void init$default(AgentCacheSdk agentCacheSdk, Context context, AgentCacheConfig agentCacheConfig, AgentCacheResultListener agentCacheResultListener, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            agentCacheConfig = new AgentCacheConfig(null, 0, false, 7, null);
        }
        if ((i10 & 4) != 0) {
            agentCacheResultListener = null;
        }
        agentCacheSdk.init(context, agentCacheConfig, agentCacheResultListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n init$lambda$0() {
        AgentCacheSdk agentCacheSdk = INSTANCE;
        agentCacheSdk.flushPendingEvents();
        agentCacheSdk.flushPendingLogs();
        return n.f10413a;
    }

    private final void logD(String str) {
        if (config.getEnableDebugLog()) {
            Log.d("AgentCacheSdk", str);
        }
    }

    private final Object normalizeJsonValue(Object obj) throws JSONException {
        if ((obj instanceof Number) || (obj instanceof String) || (obj instanceof Boolean)) {
            return obj;
        }
        if (obj instanceof Map) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (key != null && value != null) {
                    jSONObject.put(key.toString(), INSTANCE.normalizeJsonValue(value));
                }
            }
            return jSONObject;
        }
        if (obj instanceof Iterable) {
            JSONArray jSONArray = new JSONArray();
            for (Object obj2 : (Iterable) obj) {
                if (obj2 != null) {
                    jSONArray.put(INSTANCE.normalizeJsonValue(obj2));
                }
            }
            return jSONArray;
        }
        if (!(obj instanceof Object[])) {
            return obj.toString();
        }
        JSONArray jSONArray2 = new JSONArray();
        for (Object obj3 : (Object[]) obj) {
            if (obj3 != null) {
                jSONArray2.put(INSTANCE.normalizeJsonValue(obj3));
            }
        }
        return jSONArray2;
    }

    public static /* synthetic */ boolean reportEvent$default(AgentCacheSdk agentCacheSdk, String str, String str2, Map map, Map map2, String str3, String str4, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            map = kotlin.collections.b.d0();
        }
        Map map3 = map;
        if ((i11 & 8) != 0) {
            map2 = kotlin.collections.b.d0();
        }
        return agentCacheSdk.reportEvent(str, str2, map3, map2, (i11 & 16) != 0 ? "" : str3, (i11 & 32) != 0 ? "" : str4, (i11 & 64) != 0 ? 200 : i10);
    }

    public static /* synthetic */ boolean reportLog$default(AgentCacheSdk agentCacheSdk, String str, String str2, LogMessage logMessage, int i10, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            i10 = 200;
        }
        return agentCacheSdk.reportLog(str, str2, logMessage, i10);
    }

    private final String toJsonString(LogMessage logMessage) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("level", logMessage.getLevel().name());
        jSONObject.put("event", logMessage.getEvent());
        jSONObject.put("log", logMessage.getLog());
        String stack = logMessage.getStack();
        if (stack != null && !q.t0(stack)) {
            jSONObject.put("stack", logMessage.getStack());
        }
        String string = jSONObject.toString();
        g.e(string, "toString(...)");
        return string;
    }

    public final synchronized void init(Context context, AgentCacheConfig config2, AgentCacheResultListener agentCacheResultListener) {
        g.f(context, "context");
        g.f(config2, "config");
        config = config2;
        resultListener = agentCacheResultListener;
        appContext = context.getApplicationContext();
        Context context2 = appContext;
        g.c(context2);
        b bVar = new b(context2, config2.getServicePackageName(), new com.stepos.cpuset.b(19));
        bVar.a();
        client = bVar;
        initialized.set(true);
        logD("init completed, servicePackage=" + config2.getServicePackageName());
    }

    public final boolean isInitialized() {
        return initialized.get();
    }

    public final boolean reportEvent(String traceId, String nodeName, Map<String, ? extends Object> commonFields, Map<String, ? extends Object> bizData, String inputText, String outputText, int i10) {
        b bVar;
        Object objA;
        Object objA2;
        Object objA3;
        g.f(traceId, "traceId");
        g.f(nodeName, "nodeName");
        g.f(commonFields, "commonFields");
        g.f(bizData, "bizData");
        g.f(inputText, "inputText");
        g.f(outputText, "outputText");
        if (q.t0(traceId) || q.t0(nodeName)) {
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
            objA = c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = "unknown";
        }
        String str = (String) objA;
        StringBuilder sbS = ai.onnxruntime.a.s("reportEvent: traceId=", traceId, ", nodeName=", nodeName, ", statusCode=");
        sbS.append(i10);
        logD(sbS.toString());
        try {
            objA2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (objA2 == null) {
                objA2 = "unknown";
            }
        } catch (Throwable th2) {
            objA2 = c.a(th2);
        }
        String str2 = (String) (objA2 instanceof Result.Failure ? "unknown" : objA2);
        LinkedHashMap linkedHashMap = new LinkedHashMap(commonFields);
        if (!q.t0(inputText)) {
            linkedHashMap.put("input_text", inputText);
        }
        if (!q.t0(outputText)) {
            linkedHashMap.put("output_text", outputText);
        }
        String string = q.L0(traceId).toString();
        String string2 = q.L0(nodeName).toString();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strBuildTimestamp = buildTimestamp();
        g.c(str);
        LogEventParcel logEventParcel = new LogEventParcel(string, string2, jCurrentTimeMillis, strBuildTimestamp, i10, str, str2, toJsonString(linkedHashMap), toJsonString(bizData));
        bVar.a();
        AtomicReference<ILogIngestService> atomicReference = bVar.f14264c;
        try {
            ILogIngestService iLogIngestService = atomicReference.get();
            if (iLogIngestService != null) {
                iLogIngestService.cacheEvent(logEventParcel);
            }
            boolean z = atomicReference.get() != null;
            Log.d("LogSdkClient", "cacheEvent traceId=" + logEventParcel.getTraceId() + ", success=" + z);
            objA3 = Boolean.valueOf(z);
        } catch (Throwable th3) {
            objA3 = c.a(th3);
        }
        Throwable thB = Result.b(objA3);
        if (thB != null) {
            a.A("cacheEvent failed: ", thB.getMessage(), "LogSdkClient");
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

    public final boolean reportLog(String traceId, String nodeName, LogMessage message, int i10) {
        b bVar;
        Object objA;
        Object objA2;
        Object objA3;
        g.f(traceId, "traceId");
        g.f(nodeName, "nodeName");
        g.f(message, "message");
        if (q.t0(traceId) || q.t0(nodeName) || q.t0(message.getEvent()) || q.t0(message.getLog())) {
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
            objA = c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = "unknown";
        }
        String str = (String) objA;
        try {
            objA2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (objA2 == null) {
                objA2 = "unknown";
            }
        } catch (Throwable th2) {
            objA2 = c.a(th2);
        }
        Object obj = objA2 instanceof Result.Failure ? "unknown" : objA2;
        String string = q.L0(traceId).toString();
        String string2 = q.L0(nodeName).toString();
        String strBuildTimestamp = buildTimestamp();
        g.c(str);
        LogRecordParcel logRecordParcel = new LogRecordParcel(string, string2, strBuildTimestamp, i10, str, (String) obj, toJsonString(message));
        bVar.a();
        AtomicReference<ILogIngestService> atomicReference = bVar.f14264c;
        try {
            ILogIngestService iLogIngestService = atomicReference.get();
            if (iLogIngestService != null) {
                iLogIngestService.cacheLog(logRecordParcel);
            }
            boolean z = atomicReference.get() != null;
            Log.d("LogSdkClient", "cacheLog traceId=" + logRecordParcel.getTraceId() + ", success=" + z);
            objA3 = Boolean.valueOf(z);
        } catch (Throwable th3) {
            objA3 = c.a(th3);
        }
        Throwable thB = Result.b(objA3);
        if (thB != null) {
            a.A("cacheLog failed: ", thB.getMessage(), "LogSdkClient");
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
        g.e(string, "toString(...)");
        return string;
    }
}
