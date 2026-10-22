package com.google.android.material.appbar;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k implements z3.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2373a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2374b;

    @Override // z3.e
    public final void a(boolean z10) {
        switch (this.f2373a) {
            case 0:
                StepOSAppBarBehavior stepOSAppBarBehavior = (StepOSAppBarBehavior) this.f2374b;
                if (!stepOSAppBarBehavior.f2324r) {
                    stepOSAppBarBehavior.b();
                    break;
                }
                break;
            default:
                ve.d dVar = (ve.d) this.f2374b;
                dVar.f14943v = 0.0f;
                if (!z10) {
                    dVar.f14942u = 0;
                    dVar.e();
                    break;
                }
                break;
        }
    }
}
