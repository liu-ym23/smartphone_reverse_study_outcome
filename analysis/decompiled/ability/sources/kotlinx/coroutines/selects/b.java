package kotlinx.coroutines.selects;

import C7.r;
import D7.v;
import H7.h;
import S7.n;
import S7.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.InterfaceC1693K;
import m9.InterfaceC1716i;
import m9.InterfaceC1717j;
import s9.p;
import u1.d;
import v9.AbstractC2077f;
import v9.C2074c;
import v9.InterfaceC2075d;

/* loaded from: classes4.dex */
public final class b implements InterfaceC1716i, InterfaceC2075d {
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "state$volatile");

    /* renamed from: a, reason: collision with root package name */
    public final h f5256a;
    public Object c;
    private volatile /* synthetic */ Object state$volatile = AbstractC2077f.f6797a;
    public ArrayList b = new ArrayList(2);
    public int d = -1;
    public Object e = AbstractC2077f.d;

    public b(h hVar) {
        this.f5256a = hVar;
    }

    @Override // v9.InterfaceC2075d
    public final void a(InterfaceC1693K interfaceC1693K) {
        this.c = interfaceC1693K;
    }

    @Override // m9.InterfaceC1716i
    public final void b(Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        do {
            atomicReferenceFieldUpdater = f;
            obj = atomicReferenceFieldUpdater.get(this);
            if (obj == AbstractC2077f.b) {
                return;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, AbstractC2077f.c));
        ArrayList arrayList = this.b;
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((C2074c) it.next()).a();
        }
        this.e = AbstractC2077f.d;
        this.b = null;
    }

    @Override // m9.y0
    public final void c(p pVar, int i) {
        this.c = pVar;
        this.d = i;
    }

    public final Object d(ContinuationImpl continuationImpl) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
        Object obj = atomicReferenceFieldUpdater.get(this);
        k.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        C2074c c2074c = (C2074c) obj;
        Object obj2 = this.e;
        ArrayList arrayList = this.b;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C2074c c2074c2 = (C2074c) it.next();
                if (c2074c2 != c2074c) {
                    c2074c2.a();
                }
            }
            atomicReferenceFieldUpdater.set(this, AbstractC2077f.b);
            this.e = AbstractC2077f.d;
            this.b = null;
        }
        Object objInvoke = c2074c.c.invoke(c2074c.f6795a, c2074c.d, obj2);
        J7.b bVar = c2074c.e;
        return c2074c.d == AbstractC2077f.e ? ((S7.k) bVar).invoke(continuationImpl) : ((n) bVar).invoke(objInvoke, continuationImpl);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(kotlin.coroutines.jvm.internal.ContinuationImpl r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1
            if (r0 == 0) goto L13
            r0 = r11
            kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1 r0 = (kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1 r0 = new kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.d
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3a
            if (r2 == r5) goto L33
            if (r2 != r4) goto L2b
            kotlin.b.b(r11)
            return r11
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L33:
            kotlinx.coroutines.selects.b r10 = r0.f5254a
            kotlin.b.b(r11)
            goto Lb2
        L3a:
            kotlin.b.b(r11)
            r0.f5254a = r10
            r0.d = r5
            m9.k r11 = new m9.k
            H7.c r2 = U7.a.I(r0)
            r11.<init>(r5, r2)
            r11.y()
        L4d:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = kotlinx.coroutines.selects.b.f
            java.lang.Object r6 = r2.get(r10)
            C7.r r7 = C7.r.f317a
            a5.d r8 = v9.AbstractC2077f.f6797a
            if (r6 != r8) goto L63
            boolean r2 = r2.compareAndSet(r10, r6, r11)
            if (r2 == 0) goto L4d
            r11.A(r10)
            goto La6
        L63:
            boolean r9 = r6 instanceof java.util.List
            if (r9 == 0) goto L8d
            boolean r2 = r2.compareAndSet(r10, r6, r8)
            if (r2 == 0) goto L4d
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r2 = r6.iterator()
        L73:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L4d
            java.lang.Object r6 = r2.next()
            v9.c r6 = r10.h(r6)
            kotlin.jvm.internal.k.c(r6)
            r6.g = r3
            r7 = -1
            r6.h = r7
            r10.j(r6, r5)
            goto L73
        L8d:
            boolean r2 = r6 instanceof v9.C2074c
            if (r2 == 0) goto Lbe
            v9.c r6 = (v9.C2074c) r6
            java.lang.Object r2 = r10.e
            S7.o r5 = r6.f
            if (r5 == 0) goto La2
            java.lang.Object r6 = r6.d
            java.lang.Object r2 = r5.invoke(r10, r6, r2)
            S7.o r2 = (S7.o) r2
            goto La3
        La2:
            r2 = r3
        La3:
            r11.d(r7, r2)
        La6:
            java.lang.Object r11 = r11.x()
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            if (r11 != r2) goto Laf
            r7 = r11
        Laf:
            if (r7 != r1) goto Lb2
            goto Lbc
        Lb2:
            r0.f5254a = r3
            r0.d = r4
            java.lang.Object r10 = r10.d(r0)
            if (r10 != r1) goto Lbd
        Lbc:
            return r1
        Lbd:
            return r10
        Lbe:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "unexpected state: "
            java.lang.String r11 = androidx.compose.foundation.b.r(r6, r11)
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.b.e(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // v9.InterfaceC2075d
    public final void f(Object obj) {
        this.e = obj;
    }

    @Override // v9.InterfaceC2075d
    public final boolean g(Object obj, Object obj2) {
        return k(obj, obj2) == 0;
    }

    public final C2074c h(Object obj) {
        ArrayList arrayList = this.b;
        Object obj2 = null;
        if (arrayList == null) {
            return null;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((C2074c) next).f6795a == obj) {
                obj2 = next;
                break;
            }
        }
        C2074c c2074c = (C2074c) obj2;
        if (c2074c != null) {
            return c2074c;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i(d dVar, n nVar) {
        j(new C2074c(this, dVar.b, (o) dVar.c, (o) dVar.d, null, (SuspendLambda) nVar, (o) dVar.e), false);
    }

    public final void j(C2074c c2074c, boolean z10) {
        Object obj = c2074c.f6795a;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
        if (atomicReferenceFieldUpdater.get(this) instanceof C2074c) {
            return;
        }
        if (!z10) {
            ArrayList arrayList = this.b;
            k.c(arrayList);
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (((C2074c) it.next()).f6795a == obj) {
                        throw new IllegalStateException(androidx.appfunctions.metadata.a.j(obj, "Cannot use select clauses on the same object: ").toString());
                    }
                }
            }
        }
        c2074c.b.invoke(obj, this, c2074c.d);
        if (this.e != AbstractC2077f.d) {
            atomicReferenceFieldUpdater.set(this, c2074c);
            return;
        }
        if (!z10) {
            ArrayList arrayList2 = this.b;
            k.c(arrayList2);
            arrayList2.add(c2074c);
        }
        c2074c.g = this.c;
        c2074c.h = this.d;
        this.c = null;
        this.d = -1;
    }

    public final int k(Object obj, Object obj2) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj3 instanceof InterfaceC1717j) {
                C2074c c2074cH = h(obj);
                if (c2074cH != null) {
                    o oVar = c2074cH.f;
                    o oVar2 = oVar != null ? (o) oVar.invoke(this, c2074cH.d, obj2) : null;
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, c2074cH)) {
                        InterfaceC1717j interfaceC1717j = (InterfaceC1717j) obj3;
                        this.e = obj2;
                        a5.d dVarH = interfaceC1717j.h(r.f317a, oVar2);
                        if (dVarH == null) {
                            this.e = AbstractC2077f.d;
                            return 2;
                        }
                        interfaceC1717j.v(dVarH);
                        return 0;
                    }
                } else {
                    continue;
                }
            } else {
                if (k.b(obj3, AbstractC2077f.b) || (obj3 instanceof C2074c)) {
                    return 3;
                }
                if (k.b(obj3, AbstractC2077f.c)) {
                    return 2;
                }
                if (k.b(obj3, AbstractC2077f.f6797a)) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, H4.o.M(obj))) {
                        return 1;
                    }
                } else {
                    if (!(obj3 instanceof List)) {
                        throw new IllegalStateException(androidx.compose.foundation.b.r(obj3, "Unexpected state: "));
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, v.R0((Collection) obj3, obj))) {
                        return 1;
                    }
                }
            }
        }
    }
}
