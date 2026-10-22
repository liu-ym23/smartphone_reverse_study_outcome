package okhttp3.internal.tls;

import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes4.dex */
public final class BasicTrustRootIndex implements TrustRootIndex {
    private final Map<X500Principal, Set<X509Certificate>> subjectToCaCerts;

    public BasicTrustRootIndex(X509Certificate... r10) {
        this.subjectToCaCerts = new LinkedHashMap();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        X509Certificate r13 = r10[r12];
        X500Principal r14 = r13.getSubjectX500Principal();
        Set<X509Certificate> r15 = this.subjectToCaCerts.get(r14);
        if (r15 != null) goto L7;
        r15 = new LinkedHashSet(1);
        this.subjectToCaCerts.put(r14, r15);
    L7:
        r15.add(r13);
        r12 = r12 + 1;
        goto L3
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof BasicTrustRootIndex) == true) goto L8;
    L10:
        return false;
    L8:
        if (((BasicTrustRootIndex) r10).subjectToCaCerts.equals(this.subjectToCaCerts) == false) goto L10;
        return true;
    }

    @Override // okhttp3.internal.tls.TrustRootIndex
    public X509Certificate findByIssuerAndSignature(X509Certificate r10) {
        X500Principal r11 = r10.getIssuerX500Principal();
        Set<X509Certificate> r12 = this.subjectToCaCerts.get(r11);
        if (r12 != null) goto L5;
        return null;
    L5:
        Iterator<X509Certificate> r13 = r12.iterator();
    L7:
        if (r13.hasNext() == false) goto L11;
        X509Certificate r14 = r13.next();
        r10.verify(r14.getPublicKey());     // Catch: Exception -> L12
        return r14;
    L11:
        return null;
    }

    public int hashCode() {
        return this.subjectToCaCerts.hashCode();
    }
}
