package com.stepos.core.common.cloud;

import ad.k;
import ad.u;
import android.os.SystemClock;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import gc.q;
import java.net.InetSocketAddress;
import okhttp3.Handshake;
import okhttp3.Response;
import okhttp3.TlsVersion;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class RealtimeWsTiming {
    private static final String TAG = "CloudHttpTiming";
    public static final RealtimeWsTiming INSTANCE = new RealtimeWsTiming();
    private static final k APP = new g();
    private static final k NET = new h();

    private RealtimeWsTiming() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Response APP$lambda$0(k.a chain) {
        kotlin.jvm.internal.g.f(chain, "chain");
        okhttp3.h hVarA = chain.a();
        if (!INSTANCE.isWs(hVarA.f10992a.f10984i)) {
            return chain.b(hVarA);
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        LogModule logModule = LogModule.ABILITY;
        AIEngineLogger.i(logModule, "CloudHttpTiming", "APP start url=" + hVarA.f10992a);
        Response responseB = chain.b(hVarA);
        int i10 = responseB.f10891d;
        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
        StringBuilder sb2 = new StringBuilder("APP done code=");
        sb2.append(i10);
        sb2.append(" TOTAL(连接+服务端)=");
        sb2.append(jElapsedRealtime2);
        a0.a.z(sb2, "ms", logModule, "CloudHttpTiming");
        return responseB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Response NET$lambda$1(k.a chain) {
        Handshake handshake;
        u uVar;
        kotlin.jvm.internal.g.f(chain, "chain");
        okhttp3.h hVarA = chain.a();
        if (!INSTANCE.isWs(hVarA.f10992a.f10984i)) {
            return chain.b(hVarA);
        }
        ed.g gVarC = chain.c();
        LogModule logModule = LogModule.ABILITY;
        TlsVersion tlsVersion = null;
        InetSocketAddress inetSocketAddress = (gVarC == null || (uVar = gVarC.f8651d) == null) ? null : uVar.f178c;
        if (gVarC != null && (handshake = gVarC.f8654g) != null) {
            tlsVersion = handshake.f10873a;
        }
        AIEngineLogger.i(logModule, "CloudHttpTiming", "NET conn=" + inetSocketAddress + " tls=" + tlsVersion);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Response responseB = chain.b(hVarA);
        AIEngineLogger.i(logModule, "CloudHttpTiming", "NET server(发请求→101)=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms code=" + responseB.f10891d);
        return responseB;
    }

    private final boolean isWs(String str) {
        return q.l0(str, "/realtime/asr/stream", false) || q.l0(str, "/v1/realtime/audio", false);
    }

    public final k getAPP() {
        return APP;
    }

    public final k getNET() {
        return NET;
    }
}
