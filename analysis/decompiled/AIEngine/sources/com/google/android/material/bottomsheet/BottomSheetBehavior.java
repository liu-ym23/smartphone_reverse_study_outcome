package com.google.android.material.bottomsheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Property;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import c1.c;
import com.google.android.material.internal.k;
import com.google.android.material.internal.l;
import com.google.android.material.internal.m;
import com.stepos.aiengine.R;
import com.stepos.core.ota.crypto.CryptoHeaderParser;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;
import mb.y;
import v0.a;
import v0.e0;
import v0.h0;
import v0.l0;
import w0.b;
import y4.g;
import y4.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> implements u4.b {
    public final boolean A;
    public final j B;
    public boolean C;
    public final BottomSheetBehavior<V>.e D;
    public final ValueAnimator E;
    public final int F;
    public int G;
    public int H;
    public final float I;
    public int J;
    public final float K;
    public boolean L;
    public boolean M;
    public final boolean N;
    public final boolean O;
    public boolean P;
    public int Q;
    public c1.c R;
    public boolean S;
    public int T;
    public boolean U;
    public final float V;
    public int W;
    public int X;
    public int Y;
    public WeakReference<V> Z;

    /* renamed from: a, reason: collision with root package name */
    public final int f4673a;

    /* renamed from: a0, reason: collision with root package name */
    public WeakReference<View> f4674a0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4675b;
    public final ArrayList<d> b0;

    /* renamed from: c, reason: collision with root package name */
    public final float f4676c;
    public VelocityTracker c0;

    /* renamed from: d, reason: collision with root package name */
    public final int f4677d;

    /* renamed from: d0, reason: collision with root package name */
    public u4.f f4678d0;

    /* renamed from: e, reason: collision with root package name */
    public int f4679e;

    /* renamed from: e0, reason: collision with root package name */
    public int f4680e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f4681f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f4682g0;
    public boolean h;

    /* renamed from: h0, reason: collision with root package name */
    public HashMap f4683h0;

    /* renamed from: i0, reason: collision with root package name */
    public final SparseIntArray f4684i0;

    /* renamed from: j, reason: collision with root package name */
    public int f4685j;

    /* renamed from: j0, reason: collision with root package name */
    public final c f4686j0;

    /* renamed from: k, reason: collision with root package name */
    public final int f4687k;

    /* renamed from: l, reason: collision with root package name */
    public final y4.g f4688l;

    /* renamed from: m, reason: collision with root package name */
    public final ColorStateList f4689m;

    /* renamed from: n, reason: collision with root package name */
    public final int f4690n;

    /* renamed from: o, reason: collision with root package name */
    public final int f4691o;

    /* renamed from: p, reason: collision with root package name */
    public int f4692p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f4693q;
    public final boolean r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f4694s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f4695t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f4696u;

    /* renamed from: v, reason: collision with root package name */
    public final boolean f4697v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f4698w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f4699x;

    /* renamed from: y, reason: collision with root package name */
    public int f4700y;
    public int z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
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
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1;
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.state = bottomSheetBehavior.Q;
            this.peekHeight = bottomSheetBehavior.f4679e;
            this.fitToContents = bottomSheetBehavior.f4675b;
            this.hideable = bottomSheetBehavior.L;
            this.skipCollapsed = bottomSheetBehavior.M;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i10) {
            super(parcelable);
            this.state = i10;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f4701a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4702b;

        public a(View view, int i10) {
            this.f4701a = view;
            this.f4702b = i10;
        }

        @Override // java.lang.Runnable
        public final void run() throws Resources.NotFoundException {
            BottomSheetBehavior.this.v(this.f4701a, this.f4702b, false);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) throws Resources.NotFoundException {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            bottomSheetBehavior.t(5);
            WeakReference<V> weakReference = bottomSheetBehavior.Z;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            bottomSheetBehavior.Z.get().requestLayout();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c extends c.AbstractC0028c {
        public c() {
        }

        @Override // c1.c.AbstractC0028c
        public final int a(int i10, View view) {
            return view.getLeft();
        }

        @Override // c1.c.AbstractC0028c
        public final int b(int i10, View view) {
            return y.p(i10, BottomSheetBehavior.this.n(), d());
        }

        @Override // c1.c.AbstractC0028c
        public final int d() {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.L ? bottomSheetBehavior.Y : bottomSheetBehavior.J;
        }

        @Override // c1.c.AbstractC0028c
        public final void h(int i10) throws Resources.NotFoundException {
            if (i10 == 1) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.N) {
                    bottomSheetBehavior.t(1);
                }
            }
        }

        @Override // c1.c.AbstractC0028c
        public final void i(View view, int i10, int i11) {
            BottomSheetBehavior.this.j(i11);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0085  */
        /* JADX WARN: Removed duplicated region for block: B:6:0x000d  */
        @Override // c1.c.AbstractC0028c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void j(android.view.View r5, float r6, float r7) throws android.content.res.Resources.NotFoundException {
            /*
                Method dump skipped, instructions count: 233
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.c.j(android.view.View, float, float):void");
        }

        @Override // c1.c.AbstractC0028c
        public final boolean k(int i10, View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i11 = bottomSheetBehavior.Q;
            if (i11 == 1 || bottomSheetBehavior.f4682g0) {
                return false;
            }
            if (i11 == 3 && bottomSheetBehavior.f4680e0 == i10) {
                WeakReference<View> weakReference = bottomSheetBehavior.f4674a0;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            SystemClock.uptimeMillis();
            WeakReference<V> weakReference2 = bottomSheetBehavior.Z;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class e {

        /* renamed from: a, reason: collision with root package name */
        public int f4706a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f4707b;

        /* renamed from: c, reason: collision with root package name */
        public final a f4708c = new a();

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                e eVar = e.this;
                eVar.f4707b = false;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                c1.c cVar = bottomSheetBehavior.R;
                if (cVar != null && cVar.h()) {
                    eVar.a(eVar.f4706a);
                } else if (bottomSheetBehavior.Q == 2) {
                    bottomSheetBehavior.t(eVar.f4706a);
                }
            }
        }

        public e() {
        }

        public final void a(int i10) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            WeakReference<V> weakReference = bottomSheetBehavior.Z;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f4706a = i10;
            if (this.f4707b) {
                return;
            }
            bottomSheetBehavior.Z.get().postOnAnimation(this.f4708c);
            this.f4707b = true;
        }
    }

    public BottomSheetBehavior() {
        this.f4673a = 0;
        this.f4675b = true;
        this.f4690n = -1;
        this.f4691o = -1;
        this.D = new e();
        this.I = 0.5f;
        this.K = -1.0f;
        this.N = true;
        this.O = true;
        this.Q = 4;
        this.V = 0.1f;
        this.b0 = new ArrayList<>();
        this.f4681f0 = -1;
        this.f4684i0 = new SparseIntArray();
        this.f4686j0 = new c();
    }

    public static View k(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (view.isNestedScrollingEnabled()) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View viewK = k(viewGroup.getChildAt(i10));
            if (viewK != null) {
                return viewK;
            }
        }
        return null;
    }

    public static <V extends View> BottomSheetBehavior<V> l(V v3) {
        ViewGroup.LayoutParams layoutParams = v3.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.f)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.c cVar = ((CoordinatorLayout.f) layoutParams).f1456a;
        if (cVar instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) cVar;
        }
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    public static int m(int i10, int i11, int i12, int i13) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, i11, i13);
        if (i12 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i12), 1073741824);
        }
        if (size != 0) {
            i12 = Math.min(size, i12);
        }
        return View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
    }

    @Override // u4.b
    public final void a(b.a aVar) {
        u4.f fVar = this.f4678d0;
        if (fVar == null) {
            return;
        }
        fVar.f13148f = aVar;
    }

    @Override // u4.b
    public final void c() {
        u4.f fVar = this.f4678d0;
        if (fVar == null) {
            return;
        }
        if (fVar.f13148f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        b.a aVar = fVar.f13148f;
        fVar.f13148f = null;
        if (aVar == null) {
            return;
        }
        AnimatorSet animatorSetA = fVar.a();
        animatorSetA.setDuration(fVar.f13147e);
        animatorSetA.start();
    }

    @Override // u4.b
    public final void e(b.a aVar) {
        u4.f fVar = this.f4678d0;
        if (fVar == null) {
            return;
        }
        if (fVar.f13148f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        b.a aVar2 = fVar.f13148f;
        fVar.f13148f = aVar;
        if (aVar2 == null) {
            return;
        }
        fVar.b(aVar.f2988c);
    }

    @Override // u4.b
    public final void f() throws Resources.NotFoundException {
        u4.f fVar = this.f4678d0;
        if (fVar == null) {
            return;
        }
        int i10 = fVar.f13146d;
        int i11 = fVar.f13145c;
        b.a aVar = fVar.f13148f;
        fVar.f13148f = null;
        if (aVar != null) {
            float f8 = aVar.f2988c;
            if (Build.VERSION.SDK_INT >= 34) {
                if (!this.L) {
                    AnimatorSet animatorSetA = fVar.a();
                    animatorSetA.setDuration(l4.a.c(f8, i11, i10));
                    animatorSetA.start();
                    s(4);
                    return;
                }
                b bVar = new b();
                V v3 = fVar.f13144b;
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(v3, (Property<V, Float>) View.TRANSLATION_Y, v3.getScaleY() * v3.getHeight());
                objectAnimatorOfFloat.setInterpolator(new o1.b());
                objectAnimatorOfFloat.setDuration(l4.a.c(f8, i11, i10));
                objectAnimatorOfFloat.addListener(new u4.e(fVar));
                objectAnimatorOfFloat.addListener(bVar);
                objectAnimatorOfFloat.start();
                return;
            }
        }
        s(this.L ? 5 : 4);
    }

    public final void g() {
        int i10 = i();
        if (this.f4675b) {
            this.J = Math.max(this.Y - i10, this.G);
        } else {
            this.J = this.Y - i10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float h() {
        /*
            r6 = this;
            y4.g r0 = r6.f4688l
            r1 = 0
            if (r0 == 0) goto L8a
            java.lang.ref.WeakReference<V extends android.view.View> r0 = r6.Z
            if (r0 == 0) goto L8a
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L8a
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r0 < r2) goto L8a
            java.lang.ref.WeakReference<V extends android.view.View> r0 = r6.Z
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            boolean r2 = r6.p()
            if (r2 == 0) goto L8a
            android.view.WindowInsets r0 = r0.getRootWindowInsets()
            if (r0 == 0) goto L8a
            y4.g r2 = r6.f4688l
            float[] r3 = r2.D
            if (r3 == 0) goto L33
            r2 = 3
            r2 = r3[r2]
            goto L41
        L33:
            y4.g$c r3 = r2.f14023b
            y4.j r3 = r3.f14044a
            y4.d r3 = r3.f14066e
            android.graphics.RectF r2 = r2.g()
            float r2 = r3.a(r2)
        L41:
            r3 = 0
            android.view.RoundedCorner r4 = r0.getRoundedCorner(r3)
            if (r4 == 0) goto L57
            int r4 = r4.getRadius()
            float r4 = (float) r4
            int r5 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r5 <= 0) goto L57
            int r5 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r5 <= 0) goto L57
            float r4 = r4 / r2
            goto L58
        L57:
            r4 = r1
        L58:
            y4.g r6 = r6.f4688l
            float[] r2 = r6.D
            if (r2 == 0) goto L61
            r6 = r2[r3]
            goto L6f
        L61:
            y4.g$c r2 = r6.f14023b
            y4.j r2 = r2.f14044a
            y4.d r2 = r2.f14067f
            android.graphics.RectF r6 = r6.g()
            float r6 = r2.a(r6)
        L6f:
            r2 = 1
            android.view.RoundedCorner r0 = r0.getRoundedCorner(r2)
            if (r0 == 0) goto L85
            int r0 = r0.getRadius()
            float r0 = (float) r0
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 <= 0) goto L85
            int r2 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r2 <= 0) goto L85
            float r1 = r0 / r6
        L85:
            float r6 = java.lang.Math.max(r4, r1)
            return r6
        L8a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.h():float");
    }

    public final int i() {
        int iMin;
        int i10;
        int i11;
        if (this.h) {
            iMin = Math.min(Math.max(this.f4685j, this.Y - ((this.X * 9) / 16)), this.W);
            i10 = this.f4700y;
        } else {
            if (!this.f4693q && !this.r && (i11 = this.f4692p) > 0) {
                return Math.max(this.f4679e, i11 + this.f4687k);
            }
            iMin = this.f4679e;
            i10 = this.f4700y;
        }
        return iMin + i10;
    }

    public final void j(int i10) {
        V v3 = this.Z.get();
        if (v3 != null) {
            ArrayList<d> arrayList = this.b0;
            if (arrayList.isEmpty()) {
                return;
            }
            int i11 = this.J;
            if (i10 <= i11 && i11 != n()) {
                n();
            }
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                arrayList.get(i12).b(v3);
            }
        }
    }

    public final int n() {
        if (this.f4675b) {
            return this.G;
        }
        return Math.max(this.F, this.f4696u ? 0 : this.z);
    }

    public final int o(int i10) {
        if (i10 == 3) {
            return n();
        }
        if (i10 == 4) {
            return this.J;
        }
        if (i10 == 5) {
            return this.Y;
        }
        if (i10 == 6) {
            return this.H;
        }
        throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(i10, "Invalid state to get top offset: "));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
        super.onAttachedToLayoutParams(fVar);
        this.Z = null;
        this.R = null;
        this.f4678d0 = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.Z = null;
        this.R = null;
        this.f4678d0 = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v3, MotionEvent motionEvent) {
        int i10;
        c1.c cVar;
        if (!v3.isShown() || !this.N) {
            this.S = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f4680e0 = -1;
            this.f4681f0 = -1;
            VelocityTracker velocityTracker = this.c0;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.c0 = null;
            }
        }
        if (this.c0 == null) {
            this.c0 = VelocityTracker.obtain();
        }
        this.c0.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x3 = (int) motionEvent.getX();
            int y3 = (int) motionEvent.getY();
            this.f4681f0 = y3;
            if (this.Q != 2) {
                WeakReference<View> weakReference = this.f4674a0;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.z(view, x3, y3)) {
                    this.f4680e0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f4682g0 = true;
                }
            }
            this.S = this.f4680e0 == -1 && !coordinatorLayout.z(v3, x3, this.f4681f0);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f4682g0 = false;
            this.f4680e0 = -1;
            if (this.S) {
                this.S = false;
                return false;
            }
        }
        if (this.S || (cVar = this.R) == null || !cVar.t(motionEvent)) {
            WeakReference<View> weakReference2 = this.f4674a0;
            View view2 = weakReference2 != null ? weakReference2.get() : null;
            if (actionMasked != 2 || view2 == null || this.S || this.Q == 1 || coordinatorLayout.z(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.R == null || (i10 = this.f4681f0) == -1 || Math.abs(i10 - motionEvent.getY()) <= this.R.f3262b) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v3, int i10) throws Resources.NotFoundException {
        if (coordinatorLayout.getFitsSystemWindows() && !v3.getFitsSystemWindows()) {
            v3.setFitsSystemWindows(true);
        }
        int i11 = 0;
        if (this.Z == null) {
            this.f4685j = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            boolean z = (this.f4693q || this.h) ? false : true;
            if (this.r || this.f4694s || this.f4695t || this.f4697v || this.f4698w || this.f4699x || z) {
                com.google.android.material.bottomsheet.b bVar = new com.google.android.material.bottomsheet.b(this, z);
                int paddingStart = v3.getPaddingStart();
                v3.getPaddingTop();
                int paddingEnd = v3.getPaddingEnd();
                int paddingBottom = v3.getPaddingBottom();
                m.a aVar = new m.a();
                aVar.f5109a = paddingStart;
                aVar.f5110b = paddingEnd;
                aVar.f5111c = paddingBottom;
                k kVar = new k(bVar, aVar);
                WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                e0.d.k(v3, kVar);
                if (v3.isAttachedToWindow()) {
                    v3.requestApplyInsets();
                } else {
                    v3.addOnAttachStateChangeListener(new l());
                }
            }
            i iVar = new i(v3);
            WeakHashMap<View, h0> weakHashMap2 = e0.f13274a;
            v3.setWindowInsetsAnimationCallback(new l0.c.a(iVar));
            this.Z = new WeakReference<>(v3);
            this.f4678d0 = new u4.f(v3);
            y4.g gVar = this.f4688l;
            if (gVar != null) {
                v3.setBackground(gVar);
                float elevation = this.K;
                if (elevation == -1.0f) {
                    elevation = v3.getElevation();
                }
                gVar.m(elevation);
            } else {
                ColorStateList colorStateList = this.f4689m;
                if (colorStateList != null) {
                    e0.d.h(v3, colorStateList);
                }
            }
            w();
            if (v3.getImportantForAccessibility() == 0) {
                v3.setImportantForAccessibility(1);
            }
        }
        if (this.R == null) {
            this.R = new c1.c(coordinatorLayout.getContext(), coordinatorLayout, this.f4686j0);
        }
        int top = v3.getTop();
        coordinatorLayout.B(i10, v3);
        this.X = coordinatorLayout.getWidth();
        this.Y = coordinatorLayout.getHeight();
        int height = v3.getHeight();
        this.W = height;
        int iMin = this.Y;
        int i12 = iMin - height;
        int i13 = this.z;
        if (i12 < i13) {
            boolean z3 = this.f4696u;
            int i14 = this.f4691o;
            if (z3) {
                if (i14 != -1) {
                    iMin = Math.min(iMin, i14);
                }
                this.W = iMin;
            } else {
                int iMin2 = iMin - i13;
                if (i14 != -1) {
                    iMin2 = Math.min(iMin2, i14);
                }
                this.W = iMin2;
            }
        }
        this.G = Math.max(0, this.Y - this.W);
        this.H = (int) ((1.0f - this.I) * this.Y);
        g();
        int i15 = this.Q;
        if (i15 == 3) {
            int iN = n();
            WeakHashMap<View, h0> weakHashMap3 = e0.f13274a;
            v3.offsetTopAndBottom(iN);
        } else if (i15 == 6) {
            int i16 = this.H;
            WeakHashMap<View, h0> weakHashMap4 = e0.f13274a;
            v3.offsetTopAndBottom(i16);
        } else if (this.L && i15 == 5) {
            int i17 = this.Y;
            WeakHashMap<View, h0> weakHashMap5 = e0.f13274a;
            v3.offsetTopAndBottom(i17);
        } else if (i15 == 4) {
            int i18 = this.J;
            WeakHashMap<View, h0> weakHashMap6 = e0.f13274a;
            v3.offsetTopAndBottom(i18);
        } else if (i15 == 1 || i15 == 2) {
            int top2 = top - v3.getTop();
            WeakHashMap<View, h0> weakHashMap7 = e0.f13274a;
            v3.offsetTopAndBottom(top2);
        }
        x(this.Q, false);
        this.f4674a0 = new WeakReference<>(k(v3));
        while (true) {
            ArrayList<d> arrayList = this.b0;
            if (i11 >= arrayList.size()) {
                return true;
            }
            arrayList.get(i11).a(v3);
            i11++;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v3, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v3.getLayoutParams();
        v3.measure(m(i10, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, this.f4690n, marginLayoutParams.width), m(i12, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, this.f4691o, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v3, View view, float f8, float f9) {
        WeakReference<View> weakReference = this.f4674a0;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        return !(this.Q == 3 || this.P) || super.onNestedPreFling(coordinatorLayout, v3, view, f8, f9);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v3, View view, int i10, int i11, int[] iArr, int i12) throws Resources.NotFoundException {
        if (i12 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.f4674a0;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (view != view2) {
            return;
        }
        int top = v3.getTop();
        int i13 = top - i11;
        boolean z = this.N;
        boolean z3 = this.O;
        if (i11 > 0) {
            if (!this.U && !z3 && view == view2 && view.canScrollVertically(1)) {
                this.P = true;
                return;
            }
            if (i13 < n()) {
                int iN = top - n();
                iArr[1] = iN;
                WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                v3.offsetTopAndBottom(-iN);
                t(3);
            } else {
                if (!z) {
                    return;
                }
                iArr[1] = i11;
                WeakHashMap<View, h0> weakHashMap2 = e0.f13274a;
                v3.offsetTopAndBottom(-i11);
                t(1);
            }
        } else if (i11 < 0) {
            boolean zCanScrollVertically = view.canScrollVertically(-1);
            if (!this.U && !z3 && view == view2 && zCanScrollVertically) {
                this.P = true;
                return;
            }
            if (!zCanScrollVertically) {
                int i14 = this.J;
                if (i13 > i14 && !this.L) {
                    int i15 = top - i14;
                    iArr[1] = i15;
                    WeakHashMap<View, h0> weakHashMap3 = e0.f13274a;
                    v3.offsetTopAndBottom(-i15);
                    t(4);
                } else {
                    if (!z) {
                        return;
                    }
                    iArr[1] = i11;
                    WeakHashMap<View, h0> weakHashMap4 = e0.f13274a;
                    v3.offsetTopAndBottom(-i11);
                    t(1);
                }
            }
        }
        j(v3.getTop());
        this.T = i11;
        this.U = true;
        this.P = false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v3, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v3, savedState.getSuperState());
        int i10 = this.f4673a;
        if (i10 != 0) {
            if (i10 == -1 || (i10 & 1) == 1) {
                this.f4679e = savedState.peekHeight;
            }
            if (i10 == -1 || (i10 & 2) == 2) {
                this.f4675b = savedState.fitToContents;
            }
            if (i10 == -1 || (i10 & 4) == 4) {
                this.L = savedState.hideable;
            }
            if (i10 == -1 || (i10 & 8) == 8) {
                this.M = savedState.skipCollapsed;
            }
        }
        int i11 = savedState.state;
        if (i11 == 1 || i11 == 2) {
            this.Q = 4;
        } else {
            this.Q = i11;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v3) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v3), (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v3, View view, View view2, int i10, int i11) {
        this.T = 0;
        this.U = false;
        return (i10 & 2) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r3, V r4, android.view.View r5, int r6) throws android.content.res.Resources.NotFoundException {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.n()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.t(r0)
            return
        Lf:
            java.lang.ref.WeakReference<android.view.View> r3 = r2.f4674a0
            if (r3 == 0) goto Lb5
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto Lb5
            boolean r3 = r2.U
            if (r3 != 0) goto L1f
            goto Lb5
        L1f:
            int r3 = r2.T
            r5 = 6
            if (r3 <= 0) goto L34
            boolean r3 = r2.f4675b
            if (r3 == 0) goto L2a
            goto Laf
        L2a:
            int r3 = r4.getTop()
            int r6 = r2.H
            if (r3 <= r6) goto Laf
            goto Lae
        L34:
            boolean r3 = r2.L
            if (r3 == 0) goto L55
            android.view.VelocityTracker r3 = r2.c0
            if (r3 != 0) goto L3e
            r3 = 0
            goto L4d
        L3e:
            r6 = 1000(0x3e8, float:1.401E-42)
            float r1 = r2.f4676c
            r3.computeCurrentVelocity(r6, r1)
            android.view.VelocityTracker r3 = r2.c0
            int r6 = r2.f4680e0
            float r3 = r3.getYVelocity(r6)
        L4d:
            boolean r3 = r2.u(r4, r3)
            if (r3 == 0) goto L55
            r0 = 5
            goto Laf
        L55:
            int r3 = r2.T
            r6 = 4
            if (r3 != 0) goto L93
            int r3 = r4.getTop()
            boolean r1 = r2.f4675b
            if (r1 == 0) goto L74
            int r5 = r2.G
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.J
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L97
            goto Laf
        L74:
            int r1 = r2.H
            if (r3 >= r1) goto L83
            int r6 = r2.J
            int r6 = r3 - r6
            int r6 = java.lang.Math.abs(r6)
            if (r3 >= r6) goto Lae
            goto Laf
        L83:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.J
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
            goto Lae
        L93:
            boolean r3 = r2.f4675b
            if (r3 == 0) goto L99
        L97:
            r0 = r6
            goto Laf
        L99:
            int r3 = r4.getTop()
            int r0 = r2.H
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.J
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
        Lae:
            r0 = r5
        Laf:
            r3 = 0
            r2.v(r4, r0, r3)
            r2.U = r3
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v3, MotionEvent motionEvent) {
        if (!v3.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i10 = this.Q;
        if (i10 == 1 && actionMasked == 0) {
            return true;
        }
        c1.c cVar = this.R;
        if (cVar != null && (this.N || i10 == 1)) {
            cVar.m(motionEvent);
        }
        if (actionMasked == 0) {
            this.f4680e0 = -1;
            this.f4681f0 = -1;
            VelocityTracker velocityTracker = this.c0;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.c0 = null;
            }
        }
        if (this.c0 == null) {
            this.c0 = VelocityTracker.obtain();
        }
        this.c0.addMovement(motionEvent);
        if (this.R != null && ((this.N || this.Q == 1) && actionMasked == 2 && !this.S)) {
            float fAbs = Math.abs(this.f4681f0 - motionEvent.getY());
            c1.c cVar2 = this.R;
            if (fAbs > cVar2.f3262b) {
                cVar2.c(motionEvent.getPointerId(motionEvent.getActionIndex()), v3);
            }
        }
        return !this.S;
    }

    public final boolean p() {
        WeakReference<V> weakReference = this.Z;
        if (weakReference != null && weakReference.get() != null) {
            int[] iArr = new int[2];
            this.Z.get().getLocationOnScreen(iArr);
            if (iArr[1] == 0) {
                return true;
            }
        }
        return false;
    }

    public final void q(boolean z) throws Resources.NotFoundException {
        if (this.L != z) {
            this.L = z;
            if (!z && this.Q == 5) {
                s(4);
            }
            w();
        }
    }

    public final void r(int i10) {
        if (i10 == -1) {
            if (this.h) {
                return;
            } else {
                this.h = true;
            }
        } else {
            if (!this.h && this.f4679e == i10) {
                return;
            }
            this.h = false;
            this.f4679e = Math.max(0, i10);
        }
        z();
    }

    public final void s(int i10) throws Resources.NotFoundException {
        if (i10 == 1 || i10 == 2) {
            throw new IllegalArgumentException(ai.onnxruntime.a.o(new StringBuilder("STATE_"), i10 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        if (!this.L && i10 == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i10);
            return;
        }
        int i11 = (i10 == 6 && this.f4675b && o(i10) <= this.G) ? 3 : i10;
        WeakReference<V> weakReference = this.Z;
        if (weakReference == null || weakReference.get() == null) {
            t(i10);
            return;
        }
        V v3 = this.Z.get();
        a aVar = new a(v3, i11);
        ViewParent parent = v3.getParent();
        if (parent != null && parent.isLayoutRequested() && v3.isAttachedToWindow()) {
            v3.post(aVar);
        } else {
            aVar.run();
        }
    }

    public final void t(int i10) throws Resources.NotFoundException {
        V v3;
        if (this.Q == i10) {
            return;
        }
        this.Q = i10;
        if (i10 != 4 && i10 != 3 && i10 != 6) {
            boolean z = this.L;
        }
        WeakReference<V> weakReference = this.Z;
        if (weakReference == null || (v3 = weakReference.get()) == null) {
            return;
        }
        int i11 = 0;
        if (i10 == 3) {
            y(true);
        } else if (i10 == 6 || i10 == 5 || i10 == 4) {
            y(false);
        }
        x(i10, true);
        while (true) {
            ArrayList<d> arrayList = this.b0;
            if (i11 >= arrayList.size()) {
                w();
                return;
            } else {
                arrayList.get(i11).c(i10, v3);
                i11++;
            }
        }
    }

    public final boolean u(View view, float f8) {
        if (this.M) {
            return true;
        }
        if (view.getTop() < this.J) {
            return false;
        }
        return Math.abs(((f8 * this.V) + ((float) view.getTop())) - ((float) this.J)) / ((float) i()) > 0.5f;
    }

    public final void v(View view, int i10, boolean z) throws Resources.NotFoundException {
        int iO = o(i10);
        c1.c cVar = this.R;
        if (cVar == null || (!z ? cVar.u(view, view.getLeft(), iO) : cVar.s(view.getLeft(), iO))) {
            t(i10);
            return;
        }
        t(2);
        x(i10, true);
        this.D.a(i10);
    }

    public final void w() throws Resources.NotFoundException {
        V v3;
        int iA;
        WeakReference<V> weakReference = this.Z;
        if (weakReference == null || (v3 = weakReference.get()) == null) {
            return;
        }
        e0.h(524288, v3);
        e0.e(0, v3);
        e0.h(262144, v3);
        e0.e(0, v3);
        e0.h(CryptoHeaderParser.MAX_BLOCK_SIZE, v3);
        e0.e(0, v3);
        SparseIntArray sparseIntArray = this.f4684i0;
        int i10 = sparseIntArray.get(0, -1);
        if (i10 != -1) {
            e0.h(i10, v3);
            e0.e(0, v3);
            sparseIntArray.delete(0);
        }
        if (!this.f4675b && this.Q != 6) {
            String string = v3.getResources().getString(R.string.bottomsheet_action_expand_halfway);
            com.google.android.material.bottomsheet.c cVar = new com.google.android.material.bottomsheet.c(this, 6);
            ArrayList arrayListC = e0.c(v3);
            int i11 = 0;
            while (true) {
                if (i11 >= arrayListC.size()) {
                    int i12 = 0;
                    int i13 = -1;
                    while (true) {
                        int[] iArr = e0.f13275b;
                        if (i12 >= 32 || i13 != -1) {
                            break;
                        }
                        int i14 = iArr[i12];
                        boolean z = true;
                        for (int i15 = 0; i15 < arrayListC.size(); i15++) {
                            z &= ((b.a) arrayListC.get(i15)).a() != i14;
                        }
                        if (z) {
                            i13 = i14;
                        }
                        i12++;
                    }
                    iA = i13;
                } else {
                    if (TextUtils.equals(string, ((AccessibilityNodeInfo.AccessibilityAction) ((b.a) arrayListC.get(i11)).f13542a).getLabel())) {
                        iA = ((b.a) arrayListC.get(i11)).a();
                        break;
                    }
                    i11++;
                }
            }
            if (iA != -1) {
                b.a aVar = new b.a(null, iA, string, cVar, null);
                View.AccessibilityDelegate accessibilityDelegateA = e0.h.a(v3);
                v0.a aVar2 = accessibilityDelegateA == null ? null : accessibilityDelegateA instanceof a.C0151a ? ((a.C0151a) accessibilityDelegateA).f13251a : new v0.a(accessibilityDelegateA);
                if (aVar2 == null) {
                    aVar2 = new v0.a();
                }
                e0.j(v3, aVar2);
                e0.h(aVar.a(), v3);
                e0.c(v3).add(aVar);
                e0.e(0, v3);
            }
            sparseIntArray.put(0, iA);
        }
        if (this.L && this.Q != 5) {
            e0.i(v3, b.a.f13539j, new com.google.android.material.bottomsheet.c(this, 5));
        }
        int i16 = this.Q;
        if (i16 == 3) {
            e0.i(v3, b.a.f13538i, new com.google.android.material.bottomsheet.c(this, this.f4675b ? 4 : 6));
            return;
        }
        if (i16 == 4) {
            e0.i(v3, b.a.h, new com.google.android.material.bottomsheet.c(this, this.f4675b ? 3 : 6));
        } else {
            if (i16 != 6) {
                return;
            }
            e0.i(v3, b.a.f13538i, new com.google.android.material.bottomsheet.c(this, 4));
            e0.i(v3, b.a.h, new com.google.android.material.bottomsheet.c(this, 3));
        }
    }

    public final void x(int i10, boolean z) {
        y4.g gVar;
        if (i10 == 2) {
            return;
        }
        boolean z3 = this.Q == 3 && (this.A || p());
        if (this.C == z3 || (gVar = this.f4688l) == null) {
            return;
        }
        this.C = z3;
        ValueAnimator valueAnimator = this.E;
        if (z && valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                valueAnimator.reverse();
                return;
            } else {
                valueAnimator.setFloatValues(gVar.f14023b.f14052j, z3 ? h() : 1.0f);
                valueAnimator.start();
                return;
            }
        }
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
        float fH = this.C ? h() : 1.0f;
        g.c cVar = gVar.f14023b;
        if (cVar.f14052j != fH) {
            cVar.f14052j = fH;
            gVar.h = true;
            gVar.f14027j = true;
            gVar.invalidateSelf();
        }
    }

    public final void y(boolean z) {
        WeakReference<V> weakReference = this.Z;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                if (this.f4683h0 != null) {
                    return;
                } else {
                    this.f4683h0 = new HashMap(childCount);
                }
            }
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if (childAt != this.Z.get() && z) {
                    this.f4683h0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z) {
                return;
            }
            this.f4683h0 = null;
        }
    }

    public final void z() {
        V v3;
        if (this.Z != null) {
            g();
            if (this.Q != 4 || (v3 = this.Z.get()) == null) {
                return;
            }
            v3.requestLayout();
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        int i10;
        super(context, attributeSet);
        this.f4673a = 0;
        this.f4675b = true;
        this.f4690n = -1;
        this.f4691o = -1;
        this.D = new e();
        this.I = 0.5f;
        this.K = -1.0f;
        this.N = true;
        this.O = true;
        this.Q = 4;
        this.V = 0.1f;
        this.b0 = new ArrayList<>();
        this.f4681f0 = -1;
        this.f4684i0 = new SparseIntArray();
        this.f4686j0 = new c();
        this.f4687k = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k4.a.f9899c);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.f4689m = w4.c.a(context, typedArrayObtainStyledAttributes, 3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(22)) {
            this.B = j.b(context, attributeSet, R.attr.bottomSheetStyle, R.style.Widget_Design_BottomSheet_Modal).a();
        }
        j jVar = this.B;
        if (jVar != null) {
            y4.g gVar = new y4.g(jVar);
            this.f4688l = gVar;
            gVar.k(context);
            ColorStateList colorStateList = this.f4689m;
            if (colorStateList != null) {
                this.f4688l.n(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.f4688l.setTint(typedValue.data);
            }
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(h(), 1.0f);
        this.E = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.E.addUpdateListener(new com.google.android.material.bottomsheet.a(this));
        this.K = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            this.f4690n = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            this.f4691o = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, -1);
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(10);
        if (typedValuePeekValue != null && (i10 = typedValuePeekValue.data) == -1) {
            r(i10);
        } else {
            r(typedArrayObtainStyledAttributes.getDimensionPixelSize(10, -1));
        }
        q(typedArrayObtainStyledAttributes.getBoolean(9, false));
        this.f4693q = typedArrayObtainStyledAttributes.getBoolean(14, false);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(7, true);
        if (this.f4675b != z) {
            this.f4675b = z;
            if (this.Z != null) {
                g();
            }
            t((this.f4675b && this.Q == 6) ? 3 : this.Q);
            x(this.Q, true);
            w();
        }
        this.M = typedArrayObtainStyledAttributes.getBoolean(13, false);
        this.N = typedArrayObtainStyledAttributes.getBoolean(4, true);
        this.O = typedArrayObtainStyledAttributes.getBoolean(5, true);
        this.f4673a = typedArrayObtainStyledAttributes.getInt(11, 0);
        float f8 = typedArrayObtainStyledAttributes.getFloat(8, 0.5f);
        if (f8 > 0.0f && f8 < 1.0f) {
            this.I = f8;
            if (this.Z != null) {
                this.H = (int) ((1.0f - f8) * this.Y);
            }
            TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(6);
            if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
                int i11 = typedValuePeekValue2.data;
                if (i11 >= 0) {
                    this.F = i11;
                    x(this.Q, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            } else {
                int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(6, 0);
                if (dimensionPixelOffset >= 0) {
                    this.F = dimensionPixelOffset;
                    x(this.Q, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            }
            this.f4677d = typedArrayObtainStyledAttributes.getInt(12, 500);
            this.r = typedArrayObtainStyledAttributes.getBoolean(18, false);
            this.f4694s = typedArrayObtainStyledAttributes.getBoolean(19, false);
            this.f4695t = typedArrayObtainStyledAttributes.getBoolean(20, false);
            this.f4696u = typedArrayObtainStyledAttributes.getBoolean(21, true);
            this.f4697v = typedArrayObtainStyledAttributes.getBoolean(15, false);
            this.f4698w = typedArrayObtainStyledAttributes.getBoolean(16, false);
            this.f4699x = typedArrayObtainStyledAttributes.getBoolean(17, false);
            this.A = typedArrayObtainStyledAttributes.getBoolean(24, true);
            typedArrayObtainStyledAttributes.recycle();
            this.f4676c = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class d {
        public abstract void b(View view);

        public abstract void c(int i10, View view);

        public void a(View view) {
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final void onNestedScroll(CoordinatorLayout coordinatorLayout, V v3, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
    }
}
