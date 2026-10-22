package nc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h0 implements kc.g0 {

    /* renamed from: c, reason: collision with root package name */
    public j0 f8842c;

    /* renamed from: f, reason: collision with root package name */
    public long f8843f;

    /* renamed from: g, reason: collision with root package name */
    public Object f8844g;

    /* renamed from: h, reason: collision with root package name */
    public kc.g f8845h;

    @Override // kc.g0
    public final void dispose() {
        j0 j0Var = this.f8842c;
        synchronized (j0Var) {
            if (this.f8843f < j0Var.m()) {
                return;
            }
            Object[] objArr = j0Var.f8862l;
            objArr.getClass();
            long j10 = this.f8843f;
            if (objArr[((int) j10) & (objArr.length - 1)] != this) {
                return;
            }
            k0.c(objArr, j10, k0.f8871a);
            j0Var.h();
        }
    }
}
