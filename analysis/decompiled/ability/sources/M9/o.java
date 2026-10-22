package M9;

import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Ref$IntRef;
import okhttp3.internal.http2.ErrorCode;

/* loaded from: classes4.dex */
public final class o implements Closeable {

    /* renamed from: z, reason: collision with root package name */
    public static final B f983z;

    /* renamed from: a, reason: collision with root package name */
    public final h f984a;
    public final LinkedHashMap b = new LinkedHashMap();
    public final String c;
    public int d;
    public int e;
    public boolean f;
    public final I9.e g;
    public final I9.c h;
    public final I9.c i;

    /* renamed from: j, reason: collision with root package name */
    public final I9.c f985j;
    public final A k;
    public long l;
    public long m;
    public long n;
    public long o;
    public final B p;

    /* renamed from: q, reason: collision with root package name */
    public B f986q;

    /* renamed from: r, reason: collision with root package name */
    public long f987r;

    /* renamed from: s, reason: collision with root package name */
    public long f988s;

    /* renamed from: t, reason: collision with root package name */
    public long f989t;
    public long u;

    /* renamed from: v, reason: collision with root package name */
    public final Socket f990v;

    /* renamed from: w, reason: collision with root package name */
    public final x f991w;

    /* renamed from: x, reason: collision with root package name */
    public final J4.e f992x;
    public final LinkedHashSet y;

    static {
        B b = new B();
        b.c(7, 65535);
        b.c(5, 16384);
        f983z = b;
    }

    public o(f fVar) {
        this.f984a = (h) fVar.f;
        String str = (String) fVar.c;
        if (str == null) {
            kotlin.jvm.internal.k.n("connectionName");
            throw null;
        }
        this.c = str;
        this.e = 3;
        I9.e eVar = (I9.e) fVar.f981a;
        this.g = eVar;
        this.h = eVar.e();
        this.i = eVar.e();
        this.f985j = eVar.e();
        this.k = A.f974a;
        B b = new B();
        b.c(7, 16777216);
        this.p = b;
        this.f986q = f983z;
        this.u = r0.a();
        Socket socket = (Socket) fVar.b;
        if (socket == null) {
            kotlin.jvm.internal.k.n("socket");
            throw null;
        }
        this.f990v = socket;
        V9.q qVar = (V9.q) fVar.e;
        if (qVar == null) {
            kotlin.jvm.internal.k.n("sink");
            throw null;
        }
        this.f991w = new x(qVar);
        V9.r rVar = (V9.r) fVar.d;
        if (rVar == null) {
            kotlin.jvm.internal.k.n(AgentBusWakeContract.EXTRA_SOURCE);
            throw null;
        }
        this.f992x = new J4.e(1, this, false, new s(rVar));
        this.y = new LinkedHashSet();
    }

    public final void b(ErrorCode errorCode, ErrorCode errorCode2, IOException iOException) throws IOException {
        int i;
        Object[] array;
        byte[] bArr = G9.b.f704a;
        try {
            i(errorCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (this.b.isEmpty()) {
                array = null;
            } else {
                array = this.b.values().toArray(new w[0]);
                this.b.clear();
            }
        }
        w[] wVarArr = (w[]) array;
        if (wVarArr != null) {
            for (w wVar : wVarArr) {
                try {
                    wVar.c(errorCode2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.f991w.close();
        } catch (IOException unused3) {
        }
        try {
            this.f990v.close();
        } catch (IOException unused4) {
        }
        this.h.e();
        this.i.e();
        this.f985j.e();
    }

    public final void c(IOException iOException) throws IOException {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        b(errorCode, errorCode, iOException);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        b(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final synchronized w f(int i) {
        return (w) this.b.get(Integer.valueOf(i));
    }

    public final void flush() {
        this.f991w.flush();
    }

    public final synchronized w g(int i) {
        w wVar;
        wVar = (w) this.b.remove(Integer.valueOf(i));
        notifyAll();
        return wVar;
    }

    public final void i(ErrorCode errorCode) {
        synchronized (this.f991w) {
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            synchronized (this) {
                if (this.f) {
                    return;
                }
                this.f = true;
                int i = this.d;
                ref$IntRef.f4918a = i;
                this.f991w.g(i, errorCode, G9.b.f704a);
            }
        }
    }

    public final synchronized void k(long j5) {
        long j6 = this.f987r + j5;
        this.f987r = j6;
        long j10 = j6 - this.f988s;
        if (j10 >= this.p.a() / 2) {
            r(0, j10);
            this.f988s += j10;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r6 - r4), r8.f991w.c);
        r6 = r2;
        r8.f989t += r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(int r9, boolean r10, V9.g r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            M9.x r8 = r8.f991w
            r8.c(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L68
            monitor-enter(r8)
        L12:
            long r4 = r8.f989t     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            long r6 = r8.u     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 < 0) goto L34
            java.util.LinkedHashMap r2 = r8.b     // Catch: java.lang.Throwable -> L2a java.lang.InterruptedException -> L59
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
            M9.x r4 = r8.f991w     // Catch: java.lang.Throwable -> L2a
            int r4 = r4.c     // Catch: java.lang.Throwable -> L2a
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L2a
            long r4 = r8.f989t     // Catch: java.lang.Throwable -> L2a
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L2a
            long r4 = r4 + r6
            r8.f989t = r4     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r8)
            long r12 = r12 - r6
            M9.x r4 = r8.f991w
            if (r10 == 0) goto L54
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L54
            r5 = 1
            goto L55
        L54:
            r5 = r3
        L55:
            r4.c(r5, r9, r11, r2)
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
        throw new UnsupportedOperationException("Method not decompiled: M9.o.l(int, boolean, V9.g, long):void");
    }

    public final void n(int i, ErrorCode errorCode) {
        this.h.c(new l(this.c + '[' + i + "] writeSynReset", this, i, errorCode, 2), 0L);
    }

    public final void r(int i, long j5) {
        this.h.c(new n(this.c + '[' + i + "] windowUpdate", this, i, j5), 0L);
    }
}
