package androidx.fragment.app;

/* loaded from: classes.dex */
public final class p0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3796a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q0 f3797b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r0 f3798c;

    public /* synthetic */ p0(r0 r0Var, q0 q0Var, int i4) {
        this.f3796a = i4;
        this.f3798c = r0Var;
        this.f3797b = q0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f3796a;
        q0 q0Var = this.f3797b;
        r0 r0Var = this.f3798c;
        switch (i4) {
            case 0:
                if (r0Var.f3826b.contains(q0Var)) {
                    B0.g.a(q0Var.f3801a, q0Var.f3803c.mView);
                    break;
                }
                break;
            default:
                r0Var.f3826b.remove(q0Var);
                r0Var.f3827c.remove(q0Var);
                break;
        }
    }
}
