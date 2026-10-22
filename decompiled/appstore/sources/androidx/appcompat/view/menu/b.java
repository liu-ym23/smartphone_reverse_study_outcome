package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements MenuPresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MenuBuilder f534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LayoutInflater f535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LayoutInflater f536e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MenuPresenter.Callback f537f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f538g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f539h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MenuView f540i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f541j;

    public b(Context r10, int r11, int r12) {
        this.f532a = r10;
        this.f535d = LayoutInflater.from(r10);
        this.f538g = r11;
        this.f539h = r12;
    }

    public void a(View r10, int r11) {
        ViewGroup r12 = (ViewGroup) r10.getParent();
        if (r12 == null) goto L5;
        r12.removeView(r10);
    L5:
        ((ViewGroup) this.f540i).addView(r10, r11);
    }

    public abstract void b(g r10, MenuView.ItemView r11);

    public MenuView.ItemView c(ViewGroup r10) {
        return (MenuView.ItemView) this.f535d.inflate(this.f539h, r10, false);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder r10, g r11) {
        return false;
    }

    public boolean d(ViewGroup r10, int r11) {
        r10.removeViewAt(r11);
        return true;
    }

    public MenuPresenter.Callback e() {
        return this.f537f;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder r10, g r11) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View f(g r10, View r11, ViewGroup r12) {
        if ((r11 instanceof MenuView.ItemView) == false) goto L5;
        MenuView.ItemView r13 = (MenuView.ItemView) r11;
    L6:
        b(r10, r13);
        return (View) r13;
    L5:
        r13 = c(r12);
        goto L6
    }

    public void g(int r10) {
        this.f541j = r10;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f541j;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup r10) {
        if (this.f540i != null) goto L6;
        MenuView r11 = (MenuView) this.f535d.inflate(this.f538g, r10, false);
        this.f540i = r11;
        r11.initialize(this.f534c);
        updateMenuView(true);
    L6:
        return this.f540i;
    }

    public abstract boolean h(int r10, g r11);

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context r10, MenuBuilder r11) {
        this.f533b = r10;
        this.f536e = LayoutInflater.from(r10);
        this.f534c = r11;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r10, boolean r11) {
        MenuPresenter.Callback r12 = this.f537f;
        if (r12 == null) goto L6;
        r12.onCloseMenu(r10, r11);
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(m r10) {
        MenuPresenter.Callback r11 = this.f537f;
        MenuBuilder r12 = r10;
        if (r11 == null) goto L9;
        if (r10 != null) goto L8;
        r12 = this.f534c;
    L8:
        return r11.onOpenSubMenu(r12);
    L9:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r10) {
        this.f537f = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r10) {
        ViewGroup r11 = (ViewGroup) this.f540i;
        if (r11 != null) goto L5;
        return;
    L5:
        MenuBuilder r12 = this.f534c;
        int r13 = 0;
        if (r12 == null) goto L24;
        r12.flagActionItems();
        ArrayList<g> r14 = this.f534c.getVisibleItems();
        int r15 = r14.size();
        int r16 = 0;
        int r17 = 0;
    L8:
        if (r16 >= r15) goto L22;
        g r18 = r14.get(r16);
        if (h(r17, r18) == false) goto L21;
        View r19 = r11.getChildAt(r17);
        if ((r19 instanceof MenuView.ItemView) == false) goto L14;
        g r20 = ((MenuView.ItemView) r19).getItemData();
    L15:
        View r21 = f(r18, r19, r11);
        if (r18 == r20) goto L18;
        r21.setPressed(false);
        r21.jumpDrawablesToCurrentState();
    L18:
        if (r21 == r19) goto L20;
        a(r21, r17);
    L20:
        r17 = r17 + 1;
        goto L21
    L14:
        r20 = null;
    L21:
        r16 = r16 + 1;
        goto L8
    L22:
        r13 = r17;
    L24:
        if (r13 >= r11.getChildCount()) goto L28;
        if (d(r11, r13) == true) goto L24;
        r13 = r13 + 1;
        goto L24
    }
}
