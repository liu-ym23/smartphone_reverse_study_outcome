package com.stepos.core.common.cloud;

import ad.i;
import ad.n;
import ad.v;
import ad.w;
import bd.j;
import bd.l;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.util.TraceIdUtil;
import com.tonyodev.fetch2core.server.FileRequest;
import gc.n;
import gc.q;
import java.io.EOFException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.h;
import okhttp3.internal.ws.RealWebSocket;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudWebSocketClient {
    public static final CloudWebSocketClient INSTANCE = new CloudWebSocketClient();
    private static final int NORMAL_CLOSURE = 1000;
    public static final long PING_DISABLED = 0;
    private static final String TAG = "CloudWebSocketClient";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface Listener {
        void onClosed(int i10, String str);

        void onFailure(Throwable th, Integer num, Long l10);

        void onOpen();

        void onTextMessage(String str);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface Session {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class DefaultImpls {
            public static /* synthetic */ void close$default(Session session, int i10, String str, int i11, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
                }
                if ((i11 & 1) != 0) {
                    i10 = 1000;
                }
                if ((i11 & 2) != 0) {
                    str = "";
                }
                session.close(i10, str);
            }
        }

        void cancel();

        void close(int i10, String str);

        boolean isOpen();

        long queuedBytes();

        boolean sendText(String str);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class WebSocketSession implements Session {
        private volatile boolean open;
        private final v webSocket;

        public WebSocketSession(v webSocket) {
            kotlin.jvm.internal.g.f(webSocket, "webSocket");
            this.webSocket = webSocket;
            this.open = true;
        }

        @Override // com.stepos.core.common.cloud.CloudWebSocketClient.Session
        public void cancel() {
            this.open = false;
            this.webSocket.cancel();
        }

        @Override // com.stepos.core.common.cloud.CloudWebSocketClient.Session
        public void close(int i10, String reason) {
            kotlin.jvm.internal.g.f(reason, "reason");
            this.open = false;
            this.webSocket.close(i10, reason);
        }

        @Override // com.stepos.core.common.cloud.CloudWebSocketClient.Session
        public boolean isOpen() {
            return this.open;
        }

        @Override // com.stepos.core.common.cloud.CloudWebSocketClient.Session
        public long queuedBytes() {
            return this.webSocket.e();
        }

        @Override // com.stepos.core.common.cloud.CloudWebSocketClient.Session
        public boolean sendText(String text) {
            kotlin.jvm.internal.g.f(text, "text");
            return this.webSocket.a(text);
        }
    }

    private CloudWebSocketClient() {
    }

    public static /* synthetic */ Session connect$default(CloudWebSocketClient cloudWebSocketClient, String str, String str2, Map map, Listener listener, String str3, Long l10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            map = kotlin.collections.b.d0();
        }
        Map map2 = map;
        if ((i10 & 16) != 0) {
            str3 = "";
        }
        String str4 = str3;
        if ((i10 & 32) != 0) {
            l10 = null;
        }
        return cloudWebSocketClient.connect(str, str2, map2, listener, str4, l10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Long parseRetryAfterMs(String str) {
        String string;
        Long lD0;
        if (str == null || (string = q.L0(str).toString()) == null || (lD0 = n.d0(string)) == null) {
            return null;
        }
        if (lD0.longValue() < 0) {
            lD0 = null;
        }
        if (lD0 != null) {
            return Long.valueOf(lD0.longValue() * 1000);
        }
        return null;
    }

    private final v wsClient(okhttp3.h request, w listener, Long l10) {
        ad.n client$common_release;
        if (l10 != null) {
            n.a aVarB = CloudInferenceClient.INSTANCE.getClient$common_release().b();
            long jLongValue = l10.longValue();
            TimeUnit unit = TimeUnit.MILLISECONDS;
            kotlin.jvm.internal.g.f(unit, "unit");
            aVarB.A = l.b("interval", jLongValue, unit);
            client$common_release = new ad.n(aVarB);
        } else {
            client$common_release = CloudInferenceClient.INSTANCE.getClient$common_release();
        }
        client$common_release.getClass();
        kotlin.jvm.internal.g.f(request, "request");
        kotlin.jvm.internal.g.f(listener, "listener");
        RealWebSocket realWebSocket = new RealWebSocket(client$common_release.D, request, listener, new Random(), client$common_release.z, client$common_release.B, client$common_release.A);
        if (request.a("Sec-WebSocket-Extensions") != null) {
            RealWebSocket.i(realWebSocket, new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null, 6);
            return realWebSocket;
        }
        n.a aVarB2 = client$common_release.b();
        i eventListener = i.NONE;
        kotlin.jvm.internal.g.f(eventListener, "eventListener");
        aVarB2.f144e = new j(eventListener);
        List<Protocol> protocols = RealWebSocket.f11253x;
        kotlin.jvm.internal.g.f(protocols, "protocols");
        ArrayList arrayListP0 = kotlin.collections.a.P0(protocols);
        Protocol protocol = Protocol.f10883j;
        if (!arrayListP0.contains(protocol) && !arrayListP0.contains(Protocol.f10881d)) {
            throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + arrayListP0).toString());
        }
        if (arrayListP0.contains(protocol) && arrayListP0.size() > 1) {
            throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayListP0).toString());
        }
        if (arrayListP0.contains(Protocol.f10880c)) {
            throw new IllegalArgumentException(("protocols must not contain http/1.0: " + arrayListP0).toString());
        }
        if (arrayListP0.contains(null)) {
            throw new IllegalArgumentException("protocols must not contain null");
        }
        arrayListP0.remove(Protocol.f10882e);
        if (!arrayListP0.equals(aVarB2.f156s)) {
            aVarB2.D = null;
        }
        List<? extends Protocol> listUnmodifiableList = Collections.unmodifiableList(arrayListP0);
        kotlin.jvm.internal.g.e(listUnmodifiableList, "unmodifiableList(...)");
        aVarB2.f156s = listUnmodifiableList;
        ad.n nVar = new ad.n(aVarB2);
        h.a aVarB3 = request.b();
        aVarB3.b("Upgrade", "websocket");
        aVarB3.b("Connection", "Upgrade");
        aVarB3.b("Sec-WebSocket-Key", realWebSocket.f11260g);
        aVarB3.b("Sec-WebSocket-Version", "13");
        aVarB3.b("Sec-WebSocket-Extensions", "permessage-deflate");
        okhttp3.h hVar = new okhttp3.h(aVarB3);
        okhttp3.internal.connection.d dVar = new okhttp3.internal.connection.d(nVar, hVar, true);
        realWebSocket.h = dVar;
        dVar.Q(new okhttp3.internal.ws.a(realWebSocket, hVar));
        return realWebSocket;
    }

    public final Session connect(String url, String apiKey, Map<String, String> headers, final Listener listener, String logPrefix, Long l10) {
        kotlin.jvm.internal.g.f(url, "url");
        kotlin.jvm.internal.g.f(apiKey, "apiKey");
        kotlin.jvm.internal.g.f(headers, "headers");
        kotlin.jvm.internal.g.f(listener, "listener");
        kotlin.jvm.internal.g.f(logPrefix, "logPrefix");
        String strConcat = logPrefix.length() == 0 ? "" : logPrefix.concat(" ");
        h.a aVar = new h.a();
        aVar.e(url);
        if (apiKey.length() > 0) {
            aVar.a(FileRequest.FIELD_AUTHORIZATION, "Bearer ".concat(apiKey));
        }
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            aVar.a(entry.getKey(), entry.getValue());
        }
        String strNewTraceId = headers.get(CloudInferenceClient.HEADER_TRACE_ID);
        if (strNewTraceId == null) {
            strNewTraceId = TraceIdUtil.INSTANCE.newTraceId();
            aVar.a(CloudInferenceClient.HEADER_TRACE_ID, strNewTraceId);
        }
        okhttp3.h hVar = new okhttp3.h(aVar);
        final String str = strConcat + "[" + strNewTraceId + "] ";
        LogModule logModule = LogModule.ABILITY;
        AIEngineLogger.i(logModule, TAG, strConcat + "ws connect x-trace-id=" + strNewTraceId + " url=" + url);
        String str2 = CloudRequestHeaderLog.INSTANCE.format(hVar);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(strConcat);
        sb2.append("[DIAG] request-headers (ws-handshake): ");
        sb2.append(str2);
        AIEngineLogger.i(logModule, TAG, sb2.toString());
        return new WebSocketSession(wsClient(hVar, new w() { // from class: com.stepos.core.common.cloud.CloudWebSocketClient$connect$wsListener$1
            @Override // ad.w
            public void onClosed(v webSocket, int i10, String reason) {
                kotlin.jvm.internal.g.f(webSocket, "webSocket");
                kotlin.jvm.internal.g.f(reason, "reason");
                AIEngineLogger.d(LogModule.ABILITY, "CloudWebSocketClient", str + "ws closed: " + i10);
                listener.onClosed(i10, reason);
            }

            @Override // ad.w
            public void onClosing(v webSocket, int i10, String reason) {
                Object objA;
                kotlin.jvm.internal.g.f(webSocket, "webSocket");
                kotlin.jvm.internal.g.f(reason, "reason");
                try {
                    objA = Boolean.valueOf(webSocket.close(CloudWebSocketClient.INSTANCE.echoCloseCode(i10), null));
                } catch (Throwable th) {
                    objA = kotlin.c.a(th);
                }
                String str3 = str;
                Throwable thB = Result.b(objA);
                if (thB != null) {
                    AIEngineLogger.w(LogModule.ABILITY, "CloudWebSocketClient", str3 + "ws close-handshake echo failed (serverCode=" + i10 + "): " + thB.getMessage());
                }
            }

            @Override // ad.w
            public void onFailure(v webSocket, Throwable t8, Response response) {
                kotlin.jvm.internal.g.f(webSocket, "webSocket");
                kotlin.jvm.internal.g.f(t8, "t");
                Integer numValueOf = response != null ? Integer.valueOf(response.f10891d) : null;
                Long retryAfterMs = CloudWebSocketClient.INSTANCE.parseRetryAfterMs(response != null ? Response.a("Retry-After", response) : null);
                if (response != null) {
                    AIEngineLogger.i(LogModule.ABILITY, "CloudWebSocketClient", str + "[DIAG] response-headers (ws-handshake-failure): code=" + response.f10891d + ", " + CloudRequestHeaderLog.INSTANCE.format(response));
                }
                String str3 = str + "ws failure: " + t8.getMessage() + " httpCode=" + numValueOf + " retryAfterMs=" + retryAfterMs;
                if ((t8 instanceof EOFException) || (t8.getCause() instanceof EOFException)) {
                    AIEngineLogger.i(LogModule.ABILITY, "CloudWebSocketClient", str3);
                } else {
                    AIEngineLogger.e(LogModule.ABILITY, "CloudWebSocketClient", str3, t8);
                }
                listener.onFailure(new CloudWebSocketException(numValueOf, t8), numValueOf, retryAfterMs);
            }

            @Override // ad.w
            public void onMessage(v webSocket, String text) {
                kotlin.jvm.internal.g.f(webSocket, "webSocket");
                kotlin.jvm.internal.g.f(text, "text");
                listener.onTextMessage(text);
            }

            @Override // ad.w
            public void onOpen(v webSocket, Response response) {
                kotlin.jvm.internal.g.f(webSocket, "webSocket");
                kotlin.jvm.internal.g.f(response, "response");
                LogModule logModule2 = LogModule.ABILITY;
                String str3 = str;
                int i10 = response.f10891d;
                AIEngineLogger.d(logModule2, "CloudWebSocketClient", str3 + "ws open: " + i10);
                AIEngineLogger.i(logModule2, "CloudWebSocketClient", str + "[DIAG] response-headers (ws-handshake): code=" + i10 + ", " + CloudRequestHeaderLog.INSTANCE.format(response));
                listener.onOpen();
            }
        }, l10));
    }

    public final int echoCloseCode(int i10) {
        if (i10 < 1000 || ((1004 <= i10 && i10 < 1007) || ((1015 <= i10 && i10 < 3000) || i10 >= 5000))) {
            return 1000;
        }
        return i10;
    }
}
