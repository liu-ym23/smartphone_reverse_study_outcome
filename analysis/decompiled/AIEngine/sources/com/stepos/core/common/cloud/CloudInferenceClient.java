package com.stepos.core.common.cloud;

import ad.i;
import ad.k;
import ad.l;
import ad.n;
import ad.s;
import ad.t;
import com.stepos.core.ability.speech.AsrFilePcmSegmentPolicy;
import com.stepos.core.common.cloud.CloudTransportConfig;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.util.TraceIdUtil;
import com.tonyodev.fetch2core.server.FileRequest;
import gc.o;
import gc.q;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import mb.m;
import mb.v;
import okhttp3.Response;
import okhttp3.h;
import okhttp3.logging.HttpLoggingInterceptor;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudInferenceClient {
    public static final String HEADER_TRACE_ID = "x-trace-id";
    private static final String TAG = "CloudInferenceClient";
    public static final CloudInferenceClient INSTANCE = new CloudInferenceClient();
    private static final l JSON_MEDIA_TYPE = bd.d.a("application/json; charset=utf-8");
    private static final lb.d client$delegate = kotlin.b.b(new a9.a(9));

    private CloudInferenceClient() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n client_delegate$lambda$8() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new b());
        httpLoggingInterceptor.f11305d = HttpLoggingInterceptor.Level.f11307b;
        CloudTransportConfig.Timeout timeout = CloudConfigBootstrap.INSTANCE.get().getTimeout();
        n.a aVar = new n.a();
        long connectMs = timeout.getConnectMs();
        TimeUnit unit = TimeUnit.MILLISECONDS;
        aVar.b(connectMs, unit);
        aVar.c(timeout.getReadMs(), unit);
        aVar.d(timeout.getWriteMs(), unit);
        if (timeout.getPingIntervalMs() > 0) {
            long pingIntervalMs = timeout.getPingIntervalMs();
            kotlin.jvm.internal.g.f(unit, "unit");
            aVar.A = bd.l.b("interval", pingIntervalMs, unit);
        }
        RealtimeWsTiming realtimeWsTiming = RealtimeWsTiming.INSTANCE;
        aVar.a(realtimeWsTiming.getAPP());
        k interceptor = realtimeWsTiming.getNET();
        kotlin.jvm.internal.g.f(interceptor, "interceptor");
        aVar.f143d.add(interceptor);
        aVar.a(httpLoggingInterceptor);
        aVar.f144e = new ai.onnxruntime.a(22);
        return new n(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void client_delegate$lambda$8$lambda$4(String message) {
        kotlin.jvm.internal.g.f(message, "message");
        AIEngineLogger.d(LogModule.ABILITY, TAG, message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i client_delegate$lambda$8$lambda$7(ad.b it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new CloudCallEventListener();
    }

    /* renamed from: postJson-bMdYcbs$default, reason: not valid java name */
    public static /* synthetic */ Object m95postJsonbMdYcbs$default(CloudInferenceClient cloudInferenceClient, String str, String str2, long j10, String str3, Map map, String str4, zb.l lVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS;
        }
        return cloudInferenceClient.m98postJsonbMdYcbs(str, str2, j10, (i10 & 8) != 0 ? "" : str3, (i10 & 16) != 0 ? kotlin.collections.b.d0() : map, (i10 & 32) != 0 ? "" : str4, (i10 & 64) != 0 ? null : lVar);
    }

    public final String extractResponseXTraceId(Response response) {
        kotlin.jvm.internal.g.f(response, "response");
        String strA = Response.a("X-Trace-Id", response);
        if (strA != null) {
            if (q.t0(strA)) {
                strA = null;
            }
            if (strA != null) {
                return strA;
            }
        }
        String strA2 = Response.a(HEADER_TRACE_ID, response);
        if (strA2 == null || q.t0(strA2)) {
            return null;
        }
        return strA2;
    }

    public final n getClient$common_release() {
        return (n) client$delegate.getValue();
    }

    /* renamed from: postJson-bMdYcbs, reason: not valid java name */
    public final Object m98postJsonbMdYcbs(String url, String jsonBody, long j10, String apiKey, Map<String, String> headers, String logPrefix, zb.l<? super Map<String, String>, lb.n> lVar) {
        n client$common_release;
        Object objA;
        kotlin.jvm.internal.g.f(url, "url");
        kotlin.jvm.internal.g.f(jsonBody, "jsonBody");
        kotlin.jvm.internal.g.f(apiKey, "apiKey");
        kotlin.jvm.internal.g.f(headers, "headers");
        kotlin.jvm.internal.g.f(logPrefix, "logPrefix");
        String str = "";
        String strConcat = q.t0(logPrefix) ? "" : logPrefix.concat(" ");
        s.a aVar = s.Companion;
        l lVar2 = JSON_MEDIA_TYPE;
        aVar.getClass();
        bd.e eVarB = s.a.b(jsonBody, lVar2);
        h.a aVar2 = new h.a();
        aVar2.e(url);
        aVar2.c("POST", eVarB);
        if (apiKey.length() > 0) {
            aVar2.a(FileRequest.FIELD_AUTHORIZATION, "Bearer ".concat(apiKey));
        }
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            aVar2.a(entry.getKey(), entry.getValue());
        }
        String strNewTraceId = headers.get(HEADER_TRACE_ID);
        if (strNewTraceId == null) {
            strNewTraceId = TraceIdUtil.INSTANCE.newTraceId();
            aVar2.a(HEADER_TRACE_ID, strNewTraceId);
        }
        okhttp3.h hVar = new okhttp3.h(aVar2);
        LogModule logModule = LogModule.ABILITY;
        AIEngineLogger.i(logModule, TAG, strConcat + "postJson x-trace-id=" + strNewTraceId + " url=" + url);
        String str2 = CloudRequestHeaderLog.INSTANCE.format(hVar);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(strConcat);
        sb2.append("[DIAG] request-headers (http): ");
        sb2.append(str2);
        AIEngineLogger.i(logModule, TAG, sb2.toString());
        if (j10 != AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS) {
            n.a aVarB = getClient$common_release().b();
            aVarB.c(j10, TimeUnit.MILLISECONDS);
            client$common_release = new n(aVarB);
        } else {
            client$common_release = getClient$common_release();
        }
        try {
            Response responseD = client$common_release.a(hVar).d();
            if (lVar != null) {
                try {
                    Set<String> setC = responseD.h.c();
                    int iA0 = v.a0(m.Z(setC, 10));
                    if (iA0 < 16) {
                        iA0 = 16;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap(iA0);
                    for (Object obj : setC) {
                        String strA = Response.a((String) obj, responseD);
                        if (strA == null) {
                            strA = "";
                        }
                        linkedHashMap.put(obj, strA);
                    }
                    lVar.invoke(linkedHashMap);
                } finally {
                }
            }
            LogModule logModule2 = LogModule.ABILITY;
            int i10 = responseD.f10891d;
            AIEngineLogger.i(logModule2, TAG, strConcat + "[DIAG] response-headers (http): code=" + i10 + ", " + CloudRequestHeaderLog.INSTANCE.format(responseD));
            t tVar = responseD.f10893j;
            String strC = str;
            if (tVar != null) {
                strC = tVar.C();
            }
            if (responseD.r) {
                objA = strC;
            } else {
                AIEngineLogger.e(logModule2, TAG, strConcat + "postJson failed: " + ("HTTP " + i10 + ": " + strC));
                objA = kotlin.c.a(new CloudApiException(i10, strC));
            }
            responseD.close();
            return objA;
        } catch (Exception e10) {
            AIEngineLogger.e(LogModule.ABILITY, TAG, com.stepos.core.ota.d.i(strConcat, "postJson failed: ", e10.getMessage()), e10);
            return kotlin.c.a(e10);
        }
    }

    /* renamed from: postSse-eH_QyT8, reason: not valid java name */
    public final Object m99postSseeH_QyT8(String url, String jsonBody, long j10, String apiKey, Map<String, String> headers, String logPrefix, zb.l<? super Map<String, String>, lb.n> lVar, zb.l<? super String, lb.n> onData) {
        kotlin.jvm.internal.g.f(url, "url");
        kotlin.jvm.internal.g.f(jsonBody, "jsonBody");
        kotlin.jvm.internal.g.f(apiKey, "apiKey");
        kotlin.jvm.internal.g.f(headers, "headers");
        kotlin.jvm.internal.g.f(logPrefix, "logPrefix");
        kotlin.jvm.internal.g.f(onData, "onData");
        s.a aVar = s.Companion;
        l lVar2 = JSON_MEDIA_TYPE;
        aVar.getClass();
        return m100postSseBodyeH_QyT8(url, s.a.b(jsonBody, lVar2), j10, apiKey, headers, logPrefix, lVar, onData);
    }

    /* renamed from: postSseBody-eH_QyT8, reason: not valid java name */
    public final Object m100postSseBodyeH_QyT8(String url, s body, long j10, String apiKey, Map<String, String> headers, String logPrefix, zb.l<? super Map<String, String>, lb.n> lVar, zb.l<? super String, lb.n> onData) {
        sd.h hVarW;
        String str;
        kotlin.jvm.internal.g.f(url, "url");
        kotlin.jvm.internal.g.f(body, "body");
        kotlin.jvm.internal.g.f(apiKey, "apiKey");
        kotlin.jvm.internal.g.f(headers, "headers");
        kotlin.jvm.internal.g.f(logPrefix, "logPrefix");
        kotlin.jvm.internal.g.f(onData, "onData");
        String strConcat = q.t0(logPrefix) ? "" : logPrefix.concat(" ");
        h.a aVar = new h.a();
        aVar.e(url);
        aVar.c("POST", body);
        aVar.a("Accept", "text/event-stream");
        if (apiKey.length() > 0) {
            aVar.a(FileRequest.FIELD_AUTHORIZATION, "Bearer ".concat(apiKey));
        }
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            aVar.a(entry.getKey(), entry.getValue());
        }
        String strNewTraceId = headers.get(HEADER_TRACE_ID);
        if (strNewTraceId == null) {
            strNewTraceId = TraceIdUtil.INSTANCE.newTraceId();
            aVar.a(HEADER_TRACE_ID, strNewTraceId);
        }
        okhttp3.h hVar = new okhttp3.h(aVar);
        LogModule logModule = LogModule.ABILITY;
        AIEngineLogger.i(logModule, TAG, strConcat + "postSse x-trace-id=" + strNewTraceId + " url=" + url);
        String str2 = CloudRequestHeaderLog.INSTANCE.format(hVar);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(strConcat);
        sb2.append("[DIAG] request-headers (http): ");
        sb2.append(str2);
        AIEngineLogger.i(logModule, TAG, sb2.toString());
        n.a aVarB = getClient$common_release().b();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        aVarB.c(j10, timeUnit);
        aVarB.d(Math.max(j10, CloudConfigBootstrap.INSTANCE.get().getTimeout().getWriteMs()), timeUnit);
        try {
            Response responseD = new n(aVarB).a(hVar).d();
            if (lVar != null) {
                try {
                    Set<String> setC = responseD.h.c();
                    int iA0 = v.a0(m.Z(setC, 10));
                    if (iA0 < 16) {
                        iA0 = 16;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap(iA0);
                    for (Object obj : setC) {
                        String strA = Response.a((String) obj, responseD);
                        if (strA == null) {
                            strA = "";
                        }
                        linkedHashMap.put(obj, strA);
                    }
                    lVar.invoke(linkedHashMap);
                } finally {
                }
            }
            LogModule logModule2 = LogModule.ABILITY;
            int i10 = responseD.f10891d;
            t tVar = responseD.f10893j;
            AIEngineLogger.i(logModule2, TAG, strConcat + "[DIAG] response-headers (http-sse): code=" + i10 + ", " + CloudRequestHeaderLog.INSTANCE.format(responseD));
            if (!responseD.r) {
                String strC = tVar != null ? tVar.C() : "";
                AIEngineLogger.e(logModule2, TAG, strConcat + "postSse failed: HTTP " + i10 + ": " + strC);
                Result.Failure failureA = kotlin.c.a(new CloudApiException(i10, strC));
                responseD.close();
                return failureA;
            }
            if (tVar != null && (hVarW = tVar.w()) != null) {
                boolean z = false;
                int i11 = 0;
                while (true) {
                    String strV = hVarW.v();
                    str = "[DONE]";
                    if (strV == null) {
                        break;
                    }
                    if (strV.length() != 0 && o.k0(strV, "data:", false)) {
                        String string = q.L0(q.z0(strV, "data:")).toString();
                        if (string.length() != 0) {
                            if (string.equals("[DONE]")) {
                                z = true;
                                break;
                            }
                            i11++;
                            onData.invoke(string);
                        }
                    }
                }
                LogModule logModule3 = LogModule.ABILITY;
                if (!z) {
                    str = "EOF";
                }
                AIEngineLogger.i(logModule3, TAG, strConcat + "postSse stream closed: reason=" + str + " frames=" + i11);
                lb.n nVar = lb.n.f10413a;
                responseD.close();
                return nVar;
            }
            Result.Failure failureA2 = kotlin.c.a(new IOException("postSse: empty response body"));
            responseD.close();
            return failureA2;
        } catch (Exception e10) {
            AIEngineLogger.e(LogModule.ABILITY, TAG, com.stepos.core.ota.d.i(strConcat, "postSse failed: ", e10.getMessage()), e10);
            return kotlin.c.a(e10);
        }
    }

    public final String extractResponseXTraceId(Map<String, String> headers) {
        Object next;
        String str;
        kotlin.jvm.internal.g.f(headers, "headers");
        Iterator<T> it = headers.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (o.f0((String) ((Map.Entry) next).getKey(), "X-Trace-Id")) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry == null || (str = (String) entry.getValue()) == null || q.t0(str)) {
            return null;
        }
        return str;
    }
}
