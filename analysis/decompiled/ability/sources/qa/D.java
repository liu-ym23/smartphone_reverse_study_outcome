package qa;

/* loaded from: classes4.dex */
public final class D extends U {
    public final boolean d;

    public D(boolean z10) {
        this.d = z10;
    }

    @Override // qa.U
    public final void a(I i, Object obj) {
        if (obj == null) {
            return;
        }
        i.d(obj.toString(), null, this.d);
    }
}
