package com.google.android.material.carousel;

import B0.e;
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
import androidx.room.AbstractC0351g;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import java.util.List;
import m1.AbstractC0769a;
import n1.AbstractC0775a;
import q1.ViewOnLayoutChangeListenerC0825a;
import q1.b;
import q1.c;
import q1.d;
import q1.f;
import q1.g;
import q1.h;
import q1.i;

/* loaded from: classes.dex */
public class CarouselLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {

    /* renamed from: a, reason: collision with root package name */
    public final g f10541a;

    /* renamed from: b, reason: collision with root package name */
    public f f10542b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewOnLayoutChangeListenerC0825a f10543c;

    /* JADX WARN: Type inference failed for: r1v1, types: [q1.a] */
    public CarouselLayoutManager() {
        i iVar = new i();
        new c();
        final int i4 = 1;
        this.f10543c = new View.OnLayoutChangeListener() { // from class: q1.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
                int i13 = i4;
                int i14 = 12;
                CarouselLayoutManager carouselLayoutManager = this;
                carouselLayoutManager.getClass();
                switch (i13) {
                    case 0:
                        if (i7 - i5 != i11 - i9 || i8 - i6 != i12 - i10) {
                            view.post(new androidx.activity.d(i14, carouselLayoutManager));
                            break;
                        }
                        break;
                    default:
                        if (i7 - i5 != i11 - i9 || i8 - i6 != i12 - i10) {
                            view.post(new androidx.activity.d(i14, carouselLayoutManager));
                            break;
                        }
                        break;
                }
            }
        };
        this.f10541a = iVar;
        requestLayout();
        setOrientation(0);
    }

    public static float e(float f4, e eVar) {
        h hVar = (h) eVar.f142b;
        hVar.getClass();
        h hVar2 = (h) eVar.f143c;
        hVar2.getClass();
        hVar.getClass();
        hVar2.getClass();
        return AbstractC0775a.b(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, f4);
    }

    public static e f(float f4, List list, boolean z4) {
        float f5 = Float.MAX_VALUE;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        float f6 = -3.4028235E38f;
        float f7 = Float.MAX_VALUE;
        float f8 = Float.MAX_VALUE;
        for (int i8 = 0; i8 < list.size(); i8++) {
            ((h) list.get(i8)).getClass();
            float fAbs = Math.abs(Property.DEFAULT_FLOAT_VALUE - f4);
            if (Property.DEFAULT_FLOAT_VALUE <= f4 && fAbs <= f5) {
                i4 = i8;
                f5 = fAbs;
            }
            if (Property.DEFAULT_FLOAT_VALUE > f4 && fAbs <= f7) {
                i6 = i8;
                f7 = fAbs;
            }
            if (Property.DEFAULT_FLOAT_VALUE <= f8) {
                f8 = 0.0f;
                i5 = i8;
            }
            if (Property.DEFAULT_FLOAT_VALUE > f6) {
                f6 = 0.0f;
                i7 = i8;
            }
        }
        if (i4 == -1) {
            i4 = i5;
        }
        if (i6 == -1) {
            i6 = i7;
        }
        return new e((h) list.get(i4), (h) list.get(i6));
    }

    public final float b(float f4, float f5) {
        return h() ? f4 - f5 : f4 + f5;
    }

    public final float c(int i4) {
        this.f10542b.d();
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollHorizontally() {
        return g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollVertically() {
        return !g();
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
    public final PointF computeScrollVectorForPosition(int i4) {
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

    public final int d() {
        return g() ? getWidth() : getHeight();
    }

    public final boolean g() {
        return this.f10542b.f13993a == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void getDecoratedBoundsWithMargins(View view, Rect rect) {
        super.getDecoratedBoundsWithMargins(view, rect);
        rect.centerY();
        if (g()) {
            rect.centerX();
        }
        throw null;
    }

    public final boolean h() {
        return g() && getLayoutDirection() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void measureChildWithMargins(View view, int i4, int i5) {
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAttachedToWindow(RecyclerView recyclerView) throws Resources.NotFoundException {
        super.onAttachedToWindow(recyclerView);
        g gVar = this.f10541a;
        Context context = recyclerView.getContext();
        float dimension = gVar.f13994a;
        if (dimension <= Property.DEFAULT_FLOAT_VALUE) {
            dimension = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
        }
        gVar.f13994a = dimension;
        float dimension2 = gVar.f13995b;
        if (dimension2 <= Property.DEFAULT_FLOAT_VALUE) {
            dimension2 = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
        }
        gVar.f13995b = dimension2;
        requestLayout();
        recyclerView.addOnLayoutChangeListener(this.f10543c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        recyclerView.removeOnLayoutChangeListener(this.f10543c);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0047  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View onFocusSearchFailed(android.view.View r6, int r7, androidx.recyclerview.widget.RecyclerView.Recycler r8, androidx.recyclerview.widget.RecyclerView.State r9) {
        /*
            r5 = this;
            int r9 = r5.getChildCount()
            r0 = 0
            if (r9 != 0) goto L8
            return r0
        L8:
            q1.f r9 = r5.f10542b
            int r9 = r9.f13993a
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = -1
            r3 = 1
            if (r7 == r3) goto L47
            r4 = 2
            if (r7 == r4) goto L45
            r4 = 17
            if (r7 == r4) goto L3d
            r4 = 33
            if (r7 == r4) goto L3a
            r4 = 66
            if (r7 == r4) goto L31
            r4 = 130(0x82, float:1.82E-43)
            if (r7 == r4) goto L2e
            java.lang.String r9 = "Unknown focus request:"
            java.lang.String r4 = "CarouselLayoutManager"
            B0.g.z(r9, r7, r4)
        L2c:
            r7 = r1
            goto L48
        L2e:
            if (r9 != r3) goto L2c
            goto L45
        L31:
            if (r9 != 0) goto L2c
            boolean r7 = r5.h()
            if (r7 == 0) goto L45
            goto L47
        L3a:
            if (r9 != r3) goto L2c
            goto L47
        L3d:
            if (r9 != 0) goto L2c
            boolean r7 = r5.h()
            if (r7 == 0) goto L47
        L45:
            r7 = r3
            goto L48
        L47:
            r7 = r2
        L48:
            if (r7 != r1) goto L4b
            return r0
        L4b:
            r9 = 0
            if (r7 != r2) goto L83
            int r6 = r5.getPosition(r6)
            if (r6 != 0) goto L55
            return r0
        L55:
            android.view.View r6 = r5.getChildAt(r9)
            int r6 = r5.getPosition(r6)
            int r6 = r6 - r3
            if (r6 < 0) goto L72
            int r7 = r5.getItemCount()
            if (r6 < r7) goto L67
            goto L72
        L67:
            r5.c(r6)
            android.view.View r6 = r8.getViewForPosition(r6)
            r5.measureChildWithMargins(r6, r9, r9)
            throw r0
        L72:
            boolean r6 = r5.h()
            if (r6 == 0) goto L7e
            int r6 = r5.getChildCount()
            int r9 = r6 + (-1)
        L7e:
            android.view.View r5 = r5.getChildAt(r9)
            goto Lc2
        L83:
            int r6 = r5.getPosition(r6)
            int r7 = r5.getItemCount()
            int r7 = r7 - r3
            if (r6 != r7) goto L8f
            return r0
        L8f:
            int r6 = r5.getChildCount()
            int r6 = r6 - r3
            android.view.View r6 = r5.getChildAt(r6)
            int r6 = r5.getPosition(r6)
            int r6 = r6 + r3
            if (r6 < 0) goto Lb1
            int r7 = r5.getItemCount()
            if (r6 < r7) goto La6
            goto Lb1
        La6:
            r5.c(r6)
            android.view.View r6 = r8.getViewForPosition(r6)
            r5.measureChildWithMargins(r6, r9, r9)
            throw r0
        Lb1:
            boolean r6 = r5.h()
            if (r6 == 0) goto Lb8
            goto Lbe
        Lb8:
            int r6 = r5.getChildCount()
            int r9 = r6 + (-1)
        Lbe:
            android.view.View r5 = r5.getChildAt(r9)
        Lc2:
            return r5
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
    public final void onItemsAdded(RecyclerView recyclerView, int i4, int i5) {
        super.onItemsAdded(recyclerView, i4, i5);
        a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsChanged(RecyclerView recyclerView) {
        super.onItemsChanged(recyclerView);
        a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsRemoved(RecyclerView recyclerView, int i4, int i5) {
        super.onItemsRemoved(recyclerView, i4, i5);
        a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.getItemCount() <= 0 || d() <= Property.DEFAULT_FLOAT_VALUE) {
            removeAndRecycleAllViews(recycler);
        } else {
            h();
            measureChildWithMargins(recycler.getViewForPosition(0), 0, 0);
            throw null;
        }
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
    public final boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z4, boolean z5) {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int i4, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!g() || getChildCount() == 0 || i4 == 0) {
            return 0;
        }
        measureChildWithMargins(recycler.getViewForPosition(0), 0, 0);
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void scrollToPosition(int i4) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int i4, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!canScrollVertically() || getChildCount() == 0 || i4 == 0) {
            return 0;
        }
        measureChildWithMargins(recycler.getViewForPosition(0), 0, 0);
        throw null;
    }

    public final void setOrientation(int i4) {
        f eVar;
        if (i4 != 0 && i4 != 1) {
            throw new IllegalArgumentException(AbstractC0351g.m("invalid orientation:", i4));
        }
        assertNotInLayoutOrScroll(null);
        f fVar = this.f10542b;
        if (fVar == null || i4 != fVar.f13993a) {
            if (i4 == 0) {
                eVar = new q1.e(this);
            } else {
                if (i4 != 1) {
                    throw new IllegalArgumentException("invalid orientation");
                }
                eVar = new d(this);
            }
            this.f10542b = eVar;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i4) {
        b bVar = new b(this, recyclerView.getContext());
        bVar.setTargetPosition(i4);
        startSmoothScroll(bVar);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [q1.a] */
    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i4, int i5) {
        new c();
        final int i6 = 0;
        this.f10543c = new View.OnLayoutChangeListener() { // from class: q1.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i52, int i62, int i7, int i8, int i9, int i10, int i11, int i12) {
                int i13 = i6;
                int i14 = 12;
                CarouselLayoutManager carouselLayoutManager = this;
                carouselLayoutManager.getClass();
                switch (i13) {
                    case 0:
                        if (i7 - i52 != i11 - i9 || i8 - i62 != i12 - i10) {
                            view.post(new androidx.activity.d(i14, carouselLayoutManager));
                            break;
                        }
                        break;
                    default:
                        if (i7 - i52 != i11 - i9 || i8 - i62 != i12 - i10) {
                            view.post(new androidx.activity.d(i14, carouselLayoutManager));
                            break;
                        }
                        break;
                }
            }
        };
        this.f10541a = new i();
        requestLayout();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0769a.f13538d);
            typedArrayObtainStyledAttributes.getInt(0, 0);
            requestLayout();
            setOrientation(typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_orientation, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
