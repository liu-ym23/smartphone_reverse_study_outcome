package com.stepos.core.ota.bridge;

import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.download.IDownloadCallback;
import com.stepos.core.ota.d;
import com.stepos.core.ota.data.DownloadStateKt;
import com.stepos.core.ota.domain.OtaState;
import com.stepos.core.ota.domain.OtaStateSnapshot;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.KotlinNothingValueException;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import lb.n;
import qb.b;
import rb.c;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CallbackSubscriber {
    private final String TAG;
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, IDownloadCallback>> callbacks;
    private final HashMap<String, OtaStateSnapshot> last;
    private final l<String, String> pathResolver;
    private final StateFlow<Map<String, OtaStateSnapshot>> state;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @c(c = "com.stepos.core.ota.bridge.CallbackSubscriber$1", f = "CallbackSubscriber.kt", l = {41}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.bridge.CallbackSubscriber$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
        int label;

        public AnonymousClass1(b<? super AnonymousClass1> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            return CallbackSubscriber.this.new AnonymousClass1(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                StateFlow stateFlow = CallbackSubscriber.this.state;
                final CallbackSubscriber callbackSubscriber = CallbackSubscriber.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.stepos.core.ota.bridge.CallbackSubscriber.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, b bVar) {
                        return emit((Map<String, OtaStateSnapshot>) obj2, (b<? super n>) bVar);
                    }

                    public final Object emit(Map<String, OtaStateSnapshot> map, b<? super n> bVar) {
                        Collection<OtaStateSnapshot> collectionValues = map.values();
                        CallbackSubscriber callbackSubscriber2 = callbackSubscriber;
                        Iterator<T> it = collectionValues.iterator();
                        while (it.hasNext()) {
                            callbackSubscriber2.dispatchIfChanged((OtaStateSnapshot) it.next());
                        }
                        return n.f10413a;
                    }
                };
                this.label = 1;
                if (stateFlow.collect(flowCollector, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CallbackSubscriber(CoroutineScope scope, StateFlow<? extends Map<String, OtaStateSnapshot>> state, l<? super String, String> pathResolver) {
        g.f(scope, "scope");
        g.f(state, "state");
        g.f(pathResolver, "pathResolver");
        this.state = state;
        this.pathResolver = pathResolver;
        this.TAG = "OtaCallbackBridge";
        this.callbacks = new ConcurrentHashMap<>();
        this.last = new HashMap<>();
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchIfChanged(OtaStateSnapshot otaStateSnapshot) {
        OtaStateSnapshot otaStateSnapshot2 = this.last.get(otaStateSnapshot.getOtaId());
        if (otaStateSnapshot2 != null && g.b(otaStateSnapshot2.getState(), otaStateSnapshot.getState()) && otaStateSnapshot2.getProgress() == otaStateSnapshot.getProgress()) {
            return;
        }
        this.last.put(otaStateSnapshot.getOtaId(), otaStateSnapshot);
        ConcurrentHashMap<String, IDownloadCallback> concurrentHashMap = this.callbacks.get(otaStateSnapshot.getOtaId());
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, IDownloadCallback>> it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            IDownloadCallback value = it.next().getValue();
            if (!dispatchTo(value, otaStateSnapshot)) {
                AIEngineLogger.w(LogModule.OTA, this.TAG, "callback dead, removing: " + otaStateSnapshot.getOtaId());
                concurrentHashMap.values().remove(value);
            }
        }
    }

    private final boolean dispatchTo(IDownloadCallback iDownloadCallback, OtaStateSnapshot otaStateSnapshot) {
        Object objA;
        int downloadStateCode = DownloadStateKt.toDownloadStateCode(otaStateSnapshot.getState());
        try {
            iDownloadCallback.onUpdate(downloadStateCode, otaStateSnapshot.getProgress());
            OtaState state = otaStateSnapshot.getState();
            if (state instanceof OtaState.Downloading) {
                iDownloadCallback.onProgress(otaStateSnapshot.getProgress(), ((OtaState.Downloading) state).getDownloadedBytes(), ((OtaState.Downloading) state).getTotalBytes());
            } else if (state instanceof OtaState.Installed) {
                iDownloadCallback.onComplete(this.pathResolver.invoke(otaStateSnapshot.getOtaId()));
            } else if (state instanceof OtaState.Failed) {
                iDownloadCallback.onError(downloadStateCode, ((OtaState.Failed) state).getError().getMessage());
            }
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        return !(objA instanceof Result.Failure);
    }

    public static /* synthetic */ void emitTransient$default(CallbackSubscriber callbackSubscriber, String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        callbackSubscriber.emitTransient(str, i10, i11);
    }

    private final boolean isInProgress(OtaState otaState) {
        return (otaState instanceof OtaState.Queued) || (otaState instanceof OtaState.Checking) || (otaState instanceof OtaState.Downloading) || (otaState instanceof OtaState.Verifying) || (otaState instanceof OtaState.Installing) || (otaState instanceof OtaState.Activating) || (otaState instanceof OtaState.Paused);
    }

    public static /* synthetic */ void resyncToCallbacks$default(CallbackSubscriber callbackSubscriber, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        callbackSubscriber.resyncToCallbacks(str, str2);
    }

    private final void syncInstalledIfReady(String str, String str2, IDownloadCallback iDownloadCallback) {
        Object objA;
        ConcurrentHashMap<String, IDownloadCallback> concurrentHashMap;
        String strInvoke = this.pathResolver.invoke(str);
        if (strInvoke.length() <= 0) {
            strInvoke = null;
        }
        String str3 = strInvoke;
        if (str3 == null) {
            return;
        }
        try {
            iDownloadCallback.onUpdate(6, 100);
            iDownloadCallback.onComplete(str3);
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (!(objA instanceof Result.Failure) || (concurrentHashMap = this.callbacks.get(str)) == null) {
            return;
        }
        concurrentHashMap.remove(str2);
    }

    public final void emitTransient(String otaId, int i10, int i11) {
        Object objA;
        g.f(otaId, "otaId");
        ConcurrentHashMap<String, IDownloadCallback> concurrentHashMap = this.callbacks.get(otaId);
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            return;
        }
        for (Map.Entry<String, IDownloadCallback> entry : concurrentHashMap.entrySet()) {
            String key = entry.getKey();
            try {
                entry.getValue().onUpdate(i10, i11);
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            if (objA instanceof Result.Failure) {
                AIEngineLogger.w(LogModule.OTA, this.TAG, d.h("transient callback dead, removing: ", i10, otaId, " state="));
                concurrentHashMap.remove(key);
            }
        }
    }

    public final void register(String otaId, String key, IDownloadCallback callback) {
        ConcurrentHashMap<String, IDownloadCallback> concurrentHashMapPutIfAbsent;
        g.f(otaId, "otaId");
        g.f(key, "key");
        g.f(callback, "callback");
        ConcurrentHashMap<String, ConcurrentHashMap<String, IDownloadCallback>> concurrentHashMap = this.callbacks;
        ConcurrentHashMap<String, IDownloadCallback> concurrentHashMap2 = concurrentHashMap.get(otaId);
        if (concurrentHashMap2 == null && (concurrentHashMapPutIfAbsent = concurrentHashMap.putIfAbsent(otaId, (concurrentHashMap2 = new ConcurrentHashMap<>()))) != null) {
            concurrentHashMap2 = concurrentHashMapPutIfAbsent;
        }
        concurrentHashMap2.put(key, callback);
        OtaStateSnapshot otaStateSnapshot = this.state.getValue().get(otaId);
        if (otaStateSnapshot != null) {
            if (!dispatchTo(callback, otaStateSnapshot)) {
                ConcurrentHashMap<String, IDownloadCallback> concurrentHashMap3 = this.callbacks.get(otaId);
                if (concurrentHashMap3 != null) {
                    concurrentHashMap3.remove(key);
                    return;
                }
                return;
            }
            if ((otaStateSnapshot.getState() instanceof OtaState.Installed) || isInProgress(otaStateSnapshot.getState())) {
                return;
            }
        }
        syncInstalledIfReady(otaId, key, callback);
    }

    public final void resyncToCallbacks(String otaId, String str) {
        ConcurrentHashMap<String, IDownloadCallback> concurrentHashMap;
        Object objA;
        g.f(otaId, "otaId");
        OtaStateSnapshot otaStateSnapshot = this.state.getValue().get(otaId);
        if (otaStateSnapshot != null) {
            ConcurrentHashMap<String, IDownloadCallback> concurrentHashMap2 = this.callbacks.get(otaId);
            if (concurrentHashMap2 == null) {
                return;
            }
            for (Map.Entry<String, IDownloadCallback> entry : concurrentHashMap2.entrySet()) {
                String key = entry.getKey();
                if (!dispatchTo(entry.getValue(), otaStateSnapshot)) {
                    concurrentHashMap2.remove(key);
                }
            }
            return;
        }
        if (str != null) {
            if (str.length() <= 0) {
                str = null;
            }
            if (str == null || (concurrentHashMap = this.callbacks.get(otaId)) == null) {
                return;
            }
            for (Map.Entry<String, IDownloadCallback> entry2 : concurrentHashMap.entrySet()) {
                String key2 = entry2.getKey();
                IDownloadCallback value = entry2.getValue();
                try {
                    value.onUpdate(6, 100);
                    value.onComplete(str);
                    objA = n.f10413a;
                } catch (Throwable th) {
                    objA = kotlin.c.a(th);
                }
                if (objA instanceof Result.Failure) {
                    concurrentHashMap.remove(key2);
                }
            }
        }
    }

    public final void unregister(String otaId, String key) {
        g.f(otaId, "otaId");
        g.f(key, "key");
        ConcurrentHashMap<String, IDownloadCallback> concurrentHashMap = this.callbacks.get(otaId);
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(key);
        }
    }
}
