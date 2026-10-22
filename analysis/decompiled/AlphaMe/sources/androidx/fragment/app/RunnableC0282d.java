package androidx.fragment.app;

/* renamed from: androidx.fragment.app.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0282d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3725a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3726b;

    public /* synthetic */ RunnableC0282d(int i4, Object obj) {
        this.f3725a = i4;
        this.f3726b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f3725a;
        Object obj = this.f3726b;
        switch (i4) {
            case 0:
                AnimationAnimationListenerC0283e animationAnimationListenerC0283e = (AnimationAnimationListenerC0283e) obj;
                animationAnimationListenerC0283e.f3732b.endViewTransition(animationAnimationListenerC0283e.f3733c);
                animationAnimationListenerC0283e.f3734d.a();
                break;
            case 1:
                r rVar = (r) obj;
                rVar.f3812d.onDismiss(rVar.f3820l);
                break;
            default:
                ((Y) obj).x(true);
                break;
        }
    }
}
