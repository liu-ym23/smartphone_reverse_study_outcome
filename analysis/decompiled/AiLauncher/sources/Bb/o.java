package Bb;

import Mb.G;
import Mb.H;
import Mb.I;
import Mb.J;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import okhttp3.Protocol;
import okhttp3.internal.http2.ErrorCode;
import tb.C5528A;
import tb.C5530C;
import tb.u;
import tb.z;
import zb.C6481e;
import zb.InterfaceC6480d;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001 B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0013H\u0016¢\u0006\u0004\b%\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010&\u001a\u0004\b'\u0010(R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010)R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010/R\u0016\u00103\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00105\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00104R\u0014\u00109\u001a\u0002068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108¨\u0006:"}, d2 = {"LBb/o;", "Lzb/d;", "Ltb/z;", "client", "Lzb/d$a;", "carrier", "Lzb/g;", "chain", "Lokhttp3/internal/http2/c;", "http2Connection", "<init>", "(Ltb/z;Lzb/d$a;Lzb/g;Lokhttp3/internal/http2/c;)V", "Ltb/A;", "request", "", "contentLength", "LMb/G;", Const.INTENT_KEY_PKGNAME, "(Ltb/A;J)LMb/G;", "LY8/t;", "e", "(Ltb/A;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()V", Const.INTENT_KEY_UMID, "", "expectContinue", "Ltb/C$a;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Z)Ltb/C$a;", "Ltb/C;", UxipConstants.f30685x, Const.INTENT_KEY_APIKEY, "(Ltb/C;)J", "LMb/I;", "c", "(Ltb/C;)LMb/I;", "cancel", "Lzb/d$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Lzb/d$a;", "Lzb/g;", "Lokhttp3/internal/http2/c;", "LBb/p;", "LBb/p;", "stream", "Lokhttp3/Protocol;", "Lokhttp3/Protocol;", "protocol", "f", "Z", "canceled", "()Z", "isResponseComplete", "LMb/H;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()LMb/H;", "socket", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class o implements InterfaceC6480d {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    public static final List<String> f1529h = ub.q.l("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* renamed from: i, reason: collision with root package name */
    public static final List<String> f1530i = ub.q.l("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC6480d.a carrier;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final zb.g chain;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final okhttp3.internal.http2.c http2Connection;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public volatile p stream;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Protocol protocol;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public volatile boolean canceled;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0013R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001c¨\u0006\u001e"}, d2 = {"LBb/o$a;", "", "<init>", "()V", "Ltb/A;", "request", "", "LBb/a;", Const.INTENT_KEY_APIKEY, "(Ltb/A;)Ljava/util/List;", "Ltb/u;", "headerBlock", "Lokhttp3/Protocol;", "protocol", "Ltb/C$a;", Const.INTENT_KEY_PKGNAME, "(Ltb/u;Lokhttp3/Protocol;)Ltb/C$a;", "", "CONNECTION", "Ljava/lang/String;", "HOST", "KEEP_ALIVE", "PROXY_CONNECTION", "TRANSFER_ENCODING", "TE", "ENCODING", "UPGRADE", "HTTP_2_SKIPPED_REQUEST_HEADERS", "Ljava/util/List;", "HTTP_2_SKIPPED_RESPONSE_HEADERS", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: Bb.o$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final List<a> a(C5528A request) {
            kotlin.jvm.internal.p.i(request, "request");
            u headers = request.getHeaders();
            ArrayList arrayList = new ArrayList(headers.size() + 4);
            arrayList.add(new a(a.f1482g, request.getMethod()));
            arrayList.add(new a(a.f1483h, zb.i.f45464a.c(request.getUrl())));
            String strE = request.e(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30852k);
            if (strE != null) {
                arrayList.add(new a(a.f1485j, strE));
            }
            arrayList.add(new a(a.f1484i, request.getUrl().getScheme()));
            int size = headers.size();
            for (int i10 = 0; i10 < size; i10++) {
                String strF = headers.f(i10);
                Locale US = Locale.US;
                kotlin.jvm.internal.p.h(US, "US");
                String lowerCase = strF.toLowerCase(US);
                kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
                if (!o.f1529h.contains(lowerCase) || (kotlin.jvm.internal.p.d(lowerCase, "te") && kotlin.jvm.internal.p.d(headers.k(i10), "trailers"))) {
                    arrayList.add(new a(lowerCase, headers.k(i10)));
                }
            }
            return arrayList;
        }

        public final C5530C.a b(u headerBlock, Protocol protocol) throws IOException {
            kotlin.jvm.internal.p.i(headerBlock, "headerBlock");
            kotlin.jvm.internal.p.i(protocol, "protocol");
            u.a aVar = new u.a();
            int size = headerBlock.size();
            zb.k kVarA = null;
            for (int i10 = 0; i10 < size; i10++) {
                String strF = headerBlock.f(i10);
                String strK = headerBlock.k(i10);
                if (kotlin.jvm.internal.p.d(strF, ":status")) {
                    kVarA = zb.k.INSTANCE.a("HTTP/1.1 " + strK);
                } else if (!o.f1530i.contains(strF)) {
                    aVar.d(strF, strK);
                }
            }
            if (kVarA != null) {
                return new C5530C.a().o(protocol).f(kVarA.code).l(kVarA.message).j(aVar.f());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }

        public Companion() {
        }
    }

    public o(z client, InterfaceC6480d.a carrier, zb.g chain, okhttp3.internal.http2.c http2Connection) {
        kotlin.jvm.internal.p.i(client, "client");
        kotlin.jvm.internal.p.i(carrier, "carrier");
        kotlin.jvm.internal.p.i(chain, "chain");
        kotlin.jvm.internal.p.i(http2Connection, "http2Connection");
        this.carrier = carrier;
        this.chain = chain;
        this.http2Connection = http2Connection;
        List<Protocol> listB = client.B();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.protocol = listB.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    @Override // zb.InterfaceC6480d
    public long a(C5530C response) {
        kotlin.jvm.internal.p.i(response, "response");
        if (C6481e.c(response)) {
            return ub.q.k(response);
        }
        return 0L;
    }

    @Override // zb.InterfaceC6480d
    public G b(C5528A request, long contentLength) {
        kotlin.jvm.internal.p.i(request, "request");
        p pVar = this.stream;
        kotlin.jvm.internal.p.f(pVar);
        return pVar.getSink();
    }

    @Override // zb.InterfaceC6480d
    public I c(C5530C response) {
        kotlin.jvm.internal.p.i(response, "response");
        p pVar = this.stream;
        kotlin.jvm.internal.p.f(pVar);
        return pVar.getSource();
    }

    @Override // zb.InterfaceC6480d
    public void cancel() {
        this.canceled = true;
        p pVar = this.stream;
        if (pVar != null) {
            pVar.i(ErrorCode.CANCEL);
        }
    }

    @Override // zb.InterfaceC6480d
    public void d() throws IOException {
        p pVar = this.stream;
        kotlin.jvm.internal.p.f(pVar);
        pVar.getSink().close();
    }

    @Override // zb.InterfaceC6480d
    public void e(C5528A request) throws IOException {
        kotlin.jvm.internal.p.i(request, "request");
        if (this.stream != null) {
            return;
        }
        this.stream = this.http2Connection.B1(INSTANCE.a(request), request.getBody() != null);
        if (this.canceled) {
            p pVar = this.stream;
            kotlin.jvm.internal.p.f(pVar);
            pVar.i(ErrorCode.CANCEL);
            throw new IOException("Canceled");
        }
        p pVar2 = this.stream;
        kotlin.jvm.internal.p.f(pVar2);
        J jY = pVar2.y();
        long jX = this.chain.x();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        jY.h(jX, timeUnit);
        p pVar3 = this.stream;
        kotlin.jvm.internal.p.f(pVar3);
        pVar3.F().h(this.chain.getWriteTimeoutMillis(), timeUnit);
    }

    @Override // zb.InterfaceC6480d
    public boolean f() {
        p pVar = this.stream;
        return pVar != null && pVar.x();
    }

    @Override // zb.InterfaceC6480d
    public C5530C.a g(boolean expectContinue) throws IOException {
        p pVar = this.stream;
        if (pVar == null) {
            throw new IOException("stream wasn't created");
        }
        C5530C.a aVarB = INSTANCE.b(pVar.D(expectContinue), this.protocol);
        if (expectContinue && aVarB.getCode() == 100) {
            return null;
        }
        return aVarB;
    }

    @Override // zb.InterfaceC6480d
    public void h() throws IOException {
        this.http2Connection.flush();
    }

    @Override // zb.InterfaceC6480d
    public H i() {
        p pVar = this.stream;
        kotlin.jvm.internal.p.f(pVar);
        return pVar;
    }

    @Override // zb.InterfaceC6480d
    /* renamed from: j, reason: from getter */
    public InterfaceC6480d.a getCarrier() {
        return this.carrier;
    }
}
