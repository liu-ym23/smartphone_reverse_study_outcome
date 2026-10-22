package s9;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes4.dex */
public final class j {
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_next$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(j.class, "_state$volatile");
    public static final a5.d g = new a5.d("REMOVE_FROZEN", 6);
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f6002a;
    public final boolean b;
    public final int c;
    public final /* synthetic */ AtomicReferenceArray d;

    public j(int i, boolean z10) {
        this.f6002a = i;
        this.b = z10;
        int i6 = i - 1;
        this.c = i6;
        this.d = new AtomicReferenceArray(i);
        if (i6 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i & i6) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int a(Object obj) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f;
            long j5 = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j5) != 0) {
                return (2305843009213693952L & j5) != 0 ? 2 : 1;
            }
            int i = (int) (1073741823 & j5);
            int i6 = (int) ((1152921503533105152L & j5) >> 30);
            int i10 = this.c;
            if (((i6 + 2) & i10) == (i & i10)) {
                return 1;
            }
            boolean z10 = this.b;
            AtomicReferenceArray atomicReferenceArray = this.d;
            if (z10 || atomicReferenceArray.get(i6 & i10) == null) {
                j jVar = this;
                if (f.compareAndSet(jVar, j5, ((-1152921503533105153L) & j5) | (((i6 + 1) & 1073741823) << 30))) {
                    atomicReferenceArray.set(i6 & i10, obj);
                    j jVarC = jVar;
                    while ((atomicLongFieldUpdater.get(jVarC) & 1152921504606846976L) != 0) {
                        jVarC = jVarC.c();
                        AtomicReferenceArray atomicReferenceArray2 = jVarC.d;
                        int i11 = jVarC.c & i6;
                        Object obj2 = atomicReferenceArray2.get(i11);
                        if ((obj2 instanceof i) && ((i) obj2).f6001a == i6) {
                            atomicReferenceArray2.set(i11, obj);
                        } else {
                            jVarC = null;
                        }
                        if (jVarC == null) {
                            return 0;
                        }
                    }
                    return 0;
                }
                this = jVar;
            } else {
                int i12 = this.f6002a;
                if (i12 < 1024 || ((i6 - i) & 1073741823) > (i12 >> 1)) {
                    return 1;
                }
            }
        }
    }

    public final boolean b() {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f;
            long j5 = atomicLongFieldUpdater.get(this);
            if ((j5 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j5) != 0) {
                return false;
            }
            j jVar = this;
            if (atomicLongFieldUpdater.compareAndSet(jVar, j5, 2305843009213693952L | j5)) {
                return true;
            }
            this = jVar;
        }
    }

    public final j c() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j5;
        j jVar;
        while (true) {
            atomicLongFieldUpdater = f;
            j5 = atomicLongFieldUpdater.get(this);
            if ((j5 & 1152921504606846976L) != 0) {
                jVar = this;
                break;
            }
            long j6 = 1152921504606846976L | j5;
            jVar = this;
            if (atomicLongFieldUpdater.compareAndSet(jVar, j5, j6)) {
                j5 = j6;
                break;
            }
            this = jVar;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
            j jVar2 = (j) atomicReferenceFieldUpdater.get(jVar);
            if (jVar2 != null) {
                return jVar2;
            }
            j jVar3 = new j(jVar.f6002a * 2, jVar.b);
            int i = (int) (1073741823 & j5);
            int i6 = (int) ((1152921503533105152L & j5) >> 30);
            while (true) {
                int i10 = jVar.c;
                int i11 = i & i10;
                if (i11 != (i10 & i6)) {
                    Object iVar = jVar.d.get(i11);
                    if (iVar == null) {
                        iVar = new i(i);
                    }
                    jVar3.d.set(jVar3.c & i, iVar);
                    i++;
                }
            }
            atomicLongFieldUpdater.set(jVar3, (-1152921504606846977L) & j5);
            atomicReferenceFieldUpdater.compareAndSet(jVar, null, jVar3);
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
            java.util.concurrent.atomic.AtomicLongFieldUpdater r6 = s9.j.f
            long r2 = r6.get(r1)
            r7 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r4 = r2 & r7
            r9 = 0
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 == 0) goto L15
            a5.d r0 = s9.j.g
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
            int r5 = r1.c
            r4 = r4 & r5
            r13 = r0 & r5
            r14 = 0
            if (r4 != r13) goto L2e
            goto L41
        L2e:
            java.util.concurrent.atomic.AtomicReferenceArray r15 = r1.d
            java.lang.Object r4 = r15.get(r13)
            boolean r5 = r1.b
            if (r4 != 0) goto L3b
            if (r5 == 0) goto L2
            goto L41
        L3b:
            r16 = r7
            boolean r7 = r4 instanceof s9.i
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
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = s9.j.f
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
            s9.j r0 = r1.c()
            r1 = r0
            goto L96
        L7d:
            long r2 = r24 & r20
            long r26 = r2 | r7
            java.util.concurrent.atomic.AtomicLongFieldUpdater r22 = s9.j.f
            r23 = r1
            boolean r1 = r22.compareAndSet(r23, r24, r26)
            r2 = r23
            if (r1 == 0) goto L99
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r2.d
            int r2 = r2.c
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
        throw new UnsupportedOperationException("Method not decompiled: s9.j.d():java.lang.Object");
    }
}
