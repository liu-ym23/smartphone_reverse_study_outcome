package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.y;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.g.c;
import com.google.android.material.internal.l;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.i;
import com.google.android.material.shape.m;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NavigationBarView extends FrameLayout {
    public static final int LABEL_VISIBILITY_AUTO = -1;
    public static final int LABEL_VISIBILITY_LABELED = 1;
    public static final int LABEL_VISIBILITY_SELECTED = 0;
    public static final int LABEL_VISIBILITY_UNLABELED = 2;
    private static final int MENU_PRESENTER_ID = 1;
    private ColorStateList itemRippleColor;
    private final NavigationBarMenu menu;
    private MenuInflater menuInflater;
    private final NavigationBarMenuView menuView;
    private final NavigationBarPresenter presenter;
    private a reselectedListener;
    private b selectedListener;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Bundle menuPresenterState;

        public SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin"));
        }

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            if (r2 != null) goto L5;
            r2 = getClass().getClassLoader();
        L5:
            readFromParcel(r1, r2);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeBundle(this.menuPresenterState);
        }

        private void readFromParcel(Parcel r1, ClassLoader r2) {
            this.menuPresenterState = r1.readBundle(r2);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    public interface a {
        void a(MenuItem r1);
    }

    public interface b {
        boolean a(MenuItem r1);
    }

    public abstract NavigationBarMenuView createNavigationBarMenuView(Context r1);

    public abstract int getMaxItemCount();

    static /* synthetic */ a access$000(NavigationBarView r0) {
        return r0.reselectedListener;
    }

    static /* synthetic */ b access$100(NavigationBarView r0) {
        return r0.selectedListener;
    }

    public NavigationBarView(Context r16, AttributeSet r17, int r18, int r19) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r16, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r2 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r17, AttributeSet.class, "com.obric.aiagent.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r1, r2, r18, r19), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r2, r18);
        NavigationBarPresenter r8 = new NavigationBarPresenter();
        this.presenter = r8;
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        y r3 = l.b(r9, r2, R.styleable.NavigationBarView, r18, r19, new int[]{ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemTextAppearanceInactive, "styleable", "NavigationBarView_itemTextAppearanceInactive"), ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemTextAppearanceActive, "styleable", "NavigationBarView_itemTextAppearanceActive")});
        NavigationBarMenu r4 = new NavigationBarMenu(r9, getClass(), getMaxItemCount());
        this.menu = r4;
        NavigationBarMenuView r5 = createNavigationBarMenuView(r9);
        this.menuView = r5;
        r8.a(r5);
        r8.a(1);
        r5.setPresenter(r8);
        r4.addMenuPresenter(r8);
        r8.initForMenu((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4);
        if (r3.g(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemIconTint, "styleable", "NavigationBarView_itemIconTint")) == false) goto L5;
        r5.setIconTintList(r3.e(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemIconTint, "styleable", "NavigationBarView_itemIconTint")));
    L6:
        setItemIconSize(r3.e(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemIconSize, "styleable", "NavigationBarView_itemIconSize"), ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.mtrl_navigation_bar_item_default_icon_size, "dimen", "mtrl_navigation_bar_item_default_icon_size"))));
        if (r3.g(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemTextAppearanceInactive, "styleable", "NavigationBarView_itemTextAppearanceInactive")) == false) goto L10;
        setItemTextAppearanceInactive(r3.g(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemTextAppearanceInactive, "styleable", "NavigationBarView_itemTextAppearanceInactive"), 0));
    L10:
        if (r3.g(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemTextAppearanceActive, "styleable", "NavigationBarView_itemTextAppearanceActive")) == false) goto L13;
        setItemTextAppearanceActive(r3.g(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemTextAppearanceActive, "styleable", "NavigationBarView_itemTextAppearanceActive"), 0));
    L13:
        if (r3.g(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemTextColor, "styleable", "NavigationBarView_itemTextColor")) == false) goto L16;
        setItemTextColor(r3.e(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemTextColor, "styleable", "NavigationBarView_itemTextColor")));
    L16:
        if (getBackground() != null) goto L18;
    L19:
        ViewCompat.a(this, createMaterialShapeDrawableBackground(r9));
    L21:
        if (r3.g(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemPaddingTop, "styleable", "NavigationBarView_itemPaddingTop")) == false) goto L24;
        setItemPaddingTop(r3.e(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemPaddingTop, "styleable", "NavigationBarView_itemPaddingTop"), 0));
    L24:
        if (r3.g(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemPaddingBottom, "styleable", "NavigationBarView_itemPaddingBottom")) == false) goto L27;
        setItemPaddingBottom(r3.e(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemPaddingBottom, "styleable", "NavigationBarView_itemPaddingBottom"), 0));
    L27:
        if (r3.g(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_elevation, "styleable", "NavigationBarView_elevation")) == false) goto L29;
        setElevation(r3.e(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_elevation, "styleable", "NavigationBarView_elevation"), 0));
    L29:
        androidx.core.graphics.drawable.a.a(getBackground().mutate(), c.a(r9, r3, ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_backgroundTint, "styleable", "NavigationBarView_backgroundTint")));
        setLabelVisibilityMode(r3.c(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_labelVisibilityMode, "styleable", "NavigationBarView_labelVisibilityMode"), -1));
        int r6 = r3.g(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemBackground, "styleable", "NavigationBarView_itemBackground"), 0);
        if (r6 == 0) goto L32;
        r5.setItemBackgroundRes(r6);
    L33:
        int r7 = r3.g(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemActiveIndicatorStyle, "styleable", "NavigationBarView_itemActiveIndicatorStyle"), 0);
        if (r7 == 0) goto L37;
        setItemActiveIndicatorEnabled(true);
        TypedArray r10 = r9.obtainStyledAttributes(r7, R.styleable.NavigationBarActiveIndicator);
        setItemActiveIndicatorWidth(r10.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.NavigationBarActiveIndicator_android_width, "styleable", "NavigationBarActiveIndicator_android_width"), 0));
        setItemActiveIndicatorHeight(r10.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.NavigationBarActiveIndicator_android_height, "styleable", "NavigationBarActiveIndicator_android_height"), 0));
        setItemActiveIndicatorMarginHorizontal(r10.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.NavigationBarActiveIndicator_marginHorizontal, "styleable", "NavigationBarActiveIndicator_marginHorizontal"), 0));
        setItemActiveIndicatorColor(c.a(r9, r10, ZeusTransformUtils.mapRes(R.styleable.NavigationBarActiveIndicator_android_color, "styleable", "NavigationBarActiveIndicator_android_color")));
        setItemActiveIndicatorShapeAppearance(m.a(r9, r10.getResourceId(ZeusTransformUtils.mapRes(R.styleable.NavigationBarActiveIndicator_shapeAppearance, "styleable", "NavigationBarActiveIndicator_shapeAppearance"), 0), 0).a());
        r10.recycle();
    L37:
        if (r3.g(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_menu, "styleable", "NavigationBarView_menu")) == false) goto L39;
        inflateMenu(r3.g(ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_menu, "styleable", "NavigationBarView_menu"), 0));
    L39:
        r3.b();
        addView(r5);
        r4.setCallback(new AnonymousClass1(this));
        return;
    L32:
        setItemRippleColor(c.a(r9, r3, ZeusTransformUtils.mapRes(R.styleable.NavigationBarView_itemRippleColor, "styleable", "NavigationBarView_itemRippleColor")));
        goto L33
    L18:
        if (ZeusTransformUtils.instanceOf(getBackground(), ColorDrawable.class) == false) goto L21;
    L5:
        r5.setIconTintList(r5.createDefaultColorStateList(android.R.attr.textColorSecondary));
        goto L6
    }

    private MaterialShapeDrawable createMaterialShapeDrawableBackground(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        MaterialShapeDrawable r0 = new MaterialShapeDrawable();
        Drawable r3 = getBackground();
        if (ZeusTransformUtils.instanceOf(r3, ColorDrawable.class) == false) goto L5;
        r0.setFillColor(ColorStateList.valueOf(((ColorDrawable) ZeusTransformUtils.preCheckCast(r3, ColorDrawable.class, "com.obric.aiagent.plugin")).getColor()));
    L5:
        r0.initializeElevationOverlay(r5);
        return r0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a(this);
    }

    @Override // android.view.View
    public void setElevation(float r3) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        super.setElevation(r3);
    L5:
        i.a(this, r3);
    }

    public void setOnItemSelectedListener(b r3) {
        this.selectedListener = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
    }

    public void setOnItemReselectedListener(a r3) {
        this.reselectedListener = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    public Menu getMenu() {
        return this.menu;
    }

    public e getMenuView() {
        return this.menuView;
    }

    public void inflateMenu(int r4) {
        this.presenter.a(true);
        getMenuInflater().inflate(r4, this.menu);
        this.presenter.a(false);
        this.presenter.updateMenuView(true);
    }

    public ColorStateList getItemIconTintList() {
        return this.menuView.getIconTintList();
    }

    public void setItemIconTintList(ColorStateList r1) {
        this.menuView.setIconTintList(r1);
    }

    public void setItemIconSize(int r1) {
        this.menuView.setItemIconSize(r1);
    }

    public void setItemIconSizeRes(int r2) {
        setItemIconSize(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(r2));
    }

    public int getItemIconSize() {
        return this.menuView.getItemIconSize();
    }

    public ColorStateList getItemTextColor() {
        return this.menuView.getItemTextColor();
    }

    public void setItemTextColor(ColorStateList r1) {
        this.menuView.setItemTextColor(r1);
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.menuView.getItemBackgroundRes();
    }

    public void setItemBackgroundResource(int r2) {
        this.menuView.setItemBackgroundRes(r2);
        this.itemRippleColor = null;
    }

    public Drawable getItemBackground() {
        return this.menuView.getItemBackground();
    }

    public void setItemBackground(Drawable r2) {
        this.menuView.setItemBackground(r2);
        this.itemRippleColor = null;
    }

    public ColorStateList getItemRippleColor() {
        return this.itemRippleColor;
    }

    public void setItemRippleColor(ColorStateList r4) {
        if (this.itemRippleColor != r4) goto L9;
        if (r4 == null) goto L6;
        return;
    L6:
        if (this.menuView.getItemBackground() == null) goto L18;
        this.menuView.setItemBackground(null);
        return;
    L18:
        return;
    L9:
        this.itemRippleColor = r4;
        if (r4 != null) goto L12;
        this.menuView.setItemBackground(null);
        return;
    L12:
        ColorStateList r5 = com.google.android.material.ripple.a.a(r4);
        if (Build.VERSION.SDK_INT < 21) goto L15;
        this.menuView.setItemBackground(new RippleDrawable(r5, null, null));
        return;
    L15:
        GradientDrawable r0 = new GradientDrawable();
        r0.setCornerRadius(1.0E-5f);
        Drawable r1 = androidx.core.graphics.drawable.a.g(r0);
        androidx.core.graphics.drawable.a.a(r1, r5);
        this.menuView.setItemBackground(r1);
    }

    public int getItemPaddingTop() {
        return this.menuView.getItemPaddingTop();
    }

    public void setItemPaddingTop(int r1) {
        this.menuView.setItemPaddingTop(r1);
    }

    public int getItemPaddingBottom() {
        return this.menuView.getItemPaddingBottom();
    }

    public void setItemPaddingBottom(int r1) {
        this.menuView.setItemPaddingBottom(r1);
    }

    public boolean isItemActiveIndicatorEnabled() {
        return this.menuView.getItemActiveIndicatorEnabled();
    }

    public void setItemActiveIndicatorEnabled(boolean r1) {
        this.menuView.setItemActiveIndicatorEnabled(r1);
    }

    public int getItemActiveIndicatorWidth() {
        return this.menuView.getItemActiveIndicatorWidth();
    }

    public void setItemActiveIndicatorWidth(int r1) {
        this.menuView.setItemActiveIndicatorWidth(r1);
    }

    public int getItemActiveIndicatorHeight() {
        return this.menuView.getItemActiveIndicatorHeight();
    }

    public void setItemActiveIndicatorHeight(int r1) {
        this.menuView.setItemActiveIndicatorHeight(r1);
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.menuView.getItemActiveIndicatorMarginHorizontal();
    }

    public void setItemActiveIndicatorMarginHorizontal(int r1) {
        this.menuView.setItemActiveIndicatorMarginHorizontal(r1);
    }

    public m getItemActiveIndicatorShapeAppearance() {
        return this.menuView.getItemActiveIndicatorShapeAppearance();
    }

    public void setItemActiveIndicatorShapeAppearance(m r1) {
        this.menuView.setItemActiveIndicatorShapeAppearance(r1);
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.menuView.getItemActiveIndicatorColor();
    }

    public void setItemActiveIndicatorColor(ColorStateList r1) {
        this.menuView.setItemActiveIndicatorColor(r1);
    }

    public int getSelectedItemId() {
        return this.menuView.getSelectedItemId();
    }

    public void setSelectedItemId(int r3) {
        MenuItem r4 = this.menu.findItem(r3);
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.menu.performItemAction(r4, this.presenter, 0) == true) goto L9;
        r4.setChecked(true);
        return;
    }

    public void setLabelVisibilityMode(int r2) {
        if (this.menuView.getLabelVisibilityMode() == r2) goto L6;
        this.menuView.setLabelVisibilityMode(r2);
        this.presenter.updateMenuView(false);
        return;
    }

    public int getLabelVisibilityMode() {
        return this.menuView.getLabelVisibilityMode();
    }

    public void setItemTextAppearanceInactive(int r1) {
        this.menuView.setItemTextAppearanceInactive(r1);
    }

    public int getItemTextAppearanceInactive() {
        return this.menuView.getItemTextAppearanceInactive();
    }

    public void setItemTextAppearanceActive(int r1) {
        this.menuView.setItemTextAppearanceActive(r1);
    }

    public int getItemTextAppearanceActive() {
        return this.menuView.getItemTextAppearanceActive();
    }

    public void setItemOnTouchListener(int r3, View.OnTouchListener r4) {
        View.OnTouchListener r5 = (View.OnTouchListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnTouchListener.class, "com.obric.aiagent.plugin");
        this.menuView.setItemOnTouchListener(r3, r5);
    }

    public BadgeDrawable getBadge(int r1) {
        return this.menuView.getBadge(r1);
    }

    public BadgeDrawable getOrCreateBadge(int r1) {
        return this.menuView.getOrCreateBadge(r1);
    }

    public void removeBadge(int r1) {
        this.menuView.removeBadge(r1);
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater != null) goto L6;
        this.menuInflater = new SupportMenuInflater((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L6:
        return this.menuInflater;
    }

    public NavigationBarPresenter getPresenter() {
        return this.presenter;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.menuPresenterState = new Bundle();
        this.menu.savePresenterStates(r1.menuPresenterState);
        return r1;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SavedState.class) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        SavedState r5 = (SavedState) ZeusTransformUtils.preCheckCast(r4, SavedState.class, "com.obric.aiagent.plugin");
        super.onRestoreInstanceState(r5.getSuperState());
        this.menu.restorePresenterStates(r5.menuPresenterState);
    }
}
