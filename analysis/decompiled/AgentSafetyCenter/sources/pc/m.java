package pc;

import java.lang.invoke.VarHandle;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9971e = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_next$volatile");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f9972f = AtomicLongFieldUpdater.newUpdater(m.class, "_state$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final t f9973g = new t("REMOVE_FROZEN");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f9974a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f9975b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9976c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f9977d;

    public m(int i, boolean z10) {
        this.f9974a = i;
        this.f9975b = z10;
        int i3 = i - 1;
        this.f9976c = i3;
        this.f9977d = new AtomicReferenceArray(i);
        if (i3 > 1073741823) {
            od.f.e("Check failed.");
            throw null;
        }
        if ((i & i3) == 0) {
            return;
        }
        od.f.e("Check failed.");
        throw null;
    }

    public final int a(Object obj) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f9972f;
            long j10 = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j10) != 0) {
                return (2305843009213693952L & j10) != 0 ? 2 : 1;
            }
            int i = (int) (1073741823 & j10);
            int i3 = (int) ((1152921503533105152L & j10) >> 30);
            int i10 = this.f9976c;
            if (((i3 + 2) & i10) == (i & i10)) {
                return 1;
            }
            boolean z10 = this.f9975b;
            AtomicReferenceArray atomicReferenceArray = this.f9977d;
            if (z10 || atomicReferenceArray.get(i3 & i10) == null) {
                m mVar = this;
                if (f9972f.compareAndSet(mVar, j10, ((-1152921503533105153L) & j10) | (((i3 + 1) & 1073741823) << 30))) {
                    atomicReferenceArray.set(i3 & i10, obj);
                    m mVarC = mVar;
                    while ((atomicLongFieldUpdater.get(mVarC) & 1152921504606846976L) != 0) {
                        mVarC = mVarC.c();
                        AtomicReferenceArray atomicReferenceArray2 = mVarC.f9977d;
                        int i11 = mVarC.f9976c & i3;
                        Object obj2 = atomicReferenceArray2.get(i11);
                        if ((obj2 instanceof l) && ((l) obj2).f9970a == i3) {
                            atomicReferenceArray2.set(i11, obj);
                        } else {
                            mVarC = null;
                        }
                        if (mVarC == null) {
                            return 0;
                        }
                    }
                    return 0;
                }
                this = mVar;
            } else {
                int i12 = this.f9974a;
                if (i12 < 1024 || ((i3 - i) & 1073741823) > (i12 >> 1)) {
                    return 1;
                }
            }
        }
    }

    public final boolean b() {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f9972f;
            long j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j10) != 0) {
                return false;
            }
            m mVar = this;
            if (atomicLongFieldUpdater.compareAndSet(mVar, j10, 2305843009213693952L | j10)) {
                return true;
            }
            this = mVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object, pc.l] */
    public final m c() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j10;
        m mVar;
        while (true) {
            atomicLongFieldUpdater = f9972f;
            j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & 1152921504606846976L) != 0) {
                mVar = this;
                break;
            }
            long j11 = 1152921504606846976L | j10;
            mVar = this;
            if (atomicLongFieldUpdater.compareAndSet(mVar, j10, j11)) {
                j10 = j11;
                break;
            }
            this = mVar;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9971e;
            m mVar2 = (m) atomicReferenceFieldUpdater.get(mVar);
            if (mVar2 != null) {
                return mVar2;
            }
            m mVar3 = new m(mVar.f9974a * 2, mVar.f9975b);
            int i = (int) (1073741823 & j10);
            int i3 = (int) ((1152921503533105152L & j10) >> 30);
            while (true) {
                int i10 = mVar.f9976c;
                int i11 = i & i10;
                if (i11 != (i10 & i3)) {
                    ?? lVar = mVar.f9977d.get(i11);
                    if (lVar == 0) {
                        lVar = new l();
                        lVar.f9970a = i;
                        VarHandle.storeStoreFence();
                    }
                    mVar3.f9977d.set(mVar3.f9976c & i, lVar);
                    i++;
                }
            }
            atomicLongFieldUpdater.set(mVar3, (-1152921504606846977L) & j10);
            atomicReferenceFieldUpdater.compareAndSet(mVar, null, mVar3);
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
            java.util.concurrent.atomic.AtomicLongFieldUpdater r6 = pc.m.f9972f
            long r2 = r6.get(r1)
            r7 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r4 = r2 & r7
            r9 = 0
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 == 0) goto L15
            pc.t r0 = pc.m.f9973g
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
            int r5 = r1.f9976c
            r4 = r4 & r5
            r13 = r0 & r5
            r14 = 0
            if (r4 != r13) goto L2e
            goto L41
        L2e:
            java.util.concurrent.atomic.AtomicReferenceArray r15 = r1.f9977d
            java.lang.Object r4 = r15.get(r13)
            boolean r5 = r1.f9975b
            if (r4 != 0) goto L3b
            if (r5 == 0) goto L2
            goto L41
        L3b:
            r16 = r7
            boolean r7 = r4 instanceof pc.l
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
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = pc.m.f9972f
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
            pc.m r0 = r1.c()
            r1 = r0
            goto L96
        L7d:
            long r2 = r24 & r20
            long r26 = r2 | r7
            java.util.concurrent.atomic.AtomicLongFieldUpdater r22 = pc.m.f9972f
            r23 = r1
            boolean r1 = r22.compareAndSet(r23, r24, r26)
            r2 = r23
            if (r1 == 0) goto L99
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r2.f9977d
            int r2 = r2.f9976c
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
        throw new UnsupportedOperationException("Method not decompiled: pc.m.d():java.lang.Object");
    }
}
