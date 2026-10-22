package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import s9.g;
import s9.m;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5251a = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_next$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_prev$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_removedRef$volatile");
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    public final boolean c(a aVar, int i) {
        a aVarD;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            aVarD = d();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = b;
            if (aVarD == null) {
                Object obj = atomicReferenceFieldUpdater2.get(this);
                while (true) {
                    aVarD = (a) obj;
                    if (!aVarD.g()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater2.get(aVarD);
                }
            }
            if (aVarD instanceof g) {
                return (((g) aVarD).d & i) == 0 && aVarD.c(aVar, i);
            }
            atomicReferenceFieldUpdater2.set(aVar, aVarD);
            atomicReferenceFieldUpdater = f5251a;
            atomicReferenceFieldUpdater.set(aVar, this);
        } while (!atomicReferenceFieldUpdater.compareAndSet(aVarD, this, aVar));
        aVar.e(this);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
    
        if (r5.compareAndSet(r4, r3, ((s9.m) r6).f6005a) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlinx.coroutines.internal.a d() {
        /*
            r9 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.internal.a.b
            java.lang.Object r1 = r0.get(r9)
            kotlinx.coroutines.internal.a r1 = (kotlinx.coroutines.internal.a) r1
            r2 = 0
            r3 = r1
        La:
            r4 = r2
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.a.f5251a
            java.lang.Object r6 = r5.get(r3)
            if (r6 != r9) goto L1e
            if (r1 != r3) goto L16
            goto L1d
        L16:
            boolean r0 = r0.compareAndSet(r9, r1, r3)
            if (r0 != 0) goto L1d
            goto L0
        L1d:
            return r3
        L1e:
            boolean r7 = r9.g()
            if (r7 == 0) goto L25
            return r2
        L25:
            boolean r7 = r6 instanceof s9.m
            if (r7 == 0) goto L3f
            if (r4 == 0) goto L38
            s9.m r6 = (s9.m) r6
            kotlinx.coroutines.internal.a r6 = r6.f6005a
            boolean r3 = r5.compareAndSet(r4, r3, r6)
            if (r3 != 0) goto L36
            goto L0
        L36:
            r3 = r4
            goto La
        L38:
            java.lang.Object r3 = r0.get(r3)
            kotlinx.coroutines.internal.a r3 = (kotlinx.coroutines.internal.a) r3
            goto Lb
        L3f:
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode"
            kotlin.jvm.internal.k.d(r6, r4)
            r4 = r6
            kotlinx.coroutines.internal.a r4 = (kotlinx.coroutines.internal.a) r4
            r8 = r4
            r4 = r3
            r3 = r8
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.a.d():kotlinx.coroutines.internal.a");
    }

    public final void e(a aVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        a aVar2;
        do {
            atomicReferenceFieldUpdater = b;
            aVar2 = (a) atomicReferenceFieldUpdater.get(aVar);
            if (f5251a.get(this) != aVar) {
                return;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(aVar, aVar2, this));
        if (g()) {
            aVar.d();
        }
    }

    public final a f() {
        a aVar;
        Object obj = f5251a.get(this);
        m mVar = obj instanceof m ? (m) obj : null;
        if (mVar != null && (aVar = mVar.f6005a) != null) {
            return aVar;
        }
        k.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        return (a) obj;
    }

    public boolean g() {
        return f5251a.get(this) instanceof m;
    }

    public String toString() {
        return new LockFreeLinkedListNode$toString$1(1, AbstractC1683A.class, this, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;") + '@' + AbstractC1683A.i(this);
    }
}
