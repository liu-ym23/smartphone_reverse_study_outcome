package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class CascadingMenuPopup extends MenuPopup implements View.OnKeyListener, PopupWindow.OnDismissListener {
    static final int HORIZ_POSITION_LEFT = 0;
    static final int HORIZ_POSITION_RIGHT = 1;
    private static final int ITEM_LAYOUT = 2131558417;
    static final int SUBMENU_TIMEOUT_MS = 200;
    private View mAnchorView;
    private final View.OnAttachStateChangeListener mAttachStateChangeListener;
    private final Context mContext;
    private int mDropDownGravity;
    private boolean mForceShowIcon;
    final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    private boolean mHasXOffset;
    private boolean mHasYOffset;
    private int mLastPosition;
    private final MenuItemHoverListener mMenuItemHoverListener;
    private final int mMenuMaxWidth;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private final List<MenuBuilder> mPendingMenus;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter.Callback mPresenterCallback;
    private int mRawDropDownGravity;
    boolean mShouldCloseImmediately;
    private boolean mShowTitle;
    final List<CascadingMenuInfo> mShowingMenus;
    View mShownAnchorView;
    final Handler mSubMenuHoverHandler;
    ViewTreeObserver mTreeObserver;
    private int mXOffset;
    private int mYOffset;

    public static class CascadingMenuInfo {
        public final MenuBuilder menu;
        public final int position;
        public final MenuPopupWindow window;

        public ListView getListView() {
            return this.window.getListView();
        }

        public CascadingMenuInfo(MenuPopupWindow r100, MenuBuilder r101, int r102) {
            this.window = r100;
            this.menu = r101;
            this.position = r102;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface HorizPosition {
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public boolean closeMenuOnSubMenuOpened() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable r100) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        return null;
    }

    private MenuPopupWindow createPopupWindow() {
        MenuPopupWindow r100 = new MenuPopupWindow(this.mContext, null, this.mPopupStyleAttr, this.mPopupStyleRes);
        r100.setHoverListener(this.mMenuItemHoverListener);
        r100.setOnItemClickListener(this);
        r100.setOnDismissListener(this);
        r100.setAnchorView(this.mAnchorView);
        r100.setDropDownGravity(this.mDropDownGravity);
        r100.setModal(true);
        r100.setInputMethodMode(2);
        return r100;
    }

    private int getInitialMenuPosition() {
        if (ViewCompat.getLayoutDirection(this.mAnchorView) != 1) goto L6;
        return 0;
    L6:
        return 1;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        int r100 = this.mShowingMenus.size();
        if (r100 <= 0) goto L10;
        CascadingMenuInfo[] r101 = (CascadingMenuInfo[]) this.mShowingMenus.toArray(new CascadingMenuInfo[r100]);
        int r102 = r100 - 1;
    L5:
        if (r102 < 0) goto L14;
        CascadingMenuInfo r103 = r101[r102];
        if (r103.window.isShowing() == false) goto L9;
        r103.window.dismiss();
    L9:
        r102 = r102 - 1;
        goto L5
    L14:
        return;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView getListView() {
        if (this.mShowingMenus.isEmpty() == false) goto L5;
        return null;
    L5:
        List<CascadingMenuInfo> r100 = this.mShowingMenus;
        return ((CascadingMenuInfo) ListProtector.get(r100, r100.size() - 1)).getListView();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        if (this.mShowingMenus.size() > 0) goto L5;
        return false;
    L5:
        if (((CascadingMenuInfo) ListProtector.get(this.mShowingMenus, 0)).window.isShowing() == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        int r100 = this.mShowingMenus.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L8;
        CascadingMenuInfo r102 = (CascadingMenuInfo) ListProtector.get(this.mShowingMenus, r101);
        if (r102.window.isShowing() == false) goto L9;
        r101 = r101 + 1;
    L9:
        if (r102 == null) goto L14;
        r102.menu.close(false);
        return;
    L14:
        return;
    L8:
        r102 = null;
        goto L9
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        if (isShowing() == false) goto L5;
        return;
    L5:
        Iterator<MenuBuilder> r100 = this.mPendingMenus.iterator();
    L7:
        if (r100.hasNext() == false) goto L9;
        showMenu(r100.next());
        goto L7
    L9:
        this.mPendingMenus.clear();
        View r101 = this.mAnchorView;
        this.mShownAnchorView = r101;
        if (r101 != null) goto L12;
        return;
    L12:
        if (this.mTreeObserver != null) goto L14;
        boolean r102 = true;
    L15:
        ViewTreeObserver r103 = r101.getViewTreeObserver();
        this.mTreeObserver = r103;
        if (r102 == false) goto L18;
        r103.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
    L18:
        this.mShownAnchorView.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
        return;
    L14:
        r102 = false;
        goto L15
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_view_menu_CascadingMenuPopup_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private int findIndexOfAddedMenu(MenuBuilder r100) {
        int r101 = this.mShowingMenus.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (r100 == ((CascadingMenuInfo) ListProtector.get(this.mShowingMenus, r102)).menu) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return r102;
    L8:
        return -1;
    }

    private int getNextMenuPosition(int r100) {
        List<CascadingMenuInfo> r101 = this.mShowingMenus;
        ListView r102 = ((CascadingMenuInfo) ListProtector.get(r101, r101.size() - 1)).getListView();
        int[] r103 = new int[2];
        r102.getLocationOnScreen(r103);
        Rect r104 = new Rect();
        this.mShownAnchorView.getWindowVisibleDisplayFrame(r104);
        if (this.mLastPosition != 1) goto L9;
        if (((r103[0] + r102.getWidth()) + r100) <= r104.right) goto L7;
        return 0;
    L7:
        return 1;
    L9:
        if ((r103[0] - r100) >= 0) goto L11;
        return 1;
    L11:
        return 0;
    }

    private void showMenu(MenuBuilder r110) {
        LayoutInflater r100 = LayoutInflater.from(this.mContext);
        MenuAdapter r101 = new MenuAdapter(r110, r100, this.mOverflowOnly, ITEM_LAYOUT);
        if (isShowing() == true) goto L8;
        if (this.mForceShowIcon == false) goto L8;
        r101.setForceShowIcon(true);
    L10:
        int r102 = MenuPopup.measureIndividualMenuWidth(r101, null, this.mContext, this.mMenuMaxWidth);
        MenuPopupWindow r103 = createPopupWindow();
        r103.setAdapter(r101);
        r103.setContentWidth(r102);
        r103.setDropDownGravity(this.mDropDownGravity);
        if (this.mShowingMenus.size() <= 0) goto L13;
        List<CascadingMenuInfo> r104 = this.mShowingMenus;
        CascadingMenuInfo r105 = (CascadingMenuInfo) ListProtector.get(r104, r104.size() - 1);
        View r106 = findParentViewForSubmenu(r105, r110);
    L15:
        if (r106 == null) goto L38;
        r103.setTouchModal(false);
        r103.setEnterTransition(null);
        int r107 = getNextMenuPosition(r102);
        if (r107 != 1) goto L19;
        boolean r108 = true;
    L20:
        this.mLastPosition = r107;
        if (Build.VERSION.SDK_INT < 26) goto L23;
        r103.setAnchorView(r106);
        int r109 = 0;
        int r111 = 0;
    L28:
        if ((this.mDropDownGravity & 5) != 5) goto L32;
        if (r108 == true) goto L34;
        r102 = r106.getWidth();
    L35:
        int r112 = r111 - r102;
    L36:
        r103.setHorizontalOffset(r112);
        r103.setOverlapAnchor(true);
        r103.setVerticalOffset(r109);
    L44:
        this.mShowingMenus.add(new CascadingMenuInfo(r103, r110, this.mLastPosition));
        r103.show();
        ListView r113 = r103.getListView();
        r113.setOnKeyListener(this);
        if (r105 == null) goto L47;
        return;
    L47:
        if (this.mShowTitle == true) goto L49;
        return;
    L49:
        if (r110.getHeaderTitle() == null) goto L54;
        FrameLayout r114 = (FrameLayout) r100.inflate(R.layout.abc_popup_menu_header_item_layout, r113, false);
        TextView r115 = (TextView) r114.findViewById(android.R.id.title);
        r114.setEnabled(false);
        r115.setText(r110.getHeaderTitle());
        r113.addHeaderView(r114, null, false);
        r103.show();
        return;
    L54:
        return;
    L34:
        r112 = r111 + r102;
        goto L36
    L32:
        if (r108 == false) goto L35;
        r102 = r106.getWidth();
        goto L34
    L23:
        int[] r116 = new int[2];
        this.mAnchorView.getLocationOnScreen(r116);
        int[] r117 = new int[2];
        r106.getLocationOnScreen(r117);
        if ((this.mDropDownGravity & 7) != 5) goto L26;
        r116[0] = r116[0] + this.mAnchorView.getWidth();
        r117[0] = r117[0] + r106.getWidth();
    L26:
        r111 = r117[0] - r116[0];
        r109 = r117[1] - r116[1];
        goto L28
    L19:
        r108 = false;
        goto L20
    L38:
        if (this.mHasXOffset == false) goto L41;
        r103.setHorizontalOffset(this.mXOffset);
    L41:
        if (this.mHasYOffset == false) goto L43;
        r103.setVerticalOffset(this.mYOffset);
    L43:
        r103.setEpicenterBounds(getEpicenterBounds());
        goto L44
    L13:
        r105 = null;
        r106 = null;
    L8:
        if (isShowing() == false) goto L10;
        r101.setForceShowIcon(MenuPopup.shouldPreserveIconSpacing(r110));
        goto L10
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void addMenu(MenuBuilder r100) {
        r100.addMenuPresenter(this, this.mContext);
        if (isShowing() == false) goto L5;
        showMenu(r100);
        return;
    L5:
        this.mPendingMenus.add(r100);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder r100) {
        Iterator<CascadingMenuInfo> r101 = this.mShowingMenus.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        CascadingMenuInfo r102 = r101.next();
        if (r100 != r102.menu) goto L4;
        r102.getListView().requestFocus();
        return true;
    L10:
        if (r100.hasVisibleItems() == false) goto L15;
        addMenu(r100);
        MenuPresenter.Callback r103 = this.mPresenterCallback;
        if (r103 == null) goto L14;
        r103.onOpenSubMenu(r100);
    L14:
        return true;
    L15:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setAnchorView(View r100) {
        if (this.mAnchorView == r100) goto L6;
        this.mAnchorView = r100;
        this.mDropDownGravity = GravityCompat.getAbsoluteGravity(this.mRawDropDownGravity, ViewCompat.getLayoutDirection(r100));
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r100) {
        this.mPresenterCallback = r100;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setForceShowIcon(boolean r100) {
        this.mForceShowIcon = r100;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setGravity(int r100) {
        if (this.mRawDropDownGravity == r100) goto L6;
        this.mRawDropDownGravity = r100;
        this.mDropDownGravity = GravityCompat.getAbsoluteGravity(r100, ViewCompat.getLayoutDirection(this.mAnchorView));
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setHorizontalOffset(int r100) {
        this.mHasXOffset = true;
        this.mXOffset = r100;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setOnDismissListener(PopupWindow.OnDismissListener r100) {
        this.mOnDismissListener = r100;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setShowTitle(boolean r100) {
        this.mShowTitle = r100;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setVerticalOffset(int r100) {
        this.mHasYOffset = true;
        this.mYOffset = r100;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r100) {
        Iterator<CascadingMenuInfo> r101 = this.mShowingMenus.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        MenuPopup.toMenuAdapter(r101.next().getListView().getAdapter()).notifyDataSetChanged();
        goto L4
    }

    private MenuItem findMenuItemForSubmenu(MenuBuilder r100, MenuBuilder r101) {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L10;
        MenuItem r104 = r100.getItem(r103);
        if (r104.hasSubMenu() == false) goto L9;
        if (r101 != r104.getSubMenu()) goto L9;
        return r104;
    L9:
        r103 = r103 + 1;
        goto L3
    L10:
        return null;
    }

    private View findParentViewForSubmenu(CascadingMenuInfo r100, MenuBuilder r101) {
        MenuItem r102 = findMenuItemForSubmenu(r100.menu, r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        ListView r103 = r100.getListView();
        ListAdapter r104 = r103.getAdapter();
        int r105 = 0;
        if ((r104 instanceof HeaderViewListAdapter) == false) goto L8;
        HeaderViewListAdapter r106 = (HeaderViewListAdapter) r104;
        int r107 = r106.getHeadersCount();
        MenuAdapter r108 = (MenuAdapter) r106.getWrappedAdapter();
    L9:
        int r109 = r108.getCount();
    L11:
        if (r105 >= r109) goto L16;
        if (r102 == r108.getItem(r105)) goto L17;
        r105 = r105 + 1;
    L17:
        if (r105 != (-1)) goto L19;
        return null;
    L19:
        int r110 = (r105 + r107) - r103.getFirstVisiblePosition();
        if (r110 >= 0) goto L22;
    L26:
        return null;
    L22:
        if (r110 >= r103.getChildCount()) goto L26;
        return r103.getChildAt(r110);
    L16:
        r105 = -1;
        goto L17
    L8:
        r108 = (MenuAdapter) r104;
        r107 = 0;
        goto L9
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r100, boolean r101) {
        int r102 = findIndexOfAddedMenu(r100);
        if (r102 >= 0) goto L5;
        return;
    L5:
        int r103 = r102 + 1;
        if (r103 >= this.mShowingMenus.size()) goto L8;
        ((CascadingMenuInfo) ListProtector.get(this.mShowingMenus, r103)).menu.close(false);
    L8:
        CascadingMenuInfo r104 = (CascadingMenuInfo) ListProtector.remove(this.mShowingMenus, r102);
        r104.menu.removeMenuPresenter(this);
        if (this.mShouldCloseImmediately == false) goto L11;
        r104.window.setExitTransition(null);
        r104.window.setAnimationStyle(0);
    L11:
        r104.window.dismiss();
        int r105 = this.mShowingMenus.size();
        if (r105 <= 0) goto L14;
        this.mLastPosition = ((CascadingMenuInfo) ListProtector.get(this.mShowingMenus, r105 - 1)).position;
    L15:
        if (r105 != 0) goto L26;
        dismiss();
        MenuPresenter.Callback r106 = this.mPresenterCallback;
        if (r106 == null) goto L19;
        r106.onCloseMenu(r100, true);
    L19:
        ViewTreeObserver r107 = this.mTreeObserver;
        if (r107 != null) goto L22;
    L25:
        this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
        this.mOnDismissListener.onDismiss();
        return;
    L22:
        if (r107.isAlive() == false) goto L24;
        this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
    L24:
        this.mTreeObserver = null;
        goto L25
    L26:
        if (r101 == false) goto L30;
        ((CascadingMenuInfo) ListProtector.get(this.mShowingMenus, 0)).menu.close(false);
        return;
    L30:
        return;
    L14:
        this.mLastPosition = getInitialMenuPosition();
        goto L15
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View r100, int r101, KeyEvent r102) {
        if (r102.getAction() == 1) goto L5;
        return false;
    L5:
        if (r101 != 82) goto L10;
        dismiss();
        return true;
    L10:
        return false;
    }

    public CascadingMenuPopup(Context r100, View r101, int r102, int r103, boolean r104) {
        this.mPendingMenus = new ArrayList();
        this.mShowingMenus = new ArrayList();
        this.mGlobalLayoutListener = new AnonymousClass1(this);
        this.mAttachStateChangeListener = new AnonymousClass2(this);
        this.mMenuItemHoverListener = new AnonymousClass3(this);
        this.mRawDropDownGravity = 0;
        this.mDropDownGravity = 0;
        this.mContext = r100;
        this.mAnchorView = r101;
        this.mPopupStyleAttr = r102;
        this.mPopupStyleRes = r103;
        this.mOverflowOnly = r104;
        this.mForceShowIcon = false;
        this.mLastPosition = getInitialMenuPosition();
        Resources r105 = r100.getResources();
        this.mMenuMaxWidth = Math.max(INVOKEVIRTUAL_androidx_appcompat_view_menu_CascadingMenuPopup_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r105).widthPixels / 2, r105.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.mSubMenuHoverHandler = new Handler();
    }
}
