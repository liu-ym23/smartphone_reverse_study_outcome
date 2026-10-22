package okhttp3;

import androidx.appcompat.widget.p;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f22852c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f22853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CertificateChainCleaner f22854b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f22855a;

        public a() {
            this.f22855a = new ArrayList();
        }

        public b a() {
            return new b(new LinkedHashSet(this.f22855a), null);
        }
    }

    static {
        f22852c = new a().a();
    }

    public b(Set r10, CertificateChainCleaner r11) {
        this.f22853a = r10;
        this.f22854b = r11;
    }

    public static String c(Certificate r10) {
        if ((r10 instanceof X509Certificate) == false) goto L7;
        return "sha256/" + d((X509Certificate) r10).base64();
    L7:
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    public static ByteString d(X509Certificate r10) {
        return ByteString.of(r10.getPublicKey().getEncoded()).sha256();
    }

    public void a(String r10, List r11) {
        List r12 = b(r10);
        if (r12.isEmpty() == false) goto L5;
        return;
    L5:
        CertificateChainCleaner r13 = this.f22854b;
        if (r13 == null) goto L8;
        r11 = r13.clean(r11, r10);
    L8:
        int r14 = r11.size();
        int r15 = 0;
        int r16 = 0;
    L10:
        if (r16 >= r14) goto L16;
        X509Certificate r17 = (X509Certificate) r11.get(r16);
        if (r12.size() > 0) goto L14;
        r16 = r16 + 1;
        goto L10
    L14:
        p.a(r12.get(0));
        throw null;
    L16:
        StringBuilder r18 = new StringBuilder();
        r18.append("Certificate pinning failure!");
        r18.append("\n  Peer certificate chain:");
        int r19 = r11.size();
        int r20 = 0;
    L18:
        if (r20 >= r19) goto L20;
        X509Certificate r21 = (X509Certificate) r11.get(r20);
        r18.append("\n    ");
        r18.append(c(r21));
        r18.append(": ");
        r18.append(r21.getSubjectDN().getName());
        r20 = r20 + 1;
        goto L18
    L20:
        r18.append("\n  Pinned certificates for ");
        r18.append(r10);
        r18.append(":");
        int r22 = r12.size();
    L21:
        if (r15 >= r22) goto L24;
        p.a(r12.get(r15));
        r18.append("\n    ");
        r18.append(null);
        r15 = r15 + 1;
        goto L21
    L24:
        throw new SSLPeerUnverifiedException(r18.toString());
    }

    public List b(String r10) {
        List r11 = Collections.emptyList();
        Iterator r12 = this.f22853a.iterator();
        if (r12.hasNext() == true) goto L5;
        return r11;
    L5:
        p.a(r12.next());
        throw null;
    }

    public b e(CertificateChainCleaner r10) {
        if (Util.equal(this.f22854b, r10) == false) goto L6;
        return this;
    L6:
        return new b(this.f22853a, r10);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == false) goto L12;
        b r11 = (b) r10;
        if (Util.equal(this.f22854b, r11.f22854b) == false) goto L12;
        if (this.f22853a.equals(r11.f22853a) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        CertificateChainCleaner r10 = this.f22854b;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L7:
        return (r11 * 31) + this.f22853a.hashCode();
    L5:
        r11 = 0;
        goto L7
    }
}
