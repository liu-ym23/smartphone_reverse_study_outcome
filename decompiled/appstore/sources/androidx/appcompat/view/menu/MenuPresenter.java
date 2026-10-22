package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface MenuPresenter {

    public interface Callback {
        void onCloseMenu(@NonNull MenuBuilder r10, boolean r11);

        boolean onOpenSubMenu(@NonNull MenuBuilder r10);
    }

    boolean collapseItemActionView(MenuBuilder r10, g r11);

    boolean expandItemActionView(MenuBuilder r10, g r11);

    boolean flagActionItems();

    int getId();

    MenuView getMenuView(ViewGroup r10);

    void initForMenu(Context r10, MenuBuilder r11);

    void onCloseMenu(MenuBuilder r10, boolean r11);

    void onRestoreInstanceState(Parcelable r10);

    Parcelable onSaveInstanceState();

    boolean onSubMenuSelected(m r10);

    void setCallback(Callback r10);

    void updateMenuView(boolean r10);
}
