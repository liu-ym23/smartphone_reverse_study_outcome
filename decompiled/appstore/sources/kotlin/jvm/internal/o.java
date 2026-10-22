package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes4.dex */
public final class o extends t {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f21183d;

    public o(int r10) {
        super(r10);
        this.f21183d = new float[r10];
    }

    @Override // kotlin.jvm.internal.t
    public /* bridge */ /* synthetic */ int c(Object r10) {
        return h((float[]) r10);
    }

    public final void g(float r10) {
        float[] r11 = this.f21183d;
        int r12 = b();
        d(r12 + 1);
        r11[r12] = r10;
    }

    public int h(float[] r10) {
        q.g(r10, "<this>");
        return r10.length;
    }

    public final float[] i() {
        return (float[]) f(this.f21183d, new float[e()]);
    }
}
