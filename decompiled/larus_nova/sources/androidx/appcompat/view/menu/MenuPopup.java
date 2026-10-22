package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes2.dex */
abstract class MenuPopup implements ShowableListMenu, MenuPresenter, AdapterView.OnItemClickListener {
    private Rect mEpicenterBounds;

    public MenuPopup() {
    }

    public abstract void addMenu(MenuBuilder r100);

    public boolean closeMenuOnSubMenuOpened() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder r100, MenuItemImpl r101) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder r100, MenuItemImpl r101) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context r100, MenuBuilder r101) {
    }

    public abstract void setAnchorView(View r100);

    public abstract void setForceShowIcon(boolean r100);

    public abstract void setGravity(int r100);

    public abstract void setHorizontalOffset(int r100);

    public abstract void setOnDismissListener(PopupWindow.OnDismissListener r100);

    public abstract void setShowTitle(boolean r100);

    public abstract void setVerticalOffset(int r100);

    public Rect getEpicenterBounds() {
        return this.mEpicenterBounds;
    }

    public static boolean shouldPreserveIconSpacing(MenuBuilder r100) {
        int r101 = r100.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L15;
        MenuItem r103 = r100.getItem(r102);
        if (r103.isVisible() == false) goto L9;
        if (r103.getIcon() == null) goto L9;
        return true;
    L9:
        r102 = r102 + 1;
        goto L3
    L15:
        return false;
    }

    public static MenuAdapter toMenuAdapter(ListAdapter r100) {
        if ((r100 instanceof HeaderViewListAdapter) == false) goto L7;
        return (MenuAdapter) ((HeaderViewListAdapter) r100).getWrappedAdapter();
    L7:
        return (MenuAdapter) r100;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup r100) {
        throw new UnsupportedOperationException("MenuPopups manage their own views");
    }

    public void setEpicenterBounds(Rect r100) {
        this.mEpicenterBounds = r100;
    }

    public static int measureIndividualMenuWidth(ListAdapter r100, ViewGroup r110, Context r111, int r112) {
        int r101 = 0;
        int r102 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r103 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r104 = r100.getCount();
        View r105 = null;
        int r106 = 0;
        int r107 = 0;
    L3:
        if (r101 >= r104) goto L15;
        int r108 = r100.getItemViewType(r101);
        if (r108 == r107) goto L7;
        r105 = null;
        r107 = r108;
    L7:
        if (r110 != null) goto L9;
        r110 = new FrameLayout(r111);
    L9:
        r105 = r100.getView(r101, r105, r110);
        r105.measure(r102, r103);
        int r109 = r105.getMeasuredWidth();
        if (r109 >= r112) goto L11;
        if (r109 <= r106) goto L14;
        r106 = r109;
    L14:
        r101 = r101 + 1;
        goto L3
    L11:
        return r112;
    L15:
        return r106;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r100, View r101, int r102, long r103) {
        ListAdapter r104 = (ListAdapter) r100.getAdapter();
        MenuBuilder r105 = toMenuAdapter(r104).mAdapterMenu;
        MenuItem r106 = (MenuItem) r104.getItem(r102);
        if (closeMenuOnSubMenuOpened() == false) goto L5;
        int r107 = 0;
    L6:
        r105.performItemAction(r106, this, r107);
        return;
    L5:
        r107 = 4;
        goto L6
    }
}
