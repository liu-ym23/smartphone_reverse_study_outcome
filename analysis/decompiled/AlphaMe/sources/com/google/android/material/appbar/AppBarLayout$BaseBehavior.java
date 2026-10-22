package com.google.android.material.appbar;

import K.InterfaceC0085q;
import K.O;
import K.S;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.baidu.platform.comapi.UIMsg;
import com.google.android.material.appbar.h;
import com.stepos.alphame.utils.Property;
import f1.AbstractC0557a;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import n1.AbstractC0775a;

/* loaded from: classes.dex */
public class AppBarLayout$BaseBehavior<T extends h> extends i {

    /* renamed from: h, reason: collision with root package name */
    public int f10259h;

    /* renamed from: i, reason: collision with root package name */
    public int f10260i;

    /* renamed from: j, reason: collision with root package name */
    public ValueAnimator f10261j;

    /* renamed from: k, reason: collision with root package name */
    public SavedState f10262k;

    /* renamed from: l, reason: collision with root package name */
    public WeakReference f10263l;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new d();

        /* renamed from: a, reason: collision with root package name */
        public boolean f10264a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f10265b;

        /* renamed from: c, reason: collision with root package name */
        public int f10266c;

        /* renamed from: d, reason: collision with root package name */
        public float f10267d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f10268e;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f10264a = parcel.readByte() != 0;
            this.f10265b = parcel.readByte() != 0;
            this.f10266c = parcel.readInt();
            this.f10267d = parcel.readFloat();
            this.f10268e = parcel.readByte() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeByte(this.f10264a ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f10265b ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f10266c);
            parcel.writeFloat(this.f10267d);
            parcel.writeByte(this.f10268e ? (byte) 1 : (byte) 0);
        }
    }

    public AppBarLayout$BaseBehavior() {
        this.f10324d = -1;
        this.f10326f = -1;
    }

    public static View f(AppBarLayout$BaseBehavior appBarLayout$BaseBehavior, CoordinatorLayout coordinatorLayout) {
        appBarLayout$BaseBehavior.getClass();
        int childCount = coordinatorLayout.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = coordinatorLayout.getChildAt(i4);
            if (((A.d) childAt.getLayoutParams()).f5a instanceof AppBarLayout$ScrollingViewBehavior) {
                return childAt;
            }
        }
        return null;
    }

    public static View h(CoordinatorLayout coordinatorLayout) {
        int childCount = coordinatorLayout.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = coordinatorLayout.getChildAt(i4);
            if ((childAt instanceof InterfaceC0085q) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
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
    public static void m(androidx.coordinatorlayout.widget.CoordinatorLayout r6, com.google.android.material.appbar.h r7, int r8, int r9, boolean r10) {
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
            com.google.android.material.appbar.f r0 = (com.google.android.material.appbar.f) r0
            int r0 = r0.f10290a
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
            boolean r8 = r7.f10306l
            if (r8 == 0) goto L67
            android.view.View r8 = h(r6)
            boolean r3 = r7.j(r8)
        L67:
            boolean r8 = r7.i(r3)
            if (r10 != 0) goto La9
            if (r8 == 0) goto Ld0
            t.d r8 = r6.f3252b
            java.lang.Object r8 = r8.f15274b
            q.l r8 = (q.l) r8
            java.lang.Object r8 = r8.get(r7)
            java.util.List r8 = (java.util.List) r8
            java.util.ArrayList r6 = r6.f3254d
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
            A.d r9 = (A.d) r9
            A.b r9 = r9.f5a
            boolean r10 = r9 instanceof com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior
            if (r10 == 0) goto La6
            com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior r9 = (com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior) r9
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout$BaseBehavior.m(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.h, int, int, boolean):void");
    }

    @Override // com.google.android.material.appbar.i
    public final int c() {
        return getTopAndBottomOffset() + this.f10259h;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x018c  */
    @Override // com.google.android.material.appbar.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d(androidx.coordinatorlayout.widget.CoordinatorLayout r18, android.view.View r19, int r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout$BaseBehavior.d(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int, int, int):int");
    }

    public final void g(CoordinatorLayout coordinatorLayout, h hVar, int i4) {
        int iAbs = Math.abs(c() - i4);
        float fAbs = Math.abs(Property.DEFAULT_FLOAT_VALUE);
        int iRound = fAbs > Property.DEFAULT_FLOAT_VALUE ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / hVar.getHeight()) + 1.0f) * 150.0f);
        int iC = c();
        if (iC == i4) {
            ValueAnimator valueAnimator = this.f10261j;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                return;
            }
            this.f10261j.cancel();
            return;
        }
        ValueAnimator valueAnimator2 = this.f10261j;
        if (valueAnimator2 == null) {
            ValueAnimator valueAnimator3 = new ValueAnimator();
            this.f10261j = valueAnimator3;
            valueAnimator3.setInterpolator(AbstractC0775a.f13654e);
            this.f10261j.addUpdateListener(new b(coordinatorLayout, this, hVar));
        } else {
            valueAnimator2.cancel();
        }
        this.f10261j.setDuration(Math.min(iRound, UIMsg.MSG_MAP_PANO_DATA));
        this.f10261j.setIntValues(iC, i4);
        this.f10261j.start();
    }

    public final void i(CoordinatorLayout coordinatorLayout, h hVar, View view, int i4, int[] iArr) {
        int i5;
        int downNestedPreScrollRange;
        if (i4 != 0) {
            if (i4 < 0) {
                i5 = -hVar.getTotalScrollRange();
                downNestedPreScrollRange = hVar.getDownNestedPreScrollRange() + i5;
            } else {
                i5 = -hVar.getUpNestedPreScrollRange();
                downNestedPreScrollRange = 0;
            }
            int i6 = i5;
            int i7 = downNestedPreScrollRange;
            if (i6 != i7) {
                iArr[1] = d(coordinatorLayout, hVar, c() - i4, i6, i7);
            }
        }
        if (hVar.f10306l) {
            hVar.i(hVar.j(view));
        }
    }

    @Override // A.b
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, h hVar, View view, View view2, int i4, int i5) {
        ValueAnimator valueAnimator;
        boolean z4 = (i4 & 2) != 0 && (hVar.f10306l || hVar.f10305k || (hVar.getTotalScrollRange() != 0 && coordinatorLayout.getHeight() - view.getHeight() <= hVar.getHeight()));
        if (z4 && (valueAnimator = this.f10261j) != null) {
            valueAnimator.cancel();
        }
        this.f10263l = null;
        this.f10260i = i5;
        return z4;
    }

    public final SavedState k(Parcelable parcelable, h hVar) {
        int topAndBottomOffset = getTopAndBottomOffset();
        int childCount = hVar.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = hVar.getChildAt(i4);
            int bottom = childAt.getBottom() + topAndBottomOffset;
            if (childAt.getTop() + topAndBottomOffset <= 0 && bottom >= 0) {
                if (parcelable == null) {
                    parcelable = AbsSavedState.EMPTY_STATE;
                }
                SavedState savedState = new SavedState(parcelable);
                boolean z4 = topAndBottomOffset == 0;
                savedState.f10265b = z4;
                savedState.f10264a = !z4 && (-topAndBottomOffset) >= hVar.getTotalScrollRange();
                savedState.f10266c = i4;
                savedState.f10268e = bottom == hVar.getTopInset() + childAt.getMinimumHeight();
                savedState.f10267d = bottom / childAt.getHeight();
                return savedState;
            }
        }
        return null;
    }

    public final void l(CoordinatorLayout coordinatorLayout, h hVar) {
        int paddingTop = hVar.getPaddingTop() + hVar.getTopInset();
        int iC = c() - paddingTop;
        int childCount = hVar.getChildCount();
        int i4 = 0;
        while (true) {
            if (i4 >= childCount) {
                i4 = -1;
                break;
            }
            View childAt = hVar.getChildAt(i4);
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            f fVar = (f) childAt.getLayoutParams();
            if ((fVar.f10290a & 32) == 32) {
                top -= ((LinearLayout.LayoutParams) fVar).topMargin;
                bottom += ((LinearLayout.LayoutParams) fVar).bottomMargin;
            }
            int i5 = -iC;
            if (top <= i5 && bottom >= i5) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 >= 0) {
            View childAt2 = hVar.getChildAt(i4);
            f fVar2 = (f) childAt2.getLayoutParams();
            int i6 = fVar2.f10290a;
            if ((i6 & 17) == 17) {
                int topInset = -childAt2.getTop();
                int minimumHeight = -childAt2.getBottom();
                if (i4 == 0 && hVar.getFitsSystemWindows() && childAt2.getFitsSystemWindows()) {
                    topInset -= hVar.getTopInset();
                }
                if ((i6 & 2) == 2) {
                    minimumHeight += childAt2.getMinimumHeight();
                } else if ((i6 & 5) == 5) {
                    int minimumHeight2 = childAt2.getMinimumHeight() + minimumHeight;
                    if (iC < minimumHeight2) {
                        topInset = minimumHeight2;
                    } else {
                        minimumHeight = minimumHeight2;
                    }
                }
                if ((i6 & 32) == 32) {
                    topInset += ((LinearLayout.LayoutParams) fVar2).topMargin;
                    minimumHeight -= ((LinearLayout.LayoutParams) fVar2).bottomMargin;
                }
                if (iC < (minimumHeight + topInset) / 2) {
                    topInset = minimumHeight;
                }
                g(coordinatorLayout, hVar, AbstractC0557a.o(topInset + paddingTop, -hVar.getTotalScrollRange(), 0));
            }
        }
    }

    @Override // com.google.android.material.appbar.m, A.b
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i4) {
        h hVar = (h) view;
        super.onLayoutChild(coordinatorLayout, hVar, i4);
        int pendingAction = hVar.getPendingAction();
        SavedState savedState = this.f10262k;
        if (savedState == null || (pendingAction & 8) != 0) {
            if (pendingAction != 0) {
                boolean z4 = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i5 = -hVar.getUpNestedPreScrollRange();
                    if (z4) {
                        g(coordinatorLayout, hVar, i5);
                    } else {
                        e(coordinatorLayout, hVar, i5);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z4) {
                        g(coordinatorLayout, hVar, 0);
                    } else {
                        e(coordinatorLayout, hVar, 0);
                    }
                }
            }
        } else if (savedState.f10264a) {
            e(coordinatorLayout, hVar, -hVar.getTotalScrollRange());
        } else if (savedState.f10265b) {
            e(coordinatorLayout, hVar, 0);
        } else {
            View childAt = hVar.getChildAt(savedState.f10266c);
            int i6 = -childAt.getBottom();
            e(coordinatorLayout, hVar, this.f10262k.f10268e ? hVar.getTopInset() + childAt.getMinimumHeight() + i6 : Math.round(childAt.getHeight() * this.f10262k.f10267d) + i6);
        }
        hVar.f10300f = 0;
        this.f10262k = null;
        setTopAndBottomOffset(AbstractC0557a.o(getTopAndBottomOffset(), -hVar.getTotalScrollRange(), 0));
        m(coordinatorLayout, hVar, getTopAndBottomOffset(), 0, true);
        hVar.g(getTopAndBottomOffset());
        WeakHashMap weakHashMap = S.f939a;
        if (O.a(coordinatorLayout) == null) {
            S.h(coordinatorLayout, new c(coordinatorLayout, this, hVar));
        }
        return true;
    }

    @Override // A.b
    public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i4, int i5, int i6, int i7) {
        h hVar = (h) view;
        if (((ViewGroup.MarginLayoutParams) ((A.d) hVar.getLayoutParams())).height != -2) {
            return false;
        }
        coordinatorLayout.C(hVar, i4, i5, View.MeasureSpec.makeMeasureSpec(0, 0), 0);
        return true;
    }

    @Override // A.b
    public final /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i4, int i5, int[] iArr, int i6) {
        i(coordinatorLayout, (h) view, view2, i5, iArr);
    }

    @Override // A.b
    public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
        h hVar = (h) view;
        if (i7 < 0) {
            iArr[1] = d(coordinatorLayout, hVar, c() - i7, -hVar.getDownNestedScrollRange(), 0);
        }
        if (i7 == 0) {
            WeakHashMap weakHashMap = S.f939a;
            if (O.a(coordinatorLayout) != null) {
                return;
            }
            S.h(coordinatorLayout, new c(coordinatorLayout, this, hVar));
        }
    }

    @Override // A.b
    public final void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        h hVar = (h) view;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(coordinatorLayout, hVar, parcelable);
            this.f10262k = null;
        } else {
            SavedState savedState = (SavedState) parcelable;
            this.f10262k = savedState;
            super.onRestoreInstanceState(coordinatorLayout, hVar, savedState.getSuperState());
        }
    }

    @Override // A.b
    public final Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view) {
        h hVar = (h) view;
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, hVar);
        SavedState savedStateK = k(parcelableOnSaveInstanceState, hVar);
        return savedStateK == null ? parcelableOnSaveInstanceState : savedStateK;
    }

    @Override // A.b
    public final void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i4) {
        h hVar = (h) view;
        if (this.f10260i == 0 || i4 == 1) {
            l(coordinatorLayout, hVar);
            if (hVar.f10306l) {
                hVar.i(hVar.j(view2));
            }
        }
        this.f10263l = new WeakReference(view2);
    }

    public AppBarLayout$BaseBehavior(Context context, AttributeSet attributeSet) {
        super(0);
        this.f10324d = -1;
        this.f10326f = -1;
    }
}
