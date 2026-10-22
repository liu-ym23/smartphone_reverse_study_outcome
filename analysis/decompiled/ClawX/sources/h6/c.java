package h6;

import a6.i0;
import a6.w;
import androidx.emoji2.text.r;
import f6.o;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c implements Executor, Closeable {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f3049h = AtomicLongFieldUpdater.newUpdater(c.class, "parkedWorkersStack$volatile");

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f3050j = AtomicLongFieldUpdater.newUpdater(c.class, "controlState$volatile");

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f3051k = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isTerminated$volatile");

    /* renamed from: l, reason: collision with root package name */
    public static final r f3052l = new r("NOT_IN_STACK", 1);
    private volatile /* synthetic */ int _isTerminated$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f3053a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3054b;

    /* renamed from: c, reason: collision with root package name */
    public final long f3055c;
    private volatile /* synthetic */ long controlState$volatile;
    public final String d;

    /* renamed from: e, reason: collision with root package name */
    public final f f3056e;

    /* renamed from: f, reason: collision with root package name */
    public final f f3057f;

    /* renamed from: g, reason: collision with root package name */
    public final o f3058g;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    public c(int i8, int i9, long j4, String str) {
        this.f3053a = i8;
        this.f3054b = i9;
        this.f3055c = j4;
        this.d = str;
        if (i8 < 1) {
            throw new IllegalArgumentException(a8.b.k(i8, "Core pool size ", " should be at least 1").toString());
        }
        if (i9 < i8) {
            throw new IllegalArgumentException(a8.b.i(i9, i8, "Max pool size ", " should be greater than or equals to core pool size ").toString());
        }
        if (i9 > 2097150) {
            throw new IllegalArgumentException(a8.b.k(i9, "Max pool size ", " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j4 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j4 + " must be positive").toString());
        }
        this.f3056e = new f();
        this.f3057f = new f();
        this.f3058g = new o((i8 + 1) * 2);
        this.controlState$volatile = i8 << 42;
    }

    public static /* synthetic */ void e(c cVar, Runnable runnable, int i8) {
        cVar.b(runnable, false, (i8 & 4) == 0);
    }

    public final int a() {
        synchronized (this.f3058g) {
            try {
                if (f3051k.get(this) == 1) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f3050j;
                long j4 = atomicLongFieldUpdater.get(this);
                int i8 = (int) (j4 & 2097151);
                int i9 = i8 - ((int) ((j4 & 4398044413952L) >> 21));
                if (i9 < 0) {
                    i9 = 0;
                }
                if (i9 >= this.f3053a) {
                    return 0;
                }
                if (i8 >= this.f3054b) {
                    return 0;
                }
                int i10 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i10 <= 0 || this.f3058g.b(i10) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                a aVar = new a(this, i10);
                this.f3058g.c(i10, aVar);
                if (i10 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i11 = i9 + 1;
                aVar.start();
                return i11;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(Runnable runnable, boolean z, boolean z2) {
        i jVar;
        b bVar;
        k.f3069f.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof i) {
            jVar = (i) runnable;
            jVar.f3062a = jNanoTime;
            jVar.f3063b = z;
        } else {
            jVar = new j(runnable, jNanoTime, z);
        }
        boolean z8 = jVar.f3063b;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f3050j;
        long jAddAndGet = z8 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        a aVar = threadCurrentThread instanceof a ? (a) threadCurrentThread : null;
        if (aVar == null || !p.a(aVar.f3043h, this)) {
            aVar = null;
        }
        if (aVar != null && (bVar = aVar.f3039c) != b.f3047e && (jVar.f3063b || bVar != b.f3045b)) {
            aVar.f3042g = true;
            m mVar = aVar.f3037a;
            if (z2) {
                jVar = mVar.a(jVar);
            } else {
                mVar.getClass();
                i iVar = (i) m.f3071b.getAndSet(mVar, jVar);
                jVar = iVar == null ? null : mVar.a(iVar);
            }
        }
        if (jVar != null) {
            if (!(jVar.f3063b ? this.f3057f.a(jVar) : this.f3056e.a(jVar))) {
                throw new RejectedExecutionException(m0.f.f(new StringBuilder(), this.d, " was terminated"));
            }
        }
        if (z8) {
            if (l() || j(jAddAndGet)) {
                return;
            }
            l();
            return;
        }
        if (l() || j(atomicLongFieldUpdater.get(this))) {
            return;
        }
        l();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x008a  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void close() throws java.lang.InterruptedException {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = h6.c.f3051k
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof h6.a
            r3 = 0
            if (r1 == 0) goto L17
            h6.a r0 = (h6.a) r0
            goto L18
        L17:
            r0 = r3
        L18:
            if (r0 == 0) goto L23
            h6.c r1 = r0.f3043h
            boolean r1 = kotlin.jvm.internal.p.a(r1, r8)
            if (r1 == 0) goto L23
            goto L24
        L23:
            r0 = r3
        L24:
            f6.o r1 = r8.f3058g
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = h6.c.f3050j     // Catch: java.lang.Throwable -> Lc3
            long r4 = r4.get(r8)     // Catch: java.lang.Throwable -> Lc3
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r4 = (int) r4
            monitor-exit(r1)
            if (r2 > r4) goto L78
            r1 = r2
        L36:
            f6.o r5 = r8.f3058g
            java.lang.Object r5 = r5.b(r1)
            kotlin.jvm.internal.p.b(r5)
            h6.a r5 = (h6.a) r5
            if (r5 == r0) goto L73
        L43:
            java.lang.Thread$State r6 = r5.getState()
            java.lang.Thread$State r7 = java.lang.Thread.State.TERMINATED
            if (r6 == r7) goto L54
            java.util.concurrent.locks.LockSupport.unpark(r5)
            r6 = 10000(0x2710, double:4.9407E-320)
            r5.join(r6)
            goto L43
        L54:
            h6.m r5 = r5.f3037a
            h6.f r6 = r8.f3057f
            r5.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = h6.m.f3071b
            java.lang.Object r7 = r7.getAndSet(r5, r3)
            h6.i r7 = (h6.i) r7
            if (r7 == 0) goto L68
            r6.a(r7)
        L68:
            h6.i r7 = r5.b()
            if (r7 != 0) goto L6f
            goto L73
        L6f:
            r6.a(r7)
            goto L68
        L73:
            if (r1 == r4) goto L78
            int r1 = r1 + 1
            goto L36
        L78:
            h6.f r1 = r8.f3057f
            r1.b()
            h6.f r1 = r8.f3056e
            r1.b()
        L82:
            if (r0 == 0) goto L8a
            h6.i r1 = r0.a(r2)
            if (r1 != 0) goto Lb2
        L8a:
            h6.f r1 = r8.f3056e
            java.lang.Object r1 = r1.d()
            h6.i r1 = (h6.i) r1
            if (r1 != 0) goto Lb2
            h6.f r1 = r8.f3057f
            java.lang.Object r1 = r1.d()
            h6.i r1 = (h6.i) r1
            if (r1 != 0) goto Lb2
            if (r0 == 0) goto La5
            h6.b r1 = h6.b.f3047e
            r0.h(r1)
        La5:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = h6.c.f3049h
            r1 = 0
            r0.set(r8, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = h6.c.f3050j
            r0.set(r8, r1)
            return
        Lb2:
            r1.run()     // Catch: java.lang.Throwable -> Lb6
            goto L82
        Lb6:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()
            r4.uncaughtException(r3, r1)
            goto L82
        Lc3:
            r8 = move-exception
            monitor-exit(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: h6.c.close():void");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        e(this, runnable, 6);
    }

    public final void g(a aVar, int i8, int i9) {
        while (true) {
            long j4 = f3049h.get(this);
            int i10 = (int) (2097151 & j4);
            long j8 = (2097152 + j4) & (-2097152);
            if (i10 == i8) {
                if (i9 == 0) {
                    Object objC = aVar.c();
                    while (true) {
                        if (objC == f3052l) {
                            i10 = -1;
                            break;
                        }
                        if (objC == null) {
                            i10 = 0;
                            break;
                        }
                        a aVar2 = (a) objC;
                        int iB = aVar2.b();
                        if (iB != 0) {
                            i10 = iB;
                            break;
                        }
                        objC = aVar2.c();
                    }
                } else {
                    i10 = i9;
                }
            }
            if (i10 >= 0) {
                c cVar = this;
                if (f3049h.compareAndSet(cVar, j4, i10 | j8)) {
                    return;
                } else {
                    this = cVar;
                }
            }
        }
    }

    public final boolean j(long j4) {
        int i8 = ((int) (2097151 & j4)) - ((int) ((j4 & 4398044413952L) >> 21));
        if (i8 < 0) {
            i8 = 0;
        }
        int i9 = this.f3053a;
        if (i8 < i9) {
            int iA = a();
            if (iA == 1 && i9 > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean l() {
        c cVar;
        r rVar;
        int iB;
        while (true) {
            long j4 = f3049h.get(this);
            a aVar = (a) this.f3058g.b((int) (2097151 & j4));
            if (aVar == null) {
                aVar = null;
                cVar = this;
            } else {
                long j8 = (2097152 + j4) & (-2097152);
                Object objC = aVar.c();
                while (true) {
                    rVar = f3052l;
                    if (objC == rVar) {
                        iB = -1;
                        break;
                    }
                    if (objC == null) {
                        iB = 0;
                        break;
                    }
                    a aVar2 = (a) objC;
                    iB = aVar2.b();
                    if (iB != 0) {
                        break;
                    }
                    objC = aVar2.c();
                    j4 = j4;
                }
                if (iB >= 0) {
                    c cVar2 = this;
                    boolean zCompareAndSet = f3049h.compareAndSet(cVar2, j4, iB | j8);
                    cVar = cVar2;
                    if (zCompareAndSet) {
                        aVar.g(rVar);
                    }
                    this = cVar;
                } else {
                    continue;
                }
            }
            if (aVar == null) {
                return false;
            }
            if (a.f3036j.compareAndSet(aVar, -1, 0)) {
                LockSupport.unpark(aVar);
                return true;
            }
            this = cVar;
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        o oVar = this.f3058g;
        int iA = oVar.a();
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 1; i13 < iA; i13++) {
            a aVar = (a) oVar.b(i13);
            if (aVar != null) {
                m mVar = aVar.f3037a;
                mVar.getClass();
                int i14 = m.f3071b.get(mVar) != null ? (m.f3072c.get(mVar) - m.d.get(mVar)) + 1 : m.f3072c.get(mVar) - m.d.get(mVar);
                int iOrdinal = aVar.f3039c.ordinal();
                if (iOrdinal == 0) {
                    i8++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i14);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iOrdinal == 1) {
                    i9++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i14);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iOrdinal == 2) {
                    i10++;
                } else if (iOrdinal == 3) {
                    i11++;
                    if (i14 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i14);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else {
                    if (iOrdinal != 4) {
                        throw new w();
                    }
                    i12++;
                }
            }
        }
        long j4 = f3050j.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.d);
        sb4.append('@');
        sb4.append(i0.k(this));
        sb4.append("[Pool Size {core = ");
        int i15 = this.f3053a;
        sb4.append(i15);
        sb4.append(", max = ");
        a8.b.z(sb4, this.f3054b, "}, Worker States {CPU = ", i8, ", blocking = ");
        a8.b.z(sb4, i9, ", parked = ", i10, ", dormant = ");
        a8.b.z(sb4, i11, ", terminated = ", i12, "}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.f3056e.c());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.f3057f.c());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j4));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j4) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i15 - ((int) ((j4 & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }
}
