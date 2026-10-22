package okhttp3.internal.i;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
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
import okhttp3.internal.i.a.l;

/* JADX INFO: compiled from: AndroidPlatform.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40121a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final boolean f40122e = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<k> f40123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final okhttp3.internal.i.a.h f40124d;

    /* JADX INFO: compiled from: AndroidPlatform.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final boolean a() {
            return b.a();
        }

        public final h b() {
            if (a() == true) goto L7;
            return null;
        L7:
            return (h) ZeusTransformUtils.preCheckCast(new b(), h.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.i.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AndroidPlatform.kt */
    public static final class C1086b implements okhttp3.internal.k.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final X509TrustManager f40125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f40126b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C1086b.class) == true) goto L8;
            return false;
        L8:
            C1086b r6 = (C1086b) ZeusTransformUtils.preCheckCast(r5, C1086b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f40125a, r6.f40125a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f40126b, r6.f40126b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f40125a.hashCode() * 31) + this.f40126b.hashCode();
        }

        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.f40125a + ", findByIssuerAndSignatureMethod=" + this.f40126b + ')';
        }

        public C1086b(X509TrustManager r3, Method r4) {
            X509TrustManager r5 = (X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r3, X509TrustManager.class, "com.obric.aiagent.plugin");
            o.e(r5, "trustManager");
            o.e(r4, "findByIssuerAndSignatureMethod");
            this.f40125a = r5;
            this.f40126b = r4;
        }

        @Override // okhttp3.internal.k.e
        public X509Certificate a(X509Certificate r5) {
            o.e(r5, "cert");
            Object r4 = this.f40126b.invoke(this.f40125a, new Object[]{r5});     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7
            o.a(r4, "null cannot be cast to non-null type java.security.cert.TrustAnchor");     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7
        L12:
            return ((TrustAnchor) ZeusTransformUtils.preCheckCast(r4, TrustAnchor.class, "com.obric.aiagent.plugin")).getTrustedCert();
        L7:
            e = move-exception;
            throw new AssertionError("unable to get issues and signature", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        L5:
            return null;
        }
    }

    public static final /* synthetic */ boolean a() {
        return f40122e;
    }

    public b() {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(p.e(new k[]{l.a.a(l.f40118b, null, 1, null), new j(okhttp3.internal.i.a.f.f40102a.a()), new j(i.f40114a.a()), new j(okhttp3.internal.i.a.g.f40108a.a())}), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (((k) ZeusTransformUtils.preCheckCast(r3, k.class, "com.obric.aiagent.plugin")).a() == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        this.f40123c = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
        this.f40124d = okhttp3.internal.i.a.h.f40110a.a();
    }

    @Override // okhttp3.internal.i.h
    public void a(Socket r2, InetSocketAddress r3, int r4) {
        o.e(r2, "socket");
        o.e(r3, SensitiveType.ADDRESS);
        r2.connect((SocketAddress) ZeusTransformUtils.preCheckCast(r3, SocketAddress.class, "com.obric.aiagent.plugin"), r4);     // Catch: ClassCastException -> L5
        return;
    L5:
        e = move-exception;
        if (Build.VERSION.SDK_INT == 26) goto L9;
        throw e;
    L9:
        throw new IOException("Exception in connect", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    @Override // okhttp3.internal.i.h
    public X509TrustManager a(SSLSocketFactory r5) {
        o.e(r5, "sslSocketFactory");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f40123c, Iterable.class, "com.obric.aiagent.plugin")).iterator();
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
    public void a(SSLSocket r4, String r5, List<aa> r6) {
        List<? extends aa> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "sslSocket");
        o.e(r7, "protocols");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f40123c, Iterable.class, "com.obric.aiagent.plugin")).iterator();
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
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f40123c, Iterable.class, "com.obric.aiagent.plugin")).iterator();
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
    public Object b(String r2) {
        o.e(r2, "closer");
        return this.f40124d.a(r2);
    }

    @Override // okhttp3.internal.i.h
    public void a(String r7, Object r8) {
        o.e(r7, "message");
        if (this.f40124d.a(r8) == true) goto L6;
        h.a((h) ZeusTransformUtils.preCheckCast(this, h.class, "com.obric.aiagent.plugin"), r7, 5, null, 4, null);
        return;
    }

    @Override // okhttp3.internal.i.h
    public boolean a(String r2) {
        o.e(r2, "hostname");
        if (Build.VERSION.SDK_INT < 24) goto L6;
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(r2);
    L6:
        if (Build.VERSION.SDK_INT >= 23) goto L11;
        return true;
    L11:
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
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

    @Override // okhttp3.internal.i.h
    public okhttp3.internal.k.e b(X509TrustManager r8) {
        X509TrustManager r9 = (X509TrustManager) ZeusTransformUtils.wrapperContextForParams(r8, X509TrustManager.class, "com.obric.aiagent.plugin");
        o.e(r9, "trustManager");
        Method r0 = r9.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});     // Catch: NoSuchMethodException -> L5
        r0.setAccessible(true);     // Catch: NoSuchMethodException -> L5
        o.c(r0, "method");     // Catch: NoSuchMethodException -> L5
        return (okhttp3.internal.k.e) ZeusTransformUtils.preCheckCast(new C1086b(r9, r0), okhttp3.internal.k.e.class, "com.obric.aiagent.plugin");
    L6:
        return super.b(r9);
    }

    static {
        f40121a = new a(null);
        boolean r1 = true;
        boolean r2 = false;
        if (h.f40147b.b() == true) goto L6;
    L4:
        r1 = false;
    L12:
        f40122e = r1;
        return;
    L6:
        if (Build.VERSION.SDK_INT >= 30) goto L4;
        if (Build.VERSION.SDK_INT < 21) goto L11;
        r2 = true;
    L11:
        if (r2 == true) goto L12;
        throw new IllegalStateException(("Expected Android API level 21+ but was " + Build.VERSION.SDK_INT).toString());
    }
}
