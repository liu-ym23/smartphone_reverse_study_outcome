package com.google.android.material.search;

import M2.a;
import Z2.h;
import Z2.i;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$style;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.s;
import u0.C5566a;

/* loaded from: classes2.dex */
public class SearchBar extends Toolbar {

    /* renamed from: A0, reason: collision with root package name */
    public static final int f21209A0 = R$style.Widget_Material3_SearchBar;

    /* renamed from: U, reason: collision with root package name */
    public final TextView f21210U;

    /* renamed from: V, reason: collision with root package name */
    public final TextView f21211V;

    /* renamed from: W, reason: collision with root package name */
    public final FrameLayout f21212W;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f21213a0;

    /* renamed from: b0, reason: collision with root package name */
    public final ColorStateList f21214b0;

    /* renamed from: c0, reason: collision with root package name */
    public final boolean f21215c0;

    /* renamed from: d0, reason: collision with root package name */
    public final boolean f21216d0;

    /* renamed from: e0, reason: collision with root package name */
    public final Drawable f21217e0;

    /* renamed from: f0, reason: collision with root package name */
    public final boolean f21218f0;

    /* renamed from: g0, reason: collision with root package name */
    public final boolean f21219g0;

    /* renamed from: h0, reason: collision with root package name */
    public View f21220h0;

    /* renamed from: i0, reason: collision with root package name */
    public Integer f21221i0;

    /* renamed from: j0, reason: collision with root package name */
    public Drawable f21222j0;

    /* renamed from: k0, reason: collision with root package name */
    public int f21223k0;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f21224t0;

    /* renamed from: u0, reason: collision with root package name */
    public h f21225u0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f21226v0;

    /* renamed from: w0, reason: collision with root package name */
    public int f21227w0;

    /* renamed from: x0, reason: collision with root package name */
    public ActionMenuView f21228x0;

    /* renamed from: y0, reason: collision with root package name */
    public ImageButton f21229y0;

    /* renamed from: z0, reason: collision with root package name */
    public final AppBarLayout.g f21230z0;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        String text;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.text);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.text = parcel.readString();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    private Drawable Z(Drawable drawable) {
        int iD;
        if (!this.f21218f0 || drawable == null) {
            return drawable;
        }
        Integer num = this.f21221i0;
        if (num != null) {
            iD = num.intValue();
        } else {
            iD = a.d(this, drawable == this.f21217e0 ? R$attr.colorOnSurfaceVariant : R$attr.colorOnSurface);
        }
        Drawable drawableR = C5566a.r(drawable.mutate());
        drawableR.setTint(iD);
        return drawableR;
    }

    private AppBarLayout getAppBarLayoutParentIfExists() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof AppBarLayout) {
                return (AppBarLayout) parent;
            }
        }
        return null;
    }

    private void setNavigationIconDecorative(boolean z10) {
        ImageButton imageButtonD = s.d(this);
        if (imageButtonD == null) {
            return;
        }
        imageButtonD.setClickable(!z10);
        imageButtonD.setFocusable(!z10);
        Drawable background = imageButtonD.getBackground();
        if (background != null) {
            this.f21222j0 = background;
        }
        imageButtonD.setBackgroundDrawable(z10 ? null : this.f21222j0);
        d0();
    }

    public final void S() {
        AppBarLayout appBarLayoutParentIfExists = getAppBarLayoutParentIfExists();
        if (appBarLayoutParentIfExists == null || this.f21214b0 == null) {
            return;
        }
        appBarLayoutParentIfExists.e(this.f21230z0);
    }

    public final int T(int i10, int i11) {
        return i10 == 0 ? i11 : i10;
    }

    public final ActionMenuView U() {
        if (this.f21228x0 == null) {
            this.f21228x0 = s.a(this);
        }
        return this.f21228x0;
    }

    public final ImageButton V() {
        if (this.f21229y0 == null) {
            this.f21229y0 = s.d(this);
        }
        return this.f21229y0;
    }

    public final void W(View view, int i10, int i11, int i12, int i13) {
        if (getLayoutDirection() == 1) {
            view.layout(getMeasuredWidth() - i12, i11, getMeasuredWidth() - i10, i13);
        } else {
            view.layout(i10, i11, i12, i13);
        }
    }

    public final void X() {
        int measuredWidth = (getMeasuredWidth() / 2) - (this.f21212W.getMeasuredWidth() / 2);
        int measuredWidth2 = this.f21212W.getMeasuredWidth() + measuredWidth;
        int measuredHeight = (getMeasuredHeight() / 2) - (this.f21212W.getMeasuredHeight() / 2);
        int measuredHeight2 = this.f21212W.getMeasuredHeight() + measuredHeight;
        boolean z10 = getLayoutDirection() == 1;
        ActionMenuView actionMenuViewU = U();
        ImageButton imageButtonV = V();
        int measuredWidth3 = (this.f21212W.getMeasuredWidth() / 2) - (this.f21210U.getMeasuredWidth() / 2);
        int measuredWidth4 = this.f21210U.getMeasuredWidth() + measuredWidth3;
        int i10 = measuredWidth3 + measuredWidth;
        int i11 = measuredWidth4 + measuredWidth;
        ActionMenuView actionMenuView = z10 ? actionMenuViewU : imageButtonV;
        if (z10) {
            actionMenuViewU = imageButtonV;
        }
        int iMax = actionMenuView != null ? Math.max(actionMenuView.getRight() - i10, 0) : 0;
        int i12 = i10 + iMax;
        int i13 = i11 + iMax;
        int iMax2 = actionMenuViewU != null ? Math.max(i13 - actionMenuViewU.getLeft(), 0) : 0;
        int i14 = i12 - iMax2;
        int i15 = i13 - iMax2;
        int iMax3 = ((iMax - iMax2) + Math.max(Math.max(getPaddingLeft() - i14, getContentInsetLeft() - i14), 0)) - Math.max(Math.max(i15 - (getMeasuredWidth() - getPaddingRight()), i15 - (getMeasuredWidth() - getContentInsetRight())), 0);
        this.f21212W.layout(measuredWidth + iMax3, measuredHeight, measuredWidth2 + iMax3, measuredHeight2);
    }

    public final void Y(View view) {
        if (view == null) {
            return;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredWidth2 = (getMeasuredWidth() / 2) - (measuredWidth / 2);
        int i10 = measuredWidth2 + measuredWidth;
        int measuredHeight = view.getMeasuredHeight();
        int measuredHeight2 = (getMeasuredHeight() / 2) - (measuredHeight / 2);
        W(view, measuredWidth2, measuredHeight2, i10, measuredHeight2 + measuredHeight);
    }

    public final void a0(int i10, int i11) {
        View view = this.f21220h0;
        if (view != null) {
            view.measure(i10, i11);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (this.f21215c0 && this.f21220h0 == null && !(view instanceof ActionMenuView)) {
            this.f21220h0 = view;
            view.setAlpha(0.0f);
        }
        super.addView(view, i10, layoutParams);
    }

    public final void b0() {
        AppBarLayout appBarLayoutParentIfExists = getAppBarLayoutParentIfExists();
        if (appBarLayoutParentIfExists != null) {
            appBarLayoutParentIfExists.A(this.f21230z0);
        }
    }

    public final void c0() throws Resources.NotFoundException {
        if (this.f21216d0 && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            Resources resources = getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.m3_searchbar_margin_horizontal);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(getDefaultMarginVerticalResource());
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.leftMargin = T(marginLayoutParams.leftMargin, dimensionPixelSize);
            marginLayoutParams.topMargin = T(marginLayoutParams.topMargin, dimensionPixelSize2);
            marginLayoutParams.rightMargin = T(marginLayoutParams.rightMargin, dimensionPixelSize);
            marginLayoutParams.bottomMargin = T(marginLayoutParams.bottomMargin, dimensionPixelSize2);
        }
    }

    public final void d0() {
        boolean z10 = getLayoutDirection() == 1;
        ImageButton imageButtonD = s.d(this);
        int width = (imageButtonD == null || !imageButtonD.isClickable()) ? 0 : z10 ? getWidth() - imageButtonD.getLeft() : imageButtonD.getRight();
        ActionMenuView actionMenuViewA = s.a(this);
        int right = actionMenuViewA != null ? z10 ? actionMenuViewA.getRight() : getWidth() - actionMenuViewA.getLeft() : 0;
        float f10 = -(z10 ? right : width);
        if (!z10) {
            width = right;
        }
        setHandwritingBoundsOffsets(f10, 0.0f, -width, 0.0f);
    }

    public final void e0() {
        if (getLayoutParams() instanceof AppBarLayout.e) {
            AppBarLayout.e eVar = (AppBarLayout.e) getLayoutParams();
            if (this.f21224t0) {
                if (eVar.c() == 0) {
                    eVar.g(53);
                }
            } else if (eVar.c() == 53) {
                eVar.g(0);
            }
        }
    }

    public View getCenterView() {
        return this.f21220h0;
    }

    public float getCompatElevation() {
        h hVar = this.f21225u0;
        return hVar != null ? hVar.A() : getElevation();
    }

    public float getCornerSize() {
        return this.f21225u0.N();
    }

    public int getDefaultMarginVerticalResource() {
        return R$dimen.m3_searchbar_margin_vertical;
    }

    public int getDefaultNavigationIconResource() {
        return R$drawable.ic_search_black_24;
    }

    public CharSequence getHint() {
        return this.f21210U.getHint();
    }

    public int getMaxWidth() {
        return this.f21227w0;
    }

    public int getMenuResId() {
        return this.f21223k0;
    }

    public TextView getPlaceholderTextView() {
        return this.f21211V;
    }

    public int getStrokeColor() {
        return this.f21225u0.J().getDefaultColor();
    }

    public float getStrokeWidth() {
        return this.f21225u0.L();
    }

    public CharSequence getText() {
        return this.f21210U.getText();
    }

    public boolean getTextCentered() {
        return this.f21226v0;
    }

    public TextView getTextView() {
        return this.f21210U;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() throws Resources.NotFoundException {
        super.onAttachedToWindow();
        i.f(this, this.f21225u0);
        c0();
        e0();
        if (this.f21213a0) {
            S();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b0();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EditText.class.getCanonicalName());
        accessibilityNodeInfo.setEditable(isEnabled());
        CharSequence text = getText();
        boolean zIsEmpty = TextUtils.isEmpty(text);
        accessibilityNodeInfo.setHintText(getHint());
        accessibilityNodeInfo.setShowingHintText(zIsEmpty);
        if (zIsEmpty) {
            text = getHint();
        }
        accessibilityNodeInfo.setText(text);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        View view = this.f21220h0;
        if (view != null) {
            Y(view);
        }
        d0();
        if (this.f21210U == null || !this.f21226v0) {
            return;
        }
        X();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12 = this.f21227w0;
        if (i12 >= 0 && i12 < View.MeasureSpec.getSize(i10)) {
            i10 = View.MeasureSpec.makeMeasureSpec(this.f21227w0, View.MeasureSpec.getMode(i10));
        }
        super.onMeasure(i10, i11);
        a0(i10, i11);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setText(savedState.text);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        CharSequence text = getText();
        savedState.text = text == null ? null : text.toString();
        return savedState;
    }

    public void setCenterView(View view) {
        View view2 = this.f21220h0;
        if (view2 != null) {
            removeView(view2);
            this.f21220h0 = null;
        }
        if (view != null) {
            addView(view);
        }
    }

    public void setDefaultScrollFlagsEnabled(boolean z10) {
        this.f21224t0 = z10;
        e0();
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        h hVar = this.f21225u0;
        if (hVar != null) {
            hVar.f0(f10);
        }
    }

    public void setHint(CharSequence charSequence) {
        this.f21210U.setHint(charSequence);
    }

    public void setLiftOnScroll(boolean z10) {
        this.f21213a0 = z10;
        if (z10) {
            S();
        } else {
            b0();
        }
    }

    public void setMaxWidth(int i10) {
        if (this.f21227w0 != i10) {
            this.f21227w0 = i10;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(Z(drawable));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        if (this.f21219g0) {
            return;
        }
        super.setNavigationOnClickListener(onClickListener);
        setNavigationIconDecorative(onClickListener == null);
    }

    public void setOnLoadAnimationFadeInEnabled(boolean z10) {
        throw null;
    }

    public void setPlaceholderText(String str) {
        this.f21211V.setText(str);
    }

    public void setStrokeColor(int i10) {
        if (getStrokeColor() != i10) {
            this.f21225u0.o0(ColorStateList.valueOf(i10));
        }
    }

    public void setStrokeWidth(float f10) {
        if (getStrokeWidth() != f10) {
            this.f21225u0.p0(f10);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    public void setText(CharSequence charSequence) {
        this.f21210U.setText(charSequence);
        this.f21211V.setText(charSequence);
    }

    public void setTextCentered(boolean z10) {
        this.f21226v0 = z10;
        TextView textView = this.f21210U;
        if (textView == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
        if (z10) {
            layoutParams.gravity = 1;
            this.f21210U.setGravity(1);
        } else {
            layoutParams.gravity = 0;
            this.f21210U.setGravity(0);
        }
        this.f21210U.setLayoutParams(layoutParams);
        this.f21211V.setLayoutParams(layoutParams);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void x(int i10) {
        super.x(i10);
        this.f21223k0 = i10;
    }

    public static class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {

        /* renamed from: a, reason: collision with root package name */
        public boolean f21231a;

        public ScrollingViewBehavior() {
            this.f21231a = false;
        }

        public final void g(AppBarLayout appBarLayout) throws Resources.NotFoundException {
            appBarLayout.setBackgroundColor(0);
            appBarLayout.setTargetElevation(0.0f);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) throws Resources.NotFoundException {
            boolean zOnDependentViewChanged = super.onDependentViewChanged(coordinatorLayout, view, view2);
            if (!this.f21231a && (view2 instanceof AppBarLayout)) {
                this.f21231a = true;
                g((AppBarLayout) view2);
            }
            return zOnDependentViewChanged;
        }

        @Override // com.google.android.material.appbar.d
        public boolean shouldHeaderOverlapScrollingChild() {
            return true;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f21231a = false;
        }
    }

    public void setHint(int i10) {
        this.f21210U.setHint(i10);
    }

    public void setText(int i10) {
        this.f21210U.setText(i10);
        this.f21211V.setText(i10);
    }
}
