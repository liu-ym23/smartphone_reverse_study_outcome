package okhttp3.internal.k;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: compiled from: BasicCertificateChainCleaner.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1087a f40150a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f40151c;

    /* JADX INFO: renamed from: okhttp3.internal.k.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BasicCertificateChainCleaner.kt */
    public static final class C1087a {
        public /* synthetic */ C1087a(h r1) {
            this();
        }

        private C1087a() {
        }
    }

    static {
        f40150a = new C1087a(null);
    }

    public a(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        o.e(r4, "trustRootIndex");
        this.f40151c = r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // okhttp3.internal.k.c
    public List<Certificate> a(List<? extends Certificate> r9, String r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        o.e(r11, "chain");
        o.e(r10, "hostname");
        Deque r12 = (Deque) ZeusTransformUtils.preCheckCast(new ArrayDeque((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin")), Deque.class, "com.obric.aiagent.plugin");
        List<Certificate> r13 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Object r0 = r12.removeFirst();
        o.c(r0, "queue.removeFirst()");
        r13.add(r0);
        int r1 = 0;
        boolean r2 = false;
    L4:
        if (r1 >= 9) goto L28;
        Object r3 = r13.get(r13.size() - 1);
        o.a(r3, "null cannot be cast to non-null type java.security.cert.X509Certificate");
        X509Certificate r4 = (X509Certificate) ZeusTransformUtils.preCheckCast(r3, X509Certificate.class, "com.obric.aiagent.plugin");
        X509Certificate r6 = this.f40151c.a(r4);
        if (r6 != null) goto L8;
        Iterator r5 = r12.iterator();
        o.c(r5, "queue.iterator()");
    L18:
        if (r5.hasNext() == false) goto L23;
        Object r7 = r5.next();
        o.a(r7, "null cannot be cast to non-null type java.security.cert.X509Certificate");
        X509Certificate r8 = (X509Certificate) ZeusTransformUtils.preCheckCast(r7, X509Certificate.class, "com.obric.aiagent.plugin");
        if (a(r4, r8) == false) goto L18;
        r5.remove();
        r13.add(r8);
    L22:
        r1 = r1 + 1;
        goto L4
    L23:
        if (r2 == false) goto L26;
        return r13;
    L26:
        throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + r4);
    L8:
        if (r13.size() <= 1) goto L10;
    L11:
        r13.add(r6);
    L13:
        if (a(r6, r6) == true) goto L14;
        r2 = true;
        goto L22
    L14:
        return r13;
    L10:
        if (o.a(r4, r6) == true) goto L13;
    L28:
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + r13);
    }

    private final boolean a(X509Certificate r2, X509Certificate r3) {
        if (o.a(r2.getIssuerDN(), r3.getSubjectDN()) == true) goto L9;
        return false;
    L9:
        r2.verify(r3.getPublicKey());     // Catch: GeneralSecurityException -> L8
        return true;
    L11:
        return false;
    }

    public int hashCode() {
        return this.f40151c.hashCode();
    }

    public boolean equals(Object r4) {
        if (r4 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, a.class) == true) goto L8;
    L10:
        return false;
    L8:
        if (o.a(((a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin")).f40151c, this.f40151c) == false) goto L10;
        return true;
    }
}
