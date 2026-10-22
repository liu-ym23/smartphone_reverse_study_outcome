package hb;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.TimeUnit;
import ob.e0;

/* loaded from: classes.dex */
public final class p implements Closeable {
    public static final b0 F;
    public long A;
    public final Socket B;
    public final y C;
    public final k D;
    public final LinkedHashSet E;

    /* renamed from: f, reason: collision with root package name */
    public final h f4314f;

    /* renamed from: g, reason: collision with root package name */
    public final LinkedHashMap f4315g = new LinkedHashMap();

    /* renamed from: h, reason: collision with root package name */
    public final String f4316h;

    /* renamed from: i, reason: collision with root package name */
    public int f4317i;

    /* renamed from: j, reason: collision with root package name */
    public int f4318j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f4319k;

    /* renamed from: l, reason: collision with root package name */
    public final db.e f4320l;

    /* renamed from: m, reason: collision with root package name */
    public final db.c f4321m;

    /* renamed from: n, reason: collision with root package name */
    public final db.c f4322n;

    /* renamed from: o, reason: collision with root package name */
    public final db.c f4323o;

    /* renamed from: p, reason: collision with root package name */
    public final a0 f4324p;

    /* renamed from: q, reason: collision with root package name */
    public long f4325q;

    /* renamed from: r, reason: collision with root package name */
    public long f4326r;

    /* renamed from: s, reason: collision with root package name */
    public long f4327s;

    /* renamed from: t, reason: collision with root package name */
    public long f4328t;

    /* renamed from: u, reason: collision with root package name */
    public long f4329u;

    /* renamed from: v, reason: collision with root package name */
    public final b0 f4330v;

    /* renamed from: w, reason: collision with root package name */
    public b0 f4331w;

    /* renamed from: x, reason: collision with root package name */
    public long f4332x;

    /* renamed from: y, reason: collision with root package name */
    public long f4333y;

    /* renamed from: z, reason: collision with root package name */
    public long f4334z;

    static {
        b0 b0Var = new b0();
        b0Var.c(7, 65535);
        b0Var.c(5, 16384);
        F = b0Var;
    }

    public p(gb.h hVar) {
        this.f4314f = (h) hVar.f4058h;
        String str = (String) hVar.f4055e;
        if (str == null) {
            q7.k.j("connectionName");
            throw null;
        }
        this.f4316h = str;
        this.f4318j = 3;
        db.e eVar = (db.e) hVar.f4053c;
        this.f4320l = eVar;
        db.c cVarE = eVar.e();
        this.f4321m = cVarE;
        this.f4322n = eVar.e();
        this.f4323o = eVar.e();
        this.f4324p = a0.f4255a;
        b0 b0Var = new b0();
        b0Var.c(7, 16777216);
        this.f4330v = b0Var;
        this.f4331w = F;
        this.A = r2.a();
        Socket socket = (Socket) hVar.f4054d;
        if (socket == null) {
            q7.k.j("socket");
            throw null;
        }
        this.B = socket;
        ob.c0 c0Var = (ob.c0) hVar.f4057g;
        if (c0Var == null) {
            q7.k.j("sink");
            throw null;
        }
        this.C = new y(c0Var);
        e0 e0Var = (e0) hVar.f4056f;
        if (e0Var == null) {
            q7.k.j("source");
            throw null;
        }
        this.D = new k(0, this, new t(e0Var));
        this.E = new LinkedHashSet();
        int i2 = hVar.f4052b;
        if (i2 != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(i2);
            cVarE.c(new n(str.concat(" ping"), this, nanos, 0), nanos);
        }
    }

    public final void a(int i2, int i10, IOException iOException) throws IOException {
        int i11;
        Object[] array;
        m.x.t(i2, "connectionCode");
        m.x.t(i10, "streamCode");
        byte[] bArr = bb.b.f1659a;
        try {
            e(i2);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (this.f4315g.isEmpty()) {
                array = null;
            } else {
                array = this.f4315g.values().toArray(new x[0]);
                this.f4315g.clear();
            }
        }
        x[] xVarArr = (x[]) array;
        if (xVarArr != null) {
            for (x xVar : xVarArr) {
                try {
                    xVar.c(i10, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.C.close();
        } catch (IOException unused3) {
        }
        try {
            this.B.close();
        } catch (IOException unused4) {
        }
        this.f4321m.e();
        this.f4322n.e();
        this.f4323o.e();
    }

    public final synchronized x b(int i2) {
        return (x) this.f4315g.get(Integer.valueOf(i2));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        a(1, 9, null);
    }

    public final synchronized x d(int i2) {
        x xVar;
        xVar = (x) this.f4315g.remove(Integer.valueOf(i2));
        notifyAll();
        return xVar;
    }

    public final void e(int i2) {
        m.x.t(i2, "statusCode");
        synchronized (this.C) {
            synchronized (this) {
                if (this.f4319k) {
                    return;
                }
                this.f4319k = true;
                this.C.e(bb.b.f1659a, this.f4317i, i2);
            }
        }
    }

    public final void flush() {
        this.C.flush();
    }

    public final synchronized void g(long j2) {
        long j4 = this.f4332x + j2;
        this.f4332x = j4;
        long j10 = j4 - this.f4333y;
        if (j10 >= this.f4330v.a() / 2) {
            n(0, j10);
            this.f4333y += j10;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r6 - r4), r8.C.f4381h);
        r6 = r2;
        r8.f4334z += r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(int r9, boolean r10, ob.h r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            hb.y r8 = r8.C
            r8.b(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L68
            monitor-enter(r8)
        L12:
            long r4 = r8.f4334z     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            long r6 = r8.A     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 < 0) goto L34
            java.util.LinkedHashMap r2 = r8.f4315g     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            if (r2 == 0) goto L2c
            r8.wait()     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            goto L12
        L2a:
            r9 = move-exception
            goto L66
        L2c:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            throw r9     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
        L34:
            long r6 = r6 - r4
            long r4 = java.lang.Math.min(r12, r6)     // Catch: java.lang.Throwable -> L2a
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L2a
            hb.y r4 = r8.C     // Catch: java.lang.Throwable -> L2a
            int r4 = r4.f4381h     // Catch: java.lang.Throwable -> L2a
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L2a
            long r4 = r8.f4334z     // Catch: java.lang.Throwable -> L2a
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L2a
            long r4 = r4 + r6
            r8.f4334z = r4     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r8)
            long r12 = r12 - r6
            hb.y r4 = r8.C
            if (r10 == 0) goto L54
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L54
            r5 = 1
            goto L55
        L54:
            r5 = r3
        L55:
            r4.b(r5, r9, r11, r2)
            goto Ld
        L59:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L2a
            r9.interrupt()     // Catch: java.lang.Throwable -> L2a
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L2a
            r9.<init>()     // Catch: java.lang.Throwable -> L2a
            throw r9     // Catch: java.lang.Throwable -> L2a
        L66:
            monitor-exit(r8)
            throw r9
        L68:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.p.i(int, boolean, ob.h, long):void");
    }

    public final void k(int i2, int i10) {
        m.x.t(i10, "errorCode");
        this.f4321m.c(new j(this.f4316h + '[' + i2 + "] writeSynReset", this, i2, i10, 2), 0L);
    }

    public final void n(int i2, long j2) {
        this.f4321m.c(new o(this.f4316h + '[' + i2 + "] windowUpdate", this, i2, j2), 0L);
    }
}
