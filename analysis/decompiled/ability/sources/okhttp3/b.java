package okhttp3;

import F9.AbstractC0226d;
import F9.C0232j;
import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.collections.EmptyList;

/* loaded from: classes4.dex */
public abstract class b {
    public static c a(SSLSession sSLSession) throws IOException {
        final List listJ;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if (cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") ? true : cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
            throw new IOException("cipherSuite == ".concat(cipherSuite));
        }
        C0232j c0232jD = C0232j.b.d(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        TlsVersion tlsVersionF = AbstractC0226d.f(protocol);
        try {
            Certificate[] peerCertificates = sSLSession.getPeerCertificates();
            listJ = peerCertificates != null ? G9.b.j(Arrays.copyOf(peerCertificates, peerCertificates.length)) : EmptyList.f4893a;
        } catch (SSLPeerUnverifiedException unused) {
            listJ = EmptyList.f4893a;
        }
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new c(tlsVersionF, c0232jD, localCertificates != null ? G9.b.j(Arrays.copyOf(localCertificates, localCertificates.length)) : EmptyList.f4893a, new S7.a() { // from class: okhttp3.Handshake$Companion$handshake$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // S7.a
            public final Object invoke() {
                return listJ;
            }
        });
    }
}
