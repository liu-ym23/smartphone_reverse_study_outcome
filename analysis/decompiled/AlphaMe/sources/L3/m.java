package L3;

import K.AbstractC0072d;
import android.view.ActionProvider;
import android.view.SubMenu;

/* loaded from: classes2.dex */
public abstract class m extends AbstractC0072d {

    /* renamed from: a, reason: collision with root package name */
    public final ActionProvider f1331a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f1332b;

    public m(q qVar, ActionProvider actionProvider) {
        this.f1332b = qVar;
        this.f1331a = actionProvider;
    }

    @Override // K.AbstractC0072d
    public final boolean a() {
        return this.f1331a.hasSubMenu();
    }

    @Override // K.AbstractC0072d
    public final boolean d() {
        return this.f1331a.onPerformDefaultAction();
    }

    @Override // K.AbstractC0072d
    public final void e(SubMenu subMenu) {
        this.f1332b.getClass();
        this.f1331a.onPrepareSubMenu(subMenu);
    }
}
