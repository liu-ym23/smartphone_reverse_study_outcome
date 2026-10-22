package hd;

import androidx.exifinterface.media.ExifInterface;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o implements Closeable {
    public static final z D;
    public w A;
    public k B;
    public LinkedHashSet C;

    /* renamed from: c, reason: collision with root package name */
    public ed.m f5518c;

    /* renamed from: f, reason: collision with root package name */
    public LinkedHashMap f5519f;

    /* renamed from: g, reason: collision with root package name */
    public String f5520g;

    /* renamed from: h, reason: collision with root package name */
    public int f5521h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5522j;

    /* renamed from: k, reason: collision with root package name */
    public dd.d f5523k;

    /* renamed from: l, reason: collision with root package name */
    public dd.c f5524l;

    /* renamed from: m, reason: collision with root package name */
    public dd.c f5525m;

    /* renamed from: n, reason: collision with root package name */
    public dd.c f5526n;

    /* renamed from: o, reason: collision with root package name */
    public y f5527o;

    /* renamed from: p, reason: collision with root package name */
    public long f5528p;

    /* renamed from: q, reason: collision with root package name */
    public long f5529q;

    /* renamed from: r, reason: collision with root package name */
    public long f5530r;

    /* renamed from: s, reason: collision with root package name */
    public long f5531s;

    /* renamed from: t, reason: collision with root package name */
    public z f5532t;

    /* renamed from: u, reason: collision with root package name */
    public z f5533u;

    /* renamed from: v, reason: collision with root package name */
    public long f5534v;

    /* renamed from: w, reason: collision with root package name */
    public long f5535w;

    /* renamed from: x, reason: collision with root package name */
    public long f5536x;

    /* renamed from: y, reason: collision with root package name */
    public long f5537y;

    /* renamed from: z, reason: collision with root package name */
    public Socket f5538z;

    static {
        z zVar = new z();
        zVar.b(7, ExifInterface.COLOR_SPACE_UNCALIBRATED);
        zVar.b(5, 16384);
        D = zVar;
    }

    public final void A(int i, long j10) {
        this.f5524l.c(new n(this.f5520g + '[' + i + "] windowUpdate", this, i, j10), 0L);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        d(1, 9, null);
    }

    public final void d(int i, int i3, IOException iOException) {
        int i10;
        Object[] array = null;
        if (i == 0 || i3 == 0) {
            throw null;
        }
        byte[] bArr = bd.b.f2074a;
        try {
            i(i);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (!this.f5519f.isEmpty()) {
                array = this.f5519f.values().toArray(new v[0]);
                this.f5519f.clear();
            }
        }
        v[] vVarArr = (v[]) array;
        if (vVarArr != null) {
            for (v vVar : vVarArr) {
                try {
                    vVar.c(i3, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.A.close();
        } catch (IOException unused3) {
        }
        try {
            this.f5538z.close();
        } catch (IOException unused4) {
        }
        this.f5524l.e();
        this.f5525m.e();
        this.f5526n.e();
    }

    public final synchronized v e(int i) {
        return (v) this.f5519f.get(Integer.valueOf(i));
    }

    public final void flush() {
        this.A.flush();
    }

    public final synchronized v g(int i) {
        v vVar;
        vVar = (v) this.f5519f.remove(Integer.valueOf(i));
        notifyAll();
        return vVar;
    }

    public final void i(int i) {
        if (i == 0) {
            throw null;
        }
        synchronized (this.A) {
            synchronized (this) {
                if (this.f5522j) {
                    return;
                }
                this.f5522j = true;
                this.A.i(this.f5521h, i, bd.b.f2074a);
            }
        }
    }

    public final synchronized void n(long j10) {
        long j11 = this.f5534v + j10;
        this.f5534v = j11;
        long j12 = j11 - this.f5535w;
        if (j12 >= this.f5532t.a() / 2) {
            A(0, j12);
            this.f5535w += j12;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r6 - r4), r8.A.f5582g);
        r6 = r2;
        r8.f5536x += r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o(int r9, boolean r10, od.i r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            hd.w r8 = r8.A
            r8.e(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L68
            monitor-enter(r8)
        L12:
            long r4 = r8.f5536x     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            long r6 = r8.f5537y     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 < 0) goto L34
            java.util.LinkedHashMap r2 = r8.f5519f     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
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
            hd.w r4 = r8.A     // Catch: java.lang.Throwable -> L2a
            int r4 = r4.f5582g     // Catch: java.lang.Throwable -> L2a
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L2a
            long r4 = r8.f5536x     // Catch: java.lang.Throwable -> L2a
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L2a
            long r4 = r4 + r6
            r8.f5536x = r4     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r8)
            long r12 = r12 - r6
            hd.w r4 = r8.A
            if (r10 == 0) goto L54
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L54
            r5 = 1
            goto L55
        L54:
            r5 = r3
        L55:
            r4.e(r5, r9, r11, r2)
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
        throw new UnsupportedOperationException("Method not decompiled: hd.o.o(int, boolean, od.i, long):void");
    }

    public final void r(int i, int i3) {
        if (i3 == 0) {
            throw null;
        }
        this.f5524l.c(new j(this.f5520g + '[' + i + "] writeSynReset", this, i, i3, 2), 0L);
    }
}
