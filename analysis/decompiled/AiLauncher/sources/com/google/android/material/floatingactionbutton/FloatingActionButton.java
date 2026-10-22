package com.google.android.material.floatingactionbutton;

import E2.h;
import E2.k;
import Z2.l;
import Z2.o;
import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.C1295h;
import androidx.appcompat.widget.C1300m;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.N;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.a;
import com.google.android.material.internal.v;
import com.google.android.material.stateful.ExtendableSavedState;
import java.util.List;
import u0.C5566a;

/* loaded from: classes2.dex */
public class FloatingActionButton extends v implements Q2.a, o, CoordinatorLayout.b {

    /* renamed from: p, reason: collision with root package name */
    public static final int f20890p = R$style.Widget_Design_FloatingActionButton;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f20891b;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f20892c;

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f20893d;

    /* renamed from: e, reason: collision with root package name */
    public PorterDuff.Mode f20894e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f20895f;

    /* renamed from: g, reason: collision with root package name */
    public int f20896g;

    /* renamed from: h, reason: collision with root package name */
    public int f20897h;

    /* renamed from: i, reason: collision with root package name */
    public int f20898i;

    /* renamed from: j, reason: collision with root package name */
    public int f20899j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f20900k;

    /* renamed from: l, reason: collision with root package name */
    public final Rect f20901l;

    /* renamed from: m, reason: collision with root package name */
    public final Rect f20902m;

    /* renamed from: n, reason: collision with root package name */
    public final C1300m f20903n;

    /* renamed from: o, reason: collision with root package name */
    public com.google.android.material.floatingactionbutton.a f20904o;

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: g */
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: k */
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.onDependentViewChanged(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: l */
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i10) {
            return super.onLayoutChild(coordinatorLayout, floatingActionButton, i10);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
            super.onAttachedToLayoutParams(fVar);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public class a implements a.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f20908a;

        public a(b bVar) {
            this.f20908a = bVar;
        }

        @Override // com.google.android.material.floatingactionbutton.a.e
        public void a() {
            this.f20908a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.a.e
        public void b() {
            this.f20908a.a(FloatingActionButton.this);
        }
    }

    public static abstract class b {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    public class c implements Y2.b {
        public c() {
        }

        @Override // Y2.b
        public void a(int i10, int i11, int i12, int i13) {
            FloatingActionButton.this.f20901l.set(i10, i11, i12, i13);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i10 + floatingActionButton.f20898i, i11 + FloatingActionButton.this.f20898i, i12 + FloatingActionButton.this.f20898i, i13 + FloatingActionButton.this.f20898i);
        }

        @Override // Y2.b
        public void b(Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        @Override // Y2.b
        public boolean c() {
            return FloatingActionButton.this.f20900k;
        }
    }

    public class d<T extends FloatingActionButton> implements a.d {
        public d(k<T> kVar) {
        }

        @Override // com.google.android.material.floatingactionbutton.a.d
        public void a() {
            throw null;
        }

        @Override // com.google.android.material.floatingactionbutton.a.d
        public void b() {
            throw null;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            ((d) obj).getClass();
            throw null;
        }

        public int hashCode() {
            throw null;
        }
    }

    private com.google.android.material.floatingactionbutton.a getImpl() {
        if (this.f20904o == null) {
            this.f20904o = new com.google.android.material.floatingactionbutton.a(this, new c());
        }
        return this.f20904o;
    }

    @Override // Q2.a
    public boolean a() {
        throw null;
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void e(Animator.AnimatorListener animatorListener) {
        getImpl().e(animatorListener);
    }

    public void f(Animator.AnimatorListener animatorListener) {
        getImpl().f(animatorListener);
    }

    public void g(k<? extends FloatingActionButton> kVar) {
        getImpl().g(new d(kVar));
    }

    @Override // android.widget.ImageButton, android.widget.ImageView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "com.google.android.material.floatingactionbutton.FloatingActionButton";
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f20891b;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f20892c;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().n();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().q();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().s();
    }

    public Drawable getContentBackground() {
        return getImpl().m();
    }

    public int getCustomSize() {
        return this.f20897h;
    }

    public int getExpandedComponentIdHint() {
        throw null;
    }

    public h getHideMotionSpec() {
        return getImpl().p();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f20895f;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f20895f;
    }

    public l getShapeAppearanceModel() {
        return (l) B0.h.f(getImpl().t());
    }

    public h getShowMotionSpec() {
        return getImpl().u();
    }

    public int getSize() {
        return this.f20896g;
    }

    public int getSizeDimension() {
        return i(this.f20896g);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f20893d;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f20894e;
    }

    public boolean getUseCompatPadding() {
        return this.f20900k;
    }

    public void h(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        o(rect);
    }

    public final int i(int i10) {
        int i11 = this.f20897h;
        if (i11 != 0) {
            return i11;
        }
        Resources resources = getResources();
        return i10 != -1 ? i10 != 1 ? resources.getDimensionPixelSize(R$dimen.design_fab_size_normal) : resources.getDimensionPixelSize(R$dimen.design_fab_size_mini) : Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? i(1) : i(0);
    }

    public final void j(Rect rect) {
        h(rect);
        int i10 = -this.f20904o.v();
        rect.inset(i10, i10);
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
    }

    public void k(b bVar) {
        l(bVar, true);
    }

    public void l(b bVar, boolean z10) {
        getImpl().w(s(bVar), z10);
    }

    public boolean m() {
        return getImpl().y();
    }

    public boolean n() {
        return getImpl().z();
    }

    public final void o(Rect rect) {
        int i10 = rect.left;
        Rect rect2 = this.f20901l;
        rect.left = i10 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().A();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().C();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        int sizeDimension = getSizeDimension();
        this.f20898i = (sizeDimension - this.f20899j) / 2;
        getImpl().Y();
        int iMin = Math.min(View.resolveSize(sizeDimension, i10), View.resolveSize(sizeDimension, i11));
        Rect rect = this.f20901l;
        setMeasuredDimension(rect.left + iMin + rect.right, iMin + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.getSuperState());
        throw null;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        new ExtendableSavedState(parcelableOnSaveInstanceState);
        throw null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            j(this.f20902m);
            if (!this.f20902m.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void p() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f20893d;
        if (colorStateList == null) {
            C5566a.c(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f20894e;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(C1295h.e(colorForState, mode));
    }

    public void q(b bVar) {
        r(bVar, true);
    }

    public void r(b bVar, boolean z10) {
        getImpl().W(s(bVar), z10);
    }

    public final a.e s(b bVar) {
        if (bVar == null) {
            return null;
        }
        return new a(bVar);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f20891b != colorStateList) {
            this.f20891b = colorStateList;
            getImpl().H(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f20892c != mode) {
            this.f20892c = mode;
            getImpl().I(mode);
        }
    }

    public void setCompatElevation(float f10) {
        getImpl().J(f10);
    }

    public void setCompatElevationResource(int i10) {
        setCompatElevation(getResources().getDimension(i10));
    }

    public void setCompatHoveredFocusedTranslationZ(float f10) {
        getImpl().M(f10);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i10) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i10));
    }

    public void setCompatPressedTranslationZ(float f10) {
        getImpl().P(f10);
    }

    public void setCompatPressedTranslationZResource(int i10) {
        setCompatPressedTranslationZ(getResources().getDimension(i10));
    }

    public void setCustomSize(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i10 != this.f20897h) {
            this.f20897h = i10;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        getImpl().Z(f10);
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        if (z10 != getImpl().o()) {
            getImpl().K(z10);
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i10) {
        throw null;
    }

    public void setHideMotionSpec(h hVar) {
        getImpl().L(hVar);
    }

    public void setHideMotionSpecResource(int i10) {
        setHideMotionSpec(h.c(getContext(), i10));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().X();
            if (this.f20893d != null) {
                p();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        this.f20903n.i(i10);
        p();
    }

    public void setMaxImageSize(int i10) {
        this.f20899j = i10;
        getImpl().O(i10);
    }

    public void setRippleColor(int i10) {
        setRippleColor(ColorStateList.valueOf(i10));
    }

    @Override // android.view.View
    public void setScaleX(float f10) {
        super.setScaleX(f10);
        getImpl().F();
    }

    @Override // android.view.View
    public void setScaleY(float f10) {
        super.setScaleY(f10);
        getImpl().F();
    }

    public void setShadowPaddingEnabled(boolean z10) {
        getImpl().R(z10);
    }

    @Override // Z2.o
    public void setShapeAppearanceModel(l lVar) {
        getImpl().S(lVar);
    }

    public void setShowMotionSpec(h hVar) {
        getImpl().T(hVar);
    }

    public void setShowMotionSpecResource(int i10) {
        setShowMotionSpec(h.c(getContext(), i10));
    }

    public void setSize(int i10) {
        this.f20897h = 0;
        if (i10 != this.f20896g) {
            this.f20896g = i10;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f20893d != colorStateList) {
            this.f20893d = colorStateList;
            p();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f20894e != mode) {
            this.f20894e = mode;
            p();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f10) {
        super.setTranslationX(f10);
        getImpl().G();
    }

    @Override // android.view.View
    public void setTranslationY(float f10) {
        super.setTranslationY(f10);
        getImpl().G();
    }

    @Override // android.view.View
    public void setTranslationZ(float f10) {
        super.setTranslationZ(f10);
        getImpl().G();
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f20900k != z10) {
            this.f20900k = z10;
            getImpl().B();
        }
    }

    @Override // com.google.android.material.internal.v, android.widget.ImageView, android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: a, reason: collision with root package name */
        public Rect f20905a;

        /* renamed from: b, reason: collision with root package name */
        public b f20906b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f20907c;

        public BaseBehavior() {
            this.f20907c = true;
        }

        private static boolean i(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.f20901l;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        public final boolean h(View view, FloatingActionButton floatingActionButton) {
            return (this.f20907c && ((CoordinatorLayout.f) floatingActionButton.getLayoutParams()).e() == view.getId() && floatingActionButton.getUserSetVisibility() == 0) ? false : true;
        }

        public final void j(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            Rect rect = floatingActionButton.f20901l;
            if (rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
            int i10 = 0;
            int i11 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) fVar).rightMargin ? rect.right : floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) fVar).leftMargin ? -rect.left : 0;
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) {
                i10 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) fVar).topMargin) {
                i10 = -rect.top;
            }
            if (i10 != 0) {
                N.T(floatingActionButton, i10);
            }
            if (i11 != 0) {
                N.S(floatingActionButton, i11);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                m(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!i(view)) {
                return false;
            }
            n(view, floatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i10) {
            List<View> listY = coordinatorLayout.y(floatingActionButton);
            int size = listY.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = listY.get(i11);
                if (!(view instanceof AppBarLayout)) {
                    if (i(view) && n(view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (m(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.Q(floatingActionButton, i10);
            j(coordinatorLayout, floatingActionButton);
            return true;
        }

        public final boolean m(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (h(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f20905a == null) {
                this.f20905a = new Rect();
            }
            Rect rect = this.f20905a;
            com.google.android.material.internal.c.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.l(this.f20906b, false);
                return true;
            }
            floatingActionButton.r(this.f20906b, false);
            return true;
        }

        public final boolean n(View view, FloatingActionButton floatingActionButton) {
            if (h(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.l(this.f20906b, false);
                return true;
            }
            floatingActionButton.r(this.f20906b, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
            if (fVar.f12914h == 0) {
                fVar.f12914h = 80;
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatingActionButton_Behavior_Layout);
            this.f20907c = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f20895f != colorStateList) {
            this.f20895f = colorStateList;
            getImpl().Q(this.f20895f);
        }
    }
}
