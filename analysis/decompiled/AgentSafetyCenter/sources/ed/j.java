package ed;

import ad.e0;
import ad.q;
import ad.w;
import ad.z;
import b8.d0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.invoke.VarHandle;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j implements Cloneable {

    /* renamed from: c, reason: collision with root package name */
    public final w f3801c;

    /* renamed from: f, reason: collision with root package name */
    public final z f3802f;

    /* renamed from: g, reason: collision with root package name */
    public final d0 f3803g;

    /* renamed from: h, reason: collision with root package name */
    public final i f3804h;
    public final AtomicBoolean i;

    /* renamed from: j, reason: collision with root package name */
    public Object f3805j;

    /* renamed from: k, reason: collision with root package name */
    public f f3806k;

    /* renamed from: l, reason: collision with root package name */
    public m f3807l;

    /* renamed from: m, reason: collision with root package name */
    public e f3808m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f3809n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f3810o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f3811p;

    /* renamed from: q, reason: collision with root package name */
    public volatile boolean f3812q;

    /* renamed from: r, reason: collision with root package name */
    public volatile e f3813r;

    /* renamed from: s, reason: collision with root package name */
    public volatile m f3814s;

    public j(w wVar, z zVar) {
        wVar.getClass();
        zVar.getClass();
        this.f3801c = wVar;
        this.f3802f = zVar;
        this.f3803g = (d0) wVar.f604f.f49f;
        wVar.i.getClass();
        i iVar = new i();
        iVar.f3800m = this;
        VarHandle.storeStoreFence();
        iVar.g(wVar.f623z);
        this.f3804h = iVar;
        this.i = new AtomicBoolean();
        this.f3811p = true;
    }

    public static final String a(j jVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(jVar.f3812q ? "canceled " : "");
        sb2.append("call");
        sb2.append(" to ");
        sb2.append(((q) jVar.f3802f.f637b).f());
        return sb2.toString();
    }

    public final void b(m mVar) {
        byte[] bArr = bd.b.f2074a;
        if (this.f3807l != null) {
            od.f.e("Check failed.");
            return;
        }
        this.f3807l = mVar;
        ArrayList arrayList = mVar.f3833o;
        Object obj = this.f3805j;
        h hVar = new h(this);
        hVar.f3799a = obj;
        VarHandle.storeStoreFence();
        arrayList.add(hVar);
    }

    public final IOException c(IOException iOException) throws IOException {
        IOException interruptedIOException;
        Socket socketL;
        byte[] bArr = bd.b.f2074a;
        m mVar = this.f3807l;
        if (mVar != null) {
            synchronized (mVar) {
                socketL = l();
            }
            if (this.f3807l == null) {
                if (socketL != null) {
                    bd.b.e(socketL);
                }
            } else if (socketL != null) {
                od.f.e("Check failed.");
                return null;
            }
        }
        if (this.f3804h.i()) {
            interruptedIOException = new InterruptedIOException("timeout");
            if (iOException != null) {
                interruptedIOException.initCause(iOException);
            }
        } else {
            interruptedIOException = iOException;
        }
        if (iOException != null) {
            interruptedIOException.getClass();
        }
        return interruptedIOException;
    }

    public final void cancel() {
        Socket socket;
        if (this.f3812q) {
            return;
        }
        this.f3812q = true;
        e eVar = this.f3813r;
        if (eVar != null) {
            ((fd.d) eVar.f3786d).cancel();
        }
        m mVar = this.f3814s;
        if (mVar == null || (socket = mVar.f3821b) == null) {
            return;
        }
        bd.b.e(socket);
    }

    public final Object clone() {
        return new j(this.f3801c, this.f3802f);
    }

    public final void d(ad.d dVar) {
        g gVar;
        if (!this.i.compareAndSet(false, true)) {
            od.f.e("Already Executed");
            return;
        }
        id.n.Companion.getClass();
        this.f3805j = id.n.platform.getStackTraceForCloseable("response.body().close()");
        p5.i iVar = this.f3801c.f603c;
        g gVar2 = new g();
        gVar2.f3798g = this;
        gVar2.f3796c = dVar;
        gVar2.f3797f = new AtomicInteger(0);
        VarHandle.storeStoreFence();
        iVar.getClass();
        synchronized (iVar) {
            ((ArrayDeque) iVar.f9731f).add(gVar2);
            String str = ((q) this.f3802f.f637b).f562d;
            Iterator it = ((ArrayDeque) iVar.f9732g).iterator();
            while (true) {
                if (!it.hasNext()) {
                    Iterator it2 = ((ArrayDeque) iVar.f9731f).iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            gVar = null;
                            break;
                        } else {
                            gVar = (g) it2.next();
                            if (yb.k.a(((q) gVar.f3798g.f3802f.f637b).f562d, str)) {
                                break;
                            }
                        }
                    }
                } else {
                    gVar = (g) it.next();
                    if (yb.k.a(((q) gVar.f3798g.f3802f.f637b).f562d, str)) {
                        break;
                    }
                }
            }
            if (gVar != null) {
                gVar2.f3797f = gVar.f3797f;
            }
        }
        iVar.A();
    }

    public final e0 e() {
        if (!this.i.compareAndSet(false, true)) {
            od.f.e("Already Executed");
            return null;
        }
        this.f3804h.h();
        id.n.Companion.getClass();
        this.f3805j = id.n.platform.getStackTraceForCloseable("response.body().close()");
        try {
            p5.i iVar = this.f3801c.f603c;
            synchronized (iVar) {
                ((ArrayDeque) iVar.f9733h).add(this);
            }
            return h();
        } finally {
            p5.i iVar2 = this.f3801c.f603c;
            iVar2.getClass();
            iVar2.t((ArrayDeque) iVar2.f9733h, this);
        }
    }

    public final void f(boolean z10) {
        e eVar;
        synchronized (this) {
            if (!this.f3811p) {
                throw new IllegalStateException("released");
            }
        }
        if (z10 && (eVar = this.f3813r) != null) {
            ((fd.d) eVar.f3786d).cancel();
            ((j) eVar.f3784b).j(eVar, true, true, null);
        }
        this.f3808m = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ad.e0 h() throws java.lang.Throwable {
        /*
            r11 = this;
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            ad.w r0 = r11.f3801c
            java.util.List r0 = r0.f605g
            kb.q.p0(r0, r2)
            fd.a r0 = new fd.a
            ad.w r1 = r11.f3801c
            r1.getClass()
            r9 = 1
            r0.<init>(r9)
            r0.f4058b = r1
            java.lang.invoke.VarHandle.storeStoreFence()
            r2.add(r0)
            fd.a r0 = new fd.a
            ad.w r1 = r11.f3801c
            ad.b r1 = r1.f611n
            r1.getClass()
            r10 = 0
            r0.<init>(r10)
            r0.f4058b = r1
            java.lang.invoke.VarHandle.storeStoreFence()
            r2.add(r0)
            cd.b r0 = new cd.b
            ad.w r1 = r11.f3801c
            r1.getClass()
            r0.<init>()
            r2.add(r0)
            ed.a r0 = ed.a.f3769a
            r2.add(r0)
            ad.w r0 = r11.f3801c
            java.util.List r0 = r0.f606h
            kb.q.p0(r0, r2)
            fd.b r0 = new fd.b
            r0.<init>()
            java.lang.invoke.VarHandle.storeStoreFence()
            r2.add(r0)
            fd.f r0 = new fd.f
            ad.z r5 = r11.f3802f
            ad.w r1 = r11.f3801c
            int r6 = r1.A
            int r7 = r1.B
            int r8 = r1.C
            r3 = 0
            r4 = 0
            r1 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r11 = 0
            ad.z r2 = r1.f3802f     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            ad.e0 r0 = r0.b(r2)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            boolean r2 = r1.f3812q     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            if (r2 != 0) goto L79
            r1.k(r11)
            return r0
        L79:
            bd.b.d(r0)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            java.lang.String r2 = "Canceled"
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
            throw r0     // Catch: java.lang.Throwable -> L84 java.io.IOException -> L87
        L84:
            r0 = move-exception
            r9 = r10
            goto L91
        L87:
            r0 = move-exception
            java.io.IOException r0 = r1.k(r0)     // Catch: java.lang.Throwable -> L90
            r0.getClass()     // Catch: java.lang.Throwable -> L90
            throw r0     // Catch: java.lang.Throwable -> L90
        L90:
            r0 = move-exception
        L91:
            if (r9 != 0) goto L96
            r1.k(r11)
        L96:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ed.j.h():ad.e0");
    }

    public final IOException j(e eVar, boolean z10, boolean z11, IOException iOException) {
        boolean z12;
        boolean z13;
        eVar.getClass();
        if (eVar.equals(this.f3813r)) {
            synchronized (this) {
                z12 = false;
                if (z10) {
                    try {
                        if (!this.f3809n) {
                            if (z11 || !this.f3810o) {
                                z13 = false;
                            }
                        }
                        if (z10) {
                            this.f3809n = false;
                        }
                        if (z11) {
                            this.f3810o = false;
                        }
                        boolean z14 = this.f3809n;
                        boolean z15 = (z14 || this.f3810o) ? false : true;
                        if (!z14 && !this.f3810o) {
                            if (!this.f3811p) {
                                z12 = true;
                            }
                        }
                        z13 = z12;
                        z12 = z15;
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    if (z11) {
                    }
                    z13 = false;
                }
            }
            if (z12) {
                this.f3813r = null;
                m mVar = this.f3807l;
                if (mVar != null) {
                    synchronized (mVar) {
                        mVar.f3830l++;
                    }
                }
            }
            if (z13) {
                return c(iOException);
            }
        }
        return iOException;
    }

    public final IOException k(IOException iOException) {
        boolean z10;
        synchronized (this) {
            z10 = false;
            if (this.f3811p) {
                this.f3811p = false;
                if (!this.f3809n) {
                    if (!this.f3810o) {
                        z10 = true;
                    }
                }
            }
        }
        return z10 ? c(iOException) : iOException;
    }

    public final Socket l() {
        m mVar = this.f3807l;
        mVar.getClass();
        byte[] bArr = bd.b.f2074a;
        ArrayList arrayList = mVar.f3833o;
        int size = arrayList.size();
        int i = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i = -1;
                break;
            }
            Object obj = arrayList.get(i3);
            i3++;
            if (yb.k.a(((Reference) obj).get(), this)) {
                break;
            }
            i++;
        }
        if (i == -1) {
            od.f.e("Check failed.");
            return null;
        }
        arrayList.remove(i);
        this.f3807l = null;
        if (!arrayList.isEmpty()) {
            return null;
        }
        mVar.f3834p = System.nanoTime();
        d0 d0Var = this.f3803g;
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) d0Var.f1949h;
        dd.c cVar = (dd.c) d0Var.f1947f;
        byte[] bArr2 = bd.b.f2074a;
        if (!mVar.i) {
            cVar.c((dd.b) d0Var.f1948g, 0L);
            return null;
        }
        mVar.i = true;
        concurrentLinkedQueue.remove(mVar);
        if (concurrentLinkedQueue.isEmpty()) {
            cVar.a();
        }
        Socket socket = mVar.f3822c;
        socket.getClass();
        return socket;
    }
}
