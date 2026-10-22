package ya;

/* renamed from: ya.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5983a extends AbstractC6019z {

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC5990d0 f44065b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC5990d0 f44066c;

    public C5983a(AbstractC5990d0 delegate, AbstractC5990d0 abbreviation) {
        kotlin.jvm.internal.p.i(delegate, "delegate");
        kotlin.jvm.internal.p.i(abbreviation, "abbreviation");
        this.f44065b = delegate;
        this.f44066c = abbreviation;
    }

    public final AbstractC5990d0 E() {
        return Q0();
    }

    @Override // ya.K0
    /* renamed from: P0 */
    public AbstractC5990d0 N0(s0 newAttributes) {
        kotlin.jvm.internal.p.i(newAttributes, "newAttributes");
        return new C5983a(Q0().N0(newAttributes), this.f44066c);
    }

    @Override // ya.AbstractC6019z
    public AbstractC5990d0 Q0() {
        return this.f44065b;
    }

    public final AbstractC5990d0 T0() {
        return this.f44066c;
    }

    @Override // ya.AbstractC5990d0
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public C5983a L0(boolean z10) {
        return new C5983a(Q0().L0(z10), this.f44066c.L0(z10));
    }

    @Override // ya.AbstractC6019z
    /* renamed from: V0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public C5983a R0(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        S sA = kotlinTypeRefiner.a(Q0());
        kotlin.jvm.internal.p.g(sA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        S sA2 = kotlinTypeRefiner.a(this.f44066c);
        kotlin.jvm.internal.p.g(sA2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new C5983a((AbstractC5990d0) sA, (AbstractC5990d0) sA2);
    }

    @Override // ya.AbstractC6019z
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public C5983a S0(AbstractC5990d0 delegate) {
        kotlin.jvm.internal.p.i(delegate, "delegate");
        return new C5983a(delegate, this.f44066c);
    }
}
