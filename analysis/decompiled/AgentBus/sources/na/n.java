package na;

import f8.x;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6916e = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_next$volatile");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f6917f = AtomicLongFieldUpdater.newUpdater(n.class, "_state$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final x f6918g = new x("REMOVE_FROZEN", 3);
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f6919a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f6920b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6921c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f6922d;

    public n(int i2, boolean z4) {
        this.f6919a = i2;
        this.f6920b = z4;
        int i10 = i2 - 1;
        this.f6921c = i10;
        this.f6922d = new AtomicReferenceArray(i2);
        if (i10 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i2 & i10) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int a(Object obj) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f6917f;
            long j2 = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j2) != 0) {
                return (2305843009213693952L & j2) != 0 ? 2 : 1;
            }
            int i2 = (int) (1073741823 & j2);
            int i10 = (int) ((1152921503533105152L & j2) >> 30);
            int i11 = this.f6921c;
            if (((i10 + 2) & i11) == (i2 & i11)) {
                return 1;
            }
            boolean z4 = this.f6920b;
            AtomicReferenceArray atomicReferenceArray = this.f6922d;
            if (z4 || atomicReferenceArray.get(i10 & i11) == null) {
                n nVar = this;
                if (f6917f.compareAndSet(nVar, j2, ((-1152921503533105153L) & j2) | (((i10 + 1) & 1073741823) << 30))) {
                    atomicReferenceArray.set(i10 & i11, obj);
                    n nVarC = nVar;
                    while ((atomicLongFieldUpdater.get(nVarC) & 1152921504606846976L) != 0) {
                        nVarC = nVarC.c();
                        AtomicReferenceArray atomicReferenceArray2 = nVarC.f6922d;
                        int i12 = nVarC.f6921c & i10;
                        Object obj2 = atomicReferenceArray2.get(i12);
                        if ((obj2 instanceof m) && ((m) obj2).f6915a == i10) {
                            atomicReferenceArray2.set(i12, obj);
                        } else {
                            nVarC = null;
                        }
                        if (nVarC == null) {
                            return 0;
                        }
                    }
                    return 0;
                }
                this = nVar;
            } else {
                int i13 = this.f6919a;
                if (i13 < 1024 || ((i10 - i2) & 1073741823) > (i13 >> 1)) {
                    return 1;
                }
            }
        }
    }

    public final boolean b() {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f6917f;
            long j2 = atomicLongFieldUpdater.get(this);
            if ((j2 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j2) != 0) {
                return false;
            }
            n nVar = this;
            if (atomicLongFieldUpdater.compareAndSet(nVar, j2, 2305843009213693952L | j2)) {
                return true;
            }
            this = nVar;
        }
    }

    public final n c() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j2;
        n nVar;
        while (true) {
            atomicLongFieldUpdater = f6917f;
            j2 = atomicLongFieldUpdater.get(this);
            if ((j2 & 1152921504606846976L) != 0) {
                nVar = this;
                break;
            }
            long j4 = 1152921504606846976L | j2;
            nVar = this;
            if (atomicLongFieldUpdater.compareAndSet(nVar, j2, j4)) {
                j2 = j4;
                break;
            }
            this = nVar;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6916e;
            n nVar2 = (n) atomicReferenceFieldUpdater.get(nVar);
            if (nVar2 != null) {
                return nVar2;
            }
            n nVar3 = new n(nVar.f6919a * 2, nVar.f6920b);
            int i2 = (int) (1073741823 & j2);
            int i10 = (int) ((1152921503533105152L & j2) >> 30);
            while (true) {
                int i11 = nVar.f6921c;
                int i12 = i2 & i11;
                if (i12 == (i11 & i10)) {
                    break;
                }
                Object mVar = nVar.f6922d.get(i12);
                if (mVar == null) {
                    mVar = new m(i2);
                }
                nVar3.f6922d.set(nVar3.f6921c & i2, mVar);
                i2++;
            }
            atomicLongFieldUpdater.set(nVar3, (-1152921504606846977L) & j2);
            while (!atomicReferenceFieldUpdater.compareAndSet(nVar, null, nVar3) && atomicReferenceFieldUpdater.get(nVar) == null) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d() {
        /*
            r30 = this;
            r1 = r30
        L2:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r6 = na.n.f6917f
            long r2 = r6.get(r1)
            r7 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r4 = r2 & r7
            r9 = 0
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 == 0) goto L15
            f8.x r0 = na.n.f6918g
            return r0
        L15:
            r11 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r4 = r2 & r11
            int r0 = (int) r4
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r13 = 30
            long r4 = r4 >> r13
            int r4 = (int) r4
            int r5 = r1.f6921c
            r4 = r4 & r5
            r13 = r0 & r5
            r14 = 0
            if (r4 != r13) goto L2e
            goto L41
        L2e:
            java.util.concurrent.atomic.AtomicReferenceArray r15 = r1.f6922d
            java.lang.Object r4 = r15.get(r13)
            boolean r5 = r1.f6920b
            if (r4 != 0) goto L3b
            if (r5 == 0) goto L2
            goto L41
        L3b:
            r16 = r7
            boolean r7 = r4 instanceof na.m
            if (r7 == 0) goto L42
        L41:
            return r14
        L42:
            int r0 = r0 + 1
            r7 = 1073741823(0x3fffffff, float:1.9999999)
            r0 = r0 & r7
            r7 = -1073741824(0xffffffffc0000000, double:NaN)
            long r18 = r2 & r7
            r20 = r7
            long r7 = (long) r0
            long r18 = r18 | r7
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = na.n.f6917f
            r28 = r18
            r18 = r4
            r19 = r5
            r4 = r28
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L66
            r15.set(r13, r14)
            return r18
        L66:
            r1 = r30
            if (r19 == 0) goto L2
        L6a:
            long r24 = r6.get(r1)
            long r2 = r24 & r11
            int r0 = (int) r2
            long r2 = r24 & r16
            int r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r2 == 0) goto L7d
            na.n r0 = r1.c()
            r1 = r0
            goto L96
        L7d:
            long r2 = r24 & r20
            long r26 = r2 | r7
            java.util.concurrent.atomic.AtomicLongFieldUpdater r22 = na.n.f6917f
            r23 = r1
            boolean r1 = r22.compareAndSet(r23, r24, r26)
            r2 = r23
            if (r1 == 0) goto L99
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r2.f6922d
            int r2 = r2.f6921c
            r0 = r0 & r2
            r1.set(r0, r14)
            r1 = r14
        L96:
            if (r1 != 0) goto L6a
            return r18
        L99:
            r1 = r2
            goto L6a
        */
        throw new UnsupportedOperationException("Method not decompiled: na.n.d():java.lang.Object");
    }
}
