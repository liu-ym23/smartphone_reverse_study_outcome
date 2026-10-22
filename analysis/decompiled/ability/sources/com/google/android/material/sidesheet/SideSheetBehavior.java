package com.google.android.material.sidesheet;

import D7.N;
import Z6.k;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import c3.AbstractC0873c;
import com.google.android.material.bottomsheet.f;
import com.stepos.ability.R;
import e3.C1412a;
import e3.o;
import e3.p;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes3.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a, reason: collision with root package name */
    public k f2509a;
    public final e3.k b;
    public final ColorStateList c;
    public final p d;
    public final f e;
    public final float f;
    public final boolean g;
    public int h;
    public ViewDragHelper i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2510j;
    public final float k;
    public int l;
    public int m;
    public int n;
    public int o;
    public WeakReference p;

    /* renamed from: q, reason: collision with root package name */
    public WeakReference f2511q;

    /* renamed from: r, reason: collision with root package name */
    public final int f2512r;

    /* renamed from: s, reason: collision with root package name */
    public VelocityTracker f2513s;

    /* renamed from: t, reason: collision with root package name */
    public int f2514t;
    public final LinkedHashSet u;

    /* renamed from: v, reason: collision with root package name */
    public final c f2515v;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new d();
        final int state;

        public SavedState(@NonNull Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, @NonNull SideSheetBehavior<?> sideSheetBehavior) {
            super(parcelable);
            this.state = sideSheetBehavior.h;
        }
    }

    public SideSheetBehavior() {
        this.e = new f(this);
        this.g = true;
        this.h = 5;
        this.k = 0.1f;
        this.f2512r = -1;
        this.u = new LinkedHashSet();
        this.f2515v = new c(this);
    }

    public final void c(int i) {
        View view;
        if (this.h == i) {
            return;
        }
        this.h = i;
        WeakReference weakReference = this.p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i6 = this.h == 5 ? 4 : 0;
        if (view.getVisibility() != i6) {
            view.setVisibility(i6);
        }
        Iterator it = this.u.iterator();
        if (it.hasNext()) {
            throw B7.a.f(it);
        }
        f();
    }

    public final boolean d() {
        if (this.i != null) {
            return this.g || this.h == 1;
        }
        return false;
    }

    public final void e(View view, int i, boolean z10) {
        int iX;
        if (i == 3) {
            iX = this.f2509a.x();
        } else {
            if (i != 5) {
                throw new IllegalArgumentException(B7.a.h(i, "Invalid state to get outer edge offset: "));
            }
            iX = this.f2509a.y();
        }
        ViewDragHelper viewDragHelper = this.i;
        if (viewDragHelper == null || (!z10 ? viewDragHelper.smoothSlideViewTo(view, iX, view.getTop()) : viewDragHelper.settleCapturedViewAt(iX, view.getTop()))) {
            c(i);
        } else {
            c(2);
            this.e.a(i);
        }
    }

    public final void f() {
        View view;
        WeakReference weakReference = this.p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(view, 262144);
        ViewCompat.removeAccessibilityAction(view, 1048576);
        final int i = 5;
        if (this.h != 5) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new AccessibilityViewCommand() { // from class: com.google.android.material.sidesheet.b
                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public final boolean perform(View view2, AccessibilityViewCommand.CommandArguments commandArguments) throws RemoteException {
                    int i6 = i;
                    if (i6 == 1 || i6 == 2) {
                        throw new IllegalArgumentException(B7.a.q(new StringBuilder("STATE_"), i6 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
                    }
                    SideSheetBehavior sideSheetBehavior = this.f2516a;
                    WeakReference weakReference2 = sideSheetBehavior.p;
                    if (weakReference2 == null || weakReference2.get() == null) {
                        sideSheetBehavior.c(i6);
                        return true;
                    }
                    View view3 = (View) sideSheetBehavior.p.get();
                    androidx.core.content.res.a aVar = new androidx.core.content.res.a(sideSheetBehavior, i6, 1);
                    ViewParent parent = view3.getParent();
                    if (parent != null && parent.isLayoutRequested() && view3.isAttachedToWindow()) {
                        view3.post(aVar);
                        return true;
                    }
                    aVar.run();
                    return true;
                }
            });
        }
        final int i6 = 3;
        if (this.h != 3) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, null, new AccessibilityViewCommand() { // from class: com.google.android.material.sidesheet.b
                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public final boolean perform(View view2, AccessibilityViewCommand.CommandArguments commandArguments) throws RemoteException {
                    int i62 = i6;
                    if (i62 == 1 || i62 == 2) {
                        throw new IllegalArgumentException(B7.a.q(new StringBuilder("STATE_"), i62 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
                    }
                    SideSheetBehavior sideSheetBehavior = this.f2516a;
                    WeakReference weakReference2 = sideSheetBehavior.p;
                    if (weakReference2 == null || weakReference2.get() == null) {
                        sideSheetBehavior.c(i62);
                        return true;
                    }
                    View view3 = (View) sideSheetBehavior.p.get();
                    androidx.core.content.res.a aVar = new androidx.core.content.res.a(sideSheetBehavior, i62, 1);
                    ViewParent parent = view3.getParent();
                    if (parent != null && parent.isLayoutRequested() && view3.isAttachedToWindow()) {
                        view3.post(aVar);
                        return true;
                    }
                    aVar.run();
                    return true;
                }
            });
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.p = null;
        this.i = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.p = null;
        this.i = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        VelocityTracker velocityTracker;
        if ((!view.isShown() && ViewCompat.getAccessibilityPaneTitle(view) == null) || !this.g) {
            this.f2510j = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && (velocityTracker = this.f2513s) != null) {
            velocityTracker.recycle();
            this.f2513s = null;
        }
        if (this.f2513s == null) {
            this.f2513s = VelocityTracker.obtain();
        }
        this.f2513s.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.f2514t = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.f2510j) {
            this.f2510j = false;
            return false;
        }
        return (this.f2510j || (viewDragHelper = this.i) == null || !viewDragHelper.shouldInterceptTouchEvent(motionEvent)) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) throws Resources.NotFoundException {
        View view2;
        View view3;
        int i6;
        View viewFindViewById;
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        int iB = 0;
        if (this.p == null) {
            this.p = new WeakReference(view);
            new PathInterpolator(0.1f, 0.1f, 0.0f, 1.0f);
            Context context = view.getContext();
            N.N(context, R.attr.motionDurationMedium2, 300);
            N.N(context, R.attr.motionDurationShort3, 150);
            N.N(context, R.attr.motionDurationShort2, 100);
            Resources resources = view.getResources();
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_y_distance);
            e3.k kVar = this.b;
            if (kVar != null) {
                view.setBackground(kVar);
                float elevation = this.f;
                if (elevation == -1.0f) {
                    elevation = view.getElevation();
                }
                this.b.p(elevation);
            } else {
                ColorStateList colorStateList = this.c;
                if (colorStateList != null) {
                    ViewCompat.setBackgroundTintList(view, colorStateList);
                }
            }
            int i10 = this.h == 5 ? 4 : 0;
            if (view.getVisibility() != i10) {
                view.setVisibility(i10);
            }
            f();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
            if (ViewCompat.getAccessibilityPaneTitle(view) == null) {
                ViewCompat.setAccessibilityPaneTitle(view, view.getResources().getString(R.string.side_sheet_accessibility_pane_title));
            }
        }
        int i11 = Gravity.getAbsoluteGravity(((CoordinatorLayout.LayoutParams) view.getLayoutParams()).gravity, i) == 3 ? 1 : 0;
        k kVar2 = this.f2509a;
        if (kVar2 == null || kVar2.E() != i11) {
            CoordinatorLayout.LayoutParams layoutParams = null;
            p pVar = this.d;
            if (i11 == 0) {
                this.f2509a = new a(this, 1);
                if (pVar != null) {
                    WeakReference weakReference = this.p;
                    if (weakReference != null && (view3 = (View) weakReference.get()) != null && (view3.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                        layoutParams = (CoordinatorLayout.LayoutParams) view3.getLayoutParams();
                    }
                    if (layoutParams == null || ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin <= 0) {
                        o oVarF = pVar.f();
                        oVarF.f = new C1412a(0.0f);
                        oVarF.g = new C1412a(0.0f);
                        p pVarA = oVarF.a();
                        e3.k kVar3 = this.b;
                        if (kVar3 != null) {
                            kVar3.setShapeAppearanceModel(pVarA);
                        }
                    }
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(i11, "Invalid sheet edge position value: ", ". Must be 0 or 1."));
                }
                this.f2509a = new a(this, 0);
                if (pVar != null) {
                    WeakReference weakReference2 = this.p;
                    if (weakReference2 != null && (view2 = (View) weakReference2.get()) != null && (view2.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                        layoutParams = (CoordinatorLayout.LayoutParams) view2.getLayoutParams();
                    }
                    if (layoutParams == null || ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin <= 0) {
                        o oVarF2 = pVar.f();
                        oVarF2.e = new C1412a(0.0f);
                        oVarF2.h = new C1412a(0.0f);
                        p pVarA2 = oVarF2.a();
                        e3.k kVar4 = this.b;
                        if (kVar4 != null) {
                            kVar4.setShapeAppearanceModel(pVarA2);
                        }
                    }
                }
            }
        }
        if (this.i == null) {
            this.i = ViewDragHelper.create(coordinatorLayout, this.f2515v);
        }
        int iB2 = this.f2509a.B(view);
        coordinatorLayout.onLayoutChild(view, i);
        this.m = coordinatorLayout.getWidth();
        this.n = this.f2509a.C(coordinatorLayout);
        this.l = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.o = marginLayoutParams != null ? this.f2509a.k(marginLayoutParams) : 0;
        int i12 = this.h;
        if (i12 == 1 || i12 == 2) {
            iB = iB2 - this.f2509a.B(view);
        } else if (i12 != 3) {
            if (i12 != 5) {
                throw new IllegalStateException("Unexpected value: " + this.h);
            }
            iB = this.f2509a.y();
        }
        ViewCompat.offsetLeftAndRight(view, iB);
        if (this.f2511q == null && (i6 = this.f2512r) != -1 && (viewFindViewById = coordinatorLayout.findViewById(i6)) != null) {
            this.f2511q = new WeakReference(viewFindViewById);
        }
        Iterator it = this.u.iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i6, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i6, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i10, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i11, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        if (savedState.getSuperState() != null) {
            super.onRestoreInstanceState(coordinatorLayout, view, savedState.getSuperState());
        }
        int i = savedState.state;
        if (i == 1 || i == 2) {
            i = 5;
        }
        this.h = i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, view), (SideSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.h == 1 && actionMasked == 0) {
            return true;
        }
        if (d()) {
            this.i.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0 && (velocityTracker = this.f2513s) != null) {
            velocityTracker.recycle();
            this.f2513s = null;
        }
        if (this.f2513s == null) {
            this.f2513s = VelocityTracker.obtain();
        }
        this.f2513s.addMovement(motionEvent);
        if (d() && actionMasked == 2 && !this.f2510j && d() && Math.abs(this.f2514t - motionEvent.getX()) > this.i.getTouchSlop()) {
            this.i.captureChildView(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f2510j;
    }

    public SideSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new f(this);
        this.g = true;
        this.h = 5;
        this.k = 0.1f;
        this.f2512r = -1;
        this.u = new LinkedHashSet();
        this.f2515v = new c(this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, P2.a.E);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.c = AbstractC0873c.a(context, typedArrayObtainStyledAttributes, 3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            this.d = p.b(context, attributeSet, 0, R.style.Widget_Material3_SideSheet).a();
        }
        if (typedArrayObtainStyledAttributes.hasValue(5)) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(5, -1);
            this.f2512r = resourceId;
            WeakReference weakReference = this.f2511q;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.f2511q = null;
            WeakReference weakReference2 = this.p;
            if (weakReference2 != null) {
                View view = (View) weakReference2.get();
                if (resourceId != -1 && view.isLaidOut()) {
                    view.requestLayout();
                }
            }
        }
        p pVar = this.d;
        if (pVar != null) {
            e3.k kVar = new e3.k(pVar);
            this.b = kVar;
            kVar.m(context);
            ColorStateList colorStateList = this.c;
            if (colorStateList != null) {
                this.b.q(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.b.setTint(typedValue.data);
            }
        }
        this.f = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        this.g = typedArrayObtainStyledAttributes.getBoolean(4, true);
        typedArrayObtainStyledAttributes.recycle();
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
