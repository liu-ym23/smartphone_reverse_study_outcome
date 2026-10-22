package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import androidx.datastore.preferences.protobuf.b1;
import com.google.android.material.appbar.AppBarLayout;
import com.stepos.aiengine.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.WeakHashMap;
import mb.y;
import v0.e0;
import v0.h0;
import v0.m;
import v0.m0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {
    public static final /* synthetic */ int E = 0;
    public Drawable A;
    public Integer B;
    public final float C;
    public Behavior D;

    /* renamed from: a, reason: collision with root package name */
    public int f4539a;

    /* renamed from: b, reason: collision with root package name */
    public int f4540b;

    /* renamed from: c, reason: collision with root package name */
    public int f4541c;

    /* renamed from: d, reason: collision with root package name */
    public int f4542d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4543e;
    public int h;

    /* renamed from: j, reason: collision with root package name */
    public m0 f4544j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f4545k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4546l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f4547m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f4548n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f4549o;

    /* renamed from: p, reason: collision with root package name */
    public ColorStateList f4550p;

    /* renamed from: q, reason: collision with root package name */
    public int f4551q;
    public WeakReference<View> r;

    /* renamed from: s, reason: collision with root package name */
    public ValueAnimator f4552s;

    /* renamed from: t, reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f4553t;

    /* renamed from: u, reason: collision with root package name */
    public final ArrayList f4554u;

    /* renamed from: v, reason: collision with root package name */
    public final LinkedHashSet<f> f4555v;

    /* renamed from: w, reason: collision with root package name */
    public final long f4556w;

    /* renamed from: x, reason: collision with root package name */
    public final TimeInterpolator f4557x;

    /* renamed from: y, reason: collision with root package name */
    public int[] f4558y;
    public int z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class BaseBehavior<T extends AppBarLayout> extends com.google.android.material.appbar.e<T> {

        /* renamed from: k, reason: collision with root package name */
        public int f4559k;

        /* renamed from: l, reason: collision with root package name */
        public int f4560l;

        /* renamed from: m, reason: collision with root package name */
        public ValueAnimator f4561m;

        /* renamed from: n, reason: collision with root package name */
        public SavedState f4562n;

        /* renamed from: o, reason: collision with root package name */
        public WeakReference<View> f4563o;

        public BaseBehavior() {
        }

        public static View n(BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if (((CoordinatorLayout.f) childAt.getLayoutParams()).f1456a instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        public static View p(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if ((childAt instanceof m) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x005a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void u(androidx.coordinatorlayout.widget.CoordinatorLayout r6, com.google.android.material.appbar.AppBarLayout r7, int r8, int r9, boolean r10) {
            /*
                int r0 = java.lang.Math.abs(r8)
                int r1 = r7.getChildCount()
                r2 = 0
                r3 = r2
            La:
                if (r3 >= r1) goto L20
                android.view.View r4 = r7.getChildAt(r3)
                int r5 = r4.getTop()
                if (r0 < r5) goto L1d
                int r5 = r4.getBottom()
                if (r0 > r5) goto L1d
                goto L21
            L1d:
                int r3 = r3 + 1
                goto La
            L20:
                r4 = 0
            L21:
                if (r4 == 0) goto L5a
                android.view.ViewGroup$LayoutParams r0 = r4.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$d r0 = (com.google.android.material.appbar.AppBarLayout.d) r0
                int r0 = r0.f4566a
                r1 = r0 & 1
                if (r1 == 0) goto L5a
                int r1 = r4.getMinimumHeight()
                r3 = 1
                if (r9 <= 0) goto L48
                r9 = r0 & 12
                if (r9 == 0) goto L48
                int r8 = -r8
                int r9 = r4.getBottom()
                int r9 = r9 - r1
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L5a
                goto L5b
            L48:
                r9 = r0 & 2
                if (r9 == 0) goto L5a
                int r8 = -r8
                int r9 = r4.getBottom()
                int r9 = r9 - r1
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L5a
                goto L5b
            L5a:
                r3 = r2
            L5b:
                boolean r8 = r7.f4549o
                if (r8 == 0) goto L67
                android.view.View r8 = p(r6)
                boolean r3 = r7.j(r8)
            L67:
                boolean r8 = r7.i(r3)
                if (r10 != 0) goto La9
                if (r8 == 0) goto Ld0
                androidx.coordinatorlayout.widget.a r8 = r6.f1437b
                java.lang.Object r8 = r8.f1475c
                p.o r8 = (p.o) r8
                java.lang.Object r8 = r8.get(r7)
                java.util.List r8 = (java.util.List) r8
                java.util.ArrayList r6 = r6.f1439d
                r6.clear()
                if (r8 == 0) goto L85
                r6.addAll(r8)
            L85:
                int r8 = r6.size()
            L89:
                if (r2 >= r8) goto Ld0
                java.lang.Object r9 = r6.get(r2)
                android.view.View r9 = (android.view.View) r9
                android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
                androidx.coordinatorlayout.widget.CoordinatorLayout$f r9 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r9
                androidx.coordinatorlayout.widget.CoordinatorLayout$c r9 = r9.f1456a
                boolean r10 = r9 instanceof com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior
                if (r10 == 0) goto La6
                com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior r9 = (com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior) r9
                int r6 = r9.getOverlayTop()
                if (r6 == 0) goto Ld0
                goto La9
            La6:
                int r2 = r2 + 1
                goto L89
            La9:
                android.graphics.drawable.Drawable r6 = r7.getBackground()
                if (r6 == 0) goto Lb6
                android.graphics.drawable.Drawable r6 = r7.getBackground()
                r6.jumpToCurrentState()
            Lb6:
                android.graphics.drawable.Drawable r6 = r7.getForeground()
                if (r6 == 0) goto Lc3
                android.graphics.drawable.Drawable r6 = r7.getForeground()
                r6.jumpToCurrentState()
            Lc3:
                android.animation.StateListAnimator r6 = r7.getStateListAnimator()
                if (r6 == 0) goto Ld0
                android.animation.StateListAnimator r6 = r7.getStateListAnimator()
                r6.jumpToCurrentState()
            Ld0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.u(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        @Override // com.google.android.material.appbar.j
        public final int g() {
            return getTopAndBottomOffset() + this.f4559k;
        }

        @Override // com.google.android.material.appbar.e
        public final boolean h(View view) {
            WeakReference<View> weakReference = this.f4563o;
            if (weakReference == null) {
                return true;
            }
            View view2 = weakReference.get();
            return (view2 == null || !view2.isShown() || view2.canScrollVertically(-1)) ? false : true;
        }

        @Override // com.google.android.material.appbar.e
        public final int i(View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            return appBarLayout.getTopInset() + (-appBarLayout.getDownNestedScrollRange());
        }

        @Override // com.google.android.material.appbar.e
        public final int j(View view) {
            return ((AppBarLayout) view).getTotalScrollRange();
        }

        @Override // com.google.android.material.appbar.e
        public final void k(CoordinatorLayout coordinatorLayout, View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            t(coordinatorLayout, appBarLayout);
            if (appBarLayout.f4549o) {
                appBarLayout.i(appBarLayout.j(p(coordinatorLayout)));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x014f  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x016e  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0170  */
        @Override // com.google.android.material.appbar.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int l(androidx.coordinatorlayout.widget.CoordinatorLayout r18, android.view.View r19, int r20, int r21, int r22) {
            /*
                Method dump skipped, instructions count: 394
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.l(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int, int, int):int");
        }

        public final void o(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i10) {
            int iAbs = Math.abs(g() - i10);
            float fAbs = Math.abs(0.0f);
            int iRound = fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / appBarLayout.getHeight()) + 1.0f) * 150.0f);
            int iG = g();
            if (iG == i10) {
                ValueAnimator valueAnimator = this.f4561m;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f4561m.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f4561m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f4561m = valueAnimator3;
                valueAnimator3.setInterpolator(l4.a.f10224e);
                this.f4561m.addUpdateListener(new com.google.android.material.appbar.c(coordinatorLayout, this, appBarLayout));
            } else {
                valueAnimator2.cancel();
            }
            this.f4561m.setDuration(Math.min(iRound, 600));
            this.f4561m.setIntValues(iG, i10);
            this.f4561m.start();
        }

        @Override // com.google.android.material.appbar.j, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i10) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            boolean zOnLayoutChild = super.onLayoutChild(coordinatorLayout, appBarLayout, i10);
            int pendingAction = appBarLayout.getPendingAction();
            SavedState savedState = this.f4562n;
            if (savedState == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i11 = -appBarLayout.getUpNestedPreScrollRange();
                        if (z) {
                            o(coordinatorLayout, appBarLayout, i11);
                        } else {
                            m(coordinatorLayout, appBarLayout, i11);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z) {
                            o(coordinatorLayout, appBarLayout, 0);
                        } else {
                            m(coordinatorLayout, appBarLayout, 0);
                        }
                    }
                }
            } else if (savedState.fullyScrolled) {
                m(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange());
            } else if (savedState.fullyExpanded) {
                m(coordinatorLayout, appBarLayout, 0);
            } else {
                View childAt = appBarLayout.getChildAt(savedState.firstVisibleChildIndex);
                int i12 = -childAt.getBottom();
                m(coordinatorLayout, appBarLayout, this.f4562n.firstVisibleChildAtMinimumHeight ? appBarLayout.getTopInset() + childAt.getMinimumHeight() + i12 : Math.round(childAt.getHeight() * this.f4562n.firstVisibleChildPercentageShown) + i12);
            }
            appBarLayout.h = 0;
            this.f4562n = null;
            setTopAndBottomOffset(y.p(getTopAndBottomOffset(), -appBarLayout.getTotalScrollRange(), 0));
            u(coordinatorLayout, appBarLayout, getTopAndBottomOffset(), 0, true);
            appBarLayout.g(getTopAndBottomOffset());
            WeakHashMap<View, h0> weakHashMap = e0.f13274a;
            if (e0.h.a(coordinatorLayout) != null) {
                return zOnLayoutChild;
            }
            e0.j(coordinatorLayout, new com.google.android.material.appbar.d(coordinatorLayout, this, appBarLayout));
            return zOnLayoutChild;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int i13) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) appBarLayout.getLayoutParams())).height != -2) {
                return super.onMeasureChild(coordinatorLayout, appBarLayout, i10, i11, i12, i13);
            }
            coordinatorLayout.C(appBarLayout, i10, i11, View.MeasureSpec.makeMeasureSpec(0, 0), i13);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i10, int i11, int[] iArr, int i12) {
            q(coordinatorLayout, (AppBarLayout) view, view2, i11, iArr);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i13 < 0) {
                iArr[1] = l(coordinatorLayout, appBarLayout, g() - i13, -appBarLayout.getDownNestedScrollRange(), 0);
            }
            if (i13 == 0) {
                WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                if (e0.h.a(coordinatorLayout) != null) {
                    return;
                }
                e0.j(coordinatorLayout, new com.google.android.material.appbar.d(coordinatorLayout, this, appBarLayout));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(coordinatorLayout, appBarLayout, parcelable);
                this.f4562n = null;
            } else {
                SavedState savedState = (SavedState) parcelable;
                this.f4562n = savedState;
                super.onRestoreInstanceState(coordinatorLayout, appBarLayout, savedState.getSuperState());
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, appBarLayout);
            SavedState savedStateS = s(parcelableOnSaveInstanceState, appBarLayout);
            return savedStateS == null ? parcelableOnSaveInstanceState : savedStateS;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public final void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i10) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.f4560l == 0 || i10 == 1) {
                t(coordinatorLayout, appBarLayout);
                if (appBarLayout.f4549o) {
                    appBarLayout.i(appBarLayout.j(view2));
                }
            }
            this.f4563o = new WeakReference<>(view2);
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void q(androidx.coordinatorlayout.widget.CoordinatorLayout r9, com.google.android.material.appbar.AppBarLayout r10, android.view.View r11, int r12, int[] r13) {
            /*
                r8 = this;
                if (r12 == 0) goto L2b
                if (r12 >= 0) goto L11
                int r0 = r10.getTotalScrollRange()
                int r0 = -r0
                int r1 = r10.getDownNestedPreScrollRange()
                int r1 = r1 + r0
            Le:
                r6 = r0
                r7 = r1
                goto L18
            L11:
                int r0 = r10.getUpNestedPreScrollRange()
                int r0 = -r0
                r1 = 0
                goto Le
            L18:
                if (r6 == r7) goto L2b
                int r0 = r8.g()
                int r5 = r0 - r12
                r2 = r8
                r3 = r9
                r4 = r10
                int r8 = r2.l(r3, r4, r5, r6, r7)
                r9 = 1
                r13[r9] = r8
                goto L2c
            L2b:
                r4 = r10
            L2c:
                boolean r8 = r4.f4549o
                if (r8 == 0) goto L37
                boolean r8 = r4.j(r11)
                r4.i(r8)
            L37:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.q(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, int, int[]):void");
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, T t8, View view, View view2, int i10, int i11) {
            ValueAnimator valueAnimator;
            boolean z = (i10 & 2) != 0 && (t8.f4549o || t8.f4548n || (t8.getTotalScrollRange() != 0 && coordinatorLayout.getHeight() - view.getHeight() <= t8.getHeight()));
            if (z && (valueAnimator = this.f4561m) != null) {
                valueAnimator.cancel();
            }
            this.f4563o = null;
            this.f4560l = i11;
            return z;
        }

        public final SavedState s(Parcelable parcelable, T t8) {
            int topAndBottomOffset = getTopAndBottomOffset();
            int childCount = t8.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = t8.getChildAt(i10);
                int bottom = childAt.getBottom() + topAndBottomOffset;
                if (childAt.getTop() + topAndBottomOffset <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = AbsSavedState.EMPTY_STATE;
                    }
                    SavedState savedState = new SavedState(parcelable);
                    boolean z = topAndBottomOffset == 0;
                    savedState.fullyExpanded = z;
                    savedState.fullyScrolled = !z && (-topAndBottomOffset) >= t8.getTotalScrollRange();
                    savedState.firstVisibleChildIndex = i10;
                    savedState.firstVisibleChildAtMinimumHeight = bottom == t8.getTopInset() + childAt.getMinimumHeight();
                    savedState.firstVisibleChildPercentageShown = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return null;
        }

        public final void t(CoordinatorLayout coordinatorLayout, T t8) {
            int paddingTop = t8.getPaddingTop() + t8.getTopInset();
            int iG = g() - paddingTop;
            int childCount = t8.getChildCount();
            int i10 = 0;
            while (true) {
                if (i10 >= childCount) {
                    i10 = -1;
                    break;
                }
                View childAt = t8.getChildAt(i10);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                d dVar = (d) childAt.getLayoutParams();
                if ((dVar.f4566a & 32) == 32) {
                    top -= ((LinearLayout.LayoutParams) dVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) dVar).bottomMargin;
                }
                int i11 = -iG;
                if (top <= i11 && bottom >= i11) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 >= 0) {
                View childAt2 = t8.getChildAt(i10);
                d dVar2 = (d) childAt2.getLayoutParams();
                int i12 = dVar2.f4566a;
                if ((i12 & 17) == 17) {
                    int topInset = -childAt2.getTop();
                    int minimumHeight = -childAt2.getBottom();
                    if (i10 == 0 && t8.getFitsSystemWindows() && childAt2.getFitsSystemWindows()) {
                        topInset -= t8.getTopInset();
                    }
                    if ((i12 & 2) == 2) {
                        minimumHeight += childAt2.getMinimumHeight();
                    } else if ((i12 & 5) == 5) {
                        int minimumHeight2 = childAt2.getMinimumHeight() + minimumHeight;
                        if (iG < minimumHeight2) {
                            topInset = minimumHeight2;
                        } else {
                            minimumHeight = minimumHeight2;
                        }
                    }
                    if ((i12 & 32) == 32) {
                        topInset += ((LinearLayout.LayoutParams) dVar2).topMargin;
                        minimumHeight -= ((LinearLayout.LayoutParams) dVar2).bottomMargin;
                    }
                    if (iG < (minimumHeight + topInset) / 2) {
                        topInset = minimumHeight;
                    }
                    o(coordinatorLayout, t8, y.p(topInset + paddingTop, -t8.getTotalScrollRange(), 0));
                }
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;
            boolean fullyExpanded;
            boolean fullyScrolled;

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
                    return new SavedState(parcel, null);
                }
            }

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.fullyScrolled = parcel.readByte() != 0;
                this.fullyExpanded = parcel.readByte() != 0;
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                this.firstVisibleChildAtMinimumHeight = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                super.writeToParcel(parcel, i10);
                parcel.writeByte(this.fullyScrolled ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.fullyExpanded ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.firstVisibleChildIndex);
                parcel.writeFloat(this.firstVisibleChildPercentageShown);
                parcel.writeByte(this.firstVisibleChildAtMinimumHeight ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class ScrollingViewBehavior extends com.google.android.material.appbar.f {
        public ScrollingViewBehavior() {
        }

        private static int getAppBarLayoutOffset(AppBarLayout appBarLayout) {
            CoordinatorLayout.c cVar = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).f1456a;
            if (cVar instanceof BaseBehavior) {
                return ((BaseBehavior) cVar).g();
            }
            return 0;
        }

        private void offsetChildAsNeeded(View view, View view2) {
            CoordinatorLayout.c cVar = ((CoordinatorLayout.f) view2.getLayoutParams()).f1456a;
            if (cVar instanceof BaseBehavior) {
                int verticalLayoutGap = (getVerticalLayoutGap() + ((view2.getBottom() - view.getTop()) + ((BaseBehavior) cVar).f4559k)) - getOverlapPixelsForOffset(view2);
                WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                view.offsetTopAndBottom(verticalLayoutGap);
            }
        }

        private void updateLiftedStateIfNeeded(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.f4549o) {
                    appBarLayout.i(appBarLayout.j(view));
                }
            }
        }

        @Override // com.google.android.material.appbar.f
        public /* bridge */ /* synthetic */ View findFirstDependency(List list) {
            return findFirstDependency((List<View>) list);
        }

        @Override // com.google.android.material.appbar.j
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.f
        public float getOverlapRatioForOffset(View view) {
            int i10;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int appBarLayoutOffset = getAppBarLayoutOffset(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + appBarLayoutOffset > downNestedPreScrollRange) && (i10 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (appBarLayoutOffset / i10) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.f
        public int getScrollRange(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.getScrollRange(view);
        }

        @Override // com.google.android.material.appbar.j
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.google.android.material.appbar.j
        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.j
        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            offsetChildAsNeeded(view, view2);
            updateLiftedStateIfNeeded(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                e0.j(coordinatorLayout, null);
            }
        }

        @Override // com.google.android.material.appbar.j, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i10) {
            return super.onLayoutChild(coordinatorLayout, view, i10);
        }

        @Override // com.google.android.material.appbar.f, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int i13) {
            return super.onMeasureChild(coordinatorLayout, view, i10, i11, i12, i13);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout appBarLayoutFindFirstDependency = findFirstDependency((List<View>) coordinatorLayout.v(view));
            if (appBarLayoutFindFirstDependency != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                Rect rect3 = this.tempRect1;
                rect3.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect3.contains(rect2)) {
                    appBarLayoutFindFirstDependency.h(false, !z, true);
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.material.appbar.j
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z) {
            super.setHorizontalOffsetEnabled(z);
        }

        @Override // com.google.android.material.appbar.j
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i10) {
            return super.setLeftAndRightOffset(i10);
        }

        @Override // com.google.android.material.appbar.j
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i10) {
            return super.setTopAndBottomOffset(i10);
        }

        @Override // com.google.android.material.appbar.j
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z) {
            super.setVerticalOffsetEnabled(z);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k4.a.C);
            setOverlayTop(typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0));
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // com.google.android.material.appbar.f
        public AppBarLayout findFirstDependency(List<View> list) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = list.get(i10);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a<T extends AppBarLayout> {
        void a(int i10);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class b {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c extends b {

        /* renamed from: a, reason: collision with root package name */
        public final Rect f4564a = new Rect();

        /* renamed from: b, reason: collision with root package name */
        public final Rect f4565b = new Rect();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class d extends LinearLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f4566a;

        /* renamed from: b, reason: collision with root package name */
        public c f4567b;

        /* renamed from: c, reason: collision with root package name */
        public Interpolator f4568c;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @Deprecated
    public interface e {
        void a();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class f {
        public abstract void a();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface g extends a<AppBarLayout> {
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(b5.a.a(context, attributeSet, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout), attributeSet, R.attr.appBarLayoutStyle);
        this.f4540b = -1;
        this.f4541c = -1;
        this.f4542d = -1;
        this.h = 0;
        this.f4554u = new ArrayList();
        this.f4555v = new LinkedHashSet<>();
        Context context2 = getContext();
        int i10 = 1;
        setOrientation(1);
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
        Context context3 = getContext();
        TypedArray typedArrayD = com.google.android.material.internal.i.d(context3, attributeSet, l.f4608a, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout, new int[0]);
        try {
            if (typedArrayD.hasValue(0)) {
                setStateListAnimator(AnimatorInflater.loadStateListAnimator(context3, typedArrayD.getResourceId(0, 0)));
            }
            typedArrayD.recycle();
            TypedArray typedArrayD2 = com.google.android.material.internal.i.d(context2, attributeSet, k4.a.f9897a, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout, new int[0]);
            this.f4550p = w4.c.a(context2, typedArrayD2, 6);
            this.f4556w = u4.j.c(context2, R.attr.motionDurationMedium2, getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
            this.f4557x = u4.j.d(context2, R.attr.motionEasingStandardInterpolator, l4.a.f10220a);
            if (typedArrayD2.hasValue(4)) {
                h(typedArrayD2.getBoolean(4, false), false, false);
            }
            if (typedArrayD2.hasValue(3)) {
                l.a(this, typedArrayD2.getDimensionPixelSize(3, 0));
            }
            setBackground(typedArrayD2.getDrawable(0));
            if (typedArrayD2.hasValue(2)) {
                setKeyboardNavigationCluster(typedArrayD2.getBoolean(2, false));
            }
            if (typedArrayD2.hasValue(1)) {
                setTouchscreenBlocksFocus(typedArrayD2.getBoolean(1, false));
            }
            this.C = getResources().getDimension(R.dimen.design_appbar_elevation);
            this.f4549o = typedArrayD2.getBoolean(5, false);
            this.f4551q = typedArrayD2.getResourceId(7, -1);
            setStatusBarForeground(typedArrayD2.getDrawable(8));
            typedArrayD2.recycle();
            androidx.lifecycle.b bVar = new androidx.lifecycle.b(this, i10);
            WeakHashMap<View, h0> weakHashMap = e0.f13274a;
            e0.d.k(this, bVar);
        } catch (Throwable th) {
            typedArrayD.recycle();
            throw th;
        }
    }

    public static d e(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            d dVar = new d((LinearLayout.LayoutParams) layoutParams);
            dVar.f4566a = 1;
            return dVar;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            d dVar2 = new d((ViewGroup.MarginLayoutParams) layoutParams);
            dVar2.f4566a = 1;
            return dVar2;
        }
        d dVar3 = new d(layoutParams);
        dVar3.f4566a = 1;
        return dVar3;
    }

    public final void c(g gVar) {
        if (this.f4545k == null) {
            this.f4545k = new ArrayList();
        }
        if (gVar == null || this.f4545k.contains(gVar)) {
            return;
        }
        this.f4545k.add(gVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof d;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final d generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        d dVar = new d(context, attributeSet);
        dVar.f4566a = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k4.a.f9898b);
        dVar.f4566a = typedArrayObtainStyledAttributes.getInt(1, 0);
        dVar.f4567b = typedArrayObtainStyledAttributes.getInt(0, 0) != 1 ? null : new c();
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            dVar.f4568c = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(2, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
        return dVar;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.A == null || getTopInset() <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(0.0f, -this.f4539a);
        this.A.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.A;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public final void f() {
        Behavior behavior = this.D;
        BaseBehavior.SavedState savedStateS = (behavior == null || this.f4540b == -1 || this.h != 0) ? null : behavior.s(AbsSavedState.EMPTY_STATE, this);
        this.f4540b = -1;
        this.f4541c = -1;
        this.f4542d = -1;
        if (savedStateS != null) {
            Behavior behavior2 = this.D;
            if (behavior2.f4562n != null) {
                return;
            }
            behavior2.f4562n = savedStateS;
        }
    }

    public final void g(int i10) {
        this.f4539a = i10;
        if (!willNotDraw()) {
            postInvalidateOnAnimation();
        }
        ArrayList arrayList = this.f4545k;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                a aVar = (a) this.f4545k.get(i11);
                if (aVar != null) {
                    aVar.a(i10);
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        d dVar = new d(-1, -2);
        dVar.f4566a = 1;
        return dVar;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<AppBarLayout> getBehavior() {
        Behavior behavior = new Behavior();
        this.D = behavior;
        return behavior;
    }

    public int getDownNestedPreScrollRange() {
        int iMin;
        int minimumHeight;
        int i10 = this.f4541c;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i12 = dVar.f4566a;
                if ((i12 & 5) != 5) {
                    if (i11 > 0) {
                        break;
                    }
                } else {
                    int i13 = ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin;
                    if ((i12 & 8) != 0) {
                        minimumHeight = childAt.getMinimumHeight();
                    } else if ((i12 & 2) != 0) {
                        minimumHeight = measuredHeight - childAt.getMinimumHeight();
                    } else {
                        iMin = i13 + measuredHeight;
                        if (childCount == 0 && childAt.getFitsSystemWindows()) {
                            iMin = Math.min(iMin, measuredHeight - getTopInset());
                        }
                        i11 += iMin;
                    }
                    iMin = minimumHeight + i13;
                    if (childCount == 0) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i11 += iMin;
                }
            }
        }
        int iMax = Math.max(0, i11);
        this.f4541c = iMax;
        return iMax;
    }

    public int getDownNestedScrollRange() {
        int i10 = this.f4542d;
        if (i10 != -1) {
            return i10;
        }
        int childCount = getChildCount();
        int i11 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                int measuredHeight = ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin + childAt.getMeasuredHeight();
                int i12 = dVar.f4566a;
                if ((i12 & 1) == 0) {
                    break;
                }
                minimumHeight += measuredHeight;
                if ((i12 & 2) != 0) {
                    minimumHeight -= childAt.getMinimumHeight();
                    break;
                }
            }
            i11++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f4542d = iMax;
        return iMax;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f4551q;
    }

    public y4.g getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof y4.g) {
            return (y4.g) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = getMinimumHeight();
        if (minimumHeight != 0) {
            int i10 = (minimumHeight * 2) + topInset;
            return i10 < getHeight() ? i10 : minimumHeight + topInset;
        }
        int childCount = getChildCount();
        int minimumHeight2 = childCount >= 1 ? getChildAt(childCount - 1).getMinimumHeight() : 0;
        if (minimumHeight2 == 0) {
            return getHeight() / 3;
        }
        int i11 = (minimumHeight2 * 2) + topInset;
        return i11 < getHeight() ? i11 : minimumHeight2 + topInset;
    }

    public int getPendingAction() {
        return this.h;
    }

    public Drawable getStatusBarForeground() {
        return this.A;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        m0 m0Var = this.f4544j;
        if (m0Var != null) {
            return m0Var.d();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i10 = this.f4540b;
        if (i10 != -1) {
            return i10;
        }
        int childCount = getChildCount();
        int i11 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i12 = dVar.f4566a;
                if ((i12 & 1) == 0) {
                    break;
                }
                int topInset = measuredHeight + ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin + minimumHeight;
                if (i11 == 0 && childAt.getFitsSystemWindows()) {
                    topInset -= getTopInset();
                }
                minimumHeight = topInset;
                if ((i12 & 2) != 0) {
                    minimumHeight -= childAt.getMinimumHeight();
                    break;
                }
            }
            i11++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f4540b = iMax;
        return iMax;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public final void h(boolean z, boolean z3, boolean z10) {
        this.h = (z ? 1 : 2) | (z3 ? 4 : 0) | (z10 ? 8 : 0);
        requestLayout();
    }

    public final boolean i(boolean z) {
        if (this.f4546l || this.f4548n == z) {
            return false;
        }
        this.f4548n = z;
        refreshDrawableState();
        if (!(getBackground() instanceof y4.g)) {
            return true;
        }
        if (this.f4550p != null) {
            k(z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
            return true;
        }
        if (!this.f4549o) {
            return true;
        }
        float f8 = this.C;
        k(z ? 0.0f : f8, z ? f8 : 0.0f);
        return true;
    }

    public final boolean j(View view) {
        int i10;
        if (this.r == null && (i10 = this.f4551q) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i10) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.f4551q);
            }
            if (viewFindViewById != null) {
                this.r = new WeakReference<>(viewFindViewById);
            }
        }
        WeakReference<View> weakReference = this.r;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (view2 != null) {
            view = view2;
        }
        if (view != null) {
            return view.canScrollVertically(-1) || view.getScrollY() > 0;
        }
        return false;
    }

    public final void k(float f8, float f9) {
        ValueAnimator valueAnimator = this.f4552s;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f8, f9);
        this.f4552s = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.f4556w);
        this.f4552s.setInterpolator(this.f4557x);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f4553t;
        if (animatorUpdateListener != null) {
            this.f4552s.addUpdateListener(animatorUpdateListener);
        }
        this.f4552s.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof y4.g) {
            xb.a.g(this, (y4.g) background);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i10) {
        if (this.f4558y == null) {
            this.f4558y = new int[4];
        }
        int[] iArr = this.f4558y;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + iArr.length);
        boolean z = this.f4547m;
        iArr[0] = z ? R.attr.state_liftable : -2130970233;
        iArr[1] = (z && this.f4548n) ? R.attr.state_lifted : -2130970234;
        iArr[2] = z ? R.attr.state_collapsible : -2130970229;
        iArr[3] = (z && this.f4548n) ? R.attr.state_collapsed : -2130970228;
        return LinearLayout.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference<View> weakReference = this.r;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.r = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        super.onLayout(z, i10, i11, i12, i13);
        boolean z3 = true;
        if (getFitsSystemWindows() && getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                int topInset = getTopInset();
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt2 = getChildAt(childCount);
                    WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                    childAt2.offsetTopAndBottom(topInset);
                }
            }
        }
        f();
        this.f4543e = false;
        int childCount2 = getChildCount();
        int i14 = 0;
        while (true) {
            if (i14 >= childCount2) {
                break;
            }
            if (((d) getChildAt(i14).getLayoutParams()).f4568c != null) {
                this.f4543e = true;
                break;
            }
            i14++;
        }
        Drawable drawable = this.A;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.f4546l) {
            return;
        }
        if (!this.f4549o) {
            int childCount3 = getChildCount();
            int i15 = 0;
            while (true) {
                if (i15 >= childCount3) {
                    z3 = false;
                    break;
                }
                int i16 = ((d) getChildAt(i15).getLayoutParams()).f4566a;
                if ((i16 & 1) == 1 && (i16 & 10) != 0) {
                    break;
                } else {
                    i15++;
                }
            }
        }
        if (this.f4547m != z3) {
            this.f4547m = z3;
            refreshDrawableState();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        if (mode != 1073741824 && getFitsSystemWindows() && getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                int measuredHeight = getMeasuredHeight();
                if (mode == Integer.MIN_VALUE) {
                    measuredHeight = y.p(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i11));
                } else if (mode == 0) {
                    measuredHeight += getTopInset();
                }
                setMeasuredDimension(getMeasuredWidth(), measuredHeight);
            }
        }
        f();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        final y4.g gVar;
        ColorStateList colorStateList;
        Context context = getContext();
        if (drawable instanceof y4.g) {
            gVar = (y4.g) drawable;
        } else {
            ColorStateList colorStateListA = r4.a.a(drawable);
            if (colorStateListA == null) {
                gVar = null;
            } else {
                y4.g gVar2 = new y4.g();
                gVar2.n(colorStateListA);
                gVar = gVar2;
            }
        }
        if (gVar != null && (colorStateList = gVar.f14023b.f14047d) != null) {
            this.z = colorStateList.getDefaultColor();
            final ColorStateList colorStateList2 = this.f4550p;
            if (colorStateList2 != null) {
                final Integer numT = jd.b.t(R.attr.colorSurface, getContext());
                this.f4553t = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.a
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Integer num;
                        AppBarLayout appBarLayout = this.f4575a;
                        LinkedHashSet<AppBarLayout.f> linkedHashSet = appBarLayout.f4555v;
                        ArrayList arrayList = appBarLayout.f4554u;
                        int iC = jd.b.C(((Float) valueAnimator.getAnimatedValue()).floatValue(), appBarLayout.z, colorStateList2.getDefaultColor());
                        ColorStateList colorStateListValueOf = ColorStateList.valueOf(iC);
                        y4.g gVar3 = gVar;
                        gVar3.n(colorStateListValueOf);
                        if (appBarLayout.A != null && (num = appBarLayout.B) != null && num.equals(numT)) {
                            appBarLayout.A.setTint(iC);
                        }
                        if (!arrayList.isEmpty()) {
                            int size = arrayList.size();
                            int i10 = 0;
                            while (i10 < size) {
                                Object obj = arrayList.get(i10);
                                i10++;
                                AppBarLayout.e eVar = (AppBarLayout.e) obj;
                                if (gVar3.f14023b.f14047d != null) {
                                    eVar.a();
                                }
                            }
                        }
                        if (linkedHashSet.isEmpty()) {
                            return;
                        }
                        Iterator<AppBarLayout.f> it = linkedHashSet.iterator();
                        while (it.hasNext()) {
                            it.next().a();
                        }
                    }
                };
            } else {
                gVar.k(context);
                this.f4553t = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.b
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int i10 = AppBarLayout.E;
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        gVar.m(fFloatValue);
                        AppBarLayout appBarLayout = this.f4579a;
                        Drawable drawable2 = appBarLayout.A;
                        if (drawable2 instanceof y4.g) {
                            ((y4.g) drawable2).m(fFloatValue);
                        }
                        ArrayList arrayList = appBarLayout.f4554u;
                        int size = arrayList.size();
                        int i11 = 0;
                        while (i11 < size) {
                            Object obj = arrayList.get(i11);
                            i11++;
                            ((AppBarLayout.e) obj).a();
                        }
                        Iterator<AppBarLayout.f> it = appBarLayout.f4555v.iterator();
                        while (it.hasNext()) {
                            it.next().a();
                        }
                    }
                };
            }
            drawable = gVar;
        }
        super.setBackground(drawable);
    }

    @Override // android.view.View
    public void setElevation(float f8) {
        super.setElevation(f8);
        Drawable background = getBackground();
        if (background instanceof y4.g) {
            ((y4.g) background).m(f8);
        }
    }

    public void setExpanded(boolean z) {
        h(z, isLaidOut(), true);
    }

    public void setLiftOnScroll(boolean z) {
        this.f4549o = z;
    }

    public void setLiftOnScrollColor(ColorStateList colorStateList) {
        if (this.f4550p != colorStateList) {
            this.f4550p = colorStateList;
            setBackground(getBackground());
        }
    }

    public void setLiftOnScrollTargetView(View view) {
        this.f4551q = -1;
        if (view != null) {
            this.r = new WeakReference<>(view);
            return;
        }
        WeakReference<View> weakReference = this.r;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.r = null;
    }

    public void setLiftOnScrollTargetViewId(int i10) {
        this.f4551q = i10;
        WeakReference<View> weakReference = this.r;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.r = null;
    }

    public void setLiftableOverrideEnabled(boolean z) {
        this.f4546l = z;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i10) {
        if (i10 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i10);
    }

    public void setPendingAction(int i10) {
        this.h = i10;
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.A;
        if (drawable2 != drawable) {
            Integer numValueOf = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.A = drawableMutate;
            if (drawableMutate instanceof y4.g) {
                numValueOf = Integer.valueOf(((y4.g) drawableMutate).f14040x);
            } else {
                ColorStateList colorStateListA = r4.a.a(drawableMutate);
                if (colorStateListA != null) {
                    numValueOf = Integer.valueOf(colorStateListA.getDefaultColor());
                }
            }
            this.B = numValueOf;
            Drawable drawable3 = this.A;
            boolean z = false;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.A.setState(getDrawableState());
                }
                this.A.setLayoutDirection(getLayoutDirection());
                this.A.setVisible(getVisibility() == 0, false);
                this.A.setCallback(this);
            }
            if (this.A != null && getTopInset() > 0) {
                z = true;
            }
            setWillNotDraw(!z);
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarForegroundColor(int i10) {
        setStatusBarForeground(new ColorDrawable(i10));
    }

    public void setStatusBarForegroundResource(int i10) {
        setStatusBarForeground(b1.L(i10, getContext()));
    }

    @Deprecated
    public void setTargetElevation(float f8) {
        l.a(this, f8);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z = i10 == 0;
        Drawable drawable = this.A;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.A;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return e(layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        d dVar = new d(-1, -2);
        dVar.f4566a = 1;
        return dVar;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return e(layoutParams);
    }
}
