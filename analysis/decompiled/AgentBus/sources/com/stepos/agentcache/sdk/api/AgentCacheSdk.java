package com.stepos.agentcache.sdk.api;

import a1.a;
import android.content.Context;
import android.util.Log;
import b0.d0;
import c7.l;
import c7.r;
import com.stepos.account.oauth.OAuthConstants;
import com.stepos.agentcache.core.ServiceContract;
import com.stepos.agentcache.ipc.LogEventParcel;
import com.stepos.agentcache.ipc.LogRecordParcel;
import com.stepos.agentcache.sdk.internal.LogSdkClient;
import d7.a0;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q7.k;
import w7.e0;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0011\u001a\u00020\u0010*\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u001cH\u0002¢\u0006\u0004\b\u0011\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0001H\u0002¢\u0006\u0004\b \u0010!J\u0019\u0010#\u001a\u00020\"2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b#\u0010$J+\u0010+\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%2\b\b\u0002\u0010(\u001a\u00020'2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b+\u0010,Jg\u00105\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u00102\u0014\b\u0002\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u001c2\u0014\b\u0002\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u001c2\b\b\u0002\u00101\u001a\u00020\u00102\b\b\u0002\u00102\u001a\u00020\u00102\b\b\u0002\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J/\u00107\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u000203¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020\"¢\u0006\u0004\b9\u0010:R\u0018\u0010;\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010@R\u0018\u0010A\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010D\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00060F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000b0F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010H¨\u0006J"}, d2 = {"Lcom/stepos/agentcache/sdk/api/AgentCacheSdk;", "", "<init>", "()V", "Lc7/r;", "flushPendingEvents", "Lcom/stepos/agentcache/ipc/LogEventParcel;", "event", "enqueuePending", "(Lcom/stepos/agentcache/ipc/LogEventParcel;)V", "flushPendingLogs", "Lcom/stepos/agentcache/ipc/LogRecordParcel;", "log", "enqueuePendingLog", "(Lcom/stepos/agentcache/ipc/LogRecordParcel;)V", "Lcom/stepos/agentcache/sdk/api/LogMessage;", "", "toJsonString", "(Lcom/stepos/agentcache/sdk/api/LogMessage;)Ljava/lang/String;", "Lcom/stepos/agentcache/sdk/api/AgentCacheSendResult;", "result", "emitResult", "(Lcom/stepos/agentcache/sdk/api/AgentCacheSendResult;)V", OAuthConstants.FACTOR_RESULT_MESSAGE, "logD", "(Ljava/lang/String;)V", "buildTimestamp", "()Ljava/lang/String;", "", "map", "(Ljava/util/Map;)Ljava/lang/String;", "value", "normalizeJsonValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "containsNullValue", "(Ljava/lang/Object;)Z", "Landroid/content/Context;", "context", "Lcom/stepos/agentcache/sdk/api/AgentCacheConfig;", "config", "Lcom/stepos/agentcache/sdk/api/AgentCacheResultListener;", "listener", "init", "(Landroid/content/Context;Lcom/stepos/agentcache/sdk/api/AgentCacheConfig;Lcom/stepos/agentcache/sdk/api/AgentCacheResultListener;)V", ServiceContract.RequiredKeys.TRACE_ID, ServiceContract.RequiredKeys.NODE_NAME, "commonFields", "bizData", "inputText", "outputText", "", "statusCode", "reportEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;I)Z", "reportLog", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentcache/sdk/api/LogMessage;I)Z", "isInitialized", "()Z", "appContext", "Landroid/content/Context;", "Lcom/stepos/agentcache/sdk/internal/LogSdkClient;", "client", "Lcom/stepos/agentcache/sdk/internal/LogSdkClient;", "Lcom/stepos/agentcache/sdk/api/AgentCacheConfig;", "resultListener", "Lcom/stepos/agentcache/sdk/api/AgentCacheResultListener;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "pendingQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "pendingLogQueue", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AgentCacheSdk {
    private static volatile Context appContext;
    private static volatile LogSdkClient client;
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
        k.d(str, "format(...)");
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
        LogEventParcel logEventParcelPoll;
        LogSdkClient logSdkClient = client;
        if (logSdkClient == null || pendingQueue.isEmpty()) {
            return;
        }
        logSdkClient.bind();
        ArrayList arrayList = new ArrayList();
        while (arrayList.size() < config.getMaxPendingEvents() && (logEventParcelPoll = pendingQueue.poll()) != null) {
            arrayList.add(logEventParcelPoll);
        }
        if (arrayList.isEmpty() || logSdkClient.cacheEvents(arrayList)) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            INSTANCE.enqueuePending((LogEventParcel) it.next());
        }
    }

    private final void flushPendingLogs() {
        LogRecordParcel logRecordParcelPoll;
        LogSdkClient logSdkClient = client;
        if (logSdkClient == null || pendingLogQueue.isEmpty()) {
            return;
        }
        logSdkClient.bind();
        ArrayList arrayList = new ArrayList();
        while (arrayList.size() < config.getMaxPendingEvents() && (logRecordParcelPoll = pendingLogQueue.poll()) != null) {
            arrayList.add(logRecordParcelPoll);
        }
        if (arrayList.isEmpty() || logSdkClient.cacheLogs(arrayList)) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            INSTANCE.enqueuePendingLog((LogRecordParcel) it.next());
        }
    }

    public static /* synthetic */ void init$default(AgentCacheSdk agentCacheSdk, Context context, AgentCacheConfig agentCacheConfig, AgentCacheResultListener agentCacheResultListener, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            agentCacheConfig = new AgentCacheConfig(null, 0, false, 7, null);
        }
        if ((i2 & 4) != 0) {
            agentCacheResultListener = null;
        }
        agentCacheSdk.init(context, agentCacheConfig, agentCacheResultListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r init$lambda$0() {
        AgentCacheSdk agentCacheSdk = INSTANCE;
        agentCacheSdk.flushPendingEvents();
        agentCacheSdk.flushPendingLogs();
        return r.f1986a;
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

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean reportEvent$default(AgentCacheSdk agentCacheSdk, String str, String str2, Map map, Map map2, String str3, String str4, int i2, int i10, Object obj) {
        int i11 = i10 & 4;
        a0 a0Var = a0.f2944f;
        if (i11 != 0) {
            map = a0Var;
        }
        if ((i10 & 8) != 0) {
            map2 = a0Var;
        }
        if ((i10 & 16) != 0) {
            str3 = "";
        }
        if ((i10 & 32) != 0) {
            str4 = "";
        }
        if ((i10 & 64) != 0) {
            i2 = OAuthConstants.RESPONSE_CODE_OK;
        }
        return agentCacheSdk.reportEvent(str, str2, map, map2, str3, str4, i2);
    }

    public static /* synthetic */ boolean reportLog$default(AgentCacheSdk agentCacheSdk, String str, String str2, LogMessage logMessage, int i2, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            i2 = OAuthConstants.RESPONSE_CODE_OK;
        }
        return agentCacheSdk.reportLog(str, str2, logMessage, i2);
    }

    private final String toJsonString(LogMessage logMessage) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("level", logMessage.getLevel().name());
        jSONObject.put("event", logMessage.getEvent());
        jSONObject.put("log", logMessage.getLog());
        String stack = logMessage.getStack();
        if (stack != null && !ga.k.t0(stack)) {
            jSONObject.put("stack", logMessage.getStack());
        }
        String string = jSONObject.toString();
        k.d(string, "toString(...)");
        return string;
    }

    public final synchronized void init(Context context, AgentCacheConfig config2, AgentCacheResultListener listener) {
        k.e(context, "context");
        k.e(config2, "config");
        config = config2;
        resultListener = listener;
        appContext = context.getApplicationContext();
        Context context2 = appContext;
        k.b(context2);
        LogSdkClient logSdkClient = new LogSdkClient(context2, config2.getServicePackageName(), new d0(3));
        logSdkClient.bind();
        client = logSdkClient;
        initialized.set(true);
        logD("init completed, servicePackage=" + config2.getServicePackageName());
    }

    public final boolean isInitialized() {
        return initialized.get();
    }

    public final boolean reportEvent(String traceId, String nodeName, Map<String, ? extends Object> commonFields, Map<String, ? extends Object> bizData, String inputText, String outputText, int statusCode) {
        LogSdkClient logSdkClient;
        Object objN;
        Object objN2;
        k.e(traceId, ServiceContract.RequiredKeys.TRACE_ID);
        k.e(nodeName, ServiceContract.RequiredKeys.NODE_NAME);
        k.e(commonFields, "commonFields");
        k.e(bizData, "bizData");
        k.e(inputText, "inputText");
        k.e(outputText, "outputText");
        if (ga.k.t0(traceId) || ga.k.t0(nodeName)) {
            emitResult(new AgentCacheSendResult(false, "invalid_params", traceId));
            return false;
        }
        if (containsNullValue(commonFields) || containsNullValue(bizData)) {
            emitResult(new AgentCacheSendResult(false, "invalid_params_null_value", traceId));
            return false;
        }
        Context context = appContext;
        if (context == null || (logSdkClient = client) == null) {
            return false;
        }
        try {
            objN = context.getPackageName();
        } catch (Throwable th) {
            objN = e0.n(th);
        }
        if (objN instanceof l) {
            objN = "unknown";
        }
        String str = (String) objN;
        StringBuilder sbP = a.p("reportEvent: traceId=", traceId, ", nodeName=", nodeName, ", statusCode=");
        sbP.append(statusCode);
        logD(sbP.toString());
        try {
            objN2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (objN2 == null) {
                objN2 = "unknown";
            }
        } catch (Throwable th2) {
            objN2 = e0.n(th2);
        }
        String str2 = (String) (objN2 instanceof l ? "unknown" : objN2);
        LinkedHashMap linkedHashMap = new LinkedHashMap(commonFields);
        if (!ga.k.t0(inputText)) {
            linkedHashMap.put("input_text", inputText);
        }
        if (!ga.k.t0(outputText)) {
            linkedHashMap.put("output_text", outputText);
        }
        String string = ga.k.N0(traceId).toString();
        String string2 = ga.k.N0(nodeName).toString();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strBuildTimestamp = buildTimestamp();
        k.b(str);
        LogEventParcel logEventParcel = new LogEventParcel(string, string2, jCurrentTimeMillis, strBuildTimestamp, statusCode, str, str2, toJsonString(linkedHashMap), toJsonString(bizData));
        logSdkClient.bind();
        if (logSdkClient.cacheEvent(logEventParcel)) {
            emitResult(new AgentCacheSendResult(true, "sent", traceId));
            flushPendingEvents();
            return true;
        }
        enqueuePending(logEventParcel);
        emitResult(new AgentCacheSendResult(true, "service_unavailable_queued", traceId));
        return true;
    }

    public final boolean reportLog(String traceId, String nodeName, LogMessage message, int statusCode) {
        LogSdkClient logSdkClient;
        Object objN;
        Object objN2;
        k.e(traceId, ServiceContract.RequiredKeys.TRACE_ID);
        k.e(nodeName, ServiceContract.RequiredKeys.NODE_NAME);
        k.e(message, OAuthConstants.FACTOR_RESULT_MESSAGE);
        if (ga.k.t0(traceId) || ga.k.t0(nodeName) || ga.k.t0(message.getEvent()) || ga.k.t0(message.getLog())) {
            emitResult(new AgentCacheSendResult(false, "invalid_params", traceId));
            return false;
        }
        Context context = appContext;
        if (context == null || (logSdkClient = client) == null) {
            return false;
        }
        try {
            objN = context.getPackageName();
        } catch (Throwable th) {
            objN = e0.n(th);
        }
        if (objN instanceof l) {
            objN = "unknown";
        }
        String str = (String) objN;
        try {
            objN2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (objN2 == null) {
                objN2 = "unknown";
            }
        } catch (Throwable th2) {
            objN2 = e0.n(th2);
        }
        Object obj = objN2 instanceof l ? "unknown" : objN2;
        String string = ga.k.N0(traceId).toString();
        String string2 = ga.k.N0(nodeName).toString();
        String strBuildTimestamp = buildTimestamp();
        k.b(str);
        LogRecordParcel logRecordParcel = new LogRecordParcel(string, string2, strBuildTimestamp, statusCode, str, (String) obj, toJsonString(message));
        logSdkClient.bind();
        if (logSdkClient.cacheLog(logRecordParcel)) {
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
        k.d(string, "toString(...)");
        return string;
    }
}
