package D9;

/* loaded from: classes4.dex */
public final class f extends C4.a {
    public final boolean e;

    public f(B1.b bVar, boolean z10) {
        super(bVar);
        this.e = z10;
    }

    @Override // C4.a
    public final void r(String value) {
        kotlin.jvm.internal.k.f(value, "value");
        if (this.e) {
            super.r(value);
        } else {
            p(value);
        }
    }
}
