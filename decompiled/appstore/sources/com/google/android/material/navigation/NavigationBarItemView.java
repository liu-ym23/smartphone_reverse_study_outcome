package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.g0;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.k;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import o.a;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class NavigationBarItemView extends FrameLayout implements MenuView.ItemView {
    private static final int[] CHECKED_STATE_SET = null;
    private static final int INVALID_ITEM_POSITION = -1;

    @Nullable
    private BadgeDrawable badgeDrawable;
    private final int defaultMargin;
    private ImageView icon;

    @Nullable
    private ColorStateList iconTint;
    private boolean isShifting;

    @Nullable
    private g itemData;
    private int itemPosition;
    private final ViewGroup labelGroup;
    private int labelVisibilityMode;
    private final TextView largeLabel;

    @Nullable
    private Drawable originalIconDrawable;
    private float scaleDownFactor;
    private float scaleUpFactor;
    private float shiftAmount;
    private final TextView smallLabel;

    @Nullable
    private Drawable wrappedIconDrawable;

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
    }

    public NavigationBarItemView(@NonNull Context r10) {
        super(r10);
        this.itemPosition = -1;
        LayoutInflater.from(r10).inflate(getItemLayoutResId(), this, true);
        this.icon = (ImageView) findViewById(com.google.android.material.R.id.navigation_bar_item_icon_view);
        ViewGroup r11 = (ViewGroup) findViewById(com.google.android.material.R.id.navigation_bar_item_labels_group);
        this.labelGroup = r11;
        TextView r12 = (TextView) findViewById(com.google.android.material.R.id.navigation_bar_item_small_label_view);
        this.smallLabel = r12;
        TextView r13 = (TextView) findViewById(com.google.android.material.R.id.navigation_bar_item_large_label_view);
        this.largeLabel = r13;
        setBackgroundResource(getItemBackgroundResId());
        this.defaultMargin = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        r11.setTag(com.google.android.material.R.id.mtrl_view_tag_bottom_padding, Integer.valueOf(r11.getPaddingBottom()));
        ViewCompat.A0(r12, 2);
        ViewCompat.A0(r13, 2);
        setFocusable(true);
        calculateTextScaleFactors(r12.getTextSize(), r13.getTextSize());
        ImageView r14 = this.icon;
        if (r14 == null) goto L6;
        r14.addOnLayoutChangeListener(new AnonymousClass1(this));
        return;
    }

    public static /* synthetic */ ImageView access$000(NavigationBarItemView r10) {
        return r10.icon;
    }

    public static /* synthetic */ void access$100(NavigationBarItemView r10, View r11) {
        r10.tryUpdateBadgeBounds(r11);
    }

    private void calculateTextScaleFactors(float r10, float r11) {
        this.shiftAmount = r10 - r11;
        this.scaleUpFactor = (r11 * 1.0f) / r10;
        this.scaleDownFactor = (r10 * 1.0f) / r11;
    }

    @Nullable
    private FrameLayout getCustomParentForBadge(View r10) {
        ImageView r11 = this.icon;
        if (r10 == r11) goto L5;
        return null;
    L5:
        if (BadgeUtils.USE_COMPAT_PARENT == true) goto L7;
        return null;
    L7:
        return (FrameLayout) r11.getParent();
    }

    private int getItemVisiblePosition() {
        ViewGroup r10 = (ViewGroup) getParent();
        int r11 = r10.indexOfChild(this);
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L10;
        View r14 = r10.getChildAt(r12);
        if ((r14 instanceof NavigationBarItemView) == false) goto L9;
        if (r14.getVisibility() != 0) goto L9;
        r13 = r13 + 1;
    L9:
        r12 = r12 + 1;
        goto L3
    L10:
        return r13;
    }

    private int getSuggestedIconHeight() {
        BadgeDrawable r10 = this.badgeDrawable;
        if (r10 == null) goto L5;
        int r11 = r10.getMinimumHeight() / 2;
    L7:
        return (Math.max(r11, ((FrameLayout.LayoutParams) this.icon.getLayoutParams()).topMargin) + this.icon.getMeasuredWidth()) + r11;
    L5:
        r11 = 0;
        goto L7
    }

    private int getSuggestedIconWidth() {
        BadgeDrawable r10 = this.badgeDrawable;
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        FrameLayout.LayoutParams r12 = (FrameLayout.LayoutParams) this.icon.getLayoutParams();
        return (Math.max(r11, r12.leftMargin) + this.icon.getMeasuredWidth()) + Math.max(r11, r12.rightMargin);
    L5:
        r11 = r10.getMinimumWidth() - this.badgeDrawable.getHorizontalOffset();
        goto L6
    }

    private boolean hasBadge() {
        if (this.badgeDrawable == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static void setViewLayoutParams(@NonNull View r10, int r11, int r12) {
        FrameLayout.LayoutParams r13 = (FrameLayout.LayoutParams) r10.getLayoutParams();
        r13.topMargin = r11;
        r13.gravity = r12;
        r10.setLayoutParams(r13);
    }

    private static void setViewScaleValues(@NonNull View r10, float r11, float r12, int r13) {
        r10.setScaleX(r11);
        r10.setScaleY(r12);
        r10.setVisibility(r13);
    }

    private void tryAttachBadgeToAnchor(@Nullable View r10) {
        if (hasBadge() == true) goto L5;
        return;
    L5:
        if (r10 == null) goto L8;
        setClipChildren(false);
        setClipToPadding(false);
        BadgeUtils.attachBadgeDrawable(this.badgeDrawable, r10, getCustomParentForBadge(r10));
        return;
    }

    private void tryRemoveBadgeFromAnchor(@Nullable View r10) {
        if (hasBadge() == true) goto L5;
        return;
    L5:
        if (r10 == null) goto L7;
        setClipChildren(true);
        setClipToPadding(true);
        BadgeUtils.detachBadgeDrawable(this.badgeDrawable, r10);
    L7:
        this.badgeDrawable = null;
    }

    private void tryUpdateBadgeBounds(View r10) {
        if (hasBadge() == true) goto L5;
        return;
    L5:
        BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, r10, getCustomParentForBadge(r10));
    }

    private static void updateViewPaddingBottom(@NonNull View r10, int r11) {
        r10.setPadding(r10.getPaddingLeft(), r10.getPaddingTop(), r10.getPaddingRight(), r11);
    }

    @Nullable
    public BadgeDrawable getBadge() {
        return this.badgeDrawable;
    }

    @DrawableRes
    public int getItemBackgroundResId() {
        return com.google.android.material.R.drawable.mtrl_navigation_bar_item_background;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    @Nullable
    public g getItemData() {
        return this.itemData;
    }

    @DimenRes
    public int getItemDefaultMarginResId() {
        return com.google.android.material.R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    @LayoutRes
    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.itemPosition;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) this.labelGroup.getLayoutParams();
        return ((getSuggestedIconHeight() + r10.topMargin) + this.labelGroup.getMeasuredHeight()) + r10.bottomMargin;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) this.labelGroup.getLayoutParams();
        int r11 = (r10.leftMargin + this.labelGroup.getMeasuredWidth()) + r10.rightMargin;
        return Math.max(getSuggestedIconWidth(), r11);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull g r10, int r11) {
        this.itemData = r10;
        setCheckable(r10.isCheckable());
        setChecked(r10.isChecked());
        setEnabled(r10.isEnabled());
        setIcon(r10.getIcon());
        setTitle(r10.getTitle());
        setId(r10.getItemId());
        if (TextUtils.isEmpty(r10.getContentDescription()) == true) goto L6;
        setContentDescription(r10.getContentDescription());
    L6:
        if (TextUtils.isEmpty(r10.getTooltipText()) == true) goto L8;
        CharSequence r12 = r10.getTooltipText();
    L9:
        g0.a(this, r12);
        if (r10.isVisible() == false) goto L12;
        int r13 = 0;
    L13:
        setVisibility(r13);
        return;
    L12:
        r13 = 8;
        goto L13
    L8:
        r12 = r10.getTitle();
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    @NonNull
    public int[] onCreateDrawableState(int r10) {
        int[] r11 = super.onCreateDrawableState(r10 + 1);
        g r12 = this.itemData;
        if (r12 != null) goto L5;
    L9:
        return r11;
    L5:
        if (r12.isCheckable() == false) goto L9;
        if (this.itemData.isChecked() == false) goto L9;
        FrameLayout.mergeDrawableStates(r11, CHECKED_STATE_SET);
        goto L9
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        BadgeDrawable r11 = this.badgeDrawable;
        if (r11 != null) goto L5;
    L10:
        AccessibilityNodeInfoCompat r12 = AccessibilityNodeInfoCompat.B0(r10);
        r12.Y(AccessibilityNodeInfoCompat.c.a(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected() == false) goto L13;
        r12.W(false);
        r12.O(AccessibilityNodeInfoCompat.a.f2742i);
    L13:
        r12.p0(getResources().getString(com.google.android.material.R.string.item_view_role_description));
        return;
    L5:
        if (r11.isVisible() == false) goto L10;
        CharSequence r13 = this.itemData.getTitle();
        if (TextUtils.isEmpty(this.itemData.getContentDescription()) == true) goto L9;
        r13 = this.itemData.getContentDescription();
    L9:
        r10.setContentDescription(r13 + ", " + this.badgeDrawable.getContentDescription());
        goto L10
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void removeBadge() {
        tryRemoveBadgeFromAnchor(this.icon);
    }

    public void setBadge(@NonNull BadgeDrawable r10) {
        this.badgeDrawable = r10;
        ImageView r11 = this.icon;
        if (r11 == null) goto L6;
        tryAttachBadgeToAnchor(r11);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean r10) {
        refreshDrawableState();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean r10) {
        TextView r11 = this.largeLabel;
        r11.setPivotX(r11.getWidth() / 2);
        TextView r12 = this.largeLabel;
        r12.setPivotY(r12.getBaseline());
        TextView r13 = this.smallLabel;
        r13.setPivotX(r13.getWidth() / 2);
        TextView r14 = this.smallLabel;
        r14.setPivotY(r14.getBaseline());
        int r15 = this.labelVisibilityMode;
        if (r15 == (-1)) goto L19;
        if (r15 != 0) goto L6;
        if (r10 == false) goto L16;
        setViewLayoutParams(this.icon, this.defaultMargin, 49);
        ViewGroup r16 = this.labelGroup;
        updateViewPaddingBottom(r16, ((Integer) r16.getTag(com.google.android.material.R.id.mtrl_view_tag_bottom_padding)).intValue());
        this.largeLabel.setVisibility(0);
    L17:
        this.smallLabel.setVisibility(4);
    L28:
        refreshDrawableState();
        setSelected(r10);
        return;
    L16:
        setViewLayoutParams(this.icon, this.defaultMargin, 17);
        updateViewPaddingBottom(this.labelGroup, 0);
        this.largeLabel.setVisibility(4);
        goto L17
    L6:
        if (r15 == 1) goto L10;
        if (r15 != 2) goto L28;
        setViewLayoutParams(this.icon, this.defaultMargin, 17);
        this.largeLabel.setVisibility(8);
        this.smallLabel.setVisibility(8);
        goto L28
    L10:
        ViewGroup r17 = this.labelGroup;
        updateViewPaddingBottom(r17, ((Integer) r17.getTag(com.google.android.material.R.id.mtrl_view_tag_bottom_padding)).intValue());
        if (r10 == false) goto L13;
        setViewLayoutParams(this.icon, (int) (this.defaultMargin + this.shiftAmount), 49);
        setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
        TextView r18 = this.smallLabel;
        float r19 = this.scaleUpFactor;
        setViewScaleValues(r18, r19, r19, 4);
        goto L28
    L13:
        setViewLayoutParams(this.icon, this.defaultMargin, 49);
        TextView r20 = this.largeLabel;
        float r21 = this.scaleDownFactor;
        setViewScaleValues(r20, r21, r21, 4);
        setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
        goto L28
    L19:
        if (this.isShifting == false) goto L24;
        if (r10 == false) goto L22;
        setViewLayoutParams(this.icon, this.defaultMargin, 49);
        ViewGroup r22 = this.labelGroup;
        updateViewPaddingBottom(r22, ((Integer) r22.getTag(com.google.android.material.R.id.mtrl_view_tag_bottom_padding)).intValue());
        this.largeLabel.setVisibility(0);
    L23:
        this.smallLabel.setVisibility(4);
        goto L28
    L22:
        setViewLayoutParams(this.icon, this.defaultMargin, 17);
        updateViewPaddingBottom(this.labelGroup, 0);
        this.largeLabel.setVisibility(4);
        goto L23
    L24:
        ViewGroup r23 = this.labelGroup;
        updateViewPaddingBottom(r23, ((Integer) r23.getTag(com.google.android.material.R.id.mtrl_view_tag_bottom_padding)).intValue());
        if (r10 == false) goto L27;
        setViewLayoutParams(this.icon, (int) (this.defaultMargin + this.shiftAmount), 49);
        setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
        TextView r24 = this.smallLabel;
        float r25 = this.scaleUpFactor;
        setViewScaleValues(r24, r25, r25, 4);
        goto L28
    L27:
        setViewLayoutParams(this.icon, this.defaultMargin, 49);
        TextView r26 = this.largeLabel;
        float r27 = this.scaleDownFactor;
        setViewScaleValues(r26, r27, r27, 4);
        setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
        goto L28
    }

    @Override // android.view.View, androidx.appcompat.view.menu.MenuView.ItemView
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        this.smallLabel.setEnabled(r10);
        this.largeLabel.setEnabled(r10);
        this.icon.setEnabled(r10);
        if (r10 == false) goto L5;
        ViewCompat.E0(this, k.b(getContext(), 1002));
        return;
    L5:
        ViewCompat.E0(this, null);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable r10) {
        if (r10 != this.originalIconDrawable) goto L5;
        return;
    L5:
        this.originalIconDrawable = r10;
        if (r10 == null) goto L14;
        Drawable.ConstantState r11 = r10.getConstantState();
        if (r11 == null) goto L11;
        r10 = r11.newDrawable();
    L11:
        r10 = a.l(r10).mutate();
        this.wrappedIconDrawable = r10;
        ColorStateList r12 = this.iconTint;
        if (r12 == null) goto L14;
        a.i(r10, r12);
    L14:
        this.icon.setImageDrawable(r10);
    }

    public void setIconSize(int r10) {
        FrameLayout.LayoutParams r11 = (FrameLayout.LayoutParams) this.icon.getLayoutParams();
        r11.width = r10;
        r11.height = r10;
        this.icon.setLayoutParams(r11);
    }

    public void setIconTintList(@Nullable ColorStateList r10) {
        this.iconTint = r10;
        if (this.itemData == null) goto L8;
        Drawable r11 = this.wrappedIconDrawable;
        if (r11 == null) goto L9;
        a.i(r11, r10);
        this.wrappedIconDrawable.invalidateSelf();
        return;
    L9:
        return;
    }

    public void setItemBackground(int r10) {
        if (r10 != 0) goto L4;
        Drawable r11 = null;
    L5:
        setItemBackground(r11);
        return;
    L4:
        r11 = ContextCompat.d(getContext(), r10);
        goto L5
    }

    public void setItemPosition(int r10) {
        this.itemPosition = r10;
    }

    public void setLabelVisibilityMode(int r10) {
        if (this.labelVisibilityMode == r10) goto L8;
        this.labelVisibilityMode = r10;
        g r11 = this.itemData;
        if (r11 == null) goto L9;
        setChecked(r11.isChecked());
        return;
    L9:
        return;
    }

    public void setShifting(boolean r10) {
        if (this.isShifting == r10) goto L8;
        this.isShifting = r10;
        g r11 = this.itemData;
        if (r11 == null) goto L9;
        setChecked(r11.isChecked());
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean r10, char r11) {
    }

    public void setTextAppearanceActive(@StyleRes int r10) {
        TextViewCompat.n(this.largeLabel, r10);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextAppearanceInactive(@StyleRes int r10) {
        TextViewCompat.n(this.smallLabel, r10);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextColor(@Nullable ColorStateList r10) {
        if (r10 == null) goto L5;
        this.smallLabel.setTextColor(r10);
        this.largeLabel.setTextColor(r10);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(@Nullable CharSequence r10) {
        this.smallLabel.setText(r10);
        this.largeLabel.setText(r10);
        g r11 = this.itemData;
        if (r11 != null) goto L5;
    L6:
        setContentDescription(r10);
    L7:
        g r12 = this.itemData;
        if (r12 != null) goto L10;
    L13:
        g0.a(this, r10);
        return;
    L10:
        if (TextUtils.isEmpty(r12.getTooltipText()) == true) goto L13;
        r10 = this.itemData.getTooltipText();
        goto L13
    L5:
        if (TextUtils.isEmpty(r11.getContentDescription()) == false) goto L7;
        goto L6
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public void setItemBackground(@Nullable Drawable r10) {
        if (r10 != null) goto L4;
    L6:
        ViewCompat.t0(this, r10);
        return;
    L4:
        if (r10.getConstantState() == null) goto L6;
        r10 = r10.getConstantState().newDrawable().mutate();
        goto L6
    }
}
