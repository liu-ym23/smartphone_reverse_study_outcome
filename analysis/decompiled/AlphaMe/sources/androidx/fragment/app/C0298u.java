package androidx.fragment.app;

import android.view.View;

/* renamed from: androidx.fragment.app.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0298u extends J {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ D f3833a;

    public C0298u(D d4) {
        this.f3833a = d4;
    }

    @Override // androidx.fragment.app.J
    public final View b(int i4) {
        D d4 = this.f3833a;
        View view = d4.mView;
        if (view != null) {
            return view.findViewById(i4);
        }
        throw new IllegalStateException(B0.g.l("Fragment ", d4, " does not have a view"));
    }

    @Override // androidx.fragment.app.J
    public final boolean c() {
        return this.f3833a.mView != null;
    }
}
