package ya;

/* renamed from: ya.A, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5966A extends AbstractC6019z {

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC5990d0 f44001b;

    public AbstractC5966A(AbstractC5990d0 delegate) {
        kotlin.jvm.internal.p.i(delegate, "delegate");
        this.f44001b = delegate;
    }

    @Override // ya.K0
    /* renamed from: O0 */
    public AbstractC5990d0 L0(boolean z10) {
        return z10 == I0() ? this : Q0().L0(z10).N0(G0());
    }

    @Override // ya.K0
    /* renamed from: P0 */
    public AbstractC5990d0 N0(s0 newAttributes) {
        kotlin.jvm.internal.p.i(newAttributes, "newAttributes");
        return newAttributes != G0() ? new C5994f0(this, newAttributes) : this;
    }

    @Override // ya.AbstractC6019z
    public AbstractC5990d0 Q0() {
        return this.f44001b;
    }
}
