package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.PathInterpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.emoji2.text.p;
import com.stepos.stepclaw.R;
import e0.a0;
import e0.b0;
import e0.u;
import e0.y;
import f0.c;
import g.z;
import i0.e;
import i1.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import k4.v;
import m0.f;
import p1.l;
import p1.m;
import t.a;
import t.d;
import t1.h;
import t1.j;
import t1.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends a {
    public final androidx.fragment.app.a A;
    public final ValueAnimator B;
    public final int C;
    public int D;
    public int E;
    public final float F;
    public int G;
    public final float H;
    public boolean I;
    public boolean J;
    public final boolean K;
    public final boolean L;
    public boolean M;
    public int N;
    public e O;
    public boolean P;
    public int Q;
    public boolean R;
    public final float S;
    public int T;
    public int U;
    public int V;
    public WeakReference W;
    public WeakReference X;
    public final ArrayList Y;
    public VelocityTracker Z;

    /* renamed from: a, reason: collision with root package name */
    public final int f1232a;

    /* renamed from: a0, reason: collision with root package name */
    public int f1233a0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1234b;

    /* renamed from: b0, reason: collision with root package name */
    public int f1235b0;

    /* renamed from: c, reason: collision with root package name */
    public final float f1236c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f1237c0;
    public final int d;

    /* renamed from: d0, reason: collision with root package name */
    public HashMap f1238d0;

    /* renamed from: e, reason: collision with root package name */
    public int f1239e;

    /* renamed from: e0, reason: collision with root package name */
    public final SparseIntArray f1240e0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1241f;

    /* renamed from: f0, reason: collision with root package name */
    public final b f1242f0;

    /* renamed from: g, reason: collision with root package name */
    public int f1243g;

    /* renamed from: h, reason: collision with root package name */
    public final int f1244h;

    /* renamed from: i, reason: collision with root package name */
    public final j f1245i;

    /* renamed from: j, reason: collision with root package name */
    public final ColorStateList f1246j;

    /* renamed from: k, reason: collision with root package name */
    public final int f1247k;

    /* renamed from: l, reason: collision with root package name */
    public final int f1248l;

    /* renamed from: m, reason: collision with root package name */
    public int f1249m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f1250n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f1251o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f1252p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f1253q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f1254r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f1255s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f1256t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f1257u;

    /* renamed from: v, reason: collision with root package name */
    public int f1258v;

    /* renamed from: w, reason: collision with root package name */
    public int f1259w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f1260x;
    public final n y;
    public boolean z;

    public BottomSheetBehavior() {
        this.f1232a = 0;
        this.f1234b = true;
        this.f1247k = -1;
        this.f1248l = -1;
        this.A = new androidx.fragment.app.a(this);
        this.F = 0.5f;
        this.H = -1.0f;
        this.K = true;
        this.L = true;
        this.N = 4;
        this.S = 0.1f;
        this.Y = new ArrayList();
        this.f1235b0 = -1;
        this.f1240e0 = new SparseIntArray();
        this.f1242f0 = new b(this, 0);
    }

    public static View v(View view) {
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
        for (int i8 = 0; i8 < childCount; i8++) {
            View viewV = v(viewGroup.getChildAt(i8));
            if (viewV != null) {
                return viewV;
            }
        }
        return null;
    }

    public static int w(int i8, int i9, int i10, int i11) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i8, i9, i11);
        if (i10 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i10), 1073741824);
        }
        if (size != 0) {
            i10 = Math.min(size, i10);
        }
        return View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE);
    }

    public final void A(int i8) {
        if (i8 == -1) {
            if (this.f1241f) {
                return;
            } else {
                this.f1241f = true;
            }
        } else {
            if (!this.f1241f && this.f1239e == i8) {
                return;
            }
            this.f1241f = false;
            this.f1239e = Math.max(0, i8);
        }
        I();
    }

    public final void B(int i8) throws Resources.NotFoundException {
        if (i8 == 1 || i8 == 2) {
            throw new IllegalArgumentException(f.f(new StringBuilder("STATE_"), i8 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        if (!this.I && i8 == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i8);
            return;
        }
        int i9 = (i8 == 6 && this.f1234b && y(i8) <= this.D) ? 3 : i8;
        WeakReference weakReference = this.W;
        if (weakReference == null || weakReference.get() == null) {
            C(i8);
            return;
        }
        View view = (View) this.W.get();
        z zVar = new z(this, view, i9);
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested() && view.isAttachedToWindow()) {
            view.post(zVar);
        } else {
            zVar.run();
        }
    }

    public final void C(int i8) throws Resources.NotFoundException {
        if (this.N == i8) {
            return;
        }
        this.N = i8;
        if (i8 != 4 && i8 != 3 && i8 != 6) {
            boolean z = this.I;
        }
        WeakReference weakReference = this.W;
        if (weakReference == null || ((View) weakReference.get()) == null) {
            return;
        }
        if (i8 == 3) {
            H(true);
        } else if (i8 == 6 || i8 == 5 || i8 == 4) {
            H(false);
        }
        G(i8, true);
        ArrayList arrayList = this.Y;
        if (arrayList.size() <= 0) {
            F();
        } else {
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
    }

    public final boolean D(View view, float f3) {
        if (this.J) {
            return true;
        }
        if (view.getTop() < this.G) {
            return false;
        }
        return Math.abs(((f3 * this.S) + ((float) view.getTop())) - ((float) this.G)) / ((float) t()) > 0.5f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        if (r3 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        C(2);
        G(r4, true);
        r2.A.a(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        if (r1.o(r3.getLeft(), r0) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(android.view.View r3, int r4, boolean r5) throws android.content.res.Resources.NotFoundException {
        /*
            r2 = this;
            int r0 = r2.y(r4)
            i0.e r1 = r2.O
            if (r1 == 0) goto L40
            if (r5 == 0) goto L15
            int r3 = r3.getLeft()
            boolean r3 = r1.o(r3, r0)
            if (r3 == 0) goto L40
            goto L32
        L15:
            int r5 = r3.getLeft()
            r1.f3123r = r3
            r3 = -1
            r1.f3109c = r3
            r3 = 0
            boolean r3 = r1.h(r5, r0, r3, r3)
            if (r3 != 0) goto L30
            int r5 = r1.f3107a
            if (r5 != 0) goto L30
            android.view.View r5 = r1.f3123r
            if (r5 == 0) goto L30
            r5 = 0
            r1.f3123r = r5
        L30:
            if (r3 == 0) goto L40
        L32:
            r3 = 2
            r2.C(r3)
            r3 = 1
            r2.G(r4, r3)
            androidx.fragment.app.a r2 = r2.A
            r2.a(r4)
            return
        L40:
            r2.C(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.E(android.view.View, int, boolean):void");
    }

    public final void F() throws Resources.NotFoundException {
        View view;
        int iA;
        WeakReference weakReference = this.W;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        a0.c(view, 524288);
        a0.b(view, 0);
        a0.c(view, 262144);
        a0.b(view, 0);
        a0.c(view, 1048576);
        a0.b(view, 0);
        SparseIntArray sparseIntArray = this.f1240e0;
        int i8 = sparseIntArray.get(0, -1);
        if (i8 != -1) {
            a0.c(view, i8);
            a0.b(view, 0);
            sparseIntArray.delete(0);
        }
        if (!this.f1234b && this.N != 6) {
            String string = view.getResources().getString(R.string.bottomsheet_action_expand_halfway);
            b0.j jVar = new b0.j(this, 6);
            ArrayList arrayListA = a0.a(view);
            int i9 = 0;
            while (true) {
                if (i9 >= arrayListA.size()) {
                    int i10 = 0;
                    int i11 = -1;
                    while (true) {
                        int[] iArr = a0.f2285a;
                        if (i10 >= 32 || i11 != -1) {
                            break;
                        }
                        int i12 = iArr[i10];
                        boolean z = true;
                        for (int i13 = 0; i13 < arrayListA.size(); i13++) {
                            z &= ((c) arrayListA.get(i13)).a() != i12;
                        }
                        if (z) {
                            i11 = i12;
                        }
                        i10++;
                    }
                    iA = i11;
                } else {
                    if (TextUtils.equals(string, ((AccessibilityNodeInfo.AccessibilityAction) ((c) arrayListA.get(i9)).f2539a).getLabel())) {
                        iA = ((c) arrayListA.get(i9)).a();
                        break;
                    }
                    i9++;
                }
            }
            if (iA != -1) {
                c cVar = new c(null, iA, string, jVar, null);
                View.AccessibilityDelegate accessibilityDelegateA = y.a(view);
                e0.b bVar = accessibilityDelegateA == null ? null : accessibilityDelegateA instanceof e0.a ? ((e0.a) accessibilityDelegateA).f2284a : new e0.b(accessibilityDelegateA);
                if (bVar == null) {
                    bVar = new e0.b();
                }
                a0.e(view, bVar);
                a0.c(view, cVar.a());
                a0.a(view).add(cVar);
                a0.b(view, 0);
            }
            sparseIntArray.put(0, iA);
        }
        if (this.I && this.N != 5) {
            a0.d(view, c.f2536j, new b0.j(this, 5));
        }
        int i14 = this.N;
        if (i14 == 3) {
            a0.d(view, c.f2535i, new b0.j(this, this.f1234b ? 4 : 6));
            return;
        }
        if (i14 == 4) {
            a0.d(view, c.f2534h, new b0.j(this, this.f1234b ? 3 : 6));
        } else {
            if (i14 != 6) {
                return;
            }
            a0.d(view, c.f2535i, new b0.j(this, 4));
            a0.d(view, c.f2534h, new b0.j(this, 3));
        }
    }

    public final void G(int i8, boolean z) {
        j jVar;
        if (i8 == 2) {
            return;
        }
        boolean z2 = this.N == 3 && (this.f1260x || z());
        if (this.z == z2 || (jVar = this.f1245i) == null) {
            return;
        }
        this.z = z2;
        ValueAnimator valueAnimator = this.B;
        if (z && valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                valueAnimator.reverse();
                return;
            } else {
                valueAnimator.setFloatValues(jVar.f5475b.f5465j, z2 ? s() : 1.0f);
                valueAnimator.start();
                return;
            }
        }
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
        float fS = this.z ? s() : 1.0f;
        h hVar = jVar.f5475b;
        if (hVar.f5465j != fS) {
            hVar.f5465j = fS;
            jVar.f5478f = true;
            jVar.f5479g = true;
            jVar.invalidateSelf();
        }
    }

    public final void H(boolean z) {
        WeakReference weakReference = this.W;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                if (this.f1238d0 != null) {
                    return;
                } else {
                    this.f1238d0 = new HashMap(childCount);
                }
            }
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = coordinatorLayout.getChildAt(i8);
                if (childAt != this.W.get() && z) {
                    this.f1238d0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z) {
                return;
            }
            this.f1238d0 = null;
        }
    }

    public final void I() {
        View view;
        if (this.W != null) {
            r();
            if (this.N != 4 || (view = (View) this.W.get()) == null) {
                return;
            }
            view.requestLayout();
        }
    }

    @Override // t.a
    public final void c(d dVar) {
        this.W = null;
        this.O = null;
    }

    @Override // t.a
    public final void e() {
        this.W = null;
        this.O = null;
    }

    @Override // t.a
    public final boolean f(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int i8;
        e eVar;
        if (!view.isShown() || !this.K) {
            this.P = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1233a0 = -1;
            this.f1235b0 = -1;
            VelocityTracker velocityTracker = this.Z;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.Z = null;
            }
        }
        if (this.Z == null) {
            this.Z = VelocityTracker.obtain();
        }
        this.Z.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x7 = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            this.f1235b0 = y;
            if (this.N != 2) {
                WeakReference weakReference = this.X;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.o(view2, x7, y)) {
                    this.f1233a0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f1237c0 = true;
                }
            }
            this.P = this.f1233a0 == -1 && !coordinatorLayout.o(view, x7, this.f1235b0);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f1237c0 = false;
            this.f1233a0 = -1;
            if (this.P) {
                this.P = false;
                return false;
            }
        }
        if (this.P || (eVar = this.O) == null || !eVar.p(motionEvent)) {
            WeakReference weakReference2 = this.X;
            View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
            if (actionMasked != 2 || view3 == null || this.P || this.N == 1 || coordinatorLayout.o(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.O == null || (i8 = this.f1235b0) == -1 || Math.abs(i8 - motionEvent.getY()) <= this.O.f3108b) {
                return false;
            }
        }
        return true;
    }

    @Override // t.a
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, int i8) throws Resources.NotFoundException {
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        if (this.W == null) {
            this.f1243g = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            boolean z = (this.f1250n || this.f1241f) ? false : true;
            if (this.f1251o || this.f1252p || this.f1253q || this.f1255s || this.f1256t || this.f1257u || z) {
                c0.f fVar = new c0.f(this, z);
                int paddingStart = view.getPaddingStart();
                view.getPaddingTop();
                int paddingEnd = view.getPaddingEnd();
                int paddingBottom = view.getPaddingBottom();
                m mVar = new m();
                mVar.f4724a = paddingStart;
                mVar.f4725b = paddingEnd;
                mVar.f4726c = paddingBottom;
                p pVar = new p(fVar, 13, mVar);
                int[] iArr = a0.f2285a;
                u.b(view, pVar);
                if (view.isAttachedToWindow()) {
                    view.requestApplyInsets();
                } else {
                    view.addOnAttachStateChangeListener(new l());
                }
            }
            i1.d dVar = new i1.d(view);
            int[] iArr2 = a0.f2285a;
            view.setWindowInsetsAnimationCallback(new b0(dVar));
            this.W = new WeakReference(view);
            new PathInterpolator(0.1f, 0.1f, 0.0f, 1.0f);
            Context context = view.getContext();
            v.g0(context, R.attr.motionDurationMedium2, 300);
            v.g0(context, R.attr.motionDurationShort3, 150);
            v.g0(context, R.attr.motionDurationShort2, 100);
            Resources resources = view.getResources();
            resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_x_distance);
            resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_y_distance);
            j jVar = this.f1245i;
            if (jVar != null) {
                view.setBackground(jVar);
                float elevation = this.H;
                if (elevation == -1.0f) {
                    elevation = view.getElevation();
                }
                jVar.l(elevation);
            } else {
                ColorStateList colorStateList = this.f1246j;
                if (colorStateList != null) {
                    view.setBackgroundTintList(colorStateList);
                }
            }
            F();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
        }
        if (this.O == null) {
            this.O = new e(coordinatorLayout.getContext(), coordinatorLayout, this.f1242f0);
        }
        int top = view.getTop();
        coordinatorLayout.q(view, i8);
        this.U = coordinatorLayout.getWidth();
        this.V = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.T = height;
        int iMin = this.V;
        int i9 = iMin - height;
        int i10 = this.f1259w;
        if (i9 < i10) {
            boolean z2 = this.f1254r;
            int i11 = this.f1248l;
            if (z2) {
                if (i11 != -1) {
                    iMin = Math.min(iMin, i11);
                }
                this.T = iMin;
            } else {
                int iMin2 = iMin - i10;
                if (i11 != -1) {
                    iMin2 = Math.min(iMin2, i11);
                }
                this.T = iMin2;
            }
        }
        this.D = Math.max(0, this.V - this.T);
        this.E = (int) ((1.0f - this.F) * this.V);
        r();
        int i12 = this.N;
        if (i12 == 3) {
            int iX = x();
            int[] iArr3 = a0.f2285a;
            view.offsetTopAndBottom(iX);
        } else if (i12 == 6) {
            int i13 = this.E;
            int[] iArr4 = a0.f2285a;
            view.offsetTopAndBottom(i13);
        } else if (this.I && i12 == 5) {
            int i14 = this.V;
            int[] iArr5 = a0.f2285a;
            view.offsetTopAndBottom(i14);
        } else if (i12 == 4) {
            int i15 = this.G;
            int[] iArr6 = a0.f2285a;
            view.offsetTopAndBottom(i15);
        } else if (i12 == 1 || i12 == 2) {
            int top2 = top - view.getTop();
            int[] iArr7 = a0.f2285a;
            view.offsetTopAndBottom(top2);
        }
        G(this.N, false);
        this.X = new WeakReference(v(view));
        ArrayList arrayList = this.Y;
        if (arrayList.size() <= 0) {
            return true;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    @Override // t.a
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i8, int i9, int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(w(i8, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i9, this.f1247k, marginLayoutParams.width), w(i10, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, this.f1248l, marginLayoutParams.height));
        return true;
    }

    @Override // t.a
    public final boolean i(View view) {
        WeakReference weakReference = this.X;
        return (weakReference == null || view != weakReference.get() || this.N == 3 || this.M) ? false : true;
    }

    @Override // t.a
    public final void j(CoordinatorLayout coordinatorLayout, View view, View view2, int i8, int i9, int[] iArr, int i10) throws Resources.NotFoundException {
        if (i10 == 1) {
            return;
        }
        WeakReference weakReference = this.X;
        View view3 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != view3) {
            return;
        }
        int top = view.getTop();
        int i11 = top - i9;
        boolean z = this.K;
        boolean z2 = this.L;
        if (i9 > 0) {
            if (!this.R && !z2 && view2 == view3 && view2.canScrollVertically(1)) {
                this.M = true;
                return;
            }
            if (i11 < x()) {
                int iX = top - x();
                iArr[1] = iX;
                int[] iArr2 = a0.f2285a;
                view.offsetTopAndBottom(-iX);
                C(3);
            } else {
                if (!z) {
                    return;
                }
                iArr[1] = i9;
                int[] iArr3 = a0.f2285a;
                view.offsetTopAndBottom(-i9);
                C(1);
            }
        } else if (i9 < 0) {
            boolean zCanScrollVertically = view2.canScrollVertically(-1);
            if (!this.R && !z2 && view2 == view3 && zCanScrollVertically) {
                this.M = true;
                return;
            }
            if (!zCanScrollVertically) {
                int i12 = this.G;
                if (i11 > i12 && !this.I) {
                    int i13 = top - i12;
                    iArr[1] = i13;
                    int[] iArr4 = a0.f2285a;
                    view.offsetTopAndBottom(-i13);
                    C(4);
                } else {
                    if (!z) {
                        return;
                    }
                    iArr[1] = i9;
                    int[] iArr5 = a0.f2285a;
                    view.offsetTopAndBottom(-i9);
                    C(1);
                }
            }
        }
        u(view.getTop());
        this.Q = i9;
        this.R = true;
        this.M = false;
    }

    @Override // t.a
    public final void m(View view, Parcelable parcelable) {
        i1.c cVar = (i1.c) parcelable;
        int i8 = this.f1232a;
        if (i8 != 0) {
            if (i8 == -1 || (i8 & 1) == 1) {
                this.f1239e = cVar.d;
            }
            if (i8 == -1 || (i8 & 2) == 2) {
                this.f1234b = cVar.f3131e;
            }
            if (i8 == -1 || (i8 & 4) == 4) {
                this.I = cVar.f3132f;
            }
            if (i8 == -1 || (i8 & 8) == 8) {
                this.J = cVar.f3133g;
            }
        }
        int i9 = cVar.f3130c;
        if (i9 == 1 || i9 == 2) {
            this.N = 4;
        } else {
            this.N = i9;
        }
    }

    @Override // t.a
    public final Parcelable n(View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new i1.c(this);
    }

    @Override // t.a
    public final boolean o(View view, int i8, int i9) {
        this.Q = 0;
        this.R = false;
        return (i8 & 2) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    @Override // t.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(android.view.View r4, android.view.View r5, int r6) throws android.content.res.Resources.NotFoundException {
        /*
            r3 = this;
            int r6 = r4.getTop()
            int r0 = r3.x()
            r1 = 3
            if (r6 != r0) goto Lf
            r3.C(r1)
            return
        Lf:
            java.lang.ref.WeakReference r6 = r3.X
            if (r6 == 0) goto Lb5
            java.lang.Object r6 = r6.get()
            if (r5 != r6) goto Lb5
            boolean r5 = r3.R
            if (r5 != 0) goto L1f
            goto Lb5
        L1f:
            int r5 = r3.Q
            r6 = 6
            if (r5 <= 0) goto L34
            boolean r5 = r3.f1234b
            if (r5 == 0) goto L2a
            goto Laf
        L2a:
            int r5 = r4.getTop()
            int r0 = r3.E
            if (r5 <= r0) goto Laf
            goto Lae
        L34:
            boolean r5 = r3.I
            if (r5 == 0) goto L55
            android.view.VelocityTracker r5 = r3.Z
            if (r5 != 0) goto L3e
            r5 = 0
            goto L4d
        L3e:
            r0 = 1000(0x3e8, float:1.401E-42)
            float r2 = r3.f1236c
            r5.computeCurrentVelocity(r0, r2)
            android.view.VelocityTracker r5 = r3.Z
            int r0 = r3.f1233a0
            float r5 = r5.getYVelocity(r0)
        L4d:
            boolean r5 = r3.D(r4, r5)
            if (r5 == 0) goto L55
            r1 = 5
            goto Laf
        L55:
            int r5 = r3.Q
            r0 = 4
            if (r5 != 0) goto L93
            int r5 = r4.getTop()
            boolean r2 = r3.f1234b
            if (r2 == 0) goto L74
            int r6 = r3.D
            int r6 = r5 - r6
            int r6 = java.lang.Math.abs(r6)
            int r2 = r3.G
            int r5 = r5 - r2
            int r5 = java.lang.Math.abs(r5)
            if (r6 >= r5) goto L97
            goto Laf
        L74:
            int r2 = r3.E
            if (r5 >= r2) goto L83
            int r0 = r3.G
            int r0 = r5 - r0
            int r0 = java.lang.Math.abs(r0)
            if (r5 >= r0) goto Lae
            goto Laf
        L83:
            int r1 = r5 - r2
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.G
            int r5 = r5 - r2
            int r5 = java.lang.Math.abs(r5)
            if (r1 >= r5) goto L97
            goto Lae
        L93:
            boolean r5 = r3.f1234b
            if (r5 == 0) goto L99
        L97:
            r1 = r0
            goto Laf
        L99:
            int r5 = r4.getTop()
            int r1 = r3.E
            int r1 = r5 - r1
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.G
            int r5 = r5 - r2
            int r5 = java.lang.Math.abs(r5)
            if (r1 >= r5) goto L97
        Lae:
            r1 = r6
        Laf:
            r5 = 0
            r3.E(r4, r1, r5)
            r3.R = r5
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.p(android.view.View, android.view.View, int):void");
    }

    @Override // t.a
    public final boolean q(View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i8 = this.N;
        if (i8 == 1 && actionMasked == 0) {
            return true;
        }
        e eVar = this.O;
        if (eVar != null && (this.K || i8 == 1)) {
            eVar.j(motionEvent);
        }
        if (actionMasked == 0) {
            this.f1233a0 = -1;
            this.f1235b0 = -1;
            VelocityTracker velocityTracker = this.Z;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.Z = null;
            }
        }
        if (this.Z == null) {
            this.Z = VelocityTracker.obtain();
        }
        this.Z.addMovement(motionEvent);
        if (this.O != null && ((this.K || this.N == 1) && actionMasked == 2 && !this.P)) {
            float fAbs = Math.abs(this.f1235b0 - motionEvent.getY());
            e eVar2 = this.O;
            if (fAbs > eVar2.f3108b) {
                eVar2.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.P;
    }

    public final void r() {
        int iT = t();
        if (this.f1234b) {
            this.G = Math.max(this.V - iT, this.D);
        } else {
            this.G = this.V - iT;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float s() {
        /*
            r6 = this;
            t1.j r0 = r6.f1245i
            r1 = 0
            if (r0 == 0) goto L84
            java.lang.ref.WeakReference r0 = r6.W
            if (r0 == 0) goto L84
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L84
            java.lang.ref.WeakReference r0 = r6.W
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            boolean r2 = r6.z()
            if (r2 == 0) goto L84
            android.view.WindowInsets r0 = r0.getRootWindowInsets()
            if (r0 == 0) goto L84
            t1.j r2 = r6.f1245i
            float[] r3 = r2.A
            if (r3 == 0) goto L2d
            r2 = 3
            r2 = r3[r2]
            goto L3b
        L2d:
            t1.h r3 = r2.f5475b
            t1.n r3 = r3.f5457a
            t1.d r3 = r3.f5511e
            android.graphics.RectF r2 = r2.f()
            float r2 = r3.a(r2)
        L3b:
            r3 = 0
            android.view.RoundedCorner r4 = r0.getRoundedCorner(r3)
            if (r4 == 0) goto L51
            int r4 = r4.getRadius()
            float r4 = (float) r4
            int r5 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r5 <= 0) goto L51
            int r5 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r5 <= 0) goto L51
            float r4 = r4 / r2
            goto L52
        L51:
            r4 = r1
        L52:
            t1.j r6 = r6.f1245i
            float[] r2 = r6.A
            if (r2 == 0) goto L5b
            r6 = r2[r3]
            goto L69
        L5b:
            t1.h r2 = r6.f5475b
            t1.n r2 = r2.f5457a
            t1.d r2 = r2.f5512f
            android.graphics.RectF r6 = r6.f()
            float r6 = r2.a(r6)
        L69:
            r2 = 1
            android.view.RoundedCorner r0 = r0.getRoundedCorner(r2)
            if (r0 == 0) goto L7f
            int r0 = r0.getRadius()
            float r0 = (float) r0
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 <= 0) goto L7f
            int r2 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r2 <= 0) goto L7f
            float r1 = r0 / r6
        L7f:
            float r6 = java.lang.Math.max(r4, r1)
            return r6
        L84:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.s():float");
    }

    public final int t() {
        int iMin;
        int i8;
        int i9;
        if (this.f1241f) {
            iMin = Math.min(Math.max(this.f1243g, this.V - ((this.U * 9) / 16)), this.T);
            i8 = this.f1258v;
        } else {
            if (!this.f1250n && !this.f1251o && (i9 = this.f1249m) > 0) {
                return Math.max(this.f1239e, i9 + this.f1244h);
            }
            iMin = this.f1239e;
            i8 = this.f1258v;
        }
        return iMin + i8;
    }

    public final void u(int i8) {
        if (((View) this.W.get()) != null) {
            ArrayList arrayList = this.Y;
            if (arrayList.isEmpty()) {
                return;
            }
            int i9 = this.G;
            if (i8 <= i9 && i9 != x()) {
                x();
            }
            if (arrayList.size() <= 0) {
                return;
            }
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
    }

    public final int x() {
        if (this.f1234b) {
            return this.D;
        }
        return Math.max(this.C, this.f1254r ? 0 : this.f1259w);
    }

    public final int y(int i8) {
        if (i8 == 3) {
            return x();
        }
        if (i8 == 4) {
            return this.G;
        }
        if (i8 == 5) {
            return this.V;
        }
        if (i8 == 6) {
            return this.E;
        }
        throw new IllegalArgumentException(a8.b.j(i8, "Invalid state to get top offset: "));
    }

    public final boolean z() {
        WeakReference weakReference = this.W;
        if (weakReference != null && weakReference.get() != null) {
            int[] iArr = new int[2];
            ((View) this.W.get()).getLocationOnScreen(iArr);
            if (iArr[1] == 0) {
                return true;
            }
        }
        return false;
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        int i8;
        int i9 = 0;
        this.f1232a = 0;
        this.f1234b = true;
        this.f1247k = -1;
        this.f1248l = -1;
        this.A = new androidx.fragment.app.a(this);
        this.F = 0.5f;
        this.H = -1.0f;
        this.K = true;
        this.L = true;
        this.N = 4;
        this.S = 0.1f;
        this.Y = new ArrayList();
        this.f1235b0 = -1;
        this.f1240e0 = new SparseIntArray();
        this.f1242f0 = new b(this, i9);
        this.f1244h = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d1.a.f1760a);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.f1246j = v.D(context, typedArrayObtainStyledAttributes, 3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(22)) {
            this.y = n.b(context, attributeSet, R.attr.bottomSheetStyle, R.style.Widget_Design_BottomSheet_Modal).a();
        }
        n nVar = this.y;
        if (nVar != null) {
            j jVar = new j(nVar);
            this.f1245i = jVar;
            jVar.j(context);
            ColorStateList colorStateList = this.f1246j;
            if (colorStateList != null) {
                this.f1245i.m(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.f1245i.setTint(typedValue.data);
            }
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(s(), 1.0f);
        this.B = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.B.addUpdateListener(new i1.a(i9, this));
        this.H = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            this.f1247k = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            this.f1248l = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, -1);
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(10);
        if (typedValuePeekValue != null && (i8 = typedValuePeekValue.data) == -1) {
            A(i8);
        } else {
            A(typedArrayObtainStyledAttributes.getDimensionPixelSize(10, -1));
        }
        boolean z = typedArrayObtainStyledAttributes.getBoolean(9, false);
        if (this.I != z) {
            this.I = z;
            if (!z && this.N == 5) {
                B(4);
            }
            F();
        }
        this.f1250n = typedArrayObtainStyledAttributes.getBoolean(14, false);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(7, true);
        if (this.f1234b != z2) {
            this.f1234b = z2;
            if (this.W != null) {
                r();
            }
            C((this.f1234b && this.N == 6) ? 3 : this.N);
            G(this.N, true);
            F();
        }
        this.J = typedArrayObtainStyledAttributes.getBoolean(13, false);
        this.K = typedArrayObtainStyledAttributes.getBoolean(4, true);
        this.L = typedArrayObtainStyledAttributes.getBoolean(5, true);
        this.f1232a = typedArrayObtainStyledAttributes.getInt(11, 0);
        float f3 = typedArrayObtainStyledAttributes.getFloat(8, 0.5f);
        if (f3 > 0.0f && f3 < 1.0f) {
            this.F = f3;
            if (this.W != null) {
                this.E = (int) ((1.0f - f3) * this.V);
            }
            TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(6);
            if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
                int i10 = typedValuePeekValue2.data;
                if (i10 >= 0) {
                    this.C = i10;
                    G(this.N, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            } else {
                int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(6, 0);
                if (dimensionPixelOffset >= 0) {
                    this.C = dimensionPixelOffset;
                    G(this.N, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            }
            this.d = typedArrayObtainStyledAttributes.getInt(12, 500);
            this.f1251o = typedArrayObtainStyledAttributes.getBoolean(18, false);
            this.f1252p = typedArrayObtainStyledAttributes.getBoolean(19, false);
            this.f1253q = typedArrayObtainStyledAttributes.getBoolean(20, false);
            this.f1254r = typedArrayObtainStyledAttributes.getBoolean(21, true);
            this.f1255s = typedArrayObtainStyledAttributes.getBoolean(15, false);
            this.f1256t = typedArrayObtainStyledAttributes.getBoolean(16, false);
            this.f1257u = typedArrayObtainStyledAttributes.getBoolean(17, false);
            this.f1260x = typedArrayObtainStyledAttributes.getBoolean(24, true);
            typedArrayObtainStyledAttributes.recycle();
            this.f1236c = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    @Override // t.a
    public final void k(CoordinatorLayout coordinatorLayout, View view, int i8, int i9, int i10, int[] iArr) {
    }
}
