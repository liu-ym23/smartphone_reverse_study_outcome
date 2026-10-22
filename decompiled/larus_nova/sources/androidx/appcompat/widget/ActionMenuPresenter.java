package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ActionProvider;
import androidx.core.view.GravityCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
    private static final String TAG = "ActionMenuPresenter";
    private final SparseBooleanArray mActionButtonGroups;
    ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    int mOpenSubMenuId;
    OverflowMenuButton mOverflowButton;
    OverflowPopup mOverflowPopup;
    private Drawable mPendingOverflowIcon;
    private boolean mPendingOverflowIconSet;
    private ActionMenuPopupCallback mPopupCallback;
    final PopupPresenterCallback mPopupPresenterCallback;
    OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private boolean mStrictWidthLimit;
    private int mWidthLimit;
    private boolean mWidthLimitSet;

    public class ActionButtonSubmenu extends MenuPopupHelper {
        final /* synthetic */ ActionMenuPresenter this$0;

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        public void onDismiss() {
            ActionMenuPresenter r100 = this.this$0;
            r100.mActionButtonPopup = null;
            r100.mOpenSubMenuId = 0;
            super.onDismiss();
        }

        public ActionButtonSubmenu(ActionMenuPresenter r100, Context r101, SubMenuBuilder r102, View r110) {
            this.this$0 = r100;
            super(r101, r102, r110, false, R.attr.actionOverflowMenuStyle);
            if (((MenuItemImpl) r102.getItem()).isActionButton() == true) goto L8;
            View r103 = r100.mOverflowButton;
            if (r103 != null) goto L7;
            r103 = (View) ActionMenuPresenter.access$200(r100);
        L7:
            setAnchorView(r103);
        L8:
            setPresenterCallback(r100.mPopupPresenterCallback);
        }
    }

    public class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
        final /* synthetic */ ActionMenuPresenter this$0;

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.PopupCallback
        public ShowableListMenu getPopup() {
            ActionButtonSubmenu r100 = this.this$0.mActionButtonPopup;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getPopup();
        }

        public ActionMenuPopupCallback(ActionMenuPresenter r100) {
            this.this$0 = r100;
        }
    }

    public class OpenOverflowRunnable implements Runnable {
        private OverflowPopup mPopup;
        final /* synthetic */ ActionMenuPresenter this$0;

        @Override // java.lang.Runnable
        public void run() {
            androidx_appcompat_widget_ActionMenuPresenter$OpenOverflowRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_appcompat_widget_ActionMenuPresenter$OpenOverflowRunnable__run$___twin___() {
            if (ActionMenuPresenter.access$400(this.this$0) == null) goto L5;
            ActionMenuPresenter.access$500(this.this$0).changeMenuMode();
        L5:
            View r100 = (View) ActionMenuPresenter.access$600(this.this$0);
            if (r100 != null) goto L8;
        L12:
            this.this$0.mPostedOpenRunnable = null;
            return;
        L8:
            if (r100.getWindowToken() == null) goto L12;
            if (this.mPopup.tryShow() == false) goto L12;
            ActionMenuPresenter r101 = this.this$0;
            r101.mOverflowPopup = this.mPopup;
            goto L12
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_appcompat_widget_ActionMenuPresenter$OpenOverflowRunnable_com_larus_apm_impl_protector_RunnableLancet_run(OpenOverflowRunnable r100) {
            r100.androidx_appcompat_widget_ActionMenuPresenter$OpenOverflowRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public OpenOverflowRunnable(ActionMenuPresenter r100, OverflowPopup r101) {
            this.this$0 = r100;
            this.mPopup = r101;
        }
    }

    public class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
        final /* synthetic */ ActionMenuPresenter this$0;

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerAfter() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public boolean needsDividerBefore() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick() == false) goto L5;
            return true;
        L5:
            playSoundEffect(0);
            this.this$0.showOverflowMenu();
            return true;
        }

        public OverflowMenuButton(final ActionMenuPresenter r100, Context r101) {
            this.this$0 = r100;
            super(r101, null, R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.setTooltipText(this, getContentDescription());
            setOnTouchListener(new AnonymousClass1(this, this, r100));
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int r100, int r101, int r102, int r103) {
            boolean r104 = super.setFrame(r100, r101, r102, r103);
            Drawable r105 = getDrawable();
            Drawable r106 = getBackground();
            if (r105 == null) goto L6;
            if (r106 == null) goto L6;
            int r107 = getWidth();
            int r108 = getHeight();
            int r109 = Math.max(r107, r108) / 2;
            int r110 = getPaddingLeft() - getPaddingRight();
            int r111 = (r107 + r110) / 2;
            int r112 = (r108 + (getPaddingTop() - getPaddingBottom())) / 2;
            DrawableCompat.setHotspotBounds(r106, r111 - r109, r112 - r109, r111 + r109, r112 + r109);
        L6:
            return r104;
        }
    }

    public class OverflowPopup extends MenuPopupHelper {
        final /* synthetic */ ActionMenuPresenter this$0;

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        public void onDismiss() {
            if (ActionMenuPresenter.access$000(this.this$0) == null) goto L5;
            ActionMenuPresenter.access$100(this.this$0).close();
        L5:
            this.this$0.mOverflowPopup = null;
            super.onDismiss();
        }

        public OverflowPopup(ActionMenuPresenter r100, Context r101, MenuBuilder r102, View r110, boolean r111) {
            this.this$0 = r100;
            super(r101, r102, r110, r111, R.attr.actionOverflowMenuStyle);
            setGravity(GravityCompat.END);
            setPresenterCallback(r100.mPopupPresenterCallback);
        }
    }

    public class PopupPresenterCallback implements MenuPresenter.Callback {
        final /* synthetic */ ActionMenuPresenter this$0;

        public PopupPresenterCallback(ActionMenuPresenter r100) {
            this.this$0 = r100;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder r100) {
            if (r100 != ActionMenuPresenter.access$300(this.this$0)) goto L5;
            return false;
        L5:
            ActionMenuPresenter r101 = this.this$0;
            r101.mOpenSubMenuId = ((SubMenuBuilder) r100).getItem().getItemId();
            MenuPresenter.Callback r102 = this.this$0.getCallback();
            if (r102 != null) goto L8;
            return false;
        L8:
            return r102.onOpenSubMenu(r100);
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder r100, boolean r101) {
            if ((r100 instanceof SubMenuBuilder) == false) goto L5;
            r100.getRootMenu().close(false);
        L5:
            MenuPresenter.Callback r102 = this.this$0.getCallback();
            if (r102 == null) goto L9;
            r102.onCloseMenu(r100, r101);
            return;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int openSubMenuId;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState() {
        }

        public SavedState(Parcel r100) {
            this.openSubMenuId = r100.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(this.openSubMenuId);
        }
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        ActionMenuPresenter r100 = this;
        MenuBuilder r101 = r100.mMenu;
        View r102 = null;
        int r103 = 0;
        if (r101 == null) goto L5;
        ArrayList<MenuItemImpl> r104 = r101.getVisibleItems();
        int r105 = r104.size();
    L6:
        int r106 = r100.mMaxItems;
        int r107 = r100.mActionItemWidthLimit;
        int r108 = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup r109 = (ViewGroup) r100.mMenuView;
        int r110 = 0;
        boolean r111 = false;
        int r112 = 0;
        int r113 = 0;
    L7:
        if (r110 >= r105) goto L22;
        MenuItemImpl r114 = (MenuItemImpl) ListProtector.get(r104, r110);
        if (r114.requiresActionButton() == false) goto L12;
        r112 = r112 + 1;
    L16:
        if (r100.mExpandedActionViewsExclusive == false) goto L20;
        if (r114.isActionViewExpanded() == false) goto L20;
        r106 = 0;
    L20:
        r110 = r110 + 1;
        goto L7
    L12:
        if (r114.requestsActionButton() == false) goto L14;
        r113 = r113 + 1;
        goto L16
    L14:
        r111 = true;
        goto L16
    L22:
        if (r100.mReserveOverflow == false) goto L27;
        if (r111 == false) goto L25;
    L26:
        r106 = r106 - 1;
        goto L27
    L25:
        if ((r113 + r112) > r106) goto L26;
    L27:
        int r115 = r106 - r112;
        SparseBooleanArray r116 = r100.mActionButtonGroups;
        r116.clear();
        if (r100.mStrictWidthLimit == false) goto L30;
        int r117 = r100.mMinCellSize;
        int r118 = r107 / r117;
        int r119 = r117 + ((r107 % r117) / r118);
    L31:
        int r120 = 0;
        int r121 = 0;
    L32:
        if (r120 >= r105) goto L96;
        MenuItemImpl r122 = (MenuItemImpl) ListProtector.get(r104, r120);
        if (r122.requiresActionButton() == false) goto L48;
        View r123 = r100.getItemView(r122, r102, r109);
        if (r100.mStrictWidthLimit == false) goto L38;
        r118 = r118 - ActionMenuView.measureChildForCells(r123, r119, r118, r108, r103);
    L39:
        int r124 = r123.getMeasuredWidth();
        r107 = r107 - r124;
        if (r121 != 0) goto L42;
        r121 = r124;
    L42:
        int r125 = r122.getGroupId();
        if (r125 == 0) goto L45;
        r116.put(r125, true);
    L45:
        r122.setIsActionButton(true);
    L95:
        r120 = r120 + 1;
        r102 = null;
        r100 = this;
        r105 = r105;
        r103 = 0;
        goto L32
    L38:
        r123.measure(r108, r108);
        goto L39
    L48:
        if (r122.requestsActionButton() == false) goto L94;
        int r126 = r122.getGroupId();
        boolean r127 = r116.get(r126);
        if (r115 > 0) goto L52;
        if (r127 == true) goto L52;
    L57:
        boolean r128 = false;
    L58:
        boolean r129 = r128;
        if (r128 == false) goto L78;
        View r130 = r100.getItemView(r122, null, r109);
        if (r100.mStrictWidthLimit == false) goto L65;
        int r131 = ActionMenuView.measureChildForCells(r130, r119, r118, r108, 0);
        r118 = r118 - r131;
        if (r131 != 0) goto L66;
        r129 = false;
    L66:
        boolean r132 = r129;
        int r133 = r130.getMeasuredWidth();
        r107 = r107 - r133;
        if (r121 != 0) goto L70;
        r121 = r133;
    L70:
        if (r100.mStrictWidthLimit == false) goto L74;
        if (r107 >= 0) goto L75;
    L76:
        boolean r134 = false;
    L77:
        r128 = r132 & r134;
    L75:
        r134 = true;
        goto L77
    L74:
        if ((r107 + r121) <= 0) goto L76;
    L65:
        r130.measure(r108, r108);
    L78:
        if (r128 == false) goto L81;
        if (r126 == 0) goto L81;
        r116.put(r126, true);
    L91:
        if (r128 == false) goto L93;
        r115 = r115 - 1;
    L93:
        r122.setIsActionButton(r128);
    L81:
        if (r127 == false) goto L91;
        r116.put(r126, false);
        int r135 = 0;
    L83:
        if (r135 >= r120) goto L91;
        MenuItemImpl r136 = (MenuItemImpl) ListProtector.get(r104, r135);
        if (r136.getGroupId() != r126) goto L90;
        if (r136.isActionButton() == false) goto L89;
        r115 = r115 + 1;
    L89:
        r136.setIsActionButton(false);
    L90:
        r135 = r135 + 1;
    L52:
        if (r107 <= 0) goto L57;
        if (r100.mStrictWidthLimit == false) goto L56;
        if (r118 <= 0) goto L57;
    L56:
        r128 = true;
        goto L58
    L94:
        r105 = r105;
        r122.setIsActionButton(false);
        goto L95
    L96:
        return true;
    L30:
        r119 = 0;
        r118 = 0;
        goto L31
    L5:
        r104 = null;
        r105 = 0;
        goto L6
    }

    public Drawable getOverflowIcon() {
        OverflowMenuButton r100 = this.mOverflowButton;
        if (r100 == null) goto L7;
        return r100.getDrawable();
    L7:
        if (this.mPendingOverflowIconSet == true) goto L9;
        return null;
    L9:
        return this.mPendingOverflowIcon;
    }

    public boolean hideOverflowMenu() {
        OpenOverflowRunnable r100 = this.mPostedOpenRunnable;
        if (r100 == null) goto L8;
        Object r101 = this.mMenuView;
        if (r101 == null) goto L8;
        ((View) r101).removeCallbacks(r100);
        this.mPostedOpenRunnable = null;
        return true;
    L8:
        OverflowPopup r102 = this.mOverflowPopup;
        if (r102 == null) goto L12;
        r102.dismiss();
        return true;
    L12:
        return false;
    }

    public boolean hideSubMenus() {
        ActionButtonSubmenu r100 = this.mActionButtonPopup;
        if (r100 == null) goto L6;
        r100.dismiss();
        return true;
    L6:
        return false;
    }

    public boolean isOverflowMenuShowPending() {
        if (this.mPostedOpenRunnable == null) goto L5;
    L8:
        return true;
    L5:
        if (isOverflowMenuShowing() == true) goto L8;
        return false;
    }

    public boolean isOverflowMenuShowing() {
        OverflowPopup r100 = this.mOverflowPopup;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isShowing() == false) goto L7;
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState();
        r100.openSubMenuId = this.mOpenSubMenuId;
        return r100;
    }

    public boolean showOverflowMenu() {
        if (this.mReserveOverflow == true) goto L5;
        return false;
    L5:
        if (isOverflowMenuShowing() == true) goto L18;
        MenuBuilder r100 = this.mMenu;
        if (r100 != null) goto L9;
        return false;
    L9:
        if (this.mMenuView != null) goto L11;
        return false;
    L11:
        if (this.mPostedOpenRunnable == null) goto L13;
        return false;
    L13:
        if (r100.getNonActionItems().isEmpty() == true) goto L22;
        OpenOverflowRunnable r101 = new OpenOverflowRunnable(this, new OverflowPopup(this, this.mContext, this.mMenu, this.mOverflowButton, true));
        this.mPostedOpenRunnable = r101;
        ((View) this.mMenuView).post(r101);
        return true;
    L22:
        return false;
    L18:
        return false;
    }

    public boolean dismissPopupMenus() {
        return hideOverflowMenu() | hideSubMenus();
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public ActionMenuPresenter(Context r100) {
        super(r100, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
        this.mActionButtonGroups = new SparseBooleanArray();
        this.mPopupPresenterCallback = new PopupPresenterCallback(this);
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_widget_ActionMenuPresenter_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static /* synthetic */ MenuBuilder access$000(ActionMenuPresenter r100) {
        return r100.mMenu;
    }

    public static /* synthetic */ MenuBuilder access$100(ActionMenuPresenter r100) {
        return r100.mMenu;
    }

    public static /* synthetic */ MenuView access$200(ActionMenuPresenter r100) {
        return r100.mMenuView;
    }

    public static /* synthetic */ MenuBuilder access$300(ActionMenuPresenter r100) {
        return r100.mMenu;
    }

    public static /* synthetic */ MenuBuilder access$400(ActionMenuPresenter r100) {
        return r100.mMenu;
    }

    public static /* synthetic */ MenuBuilder access$500(ActionMenuPresenter r100) {
        return r100.mMenu;
    }

    public static /* synthetic */ MenuView access$600(ActionMenuPresenter r100) {
        return r100.mMenuView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View findViewForItem(MenuItem r100) {
        ViewGroup r101 = (ViewGroup) this.mMenuView;
        if (r101 != null) goto L5;
        return null;
    L5:
        int r102 = r101.getChildCount();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L13;
        View r104 = r101.getChildAt(r103);
        if ((r104 instanceof MenuView.ItemView) == false) goto L12;
        if (((MenuView.ItemView) r104).getItemData() != r100) goto L12;
        return r104;
    L12:
        r103 = r103 + 1;
        goto L6
    L13:
        return null;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup r100) {
        MenuView r101 = this.mMenuView;
        MenuView r102 = super.getMenuView(r100);
        if (r101 == r102) goto L5;
        ((ActionMenuView) r102).setPresenter(this);
    L5:
        return r102;
    }

    public void onConfigurationChanged(Configuration r100) {
        if (this.mMaxItemsSet == true) goto L5;
        this.mMaxItems = ActionBarPolicy.get(this.mContext).getMaxActionButtons();
    L5:
        MenuBuilder r101 = this.mMenu;
        if (r101 == null) goto L9;
        r101.onItemsChanged(true);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L5;
        return;
    L5:
        int r101 = ((SavedState) r100).openSubMenuId;
        if (r101 <= 0) goto L11;
        MenuItem r102 = this.mMenu.findItem(r101);
        if (r102 == null) goto L12;
        onSubMenuSelected((SubMenuBuilder) r102.getSubMenu());
        return;
    L12:
        return;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder r100) {
        boolean r101 = false;
        if (r100.hasVisibleItems() == true) goto L5;
        return false;
    L5:
        SubMenuBuilder r102 = r100;
    L7:
        if (r102.getParentMenu() == this.mMenu) goto L9;
        r102 = (SubMenuBuilder) r102.getParentMenu();
        goto L7
    L9:
        View r103 = findViewForItem(r102.getItem());
        if (r103 != null) goto L12;
        return false;
    L12:
        this.mOpenSubMenuId = r100.getItem().getItemId();
        int r104 = r100.size();
        int r105 = 0;
    L14:
        if (r105 >= r104) goto L21;
        MenuItem r106 = r100.getItem(r105);
        if (r106.isVisible() == false) goto L20;
        if (r106.getIcon() == null) goto L20;
        r101 = true;
    L20:
        r105 = r105 + 1;
    L21:
        ActionButtonSubmenu r107 = new ActionButtonSubmenu(this, this.mContext, r100, r103);
        this.mActionButtonPopup = r107;
        r107.setForceShowIcon(r101);
        this.mActionButtonPopup.show();
        super.onSubMenuSelected(r100);
        return true;
    }

    @Override // androidx.core.view.ActionProvider.SubUiVisibilityListener
    public void onSubUiVisibilityChanged(boolean r100) {
        if (r100 == false) goto L4;
        super.onSubMenuSelected(null);
        return;
    L4:
        MenuBuilder r101 = this.mMenu;
        if (r101 == null) goto L9;
        r101.close(false);
        return;
    }

    public void setExpandedActionViewsExclusive(boolean r100) {
        this.mExpandedActionViewsExclusive = r100;
    }

    public void setItemLimit(int r100) {
        this.mMaxItems = r100;
        this.mMaxItemsSet = true;
    }

    public void setMenuView(ActionMenuView r100) {
        this.mMenuView = r100;
        r100.initialize(this.mMenu);
    }

    public void setOverflowIcon(Drawable r100) {
        OverflowMenuButton r101 = this.mOverflowButton;
        if (r101 == null) goto L5;
        r101.setImageDrawable(r100);
        return;
    L5:
        this.mPendingOverflowIconSet = true;
        this.mPendingOverflowIcon = r100;
    }

    public void setReserveOverflow(boolean r100) {
        this.mReserveOverflow = r100;
        this.mReserveOverflowSet = true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r100) {
        super.updateMenuView(r100);
        ((View) this.mMenuView).requestLayout();
        MenuBuilder r101 = this.mMenu;
        boolean r102 = false;
        if (r101 == null) goto L10;
        ArrayList<MenuItemImpl> r103 = r101.getActionItems();
        int r104 = r103.size();
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L10;
        ActionProvider r106 = ((MenuItemImpl) ListProtector.get(r103, r105)).getSupportActionProvider();
        if (r106 == null) goto L9;
        r106.setSubUiVisibilityListener(this);
    L9:
        r105 = r105 + 1;
    L10:
        MenuBuilder r107 = this.mMenu;
        if (r107 == null) goto L13;
        ArrayList<MenuItemImpl> r108 = r107.getNonActionItems();
    L15:
        if (this.mReserveOverflow == false) goto L22;
        if (r108 == null) goto L22;
        int r109 = r108.size();
        if (r109 != 1) goto L20;
        r102 = !((MenuItemImpl) ListProtector.get(r108, 0)).isActionViewExpanded();
        goto L22
    L20:
        if (r109 <= 0) goto L22;
        r102 = true;
    L22:
        if (r102 == true) goto L24;
        OverflowMenuButton r110 = this.mOverflowButton;
        if (r110 == null) goto L36;
        Object r111 = r110.getParent();
        Object r112 = this.mMenuView;
        if (r111 != r112) goto L36;
        ((ViewGroup) r112).removeView(this.mOverflowButton);
    L36:
        ((ActionMenuView) this.mMenuView).setOverflowReserved(this.mReserveOverflow);
        return;
    L24:
        if (this.mOverflowButton != null) goto L26;
        this.mOverflowButton = new OverflowMenuButton(this, this.mSystemContext);
    L26:
        ViewGroup r113 = (ViewGroup) this.mOverflowButton.getParent();
        if (r113 == this.mMenuView) goto L36;
        if (r113 == null) goto L30;
        r113.removeView(this.mOverflowButton);
    L30:
        ActionMenuView r114 = (ActionMenuView) this.mMenuView;
        r114.addView(this.mOverflowButton, r114.generateOverflowButtonLayoutParams());
        goto L36
    L13:
        r108 = null;
        goto L15
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public void bindItemView(MenuItemImpl r100, MenuView.ItemView r101) {
        r101.initialize(r100, 0);
        ActionMenuItemView r102 = (ActionMenuItemView) r101;
        r102.setItemInvoker((ActionMenuView) this.mMenuView);
        if (this.mPopupCallback != null) goto L5;
        this.mPopupCallback = new ActionMenuPopupCallback(this);
    L5:
        r102.setPopupCallback(this.mPopupCallback);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean filterLeftoverView(ViewGroup r100, int r101) {
        if (r100.getChildAt(r101) != this.mOverflowButton) goto L7;
        return false;
    L7:
        return super.filterLeftoverView(r100, r101);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context r100, MenuBuilder r101) {
        super.initForMenu(r100, r101);
        Resources r102 = r100.getResources();
        ActionBarPolicy r103 = ActionBarPolicy.get(r100);
        if (this.mReserveOverflowSet == true) goto L6;
        this.mReserveOverflow = r103.showsOverflowMenuButton();
    L6:
        if (this.mWidthLimitSet == true) goto L9;
        this.mWidthLimit = r103.getEmbeddedMenuWidthLimit();
    L9:
        if (this.mMaxItemsSet == true) goto L11;
        this.mMaxItems = r103.getMaxActionButtons();
    L11:
        int r104 = this.mWidthLimit;
        if (this.mReserveOverflow == true) goto L14;
        this.mOverflowButton = null;
    L21:
        this.mActionItemWidthLimit = r104;
        this.mMinCellSize = (int) (INVOKEVIRTUAL_androidx_appcompat_widget_ActionMenuPresenter_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r102).density * 56.0f);
        return;
    L14:
        if (this.mOverflowButton != null) goto L19;
        OverflowMenuButton r105 = new OverflowMenuButton(this, this.mSystemContext);
        this.mOverflowButton = r105;
        if (this.mPendingOverflowIconSet == false) goto L18;
        r105.setImageDrawable(this.mPendingOverflowIcon);
        this.mPendingOverflowIcon = null;
        this.mPendingOverflowIconSet = false;
    L18:
        int r106 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mOverflowButton.measure(r106, r106);
    L19:
        r104 = r104 - this.mOverflowButton.getMeasuredWidth();
        goto L21
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r100, boolean r101) {
        dismissPopupMenus();
        super.onCloseMenu(r100, r101);
    }

    public void setWidthLimit(int r100, boolean r101) {
        this.mWidthLimit = r100;
        this.mStrictWidthLimit = r101;
        this.mWidthLimitSet = true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean shouldIncludeItem(int r100, MenuItemImpl r101) {
        return r101.isActionButton();
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public View getItemView(MenuItemImpl r100, View r101, ViewGroup r102) {
        View r103 = r100.getActionView();
        if (r103 != null) goto L5;
    L6:
        r103 = super.getItemView(r100, r101, r102);
    L8:
        if (r100.isActionViewExpanded() == false) goto L10;
        int r104 = 8;
    L11:
        r103.setVisibility(r104);
        ActionMenuView r105 = (ActionMenuView) r102;
        ViewGroup.LayoutParams r106 = r103.getLayoutParams();
        if (r105.checkLayoutParams(r106) == true) goto L14;
        r103.setLayoutParams(r105.generateLayoutParams(r106));
    L14:
        return r103;
    L10:
        r104 = 0;
        goto L11
    L5:
        if (r100.hasCollapsibleActionView() == false) goto L8;
        goto L6
    }
}
