package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Toolbar extends ViewGroup {
    private static final String TAG = "Toolbar";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    int mButtonGravity;
    ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private int mContentInsetEndWithActions;
    private int mContentInsetStartWithNavigation;
    private RtlSpacingHelper mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList<View> mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    private MenuBuilder.Callback mMenuBuilderCallback;
    private ActionMenuView mMenuView;
    private final ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private ColorStateList mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private ColorStateList mTitleTextColor;
    private TextView mTitleTextView;
    private ToolbarWidgetWrapper mWrapper;

    public class ExpandedActionViewMenuPresenter implements MenuPresenter {
        MenuItemImpl mCurrentExpandedItem;
        MenuBuilder mMenu;
        final /* synthetic */ Toolbar this$0;

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean flagActionItems() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public MenuView getMenuView(ViewGroup r100) {
            return null;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void onCloseMenu(MenuBuilder r100, boolean r101) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void onRestoreInstanceState(Parcelable r100) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public Parcelable onSaveInstanceState() {
            return null;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean onSubMenuSelected(SubMenuBuilder r100) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void setCallback(MenuPresenter.Callback r100) {
        }

        public ExpandedActionViewMenuPresenter(Toolbar r100) {
            this.this$0 = r100;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void updateMenuView(boolean r100) {
            if (this.mCurrentExpandedItem == null) goto L17;
            MenuBuilder r101 = this.mMenu;
            boolean r102 = false;
            if (r101 == null) goto L12;
            int r103 = r101.size();
            int r104 = 0;
        L7:
            if (r104 >= r103) goto L12;
            if (this.mMenu.getItem(r104) == this.mCurrentExpandedItem) goto L10;
            r104 = r104 + 1;
            goto L7
        L10:
            r102 = true;
        L12:
            if (r102 == true) goto L18;
            collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
            return;
        L18:
            return;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean collapseItemActionView(MenuBuilder r100, MenuItemImpl r101) {
            KeyEvent.Callback r102 = this.this$0.mExpandedActionView;
            if ((r102 instanceof CollapsibleActionView) == false) goto L5;
            ((CollapsibleActionView) r102).onActionViewCollapsed();
        L5:
            Toolbar r103 = this.this$0;
            r103.removeView(r103.mExpandedActionView);
            Toolbar r104 = this.this$0;
            r104.removeView(r104.mCollapseButtonView);
            Toolbar r105 = this.this$0;
            r105.mExpandedActionView = null;
            r105.addChildrenForExpandedActionView();
            this.mCurrentExpandedItem = null;
            this.this$0.requestLayout();
            r101.setActionViewExpanded(false);
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean expandItemActionView(MenuBuilder r100, MenuItemImpl r101) {
            this.this$0.ensureCollapseButtonView();
            ViewParent r102 = this.this$0.mCollapseButtonView.getParent();
            Toolbar r103 = this.this$0;
            if (r102 != r103) goto L5;
        L8:
            Toolbar r104 = this.this$0;
            r104.mExpandedActionView = r101.getActionView();
            this.mCurrentExpandedItem = r101;
            ViewParent r105 = this.this$0.mExpandedActionView.getParent();
            Toolbar r106 = this.this$0;
            if (r105 != r106) goto L11;
        L14:
            this.this$0.removeChildrenForExpandedActionView();
            this.this$0.requestLayout();
            r101.setActionViewExpanded(true);
            KeyEvent.Callback r107 = this.this$0.mExpandedActionView;
            if ((r107 instanceof CollapsibleActionView) == false) goto L17;
            ((CollapsibleActionView) r107).onActionViewExpanded();
        L17:
            return true;
        L11:
            if ((r105 instanceof ViewGroup) == false) goto L13;
            ((ViewGroup) r105).removeView(r106.mExpandedActionView);
        L13:
            LayoutParams r108 = this.this$0.generateDefaultLayoutParams();
            Toolbar r109 = this.this$0;
            r108.gravity = (r109.mButtonGravity & 112) | GravityCompat.START;
            r108.mViewType = 2;
            r109.mExpandedActionView.setLayoutParams(r108);
            Toolbar r110 = this.this$0;
            r110.addView(r110.mExpandedActionView);
            goto L14
        L5:
            if ((r102 instanceof ViewGroup) == false) goto L7;
            ((ViewGroup) r102).removeView(r103.mCollapseButtonView);
        L7:
            Toolbar r111 = this.this$0;
            r111.addView(r111.mCollapseButtonView);
            goto L8
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void initForMenu(Context r100, MenuBuilder r101) {
            MenuBuilder r102 = this.mMenu;
            if (r102 == null) goto L7;
            MenuItemImpl r103 = this.mCurrentExpandedItem;
            if (r103 == null) goto L7;
            r102.collapseItemActionView(r103);
        L7:
            this.mMenu = r101;
        }
    }

    public static class LayoutParams extends ActionBar.LayoutParams {
        static final int CUSTOM = 0;
        static final int EXPANDED = 2;
        static final int SYSTEM = 1;
        int mViewType;

        public LayoutParams(LayoutParams r100) {
            super(r100);
            this.mViewType = 0;
            this.mViewType = r100.mViewType;
        }

        public void copyMarginsFromCompat(ViewGroup.MarginLayoutParams r100) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r100.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = r100.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r100.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = r100.bottomMargin;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            super(r100);
            this.mViewType = 0;
            copyMarginsFromCompat(r100);
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
            this.mViewType = 0;
        }

        public LayoutParams(ActionBar.LayoutParams r100) {
            super(r100);
            this.mViewType = 0;
        }

        public LayoutParams(int r100) {
            this(-2, -1, r100);
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
            this.mViewType = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.mViewType = 0;
        }

        public LayoutParams(int r100, int r101, int r102) {
            super(r100, r101);
            this.mViewType = 0;
            this.gravity = r102;
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem r100);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int expandedMenuItemId;
        boolean isOverflowOpen;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r100) {
            this(r100, null);
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            super(r100, r101);
            this.expandedMenuItemId = r100.readInt();
            if (r100.readInt() == 0) goto L5;
            boolean r102 = true;
        L6:
            this.isOverflowOpen = r102;
            return;
        L5:
            r102 = false;
            goto L6
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.expandedMenuItemId);
            r100.writeInt(this.isOverflowOpen ? 1 : 0);
        }
    }

    private void ensureContentInsets() {
        if (this.mContentInsets != null) goto L6;
        this.mContentInsets = new RtlSpacingHelper();
        return;
    }

    private void ensureLogoView() {
        if (this.mLogoView != null) goto L6;
        this.mLogoView = new AppCompatImageView(getContext());
        return;
    }

    private void ensureMenuView() {
        if (this.mMenuView != null) goto L6;
        ActionMenuView r100 = new ActionMenuView(getContext());
        this.mMenuView = r100;
        r100.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
        this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
        LayoutParams r101 = generateDefaultLayoutParams();
        r101.gravity = (this.mButtonGravity & 112) | GravityCompat.END;
        this.mMenuView.setLayoutParams(r101);
        addSystemView(this.mMenuView, false);
        return;
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView != null) goto L6;
        this.mNavButtonView = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
        LayoutParams r100 = generateDefaultLayoutParams();
        r100.gravity = (this.mButtonGravity & 112) | GravityCompat.START;
        this.mNavButtonView.setLayoutParams(r100);
        return;
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    private void postShowOverflowMenu() {
        removeCallbacks(this.mShowOverflowMenuRunnable);
        post(this.mShowOverflowMenuRunnable);
    }

    private boolean shouldCollapse() {
        if (this.mCollapsible == true) goto L5;
        return false;
    L5:
        int r100 = getChildCount();
        int r101 = 0;
    L6:
        if (r101 >= r100) goto L15;
        View r102 = getChildAt(r101);
        if (shouldLayout(r102) == false) goto L14;
        if (r102.getMeasuredWidth() <= 0) goto L14;
        if (r102.getMeasuredHeight() <= 0) goto L14;
        return false;
    L14:
        r101 = r101 + 1;
        goto L6
    L15:
        return true;
    }

    public void addChildrenForExpandedActionView() {
        int r100 = this.mHiddenViews.size() - 1;
    L3:
        if (r100 < 0) goto L5;
        addView((View) ListProtector.get(this.mHiddenViews, r100));
        r100 = r100 - 1;
        goto L3
    L5:
        this.mHiddenViews.clear();
    }

    public void collapseActionView() {
        ExpandedActionViewMenuPresenter r100 = this.mExpandedMenuPresenter;
        if (r100 != null) goto L5;
        MenuItemImpl r101 = null;
    L6:
        if (r101 == null) goto L9;
        r101.collapseActionView();
        return;
    L9:
        return;
    L5:
        r101 = r100.mCurrentExpandedItem;
        goto L6
    }

    public void dismissPopupMenus() {
        ActionMenuView r100 = this.mMenuView;
        if (r100 == null) goto L6;
        r100.dismissPopupMenus();
        return;
    }

    public void ensureCollapseButtonView() {
        if (this.mCollapseButtonView != null) goto L6;
        AppCompatImageButton r100 = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
        this.mCollapseButtonView = r100;
        r100.setImageDrawable(this.mCollapseIcon);
        this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
        LayoutParams r101 = generateDefaultLayoutParams();
        r101.gravity = (this.mButtonGravity & 112) | GravityCompat.START;
        r101.mViewType = 2;
        this.mCollapseButtonView.setLayoutParams(r101);
        this.mCollapseButtonView.setOnClickListener(new AnonymousClass3(this));
        return;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton r100 = this.mCollapseButtonView;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getContentDescription();
    }

    public Drawable getCollapseIcon() {
        ImageButton r100 = this.mCollapseButtonView;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getDrawable();
    }

    public int getContentInsetEnd() {
        RtlSpacingHelper r100 = this.mContentInsets;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getEnd();
    }

    public int getContentInsetEndWithActions() {
        int r100 = this.mContentInsetEndWithActions;
        if (r100 == Integer.MIN_VALUE) goto L6;
        return r100;
    L6:
        return getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        RtlSpacingHelper r100 = this.mContentInsets;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getLeft();
    }

    public int getContentInsetRight() {
        RtlSpacingHelper r100 = this.mContentInsets;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getRight();
    }

    public int getContentInsetStart() {
        RtlSpacingHelper r100 = this.mContentInsets;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getStart();
    }

    public int getContentInsetStartWithNavigation() {
        int r100 = this.mContentInsetStartWithNavigation;
        if (r100 == Integer.MIN_VALUE) goto L6;
        return r100;
    L6:
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        ActionMenuView r100 = this.mMenuView;
        if (r100 == null) goto L9;
        MenuBuilder r101 = r100.peekMenu();
        if (r101 == null) goto L9;
        if (r101.hasVisibleItems() == false) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
    L13:
        return getContentInsetEnd();
    L9:
        r102 = false;
        goto L10
    }

    public Drawable getLogo() {
        ImageView r100 = this.mLogoView;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getDrawable();
    }

    public CharSequence getLogoDescription() {
        ImageView r100 = this.mLogoView;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getContentDescription();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton r100 = this.mNavButtonView;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getContentDescription();
    }

    public Drawable getNavigationIcon() {
        ImageButton r100 = this.mNavButtonView;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getDrawable();
    }

    public DecorToolbar getWrapper() {
        if (this.mWrapper != null) goto L6;
        this.mWrapper = new ToolbarWidgetWrapper(this, true);
    L6:
        return this.mWrapper;
    }

    public boolean hasExpandedActionView() {
        ExpandedActionViewMenuPresenter r100 = this.mExpandedMenuPresenter;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.mCurrentExpandedItem == null) goto L7;
        return true;
    }

    public boolean hideOverflowMenu() {
        ActionMenuView r100 = this.mMenuView;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.hideOverflowMenu() == false) goto L7;
        return true;
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuView r100 = this.mMenuView;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isOverflowMenuShowPending() == false) goto L7;
        return true;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView r100 = this.mMenuView;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isOverflowMenuShowing() == false) goto L7;
        return true;
    }

    public boolean isTitleTruncated() {
        TextView r100 = this.mTitleTextView;
        if (r100 != null) goto L5;
        return false;
    L5:
        Layout r101 = r100.getLayout();
        if (r101 != null) goto L8;
        return false;
    L8:
        int r102 = r101.getLineCount();
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L15;
        if (r101.getEllipsisCount(r103) > 0) goto L12;
        r103 = r103 + 1;
        goto L9
    L12:
        return true;
    L15:
        return false;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        ExpandedActionViewMenuPresenter r101 = this.mExpandedMenuPresenter;
        if (r101 == null) goto L7;
        MenuItemImpl r102 = r101.mCurrentExpandedItem;
        if (r102 == null) goto L7;
        r100.expandedMenuItemId = r102.getItemId();
    L7:
        r100.isOverflowOpen = isOverflowMenuShowing();
        return r100;
    }

    public boolean showOverflowMenu() {
        ActionMenuView r100 = this.mMenuView;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.showOverflowMenu() == false) goto L7;
        return true;
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.peekMenu() != null) goto L9;
        MenuBuilder r100 = (MenuBuilder) this.mMenuView.getMenu();
        if (this.mExpandedMenuPresenter != null) goto L7;
        this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(this);
    L7:
        this.mMenuView.setExpandedActionViewsExclusive(true);
        r100.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        return;
    }

    public boolean canShowOverflowMenu() {
        if (getVisibility() != 0) goto L9;
        ActionMenuView r100 = this.mMenuView;
        if (r100 == null) goto L9;
        if (r100.isOverflowReserved() == false) goto L9;
        return true;
    L9:
        return false;
    }

    public int getCurrentContentInsetLeft() {
        if (ViewCompat.getLayoutDirection(this) != 1) goto L6;
        return getCurrentContentInsetEnd();
    L6:
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (ViewCompat.getLayoutDirection(this) != 1) goto L6;
        return getCurrentContentInsetStart();
    L6:
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() == null) goto L6;
        return Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
    L6:
        return getContentInsetStart();
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
    }

    public void removeChildrenForExpandedActionView() {
        int r100 = getChildCount() - 1;
    L3:
        if (r100 < 0) goto L10;
        View r101 = getChildAt(r100);
        if (((LayoutParams) r101.getLayoutParams()).mViewType == 2) goto L9;
        if (r101 == this.mMenuView) goto L9;
        removeViewAt(r100);
        this.mHiddenViews.add(r101);
    L9:
        r100 = r100 - 1;
        goto L3
    }

    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    public Context getPopupContext() {
        return this.mPopupContext;
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    public final TextView getSubtitleTextView() {
        return this.mSubtitleTextView;
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    public final TextView getTitleTextView() {
        return this.mTitleTextView;
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    public Toolbar(Context r100) {
        this(r100, null);
    }

    private int getChildHorizontalGravity(int r100) {
        int r101 = ViewCompat.getLayoutDirection(this);
        int r102 = GravityCompat.getAbsoluteGravity(r100, r101) & 7;
        if (r102 != 1) goto L5;
    L11:
        return r102;
    L5:
        if (r102 == 3) goto L11;
        if (r102 == 5) goto L11;
        if (r101 != 1) goto L12;
        return 5;
    L12:
        return 3;
    }

    private int getChildVerticalGravity(int r100) {
        int r101 = r100 & 112;
        if (r101 != 16) goto L5;
        return r101;
    L5:
        if (r101 != 48) goto L7;
        return r101;
    L7:
        if (r101 != 80) goto L9;
        return r101;
    L9:
        return this.mGravity & 112;
    }

    private int getHorizontalMargins(View r100) {
        ViewGroup.MarginLayoutParams r101 = (ViewGroup.MarginLayoutParams) r100.getLayoutParams();
        return MarginLayoutParamsCompat.getMarginStart(r101) + MarginLayoutParamsCompat.getMarginEnd(r101);
    }

    private int getVerticalMargins(View r100) {
        ViewGroup.MarginLayoutParams r101 = (ViewGroup.MarginLayoutParams) r100.getLayoutParams();
        return r101.topMargin + r101.bottomMargin;
    }

    private boolean isChildOrHidden(View r100) {
        if (r100.getParent() != this) goto L5;
    L8:
        return true;
    L5:
        if (this.mHiddenViews.contains(r100) == true) goto L8;
        return false;
    }

    private boolean shouldLayout(View r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (r100.getParent() != this) goto L8;
        if (r100.getVisibility() == 8) goto L8;
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        if (super.checkLayoutParams(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if ((r100 instanceof LayoutParams) == false) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof LayoutParams) == false) goto L7;
        return new LayoutParams((LayoutParams) r100);
    L7:
        if ((r100 instanceof ActionBar.LayoutParams) == false) goto L11;
        return new LayoutParams((ActionBar.LayoutParams) r100);
    L11:
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r100);
    L15:
        return new LayoutParams(r100);
    }

    public void inflateMenu(int r100) {
        getMenuInflater().inflate(r100, getMenu());
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r100) {
        int r101 = r100.getActionMasked();
        if (r101 != 9) goto L6;
        this.mEatingHover = false;
    L6:
        if (this.mEatingHover == true) goto L12;
        boolean r102 = super.onHoverEvent(r100);
        if (r101 != 9) goto L12;
        if (r102 == true) goto L12;
        this.mEatingHover = true;
    L12:
        if (r101 != 10) goto L14;
    L15:
        this.mEatingHover = false;
    L16:
        return true;
    L14:
        if (r101 != 3) goto L16;
        goto L15
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        ActionMenuView r102 = this.mMenuView;
        if (r102 == null) goto L9;
        MenuBuilder r103 = r102.peekMenu();
    L10:
        int r104 = r101.expandedMenuItemId;
        if (r104 == 0) goto L19;
        if (this.mExpandedMenuPresenter == null) goto L19;
        if (r103 == null) goto L19;
        MenuItem r105 = r103.findItem(r104);
        if (r105 == null) goto L19;
        r105.expandActionView();
    L19:
        if (r101.isOverflowOpen == false) goto L22;
        postShowOverflowMenu();
        return;
    L22:
        return;
    L9:
        r103 = null;
        goto L10
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r100) {
        super.onRtlPropertiesChanged(r100);
        ensureContentInsets();
        RtlSpacingHelper r101 = this.mContentInsets;
        boolean r102 = true;
        if (r100 == 1) goto L6;
        r102 = false;
    L6:
        r101.setDirection(r102);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        int r101 = r100.getActionMasked();
        if (r101 != 0) goto L6;
        this.mEatingTouch = false;
    L6:
        if (this.mEatingTouch == true) goto L11;
        boolean r102 = super.onTouchEvent(r100);
        if (r101 != 0) goto L11;
        if (r102 == true) goto L11;
        this.mEatingTouch = true;
    L11:
        if (r101 != 1) goto L13;
    L14:
        this.mEatingTouch = false;
    L15:
        return true;
    L13:
        if (r101 != 3) goto L15;
        goto L14
    }

    public void setCollapseContentDescription(CharSequence r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        ensureCollapseButtonView();
    L5:
        ImageButton r101 = this.mCollapseButtonView;
        if (r101 == null) goto L9;
        r101.setContentDescription(r100);
        return;
    }

    public void setCollapseIcon(Drawable r100) {
        if (r100 == null) goto L4;
        ensureCollapseButtonView();
        this.mCollapseButtonView.setImageDrawable(r100);
        return;
    L4:
        ImageButton r101 = this.mCollapseButtonView;
        if (r101 == null) goto L9;
        r101.setImageDrawable(this.mCollapseIcon);
        return;
    }

    public void setCollapsible(boolean r100) {
        this.mCollapsible = r100;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int r100) {
        if (r100 >= 0) goto L5;
        r100 = Integer.MIN_VALUE;
    L5:
        if (r100 == this.mContentInsetEndWithActions) goto L10;
        this.mContentInsetEndWithActions = r100;
        if (getNavigationIcon() == null) goto L11;
        requestLayout();
        return;
    L11:
        return;
    }

    public void setContentInsetStartWithNavigation(int r100) {
        if (r100 >= 0) goto L5;
        r100 = Integer.MIN_VALUE;
    L5:
        if (r100 == this.mContentInsetStartWithNavigation) goto L10;
        this.mContentInsetStartWithNavigation = r100;
        if (getNavigationIcon() == null) goto L11;
        requestLayout();
        return;
    L11:
        return;
    }

    public void setLogo(Drawable r100) {
        if (r100 == null) goto L6;
        ensureLogoView();
        if (isChildOrHidden(this.mLogoView) == true) goto L11;
        addSystemView(this.mLogoView, true);
    L11:
        ImageView r101 = this.mLogoView;
        if (r101 == null) goto L15;
        r101.setImageDrawable(r100);
        return;
    L15:
        return;
    L6:
        ImageView r102 = this.mLogoView;
        if (r102 == null) goto L11;
        if (isChildOrHidden(r102) == false) goto L11;
        removeView(this.mLogoView);
        this.mHiddenViews.remove(this.mLogoView);
        goto L11
    }

    public void setLogoDescription(CharSequence r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        ensureLogoView();
    L5:
        ImageView r101 = this.mLogoView;
        if (r101 == null) goto L9;
        r101.setContentDescription(r100);
        return;
    }

    public void setNavigationContentDescription(CharSequence r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        ensureNavButtonView();
    L5:
        ImageButton r101 = this.mNavButtonView;
        if (r101 == null) goto L9;
        r101.setContentDescription(r100);
        return;
    }

    public void setNavigationIcon(Drawable r100) {
        if (r100 == null) goto L6;
        ensureNavButtonView();
        if (isChildOrHidden(this.mNavButtonView) == true) goto L11;
        addSystemView(this.mNavButtonView, true);
    L11:
        ImageButton r101 = this.mNavButtonView;
        if (r101 == null) goto L15;
        r101.setImageDrawable(r100);
        return;
    L15:
        return;
    L6:
        ImageButton r102 = this.mNavButtonView;
        if (r102 == null) goto L11;
        if (isChildOrHidden(r102) == false) goto L11;
        removeView(this.mNavButtonView);
        this.mHiddenViews.remove(this.mNavButtonView);
        goto L11
    }

    public void setNavigationOnClickListener(View.OnClickListener r100) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(r100);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener r100) {
        this.mOnMenuItemClickListener = r100;
    }

    public void setOverflowIcon(Drawable r100) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(r100);
    }

    public void setPopupTheme(int r100) {
        if (this.mPopupTheme == r100) goto L9;
        this.mPopupTheme = r100;
        if (r100 != 0) goto L7;
        this.mPopupContext = getContext();
        return;
    L7:
        this.mPopupContext = new ContextThemeWrapper(getContext(), r100);
        return;
    }

    public void setSubtitle(CharSequence r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        TextView r101 = this.mSubtitleTextView;
        if (r101 != null) goto L18;
    L20:
        TextView r102 = this.mSubtitleTextView;
        if (r102 == null) goto L23;
        r102.setText(r100);
    L23:
        this.mSubtitleText = r100;
        return;
    L18:
        if (isChildOrHidden(r101) == false) goto L20;
        removeView(this.mSubtitleTextView);
        this.mHiddenViews.remove(this.mSubtitleTextView);
        goto L20
    L5:
        if (this.mSubtitleTextView != null) goto L13;
        Context r103 = getContext();
        AppCompatTextView r104 = new AppCompatTextView(r103);
        this.mSubtitleTextView = r104;
        r104.setSingleLine();
        this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        int r105 = this.mSubtitleTextAppearance;
        if (r105 == 0) goto L9;
        this.mSubtitleTextView.setTextAppearance(r103, r105);
    L9:
        ColorStateList r106 = this.mSubtitleTextColor;
        if (r106 == null) goto L13;
        this.mSubtitleTextView.setTextColor(r106);
    L13:
        if (isChildOrHidden(this.mSubtitleTextView) == true) goto L20;
        addSystemView(this.mSubtitleTextView, true);
        goto L20
    }

    public void setSubtitleTextColor(ColorStateList r100) {
        this.mSubtitleTextColor = r100;
        TextView r101 = this.mSubtitleTextView;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    public void setTitle(CharSequence r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        TextView r101 = this.mTitleTextView;
        if (r101 != null) goto L18;
    L20:
        TextView r102 = this.mTitleTextView;
        if (r102 == null) goto L23;
        r102.setText(r100);
    L23:
        this.mTitleText = r100;
        return;
    L18:
        if (isChildOrHidden(r101) == false) goto L20;
        removeView(this.mTitleTextView);
        this.mHiddenViews.remove(this.mTitleTextView);
        goto L20
    L5:
        if (this.mTitleTextView != null) goto L13;
        Context r103 = getContext();
        AppCompatTextView r104 = new AppCompatTextView(r103);
        this.mTitleTextView = r104;
        r104.setSingleLine();
        this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        int r105 = this.mTitleTextAppearance;
        if (r105 == 0) goto L9;
        this.mTitleTextView.setTextAppearance(r103, r105);
    L9:
        ColorStateList r106 = this.mTitleTextColor;
        if (r106 == null) goto L13;
        this.mTitleTextView.setTextColor(r106);
    L13:
        if (isChildOrHidden(this.mTitleTextView) == true) goto L20;
        addSystemView(this.mTitleTextView, true);
        goto L20
    }

    public void setTitleMarginBottom(int r100) {
        this.mTitleMarginBottom = r100;
        requestLayout();
    }

    public void setTitleMarginEnd(int r100) {
        this.mTitleMarginEnd = r100;
        requestLayout();
    }

    public void setTitleMarginStart(int r100) {
        this.mTitleMarginStart = r100;
        requestLayout();
    }

    public void setTitleMarginTop(int r100) {
        this.mTitleMarginTop = r100;
        requestLayout();
    }

    public void setTitleTextColor(ColorStateList r100) {
        this.mTitleTextColor = r100;
        TextView r101 = this.mTitleTextView;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public void setCollapseContentDescription(int r100) {
        if (r100 == 0) goto L4;
        CharSequence r101 = getContext().getText(r100);
    L5:
        setCollapseContentDescription(r101);
        return;
    L4:
        r101 = null;
        goto L5
    }

    public void setCollapseIcon(int r100) {
        setCollapseIcon(AppCompatResources.getDrawable(getContext(), r100));
    }

    public void setLogo(int r100) {
        setLogo(AppCompatResources.getDrawable(getContext(), r100));
    }

    public void setLogoDescription(int r100) {
        setLogoDescription(getContext().getText(r100));
    }

    public void setNavigationContentDescription(int r100) {
        if (r100 == 0) goto L4;
        CharSequence r101 = getContext().getText(r100);
    L5:
        setNavigationContentDescription(r101);
        return;
    L4:
        r101 = null;
        goto L5
    }

    public void setNavigationIcon(int r100) {
        setNavigationIcon(AppCompatResources.getDrawable(getContext(), r100));
    }

    public void setSubtitle(int r100) {
        setSubtitle(getContext().getText(r100));
    }

    public void setSubtitleTextColor(int r100) {
        setSubtitleTextColor(ColorStateList.valueOf(r100));
    }

    public void setTitle(int r100) {
        setTitle(getContext().getText(r100));
    }

    public void setTitleTextColor(int r100) {
        setTitleTextColor(ColorStateList.valueOf(r100));
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateLayoutParams(r100);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return generateLayoutParams(r100);
    }

    public Toolbar(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.toolbarStyle);
    }

    private void addCustomViewsWithGravity(List<View> r100, int r101) {
        int r102 = 0;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L5;
        boolean r103 = true;
    L6:
        int r104 = getChildCount();
        int r105 = GravityCompat.getAbsoluteGravity(r101, ViewCompat.getLayoutDirection(this));
        r100.clear();
        if (r103 == false) goto L18;
        int r106 = r104 - 1;
    L9:
        if (r106 < 0) goto L27;
        View r107 = getChildAt(r106);
        LayoutParams r108 = (LayoutParams) r107.getLayoutParams();
        if (r108.mViewType != 0) goto L17;
        if (shouldLayout(r107) == false) goto L17;
        if (getChildHorizontalGravity(r108.gravity) != r105) goto L17;
        r100.add(r107);
    L17:
        r106 = r106 - 1;
        goto L9
    L27:
        return;
    L18:
        if (r102 >= r104) goto L38;
        View r109 = getChildAt(r102);
        LayoutParams r110 = (LayoutParams) r109.getLayoutParams();
        if (r110.mViewType != 0) goto L26;
        if (shouldLayout(r109) == false) goto L26;
        if (getChildHorizontalGravity(r110.gravity) != r105) goto L26;
        r100.add(r109);
    L26:
        r102 = r102 + 1;
        goto L18
    L38:
        return;
    L5:
        r103 = false;
        goto L6
    }

    private void addSystemView(View r100, boolean r101) {
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 != null) goto L6;
        LayoutParams r103 = generateDefaultLayoutParams();
    L9:
        r103.mViewType = 1;
        if (r101 == true) goto L12;
    L14:
        addView(r100, r103);
        return;
    L12:
        if (this.mExpandedActionView == null) goto L14;
        r100.setLayoutParams(r103);
        this.mHiddenViews.add(r100);
        return;
    L6:
        if (checkLayoutParams(r102) == true) goto L8;
        r103 = generateLayoutParams(r102);
        goto L9
    L8:
        r103 = (LayoutParams) r102;
        goto L9
    }

    private int getChildTop(View r100, int r101) {
        LayoutParams r102 = (LayoutParams) r100.getLayoutParams();
        int r103 = r100.getMeasuredHeight();
        if (r101 <= 0) goto L5;
        int r104 = (r103 - r101) / 2;
    L6:
        int r105 = getChildVerticalGravity(r102.gravity);
        if (r105 == 48) goto L21;
        if (r105 == 80) goto L19;
        int r106 = getPaddingTop();
        int r107 = getPaddingBottom();
        int r108 = getHeight();
        int r109 = (((r108 - r106) - r107) - r103) / 2;
        int r110 = ((ViewGroup.MarginLayoutParams) r102).topMargin;
        if (r109 >= r110) goto L13;
        r109 = r110;
    L17:
        return r106 + r109;
    L13:
        int r111 = (((r108 - r107) - r103) - r109) - r106;
        int r112 = ((ViewGroup.MarginLayoutParams) r102).bottomMargin;
        if (r111 >= r112) goto L17;
        r109 = Math.max(0, r109 - (r112 - r111));
        goto L17
    L19:
        return (((getHeight() - getPaddingBottom()) - r103) - ((ViewGroup.MarginLayoutParams) r102).bottomMargin) - r104;
    L21:
        return getPaddingTop() - r104;
    L5:
        r104 = 0;
        goto L6
    }

    private int getViewListMeasuredWidth(List<View> r100, int[] r110) {
        int r101 = r110[0];
        int r111 = r110[1];
        int r102 = r100.size();
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L5;
        View r105 = (View) ListProtector.get(r100, r103);
        LayoutParams r106 = (LayoutParams) r105.getLayoutParams();
        int r107 = ((ViewGroup.MarginLayoutParams) r106).leftMargin - r101;
        int r108 = ((ViewGroup.MarginLayoutParams) r106).rightMargin - r111;
        int r112 = Math.max(0, r107);
        int r109 = Math.max(0, r108);
        int r113 = Math.max(0, -r107);
        int r114 = Math.max(0, -r108);
        r104 = r104 + ((r112 + r105.getMeasuredWidth()) + r109);
        r103 = r103 + 1;
        r111 = r114;
        r101 = r113;
        goto L3
    L5:
        return r104;
    }

    @Override // android.view.View
    public void onMeasure(int r110, int r111) {
        int[] r100 = this.mTempMargins;
        boolean r101 = ViewUtils.isLayoutRtl(this);
        int r112 = 0;
        int r113 = !r101 ? 1 : 0;
        if (shouldLayout(this.mNavButtonView) == false) goto L5;
        measureChildConstrained(this.mNavButtonView, r110, 0, r111, 0, this.mMaxButtonHeight);
        int r102 = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
        int r103 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
        int r114 = r103;
        int r115 = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
    L7:
        if (shouldLayout(this.mCollapseButtonView) == false) goto L9;
        measureChildConstrained(this.mCollapseButtonView, r110, 0, r111, 0, this.mMaxButtonHeight);
        r102 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
        r114 = Math.max(r114, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
        r115 = View.combineMeasuredStates(r115, this.mCollapseButtonView.getMeasuredState());
    L9:
        int r104 = getCurrentContentInsetStart();
        int r116 = 0 + Math.max(r104, r102);
        int r105 = Math.max(0, r104 - r102);
        r100[r101 ? 1 : 0] = r105;
        if (shouldLayout(this.mMenuView) == false) goto L12;
        measureChildConstrained(this.mMenuView, r110, r116, r111, 0, this.mMaxButtonHeight);
        int r106 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
        r114 = Math.max(r114, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
        r115 = View.combineMeasuredStates(r115, this.mMenuView.getMeasuredState());
    L13:
        int r107 = getCurrentContentInsetEnd();
        int r117 = r116 + Math.max(r107, r106);
        r100[r113] = Math.max(0, r107 - r106);
        if (shouldLayout(this.mExpandedActionView) == false) goto L17;
        r117 = r117 + measureChildCollapseMargins(this.mExpandedActionView, r110, r117, r111, 0, r100);
        r114 = Math.max(r114, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
        r115 = View.combineMeasuredStates(r115, this.mExpandedActionView.getMeasuredState());
    L17:
        if (shouldLayout(this.mLogoView) == false) goto L19;
        r117 = r117 + measureChildCollapseMargins(this.mLogoView, r110, r117, r111, 0, r100);
        r114 = Math.max(r114, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
        r115 = View.combineMeasuredStates(r115, this.mLogoView.getMeasuredState());
    L19:
        int r108 = getChildCount();
        int r118 = 0;
    L20:
        if (r118 >= r108) goto L28;
        View r119 = getChildAt(r118);
        if (((LayoutParams) r119.getLayoutParams()).mViewType != 0) goto L27;
        if (shouldLayout(r119) == false) goto L27;
        r117 = r117 + measureChildCollapseMargins(r119, r110, r117, r111, 0, r100);
        int r109 = Math.max(r114, r119.getMeasuredHeight() + getVerticalMargins(r119));
        r114 = r109;
        r115 = View.combineMeasuredStates(r115, r119.getMeasuredState());
    L27:
        r118 = r118 + 1;
        goto L20
    L28:
        int r120 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int r121 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView) == false) goto L31;
        measureChildCollapseMargins(this.mTitleTextView, r110, r117 + r121, r111, r120, r100);
        int r122 = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
        int r123 = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
        int r124 = r123;
        int r125 = View.combineMeasuredStates(r115, this.mTitleTextView.getMeasuredState());
        int r126 = r122;
    L33:
        if (shouldLayout(this.mSubtitleTextView) == false) goto L36;
        int r127 = r124 + r120;
        r126 = Math.max(r126, measureChildCollapseMargins(this.mSubtitleTextView, r110, r117 + r121, r111, r127, r100));
        r124 = r124 + (this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView));
        r125 = View.combineMeasuredStates(r125, this.mSubtitleTextView.getMeasuredState());
    L36:
        int r128 = Math.max(r114, r124);
        int r129 = (r117 + r126) + (getPaddingLeft() + getPaddingRight());
        int r130 = r128 + (getPaddingTop() + getPaddingBottom());
        int r131 = View.resolveSizeAndState(Math.max(r129, getSuggestedMinimumWidth()), r110, (-16777216) & r125);
        int r132 = View.resolveSizeAndState(Math.max(r130, getSuggestedMinimumHeight()), r111, r125 << 16);
        if (shouldCollapse() == true) goto L40;
        r112 = r132;
    L40:
        setMeasuredDimension(r131, r112);
        return;
    L31:
        r125 = r115;
        r126 = 0;
        r124 = 0;
        goto L33
    L12:
        r106 = 0;
        goto L13
    L5:
        r102 = 0;
        r114 = 0;
        r115 = 0;
        goto L7
    }

    public void setContentInsetsAbsolute(int r100, int r101) {
        ensureContentInsets();
        this.mContentInsets.setAbsolute(r100, r101);
    }

    public void setContentInsetsRelative(int r100, int r101) {
        ensureContentInsets();
        this.mContentInsets.setRelative(r100, r101);
    }

    public void setMenu(MenuBuilder r100, ActionMenuPresenter r101) {
        if (r100 == null) goto L4;
    L6:
        ensureMenuView();
        MenuBuilder r102 = this.mMenuView.peekMenu();
        if (r102 != r100) goto L9;
        return;
    L9:
        if (r102 == null) goto L12;
        r102.removeMenuPresenter(this.mOuterActionMenuPresenter);
        r102.removeMenuPresenter(this.mExpandedMenuPresenter);
    L12:
        if (this.mExpandedMenuPresenter != null) goto L14;
        this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(this);
    L14:
        r101.setExpandedActionViewsExclusive(true);
        if (r100 == null) goto L17;
        r100.addMenuPresenter(r101, this.mPopupContext);
        r100.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
    L18:
        this.mMenuView.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setPresenter(r101);
        this.mOuterActionMenuPresenter = r101;
        return;
    L17:
        r101.initForMenu(this.mPopupContext, null);
        this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
        r101.updateMenuView(true);
        this.mExpandedMenuPresenter.updateMenuView(true);
        goto L18
    L4:
        if (this.mMenuView != null) goto L6;
    }

    public void setMenuCallbacks(MenuPresenter.Callback r100, MenuBuilder.Callback r101) {
        this.mActionMenuPresenterCallback = r100;
        this.mMenuBuilderCallback = r101;
        ActionMenuView r102 = this.mMenuView;
        if (r102 == null) goto L6;
        r102.setMenuCallbacks(r100, r101);
        return;
    }

    public void setSubtitleTextAppearance(Context r100, int r101) {
        this.mSubtitleTextAppearance = r101;
        TextView r102 = this.mSubtitleTextView;
        if (r102 == null) goto L6;
        r102.setTextAppearance(r100, r101);
        return;
    }

    public void setTitleTextAppearance(Context r100, int r101) {
        this.mTitleTextAppearance = r101;
        TextView r102 = this.mTitleTextView;
        if (r102 == null) goto L6;
        r102.setTextAppearance(r100, r101);
        return;
    }

    public Toolbar(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList();
        this.mHiddenViews = new ArrayList();
        this.mTempMargins = new int[2];
        this.mMenuViewItemClickListener = new AnonymousClass1(this);
        this.mShowOverflowMenuRunnable = new AnonymousClass2(this);
        TintTypedArray r100 = TintTypedArray.obtainStyledAttributes(getContext(), r111, new int[]{android.R.attr.gravity, android.R.attr.minHeight, R.attr.buttonGravity, R.attr.collapseContentDescription, R.attr.collapseIcon, R.attr.contentInsetEnd, R.attr.contentInsetEndWithActions, R.attr.contentInsetLeft, R.attr.contentInsetRight, R.attr.contentInsetStart, R.attr.contentInsetStartWithNavigation, R.attr.logo, R.attr.logoDescription, R.attr.maxButtonHeight, R.attr.menu, R.attr.navigationContentDescription, R.attr.navigationIcon, R.attr.popupTheme, R.attr.subtitle, R.attr.subtitleTextAppearance, R.attr.subtitleTextColor, R.attr.title, R.attr.titleMargin, R.attr.titleMarginBottom, R.attr.titleMarginEnd, R.attr.titleMarginStart, R.attr.titleMarginTop, R.attr.titleMargins, R.attr.titleTextAppearance, R.attr.titleTextColor}, r112, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r110, new int[]{android.R.attr.gravity, android.R.attr.minHeight, R.attr.buttonGravity, R.attr.collapseContentDescription, R.attr.collapseIcon, R.attr.contentInsetEnd, R.attr.contentInsetEndWithActions, R.attr.contentInsetLeft, R.attr.contentInsetRight, R.attr.contentInsetStart, R.attr.contentInsetStartWithNavigation, R.attr.logo, R.attr.logoDescription, R.attr.maxButtonHeight, R.attr.menu, R.attr.navigationContentDescription, R.attr.navigationIcon, R.attr.popupTheme, R.attr.subtitle, R.attr.subtitleTextAppearance, R.attr.subtitleTextColor, R.attr.title, R.attr.titleMargin, R.attr.titleMarginBottom, R.attr.titleMarginEnd, R.attr.titleMarginStart, R.attr.titleMarginTop, R.attr.titleMargins, R.attr.titleTextAppearance, R.attr.titleTextColor}, r111, r100.getWrappedTypeArray(), r112, 0);
        this.mTitleTextAppearance = r100.getResourceId(28, 0);
        this.mSubtitleTextAppearance = r100.getResourceId(19, 0);
        this.mGravity = r100.getInteger(0, this.mGravity);
        this.mButtonGravity = r100.getInteger(2, 48);
        int r113 = r100.getDimensionPixelOffset(22, 0);
        if (r100.hasValue(27) == false) goto L5;
        r113 = r100.getDimensionPixelOffset(27, r113);
    L5:
        this.mTitleMarginBottom = r113;
        this.mTitleMarginTop = r113;
        this.mTitleMarginEnd = r113;
        this.mTitleMarginStart = r113;
        int r114 = r100.getDimensionPixelOffset(25, -1);
        if (r114 < 0) goto L8;
        this.mTitleMarginStart = r114;
    L8:
        int r115 = r100.getDimensionPixelOffset(24, -1);
        if (r115 < 0) goto L11;
        this.mTitleMarginEnd = r115;
    L11:
        int r116 = r100.getDimensionPixelOffset(26, -1);
        if (r116 < 0) goto L14;
        this.mTitleMarginTop = r116;
    L14:
        int r117 = r100.getDimensionPixelOffset(23, -1);
        if (r117 < 0) goto L17;
        this.mTitleMarginBottom = r117;
    L17:
        this.mMaxButtonHeight = r100.getDimensionPixelSize(13, -1);
        int r118 = r100.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int r119 = r100.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int r101 = r100.getDimensionPixelSize(7, 0);
        int r102 = r100.getDimensionPixelSize(8, 0);
        ensureContentInsets();
        this.mContentInsets.setAbsolute(r101, r102);
        if (r118 != Integer.MIN_VALUE) goto L20;
        if (r119 != Integer.MIN_VALUE) goto L20;
    L21:
        this.mContentInsetStartWithNavigation = r100.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.mContentInsetEndWithActions = r100.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.mCollapseIcon = r100.getDrawable(4);
        this.mCollapseDescription = r100.getText(3);
        CharSequence r120 = r100.getText(21);
        if (TextUtils.isEmpty(r120) == true) goto L24;
        setTitle(r120);
    L24:
        CharSequence r121 = r100.getText(18);
        if (TextUtils.isEmpty(r121) == true) goto L27;
        setSubtitle(r121);
    L27:
        this.mPopupContext = getContext();
        setPopupTheme(r100.getResourceId(17, 0));
        Drawable r122 = r100.getDrawable(16);
        if (r122 == null) goto L30;
        setNavigationIcon(r122);
    L30:
        CharSequence r123 = r100.getText(15);
        if (TextUtils.isEmpty(r123) == true) goto L33;
        setNavigationContentDescription(r123);
    L33:
        Drawable r124 = r100.getDrawable(11);
        if (r124 == null) goto L36;
        setLogo(r124);
    L36:
        CharSequence r125 = r100.getText(12);
        if (TextUtils.isEmpty(r125) == true) goto L40;
        setLogoDescription(r125);
    L40:
        if (r100.hasValue(29) == false) goto L43;
        setTitleTextColor(r100.getColorStateList(29));
    L43:
        if (r100.hasValue(20) == false) goto L46;
        setSubtitleTextColor(r100.getColorStateList(20));
    L46:
        if (r100.hasValue(14) == false) goto L48;
        inflateMenu(r100.getResourceId(14, 0));
    L48:
        r100.recycle();
        return;
    L20:
        this.mContentInsets.setRelative(r118, r119);
        goto L21
    }

    private int layoutChildLeft(View r100, int r101, int[] r102, int r103) {
        LayoutParams r104 = (LayoutParams) r100.getLayoutParams();
        int r105 = ((ViewGroup.MarginLayoutParams) r104).leftMargin - r102[0];
        int r106 = r101 + Math.max(0, r105);
        r102[0] = Math.max(0, -r105);
        int r107 = getChildTop(r100, r103);
        int r108 = r100.getMeasuredWidth();
        r100.layout(r106, r107, r106 + r108, r100.getMeasuredHeight() + r107);
        return r106 + (r108 + ((ViewGroup.MarginLayoutParams) r104).rightMargin);
    }

    private int layoutChildRight(View r100, int r101, int[] r102, int r103) {
        LayoutParams r104 = (LayoutParams) r100.getLayoutParams();
        int r105 = ((ViewGroup.MarginLayoutParams) r104).rightMargin - r102[1];
        int r106 = r101 - Math.max(0, r105);
        r102[1] = Math.max(0, -r105);
        int r107 = getChildTop(r100, r103);
        int r108 = r100.getMeasuredWidth();
        r100.layout(r106 - r108, r107, r106, r100.getMeasuredHeight() + r107);
        return r106 - (r108 + ((ViewGroup.MarginLayoutParams) r104).leftMargin);
    }

    public void setTitleMargin(int r100, int r101, int r102, int r103) {
        this.mTitleMarginStart = r100;
        this.mTitleMarginTop = r101;
        this.mTitleMarginEnd = r102;
        this.mTitleMarginBottom = r103;
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r210, int r211, int r212, int r213, int r214) {
        if (ViewCompat.getLayoutDirection(this) != 1) goto L5;
        boolean r100 = true;
    L6:
        int r101 = getWidth();
        int r102 = getHeight();
        int r103 = getPaddingLeft();
        int r104 = getPaddingRight();
        int r105 = getPaddingTop();
        int r106 = getPaddingBottom();
        int r110 = r101 - r104;
        int[] r111 = this.mTempMargins;
        r111[1] = 0;
        r111[0] = 0;
        int r112 = ViewCompat.getMinimumHeight(this);
        if (r112 < 0) goto L9;
        int r113 = Math.min(r112, r214 - r212);
    L11:
        if (shouldLayout(this.mNavButtonView) == false) goto L15;
        if (r100 == false) goto L14;
        int r114 = layoutChildRight(this.mNavButtonView, r110, r111, r113);
        int r115 = r103;
    L18:
        if (shouldLayout(this.mCollapseButtonView) == false) goto L23;
        if (r100 == false) goto L21;
        r114 = layoutChildRight(this.mCollapseButtonView, r114, r111, r113);
        goto L23
    L21:
        r115 = layoutChildLeft(this.mCollapseButtonView, r115, r111, r113);
    L23:
        if (shouldLayout(this.mMenuView) == false) goto L27;
        if (r100 == false) goto L26;
        r115 = layoutChildLeft(this.mMenuView, r115, r111, r113);
        goto L27
    L26:
        r114 = layoutChildRight(this.mMenuView, r114, r111, r113);
    L27:
        int r116 = getCurrentContentInsetLeft();
        int r117 = getCurrentContentInsetRight();
        r111[0] = Math.max(0, r116 - r115);
        r111[1] = Math.max(0, r117 - (r110 - r114));
        int r107 = Math.max(r115, r116);
        int r118 = Math.min(r114, r110 - r117);
        if (shouldLayout(this.mExpandedActionView) == false) goto L33;
        if (r100 == false) goto L31;
        r118 = layoutChildRight(this.mExpandedActionView, r118, r111, r113);
        goto L33
    L31:
        r107 = layoutChildLeft(this.mExpandedActionView, r107, r111, r113);
    L33:
        if (shouldLayout(this.mLogoView) == false) goto L37;
        if (r100 == false) goto L36;
        r118 = layoutChildRight(this.mLogoView, r118, r111, r113);
        goto L37
    L36:
        r107 = layoutChildLeft(this.mLogoView, r107, r111, r113);
    L37:
        boolean r119 = shouldLayout(this.mTitleTextView);
        boolean r120 = shouldLayout(this.mSubtitleTextView);
        if (r119 == false) goto L40;
        LayoutParams r121 = (LayoutParams) this.mTitleTextView.getLayoutParams();
        int r108 = ((((ViewGroup.MarginLayoutParams) r121).topMargin + this.mTitleTextView.getMeasuredHeight()) + ((ViewGroup.MarginLayoutParams) r121).bottomMargin) + 0;
    L41:
        if (r120 == false) goto L44;
        LayoutParams r109 = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
        r108 = r108 + ((((ViewGroup.MarginLayoutParams) r109).topMargin + this.mSubtitleTextView.getMeasuredHeight()) + ((ViewGroup.MarginLayoutParams) r109).bottomMargin);
    L44:
        if (r119 == true) goto L49;
        if (r120 == true) goto L49;
        int r122 = r103;
        r113 = r113;
    L48:
        int r123 = 0;
    L103:
        addCustomViewsWithGravity(this.mTempViews, 3);
        int r124 = this.mTempViews.size();
        int r125 = 0;
    L104:
        if (r125 >= r124) goto L106;
        r107 = layoutChildLeft((View) ListProtector.get(this.mTempViews, r125), r107, r111, r113);
        r125 = r125 + 1;
        goto L104
    L106:
        int r126 = r113;
        addCustomViewsWithGravity(this.mTempViews, 5);
        int r127 = this.mTempViews.size();
        int r128 = 0;
    L107:
        if (r128 >= r127) goto L109;
        r118 = layoutChildRight((View) ListProtector.get(this.mTempViews, r128), r118, r111, r126);
        r128 = r128 + 1;
        goto L107
    L109:
        addCustomViewsWithGravity(this.mTempViews, 1);
        int r129 = getViewListMeasuredWidth(this.mTempViews, r111);
        int r130 = (r122 + (((r101 - r122) - r104) / 2)) - (r129 / 2);
        int r131 = r129 + r130;
        if (r130 < r107) goto L115;
        if (r131 <= r118) goto L114;
        r107 = r130 - (r131 - r118);
        goto L115
    L114:
        r107 = r130;
    L115:
        int r132 = this.mTempViews.size();
    L116:
        if (r123 >= r132) goto L118;
        r107 = layoutChildLeft((View) ListProtector.get(this.mTempViews, r123), r107, r111, r126);
        r123 = r123 + 1;
        goto L116
    L118:
        this.mTempViews.clear();
        return;
    L49:
        if (r119 == false) goto L51;
        TextView r133 = this.mTitleTextView;
    L52:
        if (r120 == false) goto L54;
        TextView r134 = this.mSubtitleTextView;
    L55:
        LayoutParams r135 = (LayoutParams) r133.getLayoutParams();
        LayoutParams r136 = (LayoutParams) r134.getLayoutParams();
        if (r119 == true) goto L58;
    L59:
        if (r120 == true) goto L61;
    L63:
        boolean r137 = false;
    L64:
        int r138 = this.mGravity & 112;
        r122 = r103;
        if (r138 != 48) goto L67;
        int r139 = (getPaddingTop() + ((ViewGroup.MarginLayoutParams) r135).topMargin) + this.mTitleMarginTop;
    L77:
        if (r100 == false) goto L91;
        if (r137 == false) goto L80;
        int r140 = this.mTitleMarginStart;
    L81:
        int r141 = r140 - r111[1];
        r118 = r118 - Math.max(0, r141);
        r111[1] = Math.max(0, -r141);
        if (r119 == false) goto L84;
        LayoutParams r142 = (LayoutParams) this.mTitleTextView.getLayoutParams();
        int r143 = r118 - this.mTitleTextView.getMeasuredWidth();
        int r144 = this.mTitleTextView.getMeasuredHeight() + r139;
        this.mTitleTextView.layout(r143, r139, r118, r144);
        int r145 = r143 - this.mTitleMarginEnd;
        r139 = r144 + ((ViewGroup.MarginLayoutParams) r142).bottomMargin;
    L85:
        if (r120 == false) goto L87;
        int r146 = r139 + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSubtitleTextView.getLayoutParams())).topMargin;
        int r147 = r118 - this.mSubtitleTextView.getMeasuredWidth();
        int r148 = this.mSubtitleTextView.getMeasuredHeight() + r146;
        this.mSubtitleTextView.layout(r147, r146, r118, r148);
        int r149 = r118 - this.mTitleMarginEnd;
    L88:
        if (r137 == false) goto L90;
        r118 = Math.min(r145, r149);
    L90:
        r107 = r107;
        goto L48
    L87:
        r149 = r118;
        goto L88
    L84:
        r145 = r118;
        goto L85
    L80:
        r140 = 0;
        goto L81
    L91:
        if (r137 == false) goto L93;
        int r150 = this.mTitleMarginStart;
        r123 = 0;
    L94:
        int r151 = r150 - r111[r123];
        r107 = r107 + Math.max(r123, r151);
        r111[r123] = Math.max(r123, -r151);
        if (r119 == false) goto L97;
        LayoutParams r152 = (LayoutParams) this.mTitleTextView.getLayoutParams();
        int r153 = this.mTitleTextView.getMeasuredWidth() + r107;
        int r154 = this.mTitleTextView.getMeasuredHeight() + r139;
        this.mTitleTextView.layout(r107, r139, r153, r154);
        int r155 = r153 + this.mTitleMarginEnd;
        r139 = r154 + ((ViewGroup.MarginLayoutParams) r152).bottomMargin;
    L98:
        if (r120 == false) goto L100;
        int r156 = r139 + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSubtitleTextView.getLayoutParams())).topMargin;
        int r157 = this.mSubtitleTextView.getMeasuredWidth() + r107;
        int r158 = this.mSubtitleTextView.getMeasuredHeight() + r156;
        this.mSubtitleTextView.layout(r107, r156, r157, r158);
        int r159 = r157 + this.mTitleMarginEnd;
    L101:
        if (r137 == false) goto L103;
        r107 = Math.max(r155, r159);
        goto L103
    L100:
        r159 = r107;
        goto L101
    L97:
        r155 = r107;
        goto L98
    L93:
        r123 = 0;
        r150 = 0;
        goto L94
    L67:
        if (r138 == 80) goto L75;
        int r160 = (((r102 - r105) - r106) - r108) / 2;
        int r161 = ((ViewGroup.MarginLayoutParams) r135).topMargin;
        int r162 = this.mTitleMarginTop;
        if (r160 >= (r161 + r162)) goto L71;
        r160 = r161 + r162;
    L74:
        r139 = r105 + r160;
        goto L77
    L71:
        int r163 = (((r102 - r106) - r108) - r160) - r105;
        int r164 = ((ViewGroup.MarginLayoutParams) r135).bottomMargin;
        int r165 = this.mTitleMarginBottom;
        if (r163 >= (r164 + r165)) goto L74;
        r160 = Math.max(0, r160 - ((((ViewGroup.MarginLayoutParams) r136).bottomMargin + r165) - r163));
        goto L74
    L75:
        r139 = (((r102 - r106) - ((ViewGroup.MarginLayoutParams) r136).bottomMargin) - this.mTitleMarginBottom) - r108;
        goto L77
    L61:
        if (this.mSubtitleTextView.getMeasuredWidth() <= 0) goto L63;
    L62:
        r137 = true;
        goto L64
    L58:
        if (this.mTitleTextView.getMeasuredWidth() > 0) goto L62;
    L54:
        r134 = this.mTitleTextView;
        goto L55
    L51:
        r133 = this.mSubtitleTextView;
        goto L52
    L40:
        r108 = 0;
        goto L41
    L14:
        r115 = layoutChildLeft(this.mNavButtonView, r103, r111, r113);
    L16:
        r114 = r110;
        goto L18
    L15:
        r115 = r103;
        goto L16
    L9:
        r113 = 0;
        goto L11
    L5:
        r100 = false;
        goto L6
    }

    private int measureChildCollapseMargins(View r100, int r101, int r110, int r111, int r112, int[] r113) {
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r100.getLayoutParams();
        int r103 = r102.leftMargin - r113[0];
        int r104 = r102.rightMargin - r113[1];
        int r105 = Math.max(0, r103) + Math.max(0, r104);
        r113[0] = Math.max(0, -r103);
        r113[1] = Math.max(0, -r104);
        r100.measure(ViewGroup.getChildMeasureSpec(r101, ((getPaddingLeft() + getPaddingRight()) + r105) + r110, r102.width), ViewGroup.getChildMeasureSpec(r111, (((getPaddingTop() + getPaddingBottom()) + r102.topMargin) + r102.bottomMargin) + r112, r102.height));
        return r100.getMeasuredWidth() + r105;
    }

    private void measureChildConstrained(View r100, int r101, int r102, int r103, int r104, int r105) {
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r100.getLayoutParams();
        int r107 = ViewGroup.getChildMeasureSpec(r101, (((getPaddingLeft() + getPaddingRight()) + r106.leftMargin) + r106.rightMargin) + r102, r106.width);
        int r108 = ViewGroup.getChildMeasureSpec(r103, (((getPaddingTop() + getPaddingBottom()) + r106.topMargin) + r106.bottomMargin) + r104, r106.height);
        int r109 = View.MeasureSpec.getMode(r108);
        if (r109 == 1073741824) goto L8;
        if (r105 < 0) goto L8;
        if (r109 == 0) goto L7;
        r105 = Math.min(View.MeasureSpec.getSize(r108), r105);
    L7:
        r108 = View.MeasureSpec.makeMeasureSpec(r105, 1073741824);
    L8:
        r100.measure(r107, r108);
    }
}
