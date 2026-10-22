package com.stepos.core.ota.process;

import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.ota.OtaContainer;
import com.stepos.core.ota.domain.OtaState;
import com.stepos.core.ota.domain.OtaStateSnapshot;
import com.stepos.core.ota.storage.OtaTaskSnapshotStore;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaProcessShutdown {
    public static final OtaProcessShutdown INSTANCE = new OtaProcessShutdown();
    private static final String TAG = "OtaProcessShutdown";
    private static volatile boolean exiting;

    private OtaProcessShutdown() {
    }

    public static /* synthetic */ boolean requestIdleExit$default(OtaProcessShutdown otaProcessShutdown, OtaProcessControlBinder otaProcessControlBinder, boolean z, zb.a aVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z = false;
        }
        return otaProcessShutdown.requestIdleExit(otaProcessControlBinder, z, aVar);
    }

    public final boolean isExiting() {
        return exiting;
    }

    public final boolean requestIdleExit(OtaProcessControlBinder controlBinder, boolean z, zb.a<n> stopSelf) {
        Object objA;
        g.f(controlBinder, "controlBinder");
        g.f(stopSelf, "stopSelf");
        int i10 = 0;
        if (exiting) {
            return false;
        }
        try {
            objA = OtaContainer.INSTANCE.snapshot();
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object objD0 = kotlin.collections.b.d0();
        if (objA instanceof Result.Failure) {
            objA = objD0;
        }
        Map<String, OtaStateSnapshot> map = (Map) objA;
        if (!z) {
            Collection<OtaStateSnapshot> collectionValues = map.values();
            if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
                Iterator<T> it = collectionValues.iterator();
                while (it.hasNext()) {
                    if (((OtaStateSnapshot) it.next()).getState().isActive()) {
                        AIEngineLogger.i(LogModule.OTA, TAG, "idle exit aborted: active task appeared");
                        return false;
                    }
                }
            }
        }
        exiting = true;
        try {
            OtaTaskSnapshotStore.INSTANCE.flushForProcessExit(map);
            n nVar = n.f10413a;
        } catch (Throwable th2) {
            kotlin.c.a(th2);
        }
        try {
            OtaContainer.INSTANCE.getNotifier().releaseAnyForegroundAnchor();
            n nVar2 = n.f10413a;
        } catch (Throwable th3) {
            kotlin.c.a(th3);
        }
        LogModule logModule = LogModule.OTA;
        if (!map.isEmpty()) {
            Iterator<Map.Entry<String, OtaStateSnapshot>> it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                if (it2.next().getValue().getState() instanceof OtaState.Paused) {
                    i10++;
                }
            }
        }
        AIEngineLogger.i(logModule, TAG, "idle exit, retainedPaused=" + i10);
        try {
            controlBinder.notifyIdleExitRequested();
            n nVar3 = n.f10413a;
        } catch (Throwable th4) {
            kotlin.c.a(th4);
        }
        stopSelf.invoke();
        return true;
    }

    public final void reset() {
        exiting = false;
    }
}
