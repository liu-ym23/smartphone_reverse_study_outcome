package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseMenuPresenter implements MenuPresenter {
    private MenuPresenter.Callback mCallback;
    protected Context mContext;
    private int mId;
    protected LayoutInflater mInflater;
    private int mItemLayoutRes;
    protected MenuBuilder mMenu;
    private int mMenuLayoutRes;
    protected MenuView mMenuView;
    protected Context mSystemContext;
    protected LayoutInflater mSystemInflater;

    public abstract void bindItemView(MenuItemImpl r100, MenuView.ItemView r101);

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder r100, MenuItemImpl r101) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder r100, MenuItemImpl r101) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    public boolean shouldIncludeItem(int r100, MenuItemImpl r101) {
        return true;
    }

    public MenuPresenter.Callback getCallback() {
        return this.mCallback;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.mId;
    }

    public MenuView.ItemView createItemView(ViewGroup r100) {
        return (MenuView.ItemView) this.mSystemInflater.inflate(this.mItemLayoutRes, r100, false);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup r100) {
        if (this.mMenuView != null) goto L6;
        MenuView r101 = (MenuView) this.mSystemInflater.inflate(this.mMenuLayoutRes, r100, false);
        this.mMenuView = r101;
        r101.initialize(this.mMenu);
        updateMenuView(true);
    L6:
        return this.mMenuView;
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
    public boolean onSubMenuSelected(SubMenuBuilder r100) {
        MenuPresenter.Callback r101 = this.mCallback;
        MenuBuilder r102 = r100;
        if (r101 == null) goto L9;
        if (r100 != null) goto L8;
        r102 = this.mMenu;
    L8:
        return r101.onOpenSubMenu(r102);
    L9:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r100) {
        this.mCallback = r100;
    }

    public void setId(int r100) {
        this.mId = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r110) {
        ViewGroup r111 = (ViewGroup) this.mMenuView;
        if (r111 != null) goto L5;
        return;
    L5:
        MenuBuilder r100 = this.mMenu;
        int r101 = 0;
        if (r100 == null) goto L24;
        r100.flagActionItems();
        ArrayList<MenuItemImpl> r102 = this.mMenu.getVisibleItems();
        int r103 = r102.size();
        int r104 = 0;
        int r105 = 0;
    L8:
        if (r104 >= r103) goto L22;
        MenuItemImpl r106 = (MenuItemImpl) ListProtector.get(r102, r104);
        if (shouldIncludeItem(r105, r106) == false) goto L21;
        View r107 = r111.getChildAt(r105);
        if ((r107 instanceof MenuView.ItemView) == false) goto L14;
        MenuItemImpl r108 = ((MenuView.ItemView) r107).getItemData();
    L15:
        View r109 = getItemView(r106, r107, r111);
        if (r106 == r108) goto L18;
        r109.setPressed(false);
        r109.jumpDrawablesToCurrentState();
    L18:
        if (r109 == r107) goto L20;
        addItemView(r109, r105);
    L20:
        r105 = r105 + 1;
        goto L21
    L14:
        r108 = null;
    L21:
        r104 = r104 + 1;
        goto L8
    L22:
        r101 = r105;
    L24:
        if (r101 >= r111.getChildCount()) goto L28;
        if (filterLeftoverView(r111, r101) == true) goto L24;
        r101 = r101 + 1;
        goto L24
    }

    public void addItemView(View r100, int r101) {
        ViewGroup r102 = (ViewGroup) r100.getParent();
        if (r102 == null) goto L5;
        r102.removeView(r100);
    L5:
        ((ViewGroup) this.mMenuView).addView(r100, r101);
    }

    public boolean filterLeftoverView(ViewGroup r100, int r101) {
        r100.removeViewAt(r101);
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context r100, MenuBuilder r101) {
        this.mContext = r100;
        this.mInflater = LayoutInflater.from(r100);
        this.mMenu = r101;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r100, boolean r101) {
        MenuPresenter.Callback r102 = this.mCallback;
        if (r102 == null) goto L6;
        r102.onCloseMenu(r100, r101);
        return;
    }

    public BaseMenuPresenter(Context r100, int r101, int r102) {
        this.mSystemContext = r100;
        this.mSystemInflater = LayoutInflater.from(r100);
        this.mMenuLayoutRes = r101;
        this.mItemLayoutRes = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View getItemView(MenuItemImpl r100, View r101, ViewGroup r102) {
        if ((r101 instanceof MenuView.ItemView) == false) goto L5;
        MenuView.ItemView r103 = (MenuView.ItemView) r101;
    L6:
        bindItemView(r100, r103);
        return (View) r103;
    L5:
        r103 = createItemView(r102);
        goto L6
    }
}
