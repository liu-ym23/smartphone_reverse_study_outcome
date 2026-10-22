package ab;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final d0 f573a;

    /* renamed from: b, reason: collision with root package name */
    public final g f574b;

    /* renamed from: c, reason: collision with root package name */
    public final List f575c;

    /* renamed from: d, reason: collision with root package name */
    public final c7.o f576d;

    public l(d0 d0Var, g gVar, List list, p7.a aVar) {
        this.f573a = d0Var;
        this.f574b = gVar;
        this.f575c = list;
        this.f576d = s7.a.H(new k(aVar, 0));
    }

    public final List a() {
        return (List) this.f576d.getValue();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return lVar.f573a == this.f573a && q7.k.a(lVar.f574b, this.f574b) && q7.k.a(lVar.a(), a()) && q7.k.a(lVar.f575c, this.f575c);
    }

    public final int hashCode() {
        return this.f575c.hashCode() + ((a().hashCode() + ((this.f574b.hashCode() + ((this.f573a.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String type;
        String type2;
        List<Certificate> listA = a();
        ArrayList arrayList = new ArrayList(d7.t.A0(listA, 10));
        for (Certificate certificate : listA) {
            if (certificate instanceof X509Certificate) {
                type2 = ((X509Certificate) certificate).getSubjectDN().toString();
            } else {
                type2 = certificate.getType();
                q7.k.d(type2, "type");
            }
            arrayList.add(type2);
        }
        String string = arrayList.toString();
        StringBuilder sb2 = new StringBuilder("Handshake{tlsVersion=");
        sb2.append(this.f573a);
        sb2.append(" cipherSuite=");
        sb2.append(this.f574b);
        sb2.append(" peerCertificates=");
        sb2.append(string);
        sb2.append(" localCertificates=");
        List<Certificate> list = this.f575c;
        ArrayList arrayList2 = new ArrayList(d7.t.A0(list, 10));
        for (Certificate certificate2 : list) {
            if (certificate2 instanceof X509Certificate) {
                type = ((X509Certificate) certificate2).getSubjectDN().toString();
            } else {
                type = certificate2.getType();
                q7.k.d(type, "type");
            }
            arrayList2.add(type);
        }
        sb2.append(arrayList2);
        sb2.append('}');
        return sb2.toString();
    }
}
