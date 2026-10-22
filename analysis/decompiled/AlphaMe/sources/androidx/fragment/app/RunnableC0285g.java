package androidx.fragment.app;

/* renamed from: androidx.fragment.app.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0285g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q0 f3751a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q0 f3752b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f3753c;

    public RunnableC0285g(q0 q0Var, q0 q0Var2, boolean z4, q.f fVar) {
        this.f3751a = q0Var;
        this.f3752b = q0Var2;
        this.f3753c = z4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        D d4 = this.f3751a.f3803c;
        D d5 = this.f3752b.f3803c;
        k0 k0Var = f0.f3749a;
        if (this.f3753c) {
            d5.getEnterTransitionCallback();
        } else {
            d4.getEnterTransitionCallback();
        }
    }
}
