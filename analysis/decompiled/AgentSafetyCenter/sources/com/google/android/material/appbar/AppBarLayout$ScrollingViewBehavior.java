package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;
import java.util.WeakHashMap;
import n3.k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class AppBarLayout$ScrollingViewBehavior extends i {
    public AppBarLayout$ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p6.a.f9824q);
        setOverlayTop(typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // com.google.android.material.appbar.i
    public g findFirstDependency(List<View> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            View view = list.get(i);
            if (view instanceof g) {
                return (g) view;
            }
        }
        return null;
    }

    @Override // com.google.android.material.appbar.l
    public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
        return super.getLeftAndRightOffset();
    }

    @Override // com.google.android.material.appbar.i
    public float getOverlapRatioForOffset(View view) {
        int i;
        if (view instanceof g) {
            g gVar = (g) view;
            int totalScrollRange = gVar.getTotalScrollRange();
            int downNestedPreScrollRange = gVar.getDownNestedPreScrollRange();
            b3.a aVar = ((b3.d) gVar.getLayoutParams()).f1877a;
            int iF = aVar instanceof AppBarLayout$BaseBehavior ? ((AppBarLayout$BaseBehavior) aVar).f() : 0;
            if ((downNestedPreScrollRange == 0 || totalScrollRange + iF > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                return (iF / i) + 1.0f;
            }
        }
        return 0.0f;
    }

    @Override // com.google.android.material.appbar.i
    public int getScrollRange(View view) {
        return view instanceof g ? ((g) view).getTotalScrollRange() : view.getMeasuredHeight();
    }

    @Override // com.google.android.material.appbar.l
    public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
        return super.getTopAndBottomOffset();
    }

    @Override // com.google.android.material.appbar.l
    public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
        return super.isHorizontalOffsetEnabled();
    }

    @Override // com.google.android.material.appbar.l
    public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
        return super.isVerticalOffsetEnabled();
    }

    @Override // b3.a
    public boolean layoutDependsOn(androidx.coordinatorlayout.widget.a aVar, View view, View view2) {
        return view2 instanceof g;
    }

    @Override // b3.a
    public boolean onDependentViewChanged(androidx.coordinatorlayout.widget.a aVar, View view, View view2) {
        b3.a aVar2 = ((b3.d) view2.getLayoutParams()).f1877a;
        if (aVar2 instanceof AppBarLayout$BaseBehavior) {
            int verticalLayoutGap = (getVerticalLayoutGap() + ((view2.getBottom() - view.getTop()) + ((AppBarLayout$BaseBehavior) aVar2).f2315h)) - getOverlapPixelsForOffset(view2);
            WeakHashMap weakHashMap = k0.f8724a;
            view.offsetTopAndBottom(verticalLayoutGap);
        }
        if (!(view2 instanceof g)) {
            return false;
        }
        g gVar = (g) view2;
        if (!gVar.f2355p) {
            return false;
        }
        gVar.i(gVar.j(view));
        return false;
    }

    @Override // b3.a
    public void onDependentViewRemoved(androidx.coordinatorlayout.widget.a aVar, View view, View view2) {
        if (view2 instanceof g) {
            k0.g(aVar, null);
        }
    }

    @Override // com.google.android.material.appbar.l, b3.a
    public /* bridge */ /* synthetic */ boolean onLayoutChild(androidx.coordinatorlayout.widget.a aVar, View view, int i) {
        super.onLayoutChild(aVar, view, i);
        return true;
    }

    @Override // b3.a
    public boolean onRequestChildRectangleOnScreen(androidx.coordinatorlayout.widget.a aVar, View view, Rect rect, boolean z10) {
        g gVarFindFirstDependency = findFirstDependency((List<View>) aVar.v(view));
        if (gVarFindFirstDependency != null) {
            Rect rect2 = new Rect(rect);
            rect2.offset(view.getLeft(), view.getTop());
            Rect rect3 = this.tempRect1;
            rect3.set(0, 0, aVar.getWidth(), aVar.getHeight());
            if (!rect3.contains(rect2)) {
                gVarFindFirstDependency.h(false, !z10, true);
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.material.appbar.l
    public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z10) {
        super.setHorizontalOffsetEnabled(z10);
    }

    @Override // com.google.android.material.appbar.l
    public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i) {
        return super.setLeftAndRightOffset(i);
    }

    @Override // com.google.android.material.appbar.l
    public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i) {
        return super.setTopAndBottomOffset(i);
    }

    @Override // com.google.android.material.appbar.l
    public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z10) {
        super.setVerticalOffsetEnabled(z10);
    }

    public AppBarLayout$ScrollingViewBehavior() {
    }

    @Override // com.google.android.material.appbar.i
    public /* bridge */ /* synthetic */ View findFirstDependency(List list) {
        return findFirstDependency((List<View>) list);
    }
}
