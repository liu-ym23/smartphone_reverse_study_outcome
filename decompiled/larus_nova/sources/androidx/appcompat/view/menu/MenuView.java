package androidx.appcompat.view.menu;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public interface MenuView {

    public interface ItemView {
        MenuItemImpl getItemData();

        void initialize(MenuItemImpl r100, int r101);

        boolean prefersCondensedTitle();

        void setCheckable(boolean r100);

        void setChecked(boolean r100);

        void setEnabled(boolean r100);

        void setIcon(Drawable r100);

        void setShortcut(boolean r100, char r101);

        void setTitle(CharSequence r100);

        boolean showsIcon();
    }

    int getWindowAnimations();

    void initialize(MenuBuilder r100);
}
