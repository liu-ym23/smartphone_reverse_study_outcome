package com.stepos.core.ota.bridge;

import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.deepbinder.IOtaTaskStateCallback;
import com.stepos.core.ota.d;
import com.stepos.core.ota.data.DownloadStateKt;
import com.stepos.core.ota.domain.OtaStateSnapshot;
import com.stepos.core.ota.process.OtaRuntime;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaTaskStateBroadcaster {
    private static final String TAG = "OtaTaskStateBroadcaster";
    private static volatile boolean started;
    public static final OtaTaskStateBroadcaster INSTANCE = new OtaTaskStateBroadcaster();
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
    private static final ConcurrentHashMap<String, IOtaTaskStateCallback> callbacks = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Integer> lastSig = new ConcurrentHashMap<>();

    private OtaTaskStateBroadcaster() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean dispatch(IOtaTaskStateCallback iOtaTaskStateCallback, OtaStateSnapshot otaStateSnapshot) {
        Object objA;
        try {
            iOtaTaskStateCallback.onTaskState(otaStateSnapshot.getOtaId(), DownloadStateKt.toDownloadStateCode(otaStateSnapshot.getState()), otaStateSnapshot.getProgress(), otaStateSnapshot.getInstalledVersion());
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        return !(objA instanceof Result.Failure);
    }

    private final void ensureStarted() {
        if (started) {
            return;
        }
        synchronized (this) {
            if (started) {
                return;
            }
            started = true;
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new OtaTaskStateBroadcaster$ensureStarted$1$1(null), 3, null);
        }
    }

    public final void register(String key, IOtaTaskStateCallback cb2) {
        g.f(key, "key");
        g.f(cb2, "cb");
        callbacks.put(key, cb2);
        ensureStarted();
        Iterator<T> it = OtaRuntime.INSTANCE.taskStateFlow().getValue().values().iterator();
        while (it.hasNext()) {
            if (!INSTANCE.dispatch(cb2, (OtaStateSnapshot) it.next())) {
                callbacks.remove(key);
                return;
            }
        }
        AIEngineLogger.d(LogModule.OTA, TAG, d.h("register key=", callbacks.size(), key, " total="));
    }

    public final void unregister(String key) {
        g.f(key, "key");
        ConcurrentHashMap<String, IOtaTaskStateCallback> concurrentHashMap = callbacks;
        concurrentHashMap.remove(key);
        AIEngineLogger.d(LogModule.OTA, TAG, d.h("unregister key=", concurrentHashMap.size(), key, " total="));
    }
}
