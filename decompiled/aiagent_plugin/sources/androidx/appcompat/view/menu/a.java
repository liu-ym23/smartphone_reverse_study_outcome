package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: BaseMenuPresenter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Context f326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected MenuBuilder f327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected LayoutInflater f328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected LayoutInflater f329e;
    protected e f;
    private d.a g;
    private int h;
    private int i;
    private int j;

    public abstract void a(MenuItemImpl r1, e.a r2);

    public boolean a(int r1, MenuItemImpl r2) {
        return true;
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean collapseItemActionView(MenuBuilder r1, MenuItemImpl r2) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean expandItemActionView(MenuBuilder r1, MenuItemImpl r2) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean flagActionItems() {
        return false;
    }

    public a(Context r3, int r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f325a = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
        this.f328d = LayoutInflater.from(r6);
        this.h = r4;
        this.i = r5;
    }

    @Override // androidx.appcompat.view.menu.d
    public void initForMenu(Context r3, MenuBuilder r4) {
        Context r5 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f326b = r5;
        this.f329e = LayoutInflater.from(r5);
        this.f327c = r4;
    }

    public e a(ViewGroup r5) {
        if (this.f != null) goto L6;
        e r6 = (e) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(this.f328d, this.h, r5, false, "com.obric.aiagent.plugin"), e.class, "com.obric.aiagent.plugin");
        this.f = r6;
        r6.initialize(this.f327c);
        updateMenuView(true);
    L6:
        return this.f;
    }

    @Override // androidx.appcompat.view.menu.d
    public void updateMenuView(boolean r11) {
        ViewGroup r12 = (ViewGroup) ZeusTransformUtils.preCheckCast(this.f, ViewGroup.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L5;
        return;
    L5:
        MenuBuilder r0 = this.f327c;
        int r2 = 0;
        if (r0 == null) goto L24;
        r0.flagActionItems();
        ArrayList<MenuItemImpl> r1 = this.f327c.getVisibleItems();
        int r3 = r1.size();
        int r4 = 0;
        int r5 = 0;
    L8:
        if (r4 >= r3) goto L22;
        MenuItemImpl r6 = (MenuItemImpl) ZeusTransformUtils.preCheckCast(r1.get(r4), MenuItemImpl.class, "com.obric.aiagent.plugin");
        if (a(r5, r6) == false) goto L21;
        View r7 = r12.getChildAt(r5);
        if (ZeusTransformUtils.instanceOf(r7, e.a.class) == false) goto L14;
        MenuItemImpl r8 = ((e.a) ZeusTransformUtils.preCheckCast(r7, e.a.class, "com.obric.aiagent.plugin")).getItemData();
    L15:
        View r9 = a(r6, r7, r12);
        if (r6 == r8) goto L18;
        r9.setPressed(false);
        r9.jumpDrawablesToCurrentState();
    L18:
        if (r9 == r7) goto L20;
        a(r9, r5);
    L20:
        r5 = r5 + 1;
        goto L21
    L14:
        r8 = null;
    L21:
        r4 = r4 + 1;
        goto L8
    L22:
        r2 = r5;
    L24:
        if (r2 >= r12.getChildCount()) goto L28;
        if (a(r12, r2) == true) goto L24;
        r2 = r2 + 1;
        goto L24
    }

    public void a(View r4, int r5) {
        ViewGroup r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(r4.getParent(), ViewGroup.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        r0.removeView(r4);
    L5:
        ((ViewGroup) ZeusTransformUtils.preCheckCast(this.f, ViewGroup.class, "com.obric.aiagent.plugin")).addView(r4, r5);
    }

    public boolean a(ViewGroup r1, int r2) {
        r1.removeViewAt(r2);
        return true;
    }

    @Override // androidx.appcompat.view.menu.d
    public void setCallback(d.a r3) {
        this.g = (d.a) ZeusTransformUtils.wrapperContextForParams(r3, d.a.class, "com.obric.aiagent.plugin");
    }

    public d.a a() {
        return this.g;
    }

    public e.a b(ViewGroup r4) {
        return (e.a) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(this.f328d, this.i, r4, false, "com.obric.aiagent.plugin"), e.a.class, "com.obric.aiagent.plugin");
    }

    public View a(MenuItemImpl r3, View r4, ViewGroup r5) {
        if (ZeusTransformUtils.instanceOf(r4, e.a.class) == false) goto L5;
        e.a r6 = (e.a) ZeusTransformUtils.preCheckCast(r4, e.a.class, "com.obric.aiagent.plugin");
    L6:
        a(r3, r6);
        return (View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin");
    L5:
        r6 = b(r5);
        goto L6
    }

    @Override // androidx.appcompat.view.menu.d
    public void onCloseMenu(MenuBuilder r1, boolean r2) {
        d.a r0 = this.g;
        if (r0 == null) goto L6;
        r0.onCloseMenu(r1, r2);
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
    @Override // androidx.appcompat.view.menu.d
    public boolean onSubMenuSelected(SubMenuBuilder r2) {
        d.a r0 = this.g;
        MenuBuilder r3 = r2;
        if (r0 == null) goto L9;
        if (r2 != null) goto L8;
        r3 = this.f327c;
    L8:
        return r0.onOpenSubMenu(r3);
    L9:
        return false;
    }

    @Override // androidx.appcompat.view.menu.d
    public int getId() {
        return this.j;
    }

    public void a(int r1) {
        this.j = r1;
    }
}
