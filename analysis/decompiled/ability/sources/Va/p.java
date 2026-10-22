package Va;

import androidx.core.view.ActionProvider;

/* loaded from: classes4.dex */
public final class p implements ActionProvider.VisibilityListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f1449a;

    public p(q qVar) {
        this.f1449a = qVar;
    }

    @Override // androidx.core.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z10) {
        n nVar = this.f1449a.n;
        nVar.g = true;
        nVar.o(true);
    }
}
