package okhttp3.internal.d;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.af;
import okhttp3.internal.g.m;
import okhttp3.internal.g.n;
import okhttp3.l;
import okhttp3.r;
import okhttp3.t;
import okhttp3.v;
import okhttp3.z;

/* JADX INFO: compiled from: RealConnection.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f extends okhttp3.internal.g.f.c implements okhttp3.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f39890a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g f39891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final af f39892e;
    private Socket f;
    private Socket g;
    private t h;
    private aa i;
    private okhttp3.internal.g.f j;
    private e.g k;
    private e.f l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private int q;
    private int r;
    private final List<Reference<e>> s;
    private long t;

    /* JADX INFO: compiled from: RealConnection.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: RealConnection.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f39893a = null;

        static {
            int[] r0 = new int[Proxy.Type.values().length];
            r0[Proxy.Type.DIRECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Proxy.Type.HTTP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f39893a = r0;
        }
    }

    /* JADX INFO: compiled from: RealConnection.kt */
    static final class c extends p implements d.h.a.a<List<? extends Certificate>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ okhttp3.g f39894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ t f39895b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ okhttp3.a f39896c;

        c(okhttp3.g r1, t r2, okhttp3.a r3) {
            this.f39894a = r1;
            this.f39895b = r2;
            this.f39896c = r3;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ List<? extends Certificate> invoke() {
            return a();
        }

        public final List<Certificate> a() {
            okhttp3.internal.k.c r0 = this.f39894a.a();
            o.a(r0);
            return r0.a(this.f39895b.d(), this.f39896c.i().b());
        }
    }

    /* JADX INFO: compiled from: RealConnection.kt */
    static final class d extends p implements d.h.a.a<List<? extends X509Certificate>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f39897a;

        d(f r1) {
            this.f39897a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ List<? extends X509Certificate> invoke() {
            return a();
        }

        public final List<X509Certificate> a() {
            t r4 = f.a(this.f39897a);
            o.a(r4);
            Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r4.d(), Iterable.class, "com.obric.aiagent.plugin");
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r5, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r6 = r5.iterator();
        L4:
            if (r6.hasNext() == false) goto L7;
            Certificate r2 = (Certificate) ZeusTransformUtils.preCheckCast(r6.next(), Certificate.class, "com.obric.aiagent.plugin");
            o.a(r2, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            r0.add((X509Certificate) ZeusTransformUtils.preCheckCast(r2, X509Certificate.class, "com.obric.aiagent.plugin"));
            goto L4
        L7:
            return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        }
    }

    static {
        f39890a = new a(null);
    }

    public static final /* synthetic */ t a(f r0) {
        return r0.h;
    }

    public f(g r2, af r3) {
        o.e(r2, "connectionPool");
        o.e(r3, "route");
        this.f39891d = r2;
        this.f39892e = r3;
        this.r = 1;
        this.s = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.t = Long.MAX_VALUE;
    }

    public final void a(boolean r1) {
        this.m = r1;
    }

    public final boolean c() {
        return this.m;
    }

    public final int d() {
        return this.o;
    }

    public final List<Reference<e>> e() {
        return this.s;
    }

    public final void a(long r1) {
        this.t = r1;
    }

    public final long f() {
        return this.t;
    }

    public final boolean g() {
        if (this.j == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final synchronized void h() {
        monitor-enter(this);
        this.m = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void i() {
        monitor-enter(this);
        this.n = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void j() {
        monitor-enter(this);
        this.p++;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void a(int r18, int r19, int r20, int r21, boolean r22, okhttp3.e r23, r r24) {
        okhttp3.e r10 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r23, okhttp3.e.class, "com.obric.aiagent.plugin");
        o.e(r10, "call");
        o.e(r24, "eventListener");
        if (this.i != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L65;
        List<l> r1 = this.f39892e.a().k();
        okhttp3.internal.d.b r12 = new okhttp3.internal.d.b(r1);
        if (this.f39892e.a().c() != null) goto L19;
        if (r1.contains(l.f40168e) == false) goto L17;
        String r2 = this.f39892e.a().i().b();
        if (okhttp3.internal.i.h.f40147b.a().a(r2) == false) goto L15;
    L20:
        i r14 = null;
    L66:
    L44:
        e = e;
    L47:
        Socket r3 = this.g;
        if (r3 == null) goto L50;
        okhttp3.internal.c.a(r3);
    L50:
        Socket r4 = this.f;
        if (r4 == null) goto L53;
        okhttp3.internal.c.a(r4);
    L53:
        this.g = null;
        this.f = null;
        this.k = null;
        this.l = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.r = 1;
        r24.connectFailed(r10, this.f39892e.c(), this.f39892e.b(), null, e);
        if (r14 != null) goto L56;
        r14 = new i(e);
    L57:
        if (r22 == false) goto L61;
        if (r12.a(e) == true) goto L66;
        throw r14;
    L61:
        throw r14;
    L56:
        r14.a(e);
        goto L57
    L22:
        if (this.f39892e.d() == false) goto L68;
        a(r18, r19, r20, r10, r24);     // Catch: IOException -> L44
        if (this.f == null) goto L32;
    L70:
        a(r12, r21, r10, r24);     // Catch: IOException -> L40
        r24.connectEnd(r10, this.f39892e.c(), this.f39892e.b(), this.i);     // Catch: IOException -> L40
    L40:
        e = e;
    L32:
        if (this.f39892e.d() == true) goto L34;
    L38:
        this.t = System.nanoTime();
        return;
    L34:
        if (this.f != null) goto L38;
        throw new i((IOException) ZeusTransformUtils.preCheckCast(new ProtocolException("Too many tunnel connections attempted: 21"), IOException.class, "com.obric.aiagent.plugin"));
    L68:
        a(r18, r19, r10, r24);     // Catch: IOException -> L42
    L42:
        e = e;
        goto L47
    L15:
        throw new i((IOException) ZeusTransformUtils.preCheckCast(new UnknownServiceException("CLEARTEXT communication to " + r2 + " not permitted by network security policy"), IOException.class, "com.obric.aiagent.plugin"));
    L17:
        throw new i((IOException) ZeusTransformUtils.preCheckCast(new UnknownServiceException("CLEARTEXT communication not enabled for client"), IOException.class, "com.obric.aiagent.plugin"));
    L19:
        if (this.f39892e.a().j().contains(aa.f) == false) goto L20;
        throw new i((IOException) ZeusTransformUtils.preCheckCast(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"), IOException.class, "com.obric.aiagent.plugin"));
    L65:
        throw new IllegalStateException("already connected".toString());
    L5:
        r0 = false;
        goto L6
    }

    private final void a(int r7, int r8, int r9, okhttp3.e r10, r r11) {
        okhttp3.e r12 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r10, okhttp3.e.class, "com.obric.aiagent.plugin");
        ab r0 = m();
        v r1 = r0.a();
        int r2 = 0;
    L4:
        if (r2 >= 21) goto L12;
        a(r7, r8, r12, r11);
        r0 = a(r8, r9, r0, r1);
        if (r0 == null) goto L17;
        Socket r3 = this.f;
        if (r3 == null) goto L11;
        okhttp3.internal.c.a(r3);
    L11:
        this.f = null;
        this.l = null;
        this.k = null;
        r11.connectEnd(r12, this.f39892e.c(), this.f39892e.b(), null);
        r2 = r2 + 1;
        goto L4
    L17:
        return;
    }

    private final void a(int r6, int r7, okhttp3.e r8, r r9) {
        okhttp3.e r10 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r8, okhttp3.e.class, "com.obric.aiagent.plugin");
        Proxy r0 = this.f39892e.b();
        okhttp3.a r2 = this.f39892e.a();
        Proxy.Type r3 = r0.type();
        if (r3 != null) goto L5;
        int r4 = -1;
    L7:
        if (r4 != 1) goto L9;
    L11:
        Socket r5 = r2.b().createSocket();
        o.a(r5);
    L12:
        this.f = r5;
        r9.connectStart(r10, this.f39892e.c(), r0);
        r5.setSoTimeout(r7);
        okhttp3.internal.i.h.f40147b.a().a(r5, this.f39892e.c(), r6);     // Catch: ConnectException -> L22
        this.k = e.o.a(e.o.b(r5));     // Catch: NullPointerException -> L16
        this.l = e.o.a(e.o.a(r5));     // Catch: NullPointerException -> L16
        return;
    L16:
        e = move-exception;
        if (o.a(e.getMessage(), "throw with null exception") == true) goto L21;
        return;
    L21:
        throw new IOException((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L22:
        e = move-exception;
        ConnectException r11 = new ConnectException("Failed to connect to " + this.f39892e.c());
        r11.initCause((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        throw ((Throwable) ZeusTransformUtils.preCheckCast(r11, Throwable.class, "com.obric.aiagent.plugin"));
    L9:
        if (r4 == 2) goto L11;
        r5 = new Socket(r0);
        goto L12
    L5:
        r4 = b.f39893a[r3.ordinal()];
        goto L7
    }

    private final void a(okhttp3.internal.d.b r3, int r4, okhttp3.e r5, r r6) {
        okhttp3.e r7 = (okhttp3.e) ZeusTransformUtils.wrapperContextForParams(r5, okhttp3.e.class, "com.obric.aiagent.plugin");
        if (this.f39892e.a().c() == null) goto L5;
        r6.secureConnectStart(r7);
        a(r3);
        r6.secureConnectEnd(r7, this.h);
        if (this.i != aa.f39697e) goto L14;
        a(r4);
        return;
    L14:
        return;
    L5:
        if (this.f39892e.a().j().contains(aa.f) == false) goto L8;
        this.g = this.f;
        this.i = aa.f;
        a(r4);
        return;
    L8:
        this.g = this.f;
        this.i = aa.f39695c;
    }

    private final void a(int r8) {
        Socket r0 = this.g;
        o.a(r0);
        e.g r1 = this.k;
        o.a(r1);
        e.f r2 = this.l;
        o.a(r2);
        r0.setSoTimeout(0);
        okhttp3.internal.g.f r9 = new okhttp3.internal.g.f.a(true, okhttp3.internal.c.d.f39849b).a(r0, this.f39892e.a().i().b(), r1, r2).a((okhttp3.internal.g.f.c) ZeusTransformUtils.preCheckCast(this, okhttp3.internal.g.f.c.class, "com.obric.aiagent.plugin")).a(r8).j();
        this.j = r9;
        this.r = okhttp3.internal.g.f.f39991a.a().d();
        okhttp3.internal.g.f.a(r9, false, null, 3, null);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void a(okhttp3.internal.d.b r12) {
        okhttp3.a r1 = this.f39892e.a();
        SSLSocketFactory r2 = r1.c();
        SSLSocket r3 = null;
        String r4 = null;
        o.a(r2);     // Catch: Throwable -> L27
        Socket r5 = r2.createSocket(this.f, r1.i().b(), r1.i().c(), true);     // Catch: Throwable -> L27
        o.a(r5, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");     // Catch: Throwable -> L27
        SSLSocket r6 = (SSLSocket) ZeusTransformUtils.preCheckCast(r5, SSLSocket.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        l r13 = r12.a(r6);     // Catch: Throwable -> L25
        if (r13.b() == false) goto L7;
        okhttp3.internal.i.h.f40147b.a().a(r6, r1.i().b(), r1.j());     // Catch: Throwable -> L25
    L7:
        r6.startHandshake();     // Catch: Throwable -> L25
        SSLSession r7 = r6.getSession();     // Catch: Throwable -> L25
        t.a r8 = t.f40197a;     // Catch: Throwable -> L25
        o.c(r7, "sslSocketSession");     // Catch: Throwable -> L25
        t r9 = r8.a(r7);     // Catch: Throwable -> L25
        HostnameVerifier r10 = r1.d();     // Catch: Throwable -> L25
        o.a(r10);     // Catch: Throwable -> L25
        if (r10.verify(r1.i().b(), r7) == true) goto L15;
        List<Certificate> r11 = r9.d();     // Catch: Throwable -> L25
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L14;
        Certificate r14 = r11.get(0);     // Catch: Throwable -> L25
        o.a(r14, "null cannot be cast to non-null type java.security.cert.X509Certificate");     // Catch: Throwable -> L25
        X509Certificate r15 = (X509Certificate) ZeusTransformUtils.preCheckCast(r14, X509Certificate.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        throw new SSLPeerUnverifiedException(d.o.o.a("\n              |Hostname " + r1.i().b() + " not verified:\n              |    certificate: " + okhttp3.g.f39770a.a((Certificate) ZeusTransformUtils.preCheckCast(r15, Certificate.class, "com.obric.aiagent.plugin")) + "\n              |    DN: " + r15.getSubjectDN().getName() + "\n              |    subjectAltNames: " + okhttp3.internal.k.d.f40154a.a(r15) + "\n              ", null, 1, null));     // Catch: Throwable -> L25
    L14:
        throw new SSLPeerUnverifiedException("Hostname " + r1.i().b() + " not verified (no certificates)");     // Catch: Throwable -> L25
    L15:
        okhttp3.g r16 = r1.e();     // Catch: Throwable -> L25
        o.a(r16);     // Catch: Throwable -> L25
        this.h = new t(r9.a(), r9.b(), r9.c(), (d.h.a.a) ZeusTransformUtils.preCheckCast(new c(r16, r9, r1), d.h.a.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L25
        r16.a(r1.i().b(), (d.h.a.a) ZeusTransformUtils.preCheckCast(new d(this), d.h.a.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L25
        if (r13.b() == false) goto L18;
        r4 = okhttp3.internal.i.h.f40147b.a().a(r6);     // Catch: Throwable -> L25
    L18:
        this.g = (Socket) ZeusTransformUtils.preCheckCast(r6, Socket.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        this.k = e.o.a(e.o.b((Socket) ZeusTransformUtils.preCheckCast(r6, Socket.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L25
        this.l = e.o.a(e.o.a((Socket) ZeusTransformUtils.preCheckCast(r6, Socket.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L25
        if (r4 == null) goto L21;
        aa r17 = aa.f39693a.a(r4);     // Catch: Throwable -> L25
    L22:
        this.i = r17;     // Catch: Throwable -> L25
        okhttp3.internal.i.h.f40147b.a().b(r6);
        return;
    L21:
        r17 = aa.f39695c;     // Catch: Throwable -> L25
    L25:
        th = th;
        r3 = r6;
    L28:
        if (r3 == null) goto L30;
        okhttp3.internal.i.h.f40147b.a().b(r3);
    L30:
        if (r3 == null) goto L32;
        okhttp3.internal.c.a((Socket) ZeusTransformUtils.preCheckCast(r3, Socket.class, "com.obric.aiagent.plugin"));
    L32:
        throw th;
    L27:
        th = th;
        goto L28
    }

    private final ab a(int r10, int r11, ab r12, v r13) {
        String r14 = "CONNECT " + okhttp3.internal.c.a(r13, true) + " HTTP/1.1";
    L3:
        e.g r0 = this.k;
        o.a(r0);
        e.f r2 = this.l;
        o.a(r2);
        okhttp3.internal.f.b r3 = new okhttp3.internal.f.b(null, this, r0, r2);
        r0.a().a(r10, TimeUnit.MILLISECONDS);
        r2.a().a(r11, TimeUnit.MILLISECONDS);
        r3.a(r12.c(), r14);
        r3.c();
        ad.a r5 = r3.a(false);
        o.a(r5);
        ad r15 = r5.a(r12).b();
        r3.c(r15);
        int r4 = r15.d();
        if (r4 == 200) goto L18;
        if (r4 != 407) goto L16;
        ab r1 = this.f39892e.a().f().authenticate(this.f39892e, r15);
        if (r1 == null) goto L14;
        if (d.o.o.a("close", ad.a(r15, "Connection", null, 2, null), true) == true) goto L11;
        r12 = r1;
        goto L3
    L11:
        return r1;
    L14:
        throw new IOException("Failed to authenticate with proxy");
    L16:
        throw new IOException("Unexpected response code for CONNECT: " + r15.d());
    L18:
        if (r0.d().h() == false) goto L23;
        if (r2.d().h() == false) goto L23;
        return null;
    L23:
        throw new IOException("TLS tunnel buffered too many bytes!");
    }

    private final ab m() {
        ab r0 = new ab.a().a(this.f39892e.a().i()).a("CONNECT", null).a(DownloadConstants.HOST, okhttp3.internal.c.a(this.f39892e.a().i(), true)).a("Proxy-Connection", "Keep-Alive").a(DownloadConstants.USER_AGENT, "okhttp/4.12.0").b();
        ad r1 = new ad.a().a(r0).a(aa.f39695c).a(407).a("Preemptive Authenticate").a(okhttp3.internal.c.f39835c).a(-1).b(-1).a("Proxy-Authenticate", "OkHttp-Preemptive").b();
        ab r4 = this.f39892e.a().f().authenticate(this.f39892e, r1);
        if (r4 != null) goto L6;
        return r0;
    L6:
        return r4;
    }

    private final boolean a(List<af> r7) {
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L5;
    L7:
        Iterator r9 = r8.iterator();
    L9:
        if (r9.hasNext() == false) goto L19;
        af r0 = (af) ZeusTransformUtils.preCheckCast(r9.next(), af.class, "com.obric.aiagent.plugin");
        if (r0.b().type() == Proxy.Type.DIRECT) goto L13;
    L17:
        boolean r1 = false;
    L18:
        if (r1 == false) goto L9;
        return true;
    L13:
        if (this.f39892e.b().type() != Proxy.Type.DIRECT) goto L17;
        if (o.a(this.f39892e.c(), r0.c()) == false) goto L17;
        r1 = true;
    L19:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    private final boolean a(v r5, t r6) {
        List<Certificate> r4 = r6.d();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L8;
        okhttp3.internal.k.d r7 = okhttp3.internal.k.d.f40154a;
        String r8 = r5.b();
        Certificate r9 = r4.get(0);
        o.a(r9, "null cannot be cast to non-null type java.security.cert.X509Certificate");
        if (r7.a(r8, (X509Certificate) ZeusTransformUtils.preCheckCast(r9, X509Certificate.class, "com.obric.aiagent.plugin")) == false) goto L8;
        return true;
    L8:
        return false;
    }

    public final okhttp3.internal.e.d a(z r8, okhttp3.internal.e.g r9) {
        o.e(r8, "client");
        o.e(r9, "chain");
        Socket r0 = this.g;
        o.a(r0);
        e.g r1 = this.k;
        o.a(r1);
        e.f r2 = this.l;
        o.a(r2);
        okhttp3.internal.g.f r3 = this.j;
        if (r3 != null) goto L7;
        r0.setSoTimeout(r9.i());
        r1.a().a(r9.g(), TimeUnit.MILLISECONDS);
        r2.a().a(r9.h(), TimeUnit.MILLISECONDS);
        return (okhttp3.internal.e.d) ZeusTransformUtils.preCheckCast(new okhttp3.internal.f.b(r8, this, r1, r2), okhttp3.internal.e.d.class, "com.obric.aiagent.plugin");
    L7:
        return (okhttp3.internal.e.d) ZeusTransformUtils.preCheckCast(new okhttp3.internal.g.g(r8, this, r9, r3), okhttp3.internal.e.d.class, "com.obric.aiagent.plugin");
    }

    @Override // okhttp3.j
    public af a() {
        return this.f39892e;
    }

    public final void k() {
        Socket r0 = this.f;
        if (r0 == null) goto L6;
        okhttp3.internal.c.a(r0);
        return;
    }

    @Override // okhttp3.j
    public Socket b() {
        Socket r0 = this.g;
        o.a(r0);
        return r0;
    }

    @Override // okhttp3.internal.g.f.c
    public void a(okhttp3.internal.g.i r2) {
        o.e(r2, CozeCloudExt.API_KEY_HTTP_STREAM_METHOD);
        r2.a(okhttp3.internal.g.b.i, null);
    }

    @Override // okhttp3.internal.g.f.c
    public synchronized void a(okhttp3.internal.g.f r2, m r3) {
        monitor-enter(this);
        o.e(r2, WsConstants.KEY_CONNECTION);     // Catch: Throwable -> L6
        o.e(r3, "settings");     // Catch: Throwable -> L6
        this.r = r3.d();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public t l() {
        return this.h;
    }

    public final void a(z r3, af r4, IOException r5) {
        o.e(r3, "client");
        o.e(r4, "failedRoute");
        o.e(r5, "failure");
        if (r4.b().type() == Proxy.Type.DIRECT) goto L5;
        okhttp3.a r2 = r4.a();
        r2.h().connectFailed(r2.i().f(), r4.b().address(), r5);
    L5:
        r3.D().a(r4);
    }

    public final synchronized void a(e r4, IOException r5) {
        monitor-enter(this);
        o.e(r4, "call");     // Catch: Throwable -> L26
        if (ZeusTransformUtils.instanceOf(r5, n.class) == false) goto L16;
        if (((n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin")).f40087a != okhttp3.internal.g.b.i) goto L11;
        int r6 = this.q + 1;     // Catch: Throwable -> L26
        this.q = r6;     // Catch: Throwable -> L26
        if (r6 <= 1) goto L24;
        this.m = true;     // Catch: Throwable -> L26
        this.o++;     // Catch: Throwable -> L26
    L24:
        monitor-exit(this);
        return;
    L11:
        if (((n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin")).f40087a == okhttp3.internal.g.b.j) goto L13;
    L14:
        this.m = true;     // Catch: Throwable -> L26
        this.o++;     // Catch: Throwable -> L26
        goto L24
    L13:
        if (r4.d() == true) goto L24;
    L16:
        if (g() == true) goto L18;
    L19:
        this.m = true;     // Catch: Throwable -> L26
        if (this.p != 0) goto L24;
        if (r5 == null) goto L23;
        a(r4.e(), this.f39892e, r5);     // Catch: Throwable -> L26
    L23:
        this.o++;     // Catch: Throwable -> L26
        goto L24
    L18:
        if (ZeusTransformUtils.instanceOf(r5, okhttp3.internal.g.a.class) == false) goto L24;
    L26:
        th = move-exception;
        throw th;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("Connection{").append(this.f39892e.a().i().b()).append(':').append(this.f39892e.a().i().c()).append(", proxy=").append(this.f39892e.b()).append(" hostAddress=").append(this.f39892e.c()).append(" cipherSuite=");
        t r1 = this.h;
        if (r1 == null) goto L6;
        Object r2 = r1.b();
        if (r2 == null) goto L6;
    L8:
        return r0.append(r2).append(" protocol=").append(this.i).append('}').toString();
    L6:
        r2 = OProtocolTextEffectTextView.EffectNameNone;
        goto L8
    }

    public final boolean a(okhttp3.a r4, List<af> r5) {
        List<af> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r4, SensitiveType.ADDRESS);
        if (okhttp3.internal.c.f == false) goto L10;
        if (Thread.holdsLock(this) == true) goto L10;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    L10:
        if (this.s.size() < this.r) goto L12;
    L35:
        return false;
    L12:
        if (this.m == true) goto L35;
        if (this.f39892e.a().a(r4) == true) goto L18;
        return false;
    L18:
        if (o.a(r4.i().b(), a().a().i().b()) == false) goto L21;
        return true;
    L21:
        if (this.j != null) goto L23;
        return false;
    L23:
        if (r6 == null) goto L35;
        if (a(r6) == false) goto L35;
        if (r4.d() == okhttp3.internal.k.d.f40154a) goto L31;
        return false;
    L31:
        if (a(r4.i()) == true) goto L37;
        return false;
    L37:
        okhttp3.g r7 = r4.e();     // Catch: SSLPeerUnverifiedException -> L36
        o.a(r7);     // Catch: SSLPeerUnverifiedException -> L36
        String r8 = r4.i().b();     // Catch: SSLPeerUnverifiedException -> L36
        t r3 = l();     // Catch: SSLPeerUnverifiedException -> L36
        o.a(r3);     // Catch: SSLPeerUnverifiedException -> L36
        r7.a(r8, r3.d());     // Catch: SSLPeerUnverifiedException -> L36
        return true;
    }

    private final boolean a(v r5) {
        if (okhttp3.internal.c.f == true) goto L5;
    L9:
        v r0 = this.f39892e.a().i();
        if (r5.c() == r0.c()) goto L13;
        return false;
    L13:
        if (o.a(r5.b(), r0.b()) == false) goto L16;
        return true;
    L16:
        if (this.n == true) goto L23;
        t r1 = this.h;
        if (r1 == null) goto L24;
        o.a(r1);
        if (a(r5, r1) == true) goto L22;
        return false;
    L22:
        return true;
    L24:
        return false;
    L23:
        return false;
    L5:
        if (Thread.holdsLock(this) == true) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    public final boolean b(boolean r8) {
        if (okhttp3.internal.c.f == true) goto L5;
    L9:
        long r0 = System.nanoTime();
        Socket r2 = this.f;
        o.a(r2);
        Socket r3 = this.g;
        o.a(r3);
        e.g r4 = this.k;
        o.a(r4);
        if (r2.isClosed() == false) goto L12;
        return false;
    L12:
        if (r3.isClosed() == false) goto L14;
        return false;
    L14:
        if (r3.isInputShutdown() == false) goto L16;
        return false;
    L16:
        if (r3.isOutputShutdown() == true) goto L43;
        okhttp3.internal.g.f r5 = this.j;
        if (r5 != null) goto L21;
        monitor-enter(this);
        long r1 = r0 - this.t;
        monitor-exit(this);
        if (r1 < 10000000000L) goto L31;
        if (r8 == true) goto L30;
        return true;
    L30:
        return okhttp3.internal.c.a(r3, r4);
    L31:
        return true;
    L33:
        th = move-exception;
        throw th;
    L21:
        return r5.b(r0);
    L43:
        return false;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }
}
