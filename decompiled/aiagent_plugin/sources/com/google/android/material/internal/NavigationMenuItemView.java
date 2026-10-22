package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.aa;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements androidx.appcompat.view.menu.e.a {
    private static final int[] CHECKED_STATE_SET = null;
    private final AccessibilityDelegateCompat accessibilityDelegate;
    private FrameLayout actionArea;
    boolean checkable;
    private Drawable emptyDrawable;
    private boolean hasIconTintList;
    private int iconSize;
    private ColorStateList iconTintList;
    private MenuItemImpl itemData;
    private boolean needsEmptyIcon;
    private final CheckedTextView textView;

    @Override // androidx.appcompat.view.menu.e.a
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setShortcut(boolean r1, char r2) {
    }

    public boolean showsIcon() {
        return true;
    }

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
    }

    public NavigationMenuItemView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public NavigationMenuItemView(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), 0);
    }

    public NavigationMenuItemView(Context r5, AttributeSet r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        super(r8, (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin"), r7);
        AccessibilityDelegateCompat r9 = new AnonymousClass1(this);
        this.accessibilityDelegate = r9;
        setOrientation(0);
        ZeusTransformUtils.inflate(LayoutInflater.from(r8), ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.layout.design_navigation_menu_item, "layout", "design_navigation_menu_item"), this, true, "com.obric.aiagent.plugin");
        setIconSize(ZeusTransformUtils.getResources(r8, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.dimen.design_navigation_icon_size, "dimen", "design_navigation_icon_size")));
        CheckedTextView r10 = (CheckedTextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.design_menu_item_text, DbHelper.COL_ID, "design_menu_item_text")), CheckedTextView.class, "com.obric.aiagent.plugin");
        this.textView = r10;
        r10.setDuplicateParentStateEnabled(true);
        ViewCompat.a(r10, r9);
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void initialize(MenuItemImpl r1, int r2) {
        this.itemData = r1;
        if (r1.getItemId() <= 0) goto L6;
        setId(r1.getItemId());
    L6:
        if (r1.isVisible() == false) goto L8;
        int r3 = 0;
    L9:
        setVisibility(r3);
        if (getBackground() != null) goto L12;
        ViewCompat.a(this, createDefaultBackground());
    L12:
        setCheckable(r1.isCheckable());
        setChecked(r1.isChecked());
        setEnabled(r1.isEnabled());
        setTitle(r1.getTitle());
        setIcon(r1.getIcon());
        setActionView(r1.getActionView());
        setContentDescription(r1.getContentDescription());
        aa.a(this, r1.getTooltipText());
        adjustAppearance();
        return;
    L8:
        r3 = 8;
        goto L9
    }

    private boolean shouldExpandActionArea() {
        if (this.itemData.getTitle() == null) goto L5;
    L9:
        return false;
    L5:
        if (this.itemData.getIcon() != null) goto L9;
        if (this.itemData.getActionView() == null) goto L9;
        return true;
    }

    private void adjustAppearance() {
        if (shouldExpandActionArea() == false) goto L7;
        this.textView.setVisibility(8);
        FrameLayout r0 = this.actionArea;
        if (r0 == null) goto L11;
        LinearLayoutCompat.LayoutParams r1 = (LinearLayoutCompat.LayoutParams) ZeusTransformUtils.preCheckCast(r0.getLayoutParams(), LinearLayoutCompat.LayoutParams.class, "com.obric.aiagent.plugin");
        r1.width = -1;
        this.actionArea.setLayoutParams(r1);
        return;
    L11:
        return;
    L7:
        this.textView.setVisibility(0);
        FrameLayout r2 = this.actionArea;
        if (r2 == null) goto L13;
        LinearLayoutCompat.LayoutParams r3 = (LinearLayoutCompat.LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LinearLayoutCompat.LayoutParams.class, "com.obric.aiagent.plugin");
        r3.width = -2;
        this.actionArea.setLayoutParams(r3);
        return;
    }

    public void recycle() {
        FrameLayout r0 = this.actionArea;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        this.textView.setCompoundDrawables(null, null, null, null);
    }

    private void setActionView(View r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (this.actionArea != null) goto L6;
        this.actionArea = (FrameLayout) ZeusTransformUtils.preCheckCast(((ViewStub) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.design_menu_item_action_area_stub, DbHelper.COL_ID, "design_menu_item_action_area_stub")), ViewStub.class, "com.obric.aiagent.plugin")).inflate(), FrameLayout.class, "com.obric.aiagent.plugin");
    L6:
        this.actionArea.removeAllViews();
        this.actionArea.addView(r4);
    }

    private StateListDrawable createDefaultBackground() {
        TypedValue r0 = new TypedValue();
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getTheme().resolveAttribute(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.attr.colorControlHighlight, "attr", "colorControlHighlight"), r0, true) == false) goto L6;
        StateListDrawable r4 = new StateListDrawable();
        r4.addState(CHECKED_STATE_SET, new ColorDrawable(r0.data));
        r4.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return r4;
    L6:
        return null;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    public void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.textView.setText(r4);
    }

    public void setCheckable(boolean r2) {
        refreshDrawableState();
        if (this.checkable == r2) goto L6;
        this.checkable = r2;
        this.accessibilityDelegate.a(this.textView, 2048);
        return;
    }

    public void setChecked(boolean r1) {
        refreshDrawableState();
        this.textView.setChecked(r1);
    }

    public void setIcon(Drawable r6) {
        if (r6 == null) goto L13;
        if (this.hasIconTintList == false) goto L11;
        Drawable.ConstantState r1 = r6.getConstantState();
        if (r1 == null) goto L10;
        r6 = r1.newDrawable();
    L10:
        r6 = androidx.core.graphics.drawable.a.g(r6).mutate();
        androidx.core.graphics.drawable.a.a(r6, this.iconTintList);
    L11:
        int r2 = this.iconSize;
        r6.setBounds(0, 0, r2, r2);
    L20:
        TextViewCompat.a(this.textView, r6, null, null, null);
        return;
    L13:
        if (this.needsEmptyIcon == false) goto L20;
        if (this.emptyDrawable != null) goto L19;
        Drawable r7 = androidx.core.content.b.h.a(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.drawable.navigation_empty_icon, "drawable", "navigation_empty_icon"), ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getTheme());
        this.emptyDrawable = r7;
        if (r7 == null) goto L19;
        int r3 = this.iconSize;
        r7.setBounds(0, 0, r3, r3);
    L19:
        r6 = this.emptyDrawable;
        goto L20
    }

    public void setIconSize(int r1) {
        this.iconSize = r1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int r2) {
        int[] r3 = super.onCreateDrawableState(r2 + 1);
        MenuItemImpl r0 = this.itemData;
        if (r0 != null) goto L5;
    L9:
        return r3;
    L5:
        if (r0.isCheckable() == false) goto L9;
        if (this.itemData.isChecked() == false) goto L9;
        mergeDrawableStates(r3, CHECKED_STATE_SET);
        goto L9
    }

    void setIconTintList(ColorStateList r1) {
        this.iconTintList = r1;
        if (r1 == null) goto L5;
        boolean r2 = true;
    L6:
        this.hasIconTintList = r2;
        MenuItemImpl r3 = this.itemData;
        if (r3 == null) goto L10;
        setIcon(r3.getIcon());
        return;
    L10:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public void setTextAppearance(int r1) {
        TextViewCompat.a(this.textView, r1);
    }

    public void setTextColor(ColorStateList r1) {
        this.textView.setTextColor(r1);
    }

    public void setNeedsEmptyIcon(boolean r1) {
        this.needsEmptyIcon = r1;
    }

    public void setHorizontalPadding(int r3) {
        setPadding(r3, getPaddingTop(), r3, getPaddingBottom());
    }

    public void setIconPadding(int r1) {
        this.textView.setCompoundDrawablePadding(r1);
    }

    public void setMaxLines(int r1) {
        this.textView.setMaxLines(r1);
    }
}
