package androidx.lifecycle;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class B implements E, Z2.F {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0328z f3864a;

    /* renamed from: b, reason: collision with root package name */
    public final CoroutineContext f3865b;

    public B(AbstractC0328z lifecycle, CoroutineContext coroutineContext) {
        Z2.o0 o0Var;
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.f3864a = lifecycle;
        this.f3865b = coroutineContext;
        if (((I) lifecycle).f3871d != EnumC0327y.f3983a || (o0Var = (Z2.o0) coroutineContext.get(Z2.n0.f2230a)) == null) {
            return;
        }
        o0Var.b(null);
    }

    @Override // androidx.lifecycle.E
    public final void a(G source, EnumC0326x event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        AbstractC0328z abstractC0328z = this.f3864a;
        if (((I) abstractC0328z).f3871d.compareTo(EnumC0327y.f3983a) <= 0) {
            abstractC0328z.b(this);
            Z2.o0 o0Var = (Z2.o0) this.f3865b.get(Z2.n0.f2230a);
            if (o0Var != null) {
                o0Var.b(null);
            }
        }
    }

    @Override // Z2.F
    public final CoroutineContext e() {
        return this.f3865b;
    }
}
