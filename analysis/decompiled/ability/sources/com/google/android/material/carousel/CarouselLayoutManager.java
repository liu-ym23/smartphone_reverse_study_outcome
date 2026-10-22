package com.google.android.material.carousel;

import B7.a;
import U2.b;
import U2.c;
import U2.d;
import U2.e;
import U2.f;
import U2.i;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ability.R;

/* loaded from: classes3.dex */
public class CarouselLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {

    /* renamed from: a, reason: collision with root package name */
    public final i f2378a;
    public f b;
    public final View.OnLayoutChangeListener c;

    public CarouselLayoutManager() {
        i iVar = new i();
        new c();
        this.c = new View.OnLayoutChangeListener() { // from class: U2.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15) {
                if (i10 - i == i14 - i12 && i11 - i6 == i15 - i13) {
                    return;
                }
                view.post(new D6.b(this.f1266a, 8));
            }
        };
        this.f2378a = iVar;
        requestLayout();
        setOrientation(0);
    }

    public final float a(float f, float f7) {
        return c() ? f - f7 : f + f7;
    }

    public final boolean b() {
        return this.b.f1268a == 0;
    }

    public final boolean c() {
        return b() && getLayoutDirection() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollHorizontally() {
        return b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollVertically() {
        return !b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollExtent(RecyclerView.State state) {
        getChildCount();
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollOffset(RecyclerView.State state) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollRange(RecyclerView.State state) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public final PointF computeScrollVectorForPosition(int i) {
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollExtent(RecyclerView.State state) {
        getChildCount();
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollOffset(RecyclerView.State state) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollRange(RecyclerView.State state) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void getDecoratedBoundsWithMargins(View view, Rect rect) {
        super.getDecoratedBoundsWithMargins(view, rect);
        rect.centerY();
        if (b()) {
            rect.centerX();
        }
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void measureChildWithMargins(View view, int i, int i6) {
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAttachedToWindow(RecyclerView recyclerView) throws Resources.NotFoundException {
        super.onAttachedToWindow(recyclerView);
        Context context = recyclerView.getContext();
        i iVar = this.f2378a;
        float dimension = iVar.f1269a;
        if (dimension <= 0.0f) {
            dimension = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
        }
        iVar.f1269a = dimension;
        float dimension2 = iVar.b;
        if (dimension2 <= 0.0f) {
            dimension2 = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
        }
        iVar.b = dimension2;
        requestLayout();
        recyclerView.addOnLayoutChangeListener(this.c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        recyclerView.removeOnLayoutChangeListener(this.c);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003a  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View onFocusSearchFailed(android.view.View r4, int r5, androidx.recyclerview.widget.RecyclerView.Recycler r6, androidx.recyclerview.widget.RecyclerView.State r7) {
        /*
            r3 = this;
            int r6 = r3.getChildCount()
            if (r6 != 0) goto L8
            goto L8a
        L8:
            U2.f r6 = r3.b
            int r6 = r6.f1268a
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = -1
            r1 = 1
            if (r5 == r1) goto L3a
            r2 = 2
            if (r5 == r2) goto L30
            r2 = 17
            if (r5 == r2) goto L3f
            r2 = 33
            if (r5 == r2) goto L3c
            r2 = 66
            if (r5 == r2) goto L32
            r2 = 130(0x82, float:1.82E-43)
            if (r5 == r2) goto L2e
            java.lang.String r6 = "CarouselLayoutManager"
            java.lang.String r2 = "Unknown focus request:"
            androidx.constraintlayout.core.dsl.a.p(r5, r2, r6)
        L2c:
            r5 = r7
            goto L48
        L2e:
            if (r6 != r1) goto L2c
        L30:
            r5 = r1
            goto L48
        L32:
            if (r6 != 0) goto L2c
            boolean r5 = r3.c()
            if (r5 == 0) goto L30
        L3a:
            r5 = r0
            goto L48
        L3c:
            if (r6 != r1) goto L2c
            goto L3a
        L3f:
            if (r6 != 0) goto L2c
            boolean r5 = r3.c()
            if (r5 == 0) goto L3a
            goto L30
        L48:
            if (r5 != r7) goto L4b
            goto L8a
        L4b:
            r6 = 0
            if (r5 != r0) goto L7f
            int r4 = r3.getPosition(r4)
            if (r4 != 0) goto L55
            goto L8a
        L55:
            android.view.View r4 = r3.getChildAt(r6)
            int r4 = r3.getPosition(r4)
            int r4 = r4 - r1
            if (r4 < 0) goto L6e
            int r5 = r3.getItemCount()
            if (r4 < r5) goto L67
            goto L6e
        L67:
            U2.f r3 = r3.b
            r3.d()
            r3 = 0
            throw r3
        L6e:
            boolean r4 = r3.c()
            if (r4 == 0) goto L7a
            int r4 = r3.getChildCount()
            int r6 = r4 + (-1)
        L7a:
            android.view.View r3 = r3.getChildAt(r6)
            return r3
        L7f:
            int r4 = r3.getPosition(r4)
            int r5 = r3.getItemCount()
            int r5 = r5 - r1
            if (r4 != r5) goto L8c
        L8a:
            r3 = 0
            return r3
        L8c:
            int r4 = r3.getChildCount()
            int r4 = r4 - r1
            android.view.View r4 = r3.getChildAt(r4)
            int r4 = r3.getPosition(r4)
            int r4 = r4 + r1
            if (r4 < 0) goto Laa
            int r5 = r3.getItemCount()
            if (r4 < r5) goto La3
            goto Laa
        La3:
            U2.f r3 = r3.b
            r3.d()
            r3 = 0
            throw r3
        Laa:
            boolean r4 = r3.c()
            if (r4 == 0) goto Lb1
            goto Lb7
        Lb1:
            int r4 = r3.getChildCount()
            int r6 = r4 + (-1)
        Lb7:
            android.view.View r3 = r3.getChildAt(r6)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.CarouselLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(getPosition(getChildAt(0)));
            accessibilityEvent.setToIndex(getPosition(getChildAt(getChildCount() - 1)));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsAdded(RecyclerView recyclerView, int i, int i6) {
        super.onItemsAdded(recyclerView, i, i6);
        getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsChanged(RecyclerView recyclerView) {
        super.onItemsChanged(recyclerView);
        getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsRemoved(RecyclerView recyclerView, int i, int i6) {
        super.onItemsRemoved(recyclerView, i, i6);
        getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.getItemCount() > 0) {
            if ((b() ? getWidth() : getHeight()) > 0.0f) {
                c();
                measureChildWithMargins(recycler.getViewForPosition(0), 0, 0);
                throw null;
            }
        }
        removeAndRecycleAllViews(recycler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        if (getChildCount() == 0) {
            return;
        }
        getPosition(getChildAt(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!b() || getChildCount() == 0 || i == 0) {
            return 0;
        }
        measureChildWithMargins(recycler.getViewForPosition(0), 0, 0);
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void scrollToPosition(int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!canScrollVertically() || getChildCount() == 0 || i == 0) {
            return 0;
        }
        measureChildWithMargins(recycler.getViewForPosition(0), 0, 0);
        throw null;
    }

    public final void setOrientation(int i) {
        f eVar;
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException(a.h(i, "invalid orientation:"));
        }
        assertNotInLayoutOrScroll(null);
        f fVar = this.b;
        if (fVar == null || i != fVar.f1268a) {
            if (i == 0) {
                eVar = new e(this);
            } else {
                if (i != 1) {
                    throw new IllegalArgumentException("invalid orientation");
                }
                eVar = new d(this);
            }
            this.b = eVar;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        b bVar = new b(recyclerView.getContext());
        bVar.setTargetPosition(i);
        startSmoothScroll(bVar);
    }

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i, int i6) {
        new c();
        this.c = new View.OnLayoutChangeListener() { // from class: U2.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i62, int i102, int i11, int i12, int i13, int i14, int i15) {
                if (i102 - i10 == i14 - i12 && i11 - i62 == i15 - i13) {
                    return;
                }
                view.post(new D6.b(this.f1266a, 8));
            }
        };
        this.f2378a = new i();
        requestLayout();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, P2.a.d);
            typedArrayObtainStyledAttributes.getInt(0, 0);
            requestLayout();
            setOrientation(typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_orientation, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
