package okhttp3;

import D7.v;
import D7.w;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class a {
    public static final a c = new a(v.j1(new ArrayList()), null);

    /* renamed from: a, reason: collision with root package name */
    public final Set f5466a;
    public final S9.c b;

    public a(Set pins, S9.c cVar) {
        k.f(pins, "pins");
        this.f5466a = pins;
        this.b = cVar;
    }

    public final void a(final String hostname, final List peerCertificates) {
        k.f(hostname, "hostname");
        k.f(peerCertificates, "peerCertificates");
        b(hostname, new S7.a() { // from class: okhttp3.CertificatePinner$check$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // S7.a
            public final Object invoke() {
                S9.c cVar = this.f5461a.b;
                List listA = peerCertificates;
                if (cVar != null) {
                    listA = cVar.a(hostname, listA);
                }
                List<Certificate> list = listA;
                ArrayList arrayList = new ArrayList(w.c0(list, 10));
                for (Certificate certificate : list) {
                    k.d(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    arrayList.add((X509Certificate) certificate);
                }
                return arrayList;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.String r14, S7.a r15) throws java.security.NoSuchAlgorithmException, javax.net.ssl.SSLPeerUnverifiedException {
        /*
            Method dump skipped, instructions count: 405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.a.b(java.lang.String, S7.a):void");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.b(aVar.f5466a, this.f5466a) && k.b(aVar.b, this.b);
    }

    public final int hashCode() {
        int iHashCode = (this.f5466a.hashCode() + 1517) * 41;
        S9.c cVar = this.b;
        return iHashCode + (cVar != null ? cVar.hashCode() : 0);
    }
}
