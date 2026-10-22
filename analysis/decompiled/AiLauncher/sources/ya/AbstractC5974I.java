package ya;

import java.util.List;
import ra.InterfaceC5238k;

/* renamed from: ya.I, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5974I extends K0 implements Ca.e {

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC5990d0 f44028b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC5990d0 f44029c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC5974I(AbstractC5990d0 lowerBound, AbstractC5990d0 upperBound) {
        super(null);
        kotlin.jvm.internal.p.i(lowerBound, "lowerBound");
        kotlin.jvm.internal.p.i(upperBound, "upperBound");
        this.f44028b = lowerBound;
        this.f44029c = upperBound;
    }

    @Override // ya.S
    public List<B0> F0() {
        return O0().F0();
    }

    @Override // ya.S
    public s0 G0() {
        return O0().G0();
    }

    @Override // ya.S
    public v0 H0() {
        return O0().H0();
    }

    @Override // ya.S
    public boolean I0() {
        return O0().I0();
    }

    public abstract AbstractC5990d0 O0();

    public final AbstractC5990d0 P0() {
        return this.f44028b;
    }

    public final AbstractC5990d0 Q0() {
        return this.f44029c;
    }

    public abstract String R0(kotlin.reflect.jvm.internal.impl.renderer.b bVar, kotlin.reflect.jvm.internal.impl.renderer.c cVar);

    @Override // ya.S
    public InterfaceC5238k m() {
        return O0().m();
    }

    public String toString() {
        return kotlin.reflect.jvm.internal.impl.renderer.b.f35920k.S(this);
    }
}
