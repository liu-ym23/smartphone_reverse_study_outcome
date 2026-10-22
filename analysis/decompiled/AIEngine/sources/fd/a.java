package fd;

import ad.k;
import ad.l;
import ad.s;
import ad.t;
import kotlin.collections.EmptyList;
import kotlin.text.Regex;
import mb.m;
import okhttp3.Response;
import okhttp3.f;
import okhttp3.h;
import sd.q;
import sd.z;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements k {

    /* renamed from: a, reason: collision with root package name */
    public final ad.g f8832a;

    public a(ad.g cookieJar) {
        kotlin.jvm.internal.g.f(cookieJar, "cookieJar");
        this.f8832a = cookieJar;
    }

    @Override // ad.k
    public final Response intercept(k.a aVar) {
        boolean z;
        t tVar;
        f fVar = (f) aVar;
        okhttp3.h hVar = fVar.f8839e;
        h.a aVarB = hVar.b();
        okhttp3.g url = hVar.f10992a;
        s sVar = hVar.f10995d;
        if (sVar != null) {
            l lVarContentType = sVar.contentType();
            if (lVarContentType != null) {
                Regex regex = bd.d.f3219a;
                aVarB.b("Content-Type", lVarContentType.f100a);
            }
            long jContentLength = sVar.contentLength();
            if (jContentLength != -1) {
                aVarB.b("Content-Length", String.valueOf(jContentLength));
                aVarB.f11000c.c("Transfer-Encoding");
            } else {
                aVarB.b("Transfer-Encoding", "chunked");
                aVarB.f11000c.c("Content-Length");
            }
        }
        int i10 = 0;
        if (hVar.a("Host") == null) {
            aVarB.b("Host", bd.l.k(url, false));
        }
        if (hVar.a("Connection") == null) {
            aVarB.b("Connection", "Keep-Alive");
        }
        if (hVar.a("Accept-Encoding") == null && hVar.a("Range") == null) {
            aVarB.b("Accept-Encoding", "gzip");
            z = true;
        } else {
            z = false;
        }
        ad.g gVar = this.f8832a;
        gVar.getClass();
        kotlin.jvm.internal.g.f(url, "url");
        EmptyList emptyList = EmptyList.f10001a;
        if (!emptyList.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            for (Object obj : emptyList) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    m.f0();
                    throw null;
                }
                ad.f fVar2 = (ad.f) obj;
                if (i10 > 0) {
                    sb2.append("; ");
                }
                sb2.append(fVar2.f80a);
                sb2.append('=');
                sb2.append(fVar2.f81b);
                i10 = i11;
            }
            String string = sb2.toString();
            kotlin.jvm.internal.g.e(string, "toString(...)");
            aVarB.b("Cookie", string);
        }
        if (hVar.a("User-Agent") == null) {
            aVarB.b("User-Agent", "okhttp/5.0.0-alpha.14");
        }
        okhttp3.h hVar2 = new okhttp3.h(aVarB);
        Response responseB = fVar.b(hVar2);
        okhttp3.f fVar3 = responseB.h;
        e.b(gVar, hVar2.f10992a, fVar3);
        Response.Builder builder = new Response.Builder(responseB);
        builder.f10901a = hVar2;
        if (z && "gzip".equalsIgnoreCase(Response.a("Content-Encoding", responseB)) && e.a(responseB) && (tVar = responseB.f10893j) != null) {
            q qVar = new q(tVar.w());
            f.a aVarE = fVar3.e();
            aVarE.c("Content-Encoding");
            aVarE.c("Content-Length");
            builder.f10906f = aVarE.b().e();
            builder.f10907g = new g(Response.a("Content-Type", responseB), -1L, new z(qVar));
        }
        return builder.a();
    }
}
