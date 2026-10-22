package okhttp3;

import gc.o;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.EmptyList;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CertificatePinner {

    /* renamed from: c, reason: collision with root package name */
    public static final CertificatePinner f10859c = new CertificatePinner(kotlin.collections.a.R0(new ArrayList()), null);

    /* renamed from: a, reason: collision with root package name */
    public final Set<a> f10860a;

    /* renamed from: b, reason: collision with root package name */
    public final od.c f10861b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            throw null;
        }
    }

    public CertificatePinner(Set<a> pins, od.c cVar) {
        kotlin.jvm.internal.g.f(pins, "pins");
        this.f10860a = pins;
        this.f10861b = cVar;
    }

    public final void a(final String hostname, final List<? extends Certificate> peerCertificates) {
        kotlin.jvm.internal.g.f(hostname, "hostname");
        kotlin.jvm.internal.g.f(peerCertificates, "peerCertificates");
        b(hostname, new zb.a<List<? extends X509Certificate>>() { // from class: okhttp3.CertificatePinner$check$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // zb.a
            public final List<? extends X509Certificate> invoke() {
                od.c cVar = this.f10862a.f10861b;
                List<Certificate> listA = peerCertificates;
                if (cVar != null) {
                    listA = cVar.a(hostname, listA);
                }
                ArrayList arrayList = new ArrayList(m.Z(listA, 10));
                for (Certificate certificate : listA) {
                    kotlin.jvm.internal.g.d(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    arrayList.add((X509Certificate) certificate);
                }
                return arrayList;
            }
        });
    }

    public final void b(String hostname, zb.a<? extends List<? extends X509Certificate>> aVar) {
        kotlin.jvm.internal.g.f(hostname, "hostname");
        Set<a> set = this.f10860a;
        EmptyList emptyList = EmptyList.f10001a;
        Iterator<T> it = set.iterator();
        if (!it.hasNext()) {
            emptyList.getClass();
        } else {
            ((a) it.next()).getClass();
            o.k0(null, "**.", false);
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof CertificatePinner)) {
            return false;
        }
        CertificatePinner certificatePinner = (CertificatePinner) obj;
        return kotlin.jvm.internal.g.b(certificatePinner.f10860a, this.f10860a) && kotlin.jvm.internal.g.b(certificatePinner.f10861b, this.f10861b);
    }

    public final int hashCode() {
        int iHashCode = (this.f10860a.hashCode() + 1517) * 41;
        od.c cVar = this.f10861b;
        return iHashCode + (cVar != null ? cVar.hashCode() : 0);
    }
}
