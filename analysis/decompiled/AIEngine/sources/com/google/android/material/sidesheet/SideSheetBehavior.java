package com.google.android.material.sidesheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Property;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.z0;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import c1.c;
import com.stepos.aiengine.R;
import com.stepos.core.ota.crypto.CryptoHeaderParser;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import mb.y;
import u4.h;
import u4.i;
import v0.e0;
import v0.h0;
import w0.b;
import y4.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.c<V> implements u4.b {

    /* renamed from: a, reason: collision with root package name */
    public d f5132a;

    /* renamed from: b, reason: collision with root package name */
    public final y4.g f5133b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorStateList f5134c;

    /* renamed from: d, reason: collision with root package name */
    public final j f5135d;

    /* renamed from: e, reason: collision with root package name */
    public final SideSheetBehavior<V>.c f5136e;
    public final float h;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f5137j;

    /* renamed from: k, reason: collision with root package name */
    public int f5138k;

    /* renamed from: l, reason: collision with root package name */
    public c1.c f5139l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5140m;

    /* renamed from: n, reason: collision with root package name */
    public final float f5141n;

    /* renamed from: o, reason: collision with root package name */
    public int f5142o;

    /* renamed from: p, reason: collision with root package name */
    public int f5143p;

    /* renamed from: q, reason: collision with root package name */
    public int f5144q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public WeakReference<V> f5145s;

    /* renamed from: t, reason: collision with root package name */
    public WeakReference<View> f5146t;

    /* renamed from: u, reason: collision with root package name */
    public final int f5147u;

    /* renamed from: v, reason: collision with root package name */
    public VelocityTracker f5148v;

    /* renamed from: w, reason: collision with root package name */
    public i f5149w;

    /* renamed from: x, reason: collision with root package name */
    public int f5150x;

    /* renamed from: y, reason: collision with root package name */
    public final LinkedHashSet f5151y;
    public final a z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        final int state;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i10) {
                return new SavedState[i10];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        }

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.state);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, SideSheetBehavior<?> sideSheetBehavior) {
            super(parcelable);
            this.state = sideSheetBehavior.f5138k;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends c.AbstractC0028c {
        public a() {
        }

        @Override // c1.c.AbstractC0028c
        public final int a(int i10, View view) {
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            return y.p(i10, sideSheetBehavior.f5132a.g(), sideSheetBehavior.f5132a.f());
        }

        @Override // c1.c.AbstractC0028c
        public final int b(int i10, View view) {
            return view.getTop();
        }

        @Override // c1.c.AbstractC0028c
        public final int c(View view) {
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            return sideSheetBehavior.f5142o + sideSheetBehavior.r;
        }

        @Override // c1.c.AbstractC0028c
        public final void h(int i10) {
            if (i10 == 1) {
                SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                if (sideSheetBehavior.f5137j) {
                    sideSheetBehavior.h(1);
                }
            }
        }

        @Override // c1.c.AbstractC0028c
        public final void i(View view, int i10, int i11) {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            WeakReference<View> weakReference = sideSheetBehavior.f5146t;
            View view2 = weakReference != null ? weakReference.get() : null;
            if (view2 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) != null) {
                sideSheetBehavior.f5132a.p(marginLayoutParams, view.getLeft(), view.getRight());
                view2.setLayoutParams(marginLayoutParams);
            }
            LinkedHashSet linkedHashSet = sideSheetBehavior.f5151y;
            if (linkedHashSet.isEmpty()) {
                return;
            }
            sideSheetBehavior.f5132a.b(i10);
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                ((com.google.android.material.sidesheet.c) it.next()).b();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
        @Override // c1.c.AbstractC0028c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void j(android.view.View r2, float r3, float r4) {
            /*
                r1 = this;
                com.google.android.material.sidesheet.SideSheetBehavior r1 = com.google.android.material.sidesheet.SideSheetBehavior.this
                com.google.android.material.sidesheet.d r0 = r1.f5132a
                boolean r0 = r0.k(r3)
                if (r0 == 0) goto Lb
                goto L53
            Lb:
                com.google.android.material.sidesheet.d r0 = r1.f5132a
                boolean r0 = r0.n(r2, r3)
                if (r0 == 0) goto L24
                com.google.android.material.sidesheet.d r0 = r1.f5132a
                boolean r3 = r0.m(r3, r4)
                if (r3 != 0) goto L55
                com.google.android.material.sidesheet.d r3 = r1.f5132a
                boolean r3 = r3.l(r2)
                if (r3 == 0) goto L53
                goto L55
            L24:
                r0 = 0
                int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r0 == 0) goto L36
                float r3 = java.lang.Math.abs(r3)
                float r4 = java.lang.Math.abs(r4)
                int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r3 <= 0) goto L36
                goto L55
            L36:
                int r3 = r2.getLeft()
                com.google.android.material.sidesheet.d r4 = r1.f5132a
                int r4 = r4.d()
                int r4 = r3 - r4
                int r4 = java.lang.Math.abs(r4)
                com.google.android.material.sidesheet.d r0 = r1.f5132a
                int r0 = r0.e()
                int r3 = r3 - r0
                int r3 = java.lang.Math.abs(r3)
                if (r4 >= r3) goto L55
            L53:
                r3 = 3
                goto L56
            L55:
                r3 = 5
            L56:
                r4 = 1
                r1.j(r2, r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.a.j(android.view.View, float, float):void");
        }

        @Override // c1.c.AbstractC0028c
        public final boolean k(int i10, View view) {
            WeakReference<V> weakReference;
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            return (sideSheetBehavior.f5138k == 1 || (weakReference = sideSheetBehavior.f5145s) == null || weakReference.get() != view) ? false : true;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            sideSheetBehavior.h(5);
            WeakReference<V> weakReference = sideSheetBehavior.f5145s;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            sideSheetBehavior.f5145s.get().requestLayout();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public int f5154a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f5155b;

        /* renamed from: c, reason: collision with root package name */
        public final z0 f5156c = new z0(this, 7);

        public c() {
        }

        public final void a(int i10) {
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            WeakReference<V> weakReference = sideSheetBehavior.f5145s;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f5154a = i10;
            if (this.f5155b) {
                return;
            }
            sideSheetBehavior.f5145s.get().postOnAnimation(this.f5156c);
            this.f5155b = true;
        }
    }

    public SideSheetBehavior() {
        this.f5136e = new c();
        this.f5137j = true;
        this.f5138k = 5;
        this.f5141n = 0.1f;
        this.f5147u = -1;
        this.f5151y = new LinkedHashSet();
        this.z = new a();
    }

    @Override // u4.b
    public final void a(b.a aVar) {
        i iVar = this.f5149w;
        if (iVar == null) {
            return;
        }
        iVar.f13148f = aVar;
    }

    @Override // u4.b
    public final void c() {
        i iVar = this.f5149w;
        if (iVar == null) {
            return;
        }
        V v3 = iVar.f13144b;
        if (iVar.f13148f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        b.a aVar = iVar.f13148f;
        iVar.f13148f = null;
        if (aVar == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(v3, (Property<V, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(v3, (Property<V, Float>) View.SCALE_Y, 1.0f));
        if (v3 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v3;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i10), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setDuration(iVar.f13147e);
        animatorSet.start();
    }

    @Override // u4.b
    public final void e(b.a aVar) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        i iVar = this.f5149w;
        if (iVar == null) {
            return;
        }
        d dVar = this.f5132a;
        int i10 = (dVar == null || dVar.j() == 0) ? 5 : 3;
        if (iVar.f13148f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        b.a aVar2 = iVar.f13148f;
        iVar.f13148f = aVar;
        if (aVar2 != null) {
            iVar.a(aVar.f2988c, aVar.f2989d == 0, i10);
        }
        WeakReference<V> weakReference = this.f5145s;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        V v3 = this.f5145s.get();
        WeakReference<View> weakReference2 = this.f5146t;
        View view = weakReference2 != null ? weakReference2.get() : null;
        if (view == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) == null) {
            return;
        }
        this.f5132a.o(marginLayoutParams, (int) ((v3.getScaleX() * this.f5142o) + this.r));
        view.requestLayout();
    }

    @Override // u4.b
    public final void f() {
        int i10;
        final ViewGroup.MarginLayoutParams marginLayoutParams;
        i iVar = this.f5149w;
        if (iVar == null) {
            return;
        }
        b.a aVar = iVar.f13148f;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
        iVar.f13148f = null;
        int i11 = 5;
        if (aVar == null || Build.VERSION.SDK_INT < 34) {
            g(5);
            return;
        }
        d dVar = this.f5132a;
        if (dVar != null && dVar.j() != 0) {
            i11 = 3;
        }
        b bVar = new b();
        WeakReference<View> weakReference = this.f5146t;
        final View view = weakReference != null ? weakReference.get() : null;
        if (view != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) != null) {
            final int iC = this.f5132a.c(marginLayoutParams);
            animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.sidesheet.g
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f5164a.f5132a.o(marginLayoutParams, l4.a.c(valueAnimator.getAnimatedFraction(), iC, 0));
                    view.requestLayout();
                }
            };
        }
        V v3 = iVar.f13144b;
        boolean z = aVar.f2989d == 0;
        boolean z3 = (Gravity.getAbsoluteGravity(i11, v3.getLayoutDirection()) & 3) == 3;
        float scaleX = v3.getScaleX() * v3.getWidth();
        ViewGroup.LayoutParams layoutParams = v3.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
            i10 = z3 ? marginLayoutParams2.leftMargin : marginLayoutParams2.rightMargin;
        } else {
            i10 = 0;
        }
        float f8 = scaleX + i10;
        Property property = View.TRANSLATION_X;
        if (z3) {
            f8 = -f8;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(v3, (Property<V, Float>) property, f8);
        if (animatorUpdateListener != null) {
            objectAnimatorOfFloat.addUpdateListener(animatorUpdateListener);
        }
        objectAnimatorOfFloat.setInterpolator(new o1.b());
        objectAnimatorOfFloat.setDuration(l4.a.c(aVar.f2988c, iVar.f13145c, iVar.f13146d));
        objectAnimatorOfFloat.addListener(new h(iVar, z, i11));
        objectAnimatorOfFloat.addListener(bVar);
        objectAnimatorOfFloat.start();
    }

    public final void g(int i10) {
        if (i10 == 1 || i10 == 2) {
            throw new IllegalArgumentException(ai.onnxruntime.a.o(new StringBuilder("STATE_"), i10 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        WeakReference<V> weakReference = this.f5145s;
        if (weakReference == null || weakReference.get() == null) {
            h(i10);
            return;
        }
        V v3 = this.f5145s.get();
        e eVar = new e(i10, 0, this);
        ViewParent parent = v3.getParent();
        if (parent != null && parent.isLayoutRequested() && v3.isAttachedToWindow()) {
            v3.post(eVar);
        } else {
            eVar.run();
        }
    }

    public final void h(int i10) {
        V v3;
        if (this.f5138k == i10) {
            return;
        }
        this.f5138k = i10;
        WeakReference<V> weakReference = this.f5145s;
        if (weakReference == null || (v3 = weakReference.get()) == null) {
            return;
        }
        int i11 = this.f5138k == 5 ? 4 : 0;
        if (v3.getVisibility() != i11) {
            v3.setVisibility(i11);
        }
        Iterator it = this.f5151y.iterator();
        while (it.hasNext()) {
            ((com.google.android.material.sidesheet.c) it.next()).a();
        }
        k();
    }

    public final boolean i() {
        if (this.f5139l != null) {
            return this.f5137j || this.f5138k == 1;
        }
        return false;
    }

    public final void j(View view, int i10, boolean z) {
        int iD;
        if (i10 == 3) {
            iD = this.f5132a.d();
        } else {
            if (i10 != 5) {
                throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(i10, "Invalid state to get outer edge offset: "));
            }
            iD = this.f5132a.e();
        }
        c1.c cVar = this.f5139l;
        if (cVar == null || (!z ? cVar.u(view, iD, view.getTop()) : cVar.s(iD, view.getTop()))) {
            h(i10);
        } else {
            h(2);
            this.f5136e.a(i10);
        }
    }

    public final void k() {
        V v3;
        WeakReference<V> weakReference = this.f5145s;
        if (weakReference == null || (v3 = weakReference.get()) == null) {
            return;
        }
        e0.h(262144, v3);
        e0.e(0, v3);
        e0.h(CryptoHeaderParser.MAX_BLOCK_SIZE, v3);
        e0.e(0, v3);
        if (this.f5138k != 5) {
            e0.i(v3, b.a.f13539j, new f(this, 5));
        }
        if (this.f5138k != 3) {
            e0.i(v3, b.a.h, new f(this, 3));
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
        super.onAttachedToLayoutParams(fVar);
        this.f5145s = null;
        this.f5139l = null;
        this.f5149w = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.f5145s = null;
        this.f5139l = null;
        this.f5149w = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0012  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r3, V r4, android.view.MotionEvent r5) {
        /*
            r2 = this;
            boolean r3 = r4.isShown()
            r0 = 1
            r1 = 0
            if (r3 != 0) goto L12
            java.util.WeakHashMap<android.view.View, v0.h0> r3 = v0.e0.f13274a
            java.lang.CharSequence r3 = v0.e0.g.a(r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L5b
        L12:
            boolean r3 = r2.f5137j
            if (r3 == 0) goto L5b
            int r3 = r5.getActionMasked()
            if (r3 != 0) goto L26
            android.view.VelocityTracker r4 = r2.f5148v
            if (r4 == 0) goto L26
            r4.recycle()
            r4 = 0
            r2.f5148v = r4
        L26:
            android.view.VelocityTracker r4 = r2.f5148v
            if (r4 != 0) goto L30
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r2.f5148v = r4
        L30:
            android.view.VelocityTracker r4 = r2.f5148v
            r4.addMovement(r5)
            if (r3 == 0) goto L44
            if (r3 == r0) goto L3d
            r4 = 3
            if (r3 == r4) goto L3d
            goto L4b
        L3d:
            boolean r3 = r2.f5140m
            if (r3 == 0) goto L4b
            r2.f5140m = r1
            return r1
        L44:
            float r3 = r5.getX()
            int r3 = (int) r3
            r2.f5150x = r3
        L4b:
            boolean r3 = r2.f5140m
            if (r3 != 0) goto L5a
            c1.c r2 = r2.f5139l
            if (r2 == 0) goto L5a
            boolean r2 = r2.t(r5)
            if (r2 == 0) goto L5a
            return r0
        L5a:
            return r1
        L5b:
            r2.f5140m = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v3, int i10) {
        V v7;
        V v8;
        int i11;
        View viewFindViewById;
        if (coordinatorLayout.getFitsSystemWindows() && !v3.getFitsSystemWindows()) {
            v3.setFitsSystemWindows(true);
        }
        WeakReference<V> weakReference = this.f5145s;
        y4.g gVar = this.f5133b;
        int iH = 0;
        if (weakReference == null) {
            this.f5145s = new WeakReference<>(v3);
            this.f5149w = new i(v3);
            if (gVar != null) {
                v3.setBackground(gVar);
                float elevation = this.h;
                if (elevation == -1.0f) {
                    elevation = v3.getElevation();
                }
                gVar.m(elevation);
            } else {
                ColorStateList colorStateList = this.f5134c;
                if (colorStateList != null) {
                    WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                    e0.d.h(v3, colorStateList);
                }
            }
            int i12 = this.f5138k == 5 ? 4 : 0;
            if (v3.getVisibility() != i12) {
                v3.setVisibility(i12);
            }
            k();
            if (v3.getImportantForAccessibility() == 0) {
                v3.setImportantForAccessibility(1);
            }
            WeakHashMap<View, h0> weakHashMap2 = e0.f13274a;
            if (e0.g.a(v3) == null) {
                e0.k(v3, v3.getResources().getString(R.string.side_sheet_accessibility_pane_title));
            }
        }
        int i13 = Gravity.getAbsoluteGravity(((CoordinatorLayout.f) v3.getLayoutParams()).f1458c, i10) == 3 ? 1 : 0;
        d dVar = this.f5132a;
        if (dVar == null || dVar.j() != i13) {
            CoordinatorLayout.f fVar = null;
            j jVar = this.f5135d;
            if (i13 == 0) {
                this.f5132a = new com.google.android.material.sidesheet.b(this);
                if (jVar != null) {
                    WeakReference<V> weakReference2 = this.f5145s;
                    if (weakReference2 != null && (v8 = weakReference2.get()) != null && (v8.getLayoutParams() instanceof CoordinatorLayout.f)) {
                        fVar = (CoordinatorLayout.f) v8.getLayoutParams();
                    }
                    if (fVar == null || ((ViewGroup.MarginLayoutParams) fVar).rightMargin <= 0) {
                        j.a aVarF = jVar.f();
                        aVarF.f(0.0f);
                        aVarF.d(0.0f);
                        j jVarA = aVarF.a();
                        if (gVar != null) {
                            gVar.setShapeAppearanceModel(jVarA);
                        }
                    }
                }
            } else {
                if (i13 != 1) {
                    throw new IllegalArgumentException(ai.onnxruntime.a.g(i13, "Invalid sheet edge position value: ", ". Must be 0 or 1."));
                }
                this.f5132a = new com.google.android.material.sidesheet.a(this);
                if (jVar != null) {
                    WeakReference<V> weakReference3 = this.f5145s;
                    if (weakReference3 != null && (v7 = weakReference3.get()) != null && (v7.getLayoutParams() instanceof CoordinatorLayout.f)) {
                        fVar = (CoordinatorLayout.f) v7.getLayoutParams();
                    }
                    if (fVar == null || ((ViewGroup.MarginLayoutParams) fVar).leftMargin <= 0) {
                        j.a aVarF2 = jVar.f();
                        aVarF2.e(0.0f);
                        aVarF2.c(0.0f);
                        j jVarA2 = aVarF2.a();
                        if (gVar != null) {
                            gVar.setShapeAppearanceModel(jVarA2);
                        }
                    }
                }
            }
        }
        if (this.f5139l == null) {
            this.f5139l = new c1.c(coordinatorLayout.getContext(), coordinatorLayout, this.z);
        }
        int iH2 = this.f5132a.h(v3);
        coordinatorLayout.B(i10, v3);
        this.f5143p = coordinatorLayout.getWidth();
        this.f5144q = this.f5132a.i(coordinatorLayout);
        this.f5142o = v3.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v3.getLayoutParams();
        this.r = marginLayoutParams != null ? this.f5132a.a(marginLayoutParams) : 0;
        int i14 = this.f5138k;
        if (i14 == 1 || i14 == 2) {
            iH = iH2 - this.f5132a.h(v3);
        } else if (i14 != 3) {
            if (i14 != 5) {
                throw new IllegalStateException("Unexpected value: " + this.f5138k);
            }
            iH = this.f5132a.e();
        }
        WeakHashMap<View, h0> weakHashMap3 = e0.f13274a;
        v3.offsetLeftAndRight(iH);
        if (this.f5146t == null && (i11 = this.f5147u) != -1 && (viewFindViewById = coordinatorLayout.findViewById(i11)) != null) {
            this.f5146t = new WeakReference<>(viewFindViewById);
        }
        for (com.google.android.material.sidesheet.c cVar : this.f5151y) {
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v3, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v3.getLayoutParams();
        v3.measure(ViewGroup.getChildMeasureSpec(i10, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i12, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v3, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        if (savedState.getSuperState() != null) {
            super.onRestoreInstanceState(coordinatorLayout, v3, savedState.getSuperState());
        }
        int i10 = savedState.state;
        if (i10 == 1 || i10 == 2) {
            i10 = 5;
        }
        this.f5138k = i10;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v3) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v3), (SideSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v3, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (!v3.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f5138k == 1 && actionMasked == 0) {
            return true;
        }
        if (i()) {
            this.f5139l.m(motionEvent);
        }
        if (actionMasked == 0 && (velocityTracker = this.f5148v) != null) {
            velocityTracker.recycle();
            this.f5148v = null;
        }
        if (this.f5148v == null) {
            this.f5148v = VelocityTracker.obtain();
        }
        this.f5148v.addMovement(motionEvent);
        if (i() && actionMasked == 2 && !this.f5140m && i()) {
            float fAbs = Math.abs(this.f5150x - motionEvent.getX());
            c1.c cVar = this.f5139l;
            if (fAbs > cVar.f3262b) {
                cVar.c(motionEvent.getPointerId(motionEvent.getActionIndex()), v3);
            }
        }
        return !this.f5140m;
    }

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5136e = new c();
        this.f5137j = true;
        this.f5138k = 5;
        this.f5141n = 0.1f;
        this.f5147u = -1;
        this.f5151y = new LinkedHashSet();
        this.z = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k4.a.E);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.f5134c = w4.c.a(context, typedArrayObtainStyledAttributes, 3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            this.f5135d = j.b(context, attributeSet, 0, R.style.Widget_Material3_SideSheet).a();
        }
        if (typedArrayObtainStyledAttributes.hasValue(5)) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(5, -1);
            this.f5147u = resourceId;
            WeakReference<View> weakReference = this.f5146t;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.f5146t = null;
            WeakReference<V> weakReference2 = this.f5145s;
            if (weakReference2 != null) {
                V v3 = weakReference2.get();
                if (resourceId != -1 && v3.isLaidOut()) {
                    v3.requestLayout();
                }
            }
        }
        j jVar = this.f5135d;
        if (jVar != null) {
            y4.g gVar = new y4.g(jVar);
            this.f5133b = gVar;
            gVar.k(context);
            ColorStateList colorStateList = this.f5134c;
            if (colorStateList != null) {
                this.f5133b.n(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.f5133b.setTint(typedValue.data);
            }
        }
        this.h = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        this.f5137j = typedArrayObtainStyledAttributes.getBoolean(4, true);
        typedArrayObtainStyledAttributes.recycle();
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
