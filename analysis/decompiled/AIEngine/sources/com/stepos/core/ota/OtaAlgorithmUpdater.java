package com.stepos.core.ota;

import android.content.Context;
import android.os.SystemClock;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.ota.data.OtaRemoteModel;
import com.stepos.core.ota.remote.RemoteModelsRepository;
import com.stepos.core.ota.storage.ModelsVersionStore;
import gc.q;
import h0.e;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Result;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaAlgorithmUpdater {
    private static final long CACHE_TTL_MS = 43200000;
    private static final long CHECK_TIMEOUT_MS = 6000;
    private static final long CONFIRM_CACHE_TTL_MS = 7200000;
    private static final String TAG = "OtaAlgorithmUpdater";
    private static final ExecutorService fetchExecutor;
    public static final OtaAlgorithmUpdater INSTANCE = new OtaAlgorithmUpdater();
    private static final Map<String, Long> lastCheckTime = new LinkedHashMap();
    private static final ConcurrentHashMap<String, Long> lastConfirmRefreshElapsed = new ConcurrentHashMap<>();

    static {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new a6.d(3));
        g.e(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        fetchExecutor = executorServiceNewSingleThreadExecutor;
    }

    private OtaAlgorithmUpdater() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread fetchExecutor$lambda$1(Runnable runnable) {
        return d.n(runnable, "ota-remote-fetch", true);
    }

    private final boolean isConfirmCacheFresh(String str, long j10) {
        Long l10 = lastConfirmRefreshElapsed.get(str);
        if (l10 != null) {
            if (SystemClock.elapsedRealtime() - l10.longValue() < j10) {
                return true;
            }
        }
        return false;
    }

    private final void logFetchOutcome(String str, String str2, boolean z) {
        OtaRemoteModel otaRemoteModel = RemoteModelsRepository.get(str2);
        int versionCode = ModelsVersionStore.INSTANCE.getVersionCode(str2);
        AIEngineLogger.i(LogModule.OTA, TAG, str + ": done otaId=" + str2 + " fetchOk=" + z + " remote=" + (otaRemoteModel != null ? otaRemoteModel.getName() : null) + " remoteVer=" + (otaRemoteModel != null ? Integer.valueOf(otaRemoteModel.getVersion_code()) : null) + " localVer=" + versionCode + " updatable=" + (otaRemoteModel != null && versionCode < otaRemoteModel.getVersion_code()));
    }

    private final void markConfirmCacheRefreshed(String str) {
        lastConfirmRefreshElapsed.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
    }

    public static /* synthetic */ boolean refreshRemote$default(OtaAlgorithmUpdater otaAlgorithmUpdater, Context context, String str, boolean z, long j10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z = false;
        }
        boolean z3 = z;
        if ((i10 & 8) != 0) {
            j10 = CONFIRM_CACHE_TTL_MS;
        }
        return otaAlgorithmUpdater.refreshRemote(context, str, z3, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean refreshRemote$lambda$7(Context context, String str) {
        Object objA;
        try {
            g.c(context);
            objA = Boolean.valueOf(RemoteModelsRepository.fetchIgnoringInstalledVersion(context, str));
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.e(LogModule.OTA, TAG, "refreshRemote: fetch threw otaId=" + str, thB);
        }
        Boolean bool = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = bool;
        }
        return (Boolean) objA;
    }

    private final Future<Boolean> submitFetch(final Context context, final String str, long j10, final String str2) {
        Map<String, Long> map = lastCheckTime;
        Long l10 = map.get(str);
        long jLongValue = j10 - (l10 != null ? l10.longValue() : 0L);
        if (jLongValue >= CACHE_TTL_MS) {
            map.put(str, Long.valueOf(j10));
            return fetchExecutor.submit(new Callable() { // from class: com.stepos.core.ota.b
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return OtaAlgorithmUpdater.submitFetch$lambda$4(str2, str, context);
                }
            });
        }
        LogModule logModule = LogModule.OTA;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(": throttle skip otaId=");
        sb2.append(str);
        sb2.append(" (");
        AIEngineLogger.d(logModule, TAG, ai.onnxruntime.a.m(sb2, jLongValue / 1000, "s since last)"));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean submitFetch$lambda$4(String str, String str2, Context context) {
        Object objA;
        try {
            objA = Boolean.valueOf(RemoteModelsRepository.fetch$default(context, str2, false, 4, null));
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.e(LogModule.OTA, TAG, d.i(str, ": fetch threw otaId=", str2), thB);
        }
        Boolean bool = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = bool;
        }
        Boolean bool2 = (Boolean) objA;
        boolean zBooleanValue = bool2.booleanValue();
        if (g.b(str, "checkUpdatesAsync")) {
            INSTANCE.logFetchOutcome(str, str2, zBooleanValue);
        }
        return bool2;
    }

    public final long checkUpdates(Context context, String[] algorithms) throws ExecutionException, InterruptedException, TimeoutException {
        g.f(context, "context");
        g.f(algorithms, "algorithms");
        Context applicationContext = context.getApplicationContext();
        long jCurrentTimeMillis = System.currentTimeMillis();
        int length = algorithms.length;
        int i10 = 0;
        while (i10 < length) {
            String str = algorithms[i10];
            g.c(applicationContext);
            OtaAlgorithmUpdater otaAlgorithmUpdater = this;
            Future<Boolean> futureSubmitFetch = otaAlgorithmUpdater.submitFetch(applicationContext, str, jCurrentTimeMillis, "checkUpdates");
            if (futureSubmitFetch != null) {
                try {
                    Boolean bool = futureSubmitFetch.get(6000L, TimeUnit.MILLISECONDS);
                    g.c(bool);
                    otaAlgorithmUpdater.logFetchOutcome("checkUpdates", str, bool.booleanValue());
                } catch (TimeoutException unused) {
                    futureSubmitFetch.cancel(true);
                    AIEngineLogger.w(LogModule.OTA, TAG, "checkUpdates: fetch timeout otaId=" + str + " after 6000ms");
                } catch (Exception e10) {
                    AIEngineLogger.e(LogModule.OTA, TAG, "checkUpdates: wait failed otaId=" + str, e10);
                }
            }
            i10++;
            this = otaAlgorithmUpdater;
        }
        return jCurrentTimeMillis + 6000;
    }

    public final void checkUpdatesAsync(Context context, String[] algorithms) {
        g.f(context, "context");
        g.f(algorithms, "algorithms");
        Context applicationContext = context.getApplicationContext();
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (String str : algorithms) {
            g.c(applicationContext);
            submitFetch(applicationContext, str, jCurrentTimeMillis, "checkUpdatesAsync");
        }
    }

    public final List<String> getUpdates(Context context, String[] algorithms) {
        boolean z;
        g.f(context, "context");
        g.f(algorithms, "algorithms");
        ArrayList arrayList = new ArrayList();
        for (String str : algorithms) {
            OtaRemoteModel otaRemoteModel = RemoteModelsRepository.get(str);
            if (otaRemoteModel == null) {
                AIEngineLogger.d(LogModule.OTA, TAG, "getUpdates: no remote row for otaId=" + str + " (fetch 未写入或 name 与缓存 key 不一致)");
                z = false;
            } else {
                int versionCode = ModelsVersionStore.INSTANCE.getVersionCode(str);
                z = versionCode < otaRemoteModel.getVersion_code();
                if (!z) {
                    LogModule logModule = LogModule.OTA;
                    int version_code = otaRemoteModel.getVersion_code();
                    StringBuilder sbF = e.f("getUpdates: already up-to-date otaId=", str, " local=", versionCode, " remote=");
                    sbF.append(version_code);
                    AIEngineLogger.d(logModule, TAG, sbF.toString());
                }
            }
            if (z) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public final boolean refreshRemote(Context context, String otaId, boolean z, long j10) {
        g.f(context, "context");
        g.f(otaId, "otaId");
        if (q.t0(otaId)) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        if (!z && isConfirmCacheFresh(otaId, j10) && RemoteModelsRepository.get(otaId) != null) {
            AIEngineLogger.d(LogModule.OTA, TAG, a0.a.h("refreshRemote: cache fresh within ", j10, "ms, skip fetch otaId=", otaId));
            return true;
        }
        Future futureSubmit = fetchExecutor.submit(new a(0, applicationContext, otaId));
        try {
            Boolean bool = (Boolean) futureSubmit.get(6000L, TimeUnit.MILLISECONDS);
            if (bool.booleanValue()) {
                markConfirmCacheRefreshed(otaId);
            }
            return bool.booleanValue();
        } catch (TimeoutException unused) {
            futureSubmit.cancel(true);
            AIEngineLogger.w(LogModule.OTA, TAG, "refreshRemote: fetch timeout otaId=" + otaId + " after 6000ms");
            return false;
        } catch (Exception e10) {
            AIEngineLogger.e(LogModule.OTA, TAG, "refreshRemote: wait failed otaId=".concat(otaId), e10);
            return false;
        }
    }
}
