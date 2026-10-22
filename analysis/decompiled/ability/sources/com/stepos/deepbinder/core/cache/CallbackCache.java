package com.stepos.deepbinder.core.cache;

import D7.v;
import R3.c;
import R3.f;
import android.util.Pair;
import androidx.window.embedding.b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.deepbinder.core.api.IRecycle;
import com.stepos.deepbinder.core.log.IPCLog;
import com.stepos.deepbinder.core.tools.IPCRecycle;
import com.stepos.deepbinder.core.tools.TimeStampGenerator;
import com.stepos.taskrobot.llmapi.stepfun.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001!B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0001¢\u0006\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R,\u0010\u001f\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u001d\u0012\u0004\u0012\u00020\u001e0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/stepos/deepbinder/core/cache/CallbackCache;", "", AppAgent.CONSTRUCT, "()V", "", CallbackCache.TIME_STAMP, "getCallback", "(J)Ljava/lang/Object;", "", CallbackCache.PROCESS_NAME, "LC7/r;", "notifyCallbackToRecycle", "(Ljava/lang/String;)V", "callback", "", "isWeakRef", "isImmediateEviction", "putCallback", "(Ljava/lang/String;Ljava/lang/Object;ZZ)J", "removeCallback", "(J)V", "(Ljava/lang/Object;)V", "TAG", "Ljava/lang/String;", "KEY", "TIME_STAMP", "PROCESS_NAME", "SIZE", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/util/Pair;", "Lcom/stepos/deepbinder/core/cache/CallbackCache$CallbackWrapper;", "callbackWrapperMap", "Ljava/util/concurrent/ConcurrentHashMap;", "CallbackWrapper", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CallbackCache {
    private static final String KEY = "key";
    private static final String PROCESS_NAME = "processName";
    private static final String SIZE = "size";
    private static final String TAG = "CallbackCache";
    private static final String TIME_STAMP = "timeStamp";
    public static final CallbackCache INSTANCE = new CallbackCache();
    private static final ConcurrentHashMap<Pair<String, Long>, CallbackWrapper> callbackWrapperMap = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u0004\u0018\u00010\u0001J\u0006\u0010\u0004\u001a\u00020\u0003R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stepos/deepbinder/core/cache/CallbackCache$CallbackWrapper;", "", "isWeakRef", "", "isImmediateEviction", "callback", AppAgent.CONSTRUCT, "(ZZLjava/lang/Object;)V", "get", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CallbackWrapper {
        private final Object callback;
        private final boolean isImmediateEviction;

        public CallbackWrapper(boolean z10, boolean z11, Object callback) {
            k.f(callback, "callback");
            this.isImmediateEviction = z11;
            this.callback = z10 ? new WeakReference(callback) : callback;
        }

        public final Object get() {
            Object obj = this.callback;
            return obj instanceof WeakReference ? ((WeakReference) obj).get() : obj;
        }

        /* renamed from: isImmediateEviction, reason: from getter */
        public final boolean getIsImmediateEviction() {
            return this.isImmediateEviction;
        }
    }

    private CallbackCache() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean notifyCallbackToRecycle$lambda$1(String str, Map.Entry entry) {
        k.f(entry, "entry");
        if (!k.b(str, ((Pair) entry.getKey()).first)) {
            return false;
        }
        Object obj = ((CallbackWrapper) entry.getValue()).get();
        if (!(obj instanceof IRecycle)) {
            return true;
        }
        ((IRecycle) obj).onRecycle();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean notifyCallbackToRecycle$lambda$2(S7.k kVar, Object obj) {
        return ((Boolean) kVar.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeCallback$lambda$4(long j5, Map.Entry entry) {
        k.f(entry, "entry");
        Long l = (Long) ((Pair) entry.getKey()).second;
        if (l == null || l.longValue() != j5) {
            return false;
        }
        IPCLog.INSTANCE.d(TAG, "[passive][removeCallback]", KEY, entry.getKey());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeCallback$lambda$5(S7.k kVar, Object obj) {
        return ((Boolean) kVar.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeCallback$lambda$6(Object obj, Map.Entry entry) {
        k.f(entry, "entry");
        if (((CallbackWrapper) entry.getValue()).get() != obj) {
            return false;
        }
        IPCLog.INSTANCE.d(TAG, "[initiative][removeCallback]", KEY, entry.getKey());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeCallback$lambda$7(S7.k kVar, Object obj) {
        return ((Boolean) kVar.invoke(obj)).booleanValue();
    }

    public final Object getCallback(long timeStamp) {
        Set<Map.Entry<Pair<String, Long>, CallbackWrapper>> setEntrySet = callbackWrapperMap.entrySet();
        k.e(setEntrySet, "<get-entries>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : setEntrySet) {
            Long l = (Long) ((Pair) ((Map.Entry) obj).getKey()).second;
            if (l != null && l.longValue() == timeStamp) {
                arrayList.add(obj);
            }
        }
        Set setJ1 = v.j1(arrayList);
        if (setJ1.isEmpty()) {
            IPCLog.INSTANCE.d(TAG, "[getCallback][Null]", TIME_STAMP, Long.valueOf(timeStamp));
            return null;
        }
        Object objZ0 = v.z0(setJ1);
        k.e(objZ0, "first(...)");
        Map.Entry entry = (Map.Entry) objZ0;
        Object obj2 = ((CallbackWrapper) entry.getValue()).get();
        if (obj2 == null || ((CallbackWrapper) entry.getValue()).getIsImmediateEviction()) {
            IPCLog.INSTANCE.d(TAG, "[getCallback][Recycled]", KEY, entry.getKey());
            callbackWrapperMap.remove(entry.getKey());
        }
        IPCLog.INSTANCE.d(TAG, "[getCallback][Success]", KEY, entry.getKey());
        return obj2;
    }

    public final void notifyCallbackToRecycle(String processName) {
        k.f(processName, "processName");
        IPCLog.INSTANCE.d(TAG, "[notifyCallbackToRecycle]", PROCESS_NAME, processName);
        callbackWrapperMap.entrySet().removeIf(new b(new c(processName, 21), 10));
    }

    public final synchronized long putCallback(String processName, Object callback, boolean isWeakRef, boolean isImmediateEviction) {
        try {
            k.f(processName, "processName");
            k.f(callback, "callback");
            Set<Map.Entry<Pair<String, Long>, CallbackWrapper>> setEntrySet = callbackWrapperMap.entrySet();
            k.e(setEntrySet, "<get-entries>(...)");
            ArrayList arrayList = new ArrayList();
            for (Object obj : setEntrySet) {
                if (((CallbackWrapper) ((Map.Entry) obj).getValue()).get() == callback) {
                    arrayList.add(obj);
                }
            }
            Set setJ1 = v.j1(arrayList);
            if (setJ1.isEmpty()) {
                long timeStamp = TimeStampGenerator.INSTANCE.getTimeStamp();
                Pair<String, Long> pair = new Pair<>(processName, Long.valueOf(timeStamp));
                callbackWrapperMap.put(pair, new CallbackWrapper(isWeakRef, isImmediateEviction, callback));
                IPCLog.INSTANCE.d(TAG, "[putCallback]", KEY, pair);
                IPCRecycle.INSTANCE.getInstance().registerLifeCycle(callback, timeStamp);
                return timeStamp;
            }
            Object objZ0 = v.z0(setJ1);
            k.e(objZ0, "first(...)");
            Map.Entry entry = (Map.Entry) objZ0;
            IPCLog.INSTANCE.d(TAG, "[putCallback][Exists]", KEY, entry.getKey());
            Object second = ((Pair) entry.getKey()).second;
            k.e(second, "second");
            return ((Number) second).longValue();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void removeCallback(long timeStamp) {
        ConcurrentHashMap<Pair<String, Long>, CallbackWrapper> concurrentHashMap = callbackWrapperMap;
        concurrentHashMap.entrySet().removeIf(new b(new f(timeStamp, 5), 9));
        IPCLog.INSTANCE.d(TAG, "[Remain]", SIZE, Integer.valueOf(concurrentHashMap.size()));
    }

    public final void removeCallback(Object callback) {
        k.f(callback, "callback");
        callbackWrapperMap.entrySet().removeIf(new b(new g(callback, 5), 8));
    }
}
