package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.b0;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import g.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import o.a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NavigationBarView extends FrameLayout {
    public static final int LABEL_VISIBILITY_AUTO = -1;
    public static final int LABEL_VISIBILITY_LABELED = 1;
    public static final int LABEL_VISIBILITY_SELECTED = 0;
    public static final int LABEL_VISIBILITY_UNLABELED = 2;
    private static final int MENU_PRESENTER_ID = 1;

    @Nullable
    private ColorStateList itemRippleColor;

    @NonNull
    private final NavigationBarMenu menu;
    private MenuInflater menuInflater;

    @NonNull
    private final NavigationBarMenuView menuView;

    @NonNull
    private final NavigationBarPresenter presenter;
    private OnItemReselectedListener reselectedListener;
    private OnItemSelectedListener selectedListener;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface LabelVisibility {
    }

    public interface OnItemReselectedListener {
        void onNavigationItemReselected(@NonNull MenuItem r10);
    }

    public interface OnItemSelectedListener {
        boolean onNavigationItemSelected(@NonNull MenuItem r10);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        @Nullable
        Bundle menuPresenterState;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }

        private void readFromParcel(@NonNull Parcel r10, ClassLoader r11) {
            this.menuPresenterState = r10.readBundle(r11);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeBundle(this.menuPresenterState);
        }

        public SavedState(@NonNull Parcel r10, ClassLoader r11) {
            super(r10, r11);
            if (r11 != null) goto L5;
            r11 = getClass().getClassLoader();
        L5:
            readFromParcel(r10, r11);
        }
    }

    public NavigationBarView(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r13), r11, r12);
        NavigationBarPresenter r14 = new NavigationBarPresenter();
        this.presenter = r14;
        Context r15 = getContext();
        int[] r16 = R.styleable.NavigationBarView;
        int r17 = R.styleable.NavigationBarView_itemTextAppearanceInactive;
        int r18 = R.styleable.NavigationBarView_itemTextAppearanceActive;
        b0 r19 = ThemeEnforcement.obtainTintedStyledAttributes(r15, r11, r16, r12, r13, new int[]{r17, r18});
        NavigationBarMenu r110 = new NavigationBarMenu(r15, getClass(), getMaxItemCount());
        this.menu = r110;
        NavigationBarMenuView r111 = createNavigationBarMenuView(r15);
        this.menuView = r111;
        r14.setMenuView(r111);
        r14.setId(1);
        r111.setPresenter(r14);
        r110.addMenuPresenter(r14);
        r14.initForMenu(getContext(), r110);
        int r112 = R.styleable.NavigationBarView_itemIconTint;
        if (r19.s(r112) == false) goto L5;
        r111.setIconTintList(r19.c(r112));
    L6:
        setItemIconSize(r19.f(R.styleable.NavigationBarView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (r19.s(r17) == false) goto L10;
        setItemTextAppearanceInactive(r19.n(r17, 0));
    L10:
        if (r19.s(r18) == false) goto L12;
        setItemTextAppearanceActive(r19.n(r18, 0));
    L12:
        int r113 = R.styleable.NavigationBarView_itemTextColor;
        if (r19.s(r113) == false) goto L16;
        setItemTextColor(r19.c(r113));
    L16:
        if (getBackground() != null) goto L18;
    L19:
        ViewCompat.t0(this, createMaterialShapeDrawableBackground(r15));
    L20:
        int r114 = R.styleable.NavigationBarView_elevation;
        if (r19.s(r114) == false) goto L23;
        setElevation(r19.f(r114, 0));
    L23:
        a.i(getBackground().mutate(), MaterialResources.getColorStateList(r15, r19, R.styleable.NavigationBarView_backgroundTint));
        setLabelVisibilityMode(r19.l(R.styleable.NavigationBarView_labelVisibilityMode, -1));
        int r115 = r19.n(R.styleable.NavigationBarView_itemBackground, 0);
        if (r115 == 0) goto L26;
        r111.setItemBackgroundRes(r115);
    L27:
        int r116 = R.styleable.NavigationBarView_menu;
        if (r19.s(r116) == false) goto L30;
        inflateMenu(r19.n(r116, 0));
    L30:
        r19.w();
        addView(r111);
        r110.setCallback(new AnonymousClass1(this));
        applyWindowInsets();
        return;
    L26:
        setItemRippleColor(MaterialResources.getColorStateList(r15, r19, R.styleable.NavigationBarView_itemRippleColor));
        goto L27
    L18:
        if ((getBackground() instanceof ColorDrawable) == false) goto L20;
    L5:
        r111.setIconTintList(r111.createDefaultColorStateList(android.R.attr.textColorSecondary));
        goto L6
    }

    public static /* synthetic */ OnItemReselectedListener access$000(NavigationBarView r10) {
        return r10.reselectedListener;
    }

    public static /* synthetic */ OnItemSelectedListener access$100(NavigationBarView r10) {
        return r10.selectedListener;
    }

    private void applyWindowInsets() {
        ViewUtils.doOnApplyWindowInsets(this, new AnonymousClass2(this));
    }

    @NonNull
    private MaterialShapeDrawable createMaterialShapeDrawableBackground(Context r10) {
        MaterialShapeDrawable r11 = new MaterialShapeDrawable();
        Drawable r12 = getBackground();
        if ((r12 instanceof ColorDrawable) == false) goto L5;
        r11.setFillColor(ColorStateList.valueOf(((ColorDrawable) r12).getColor()));
    L5:
        r11.initializeElevationOverlay(r10);
        return r11;
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater != null) goto L6;
        this.menuInflater = new c(getContext());
    L6:
        return this.menuInflater;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract NavigationBarMenuView createNavigationBarMenuView(@NonNull Context r10);

    @Nullable
    public BadgeDrawable getBadge(int r10) {
        return this.menuView.getBadge(r10);
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.menuView.getItemBackground();
    }

    @DrawableRes
    @Deprecated
    public int getItemBackgroundResource() {
        return this.menuView.getItemBackgroundRes();
    }

    @Dimension
    public int getItemIconSize() {
        return this.menuView.getItemIconSize();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.menuView.getIconTintList();
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.itemRippleColor;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.menuView.getItemTextAppearanceActive();
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.menuView.getItemTextAppearanceInactive();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.menuView.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.menuView.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    @NonNull
    public Menu getMenu() {
        return this.menu;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MenuView getMenuView() {
        return this.menuView;
    }

    @NonNull
    public BadgeDrawable getOrCreateBadge(int r10) {
        return this.menuView.getOrCreateBadge(r10);
    }

    @NonNull
    public NavigationBarPresenter getPresenter() {
        return this.presenter;
    }

    @IdRes
    public int getSelectedItemId() {
        return this.menuView.getSelectedItemId();
    }

    public void inflateMenu(int r10) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(r10, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        this.menu.restorePresenterStates(r11.menuPresenterState);
    }

    @Override // android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        Bundle r11 = new Bundle();
        r10.menuPresenterState = r11;
        this.menu.savePresenterStates(r11);
        return r10;
    }

    public void removeBadge(int r10) {
        this.menuView.removeBadge(r10);
    }

    @Override // android.view.View
    public void setElevation(float r10) {
        super.setElevation(r10);
        MaterialShapeUtils.setElevation(this, r10);
    }

    public void setItemBackground(@Nullable Drawable r10) {
        this.menuView.setItemBackground(r10);
        this.itemRippleColor = null;
    }

    public void setItemBackgroundResource(@DrawableRes int r10) {
        this.menuView.setItemBackgroundRes(r10);
        this.itemRippleColor = null;
    }

    public void setItemIconSize(@Dimension int r10) {
        this.menuView.setItemIconSize(r10);
    }

    public void setItemIconSizeRes(@DimenRes int r10) {
        setItemIconSize(getResources().getDimensionPixelSize(r10));
    }

    public void setItemIconTintList(@Nullable ColorStateList r10) {
        this.menuView.setIconTintList(r10);
    }

    public void setItemOnTouchListener(int r10, @Nullable View.OnTouchListener r11) {
        this.menuView.setItemOnTouchListener(r10, r11);
    }

    public void setItemRippleColor(@Nullable ColorStateList r10) {
        if (this.itemRippleColor != r10) goto L9;
        if (r10 == null) goto L6;
        return;
    L6:
        if (this.menuView.getItemBackground() == null) goto L15;
        this.menuView.setItemBackground(null);
        return;
    L15:
        return;
    L9:
        this.itemRippleColor = r10;
        if (r10 != null) goto L12;
        this.menuView.setItemBackground(null);
        return;
    L12:
        ColorStateList r11 = RippleUtils.convertToRippleDrawableColor(r10);
        this.menuView.setItemBackground(new RippleDrawable(r11, null, null));
    }

    public void setItemTextAppearanceActive(@StyleRes int r10) {
        this.menuView.setItemTextAppearanceActive(r10);
    }

    public void setItemTextAppearanceInactive(@StyleRes int r10) {
        this.menuView.setItemTextAppearanceInactive(r10);
    }

    public void setItemTextColor(@Nullable ColorStateList r10) {
        this.menuView.setItemTextColor(r10);
    }

    public void setLabelVisibilityMode(int r10) {
        if (this.menuView.getLabelVisibilityMode() == r10) goto L6;
        this.menuView.setLabelVisibilityMode(r10);
        this.presenter.updateMenuView(false);
        return;
    }

    public void setOnItemReselectedListener(@Nullable OnItemReselectedListener r10) {
        this.reselectedListener = r10;
    }

    public void setOnItemSelectedListener(@Nullable OnItemSelectedListener r10) {
        this.selectedListener = r10;
    }

    public void setSelectedItemId(@IdRes int r10) {
        MenuItem r11 = this.menu.findItem(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        if (this.menu.performItemAction(r11, this.presenter, 0) == true) goto L9;
        r11.setChecked(true);
        return;
    }
}
