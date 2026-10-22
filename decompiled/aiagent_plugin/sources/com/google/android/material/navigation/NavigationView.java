package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
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
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.y;
import androidx.core.view.ViewCompat;
import androidx.core.view.al;
import androidx.core.view.d;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.g.c;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.g;
import com.google.android.material.internal.l;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.i;
import com.google.android.material.shape.m;
import com.google.android.material.shape.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] CHECKED_STATE_SET = null;
    private static final int DEF_STYLE_RES = 0;
    private static final int[] DISABLED_STATE_SET = null;
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    private boolean bottomInsetScrimEnabled;
    private int drawerLayoutCornerSize;
    private int layoutGravity;
    a listener;
    private final int maxWidth;
    private final NavigationMenu menu;
    private MenuInflater menuInflater;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private final g presenter;
    private final RectF shapeClipBounds;
    private Path shapeClipPath;
    private final int[] tmpLocation;
    private boolean topInsetScrimEnabled;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public Bundle menuState;

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            this.menuState = r1.readBundle(r2);
        }

        public SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin"));
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeBundle(this.menuState);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    public interface a {
        boolean a(MenuItem r1);
    }

    static /* synthetic */ int[] access$000(NavigationView r0) {
        return r0.tmpLocation;
    }

    static /* synthetic */ g access$100(NavigationView r0) {
        return r0.presenter;
    }

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        DISABLED_STATE_SET = new int[]{-16842910};
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.style.Widget_Design_NavigationView, "style", "Widget_Design_NavigationView");
    }

    public NavigationView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public NavigationView(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.attr.navigationViewStyle, "attr", "navigationViewStyle"));
    }

    public NavigationView(Context r17, AttributeSet r18, int r19) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r18, AttributeSet.class, "com.obric.aiagent.plugin");
        int r10 = DEF_STYLE_RES;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r1, r9, r19, r10), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r9, r19);
        g r11 = new g();
        this.presenter = r11;
        this.tmpLocation = new int[2];
        this.topInsetScrimEnabled = true;
        this.bottomInsetScrimEnabled = true;
        this.layoutGravity = 0;
        this.drawerLayoutCornerSize = 0;
        this.shapeClipBounds = new RectF();
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        NavigationMenu r15 = new NavigationMenu(r14);
        this.menu = r15;
        y r2 = l.b(r14, r9, com.obric.aiagent.plugin.R.styleable.NavigationView, r19, r10, new int[0]);
        if (r2.g(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_android_background, "styleable", "NavigationView_android_background")) == false) goto L5;
        ViewCompat.a(this, r2.a(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_android_background, "styleable", "NavigationView_android_background")));
    L5:
        this.drawerLayoutCornerSize = r2.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_drawerLayoutCornerSize, "styleable", "NavigationView_drawerLayoutCornerSize"), 0);
        this.layoutGravity = r2.a(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_android_layout_gravity, "styleable", "NavigationView_android_layout_gravity"), 0);
        if (getBackground() != null) goto L8;
    L9:
        m r3 = m.a(r14, r9, r19, r10).a();
        Drawable r4 = getBackground();
        MaterialShapeDrawable r5 = new MaterialShapeDrawable(r3);
        if (ZeusTransformUtils.instanceOf(r4, ColorDrawable.class) == false) goto L12;
        r5.setFillColor(ColorStateList.valueOf(((ColorDrawable) ZeusTransformUtils.preCheckCast(r4, ColorDrawable.class, "com.obric.aiagent.plugin")).getColor()));
    L12:
        r5.initializeElevationOverlay(r14);
        ViewCompat.a(this, r5);
    L14:
        if (r2.g(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_elevation, "styleable", "NavigationView_elevation")) == false) goto L16;
        setElevation(r2.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_elevation, "styleable", "NavigationView_elevation"), 0));
    L16:
        setFitsSystemWindows(r2.a(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_android_fitsSystemWindows, "styleable", "NavigationView_android_fitsSystemWindows"), false));
        this.maxWidth = r2.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_android_maxWidth, "styleable", "NavigationView_android_maxWidth"), 0);
        if (r2.g(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_subheaderColor, "styleable", "NavigationView_subheaderColor")) == false) goto L19;
        ColorStateList r6 = r2.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_subheaderColor, "styleable", "NavigationView_subheaderColor"));
    L21:
        if (r2.g(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_subheaderTextAppearance, "styleable", "NavigationView_subheaderTextAppearance")) == false) goto L23;
        int r7 = r2.g(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_subheaderTextAppearance, "styleable", "NavigationView_subheaderTextAppearance"), 0);
    L25:
        if (r7 != 0) goto L29;
        if (r6 != null) goto L29;
        r6 = createDefaultColorStateList(R.attr.textColorSecondary);
    L29:
        if (r2.g(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemIconTint, "styleable", "NavigationView_itemIconTint")) == false) goto L31;
        ColorStateList r8 = r2.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemIconTint, "styleable", "NavigationView_itemIconTint"));
    L33:
        if (r2.g(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemTextAppearance, "styleable", "NavigationView_itemTextAppearance")) == false) goto L35;
        int r12 = r2.g(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemTextAppearance, "styleable", "NavigationView_itemTextAppearance"), 0);
    L37:
        if (r2.g(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemIconSize, "styleable", "NavigationView_itemIconSize")) == false) goto L40;
        setItemIconSize(r2.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemIconSize, "styleable", "NavigationView_itemIconSize"), 0));
    L40:
        if (r2.g(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemTextColor, "styleable", "NavigationView_itemTextColor")) == false) goto L42;
        ColorStateList r13 = r2.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemTextColor, "styleable", "NavigationView_itemTextColor"));
    L43:
        if (r12 != 0) goto L46;
        if (r13 != null) goto L46;
        r13 = createDefaultColorStateList(R.attr.textColorPrimary);
    L46:
        Drawable r16 = r2.a(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemBackground, "styleable", "NavigationView_itemBackground"));
        if (r16 != null) goto L57;
        if (hasShapeAppearance(r2) == false) goto L57;
        Drawable r110 = createDefaultItemBackground(r2);
        ColorStateList r111 = c.a(r14, r2, ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemRippleColor, "styleable", "NavigationView_itemRippleColor"));
        if (Build.VERSION.SDK_INT < 21) goto L55;
        if (r111 == null) goto L55;
        r11.a(new RippleDrawable(com.google.android.material.ripple.a.b(r111), null, createDefaultItemDrawable(r2, null)));
    L55:
        r16 = r110;
    L57:
        if (r2.g(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemHorizontalPadding, "styleable", "NavigationView_itemHorizontalPadding")) == false) goto L59;
        int r112 = 0;
        setItemHorizontalPadding(r2.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemHorizontalPadding, "styleable", "NavigationView_itemHorizontalPadding"), 0));
    L61:
        if (r2.g(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemVerticalPadding, "styleable", "NavigationView_itemVerticalPadding")) == false) goto L63;
        setItemVerticalPadding(r2.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemVerticalPadding, "styleable", "NavigationView_itemVerticalPadding"), r112));
    L63:
        setDividerInsetStart(r2.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_dividerInsetStart, "styleable", "NavigationView_dividerInsetStart"), r112));
        setDividerInsetEnd(r2.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_dividerInsetEnd, "styleable", "NavigationView_dividerInsetEnd"), r112));
        setSubheaderInsetStart(r2.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_subheaderInsetStart, "styleable", "NavigationView_subheaderInsetStart"), r112));
        setSubheaderInsetEnd(r2.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_subheaderInsetEnd, "styleable", "NavigationView_subheaderInsetEnd"), r112));
        setTopInsetScrimEnabled(r2.a(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_topInsetScrimEnabled, "styleable", "NavigationView_topInsetScrimEnabled"), this.topInsetScrimEnabled));
        setBottomInsetScrimEnabled(r2.a(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_bottomInsetScrimEnabled, "styleable", "NavigationView_bottomInsetScrimEnabled"), this.bottomInsetScrimEnabled));
        int r20 = r2.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemIconPadding, "styleable", "NavigationView_itemIconPadding"), 0);
        setItemMaxLines(r2.a(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemMaxLines, "styleable", "NavigationView_itemMaxLines"), 1));
        r15.setCallback(new AnonymousClass1(this));
        r11.a(1);
        r11.initForMenu(r14, r15);
        if (r7 == 0) goto L66;
        r11.d(r7);
    L66:
        r11.a(r6);
        r11.b(r8);
        r11.n(getOverScrollMode());
        if (r12 == 0) goto L69;
        r11.e(r12);
    L69:
        r11.c(r13);
        r11.a(r16);
        r11.k(r20);
        r15.addMenuPresenter(r11);
        addView((View) ZeusTransformUtils.preCheckCast(r11.a(this), View.class, "com.obric.aiagent.plugin"));
        if (r2.g(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_menu, "styleable", "NavigationView_menu")) == false) goto L72;
        int r21 = 0;
        inflateMenu(r2.g(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_menu, "styleable", "NavigationView_menu"), 0));
    L74:
        if (r2.g(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_headerLayout, "styleable", "NavigationView_headerLayout")) == false) goto L76;
        inflateHeaderView(r2.g(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_headerLayout, "styleable", "NavigationView_headerLayout"), r21));
    L76:
        r2.b();
        setupInsetScrimsListener();
        return;
    L72:
        r21 = 0;
        goto L74
    L59:
        r112 = 0;
        goto L61
    L42:
        r13 = null;
        goto L43
    L35:
        r12 = 0;
        goto L37
    L31:
        r8 = createDefaultColorStateList(R.attr.textColorSecondary);
        goto L33
    L23:
        r7 = 0;
        goto L25
    L19:
        r6 = null;
        goto L21
    L8:
        if (ZeusTransformUtils.instanceOf(getBackground(), ColorDrawable.class) == false) goto L14;
        goto L9
    }

    @Override // android.view.View
    public void setOverScrollMode(int r1) {
        super.setOverScrollMode(r1);
        g r0 = this.presenter;
        if (r0 == null) goto L6;
        r0.n(r1);
        return;
    }

    private void maybeUpdateCornerSizeForDrawerLayout(int r5, int r6) {
        if (ZeusTransformUtils.instanceOf(getParent(), DrawerLayout.class) == true) goto L5;
    L16:
        this.shapeClipPath = null;
        this.shapeClipBounds.setEmpty();
        return;
    L5:
        if (this.drawerLayoutCornerSize <= 0) goto L16;
        if (ZeusTransformUtils.instanceOf(getBackground(), MaterialShapeDrawable.class) == false) goto L16;
        MaterialShapeDrawable r0 = (MaterialShapeDrawable) ZeusTransformUtils.preCheckCast(getBackground(), MaterialShapeDrawable.class, "com.obric.aiagent.plugin");
        m.a r1 = r0.getShapeAppearanceModel().n();
        if (d.a(this.layoutGravity, ViewCompat.i(this)) != 3) goto L11;
        r1.c(this.drawerLayoutCornerSize);
        r1.d(this.drawerLayoutCornerSize);
    L12:
        r0.setShapeAppearanceModel(r1.a());
        if (this.shapeClipPath != null) goto L15;
        this.shapeClipPath = new Path();
    L15:
        this.shapeClipPath.reset();
        this.shapeClipBounds.set(0.0f, 0.0f, r5, r6);
        n.a().a(r0.getShapeAppearanceModel(), r0.getInterpolation(), this.shapeClipBounds, this.shapeClipPath);
        invalidate();
        return;
    L11:
        r1.b(this.drawerLayoutCornerSize);
        r1.e(this.drawerLayoutCornerSize);
        goto L12
    }

    private boolean hasShapeAppearance(y r3) {
        if (r3.g(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemShapeAppearance, "styleable", "NavigationView_itemShapeAppearance")) == false) goto L5;
    L8:
        return true;
    L5:
        if (r3.g(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemShapeAppearanceOverlay, "styleable", "NavigationView_itemShapeAppearanceOverlay")) == true) goto L8;
        return false;
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a(this);
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        maybeUpdateCornerSizeForDrawerLayout(r1, r2);
    }

    @Override // android.view.View
    public void setElevation(float r3) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        super.setElevation(r3);
    L5:
        i.a(this, r3);
    }

    private Drawable createDefaultItemBackground(y r5) {
        return createDefaultItemDrawable(r5, c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5, ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemShapeFillColor, "styleable", "NavigationView_itemShapeFillColor")));
    }

    private Drawable createDefaultItemDrawable(y r11, ColorStateList r12) {
        int r0 = r11.g(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemShapeAppearance, "styleable", "NavigationView_itemShapeAppearance"), 0);
        int r3 = r11.g(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemShapeAppearanceOverlay, "styleable", "NavigationView_itemShapeAppearanceOverlay"), 0);
        MaterialShapeDrawable r5 = new MaterialShapeDrawable(m.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r0, r3).a());
        r5.setFillColor(r12);
        return new InsetDrawable(r5, r11.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemShapeInsetStart, "styleable", "NavigationView_itemShapeInsetStart"), 0), r11.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemShapeInsetTop, "styleable", "NavigationView_itemShapeInsetTop"), 0), r11.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemShapeInsetEnd, "styleable", "NavigationView_itemShapeInsetEnd"), 0), r11.e(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.NavigationView_itemShapeInsetBottom, "styleable", "NavigationView_itemShapeInsetBottom"), 0));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.menuState = new Bundle();
        this.menu.savePresenterStates(r1.menuState);
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
        this.menu.restorePresenterStates(r5.menuState);
    }

    public void setNavigationItemSelectedListener(a r3) {
        this.listener = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r4, int r5) {
        int r0 = View.MeasureSpec.getMode(r4);
        if (r0 == Integer.MIN_VALUE) goto L7;
        if (r0 != 0) goto L8;
        r4 = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
    L8:
        super.onMeasure(r4, r5);
        return;
    L7:
        r4 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(r4), this.maxWidth), 1073741824);
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r3) {
        if (this.shapeClipPath != null) goto L6;
        super.dispatchDraw(r3);
        return;
    L6:
        int r0 = r3.save();
        r3.clipPath(this.shapeClipPath);
        super.dispatchDraw(r3);
        r3.restoreToCount(r0);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    public void onInsetsChanged(al r1) {
        this.presenter.a(r1);
    }

    public void inflateMenu(int r3) {
        this.presenter.a(true);
        getMenuInflater().inflate(r3, this.menu);
        this.presenter.a(false);
        this.presenter.updateMenuView(false);
    }

    public Menu getMenu() {
        return this.menu;
    }

    public View inflateHeaderView(int r1) {
        return this.presenter.b(r1);
    }

    public void addHeaderView(View r1) {
        this.presenter.a(r1);
    }

    public void removeHeaderView(View r1) {
        this.presenter.b(r1);
    }

    public int getHeaderCount() {
        return this.presenter.b();
    }

    public View getHeaderView(int r1) {
        return this.presenter.c(r1);
    }

    public ColorStateList getItemIconTintList() {
        return this.presenter.c();
    }

    public void setItemIconTintList(ColorStateList r1) {
        this.presenter.b(r1);
    }

    public ColorStateList getItemTextColor() {
        return this.presenter.d();
    }

    public void setItemTextColor(ColorStateList r1) {
        this.presenter.c(r1);
    }

    public Drawable getItemBackground() {
        return this.presenter.e();
    }

    public void setItemBackgroundResource(int r4) {
        setItemBackground(androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
    }

    public void setItemBackground(Drawable r1) {
        this.presenter.a(r1);
    }

    public int getItemHorizontalPadding() {
        return this.presenter.f();
    }

    public void setItemHorizontalPadding(int r1) {
        this.presenter.f(r1);
    }

    public void setItemHorizontalPaddingResource(int r3) {
        this.presenter.f(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(r3));
    }

    public int getItemVerticalPadding() {
        return this.presenter.g();
    }

    public void setItemVerticalPadding(int r1) {
        this.presenter.g(r1);
    }

    public void setItemVerticalPaddingResource(int r3) {
        this.presenter.g(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(r3));
    }

    public int getItemIconPadding() {
        return this.presenter.l();
    }

    public void setItemIconPadding(int r1) {
        this.presenter.k(r1);
    }

    public void setItemIconPaddingResource(int r3) {
        this.presenter.k(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(r3));
    }

    public void setCheckedItem(int r3) {
        MenuItem r4 = this.menu.findItem(r3);
        if (r4 == null) goto L6;
        this.presenter.a((MenuItemImpl) ZeusTransformUtils.preCheckCast(r4, MenuItemImpl.class, "com.obric.aiagent.plugin"));
        return;
    }

    public void setCheckedItem(MenuItem r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r3, MenuItem.class, "com.obric.aiagent.plugin");
        MenuItem r5 = this.menu.findItem(r4.getItemId());
        if (r5 == null) goto L7;
        this.presenter.a((MenuItemImpl) ZeusTransformUtils.preCheckCast(r5, MenuItemImpl.class, "com.obric.aiagent.plugin"));
        return;
    L7:
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    public MenuItem getCheckedItem() {
        return this.presenter.a();
    }

    public void setItemTextAppearance(int r1) {
        this.presenter.e(r1);
    }

    public void setItemIconSize(int r1) {
        this.presenter.m(r1);
    }

    public void setItemMaxLines(int r1) {
        this.presenter.l(r1);
    }

    public int getItemMaxLines() {
        return this.presenter.m();
    }

    public boolean isTopInsetScrimEnabled() {
        return this.topInsetScrimEnabled;
    }

    public void setTopInsetScrimEnabled(boolean r1) {
        this.topInsetScrimEnabled = r1;
    }

    public boolean isBottomInsetScrimEnabled() {
        return this.bottomInsetScrimEnabled;
    }

    public void setBottomInsetScrimEnabled(boolean r1) {
        this.bottomInsetScrimEnabled = r1;
    }

    public int getDividerInsetStart() {
        return this.presenter.h();
    }

    public void setDividerInsetStart(int r1) {
        this.presenter.h(r1);
    }

    public int getDividerInsetEnd() {
        return this.presenter.i();
    }

    public void setDividerInsetEnd(int r1) {
        this.presenter.i(r1);
    }

    public int getSubheaderInsetStart() {
        return this.presenter.j();
    }

    public void setSubheaderInsetStart(int r1) {
        this.presenter.j(r1);
    }

    public int getSubheaderInsetEnd() {
        return this.presenter.k();
    }

    public void setSubheaderInsetEnd(int r1) {
        this.presenter.j(r1);
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater != null) goto L6;
        this.menuInflater = new SupportMenuInflater((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L6:
        return this.menuInflater;
    }

    private ColorStateList createDefaultColorStateList(int r10) {
        TypedValue r0 = new TypedValue();
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getTheme().resolveAttribute(r10, r0, true) == true) goto L5;
        return null;
    L5:
        ColorStateList r11 = androidx.appcompat.a.a.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r0.resourceId);
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getTheme().resolveAttribute(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.attr.colorPrimary, "attr", "colorPrimary"), r0, true) == true) goto L8;
        return null;
    L8:
        int r9 = r0.data;
        int r1 = r11.getDefaultColor();
        int[] r5 = DISABLED_STATE_SET;
        return new ColorStateList(new int[][]{r5, CHECKED_STATE_SET, EMPTY_STATE_SET}, new int[]{r11.getColorForState(r5, r1), r9, r1});
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        getViewTreeObserver().removeGlobalOnLayoutListener(this.onGlobalLayoutListener);
        return;
    L5:
        getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    private void setupInsetScrimsListener() {
        this.onGlobalLayoutListener = new AnonymousClass2(this);
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }
}
