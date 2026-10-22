package okhttp3.internal.tls;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes4.dex */
public final class BasicCertificateChainCleaner extends CertificateChainCleaner {
    private static final int MAX_SIGNERS = 9;
    private final TrustRootIndex trustRootIndex;

    public BasicCertificateChainCleaner(TrustRootIndex r10) {
        this.trustRootIndex = r10;
    }

    private boolean verifySignature(X509Certificate r10, X509Certificate r11) {
        if (r10.getIssuerDN().equals(r11.getSubjectDN()) == true) goto L9;
        return false;
    L9:
        r10.verify(r11.getPublicKey());     // Catch: GeneralSecurityException -> L8
        return true;
    L8:
        return false;
    }

    @Override // okhttp3.internal.tls.CertificateChainCleaner
    public List<Certificate> clean(List<Certificate> r10, String r11) throws SSLPeerUnverifiedException {
        ArrayDeque r12 = new ArrayDeque(r10);
        ArrayList r13 = new ArrayList();
        r13.add(r12.removeFirst());
        int r14 = 0;
        boolean r15 = false;
    L4:
        if (r14 >= 9) goto L28;
        X509Certificate r16 = (X509Certificate) r13.get(r13.size() - 1);
        X509Certificate r17 = this.trustRootIndex.findByIssuerAndSignature(r16);
        if (r17 != null) goto L8;
        Iterator r18 = r12.iterator();
    L18:
        if (r18.hasNext() == false) goto L23;
        X509Certificate r19 = (X509Certificate) r18.next();
        if (verifySignature(r16, r19) == false) goto L18;
        r18.remove();
        r13.add(r19);
    L22:
        r14 = r14 + 1;
        goto L4
    L23:
        if (r15 == false) goto L26;
        return r13;
    L26:
        throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + r16);
    L8:
        if (r13.size() <= 1) goto L10;
    L11:
        r13.add(r17);
    L13:
        if (verifySignature(r17, r17) == true) goto L14;
        r15 = true;
        goto L22
    L14:
        return r13;
    L10:
        if (r16.equals(r17) == true) goto L13;
    L28:
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + r13);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof BasicCertificateChainCleaner) == true) goto L8;
    L10:
        return false;
    L8:
        if (((BasicCertificateChainCleaner) r10).trustRootIndex.equals(this.trustRootIndex) == false) goto L10;
        return true;
    }

    public int hashCode() {
        return this.trustRootIndex.hashCode();
    }
}
