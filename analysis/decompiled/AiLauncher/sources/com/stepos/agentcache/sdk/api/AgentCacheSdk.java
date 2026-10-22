package com.stepos.agentcache.sdk.api;

import La.H;
import Y8.t;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import c4.C1495a;
import com.stepos.agentcache.ipc.LogEventParcel;
import com.stepos.agentcache.ipc.LogRecordParcel;
import com.stepos.agentcache.sdk.api.AgentCacheSdk;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.statsapp.v3.lib.plugin.events.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.a;
import kotlin.jvm.internal.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0011\u001a\u00020\u0010*\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u001cH\u0002¢\u0006\u0004\b\u0011\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0001H\u0002¢\u0006\u0004\b \u0010!J\u0019\u0010#\u001a\u00020\"2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b#\u0010$J+\u0010+\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%2\b\b\u0002\u0010(\u001a\u00020'2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b+\u0010,Jg\u00105\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u00102\u0014\b\u0002\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u001c2\u0014\b\u0002\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u001c2\b\b\u0002\u00101\u001a\u00020\u00102\b\b\u0002\u00102\u001a\u00020\u00102\b\b\u0002\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J/\u00107\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u000203¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020\"¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020\"¢\u0006\u0004\b;\u0010:R\u0018\u0010<\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010AR\u0018\u0010B\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010E\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00060G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000b0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010I¨\u0006K"}, d2 = {"Lcom/stepos/agentcache/sdk/api/AgentCacheSdk;", "", "<init>", "()V", "LY8/t;", "flushPendingEvents", "Lcom/stepos/agentcache/ipc/LogEventParcel;", "event", "enqueuePending", "(Lcom/stepos/agentcache/ipc/LogEventParcel;)V", "flushPendingLogs", "Lcom/stepos/agentcache/ipc/LogRecordParcel;", b.f30786f, "enqueuePendingLog", "(Lcom/stepos/agentcache/ipc/LogRecordParcel;)V", "Lcom/stepos/agentcache/sdk/api/LogMessage;", "", "toJsonString", "(Lcom/stepos/agentcache/sdk/api/LogMessage;)Ljava/lang/String;", "Lcom/stepos/agentcache/sdk/api/AgentCacheSendResult;", "result", "emitResult", "(Lcom/stepos/agentcache/sdk/api/AgentCacheSendResult;)V", "message", "logD", "(Ljava/lang/String;)V", "buildTimestamp", "()Ljava/lang/String;", "", C3081a.FOCUS_MAP_NAME, "(Ljava/util/Map;)Ljava/lang/String;", UxipConstants.f30680s, "normalizeJsonValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "containsNullValue", "(Ljava/lang/Object;)Z", "Landroid/content/Context;", "context", "Lcom/stepos/agentcache/sdk/api/AgentCacheConfig;", "config", "Lcom/stepos/agentcache/sdk/api/AgentCacheResultListener;", "listener", "init", "(Landroid/content/Context;Lcom/stepos/agentcache/sdk/api/AgentCacheConfig;Lcom/stepos/agentcache/sdk/api/AgentCacheResultListener;)V", DidiCardProvider.KEY_TRACE_ID, "nodeName", "commonFields", "bizData", "inputText", "outputText", "", "statusCode", "reportEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;I)Z", "reportLog", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentcache/sdk/api/LogMessage;I)Z", "clearCache", "()Z", "isInitialized", "appContext", "Landroid/content/Context;", "Lc4/a;", "client", "Lc4/a;", "Lcom/stepos/agentcache/sdk/api/AgentCacheConfig;", "resultListener", "Lcom/stepos/agentcache/sdk/api/AgentCacheResultListener;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "pendingQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "pendingLogQueue", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentCacheSdk {
    private static volatile Context appContext;
    private static volatile C1495a client;
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
        p.h(str, "format(...)");
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
        C1495a c1495a = client;
        if (c1495a == null || pendingQueue.isEmpty()) {
            return;
        }
        c1495a.d();
        ArrayList arrayList = new ArrayList();
        while (arrayList.size() < config.getMaxPendingEvents() && (logEventParcelPoll = pendingQueue.poll()) != null) {
            arrayList.add(logEventParcelPoll);
        }
        if (arrayList.isEmpty() || c1495a.f(arrayList)) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            INSTANCE.enqueuePending((LogEventParcel) it.next());
        }
    }

    private final void flushPendingLogs() {
        LogRecordParcel logRecordParcelPoll;
        C1495a c1495a = client;
        if (c1495a == null || pendingLogQueue.isEmpty()) {
            return;
        }
        c1495a.d();
        ArrayList arrayList = new ArrayList();
        while (arrayList.size() < config.getMaxPendingEvents() && (logRecordParcelPoll = pendingLogQueue.poll()) != null) {
            arrayList.add(logRecordParcelPoll);
        }
        if (arrayList.isEmpty() || c1495a.h(arrayList)) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            INSTANCE.enqueuePendingLog((LogRecordParcel) it.next());
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
    public static final t init$lambda$0() {
        AgentCacheSdk agentCacheSdk = INSTANCE;
        agentCacheSdk.flushPendingEvents();
        agentCacheSdk.flushPendingLogs();
        return t.f7040a;
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

    public static /* synthetic */ boolean reportEvent$default(AgentCacheSdk agentCacheSdk, String str, String str2, Map map, Map map2, String str3, String str4, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            map = a.i();
        }
        Map map3 = map;
        if ((i11 & 8) != 0) {
            map2 = a.i();
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
        jSONObject.put(b.f30786f, logMessage.getLog());
        String stack = logMessage.getStack();
        if (stack != null && !H.x0(stack)) {
            jSONObject.put("stack", logMessage.getStack());
        }
        String string = jSONObject.toString();
        p.h(string, "toString(...)");
        return string;
    }

    public final boolean clearCache() {
        Object objB;
        pendingQueue.clear();
        pendingLogQueue.clear();
        Context context = appContext;
        if (context == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(context.getContentResolver().delete(Uri.parse("content://com.stepos.agentcache.provider.purge"), null, null) > 0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w("AgentCacheSdk", "clearCache failed: " + thE.getMessage());
            objB = Boolean.FALSE;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final synchronized void init(Context context, AgentCacheConfig config2, AgentCacheResultListener listener) {
        p.i(context, "context");
        p.i(config2, "config");
        config = config2;
        resultListener = listener;
        appContext = context.getApplicationContext();
        Context context2 = appContext;
        p.f(context2);
        C1495a c1495a = new C1495a(context2, config2.getServicePackageName(), new InterfaceC5063a() { // from class: b4.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentCacheSdk.init$lambda$0();
            }
        });
        c1495a.d();
        client = c1495a;
        initialized.set(true);
        logD("init completed, servicePackage=" + config2.getServicePackageName());
    }

    public final boolean isInitialized() {
        return initialized.get();
    }

    public final boolean reportEvent(String traceId, String nodeName, Map<String, ? extends Object> commonFields, Map<String, ? extends Object> bizData, String inputText, String outputText, int statusCode) {
        C1495a c1495a;
        Object objB;
        Object objB2;
        p.i(traceId, "traceId");
        p.i(nodeName, "nodeName");
        p.i(commonFields, "commonFields");
        p.i(bizData, "bizData");
        p.i(inputText, "inputText");
        p.i(outputText, "outputText");
        if (H.x0(traceId) || H.x0(nodeName)) {
            emitResult(new AgentCacheSendResult(false, "invalid_params", traceId));
            return false;
        }
        if (containsNullValue(commonFields) || containsNullValue(bizData)) {
            emitResult(new AgentCacheSendResult(false, "invalid_params_null_value", traceId));
            return false;
        }
        Context context = appContext;
        if (context == null || (c1495a = client) == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(context.getPackageName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = "unknown";
        }
        String str = (String) objB;
        logD("reportEvent: traceId=" + traceId + ", nodeName=" + nodeName + ", statusCode=" + statusCode);
        try {
            String str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (str2 == null) {
                str2 = "unknown";
            }
            objB2 = Result.b(str2);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        String str3 = (String) (Result.g(objB2) ? "unknown" : objB2);
        LinkedHashMap linkedHashMap = new LinkedHashMap(commonFields);
        if (!H.x0(inputText)) {
            linkedHashMap.put("input_text", inputText);
        }
        if (!H.x0(outputText)) {
            linkedHashMap.put("output_text", outputText);
        }
        String string = H.D1(traceId).toString();
        String string2 = H.D1(nodeName).toString();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strBuildTimestamp = buildTimestamp();
        p.f(str);
        LogEventParcel logEventParcel = new LogEventParcel(string, string2, jCurrentTimeMillis, strBuildTimestamp, statusCode, str, str3, toJsonString(linkedHashMap), toJsonString(bizData));
        c1495a.d();
        if (c1495a.e(logEventParcel)) {
            emitResult(new AgentCacheSendResult(true, "sent", traceId));
            flushPendingEvents();
            return true;
        }
        enqueuePending(logEventParcel);
        emitResult(new AgentCacheSendResult(true, "service_unavailable_queued", traceId));
        return true;
    }

    public final boolean reportLog(String traceId, String nodeName, LogMessage message, int statusCode) {
        C1495a c1495a;
        Object objB;
        Object objB2;
        p.i(traceId, "traceId");
        p.i(nodeName, "nodeName");
        p.i(message, "message");
        if (H.x0(traceId) || H.x0(nodeName) || H.x0(message.getEvent()) || H.x0(message.getLog())) {
            emitResult(new AgentCacheSendResult(false, "invalid_params", traceId));
            return false;
        }
        Context context = appContext;
        if (context == null || (c1495a = client) == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(context.getPackageName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = "unknown";
        }
        String str = (String) objB;
        try {
            String str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (str2 == null) {
                str2 = "unknown";
            }
            objB2 = Result.b(str2);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        Object obj = Result.g(objB2) ? "unknown" : objB2;
        String string = H.D1(traceId).toString();
        String string2 = H.D1(nodeName).toString();
        String strBuildTimestamp = buildTimestamp();
        p.f(str);
        LogRecordParcel logRecordParcel = new LogRecordParcel(string, string2, strBuildTimestamp, statusCode, str, (String) obj, toJsonString(message));
        c1495a.d();
        if (c1495a.g(logRecordParcel)) {
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
        p.h(string, "toString(...)");
        return string;
    }
}
