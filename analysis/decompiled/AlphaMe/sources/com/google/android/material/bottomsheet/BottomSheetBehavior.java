package com.google.android.material.bottomsheet;

import A.b;
import A.d;
import B0.f;
import B0.g;
import B0.m;
import K.C0067a;
import K.C0069b;
import K.J;
import K.O;
import K.S;
import K.l0;
import Q.e;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.C0186l;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import androidx.room.AbstractC0351g;
import com.airbnb.lottie.q;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.google.android.gms.common.api.internal.k;
import com.google.android.material.internal.o;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import e.EnumC0546d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;
import m1.AbstractC0769a;
import p1.C0814a;
import p1.C0815b;
import p1.c;
import y1.h;
import y1.j;
import y1.n;

/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends b {

    /* renamed from: A, reason: collision with root package name */
    public final k f10406A;

    /* renamed from: B, reason: collision with root package name */
    public final ValueAnimator f10407B;

    /* renamed from: C, reason: collision with root package name */
    public final int f10408C;

    /* renamed from: D, reason: collision with root package name */
    public int f10409D;

    /* renamed from: E, reason: collision with root package name */
    public int f10410E;

    /* renamed from: F, reason: collision with root package name */
    public final float f10411F;

    /* renamed from: G, reason: collision with root package name */
    public int f10412G;

    /* renamed from: H, reason: collision with root package name */
    public final float f10413H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f10414I;

    /* renamed from: J, reason: collision with root package name */
    public boolean f10415J;

    /* renamed from: K, reason: collision with root package name */
    public final boolean f10416K;

    /* renamed from: L, reason: collision with root package name */
    public final boolean f10417L;

    /* renamed from: M, reason: collision with root package name */
    public boolean f10418M;

    /* renamed from: N, reason: collision with root package name */
    public int f10419N;

    /* renamed from: O, reason: collision with root package name */
    public e f10420O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f10421P;

    /* renamed from: Q, reason: collision with root package name */
    public int f10422Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f10423R;

    /* renamed from: S, reason: collision with root package name */
    public final float f10424S;
    public int T;

    /* renamed from: U, reason: collision with root package name */
    public int f10425U;

    /* renamed from: V, reason: collision with root package name */
    public int f10426V;

    /* renamed from: W, reason: collision with root package name */
    public WeakReference f10427W;

    /* renamed from: X, reason: collision with root package name */
    public WeakReference f10428X;

    /* renamed from: Y, reason: collision with root package name */
    public final ArrayList f10429Y;

    /* renamed from: Z, reason: collision with root package name */
    public VelocityTracker f10430Z;

    /* renamed from: a, reason: collision with root package name */
    public final int f10431a;

    /* renamed from: a0, reason: collision with root package name */
    public int f10432a0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f10433b;

    /* renamed from: b0, reason: collision with root package name */
    public int f10434b0;

    /* renamed from: c, reason: collision with root package name */
    public final float f10435c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f10436c0;

    /* renamed from: d, reason: collision with root package name */
    public final int f10437d;

    /* renamed from: d0, reason: collision with root package name */
    public HashMap f10438d0;

    /* renamed from: e, reason: collision with root package name */
    public int f10439e;

    /* renamed from: e0, reason: collision with root package name */
    public final SparseIntArray f10440e0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10441f;

    /* renamed from: f0, reason: collision with root package name */
    public final C0815b f10442f0;

    /* renamed from: g, reason: collision with root package name */
    public int f10443g;

    /* renamed from: h, reason: collision with root package name */
    public final int f10444h;

    /* renamed from: i, reason: collision with root package name */
    public final j f10445i;

    /* renamed from: j, reason: collision with root package name */
    public final ColorStateList f10446j;

    /* renamed from: k, reason: collision with root package name */
    public final int f10447k;

    /* renamed from: l, reason: collision with root package name */
    public final int f10448l;

    /* renamed from: m, reason: collision with root package name */
    public int f10449m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f10450n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f10451o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f10452p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f10453q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f10454r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f10455s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f10456t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f10457u;

    /* renamed from: v, reason: collision with root package name */
    public int f10458v;

    /* renamed from: w, reason: collision with root package name */
    public int f10459w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f10460x;

    /* renamed from: y, reason: collision with root package name */
    public final n f10461y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f10462z;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({EnumC0546d.f12493b})
    public @interface SaveFlags {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({EnumC0546d.f12493b})
    public @interface StableState {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({EnumC0546d.f12493b})
    public @interface State {
    }

    public BottomSheetBehavior() {
        this.f10431a = 0;
        this.f10433b = true;
        this.f10447k = -1;
        this.f10448l = -1;
        this.f10406A = new k(this, 0);
        this.f10411F = 0.5f;
        this.f10413H = -1.0f;
        this.f10416K = true;
        this.f10417L = true;
        this.f10419N = 4;
        this.f10424S = 0.1f;
        this.f10429Y = new ArrayList();
        this.f10434b0 = -1;
        this.f10440e0 = new SparseIntArray();
        this.f10442f0 = new C0815b(this);
    }

    public static View g(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (view.isNestedScrollingEnabled()) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View viewG = g(viewGroup.getChildAt(i4));
                if (viewG != null) {
                    return viewG;
                }
            }
        }
        return null;
    }

    public static int h(int i4, int i5, int i6, int i7) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i4, i5, i7);
        if (i6 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i6), 1073741824);
        }
        if (size != 0) {
            i6 = Math.min(size, i6);
        }
        return View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE);
    }

    public final void c() {
        int iE = e();
        if (this.f10433b) {
            this.f10412G = Math.max(this.f10426V - iE, this.f10409D);
        } else {
            this.f10412G = this.f10426V - iE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float d() {
        /*
            r6 = this;
            y1.j r0 = r6.f10445i
            r1 = 0
            if (r0 == 0) goto L84
            java.lang.ref.WeakReference r0 = r6.f10427W
            if (r0 == 0) goto L84
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L84
            java.lang.ref.WeakReference r0 = r6.f10427W
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            boolean r2 = r6.k()
            if (r2 == 0) goto L84
            android.view.WindowInsets r0 = r0.getRootWindowInsets()
            if (r0 == 0) goto L84
            y1.j r2 = r6.f10445i
            float[] r3 = r2.f16230C
            if (r3 == 0) goto L2d
            r2 = 3
            r2 = r3[r2]
            goto L3b
        L2d:
            y1.h r3 = r2.f16234b
            y1.n r3 = r3.f16203a
            y1.d r3 = r3.f16276e
            android.graphics.RectF r2 = r2.h()
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
            y1.j r6 = r6.f10445i
            float[] r2 = r6.f16230C
            if (r2 == 0) goto L5b
            r6 = r2[r3]
            goto L69
        L5b:
            y1.h r2 = r6.f16234b
            y1.n r2 = r2.f16203a
            y1.d r2 = r2.f16277f
            android.graphics.RectF r6 = r6.h()
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.d():float");
    }

    public final int e() {
        int iMin;
        int i4;
        int i5;
        if (this.f10441f) {
            iMin = Math.min(Math.max(this.f10443g, this.f10426V - ((this.f10425U * 9) / 16)), this.T);
            i4 = this.f10458v;
        } else {
            if (!this.f10450n && !this.f10451o && (i5 = this.f10449m) > 0) {
                return Math.max(this.f10439e, i5 + this.f10444h);
            }
            iMin = this.f10439e;
            i4 = this.f10458v;
        }
        return iMin + i4;
    }

    public final void f(int i4) {
        if (((View) this.f10427W.get()) != null) {
            ArrayList arrayList = this.f10429Y;
            if (arrayList.isEmpty()) {
                return;
            }
            int i5 = this.f10412G;
            if (i4 <= i5 && i5 != i()) {
                i();
            }
            if (arrayList.size() <= 0) {
                return;
            }
            g.y(arrayList.get(0));
            throw null;
        }
    }

    public final int i() {
        if (this.f10433b) {
            return this.f10409D;
        }
        return Math.max(this.f10408C, this.f10454r ? 0 : this.f10459w);
    }

    public final int j(int i4) {
        if (i4 == 3) {
            return i();
        }
        if (i4 == 4) {
            return this.f10412G;
        }
        if (i4 == 5) {
            return this.f10426V;
        }
        if (i4 == 6) {
            return this.f10410E;
        }
        throw new IllegalArgumentException(AbstractC0351g.m("Invalid state to get top offset: ", i4));
    }

    public final boolean k() {
        WeakReference weakReference = this.f10427W;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        int[] iArr = new int[2];
        ((View) this.f10427W.get()).getLocationOnScreen(iArr);
        return iArr[1] == 0;
    }

    public final void l(int i4) {
        if (i4 == -1) {
            if (this.f10441f) {
                return;
            } else {
                this.f10441f = true;
            }
        } else {
            if (!this.f10441f && this.f10439e == i4) {
                return;
            }
            this.f10441f = false;
            this.f10439e = Math.max(0, i4);
        }
        t();
    }

    public final void m(int i4) {
        if (i4 == 1 || i4 == 2) {
            throw new IllegalArgumentException(g.r(new StringBuilder("STATE_"), i4 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        if (!this.f10414I && i4 == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i4);
            return;
        }
        int i5 = (i4 == 6 && this.f10433b && j(i4) <= this.f10409D) ? 3 : i4;
        WeakReference weakReference = this.f10427W;
        if (weakReference == null || weakReference.get() == null) {
            n(i4);
            return;
        }
        View view = (View) this.f10427W.get();
        android.support.v4.os.a aVar = new android.support.v4.os.a(this, view, i5, 8);
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested() && view.isAttachedToWindow()) {
            view.post(aVar);
        } else {
            aVar.run();
        }
    }

    public final void n(int i4) {
        if (this.f10419N == i4) {
            return;
        }
        this.f10419N = i4;
        if (i4 != 4 && i4 != 3 && i4 != 6) {
            boolean z4 = this.f10414I;
        }
        WeakReference weakReference = this.f10427W;
        if (weakReference == null || ((View) weakReference.get()) == null) {
            return;
        }
        if (i4 == 3) {
            s(true);
        } else if (i4 == 6 || i4 == 5 || i4 == 4) {
            s(false);
        }
        r(i4, true);
        ArrayList arrayList = this.f10429Y;
        if (arrayList.size() <= 0) {
            q();
        } else {
            g.y(arrayList.get(0));
            throw null;
        }
    }

    public final boolean o(View view, float f4) {
        if (this.f10415J) {
            return true;
        }
        if (view.getTop() < this.f10412G) {
            return false;
        }
        return Math.abs(((f4 * this.f10424S) + ((float) view.getTop())) - ((float) this.f10412G)) / ((float) e()) > 0.5f;
    }

    @Override // A.b
    public final void onAttachedToLayoutParams(d dVar) {
        super.onAttachedToLayoutParams(dVar);
        this.f10427W = null;
        this.f10420O = null;
    }

    @Override // A.b
    public final void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.f10427W = null;
        this.f10420O = null;
    }

    @Override // A.b
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int i4;
        e eVar;
        if (!view.isShown() || !this.f10416K) {
            this.f10421P = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f10432a0 = -1;
            this.f10434b0 = -1;
            VelocityTracker velocityTracker = this.f10430Z;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f10430Z = null;
            }
        }
        if (this.f10430Z == null) {
            this.f10430Z = VelocityTracker.obtain();
        }
        this.f10430Z.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x4 = (int) motionEvent.getX();
            int y4 = (int) motionEvent.getY();
            this.f10434b0 = y4;
            if (this.f10419N != 2) {
                WeakReference weakReference = this.f10428X;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.z(view2, x4, y4)) {
                    this.f10432a0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f10436c0 = true;
                }
            }
            this.f10421P = this.f10432a0 == -1 && !coordinatorLayout.z(view, x4, this.f10434b0);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f10436c0 = false;
            this.f10432a0 = -1;
            if (this.f10421P) {
                this.f10421P = false;
                return false;
            }
        }
        if (!this.f10421P && (eVar = this.f10420O) != null && eVar.p(motionEvent)) {
            return true;
        }
        WeakReference weakReference2 = this.f10428X;
        View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
        return (actionMasked != 2 || view3 == null || this.f10421P || this.f10419N == 1 || coordinatorLayout.z(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.f10420O == null || (i4 = this.f10434b0) == -1 || Math.abs(((float) i4) - motionEvent.getY()) <= ((float) this.f10420O.f1606b)) ? false : true;
    }

    @Override // A.b
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i4) throws Resources.NotFoundException {
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        if (this.f10427W == null) {
            this.f10443g = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            boolean z4 = (this.f10450n || this.f10441f) ? false : true;
            if (this.f10451o || this.f10452p || this.f10453q || this.f10455s || this.f10456t || this.f10457u || z4) {
                C0814a c0814a = new C0814a(this, z4);
                int paddingStart = view.getPaddingStart();
                view.getPaddingTop();
                int paddingEnd = view.getPaddingEnd();
                int paddingBottom = view.getPaddingBottom();
                o oVar = new o();
                oVar.f10865a = paddingStart;
                oVar.f10866b = paddingEnd;
                oVar.f10867c = paddingBottom;
                m mVar = new m(c0814a, oVar);
                WeakHashMap weakHashMap = S.f939a;
                J.u(view, mVar);
                if (view.isAttachedToWindow()) {
                    view.requestApplyInsets();
                } else {
                    view.addOnAttachStateChangeListener(new com.google.android.material.internal.n());
                }
            }
            c cVar = new c(view);
            WeakHashMap weakHashMap2 = S.f939a;
            view.setWindowInsetsAnimationCallback(new l0(cVar));
            this.f10427W = new WeakReference(view);
            new PathInterpolator(0.1f, 0.1f, Property.DEFAULT_FLOAT_VALUE, 1.0f);
            Context context = view.getContext();
            com.stepos.statsrpk.c.L(context, R.attr.motionDurationMedium2, UIMsg.MsgDefine.RENDER_STATE_FIRST_FRAME);
            com.stepos.statsrpk.c.L(context, R.attr.motionDurationShort3, 150);
            com.stepos.statsrpk.c.L(context, R.attr.motionDurationShort2, 100);
            Resources resources = view.getResources();
            resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_x_distance);
            resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_y_distance);
            j jVar = this.f10445i;
            if (jVar != null) {
                view.setBackground(jVar);
                j jVar2 = this.f10445i;
                float elevation = this.f10413H;
                if (elevation == -1.0f) {
                    elevation = view.getElevation();
                }
                jVar2.n(elevation);
            } else {
                ColorStateList colorStateList = this.f10446j;
                if (colorStateList != null) {
                    J.q(view, colorStateList);
                }
            }
            q();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
        }
        if (this.f10420O == null) {
            this.f10420O = new e(coordinatorLayout.getContext(), coordinatorLayout, this.f10442f0);
        }
        int top = view.getTop();
        coordinatorLayout.B(i4, view);
        this.f10425U = coordinatorLayout.getWidth();
        this.f10426V = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.T = height;
        int iMin = this.f10426V;
        int i5 = iMin - height;
        int i6 = this.f10459w;
        if (i5 < i6) {
            if (this.f10454r) {
                int i7 = this.f10448l;
                if (i7 != -1) {
                    iMin = Math.min(iMin, i7);
                }
                this.T = iMin;
            } else {
                int iMin2 = iMin - i6;
                int i8 = this.f10448l;
                if (i8 != -1) {
                    iMin2 = Math.min(iMin2, i8);
                }
                this.T = iMin2;
            }
        }
        this.f10409D = Math.max(0, this.f10426V - this.T);
        this.f10410E = (int) ((1.0f - this.f10411F) * this.f10426V);
        c();
        int i9 = this.f10419N;
        if (i9 == 3) {
            int i10 = i();
            WeakHashMap weakHashMap3 = S.f939a;
            view.offsetTopAndBottom(i10);
        } else if (i9 == 6) {
            int i11 = this.f10410E;
            WeakHashMap weakHashMap4 = S.f939a;
            view.offsetTopAndBottom(i11);
        } else if (this.f10414I && i9 == 5) {
            int i12 = this.f10426V;
            WeakHashMap weakHashMap5 = S.f939a;
            view.offsetTopAndBottom(i12);
        } else if (i9 == 4) {
            int i13 = this.f10412G;
            WeakHashMap weakHashMap6 = S.f939a;
            view.offsetTopAndBottom(i13);
        } else if (i9 == 1 || i9 == 2) {
            int top2 = top - view.getTop();
            WeakHashMap weakHashMap7 = S.f939a;
            view.offsetTopAndBottom(top2);
        }
        r(this.f10419N, false);
        this.f10428X = new WeakReference(g(view));
        ArrayList arrayList = this.f10429Y;
        if (arrayList.size() <= 0) {
            return true;
        }
        g.y(arrayList.get(0));
        throw null;
    }

    @Override // A.b
    public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i4, int i5, int i6, int i7) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(h(i4, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i5, this.f10447k, marginLayoutParams.width), h(i6, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, this.f10448l, marginLayoutParams.height));
        return true;
    }

    @Override // A.b
    public final boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, View view, View view2, float f4, float f5) {
        WeakReference weakReference = this.f10428X;
        if (weakReference == null || view2 != weakReference.get()) {
            return false;
        }
        return !(this.f10419N == 3 || this.f10418M) || super.onNestedPreFling(coordinatorLayout, view, view2, f4, f5);
    }

    @Override // A.b
    public final void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i4, int i5, int[] iArr, int i6) {
        if (i6 == 1) {
            return;
        }
        WeakReference weakReference = this.f10428X;
        View view3 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != view3) {
            return;
        }
        int top = view.getTop();
        int i7 = top - i5;
        if (i5 > 0) {
            if (!this.f10423R && !this.f10417L && view2 == view3 && view2.canScrollVertically(1)) {
                this.f10418M = true;
                return;
            }
            if (i7 < i()) {
                int i8 = top - i();
                iArr[1] = i8;
                WeakHashMap weakHashMap = S.f939a;
                view.offsetTopAndBottom(-i8);
                n(3);
            } else {
                if (!this.f10416K) {
                    return;
                }
                iArr[1] = i5;
                WeakHashMap weakHashMap2 = S.f939a;
                view.offsetTopAndBottom(-i5);
                n(1);
            }
        } else if (i5 < 0) {
            boolean zCanScrollVertically = view2.canScrollVertically(-1);
            if (!this.f10423R && !this.f10417L && view2 == view3 && zCanScrollVertically) {
                this.f10418M = true;
                return;
            }
            if (!zCanScrollVertically) {
                int i9 = this.f10412G;
                if (i7 > i9 && !this.f10414I) {
                    int i10 = top - i9;
                    iArr[1] = i10;
                    WeakHashMap weakHashMap3 = S.f939a;
                    view.offsetTopAndBottom(-i10);
                    n(4);
                } else {
                    if (!this.f10416K) {
                        return;
                    }
                    iArr[1] = i5;
                    WeakHashMap weakHashMap4 = S.f939a;
                    view.offsetTopAndBottom(-i5);
                    n(1);
                }
            }
        }
        f(view.getTop());
        this.f10422Q = i5;
        this.f10423R = true;
        this.f10418M = false;
    }

    @Override // A.b
    public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
    }

    @Override // A.b
    public final void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, view, savedState.getSuperState());
        int i4 = this.f10431a;
        if (i4 != 0) {
            if (i4 == -1 || (i4 & 1) == 1) {
                this.f10439e = savedState.f10464b;
            }
            if (i4 == -1 || (i4 & 2) == 2) {
                this.f10433b = savedState.f10465c;
            }
            if (i4 == -1 || (i4 & 4) == 4) {
                this.f10414I = savedState.f10466d;
            }
            if (i4 == -1 || (i4 & 8) == 8) {
                this.f10415J = savedState.f10467e;
            }
        }
        int i5 = savedState.f10463a;
        if (i5 == 1 || i5 == 2) {
            this.f10419N = 4;
        } else {
            this.f10419N = i5;
        }
    }

    @Override // A.b
    public final Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, view), this);
    }

    @Override // A.b
    public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i4, int i5) {
        this.f10422Q = 0;
        this.f10423R = false;
        return (i4 & 2) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    @Override // A.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r3, android.view.View r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.i()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.n(r0)
            return
        Lf:
            java.lang.ref.WeakReference r3 = r2.f10428X
            if (r3 == 0) goto Lb5
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto Lb5
            boolean r3 = r2.f10423R
            if (r3 != 0) goto L1f
            goto Lb5
        L1f:
            int r3 = r2.f10422Q
            r5 = 6
            if (r3 <= 0) goto L34
            boolean r3 = r2.f10433b
            if (r3 == 0) goto L2a
            goto Laf
        L2a:
            int r3 = r4.getTop()
            int r6 = r2.f10410E
            if (r3 <= r6) goto Laf
            goto Lae
        L34:
            boolean r3 = r2.f10414I
            if (r3 == 0) goto L55
            android.view.VelocityTracker r3 = r2.f10430Z
            if (r3 != 0) goto L3e
            r3 = 0
            goto L4d
        L3e:
            r6 = 1000(0x3e8, float:1.401E-42)
            float r1 = r2.f10435c
            r3.computeCurrentVelocity(r6, r1)
            android.view.VelocityTracker r3 = r2.f10430Z
            int r6 = r2.f10432a0
            float r3 = r3.getYVelocity(r6)
        L4d:
            boolean r3 = r2.o(r4, r3)
            if (r3 == 0) goto L55
            r0 = 5
            goto Laf
        L55:
            int r3 = r2.f10422Q
            r6 = 4
            if (r3 != 0) goto L93
            int r3 = r4.getTop()
            boolean r1 = r2.f10433b
            if (r1 == 0) goto L74
            int r5 = r2.f10409D
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.f10412G
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L97
            goto Laf
        L74:
            int r1 = r2.f10410E
            if (r3 >= r1) goto L83
            int r6 = r2.f10412G
            int r6 = r3 - r6
            int r6 = java.lang.Math.abs(r6)
            if (r3 >= r6) goto Lae
            goto Laf
        L83:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.f10412G
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
            goto Lae
        L93:
            boolean r3 = r2.f10433b
            if (r3 == 0) goto L99
        L97:
            r0 = r6
            goto Laf
        L99:
            int r3 = r4.getTop()
            int r0 = r2.f10410E
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.f10412G
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
        Lae:
            r0 = r5
        Laf:
            r3 = 0
            r2.p(r4, r0, r3)
            r2.f10423R = r3
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // A.b
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i4 = this.f10419N;
        if (i4 == 1 && actionMasked == 0) {
            return true;
        }
        e eVar = this.f10420O;
        if (eVar != null && (this.f10416K || i4 == 1)) {
            eVar.j(motionEvent);
        }
        if (actionMasked == 0) {
            this.f10432a0 = -1;
            this.f10434b0 = -1;
            VelocityTracker velocityTracker = this.f10430Z;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f10430Z = null;
            }
        }
        if (this.f10430Z == null) {
            this.f10430Z = VelocityTracker.obtain();
        }
        this.f10430Z.addMovement(motionEvent);
        if (this.f10420O != null && ((this.f10416K || this.f10419N == 1) && actionMasked == 2 && !this.f10421P)) {
            float fAbs = Math.abs(this.f10434b0 - motionEvent.getY());
            e eVar2 = this.f10420O;
            if (fAbs > eVar2.f1606b) {
                eVar2.b(motionEvent.getPointerId(motionEvent.getActionIndex()), view);
            }
        }
        return !this.f10421P;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        if (r3 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        n(2);
        r(r4, true);
        r2.f10406A.a(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        if (r1.o(r3.getLeft(), r0) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(android.view.View r3, int r4, boolean r5) {
        /*
            r2 = this;
            int r0 = r2.j(r4)
            Q.e r1 = r2.f10420O
            if (r1 == 0) goto L40
            if (r5 == 0) goto L15
            int r3 = r3.getLeft()
            boolean r3 = r1.o(r3, r0)
            if (r3 == 0) goto L40
            goto L32
        L15:
            int r5 = r3.getLeft()
            r1.f1622r = r3
            r3 = -1
            r1.f1607c = r3
            r3 = 0
            boolean r3 = r1.h(r5, r0, r3, r3)
            if (r3 != 0) goto L30
            int r5 = r1.f1605a
            if (r5 != 0) goto L30
            android.view.View r5 = r1.f1622r
            if (r5 == 0) goto L30
            r5 = 0
            r1.f1622r = r5
        L30:
            if (r3 == 0) goto L40
        L32:
            r3 = 2
            r2.n(r3)
            r3 = 1
            r2.r(r4, r3)
            com.google.android.gms.common.api.internal.k r2 = r2.f10406A
            r2.a(r4)
            goto L43
        L40:
            r2.n(r4)
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.p(android.view.View, int, boolean):void");
    }

    public final void q() throws Resources.NotFoundException {
        View view;
        int iA;
        WeakReference weakReference = this.f10427W;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        S.f(524288, view);
        S.d(0, view);
        S.f(262144, view);
        S.d(0, view);
        S.f(BmLocated.ALIGN_TOP, view);
        S.d(0, view);
        SparseIntArray sparseIntArray = this.f10440e0;
        int i4 = sparseIntArray.get(0, -1);
        if (i4 != -1) {
            S.f(i4, view);
            S.d(0, view);
            sparseIntArray.delete(0);
        }
        int i5 = 2;
        if (!this.f10433b && this.f10419N != 6) {
            String string = view.getResources().getString(R.string.bottomsheet_action_expand_halfway);
            C0186l c0186l = new C0186l(i, i5, this);
            ArrayList arrayListC = S.c(view);
            int i6 = 0;
            while (true) {
                if (i6 >= arrayListC.size()) {
                    int i7 = -1;
                    for (int i8 = 0; i8 < 32 && i7 == -1; i8++) {
                        int i9 = S.f940b[i8];
                        boolean z4 = true;
                        for (int i10 = 0; i10 < arrayListC.size(); i10++) {
                            z4 &= ((L.b) arrayListC.get(i10)).a() != i9;
                        }
                        if (z4) {
                            i7 = i9;
                        }
                    }
                    iA = i7;
                } else {
                    if (TextUtils.equals(string, ((AccessibilityNodeInfo.AccessibilityAction) ((L.b) arrayListC.get(i6)).f1137a).getLabel())) {
                        iA = ((L.b) arrayListC.get(i6)).a();
                        break;
                    }
                    i6++;
                }
            }
            if (iA != -1) {
                L.b bVar = new L.b(null, iA, string, c0186l, null);
                View.AccessibilityDelegate accessibilityDelegateA = O.a(view);
                C0069b c0069b = accessibilityDelegateA == null ? null : accessibilityDelegateA instanceof C0067a ? ((C0067a) accessibilityDelegateA).f947a : new C0069b(accessibilityDelegateA);
                if (c0069b == null) {
                    c0069b = new C0069b();
                }
                S.h(view, c0069b);
                S.f(bVar.a(), view);
                S.c(view).add(bVar);
                S.d(0, view);
            }
            sparseIntArray.put(0, iA);
        }
        if (this.f10414I) {
            int i11 = 5;
            if (this.f10419N != 5) {
                S.g(view, L.b.f1134j, new C0186l(i11, i5, this));
            }
        }
        int i12 = this.f10419N;
        int i13 = 4;
        int i14 = 3;
        if (i12 == 3) {
            S.g(view, L.b.f1133i, new C0186l(this.f10433b ? 4 : 6, i5, this));
            return;
        }
        if (i12 == 4) {
            S.g(view, L.b.f1132h, new C0186l(this.f10433b ? 3 : 6, i5, this));
        } else {
            if (i12 != 6) {
                return;
            }
            S.g(view, L.b.f1133i, new C0186l(i13, i5, this));
            S.g(view, L.b.f1132h, new C0186l(i14, i5, this));
        }
    }

    public final void r(int i4, boolean z4) {
        j jVar = this.f10445i;
        ValueAnimator valueAnimator = this.f10407B;
        if (i4 == 2) {
            return;
        }
        boolean z5 = this.f10419N == 3 && (this.f10460x || k());
        if (this.f10462z == z5 || jVar == null) {
            return;
        }
        this.f10462z = z5;
        if (z4 && valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                valueAnimator.reverse();
                return;
            } else {
                valueAnimator.setFloatValues(jVar.f16234b.f16213k, z5 ? d() : 1.0f);
                valueAnimator.start();
                return;
            }
        }
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
        float fD = this.f10462z ? d() : 1.0f;
        h hVar = jVar.f16234b;
        if (hVar.f16213k != fD) {
            hVar.f16213k = fD;
            jVar.f16238f = true;
            jVar.f16239g = true;
            jVar.invalidateSelf();
        }
    }

    public final void s(boolean z4) {
        WeakReference weakReference = this.f10427W;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z4) {
                if (this.f10438d0 != null) {
                    return;
                } else {
                    this.f10438d0 = new HashMap(childCount);
                }
            }
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = coordinatorLayout.getChildAt(i4);
                if (childAt != this.f10427W.get() && z4) {
                    this.f10438d0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z4) {
                return;
            }
            this.f10438d0 = null;
        }
    }

    public final void t() {
        View view;
        if (this.f10427W != null) {
            c();
            if (this.f10419N != 4 || (view = (View) this.f10427W.get()) == null) {
                return;
            }
            view.requestLayout();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public final int f10463a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10464b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f10465c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f10466d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f10467e;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f10463a = parcel.readInt();
            this.f10464b = parcel.readInt();
            this.f10465c = parcel.readInt() == 1;
            this.f10466d = parcel.readInt() == 1;
            this.f10467e = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f10463a);
            parcel.writeInt(this.f10464b);
            parcel.writeInt(this.f10465c ? 1 : 0);
            parcel.writeInt(this.f10466d ? 1 : 0);
            parcel.writeInt(this.f10467e ? 1 : 0);
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior bottomSheetBehavior) {
            super(parcelable);
            this.f10463a = bottomSheetBehavior.f10419N;
            this.f10464b = bottomSheetBehavior.f10439e;
            this.f10465c = bottomSheetBehavior.f10433b;
            this.f10466d = bottomSheetBehavior.f10414I;
            this.f10467e = bottomSheetBehavior.f10415J;
        }
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) throws Resources.NotFoundException {
        int i4;
        this.f10431a = 0;
        this.f10433b = true;
        this.f10447k = -1;
        this.f10448l = -1;
        this.f10406A = new k(this, 0);
        this.f10411F = 0.5f;
        this.f10413H = -1.0f;
        this.f10416K = true;
        this.f10417L = true;
        this.f10419N = 4;
        this.f10424S = 0.1f;
        this.f10429Y = new ArrayList();
        this.f10434b0 = -1;
        this.f10440e0 = new SparseIntArray();
        this.f10442f0 = new C0815b(this);
        this.f10444h = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0769a.f13537c);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.f10446j = f.y(context, typedArrayObtainStyledAttributes, 3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(22)) {
            this.f10461y = n.b(context, attributeSet, R.attr.bottomSheetStyle, R.style.Widget_Design_BottomSheet_Modal).a();
        }
        n nVar = this.f10461y;
        if (nVar != null) {
            j jVar = new j(nVar);
            this.f10445i = jVar;
            jVar.l(context);
            ColorStateList colorStateList = this.f10446j;
            if (colorStateList != null) {
                this.f10445i.o(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.f10445i.setTint(typedValue.data);
            }
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(d(), 1.0f);
        this.f10407B = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.f10407B.addUpdateListener(new q(1, this));
        this.f10413H = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            this.f10447k = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            this.f10448l = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, -1);
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(10);
        if (typedValuePeekValue != null && (i4 = typedValuePeekValue.data) == -1) {
            l(i4);
        } else {
            l(typedArrayObtainStyledAttributes.getDimensionPixelSize(10, -1));
        }
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(9, false);
        if (this.f10414I != z4) {
            this.f10414I = z4;
            if (!z4 && this.f10419N == 5) {
                m(4);
            }
            q();
        }
        this.f10450n = typedArrayObtainStyledAttributes.getBoolean(14, false);
        boolean z5 = typedArrayObtainStyledAttributes.getBoolean(7, true);
        if (this.f10433b != z5) {
            this.f10433b = z5;
            if (this.f10427W != null) {
                c();
            }
            n((this.f10433b && this.f10419N == 6) ? 3 : this.f10419N);
            r(this.f10419N, true);
            q();
        }
        this.f10415J = typedArrayObtainStyledAttributes.getBoolean(13, false);
        this.f10416K = typedArrayObtainStyledAttributes.getBoolean(4, true);
        this.f10417L = typedArrayObtainStyledAttributes.getBoolean(5, true);
        this.f10431a = typedArrayObtainStyledAttributes.getInt(11, 0);
        float f4 = typedArrayObtainStyledAttributes.getFloat(8, 0.5f);
        if (f4 > Property.DEFAULT_FLOAT_VALUE && f4 < 1.0f) {
            this.f10411F = f4;
            if (this.f10427W != null) {
                this.f10410E = (int) ((1.0f - f4) * this.f10426V);
            }
            TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(6);
            if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
                int i5 = typedValuePeekValue2.data;
                if (i5 >= 0) {
                    this.f10408C = i5;
                    r(this.f10419N, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            } else {
                int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(6, 0);
                if (dimensionPixelOffset >= 0) {
                    this.f10408C = dimensionPixelOffset;
                    r(this.f10419N, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            }
            this.f10437d = typedArrayObtainStyledAttributes.getInt(12, 500);
            this.f10451o = typedArrayObtainStyledAttributes.getBoolean(18, false);
            this.f10452p = typedArrayObtainStyledAttributes.getBoolean(19, false);
            this.f10453q = typedArrayObtainStyledAttributes.getBoolean(20, false);
            this.f10454r = typedArrayObtainStyledAttributes.getBoolean(21, true);
            this.f10455s = typedArrayObtainStyledAttributes.getBoolean(15, false);
            this.f10456t = typedArrayObtainStyledAttributes.getBoolean(16, false);
            this.f10457u = typedArrayObtainStyledAttributes.getBoolean(17, false);
            this.f10460x = typedArrayObtainStyledAttributes.getBoolean(24, true);
            typedArrayObtainStyledAttributes.recycle();
            this.f10435c = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }
}
