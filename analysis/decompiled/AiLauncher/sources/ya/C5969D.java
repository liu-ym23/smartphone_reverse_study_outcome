package ya;

/* renamed from: ya.D, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5969D extends AbstractC5974I implements Ca.d {

    /* renamed from: d, reason: collision with root package name */
    public final s0 f44013d;

    /* JADX WARN: Illegal instructions before constructor call */
    public C5969D(C9.j builtIns, s0 attributes) {
        kotlin.jvm.internal.p.i(builtIns, "builtIns");
        kotlin.jvm.internal.p.i(attributes, "attributes");
        AbstractC5990d0 abstractC5990d0I = builtIns.I();
        kotlin.jvm.internal.p.h(abstractC5990d0I, "getNothingType(...)");
        AbstractC5990d0 abstractC5990d0J = builtIns.J();
        kotlin.jvm.internal.p.h(abstractC5990d0J, "getNullableAnyType(...)");
        super(abstractC5990d0I, abstractC5990d0J);
        this.f44013d = attributes;
    }

    @Override // ya.AbstractC5974I, ya.S
    public s0 G0() {
        return this.f44013d;
    }

    @Override // ya.AbstractC5974I, ya.S
    public boolean I0() {
        return false;
    }

    @Override // ya.AbstractC5974I
    public AbstractC5990d0 O0() {
        return Q0();
    }

    @Override // ya.AbstractC5974I
    public String R0(kotlin.reflect.jvm.internal.impl.renderer.b renderer, kotlin.reflect.jvm.internal.impl.renderer.c options) {
        kotlin.jvm.internal.p.i(renderer, "renderer");
        kotlin.jvm.internal.p.i(options, "options");
        return "dynamic";
    }

    @Override // ya.K0
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public C5969D L0(boolean z10) {
        return this;
    }

    @Override // ya.K0
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public C5969D R0(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // ya.K0
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public C5969D N0(s0 newAttributes) {
        kotlin.jvm.internal.p.i(newAttributes, "newAttributes");
        return new C5969D(Da.d.n(O0()), newAttributes);
    }
}
