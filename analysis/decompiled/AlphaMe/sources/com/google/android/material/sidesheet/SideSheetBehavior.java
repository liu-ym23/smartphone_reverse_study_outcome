package com.google.android.material.sidesheet;

import A.b;
import A.d;
import B0.f;
import B0.g;
import K.S;
import L.r;
import Q.e;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.google.android.gms.common.api.internal.k;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.stepos.alphame.R;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import m1.AbstractC0769a;
import y1.j;
import y1.n;
import z1.C1004a;
import z1.c;

/* loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends b {

    /* renamed from: a, reason: collision with root package name */
    public C1004a f10878a;

    /* renamed from: b, reason: collision with root package name */
    public final j f10879b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorStateList f10880c;

    /* renamed from: d, reason: collision with root package name */
    public final n f10881d;

    /* renamed from: e, reason: collision with root package name */
    public final k f10882e;

    /* renamed from: f, reason: collision with root package name */
    public final float f10883f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f10884g;

    /* renamed from: h, reason: collision with root package name */
    public int f10885h;

    /* renamed from: i, reason: collision with root package name */
    public e f10886i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10887j;

    /* renamed from: k, reason: collision with root package name */
    public final float f10888k;

    /* renamed from: l, reason: collision with root package name */
    public int f10889l;

    /* renamed from: m, reason: collision with root package name */
    public int f10890m;

    /* renamed from: n, reason: collision with root package name */
    public int f10891n;

    /* renamed from: o, reason: collision with root package name */
    public int f10892o;

    /* renamed from: p, reason: collision with root package name */
    public WeakReference f10893p;

    /* renamed from: q, reason: collision with root package name */
    public WeakReference f10894q;

    /* renamed from: r, reason: collision with root package name */
    public final int f10895r;

    /* renamed from: s, reason: collision with root package name */
    public VelocityTracker f10896s;

    /* renamed from: t, reason: collision with root package name */
    public int f10897t;

    /* renamed from: u, reason: collision with root package name */
    public final LinkedHashSet f10898u;

    /* renamed from: v, reason: collision with root package name */
    public final c f10899v;

    public SideSheetBehavior() {
        this.f10882e = new k(this);
        this.f10884g = true;
        this.f10885h = 5;
        this.f10888k = 0.1f;
        this.f10895r = -1;
        this.f10898u = new LinkedHashSet();
        this.f10899v = new c(this);
    }

    public final void c(int i4) {
        View view;
        if (this.f10885h == i4) {
            return;
        }
        this.f10885h = i4;
        WeakReference weakReference = this.f10893p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i5 = this.f10885h == 5 ? 4 : 0;
        if (view.getVisibility() != i5) {
            view.setVisibility(i5);
        }
        Iterator it = this.f10898u.iterator();
        if (it.hasNext()) {
            g.y(it.next());
            throw null;
        }
        f();
    }

    public final boolean d() {
        return this.f10886i != null && (this.f10884g || this.f10885h == 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        if (r1.o(r0, r3.getTop()) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
    
        if (r3 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
    
        c(2);
        r2.f10882e.a(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(android.view.View r3, int r4, boolean r5) {
        /*
            r2 = this;
            r0 = 3
            if (r4 == r0) goto L19
            r0 = 5
            if (r4 != r0) goto Ld
            z1.a r0 = r2.f10878a
            int r0 = r0.l()
            goto L1f
        Ld:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Invalid state to get outer edge offset: "
            java.lang.String r3 = androidx.room.AbstractC0351g.m(r3, r4)
            r2.<init>(r3)
            throw r2
        L19:
            z1.a r0 = r2.f10878a
            int r0 = r0.k()
        L1f:
            Q.e r1 = r2.f10886i
            if (r1 == 0) goto L57
            if (r5 == 0) goto L30
            int r3 = r3.getTop()
            boolean r3 = r1.o(r0, r3)
            if (r3 == 0) goto L57
            goto L4d
        L30:
            int r5 = r3.getTop()
            r1.f1622r = r3
            r3 = -1
            r1.f1607c = r3
            r3 = 0
            boolean r3 = r1.h(r0, r5, r3, r3)
            if (r3 != 0) goto L4b
            int r5 = r1.f1605a
            if (r5 != 0) goto L4b
            android.view.View r5 = r1.f1622r
            if (r5 == 0) goto L4b
            r5 = 0
            r1.f1622r = r5
        L4b:
            if (r3 == 0) goto L57
        L4d:
            r3 = 2
            r2.c(r3)
            com.google.android.gms.common.api.internal.k r2 = r2.f10882e
            r2.a(r4)
            goto L5a
        L57:
            r2.c(r4)
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.e(android.view.View, int, boolean):void");
    }

    public final void f() {
        View view;
        WeakReference weakReference = this.f10893p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        S.f(262144, view);
        S.d(0, view);
        S.f(BmLocated.ALIGN_TOP, view);
        S.d(0, view);
        final int i4 = 5;
        if (this.f10885h != 5) {
            S.g(view, L.b.f1134j, new r() { // from class: z1.b
                @Override // L.r
                public final boolean a(View view2) {
                    SideSheetBehavior sideSheetBehavior = this.f16414a;
                    sideSheetBehavior.getClass();
                    int i5 = 1;
                    int i6 = i4;
                    if (i6 == 1 || i6 == 2) {
                        throw new IllegalArgumentException(g.r(new StringBuilder("STATE_"), i6 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
                    }
                    WeakReference weakReference2 = sideSheetBehavior.f10893p;
                    if (weakReference2 == null || weakReference2.get() == null) {
                        sideSheetBehavior.c(i6);
                    } else {
                        View view3 = (View) sideSheetBehavior.f10893p.get();
                        C.n nVar = new C.n(i6, i5, sideSheetBehavior);
                        ViewParent parent = view3.getParent();
                        if (parent != null && parent.isLayoutRequested() && view3.isAttachedToWindow()) {
                            view3.post(nVar);
                        } else {
                            nVar.run();
                        }
                    }
                    return true;
                }
            });
        }
        final int i5 = 3;
        if (this.f10885h != 3) {
            S.g(view, L.b.f1132h, new r() { // from class: z1.b
                @Override // L.r
                public final boolean a(View view2) {
                    SideSheetBehavior sideSheetBehavior = this.f16414a;
                    sideSheetBehavior.getClass();
                    int i52 = 1;
                    int i6 = i5;
                    if (i6 == 1 || i6 == 2) {
                        throw new IllegalArgumentException(g.r(new StringBuilder("STATE_"), i6 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
                    }
                    WeakReference weakReference2 = sideSheetBehavior.f10893p;
                    if (weakReference2 == null || weakReference2.get() == null) {
                        sideSheetBehavior.c(i6);
                    } else {
                        View view3 = (View) sideSheetBehavior.f10893p.get();
                        C.n nVar = new C.n(i6, i52, sideSheetBehavior);
                        ViewParent parent = view3.getParent();
                        if (parent != null && parent.isLayoutRequested() && view3.isAttachedToWindow()) {
                            view3.post(nVar);
                        } else {
                            nVar.run();
                        }
                    }
                    return true;
                }
            });
        }
    }

    @Override // A.b
    public final void onAttachedToLayoutParams(d dVar) {
        super.onAttachedToLayoutParams(dVar);
        this.f10893p = null;
        this.f10886i = null;
    }

    @Override // A.b
    public final void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.f10893p = null;
        this.f10886i = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
    @Override // A.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r3, android.view.View r4, android.view.MotionEvent r5) {
        /*
            r2 = this;
            boolean r3 = r4.isShown()
            r0 = 1
            r1 = 0
            if (r3 != 0) goto L10
            java.util.WeakHashMap r3 = K.S.f939a
            java.lang.CharSequence r3 = K.N.b(r4)
            if (r3 == 0) goto L5a
        L10:
            boolean r3 = r2.f10884g
            if (r3 == 0) goto L5a
            int r3 = r5.getActionMasked()
            if (r3 != 0) goto L24
            android.view.VelocityTracker r4 = r2.f10896s
            if (r4 == 0) goto L24
            r4.recycle()
            r4 = 0
            r2.f10896s = r4
        L24:
            android.view.VelocityTracker r4 = r2.f10896s
            if (r4 != 0) goto L2e
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r2.f10896s = r4
        L2e:
            android.view.VelocityTracker r4 = r2.f10896s
            r4.addMovement(r5)
            if (r3 == 0) goto L42
            if (r3 == r0) goto L3b
            r4 = 3
            if (r3 == r4) goto L3b
            goto L49
        L3b:
            boolean r3 = r2.f10887j
            if (r3 == 0) goto L49
            r2.f10887j = r1
            return r1
        L42:
            float r3 = r5.getX()
            int r3 = (int) r3
            r2.f10897t = r3
        L49:
            boolean r3 = r2.f10887j
            if (r3 != 0) goto L58
            Q.e r2 = r2.f10886i
            if (r2 == 0) goto L58
            boolean r2 = r2.p(r5)
            if (r2 == 0) goto L58
            goto L59
        L58:
            r0 = r1
        L59:
            return r0
        L5a:
            r2.f10887j = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ce  */
    @Override // A.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout r10, android.view.View r11, int r12) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 614
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int):boolean");
    }

    @Override // A.b
    public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i4, int i5, int i6, int i7) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i4, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i5, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i6, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
        return true;
    }

    @Override // A.b
    public final void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        if (savedState.getSuperState() != null) {
            super.onRestoreInstanceState(coordinatorLayout, view, savedState.getSuperState());
        }
        int i4 = savedState.f10900a;
        if (i4 == 1 || i4 == 2) {
            i4 = 5;
        }
        this.f10885h = i4;
    }

    @Override // A.b
    public final Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, view), this);
    }

    @Override // A.b
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f10885h == 1 && actionMasked == 0) {
            return true;
        }
        if (d()) {
            this.f10886i.j(motionEvent);
        }
        if (actionMasked == 0 && (velocityTracker = this.f10896s) != null) {
            velocityTracker.recycle();
            this.f10896s = null;
        }
        if (this.f10896s == null) {
            this.f10896s = VelocityTracker.obtain();
        }
        this.f10896s.addMovement(motionEvent);
        if (d() && actionMasked == 2 && !this.f10887j && d()) {
            float fAbs = Math.abs(this.f10897t - motionEvent.getX());
            e eVar = this.f10886i;
            if (fAbs > eVar.f1606b) {
                eVar.b(motionEvent.getPointerId(motionEvent.getActionIndex()), view);
            }
        }
        return !this.f10887j;
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public final int f10900a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f10900a = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f10900a);
        }

        public SavedState(Parcelable parcelable, SideSheetBehavior sideSheetBehavior) {
            super(parcelable);
            this.f10900a = sideSheetBehavior.f10885h;
        }
    }

    public SideSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this.f10882e = new k(this);
        this.f10884g = true;
        this.f10885h = 5;
        this.f10888k = 0.1f;
        this.f10895r = -1;
        this.f10898u = new LinkedHashSet();
        this.f10899v = new c(this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0769a.f13529D);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.f10880c = f.y(context, typedArrayObtainStyledAttributes, 3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            this.f10881d = n.b(context, attributeSet, 0, R.style.Widget_Material3_SideSheet).a();
        }
        if (typedArrayObtainStyledAttributes.hasValue(5)) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(5, -1);
            this.f10895r = resourceId;
            WeakReference weakReference = this.f10894q;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.f10894q = null;
            WeakReference weakReference2 = this.f10893p;
            if (weakReference2 != null) {
                View view = (View) weakReference2.get();
                if (resourceId != -1 && view.isLaidOut()) {
                    view.requestLayout();
                }
            }
        }
        n nVar = this.f10881d;
        if (nVar != null) {
            j jVar = new j(nVar);
            this.f10879b = jVar;
            jVar.l(context);
            ColorStateList colorStateList = this.f10880c;
            if (colorStateList != null) {
                this.f10879b.o(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.f10879b.setTint(typedValue.data);
            }
        }
        this.f10883f = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        this.f10884g = typedArrayObtainStyledAttributes.getBoolean(4, true);
        typedArrayObtainStyledAttributes.recycle();
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
