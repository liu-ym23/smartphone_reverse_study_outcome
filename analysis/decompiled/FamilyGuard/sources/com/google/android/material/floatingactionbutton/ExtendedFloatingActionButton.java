package com.google.android.material.floatingactionbutton;

import a1.C0417j;
import a1.C0418k;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b1.h;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import java.util.List;

/* loaded from: classes.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {

    /* renamed from: W, reason: collision with root package name */
    private static final int f12807W = C0417j.f6929t;

    /* renamed from: a0, reason: collision with root package name */
    static final Property<View, Float> f12808a0 = new a(Float.class, "width");

    /* renamed from: b0, reason: collision with root package name */
    static final Property<View, Float> f12809b0 = new b(Float.class, "height");

    /* renamed from: c0, reason: collision with root package name */
    static final Property<View, Float> f12810c0 = new c(Float.class, "paddingStart");

    /* renamed from: d0, reason: collision with root package name */
    static final Property<View, Float> f12811d0 = new d(Float.class, "paddingEnd");

    /* renamed from: K, reason: collision with root package name */
    private boolean f12812K;

    /* renamed from: L, reason: collision with root package name */
    private final int f12813L;

    /* renamed from: M, reason: collision with root package name */
    private int f12814M;

    /* renamed from: Q, reason: collision with root package name */
    private int f12815Q;

    /* renamed from: R, reason: collision with root package name */
    private final CoordinatorLayout.c<ExtendedFloatingActionButton> f12816R;

    /* renamed from: S, reason: collision with root package name */
    private boolean f12817S;

    /* renamed from: T, reason: collision with root package name */
    private boolean f12818T;

    /* renamed from: U, reason: collision with root package name */
    private boolean f12819U;

    /* renamed from: V, reason: collision with root package name */
    protected ColorStateList f12820V;

    class a extends Property<View, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f5) {
            view.getLayoutParams().width = f5.intValue();
            view.requestLayout();
        }
    }

    class b extends Property<View, Float> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f5) {
            view.getLayoutParams().height = f5.intValue();
            view.requestLayout();
        }
    }

    class c extends Property<View, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getPaddingStart());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f5) {
            view.setPaddingRelative(f5.intValue(), view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom());
        }
    }

    class d extends Property<View, Float> {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getPaddingEnd());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f5) {
            view.setPaddingRelative(view.getPaddingStart(), view.getPaddingTop(), f5.intValue(), view.getPaddingBottom());
        }
    }

    public static abstract class e {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i5, e eVar) {
        if (i5 == 0 || i5 == 1 || i5 == 2 || i5 == 3) {
            throw null;
        }
        throw new IllegalStateException("Unknown strategy type: " + i5);
    }

    private void v() {
        this.f12820V = getTextColors();
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "com.google.android.material.floatingactionbutton.FloatingActionButton";
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<ExtendedFloatingActionButton> getBehavior() {
        return this.f12816R;
    }

    int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    int getCollapsedSize() {
        int i5 = this.f12813L;
        return i5 < 0 ? (Math.min(getPaddingStart(), getPaddingEnd()) * 2) + getIconSize() : i5;
    }

    public h getExtendMotionSpec() {
        throw null;
    }

    public h getHideMotionSpec() {
        throw null;
    }

    public h getShowMotionSpec() {
        throw null;
    }

    public h getShrinkMotionSpec() {
        throw null;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f12817S && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.f12817S = false;
            throw null;
        }
    }

    public void setAnimateShowBeforeLayout(boolean z5) {
        this.f12819U = z5;
    }

    public void setAnimationEnabled(boolean z5) {
        this.f12812K = z5;
    }

    public void setExtendMotionSpec(h hVar) {
        throw null;
    }

    public void setExtendMotionSpecResource(int i5) {
        setExtendMotionSpec(h.c(getContext(), i5));
    }

    public void setExtended(boolean z5) {
        if (this.f12817S != z5) {
            throw null;
        }
    }

    public void setHideMotionSpec(h hVar) {
        throw null;
    }

    public void setHideMotionSpecResource(int i5) {
        setHideMotionSpec(h.c(getContext(), i5));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i5, int i6, int i7, int i8) {
        super.setPadding(i5, i6, i7, i8);
        if (!this.f12817S || this.f12818T) {
            return;
        }
        this.f12814M = getPaddingStart();
        this.f12815Q = getPaddingEnd();
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i5, int i6, int i7, int i8) {
        super.setPaddingRelative(i5, i6, i7, i8);
        if (!this.f12817S || this.f12818T) {
            return;
        }
        this.f12814M = i5;
        this.f12815Q = i7;
    }

    public void setShowMotionSpec(h hVar) {
        throw null;
    }

    public void setShowMotionSpecResource(int i5) {
        setShowMotionSpec(h.c(getContext(), i5));
    }

    public void setShrinkMotionSpec(h hVar) {
        throw null;
    }

    public void setShrinkMotionSpecResource(int i5) {
        setShrinkMotionSpec(h.c(getContext(), i5));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i5) {
        super.setTextColor(i5);
        v();
    }

    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: a, reason: collision with root package name */
        private Rect f12821a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f12822b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f12823c;

        public ExtendedFloatingActionButtonBehavior() {
            this.f12822b = false;
            this.f12823c = true;
        }

        private static boolean e(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean h(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.f12822b || this.f12823c) && ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams()).e() == view.getId();
        }

        private boolean j(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!h(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f12821a == null) {
                this.f12821a = new Rect();
            }
            Rect rect = this.f12821a;
            com.google.android.material.internal.c.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                i(extendedFloatingActionButton);
                return true;
            }
            c(extendedFloatingActionButton);
            return true;
        }

        private boolean k(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!h(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                i(extendedFloatingActionButton);
                return true;
            }
            c(extendedFloatingActionButton);
            return true;
        }

        protected void c(ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.u(this.f12823c ? 3 : 0, null);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                j(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!e(view)) {
                return false;
            }
            k(view, extendedFloatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i5) {
            List<View> listE = coordinatorLayout.E(extendedFloatingActionButton);
            int size = listE.size();
            for (int i6 = 0; i6 < size; i6++) {
                View view = listE.get(i6);
                if (!(view instanceof AppBarLayout)) {
                    if (e(view) && k(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (j(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.W(extendedFloatingActionButton, i5);
            return true;
        }

        protected void i(ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.u(this.f12823c ? 2 : 1, null);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
            if (fVar.f9432h == 0) {
                fVar.f9432h = 80;
            }
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0418k.f7182o1);
            this.f12822b = typedArrayObtainStyledAttributes.getBoolean(C0418k.f7188p1, false);
            this.f12823c = typedArrayObtainStyledAttributes.getBoolean(C0418k.f7194q1, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        v();
    }
}
