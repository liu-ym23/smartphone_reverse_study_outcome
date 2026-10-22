package na;

import ia.d0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class k {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6911f = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_next$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6912g = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_prev$volatile");

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f6913h = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_removedRef$volatile");
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    public final boolean e(k kVar, int i2) {
        while (true) {
            k kVarF = f();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6912g;
            if (kVarF == null) {
                Object obj = atomicReferenceFieldUpdater.get(this);
                while (true) {
                    kVarF = (k) obj;
                    if (!kVarF.i()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(kVarF);
                }
            }
            if (kVarF instanceof i) {
                return (((i) kVarF).f6910i & i2) == 0 && kVarF.e(kVar, i2);
            }
            atomicReferenceFieldUpdater.set(kVar, kVarF);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f6911f;
            atomicReferenceFieldUpdater2.set(kVar, this);
            while (!atomicReferenceFieldUpdater2.compareAndSet(kVarF, this, kVar)) {
                if (atomicReferenceFieldUpdater2.get(kVarF) != this) {
                    break;
                }
            }
            kVar.g(this);
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
    
        r6 = ((na.p) r6).f6924a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        if (r5.compareAndSet(r4, r3, r6) == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
    
        if (r5.get(r4) == r3) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final na.k f() {
        /*
            r9 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = na.k.f6912g
            java.lang.Object r1 = r0.get(r9)
            na.k r1 = (na.k) r1
            r2 = 0
            r3 = r1
        La:
            r4 = r2
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = na.k.f6911f
            java.lang.Object r6 = r5.get(r3)
            if (r6 != r9) goto L24
            if (r1 != r3) goto L16
            return r3
        L16:
            boolean r2 = r0.compareAndSet(r9, r1, r3)
            if (r2 == 0) goto L1d
            return r3
        L1d:
            java.lang.Object r2 = r0.get(r9)
            if (r2 == r1) goto L16
            goto L0
        L24:
            boolean r7 = r9.i()
            if (r7 == 0) goto L2b
            return r2
        L2b:
            boolean r7 = r6 instanceof na.p
            if (r7 == 0) goto L4b
            if (r4 == 0) goto L44
            na.p r6 = (na.p) r6
            na.k r6 = r6.f6924a
        L35:
            boolean r7 = r5.compareAndSet(r4, r3, r6)
            if (r7 == 0) goto L3d
            r3 = r4
            goto La
        L3d:
            java.lang.Object r7 = r5.get(r4)
            if (r7 == r3) goto L35
            goto L0
        L44:
            java.lang.Object r3 = r0.get(r3)
            na.k r3 = (na.k) r3
            goto Lb
        L4b:
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode"
            q7.k.c(r6, r4)
            r4 = r6
            na.k r4 = (na.k) r4
            r8 = r4
            r4 = r3
            r3 = r8
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: na.k.f():na.k");
    }

    public final void g(k kVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6912g;
            k kVar2 = (k) atomicReferenceFieldUpdater.get(kVar);
            if (f6911f.get(this) != kVar) {
                return;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(kVar, kVar2, this)) {
                if (atomicReferenceFieldUpdater.get(kVar) != kVar2) {
                    break;
                }
            }
            if (i()) {
                kVar.f();
                return;
            }
            return;
        }
    }

    public final k h() {
        k kVar;
        Object obj = f6911f.get(this);
        p pVar = obj instanceof p ? (p) obj : null;
        if (pVar != null && (kVar = pVar.f6924a) != null) {
            return kVar;
        }
        q7.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        return (k) obj;
    }

    public boolean i() {
        return f6911f.get(this) instanceof p;
    }

    public String toString() {
        return new j(1, d0.class, this, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;") + '@' + d0.k(this);
    }
}
