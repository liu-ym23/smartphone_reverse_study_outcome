package d3;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class p {

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f12470e = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_next");

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f12471f = AtomicLongFieldUpdater.newUpdater(p.class, "_state");

    /* renamed from: g, reason: collision with root package name */
    public static final X.r f12472g = new X.r("REMOVE_FROZEN", 4);

    @Volatile
    @Nullable
    private volatile Object _next;

    @Volatile
    private volatile long _state;

    /* renamed from: a, reason: collision with root package name */
    public final int f12473a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f12474b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12475c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReferenceArray f12476d;

    public p(int i4, boolean z4) {
        this.f12473a = i4;
        this.f12474b = z4;
        int i5 = i4 - 1;
        this.f12475c = i5;
        this.f12476d = new AtomicReferenceArray(i4);
        if (i5 > 1073741823) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if ((i4 & i5) != 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0050, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Object r14) {
        /*
            r13 = this;
        L0:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = d3.p.f12471f
            long r3 = r0.get(r13)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            r7 = 0
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            r2 = 1
            if (r1 == 0) goto L19
            r13 = 2305843009213693952(0x2000000000000000, double:1.4916681462400413E-154)
            long r13 = r13 & r3
            int r13 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r13 == 0) goto L18
            r2 = 2
        L18:
            return r2
        L19:
            r5 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r5 = r5 & r3
            int r1 = (int) r5
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r9 = 30
            long r5 = r5 >> r9
            int r10 = (int) r5
            int r5 = r10 + 2
            int r11 = r13.f12475c
            r5 = r5 & r11
            r6 = r1 & r11
            if (r5 != r6) goto L32
            return r2
        L32:
            boolean r5 = r13.f12474b
            r6 = 1073741823(0x3fffffff, float:1.9999999)
            java.util.concurrent.atomic.AtomicReferenceArray r12 = r13.f12476d
            if (r5 != 0) goto L51
            r5 = r10 & r11
            java.lang.Object r5 = r12.get(r5)
            if (r5 == 0) goto L51
            r0 = 1024(0x400, float:1.435E-42)
            int r3 = r13.f12473a
            if (r3 < r0) goto L50
            int r10 = r10 - r1
            r0 = r10 & r6
            int r1 = r3 >> 1
            if (r0 <= r1) goto L0
        L50:
            return r2
        L51:
            int r1 = r10 + 1
            r1 = r1 & r6
            r5 = -1152921503533105153(0xf00000003fffffff, double:-3.1050369248997324E231)
            long r5 = r5 & r3
            long r1 = (long) r1
            long r1 = r1 << r9
            long r5 = r5 | r1
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = d3.p.f12471f
            r2 = r13
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L0
            r1 = r10 & r11
            r12.set(r1, r14)
        L6b:
            long r1 = r0.get(r13)
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L94
            d3.p r13 = r13.c()
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r13.f12476d
            int r2 = r13.f12475c
            r2 = r2 & r10
            java.lang.Object r3 = r1.get(r2)
            boolean r4 = r3 instanceof d3.o
            if (r4 == 0) goto L91
            d3.o r3 = (d3.o) r3
            int r3 = r3.f12469a
            if (r3 != r10) goto L91
            r1.set(r2, r14)
            goto L92
        L91:
            r13 = 0
        L92:
            if (r13 != 0) goto L6b
        L94:
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: d3.p.a(java.lang.Object):int");
    }

    public final boolean b() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j4;
        do {
            atomicLongFieldUpdater = f12471f;
            j4 = atomicLongFieldUpdater.get(this);
            if ((j4 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j4) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j4, 2305843009213693952L | j4));
        return true;
    }

    public final p c() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j4;
        while (true) {
            atomicLongFieldUpdater = f12471f;
            j4 = atomicLongFieldUpdater.get(this);
            if ((j4 & 1152921504606846976L) != 0) {
                break;
            }
            long j5 = j4 | 1152921504606846976L;
            if (atomicLongFieldUpdater.compareAndSet(this, j4, j5)) {
                j4 = j5;
                break;
            }
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12470e;
            p pVar = (p) atomicReferenceFieldUpdater.get(this);
            if (pVar != null) {
                return pVar;
            }
            p pVar2 = new p(this.f12473a * 2, this.f12474b);
            int i4 = (int) (1073741823 & j4);
            int i5 = (int) ((1152921503533105152L & j4) >> 30);
            while (true) {
                int i6 = this.f12475c;
                int i7 = i4 & i6;
                if (i7 != (i6 & i5)) {
                    Object oVar = this.f12476d.get(i7);
                    if (oVar == null) {
                        oVar = new o(i4);
                    }
                    pVar2.f12476d.set(pVar2.f12475c & i4, oVar);
                    i4++;
                }
            }
            atomicLongFieldUpdater.set(pVar2, (-1152921504606846977L) & j4);
            atomicReferenceFieldUpdater.compareAndSet(this, null, pVar2);
        }
    }

    public final Object d() {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f12471f;
            long j4 = atomicLongFieldUpdater.get(this);
            if ((j4 & 1152921504606846976L) != 0) {
                return f12472g;
            }
            int i4 = (int) (j4 & 1073741823);
            int i5 = this.f12475c;
            int i6 = i4 & i5;
            if ((((int) ((1152921503533105152L & j4) >> 30)) & i5) == i6) {
                return null;
            }
            AtomicReferenceArray atomicReferenceArray = this.f12476d;
            Object obj = atomicReferenceArray.get(i6);
            boolean z4 = this.f12474b;
            if (obj == null) {
                if (z4) {
                    return null;
                }
            } else {
                if (obj instanceof o) {
                    return null;
                }
                long j5 = (i4 + 1) & 1073741823;
                if (atomicLongFieldUpdater.compareAndSet(this, j4, (j4 & (-1073741824)) | j5)) {
                    atomicReferenceArray.set(i6, null);
                    return obj;
                }
                if (z4) {
                    p pVarC = this;
                    while (true) {
                        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f12471f;
                        long j6 = atomicLongFieldUpdater2.get(pVarC);
                        int i7 = (int) (j6 & 1073741823);
                        if ((j6 & 1152921504606846976L) != 0) {
                            pVarC = pVarC.c();
                        } else {
                            if (atomicLongFieldUpdater2.compareAndSet(pVarC, j6, (j6 & (-1073741824)) | j5)) {
                                pVarC.f12476d.set(pVarC.f12475c & i7, null);
                                pVarC = null;
                            } else {
                                continue;
                            }
                        }
                        if (pVarC == null) {
                            return obj;
                        }
                    }
                }
            }
        }
    }
}
