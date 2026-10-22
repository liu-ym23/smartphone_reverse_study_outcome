package ad;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final j0 f544a;

    /* renamed from: b, reason: collision with root package name */
    public final g f545b;

    /* renamed from: c, reason: collision with root package name */
    public final List f546c;

    /* renamed from: d, reason: collision with root package name */
    public final jb.k f547d;

    public m(j0 j0Var, g gVar, List list, xb.a aVar) {
        this.f544a = j0Var;
        this.f545b = gVar;
        this.f546c = list;
        this.f547d = new jb.k(new l(aVar));
    }

    public final List a() {
        return (List) this.f547d.getValue();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return mVar.f544a == this.f544a && mVar.f545b.equals(this.f545b) && yb.k.a(mVar.a(), a()) && mVar.f546c.equals(this.f546c);
    }

    public final int hashCode() {
        return this.f546c.hashCode() + ((a().hashCode() + ((this.f545b.hashCode() + ((this.f544a.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String type;
        String type2;
        List<Certificate> listA = a();
        ArrayList arrayList = new ArrayList(kb.m.m0(listA, 10));
        for (Certificate certificate : listA) {
            if (certificate instanceof X509Certificate) {
                type2 = ((X509Certificate) certificate).getSubjectDN().toString();
            } else {
                type2 = certificate.getType();
                type2.getClass();
            }
            arrayList.add(type2);
        }
        String string = arrayList.toString();
        StringBuilder sb2 = new StringBuilder("Handshake{tlsVersion=");
        sb2.append(this.f544a);
        sb2.append(" cipherSuite=");
        sb2.append(this.f545b);
        sb2.append(" peerCertificates=");
        sb2.append(string);
        sb2.append(" localCertificates=");
        List<Certificate> list = this.f546c;
        ArrayList arrayList2 = new ArrayList(kb.m.m0(list, 10));
        for (Certificate certificate2 : list) {
            if (certificate2 instanceof X509Certificate) {
                type = ((X509Certificate) certificate2).getSubjectDN().toString();
            } else {
                type = certificate2.getType();
                type.getClass();
            }
            arrayList2.add(type);
        }
        sb2.append(arrayList2);
        sb2.append('}');
        return sb2.toString();
    }
}
