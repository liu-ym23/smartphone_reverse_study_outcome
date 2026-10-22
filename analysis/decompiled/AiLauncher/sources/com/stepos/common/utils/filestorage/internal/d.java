package com.stepos.common.utils.filestorage.internal;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import okhttp3.Protocol;
import tb.AbstractC5550q;
import tb.InterfaceC5538e;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ-\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ1\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\u0017J\u001f\u0010#\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b%\u0010\u0017J\u0017\u0010&\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010\u0017J\u001f\u0010)\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020!2\u0006\u0010.\u001a\u00020!H\u0002¢\u0006\u0004\b/\u00100R\u0014\u00101\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00102R\u0016\u00107\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00102R\u0016\u00108\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00102R\u0016\u00109\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00102R\u0016\u0010:\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00102R\u0016\u0010;\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00102R\u0016\u0010<\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00102R\u0016\u0010=\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00102R\u0016\u0010>\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u00102R\u0016\u0010?\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00102R\u0016\u0010@\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u00102¨\u0006A"}, d2 = {"Lcom/stepos/common/utils/filestorage/internal/d;", "Ltb/q;", "<init>", "()V", "Ltb/e;", "call", "", "domainName", "LY8/t;", "o", "(Ltb/e;Ljava/lang/String;)V", "", "Ljava/net/InetAddress;", "inetAddressList", "n", "(Ltb/e;Ljava/lang/String;Ljava/util/List;)V", "Ljava/net/InetSocketAddress;", "inetSocketAddress", "Ljava/net/Proxy;", "proxy", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ltb/e;Ljava/net/InetSocketAddress;Ljava/net/Proxy;)V", "F", "(Ltb/e;)V", "Lokhttp3/c;", "handshake", ExifInterface.LONGITUDE_EAST, "(Ltb/e;Lokhttp3/c;)V", "Lokhttp3/Protocol;", "protocol", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ltb/e;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lokhttp3/Protocol;)V", "t", "", "byteCount", "s", "(Ltb/e;J)V", "B", "c", "Ljava/io/IOException;", "ioe", Const.INTENT_KEY_UMID, "(Ltb/e;Ljava/io/IOException;)V", "status", "H", "(Ljava/lang/String;)V", "startNs", "G", "(J)J", "t0", "J", "", "reused", "Z", "dnsMs", "connMs", "tlsMs", "uploadMs", "bytesSent", "reqBodyEndNs", "respHeadersStartNs", "dnsStartNs", "connStartNs", "tlsStartNs", "reqBodyStartNs", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d extends AbstractC5550q {
    private long bytesSent;
    private long connMs;
    private long connStartNs;
    private long dnsMs;
    private long dnsStartNs;
    private long reqBodyEndNs;
    private long reqBodyStartNs;
    private long respHeadersStartNs;
    private long tlsMs;
    private long tlsStartNs;
    private long uploadMs;
    private final long t0 = System.nanoTime();
    private boolean reused = true;

    @Override // tb.AbstractC5550q
    public void B(InterfaceC5538e call) {
        p.i(call, "call");
        this.respHeadersStartNs = System.nanoTime();
    }

    @Override // tb.AbstractC5550q
    public void E(InterfaceC5538e call, okhttp3.c handshake) {
        p.i(call, "call");
        this.tlsMs = G(this.tlsStartNs);
    }

    @Override // tb.AbstractC5550q
    public void F(InterfaceC5538e call) {
        p.i(call, "call");
        this.tlsStartNs = System.nanoTime();
    }

    public final long G(long startNs) {
        if (startNs == 0) {
            return 0L;
        }
        return (System.nanoTime() - startNs) / 1000000;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H(java.lang.String r17) {
        /*
            r16 = this;
            r0 = r16
            long r1 = r0.t0
            long r1 = r0.G(r1)
            long r3 = r0.reqBodyEndNs
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L1d
            long r7 = r0.respHeadersStartNs
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
            long r3 = r0.dnsMs
            long r5 = r0.connMs
            long r9 = r0.tlsMs
            long r11 = r0.uploadMs
            long r13 = r0.bytesSent
            boolean r0 = r0.reused
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r16 = r0
            java.lang.String r0 = "net total="
            r15.append(r0)
            r15.append(r1)
            java.lang.String r0 = "ms dns="
            r15.append(r0)
            r15.append(r3)
            java.lang.String r0 = " conn="
            r15.append(r0)
            r15.append(r5)
            java.lang.String r0 = " tls="
            r15.append(r0)
            r15.append(r9)
            java.lang.String r0 = " upload="
            r15.append(r0)
            r15.append(r11)
            java.lang.String r0 = "ms(sent="
            r15.append(r0)
            r15.append(r13)
            java.lang.String r0 = ") gap="
            r15.append(r0)
            r15.append(r7)
            java.lang.String r0 = "ms reused="
            r15.append(r0)
            r0 = r16
            r15.append(r0)
            java.lang.String r0 = " "
            r15.append(r0)
            r0 = r17
            r15.append(r0)
            java.lang.String r0 = r15.toString()
            java.lang.String r1 = "FileStorage.TosNet"
            android.util.Log.i(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.utils.filestorage.internal.d.H(java.lang.String):void");
    }

    @Override // tb.AbstractC5550q
    public void c(InterfaceC5538e call) {
        p.i(call, "call");
        H("ok");
    }

    @Override // tb.AbstractC5550q
    public void d(InterfaceC5538e call, IOException ioe) {
        p.i(call, "call");
        p.i(ioe, "ioe");
        H("fail=" + ioe.getMessage());
    }

    @Override // tb.AbstractC5550q
    public void g(InterfaceC5538e call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        p.i(call, "call");
        p.i(inetSocketAddress, "inetSocketAddress");
        p.i(proxy, "proxy");
        this.connMs = G(this.connStartNs);
    }

    @Override // tb.AbstractC5550q
    public void i(InterfaceC5538e call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        p.i(call, "call");
        p.i(inetSocketAddress, "inetSocketAddress");
        p.i(proxy, "proxy");
        this.reused = false;
        this.connStartNs = System.nanoTime();
    }

    @Override // tb.AbstractC5550q
    public void n(InterfaceC5538e call, String domainName, List<? extends InetAddress> inetAddressList) {
        p.i(call, "call");
        p.i(domainName, "domainName");
        p.i(inetAddressList, "inetAddressList");
        this.dnsMs = G(this.dnsStartNs);
    }

    @Override // tb.AbstractC5550q
    public void o(InterfaceC5538e call, String domainName) {
        p.i(call, "call");
        p.i(domainName, "domainName");
        this.reused = false;
        this.dnsStartNs = System.nanoTime();
    }

    @Override // tb.AbstractC5550q
    public void s(InterfaceC5538e call, long byteCount) {
        p.i(call, "call");
        this.reqBodyEndNs = System.nanoTime();
        this.uploadMs = G(this.reqBodyStartNs);
        this.bytesSent = byteCount;
    }

    @Override // tb.AbstractC5550q
    public void t(InterfaceC5538e call) {
        p.i(call, "call");
        this.reqBodyStartNs = System.nanoTime();
    }
}
