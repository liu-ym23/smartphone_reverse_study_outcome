package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NavigationBarView extends FrameLayout {
    public static final int LABEL_VISIBILITY_AUTO = -1;
    public static final int LABEL_VISIBILITY_LABELED = 1;
    public static final int LABEL_VISIBILITY_SELECTED = 0;
    public static final int LABEL_VISIBILITY_UNLABELED = 2;
    private static final int MENU_PRESENTER_ID = 1;
    private final NavigationBarMenu menu;
    private MenuInflater menuInflater;
    private final NavigationBarMenuView menuView;
    private final NavigationBarPresenter presenter;
    private OnItemReselectedListener reselectedListener;
    private OnItemSelectedListener selectedListener;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LabelVisibility {
    }

    public interface OnItemReselectedListener {
        void onNavigationItemReselected(MenuItem r1);
    }

    public interface OnItemSelectedListener {
        boolean onNavigationItemSelected(MenuItem r1);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Bundle menuPresenterState;

        public SavedState(Parcelable r1) {
            super(r1);
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

    protected abstract NavigationBarMenuView createNavigationBarMenuView(Context r1);

    public abstract int getMaxItemCount();

    static /* synthetic */ OnItemReselectedListener access$000(NavigationBarView r0) {
        return r0.reselectedListener;
    }

    static /* synthetic */ OnItemSelectedListener access$100(NavigationBarView r0) {
        return r0.selectedListener;
    }

    public NavigationBarView(Context r10, AttributeSet r11, int r12, int r13) {
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r13), r11, r12);
        NavigationBarPresenter r14 = new NavigationBarPresenter();
        this.presenter = r14;
        Context r6 = getContext();
        TintTypedArray r15 = ThemeEnforcement.obtainTintedStyledAttributes(r6, r11, R.styleable.NavigationBarView, r12, r13, new int[]{R.styleable.NavigationBarView_itemTextAppearanceInactive, R.styleable.NavigationBarView_itemTextAppearanceActive});
        NavigationBarMenu r16 = new NavigationBarMenu(r6, getClass(), getMaxItemCount());
        this.menu = r16;
        NavigationBarMenuView r17 = createNavigationBarMenuView(r6);
        this.menuView = r17;
        r14.setMenuView(r17);
        r14.setId(1);
        r17.setPresenter(r14);
        r16.addMenuPresenter(r14);
        r14.initForMenu(getContext(), r16);
        if (r15.hasValue(R.styleable.NavigationBarView_itemIconTint) == false) goto L5;
        r17.setIconTintList(r15.getColorStateList(R.styleable.NavigationBarView_itemIconTint));
    L6:
        setItemIconSize(r15.getDimensionPixelSize(R.styleable.NavigationBarView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (r15.hasValue(R.styleable.NavigationBarView_itemTextAppearanceInactive) == false) goto L10;
        setItemTextAppearanceInactive(r15.getResourceId(R.styleable.NavigationBarView_itemTextAppearanceInactive, 0));
    L10:
        if (r15.hasValue(R.styleable.NavigationBarView_itemTextAppearanceActive) == false) goto L13;
        setItemTextAppearanceActive(r15.getResourceId(R.styleable.NavigationBarView_itemTextAppearanceActive, 0));
    L13:
        if (r15.hasValue(R.styleable.NavigationBarView_itemTextColor) == false) goto L16;
        setItemTextColor(r15.getColorStateList(R.styleable.NavigationBarView_itemTextColor));
    L16:
        if (getBackground() != null) goto L18;
    L19:
        ViewCompat.setBackground(this, createMaterialShapeDrawableBackground(r6));
    L21:
        if (r15.hasValue(R.styleable.NavigationBarView_itemPaddingTop) == false) goto L24;
        setItemPaddingTop(r15.getDimensionPixelSize(R.styleable.NavigationBarView_itemPaddingTop, 0));
    L24:
        if (r15.hasValue(R.styleable.NavigationBarView_itemPaddingBottom) == false) goto L27;
        setItemPaddingBottom(r15.getDimensionPixelSize(R.styleable.NavigationBarView_itemPaddingBottom, 0));
    L27:
        if (r15.hasValue(R.styleable.NavigationBarView_elevation) == false) goto L29;
        setElevation(r15.getDimensionPixelSize(R.styleable.NavigationBarView_elevation, 0));
    L29:
        DrawableCompat.setTintList(getBackground().mutate(), MaterialResources.getColorStateList(r6, r15, R.styleable.NavigationBarView_backgroundTint));
        setLabelVisibilityMode(r15.getInteger(R.styleable.NavigationBarView_labelVisibilityMode, -1));
        int r18 = r15.getResourceId(R.styleable.NavigationBarView_itemBackground, 0);
        if (r18 == 0) goto L32;
        r17.setItemBackgroundRes(r18);
    L33:
        int r19 = r15.getResourceId(R.styleable.NavigationBarView_itemActiveIndicatorStyle, 0);
        if (r19 == 0) goto L37;
        setItemActiveIndicatorEnabled(true);
        TypedArray r110 = r6.obtainStyledAttributes(r19, R.styleable.NavigationBarActiveIndicator);
        setItemActiveIndicatorWidth(r110.getDimensionPixelSize(R.styleable.NavigationBarActiveIndicator_android_width, 0));
        setItemActiveIndicatorHeight(r110.getDimensionPixelSize(R.styleable.NavigationBarActiveIndicator_android_height, 0));
        setItemActiveIndicatorMarginHorizontal(r110.getDimensionPixelOffset(R.styleable.NavigationBarActiveIndicator_marginHorizontal, 0));
        setItemActiveIndicatorColor(MaterialResources.getColorStateList(r6, r110, R.styleable.NavigationBarActiveIndicator_android_color));
        setItemActiveIndicatorShapeAppearance(ShapeAppearanceModel.builder(r6, r110.getResourceId(R.styleable.NavigationBarActiveIndicator_shapeAppearance, 0), 0).build());
        r110.recycle();
    L37:
        if (r15.hasValue(R.styleable.NavigationBarView_menu) == false) goto L39;
        inflateMenu(r15.getResourceId(R.styleable.NavigationBarView_menu, 0));
    L39:
        r15.recycle();
        addView(r17);
        r16.setCallback(new AnonymousClass1(this));
        return;
    L32:
        setItemRippleColor(MaterialResources.getColorStateList(r6, r15, R.styleable.NavigationBarView_itemRippleColor));
        goto L33
    L18:
        if ((getBackground() instanceof ColorDrawable) == false) goto L21;
    L5:
        r17.setIconTintList(r17.createDefaultColorStateList(android.R.attr.textColorSecondary));
        goto L6
    }

    private MaterialShapeDrawable createMaterialShapeDrawableBackground(Context r3) {
        MaterialShapeDrawable r0 = new MaterialShapeDrawable();
        Drawable r2 = getBackground();
        if ((r2 instanceof ColorDrawable) == false) goto L5;
        r0.setFillColor(ColorStateList.valueOf(((ColorDrawable) r2).getColor()));
    L5:
        r0.initializeElevationOverlay(r3);
        return r0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.View
    public void setElevation(float r1) {
        super.setElevation(r1);
        MaterialShapeUtils.setElevation(this, r1);
    }

    public void setOnItemSelectedListener(OnItemSelectedListener r1) {
        this.selectedListener = r1;
    }

    public void setOnItemReselectedListener(OnItemReselectedListener r1) {
        this.reselectedListener = r1;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public MenuView getMenuView() {
        return this.menuView;
    }

    public void inflateMenu(int r4) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(r4, this.menu);
        this.presenter.setUpdateSuspended(false);
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
        setItemIconSize(getResources().getDimensionPixelSize(r2));
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

    public void setItemBackgroundResource(int r1) {
        this.menuView.setItemBackgroundRes(r1);
    }

    public Drawable getItemBackground() {
        return this.menuView.getItemBackground();
    }

    public void setItemBackground(Drawable r1) {
        this.menuView.setItemBackground(r1);
    }

    public ColorStateList getItemRippleColor() {
        return this.menuView.getItemRippleColor();
    }

    public void setItemRippleColor(ColorStateList r1) {
        this.menuView.setItemRippleColor(r1);
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

    public ShapeAppearanceModel getItemActiveIndicatorShapeAppearance() {
        return this.menuView.getItemActiveIndicatorShapeAppearance();
    }

    public void setItemActiveIndicatorShapeAppearance(ShapeAppearanceModel r1) {
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

    public void setItemOnTouchListener(int r1, View.OnTouchListener r2) {
        this.menuView.setItemOnTouchListener(r1, r2);
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
        this.menuInflater = new SupportMenuInflater(getContext());
    L6:
        return this.menuInflater;
    }

    public NavigationBarPresenter getPresenter() {
        return this.presenter;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.menuPresenterState = new Bundle();
        this.menu.savePresenterStates(r1.menuPresenterState);
        return r1;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r2);
        return;
    L6:
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        this.menu.restorePresenterStates(r3.menuPresenterState);
    }
}
