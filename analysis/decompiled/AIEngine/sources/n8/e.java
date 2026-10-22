package n8;

import ad.i;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Handshake;
import okhttp3.Protocol;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends i {

    /* renamed from: a, reason: collision with root package name */
    public final long f10654a = System.nanoTime();

    /* renamed from: b, reason: collision with root package name */
    public boolean f10655b = true;

    /* renamed from: c, reason: collision with root package name */
    public long f10656c;

    /* renamed from: d, reason: collision with root package name */
    public long f10657d;

    /* renamed from: e, reason: collision with root package name */
    public long f10658e;

    /* renamed from: f, reason: collision with root package name */
    public long f10659f;

    /* renamed from: g, reason: collision with root package name */
    public long f10660g;
    public long h;

    /* renamed from: i, reason: collision with root package name */
    public long f10661i;

    /* renamed from: j, reason: collision with root package name */
    public long f10662j;

    /* renamed from: k, reason: collision with root package name */
    public long f10663k;

    /* renamed from: l, reason: collision with root package name */
    public long f10664l;

    /* renamed from: m, reason: collision with root package name */
    public long f10665m;

    public static long a(long j10) {
        if (j10 == 0) {
            return 0L;
        }
        return (System.nanoTime() - j10) / 1000000;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.String r17) {
        /*
            r16 = this;
            r0 = r16
            long r1 = r0.f10654a
            long r1 = a(r1)
            long r3 = r0.h
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L1d
            long r7 = r0.f10661i
            int r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r5 <= 0) goto L1d
            long r7 = r7 - r3
            r3 = 1000000(0xf4240, float:1.401298E-39)
            long r3 = (long) r3
            long r7 = r7 / r3
            goto L1f
        L1d:
            r7 = -1
        L1f:
            long r3 = r0.f10656c
            long r5 = r0.f10657d
            long r9 = r0.f10658e
            long r11 = r0.f10659f
            long r13 = r0.f10660g
            boolean r0 = r0.f10655b
            java.lang.String r15 = "net total="
            r16 = r0
            java.lang.String r0 = "ms dns="
            java.lang.StringBuilder r0 = ai.onnxruntime.a.q(r1, r15, r0)
            r0.append(r3)
            java.lang.String r1 = " conn="
            java.lang.String r2 = " tls="
            a0.a.s(r5, r1, r2, r0)
            r0.append(r9)
            java.lang.String r1 = " upload="
            java.lang.String r2 = "ms(sent="
            a0.a.s(r11, r1, r2, r0)
            r0.append(r13)
            java.lang.String r1 = ") gap="
            java.lang.String r2 = "ms reused="
            a0.a.s(r7, r1, r2, r0)
            r1 = r16
            r0.append(r1)
            java.lang.String r1 = " "
            r0.append(r1)
            r1 = r17
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "FileStorage.TosNet"
            android.util.Log.i(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n8.e.b(java.lang.String):void");
    }

    @Override // ad.i
    public final void callEnd(ad.b call) {
        kotlin.jvm.internal.g.f(call, "call");
        b("ok");
    }

    @Override // ad.i
    public final void callFailed(ad.b call, IOException ioe) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(ioe, "ioe");
        b("fail=" + ioe.getMessage());
    }

    @Override // ad.i
    public final void connectEnd(ad.b call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(inetSocketAddress, "inetSocketAddress");
        kotlin.jvm.internal.g.f(proxy, "proxy");
        this.f10657d = a(this.f10663k);
    }

    @Override // ad.i
    public final void connectStart(ad.b call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(inetSocketAddress, "inetSocketAddress");
        kotlin.jvm.internal.g.f(proxy, "proxy");
        this.f10655b = false;
        this.f10663k = System.nanoTime();
    }

    @Override // ad.i
    public final void dnsEnd(ad.b call, String domainName, List<? extends InetAddress> inetAddressList) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(domainName, "domainName");
        kotlin.jvm.internal.g.f(inetAddressList, "inetAddressList");
        this.f10656c = a(this.f10662j);
    }

    @Override // ad.i
    public final void dnsStart(ad.b call, String domainName) {
        kotlin.jvm.internal.g.f(call, "call");
        kotlin.jvm.internal.g.f(domainName, "domainName");
        this.f10655b = false;
        this.f10662j = System.nanoTime();
    }

    @Override // ad.i
    public final void requestBodyEnd(ad.b call, long j10) {
        kotlin.jvm.internal.g.f(call, "call");
        this.h = System.nanoTime();
        this.f10659f = a(this.f10665m);
        this.f10660g = j10;
    }

    @Override // ad.i
    public final void requestBodyStart(ad.b call) {
        kotlin.jvm.internal.g.f(call, "call");
        this.f10665m = System.nanoTime();
    }

    @Override // ad.i
    public final void responseHeadersStart(ad.b call) {
        kotlin.jvm.internal.g.f(call, "call");
        this.f10661i = System.nanoTime();
    }

    @Override // ad.i
    public final void secureConnectEnd(ad.b call, Handshake handshake) {
        kotlin.jvm.internal.g.f(call, "call");
        this.f10658e = a(this.f10664l);
    }

    @Override // ad.i
    public final void secureConnectStart(ad.b call) {
        kotlin.jvm.internal.g.f(call, "call");
        this.f10664l = System.nanoTime();
    }
}
