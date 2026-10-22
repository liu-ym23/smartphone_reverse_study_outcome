package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.b0;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import c.a;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.common.primitives.Ints;
import g.c;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] CHECKED_STATE_SET = null;
    private static final int DEF_STYLE_RES = 0;
    private static final int[] DISABLED_STATE_SET = null;
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    OnNavigationItemSelectedListener listener;
    private final int maxWidth;

    @NonNull
    private final NavigationMenu menu;
    private MenuInflater menuInflater;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private final NavigationMenuPresenter presenter;
    private final int[] tmpLocation;

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(@NonNull MenuItem r10);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        @Nullable
        public Bundle menuState;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(@NonNull Parcel r10, @Nullable ClassLoader r11) {
            super(r10, r11);
            this.menuState = r10.readBundle(r11);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeBundle(this.menuState);
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }
    }

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        DISABLED_STATE_SET = new int[]{-16842910};
        DEF_STYLE_RES = com.google.android.material.R.style.Widget_Design_NavigationView;
    }

    public NavigationView(@NonNull Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ int[] access$000(NavigationView r10) {
        return r10.tmpLocation;
    }

    public static /* synthetic */ NavigationMenuPresenter access$100(NavigationView r10) {
        return r10.presenter;
    }

    @Nullable
    private ColorStateList createDefaultColorStateList(int r10) {
        TypedValue r11 = new TypedValue();
        if (getContext().getTheme().resolveAttribute(r10, r11, true) == true) goto L5;
        return null;
    L5:
        ColorStateList r12 = a.a(getContext(), r11.resourceId);
        if (getContext().getTheme().resolveAttribute(R$attr.colorPrimary, r11, true) == true) goto L8;
        return null;
    L8:
        int r13 = r11.data;
        int r14 = r12.getDefaultColor();
        int[] r15 = DISABLED_STATE_SET;
        return new ColorStateList(new int[][]{r15, CHECKED_STATE_SET, FrameLayout.EMPTY_STATE_SET}, new int[]{r12.getColorForState(r15, r14), r13, r14});
    }

    @NonNull
    private final Drawable createDefaultItemBackground(@NonNull b0 r10) {
        int r11 = r10.n(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance, 0);
        int r12 = r10.n(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay, 0);
        MaterialShapeDrawable r13 = new MaterialShapeDrawable(ShapeAppearanceModel.builder(getContext(), r11, r12).build());
        r13.setFillColor(MaterialResources.getColorStateList(getContext(), r10, com.google.android.material.R.styleable.NavigationView_itemShapeFillColor));
        return new InsetDrawable(r13, r10.f(com.google.android.material.R.styleable.NavigationView_itemShapeInsetStart, 0), r10.f(com.google.android.material.R.styleable.NavigationView_itemShapeInsetTop, 0), r10.f(com.google.android.material.R.styleable.NavigationView_itemShapeInsetEnd, 0), r10.f(com.google.android.material.R.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater != null) goto L6;
        this.menuInflater = new c(getContext());
    L6:
        return this.menuInflater;
    }

    private boolean hasShapeAppearance(@NonNull b0 r10) {
        if (r10.s(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance) == false) goto L5;
    L8:
        return true;
    L5:
        if (r10.s(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay) == true) goto L8;
        return false;
    }

    private void setupInsetScrimsListener() {
        this.onGlobalLayoutListener = new AnonymousClass2(this);
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    public void addHeaderView(@NonNull View r10) {
        this.presenter.addHeaderView(r10);
    }

    @Nullable
    public MenuItem getCheckedItem() {
        return this.presenter.getCheckedItem();
    }

    public int getHeaderCount() {
        return this.presenter.getHeaderCount();
    }

    public View getHeaderView(int r10) {
        return this.presenter.getHeaderView(r10);
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.presenter.getItemBackground();
    }

    @Dimension
    public int getItemHorizontalPadding() {
        return this.presenter.getItemHorizontalPadding();
    }

    @Dimension
    public int getItemIconPadding() {
        return this.presenter.getItemIconPadding();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.presenter.getItemTintList();
    }

    public int getItemMaxLines() {
        return this.presenter.getItemMaxLines();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.presenter.getItemTextColor();
    }

    @NonNull
    public Menu getMenu() {
        return this.menu;
    }

    public View inflateHeaderView(@LayoutRes int r10) {
        return this.presenter.inflateHeaderView(r10);
    }

    public void inflateMenu(int r10) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(r10, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(false);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onInsetsChanged(@NonNull WindowInsetsCompat r10) {
        this.presenter.dispatchApplyWindowInsets(r10);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        int r12 = View.MeasureSpec.getMode(r10);
        if (r12 == Integer.MIN_VALUE) goto L7;
        if (r12 != 0) goto L8;
        r10 = View.MeasureSpec.makeMeasureSpec(this.maxWidth, Ints.MAX_POWER_OF_TWO);
    L8:
        super.onMeasure(r10, r11);
        return;
    L7:
        r10 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(r10), this.maxWidth), Ints.MAX_POWER_OF_TWO);
        goto L8
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        this.menu.restorePresenterStates(r11.menuState);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        Bundle r11 = new Bundle();
        r10.menuState = r11;
        this.menu.savePresenterStates(r11);
        return r10;
    }

    public void removeHeaderView(@NonNull View r10) {
        this.presenter.removeHeaderView(r10);
    }

    public void setCheckedItem(@IdRes int r10) {
        MenuItem r11 = this.menu.findItem(r10);
        if (r11 == null) goto L6;
        this.presenter.setCheckedItem((g) r11);
        return;
    }

    @Override // android.view.View
    public void setElevation(float r10) {
        super.setElevation(r10);
        MaterialShapeUtils.setElevation(this, r10);
    }

    public void setItemBackground(@Nullable Drawable r10) {
        this.presenter.setItemBackground(r10);
    }

    public void setItemBackgroundResource(@DrawableRes int r10) {
        setItemBackground(ContextCompat.d(getContext(), r10));
    }

    public void setItemHorizontalPadding(@Dimension int r10) {
        this.presenter.setItemHorizontalPadding(r10);
    }

    public void setItemHorizontalPaddingResource(@DimenRes int r10) {
        this.presenter.setItemHorizontalPadding(getResources().getDimensionPixelSize(r10));
    }

    public void setItemIconPadding(@Dimension int r10) {
        this.presenter.setItemIconPadding(r10);
    }

    public void setItemIconPaddingResource(int r10) {
        this.presenter.setItemIconPadding(getResources().getDimensionPixelSize(r10));
    }

    public void setItemIconSize(@Dimension int r10) {
        this.presenter.setItemIconSize(r10);
    }

    public void setItemIconTintList(@Nullable ColorStateList r10) {
        this.presenter.setItemIconTintList(r10);
    }

    public void setItemMaxLines(int r10) {
        this.presenter.setItemMaxLines(r10);
    }

    public void setItemTextAppearance(@StyleRes int r10) {
        this.presenter.setItemTextAppearance(r10);
    }

    public void setItemTextColor(@Nullable ColorStateList r10) {
        this.presenter.setItemTextColor(r10);
    }

    public void setNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener r10) {
        this.listener = r10;
    }

    @Override // android.view.View
    public void setOverScrollMode(int r10) {
        super.setOverScrollMode(r10);
        NavigationMenuPresenter r11 = this.presenter;
        if (r11 == null) goto L6;
        r11.setOverScrollMode(r10);
        return;
    }

    public NavigationView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, com.google.android.material.R.attr.navigationViewStyle);
    }

    public NavigationView(@NonNull Context r11, @Nullable AttributeSet r12, int r13) {
        int r10 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r11, r12, r13, r10), r12, r13);
        NavigationMenuPresenter r14 = new NavigationMenuPresenter();
        this.presenter = r14;
        this.tmpLocation = new int[2];
        Context r15 = getContext();
        NavigationMenu r16 = new NavigationMenu(r15);
        this.menu = r16;
        b0 r17 = ThemeEnforcement.obtainTintedStyledAttributes(r15, r12, com.google.android.material.R.styleable.NavigationView, r13, r10, new int[0]);
        int r18 = com.google.android.material.R.styleable.NavigationView_android_background;
        if (r17.s(r18) == false) goto L6;
        ViewCompat.t0(this, r17.g(r18));
    L6:
        if (getBackground() != null) goto L8;
    L9:
        ShapeAppearanceModel r19 = ShapeAppearanceModel.builder(r15, r12, r13, r10).build();
        Drawable r110 = getBackground();
        MaterialShapeDrawable r20 = new MaterialShapeDrawable(r19);
        if ((r110 instanceof ColorDrawable) == false) goto L12;
        r20.setFillColor(ColorStateList.valueOf(((ColorDrawable) r110).getColor()));
    L12:
        r20.initializeElevationOverlay(r15);
        ViewCompat.t0(this, r20);
    L13:
        int r111 = com.google.android.material.R.styleable.NavigationView_elevation;
        if (r17.s(r111) == false) goto L16;
        setElevation(r17.f(r111, 0));
    L16:
        setFitsSystemWindows(r17.a(com.google.android.material.R.styleable.NavigationView_android_fitsSystemWindows, false));
        this.maxWidth = r17.f(com.google.android.material.R.styleable.NavigationView_android_maxWidth, 0);
        int r112 = com.google.android.material.R.styleable.NavigationView_itemIconTint;
        if (r17.s(r112) == false) goto L19;
        ColorStateList r113 = r17.c(r112);
    L20:
        int r114 = com.google.android.material.R.styleable.NavigationView_itemTextAppearance;
        if (r17.s(r114) == false) goto L23;
        int r115 = r17.n(r114, 0);
        boolean r21 = true;
    L24:
        int r22 = com.google.android.material.R.styleable.NavigationView_itemIconSize;
        if (r17.s(r22) == false) goto L27;
        setItemIconSize(r17.f(r22, 0));
    L27:
        int r23 = com.google.android.material.R.styleable.NavigationView_itemTextColor;
        if (r17.s(r23) == false) goto L30;
        ColorStateList r24 = r17.c(r23);
    L31:
        if (r21 == true) goto L34;
        if (r24 != null) goto L34;
        r24 = createDefaultColorStateList(R.attr.textColorPrimary);
    L34:
        Drawable r25 = r17.g(com.google.android.material.R.styleable.NavigationView_itemBackground);
        if (r25 == null) goto L37;
    L39:
        int r26 = com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding;
        if (r17.s(r26) == false) goto L42;
        r14.setItemHorizontalPadding(r17.f(r26, 0));
    L42:
        int r27 = r17.f(com.google.android.material.R.styleable.NavigationView_itemIconPadding, 0);
        setItemMaxLines(r17.k(com.google.android.material.R.styleable.NavigationView_itemMaxLines, 1));
        r16.setCallback(new AnonymousClass1(this));
        r14.setId(1);
        r14.initForMenu(r15, r16);
        r14.setItemIconTintList(r113);
        r14.setOverScrollMode(getOverScrollMode());
        if (r21 == false) goto L45;
        r14.setItemTextAppearance(r115);
    L45:
        r14.setItemTextColor(r24);
        r14.setItemBackground(r25);
        r14.setItemIconPadding(r27);
        r16.addMenuPresenter(r14);
        addView((View) r14.getMenuView(this));
        int r116 = com.google.android.material.R.styleable.NavigationView_menu;
        if (r17.s(r116) == false) goto L48;
        inflateMenu(r17.n(r116, 0));
    L48:
        int r117 = com.google.android.material.R.styleable.NavigationView_headerLayout;
        if (r17.s(r117) == false) goto L51;
        inflateHeaderView(r17.n(r117, 0));
    L51:
        r17.w();
        setupInsetScrimsListener();
        return;
    L37:
        if (hasShapeAppearance(r17) == false) goto L39;
        r25 = createDefaultItemBackground(r17);
        goto L39
    L30:
        r24 = null;
        goto L31
    L23:
        r115 = 0;
        r21 = false;
        goto L24
    L19:
        r113 = createDefaultColorStateList(R.attr.textColorSecondary);
        goto L20
    L8:
        if ((getBackground() instanceof ColorDrawable) == false) goto L13;
        goto L9
    }

    public void setCheckedItem(@NonNull MenuItem r10) {
        MenuItem r11 = this.menu.findItem(r10.getItemId());
        if (r11 == null) goto L7;
        this.presenter.setCheckedItem((g) r11);
        return;
    L7:
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
