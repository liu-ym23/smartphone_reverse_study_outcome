package androidx.appcompat.widget;

import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.Window;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuPresenter;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface DecorContentParent {
    boolean canShowOverflowMenu();

    void dismissPopups();

    CharSequence getTitle();

    boolean hasIcon();

    boolean hasLogo();

    boolean hideOverflowMenu();

    void initFeature(int r10);

    boolean isOverflowMenuShowPending();

    boolean isOverflowMenuShowing();

    void restoreToolbarHierarchyState(SparseArray<Parcelable> r10);

    void saveToolbarHierarchyState(SparseArray<Parcelable> r10);

    void setIcon(int r10);

    void setIcon(Drawable r10);

    void setLogo(int r10);

    void setMenu(Menu r10, MenuPresenter.Callback r11);

    void setMenuPrepared();

    void setUiOptions(int r10);

    void setWindowCallback(Window.Callback r10);

    void setWindowTitle(CharSequence r10);

    boolean showOverflowMenu();
}
