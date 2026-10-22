package com.google.android.material.appbar;

import K.S;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.stepos.alphame.utils.Property;
import java.util.List;
import java.util.WeakHashMap;
import m1.AbstractC0769a;

/* loaded from: classes.dex */
public class AppBarLayout$ScrollingViewBehavior extends j {
    public AppBarLayout$ScrollingViewBehavior() {
    }

    @Override // com.google.android.material.appbar.j
    @Nullable
    public /* bridge */ /* synthetic */ View findFirstDependency(@NonNull List list) {
        return findFirstDependency((List<View>) list);
    }

    @Override // com.google.android.material.appbar.m
    public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
        return super.getLeftAndRightOffset();
    }

    @Override // com.google.android.material.appbar.j
    public float getOverlapRatioForOffset(View view) {
        int i4;
        if (view instanceof h) {
            h hVar = (h) view;
            int totalScrollRange = hVar.getTotalScrollRange();
            int downNestedPreScrollRange = hVar.getDownNestedPreScrollRange();
            A.b bVar = ((A.d) hVar.getLayoutParams()).f5a;
            int iC = bVar instanceof AppBarLayout$BaseBehavior ? ((AppBarLayout$BaseBehavior) bVar).c() : 0;
            if ((downNestedPreScrollRange == 0 || totalScrollRange + iC > downNestedPreScrollRange) && (i4 = totalScrollRange - downNestedPreScrollRange) != 0) {
                return (iC / i4) + 1.0f;
            }
        }
        return Property.DEFAULT_FLOAT_VALUE;
    }

    @Override // com.google.android.material.appbar.j
    public int getScrollRange(View view) {
        return view instanceof h ? ((h) view).getTotalScrollRange() : view.getMeasuredHeight();
    }

    @Override // com.google.android.material.appbar.m
    public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
        return super.getTopAndBottomOffset();
    }

    @Override // com.google.android.material.appbar.m
    public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
        return super.isHorizontalOffsetEnabled();
    }

    @Override // com.google.android.material.appbar.m
    public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
        return super.isVerticalOffsetEnabled();
    }

    @Override // A.b
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof h;
    }

    @Override // A.b
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        A.b bVar = ((A.d) view2.getLayoutParams()).f5a;
        if (bVar instanceof AppBarLayout$BaseBehavior) {
            int verticalLayoutGap = (getVerticalLayoutGap() + ((view2.getBottom() - view.getTop()) + ((AppBarLayout$BaseBehavior) bVar).f10259h)) - getOverlapPixelsForOffset(view2);
            WeakHashMap weakHashMap = S.f939a;
            view.offsetTopAndBottom(verticalLayoutGap);
        }
        if (!(view2 instanceof h)) {
            return false;
        }
        h hVar = (h) view2;
        if (!hVar.f10306l) {
            return false;
        }
        hVar.i(hVar.j(view));
        return false;
    }

    @Override // A.b
    public void onDependentViewRemoved(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
        if (view2 instanceof h) {
            S.h(coordinatorLayout, null);
        }
    }

    @Override // com.google.android.material.appbar.m, A.b
    public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i4) {
        super.onLayoutChild(coordinatorLayout, view, i4);
        return true;
    }

    @Override // A.b
    public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect, boolean z4) {
        h hVarFindFirstDependency = findFirstDependency((List<View>) coordinatorLayout.v(view));
        if (hVarFindFirstDependency != null) {
            Rect rect2 = new Rect(rect);
            rect2.offset(view.getLeft(), view.getTop());
            Rect rect3 = this.tempRect1;
            rect3.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
            if (!rect3.contains(rect2)) {
                hVarFindFirstDependency.h(false, !z4, true);
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.material.appbar.m
    public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean z4) {
        super.setHorizontalOffsetEnabled(z4);
    }

    @Override // com.google.android.material.appbar.m
    public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i4) {
        return super.setLeftAndRightOffset(i4);
    }

    @Override // com.google.android.material.appbar.m
    public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i4) {
        return super.setTopAndBottomOffset(i4);
    }

    @Override // com.google.android.material.appbar.m
    public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean z4) {
        super.setVerticalOffsetEnabled(z4);
    }

    public AppBarLayout$ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0769a.f13527B);
        setOverlayTop(typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // com.google.android.material.appbar.j
    @Nullable
    public h findFirstDependency(@NonNull List<View> list) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            View view = list.get(i4);
            if (view instanceof h) {
                return (h) view;
            }
        }
        return null;
    }
}
