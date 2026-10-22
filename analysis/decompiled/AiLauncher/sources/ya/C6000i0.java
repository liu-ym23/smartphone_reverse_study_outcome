package ya;

import kotlin.reflect.jvm.internal.impl.types.Variance;

/* renamed from: ya.i0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6000i0 extends C0 {

    /* renamed from: a, reason: collision with root package name */
    public final S f44091a;

    public C6000i0(C9.j kotlinBuiltIns) {
        kotlin.jvm.internal.p.i(kotlinBuiltIns, "kotlinBuiltIns");
        AbstractC5990d0 abstractC5990d0J = kotlinBuiltIns.J();
        kotlin.jvm.internal.p.h(abstractC5990d0J, "getNullableAnyType(...)");
        this.f44091a = abstractC5990d0J;
    }

    @Override // ya.B0
    public B0 a(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // ya.B0
    public boolean b() {
        return true;
    }

    @Override // ya.B0
    public Variance c() {
        return Variance.OUT_VARIANCE;
    }

    @Override // ya.B0
    public S getType() {
        return this.f44091a;
    }
}
