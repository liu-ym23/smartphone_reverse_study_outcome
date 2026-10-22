package C4;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;

/* renamed from: C4.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0277g {

    /* renamed from: c, reason: collision with root package name */
    public static final C0277g f776c = new a().a();

    /* renamed from: a, reason: collision with root package name */
    private final Set<b> f777a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final K4.c f778b;

    /* renamed from: C4.g$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<b> f779a = new ArrayList();

        public C0277g a() {
            return new C0277g(new LinkedHashSet(this.f779a), null);
        }
    }

    /* renamed from: C4.g$b */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        final String f780a;

        /* renamed from: b, reason: collision with root package name */
        final String f781b;

        /* renamed from: c, reason: collision with root package name */
        final String f782c;

        /* renamed from: d, reason: collision with root package name */
        final L4.h f783d;

        boolean a(String str) {
            if (!this.f780a.startsWith("*.")) {
                return str.equals(this.f781b);
            }
            int iIndexOf = str.indexOf(46);
            if ((str.length() - iIndexOf) - 1 != this.f781b.length()) {
                return false;
            }
            String str2 = this.f781b;
            return str.regionMatches(false, iIndexOf + 1, str2, 0, str2.length());
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f780a.equals(bVar.f780a) && this.f782c.equals(bVar.f782c) && this.f783d.equals(bVar.f783d);
        }

        public int hashCode() {
            return ((((527 + this.f780a.hashCode()) * 31) + this.f782c.hashCode()) * 31) + this.f783d.hashCode();
        }

        public String toString() {
            return this.f782c + this.f783d.b();
        }
    }

    C0277g(Set<b> set, @Nullable K4.c cVar) {
        this.f777a = set;
        this.f778b = cVar;
    }

    public static String c(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + e((X509Certificate) certificate).b();
    }

    static L4.h d(X509Certificate x509Certificate) {
        return L4.h.p(x509Certificate.getPublicKey().getEncoded()).u();
    }

    static L4.h e(X509Certificate x509Certificate) {
        return L4.h.p(x509Certificate.getPublicKey().getEncoded()).v();
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> listB = b(str);
        if (listB.isEmpty()) {
            return;
        }
        K4.c cVar = this.f778b;
        if (cVar != null) {
            list = cVar.a(list, str);
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i5);
            int size2 = listB.size();
            L4.h hVarE = null;
            L4.h hVarD = null;
            for (int i6 = 0; i6 < size2; i6++) {
                b bVar = listB.get(i6);
                if (bVar.f782c.equals("sha256/")) {
                    if (hVarE == null) {
                        hVarE = e(x509Certificate);
                    }
                    if (bVar.f783d.equals(hVarE)) {
                        return;
                    }
                } else {
                    if (!bVar.f782c.equals("sha1/")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + bVar.f782c);
                    }
                    if (hVarD == null) {
                        hVarD = d(x509Certificate);
                    }
                    if (bVar.f783d.equals(hVarD)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i7 = 0; i7 < size3; i7++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i7);
            sb.append("\n    ");
            sb.append(c(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = listB.size();
        for (int i8 = 0; i8 < size4; i8++) {
            b bVar2 = listB.get(i8);
            sb.append("\n    ");
            sb.append(bVar2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    List<b> b(String str) {
        List<b> arrayList = Collections.EMPTY_LIST;
        for (b bVar : this.f777a) {
            if (bVar.a(str)) {
                if (arrayList.isEmpty()) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0277g)) {
            return false;
        }
        C0277g c0277g = (C0277g) obj;
        return Objects.equals(this.f778b, c0277g.f778b) && this.f777a.equals(c0277g.f777a);
    }

    C0277g f(@Nullable K4.c cVar) {
        return Objects.equals(this.f778b, cVar) ? this : new C0277g(this.f777a, cVar);
    }

    public int hashCode() {
        return (Objects.hashCode(this.f778b) * 31) + this.f777a.hashCode();
    }
}
