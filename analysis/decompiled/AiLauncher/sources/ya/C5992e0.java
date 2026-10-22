package ya;

import java.util.List;
import p9.InterfaceC5074l;
import ra.InterfaceC5238k;

/* renamed from: ya.e0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5992e0 extends AbstractC5990d0 {

    /* renamed from: b, reason: collision with root package name */
    public final v0 f44076b;

    /* renamed from: c, reason: collision with root package name */
    public final List<B0> f44077c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f44078d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC5238k f44079e;

    /* renamed from: f, reason: collision with root package name */
    public final InterfaceC5074l<kotlin.reflect.jvm.internal.impl.types.checker.c, AbstractC5990d0> f44080f;

    /* JADX WARN: Multi-variable type inference failed */
    public C5992e0(v0 constructor, List<? extends B0> arguments, boolean z10, InterfaceC5238k memberScope, InterfaceC5074l<? super kotlin.reflect.jvm.internal.impl.types.checker.c, ? extends AbstractC5990d0> refinedTypeFactory) {
        kotlin.jvm.internal.p.i(constructor, "constructor");
        kotlin.jvm.internal.p.i(arguments, "arguments");
        kotlin.jvm.internal.p.i(memberScope, "memberScope");
        kotlin.jvm.internal.p.i(refinedTypeFactory, "refinedTypeFactory");
        this.f44076b = constructor;
        this.f44077c = arguments;
        this.f44078d = z10;
        this.f44079e = memberScope;
        this.f44080f = refinedTypeFactory;
        if (!(m() instanceof Aa.f) || (m() instanceof Aa.j)) {
            return;
        }
        throw new IllegalStateException("SimpleTypeImpl should not be created for error type: " + m() + '\n' + H0());
    }

    @Override // ya.S
    public List<B0> F0() {
        return this.f44077c;
    }

    @Override // ya.S
    public s0 G0() {
        return s0.f44124b.k();
    }

    @Override // ya.S
    public v0 H0() {
        return this.f44076b;
    }

    @Override // ya.S
    public boolean I0() {
        return this.f44078d;
    }

    @Override // ya.K0
    /* renamed from: O0 */
    public AbstractC5990d0 L0(boolean z10) {
        return z10 == I0() ? this : z10 ? new C5986b0(this) : new Z(this);
    }

    @Override // ya.K0
    /* renamed from: P0 */
    public AbstractC5990d0 N0(s0 newAttributes) {
        kotlin.jvm.internal.p.i(newAttributes, "newAttributes");
        return newAttributes.isEmpty() ? this : new C5994f0(this, newAttributes);
    }

    @Override // ya.K0
    /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public AbstractC5990d0 R0(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        AbstractC5990d0 abstractC5990d0Invoke = this.f44080f.invoke(kotlinTypeRefiner);
        return abstractC5990d0Invoke == null ? this : abstractC5990d0Invoke;
    }

    @Override // ya.S
    public InterfaceC5238k m() {
        return this.f44079e;
    }
}
