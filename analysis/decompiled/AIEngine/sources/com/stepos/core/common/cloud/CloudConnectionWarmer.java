package com.stepos.core.common.cloud;

import ad.n;
import android.os.SystemClock;
import b6.i;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.cta.CtaGateManager;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Result;
import okhttp3.Response;
import okhttp3.h;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudConnectionWarmer {
    private static final String TAG = "CloudConnWarmer";
    private static final long WARM_CALL_TIMEOUT_MS = 5000;
    private static final long WARM_MIN_INTERVAL_MS = 30000;
    public static final CloudConnectionWarmer INSTANCE = new CloudConnectionWarmer();
    private static final ConcurrentHashMap<String, AtomicLong> lastWarmAtMs = new ConcurrentHashMap<>();

    private CloudConnectionWarmer() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AtomicLong warm$lambda$2(String it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new AtomicLong(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AtomicLong warm$lambda$3(l lVar, Object obj) {
        return (AtomicLong) lVar.invoke(obj);
    }

    public final void warm(String url, final String reason) {
        Object objA;
        kotlin.jvm.internal.g.f(url, "url");
        kotlin.jvm.internal.g.f(reason, "reason");
        if (!CtaGateManager.INSTANCE.isGranted()) {
            AIEngineLogger.d(LogModule.ABILITY, TAG, "[DIAG] warm skip: CTA not granted reason=".concat(reason));
            return;
        }
        try {
            h.a aVar = new h.a();
            aVar.e(url);
            aVar.c("HEAD", null);
            objA = new okhttp3.h(aVar);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (Result.b(objA) != null) {
            AIEngineLogger.d(LogModule.ABILITY, TAG, "warm skip: bad url reason=".concat(reason));
            return;
        }
        okhttp3.h hVar = (okhttp3.h) objA;
        final String str = hVar.f10992a.f10980d;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        AtomicLong atomicLongComputeIfAbsent = lastWarmAtMs.computeIfAbsent(str, new com.stepos.core.ability.h(new i(29), 2));
        kotlin.jvm.internal.g.e(atomicLongComputeIfAbsent, "computeIfAbsent(...)");
        AtomicLong atomicLong = atomicLongComputeIfAbsent;
        long j10 = atomicLong.get();
        if ((j10 == 0 || jElapsedRealtime - j10 >= 30000) && atomicLong.compareAndSet(j10, jElapsedRealtime)) {
            final long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            n.a aVarB = CloudInferenceClient.INSTANCE.getClient$common_release().b();
            TimeUnit unit = TimeUnit.MILLISECONDS;
            kotlin.jvm.internal.g.f(unit, "unit");
            aVarB.f160w = bd.l.b("timeout", 5000L, unit);
            new n(aVarB).a(hVar).Q(new ad.c() { // from class: com.stepos.core.common.cloud.CloudConnectionWarmer.warm.1
                @Override // ad.c
                public void onFailure(ad.b call, IOException e10) {
                    kotlin.jvm.internal.g.f(call, "call");
                    kotlin.jvm.internal.g.f(e10, "e");
                    LogModule logModule = LogModule.ABILITY;
                    String str2 = str;
                    String str3 = reason;
                    long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                    String message = e10.getMessage();
                    StringBuilder sbS = ai.onnxruntime.a.s("[DIAG] warm failed host=", str2, " reason=", str3, " cost=");
                    sbS.append(jElapsedRealtime3);
                    sbS.append("ms err=");
                    sbS.append(message);
                    AIEngineLogger.d(logModule, CloudConnectionWarmer.TAG, sbS.toString());
                }

                @Override // ad.c
                public void onResponse(ad.b call, Response response) {
                    kotlin.jvm.internal.g.f(call, "call");
                    kotlin.jvm.internal.g.f(response, "response");
                    response.close();
                    LogModule logModule = LogModule.ABILITY;
                    String str2 = str;
                    String str3 = reason;
                    int i10 = response.f10891d;
                    long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                    StringBuilder sbS = ai.onnxruntime.a.s("[DIAG] warm host=", str2, " reason=", str3, " code=");
                    com.stepos.core.ota.d.s(sbS, i10, " cost=", jElapsedRealtime3);
                    sbS.append("ms");
                    AIEngineLogger.d(logModule, CloudConnectionWarmer.TAG, sbS.toString());
                }
            });
        }
    }
}
