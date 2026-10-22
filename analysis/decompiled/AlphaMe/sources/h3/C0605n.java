package h3;

import com.stepos.alphame.awareness.AwarenessDataItem;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.tls.CertificateChainCleaner;

/* renamed from: h3.n, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0605n {

    /* renamed from: c, reason: collision with root package name */
    public static final C0605n f12937c = new C0605n(CollectionsKt.toSet(new ArrayList()), null);

    /* renamed from: a, reason: collision with root package name */
    public final Set f12938a;

    /* renamed from: b, reason: collision with root package name */
    public final CertificateChainCleaner f12939b;

    public C0605n(Set pins, CertificateChainCleaner certificateChainCleaner) {
        Intrinsics.checkNotNullParameter(pins, "pins");
        this.f12938a = pins;
        this.f12939b = certificateChainCleaner;
    }

    public final void a(String hostname, Function0 cleanedPeerCertificatesFn) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Intrinsics.checkNotNullParameter(cleanedPeerCertificatesFn, "cleanedPeerCertificatesFn");
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        List listEmptyList = CollectionsKt.emptyList();
        Iterator it = this.f12938a.iterator();
        if (it.hasNext()) {
            B0.g.y(it.next());
            throw null;
        }
        if (listEmptyList.isEmpty()) {
            return;
        }
        List<X509Certificate> list = (List) cleanedPeerCertificatesFn.invoke();
        for (X509Certificate x509Certificate : list) {
            Iterator it2 = listEmptyList.iterator();
            if (it2.hasNext()) {
                B0.g.y(it2.next());
                throw null;
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : list) {
            sb.append("\n    ");
            sb.append(y0.e.e(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(hostname);
        sb.append(AwarenessDataItem.USERID_SPLITTER);
        Iterator it3 = listEmptyList.iterator();
        while (it3.hasNext()) {
            B0.g.y(it3.next());
            sb.append("\n    null");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(string);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0605n) {
            C0605n c0605n = (C0605n) obj;
            if (Intrinsics.areEqual(c0605n.f12938a, this.f12938a) && Intrinsics.areEqual(c0605n.f12939b, this.f12939b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f12938a.hashCode() + 1517) * 41;
        CertificateChainCleaner certificateChainCleaner = this.f12939b;
        return iHashCode + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }
}
