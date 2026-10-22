package com.stepos.deepbinder.core.cache;

import Z8.F;
import android.util.Pair;
import com.stepos.deepbinder.core.api.IRecycle;
import com.stepos.deepbinder.core.cache.CallbackCache;
import com.stepos.deepbinder.core.log.IPCLog;
import com.stepos.deepbinder.core.tools.IPCRecycle;
import com.stepos.deepbinder.core.tools.TimeStampGenerator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001!B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0001¢\u0006\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R,\u0010\u001f\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u001d\u0012\u0004\u0012\u00020\u001e0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/stepos/deepbinder/core/cache/CallbackCache;", "", "<init>", "()V", "", CallbackCache.TIME_STAMP, "getCallback", "(J)Ljava/lang/Object;", "", CallbackCache.PROCESS_NAME, "LY8/t;", "notifyCallbackToRecycle", "(Ljava/lang/String;)V", "callback", "", "isWeakRef", "isImmediateEviction", "putCallback", "(Ljava/lang/String;Ljava/lang/Object;ZZ)J", "removeCallback", "(J)V", "(Ljava/lang/Object;)V", "TAG", "Ljava/lang/String;", "KEY", "TIME_STAMP", "PROCESS_NAME", "SIZE", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/util/Pair;", "Lcom/stepos/deepbinder/core/cache/CallbackCache$CallbackWrapper;", "callbackWrapperMap", "Ljava/util/concurrent/ConcurrentHashMap;", "CallbackWrapper", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CallbackCache {
    private static final String KEY = "key";
    private static final String PROCESS_NAME = "processName";
    private static final String SIZE = "size";
    private static final String TAG = "CallbackCache";
    private static final String TIME_STAMP = "timeStamp";
    public static final CallbackCache INSTANCE = new CallbackCache();
    private static final ConcurrentHashMap<Pair<String, Long>, CallbackWrapper> callbackWrapperMap = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u0004\u0018\u00010\u0001J\u0006\u0010\u0004\u001a\u00020\u0003R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stepos/deepbinder/core/cache/CallbackCache$CallbackWrapper;", "", "isWeakRef", "", "isImmediateEviction", "callback", "<init>", "(ZZLjava/lang/Object;)V", "get", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CallbackWrapper {
        private final Object callback;
        private final boolean isImmediateEviction;

        public CallbackWrapper(boolean z10, boolean z11, Object callback) {
            p.i(callback, "callback");
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
        p.i(entry, "entry");
        if (!p.d(str, ((Pair) entry.getKey()).first)) {
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
    public static final boolean notifyCallbackToRecycle$lambda$2(InterfaceC5074l interfaceC5074l, Object obj) {
        return ((Boolean) interfaceC5074l.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeCallback$lambda$4(long j10, Map.Entry entry) {
        p.i(entry, "entry");
        Long l10 = (Long) ((Pair) entry.getKey()).second;
        if (l10 == null || l10.longValue() != j10) {
            return false;
        }
        IPCLog.INSTANCE.d(TAG, "[passive][removeCallback]", KEY, entry.getKey());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeCallback$lambda$5(InterfaceC5074l interfaceC5074l, Object obj) {
        return ((Boolean) interfaceC5074l.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeCallback$lambda$6(Object obj, Map.Entry entry) {
        p.i(entry, "entry");
        if (((CallbackWrapper) entry.getValue()).get() != obj) {
            return false;
        }
        IPCLog.INSTANCE.d(TAG, "[initiative][removeCallback]", KEY, entry.getKey());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeCallback$lambda$7(InterfaceC5074l interfaceC5074l, Object obj) {
        return ((Boolean) interfaceC5074l.invoke(obj)).booleanValue();
    }

    public final Object getCallback(long timeStamp) {
        Set<Map.Entry<Pair<String, Long>, CallbackWrapper>> setEntrySet = callbackWrapperMap.entrySet();
        p.h(setEntrySet, "<get-entries>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : setEntrySet) {
            Long l10 = (Long) ((Pair) ((Map.Entry) obj).getKey()).second;
            if (l10 != null && l10.longValue() == timeStamp) {
                arrayList.add(obj);
            }
        }
        Set setR1 = F.r1(arrayList);
        if (setR1.isEmpty()) {
            IPCLog.INSTANCE.d(TAG, "[getCallback][Null]", TIME_STAMP, Long.valueOf(timeStamp));
            return null;
        }
        Object objP0 = F.p0(setR1);
        p.h(objP0, "first(...)");
        Map.Entry entry = (Map.Entry) objP0;
        Object obj2 = ((CallbackWrapper) entry.getValue()).get();
        if (obj2 == null || ((CallbackWrapper) entry.getValue()).getIsImmediateEviction()) {
            IPCLog.INSTANCE.d(TAG, "[getCallback][Recycled]", KEY, entry.getKey());
            callbackWrapperMap.remove(entry.getKey());
        }
        IPCLog.INSTANCE.d(TAG, "[getCallback][Success]", KEY, entry.getKey());
        return obj2;
    }

    public final void notifyCallbackToRecycle(final String processName) {
        p.i(processName, "processName");
        IPCLog.INSTANCE.d(TAG, "[notifyCallbackToRecycle]", PROCESS_NAME, processName);
        Set<Map.Entry<Pair<String, Long>, CallbackWrapper>> setEntrySet = callbackWrapperMap.entrySet();
        final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: h7.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(CallbackCache.notifyCallbackToRecycle$lambda$1(processName, (Map.Entry) obj));
            }
        };
        setEntrySet.removeIf(new Predicate() { // from class: h7.f
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CallbackCache.notifyCallbackToRecycle$lambda$2(interfaceC5074l, obj);
            }
        });
    }

    public final synchronized long putCallback(String processName, Object callback, boolean isWeakRef, boolean isImmediateEviction) {
        try {
            p.i(processName, "processName");
            p.i(callback, "callback");
            Set<Map.Entry<Pair<String, Long>, CallbackWrapper>> setEntrySet = callbackWrapperMap.entrySet();
            p.h(setEntrySet, "<get-entries>(...)");
            ArrayList arrayList = new ArrayList();
            for (Object obj : setEntrySet) {
                if (((CallbackWrapper) ((Map.Entry) obj).getValue()).get() == callback) {
                    arrayList.add(obj);
                }
            }
            Set setR1 = F.r1(arrayList);
            if (setR1.isEmpty()) {
                long timeStamp = TimeStampGenerator.INSTANCE.getTimeStamp();
                Pair<String, Long> pair = new Pair<>(processName, Long.valueOf(timeStamp));
                callbackWrapperMap.put(pair, new CallbackWrapper(isWeakRef, isImmediateEviction, callback));
                IPCLog.INSTANCE.d(TAG, "[putCallback]", KEY, pair);
                IPCRecycle.INSTANCE.getInstance().registerLifeCycle(callback, timeStamp);
                return timeStamp;
            }
            Object objP0 = F.p0(setR1);
            p.h(objP0, "first(...)");
            Map.Entry entry = (Map.Entry) objP0;
            IPCLog.INSTANCE.d(TAG, "[putCallback][Exists]", KEY, entry.getKey());
            Object second = ((Pair) entry.getKey()).second;
            p.h(second, "second");
            return ((Number) second).longValue();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void removeCallback(final long timeStamp) {
        ConcurrentHashMap<Pair<String, Long>, CallbackWrapper> concurrentHashMap = callbackWrapperMap;
        Set<Map.Entry<Pair<String, Long>, CallbackWrapper>> setEntrySet = concurrentHashMap.entrySet();
        final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: h7.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(CallbackCache.removeCallback$lambda$4(timeStamp, (Map.Entry) obj));
            }
        };
        setEntrySet.removeIf(new Predicate() { // from class: h7.d
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CallbackCache.removeCallback$lambda$5(interfaceC5074l, obj);
            }
        });
        IPCLog.INSTANCE.d(TAG, "[Remain]", "size", Integer.valueOf(concurrentHashMap.size()));
    }

    public final void removeCallback(final Object callback) {
        p.i(callback, "callback");
        Set<Map.Entry<Pair<String, Long>, CallbackWrapper>> setEntrySet = callbackWrapperMap.entrySet();
        final InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: h7.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(CallbackCache.removeCallback$lambda$6(callback, (Map.Entry) obj));
            }
        };
        setEntrySet.removeIf(new Predicate() { // from class: h7.b
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CallbackCache.removeCallback$lambda$7(interfaceC5074l, obj);
            }
        });
    }
}
