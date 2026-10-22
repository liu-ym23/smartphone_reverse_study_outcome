package okhttp3;

import bd.l;
import com.stepos.core.download.ModelFlowMeta;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Lambda;
import mb.m;
import okhttp3.TlsVersion;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Handshake {

    /* renamed from: a, reason: collision with root package name */
    public final TlsVersion f10873a;

    /* renamed from: b, reason: collision with root package name */
    public final c f10874b;

    /* renamed from: c, reason: collision with root package name */
    public final List<Certificate> f10875c;

    /* renamed from: d, reason: collision with root package name */
    public final lb.d f10876d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public static Handshake a(SSLSession sSLSession) throws IOException {
            final List listF;
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null");
            }
            if (cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") ? true : cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException("cipherSuite == ".concat(cipherSuite));
            }
            c cVarB = c.f10945b.b(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            }
            if (ModelFlowMeta.PLAN_NONE.equals(protocol)) {
                throw new IOException("tlsVersion == NONE");
            }
            TlsVersion.f10916b.getClass();
            TlsVersion tlsVersionA = TlsVersion.a.a(protocol);
            try {
                Certificate[] peerCertificates = sSLSession.getPeerCertificates();
                listF = peerCertificates != null ? l.f(Arrays.copyOf(peerCertificates, peerCertificates.length)) : EmptyList.f10001a;
            } catch (SSLPeerUnverifiedException unused) {
                listF = EmptyList.f10001a;
            }
            Certificate[] localCertificates = sSLSession.getLocalCertificates();
            return new Handshake(tlsVersionA, cVarB, localCertificates != null ? l.f(Arrays.copyOf(localCertificates, localCertificates.length)) : EmptyList.f10001a, new zb.a<List<? extends Certificate>>() { // from class: okhttp3.Handshake$Companion$handshake$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // zb.a
                public final List<? extends Certificate> invoke() {
                    return listF;
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Handshake(TlsVersion tlsVersion, c cVar, List<? extends Certificate> localCertificates, final zb.a<? extends List<? extends Certificate>> aVar) {
        kotlin.jvm.internal.g.f(localCertificates, "localCertificates");
        this.f10873a = tlsVersion;
        this.f10874b = cVar;
        this.f10875c = localCertificates;
        this.f10876d = kotlin.b.b(new zb.a<List<? extends Certificate>>(aVar) { // from class: okhttp3.Handshake$peerCertificates$2

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Lambda f10878a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.f10878a = (Lambda) aVar;
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.jvm.internal.Lambda, zb.a] */
            @Override // zb.a
            public final List<? extends Certificate> invoke() {
                try {
                    return (List) this.f10878a.invoke();
                } catch (SSLPeerUnverifiedException unused) {
                    return EmptyList.f10001a;
                }
            }
        });
    }

    public final List<Certificate> a() {
        return (List) this.f10876d.getValue();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        return handshake.f10873a == this.f10873a && kotlin.jvm.internal.g.b(handshake.f10874b, this.f10874b) && kotlin.jvm.internal.g.b(handshake.a(), a()) && kotlin.jvm.internal.g.b(handshake.f10875c, this.f10875c);
    }

    public final int hashCode() {
        return this.f10875c.hashCode() + ((a().hashCode() + ((this.f10874b.hashCode() + ((this.f10873a.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String type;
        String type2;
        List<Certificate> listA = a();
        ArrayList arrayList = new ArrayList(m.Z(listA, 10));
        for (Certificate certificate : listA) {
            if (certificate instanceof X509Certificate) {
                type2 = ((X509Certificate) certificate).getSubjectDN().toString();
            } else {
                type2 = certificate.getType();
                kotlin.jvm.internal.g.e(type2, "getType(...)");
            }
            arrayList.add(type2);
        }
        String string = arrayList.toString();
        StringBuilder sb2 = new StringBuilder("Handshake{tlsVersion=");
        sb2.append(this.f10873a);
        sb2.append(" cipherSuite=");
        sb2.append(this.f10874b);
        sb2.append(" peerCertificates=");
        sb2.append(string);
        sb2.append(" localCertificates=");
        List<Certificate> list = this.f10875c;
        ArrayList arrayList2 = new ArrayList(m.Z(list, 10));
        for (Certificate certificate2 : list) {
            if (certificate2 instanceof X509Certificate) {
                type = ((X509Certificate) certificate2).getSubjectDN().toString();
            } else {
                type = certificate2.getType();
                kotlin.jvm.internal.g.e(type, "getType(...)");
            }
            arrayList2.add(type);
        }
        sb2.append(arrayList2);
        sb2.append('}');
        return sb2.toString();
    }
}
