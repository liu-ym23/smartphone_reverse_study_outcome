package androidx.lifecycle;

import a4.C0428b;
import androidx.lifecycle.AbstractC0533m;
import s4.C1076i;
import s4.s0;

/* renamed from: androidx.lifecycle.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0535o extends AbstractC0534n implements InterfaceC0537q {

    /* renamed from: a, reason: collision with root package name */
    private final AbstractC0533m f10888a;

    /* renamed from: b, reason: collision with root package name */
    private final Z3.i f10889b;

    @kotlin.coroutines.jvm.internal.f(c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", f = "Lifecycle.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.o$a */
    static final class a extends kotlin.coroutines.jvm.internal.l implements i4.p<s4.I, Z3.e<? super V3.v>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f10890a;

        /* renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f10891b;

        a(Z3.e<? super a> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<V3.v> create(Object obj, Z3.e<?> eVar) {
            a aVar = C0535o.this.new a(eVar);
            aVar.f10891b = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            C0428b.e();
            if (this.f10890a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            V3.o.b(obj);
            s4.I i5 = (s4.I) this.f10891b;
            if (C0535o.this.b().b().compareTo(AbstractC0533m.b.INITIALIZED) >= 0) {
                C0535o.this.b().a(C0535o.this);
            } else {
                s0.d(i5.G(), null, 1, null);
            }
            return V3.v.f5542a;
        }

        @Override // i4.p
        public final Object invoke(s4.I i5, Z3.e<? super V3.v> eVar) {
            return ((a) create(i5, eVar)).invokeSuspend(V3.v.f5542a);
        }
    }

    public C0535o(AbstractC0533m abstractC0533m, Z3.i iVar) {
        j4.k.g(abstractC0533m, "lifecycle");
        j4.k.g(iVar, "coroutineContext");
        this.f10888a = abstractC0533m;
        this.f10889b = iVar;
        if (b().b() == AbstractC0533m.b.DESTROYED) {
            s0.d(G(), null, 1, null);
        }
    }

    @Override // s4.I
    public Z3.i G() {
        return this.f10889b;
    }

    public AbstractC0533m b() {
        return this.f10888a;
    }

    public final void d() {
        C1076i.b(this, s4.W.c().h0(), null, new a(null), 2, null);
    }

    @Override // androidx.lifecycle.InterfaceC0537q
    public void f(InterfaceC0539t interfaceC0539t, AbstractC0533m.a aVar) {
        j4.k.g(interfaceC0539t, "source");
        j4.k.g(aVar, "event");
        if (b().b().compareTo(AbstractC0533m.b.DESTROYED) <= 0) {
            b().d(this);
            s0.d(G(), null, 1, null);
        }
    }
}
