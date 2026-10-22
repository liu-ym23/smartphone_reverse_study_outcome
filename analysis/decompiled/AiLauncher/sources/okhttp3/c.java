package okhttp3;

import Y8.h;
import Z8.C1173v;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.core.download.ModelFlowMeta;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import okhttp3.c;
import p9.InterfaceC5063a;
import ub.q;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u0000 #2\u00020\u0001:\u0001\u0017B;\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\t¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001dR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0007¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R!\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068GX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\"\u001a\u0004\b#\u0010!R\u0018\u0010&\u001a\u00020\u0014*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010%¨\u0006'"}, d2 = {"Lokhttp3/c;", "", "Lokhttp3/TlsVersion;", "tlsVersion", "Lokhttp3/a;", "cipherSuite", "", "Ljava/security/cert/Certificate;", "localCertificates", "Lkotlin/Function0;", "peerCertificatesFn", "<init>", "(Lokhttp3/TlsVersion;Lokhttp3/a;Ljava/util/List;Lp9/a;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Lokhttp3/TlsVersion;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lokhttp3/TlsVersion;", Const.INTENT_KEY_PKGNAME, "Lokhttp3/a;", "()Lokhttp3/a;", "c", "Ljava/util/List;", Const.INTENT_KEY_UMID, "()Ljava/util/List;", "LY8/h;", "e", "peerCertificates", "(Ljava/security/cert/Certificate;)Ljava/lang/String;", "name", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final TlsVersion tlsVersion;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final a cipherSuite;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final List<Certificate> localCertificates;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final h peerCertificates;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lokhttp3/c$a;", "", "<init>", "()V", "Ljavax/net/ssl/SSLSession;", "Lokhttp3/c;", Const.INTENT_KEY_PKGNAME, "(Ljavax/net/ssl/SSLSession;)Lokhttp3/c;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: okhttp3.c$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static final List c(List list) {
            return list;
        }

        public final c b(SSLSession sSLSession) throws IOException {
            final List listM;
            p.i(sSLSession, "<this>");
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null");
            }
            if (p.d(cipherSuite, "TLS_NULL_WITH_NULL_NULL") || p.d(cipherSuite, "SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException("cipherSuite == " + cipherSuite);
            }
            a aVarB = a.INSTANCE.b(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            }
            if (p.d(ModelFlowMeta.PLAN_NONE, protocol)) {
                throw new IOException("tlsVersion == NONE");
            }
            TlsVersion tlsVersionA = TlsVersion.INSTANCE.a(protocol);
            try {
                listM = q.x(sSLSession.getPeerCertificates());
            } catch (SSLPeerUnverifiedException unused) {
                listM = C1173v.m();
            }
            return new c(tlsVersionA, aVarB, q.x(sSLSession.getLocalCertificates()), new InterfaceC5063a() { // from class: tb.t
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return c.Companion.c(listM);
                }
            });
        }

        public Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(TlsVersion tlsVersion, a cipherSuite, List<? extends Certificate> localCertificates, final InterfaceC5063a<? extends List<? extends Certificate>> peerCertificatesFn) {
        p.i(tlsVersion, "tlsVersion");
        p.i(cipherSuite, "cipherSuite");
        p.i(localCertificates, "localCertificates");
        p.i(peerCertificatesFn, "peerCertificatesFn");
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.localCertificates = localCertificates;
        this.peerCertificates = C4848b.b(new InterfaceC5063a() { // from class: tb.s
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return okhttp3.c.f(peerCertificatesFn);
            }
        });
    }

    public static final List f(InterfaceC5063a interfaceC5063a) {
        try {
            return (List) interfaceC5063a.invoke();
        } catch (SSLPeerUnverifiedException unused) {
            return C1173v.m();
        }
    }

    /* renamed from: b, reason: from getter */
    public final a getCipherSuite() {
        return this.cipherSuite;
    }

    public final String c(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        p.h(type, "getType(...)");
        return type;
    }

    public final List<Certificate> d() {
        return this.localCertificates;
    }

    public final List<Certificate> e() {
        return (List) this.peerCertificates.getValue();
    }

    public boolean equals(Object other) {
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        return cVar.tlsVersion == this.tlsVersion && p.d(cVar.cipherSuite, this.cipherSuite) && p.d(cVar.e(), e()) && p.d(cVar.localCertificates, this.localCertificates);
    }

    /* renamed from: g, reason: from getter */
    public final TlsVersion getTlsVersion() {
        return this.tlsVersion;
    }

    public int hashCode() {
        return ((((((527 + this.tlsVersion.hashCode()) * 31) + this.cipherSuite.hashCode()) * 31) + e().hashCode()) * 31) + this.localCertificates.hashCode();
    }

    public String toString() {
        List<Certificate> listE = e();
        ArrayList arrayList = new ArrayList(C1174w.x(listE, 10));
        Iterator<T> it = listE.iterator();
        while (it.hasNext()) {
            arrayList.add(c((Certificate) it.next()));
        }
        String string = arrayList.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Handshake{tlsVersion=");
        sb2.append(this.tlsVersion);
        sb2.append(" cipherSuite=");
        sb2.append(this.cipherSuite);
        sb2.append(" peerCertificates=");
        sb2.append(string);
        sb2.append(" localCertificates=");
        List<Certificate> list = this.localCertificates;
        ArrayList arrayList2 = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(c((Certificate) it2.next()));
        }
        sb2.append(arrayList2);
        sb2.append('}');
        return sb2.toString();
    }
}
