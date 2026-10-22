package hb;

import java.io.IOException;
import java.util.ArrayDeque;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final int f4364a;

    /* renamed from: b, reason: collision with root package name */
    public final p f4365b;

    /* renamed from: c, reason: collision with root package name */
    public long f4366c;

    /* renamed from: d, reason: collision with root package name */
    public long f4367d;

    /* renamed from: e, reason: collision with root package name */
    public long f4368e;

    /* renamed from: f, reason: collision with root package name */
    public long f4369f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayDeque f4370g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f4371h;

    /* renamed from: i, reason: collision with root package name */
    public final v f4372i;

    /* renamed from: j, reason: collision with root package name */
    public final u f4373j;

    /* renamed from: k, reason: collision with root package name */
    public final w f4374k;

    /* renamed from: l, reason: collision with root package name */
    public final w f4375l;

    /* renamed from: m, reason: collision with root package name */
    public int f4376m;

    /* renamed from: n, reason: collision with root package name */
    public IOException f4377n;

    public x(int i2, p pVar, boolean z4, boolean z10, ab.n nVar) {
        q7.k.e(pVar, "connection");
        this.f4364a = i2;
        this.f4365b = pVar;
        this.f4369f = pVar.f4331w.a();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f4370g = arrayDeque;
        this.f4372i = new v(this, pVar.f4330v.a(), z10);
        this.f4373j = new u(this, z4);
        this.f4374k = new w(this);
        this.f4375l = new w(this);
        if (nVar == null) {
            if (!g()) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            if (g()) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            arrayDeque.add(nVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r2 = this;
            byte[] r0 = bb.b.f1659a
            monitor-enter(r2)
            hb.v r0 = r2.f4372i     // Catch: java.lang.Throwable -> L18
            boolean r1 = r0.f4358g     // Catch: java.lang.Throwable -> L18
            if (r1 != 0) goto L1c
            boolean r0 = r0.f4361j     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L1c
            hb.u r0 = r2.f4373j     // Catch: java.lang.Throwable -> L18
            boolean r1 = r0.f4353f     // Catch: java.lang.Throwable -> L18
            if (r1 != 0) goto L1a
            boolean r0 = r0.f4355h     // Catch: java.lang.Throwable -> L18
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
            hb.p r0 = r2.f4365b
            int r2 = r2.f4364a
            r0.d(r2)
        L34:
            return
        L35:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.x.a():void");
    }

    public final void b() throws IOException {
        u uVar = this.f4373j;
        if (uVar.f4355h) {
            throw new IOException("stream closed");
        }
        if (uVar.f4353f) {
            throw new IOException("stream finished");
        }
        if (this.f4376m != 0) {
            IOException iOException = this.f4377n;
            if (iOException != null) {
                throw iOException;
            }
            int i2 = this.f4376m;
            m.x.s(i2);
            throw new c0(i2);
        }
    }

    public final void c(int i2, IOException iOException) {
        m.x.t(i2, "rstStatusCode");
        if (d(i2, iOException)) {
            p pVar = this.f4365b;
            pVar.getClass();
            m.x.t(i2, "statusCode");
            pVar.C.k(this.f4364a, i2);
        }
    }

    public final boolean d(int i2, IOException iOException) {
        byte[] bArr = bb.b.f1659a;
        synchronized (this) {
            if (this.f4376m != 0) {
                return false;
            }
            this.f4376m = i2;
            this.f4377n = iOException;
            notifyAll();
            if (this.f4372i.f4358g) {
                if (this.f4373j.f4353f) {
                    return false;
                }
            }
            this.f4365b.d(this.f4364a);
            return true;
        }
    }

    public final void e(int i2) {
        m.x.t(i2, "errorCode");
        if (d(i2, null)) {
            this.f4365b.k(this.f4364a, i2);
        }
    }

    public final u f() {
        synchronized (this) {
            if (!this.f4371h && !g()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f4373j;
    }

    public final boolean g() {
        boolean z4 = (this.f4364a & 1) == 1;
        this.f4365b.getClass();
        return true == z4;
    }

    public final synchronized boolean h() {
        try {
            if (this.f4376m != 0) {
                return false;
            }
            v vVar = this.f4372i;
            if (vVar.f4358g || vVar.f4361j) {
                u uVar = this.f4373j;
                if (uVar.f4353f || uVar.f4355h) {
                    if (this.f4371h) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void i(ab.n nVar, boolean z4) {
        boolean zH;
        q7.k.e(nVar, "headers");
        byte[] bArr = bb.b.f1659a;
        synchronized (this) {
            try {
                if (this.f4371h && z4) {
                    this.f4372i.getClass();
                } else {
                    this.f4371h = true;
                    this.f4370g.add(nVar);
                }
                if (z4) {
                    this.f4372i.f4358g = true;
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
        this.f4365b.d(this.f4364a);
    }

    public final synchronized void j(int i2) {
        m.x.t(i2, "errorCode");
        if (this.f4376m == 0) {
            this.f4376m = i2;
            notifyAll();
        }
    }
}
