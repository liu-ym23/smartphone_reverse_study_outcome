package x4;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class s<E> {

    /* renamed from: e, reason: collision with root package name */
    public static final a f23878e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f23879f = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_next$volatile");

    /* renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f23880g = AtomicLongFieldUpdater.newUpdater(s.class, "_state$volatile");

    /* renamed from: h, reason: collision with root package name */
    public static final C1294F f23881h = new C1294F("REMOVE_FROZEN");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* renamed from: a, reason: collision with root package name */
    private final int f23882a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f23883b;

    /* renamed from: c, reason: collision with root package name */
    private final int f23884c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ AtomicReferenceArray f23885d;

    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        public final int a(long j5) {
            return (j5 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j5, int i5) {
            return d(j5, 1073741823L) | i5;
        }

        public final long c(long j5, int i5) {
            return d(j5, 1152921503533105152L) | (i5 << 30);
        }

        public final long d(long j5, long j6) {
            return j5 & (~j6);
        }

        private a() {
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f23886a;

        public b(int i5) {
            this.f23886a = i5;
        }
    }

    public s(int i5, boolean z5) {
        this.f23882a = i5;
        this.f23883b = z5;
        int i6 = i5 - 1;
        this.f23884c = i6;
        this.f23885d = new AtomicReferenceArray(i5);
        if (i6 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i5 & i6) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final s<E> b(long j5) {
        s<E> sVar = new s<>(this.f23882a * 2, this.f23883b);
        int i5 = (int) (1073741823 & j5);
        int i6 = (int) ((1152921503533105152L & j5) >> 30);
        while (true) {
            int i7 = this.f23884c;
            if ((i5 & i7) == (i7 & i6)) {
                f23880g.set(sVar, f23878e.d(j5, 1152921504606846976L));
                return sVar;
            }
            Object bVar = f().get(this.f23884c & i5);
            if (bVar == null) {
                bVar = new b(i5);
            }
            sVar.f().set(sVar.f23884c & i5, bVar);
            i5++;
        }
    }

    private final s<E> c(long j5) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f23879f;
        while (true) {
            s<E> sVar = (s) atomicReferenceFieldUpdater.get(this);
            if (sVar != null) {
                return sVar;
            }
            f23879f.compareAndSet(this, null, b(j5));
        }
    }

    private final s<E> e(int i5, E e6) {
        Object obj = f().get(this.f23884c & i5);
        if (!(obj instanceof b) || ((b) obj).f23886a != i5) {
            return null;
        }
        f().set(i5 & this.f23884c, e6);
        return this;
    }

    private final /* synthetic */ AtomicReferenceArray f() {
        return this.f23885d;
    }

    private final long k() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f23880g;
        while (true) {
            long j5 = atomicLongFieldUpdater.get(this);
            if ((j5 & 1152921504606846976L) != 0) {
                return j5;
            }
            long j6 = 1152921504606846976L | j5;
            s<E> sVar = this;
            if (atomicLongFieldUpdater.compareAndSet(sVar, j5, j6)) {
                return j6;
            }
            this = sVar;
        }
    }

    private final s<E> n(int i5, int i6) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f23880g;
        while (true) {
            long j5 = atomicLongFieldUpdater.get(this);
            int i7 = (int) (1073741823 & j5);
            if ((1152921504606846976L & j5) != 0) {
                return this.l();
            }
            s<E> sVar = this;
            if (f23880g.compareAndSet(sVar, j5, f23878e.b(j5, i6))) {
                sVar.f().set(sVar.f23884c & i7, null);
                return null;
            }
            this = sVar;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(E r13) {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = i()
        L4:
            long r3 = r0.get(r12)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            r7 = 0
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L18
            x4.s$a r12 = x4.s.f23878e
            int r12 = r12.a(r3)
            return r12
        L18:
            r1 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r3
            int r1 = (int) r1
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r2 = 30
            long r5 = r5 >> r2
            int r9 = (int) r5
            int r10 = r12.f23884c
            int r2 = r9 + 2
            r2 = r2 & r10
            r5 = r1 & r10
            r6 = 1
            if (r2 != r5) goto L32
            return r6
        L32:
            boolean r2 = r12.f23883b
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r2 != 0) goto L53
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r12.f()
            r11 = r9 & r10
            java.lang.Object r2 = r2.get(r11)
            if (r2 == 0) goto L53
            int r2 = r12.f23882a
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 < r3) goto L52
            int r9 = r9 - r1
            r1 = r9 & r5
            int r2 = r2 >> 1
            if (r1 <= r2) goto L4
        L52:
            return r6
        L53:
            int r1 = r9 + 1
            r1 = r1 & r5
            r2 = r1
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = i()
            x4.s$a r5 = x4.s.f23878e
            long r5 = r5.c(r3, r2)
            r2 = r12
            boolean r12 = r1.compareAndSet(r2, r3, r5)
            if (r12 == 0) goto L8d
            java.util.concurrent.atomic.AtomicReferenceArray r12 = r2.f()
            r0 = r9 & r10
            r12.set(r0, r13)
            r12 = r2
        L72:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = i()
            long r0 = r0.get(r12)
            r2 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r0 = r0 & r2
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 == 0) goto L8b
            x4.s r12 = r12.l()
            x4.s r12 = r12.e(r9, r13)
            if (r12 != 0) goto L72
        L8b:
            r12 = 0
            return r12
        L8d:
            r12 = r2
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.s.a(java.lang.Object):int");
    }

    public final boolean d() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f23880g;
        while (true) {
            long j5 = atomicLongFieldUpdater.get(this);
            if ((j5 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j5) != 0) {
                return false;
            }
            s<E> sVar = this;
            if (atomicLongFieldUpdater.compareAndSet(sVar, j5, 2305843009213693952L | j5)) {
                return true;
            }
            this = sVar;
        }
    }

    public final int g() {
        long j5 = f23880g.get(this);
        return 1073741823 & (((int) ((j5 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j5)));
    }

    public final boolean j() {
        long j5 = f23880g.get(this);
        return ((int) (1073741823 & j5)) == ((int) ((j5 & 1152921503533105152L) >> 30));
    }

    public final s<E> l() {
        return c(k());
    }

    public final Object m() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f23880g;
        while (true) {
            long j5 = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j5) != 0) {
                return f23881h;
            }
            int i5 = (int) (1073741823 & j5);
            int i6 = this.f23884c;
            if ((((int) ((1152921503533105152L & j5) >> 30)) & i6) == (i6 & i5)) {
                return null;
            }
            Object obj = this.f().get(this.f23884c & i5);
            if (obj == null) {
                if (this.f23883b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i7 = (i5 + 1) & 1073741823;
                s<E> sVar = this;
                if (f23880g.compareAndSet(sVar, j5, f23878e.b(j5, i7))) {
                    sVar.f().set(sVar.f23884c & i5, null);
                    return obj;
                }
                if (sVar.f23883b) {
                    s<E> sVarN = sVar;
                    do {
                        sVarN = sVarN.n(i5, i7);
                    } while (sVarN != null);
                    return obj;
                }
                this = sVar;
            }
        }
    }
}
