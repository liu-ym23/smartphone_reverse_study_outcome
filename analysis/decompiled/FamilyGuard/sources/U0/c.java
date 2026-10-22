package U0;

import X0.k;

@Deprecated
/* loaded from: classes.dex */
public abstract class c<Z> extends a<Z> {

    /* renamed from: b, reason: collision with root package name */
    private final int f5438b;

    /* renamed from: c, reason: collision with root package name */
    private final int f5439c;

    public c() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // U0.e
    public void b(d dVar) {
    }

    @Override // U0.e
    public final void e(d dVar) {
        if (k.s(this.f5438b, this.f5439c)) {
            dVar.d(this.f5438b, this.f5439c);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f5438b + " and height: " + this.f5439c + ", either provide dimensions in the constructor or call override()");
    }

    public c(int i5, int i6) {
        this.f5438b = i5;
        this.f5439c = i6;
    }
}
