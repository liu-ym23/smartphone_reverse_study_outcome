package androidx.appcompat.widget;

import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.Window;
import androidx.appcompat.view.menu.MenuPresenter;

/* JADX INFO: loaded from: classes2.dex */
public interface DecorContentParent {
    boolean canShowOverflowMenu();

    void dismissPopups();

    CharSequence getTitle();

    boolean hasIcon();

    boolean hasLogo();

    boolean hideOverflowMenu();

    void initFeature(int r100);

    boolean isOverflowMenuShowPending();

    boolean isOverflowMenuShowing();

    void restoreToolbarHierarchyState(SparseArray<Parcelable> r100);

    void saveToolbarHierarchyState(SparseArray<Parcelable> r100);

    void setIcon(int r100);

    void setIcon(Drawable r100);

    void setLogo(int r100);

    void setMenu(Menu r100, MenuPresenter.Callback r101);

    void setMenuPrepared();

    void setUiOptions(int r100);

    void setWindowCallback(Window.Callback r100);

    void setWindowTitle(CharSequence r100);

    boolean showOverflowMenu();
}
