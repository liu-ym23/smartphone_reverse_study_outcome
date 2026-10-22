package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes2.dex */
final class StandardMenuPopup extends MenuPopup implements PopupWindow.OnDismissListener, View.OnKeyListener {
    private static final int ITEM_LAYOUT = 2131558425;
    private final MenuAdapter mAdapter;
    private View mAnchorView;
    private final View.OnAttachStateChangeListener mAttachStateChangeListener;
    private int mContentWidth;
    private final Context mContext;
    private int mDropDownGravity;
    final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    private boolean mHasContentWidth;
    private final MenuBuilder mMenu;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    final MenuPopupWindow mPopup;
    private final int mPopupMaxWidth;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter.Callback mPresenterCallback;
    private boolean mShowTitle;
    View mShownAnchorView;
    ViewTreeObserver mTreeObserver;
    private boolean mWasDismissed;

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void addMenu(MenuBuilder r100) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.mWasDismissed = true;
        this.mMenu.close();
        ViewTreeObserver r100 = this.mTreeObserver;
        if (r100 != null) goto L5;
    L8:
        this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
        PopupWindow.OnDismissListener r101 = this.mOnDismissListener;
        if (r101 == null) goto L12;
        r101.onDismiss();
        return;
    L12:
        return;
    L5:
        if (r100.isAlive() == true) goto L7;
        this.mTreeObserver = this.mShownAnchorView.getViewTreeObserver();
    L7:
        this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
        this.mTreeObserver = null;
        goto L8
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable r100) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView getListView() {
        return this.mPopup.getListView();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        if (this.mWasDismissed == false) goto L5;
    L7:
        return false;
    L5:
        if (this.mPopup.isShowing() == false) goto L7;
        return true;
    }

    private boolean tryShow() {
        if (isShowing() == false) goto L6;
        return true;
    L6:
        if (this.mWasDismissed == true) goto L30;
        View r100 = this.mAnchorView;
        if (r100 == null) goto L30;
        this.mShownAnchorView = r100;
        this.mPopup.setOnDismissListener(this);
        this.mPopup.setOnItemClickListener(this);
        this.mPopup.setModal(true);
        View r101 = this.mShownAnchorView;
        if (this.mTreeObserver != null) goto L13;
        boolean r102 = true;
    L14:
        ViewTreeObserver r103 = r101.getViewTreeObserver();
        this.mTreeObserver = r103;
        if (r102 == false) goto L17;
        r103.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
    L17:
        r101.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
        this.mPopup.setAnchorView(r101);
        this.mPopup.setDropDownGravity(this.mDropDownGravity);
        if (this.mHasContentWidth == true) goto L20;
        this.mContentWidth = MenuPopup.measureIndividualMenuWidth(this.mAdapter, null, this.mContext, this.mPopupMaxWidth);
        this.mHasContentWidth = true;
    L20:
        this.mPopup.setContentWidth(this.mContentWidth);
        this.mPopup.setInputMethodMode(2);
        this.mPopup.setEpicenterBounds(getEpicenterBounds());
        this.mPopup.show();
        ListView r104 = this.mPopup.getListView();
        r104.setOnKeyListener(this);
        if (this.mShowTitle == true) goto L23;
    L28:
        this.mPopup.setAdapter(this.mAdapter);
        this.mPopup.show();
        return true;
    L23:
        if (this.mMenu.getHeaderTitle() == null) goto L28;
        FrameLayout r105 = (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.abc_popup_menu_header_item_layout, r104, false);
        TextView r106 = (TextView) r105.findViewById(android.R.id.title);
        if (r106 == null) goto L27;
        r106.setText(this.mMenu.getHeaderTitle());
    L27:
        r105.setEnabled(false);
        r104.addHeaderView(r105, null, false);
        goto L28
    L13:
        r102 = false;
    L30:
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        if (isShowing() == false) goto L6;
        this.mPopup.dismiss();
        return;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        if (tryShow() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_view_menu_StandardMenuPopup_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder r110) {
        if (r110.hasVisibleItems() == false) goto L14;
        MenuPopupHelper r100 = new MenuPopupHelper(this.mContext, r110, this.mShownAnchorView, this.mOverflowOnly, this.mPopupStyleAttr, this.mPopupStyleRes);
        r100.setPresenterCallback(this.mPresenterCallback);
        r100.setForceShowIcon(MenuPopup.shouldPreserveIconSpacing(r110));
        r100.setOnDismissListener(this.mOnDismissListener);
        this.mOnDismissListener = null;
        this.mMenu.close(false);
        int r101 = this.mPopup.getHorizontalOffset();
        int r102 = this.mPopup.getVerticalOffset();
        if ((Gravity.getAbsoluteGravity(this.mDropDownGravity, ViewCompat.getLayoutDirection(this.mAnchorView)) & 7) != 5) goto L8;
        r101 = r101 + this.mAnchorView.getWidth();
    L8:
        if (r100.tryShow(r101, r102) == false) goto L14;
        MenuPresenter.Callback r103 = this.mPresenterCallback;
        if (r103 == null) goto L15;
        r103.onOpenSubMenu(r110);
        return true;
    L15:
        return true;
    L14:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setAnchorView(View r100) {
        this.mAnchorView = r100;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r100) {
        this.mPresenterCallback = r100;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setForceShowIcon(boolean r100) {
        this.mAdapter.setForceShowIcon(r100);
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setGravity(int r100) {
        this.mDropDownGravity = r100;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setHorizontalOffset(int r100) {
        this.mPopup.setHorizontalOffset(r100);
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
        this.mPopup.setVerticalOffset(r100);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r100) {
        this.mHasContentWidth = false;
        MenuAdapter r101 = this.mAdapter;
        if (r101 == null) goto L6;
        r101.notifyDataSetChanged();
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r100, boolean r101) {
        if (r100 == this.mMenu) goto L5;
        return;
    L5:
        dismiss();
        MenuPresenter.Callback r102 = this.mPresenterCallback;
        if (r102 == null) goto L9;
        r102.onCloseMenu(r100, r101);
        return;
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

    public StandardMenuPopup(Context r100, MenuBuilder r101, View r102, int r103, int r104, boolean r105) {
        this.mGlobalLayoutListener = new AnonymousClass1(this);
        this.mAttachStateChangeListener = new AnonymousClass2(this);
        this.mDropDownGravity = 0;
        this.mContext = r100;
        this.mMenu = r101;
        this.mOverflowOnly = r105;
        this.mAdapter = new MenuAdapter(r101, LayoutInflater.from(r100), r105, ITEM_LAYOUT);
        this.mPopupStyleAttr = r103;
        this.mPopupStyleRes = r104;
        Resources r106 = r100.getResources();
        this.mPopupMaxWidth = Math.max(INVOKEVIRTUAL_androidx_appcompat_view_menu_StandardMenuPopup_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r106).widthPixels / 2, r106.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.mAnchorView = r102;
        this.mPopup = new MenuPopupWindow(r100, null, r103, r104);
        r101.addMenuPresenter(this, r100);
    }
}
