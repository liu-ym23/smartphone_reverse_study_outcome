package okhttp3.internal.http2;

import ad.n;
import bd.l;
import com.tonyodev.fetch2core.server.FileResponse;
import ed.g;
import fd.d;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.h;
import okhttp3.internal.http2.e;
import okio.ByteString;
import sd.c0;
import sd.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements fd.d {

    /* renamed from: g, reason: collision with root package name */
    public static final List<String> f11209g = l.f(FileResponse.FIELD_CONNECTION, "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");
    public static final List<String> h = l.f(FileResponse.FIELD_CONNECTION, "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a, reason: collision with root package name */
    public final g f11210a;

    /* renamed from: b, reason: collision with root package name */
    public final fd.f f11211b;

    /* renamed from: c, reason: collision with root package name */
    public final Http2Connection f11212c;

    /* renamed from: d, reason: collision with root package name */
    public volatile e f11213d;

    /* renamed from: e, reason: collision with root package name */
    public final Protocol f11214e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f11215f;

    public c(n nVar, g gVar, fd.f fVar, Http2Connection http2Connection) {
        kotlin.jvm.internal.g.f(http2Connection, "http2Connection");
        this.f11210a = gVar;
        this.f11211b = fVar;
        this.f11212c = http2Connection;
        List<Protocol> list = nVar.r;
        Protocol protocol = Protocol.f10883j;
        this.f11214e = list.contains(protocol) ? protocol : Protocol.h;
    }

    @Override // fd.d
    public final void a() throws SocketTimeoutException {
        e eVar = this.f11213d;
        kotlin.jvm.internal.g.c(eVar);
        eVar.f().close();
    }

    @Override // fd.d
    public final e0 b(Response response) {
        e eVar = this.f11213d;
        kotlin.jvm.internal.g.c(eVar);
        return eVar.h;
    }

    @Override // fd.d
    public final long c(Response response) {
        if (fd.e.a(response)) {
            return l.e(response);
        }
        return 0L;
    }

    @Override // fd.d
    public final void cancel() {
        this.f11215f = true;
        e eVar = this.f11213d;
        if (eVar != null) {
            eVar.e(ErrorCode.f11126k);
        }
    }

    @Override // fd.d
    public final c0 d(h request, long j10) {
        kotlin.jvm.internal.g.f(request, "request");
        e eVar = this.f11213d;
        kotlin.jvm.internal.g.c(eVar);
        return eVar.f();
    }

    @Override // fd.d
    public final void e(h request) throws IOException {
        int i10;
        e eVar;
        boolean z;
        kotlin.jvm.internal.g.f(request, "request");
        if (this.f11213d != null) {
            return;
        }
        boolean z3 = request.f10995d != null;
        okhttp3.f fVar = request.f10994c;
        ArrayList arrayList = new ArrayList(fVar.size() + 4);
        arrayList.add(new hd.a(hd.a.f9408f, request.f10993b));
        ByteString byteString = hd.a.f9409g;
        okhttp3.g url = request.f10992a;
        kotlin.jvm.internal.g.f(url, "url");
        String strB = url.b();
        String strD = url.d();
        if (strD != null) {
            strB = strB + '?' + strD;
        }
        arrayList.add(new hd.a(byteString, strB));
        String strA = request.a("Host");
        if (strA != null) {
            arrayList.add(new hd.a(hd.a.f9410i, strA));
        }
        arrayList.add(new hd.a(hd.a.h, url.f10977a));
        int size = fVar.size();
        for (int i11 = 0; i11 < size; i11++) {
            String strB2 = fVar.b(i11);
            Locale US = Locale.US;
            kotlin.jvm.internal.g.e(US, "US");
            String lowerCase = strB2.toLowerCase(US);
            kotlin.jvm.internal.g.e(lowerCase, "toLowerCase(...)");
            if (!f11209g.contains(lowerCase) || (lowerCase.equals("te") && fVar.g(i11).equals("trailers"))) {
                arrayList.add(new hd.a(lowerCase, fVar.g(i11)));
            }
        }
        Http2Connection http2Connection = this.f11212c;
        http2Connection.getClass();
        boolean z10 = !z3;
        synchronized (http2Connection.A) {
            synchronized (http2Connection) {
                try {
                    if (http2Connection.f11133e > 1073741823) {
                        http2Connection.K(ErrorCode.f11125j);
                    }
                    if (http2Connection.h) {
                        throw new ConnectionShutdownException();
                    }
                    i10 = http2Connection.f11133e;
                    http2Connection.f11133e = i10 + 2;
                    eVar = new e(i10, http2Connection, z10, false, null);
                    z = !z3 || http2Connection.f11147x >= http2Connection.f11148y || eVar.f11228d >= eVar.f11229e;
                    if (eVar.h()) {
                        http2Connection.f11130b.put(Integer.valueOf(i10), eVar);
                    }
                    lb.n nVar = lb.n.f10413a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            http2Connection.A.K(z10, i10, arrayList);
        }
        if (z) {
            http2Connection.A.flush();
        }
        this.f11213d = eVar;
        if (this.f11215f) {
            e eVar2 = this.f11213d;
            kotlin.jvm.internal.g.c(eVar2);
            eVar2.e(ErrorCode.f11126k);
            throw new IOException("Canceled");
        }
        e eVar3 = this.f11213d;
        kotlin.jvm.internal.g.c(eVar3);
        e.c cVar = eVar3.f11233j;
        long j10 = this.f11211b.f8841g;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        cVar.g(j10, timeUnit);
        e eVar4 = this.f11213d;
        kotlin.jvm.internal.g.c(eVar4);
        eVar4.f11234k.g(this.f11211b.h, timeUnit);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002a  */
    @Override // fd.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final okhttp3.Response.Builder f(boolean r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.c.f(boolean):okhttp3.Response$Builder");
    }

    @Override // fd.d
    public final void g() {
        this.f11212c.flush();
    }

    @Override // fd.d
    public final d.a h() {
        return this.f11210a;
    }

    @Override // fd.d
    public final okhttp3.f i() throws IOException {
        okhttp3.f fVar;
        e eVar = this.f11213d;
        kotlin.jvm.internal.g.c(eVar);
        synchronized (eVar) {
            e.b bVar = eVar.h;
            if (!bVar.f11242b || !bVar.f11243c.f0() || !eVar.h.f11244d.f0()) {
                if (eVar.f11235l == null) {
                    throw new IllegalStateException("too early; can't read the trailers yet");
                }
                IOException iOException = eVar.f11236m;
                if (iOException != null) {
                    throw iOException;
                }
                ErrorCode errorCode = eVar.f11235l;
                kotlin.jvm.internal.g.c(errorCode);
                throw new StreamResetException(errorCode);
            }
            fVar = eVar.h.f11245e;
            if (fVar == null) {
                fVar = l.f3237a;
            }
        }
        return fVar;
    }
}
