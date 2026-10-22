package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes2.dex */
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
    static final int GENERATED_ITEM_PADDING = 4;
    static final int MIN_CELL_SIZE = 56;
    private static final String TAG = "ActionMenuView";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private MenuBuilder mMenu;
    MenuBuilder.Callback mMenuBuilderCallback;
    private int mMinCellSize;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private Context mPopupContext;
    private int mPopupTheme;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    public static class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder r100, boolean r101) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder r100) {
            return false;
        }

        public ActionMenuPresenterCallback() {
        }
    }

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {

        @ViewDebug.ExportedProperty
        public int cellsUsed;

        @ViewDebug.ExportedProperty
        public boolean expandable;
        boolean expanded;

        @ViewDebug.ExportedProperty
        public int extraPixels;

        @ViewDebug.ExportedProperty
        public boolean isOverflowButton;

        @ViewDebug.ExportedProperty
        public boolean preventEdgeOffset;

        public LayoutParams(LayoutParams r100) {
            super(r100);
            this.isOverflowButton = r100.isOverflowButton;
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
            this.isOverflowButton = false;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
        }

        public LayoutParams(int r100, int r101, boolean r102) {
            super(r100, r101);
            this.isOverflowButton = r102;
        }
    }

    public class MenuBuilderCallback implements MenuBuilder.Callback {
        final /* synthetic */ ActionMenuView this$0;

        public MenuBuilderCallback(ActionMenuView r100) {
            this.this$0 = r100;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder r100) {
            MenuBuilder.Callback r101 = this.this$0.mMenuBuilderCallback;
            if (r101 == null) goto L6;
            r101.onMenuModeChange(r100);
            return;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder r100, MenuItem r101) {
            OnMenuItemClickListener r102 = this.this$0.mOnMenuItemClickListener;
            if (r102 != null) goto L5;
        L7:
            return false;
        L5:
            if (r102.onMenuItemClick(r101) == false) goto L7;
            return true;
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem r100);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r100) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter r100 = this.mPresenter;
        if (r100 == null) goto L6;
        r100.dismissPopupMenus();
        return;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams r100 = new LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams) r100).gravity = 16;
        return r100;
    }

    public Menu getMenu() {
        if (this.mMenu != null) goto L10;
        Context r100 = getContext();
        MenuBuilder r101 = new MenuBuilder(r100);
        this.mMenu = r101;
        r101.setCallback(new MenuBuilderCallback(this));
        ActionMenuPresenter r102 = new ActionMenuPresenter(r100);
        this.mPresenter = r102;
        r102.setReserveOverflow(true);
        ActionMenuPresenter r103 = this.mPresenter;
        MenuPresenter.Callback r104 = this.mActionMenuPresenterCallback;
        if (r104 != null) goto L8;
        r104 = new ActionMenuPresenterCallback();
    L8:
        r103.setCallback(r104);
        this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
        this.mPresenter.setMenuView(this);
    L10:
        return this.mMenu;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter r100 = this.mPresenter;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.hideOverflowMenu() == false) goto L7;
        return true;
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter r100 = this.mPresenter;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isOverflowMenuShowPending() == false) goto L7;
        return true;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter r100 = this.mPresenter;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isOverflowMenuShowing() == false) goto L7;
        return true;
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter r100 = this.mPresenter;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.showOverflowMenu() == false) goto L7;
        return true;
    }

    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams r100 = generateDefaultLayoutParams();
        r100.isOverflowButton = true;
        return r100;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.mPresenter.getOverflowIcon();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public MenuBuilder peekMenu() {
        return this.mMenu;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    public ActionMenuView(Context r100) {
        this(r100, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_widget_ActionMenuView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof LayoutParams;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        if (r100 == null) goto L12;
        if ((r100 instanceof LayoutParams) == false) goto L6;
        LayoutParams r101 = new LayoutParams((LayoutParams) r100);
    L8:
        if (((LinearLayout.LayoutParams) r101).gravity > 0) goto L10;
        ((LinearLayout.LayoutParams) r101).gravity = 16;
    L10:
        return r101;
    L6:
        r101 = new LayoutParams(r100);
        goto L8
    L12:
        return generateDefaultLayoutParams();
    }

    public boolean hasSupportDividerBeforeChildAt(int r100) {
        boolean r101 = false;
        if (r100 != 0) goto L5;
        return false;
    L5:
        KeyEvent.Callback r102 = getChildAt(r100 - 1);
        KeyEvent.Callback r103 = getChildAt(r100);
        if (r100 < getChildCount()) goto L8;
    L10:
        if (r100 > 0) goto L12;
        return r101;
    L12:
        if ((r103 instanceof ActionMenuChildView) == true) goto L14;
        return r101;
    L14:
        return r101 | ((ActionMenuChildView) r103).needsDividerBefore();
    L8:
        if ((r102 instanceof ActionMenuChildView) == false) goto L10;
        r101 = false | ((ActionMenuChildView) r102).needsDividerAfter();
        goto L10
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder r100) {
        this.mMenu = r100;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    public boolean invokeItem(MenuItemImpl r100) {
        return this.mMenu.performItemAction(r100, 0);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        ActionMenuPresenter r101 = this.mPresenter;
        if (r101 == null) goto L8;
        r101.updateMenuView(false);
        if (this.mPresenter.isOverflowMenuShowing() == false) goto L9;
        this.mPresenter.hideOverflowMenu();
        this.mPresenter.showOverflowMenu();
        return;
    L9:
        return;
    }

    public void setExpandedActionViewsExclusive(boolean r100) {
        this.mPresenter.setExpandedActionViewsExclusive(r100);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener r100) {
        this.mOnMenuItemClickListener = r100;
    }

    public void setOverflowIcon(Drawable r100) {
        getMenu();
        this.mPresenter.setOverflowIcon(r100);
    }

    public void setOverflowReserved(boolean r100) {
        this.mReserveOverflow = r100;
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

    public void setPresenter(ActionMenuPresenter r100) {
        this.mPresenter = r100;
        r100.setMenuView(this);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateLayoutParams(r100);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return generateLayoutParams(r100);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateLayoutParams(r100);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return generateLayoutParams(r100);
    }

    public ActionMenuView(Context r100, AttributeSet r101) {
        super(r100, r101);
        setBaselineAligned(false);
        float r102 = INVOKEVIRTUAL_androidx_appcompat_widget_ActionMenuView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density;
        this.mMinCellSize = (int) (56.0f * r102);
        this.mGeneratedItemPadding = (int) (r102 * 4.0f);
        this.mPopupContext = r100;
        this.mPopupTheme = 0;
    }

    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9, types: [boolean, int] */
    private void onMeasureExactFormat(int r310, int r311) {
        int r100 = View.MeasureSpec.getMode(r311);
        int r101 = View.MeasureSpec.getSize(r310);
        int r102 = View.MeasureSpec.getSize(r311);
        int r103 = getPaddingLeft() + getPaddingRight();
        int r104 = getPaddingTop() + getPaddingBottom();
        int r105 = ViewGroup.getChildMeasureSpec(r311, r104, -2);
        int r106 = r101 - r103;
        int r107 = this.mMinCellSize;
        int r108 = r106 / r107;
        int r109 = r106 % r107;
        if (r108 != 0) goto L6;
        setMeasuredDimension(r106, 0);
        return;
    L6:
        int r110 = r107 + (r109 / r108);
        int r111 = getChildCount();
        int r112 = 0;
        int r113 = 0;
        boolean r114 = false;
        int r115 = 0;
        int r116 = 0;
        int r117 = 0;
        long r118 = 0;
    L7:
        if (r113 >= r111) goto L37;
        View r119 = getChildAt(r113);
        int r120 = r102;
        if (r119.getVisibility() == 8) goto L36;
        boolean r121 = r119 instanceof ActionMenuItemView;
        int r122 = r115 + 1;
        if (r121 == false) goto L14;
        int r123 = this.mGeneratedItemPadding;
        ?? r124 = 0;
        r119.setPadding(r123, 0, r123, 0);
    L15:
        LayoutParams r125 = (LayoutParams) r119.getLayoutParams();
        r125.expanded = r124;
        r125.extraPixels = r124;
        r125.cellsUsed = r124;
        r125.expandable = r124;
        ((LinearLayout.LayoutParams) r125).leftMargin = r124;
        ((LinearLayout.LayoutParams) r125).rightMargin = r124;
        if (r121 == true) goto L18;
    L20:
        boolean r126 = false;
    L21:
        r125.preventEdgeOffset = r126;
        if (r125.isOverflowButton == false) goto L24;
        int r127 = 1;
    L25:
        int r128 = measureChildForCells(r119, r110, r127, r105, r104);
        r116 = Math.max(r116, r128);
        if (r125.expandable == false) goto L29;
        r117 = r117 + 1;
    L29:
        if (r125.isOverflowButton == false) goto L31;
        r114 = true;
    L31:
        r108 = r108 - r128;
        r112 = Math.max(r112, r119.getMeasuredHeight());
        if (r128 != 1) goto L35;
        r118 = r118 | ((long) (1 << r113));
        r112 = r112;
    L35:
        r115 = r122;
        goto L36
    L24:
        r127 = r108;
        goto L25
    L18:
        if (((ActionMenuItemView) r119).hasText() == false) goto L20;
        r126 = true;
        goto L21
    L14:
        r124 = 0;
    L36:
        r113 = r113 + 1;
        r102 = r120;
        goto L7
    L37:
        int r129 = r102;
        if (r114 == false) goto L41;
        if (r115 != 2) goto L41;
        boolean r130 = true;
    L42:
        boolean r131 = false;
    L43:
        if (r117 <= 0) goto L78;
        if (r108 <= 0) goto L78;
        int r132 = 0;
        int r133 = 0;
        int r134 = Integer.MAX_VALUE;
        long r210 = 0;
    L46:
        if (r133 >= r111) goto L57;
        boolean r211 = r131;
        LayoutParams r135 = (LayoutParams) getChildAt(r133).getLayoutParams();
        int r212 = r112;
        if (r135.expandable == false) goto L56;
        int r136 = r135.cellsUsed;
        if (r136 >= r134) goto L54;
        r210 = 1 << r133;
        r134 = r136;
        r132 = 1;
        goto L56
    L54:
        if (r136 != r134) goto L56;
        r132 = r132 + 1;
        r210 = r210 | (1 << r133);
    L56:
        r133 = r133 + 1;
        r112 = r212;
        r131 = r211;
        goto L46
    L57:
        boolean r213 = r131;
        int r214 = r112;
        r118 = r118 | r210;
        if (r132 > r108) goto L80;
        int r137 = r134 + 1;
        int r138 = 0;
    L61:
        if (r138 >= r111) goto L77;
        View r139 = getChildAt(r138);
        LayoutParams r140 = (LayoutParams) r139.getLayoutParams();
        int r215 = r106;
        int r141 = r100;
        long r142 = 1 << r138;
        if ((r210 & r142) == 0) goto L65;
        if (r130 == false) goto L75;
        if (r140.preventEdgeOffset == false) goto L75;
        if (r108 != 1) goto L75;
        int r143 = this.mGeneratedItemPadding;
        r139.setPadding(r143 + r110, 0, r143, 0);
    L75:
        r140.cellsUsed++;
        r140.expanded = true;
        r108 = r108 - 1;
    L76:
        r138 = r138 + 1;
        r100 = r141;
        r106 = r215;
        r130 = r130;
        goto L61
    L65:
        if (r140.cellsUsed != r137) goto L67;
        r118 = r118 | r142;
    L67:
        r130 = r130;
        goto L76
    L77:
        r112 = r214;
        r131 = true;
    L80:
        if (r114 == true) goto L83;
        if (r115 != 1) goto L83;
        boolean r144 = true;
    L84:
        if (r108 > 0) goto L86;
    L133:
        boolean r145 = r213;
    L135:
        if (r145 == false) goto L143;
        int r146 = 0;
    L137:
        if (r146 >= r111) goto L143;
        View r147 = getChildAt(r146);
        LayoutParams r148 = (LayoutParams) r147.getLayoutParams();
        if (r148.expanded == false) goto L142;
        r147.measure(View.MeasureSpec.makeMeasureSpec((r148.cellsUsed * r110) + r148.extraPixels, 1073741824), r105);
    L142:
        r146 = r146 + 1;
    L143:
        if (r100 == 1073741824) goto L145;
        int r149 = r214;
    L146:
        setMeasuredDimension(r106, r149);
        return;
    L145:
        r149 = r129;
        goto L146
    L86:
        if (r118 == 0) goto L133;
        if (r108 < (r115 - 1)) goto L91;
        if (r144 == true) goto L91;
        if (r116 <= 1) goto L133;
    L91:
        float r150 = Long.bitCount(r118);
        if (r144 == true) goto L105;
        if ((r118 & 1) != 0) goto L96;
    L98:
        int r151 = r111 - 1;
        if ((r118 & ((long) (1 << r151))) == 0) goto L105;
        if (((LayoutParams) getChildAt(r151).getLayoutParams()).preventEdgeOffset == true) goto L105;
        r150 = r150 - 0.5f;
        goto L105
    L96:
        if (((LayoutParams) getChildAt(0).getLayoutParams()).preventEdgeOffset == true) goto L98;
        r150 = r150 - 0.5f;
    L105:
        if (r150 <= 0.0f) goto L107;
        int r152 = (int) ((r108 * r110) / r150);
    L108:
        r145 = r213;
        int r153 = 0;
    L109:
        if (r153 >= r111) goto L135;
        if ((r118 & ((long) (1 << r153))) == 0) goto L132;
        View r154 = getChildAt(r153);
        LayoutParams r155 = (LayoutParams) r154.getLayoutParams();
        if ((r154 instanceof ActionMenuItemView) == false) goto L123;
        r155.extraPixels = r152;
        r155.expanded = true;
        if (r153 != 0) goto L125;
        if (r155.preventEdgeOffset == true) goto L125;
        ((LinearLayout.LayoutParams) r155).leftMargin = (-r152) / 2;
    L125:
        r145 = true;
        goto L132
    L123:
        if (r155.isOverflowButton == false) goto L127;
        r155.extraPixels = r152;
        r155.expanded = true;
        ((LinearLayout.LayoutParams) r155).rightMargin = (-r152) / 2;
        goto L125
    L127:
        if (r153 == 0) goto L130;
        ((LinearLayout.LayoutParams) r155).leftMargin = r152 / 2;
    L130:
        if (r153 == (r111 - 1)) goto L132;
        ((LinearLayout.LayoutParams) r155).rightMargin = r152 / 2;
    L132:
        r153 = r153 + 1;
        goto L109
    L107:
        r152 = 0;
    L83:
        r144 = false;
    L78:
        r213 = r131;
        r214 = r112;
    L41:
        r130 = false;
        goto L42
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int r100, int r101) {
        boolean r102 = this.mFormatItems;
        if (View.MeasureSpec.getMode(r100) != 1073741824) goto L5;
        boolean r103 = true;
    L6:
        this.mFormatItems = r103;
        if (r102 == r103) goto L9;
        this.mFormatItemsWidth = 0;
    L9:
        int r104 = View.MeasureSpec.getSize(r100);
        if (this.mFormatItems == false) goto L16;
        MenuBuilder r105 = this.mMenu;
        if (r105 == null) goto L16;
        if (r104 == this.mFormatItemsWidth) goto L16;
        this.mFormatItemsWidth = r104;
        r105.onItemsChanged(true);
    L16:
        int r106 = getChildCount();
        if (this.mFormatItems == false) goto L20;
        if (r106 <= 0) goto L20;
        onMeasureExactFormat(r100, r101);
        return;
    L20:
        int r107 = 0;
    L21:
        if (r107 >= r106) goto L23;
        LayoutParams r108 = (LayoutParams) getChildAt(r107).getLayoutParams();
        ((LinearLayout.LayoutParams) r108).rightMargin = 0;
        ((LinearLayout.LayoutParams) r108).leftMargin = 0;
        r107 = r107 + 1;
        goto L21
    L23:
        super.onMeasure(r100, r101);
        return;
    L5:
        r103 = false;
        goto L6
    }

    public void setMenuCallbacks(MenuPresenter.Callback r100, MenuBuilder.Callback r101) {
        this.mActionMenuPresenterCallback = r100;
        this.mMenuBuilderCallback = r101;
    }

    public static int measureChildForCells(View r100, int r101, int r102, int r103, int r104) {
        LayoutParams r105 = (LayoutParams) r100.getLayoutParams();
        int r106 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r103) - r104, View.MeasureSpec.getMode(r103));
        if ((r100 instanceof ActionMenuItemView) == false) goto L5;
        ActionMenuItemView r107 = (ActionMenuItemView) r100;
    L6:
        boolean r108 = true;
        if (r107 != null) goto L9;
    L11:
        boolean r109 = false;
    L12:
        if (r102 <= 0) goto L23;
        int r110 = 2;
        if (r109 == false) goto L16;
        if (r102 < 2) goto L23;
    L16:
        r100.measure(View.MeasureSpec.makeMeasureSpec(r102 * r101, Integer.MIN_VALUE), r106);
        int r111 = r100.getMeasuredWidth();
        int r112 = r111 / r101;
        if ((r111 % r101) == 0) goto L19;
        r112 = r112 + 1;
    L19:
        if (r109 == false) goto L22;
        if (r112 >= 2) goto L22;
    L25:
        if (r105.isOverflowButton == true) goto L28;
        if (r109 == false) goto L28;
    L29:
        r105.expandable = r108;
        r105.cellsUsed = r110;
        r100.measure(View.MeasureSpec.makeMeasureSpec(r101 * r110, 1073741824), r106);
        return r110;
    L28:
        r108 = false;
    L22:
        r110 = r112;
    L23:
        r110 = 0;
        goto L25
    L9:
        if (r107.hasText() == false) goto L11;
        r109 = true;
        goto L12
    L5:
        r107 = null;
        goto L6
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r110, int r111, int r210, int r211, int r212) {
        if (this.mFormatItems == true) goto L6;
        super.onLayout(r110, r111, r210, r211, r212);
        return;
    L6:
        int r100 = getChildCount();
        int r101 = (r212 - r210) / 2;
        int r102 = getDividerWidth();
        int r103 = r211 - r111;
        int r104 = (r103 - getPaddingRight()) - getPaddingLeft();
        boolean r105 = ViewUtils.isLayoutRtl(this);
        int r106 = 0;
        int r107 = 0;
        int r112 = 0;
    L8:
        if (r106 >= r100) goto L24;
        View r113 = getChildAt(r106);
        if (r113.getVisibility() == 8) goto L23;
        LayoutParams r114 = (LayoutParams) r113.getLayoutParams();
        if (r114.isOverflowButton == false) goto L22;
        int r108 = r113.getMeasuredWidth();
        if (hasSupportDividerBeforeChildAt(r106) == false) goto L17;
        r108 = r108 + r102;
    L17:
        int r115 = r113.getMeasuredHeight();
        if (r105 == false) goto L20;
        int r116 = getPaddingLeft() + ((LinearLayout.LayoutParams) r114).leftMargin;
        int r117 = r116 + r108;
    L21:
        int r109 = r101 - (r115 / 2);
        r113.layout(r116, r109, r117, r115 + r109);
        r104 = r104 - r108;
        r107 = 1;
        goto L23
    L20:
        r117 = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) r114).rightMargin;
        r116 = r117 - r108;
        goto L21
    L22:
        r104 = r104 - ((r113.getMeasuredWidth() + ((LinearLayout.LayoutParams) r114).leftMargin) + ((LinearLayout.LayoutParams) r114).rightMargin);
        hasSupportDividerBeforeChildAt(r106);
        r112 = r112 + 1;
    L23:
        r106 = r106 + 1;
        goto L8
    L24:
        if (r100 != 1) goto L28;
        if (r107 != 0) goto L28;
        View r118 = getChildAt(0);
        int r119 = r118.getMeasuredWidth();
        int r120 = r118.getMeasuredHeight();
        int r121 = (r103 / 2) - (r119 / 2);
        int r122 = r101 - (r120 / 2);
        r118.layout(r121, r122, r119 + r121, r120 + r122);
        return;
    L28:
        int r123 = r112 - (r107 ^ 1);
        if (r123 <= 0) goto L31;
        int r124 = r104 / r123;
    L32:
        int r125 = Math.max(0, r124);
        if (r105 == false) goto L43;
        int r126 = getWidth() - getPaddingRight();
        int r127 = 0;
    L35:
        if (r127 >= r100) goto L52;
        View r128 = getChildAt(r127);
        LayoutParams r129 = (LayoutParams) r128.getLayoutParams();
        if (r128.getVisibility() == 8) goto L42;
        if (r129.isOverflowButton == true) goto L42;
        int r130 = r126 - ((LinearLayout.LayoutParams) r129).rightMargin;
        int r131 = r128.getMeasuredWidth();
        int r132 = r128.getMeasuredHeight();
        int r133 = r101 - (r132 / 2);
        r128.layout(r130 - r131, r133, r130, r132 + r133);
        r126 = r130 - ((r131 + ((LinearLayout.LayoutParams) r129).leftMargin) + r125);
    L42:
        r127 = r127 + 1;
        goto L35
    L52:
        return;
    L43:
        int r134 = getPaddingLeft();
        int r135 = 0;
    L44:
        if (r135 >= r100) goto L65;
        View r136 = getChildAt(r135);
        LayoutParams r137 = (LayoutParams) r136.getLayoutParams();
        if (r136.getVisibility() == 8) goto L51;
        if (r137.isOverflowButton == true) goto L51;
        int r138 = r134 + ((LinearLayout.LayoutParams) r137).leftMargin;
        int r139 = r136.getMeasuredWidth();
        int r140 = r136.getMeasuredHeight();
        int r141 = r101 - (r140 / 2);
        r136.layout(r138, r141, r138 + r139, r140 + r141);
        r134 = r138 + ((r139 + ((LinearLayout.LayoutParams) r137).rightMargin) + r125);
    L51:
        r135 = r135 + 1;
        goto L44
    L65:
        return;
    L31:
        r124 = 0;
        goto L32
    }
}
