package com.google.android.material.carousel;

import B0.h;
import I2.e;
import I2.f;
import I2.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.carousel.CarouselStrategy;
import com.google.android.material.carousel.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import t0.C5502d;
import w0.C5715a;

/* loaded from: classes2.dex */
public class CarouselLayoutManager extends RecyclerView.LayoutManager implements I2.b, RecyclerView.SmoothScroller.ScrollVectorProvider {

    /* renamed from: a, reason: collision with root package name */
    public int f20531a;

    /* renamed from: b, reason: collision with root package name */
    public int f20532b;

    /* renamed from: c, reason: collision with root package name */
    public int f20533c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f20534d;

    /* renamed from: e, reason: collision with root package name */
    public final c f20535e;

    /* renamed from: f, reason: collision with root package name */
    public CarouselStrategy f20536f;

    /* renamed from: g, reason: collision with root package name */
    public com.google.android.material.carousel.c f20537g;

    /* renamed from: h, reason: collision with root package name */
    public com.google.android.material.carousel.b f20538h;

    /* renamed from: i, reason: collision with root package name */
    public int f20539i;

    /* renamed from: j, reason: collision with root package name */
    public Map<Integer, com.google.android.material.carousel.b> f20540j;

    /* renamed from: k, reason: collision with root package name */
    public e f20541k;

    /* renamed from: l, reason: collision with root package name */
    public final View.OnLayoutChangeListener f20542l;

    /* renamed from: m, reason: collision with root package name */
    public int f20543m;

    /* renamed from: n, reason: collision with root package name */
    public int f20544n;

    /* renamed from: o, reason: collision with root package name */
    public int f20545o;

    public class a extends LinearSmoothScroller {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDxToMakeVisible(View view, int i10) {
            if (CarouselLayoutManager.this.f20537g == null || !CarouselLayoutManager.this.l()) {
                return 0;
            }
            CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
            return carouselLayoutManager.K(carouselLayoutManager.getPosition(view));
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDyToMakeVisible(View view, int i10) {
            if (CarouselLayoutManager.this.f20537g == null || CarouselLayoutManager.this.l()) {
                return 0;
            }
            CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
            return carouselLayoutManager.K(carouselLayoutManager.getPosition(view));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public PointF computeScrollVectorForPosition(int i10) {
            return CarouselLayoutManager.this.computeScrollVectorForPosition(i10);
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final View f20547a;

        /* renamed from: b, reason: collision with root package name */
        public final float f20548b;

        /* renamed from: c, reason: collision with root package name */
        public final float f20549c;

        /* renamed from: d, reason: collision with root package name */
        public final d f20550d;

        public b(View view, float f10, float f11, d dVar) {
            this.f20547a = view;
            this.f20548b = f10;
            this.f20549c = f11;
            this.f20550d = dVar;
        }
    }

    public static class c extends RecyclerView.ItemDecoration {

        /* renamed from: a, reason: collision with root package name */
        public final Paint f20551a;

        /* renamed from: b, reason: collision with root package name */
        public List<b.c> f20552b;

        public c() {
            Paint paint = new Paint();
            this.f20551a = paint;
            this.f20552b = Collections.unmodifiableList(new ArrayList());
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        public void a(List<b.c> list) {
            this.f20552b = Collections.unmodifiableList(list);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            super.onDrawOver(canvas, recyclerView, state);
            this.f20551a.setStrokeWidth(recyclerView.getResources().getDimension(R$dimen.m3_carousel_debug_keyline_width));
            for (b.c cVar : this.f20552b) {
                this.f20551a.setColor(C5502d.c(-65281, -16776961, cVar.f20574c));
                if (((CarouselLayoutManager) recyclerView.getLayoutManager()).l()) {
                    canvas.drawLine(cVar.f20573b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).a0(), cVar.f20573b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).W(), this.f20551a);
                } else {
                    canvas.drawLine(((CarouselLayoutManager) recyclerView.getLayoutManager()).X(), cVar.f20573b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).Y(), cVar.f20573b, this.f20551a);
                }
            }
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final b.c f20553a;

        /* renamed from: b, reason: collision with root package name */
        public final b.c f20554b;

        public d(b.c cVar, b.c cVar2) {
            h.a(cVar.f20572a <= cVar2.f20572a);
            this.f20553a = cVar;
            this.f20554b = cVar2;
        }
    }

    public CarouselLayoutManager() {
        this(new g());
    }

    public static int L(int i10, int i11, int i12, int i13) {
        int i14 = i11 + i10;
        return i14 < i12 ? i12 - i11 : i14 > i13 ? i13 - i11 : i10;
    }

    private int convertFocusDirectionToLayoutDirection(int i10) {
        int orientation = getOrientation();
        if (i10 == 1) {
            return -1;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 17) {
            if (orientation == 0) {
                return f0() ? 1 : -1;
            }
            return Integer.MIN_VALUE;
        }
        if (i10 == 33) {
            return orientation == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i10 == 66) {
            if (orientation == 0) {
                return f0() ? -1 : 1;
            }
            return Integer.MIN_VALUE;
        }
        if (i10 == 130) {
            return orientation == 1 ? 1 : Integer.MIN_VALUE;
        }
        Log.d("CarouselLayoutManager", "Unknown focus request:" + i10);
        return Integer.MIN_VALUE;
    }

    public static d e0(List<b.c> list, float f10, boolean z10) {
        float f11 = Float.MAX_VALUE;
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        float f12 = -3.4028235E38f;
        float f13 = Float.MAX_VALUE;
        float f14 = Float.MAX_VALUE;
        for (int i14 = 0; i14 < list.size(); i14++) {
            b.c cVar = list.get(i14);
            float f15 = z10 ? cVar.f20573b : cVar.f20572a;
            float fAbs = Math.abs(f15 - f10);
            if (f15 <= f10 && fAbs <= f11) {
                i10 = i14;
                f11 = fAbs;
            }
            if (f15 > f10 && fAbs <= f13) {
                i12 = i14;
                f13 = fAbs;
            }
            if (f15 <= f14) {
                i11 = i14;
                f14 = f15;
            }
            if (f15 > f12) {
                i13 = i14;
                f12 = f15;
            }
        }
        if (i10 == -1) {
            i10 = i11;
        }
        if (i12 == -1) {
            i12 = i13;
        }
        return new d(list.get(i10), list.get(i12));
    }

    private int scrollBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        if (this.f20537g == null) {
            l0(recycler);
        }
        if (getItemCount() <= R(this.f20537g).n()) {
            return 0;
        }
        int iL = L(i10, this.f20531a, this.f20532b, this.f20533c);
        this.f20531a += iL;
        t0(this.f20537g);
        float fG = this.f20538h.g() / 2.0f;
        float fI = I(getPosition(getChildAt(0)));
        Rect rect = new Rect();
        float f10 = f0() ? this.f20538h.i().f20573b : this.f20538h.b().f20573b;
        float f11 = Float.MAX_VALUE;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            float fAbs = Math.abs(f10 - k0(childAt, fI, fG, rect));
            if (childAt != null && fAbs < f11) {
                this.f20544n = getPosition(childAt);
                f11 = fAbs;
            }
            fI = C(fI, this.f20538h.g());
        }
        N(recycler, state);
        return iL;
    }

    public static /* synthetic */ void v(final CarouselLayoutManager carouselLayoutManager, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        carouselLayoutManager.getClass();
        if (i12 - i10 == i16 - i14 && i13 - i11 == i17 - i15) {
            return;
        }
        view.post(new Runnable() { // from class: I2.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f3356a.m0();
            }
        });
    }

    public final void B(View view, int i10, b bVar) {
        float fG = this.f20538h.g() / 2.0f;
        addView(view, i10);
        measureChildWithMargins(view, 0, 0);
        float f10 = bVar.f20549c;
        this.f20541k.k(view, (int) (f10 - fG), (int) (f10 + fG));
        s0(view, bVar.f20548b, bVar.f20550d);
    }

    public final float C(float f10, float f11) {
        return f0() ? f10 - f11 : f10 + f11;
    }

    public final float D(float f10, float f11) {
        return f0() ? f10 + f11 : f10 - f11;
    }

    public final void E(RecyclerView.Recycler recycler, int i10, int i11) {
        if (i10 < 0 || i10 >= getItemCount()) {
            return;
        }
        b bVarJ0 = j0(recycler, I(i10), i10);
        B(bVarJ0.f20547a, i11, bVarJ0);
    }

    public final void F(RecyclerView.Recycler recycler, RecyclerView.State state, int i10) {
        float fI = I(i10);
        while (i10 < state.getItemCount()) {
            float fC = C(fI, this.f20538h.g() / 2.0f);
            d dVarE0 = e0(this.f20538h.h(), fC, false);
            float fH = H(fC, dVarE0);
            if (g0(fH, dVarE0)) {
                return;
            }
            fI = C(fI, this.f20538h.g());
            if (!h0(fH, dVarE0)) {
                View viewForPosition = recycler.getViewForPosition(i10);
                B(viewForPosition, -1, new b(viewForPosition, fC, fH, dVarE0));
            }
            i10++;
        }
    }

    public final void G(RecyclerView.Recycler recycler, int i10) {
        float fI = I(i10);
        while (i10 >= 0) {
            float fC = C(fI, this.f20538h.g() / 2.0f);
            d dVarE0 = e0(this.f20538h.h(), fC, false);
            float fH = H(fC, dVarE0);
            if (h0(fH, dVarE0)) {
                return;
            }
            fI = D(fI, this.f20538h.g());
            if (!g0(fH, dVarE0)) {
                View viewForPosition = recycler.getViewForPosition(i10);
                B(viewForPosition, 0, new b(viewForPosition, fC, fH, dVarE0));
            }
            i10--;
        }
    }

    public final float H(float f10, d dVar) {
        b.c cVar = dVar.f20553a;
        float f11 = cVar.f20573b;
        b.c cVar2 = dVar.f20554b;
        float fB = E2.a.b(f11, cVar2.f20573b, cVar.f20572a, cVar2.f20572a, f10);
        if (dVar.f20554b != this.f20538h.d() && dVar.f20553a != this.f20538h.k()) {
            return fB;
        }
        b.c cVar3 = dVar.f20554b;
        return fB + ((f10 - cVar3.f20572a) * (1.0f - cVar3.f20574c));
    }

    public final float I(int i10) {
        return C(Z() - this.f20531a, this.f20538h.g() * i10);
    }

    public final int J(RecyclerView.State state, com.google.android.material.carousel.c cVar) {
        boolean zF0 = f0();
        com.google.android.material.carousel.b bVarL = zF0 ? cVar.l() : cVar.h();
        b.c cVarB = zF0 ? bVarL.b() : bVarL.i();
        int itemCount = (int) (((((state.getItemCount() - 1) * bVarL.g()) * (zF0 ? -1.0f : 1.0f)) - (cVarB.f20572a - Z())) + (((zF0 ? -1 : 1) * cVarB.f20575d) / 2.0f));
        return zF0 ? Math.min(0, itemCount) : Math.max(0, itemCount);
    }

    public int K(int i10) {
        return (int) (this.f20531a - c0(i10, S(i10)));
    }

    public final int M(com.google.android.material.carousel.c cVar) {
        boolean zF0 = f0();
        com.google.android.material.carousel.b bVarH = zF0 ? cVar.h() : cVar.l();
        return (int) (Z() - D((zF0 ? bVarH.i() : bVarH.b()).f20572a, bVarH.g() / 2.0f));
    }

    public final void N(RecyclerView.Recycler recycler, RecyclerView.State state) {
        n0(recycler);
        if (getChildCount() == 0) {
            G(recycler, this.f20539i - 1);
            F(recycler, state, this.f20539i);
        } else {
            int position = getPosition(getChildAt(0));
            int position2 = getPosition(getChildAt(getChildCount() - 1));
            G(recycler, position - 1);
            F(recycler, state, position2 + 1);
        }
        v0();
    }

    public final int O() {
        return l() ? a() : b();
    }

    public final float P(View view) {
        super.getDecoratedBoundsWithMargins(view, new Rect());
        return l() ? r0.centerX() : r0.centerY();
    }

    public final int Q() {
        int i10;
        int i11;
        if (getChildCount() <= 0) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) getChildAt(0).getLayoutParams();
        if (this.f20541k.f3357a == 0) {
            i10 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            i11 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        } else {
            i10 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            i11 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return i10 + i11;
    }

    public final com.google.android.material.carousel.b R(com.google.android.material.carousel.c cVar) {
        return f0() ? cVar.h() : cVar.l();
    }

    public final com.google.android.material.carousel.b S(int i10) {
        com.google.android.material.carousel.b bVar;
        Map<Integer, com.google.android.material.carousel.b> map = this.f20540j;
        return (map == null || (bVar = map.get(Integer.valueOf(C5715a.b(i10, 0, Math.max(0, getItemCount() + (-1)))))) == null) ? this.f20537g.g() : bVar;
    }

    public final int T() {
        if (getClipToPadding()) {
            return 0;
        }
        return getOrientation() == 1 ? getPaddingTop() : getPaddingLeft();
    }

    public final float U(float f10, d dVar) {
        b.c cVar = dVar.f20553a;
        float f11 = cVar.f20575d;
        b.c cVar2 = dVar.f20554b;
        return E2.a.b(f11, cVar2.f20575d, cVar.f20573b, cVar2.f20573b, f10);
    }

    public int V(int i10, com.google.android.material.carousel.b bVar) {
        return c0(i10, bVar) - this.f20531a;
    }

    public final int W() {
        return this.f20541k.f();
    }

    public final int X() {
        return this.f20541k.g();
    }

    public final int Y() {
        return this.f20541k.h();
    }

    public final int Z() {
        return this.f20541k.i();
    }

    @Override // I2.b
    public int a() {
        return getWidth();
    }

    public final int a0() {
        return this.f20541k.j();
    }

    @Override // I2.b
    public int b() {
        return getHeight();
    }

    public final int b0() {
        if (getClipToPadding()) {
            return 0;
        }
        return getOrientation() == 1 ? getPaddingBottom() : getPaddingRight();
    }

    public final int c0(int i10, com.google.android.material.carousel.b bVar) {
        return (int) (f0() ? ((O() - bVar.i().f20572a) - (i10 * bVar.g())) - (bVar.g() / 2.0f) : ((i10 * bVar.g()) - bVar.b().f20572a) + (bVar.g() / 2.0f));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return l();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return !l();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0 || this.f20537g == null || getItemCount() <= 1) {
            return 0;
        }
        return (int) (getWidth() * (this.f20537g.g().g() / computeHorizontalScrollRange(state)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return this.f20531a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return this.f20533c - this.f20532b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i10) {
        if (this.f20537g == null) {
            return null;
        }
        int iV = V(i10, S(i10));
        return l() ? new PointF(iV, 0.0f) : new PointF(0.0f, iV);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0 || this.f20537g == null || getItemCount() <= 1) {
            return 0;
        }
        return (int) (getHeight() * (this.f20537g.g().g() / computeVerticalScrollRange(state)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return this.f20531a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return this.f20533c - this.f20532b;
    }

    public final int d0(int i10, com.google.android.material.carousel.b bVar) {
        int i11 = Integer.MAX_VALUE;
        for (b.c cVar : bVar.f()) {
            float fG = (i10 * bVar.g()) + (bVar.g() / 2.0f);
            int iO = (f0() ? (int) ((O() - cVar.f20572a) - fG) : (int) (fG - cVar.f20572a)) - this.f20531a;
            if (Math.abs(i11) > Math.abs(iO)) {
                i11 = iO;
            }
        }
        return i11;
    }

    public boolean f0() {
        return l() && getLayoutDirection() == 1;
    }

    public final boolean g0(float f10, d dVar) {
        float fD = D(f10, U(f10, dVar) / 2.0f);
        return f0() ? fD < 0.0f : fD > ((float) O());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public final View getChildClosestToEnd() {
        return getChildAt(f0() ? 0 : getChildCount() - 1);
    }

    public final View getChildClosestToStart() {
        return getChildAt(f0() ? getChildCount() - 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        super.getDecoratedBoundsWithMargins(view, rect);
        float fCenterY = rect.centerY();
        if (l()) {
            fCenterY = rect.centerX();
        }
        float fU = U(fCenterY, e0(this.f20538h.h(), fCenterY, true));
        float fWidth = l() ? (rect.width() - fU) / 2.0f : 0.0f;
        float fHeight = l() ? 0.0f : (rect.height() - fU) / 2.0f;
        rect.set((int) (rect.left + fWidth), (int) (rect.top + fHeight), (int) (rect.right - fWidth), (int) (rect.bottom - fHeight));
    }

    public int getOrientation() {
        return this.f20541k.f3357a;
    }

    public final boolean h0(float f10, d dVar) {
        float fC = C(f10, U(f10, dVar) / 2.0f);
        return f0() ? fC > ((float) O()) : fC < 0.0f;
    }

    @Override // I2.b
    public int i() {
        return this.f20545o;
    }

    public final void i0() {
        if (this.f20534d && Log.isLoggable("CarouselLayoutManager", 3)) {
            Log.d("CarouselLayoutManager", "internal representation of views on the screen");
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                Log.d("CarouselLayoutManager", "item position " + getPosition(childAt) + ", center:" + P(childAt) + ", child index:" + i10);
            }
            Log.d("CarouselLayoutManager", "==============");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public final b j0(RecyclerView.Recycler recycler, float f10, int i10) {
        View viewForPosition = recycler.getViewForPosition(i10);
        measureChildWithMargins(viewForPosition, 0, 0);
        float fC = C(f10, this.f20538h.g() / 2.0f);
        d dVarE0 = e0(this.f20538h.h(), fC, false);
        return new b(viewForPosition, fC, H(fC, dVarE0), dVarE0);
    }

    public final float k0(View view, float f10, float f11, Rect rect) {
        float fC = C(f10, f11);
        d dVarE0 = e0(this.f20538h.h(), fC, false);
        float fH = H(fC, dVarE0);
        super.getDecoratedBoundsWithMargins(view, rect);
        s0(view, fC, dVarE0);
        this.f20541k.m(view, rect, f11, fH);
        return fH;
    }

    @Override // I2.b
    public boolean l() {
        return this.f20541k.f3357a == 0;
    }

    public final void l0(RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(0);
        measureChildWithMargins(viewForPosition, 0, 0);
        com.google.android.material.carousel.b bVarG = this.f20536f.g(this, viewForPosition);
        if (f0()) {
            bVarG = com.google.android.material.carousel.b.p(bVarG, O());
        }
        this.f20537g = com.google.android.material.carousel.c.f(this, bVarG, Q(), T(), b0(), this.f20536f.e());
    }

    public final void m0() {
        this.f20537g = null;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void measureChildWithMargins(View view, int i10, int i11) {
        if (!(view instanceof f)) {
            throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        Rect rect = new Rect();
        calculateItemDecorationsForChild(view, rect);
        int i12 = i10 + rect.left + rect.right;
        int i13 = i11 + rect.top + rect.bottom;
        com.google.android.material.carousel.c cVar = this.f20537g;
        float fG = (cVar == null || this.f20541k.f3357a != 0) ? ((ViewGroup.MarginLayoutParams) layoutParams).width : cVar.g().g();
        com.google.android.material.carousel.c cVar2 = this.f20537g;
        view.measure(RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i12, (int) fG, canScrollHorizontally()), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i13, (int) ((cVar2 == null || this.f20541k.f3357a != 1) ? ((ViewGroup.MarginLayoutParams) layoutParams).height : cVar2.g().g()), canScrollVertically()));
    }

    public final void n0(RecyclerView.Recycler recycler) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            float fP = P(childAt);
            if (!h0(fP, e0(this.f20538h.h(), fP, true))) {
                break;
            } else {
                removeAndRecycleView(childAt, recycler);
            }
        }
        while (getChildCount() - 1 >= 0) {
            View childAt2 = getChildAt(getChildCount() - 1);
            float fP2 = P(childAt2);
            if (!g0(fP2, e0(this.f20538h.h(), fP2, true))) {
                return;
            } else {
                removeAndRecycleView(childAt2, recycler);
            }
        }
    }

    public final void o0(RecyclerView recyclerView, int i10) {
        if (l()) {
            recyclerView.scrollBy(i10, 0);
        } else {
            recyclerView.scrollBy(0, i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.f20536f.f(recyclerView.getContext());
        m0();
        recyclerView.addOnLayoutChangeListener(this.f20542l);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        recyclerView.removeOnLayoutChangeListener(this.f20542l);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View view, int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int iConvertFocusDirectionToLayoutDirection;
        if (getChildCount() == 0 || (iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i10)) == Integer.MIN_VALUE) {
            return null;
        }
        if (iConvertFocusDirectionToLayoutDirection == -1) {
            if (getPosition(view) == 0) {
                return null;
            }
            E(recycler, getPosition(getChildAt(0)) - 1, 0);
            return getChildClosestToStart();
        }
        if (getPosition(view) == getItemCount() - 1) {
            return null;
        }
        E(recycler, getPosition(getChildAt(getChildCount() - 1)) + 1, -1);
        return getChildClosestToEnd();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(getPosition(getChildAt(0)));
            accessibilityEvent.setToIndex(getPosition(getChildAt(getChildCount() - 1)));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        super.onItemsAdded(recyclerView, i10, i11);
        u0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        super.onItemsChanged(recyclerView);
        u0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        super.onItemsRemoved(recyclerView, i10, i11);
        u0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.getItemCount() <= 0 || O() <= 0.0f) {
            removeAndRecycleAllViews(recycler);
            this.f20539i = 0;
            return;
        }
        boolean zF0 = f0();
        com.google.android.material.carousel.c cVar = this.f20537g;
        boolean z10 = cVar == null;
        if (z10 || cVar.g().a() != O()) {
            l0(recycler);
        }
        int iM = M(this.f20537g);
        int iJ = J(state, this.f20537g);
        this.f20532b = zF0 ? iJ : iM;
        if (zF0) {
            iJ = iM;
        }
        this.f20533c = iJ;
        if (z10) {
            this.f20531a = iM;
            this.f20540j = this.f20537g.i(getItemCount(), this.f20532b, this.f20533c, f0());
            int i10 = this.f20544n;
            if (i10 != -1) {
                this.f20531a = c0(i10, S(i10));
            }
        }
        int i11 = this.f20531a;
        this.f20531a = i11 + L(0, i11, this.f20532b, this.f20533c);
        this.f20539i = C5715a.b(this.f20539i, 0, state.getItemCount());
        t0(this.f20537g);
        detachAndScrapAttachedViews(recycler);
        N(recycler, state);
        this.f20543m = getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        if (getChildCount() == 0) {
            this.f20539i = 0;
        } else {
            this.f20539i = getPosition(getChildAt(0));
        }
        v0();
    }

    public void p0(int i10) {
        this.f20545o = i10;
        m0();
    }

    public final void q0(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Carousel);
            p0(typedArrayObtainStyledAttributes.getInt(R$styleable.Carousel_carousel_alignment, 0));
            setOrientation(typedArrayObtainStyledAttributes.getInt(R.styleable.RecyclerView_android_orientation, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void r0(CarouselStrategy carouselStrategy) {
        this.f20536f = carouselStrategy;
        m0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
        int iD0;
        if (this.f20537g == null || (iD0 = d0(getPosition(view), S(getPosition(view)))) == 0) {
            return false;
        }
        o0(recyclerView, d0(getPosition(view), this.f20537g.j(this.f20531a + L(iD0, this.f20531a, this.f20532b, this.f20533c), this.f20532b, this.f20533c)));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void s0(View view, float f10, d dVar) {
        if (view instanceof f) {
            b.c cVar = dVar.f20553a;
            float f11 = cVar.f20574c;
            b.c cVar2 = dVar.f20554b;
            float fB = E2.a.b(f11, cVar2.f20574c, cVar.f20572a, cVar2.f20572a, f10);
            float height = view.getHeight();
            float width = view.getWidth();
            RectF rectFE = this.f20541k.e(height, width, E2.a.b(0.0f, height / 2.0f, 0.0f, 1.0f, fB), E2.a.b(0.0f, width / 2.0f, 0.0f, 1.0f, fB));
            float fH = H(f10, dVar);
            RectF rectF = new RectF(fH - (rectFE.width() / 2.0f), fH - (rectFE.height() / 2.0f), fH + (rectFE.width() / 2.0f), (rectFE.height() / 2.0f) + fH);
            RectF rectF2 = new RectF(X(), a0(), Y(), W());
            if (this.f20536f.e() == CarouselStrategy.StrategyType.CONTAINED) {
                this.f20541k.a(rectFE, rectF, rectF2);
            }
            this.f20541k.l(rectFE, rectF, rectF2);
            ((f) view).a(rectFE);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollHorizontally()) {
            return scrollBy(i10, recycler, state);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i10) {
        this.f20544n = i10;
        if (this.f20537g == null) {
            return;
        }
        this.f20531a = c0(i10, S(i10));
        this.f20539i = C5715a.b(i10, 0, Math.max(0, getItemCount() - 1));
        t0(this.f20537g);
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i10, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollVertically()) {
            return scrollBy(i10, recycler, state);
        }
        return 0;
    }

    public void setOrientation(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i10);
        }
        assertNotInLayoutOrScroll(null);
        e eVar = this.f20541k;
        if (eVar == null || i10 != eVar.f3357a) {
            this.f20541k = e.c(this, i10);
            m0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i10) {
        a aVar = new a(recyclerView.getContext());
        aVar.setTargetPosition(i10);
        startSmoothScroll(aVar);
    }

    public final void t0(com.google.android.material.carousel.c cVar) {
        int i10 = this.f20533c;
        int i11 = this.f20532b;
        if (i10 <= i11) {
            this.f20538h = R(cVar);
        } else {
            this.f20538h = cVar.j(this.f20531a, i11, i10);
        }
        this.f20535e.a(this.f20538h.h());
    }

    public final void u0() {
        int itemCount = getItemCount();
        int i10 = this.f20543m;
        if (itemCount == i10 || this.f20537g == null) {
            return;
        }
        if (this.f20536f.h(this, i10)) {
            m0();
        }
        this.f20543m = itemCount;
    }

    public final void v0() {
        if (!this.f20534d || getChildCount() < 1) {
            return;
        }
        int i10 = 0;
        while (i10 < getChildCount() - 1) {
            int position = getPosition(getChildAt(i10));
            int i11 = i10 + 1;
            int position2 = getPosition(getChildAt(i11));
            if (position > position2) {
                i0();
                throw new IllegalStateException("Detected invalid child order. Child at index [" + i10 + "] had adapter position [" + position + "] and child at index [" + i11 + "] had adapter position [" + position2 + "].");
            }
            i10 = i11;
        }
    }

    public CarouselLayoutManager(CarouselStrategy carouselStrategy) {
        this(carouselStrategy, 0);
    }

    public CarouselLayoutManager(CarouselStrategy carouselStrategy, int i10) {
        this.f20534d = false;
        this.f20535e = new c();
        this.f20539i = 0;
        this.f20542l = new View.OnLayoutChangeListener() { // from class: I2.c
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                CarouselLayoutManager.v(this.f3355a, view, i11, i12, i13, i14, i15, i16, i17, i18);
            }
        };
        this.f20544n = -1;
        this.f20545o = 0;
        r0(carouselStrategy);
        setOrientation(i10);
    }

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f20534d = false;
        this.f20535e = new c();
        this.f20539i = 0;
        this.f20542l = new View.OnLayoutChangeListener() { // from class: I2.c
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i112, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                CarouselLayoutManager.v(this.f3355a, view, i112, i12, i13, i14, i15, i16, i17, i18);
            }
        };
        this.f20544n = -1;
        this.f20545o = 0;
        r0(new g());
        q0(context, attributeSet);
    }
}
