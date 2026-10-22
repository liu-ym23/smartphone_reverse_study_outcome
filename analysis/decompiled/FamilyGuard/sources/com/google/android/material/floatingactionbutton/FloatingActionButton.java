package com.google.android.material.floatingactionbutton;

import a1.C0411d;
import a1.C0417j;
import a1.C0418k;
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
import androidx.appcompat.widget.C0441k;
import androidx.appcompat.widget.C0447q;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.H;
import b1.h;
import b1.k;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.b;
import com.google.android.material.internal.s;
import java.util.List;
import m1.InterfaceC0857a;
import s1.InterfaceC1048b;
import t1.l;
import t1.o;
import v1.C1181a;

/* loaded from: classes.dex */
public class FloatingActionButton extends s implements InterfaceC0857a, o, CoordinatorLayout.b {

    /* renamed from: p, reason: collision with root package name */
    private static final int f12824p = C0417j.f6915f;

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f12825b;

    /* renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f12826c;

    /* renamed from: d, reason: collision with root package name */
    private ColorStateList f12827d;

    /* renamed from: e, reason: collision with root package name */
    private PorterDuff.Mode f12828e;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f12829f;

    /* renamed from: g, reason: collision with root package name */
    private int f12830g;

    /* renamed from: h, reason: collision with root package name */
    private int f12831h;

    /* renamed from: i, reason: collision with root package name */
    private int f12832i;

    /* renamed from: j, reason: collision with root package name */
    private int f12833j;

    /* renamed from: k, reason: collision with root package name */
    boolean f12834k;

    /* renamed from: l, reason: collision with root package name */
    final Rect f12835l;

    /* renamed from: m, reason: collision with root package name */
    private final Rect f12836m;

    /* renamed from: n, reason: collision with root package name */
    private final C0447q f12837n;

    /* renamed from: o, reason: collision with root package name */
    private com.google.android.material.floatingactionbutton.b f12838o;

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: c */
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: g */
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.onDependentViewChanged(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: h */
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i5) {
            return super.onLayoutChild(coordinatorLayout, floatingActionButton, i5);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
            super.onAttachedToLayoutParams(fVar);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    class a implements b.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f12842a;

        a(b bVar) {
            this.f12842a = bVar;
        }

        @Override // com.google.android.material.floatingactionbutton.b.e
        public void a() {
            this.f12842a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.b.e
        public void b() {
            this.f12842a.a(FloatingActionButton.this);
        }
    }

    public static abstract class b {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    private class c implements InterfaceC1048b {
        c() {
        }

        @Override // s1.InterfaceC1048b
        public void a(int i5, int i6, int i7, int i8) {
            FloatingActionButton.this.f12835l.set(i5, i6, i7, i8);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i5 + floatingActionButton.f12832i, i6 + FloatingActionButton.this.f12832i, i7 + FloatingActionButton.this.f12832i, i8 + FloatingActionButton.this.f12832i);
        }

        @Override // s1.InterfaceC1048b
        public boolean b() {
            return FloatingActionButton.this.f12834k;
        }

        @Override // s1.InterfaceC1048b
        public void g(Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }
    }

    class d<T extends FloatingActionButton> implements b.d {
        d(k<T> kVar) {
        }

        @Override // com.google.android.material.floatingactionbutton.b.d
        public void a() {
            throw null;
        }

        @Override // com.google.android.material.floatingactionbutton.b.d
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

    private com.google.android.material.floatingactionbutton.b getImpl() {
        if (this.f12838o == null) {
            this.f12838o = new com.google.android.material.floatingactionbutton.b(this, new c());
        }
        return this.f12838o;
    }

    private int i(int i5) {
        int i6 = this.f12831h;
        if (i6 != 0) {
            return i6;
        }
        Resources resources = getResources();
        return i5 != -1 ? i5 != 1 ? resources.getDimensionPixelSize(C0411d.f6778d) : resources.getDimensionPixelSize(C0411d.f6776c) : Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? i(1) : i(0);
    }

    private void j(Rect rect) {
        h(rect);
        int i5 = -this.f12838o.v();
        rect.inset(i5, i5);
    }

    private void o(Rect rect) {
        int i5 = rect.left;
        Rect rect2 = this.f12835l;
        rect.left = i5 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    private void p() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f12827d;
        if (colorStateList == null) {
            androidx.core.graphics.drawable.a.c(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f12828e;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(C0441k.e(colorForState, mode));
    }

    private b.e s(b bVar) {
        if (bVar == null) {
            return null;
        }
        return new a(bVar);
    }

    @Override // m1.InterfaceC0857a
    public boolean a() {
        throw null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
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
        return this.f12825b;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f12826c;
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
        return this.f12831h;
    }

    public int getExpandedComponentIdHint() {
        throw null;
    }

    public h getHideMotionSpec() {
        return getImpl().p();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f12829f;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f12829f;
    }

    public l getShapeAppearanceModel() {
        return (l) D.h.e(getImpl().t());
    }

    public h getShowMotionSpec() {
        return getImpl().u();
    }

    public int getSize() {
        return this.f12830g;
    }

    int getSizeDimension() {
        return i(this.f12830g);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f12827d;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f12828e;
    }

    public boolean getUseCompatPadding() {
        return this.f12834k;
    }

    public void h(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        o(rect);
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
    }

    public void k(b bVar) {
        l(bVar, true);
    }

    void l(b bVar, boolean z5) {
        getImpl().w(s(bVar), z5);
    }

    public boolean m() {
        return getImpl().y();
    }

    public boolean n() {
        return getImpl().z();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().A();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().C();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i5, int i6) {
        int sizeDimension = getSizeDimension();
        this.f12832i = (sizeDimension - this.f12833j) / 2;
        getImpl().Y();
        int iMin = Math.min(View.resolveSize(sizeDimension, i5), View.resolveSize(sizeDimension, i6));
        Rect rect = this.f12835l;
        setMeasuredDimension(rect.left + iMin + rect.right, iMin + rect.top + rect.bottom);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C1181a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C1181a c1181a = (C1181a) parcelable;
        super.onRestoreInstanceState(c1181a.getSuperState());
        throw null;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        new C1181a(parcelableOnSaveInstanceState);
        throw null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            j(this.f12836m);
            if (!this.f12836m.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void q(b bVar) {
        r(bVar, true);
    }

    void r(b bVar, boolean z5) {
        getImpl().W(s(bVar), z5);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i5) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f12825b != colorStateList) {
            this.f12825b = colorStateList;
            getImpl().H(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f12826c != mode) {
            this.f12826c = mode;
            getImpl().I(mode);
        }
    }

    public void setCompatElevation(float f5) {
        getImpl().J(f5);
    }

    public void setCompatElevationResource(int i5) {
        setCompatElevation(getResources().getDimension(i5));
    }

    public void setCompatHoveredFocusedTranslationZ(float f5) {
        getImpl().M(f5);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i5) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i5));
    }

    public void setCompatPressedTranslationZ(float f5) {
        getImpl().P(f5);
    }

    public void setCompatPressedTranslationZResource(int i5) {
        setCompatPressedTranslationZ(getResources().getDimension(i5));
    }

    public void setCustomSize(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i5 != this.f12831h) {
            this.f12831h = i5;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setElevation(float f5) {
        super.setElevation(f5);
        getImpl().Z(f5);
    }

    public void setEnsureMinTouchTargetSize(boolean z5) {
        if (z5 != getImpl().o()) {
            getImpl().K(z5);
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i5) {
        throw null;
    }

    public void setHideMotionSpec(h hVar) {
        getImpl().L(hVar);
    }

    public void setHideMotionSpecResource(int i5) {
        setHideMotionSpec(h.c(getContext(), i5));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().X();
            if (this.f12827d != null) {
                p();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i5) {
        this.f12837n.i(i5);
        p();
    }

    public void setMaxImageSize(int i5) {
        this.f12833j = i5;
        getImpl().O(i5);
    }

    public void setRippleColor(int i5) {
        setRippleColor(ColorStateList.valueOf(i5));
    }

    @Override // android.view.View
    public void setScaleX(float f5) {
        super.setScaleX(f5);
        getImpl().F();
    }

    @Override // android.view.View
    public void setScaleY(float f5) {
        super.setScaleY(f5);
        getImpl().F();
    }

    public void setShadowPaddingEnabled(boolean z5) {
        getImpl().R(z5);
    }

    @Override // t1.o
    public void setShapeAppearanceModel(l lVar) {
        getImpl().S(lVar);
    }

    public void setShowMotionSpec(h hVar) {
        getImpl().T(hVar);
    }

    public void setShowMotionSpecResource(int i5) {
        setShowMotionSpec(h.c(getContext(), i5));
    }

    public void setSize(int i5) {
        this.f12831h = 0;
        if (i5 != this.f12830g) {
            this.f12830g = i5;
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
        if (this.f12827d != colorStateList) {
            this.f12827d = colorStateList;
            p();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f12828e != mode) {
            this.f12828e = mode;
            p();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f5) {
        super.setTranslationX(f5);
        getImpl().G();
    }

    @Override // android.view.View
    public void setTranslationY(float f5) {
        super.setTranslationY(f5);
        getImpl().G();
    }

    @Override // android.view.View
    public void setTranslationZ(float f5) {
        super.setTranslationZ(f5);
        getImpl().G();
    }

    public void setUseCompatPadding(boolean z5) {
        if (this.f12834k != z5) {
            this.f12834k = z5;
            getImpl().B();
        }
    }

    @Override // com.google.android.material.internal.s, android.widget.ImageView, android.view.View
    public void setVisibility(int i5) {
        super.setVisibility(i5);
    }

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: a, reason: collision with root package name */
        private Rect f12839a;

        /* renamed from: b, reason: collision with root package name */
        private b f12840b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f12841c;

        public BaseBehavior() {
            this.f12841c = true;
        }

        private boolean d(View view, FloatingActionButton floatingActionButton) {
            return (this.f12841c && ((CoordinatorLayout.f) floatingActionButton.getLayoutParams()).e() == view.getId() && floatingActionButton.getUserSetVisibility() == 0) ? false : true;
        }

        private static boolean e(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private void f(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            Rect rect = floatingActionButton.f12835l;
            if (rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
            int i5 = 0;
            int i6 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) fVar).rightMargin ? rect.right : floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) fVar).leftMargin ? -rect.left : 0;
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) {
                i5 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) fVar).topMargin) {
                i5 = -rect.top;
            }
            if (i5 != 0) {
                H.V(floatingActionButton, i5);
            }
            if (i6 != 0) {
                H.U(floatingActionButton, i6);
            }
        }

        private boolean i(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (d(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f12839a == null) {
                this.f12839a = new Rect();
            }
            Rect rect = this.f12839a;
            com.google.android.material.internal.c.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.l(this.f12840b, false);
                return true;
            }
            floatingActionButton.r(this.f12840b, false);
            return true;
        }

        private boolean j(View view, FloatingActionButton floatingActionButton) {
            if (d(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.l(this.f12840b, false);
                return true;
            }
            floatingActionButton.r(this.f12840b, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.f12835l;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                i(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!e(view)) {
                return false;
            }
            j(view, floatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i5) {
            List<View> listE = coordinatorLayout.E(floatingActionButton);
            int size = listE.size();
            for (int i6 = 0; i6 < size; i6++) {
                View view = listE.get(i6);
                if (!(view instanceof AppBarLayout)) {
                    if (e(view) && j(view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (i(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.W(floatingActionButton, i5);
            f(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
            if (fVar.f9432h == 0) {
                fVar.f9432h = 80;
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0418k.f7206s1);
            this.f12841c = typedArrayObtainStyledAttributes.getBoolean(C0418k.f7212t1, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f12829f != colorStateList) {
            this.f12829f = colorStateList;
            getImpl().Q(this.f12829f);
        }
    }
}
