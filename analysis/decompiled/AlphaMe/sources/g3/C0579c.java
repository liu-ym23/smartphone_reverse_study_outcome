package g3;

import X.r;
import Z2.A;
import Z2.C0128h;
import Z2.InterfaceC0126g;
import Z2.K0;
import d3.v;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;

/* renamed from: g3.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0579c implements InterfaceC0126g, K0 {

    /* renamed from: a, reason: collision with root package name */
    public final C0128h f12664a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f12665b = null;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0580d f12666c;

    public C0579c(C0580d c0580d, C0128h c0128h) {
        this.f12666c = c0580d;
        this.f12664a = c0128h;
    }

    @Override // Z2.K0
    public final void a(v vVar, int i4) {
        this.f12664a.a(vVar, i4);
    }

    @Override // Z2.InterfaceC0126g
    public final void g(Object obj, Function1 function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C0580d.f12667h;
        Object obj2 = this.f12665b;
        C0580d c0580d = this.f12666c;
        atomicReferenceFieldUpdater.set(c0580d, obj2);
        C0578b c0578b = new C0578b(c0580d, this, 0);
        this.f12664a.g((Unit) obj, c0578b);
    }

    @Override // kotlin.coroutines.Continuation
    /* renamed from: getContext */
    public final CoroutineContext get$context() {
        return this.f12664a.f2220e;
    }

    @Override // Z2.InterfaceC0126g
    public final r h(Object obj, Function1 function1) {
        C0580d c0580d = this.f12666c;
        C0578b c0578b = new C0578b(c0580d, this, 1);
        r rVarH = this.f12664a.h((Unit) obj, c0578b);
        if (rVarH != null) {
            C0580d.f12667h.set(c0580d, this.f12665b);
        }
        return rVarH;
    }

    @Override // Z2.InterfaceC0126g
    public final boolean i(Throwable th) {
        return this.f12664a.i(th);
    }

    @Override // Z2.InterfaceC0126g
    public final void j(A a4, Object obj) {
        this.f12664a.j(a4, (Unit) obj);
    }

    @Override // Z2.InterfaceC0126g
    public final void o(Function1 function1) {
        this.f12664a.o(function1);
    }

    @Override // Z2.InterfaceC0126g
    public final void q(Object obj) {
        this.f12664a.q(obj);
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        this.f12664a.resumeWith(obj);
    }
}
