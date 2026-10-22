package C4;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    private final I f951a;

    /* renamed from: b, reason: collision with root package name */
    private final C0279i f952b;

    /* renamed from: c, reason: collision with root package name */
    private final List<Certificate> f953c;

    /* renamed from: d, reason: collision with root package name */
    private final List<Certificate> f954d;

    private u(I i5, C0279i c0279i, List<Certificate> list, List<Certificate> list2) {
        this.f951a = i5;
        this.f952b = c0279i;
        this.f953c = list;
        this.f954d = list2;
    }

    public static u b(SSLSession sSLSession) throws IOException {
        Certificate[] peerCertificates;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        C0279i c0279iB = C0279i.b(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        I iB = I.b(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            peerCertificates = null;
        }
        List listU = peerCertificates != null ? D4.e.u(peerCertificates) : Collections.EMPTY_LIST;
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new u(iB, c0279iB, listU, localCertificates != null ? D4.e.u(localCertificates) : Collections.EMPTY_LIST);
    }

    private List<String> c(List<Certificate> list) {
        ArrayList arrayList = new ArrayList();
        for (Certificate certificate : list) {
            if (certificate instanceof X509Certificate) {
                arrayList.add(String.valueOf(((X509Certificate) certificate).getSubjectDN()));
            } else {
                arrayList.add(certificate.getType());
            }
        }
        return arrayList;
    }

    public C0279i a() {
        return this.f952b;
    }

    public List<Certificate> d() {
        return this.f953c;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f951a.equals(uVar.f951a) && this.f952b.equals(uVar.f952b) && this.f953c.equals(uVar.f953c) && this.f954d.equals(uVar.f954d);
    }

    public int hashCode() {
        return ((((((527 + this.f951a.hashCode()) * 31) + this.f952b.hashCode()) * 31) + this.f953c.hashCode()) * 31) + this.f954d.hashCode();
    }

    public String toString() {
        return "Handshake{tlsVersion=" + this.f951a + " cipherSuite=" + this.f952b + " peerCertificates=" + c(this.f953c) + " localCertificates=" + c(this.f954d) + '}';
    }
}
