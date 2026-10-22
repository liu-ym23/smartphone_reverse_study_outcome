package okhttp3.internal.d;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import me.ele.lancet.base.annotations.Skip;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.p;
import okhttp3.r;
import okhttp3.v;
import okhttp3.z;

/* JADX INFO: compiled from: RealCall.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e implements okhttp3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z f39880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ab f39881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f39882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g f39883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final r f39884e;
    private final c f;
    private final AtomicBoolean g;
    private Object h;
    private d i;
    private f j;
    private boolean k;
    private okhttp3.internal.d.c l;
    private boolean m;
    private boolean n;
    private boolean o;
    private volatile boolean p;
    private volatile okhttp3.internal.d.c q;
    private volatile f r;

    /* JADX INFO: compiled from: RealCall.kt */
    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f39885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final okhttp3.f f39886b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile AtomicInteger f39887c;

        public a(e r3, okhttp3.f r4) {
            okhttp3.f r5 = (okhttp3.f) ZeusTransformUtils.wrapperContextForParams(r4, okhttp3.f.class, "com.obric.aiagent.plugin");
            o.e(r5, "responseCallback");
            this.f39885a = r3;
            this.f39886b = r5;
            this.f39887c = new AtomicInteger(0);
        }

        public final AtomicInteger a() {
            return this.f39887c;
        }

        public final void a(a r2) {
            o.e(r2, "other");
            this.f39887c = r2.f39887c;
        }

        public final String b() {
            return this.f39885a.f().a().b();
        }

        public final e c() {
            return this.f39885a;
        }

        public final void a(ExecutorService r5) {
            ExecutorService r6 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r5, ExecutorService.class, "com.obric.aiagent.plugin");
            o.e(r6, "executorService");
            p r0 = this.f39885a.e().a();
            if (okhttp3.internal.c.f == true) goto L5;
        L19:
            r6.execute((Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11 RejectedExecutionException -> L13
        L22:
            return;
        L13:
            e = move-exception;
            InterruptedIOException r1 = new InterruptedIOException("executor rejected");     // Catch: Throwable -> L11
            r1.initCause((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11
            this.f39885a.a((IOException) ZeusTransformUtils.preCheckCast(r1, IOException.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11
            this.f39886b.a((okhttp3.e) ZeusTransformUtils.preCheckCast(this.f39885a, okhttp3.e.class, "com.obric.aiagent.plugin"), (IOException) ZeusTransformUtils.preCheckCast(r1, IOException.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11
            this.f39885a.e().a().b(this);
            return;
        L11:
            th = move-exception;
            this.f39885a.e().a().b(this);
            throw th;
        L5:
            if (Thread.holdsLock(r0) == false) goto L19;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r0);
        }

        @Override // java.lang.Runnable
        public void run() {
            String r1 = "OkHttp " + this.f39885a.q();
            e r2 = this.f39885a;
            Thread r3 = Thread.currentThread();
            String r4 = r3.getName();
            r3.setName(r1);
            e.b(r2).c();     // Catch: Throwable -> L33
            boolean r5 = true;
            this.f39886b.a((okhttp3.e) ZeusTransformUtils.preCheckCast(r2, okhttp3.e.class, "com.obric.aiagent.plugin"), r2.m());     // Catch: Throwable -> L10 IOException -> L12
            p r0 = r2.e().a();     // Catch: Throwable -> L33
        L8:
            r0.b(this);     // Catch: Throwable -> L33
            r3.setName(r4);
            return;
        L12:
            IOException e2 = e;
        L24:
            if (r5 == false) goto L26;
            okhttp3.internal.i.h.f40147b.a().a("Callback failure for " + e.c(r2), 4, (Throwable) ZeusTransformUtils.preCheckCast(e2, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L20
        L27:
            r0 = r2.e().a();     // Catch: Throwable -> L33
            goto L8
        L26:
            this.f39886b.a((okhttp3.e) ZeusTransformUtils.preCheckCast(r2, okhttp3.e.class, "com.obric.aiagent.plugin"), e2);     // Catch: Throwable -> L20
        L10:
            Throwable th = th;
        L16:
            r2.c();     // Catch: Throwable -> L20
            if (r5 == true) goto L19;
            IOException r6 = new IOException("canceled due to " + th);     // Catch: Throwable -> L20
            d.a.a((Throwable) ZeusTransformUtils.preCheckCast(r6, Throwable.class, "com.obric.aiagent.plugin"), th);     // Catch: Throwable -> L20
            this.f39886b.a((okhttp3.e) ZeusTransformUtils.preCheckCast(r2, okhttp3.e.class, "com.obric.aiagent.plugin"), r6);     // Catch: Throwable -> L20
        L19:
            throw th;     // Catch: Throwable -> L20
        L22:
            e = move-exception;
            r5 = false;
            e2 = e;
        L14:
            th = move-exception;
            r5 = false;
            th = th;
        L33:
            th = move-exception;
            r3.setName(r4);
            throw th;
        L20:
            th = move-exception;
            r2.e().a().b(this);     // Catch: Throwable -> L33
            throw th;     // Catch: Throwable -> L33
        }
    }

    /* JADX INFO: compiled from: RealCall.kt */
    public static final class b extends WeakReference<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f39888a;

        public final Object a() {
            return this.f39888a;
        }

        public b(e r2, Object r3) {
            o.e(r2, "referent");
            super(r2);
            this.f39888a = r3;
        }
    }

    /* JADX INFO: compiled from: RealCall.kt */
    public static final class c extends e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f39889a;

        c(e r1) {
            this.f39889a = r1;
        }

        @Override // e.c
        public void a() {
            this.f39889a.c();
        }
    }

    @Override // okhttp3.e
    public void a(okhttp3.f r3) {
        a(this, (okhttp3.f) ZeusTransformUtils.wrapperContextForParams(r3, okhttp3.f.class, "com.obric.aiagent.plugin"));
    }

    @Override // okhttp3.e
    public ad b() {
        return a(this);
    }

    public e(z r3, ab r4, boolean r5) {
        o.e(r3, "client");
        o.e(r4, "originalRequest");
        this.f39880a = r3;
        this.f39881b = r4;
        this.f39882c = r5;
        this.f39883d = r3.b().a();
        this.f39884e = r3.e().create((okhttp3.e) ZeusTransformUtils.preCheckCast(this, okhttp3.e.class, "com.obric.aiagent.plugin"));
        c r6 = new c(this);
        r6.a(r3.x(), TimeUnit.MILLISECONDS);
        this.f = r6;
        this.g = new AtomicBoolean();
        this.o = true;
    }

    public static final /* synthetic */ c b(e r0) {
        return r0.f;
    }

    public static final /* synthetic */ String c(e r0) {
        return r0.s();
    }

    public /* synthetic */ Object clone() {
        return k();
    }

    public final z e() {
        return this.f39880a;
    }

    public final ab f() {
        return this.f39881b;
    }

    public final boolean g() {
        return this.f39882c;
    }

    public final r h() {
        return this.f39884e;
    }

    public final f i() {
        return this.j;
    }

    public final okhttp3.internal.d.c j() {
        return this.l;
    }

    public final void a(f r1) {
        this.r = r1;
    }

    public e k() {
        return new e(this.f39880a, this.f39881b, this.f39882c);
    }

    @Override // okhttp3.e
    public ab a() {
        return this.f39881b;
    }

    @Override // okhttp3.e
    public void c() {
        if (this.p == false) goto L5;
        return;
    L5:
        this.p = true;
        okhttp3.internal.d.c r0 = this.q;
        if (r0 == null) goto L8;
        r0.l();
    L8:
        f r1 = this.r;
        if (r1 == null) goto L11;
        r1.k();
    L11:
        this.f39884e.canceled((okhttp3.e) ZeusTransformUtils.preCheckCast(this, okhttp3.e.class, "com.obric.aiagent.plugin"));
    }

    @Override // okhttp3.e
    public boolean d() {
        return this.p;
    }

    public ad l() {
        if (this.g.compareAndSet(false, true) == false) goto L12;
        this.f.c();
        r();
        this.f39880a.a().a(this);     // Catch: Throwable -> L8
        ad r0 = m();     // Catch: Throwable -> L8
        this.f39880a.a().b(this);
        return r0;
    L8:
        th = move-exception;
        this.f39880a.a().b(this);
        throw th;
    L12:
        throw new IllegalStateException("Already Executed".toString());
    }

    public void b(okhttp3.f r4) {
        okhttp3.f r5 = (okhttp3.f) ZeusTransformUtils.wrapperContextForParams(r4, okhttp3.f.class, "com.obric.aiagent.plugin");
        o.e(r5, "responseCallback");
        if (this.g.compareAndSet(false, true) == false) goto L7;
        r();
        this.f39880a.a().a(new a(this, r5));
        return;
    L7:
        throw new IllegalStateException("Already Executed".toString());
    }

    private final void r() {
        this.h = okhttp3.internal.i.h.f40147b.a().b("response.body().close()");
        this.f39884e.callStart((okhttp3.e) ZeusTransformUtils.preCheckCast(this, okhttp3.e.class, "com.obric.aiagent.plugin"));
    }

    public final ad m() {
        List r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        d.a.p.a((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(this.f39880a.c(), Iterable.class, "com.obric.aiagent.plugin"));
        ((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).add(new okhttp3.internal.e.j(this.f39880a));
        ((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).add(new okhttp3.internal.e.a(this.f39880a.j()));
        ((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).add(new okhttp3.internal.b.a(this.f39880a.k()));
        ((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).add(okhttp3.internal.d.a.f39855a);
        if (this.f39882c == true) goto L5;
        d.a.p.a((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(this.f39880a.d(), Iterable.class, "com.obric.aiagent.plugin"));
    L5:
        ((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).add(new okhttp3.internal.e.b(this.f39882c));
        okhttp3.internal.e.g r0 = new okhttp3.internal.e.g(this, r5, 0, null, this.f39881b, this.f39880a.y(), this.f39880a.z(), this.f39880a.A());
        boolean r1 = false;
        ad r2 = r0.a(this.f39881b);     // Catch: Throwable -> L12 IOException -> L14
        if (d() == true) goto L10;
        a(null);
        return r2;
    L10:
        okhttp3.internal.c.a((Closeable) ZeusTransformUtils.preCheckCast(r2, Closeable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L12 IOException -> L14
        throw new IOException("Canceled");     // Catch: Throwable -> L12 IOException -> L14
    L14:
        e = move-exception;
        r1 = true;
        IOException r3 = a(e);     // Catch: Throwable -> L12
        o.a(r3, "null cannot be cast to non-null type kotlin.Throwable");     // Catch: Throwable -> L12
        throw ((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (r1 == true) goto L20;
        a(null);
    L20:
        throw th;
    }

    public final void a(ab r3, boolean r4) {
        o.e(r3, Ext.KEY_REQUEST);
        if (this.l != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L25;
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L9:
        if ((!this.n) == false) goto L20;
        if ((!this.m) == false) goto L18;
        x r1 = x.f38692a;     // Catch: Throwable -> L21
        monitor-exit(this);
        if (r4 == false) goto L27;
        this.i = new d(this.f39883d, a(r3.a()), this, this.f39884e);
        return;
    L27:
        return;
    L18:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L21
    L20:
        throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());     // Catch: Throwable -> L21
    L25:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r0 = false;
        goto L6
    }

    public final okhttp3.internal.d.c a(okhttp3.internal.e.g r5) {
        o.e(r5, "chain");
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (this.o == false) goto L29;
        if ((!this.n) == false) goto L27;
        if ((!this.m) == false) goto L25;
        x r0 = x.f38692a;     // Catch: Throwable -> L30
        monitor-exit(this);
        d r1 = this.i;
        o.a(r1);
        okhttp3.internal.d.c r2 = new okhttp3.internal.d.c(this, this.f39884e, r1, r1.a(this.f39880a, r5));
        this.l = r2;
        this.q = r2;
        monitor-enter(this);
        this.m = true;     // Catch: Throwable -> L21
        this.n = true;     // Catch: Throwable -> L21
        x r6 = x.f38692a;     // Catch: Throwable -> L21
        monitor-exit(this);
        if (this.p == true) goto L20;
        return r2;
    L20:
        throw new IOException("Canceled");
    L21:
        th = move-exception;
        throw th;
    L25:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L30
    L27:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L30
    L29:
        throw new IllegalStateException("released".toString());     // Catch: Throwable -> L30
    }

    public final <E extends IOException> E a(okhttp3.internal.d.c r2, boolean r3, boolean r4, E r5) {
        o.e(r2, "exchange");
        if (o.a(r2, this.q) == true) goto L5;
        return r5;
    L5:
        monitor-enter(this);
        boolean r6 = false;
        if (r3 == true) goto L46;
    L13:
        if (r4 == true) goto L15;
    L33:
        boolean r7 = false;
    L34:
        x r8 = x.f38692a;     // Catch: Throwable -> L11
        monitor-exit(this);
        if (r6 == false) goto L40;
        this.q = null;
        f r9 = this.j;
        if (r9 == null) goto L40;
        r9.j();
    L40:
        if (r7 == true) goto L42;
        return r5;
    L42:
        return (E) b(r5);
    L11:
        th = move-exception;
        throw th;
    L15:
        if (this.n == false) goto L33;
    L16:
        if (r3 == false) goto L18;
        this.m = false;     // Catch: Throwable -> L11
    L18:
        if (r4 == false) goto L20;
        this.n = false;     // Catch: Throwable -> L11
    L20:
        boolean r10 = this.m;     // Catch: Throwable -> L11
        if (r10 == false) goto L23;
    L25:
        boolean r0 = false;
    L26:
        if (r10 == false) goto L28;
    L32:
        r7 = r6;
        r6 = r0;
        goto L34
    L28:
        if (this.n == true) goto L32;
        if (this.o == true) goto L32;
        r6 = true;
        goto L32
    L23:
        if (this.n == true) goto L25;
        r0 = true;
        goto L26
    L46:
        if (this.m == true) goto L16;
        goto L16
    }

    public final IOException a(IOException r3) {
        monitor-enter(this);
        boolean r1 = false;
        if (this.o == false) goto L10;
        this.o = false;     // Catch: Throwable -> L16
        if (this.m == true) goto L10;
        if (this.n == true) goto L10;
        r1 = true;
    L10:
        x r0 = x.f38692a;     // Catch: Throwable -> L16
        monitor-exit(this);
        if (r1 == true) goto L14;
        return r3;
    L14:
        return b(r3);
    L16:
        th = move-exception;
        throw th;
    }

    public final Socket n() {
        f r0 = this.j;
        o.a(r0);
        if (okhttp3.internal.c.f == true) goto L5;
    L9:
        List<Reference<e>> r1 = r0.e();
        Iterator<Reference<e>> r2 = r1.iterator();
        boolean r3 = false;
        int r4 = 0;
    L11:
        if (r2.hasNext() == false) goto L16;
        if (o.a(((Reference) ZeusTransformUtils.preCheckCast(r2.next(), Reference.class, "com.obric.aiagent.plugin")).get(), this) == true) goto L17;
        r4 = r4 + 1;
    L17:
        if (r4 == (-1)) goto L19;
        r3 = true;
    L19:
        if (r3 == false) goto L28;
        r1.remove(r4);
        this.j = null;
        if (r1.isEmpty() == false) goto L26;
        r0.a(System.nanoTime());
        if (this.f39883d.b(r0) == false) goto L26;
        return r0.b();
    L26:
        return null;
    L28:
        throw new IllegalStateException("Check failed.".toString());
    L16:
        r4 = -1;
        goto L17
    L5:
        if (Thread.holdsLock(r0) == true) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r0);
    }

    private final <E extends IOException> E c(E r3) {
        if (this.k == false) goto L6;
        return r3;
    L6:
        if (this.f.t_() == true) goto L8;
        return r3;
    L8:
        InterruptedIOException r2 = new InterruptedIOException("timeout");
        if (r3 == null) goto L12;
        r2.initCause((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
    L12:
        return (E) ZeusTransformUtils.preCheckCast(r2, IOException.class, "com.obric.aiagent.plugin");
    }

    public final void o() {
        if ((!this.k) == false) goto L7;
        this.k = true;
        this.f.t_();
        return;
    L7:
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void a(boolean r2) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.o == false) goto L14;
        x r0 = x.f38692a;     // Catch: Throwable -> L15
        monitor-exit(this);
        if (r2 == false) goto L11;
        okhttp3.internal.d.c r3 = this.q;
        if (r3 == null) goto L11;
        r3.m();
    L11:
        this.l = null;
        return;
    L14:
        throw new IllegalStateException("released".toString());     // Catch: Throwable -> L15
    }

    private final okhttp3.a a(v r18) {
        if (r18.d() == false) goto L5;
        SSLSocketFactory r2 = this.f39880a.q();
        HostnameVerifier r10 = this.f39880a.u();
        SSLSocketFactory r9 = r2;
        okhttp3.g r11 = this.f39880a.v();
    L7:
        return new okhttp3.a(r18.b(), r18.c(), this.f39880a.l(), this.f39880a.p(), r9, r10, r11, this.f39880a.o(), this.f39880a.m(), this.f39880a.t(), this.f39880a.s(), this.f39880a.n());
    L5:
        r9 = null;
        r10 = null;
        r11 = null;
        goto L7
    }

    public final boolean p() {
        d r0 = this.i;
        o.a(r0);
        return r0.b();
    }

    private final String s() {
        StringBuilder r0 = new StringBuilder();
        if (d() == false) goto L5;
        String r1 = "canceled ";
    L6:
        StringBuilder r2 = r0.append(r1);
        if (this.f39882c == false) goto L9;
        String r3 = "web socket";
    L11:
        return r2.append(r3).append(" to ").append(q()).toString();
    L9:
        r3 = "call";
        goto L11
    L5:
        r1 = "";
        goto L6
    }

    public final String q() {
        return this.f39881b.a().m();
    }

    public final void b(f r3) {
        o.e(r3, WsConstants.KEY_CONNECTION);
        if (okhttp3.internal.c.f == false) goto L10;
        if (Thread.holdsLock(r3) == true) goto L10;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r3);
    L10:
        if (this.j != null) goto L12;
        boolean r0 = true;
    L13:
        if (r0 == false) goto L17;
        this.j = r3;
        r3.e().add(new b(this, this.h));
        return;
    L17:
        throw new IllegalStateException("Check failed.".toString());
    L12:
        r0 = false;
        goto L13
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
    private final <E extends IOException> E b(E r6) {
        if (okhttp3.internal.c.f == true) goto L5;
    L9:
        f r0 = this.j;
        if (r0 != null) goto L12;
    L36:
        E r1 = (E) c(r6);
        if (r6 == null) goto L39;
        r r7 = this.f39884e;
        okhttp3.e r5 = (okhttp3.e) ZeusTransformUtils.preCheckCast(this, okhttp3.e.class, "com.obric.aiagent.plugin");
        o.a(r1);
        r7.callFailed(r5, r1);
    L40:
        return r1;
    L39:
        this.f39884e.callEnd((okhttp3.e) ZeusTransformUtils.preCheckCast(this, okhttp3.e.class, "com.obric.aiagent.plugin"));
        goto L40
    L12:
        if (okhttp3.internal.c.f == true) goto L14;
    L18:
        monitor-enter(r0);
        Socket r2 = n();     // Catch: Throwable -> L33
        monitor-exit(r0);
        if (this.j != null) goto L26;
        if (r2 == null) goto L25;
        okhttp3.internal.c.a(r2);
    L25:
        this.f39884e.connectionReleased((okhttp3.e) ZeusTransformUtils.preCheckCast(this, okhttp3.e.class, "com.obric.aiagent.plugin"), (okhttp3.j) ZeusTransformUtils.preCheckCast(r0, okhttp3.j.class, "com.obric.aiagent.plugin"));
        goto L36
    L26:
        if (r2 != null) goto L28;
        boolean r3 = true;
    L29:
        if (r3 == true) goto L36;
        throw new IllegalStateException("Check failed.".toString());
    L28:
        r3 = false;
    L33:
        th = move-exception;
        throw th;
    L14:
        if (Thread.holdsLock(r0) == false) goto L18;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r0);
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    @Skip({"com.obric.aiagent.okhttp"})
    public static ad a(e r4) {
        ab r0 = ((okhttp3.e) ZeusTransformUtils.preCheckCast(r4, okhttp3.e.class, "com.obric.aiagent.plugin")).a();
        String r1 = r0.a().b();
        String r2 = r0.a().i();
        if (com.obric.aiagent.a.b.a(r1, r2) == false) goto L5;
        ILogDepend.Companion.i("AiAgentOkHttp3CallLancet", "execute drop " + r1 + r2);
        com.obric.aiagent.a.b.a(com.obric.aiagent.a.b.b(r1, r2), r1, r2);
        throw new IOException("[NetGuard] dropped ");
    L5:
        return r4.l();
    }

    @Skip({"com.obric.aiagent.okhttp"})
    public static void a(e r5, okhttp3.f r6) {
        okhttp3.f r7 = (okhttp3.f) ZeusTransformUtils.wrapperContextForParams(r6, okhttp3.f.class, "com.obric.aiagent.plugin");
        okhttp3.e r0 = (okhttp3.e) ZeusTransformUtils.preCheckCast(r5, okhttp3.e.class, "com.obric.aiagent.plugin");
        ab r1 = r0.a();
        String r2 = r1.a().b();
        String r3 = r1.a().i();
        if (com.obric.aiagent.a.b.a(r2, r3) == false) goto L7;
        ILogDepend.Companion.i("AiAgentOkHttp3CallLancet", "enqueue drop " + r2 + r3);
        com.obric.aiagent.a.b.a(com.obric.aiagent.a.b.b(r2, r3), r2, r3);
        if (r7 == null) goto L9;
        r7.a(r0, new IOException("[NetGuard] dropped "));
        return;
    L9:
        return;
    L7:
        r5.b(r7);
    }
}
