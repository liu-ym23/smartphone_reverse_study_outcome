package androidx.fragment.app;

/* renamed from: androidx.fragment.app.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0296s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3830a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ D f3831b;

    public /* synthetic */ RunnableC0296s(D d4, int i4) {
        this.f3830a = i4;
        this.f3831b = d4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f3830a;
        D d4 = this.f3831b;
        switch (i4) {
            case 0:
                d4.startPostponedEnterTransition();
                break;
            default:
                d4.callStartTransitionListener(false);
                break;
        }
    }
}
