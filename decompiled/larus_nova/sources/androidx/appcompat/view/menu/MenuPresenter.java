package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Parcelable;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public interface MenuPresenter {

    public interface Callback {
        void onCloseMenu(MenuBuilder r100, boolean r101);

        boolean onOpenSubMenu(MenuBuilder r100);
    }

    boolean collapseItemActionView(MenuBuilder r100, MenuItemImpl r101);

    boolean expandItemActionView(MenuBuilder r100, MenuItemImpl r101);

    boolean flagActionItems();

    int getId();

    MenuView getMenuView(ViewGroup r100);

    void initForMenu(Context r100, MenuBuilder r101);

    void onCloseMenu(MenuBuilder r100, boolean r101);

    void onRestoreInstanceState(Parcelable r100);

    Parcelable onSaveInstanceState();

    boolean onSubMenuSelected(SubMenuBuilder r100);

    void setCallback(Callback r100);

    void updateMenuView(boolean r100);
}
