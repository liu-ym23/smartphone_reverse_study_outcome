package X8;

import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes4.dex */
public final class E extends N {

    /* renamed from: a, reason: collision with root package name */
    public final A f1521a;

    public E(e8.i kotlinBuiltIns) {
        kotlin.jvm.internal.k.f(kotlinBuiltIns, "kotlinBuiltIns");
        A aO = kotlinBuiltIns.o();
        kotlin.jvm.internal.k.e(aO, "getNullableAnyType(...)");
        this.f1521a = aO;
    }

    @Override // X8.N
    public final Variance a() {
        return Variance.e;
    }

    @Override // X8.N
    public final w b() {
        return this.f1521a;
    }

    @Override // X8.N
    public final boolean c() {
        return true;
    }

    @Override // X8.N
    public final N d(Y8.f kotlinTypeRefiner) {
        kotlin.jvm.internal.k.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }
}
