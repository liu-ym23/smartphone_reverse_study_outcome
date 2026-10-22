package com.stepos.agentcache.sdk.api;

import a.a;
import android.content.Context;
import android.util.Log;
import b5.a0;
import b5.h;
import b5.i;
import c5.t;
import com.stepos.agentcache.ipc.ILogIngestService;
import com.stepos.agentcache.ipc.LogEventParcel;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.OperationResult;
import i3.b;
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
import kotlin.jvm.internal.p;
import org.bouncycastle.asn1.x509.DisplayText;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0016\u001a\u00020\u000e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ+\u0010$\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020 2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b$\u0010%Jg\u0010.\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000e2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00142\u0014\b\u0002\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00142\b\b\u0002\u0010*\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020\u000e2\b\b\u0002\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\u001b¢\u0006\u0004\b0\u00101R\u0018\u00102\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u00107R\u0018\u00108\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00060=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006@"}, d2 = {"Lcom/stepos/agentcache/sdk/api/AgentCacheSdk;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Lb5/a0;", "flushPendingEvents", "Lcom/stepos/agentcache/ipc/LogEventParcel;", "event", "enqueuePending", "(Lcom/stepos/agentcache/ipc/LogEventParcel;)V", "Lcom/stepos/agentcache/sdk/api/AgentCacheSendResult;", "result", "emitResult", "(Lcom/stepos/agentcache/sdk/api/AgentCacheSendResult;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, OperationResult.EXTRA_MESSAGE, "logD", "(Ljava/lang/String;)V", "buildTimestamp", "()Ljava/lang/String;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "map", "toJsonString", "(Ljava/util/Map;)Ljava/lang/String;", "value", "normalizeJsonValue", "(Ljava/lang/Object;)Ljava/lang/Object;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "containsNullValue", "(Ljava/lang/Object;)Z", "Landroid/content/Context;", "context", "Lcom/stepos/agentcache/sdk/api/AgentCacheConfig;", "config", "Lcom/stepos/agentcache/sdk/api/AgentCacheResultListener;", "listener", "init", "(Landroid/content/Context;Lcom/stepos/agentcache/sdk/api/AgentCacheConfig;Lcom/stepos/agentcache/sdk/api/AgentCacheResultListener;)V", "traceId", "nodeName", "commonFields", "bizData", "inputText", "outputText", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "statusCode", "reportEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;I)Z", "isInitialized", "()Z", "appContext", "Landroid/content/Context;", "Li3/b;", "client", "Li3/b;", "Lcom/stepos/agentcache/sdk/api/AgentCacheConfig;", "resultListener", "Lcom/stepos/agentcache/sdk/api/AgentCacheResultListener;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "pendingQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AgentCacheSdk {
    private static volatile Context appContext;
    private static volatile b client;
    private static volatile AgentCacheResultListener resultListener;
    public static final AgentCacheSdk INSTANCE = new AgentCacheSdk();
    private static volatile AgentCacheConfig config = new AgentCacheConfig(null, 0, false, 7, null);
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static final ConcurrentLinkedQueue<LogEventParcel> pendingQueue = new ConcurrentLinkedQueue<>();

    private AgentCacheSdk() {
    }

    private final String buildTimestamp() {
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(Long.valueOf(System.currentTimeMillis()));
        p.d(str, "format(...)");
        return str;
    }

    private final boolean containsNullValue(Object value) {
        if (value == null) {
            return true;
        }
        if (value instanceof Map) {
            Collection collectionValues = ((Map) value).values();
            if (collectionValues != null && collectionValues.isEmpty()) {
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

    private final void flushPendingEvents() {
        Object objO;
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
        AtomicReference atomicReference = bVar.f3145c;
        int i8 = 0;
        try {
            ILogIngestService iLogIngestService = (ILogIngestService) atomicReference.get();
            if (iLogIngestService != null) {
                iLogIngestService.cacheEvents(new ArrayList(arrayList));
            }
            boolean z = atomicReference.get() != null;
            Log.d("LogSdkClient", "cacheEvents count=" + arrayList.size() + ", success=" + z);
            objO = Boolean.valueOf(z);
        } catch (Throwable th) {
            objO = a.o(th);
        }
        Throwable thA = i.a(objO);
        if (thA != null) {
            a8.b.y("cacheEvents failed: ", thA.getMessage(), "LogSdkClient");
            objO = Boolean.FALSE;
        }
        if (((Boolean) objO).booleanValue()) {
            return;
        }
        int size = arrayList.size();
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            INSTANCE.enqueuePending((LogEventParcel) obj);
        }
    }

    public static /* synthetic */ void init$default(AgentCacheSdk agentCacheSdk, Context context, AgentCacheConfig agentCacheConfig, AgentCacheResultListener agentCacheResultListener, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            agentCacheConfig = new AgentCacheConfig(null, 0, false, 7, null);
        }
        if ((i8 & 4) != 0) {
            agentCacheResultListener = null;
        }
        agentCacheSdk.init(context, agentCacheConfig, agentCacheResultListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 init$lambda$0() {
        INSTANCE.flushPendingEvents();
        return a0.f883a;
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
    public static /* synthetic */ boolean reportEvent$default(AgentCacheSdk agentCacheSdk, String str, String str2, Map map, Map map2, String str3, String str4, int i8, int i9, Object obj) {
        int i10 = i9 & 4;
        t tVar = t.f1093a;
        if (i10 != 0) {
            map = tVar;
        }
        if ((i9 & 8) != 0) {
            map2 = tVar;
        }
        if ((i9 & 16) != 0) {
            str3 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        if ((i9 & 32) != 0) {
            str4 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        if ((i9 & 64) != 0) {
            i8 = DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE;
        }
        return agentCacheSdk.reportEvent(str, str2, map, map2, str3, str4, i8);
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
        p.d(string, "toString(...)");
        return string;
    }

    public final synchronized void init(Context context, AgentCacheConfig config2, AgentCacheResultListener listener) {
        p.e(context, "context");
        p.e(config2, "config");
        config = config2;
        resultListener = listener;
        appContext = context.getApplicationContext();
        Context context2 = appContext;
        p.b(context2);
        client = new b(context2, config2.getServicePackageName(), new a4.b(29));
        initialized.set(true);
        logD("init completed, servicePackage=" + config2.getServicePackageName());
    }

    public final boolean isInitialized() {
        return initialized.get();
    }

    public final boolean reportEvent(String traceId, String nodeName, Map<String, ? extends Object> commonFields, Map<String, ? extends Object> bizData, String inputText, String outputText, int statusCode) {
        b bVar;
        Object objO;
        Object objO2;
        Object objO3;
        p.e(traceId, "traceId");
        p.e(nodeName, "nodeName");
        p.e(commonFields, "commonFields");
        p.e(bizData, "bizData");
        p.e(inputText, "inputText");
        p.e(outputText, "outputText");
        if (n.t1(traceId) || n.t1(nodeName)) {
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
            objO = context.getPackageName();
        } catch (Throwable th) {
            objO = a.o(th);
        }
        if (objO instanceof h) {
            objO = "unknown";
        }
        String str = (String) objO;
        StringBuilder sbV = a8.b.v("reportEvent: ", traceId, ", ", nodeName, ", ");
        sbV.append(commonFields);
        sbV.append(", ");
        sbV.append(bizData);
        sbV.append(", ");
        a8.b.A(sbV, inputText, ", ", outputText, ", ");
        sbV.append(statusCode);
        Log.d("AgentCacheSdk", sbV.toString());
        try {
            objO2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (objO2 == null) {
                objO2 = "unknown";
            }
        } catch (Throwable th2) {
            objO2 = a.o(th2);
        }
        String str2 = (String) (objO2 instanceof h ? "unknown" : objO2);
        LinkedHashMap linkedHashMap = new LinkedHashMap(commonFields);
        if (!n.t1(inputText)) {
            linkedHashMap.put("input_text", inputText);
        }
        if (!n.t1(outputText)) {
            linkedHashMap.put("output_text", outputText);
        }
        String string = n.T1(traceId).toString();
        String string2 = n.T1(nodeName).toString();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strBuildTimestamp = buildTimestamp();
        p.b(str);
        LogEventParcel logEventParcel = new LogEventParcel(string, string2, jCurrentTimeMillis, strBuildTimestamp, statusCode, str, str2, toJsonString(linkedHashMap), toJsonString(bizData));
        bVar.a();
        AtomicReference atomicReference = bVar.f3145c;
        try {
            ILogIngestService iLogIngestService = (ILogIngestService) atomicReference.get();
            if (iLogIngestService != null) {
                iLogIngestService.cacheEvent(logEventParcel);
            }
            boolean z = atomicReference.get() != null;
            Log.d("LogSdkClient", "cacheEvent traceId=" + logEventParcel.getTraceId() + ", success=" + z);
            objO3 = Boolean.valueOf(z);
        } catch (Throwable th3) {
            objO3 = a.o(th3);
        }
        Throwable thA = i.a(objO3);
        if (thA != null) {
            a8.b.y("cacheEvent failed: ", thA.getMessage(), "LogSdkClient");
            objO3 = Boolean.FALSE;
        }
        if (((Boolean) objO3).booleanValue()) {
            emitResult(new AgentCacheSendResult(true, "sent", traceId));
            flushPendingEvents();
            return true;
        }
        enqueuePending(logEventParcel);
        emitResult(new AgentCacheSendResult(true, "service_unavailable_queued", traceId));
        return true;
    }
}
