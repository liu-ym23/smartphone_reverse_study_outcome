package I4;

import C4.v;
import L4.w;
import L4.y;
import L4.z;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    long f3110a = 0;

    /* renamed from: b, reason: collision with root package name */
    long f3111b;

    /* renamed from: c, reason: collision with root package name */
    final int f3112c;

    /* renamed from: d, reason: collision with root package name */
    final f f3113d;

    /* renamed from: e, reason: collision with root package name */
    private final Deque<v> f3114e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3115f;

    /* renamed from: g, reason: collision with root package name */
    private final b f3116g;

    /* renamed from: h, reason: collision with root package name */
    final a f3117h;

    /* renamed from: i, reason: collision with root package name */
    final c f3118i;

    /* renamed from: j, reason: collision with root package name */
    final c f3119j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    I4.b f3120k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    IOException f3121l;

    final class a implements w {

        /* renamed from: a, reason: collision with root package name */
        private final L4.e f3122a = new L4.e();

        /* renamed from: b, reason: collision with root package name */
        private v f3123b;

        /* renamed from: c, reason: collision with root package name */
        boolean f3124c;

        /* renamed from: d, reason: collision with root package name */
        boolean f3125d;

        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void a(boolean r13) throws java.io.IOException {
            /*
                r12 = this;
                I4.i r1 = I4.i.this
                monitor-enter(r1)
                I4.i r0 = I4.i.this     // Catch: java.lang.Throwable -> L7b
                I4.i$c r0 = r0.f3119j     // Catch: java.lang.Throwable -> L7b
                r0.q()     // Catch: java.lang.Throwable -> L7b
            La:
                I4.i r0 = I4.i.this     // Catch: java.lang.Throwable -> L24
                long r2 = r0.f3111b     // Catch: java.lang.Throwable -> L24
                r4 = 0
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 > 0) goto L27
                boolean r2 = r12.f3125d     // Catch: java.lang.Throwable -> L24
                if (r2 != 0) goto L27
                boolean r2 = r12.f3124c     // Catch: java.lang.Throwable -> L24
                if (r2 != 0) goto L27
                I4.b r2 = r0.f3120k     // Catch: java.lang.Throwable -> L24
                if (r2 != 0) goto L27
                r0.q()     // Catch: java.lang.Throwable -> L24
                goto La
            L24:
                r0 = move-exception
                r13 = r0
                goto L7e
            L27:
                I4.i$c r0 = r0.f3119j     // Catch: java.lang.Throwable -> L7b
                r0.z()     // Catch: java.lang.Throwable -> L7b
                I4.i r0 = I4.i.this     // Catch: java.lang.Throwable -> L7b
                r0.c()     // Catch: java.lang.Throwable -> L7b
                I4.i r0 = I4.i.this     // Catch: java.lang.Throwable -> L7b
                long r2 = r0.f3111b     // Catch: java.lang.Throwable -> L7b
                L4.e r0 = r12.f3122a     // Catch: java.lang.Throwable -> L7b
                long r4 = r0.size()     // Catch: java.lang.Throwable -> L7b
                long r10 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L7b
                I4.i r0 = I4.i.this     // Catch: java.lang.Throwable -> L7b
                long r2 = r0.f3111b     // Catch: java.lang.Throwable -> L7b
                long r2 = r2 - r10
                r0.f3111b = r2     // Catch: java.lang.Throwable -> L7b
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L7b
                I4.i$c r0 = r0.f3119j
                r0.q()
                if (r13 == 0) goto L5e
                L4.e r13 = r12.f3122a     // Catch: java.lang.Throwable -> L5b
                long r0 = r13.size()     // Catch: java.lang.Throwable -> L5b
                int r13 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r13 != 0) goto L5e
                r13 = 1
            L59:
                r8 = r13
                goto L60
            L5b:
                r0 = move-exception
                r13 = r0
                goto L73
            L5e:
                r13 = 0
                goto L59
            L60:
                I4.i r13 = I4.i.this     // Catch: java.lang.Throwable -> L5b
                I4.f r6 = r13.f3113d     // Catch: java.lang.Throwable -> L5b
                int r7 = r13.f3112c     // Catch: java.lang.Throwable -> L5b
                L4.e r9 = r12.f3122a     // Catch: java.lang.Throwable -> L5b
                r6.k0(r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L5b
                I4.i r12 = I4.i.this
                I4.i$c r12 = r12.f3119j
                r12.z()
                return
            L73:
                I4.i r12 = I4.i.this
                I4.i$c r12 = r12.f3119j
                r12.z()
                throw r13
            L7b:
                r0 = move-exception
                r12 = r0
                goto L86
            L7e:
                I4.i r12 = I4.i.this     // Catch: java.lang.Throwable -> L7b
                I4.i$c r12 = r12.f3119j     // Catch: java.lang.Throwable -> L7b
                r12.z()     // Catch: java.lang.Throwable -> L7b
                throw r13     // Catch: java.lang.Throwable -> L7b
            L86:
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L7b
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: I4.i.a.a(boolean):void");
        }

        @Override // L4.w
        public z b() {
            return i.this.f3119j;
        }

        @Override // L4.w, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (i.this) {
                try {
                    if (this.f3124c) {
                        return;
                    }
                    if (!i.this.f3117h.f3125d) {
                        boolean z5 = this.f3122a.size() > 0;
                        if (this.f3123b != null) {
                            while (this.f3122a.size() > 0) {
                                a(false);
                            }
                            i iVar = i.this;
                            iVar.f3113d.l0(iVar.f3112c, true, D4.e.I(this.f3123b));
                        } else if (z5) {
                            while (this.f3122a.size() > 0) {
                                a(true);
                            }
                        } else {
                            i iVar2 = i.this;
                            iVar2.f3113d.k0(iVar2.f3112c, true, null, 0L);
                        }
                    }
                    synchronized (i.this) {
                        this.f3124c = true;
                    }
                    i.this.f3113d.flush();
                    i.this.b();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // L4.w, java.io.Flushable
        public void flush() throws IOException {
            synchronized (i.this) {
                i.this.c();
            }
            while (this.f3122a.size() > 0) {
                a(false);
                i.this.f3113d.flush();
            }
        }

        @Override // L4.w
        public void y0(L4.e eVar, long j5) throws IOException {
            this.f3122a.y0(eVar, j5);
            while (this.f3122a.size() >= 16384) {
                a(false);
            }
        }
    }

    private final class b implements y {

        /* renamed from: a, reason: collision with root package name */
        private final L4.e f3127a = new L4.e();

        /* renamed from: b, reason: collision with root package name */
        private final L4.e f3128b = new L4.e();

        /* renamed from: c, reason: collision with root package name */
        private final long f3129c;

        /* renamed from: d, reason: collision with root package name */
        private v f3130d;

        /* renamed from: e, reason: collision with root package name */
        boolean f3131e;

        /* renamed from: f, reason: collision with root package name */
        boolean f3132f;

        b(long j5) {
            this.f3129c = j5;
        }

        private void f(long j5) {
            i.this.f3113d.j0(j5);
        }

        @Override // L4.y
        public z b() {
            return i.this.f3118i;
        }

        void c(L4.g gVar, long j5) throws EOFException {
            boolean z5;
            boolean z6;
            long size;
            while (j5 > 0) {
                synchronized (i.this) {
                    z5 = this.f3132f;
                    z6 = this.f3128b.size() + j5 > this.f3129c;
                }
                if (z6) {
                    gVar.skip(j5);
                    i.this.f(I4.b.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z5) {
                    gVar.skip(j5);
                    return;
                }
                long jE = gVar.e(this.f3127a, j5);
                if (jE == -1) {
                    throw new EOFException();
                }
                j5 -= jE;
                synchronized (i.this) {
                    try {
                        if (this.f3131e) {
                            size = this.f3127a.size();
                            this.f3127a.u();
                        } else {
                            boolean z7 = this.f3128b.size() == 0;
                            this.f3128b.k0(this.f3127a);
                            if (z7) {
                                i.this.notifyAll();
                            }
                            size = 0;
                        }
                    } finally {
                    }
                }
                if (size > 0) {
                    f(size);
                }
            }
        }

        @Override // L4.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            long size;
            synchronized (i.this) {
                this.f3131e = true;
                size = this.f3128b.size();
                this.f3128b.u();
                i.this.notifyAll();
            }
            if (size > 0) {
                f(size);
            }
            i.this.b();
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0096  */
        @Override // L4.y
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public long e(L4.e r12, long r13) throws java.lang.Throwable {
            /*
                r11 = this;
                r0 = 0
                int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
                if (r2 < 0) goto Lac
            L6:
                I4.i r2 = I4.i.this
                monitor-enter(r2)
                I4.i r3 = I4.i.this     // Catch: java.lang.Throwable -> L83
                I4.i$c r3 = r3.f3118i     // Catch: java.lang.Throwable -> L83
                r3.q()     // Catch: java.lang.Throwable -> L83
                I4.i r3 = I4.i.this     // Catch: java.lang.Throwable -> L25
                I4.b r4 = r3.f3120k     // Catch: java.lang.Throwable -> L25
                if (r4 == 0) goto L28
                java.io.IOException r3 = r3.f3121l     // Catch: java.lang.Throwable -> L25
                if (r3 == 0) goto L1b
                goto L29
            L1b:
                I4.n r3 = new I4.n     // Catch: java.lang.Throwable -> L25
                I4.i r4 = I4.i.this     // Catch: java.lang.Throwable -> L25
                I4.b r4 = r4.f3120k     // Catch: java.lang.Throwable -> L25
                r3.<init>(r4)     // Catch: java.lang.Throwable -> L25
                goto L29
            L25:
                r12 = move-exception
                goto La2
            L28:
                r3 = 0
            L29:
                boolean r4 = r11.f3131e     // Catch: java.lang.Throwable -> L25
                if (r4 != 0) goto L9a
                L4.e r4 = r11.f3128b     // Catch: java.lang.Throwable -> L25
                long r4 = r4.size()     // Catch: java.lang.Throwable -> L25
                int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                r5 = -1
                if (r4 <= 0) goto L6f
                L4.e r4 = r11.f3128b     // Catch: java.lang.Throwable -> L25
                long r7 = r4.size()     // Catch: java.lang.Throwable -> L25
                long r13 = java.lang.Math.min(r13, r7)     // Catch: java.lang.Throwable -> L25
                long r12 = r4.e(r12, r13)     // Catch: java.lang.Throwable -> L25
                I4.i r14 = I4.i.this     // Catch: java.lang.Throwable -> L25
                long r7 = r14.f3110a     // Catch: java.lang.Throwable -> L25
                long r7 = r7 + r12
                r14.f3110a = r7     // Catch: java.lang.Throwable -> L25
                if (r3 != 0) goto L86
                I4.f r14 = r14.f3113d     // Catch: java.lang.Throwable -> L25
                I4.m r14 = r14.f3041t     // Catch: java.lang.Throwable -> L25
                int r14 = r14.d()     // Catch: java.lang.Throwable -> L25
                int r14 = r14 / 2
                long r9 = (long) r14     // Catch: java.lang.Throwable -> L25
                int r14 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r14 < 0) goto L86
                I4.i r14 = I4.i.this     // Catch: java.lang.Throwable -> L25
                I4.f r4 = r14.f3113d     // Catch: java.lang.Throwable -> L25
                int r7 = r14.f3112c     // Catch: java.lang.Throwable -> L25
                long r8 = r14.f3110a     // Catch: java.lang.Throwable -> L25
                r4.p0(r7, r8)     // Catch: java.lang.Throwable -> L25
                I4.i r14 = I4.i.this     // Catch: java.lang.Throwable -> L25
                r14.f3110a = r0     // Catch: java.lang.Throwable -> L25
                goto L86
            L6f:
                boolean r4 = r11.f3132f     // Catch: java.lang.Throwable -> L25
                if (r4 != 0) goto L85
                if (r3 != 0) goto L85
                I4.i r3 = I4.i.this     // Catch: java.lang.Throwable -> L25
                r3.q()     // Catch: java.lang.Throwable -> L25
                I4.i r3 = I4.i.this     // Catch: java.lang.Throwable -> L83
                I4.i$c r3 = r3.f3118i     // Catch: java.lang.Throwable -> L83
                r3.z()     // Catch: java.lang.Throwable -> L83
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L83
                goto L6
            L83:
                r11 = move-exception
                goto Laa
            L85:
                r12 = r5
            L86:
                I4.i r14 = I4.i.this     // Catch: java.lang.Throwable -> L83
                I4.i$c r14 = r14.f3118i     // Catch: java.lang.Throwable -> L83
                r14.z()     // Catch: java.lang.Throwable -> L83
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L83
                int r14 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
                if (r14 == 0) goto L96
                r11.f(r12)
                return r12
            L96:
                if (r3 != 0) goto L99
                return r5
            L99:
                throw r3
            L9a:
                java.io.IOException r12 = new java.io.IOException     // Catch: java.lang.Throwable -> L25
                java.lang.String r13 = "stream closed"
                r12.<init>(r13)     // Catch: java.lang.Throwable -> L25
                throw r12     // Catch: java.lang.Throwable -> L25
            La2:
                I4.i r11 = I4.i.this     // Catch: java.lang.Throwable -> L83
                I4.i$c r11 = r11.f3118i     // Catch: java.lang.Throwable -> L83
                r11.z()     // Catch: java.lang.Throwable -> L83
                throw r12     // Catch: java.lang.Throwable -> L83
            Laa:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L83
                throw r11
            Lac:
                java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r0 = "byteCount < 0: "
                r12.append(r0)
                r12.append(r13)
                java.lang.String r12 = r12.toString()
                r11.<init>(r12)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: I4.i.b.e(L4.e, long):long");
        }
    }

    class c extends L4.d {
        c() {
        }

        @Override // L4.d
        protected IOException u(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // L4.d
        protected void y() {
            i.this.f(I4.b.CANCEL);
            i.this.f3113d.Y();
        }

        public void z() throws IOException {
            if (r()) {
                throw u(null);
            }
        }
    }

    i(int i5, f fVar, boolean z5, boolean z6, @Nullable v vVar) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f3114e = arrayDeque;
        this.f3118i = new c();
        this.f3119j = new c();
        if (fVar == null) {
            throw new NullPointerException("connection == null");
        }
        this.f3112c = i5;
        this.f3113d = fVar;
        this.f3111b = fVar.f3042u.d();
        b bVar = new b(fVar.f3041t.d());
        this.f3116g = bVar;
        a aVar = new a();
        this.f3117h = aVar;
        bVar.f3132f = z6;
        aVar.f3125d = z5;
        if (vVar != null) {
            arrayDeque.add(vVar);
        }
        if (j() && vVar != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!j() && vVar == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    private boolean e(I4.b bVar, @Nullable IOException iOException) {
        synchronized (this) {
            try {
                if (this.f3120k != null) {
                    return false;
                }
                if (this.f3116g.f3132f && this.f3117h.f3125d) {
                    return false;
                }
                this.f3120k = bVar;
                this.f3121l = iOException;
                notifyAll();
                this.f3113d.X(this.f3112c);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void a(long j5) {
        this.f3111b += j5;
        if (j5 > 0) {
            notifyAll();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void b() {
        /*
            r2 = this;
            monitor-enter(r2)
            I4.i$b r0 = r2.f3116g     // Catch: java.lang.Throwable -> L16
            boolean r1 = r0.f3132f     // Catch: java.lang.Throwable -> L16
            if (r1 != 0) goto L1a
            boolean r0 = r0.f3131e     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L1a
            I4.i$a r0 = r2.f3117h     // Catch: java.lang.Throwable -> L16
            boolean r1 = r0.f3125d     // Catch: java.lang.Throwable -> L16
            if (r1 != 0) goto L18
            boolean r0 = r0.f3124c     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L1a
            goto L18
        L16:
            r0 = move-exception
            goto L33
        L18:
            r0 = 1
            goto L1b
        L1a:
            r0 = 0
        L1b:
            boolean r1 = r2.k()     // Catch: java.lang.Throwable -> L16
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L29
            I4.b r0 = I4.b.CANCEL
            r1 = 0
            r2.d(r0, r1)
            return
        L29:
            if (r1 != 0) goto L32
            I4.f r0 = r2.f3113d
            int r2 = r2.f3112c
            r0.X(r2)
        L32:
            return
        L33:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L16
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: I4.i.b():void");
    }

    void c() throws IOException {
        a aVar = this.f3117h;
        if (aVar.f3124c) {
            throw new IOException("stream closed");
        }
        if (aVar.f3125d) {
            throw new IOException("stream finished");
        }
        if (this.f3120k != null) {
            IOException iOException = this.f3121l;
            if (iOException == null) {
                throw new n(this.f3120k);
            }
        }
    }

    public void d(I4.b bVar, @Nullable IOException iOException) {
        if (e(bVar, iOException)) {
            this.f3113d.n0(this.f3112c, bVar);
        }
    }

    public void f(I4.b bVar) {
        if (e(bVar, null)) {
            this.f3113d.o0(this.f3112c, bVar);
        }
    }

    public int g() {
        return this.f3112c;
    }

    public w h() {
        synchronized (this) {
            try {
                if (!this.f3115f && !j()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.f3117h;
    }

    public y i() {
        return this.f3116g;
    }

    public boolean j() {
        return this.f3113d.f3022a == ((this.f3112c & 1) == 1);
    }

    public synchronized boolean k() {
        try {
            if (this.f3120k != null) {
                return false;
            }
            b bVar = this.f3116g;
            if (bVar.f3132f || bVar.f3131e) {
                a aVar = this.f3117h;
                if (aVar.f3125d || aVar.f3124c) {
                    if (this.f3115f) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public z l() {
        return this.f3118i;
    }

    void m(L4.g gVar, int i5) {
        this.f3116g.c(gVar, i5);
    }

    void n(v vVar, boolean z5) {
        boolean zK;
        synchronized (this) {
            try {
                if (this.f3115f && z5) {
                    this.f3116g.f3130d = vVar;
                } else {
                    this.f3115f = true;
                    this.f3114e.add(vVar);
                }
                if (z5) {
                    this.f3116g.f3132f = true;
                }
                zK = k();
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zK) {
            return;
        }
        this.f3113d.X(this.f3112c);
    }

    synchronized void o(I4.b bVar) {
        if (this.f3120k == null) {
            this.f3120k = bVar;
            notifyAll();
        }
    }

    public synchronized v p() throws IOException {
        this.f3118i.q();
        while (this.f3114e.isEmpty() && this.f3120k == null) {
            try {
                q();
            } catch (Throwable th) {
                this.f3118i.z();
                throw th;
            }
        }
        this.f3118i.z();
        if (this.f3114e.isEmpty()) {
            IOException iOException = this.f3121l;
            if (iOException != null) {
                throw iOException;
            }
            throw new n(this.f3120k);
        }
        return this.f3114e.removeFirst();
    }

    void q() throws InterruptedException, InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public z r() {
        return this.f3119j;
    }
}
