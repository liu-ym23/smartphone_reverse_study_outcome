package androidx.fragment.app;

import androidx.fragment.app.SpecialEffectsController;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f2132a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f2133b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f2134c;

    public g(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, boolean z, p.a aVar) {
        this.f2132a = operation;
        this.f2133b = operation2;
        this.f2134c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Fragment fragment = this.f2132a.f2056c;
        Fragment fragment2 = this.f2133b.f2056c;
        f0 f0Var = e0.f2123a;
        if (this.f2134c) {
            fragment2.getEnterTransitionCallback();
        } else {
            fragment.getEnterTransitionCallback();
        }
    }
}
