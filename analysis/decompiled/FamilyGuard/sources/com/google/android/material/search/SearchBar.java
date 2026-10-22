package com.google.android.material.search;

import a1.C0409b;
import a1.C0411d;
import a1.C0412e;
import a1.C0417j;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.p;
import j1.C0777a;
import t1.C1115h;
import t1.C1116i;

/* loaded from: classes.dex */
public class SearchBar extends Toolbar {

    /* renamed from: u0, reason: collision with root package name */
    private static final int f13052u0 = C0417j.f6919j;

    /* renamed from: W, reason: collision with root package name */
    private final TextView f13053W;

    /* renamed from: a0, reason: collision with root package name */
    private final TextView f13054a0;

    /* renamed from: b0, reason: collision with root package name */
    private final FrameLayout f13055b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f13056c0;

    /* renamed from: d0, reason: collision with root package name */
    private final ColorStateList f13057d0;

    /* renamed from: e0, reason: collision with root package name */
    private final boolean f13058e0;

    /* renamed from: f0, reason: collision with root package name */
    private final boolean f13059f0;

    /* renamed from: g0, reason: collision with root package name */
    private final Drawable f13060g0;

    /* renamed from: h0, reason: collision with root package name */
    private final boolean f13061h0;

    /* renamed from: i0, reason: collision with root package name */
    private final boolean f13062i0;

    /* renamed from: j0, reason: collision with root package name */
    private View f13063j0;

    /* renamed from: k0, reason: collision with root package name */
    private Integer f13064k0;

    /* renamed from: l0, reason: collision with root package name */
    private Drawable f13065l0;

    /* renamed from: m0, reason: collision with root package name */
    private int f13066m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f13067n0;

    /* renamed from: o0, reason: collision with root package name */
    private C1115h f13068o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f13069p0;

    /* renamed from: q0, reason: collision with root package name */
    private int f13070q0;

    /* renamed from: r0, reason: collision with root package name */
    private ActionMenuView f13071r0;

    /* renamed from: s0, reason: collision with root package name */
    private ImageButton f13072s0;

    /* renamed from: t0, reason: collision with root package name */
    private final AppBarLayout.g f13073t0;

    static class a extends androidx.customview.view.a {
        public static final Parcelable.Creator<a> CREATOR = new C0169a();

        /* renamed from: a, reason: collision with root package name */
        String f13075a;

        /* renamed from: com.google.android.material.search.SearchBar$a$a, reason: collision with other inner class name */
        class C0169a implements Parcelable.ClassLoaderCreator<a> {
            C0169a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new a(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i5) {
                return new a[i5];
            }
        }

        public a(Parcel parcel) {
            this(parcel, null);
        }

        @Override // androidx.customview.view.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeString(this.f13075a);
        }

        public a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f13075a = parcel.readString();
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    private void R() {
        AppBarLayout appBarLayoutParentIfExists = getAppBarLayoutParentIfExists();
        if (appBarLayoutParentIfExists == null || this.f13057d0 == null) {
            return;
        }
        appBarLayoutParentIfExists.e(this.f13073t0);
    }

    private int S(int i5, int i6) {
        return i5 == 0 ? i6 : i5;
    }

    private ActionMenuView T() {
        if (this.f13071r0 == null) {
            this.f13071r0 = p.a(this);
        }
        return this.f13071r0;
    }

    private ImageButton U() {
        if (this.f13072s0 == null) {
            this.f13072s0 = p.d(this);
        }
        return this.f13072s0;
    }

    private void V(View view, int i5, int i6, int i7, int i8) {
        if (getLayoutDirection() == 1) {
            view.layout(getMeasuredWidth() - i7, i6, getMeasuredWidth() - i5, i8);
        } else {
            view.layout(i5, i6, i7, i8);
        }
    }

    private void W() {
        int measuredWidth = (getMeasuredWidth() / 2) - (this.f13055b0.getMeasuredWidth() / 2);
        int measuredWidth2 = this.f13055b0.getMeasuredWidth() + measuredWidth;
        int measuredHeight = (getMeasuredHeight() / 2) - (this.f13055b0.getMeasuredHeight() / 2);
        int measuredHeight2 = this.f13055b0.getMeasuredHeight() + measuredHeight;
        boolean z5 = getLayoutDirection() == 1;
        ActionMenuView actionMenuViewT = T();
        ImageButton imageButtonU = U();
        int measuredWidth3 = (this.f13055b0.getMeasuredWidth() / 2) - (this.f13053W.getMeasuredWidth() / 2);
        int measuredWidth4 = this.f13053W.getMeasuredWidth() + measuredWidth3;
        int i5 = measuredWidth3 + measuredWidth;
        int i6 = measuredWidth4 + measuredWidth;
        ActionMenuView actionMenuView = z5 ? actionMenuViewT : imageButtonU;
        if (z5) {
            actionMenuViewT = imageButtonU;
        }
        int iMax = actionMenuView != null ? Math.max(actionMenuView.getRight() - i5, 0) : 0;
        int i7 = i5 + iMax;
        int i8 = i6 + iMax;
        int iMax2 = actionMenuViewT != null ? Math.max(i8 - actionMenuViewT.getLeft(), 0) : 0;
        int i9 = i7 - iMax2;
        int i10 = i8 - iMax2;
        int iMax3 = ((iMax - iMax2) + Math.max(Math.max(getPaddingLeft() - i9, getContentInsetLeft() - i9), 0)) - Math.max(Math.max(i10 - (getMeasuredWidth() - getPaddingRight()), i10 - (getMeasuredWidth() - getContentInsetRight())), 0);
        this.f13055b0.layout(measuredWidth + iMax3, measuredHeight, measuredWidth2 + iMax3, measuredHeight2);
    }

    private void X(View view) {
        if (view == null) {
            return;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredWidth2 = (getMeasuredWidth() / 2) - (measuredWidth / 2);
        int i5 = measuredWidth2 + measuredWidth;
        int measuredHeight = view.getMeasuredHeight();
        int measuredHeight2 = (getMeasuredHeight() / 2) - (measuredHeight / 2);
        V(view, measuredWidth2, measuredHeight2, i5, measuredHeight2 + measuredHeight);
    }

    private Drawable Y(Drawable drawable) {
        int iD;
        if (!this.f13061h0 || drawable == null) {
            return drawable;
        }
        Integer num = this.f13064k0;
        if (num != null) {
            iD = num.intValue();
        } else {
            iD = C0777a.d(this, drawable == this.f13060g0 ? C0409b.f6718e : C0409b.f6717d);
        }
        Drawable drawableR = androidx.core.graphics.drawable.a.r(drawable.mutate());
        drawableR.setTint(iD);
        return drawableR;
    }

    private void Z(int i5, int i6) {
        View view = this.f13063j0;
        if (view != null) {
            view.measure(i5, i6);
        }
    }

    private void a0() {
        AppBarLayout appBarLayoutParentIfExists = getAppBarLayoutParentIfExists();
        if (appBarLayoutParentIfExists != null) {
            appBarLayoutParentIfExists.A(this.f13073t0);
        }
    }

    private void b0() throws Resources.NotFoundException {
        if (this.f13059f0 && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            Resources resources = getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(C0411d.f6801u);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(getDefaultMarginVerticalResource());
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.leftMargin = S(marginLayoutParams.leftMargin, dimensionPixelSize);
            marginLayoutParams.topMargin = S(marginLayoutParams.topMargin, dimensionPixelSize2);
            marginLayoutParams.rightMargin = S(marginLayoutParams.rightMargin, dimensionPixelSize);
            marginLayoutParams.bottomMargin = S(marginLayoutParams.bottomMargin, dimensionPixelSize2);
        }
    }

    private void c0() {
        if (Build.VERSION.SDK_INT < 34) {
            return;
        }
        boolean z5 = getLayoutDirection() == 1;
        ImageButton imageButtonD = p.d(this);
        int width = (imageButtonD == null || !imageButtonD.isClickable()) ? 0 : z5 ? getWidth() - imageButtonD.getLeft() : imageButtonD.getRight();
        ActionMenuView actionMenuViewA = p.a(this);
        int right = actionMenuViewA != null ? z5 ? actionMenuViewA.getRight() : getWidth() - actionMenuViewA.getLeft() : 0;
        float f5 = -(z5 ? right : width);
        if (!z5) {
            width = right;
        }
        setHandwritingBoundsOffsets(f5, 0.0f, -width, 0.0f);
    }

    private void d0() {
        if (getLayoutParams() instanceof AppBarLayout.e) {
            AppBarLayout.e eVar = (AppBarLayout.e) getLayoutParams();
            if (this.f13067n0) {
                if (eVar.c() == 0) {
                    eVar.g(53);
                }
            } else if (eVar.c() == 53) {
                eVar.g(0);
            }
        }
    }

    private AppBarLayout getAppBarLayoutParentIfExists() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof AppBarLayout) {
                return (AppBarLayout) parent;
            }
        }
        return null;
    }

    private void setNavigationIconDecorative(boolean z5) {
        ImageButton imageButtonD = p.d(this);
        if (imageButtonD == null) {
            return;
        }
        imageButtonD.setClickable(!z5);
        imageButtonD.setFocusable(!z5);
        Drawable background = imageButtonD.getBackground();
        if (background != null) {
            this.f13065l0 = background;
        }
        imageButtonD.setBackgroundDrawable(z5 ? null : this.f13065l0);
        c0();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        if (this.f13058e0 && this.f13063j0 == null && !(view instanceof ActionMenuView)) {
            this.f13063j0 = view;
            view.setAlpha(0.0f);
        }
        super.addView(view, i5, layoutParams);
    }

    public View getCenterView() {
        return this.f13063j0;
    }

    float getCompatElevation() {
        C1115h c1115h = this.f13068o0;
        return c1115h != null ? c1115h.A() : getElevation();
    }

    public float getCornerSize() {
        return this.f13068o0.N();
    }

    protected int getDefaultMarginVerticalResource() {
        return C0411d.f6802v;
    }

    protected int getDefaultNavigationIconResource() {
        return C0412e.f6809c;
    }

    public CharSequence getHint() {
        return this.f13053W.getHint();
    }

    public int getMaxWidth() {
        return this.f13070q0;
    }

    int getMenuResId() {
        return this.f13066m0;
    }

    TextView getPlaceholderTextView() {
        return this.f13054a0;
    }

    public int getStrokeColor() {
        return this.f13068o0.J().getDefaultColor();
    }

    public float getStrokeWidth() {
        return this.f13068o0.L();
    }

    public CharSequence getText() {
        return this.f13053W.getText();
    }

    public boolean getTextCentered() {
        return this.f13069p0;
    }

    public TextView getTextView() {
        return this.f13053W;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() throws Resources.NotFoundException {
        super.onAttachedToWindow();
        C1116i.f(this, this.f13068o0);
        b0();
        d0();
        if (this.f13056c0) {
            R();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a0();
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
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        View view = this.f13063j0;
        if (view != null) {
            X(view);
        }
        c0();
        if (this.f13053W == null || !this.f13069p0) {
            return;
        }
        W();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onMeasure(int i5, int i6) {
        int i7 = this.f13070q0;
        if (i7 >= 0 && i7 < View.MeasureSpec.getSize(i5)) {
            i5 = View.MeasureSpec.makeMeasureSpec(this.f13070q0, View.MeasureSpec.getMode(i5));
        }
        super.onMeasure(i5, i6);
        Z(i5, i6);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        setText(aVar.f13075a);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        CharSequence text = getText();
        aVar.f13075a = text == null ? null : text.toString();
        return aVar;
    }

    public void setCenterView(View view) {
        View view2 = this.f13063j0;
        if (view2 != null) {
            removeView(view2);
            this.f13063j0 = null;
        }
        if (view != null) {
            addView(view);
        }
    }

    public void setDefaultScrollFlagsEnabled(boolean z5) {
        this.f13067n0 = z5;
        d0();
    }

    @Override // android.view.View
    public void setElevation(float f5) {
        super.setElevation(f5);
        C1115h c1115h = this.f13068o0;
        if (c1115h != null) {
            c1115h.f0(f5);
        }
    }

    public void setHint(CharSequence charSequence) {
        this.f13053W.setHint(charSequence);
    }

    public void setLiftOnScroll(boolean z5) {
        this.f13056c0 = z5;
        if (z5) {
            R();
        } else {
            a0();
        }
    }

    public void setMaxWidth(int i5) {
        if (this.f13070q0 != i5) {
            this.f13070q0 = i5;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(Y(drawable));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        if (this.f13062i0) {
            return;
        }
        super.setNavigationOnClickListener(onClickListener);
        setNavigationIconDecorative(onClickListener == null);
    }

    public void setOnLoadAnimationFadeInEnabled(boolean z5) {
        throw null;
    }

    void setPlaceholderText(String str) {
        this.f13054a0.setText(str);
    }

    public void setStrokeColor(int i5) {
        if (getStrokeColor() != i5) {
            this.f13068o0.o0(ColorStateList.valueOf(i5));
        }
    }

    public void setStrokeWidth(float f5) {
        if (getStrokeWidth() != f5) {
            this.f13068o0.p0(f5);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    public void setText(CharSequence charSequence) {
        this.f13053W.setText(charSequence);
        this.f13054a0.setText(charSequence);
    }

    public void setTextCentered(boolean z5) {
        this.f13069p0 = z5;
        TextView textView = this.f13053W;
        if (textView == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
        if (z5) {
            layoutParams.gravity = 1;
            this.f13053W.setGravity(1);
        } else {
            layoutParams.gravity = 0;
            this.f13053W.setGravity(0);
        }
        this.f13053W.setLayoutParams(layoutParams);
        this.f13054a0.setLayoutParams(layoutParams);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void x(int i5) {
        super.x(i5);
        this.f13066m0 = i5;
    }

    public static class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {

        /* renamed from: a, reason: collision with root package name */
        private boolean f13074a;

        public ScrollingViewBehavior() {
            this.f13074a = false;
        }

        private void c(AppBarLayout appBarLayout) throws Resources.NotFoundException {
            appBarLayout.setBackgroundColor(0);
            appBarLayout.setTargetElevation(0.0f);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) throws Resources.NotFoundException {
            boolean zOnDependentViewChanged = super.onDependentViewChanged(coordinatorLayout, view, view2);
            if (!this.f13074a && (view2 instanceof AppBarLayout)) {
                this.f13074a = true;
                c((AppBarLayout) view2);
            }
            return zOnDependentViewChanged;
        }

        @Override // com.google.android.material.appbar.d
        protected boolean shouldHeaderOverlapScrollingChild() {
            return true;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f13074a = false;
        }
    }

    public void setHint(int i5) {
        this.f13053W.setHint(i5);
    }

    public void setText(int i5) {
        this.f13053W.setText(i5);
        this.f13054a0.setText(i5);
    }
}
