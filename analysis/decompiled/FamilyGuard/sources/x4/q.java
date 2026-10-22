package x4;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f23872a = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_next$volatile");

    /* renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f23873b = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_prev$volatile");

    /* renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f23874c = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_removedRef$volatile");
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    public static abstract class a extends AbstractC1302b<q> {

        /* renamed from: b, reason: collision with root package name */
        public final q f23875b;

        /* renamed from: c, reason: collision with root package name */
        public q f23876c;

        public a(q qVar) {
            this.f23875b = qVar;
        }

        @Override // x4.AbstractC1302b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(q qVar, Object obj) {
            boolean z5 = obj == null;
            q qVar2 = z5 ? this.f23875b : this.f23876c;
            if (qVar2 != null && q.n().compareAndSet(qVar, this, qVar2) && z5) {
                q qVar3 = this.f23875b;
                q qVar4 = this.f23876c;
                j4.k.d(qVar4);
                qVar3.j(qVar4);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
    
        if (x4.q.f23872a.compareAndSet(r3, r2, ((x4.z) r4).f23892a) != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final x4.q h(x4.y r8) {
        /*
            r7 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = o()
            java.lang.Object r0 = r0.get(r7)
            x4.q r0 = (x4.q) r0
            r1 = 0
            r2 = r0
        Lc:
            r3 = r1
        Ld:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = n()
            java.lang.Object r4 = r4.get(r2)
            if (r4 != r7) goto L25
            if (r0 != r2) goto L1a
            goto L2e
        L1a:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = o()
            boolean r0 = r1.compareAndSet(r7, r0, r2)
            if (r0 != 0) goto L2e
            goto L0
        L25:
            boolean r5 = r7.q()
            if (r5 == 0) goto L2c
            return r1
        L2c:
            if (r4 != r8) goto L2f
        L2e:
            return r2
        L2f:
            boolean r5 = r4 instanceof x4.y
            if (r5 == 0) goto L39
            x4.y r4 = (x4.y) r4
            r4.a(r2)
            goto L0
        L39:
            boolean r5 = r4 instanceof x4.z
            if (r5 == 0) goto L5b
            if (r3 == 0) goto L50
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = n()
            x4.z r4 = (x4.z) r4
            x4.q r4 = r4.f23892a
            boolean r2 = r5.compareAndSet(r3, r2, r4)
            if (r2 != 0) goto L4e
            goto L0
        L4e:
            r2 = r3
            goto Lc
        L50:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = o()
            java.lang.Object r2 = r4.get(r2)
            x4.q r2 = (x4.q) r2
            goto Ld
        L5b:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            j4.k.e(r4, r3)
            r3 = r4
            x4.q r3 = (x4.q) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto Ld
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.q.h(x4.y):x4.q");
    }

    private final q i(q qVar) {
        while (qVar.q()) {
            qVar = (q) f23873b.get(qVar);
        }
        return qVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(q qVar) {
        q qVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f23873b;
        do {
            qVar2 = (q) atomicReferenceFieldUpdater.get(qVar);
            if (k() != qVar) {
                return;
            }
        } while (!f23873b.compareAndSet(qVar, qVar2, this));
        if (q()) {
            qVar.h(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater n() {
        return f23872a;
    }

    private final z t() {
        z zVar = (z) f23874c.get(this);
        if (zVar != null) {
            return zVar;
        }
        z zVar2 = new z(this);
        f23874c.set(this, zVar2);
        return zVar2;
    }

    public final boolean g(q qVar) {
        f23873b.set(qVar, this);
        f23872a.set(qVar, this);
        while (k() == this) {
            if (f23872a.compareAndSet(this, this, qVar)) {
                qVar.j(this);
                return true;
            }
        }
        return false;
    }

    public final Object k() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f23872a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof y)) {
                return obj;
            }
            ((y) obj).a(this);
        }
    }

    public final q l() {
        q qVar;
        Object objK = k();
        z zVar = objK instanceof z ? (z) objK : null;
        if (zVar != null && (qVar = zVar.f23892a) != null) {
            return qVar;
        }
        j4.k.e(objK, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (q) objK;
    }

    public final q m() {
        q qVarH = h(null);
        return qVarH == null ? i((q) f23873b.get(this)) : qVarH;
    }

    public boolean q() {
        return k() instanceof z;
    }

    public boolean r() {
        return s() == null;
    }

    public final q s() {
        Object objK;
        q qVar;
        do {
            objK = k();
            if (objK instanceof z) {
                return ((z) objK).f23892a;
            }
            if (objK == this) {
                return (q) objK;
            }
            j4.k.e(objK, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            qVar = (q) objK;
        } while (!f23872a.compareAndSet(this, objK, qVar.t()));
        qVar.h(null);
        return null;
    }

    public String toString() {
        return new j4.o(this) { // from class: x4.q.b
            @Override // p4.f
            public Object get() {
                return s4.M.a(this.f17818b);
            }
        } + '@' + s4.M.b(this);
    }

    public final int u(q qVar, q qVar2, a aVar) {
        f23873b.set(qVar, this);
        f23872a.set(qVar, qVar2);
        aVar.f23876c = qVar2;
        if (f23872a.compareAndSet(this, qVar2, aVar)) {
            return aVar.a(this) == null ? 1 : 2;
        }
        return 0;
    }
}
