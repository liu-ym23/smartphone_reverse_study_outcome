package com.stepos.core.ota.confirm;

import android.os.SystemClock;
import b9.a;
import b9.b;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.ota.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.g;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InteractiveSessionRegistry {
    public static final long DEFAULT_TTL_MS = 300000;
    private static final String TAG = "InteractiveSession";
    public static final InteractiveSessionRegistry INSTANCE = new InteractiveSessionRegistry();
    private static final ConcurrentHashMap<String, Long> sessions = new ConcurrentHashMap<>();

    private InteractiveSessionRegistry() {
    }

    public static /* synthetic */ boolean isActive$default(InteractiveSessionRegistry interactiveSessionRegistry, String str, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = DEFAULT_TTL_MS;
        }
        return interactiveSessionRegistry.isActive(str, j10);
    }

    private final void sweepExpired(long j10) {
        sessions.entrySet().removeIf(new b(new a(SystemClock.elapsedRealtime(), j10, 0), 0));
    }

    public static /* synthetic */ void sweepExpired$default(InteractiveSessionRegistry interactiveSessionRegistry, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = DEFAULT_TTL_MS;
        }
        interactiveSessionRegistry.sweepExpired(j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean sweepExpired$lambda$0(long j10, long j11, Map.Entry entry) {
        g.f(entry, "<destruct>");
        Object value = entry.getValue();
        g.e(value, "component2(...)");
        return j10 - ((Long) value).longValue() > j11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean sweepExpired$lambda$1(l lVar, Object obj) {
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public final void begin(String otaId) {
        g.f(otaId, "otaId");
        ConcurrentHashMap<String, Long> concurrentHashMap = sessions;
        concurrentHashMap.put(otaId, Long.valueOf(SystemClock.elapsedRealtime()));
        AIEngineLogger.i(LogModule.OTA, TAG, d.h("begin: ", concurrentHashMap.size(), otaId, " total="));
    }

    public final void end(String otaId) {
        g.f(otaId, "otaId");
        ConcurrentHashMap<String, Long> concurrentHashMap = sessions;
        if (concurrentHashMap.remove(otaId) != null) {
            AIEngineLogger.i(LogModule.OTA, TAG, d.h("end: ", concurrentHashMap.size(), otaId, " total="));
        }
    }

    public final boolean isActive(String otaId, long j10) {
        g.f(otaId, "otaId");
        sweepExpired(j10);
        ConcurrentHashMap<String, Long> concurrentHashMap = sessions;
        Long l10 = concurrentHashMap.get(otaId);
        if (l10 == null) {
            return false;
        }
        if (SystemClock.elapsedRealtime() - l10.longValue() <= j10) {
            return true;
        }
        concurrentHashMap.remove(otaId);
        AIEngineLogger.w(LogModule.OTA, TAG, "session expired, swept: ".concat(otaId));
        return false;
    }

    public final boolean tryBegin(String otaId) {
        g.f(otaId, "otaId");
        sweepExpired$default(this, 0L, 1, null);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        ConcurrentHashMap<String, Long> concurrentHashMap = sessions;
        Long lPutIfAbsent = concurrentHashMap.putIfAbsent(otaId, Long.valueOf(jElapsedRealtime));
        if (lPutIfAbsent == null) {
            AIEngineLogger.i(LogModule.OTA, TAG, d.h("tryBegin: ok ", concurrentHashMap.size(), otaId, " total="));
            return true;
        }
        if (jElapsedRealtime - lPutIfAbsent.longValue() <= DEFAULT_TTL_MS) {
            AIEngineLogger.i(LogModule.OTA, TAG, "tryBegin: busy ".concat(otaId));
            return false;
        }
        concurrentHashMap.put(otaId, Long.valueOf(jElapsedRealtime));
        AIEngineLogger.i(LogModule.OTA, TAG, "tryBegin: replaced expired ".concat(otaId));
        return true;
    }
}
