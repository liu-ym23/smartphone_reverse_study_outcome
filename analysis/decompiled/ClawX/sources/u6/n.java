package u6;

import java.io.Closeable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import kotlinx.serialization.json.internal.ReaderJsonLexerKt;
import org.bouncycastle.crypto.digests.Blake2xsDigest;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class n implements Closeable {
    public static final z B;
    public final LinkedHashSet A;

    /* renamed from: a, reason: collision with root package name */
    public final l f5714a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f5715b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final String f5716c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public int f5717e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5718f;

    /* renamed from: g, reason: collision with root package name */
    public final q6.d f5719g;

    /* renamed from: h, reason: collision with root package name */
    public final q6.c f5720h;

    /* renamed from: j, reason: collision with root package name */
    public final q6.c f5721j;

    /* renamed from: k, reason: collision with root package name */
    public final q6.c f5722k;

    /* renamed from: l, reason: collision with root package name */
    public final y f5723l;

    /* renamed from: m, reason: collision with root package name */
    public long f5724m;

    /* renamed from: n, reason: collision with root package name */
    public long f5725n;

    /* renamed from: o, reason: collision with root package name */
    public long f5726o;

    /* renamed from: p, reason: collision with root package name */
    public long f5727p;

    /* renamed from: q, reason: collision with root package name */
    public long f5728q;

    /* renamed from: r, reason: collision with root package name */
    public final c f5729r;

    /* renamed from: s, reason: collision with root package name */
    public final z f5730s;

    /* renamed from: t, reason: collision with root package name */
    public z f5731t;

    /* renamed from: u, reason: collision with root package name */
    public final v6.a f5732u;

    /* renamed from: v, reason: collision with root package name */
    public long f5733v;

    /* renamed from: w, reason: collision with root package name */
    public long f5734w;

    /* renamed from: x, reason: collision with root package name */
    public final a4.d f5735x;
    public final w y;
    public final m z;

    static {
        z zVar = new z();
        zVar.c(4, Blake2xsDigest.UNKNOWN_DIGEST_LENGTH);
        zVar.c(5, ReaderJsonLexerKt.BATCH_SIZE);
        B = zVar;
    }

    public n(g.n nVar) {
        this.f5714a = (l) nVar.f2784e;
        String str = (String) nVar.d;
        if (str == null) {
            kotlin.jvm.internal.p.l("connectionName");
            throw null;
        }
        this.f5716c = str;
        this.f5717e = 3;
        q6.d dVar = (q6.d) nVar.f2782b;
        this.f5719g = dVar;
        q6.c cVarD = dVar.d();
        this.f5720h = cVarD;
        this.f5721j = dVar.d();
        this.f5722k = dVar.d();
        this.f5723l = y.f5780a;
        this.f5729r = (c) nVar.f2785f;
        z zVar = new z();
        zVar.c(4, 16777216);
        this.f5730s = zVar;
        this.f5731t = B;
        this.f5732u = new v6.a(0);
        this.f5734w = r2.a();
        a4.d dVar2 = (a4.d) nVar.f2783c;
        if (dVar2 == null) {
            kotlin.jvm.internal.p.l("socket");
            throw null;
        }
        this.f5735x = dVar2;
        this.y = new w((c7.o) dVar2.d);
        this.z = new m(this, new r((c7.p) dVar2.f97c));
        this.A = new LinkedHashSet();
        int i8 = nVar.f2781a;
        if (i8 != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(i8);
            String name = str.concat(" ping");
            b7.d dVar3 = new b7.d(6, nanos, this);
            kotlin.jvm.internal.p.e(name, "name");
            cVarD.c(new q6.b(name, dVar3), nanos);
        }
    }

    public final void a(b bVar, b bVar2, IOException iOException) {
        int i8;
        Object[] array;
        TimeZone timeZone = o6.f.f4330a;
        try {
            g(bVar);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (this.f5715b.isEmpty()) {
                array = null;
            } else {
                array = this.f5715b.values().toArray(new v[0]);
                this.f5715b.clear();
            }
        }
        v[] vVarArr = (v[]) array;
        if (vVarArr != null) {
            for (v vVar : vVarArr) {
                try {
                    vVar.e(bVar2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.y.close();
        } catch (IOException unused3) {
        }
        try {
            this.f5735x.cancel();
        } catch (IOException unused4) {
        }
        this.f5720h.e();
        this.f5721j.e();
        this.f5722k.e();
    }

    public final v b(int i8) {
        v vVar;
        synchronized (this) {
            vVar = (v) this.f5715b.get(Integer.valueOf(i8));
        }
        return vVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a(b.f5671c, b.f5675h, null);
    }

    public final v e(int i8) {
        v vVar;
        synchronized (this) {
            vVar = (v) this.f5715b.remove(Integer.valueOf(i8));
            notifyAll();
        }
        return vVar;
    }

    public final void flush() {
        this.y.flush();
    }

    public final void g(b bVar) {
        synchronized (this.y) {
            synchronized (this) {
                if (this.f5718f) {
                    return;
                }
                this.f5718f = true;
                this.y.g(this.d, bVar, o6.d.f4327a);
            }
        }
    }

    public final void j(long j4) {
        synchronized (this) {
            try {
                v6.a.b(this.f5732u, j4, 0L, 2);
                long jA = this.f5732u.a();
                if (jA >= this.f5730s.a() / 2) {
                    o(0, jA);
                    v6.a.b(this.f5732u, 0L, jA, 1);
                }
                c cVar = this.f5729r;
                v6.a windowCounter = this.f5732u;
                cVar.getClass();
                kotlin.jvm.internal.p.e(windowCounter, "windowCounter");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r6 - r4), r8.y.f5775c);
        r6 = r2;
        r8.f5733v += r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(int r9, boolean r10, c7.f r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            u6.w r8 = r8.y
            r8.b(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L68
            monitor-enter(r8)
        L12:
            long r4 = r8.f5733v     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            long r6 = r8.f5734w     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 < 0) goto L34
            java.util.LinkedHashMap r2 = r8.f5715b     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
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
            u6.w r4 = r8.y     // Catch: java.lang.Throwable -> L2a
            int r4 = r4.f5775c     // Catch: java.lang.Throwable -> L2a
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L2a
            long r4 = r8.f5733v     // Catch: java.lang.Throwable -> L2a
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L2a
            long r4 = r4 + r6
            r8.f5733v = r4     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r8)
            long r12 = r12 - r6
            u6.w r4 = r8.y
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
        throw new UnsupportedOperationException("Method not decompiled: u6.n.l(int, boolean, c7.f, long):void");
    }

    public final void n(int i8, b bVar) {
        q6.c.b(this.f5720h, this.f5716c + AbstractJsonLexerKt.BEGIN_LIST + i8 + "] writeSynReset", 0L, new com.stepos.stepclaw.memory.lightmem.c(this, i8, bVar), 6);
    }

    public final void o(final int i8, final long j4) {
        q6.c.b(this.f5720h, this.f5716c + AbstractJsonLexerKt.BEGIN_LIST + i8 + "] windowUpdate", 0L, new p5.a() { // from class: u6.i
            @Override // p5.a
            public final Object invoke() {
                n nVar = this.f5705a;
                try {
                    nVar.y.o(i8, j4);
                } catch (IOException e9) {
                    b bVar = b.d;
                    nVar.a(bVar, bVar, e9);
                }
                return b5.a0.f883a;
            }
        }, 6);
    }
}
