package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes2.dex */
public class ActionBarContextView extends AbsActionBarView {
    private View mClose;
    private View mCloseButton;
    private int mCloseItemLayout;
    private View mCustomView;
    private CharSequence mSubtitle;
    private int mSubtitleStyleRes;
    private TextView mSubtitleView;
    private CharSequence mTitle;
    private LinearLayout mTitleLayout;
    private boolean mTitleOptional;
    private int mTitleStyleRes;
    private TextView mTitleView;

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    private void initTitle() {
        if (this.mTitleLayout != null) goto L10;
        LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
        LinearLayout r100 = (LinearLayout) getChildAt(getChildCount() - 1);
        this.mTitleLayout = r100;
        this.mTitleView = (TextView) r100.findViewById(R.id.action_bar_title);
        this.mSubtitleView = (TextView) this.mTitleLayout.findViewById(R.id.action_bar_subtitle);
        if (this.mTitleStyleRes == 0) goto L8;
        this.mTitleView.setTextAppearance(getContext(), this.mTitleStyleRes);
    L8:
        if (this.mSubtitleStyleRes == 0) goto L10;
        this.mSubtitleView.setTextAppearance(getContext(), this.mSubtitleStyleRes);
    L10:
        this.mTitleView.setText(this.mTitle);
        this.mSubtitleView.setText(this.mSubtitle);
        boolean r101 = !TextUtils.isEmpty(this.mTitle);
        boolean r102 = !TextUtils.isEmpty(this.mSubtitle);
        TextView r103 = this.mSubtitleView;
        int r104 = 0;
        if (r102 == false) goto L13;
        int r105 = 0;
    L14:
        r103.setVisibility(r105);
        LinearLayout r106 = this.mTitleLayout;
        if (r101 == true) goto L19;
        if (r102 == true) goto L19;
        r104 = 8;
    L19:
        r106.setVisibility(r104);
        if (this.mTitleLayout.getParent() != null) goto L23;
        addView(this.mTitleLayout);
        return;
    L23:
        return;
    L13:
        r105 = 8;
        goto L14
    }

    public void closeMode() {
        if (this.mClose != null) goto L6;
        killMode();
        return;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean hideOverflowMenu() {
        ActionMenuPresenter r100 = this.mActionMenuPresenter;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter r100 = this.mActionMenuPresenter;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean showOverflowMenu() {
        ActionMenuPresenter r100 = this.mActionMenuPresenter;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.showOverflowMenu();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean canShowOverflowMenu() {
        return super.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean isOverflowMenuShowPending() {
        return super.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean isOverflowReserved() {
        return super.isOverflowReserved();
    }

    public void killMode() {
        removeAllViews();
        this.mCustomView = null;
        this.mMenuView = null;
        this.mActionMenuPresenter = null;
        View r100 = this.mCloseButton;
        if (r100 == null) goto L6;
        r100.setOnClickListener(null);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter r100 = this.mActionMenuPresenter;
        if (r100 == null) goto L6;
        r100.hideOverflowMenu();
        this.mActionMenuPresenter.hideSubMenus();
        return;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void dismissPopupMenus() {
        super.dismissPopupMenus();
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public boolean isTitleOptional() {
        return this.mTitleOptional;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void postShowOverflowMenu() {
        super.postShowOverflowMenu();
    }

    public ActionBarContextView(Context r100) {
        this(r100, null);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void animateToVisibility(int r100) {
        super.animateToVisibility(r100);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new ViewGroup.MarginLayoutParams(getContext(), r100);
    }

    public void initForMode(final ActionMode r100) {
        View r101 = this.mClose;
        if (r101 != null) goto L6;
        View r102 = LayoutInflater.from(getContext()).inflate(this.mCloseItemLayout, this, false);
        this.mClose = r102;
        addView(r102);
    L8:
        View r103 = this.mClose.findViewById(R.id.action_mode_close_button);
        this.mCloseButton = r103;
        r103.setOnClickListener(new AnonymousClass1(this, r100));
        MenuBuilder r104 = (MenuBuilder) r100.getMenu();
        ActionMenuPresenter r105 = this.mActionMenuPresenter;
        if (r105 == null) goto L11;
        r105.dismissPopupMenus();
    L11:
        ActionMenuPresenter r106 = new ActionMenuPresenter(getContext());
        this.mActionMenuPresenter = r106;
        r106.setReserveOverflow(true);
        ViewGroup.LayoutParams r107 = new ViewGroup.LayoutParams(-2, -1);
        r104.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
        ActionMenuView r108 = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
        this.mMenuView = r108;
        ViewCompat.setBackground(r108, null);
        addView(this.mMenuView, r107);
        return;
    L6:
        if (r101.getParent() != null) goto L8;
        addView(this.mClose);
        goto L8
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent r100) {
        return super.onHoverEvent(r100);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r100) {
        if (r100.getEventType() != 32) goto L5;
        r100.setSource(this);
        r100.setClassName(getClass().getName());
        r100.setPackageName(getContext().getPackageName());
        r100.setContentDescription(this.mTitle);
        return;
    L5:
        super.onInitializeAccessibilityEvent(r100);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent r100) {
        return super.onTouchEvent(r100);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public void setContentHeight(int r100) {
        this.mContentHeight = r100;
    }

    public void setCustomView(View r100) {
        View r101 = this.mCustomView;
        if (r101 == null) goto L5;
        removeView(r101);
    L5:
        this.mCustomView = r100;
        if (r100 == null) goto L10;
        LinearLayout r102 = this.mTitleLayout;
        if (r102 == null) goto L10;
        removeView(r102);
        this.mTitleLayout = null;
    L10:
        if (r100 == null) goto L12;
        addView(r100);
    L12:
        requestLayout();
    }

    public void setSubtitle(CharSequence r100) {
        this.mSubtitle = r100;
        initTitle();
    }

    public void setTitle(CharSequence r100) {
        this.mTitle = r100;
        initTitle();
    }

    public void setTitleOptional(boolean r100) {
        if (r100 == this.mTitleOptional) goto L5;
        requestLayout();
    L5:
        this.mTitleOptional = r100;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int r100) {
        super.setVisibility(r100);
    }

    public ActionBarContextView(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.actionModeStyle);
    }

    @Override // android.view.View
    public void onMeasure(int r110, int r111) {
        int r100 = 1073741824;
        if (View.MeasureSpec.getMode(r110) != 1073741824) goto L65;
        if (View.MeasureSpec.getMode(r111) == 0) goto L63;
        int r112 = View.MeasureSpec.getSize(r110);
        int r101 = this.mContentHeight;
        if (r101 > 0) goto L10;
        r101 = View.MeasureSpec.getSize(r111);
    L10:
        int r113 = getPaddingTop() + getPaddingBottom();
        int r102 = (r112 - getPaddingLeft()) - getPaddingRight();
        int r103 = r101 - r113;
        int r104 = View.MeasureSpec.makeMeasureSpec(r103, Integer.MIN_VALUE);
        View r105 = this.mClose;
        int r106 = 0;
        if (r105 == null) goto L13;
        int r107 = measureChildView(r105, r102, r104, 0);
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams();
        r102 = r107 - (r108.leftMargin + r108.rightMargin);
    L13:
        ActionMenuView r109 = this.mMenuView;
        if (r109 != null) goto L16;
    L18:
        LinearLayout r114 = this.mTitleLayout;
        if (r114 != null) goto L21;
    L36:
        View r115 = this.mCustomView;
        if (r115 == null) goto L52;
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
        int r117 = r116.width;
        if (r117 == (-2)) goto L41;
        int r118 = 1073741824;
    L42:
        if (r117 < 0) goto L44;
        r102 = Math.min(r117, r102);
    L44:
        int r119 = r116.height;
        if (r119 != (-2)) goto L48;
        r100 = Integer.MIN_VALUE;
    L48:
        if (r119 < 0) goto L50;
        r103 = Math.min(r119, r103);
    L50:
        this.mCustomView.measure(View.MeasureSpec.makeMeasureSpec(r102, r118), View.MeasureSpec.makeMeasureSpec(r103, r100));
        goto L52
    L41:
        r118 = Integer.MIN_VALUE;
    L52:
        if (this.mContentHeight > 0) goto L60;
        int r120 = getChildCount();
        int r121 = 0;
    L54:
        if (r106 >= r120) goto L59;
        int r122 = getChildAt(r106).getMeasuredHeight() + r113;
        if (r122 <= r121) goto L58;
        r121 = r122;
    L58:
        r106 = r106 + 1;
        goto L54
    L59:
        setMeasuredDimension(r112, r121);
        return;
    L60:
        setMeasuredDimension(r112, r101);
        return;
    L21:
        if (this.mCustomView != null) goto L36;
        if (this.mTitleOptional == false) goto L35;
        int r123 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mTitleLayout.measure(r123, r104);
        int r124 = this.mTitleLayout.getMeasuredWidth();
        if (r124 > r102) goto L27;
        boolean r125 = true;
    L28:
        if (r125 == false) goto L30;
        r102 = r102 - r124;
    L30:
        LinearLayout r126 = this.mTitleLayout;
        if (r125 == false) goto L33;
        int r127 = 0;
    L34:
        r126.setVisibility(r127);
        goto L36
    L33:
        r127 = 8;
        goto L34
    L27:
        r125 = false;
        goto L28
    L35:
        r102 = measureChildView(r114, r102, r104, 0);
        goto L36
    L16:
        if (r109.getParent() != this) goto L18;
        r102 = measureChildView(this.mMenuView, r102, r104, 0);
        goto L18
    L63:
        throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
    L65:
        throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat setupAnimatorToVisibility(int r100, long r101) {
        return super.setupAnimatorToVisibility(r100, r101);
    }

    public ActionBarContextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        TintTypedArray r103 = TintTypedArray.obtainStyledAttributes(r100, r101, new int[]{R.attr.background, R.attr.backgroundSplit, R.attr.closeItemLayout, R.attr.height, R.attr.subtitleTextStyle, R.attr.titleTextStyle}, r102, 0);
        ViewCompat.setBackground(this, r103.getDrawable(0));
        this.mTitleStyleRes = r103.getResourceId(5, 0);
        this.mSubtitleStyleRes = r103.getResourceId(4, 0);
        this.mContentHeight = r103.getLayoutDimension(3, 0);
        this.mCloseItemLayout = r103.getResourceId(2, R.layout.abc_action_mode_close_item_material);
        r103.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r110, int r111, int r112, int r113, int r114) {
        boolean r115 = ViewUtils.isLayoutRtl(this);
        if (r115 == false) goto L5;
        int r100 = (r113 - r111) - getPaddingRight();
    L6:
        int r101 = getPaddingTop();
        int r116 = ((r114 - r112) - getPaddingTop()) - getPaddingBottom();
        View r117 = this.mClose;
        if (r117 != null) goto L9;
    L18:
        int r118 = r100;
        LinearLayout r102 = this.mTitleLayout;
        if (r102 != null) goto L21;
    L25:
        int r103 = r118;
        View r104 = this.mCustomView;
        if (r104 == null) goto L28;
        positionChild(r104, r103, r101, r116, r115);
    L28:
        if (r115 == false) goto L30;
        int r105 = getPaddingLeft();
    L31:
        ActionMenuView r106 = this.mMenuView;
        if (r106 == null) goto L35;
        positionChild(r106, r105, r101, r116, !r115);
        return;
    L35:
        return;
    L30:
        r105 = (r113 - r111) - getPaddingRight();
        goto L31
    L21:
        if (this.mCustomView != null) goto L25;
        if (r102.getVisibility() == 8) goto L25;
        r118 = r118 + positionChild(this.mTitleLayout, r118, r101, r116, r115);
        goto L25
    L9:
        if (r117.getVisibility() == 8) goto L18;
        ViewGroup.MarginLayoutParams r119 = (ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams();
        if (r115 == false) goto L13;
        int r107 = r119.rightMargin;
    L14:
        if (r115 == false) goto L16;
        int r120 = r119.leftMargin;
    L17:
        int r108 = AbsActionBarView.next(r100, r107, r115);
        r100 = AbsActionBarView.next(r108 + positionChild(this.mClose, r108, r101, r116, r115), r120, r115);
        goto L18
    L16:
        r120 = r119.rightMargin;
        goto L17
    L13:
        r107 = r119.leftMargin;
        goto L14
    L5:
        r100 = getPaddingLeft();
        goto L6
    }
}
