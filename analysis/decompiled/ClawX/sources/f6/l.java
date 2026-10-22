package f6;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2651e = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_next$volatile");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f2652f = AtomicLongFieldUpdater.newUpdater(l.class, "_state$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final androidx.emoji2.text.r f2653g = new androidx.emoji2.text.r("REMOVE_FROZEN", 1);
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f2654a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f2655b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2656c;
    public final /* synthetic */ AtomicReferenceArray d;

    public l(int i8, boolean z) {
        this.f2654a = i8;
        this.f2655b = z;
        int i9 = i8 - 1;
        this.f2656c = i9;
        this.d = new AtomicReferenceArray(i8);
        if (i9 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i8 & i9) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int a(Object obj) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f2652f;
            long j4 = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j4) != 0) {
                return (2305843009213693952L & j4) != 0 ? 2 : 1;
            }
            int i8 = (int) (1073741823 & j4);
            int i9 = (int) ((1152921503533105152L & j4) >> 30);
            int i10 = this.f2656c;
            if (((i9 + 2) & i10) == (i8 & i10)) {
                return 1;
            }
            boolean z = this.f2655b;
            AtomicReferenceArray atomicReferenceArray = this.d;
            if (z || atomicReferenceArray.get(i9 & i10) == null) {
                l lVar = this;
                if (f2652f.compareAndSet(lVar, j4, ((-1152921503533105153L) & j4) | (((i9 + 1) & 1073741823) << 30))) {
                    atomicReferenceArray.set(i9 & i10, obj);
                    l lVarC = lVar;
                    while ((atomicLongFieldUpdater.get(lVarC) & 1152921504606846976L) != 0) {
                        lVarC = lVarC.c();
                        AtomicReferenceArray atomicReferenceArray2 = lVarC.d;
                        int i11 = lVarC.f2656c & i9;
                        Object obj2 = atomicReferenceArray2.get(i11);
                        if ((obj2 instanceof k) && ((k) obj2).f2650a == i9) {
                            atomicReferenceArray2.set(i11, obj);
                        } else {
                            lVarC = null;
                        }
                        if (lVarC == null) {
                            return 0;
                        }
                    }
                    return 0;
                }
                this = lVar;
            } else {
                int i12 = this.f2654a;
                if (i12 < 1024 || ((i9 - i8) & 1073741823) > (i12 >> 1)) {
                    return 1;
                }
            }
        }
    }

    public final boolean b() {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f2652f;
            long j4 = atomicLongFieldUpdater.get(this);
            if ((j4 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j4) != 0) {
                return false;
            }
            l lVar = this;
            if (atomicLongFieldUpdater.compareAndSet(lVar, j4, 2305843009213693952L | j4)) {
                return true;
            }
            this = lVar;
        }
    }

    public final l c() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j4;
        l lVar;
        while (true) {
            atomicLongFieldUpdater = f2652f;
            j4 = atomicLongFieldUpdater.get(this);
            if ((j4 & 1152921504606846976L) != 0) {
                lVar = this;
                break;
            }
            long j8 = 1152921504606846976L | j4;
            lVar = this;
            if (atomicLongFieldUpdater.compareAndSet(lVar, j4, j8)) {
                j4 = j8;
                break;
            }
            this = lVar;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2651e;
            l lVar2 = (l) atomicReferenceFieldUpdater.get(lVar);
            if (lVar2 != null) {
                return lVar2;
            }
            l lVar3 = new l(lVar.f2654a * 2, lVar.f2655b);
            int i8 = (int) (1073741823 & j4);
            int i9 = (int) ((1152921503533105152L & j4) >> 30);
            while (true) {
                int i10 = lVar.f2656c;
                int i11 = i8 & i10;
                if (i11 == (i10 & i9)) {
                    break;
                }
                Object kVar = lVar.d.get(i11);
                if (kVar == null) {
                    kVar = new k(i8);
                }
                lVar3.d.set(lVar3.f2656c & i8, kVar);
                i8++;
            }
            atomicLongFieldUpdater.set(lVar3, (-1152921504606846977L) & j4);
            while (!atomicReferenceFieldUpdater.compareAndSet(lVar, null, lVar3) && atomicReferenceFieldUpdater.get(lVar) == null) {
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
            java.util.concurrent.atomic.AtomicLongFieldUpdater r6 = f6.l.f2652f
            long r2 = r6.get(r1)
            r7 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r4 = r2 & r7
            r9 = 0
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 == 0) goto L15
            androidx.emoji2.text.r r0 = f6.l.f2653g
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
            int r5 = r1.f2656c
            r4 = r4 & r5
            r13 = r0 & r5
            r14 = 0
            if (r4 != r13) goto L2e
            goto L41
        L2e:
            java.util.concurrent.atomic.AtomicReferenceArray r15 = r1.d
            java.lang.Object r4 = r15.get(r13)
            boolean r5 = r1.f2655b
            if (r4 != 0) goto L3b
            if (r5 == 0) goto L2
            goto L41
        L3b:
            r16 = r7
            boolean r7 = r4 instanceof f6.k
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
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = f6.l.f2652f
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
            f6.l r0 = r1.c()
            r1 = r0
            goto L96
        L7d:
            long r2 = r24 & r20
            long r26 = r2 | r7
            java.util.concurrent.atomic.AtomicLongFieldUpdater r22 = f6.l.f2652f
            r23 = r1
            boolean r1 = r22.compareAndSet(r23, r24, r26)
            r2 = r23
            if (r1 == 0) goto L99
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r2.d
            int r2 = r2.f2656c
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
        throw new UnsupportedOperationException("Method not decompiled: f6.l.d():java.lang.Object");
    }
}
