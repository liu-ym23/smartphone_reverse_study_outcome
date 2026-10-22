package ya;

import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* renamed from: ya.k0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6004k0 extends C0 {

    /* renamed from: a, reason: collision with root package name */
    public final E9.b0 f44095a;

    /* renamed from: b, reason: collision with root package name */
    public final Y8.h f44096b;

    public C6004k0(E9.b0 typeParameter) {
        kotlin.jvm.internal.p.i(typeParameter, "typeParameter");
        this.f44095a = typeParameter;
        this.f44096b = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new C6002j0(this));
    }

    public static final S d(C6004k0 c6004k0) {
        return C6006l0.b(c6004k0.f44095a);
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

    public final S f() {
        return (S) this.f44096b.getValue();
    }

    @Override // ya.B0
    public S getType() {
        return f();
    }
}
