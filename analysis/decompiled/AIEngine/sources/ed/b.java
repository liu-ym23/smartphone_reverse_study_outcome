package ed;

import ad.k;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import lb.n;
import okhttp3.Response;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.Http2Connection;
import sd.f0;
import sd.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements k {

    /* renamed from: a, reason: collision with root package name */
    public static final b f8632a = new b();

    @Override // ad.k
    public final Response intercept(k.a aVar) throws IOException {
        fd.d http1ExchangeCodec;
        fd.f fVar = (fd.f) aVar;
        okhttp3.internal.connection.d dVar = fVar.f8835a;
        synchronized (dVar) {
            if (!dVar.r) {
                throw new IllegalStateException("released");
            }
            if (dVar.f11052q) {
                throw new IllegalStateException("Check failed.");
            }
            if (dVar.f11051p) {
                throw new IllegalStateException("Check failed.");
            }
            n nVar = n.f10413a;
        }
        e eVar = dVar.f11047l;
        kotlin.jvm.internal.g.c(eVar);
        g gVarA = eVar.a();
        ad.n nVar2 = dVar.f11040a;
        gVarA.getClass();
        int i10 = fVar.f8841g;
        Socket socket = gVarA.f8653f;
        kotlin.jvm.internal.g.c(socket);
        h hVar = gVarA.f8655i;
        kotlin.jvm.internal.g.c(hVar);
        sd.g gVar = gVarA.f8656j;
        kotlin.jvm.internal.g.c(gVar);
        Http2Connection http2Connection = gVarA.f8659m;
        if (http2Connection != null) {
            http1ExchangeCodec = new okhttp3.internal.http2.c(nVar2, gVarA, fVar, http2Connection);
        } else {
            socket.setSoTimeout(i10);
            f0 f0VarTimeout = hVar.timeout();
            long j10 = i10;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            f0VarTimeout.g(j10, timeUnit);
            gVar.timeout().g(fVar.h, timeUnit);
            http1ExchangeCodec = new Http1ExchangeCodec(nVar2, gVarA, hVar, gVar);
        }
        d dVar2 = new d(dVar, dVar.f11044e, eVar, http1ExchangeCodec);
        dVar.f11050o = dVar2;
        dVar.f11054t = dVar2;
        synchronized (dVar) {
            dVar.f11051p = true;
            dVar.f11052q = true;
        }
        if (dVar.f11053s) {
            throw new IOException("Canceled");
        }
        return fd.f.d(fVar, 0, dVar2, null, 61).b(fVar.f8839e);
    }
}
