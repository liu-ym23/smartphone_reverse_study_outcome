package n6;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final y f4050a;

    /* renamed from: b, reason: collision with root package name */
    public final g f4051b;

    /* renamed from: c, reason: collision with root package name */
    public final List f4052c;
    public final b5.k d;

    public j(y yVar, g gVar, List list, p5.a aVar) {
        this.f4050a = yVar;
        this.f4051b = gVar;
        this.f4052c = list;
        this.d = b8.h.x(new b7.c(18, aVar));
    }

    public final List a() {
        return (List) this.d.getValue();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return jVar.f4050a == this.f4050a && kotlin.jvm.internal.p.a(jVar.f4051b, this.f4051b) && kotlin.jvm.internal.p.a(jVar.a(), a()) && kotlin.jvm.internal.p.a(jVar.f4052c, this.f4052c);
    }

    public final int hashCode() {
        return this.f4052c.hashCode() + ((a().hashCode() + ((this.f4051b.hashCode() + ((this.f4050a.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String type;
        String type2;
        List<Certificate> listA = a();
        ArrayList arrayList = new ArrayList(c5.o.n0(listA, 10));
        for (Certificate certificate : listA) {
            if (certificate instanceof X509Certificate) {
                type2 = ((X509Certificate) certificate).getSubjectDN().toString();
            } else {
                type2 = certificate.getType();
                kotlin.jvm.internal.p.d(type2, "getType(...)");
            }
            arrayList.add(type2);
        }
        String string = arrayList.toString();
        StringBuilder sb = new StringBuilder("Handshake{tlsVersion=");
        sb.append(this.f4050a);
        sb.append(" cipherSuite=");
        sb.append(this.f4051b);
        sb.append(" peerCertificates=");
        sb.append(string);
        sb.append(" localCertificates=");
        List<Certificate> list = this.f4052c;
        ArrayList arrayList2 = new ArrayList(c5.o.n0(list, 10));
        for (Certificate certificate2 : list) {
            if (certificate2 instanceof X509Certificate) {
                type = ((X509Certificate) certificate2).getSubjectDN().toString();
            } else {
                type = certificate2.getType();
                kotlin.jvm.internal.p.d(type, "getType(...)");
            }
            arrayList2.add(type);
        }
        sb.append(arrayList2);
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }
}
