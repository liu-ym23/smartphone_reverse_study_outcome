package Va;

import android.content.Context;
import android.view.SubMenu;
import android.view.View;
import androidx.core.view.ActionProvider;

/* loaded from: classes4.dex */
public abstract class r extends ActionProvider {

    /* renamed from: a, reason: collision with root package name */
    public final android.view.ActionProvider f1463a;
    public final /* synthetic */ v b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(v vVar, Context context, android.view.ActionProvider actionProvider) {
        super(context);
        this.b = vVar;
        this.f1463a = actionProvider;
    }

    @Override // androidx.core.view.ActionProvider
    public final boolean hasSubMenu() {
        return this.f1463a.hasSubMenu();
    }

    @Override // androidx.core.view.ActionProvider
    public final View onCreateActionView() {
        return this.f1463a.onCreateActionView();
    }

    @Override // androidx.core.view.ActionProvider
    public final boolean onPerformDefaultAction() {
        return this.f1463a.onPerformDefaultAction();
    }

    @Override // androidx.core.view.ActionProvider
    public final void onPrepareSubMenu(SubMenu subMenu) {
        this.f1463a.onPrepareSubMenu(this.b.Q0(subMenu));
    }
}
