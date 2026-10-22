package o9;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import m9.AbstractC1683A;
import m9.C1718k;
import m9.y0;
import s9.q;

/* renamed from: o9.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1776b implements y0 {

    /* renamed from: a, reason: collision with root package name */
    public Object f5448a = AbstractC1777c.p;
    public C1718k b;
    public final /* synthetic */ kotlinx.coroutines.channels.a c;

    public C1776b(kotlinx.coroutines.channels.a aVar) {
        this.c = aVar;
    }

    public final Object b(ContinuationImpl continuationImpl) throws Throwable {
        C1783i c1783i;
        Boolean bool;
        C1783i c1783i2;
        Object obj = this.f5448a;
        boolean z10 = true;
        if (obj == AbstractC1777c.p || obj == AbstractC1777c.l) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = kotlinx.coroutines.channels.a.g;
            kotlinx.coroutines.channels.a aVar = this.c;
            C1783i c1783i3 = (C1783i) atomicReferenceFieldUpdater.get(aVar);
            while (true) {
                if (aVar.y()) {
                    this.f5448a = AbstractC1777c.l;
                    Throwable thL = aVar.l();
                    if (thL != null) {
                        int i = q.f6006a;
                        throw thL;
                    }
                    z10 = false;
                } else {
                    long andIncrement = kotlinx.coroutines.channels.a.c.getAndIncrement(aVar);
                    long j5 = AbstractC1777c.b;
                    long j6 = andIncrement / j5;
                    int i6 = (int) (andIncrement % j5);
                    if (c1783i3.c != j6) {
                        C1783i c1783iK = aVar.k(j6, c1783i3);
                        if (c1783iK == null) {
                            continue;
                        } else {
                            c1783i = c1783iK;
                        }
                    } else {
                        c1783i = c1783i3;
                    }
                    Object objJ = aVar.J(c1783i, i6, andIncrement, null);
                    a5.d dVar = AbstractC1777c.m;
                    if (objJ == dVar) {
                        throw new IllegalStateException("unreachable");
                    }
                    a5.d dVar2 = AbstractC1777c.o;
                    if (objJ == dVar2) {
                        if (andIncrement < aVar.v()) {
                            c1783i.a();
                        }
                        c1783i3 = c1783i;
                    } else {
                        if (objJ == AbstractC1777c.n) {
                            C1718k c1718kJ = AbstractC1683A.j(U7.a.I(continuationImpl));
                            try {
                                this.b = c1718kJ;
                                Object objJ2 = aVar.J(c1783i, i6, andIncrement, this);
                                if (objJ2 == dVar) {
                                    c(c1783i, i6);
                                } else {
                                    if (objJ2 == dVar2) {
                                        if (andIncrement < aVar.v()) {
                                            c1783i.a();
                                        }
                                        C1783i c1783i4 = (C1783i) kotlinx.coroutines.channels.a.g.get(aVar);
                                        while (true) {
                                            if (aVar.y()) {
                                                C1718k c1718k = this.b;
                                                kotlin.jvm.internal.k.c(c1718k);
                                                this.b = null;
                                                this.f5448a = AbstractC1777c.l;
                                                Throwable thL2 = aVar.l();
                                                if (thL2 == null) {
                                                    c1718k.resumeWith(Boolean.FALSE);
                                                } else {
                                                    c1718k.resumeWith(kotlin.b.a(thL2));
                                                }
                                            } else {
                                                long andIncrement2 = kotlinx.coroutines.channels.a.c.getAndIncrement(aVar);
                                                long j10 = AbstractC1777c.b;
                                                long j11 = andIncrement2 / j10;
                                                int i10 = (int) (andIncrement2 % j10);
                                                if (c1783i4.c != j11) {
                                                    C1783i c1783iK2 = aVar.k(j11, c1783i4);
                                                    if (c1783iK2 != null) {
                                                        c1783i2 = c1783iK2;
                                                    }
                                                } else {
                                                    c1783i2 = c1783i4;
                                                }
                                                Object objJ3 = aVar.J(c1783i2, i10, andIncrement2, this);
                                                C1783i c1783i5 = c1783i2;
                                                if (objJ3 == AbstractC1777c.m) {
                                                    c(c1783i5, i10);
                                                    break;
                                                }
                                                if (objJ3 == AbstractC1777c.o) {
                                                    if (andIncrement2 < aVar.v()) {
                                                        c1783i5.a();
                                                    }
                                                    c1783i4 = c1783i5;
                                                } else {
                                                    if (objJ3 == AbstractC1777c.n) {
                                                        throw new IllegalStateException("unexpected");
                                                    }
                                                    c1783i5.a();
                                                    this.f5448a = objJ3;
                                                    this.b = null;
                                                    bool = Boolean.TRUE;
                                                }
                                            }
                                        }
                                    } else {
                                        c1783i.a();
                                        this.f5448a = objJ2;
                                        this.b = null;
                                        bool = Boolean.TRUE;
                                    }
                                    c1718kJ.d(bool, null);
                                }
                                Object objX = c1718kJ.x();
                                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                                return objX;
                            } catch (Throwable th) {
                                c1718kJ.E();
                                throw th;
                            }
                        }
                        c1783i.a();
                        this.f5448a = objJ;
                    }
                }
            }
        }
        return Boolean.valueOf(z10);
    }

    @Override // m9.y0
    public final void c(s9.p pVar, int i) {
        C1718k c1718k = this.b;
        if (c1718k != null) {
            c1718k.c(pVar, i);
        }
    }

    public final Object d() throws Throwable {
        Object obj = this.f5448a;
        a5.d dVar = AbstractC1777c.p;
        if (obj == dVar) {
            throw new IllegalStateException("`hasNext()` has not been invoked");
        }
        this.f5448a = dVar;
        if (obj != AbstractC1777c.l) {
            return obj;
        }
        Throwable thN = this.c.n();
        int i = q.f6006a;
        throw thN;
    }
}
