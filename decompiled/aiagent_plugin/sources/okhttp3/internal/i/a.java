package okhttp3.internal.i;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.aa;
import okhttp3.internal.i.a.i;
import okhttp3.internal.i.a.j;
import okhttp3.internal.i.a.k;

/* JADX INFO: compiled from: Android10Platform.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1083a f40091a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f40092d = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<k> f40093c;

    /* JADX INFO: renamed from: okhttp3.internal.i.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Android10Platform.kt */
    public static final class C1083a {
        public /* synthetic */ C1083a(d.h.b.h r1) {
            this();
        }

        private C1083a() {
        }

        public final boolean a() {
            return a.a();
        }

        public final h b() {
            if (a() == true) goto L7;
            return null;
        L7:
            return (h) ZeusTransformUtils.preCheckCast(new a(), h.class, "com.obric.aiagent.plugin");
        }
    }

    public static final /* synthetic */ boolean a() {
        return f40092d;
    }

    public a() {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(p.e(new k[]{okhttp3.internal.i.a.a.f40094a.a(), new j(okhttp3.internal.i.a.f.f40102a.a()), new j(i.f40114a.a()), new j(okhttp3.internal.i.a.g.f40108a.a())}), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (((k) ZeusTransformUtils.preCheckCast(r3, k.class, "com.obric.aiagent.plugin")).a() == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        this.f40093c = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
    }

    @Override // okhttp3.internal.i.h
    public X509TrustManager a(SSLSocketFactory r5) {
        o.e(r5, "sslSocketFactory");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f40093c, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r0 = r4.next();
        if (((k) ZeusTransformUtils.preCheckCast(r0, k.class, "com.obric.aiagent.plugin")).b(r5) == false) goto L4;
    L9:
        k r6 = (k) ZeusTransformUtils.preCheckCast(r0, k.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L12;
        return null;
    L12:
        return r6.a(r5);
    L8:
        r0 = null;
        goto L9
    }

    @Override // okhttp3.internal.i.h
    public void a(SSLSocket r4, String r5, List<? extends aa> r6) {
        List<? extends aa> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "sslSocket");
        o.e(r7, "protocols");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f40093c, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r0 = r3.next();
        if (((k) ZeusTransformUtils.preCheckCast(r0, k.class, "com.obric.aiagent.plugin")).a(r4) == false) goto L4;
    L9:
        k r8 = (k) ZeusTransformUtils.preCheckCast(r0, k.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L16;
        r8.a(r4, r5, r7);
        return;
    L16:
        return;
    L8:
        r0 = null;
        goto L9
    }

    @Override // okhttp3.internal.i.h
    public String a(SSLSocket r5) {
        o.e(r5, "sslSocket");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f40093c, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r0 = r4.next();
        if (((k) ZeusTransformUtils.preCheckCast(r0, k.class, "com.obric.aiagent.plugin")).a(r5) == false) goto L4;
    L9:
        k r6 = (k) ZeusTransformUtils.preCheckCast(r0, k.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L12;
        return null;
    L12:
        return r6.b(r5);
    L8:
        r0 = null;
        goto L9
    }

    @Override // okhttp3.internal.i.h
    public boolean a(String r1) {
        o.e(r1, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(r1);
    }

    @Override // okhttp3.internal.i.h
    public okhttp3.internal.k.c a(X509TrustManager r3) {
        X509TrustManager r4 = (X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r3, X509TrustManager.class, "com.obric.aiagent.plugin");
        o.e(r4, "trustManager");
        okhttp3.internal.i.a.b r0 = okhttp3.internal.i.a.b.f40095a.a(r4);
        if (r0 == null) goto L6;
        return (okhttp3.internal.k.c) ZeusTransformUtils.preCheckCast(r0, okhttp3.internal.k.c.class, "com.obric.aiagent.plugin");
    L6:
        return super.a(r4);
    }

    static {
        f40091a = new C1083a(null);
        if (h.f40147b.b() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        f40092d = r0;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 29) goto L7;
        r0 = true;
        goto L8
    }
}
