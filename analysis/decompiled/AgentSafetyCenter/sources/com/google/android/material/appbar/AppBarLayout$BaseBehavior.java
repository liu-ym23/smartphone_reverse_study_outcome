package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import com.google.android.material.appbar.g;
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import n3.i0;
import n3.k0;
import n3.o;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class AppBarLayout$BaseBehavior<T extends g> extends l {

    /* renamed from: a, reason: collision with root package name */
    public h f2308a;

    /* renamed from: b, reason: collision with root package name */
    public OverScroller f2309b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2310c;

    /* renamed from: d, reason: collision with root package name */
    public int f2311d;

    /* renamed from: e, reason: collision with root package name */
    public int f2312e;

    /* renamed from: f, reason: collision with root package name */
    public int f2313f;

    /* renamed from: g, reason: collision with root package name */
    public VelocityTracker f2314g;

    /* renamed from: h, reason: collision with root package name */
    public int f2315h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public ValueAnimator f2316j;

    /* renamed from: k, reason: collision with root package name */
    public e f2317k;

    /* renamed from: l, reason: collision with root package name */
    public WeakReference f2318l;

    public AppBarLayout$BaseBehavior(Context context, AttributeSet attributeSet) {
        super(0);
        this.f2311d = -1;
        this.f2313f = -1;
    }

    public static View c(AppBarLayout$BaseBehavior appBarLayout$BaseBehavior, androidx.coordinatorlayout.widget.a aVar) {
        int childCount = aVar.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = aVar.getChildAt(i);
            if (((b3.d) childAt.getLayoutParams()).f1877a instanceof AppBarLayout$ScrollingViewBehavior) {
                return childAt;
            }
        }
        return null;
    }

    public static View e(androidx.coordinatorlayout.widget.a aVar) {
        int childCount = aVar.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = aVar.getChildAt(i);
            if ((childAt instanceof o) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m(androidx.coordinatorlayout.widget.a r7, com.google.android.material.appbar.g r8, int r9, int r10, boolean r11) {
        /*
            int r0 = java.lang.Math.abs(r9)
            int r1 = r8.getChildCount()
            r2 = 0
            r3 = r2
        La:
            r4 = 0
            if (r3 >= r1) goto L21
            android.view.View r5 = r8.getChildAt(r3)
            int r6 = r5.getTop()
            if (r0 < r6) goto L1e
            int r6 = r5.getBottom()
            if (r0 > r6) goto L1e
            goto L22
        L1e:
            int r3 = r3 + 1
            goto La
        L21:
            r5 = r4
        L22:
            if (r5 == 0) goto L5b
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            com.google.android.material.appbar.f r0 = (com.google.android.material.appbar.f) r0
            int r0 = r0.f2342a
            r1 = r0 & 1
            if (r1 == 0) goto L5b
            int r1 = r5.getMinimumHeight()
            r3 = 1
            if (r10 <= 0) goto L49
            r10 = r0 & 12
            if (r10 == 0) goto L49
            int r9 = -r9
            int r10 = r5.getBottom()
            int r10 = r10 - r1
            int r0 = r8.getTopInset()
            int r10 = r10 - r0
            if (r9 < r10) goto L5b
            goto L5c
        L49:
            r10 = r0 & 2
            if (r10 == 0) goto L5b
            int r9 = -r9
            int r10 = r5.getBottom()
            int r10 = r10 - r1
            int r0 = r8.getTopInset()
            int r10 = r10 - r0
            if (r9 < r10) goto L5b
            goto L5c
        L5b:
            r3 = r2
        L5c:
            boolean r9 = r8.f2355p
            if (r9 == 0) goto L68
            android.view.View r9 = e(r7)
            boolean r3 = r8.j(r9)
        L68:
            boolean r9 = r8.i(r3)
            if (r11 != 0) goto Lac
            if (r9 == 0) goto Ld3
            p5.i r7 = r7.f1016f
            java.lang.Object r7 = r7.f9731f
            p.p0 r7 = (p.p0) r7
            java.lang.Object r7 = r7.get(r8)
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            if (r7 != 0) goto L7f
            goto L84
        L7f:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r7)
        L84:
            if (r4 != 0) goto L88
            java.util.List r4 = java.util.Collections.EMPTY_LIST
        L88:
            int r7 = r4.size()
        L8c:
            if (r2 >= r7) goto Ld3
            java.lang.Object r9 = r4.get(r2)
            android.view.View r9 = (android.view.View) r9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            b3.d r9 = (b3.d) r9
            b3.a r9 = r9.f1877a
            boolean r10 = r9 instanceof com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior
            if (r10 == 0) goto La9
            com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior r9 = (com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior) r9
            int r7 = r9.getOverlayTop()
            if (r7 == 0) goto Ld3
            goto Lac
        La9:
            int r2 = r2 + 1
            goto L8c
        Lac:
            android.graphics.drawable.Drawable r7 = r8.getBackground()
            if (r7 == 0) goto Lb9
            android.graphics.drawable.Drawable r7 = r8.getBackground()
            r7.jumpToCurrentState()
        Lb9:
            android.graphics.drawable.Drawable r7 = r8.getForeground()
            if (r7 == 0) goto Lc6
            android.graphics.drawable.Drawable r7 = r8.getForeground()
            r7.jumpToCurrentState()
        Lc6:
            android.animation.StateListAnimator r7 = r8.getStateListAnimator()
            if (r7 == 0) goto Ld3
            android.animation.StateListAnimator r7 = r8.getStateListAnimator()
            r7.jumpToCurrentState()
        Ld3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout$BaseBehavior.m(androidx.coordinatorlayout.widget.a, com.google.android.material.appbar.g, int, int, boolean):void");
    }

    public final void d(androidx.coordinatorlayout.widget.a aVar, g gVar, int i) {
        int iAbs = Math.abs(f() - i);
        float fAbs = Math.abs(0.0f);
        int iRound = fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / gVar.getHeight()) + 1.0f) * 150.0f);
        int iF = f();
        ValueAnimator valueAnimator = this.f2316j;
        if (iF == i) {
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                return;
            }
            this.f2316j.cancel();
            return;
        }
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f2316j = valueAnimator2;
            valueAnimator2.setInterpolator(q6.a.f10104d);
            ValueAnimator valueAnimator3 = this.f2316j;
            c cVar = new c();
            cVar.f2333c = this;
            cVar.f2331a = aVar;
            cVar.f2332b = gVar;
            VarHandle.storeStoreFence();
            valueAnimator3.addUpdateListener(cVar);
        } else {
            valueAnimator.cancel();
        }
        this.f2316j.setDuration(Math.min(iRound, 600));
        this.f2316j.setIntValues(iF, i);
        this.f2316j.start();
    }

    public final int f() {
        return getTopAndBottomOffset() + this.f2315h;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(androidx.coordinatorlayout.widget.a r9, com.google.android.material.appbar.g r10, android.view.View r11, int r12, int[] r13) {
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
            int r0 = r8.f()
            int r5 = r0 - r12
            r2 = r8
            r3 = r9
            r4 = r10
            int r8 = r2.j(r3, r4, r5, r6, r7)
            r9 = 1
            r13[r9] = r8
            goto L2c
        L2b:
            r4 = r10
        L2c:
            boolean r8 = r4.f2355p
            if (r8 == 0) goto L37
            boolean r8 = r4.j(r11)
            r4.i(r8)
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout$BaseBehavior.g(androidx.coordinatorlayout.widget.a, com.google.android.material.appbar.g, android.view.View, int, int[]):void");
    }

    @Override // b3.a
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean onStartNestedScroll(androidx.coordinatorlayout.widget.a aVar, g gVar, View view, View view2, int i, int i3) {
        ValueAnimator valueAnimator;
        boolean z10 = (i & 2) != 0 && (gVar.f2355p || gVar.f2354o || (gVar.getTotalScrollRange() != 0 && aVar.getHeight() - view.getHeight() <= gVar.getHeight()));
        if (z10 && (valueAnimator = this.f2316j) != null) {
            valueAnimator.cancel();
        }
        this.f2318l = null;
        this.i = i3;
        return z10;
    }

    public final e i(Parcelable parcelable, g gVar) {
        int topAndBottomOffset = getTopAndBottomOffset();
        int childCount = gVar.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = gVar.getChildAt(i);
            int bottom = childAt.getBottom() + topAndBottomOffset;
            if (childAt.getTop() + topAndBottomOffset <= 0 && bottom >= 0) {
                if (parcelable == null) {
                    parcelable = t3.b.EMPTY_STATE;
                }
                e eVar = new e(parcelable);
                boolean z10 = topAndBottomOffset == 0;
                eVar.f2339f = z10;
                eVar.f2338c = !z10 && (-topAndBottomOffset) >= gVar.getTotalScrollRange();
                eVar.f2340g = i;
                eVar.i = bottom == gVar.getTopInset() + childAt.getMinimumHeight();
                eVar.f2341h = bottom / childAt.getHeight();
                return eVar;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x017b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int j(androidx.coordinatorlayout.widget.a r18, android.view.View r19, int r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout$BaseBehavior.j(androidx.coordinatorlayout.widget.a, android.view.View, int, int, int):int");
    }

    public final void k(androidx.coordinatorlayout.widget.a aVar, View view, int i) {
        j(aVar, view, i, Integer.MIN_VALUE, Reader.READ_DONE);
    }

    public final void l(androidx.coordinatorlayout.widget.a aVar, g gVar) {
        int paddingTop = gVar.getPaddingTop() + gVar.getTopInset();
        int iF = f() - paddingTop;
        int childCount = gVar.getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                i = -1;
                break;
            }
            View childAt = gVar.getChildAt(i);
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            f fVar = (f) childAt.getLayoutParams();
            if ((fVar.f2342a & 32) == 32) {
                top -= ((LinearLayout.LayoutParams) fVar).topMargin;
                bottom += ((LinearLayout.LayoutParams) fVar).bottomMargin;
            }
            int i3 = -iF;
            if (top <= i3 && bottom >= i3) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            View childAt2 = gVar.getChildAt(i);
            f fVar2 = (f) childAt2.getLayoutParams();
            int i10 = fVar2.f2342a;
            if ((i10 & 17) == 17) {
                int topInset = -childAt2.getTop();
                int minimumHeight = -childAt2.getBottom();
                if (i == 0 && gVar.getFitsSystemWindows() && childAt2.getFitsSystemWindows()) {
                    topInset -= gVar.getTopInset();
                }
                if ((i10 & 2) == 2) {
                    minimumHeight += childAt2.getMinimumHeight();
                } else if ((i10 & 5) == 5) {
                    int minimumHeight2 = childAt2.getMinimumHeight() + minimumHeight;
                    if (iF < minimumHeight2) {
                        topInset = minimumHeight2;
                    } else {
                        minimumHeight = minimumHeight2;
                    }
                }
                if ((i10 & 32) == 32) {
                    topInset += ((LinearLayout.LayoutParams) fVar2).topMargin;
                    minimumHeight -= ((LinearLayout.LayoutParams) fVar2).bottomMargin;
                }
                if (iF < (minimumHeight + topInset) / 2) {
                    topInset = minimumHeight;
                }
                d(aVar, gVar, td.h.j(topInset + paddingTop, -gVar.getTotalScrollRange(), 0));
            }
        }
    }

    @Override // b3.a
    public final boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.a aVar, View view, MotionEvent motionEvent) {
        View view2;
        int iFindPointerIndex;
        if (this.f2313f < 0) {
            this.f2313f = ViewConfiguration.get(aVar.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f2310c) {
            int i = this.f2311d;
            if (i == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i)) == -1) {
                return false;
            }
            int y10 = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y10 - this.f2312e) > this.f2313f) {
                this.f2312e = y10;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f2311d = -1;
            int x6 = (int) motionEvent.getX();
            int y11 = (int) motionEvent.getY();
            WeakReference weakReference = this.f2318l;
            boolean z10 = (weakReference == null || !((view2 = (View) weakReference.get()) == null || !view2.isShown() || view2.canScrollVertically(-1))) && aVar.z(view, x6, y11);
            this.f2310c = z10;
            if (z10) {
                this.f2312e = y11;
                this.f2311d = motionEvent.getPointerId(0);
                if (this.f2314g == null) {
                    this.f2314g = VelocityTracker.obtain();
                }
                OverScroller overScroller = this.f2309b;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f2309b.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f2314g;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    @Override // com.google.android.material.appbar.l, b3.a
    public final boolean onLayoutChild(androidx.coordinatorlayout.widget.a aVar, View view, int i) {
        g gVar = (g) view;
        super.onLayoutChild(aVar, gVar, i);
        int pendingAction = gVar.getPendingAction();
        e eVar = this.f2317k;
        if (eVar == null || (pendingAction & 8) != 0) {
            if (pendingAction != 0) {
                boolean z10 = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i3 = -gVar.getUpNestedPreScrollRange();
                    if (z10) {
                        d(aVar, gVar, i3);
                    } else {
                        k(aVar, gVar, i3);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z10) {
                        d(aVar, gVar, 0);
                    } else {
                        k(aVar, gVar, 0);
                    }
                }
            }
        } else if (eVar.f2338c) {
            k(aVar, gVar, -gVar.getTotalScrollRange());
        } else if (eVar.f2339f) {
            k(aVar, gVar, 0);
        } else {
            View childAt = gVar.getChildAt(eVar.f2340g);
            int i10 = -childAt.getBottom();
            k(aVar, gVar, this.f2317k.i ? gVar.getTopInset() + childAt.getMinimumHeight() + i10 : Math.round(childAt.getHeight() * this.f2317k.f2341h) + i10);
        }
        gVar.f2349j = 0;
        this.f2317k = null;
        setTopAndBottomOffset(td.h.j(getTopAndBottomOffset(), -gVar.getTotalScrollRange(), 0));
        m(aVar, gVar, getTopAndBottomOffset(), 0, true);
        gVar.g(getTopAndBottomOffset());
        WeakHashMap weakHashMap = k0.f8724a;
        if (i0.a(aVar) != null) {
            return true;
        }
        k0.g(aVar, new d(this, gVar, aVar));
        return true;
    }

    @Override // b3.a
    public final boolean onMeasureChild(androidx.coordinatorlayout.widget.a aVar, View view, int i, int i3, int i10, int i11) {
        g gVar = (g) view;
        if (((ViewGroup.MarginLayoutParams) ((b3.d) gVar.getLayoutParams())).height != -2) {
            return false;
        }
        aVar.C(gVar, i, i3, View.MeasureSpec.makeMeasureSpec(0, 0), 0);
        return true;
    }

    @Override // b3.a
    public final /* bridge */ /* synthetic */ void onNestedPreScroll(androidx.coordinatorlayout.widget.a aVar, View view, View view2, int i, int i3, int[] iArr, int i10) {
        g(aVar, (g) view, view2, i3, iArr);
    }

    @Override // b3.a
    public final void onNestedScroll(androidx.coordinatorlayout.widget.a aVar, View view, View view2, int i, int i3, int i10, int i11, int i12, int[] iArr) {
        g gVar = (g) view;
        if (i11 < 0) {
            iArr[1] = j(aVar, gVar, f() - i11, -gVar.getDownNestedScrollRange(), 0);
        }
        if (i11 == 0) {
            WeakHashMap weakHashMap = k0.f8724a;
            if (i0.a(aVar) != null) {
                return;
            }
            k0.g(aVar, new d(this, gVar, aVar));
        }
    }

    @Override // b3.a
    public final void onRestoreInstanceState(androidx.coordinatorlayout.widget.a aVar, View view, Parcelable parcelable) {
        g gVar = (g) view;
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(aVar, gVar, parcelable);
            this.f2317k = null;
        } else {
            e eVar = (e) parcelable;
            this.f2317k = eVar;
            super.onRestoreInstanceState(aVar, gVar, eVar.getSuperState());
        }
    }

    @Override // b3.a
    public final Parcelable onSaveInstanceState(androidx.coordinatorlayout.widget.a aVar, View view) {
        g gVar = (g) view;
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState(aVar, gVar);
        e eVarI = i(parcelableOnSaveInstanceState, gVar);
        return eVarI == null ? parcelableOnSaveInstanceState : eVarI;
    }

    @Override // b3.a
    public final void onStopNestedScroll(androidx.coordinatorlayout.widget.a aVar, View view, View view2, int i) {
        g gVar = (g) view;
        if (this.i == 0 || i == 1) {
            l(aVar, gVar);
            if (gVar.f2355p) {
                gVar.i(gVar.j(view2));
            }
        }
        this.f2318l = new WeakReference(view2);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0100 A[ADDED_TO_REGION] */
    @Override // b3.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(androidx.coordinatorlayout.widget.a r21, android.view.View r22, android.view.MotionEvent r23) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout$BaseBehavior.onTouchEvent(androidx.coordinatorlayout.widget.a, android.view.View, android.view.MotionEvent):boolean");
    }

    public AppBarLayout$BaseBehavior() {
        this.f2311d = -1;
        this.f2313f = -1;
    }
}
