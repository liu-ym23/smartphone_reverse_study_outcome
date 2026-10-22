package u6;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.TimeZone;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class v implements c7.u {

    /* renamed from: a, reason: collision with root package name */
    public final int f5760a;

    /* renamed from: b, reason: collision with root package name */
    public final n f5761b;

    /* renamed from: c, reason: collision with root package name */
    public final v6.a f5762c;
    public long d;

    /* renamed from: e, reason: collision with root package name */
    public long f5763e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayDeque f5764f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5765g;

    /* renamed from: h, reason: collision with root package name */
    public final t f5766h;

    /* renamed from: i, reason: collision with root package name */
    public final s f5767i;

    /* renamed from: j, reason: collision with root package name */
    public final u f5768j;

    /* renamed from: k, reason: collision with root package name */
    public final u f5769k;

    /* renamed from: l, reason: collision with root package name */
    public b f5770l;

    /* renamed from: m, reason: collision with root package name */
    public IOException f5771m;

    public v(int i8, n connection, boolean z, boolean z2, n6.k kVar) {
        kotlin.jvm.internal.p.e(connection, "connection");
        this.f5760a = i8;
        this.f5761b = connection;
        this.f5762c = new v6.a(i8);
        this.f5763e = connection.f5731t.a();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f5764f = arrayDeque;
        this.f5766h = new t(this, connection.f5730s.a(), z2);
        this.f5767i = new s(this, z);
        this.f5768j = new u(this);
        this.f5769k = new u(this);
        if (kVar == null) {
            if (!i()) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            if (i()) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            arrayDeque.add(kVar);
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
            java.util.TimeZone r0 = o6.f.f4330a
            monitor-enter(r2)
            u6.t r0 = r2.f5766h     // Catch: java.lang.Throwable -> L18
            boolean r1 = r0.f5755b     // Catch: java.lang.Throwable -> L18
            if (r1 != 0) goto L1c
            boolean r0 = r0.f5757e     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L1c
            u6.s r0 = r2.f5767i     // Catch: java.lang.Throwable -> L18
            boolean r1 = r0.f5751a     // Catch: java.lang.Throwable -> L18
            if (r1 != 0) goto L1a
            boolean r0 = r0.f5753c     // Catch: java.lang.Throwable -> L18
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
            boolean r1 = r2.j()     // Catch: java.lang.Throwable -> L18
            monitor-exit(r2)
            if (r0 == 0) goto L2b
            u6.b r0 = u6.b.f5675h
            r1 = 0
            r2.e(r0, r1)
            return
        L2b:
            if (r1 != 0) goto L34
            u6.n r0 = r2.f5761b
            int r2 = r2.f5760a
            r0.e(r2)
        L34:
            return
        L35:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u6.v.a():void");
    }

    public final void b() throws IOException {
        s sVar = this.f5767i;
        if (sVar.f5753c) {
            throw new IOException("stream closed");
        }
        if (sVar.f5751a) {
            throw new IOException("stream finished");
        }
        if (h() != null) {
            IOException iOException = this.f5771m;
            if (iOException != null) {
                throw iOException;
            }
            b bVarH = h();
            kotlin.jvm.internal.p.b(bVarH);
            throw new a0(bVarH);
        }
    }

    @Override // c7.u
    public final c7.t c() {
        return this.f5767i;
    }

    @Override // c7.u
    public final void cancel() {
        g(b.f5675h);
    }

    @Override // c7.u
    public final c7.v d() {
        return this.f5766h;
    }

    public final void e(b bVar, IOException iOException) {
        if (f(bVar, iOException)) {
            this.f5761b.y.n(this.f5760a, bVar);
        }
    }

    public final boolean f(b bVar, IOException iOException) {
        TimeZone timeZone = o6.f.f4330a;
        synchronized (this) {
            if (h() != null) {
                return false;
            }
            this.f5770l = bVar;
            this.f5771m = iOException;
            notifyAll();
            if (this.f5766h.f5755b) {
                if (this.f5767i.f5751a) {
                    return false;
                }
            }
            this.f5761b.e(this.f5760a);
            return true;
        }
    }

    public final void g(b bVar) {
        if (f(bVar, null)) {
            this.f5761b.n(this.f5760a, bVar);
        }
    }

    public final b h() {
        b bVar;
        synchronized (this) {
            bVar = this.f5770l;
        }
        return bVar;
    }

    public final boolean i() {
        boolean z = (this.f5760a & 1) == 1;
        this.f5761b.getClass();
        return true == z;
    }

    public final boolean j() {
        synchronized (this) {
            try {
                if (h() != null) {
                    return false;
                }
                t tVar = this.f5766h;
                if (tVar.f5755b || tVar.f5757e) {
                    s sVar = this.f5767i;
                    if (sVar.f5751a || sVar.f5753c) {
                        if (this.f5765g) {
                            return false;
                        }
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void k(n6.k headers, boolean z) {
        boolean zJ;
        kotlin.jvm.internal.p.e(headers, "headers");
        TimeZone timeZone = o6.f.f4330a;
        synchronized (this) {
            try {
                if (this.f5765g && headers.f(":status") == null && headers.f(":method") == null) {
                    this.f5766h.getClass();
                } else {
                    this.f5765g = true;
                    this.f5764f.add(headers);
                }
                if (z) {
                    this.f5766h.f5755b = true;
                }
                zJ = j();
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zJ) {
            return;
        }
        this.f5761b.e(this.f5760a);
    }
}
