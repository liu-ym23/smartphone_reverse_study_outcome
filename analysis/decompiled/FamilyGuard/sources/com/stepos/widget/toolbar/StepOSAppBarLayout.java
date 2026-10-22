package com.stepos.widget.toolbar;

import V3.f;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.widget.toolbar.StepOSAppBarLayout;
import j4.g;
import j4.k;
import j4.t;
import java.lang.ref.WeakReference;
import kotlin.ranges.l;
import l4.C0848a;

/* loaded from: classes.dex */
public class StepOSAppBarLayout extends LinearLayout implements CoordinatorLayout.b {

    /* renamed from: a, reason: collision with root package name */
    private final f f16353a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f16354b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f16355c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f16356d;

    /* renamed from: e, reason: collision with root package name */
    private long f16357e;

    private final Behavior getAttachedBehavior() {
        return (Behavior) this.f16353a.getValue();
    }

    public final a a() {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt instanceof a) {
                return (a) childAt;
            }
        }
        return null;
    }

    public final boolean b() {
        return this.f16355c;
    }

    public final boolean c() {
        return this.f16356d;
    }

    public final boolean d() {
        return this.f16354b;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<?> getBehavior() {
        return getAttachedBehavior();
    }

    public final long getSnapDelay() {
        return this.f16357e;
    }

    public final void setDragEnabled(boolean z5) {
        this.f16355c = z5;
    }

    public final void setNestedScrollEnabled(boolean z5) {
        this.f16356d = z5;
    }

    public final void setSnapEnabled(boolean z5) {
        this.f16354b = z5;
    }

    public static final class Behavior extends CoordinatorLayout.c<StepOSAppBarLayout> {

        /* renamed from: t, reason: collision with root package name */
        private static final a f16358t = new a(null);

        /* renamed from: a, reason: collision with root package name */
        private int f16359a;

        /* renamed from: b, reason: collision with root package name */
        private float f16360b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f16361c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f16362d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f16363e;

        /* renamed from: f, reason: collision with root package name */
        private Runnable f16364f;

        /* renamed from: g, reason: collision with root package name */
        private WeakReference<View> f16365g;

        /* renamed from: h, reason: collision with root package name */
        private WeakReference<StepOSAppBarLayout> f16366h;

        /* renamed from: i, reason: collision with root package name */
        private WeakReference<com.stepos.widget.toolbar.a> f16367i;

        /* renamed from: j, reason: collision with root package name */
        private WeakReference<RecyclerView> f16368j;

        /* renamed from: k, reason: collision with root package name */
        private RecyclerView.OnScrollListener f16369k;

        /* renamed from: l, reason: collision with root package name */
        private int f16370l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f16371m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f16372n;

        /* renamed from: o, reason: collision with root package name */
        private int f16373o;

        /* renamed from: p, reason: collision with root package name */
        private int f16374p;

        /* renamed from: q, reason: collision with root package name */
        private boolean f16375q;

        /* renamed from: r, reason: collision with root package name */
        private Runnable f16376r;

        /* renamed from: s, reason: collision with root package name */
        private ValueAnimator f16377s;

        private static final class a {
            public /* synthetic */ a(g gVar) {
                this();
            }

            private a() {
            }
        }

        public static final class b extends RecyclerView.OnScrollListener {
            b() {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i5) {
                com.stepos.widget.toolbar.a aVar;
                k.g(recyclerView, "recyclerView");
                WeakReference weakReference = Behavior.this.f16368j;
                if ((weakReference != null ? (RecyclerView) weakReference.get() : null) == recyclerView && i5 == 0) {
                    Behavior.this.R(recyclerView);
                    WeakReference weakReference2 = Behavior.this.f16367i;
                    if (weakReference2 == null || (aVar = (com.stepos.widget.toolbar.a) weakReference2.get()) == null) {
                        return;
                    }
                    Behavior behavior = Behavior.this;
                    behavior.p(recyclerView, aVar);
                    if (behavior.f16372n) {
                        behavior.y(recyclerView, aVar);
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i5, int i6) {
                com.stepos.widget.toolbar.a aVar;
                k.g(recyclerView, "recyclerView");
                WeakReference weakReference = Behavior.this.f16368j;
                if ((weakReference != null ? (RecyclerView) weakReference.get() : null) != recyclerView || Behavior.this.f16375q) {
                    return;
                }
                Behavior.this.S(recyclerView, i6);
                WeakReference weakReference2 = Behavior.this.f16367i;
                if (weakReference2 == null || (aVar = (com.stepos.widget.toolbar.a) weakReference2.get()) == null) {
                    return;
                }
                Behavior.this.p(recyclerView, aVar);
            }
        }

        public static final class c extends AnimatorListenerAdapter {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f16380b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f16381c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.stepos.widget.toolbar.a f16382d;

            c(View view, int i5, com.stepos.widget.toolbar.a aVar) {
                this.f16380b = view;
                this.f16381c = i5;
                this.f16382d = aVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                k.g(animator, "animation");
                Behavior.this.f16377s = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                k.g(animator, "animation");
                this.f16382d.N(l.h(Behavior.this.v(this.f16380b, this.f16381c, this.f16382d), 0, this.f16381c), this.f16381c);
                Behavior.this.f16377s = null;
            }
        }

        public Behavior() {
            this.f16359a = -1;
        }

        private final boolean A(View view, float f5, float f6) {
            return view.getVisibility() == 0 && f5 >= ((float) view.getLeft()) && f5 < ((float) view.getRight()) && f6 >= ((float) view.getTop()) && f6 < ((float) view.getBottom());
        }

        private final boolean B(StepOSAppBarLayout stepOSAppBarLayout, MotionEvent motionEvent) {
            float x5 = motionEvent.getX() - stepOSAppBarLayout.getLeft();
            float y5 = motionEvent.getY() - stepOSAppBarLayout.getTop();
            return x5 >= 0.0f && x5 < ((float) stepOSAppBarLayout.getWidth()) && y5 >= 0.0f && y5 < ((float) stepOSAppBarLayout.getHeight());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void K(Behavior behavior, com.stepos.widget.toolbar.a aVar, View view) {
            behavior.f16364f = null;
            int expandRange = aVar.getExpandRange();
            int iV = behavior.v(view, expandRange, aVar);
            if (1 > iV || iV >= expandRange) {
                return;
            }
            behavior.N(view, behavior.Q(iV, expandRange), aVar);
        }

        private final int M(RecyclerView recyclerView, int i5, com.stepos.widget.toolbar.a aVar) {
            q(recyclerView, aVar);
            R(recyclerView);
            return this.f16371m ? l.b(this.f16370l, 0) : i5;
        }

        private final void N(final View view, int i5, final com.stepos.widget.toolbar.a aVar) {
            u();
            final int expandRange = aVar.getExpandRange();
            int iV = v(view, expandRange, aVar);
            if (iV == i5) {
                return;
            }
            if (!(view instanceof RecyclerView)) {
                final t tVar = new t();
                tVar.f17834a = iV;
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(iV, i5);
                valueAnimatorOfInt.setDuration(250L);
                valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: w3.b
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        StepOSAppBarLayout.Behavior.P(view, tVar, this, expandRange, aVar, valueAnimator);
                    }
                });
                valueAnimatorOfInt.addListener(new c(view, expandRange, aVar));
                valueAnimatorOfInt.start();
                this.f16377s = valueAnimatorOfInt;
                return;
            }
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.stopScroll();
            q(recyclerView, aVar);
            R(recyclerView);
            if (this.f16371m) {
                int i6 = this.f16370l;
                if (i6 == i5) {
                    aVar.N(l.h(i5, 0, expandRange), expandRange);
                    return;
                }
                this.f16372n = true;
                this.f16373o = i5;
                this.f16374p = expandRange;
                recyclerView.smoothScrollBy(0, i5 - i6);
                t();
                Runnable runnable = new Runnable() { // from class: w3.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        StepOSAppBarLayout.Behavior.O(this.f23693a, view, aVar);
                    }
                };
                this.f16376r = runnable;
                view.postDelayed(runnable, 430L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void O(Behavior behavior, View view, com.stepos.widget.toolbar.a aVar) {
            behavior.f16376r = null;
            if (behavior.f16372n) {
                WeakReference<RecyclerView> weakReference = behavior.f16368j;
                if ((weakReference != null ? weakReference.get() : null) == view) {
                    behavior.y((RecyclerView) view, aVar);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void P(View view, t tVar, Behavior behavior, int i5, com.stepos.widget.toolbar.a aVar, ValueAnimator valueAnimator) {
            k.g(valueAnimator, "animator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            k.e(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) animatedValue).intValue();
            if (view instanceof NestedScrollView) {
                ((NestedScrollView) view).scrollTo(0, iIntValue);
            } else if (view instanceof RecyclerView) {
                int i6 = iIntValue - tVar.f17834a;
                if (i6 != 0) {
                    ((RecyclerView) view).scrollBy(0, i6);
                }
            } else {
                view.scrollTo(0, iIntValue);
            }
            tVar.f17834a = iIntValue;
            aVar.N(l.h(behavior.v(view, i5, aVar), 0, i5), i5);
        }

        private final int Q(int i5, int i6) {
            if (i5 / i6 < 0.5f) {
                return 0;
            }
            return i6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void R(RecyclerView recyclerView) {
            Integer numX = x(recyclerView);
            if (numX != null) {
                this.f16370l = numX.intValue();
                this.f16371m = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void S(RecyclerView recyclerView, int i5) {
            Integer numX = x(recyclerView);
            if (numX != null) {
                this.f16370l = numX.intValue();
                this.f16371m = true;
            } else if (this.f16371m) {
                this.f16370l = l.b(this.f16370l + i5, 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void p(RecyclerView recyclerView, com.stepos.widget.toolbar.a aVar) {
            int expandRange = aVar.getExpandRange();
            aVar.N(l.h(this.f16371m ? this.f16370l : expandRange, 0, expandRange), expandRange);
        }

        private final void q(RecyclerView recyclerView, com.stepos.widget.toolbar.a aVar) {
            WeakReference<StepOSAppBarLayout> weakReference = this.f16366h;
            if (weakReference == null) {
                ViewParent parent = recyclerView.getParent();
                weakReference = new WeakReference<>(parent instanceof StepOSAppBarLayout ? (StepOSAppBarLayout) parent : null);
            }
            this.f16366h = weakReference;
            this.f16367i = new WeakReference<>(aVar);
            WeakReference<RecyclerView> weakReference2 = this.f16368j;
            if ((weakReference2 != null ? weakReference2.get() : null) == recyclerView && this.f16369k != null) {
                R(recyclerView);
                return;
            }
            w();
            this.f16368j = new WeakReference<>(recyclerView);
            this.f16370l = 0;
            this.f16371m = false;
            b bVar = new b();
            this.f16369k = bVar;
            recyclerView.addOnScrollListener(bVar);
            R(recyclerView);
        }

        private final void r(StepOSAppBarLayout stepOSAppBarLayout) {
            Runnable runnable = this.f16364f;
            if (runnable != null) {
                stepOSAppBarLayout.removeCallbacks(runnable);
            }
            this.f16364f = null;
        }

        private final void s() {
            t();
            WeakReference<RecyclerView> weakReference = this.f16368j;
            RecyclerView recyclerView = weakReference != null ? weakReference.get() : null;
            if (this.f16372n && recyclerView != null) {
                recyclerView.stopScroll();
            }
            this.f16372n = false;
            this.f16373o = 0;
            this.f16374p = 0;
        }

        private final void t() {
            RecyclerView recyclerView;
            Runnable runnable = this.f16376r;
            if (runnable == null) {
                return;
            }
            this.f16376r = null;
            WeakReference<RecyclerView> weakReference = this.f16368j;
            if (weakReference == null || (recyclerView = weakReference.get()) == null) {
                return;
            }
            recyclerView.removeCallbacks(runnable);
        }

        private final void u() {
            ValueAnimator valueAnimator = this.f16377s;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.f16377s = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int v(View view, int i5, com.stepos.widget.toolbar.a aVar) {
            return view instanceof NestedScrollView ? ((NestedScrollView) view).getScrollY() : view instanceof RecyclerView ? M((RecyclerView) view, i5, aVar) : view.getScrollY();
        }

        private final void w() {
            t();
            WeakReference<RecyclerView> weakReference = this.f16368j;
            RecyclerView recyclerView = weakReference != null ? weakReference.get() : null;
            RecyclerView.OnScrollListener onScrollListener = this.f16369k;
            if (onScrollListener != null && recyclerView != null) {
                recyclerView.removeOnScrollListener(onScrollListener);
            }
            this.f16368j = null;
            this.f16369k = null;
            this.f16370l = 0;
            this.f16371m = false;
            this.f16372n = false;
        }

        private final Integer x(RecyclerView recyclerView) {
            View viewFindViewByPosition;
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager == null || (viewFindViewByPosition = layoutManager.findViewByPosition(0)) == null) {
                return null;
            }
            return Integer.valueOf(l.b(recyclerView.getPaddingTop() - layoutManager.getDecoratedTop(viewFindViewByPosition), 0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void y(RecyclerView recyclerView, com.stepos.widget.toolbar.a aVar) {
            int i5;
            if (this.f16372n) {
                WeakReference<RecyclerView> weakReference = this.f16368j;
                if ((weakReference != null ? weakReference.get() : null) != recyclerView) {
                    return;
                }
                t();
                int i6 = this.f16373o;
                Integer numValueOf = Integer.valueOf(this.f16374p);
                Integer num = numValueOf.intValue() > 0 ? numValueOf : null;
                int iIntValue = num != null ? num.intValue() : aVar.getExpandRange();
                recyclerView.stopScroll();
                R(recyclerView);
                if (this.f16371m && (i5 = this.f16370l) != i6) {
                    this.f16375q = true;
                    recyclerView.scrollBy(0, i6 - i5);
                    this.f16375q = false;
                    R(recyclerView);
                }
                this.f16370l = i6;
                this.f16371m = true;
                this.f16372n = false;
                this.f16373o = 0;
                this.f16374p = 0;
                aVar.N(l.h(i6, 0, iIntValue), iIntValue);
            }
        }

        private final boolean z(StepOSAppBarLayout stepOSAppBarLayout, com.stepos.widget.toolbar.a aVar, MotionEvent motionEvent) {
            float x5 = (motionEvent.getX() - stepOSAppBarLayout.getLeft()) - aVar.getLeft();
            float y5 = (motionEvent.getY() - stepOSAppBarLayout.getTop()) - aVar.getTop();
            return A(aVar.getStartActionContainer(), x5, y5) || A(aVar.getEndActionContainer(), x5, y5);
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0075  */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r4, com.stepos.widget.toolbar.StepOSAppBarLayout r5, android.view.MotionEvent r6) {
            /*
                r3 = this;
                java.lang.String r0 = "parent"
                j4.k.g(r4, r0)
                java.lang.String r4 = "child"
                j4.k.g(r5, r4)
                java.lang.String r4 = "ev"
                j4.k.g(r6, r4)
                boolean r4 = r5.b()
                r0 = 0
                if (r4 == 0) goto L98
                boolean r4 = r5.c()
                if (r4 != 0) goto L1e
                goto L98
            L1e:
                int r4 = r3.f16359a
                if (r4 >= 0) goto L30
                android.content.Context r4 = r5.getContext()
                android.view.ViewConfiguration r4 = android.view.ViewConfiguration.get(r4)
                int r4 = r4.getScaledTouchSlop()
                r3.f16359a = r4
            L30:
                com.stepos.widget.toolbar.a r4 = r5.a()
                int r1 = r6.getActionMasked()
                r2 = 1
                if (r1 == 0) goto L7c
                if (r1 == r2) goto L75
                r5 = 2
                if (r1 == r5) goto L44
                r4 = 3
                if (r1 == r4) goto L75
                goto L95
            L44:
                boolean r5 = r3.f16362d
                if (r5 != 0) goto L74
                boolean r5 = r3.f16363e
                if (r5 != 0) goto L4d
                goto L74
            L4d:
                float r5 = r3.f16360b
                float r0 = r6.getY()
                float r5 = r5 - r0
                float r0 = java.lang.Math.abs(r5)
                int r1 = r3.f16359a
                float r1 = (float) r1
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 <= 0) goto L95
                if (r4 == 0) goto L95
                int r5 = l4.C0848a.a(r5)
                boolean r4 = r4.p(r5)
                if (r4 == 0) goto L95
                r3.f16361c = r2
                float r4 = r6.getY()
                r3.f16360b = r4
                goto L95
            L74:
                return r0
            L75:
                r3.f16361c = r0
                r3.f16362d = r0
                r3.f16363e = r0
                goto L95
            L7c:
                float r1 = r6.getY()
                r3.f16360b = r1
                r3.f16361c = r0
                if (r4 == 0) goto L8d
                boolean r4 = r3.z(r5, r4, r6)
                if (r4 == 0) goto L8d
                r0 = r2
            L8d:
                r3.f16362d = r0
                boolean r4 = r3.B(r5, r6)
                r3.f16363e = r4
            L95:
                boolean r3 = r3.f16361c
                return r3
            L98:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.toolbar.StepOSAppBarLayout.Behavior.onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, com.stepos.widget.toolbar.StepOSAppBarLayout, android.view.MotionEvent):boolean");
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, StepOSAppBarLayout stepOSAppBarLayout, int i5) {
            k.g(coordinatorLayout, "parent");
            k.g(stepOSAppBarLayout, "child");
            coordinatorLayout.W(stepOSAppBarLayout, i5);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, StepOSAppBarLayout stepOSAppBarLayout, View view, float f5, float f6, boolean z5) {
            k.g(coordinatorLayout, "parent");
            k.g(stepOSAppBarLayout, "child");
            k.g(view, "target");
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, StepOSAppBarLayout stepOSAppBarLayout, View view, float f5, float f6) {
            k.g(coordinatorLayout, "parent");
            k.g(stepOSAppBarLayout, "child");
            k.g(view, "target");
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, StepOSAppBarLayout stepOSAppBarLayout, View view, int i5, int i6, int[] iArr, int i7) {
            k.g(coordinatorLayout, "parent");
            k.g(stepOSAppBarLayout, "child");
            k.g(view, "target");
            k.g(iArr, "consumed");
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, StepOSAppBarLayout stepOSAppBarLayout, View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
            k.g(coordinatorLayout, "parent");
            k.g(stepOSAppBarLayout, "child");
            k.g(view, "target");
            k.g(iArr, "consumed");
            com.stepos.widget.toolbar.a aVarA = stepOSAppBarLayout.a();
            if (aVarA == null) {
                return;
            }
            this.f16365g = new WeakReference<>(view);
            this.f16367i = new WeakReference<>(aVarA);
            int expandRange = aVarA.getExpandRange();
            int iV = v(view, expandRange, aVarA);
            aVarA.N(l.e(iV, expandRange), expandRange);
            if (i8 >= 0 || iV != 0) {
                return;
            }
            iArr[1] = iArr[1] + i8;
            if (aVarA.getOverScrollTranslationY() > 0.0f) {
                aVarA.K(false);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r2, com.stepos.widget.toolbar.StepOSAppBarLayout r3, android.view.View r4, android.view.View r5, int r6, int r7) {
            /*
                r1 = this;
                java.lang.String r0 = "parent"
                j4.k.g(r2, r0)
                java.lang.String r2 = "child"
                j4.k.g(r3, r2)
                java.lang.String r2 = "directTargetChild"
                j4.k.g(r4, r2)
                java.lang.String r2 = "target"
                j4.k.g(r5, r2)
                java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference
                r2.<init>(r3)
                r1.f16366h = r2
                com.stepos.widget.toolbar.a r2 = r3.a()
                boolean r4 = r5 instanceof androidx.recyclerview.widget.RecyclerView
                if (r4 == 0) goto L2b
                if (r2 == 0) goto L2b
                r4 = r5
                androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4
                r1.q(r4, r2)
            L2b:
                boolean r2 = r1.f16372n
                if (r2 == 0) goto L3e
                java.lang.ref.WeakReference<androidx.recyclerview.widget.RecyclerView> r2 = r1.f16368j
                if (r2 == 0) goto L3a
                java.lang.Object r2 = r2.get()
                androidx.recyclerview.widget.RecyclerView r2 = (androidx.recyclerview.widget.RecyclerView) r2
                goto L3b
            L3a:
                r2 = 0
            L3b:
                if (r2 != r5) goto L3e
                goto L49
            L3e:
                r1.r(r3)
                r1.u()
                if (r7 != 0) goto L49
                r1.s()
            L49:
                boolean r1 = r3.c()
                if (r1 == 0) goto L55
                r1 = r6 & 2
                if (r1 == 0) goto L55
                r1 = 1
                return r1
            L55:
                r1 = 0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.toolbar.StepOSAppBarLayout.Behavior.onStartNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, com.stepos.widget.toolbar.StepOSAppBarLayout, android.view.View, android.view.View, int, int):boolean");
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: J, reason: merged with bridge method [inline-methods] */
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, StepOSAppBarLayout stepOSAppBarLayout, final View view, int i5) {
            k.g(coordinatorLayout, "parent");
            k.g(stepOSAppBarLayout, "child");
            k.g(view, "target");
            final com.stepos.widget.toolbar.a aVarA = stepOSAppBarLayout.a();
            if (aVarA == null) {
                return;
            }
            this.f16367i = new WeakReference<>(aVarA);
            if (this.f16372n) {
                WeakReference<RecyclerView> weakReference = this.f16368j;
                if ((weakReference != null ? weakReference.get() : null) == view) {
                    return;
                }
            }
            aVarA.G(0);
            int expandRange = aVarA.getExpandRange();
            int iV = v(view, expandRange, aVarA);
            aVarA.N(l.e(iV, expandRange), expandRange);
            if (stepOSAppBarLayout.d() && 1 <= iV && iV < expandRange) {
                Runnable runnable = new Runnable() { // from class: w3.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        StepOSAppBarLayout.Behavior.K(this.f23701a, aVarA, view);
                    }
                };
                this.f16364f = runnable;
                if (i5 == 0) {
                    stepOSAppBarLayout.postDelayed(runnable, stepOSAppBarLayout.getSnapDelay());
                } else {
                    stepOSAppBarLayout.post(runnable);
                }
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: L, reason: merged with bridge method [inline-methods] */
        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, StepOSAppBarLayout stepOSAppBarLayout, MotionEvent motionEvent) {
            k.g(coordinatorLayout, "parent");
            k.g(stepOSAppBarLayout, "child");
            k.g(motionEvent, "event");
            com.stepos.widget.toolbar.a aVarA = stepOSAppBarLayout.a();
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (!this.f16363e || (aVarA != null && z(stepOSAppBarLayout, aVarA, motionEvent))) {
                    return false;
                }
                this.f16360b = motionEvent.getY();
                this.f16361c = false;
                return true;
            }
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int iA = C0848a.a(this.f16360b - motionEvent.getY());
                    this.f16360b = motionEvent.getY();
                    if (Math.abs(iA) > 0 && aVarA != null) {
                        aVarA.v(iA);
                        this.f16361c = true;
                    }
                    return true;
                }
                if (actionMasked != 3) {
                    return true;
                }
            }
            if (this.f16361c && stepOSAppBarLayout.d() && aVarA != null) {
                WeakReference<View> weakReference = this.f16365g;
                View view = weakReference != null ? weakReference.get() : null;
                int expandRange = aVarA.getExpandRange();
                int scrollOffset = aVarA.getScrollOffset();
                if (1 <= scrollOffset && scrollOffset < expandRange) {
                    if (view != null) {
                        N(view, Q(scrollOffset, expandRange), aVarA);
                    } else {
                        aVarA.P(true);
                    }
                }
            }
            this.f16361c = false;
            this.f16363e = false;
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onDetachedFromLayoutParams() {
            StepOSAppBarLayout stepOSAppBarLayout;
            WeakReference<StepOSAppBarLayout> weakReference = this.f16366h;
            if (weakReference != null && (stepOSAppBarLayout = weakReference.get()) != null) {
                r(stepOSAppBarLayout);
            }
            u();
            s();
            w();
            this.f16366h = null;
            this.f16367i = null;
            this.f16365g = null;
            super.onDetachedFromLayoutParams();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            k.g(context, "context");
            k.g(attributeSet, "attrs");
            this.f16359a = -1;
        }
    }
}
