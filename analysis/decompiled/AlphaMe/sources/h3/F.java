package h3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class F {

    /* renamed from: a, reason: collision with root package name */
    public final h0 f12707a;

    /* renamed from: b, reason: collision with root package name */
    public final C0607p f12708b;

    /* renamed from: c, reason: collision with root package name */
    public final List f12709c;

    /* renamed from: d, reason: collision with root package name */
    public final Lazy f12710d;

    public F(h0 tlsVersion, C0607p cipherSuite, List localCertificates, Function0 peerCertificatesFn) {
        Intrinsics.checkNotNullParameter(tlsVersion, "tlsVersion");
        Intrinsics.checkNotNullParameter(cipherSuite, "cipherSuite");
        Intrinsics.checkNotNullParameter(localCertificates, "localCertificates");
        Intrinsics.checkNotNullParameter(peerCertificatesFn, "peerCertificatesFn");
        this.f12707a = tlsVersion;
        this.f12708b = cipherSuite;
        this.f12709c = localCertificates;
        this.f12710d = LazyKt.lazy(new V.e(peerCertificatesFn, 1));
    }

    public final List a() {
        return (List) this.f12710d.getValue();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof F) {
            F f4 = (F) obj;
            if (f4.f12707a == this.f12707a && Intrinsics.areEqual(f4.f12708b, this.f12708b) && Intrinsics.areEqual(f4.a(), a()) && Intrinsics.areEqual(f4.f12709c, this.f12709c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f12709c.hashCode() + ((a().hashCode() + ((this.f12708b.hashCode() + ((this.f12707a.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String type;
        String type2;
        List<Certificate> listA = a();
        ArrayList arrayList = new ArrayList(CollectionsKt.e(listA));
        for (Certificate certificate : listA) {
            if (certificate instanceof X509Certificate) {
                type2 = ((X509Certificate) certificate).getSubjectDN().toString();
            } else {
                type2 = certificate.getType();
                Intrinsics.checkNotNullExpressionValue(type2, "type");
            }
            arrayList.add(type2);
        }
        String string = arrayList.toString();
        StringBuilder sb = new StringBuilder("Handshake{tlsVersion=");
        sb.append(this.f12707a);
        sb.append(" cipherSuite=");
        sb.append(this.f12708b);
        sb.append(" peerCertificates=");
        sb.append(string);
        sb.append(" localCertificates=");
        List<Certificate> list = this.f12709c;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.e(list));
        for (Certificate certificate2 : list) {
            if (certificate2 instanceof X509Certificate) {
                type = ((X509Certificate) certificate2).getSubjectDN().toString();
            } else {
                type = certificate2.getType();
                Intrinsics.checkNotNullExpressionValue(type, "type");
            }
            arrayList2.add(type);
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }
}
