package a3;

import Z2.AbstractC0114a;
import Z2.p0;
import java.util.concurrent.CancellationException;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* renamed from: a3.j, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0165j extends AbstractC0114a implements InterfaceC0164i {

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0164i f2312d;

    public AbstractC0165j(CoroutineContext coroutineContext, C0160e c0160e) {
        super(coroutineContext, true);
        this.f2312d = c0160e;
    }

    @Override // Z2.x0, Z2.o0
    public final void b(CancellationException cancellationException) {
        if (L()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new p0(x(), null, this);
        }
        v(cancellationException);
    }

    @Override // a3.v
    public final Object c(Continuation continuation) {
        return this.f2312d.c(continuation);
    }

    @Override // a3.w
    public final boolean d(Throwable th) {
        return this.f2312d.d(th);
    }

    @Override // a3.w
    public final Object f(IndexedValue indexedValue, c3.f fVar) {
        return this.f2312d.f(indexedValue, fVar);
    }

    @Override // a3.v
    public final C0156a iterator() {
        return this.f2312d.iterator();
    }

    @Override // a3.v
    public final Object k() {
        return this.f2312d.k();
    }

    @Override // a3.w
    public final Object l(Object obj) {
        return this.f2312d.l(obj);
    }

    @Override // a3.v
    public final Object m(Continuation continuation) {
        Object objM = this.f2312d.m(continuation);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return objM;
    }

    @Override // a3.w
    public final boolean n() {
        return this.f2312d.n();
    }

    @Override // a3.w
    public final void p(S.s sVar) {
        this.f2312d.p(sVar);
    }

    @Override // Z2.x0
    public final void v(CancellationException cancellationException) {
        this.f2312d.b(cancellationException);
        u(cancellationException);
    }
}
