package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.ViewPropertyAnimatorCompat;

/* JADX INFO: loaded from: classes2.dex */
public interface DecorToolbar {
    void animateToVisibility(int r100);

    boolean canShowOverflowMenu();

    void collapseActionView();

    void dismissPopupMenus();

    Context getContext();

    View getCustomView();

    int getDisplayOptions();

    int getDropdownItemCount();

    int getDropdownSelectedPosition();

    int getHeight();

    Menu getMenu();

    int getNavigationMode();

    CharSequence getSubtitle();

    CharSequence getTitle();

    ViewGroup getViewGroup();

    int getVisibility();

    boolean hasEmbeddedTabs();

    boolean hasExpandedActionView();

    boolean hasIcon();

    boolean hasLogo();

    boolean hideOverflowMenu();

    void initIndeterminateProgress();

    void initProgress();

    boolean isOverflowMenuShowPending();

    boolean isOverflowMenuShowing();

    boolean isTitleTruncated();

    void restoreHierarchyState(SparseArray<Parcelable> r100);

    void saveHierarchyState(SparseArray<Parcelable> r100);

    void setBackgroundDrawable(Drawable r100);

    void setCollapsible(boolean r100);

    void setCustomView(View r100);

    void setDefaultNavigationContentDescription(int r100);

    void setDefaultNavigationIcon(Drawable r100);

    void setDisplayOptions(int r100);

    void setDropdownParams(SpinnerAdapter r100, AdapterView.OnItemSelectedListener r101);

    void setDropdownSelectedPosition(int r100);

    void setEmbeddedTabView(ScrollingTabContainerView r100);

    void setHomeButtonEnabled(boolean r100);

    void setIcon(int r100);

    void setIcon(Drawable r100);

    void setLogo(int r100);

    void setLogo(Drawable r100);

    void setMenu(Menu r100, MenuPresenter.Callback r101);

    void setMenuCallbacks(MenuPresenter.Callback r100, MenuBuilder.Callback r101);

    void setMenuPrepared();

    void setNavigationContentDescription(int r100);

    void setNavigationContentDescription(CharSequence r100);

    void setNavigationIcon(int r100);

    void setNavigationIcon(Drawable r100);

    void setNavigationMode(int r100);

    void setSubtitle(CharSequence r100);

    void setTitle(CharSequence r100);

    void setVisibility(int r100);

    void setWindowCallback(Window.Callback r100);

    void setWindowTitle(CharSequence r100);

    ViewPropertyAnimatorCompat setupAnimatorToVisibility(int r100, long r101);

    boolean showOverflowMenu();
}
