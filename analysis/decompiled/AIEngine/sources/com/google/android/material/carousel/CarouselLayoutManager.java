package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.widget.z0;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.b;
import com.stepos.aiengine.R;
import h0.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import mb.y;
import n4.d;
import n4.f;
import n4.h;
import n4.i;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class CarouselLayoutManager extends RecyclerView.LayoutManager implements n4.b, RecyclerView.SmoothScroller.ScrollVectorProvider {

    /* renamed from: a, reason: collision with root package name */
    public int f4795a;

    /* renamed from: b, reason: collision with root package name */
    public int f4796b;

    /* renamed from: c, reason: collision with root package name */
    public int f4797c;

    /* renamed from: d, reason: collision with root package name */
    public final b f4798d;

    /* renamed from: e, reason: collision with root package name */
    public final i f4799e;

    /* renamed from: f, reason: collision with root package name */
    public com.google.android.material.carousel.c f4800f;

    /* renamed from: g, reason: collision with root package name */
    public com.google.android.material.carousel.b f4801g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public HashMap f4802i;

    /* renamed from: j, reason: collision with root package name */
    public f f4803j;

    /* renamed from: k, reason: collision with root package name */
    public final View.OnLayoutChangeListener f4804k;

    /* renamed from: l, reason: collision with root package name */
    public int f4805l;

    /* renamed from: m, reason: collision with root package name */
    public int f4806m;

    /* renamed from: n, reason: collision with root package name */
    public final int f4807n;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends LinearSmoothScroller {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final int calculateDxToMakeVisible(View view, int i10) {
            CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
            if (carouselLayoutManager.f4800f == null || !carouselLayoutManager.m()) {
                return 0;
            }
            int position = carouselLayoutManager.getPosition(view);
            return (int) (carouselLayoutManager.f4795a - carouselLayoutManager.j(position, carouselLayoutManager.i(position)));
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final int calculateDyToMakeVisible(View view, int i10) {
            CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
            if (carouselLayoutManager.f4800f == null || carouselLayoutManager.m()) {
                return 0;
            }
            int position = carouselLayoutManager.getPosition(view);
            return (int) (carouselLayoutManager.f4795a - carouselLayoutManager.j(position, carouselLayoutManager.i(position)));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public final PointF computeScrollVectorForPosition(int i10) {
            return CarouselLayoutManager.this.computeScrollVectorForPosition(i10);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b extends RecyclerView.ItemDecoration {

        /* renamed from: a, reason: collision with root package name */
        public final Paint f4809a;

        /* renamed from: b, reason: collision with root package name */
        public List<b.C0035b> f4810b;

        public b() {
            Paint paint = new Paint();
            this.f4809a = paint;
            this.f4810b = Collections.unmodifiableList(new ArrayList());
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) throws Resources.NotFoundException {
            Canvas canvas2;
            super.onDrawOver(canvas, recyclerView, state);
            float dimension = recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width);
            Paint paint = this.f4809a;
            paint.setStrokeWidth(dimension);
            for (b.C0035b c0035b : this.f4810b) {
                float f8 = c0035b.f4829c;
                ThreadLocal<double[]> threadLocal = n0.a.f10586a;
                float f9 = 1.0f - f8;
                paint.setColor(Color.argb((int) ((Color.alpha(-16776961) * f8) + (Color.alpha(-65281) * f9)), (int) ((Color.red(-16776961) * f8) + (Color.red(-65281) * f9)), (int) ((Color.green(-16776961) * f8) + (Color.green(-65281) * f9)), (int) ((Color.blue(-16776961) * f8) + (Color.blue(-65281) * f9))));
                if (((CarouselLayoutManager) recyclerView.getLayoutManager()).m()) {
                    canvas2 = canvas;
                    canvas2.drawLine(c0035b.f4828b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).f4803j.g(), c0035b.f4828b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).f4803j.c(), paint);
                } else {
                    canvas2 = canvas;
                    canvas2.drawLine(((CarouselLayoutManager) recyclerView.getLayoutManager()).f4803j.d(), c0035b.f4828b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).f4803j.e(), c0035b.f4828b, paint);
                }
                canvas = canvas2;
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final b.C0035b f4811a;

        /* renamed from: b, reason: collision with root package name */
        public final b.C0035b f4812b;

        public c(b.C0035b c0035b, b.C0035b c0035b2) {
            if (c0035b.f4827a > c0035b2.f4827a) {
                throw new IllegalArgumentException();
            }
            this.f4811a = c0035b;
            this.f4812b = c0035b2;
        }
    }

    public CarouselLayoutManager() {
        i iVar = new i();
        this.f4798d = new b();
        this.h = 0;
        this.f4804k = new View.OnLayoutChangeListener() { // from class: n4.c
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                if (i12 - i10 == i16 - i14 && i13 - i11 == i17 - i15) {
                    return;
                }
                view.post(new z0(this.f10627a, 19));
            }
        };
        this.f4806m = -1;
        this.f4807n = 0;
        this.f4799e = iVar;
        r();
        setOrientation(0);
    }

    public static c l(List<b.C0035b> list, float f8, boolean z) {
        float f9 = Float.MAX_VALUE;
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        float f10 = -3.4028235E38f;
        float f11 = Float.MAX_VALUE;
        float f12 = Float.MAX_VALUE;
        for (int i14 = 0; i14 < list.size(); i14++) {
            b.C0035b c0035b = list.get(i14);
            float f13 = z ? c0035b.f4828b : c0035b.f4827a;
            float fAbs = Math.abs(f13 - f8);
            if (f13 <= f8 && fAbs <= f9) {
                i10 = i14;
                f9 = fAbs;
            }
            if (f13 > f8 && fAbs <= f11) {
                i12 = i14;
                f11 = fAbs;
            }
            if (f13 <= f12) {
                i11 = i14;
                f12 = f13;
            }
            if (f13 > f10) {
                i13 = i14;
                f10 = f13;
            }
        }
        if (i10 == -1) {
            i10 = i11;
        }
        if (i12 == -1) {
            i12 = i13;
        }
        return new c(list.get(i10), list.get(i12));
    }

    public final float a(float f8, float f9) {
        return n() ? f8 - f9 : f8 + f9;
    }

    public final void b(RecyclerView.Recycler recycler, int i10, int i11) {
        if (i10 < 0 || i10 >= getItemCount()) {
            return;
        }
        float f8 = f(i10);
        View viewForPosition = recycler.getViewForPosition(i10);
        measureChildWithMargins(viewForPosition, 0, 0);
        float fA = a(f8, this.f4801g.f4813a / 2.0f);
        c cVarL = l(this.f4801g.f4815c, fA, false);
        float fE = e(fA, cVarL);
        float f9 = this.f4801g.f4813a / 2.0f;
        addView(viewForPosition, i11);
        measureChildWithMargins(viewForPosition, 0, 0);
        this.f4803j.h(viewForPosition, (int) (fE - f9), (int) (fE + f9));
        t(viewForPosition, fA, cVarL);
    }

    public final void c(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        float f8 = f(i10);
        while (i10 < state.getItemCount()) {
            float fA = a(f8, this.f4801g.f4813a / 2.0f);
            c cVarL = l(this.f4801g.f4815c, fA, false);
            float fE = e(fA, cVarL);
            if (o(fE, cVarL)) {
                return;
            }
            f8 = a(f8, this.f4801g.f4813a);
            if (!p(fE, cVarL)) {
                View viewForPosition = recycler.getViewForPosition(i10);
                float f9 = this.f4801g.f4813a / 2.0f;
                addView(viewForPosition, -1);
                measureChildWithMargins(viewForPosition, 0, 0);
                this.f4803j.h(viewForPosition, (int) (fE - f9), (int) (fE + f9));
                t(viewForPosition, fA, cVarL);
            }
            i10++;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollHorizontally() {
        return m();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollVertically() {
        return !m();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0 || this.f4800f == null || getItemCount() <= 1) {
            return 0;
        }
        return (int) (getWidth() * (this.f4800f.f4834a.f4813a / computeHorizontalScrollRange(state)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollOffset(RecyclerView.State state) {
        return this.f4795a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollRange(RecyclerView.State state) {
        return this.f4797c - this.f4796b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public final PointF computeScrollVectorForPosition(int i10) {
        if (this.f4800f == null) {
            return null;
        }
        int iJ = j(i10, i(i10)) - this.f4795a;
        return m() ? new PointF(iJ, 0.0f) : new PointF(0.0f, iJ);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0 || this.f4800f == null || getItemCount() <= 1) {
            return 0;
        }
        return (int) (getHeight() * (this.f4800f.f4834a.f4813a / computeVerticalScrollRange(state)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollOffset(RecyclerView.State state) {
        return this.f4795a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollRange(RecyclerView.State state) {
        return this.f4797c - this.f4796b;
    }

    public final void d(RecyclerView.Recycler recycler, int i10) {
        float f8 = f(i10);
        while (i10 >= 0) {
            float fA = a(f8, this.f4801g.f4813a / 2.0f);
            c cVarL = l(this.f4801g.f4815c, fA, false);
            float fE = e(fA, cVarL);
            if (p(fE, cVarL)) {
                return;
            }
            float f9 = this.f4801g.f4813a;
            f8 = n() ? f8 + f9 : f8 - f9;
            if (!o(fE, cVarL)) {
                View viewForPosition = recycler.getViewForPosition(i10);
                float f10 = this.f4801g.f4813a / 2.0f;
                addView(viewForPosition, 0);
                measureChildWithMargins(viewForPosition, 0, 0);
                this.f4803j.h(viewForPosition, (int) (fE - f10), (int) (fE + f10));
                t(viewForPosition, fA, cVarL);
            }
            i10--;
        }
    }

    public final float e(float f8, c cVar) {
        b.C0035b c0035b = cVar.f4811a;
        float f9 = c0035b.f4828b;
        b.C0035b c0035b2 = cVar.f4812b;
        float f10 = c0035b2.f4828b;
        float f11 = c0035b.f4827a;
        float f12 = c0035b2.f4827a;
        float fB = l4.a.b(f9, f10, f11, f12, f8);
        if (c0035b2 != this.f4801g.b() && c0035b != this.f4801g.d()) {
            return fB;
        }
        return e.a(1.0f, c0035b2.f4829c, f8 - f12, fB);
    }

    public final float f(int i10) {
        return a(this.f4803j.f() - this.f4795a, this.f4801g.f4813a * i10);
    }

    public final void g(RecyclerView.Recycler recycler, RecyclerView.State state) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            Rect rect = new Rect();
            super.getDecoratedBoundsWithMargins(childAt, rect);
            float fCenterX = m() ? rect.centerX() : rect.centerY();
            if (!p(fCenterX, l(this.f4801g.f4815c, fCenterX, true))) {
                break;
            } else {
                removeAndRecycleView(childAt, recycler);
            }
        }
        while (getChildCount() - 1 >= 0) {
            View childAt2 = getChildAt(getChildCount() - 1);
            Rect rect2 = new Rect();
            super.getDecoratedBoundsWithMargins(childAt2, rect2);
            float fCenterX2 = m() ? rect2.centerX() : rect2.centerY();
            if (!o(fCenterX2, l(this.f4801g.f4815c, fCenterX2, true))) {
                break;
            } else {
                removeAndRecycleView(childAt2, recycler);
            }
        }
        if (getChildCount() == 0) {
            d(recycler, this.h - 1);
            c(this.h, recycler, state);
        } else {
            int position = getPosition(getChildAt(0));
            int position2 = getPosition(getChildAt(getChildCount() - 1));
            d(recycler, position - 1);
            c(position2 + 1, recycler, state);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void getDecoratedBoundsWithMargins(View view, Rect rect) {
        super.getDecoratedBoundsWithMargins(view, rect);
        float fCenterY = rect.centerY();
        if (m()) {
            fCenterY = rect.centerX();
        }
        c cVarL = l(this.f4801g.f4815c, fCenterY, true);
        b.C0035b c0035b = cVarL.f4811a;
        float f8 = c0035b.f4830d;
        b.C0035b c0035b2 = cVarL.f4812b;
        float fB = l4.a.b(f8, c0035b2.f4830d, c0035b.f4828b, c0035b2.f4828b, fCenterY);
        float fWidth = m() ? (rect.width() - fB) / 2.0f : 0.0f;
        float fHeight = m() ? 0.0f : (rect.height() - fB) / 2.0f;
        rect.set((int) (rect.left + fWidth), (int) (rect.top + fHeight), (int) (rect.right - fWidth), (int) (rect.bottom - fHeight));
    }

    public final int h() {
        return m() ? getWidth() : getHeight();
    }

    public final com.google.android.material.carousel.b i(int i10) {
        com.google.android.material.carousel.b bVar;
        HashMap map = this.f4802i;
        return (map == null || (bVar = (com.google.android.material.carousel.b) map.get(Integer.valueOf(y.p(i10, 0, Math.max(0, getItemCount() + (-1)))))) == null) ? this.f4800f.f4834a : bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean isAutoMeasureEnabled() {
        return true;
    }

    public final int j(int i10, com.google.android.material.carousel.b bVar) {
        if (!n()) {
            return (int) ((bVar.f4813a / 2.0f) + ((i10 * bVar.f4813a) - bVar.a().f4827a));
        }
        float fH = h() - bVar.c().f4827a;
        float f8 = bVar.f4813a;
        return (int) ((fH - (i10 * f8)) - (f8 / 2.0f));
    }

    public final int k(int i10, com.google.android.material.carousel.b bVar) {
        int i11 = Integer.MAX_VALUE;
        for (b.C0035b c0035b : bVar.f4815c.subList(bVar.f4816d, bVar.f4817e + 1)) {
            float f8 = bVar.f4813a;
            float f9 = (f8 / 2.0f) + (i10 * f8);
            int iH = (n() ? (int) ((h() - c0035b.f4827a) - f9) : (int) (f9 - c0035b.f4827a)) - this.f4795a;
            if (Math.abs(i11) > Math.abs(iH)) {
                i11 = iH;
            }
        }
        return i11;
    }

    public final boolean m() {
        return this.f4803j.f10630a == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void measureChildWithMargins(View view, int i10, int i11) {
        if (!(view instanceof h)) {
            throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        Rect rect = new Rect();
        calculateItemDecorationsForChild(view, rect);
        int i12 = rect.left + rect.right + i10;
        int i13 = rect.top + rect.bottom + i11;
        com.google.android.material.carousel.c cVar = this.f4800f;
        view.measure(RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i12, (int) ((cVar == null || this.f4803j.f10630a != 0) ? ((ViewGroup.MarginLayoutParams) layoutParams).width : cVar.f4834a.f4813a), m()), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i13, (int) ((cVar == null || this.f4803j.f10630a != 1) ? ((ViewGroup.MarginLayoutParams) layoutParams).height : cVar.f4834a.f4813a), canScrollVertically()));
    }

    public final boolean n() {
        return m() && getLayoutDirection() == 1;
    }

    public final boolean o(float f8, c cVar) {
        b.C0035b c0035b = cVar.f4811a;
        float f9 = c0035b.f4830d;
        b.C0035b c0035b2 = cVar.f4812b;
        float fB = l4.a.b(f9, c0035b2.f4830d, c0035b.f4828b, c0035b2.f4828b, f8) / 2.0f;
        float f10 = n() ? f8 + fB : f8 - fB;
        return n() ? f10 < 0.0f : f10 > ((float) h());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAttachedToWindow(RecyclerView recyclerView) throws Resources.NotFoundException {
        super.onAttachedToWindow(recyclerView);
        Context context = recyclerView.getContext();
        i iVar = this.f4799e;
        float dimension = iVar.f10631a;
        if (dimension <= 0.0f) {
            dimension = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
        }
        iVar.f10631a = dimension;
        float dimension2 = iVar.f10632b;
        if (dimension2 <= 0.0f) {
            dimension2 = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
        }
        iVar.f10632b = dimension2;
        r();
        recyclerView.addOnLayoutChangeListener(this.f4804k);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        recyclerView.removeOnLayoutChangeListener(this.f4804k);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View onFocusSearchFailed(android.view.View r5, int r6, androidx.recyclerview.widget.RecyclerView.Recycler r7, androidx.recyclerview.widget.RecyclerView.State r8) {
        /*
            r4 = this;
            int r8 = r4.getChildCount()
            if (r8 != 0) goto L8
            goto L89
        L8:
            n4.f r8 = r4.f4803j
            int r8 = r8.f10630a
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = -1
            r2 = 1
            if (r6 == r2) goto L46
            r3 = 2
            if (r6 == r3) goto L3c
            r3 = 17
            if (r6 == r3) goto L4b
            r3 = 33
            if (r6 == r3) goto L48
            r3 = 66
            if (r6 == r3) goto L3e
            r3 = 130(0x82, float:1.82E-43)
            if (r6 == r3) goto L3a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r3 = "Unknown focus request:"
            r8.<init>(r3)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            java.lang.String r8 = "CarouselLayoutManager"
            android.util.Log.d(r8, r6)
        L38:
            r6 = r0
            goto L54
        L3a:
            if (r8 != r2) goto L38
        L3c:
            r6 = r2
            goto L54
        L3e:
            if (r8 != 0) goto L38
            boolean r6 = r4.n()
            if (r6 == 0) goto L3c
        L46:
            r6 = r1
            goto L54
        L48:
            if (r8 != r2) goto L38
            goto L46
        L4b:
            if (r8 != 0) goto L38
            boolean r6 = r4.n()
            if (r6 == 0) goto L46
            goto L3c
        L54:
            if (r6 != r0) goto L57
            goto L89
        L57:
            r8 = 0
            if (r6 != r1) goto L7e
            int r5 = r4.getPosition(r5)
            if (r5 != 0) goto L61
            goto L89
        L61:
            android.view.View r5 = r4.getChildAt(r8)
            int r5 = r4.getPosition(r5)
            int r5 = r5 - r2
            r4.b(r7, r5, r8)
            boolean r5 = r4.n()
            if (r5 == 0) goto L79
            int r5 = r4.getChildCount()
            int r8 = r5 + (-1)
        L79:
            android.view.View r4 = r4.getChildAt(r8)
            return r4
        L7e:
            int r5 = r4.getPosition(r5)
            int r6 = r4.getItemCount()
            int r6 = r6 - r2
            if (r5 != r6) goto L8b
        L89:
            r4 = 0
            return r4
        L8b:
            int r5 = r4.getChildCount()
            int r5 = r5 - r2
            android.view.View r5 = r4.getChildAt(r5)
            int r5 = r4.getPosition(r5)
            int r5 = r5 + r2
            r4.b(r7, r5, r1)
            boolean r5 = r4.n()
            if (r5 == 0) goto La3
            goto La9
        La3:
            int r5 = r4.getChildCount()
            int r8 = r5 + (-1)
        La9:
            android.view.View r4 = r4.getChildAt(r8)
            return r4
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
    public final void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        super.onItemsAdded(recyclerView, i10, i11);
        v();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsChanged(RecyclerView recyclerView) {
        super.onItemsChanged(recyclerView);
        v();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        super.onItemsRemoved(recyclerView, i10, i11);
        v();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.getItemCount() <= 0 || h() <= 0.0f) {
            removeAndRecycleAllViews(recycler);
            this.h = 0;
            return;
        }
        boolean zN = n();
        com.google.android.material.carousel.c cVar = this.f4800f;
        int i10 = 1;
        boolean z = cVar == null;
        if (z || cVar.f4834a.f4818f != h()) {
            q(recycler);
        }
        com.google.android.material.carousel.c cVar2 = this.f4800f;
        boolean zN2 = n();
        com.google.android.material.carousel.b bVarA = zN2 ? cVar2.a() : cVar2.c();
        float f8 = (zN2 ? bVarA.c() : bVarA.a()).f4827a;
        float f9 = bVarA.f4813a / 2.0f;
        int iF = (int) (this.f4803j.f() - (n() ? f8 + f9 : f8 - f9));
        com.google.android.material.carousel.c cVar3 = this.f4800f;
        boolean zN3 = n();
        com.google.android.material.carousel.b bVarC = zN3 ? cVar3.c() : cVar3.a();
        b.C0035b c0035bA = zN3 ? bVarC.a() : bVarC.c();
        int itemCount = (int) ((((zN3 ? -1 : 1) * c0035bA.f4830d) / 2.0f) + ((((state.getItemCount() - 1) * bVarC.f4813a) * (zN3 ? -1.0f : 1.0f)) - (c0035bA.f4827a - this.f4803j.f())));
        int iMin = zN3 ? Math.min(0, itemCount) : Math.max(0, itemCount);
        this.f4796b = zN ? iMin : iF;
        if (zN) {
            iMin = iF;
        }
        this.f4797c = iMin;
        if (z) {
            this.f4795a = iF;
            com.google.android.material.carousel.c cVar4 = this.f4800f;
            int itemCount2 = getItemCount();
            int i11 = this.f4796b;
            int i12 = this.f4797c;
            boolean zN4 = n();
            List<com.google.android.material.carousel.b> list = cVar4.f4835b;
            List<com.google.android.material.carousel.b> list2 = cVar4.f4836c;
            float f10 = cVar4.f4834a.f4813a;
            HashMap map = new HashMap();
            int i13 = 0;
            int i14 = 0;
            while (i13 < itemCount2) {
                int i15 = zN4 ? (itemCount2 - i13) - i10 : i13;
                int i16 = i10;
                if (i15 * f10 * (zN4 ? -1 : i16) > i12 - cVar4.f4840g || i13 >= itemCount2 - list2.size()) {
                    map.put(Integer.valueOf(i15), list2.get(y.p(i14, 0, list2.size() - 1)));
                    i14++;
                }
                i13++;
                i10 = i16;
            }
            int i17 = i10;
            int i18 = 0;
            for (int i19 = itemCount2 - 1; i19 >= 0; i19--) {
                int i20 = zN4 ? (itemCount2 - i19) - 1 : i19;
                if (i20 * f10 * (zN4 ? -1 : i17) < i11 + cVar4.f4839f || i19 < list.size()) {
                    map.put(Integer.valueOf(i20), list.get(y.p(i18, 0, list.size() - 1)));
                    i18++;
                }
            }
            this.f4802i = map;
            int i21 = this.f4806m;
            if (i21 != -1) {
                this.f4795a = j(i21, i(i21));
            }
        }
        int i22 = this.f4795a;
        int i23 = this.f4796b;
        int i24 = this.f4797c;
        this.f4795a = (i22 < i23 ? i23 - i22 : i22 > i24 ? i24 - i22 : 0) + i22;
        this.h = y.p(this.h, 0, state.getItemCount());
        u(this.f4800f);
        detachAndScrapAttachedViews(recycler);
        g(recycler, state);
        this.f4805l = getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        if (getChildCount() == 0) {
            this.h = 0;
        } else {
            this.h = getPosition(getChildAt(0));
        }
    }

    public final boolean p(float f8, c cVar) {
        b.C0035b c0035b = cVar.f4811a;
        float f9 = c0035b.f4830d;
        b.C0035b c0035b2 = cVar.f4812b;
        float fA = a(f8, l4.a.b(f9, c0035b2.f4830d, c0035b.f4828b, c0035b2.f4828b, f8) / 2.0f);
        return n() ? fA > ((float) h()) : fA < 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:143:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x05e8  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x05eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(androidx.recyclerview.widget.RecyclerView.Recycler r30) {
        /*
            Method dump skipped, instructions count: 1742
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.CarouselLayoutManager.q(androidx.recyclerview.widget.RecyclerView$Recycler):void");
    }

    public final void r() {
        this.f4800f = null;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z3) {
        int iK;
        if (this.f4800f == null || (iK = k(getPosition(view), i(getPosition(view)))) == 0) {
            return false;
        }
        int i10 = this.f4795a;
        int i11 = this.f4796b;
        int i12 = this.f4797c;
        int i13 = i10 + iK;
        if (i13 < i11) {
            iK = i11 - i10;
        } else if (i13 > i12) {
            iK = i12 - i10;
        }
        int iK2 = k(getPosition(view), this.f4800f.b(i10 + iK, i11, i12));
        if (m()) {
            recyclerView.scrollBy(iK2, 0);
            return true;
        }
        recyclerView.scrollBy(0, iK2);
        return true;
    }

    public final int s(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() != 0 && i10 != 0) {
            if (this.f4800f == null) {
                q(recycler);
            }
            int itemCount = getItemCount();
            com.google.android.material.carousel.c cVar = this.f4800f;
            if (itemCount > (n() ? cVar.a() : cVar.c()).f4814b) {
                int i11 = this.f4795a;
                int i12 = this.f4796b;
                int i13 = this.f4797c;
                int i14 = i11 + i10;
                if (i14 < i12) {
                    i10 = i12 - i11;
                } else if (i14 > i13) {
                    i10 = i13 - i11;
                }
                this.f4795a = i11 + i10;
                u(this.f4800f);
                float f8 = this.f4801g.f4813a / 2.0f;
                float f9 = f(getPosition(getChildAt(0)));
                Rect rect = new Rect();
                float f10 = n() ? this.f4801g.c().f4828b : this.f4801g.a().f4828b;
                float f11 = Float.MAX_VALUE;
                for (int i15 = 0; i15 < getChildCount(); i15++) {
                    View childAt = getChildAt(i15);
                    float fA = a(f9, f8);
                    c cVarL = l(this.f4801g.f4815c, fA, false);
                    float fE = e(fA, cVarL);
                    super.getDecoratedBoundsWithMargins(childAt, rect);
                    t(childAt, fA, cVarL);
                    this.f4803j.j(childAt, rect, f8, fE);
                    float fAbs = Math.abs(f10 - fE);
                    if (fAbs < f11) {
                        this.f4806m = getPosition(childAt);
                        f11 = fAbs;
                    }
                    f9 = a(f9, this.f4801g.f4813a);
                }
                g(recycler, state);
                return i10;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (m()) {
            return s(i10, recycler, state);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void scrollToPosition(int i10) {
        this.f4806m = i10;
        if (this.f4800f == null) {
            return;
        }
        this.f4795a = j(i10, i(i10));
        this.h = y.p(i10, 0, Math.max(0, getItemCount() - 1));
        u(this.f4800f);
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollVertically()) {
            return s(i10, recycler, state);
        }
        return 0;
    }

    public final void setOrientation(int i10) {
        f eVar;
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(i10, "invalid orientation:"));
        }
        assertNotInLayoutOrScroll(null);
        f fVar = this.f4803j;
        if (fVar == null || i10 != fVar.f10630a) {
            if (i10 == 0) {
                eVar = new n4.e(this);
            } else {
                if (i10 != 1) {
                    throw new IllegalArgumentException("invalid orientation");
                }
                eVar = new d(this);
            }
            this.f4803j = eVar;
            r();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i10) {
        a aVar = new a(recyclerView.getContext());
        aVar.setTargetPosition(i10);
        startSmoothScroll(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t(View view, float f8, c cVar) {
        if (view instanceof h) {
            b.C0035b c0035b = cVar.f4811a;
            float f9 = c0035b.f4829c;
            b.C0035b c0035b2 = cVar.f4812b;
            float fB = l4.a.b(f9, c0035b2.f4829c, c0035b.f4827a, c0035b2.f4827a, f8);
            float height = view.getHeight();
            float width = view.getWidth();
            RectF rectFB = this.f4803j.b(height, width, l4.a.b(0.0f, height / 2.0f, 0.0f, 1.0f, fB), l4.a.b(0.0f, width / 2.0f, 0.0f, 1.0f, fB));
            float fE = e(f8, cVar);
            RectF rectF = new RectF(fE - (rectFB.width() / 2.0f), fE - (rectFB.height() / 2.0f), (rectFB.width() / 2.0f) + fE, (rectFB.height() / 2.0f) + fE);
            RectF rectF2 = new RectF(this.f4803j.d(), this.f4803j.g(), this.f4803j.e(), this.f4803j.c());
            this.f4799e.getClass();
            this.f4803j.a(rectFB, rectF, rectF2);
            this.f4803j.i(rectFB, rectF, rectF2);
            ((h) view).a();
        }
    }

    public final void u(com.google.android.material.carousel.c cVar) {
        int i10 = this.f4797c;
        int i11 = this.f4796b;
        if (i10 <= i11) {
            this.f4801g = n() ? cVar.a() : cVar.c();
        } else {
            this.f4801g = cVar.b(this.f4795a, i11, i10);
        }
        List<b.C0035b> list = this.f4801g.f4815c;
        b bVar = this.f4798d;
        bVar.getClass();
        bVar.f4810b = Collections.unmodifiableList(list);
    }

    public final void v() {
        int itemCount = getItemCount();
        int i10 = this.f4805l;
        if (itemCount == i10 || this.f4800f == null) {
            return;
        }
        i iVar = this.f4799e;
        if ((i10 < iVar.f10635c && getItemCount() >= iVar.f10635c) || (i10 >= iVar.f10635c && getItemCount() < iVar.f10635c)) {
            r();
        }
        this.f4805l = itemCount;
    }

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f4798d = new b();
        this.h = 0;
        this.f4804k = new View.OnLayoutChangeListener() { // from class: n4.c
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i102, int i112, int i12, int i13, int i14, int i15, int i16, int i17) {
                if (i12 - i102 == i16 - i14 && i13 - i112 == i17 - i15) {
                    return;
                }
                view.post(new z0(this.f10627a, 19));
            }
        };
        this.f4806m = -1;
        this.f4807n = 0;
        this.f4799e = new i();
        r();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k4.a.f9900d);
            this.f4807n = typedArrayObtainStyledAttributes.getInt(0, 0);
            r();
            setOrientation(typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_orientation, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
