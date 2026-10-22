package hd;

import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.ArrayDeque;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final int f5566a;

    /* renamed from: b, reason: collision with root package name */
    public final o f5567b;

    /* renamed from: c, reason: collision with root package name */
    public long f5568c;

    /* renamed from: d, reason: collision with root package name */
    public long f5569d;

    /* renamed from: e, reason: collision with root package name */
    public long f5570e;

    /* renamed from: f, reason: collision with root package name */
    public long f5571f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayDeque f5572g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5573h;
    public final t i;

    /* renamed from: j, reason: collision with root package name */
    public final s f5574j;

    /* renamed from: k, reason: collision with root package name */
    public final u f5575k;

    /* renamed from: l, reason: collision with root package name */
    public final u f5576l;

    /* renamed from: m, reason: collision with root package name */
    public int f5577m;

    /* renamed from: n, reason: collision with root package name */
    public IOException f5578n;

    public v(int i, o oVar, boolean z10, boolean z11, ad.n nVar) {
        oVar.getClass();
        this.f5566a = i;
        this.f5567b = oVar;
        this.f5571f = oVar.f5533u.a();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f5572g = arrayDeque;
        long jA = oVar.f5532t.a();
        t tVar = new t();
        tVar.f5564j = this;
        tVar.f5560c = jA;
        tVar.f5561f = z11;
        tVar.f5562g = new od.i();
        tVar.f5563h = new od.i();
        VarHandle.storeStoreFence();
        this.i = tVar;
        s sVar = new s();
        sVar.f5559h = this;
        sVar.f5556c = z10;
        sVar.f5557f = new od.i();
        VarHandle.storeStoreFence();
        this.f5574j = sVar;
        this.f5575k = new u(this);
        this.f5576l = new u(this);
        if (nVar == null) {
            if (g()) {
                return;
            }
            od.f.e("remotely-initiated streams should have headers");
            throw null;
        }
        if (g()) {
            od.f.e("locally-initiated streams shouldn't have headers yet");
            throw null;
        }
        arrayDeque.add(nVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r2 = this;
            byte[] r0 = bd.b.f2074a
            monitor-enter(r2)
            hd.t r0 = r2.i     // Catch: java.lang.Throwable -> L18
            boolean r1 = r0.f5561f     // Catch: java.lang.Throwable -> L18
            if (r1 != 0) goto L1c
            boolean r0 = r0.i     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L1c
            hd.s r0 = r2.f5574j     // Catch: java.lang.Throwable -> L18
            boolean r1 = r0.f5556c     // Catch: java.lang.Throwable -> L18
            if (r1 != 0) goto L1a
            boolean r0 = r0.f5558g     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L1c
            goto L1a
        L18:
            r0 = move-exception
            goto L35
        L1a:
            r0 = 1
            goto L1d
        L1c:
            r0 = 0
        L1d:
            boolean r1 = r2.h()     // Catch: java.lang.Throwable -> L18
            monitor-exit(r2)
            if (r0 == 0) goto L2b
            r0 = 9
            r1 = 0
            r2.c(r0, r1)
            return
        L2b:
            if (r1 != 0) goto L34
            hd.o r0 = r2.f5567b
            int r2 = r2.f5566a
            r0.g(r2)
        L34:
            return
        L35:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: hd.v.a():void");
    }

    public final void b() throws IOException {
        s sVar = this.f5574j;
        if (sVar.f5558g) {
            od.f.l("stream closed");
            return;
        }
        if (sVar.f5556c) {
            od.f.l("stream finished");
            return;
        }
        int i = this.f5577m;
        if (i != 0) {
            IOException iOException = this.f5578n;
            if (iOException != null) {
                throw iOException;
            }
            if (i == 0) {
                throw null;
            }
            throw new a0(i);
        }
    }

    public final void c(int i, IOException iOException) {
        if (i == 0) {
            throw null;
        }
        if (d(i, iOException)) {
            o oVar = this.f5567b;
            oVar.getClass();
            oVar.A.r(this.f5566a, i);
        }
    }

    public final boolean d(int i, IOException iOException) {
        byte[] bArr = bd.b.f2074a;
        synchronized (this) {
            if (this.f5577m != 0) {
                return false;
            }
            this.f5577m = i;
            this.f5578n = iOException;
            notifyAll();
            if (this.i.f5561f) {
                if (this.f5574j.f5556c) {
                    return false;
                }
            }
            this.f5567b.g(this.f5566a);
            return true;
        }
    }

    public final void e(int i) {
        if (i == 0) {
            throw null;
        }
        if (d(i, null)) {
            this.f5567b.r(this.f5566a, i);
        }
    }

    public final s f() {
        synchronized (this) {
            if (!this.f5573h && !g()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f5574j;
    }

    public final boolean g() {
        boolean z10 = (this.f5566a & 1) == 1;
        this.f5567b.getClass();
        return true == z10;
    }

    public final synchronized boolean h() {
        try {
            if (this.f5577m != 0) {
                return false;
            }
            t tVar = this.i;
            if (tVar.f5561f || tVar.i) {
                s sVar = this.f5574j;
                if (sVar.f5556c || sVar.f5558g) {
                    if (this.f5573h) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void i(ad.n nVar, boolean z10) {
        boolean zH;
        nVar.getClass();
        byte[] bArr = bd.b.f2074a;
        synchronized (this) {
            try {
                if (this.f5573h && z10) {
                    this.i.getClass();
                } else {
                    this.f5573h = true;
                    this.f5572g.add(nVar);
                }
                if (z10) {
                    this.i.f5561f = true;
                }
                zH = h();
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zH) {
            return;
        }
        this.f5567b.g(this.f5566a);
    }
}
