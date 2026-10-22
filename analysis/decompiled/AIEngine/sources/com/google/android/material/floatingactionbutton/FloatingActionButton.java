package com.google.android.material.floatingactionbutton;

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
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomappbar.b;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.d;
import com.google.android.material.internal.n;
import com.google.android.material.stateful.ExtendableSavedState;
import com.stepos.aiengine.R;
import java.util.ArrayList;
import y4.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FloatingActionButton extends n implements t4.a, y4.n, CoordinatorLayout.b {

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f5000b;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f5001c;

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f5002d;

    /* renamed from: e, reason: collision with root package name */
    public PorterDuff.Mode f5003e;
    public ColorStateList h;

    /* renamed from: j, reason: collision with root package name */
    public int f5004j;

    /* renamed from: k, reason: collision with root package name */
    public int f5005k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5006l;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b<T extends FloatingActionButton> implements d.a {
        @Override // com.google.android.material.floatingactionbutton.d.a
        public final void a() {
            throw null;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof b) {
                throw null;
            }
            return false;
        }

        public final int hashCode() {
            throw null;
        }
    }

    private d getImpl() {
        return null;
    }

    @Override // t4.a
    public final boolean a() {
        throw null;
    }

    public final void b() {
        d impl = getImpl();
        if (impl.f5030m == null) {
            impl.f5030m = new ArrayList<>();
        }
        impl.f5030m.add(null);
    }

    public final void c(com.google.android.material.bottomappbar.c cVar) {
        d impl = getImpl();
        if (impl.f5029l == null) {
            impl.f5029l = new ArrayList<>();
        }
        impl.f5029l.add(cVar);
    }

    public final void d() {
        d impl = getImpl();
        b bVar = new b();
        if (impl.f5031n == null) {
            impl.f5031n = new ArrayList<>();
        }
        impl.f5031n.add(bVar);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public final int e(int i10) {
        int i11 = this.f5005k;
        if (i11 != 0) {
            return i11;
        }
        Resources resources = getResources();
        return i10 != -1 ? i10 != 1 ? resources.getDimensionPixelSize(R.dimen.design_fab_size_normal) : resources.getDimensionPixelSize(R.dimen.design_fab_size_mini) : Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? e(1) : e(0);
    }

    public final void f(com.google.android.material.bottomappbar.b bVar, boolean z) {
        d impl = getImpl();
        if (bVar != null) {
            new com.google.android.material.floatingactionbutton.a(this, bVar);
        }
        impl.getClass();
        throw null;
    }

    public final boolean g() {
        getImpl().getClass();
        throw null;
    }

    @Override // android.widget.ImageButton, android.widget.ImageView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "com.google.android.material.floatingactionbutton.FloatingActionButton";
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f5000b;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f5001c;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        getImpl().getClass();
        throw null;
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().f5022d;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().f5023e;
    }

    public Drawable getContentBackground() {
        getImpl().getClass();
        return null;
    }

    public int getCustomSize() {
        return this.f5005k;
    }

    public int getExpandedComponentIdHint() {
        throw null;
    }

    public l4.c getHideMotionSpec() {
        return getImpl().h;
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.h;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.h;
    }

    public j getShapeAppearanceModel() {
        j jVar = getImpl().f5019a;
        jVar.getClass();
        return jVar;
    }

    public l4.c getShowMotionSpec() {
        return getImpl().f5025g;
    }

    public int getSize() {
        return this.f5004j;
    }

    public int getSizeDimension() {
        return e(this.f5004j);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f5002d;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f5003e;
    }

    public boolean getUseCompatPadding() {
        return this.f5006l;
    }

    public final boolean h() {
        getImpl().getClass();
        throw null;
    }

    public final void i() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f5002d;
        if (colorStateList == null) {
            drawable.clearColorFilter();
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f5003e;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(androidx.appcompat.widget.j.c(colorForState, mode));
    }

    public final void j(b.a aVar, boolean z) {
        d impl = getImpl();
        if (aVar != null) {
            new com.google.android.material.floatingactionbutton.a(this, aVar);
        }
        impl.getClass();
        throw null;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().getClass();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().getClass();
        throw null;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i10, int i11) {
        getSizeDimension();
        getImpl().f();
        throw null;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.getSuperState());
        extendableSavedState.extendableStates.get("expandableWidgetHelper").getClass();
        throw null;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        new ExtendableSavedState(parcelableOnSaveInstanceState);
        throw null;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return super.onTouchEvent(motionEvent);
        }
        getMeasuredWidth();
        getMeasuredHeight();
        throw null;
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
        if (this.f5000b != colorStateList) {
            this.f5000b = colorStateList;
            getImpl().getClass();
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f5001c != mode) {
            this.f5001c = mode;
            getImpl().getClass();
        }
    }

    public void setCompatElevation(float f8) {
        d impl = getImpl();
        if (impl.f5021c != f8) {
            impl.f5021c = f8;
            impl.d(f8, impl.f5022d, impl.f5023e);
        }
    }

    public void setCompatElevationResource(int i10) {
        setCompatElevation(getResources().getDimension(i10));
    }

    public void setCompatHoveredFocusedTranslationZ(float f8) {
        d impl = getImpl();
        if (impl.f5022d != f8) {
            impl.f5022d = f8;
            impl.d(impl.f5021c, f8, impl.f5023e);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(int i10) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i10));
    }

    public void setCompatPressedTranslationZ(float f8) {
        d impl = getImpl();
        if (impl.f5023e != f8) {
            impl.f5023e = f8;
            impl.d(impl.f5021c, impl.f5022d, f8);
        }
    }

    public void setCompatPressedTranslationZResource(int i10) {
        setCompatPressedTranslationZ(getResources().getDimension(i10));
    }

    public void setCustomSize(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i10 != this.f5005k) {
            this.f5005k = i10;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setElevation(float f8) {
        super.setElevation(f8);
        getImpl().getClass();
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().f5020b) {
            getImpl().f5020b = z;
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i10) {
        throw null;
    }

    public void setHideMotionSpec(l4.c cVar) {
        getImpl().h = cVar;
    }

    public void setHideMotionSpecResource(int i10) {
        setHideMotionSpec(l4.c.a(i10, getContext()));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() == drawable) {
            return;
        }
        super.setImageDrawable(drawable);
        d impl = getImpl();
        float f8 = impl.f5026i;
        impl.f5026i = f8;
        impl.a(f8, null);
        throw null;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        throw null;
    }

    public void setMaxImageSize(int i10) {
        d impl = getImpl();
        if (impl.f5027j == i10) {
            return;
        }
        impl.f5027j = i10;
        float f8 = impl.f5026i;
        impl.f5026i = f8;
        impl.a(f8, null);
        throw null;
    }

    public void setRippleColor(int i10) {
        setRippleColor(ColorStateList.valueOf(i10));
    }

    @Override // android.view.View
    public void setScaleX(float f8) {
        super.setScaleX(f8);
        ArrayList<d.a> arrayList = getImpl().f5031n;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).a();
        throw null;
    }

    @Override // android.view.View
    public void setScaleY(float f8) {
        super.setScaleY(f8);
        ArrayList<d.a> arrayList = getImpl().f5031n;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).a();
        throw null;
    }

    public void setShadowPaddingEnabled(boolean z) {
        d impl = getImpl();
        impl.getClass();
        impl.f();
        throw null;
    }

    @Override // y4.n
    public void setShapeAppearanceModel(j jVar) {
        getImpl().f5019a = jVar;
    }

    public void setShowMotionSpec(l4.c cVar) {
        getImpl().f5025g = cVar;
    }

    public void setShowMotionSpecResource(int i10) {
        setShowMotionSpec(l4.c.a(i10, getContext()));
    }

    public void setSize(int i10) {
        this.f5005k = 0;
        if (i10 != this.f5004j) {
            this.f5004j = i10;
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
        if (this.f5002d != colorStateList) {
            this.f5002d = colorStateList;
            i();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f5003e != mode) {
            this.f5003e = mode;
            i();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f8) {
        super.setTranslationX(f8);
        getImpl().e();
    }

    @Override // android.view.View
    public void setTranslationY(float f8) {
        super.setTranslationY(f8);
        getImpl().e();
    }

    @Override // android.view.View
    public void setTranslationZ(float f8) {
        super.setTranslationZ(f8);
        getImpl().e();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f5006l == z) {
            return;
        }
        this.f5006l = z;
        getImpl().f();
        throw null;
    }

    @Override // com.google.android.material.internal.n, android.widget.ImageView, android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: a, reason: collision with root package name */
        public Rect f5007a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f5008b;

        public BaseBehavior() {
            this.f5008b = true;
        }

        public final boolean g(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
            if (!this.f5008b || fVar.f1461f != appBarLayout.getId() || floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            if (this.f5007a == null) {
                this.f5007a = new Rect();
            }
            Rect rect = this.f5007a;
            com.google.android.material.internal.c.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.f(null, false);
                return true;
            }
            floatingActionButton.j(null, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            floatingActionButton.getClass();
            floatingActionButton.getLeft();
            throw null;
        }

        public final boolean h(View view, FloatingActionButton floatingActionButton) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
            if (!this.f5008b || fVar.f1461f != view.getId() || floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.f(null, false);
                return true;
            }
            floatingActionButton.j(null, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
            if (fVar.h == 0) {
                fVar.h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                g(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).f1456a instanceof BottomSheetBehavior : false) {
                    h(view2, floatingActionButton);
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i10) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            ArrayList arrayListV = coordinatorLayout.v(floatingActionButton);
            int size = arrayListV.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view2 = (View) arrayListV.get(i11);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).f1456a instanceof BottomSheetBehavior : false) && h(view2, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (g(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.B(i10, floatingActionButton);
            throw null;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k4.a.f9906k);
            this.f5008b = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.h != colorStateList) {
            this.h = colorStateList;
            getImpl().getClass();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class a {
        public void b() {
        }

        public void a(FloatingActionButton floatingActionButton) {
        }
    }
}
