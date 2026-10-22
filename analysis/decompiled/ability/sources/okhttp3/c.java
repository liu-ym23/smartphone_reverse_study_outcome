package okhttp3;

import C7.f;
import D7.w;
import F9.C0232j;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final TlsVersion f5467a;
    public final C0232j b;
    public final List c;
    public final f d;

    public c(TlsVersion tlsVersion, C0232j c0232j, List localCertificates, final S7.a aVar) {
        k.f(localCertificates, "localCertificates");
        this.f5467a = tlsVersion;
        this.b = c0232j;
        this.c = localCertificates;
        this.d = kotlin.a.a(new S7.a(aVar) { // from class: okhttp3.Handshake$peerCertificates$2

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Lambda f5463a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.f5463a = (Lambda) aVar;
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [S7.a, kotlin.jvm.internal.Lambda] */
            @Override // S7.a
            public final Object invoke() {
                try {
                    return (List) this.f5463a.invoke();
                } catch (SSLPeerUnverifiedException unused) {
                    return EmptyList.f4893a;
                }
            }
        });
    }

    public final List a() {
        return (List) this.d.getF4884a();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return cVar.f5467a == this.f5467a && k.b(cVar.b, this.b) && k.b(cVar.a(), a()) && k.b(cVar.c, this.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((a().hashCode() + ((this.b.hashCode() + ((this.f5467a.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String type;
        String type2;
        List<Certificate> listA = a();
        ArrayList arrayList = new ArrayList(w.c0(listA, 10));
        for (Certificate certificate : listA) {
            if (certificate instanceof X509Certificate) {
                type2 = ((X509Certificate) certificate).getSubjectDN().toString();
            } else {
                type2 = certificate.getType();
                k.e(type2, "type");
            }
            arrayList.add(type2);
        }
        String string = arrayList.toString();
        StringBuilder sb = new StringBuilder("Handshake{tlsVersion=");
        sb.append(this.f5467a);
        sb.append(" cipherSuite=");
        sb.append(this.b);
        sb.append(" peerCertificates=");
        sb.append(string);
        sb.append(" localCertificates=");
        List<Certificate> list = this.c;
        ArrayList arrayList2 = new ArrayList(w.c0(list, 10));
        for (Certificate certificate2 : list) {
            if (certificate2 instanceof X509Certificate) {
                type = ((X509Certificate) certificate2).getSubjectDN().toString();
            } else {
                type = certificate2.getType();
                k.e(type, "type");
            }
            arrayList2.add(type);
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }
}
