package com.stepos.core.common.cloud;

import ad.i;
import android.os.SystemClock;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Handshake;
import okhttp3.Protocol;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudCallEventListener extends i {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "CloudHttpTiming";
    private long callStartNs;
    private long connectStartNs;
    private long dnsStartNs;
    private boolean sawConnectStart;
    private long tlsStartNs;
    private long dnsMs = -1;
    private long connectMs = -1;
    private long tlsMs = -1;
    private String host = "";
    private String path = "";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    private final long elapsedMs(long j10) {
        if (j10 > 0) {
            return (SystemClock.elapsedRealtimeNanos() - j10) / 1000000;
        }
        return -1L;
    }

    private final void logSummary(String str) {
        LogModule logModule = LogModule.ABILITY;
        String str2 = this.host;
        String str3 = this.path;
        boolean z = !this.sawConnectStart;
        long j10 = this.dnsMs;
        long j11 = this.connectMs;
        long j12 = this.tlsMs;
        long jElapsedMs = elapsedMs(this.callStartNs);
        StringBuilder sbS = ai.onnxruntime.a.s("[DIAG] http-call host=", str2, " path=", str3, " reused=");
        sbS.append(z);
        sbS.append(" dns=");
        sbS.append(j10);
        a0.a.s(j11, "ms connect=", "ms tls=", sbS);
        sbS.append(j12);
        a0.a.s(jElapsedMs, "ms total=", "ms (", sbS);
        sbS.append(str);
        sbS.append(")");
        AIEngineLogger.d(logModule, TAG, sbS.toString());
    }

    @Override // ad.i
    public void callEnd(ad.b call) {
        kotlin.jvm.internal.g.f(call, "call");
        logSummary("end");
    }

    @Override // ad.i
    public void callFailed(ad.b call, IOException ioe) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(ioe, "ioe");
        logSummary(ai.onnxruntime.a.k("failed:", ioe.getMessage()));
    }

    @Override // ad.i
    public void callStart(ad.b call) {
        kotlin.jvm.internal.g.f(call, "call");
        this.callStartNs = SystemClock.elapsedRealtimeNanos();
        okhttp3.g gVar = call.a().f10992a;
        this.host = gVar.f10980d;
        this.path = gVar.b();
    }

    @Override // ad.i
    public void connectEnd(ad.b call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(inetSocketAddress, "inetSocketAddress");
        kotlin.jvm.internal.g.f(proxy, "proxy");
        this.connectMs = elapsedMs(this.connectStartNs);
    }

    @Override // ad.i
    public void connectStart(ad.b call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(inetSocketAddress, "inetSocketAddress");
        kotlin.jvm.internal.g.f(proxy, "proxy");
        this.sawConnectStart = true;
        this.connectStartNs = SystemClock.elapsedRealtimeNanos();
    }

    @Override // ad.i
    public void dnsEnd(ad.b call, String domainName, List<? extends InetAddress> inetAddressList) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(domainName, "domainName");
        kotlin.jvm.internal.g.f(inetAddressList, "inetAddressList");
        this.dnsMs = elapsedMs(this.dnsStartNs);
    }

    @Override // ad.i
    public void dnsStart(ad.b call, String domainName) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(domainName, "domainName");
        this.dnsStartNs = SystemClock.elapsedRealtimeNanos();
    }

    @Override // ad.i
    public void secureConnectEnd(ad.b call, Handshake handshake) {
        kotlin.jvm.internal.g.f(call, "call");
        this.tlsMs = elapsedMs(this.tlsStartNs);
    }

    @Override // ad.i
    public void secureConnectStart(ad.b call) {
        kotlin.jvm.internal.g.f(call, "call");
        this.tlsStartNs = SystemClock.elapsedRealtimeNanos();
    }
}
