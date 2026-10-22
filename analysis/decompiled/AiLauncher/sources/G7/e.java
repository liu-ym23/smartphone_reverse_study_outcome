package G7;

import Y8.t;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import okhttp3.Protocol;
import p9.InterfaceC5074l;
import tb.AbstractC5550q;
import tb.C5530C;
import tb.InterfaceC5538e;
import tb.InterfaceC5543j;
import tb.v;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001BB#\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\rJ!\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J1\u0010#\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J\u001f\u0010'\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b)\u0010\rJ\u001f\u0010,\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b.\u0010\rJ\u001f\u00101\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b1\u00102J\u001f\u00103\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b3\u0010-J\u001f\u00106\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b8\u0010\rJ\u0017\u00109\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b9\u0010\rJ\u0019\u0010:\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b:\u0010;J)\u0010@\u001a\u00020\u00042\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020\u00062\b\u0010?\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b@\u0010AR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010FR\u0016\u0010H\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010FR\u0016\u0010I\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010FR\u0016\u0010J\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010FR\u0016\u0010K\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010FR\u0016\u0010M\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010FR\u0016\u0010N\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010FR\u0016\u0010O\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010FR\u0016\u0010Q\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010FR\u0016\u0010S\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010FR\u0016\u0010U\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010FR\u0016\u0010V\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010FR\u0016\u0010W\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010FR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010c\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010b¨\u0006d"}, d2 = {"LG7/e;", "Ltb/q;", "Lkotlin/Function1;", "LG7/c;", "LY8/t;", "sink", "", "traceIdHeader", "<init>", "(Lp9/l;Ljava/lang/String;)V", "Ltb/e;", "call", "e", "(Ltb/e;)V", "domainName", "o", "(Ltb/e;Ljava/lang/String;)V", "", "Ljava/net/InetAddress;", "inetAddressList", "n", "(Ltb/e;Ljava/lang/String;Ljava/util/List;)V", "Ljava/net/InetSocketAddress;", "inetSocketAddress", "Ljava/net/Proxy;", "proxy", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ltb/e;Ljava/net/InetSocketAddress;Ljava/net/Proxy;)V", "F", "Lokhttp3/c;", "handshake", ExifInterface.LONGITUDE_EAST, "(Ltb/e;Lokhttp3/c;)V", "Lokhttp3/Protocol;", "protocol", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ltb/e;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lokhttp3/Protocol;)V", "Ltb/j;", "connection", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ltb/e;Ltb/j;)V", "w", "", "byteCount", "s", "(Ltb/e;J)V", "B", "Ltb/C;", UxipConstants.f30685x, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ltb/e;Ltb/C;)V", "x", "Ljava/io/IOException;", "ioe", Const.INTENT_KEY_UMID, "(Ltb/e;Ljava/io/IOException;)V", "f", "c", "H", "(Ltb/e;)Ljava/lang/String;", "Ltb/v;", "url", "method", DidiCardProvider.KEY_TRACE_ID, "G", "(Ltb/v;Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "Lp9/l;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "J", "callStartMs", "dnsStartMs", "connectStartMs", "tlsStartMs", "requestStartMs", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "responseStartMs", "dnsMs", "connectMs", "k", "tlsMs", "l", "requestMs", "m", "responseMs", "requestBytes", "responseBytes", "", "p", "Z", "connectionReused", "", "q", "Ljava/lang/Integer;", "statusCode", "", "r", "Ljava/lang/Throwable;", "failure", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class e extends AbstractC5550q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<HttpMetrics, t> sink;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String traceIdHeader;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public long callStartMs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public long dnsStartMs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public long connectStartMs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public long tlsStartMs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public long requestStartMs;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public long responseStartMs;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public long dnsMs;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public long connectMs;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public long tlsMs;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public long requestMs;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public long responseMs;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public long requestBytes;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public long responseBytes;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public boolean connectionReused;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public Integer statusCode;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public Throwable failure;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"LG7/e$a;", "Ltb/q$c;", "Lkotlin/Function1;", "LG7/c;", "LY8/t;", "sink", "", "traceIdHeader", "<init>", "(Lp9/l;Ljava/lang/String;)V", "Ltb/e;", "call", "Ltb/q;", Const.INTENT_KEY_APIKEY, "(Ltb/e;)Ltb/q;", "Lp9/l;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements AbstractC5550q.c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC5074l<HttpMetrics, t> sink;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final String traceIdHeader;

        /* JADX WARN: Multi-variable type inference failed */
        public a(InterfaceC5074l<? super HttpMetrics, t> sink, String traceIdHeader) {
            p.i(sink, "sink");
            p.i(traceIdHeader, "traceIdHeader");
            this.sink = sink;
            this.traceIdHeader = traceIdHeader;
        }

        @Override // tb.AbstractC5550q.c
        public AbstractC5550q a(InterfaceC5538e call) {
            p.i(call, "call");
            return new e(this.sink, this.traceIdHeader);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(InterfaceC5074l<? super HttpMetrics, t> sink, String traceIdHeader) {
        p.i(sink, "sink");
        p.i(traceIdHeader, "traceIdHeader");
        this.sink = sink;
        this.traceIdHeader = traceIdHeader;
    }

    @Override // tb.AbstractC5550q
    public void A(InterfaceC5538e call, C5530C response) {
        p.i(call, "call");
        p.i(response, "response");
        this.statusCode = Integer.valueOf(response.getCode());
    }

    @Override // tb.AbstractC5550q
    public void B(InterfaceC5538e call) {
        p.i(call, "call");
        this.requestMs = SystemClock.elapsedRealtime() - this.requestStartMs;
        this.responseStartMs = SystemClock.elapsedRealtime();
    }

    @Override // tb.AbstractC5550q
    public void E(InterfaceC5538e call, okhttp3.c handshake) {
        p.i(call, "call");
        this.tlsMs = SystemClock.elapsedRealtime() - this.tlsStartMs;
    }

    @Override // tb.AbstractC5550q
    public void F(InterfaceC5538e call) {
        p.i(call, "call");
        this.tlsStartMs = SystemClock.elapsedRealtime();
    }

    public final void G(v url, String method, String traceId) {
        try {
            Result.Companion companion = Result.INSTANCE;
            this.sink.invoke(new HttpMetrics(url.getUrl(), method, this.statusCode, SystemClock.elapsedRealtime() - this.callStartMs, this.dnsMs, this.connectMs, this.tlsMs, this.requestMs, this.responseMs, this.requestBytes, this.responseBytes, this.connectionReused, this.failure, traceId));
            Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public final String H(InterfaceC5538e call) {
        return call.getOriginalRequest().e(this.traceIdHeader);
    }

    @Override // tb.AbstractC5550q
    public void c(InterfaceC5538e call) {
        p.i(call, "call");
        if (this.failure != null) {
            return;
        }
        G(call.getOriginalRequest().getUrl(), call.getOriginalRequest().getMethod(), H(call));
    }

    @Override // tb.AbstractC5550q
    public void d(InterfaceC5538e call, IOException ioe) {
        p.i(call, "call");
        p.i(ioe, "ioe");
        this.failure = ioe;
        G(call.getOriginalRequest().getUrl(), call.getOriginalRequest().getMethod(), H(call));
    }

    @Override // tb.AbstractC5550q
    public void e(InterfaceC5538e call) {
        p.i(call, "call");
        this.callStartMs = SystemClock.elapsedRealtime();
    }

    @Override // tb.AbstractC5550q
    public void f(InterfaceC5538e call) {
        p.i(call, "call");
        if (this.failure == null && this.statusCode == null) {
            this.failure = new CancellationException("Canceled");
            G(call.getOriginalRequest().getUrl(), call.getOriginalRequest().getMethod(), H(call));
        }
    }

    @Override // tb.AbstractC5550q
    public void g(InterfaceC5538e call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        p.i(call, "call");
        p.i(inetSocketAddress, "inetSocketAddress");
        p.i(proxy, "proxy");
        this.connectMs = SystemClock.elapsedRealtime() - this.connectStartMs;
    }

    @Override // tb.AbstractC5550q
    public void i(InterfaceC5538e call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        p.i(call, "call");
        p.i(inetSocketAddress, "inetSocketAddress");
        p.i(proxy, "proxy");
        this.connectStartMs = SystemClock.elapsedRealtime();
    }

    @Override // tb.AbstractC5550q
    public void j(InterfaceC5538e call, InterfaceC5543j connection) {
        p.i(call, "call");
        p.i(connection, "connection");
        if (this.connectStartMs == 0) {
            this.connectionReused = true;
        }
    }

    @Override // tb.AbstractC5550q
    public void n(InterfaceC5538e call, String domainName, List<? extends InetAddress> inetAddressList) {
        p.i(call, "call");
        p.i(domainName, "domainName");
        p.i(inetAddressList, "inetAddressList");
        this.dnsMs = SystemClock.elapsedRealtime() - this.dnsStartMs;
    }

    @Override // tb.AbstractC5550q
    public void o(InterfaceC5538e call, String domainName) {
        p.i(call, "call");
        p.i(domainName, "domainName");
        this.dnsStartMs = SystemClock.elapsedRealtime();
    }

    @Override // tb.AbstractC5550q
    public void s(InterfaceC5538e call, long byteCount) {
        p.i(call, "call");
        this.requestBytes = byteCount;
    }

    @Override // tb.AbstractC5550q
    public void w(InterfaceC5538e call) {
        p.i(call, "call");
        this.requestStartMs = SystemClock.elapsedRealtime();
    }

    @Override // tb.AbstractC5550q
    public void x(InterfaceC5538e call, long byteCount) {
        p.i(call, "call");
        this.responseBytes = byteCount;
        this.responseMs = SystemClock.elapsedRealtime() - this.responseStartMs;
    }
}
