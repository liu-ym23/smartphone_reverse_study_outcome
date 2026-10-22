package okhttp3.internal.k;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: BasicTrustRootIndex.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<X500Principal, Set<X509Certificate>> f40152a;

    public b(X509Certificate... r9) {
        o.e(r9, "caCerts");
        Map<X500Principal, Set<X509Certificate>> r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        int r1 = r9.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        X509Certificate r4 = r9[r3];
        X500Principal r5 = r4.getSubjectX500Principal();
        o.c(r5, "caCert.subjectX500Principal");
        Set<X509Certificate> r6 = r0.get(r5);
        if (r6 != null) goto L7;
        r6 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
        r0.put(r5, r6);
    L7:
        ((Set) ZeusTransformUtils.preCheckCast(r6, Set.class, "com.obric.aiagent.plugin")).add(r4);
        r3 = r3 + 1;
        goto L3
    L8:
        this.f40152a = r0;
    }

    @Override // okhttp3.internal.k.e
    public X509Certificate a(X509Certificate r5) {
        o.e(r5, "cert");
        X500Principal r0 = r5.getIssuerX500Principal();
        Set r4 = (Set) ZeusTransformUtils.preCheckCast(this.f40152a.get(r0), Set.class, "com.obric.aiagent.plugin");
        Object r1 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r6.hasNext() == false) goto L15;
        Object r2 = r6.next();
        r5.verify(((X509Certificate) ZeusTransformUtils.preCheckCast(r2, X509Certificate.class, "com.obric.aiagent.plugin")).getPublicKey());     // Catch: Exception -> L11
        boolean r3 = true;
    L12:
        if (r3 == false) goto L7;
        r1 = r2;
    L11:
        r3 = false;
    L15:
        return (X509Certificate) ZeusTransformUtils.preCheckCast(r1, X509Certificate.class, "com.obric.aiagent.plugin");
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L5;
    L10:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, b.class) == true) goto L7;
    L9:
        return false;
    L7:
        if (o.a(((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin")).f40152a, this.f40152a) == false) goto L9;
        goto L9
    }

    public int hashCode() {
        return this.f40152a.hashCode();
    }
}
