package o9;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.JobCancellationException;
import m9.AbstractC1683A;
import m9.AbstractC1708a;
import m9.C1727t;
import m9.h0;

/* renamed from: o9.k, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1785k extends AbstractC1708a implements InterfaceC1786l, InterfaceC1779e {
    public final kotlinx.coroutines.channels.a d;

    public C1785k(H7.h hVar, kotlinx.coroutines.channels.a aVar) {
        super(hVar, true);
        this.d = aVar;
    }

    @Override // kotlinx.coroutines.c
    public final void B(CancellationException cancellationException) {
        this.d.g(cancellationException, true);
        A(cancellationException);
    }

    @Override // o9.o
    public final Object a(Object obj) {
        return this.d.a(obj);
    }

    @Override // kotlinx.coroutines.c, m9.c0
    public final void cancel(CancellationException cancellationException) {
        Object obj = kotlinx.coroutines.c.f5183a.get(this);
        if (obj instanceof C1727t) {
            return;
        }
        if ((obj instanceof h0) && ((h0) obj).d()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(D(), null, this);
        }
        B(cancellationException);
    }

    @Override // m9.AbstractC1708a
    public final void g0(Throwable th, boolean z10) {
        if (this.d.g(th, false) || z10) {
            return;
        }
        AbstractC1683A.k(this.c, th);
    }

    @Override // m9.AbstractC1708a
    public final void h0(Object obj) {
        this.d.s(null);
    }

    @Override // o9.n
    public final C1776b iterator() {
        kotlinx.coroutines.channels.a aVar = this.d;
        aVar.getClass();
        return new C1776b(aVar);
    }

    public final void j0(J4.b bVar) {
        a5.d dVar;
        kotlinx.coroutines.channels.a aVar = this.d;
        aVar.getClass();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = kotlinx.coroutines.channels.a.f5193j;
        if (atomicReferenceFieldUpdater.compareAndSet(aVar, null, bVar)) {
            return;
        }
        do {
            Object obj = atomicReferenceFieldUpdater.get(aVar);
            dVar = AbstractC1777c.f5451q;
            if (obj != dVar) {
                if (obj != AbstractC1777c.f5452r) {
                    throw new IllegalStateException(androidx.compose.foundation.b.r(obj, "Another handler is already registered: "));
                }
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(aVar, dVar, AbstractC1777c.f5452r));
        bVar.invoke(aVar.l());
    }

    @Override // o9.n
    public final u1.d m() {
        return this.d.m();
    }

    @Override // o9.n
    public final u1.d o() {
        return this.d.o();
    }

    @Override // o9.o
    public final Object p(H7.c cVar, Object obj) {
        return this.d.p(cVar, obj);
    }

    @Override // o9.n
    public final Object q() {
        return this.d.q();
    }

    @Override // o9.o
    public final boolean s(Throwable th) {
        return this.d.g(th, false);
    }

    @Override // o9.n
    public final Object t(H7.c cVar) {
        kotlinx.coroutines.channels.a aVar = this.d;
        aVar.getClass();
        Object objE = kotlinx.coroutines.channels.a.E(aVar, (ContinuationImpl) cVar);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objE;
    }

    @Override // o9.n
    public final Object u(SuspendLambda suspendLambda) {
        return this.d.u(suspendLambda);
    }
}
