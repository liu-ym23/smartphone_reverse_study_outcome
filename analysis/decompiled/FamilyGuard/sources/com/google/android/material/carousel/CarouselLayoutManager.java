package com.google.android.material.carousel;

import a1.C0411d;
import a1.C0418k;
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
import b1.C0553a;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.carousel.c;
import com.google.android.material.carousel.e;
import e1.InterfaceC0682a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class CarouselLayoutManager extends RecyclerView.LayoutManager implements InterfaceC0682a, RecyclerView.SmoothScroller.ScrollVectorProvider {

    /* renamed from: a, reason: collision with root package name */
    int f12475a;

    /* renamed from: b, reason: collision with root package name */
    int f12476b;

    /* renamed from: c, reason: collision with root package name */
    int f12477c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f12478d;

    /* renamed from: e, reason: collision with root package name */
    private final c f12479e;

    /* renamed from: f, reason: collision with root package name */
    private com.google.android.material.carousel.c f12480f;

    /* renamed from: g, reason: collision with root package name */
    private f f12481g;

    /* renamed from: h, reason: collision with root package name */
    private e f12482h;

    /* renamed from: i, reason: collision with root package name */
    private int f12483i;

    /* renamed from: j, reason: collision with root package name */
    private Map<Integer, e> f12484j;

    /* renamed from: k, reason: collision with root package name */
    private com.google.android.material.carousel.b f12485k;

    /* renamed from: l, reason: collision with root package name */
    private final View.OnLayoutChangeListener f12486l;

    /* renamed from: m, reason: collision with root package name */
    private int f12487m;

    /* renamed from: n, reason: collision with root package name */
    private int f12488n;

    /* renamed from: o, reason: collision with root package name */
    private int f12489o;

    class a extends LinearSmoothScroller {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDxToMakeVisible(View view, int i5) {
            if (CarouselLayoutManager.this.f12481g == null || !CarouselLayoutManager.this.r()) {
                return 0;
            }
            CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
            return carouselLayoutManager.K(carouselLayoutManager.getPosition(view));
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDyToMakeVisible(View view, int i5) {
            if (CarouselLayoutManager.this.f12481g == null || CarouselLayoutManager.this.r()) {
                return 0;
            }
            CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
            return carouselLayoutManager.K(carouselLayoutManager.getPosition(view));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public PointF computeScrollVectorForPosition(int i5) {
            return CarouselLayoutManager.this.computeScrollVectorForPosition(i5);
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        final View f12491a;

        /* renamed from: b, reason: collision with root package name */
        final float f12492b;

        /* renamed from: c, reason: collision with root package name */
        final float f12493c;

        /* renamed from: d, reason: collision with root package name */
        final d f12494d;

        b(View view, float f5, float f6, d dVar) {
            this.f12491a = view;
            this.f12492b = f5;
            this.f12493c = f6;
            this.f12494d = dVar;
        }
    }

    private static class c extends RecyclerView.ItemDecoration {

        /* renamed from: a, reason: collision with root package name */
        private final Paint f12495a;

        /* renamed from: b, reason: collision with root package name */
        private List<e.c> f12496b;

        c() {
            Paint paint = new Paint();
            this.f12495a = paint;
            this.f12496b = Collections.unmodifiableList(new ArrayList());
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        void a(List<e.c> list) {
            this.f12496b = Collections.unmodifiableList(list);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            super.onDrawOver(canvas, recyclerView, state);
            this.f12495a.setStrokeWidth(recyclerView.getResources().getDimension(C0411d.f6795o));
            for (e.c cVar : this.f12496b) {
                this.f12495a.setColor(androidx.core.graphics.a.c(-65281, -16776961, cVar.f12532c));
                if (((CarouselLayoutManager) recyclerView.getLayoutManager()).r()) {
                    canvas.drawLine(cVar.f12531b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).a0(), cVar.f12531b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).W(), this.f12495a);
                } else {
                    canvas.drawLine(((CarouselLayoutManager) recyclerView.getLayoutManager()).X(), cVar.f12531b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).Y(), cVar.f12531b, this.f12495a);
                }
            }
        }
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        final e.c f12497a;

        /* renamed from: b, reason: collision with root package name */
        final e.c f12498b;

        d(e.c cVar, e.c cVar2) {
            D.h.a(cVar.f12530a <= cVar2.f12530a);
            this.f12497a = cVar;
            this.f12498b = cVar2;
        }
    }

    public CarouselLayoutManager() {
        this(new h());
    }

    private void B(View view, int i5, b bVar) {
        float fG = this.f12482h.g() / 2.0f;
        addView(view, i5);
        measureChildWithMargins(view, 0, 0);
        float f5 = bVar.f12493c;
        this.f12485k.k(view, (int) (f5 - fG), (int) (f5 + fG));
        s0(view, bVar.f12492b, bVar.f12494d);
    }

    private float C(float f5, float f6) {
        return f0() ? f5 - f6 : f5 + f6;
    }

    private float D(float f5, float f6) {
        return f0() ? f5 + f6 : f5 - f6;
    }

    private void E(RecyclerView.Recycler recycler, int i5, int i6) {
        if (i5 < 0 || i5 >= getItemCount()) {
            return;
        }
        b bVarJ0 = j0(recycler, I(i5), i5);
        B(bVarJ0.f12491a, i6, bVarJ0);
    }

    private void F(RecyclerView.Recycler recycler, RecyclerView.State state, int i5) {
        float fI = I(i5);
        while (i5 < state.getItemCount()) {
            float fC = C(fI, this.f12482h.g() / 2.0f);
            d dVarE0 = e0(this.f12482h.h(), fC, false);
            float fH = H(fC, dVarE0);
            if (g0(fH, dVarE0)) {
                return;
            }
            fI = C(fI, this.f12482h.g());
            if (!h0(fH, dVarE0)) {
                View viewForPosition = recycler.getViewForPosition(i5);
                B(viewForPosition, -1, new b(viewForPosition, fC, fH, dVarE0));
            }
            i5++;
        }
    }

    private void G(RecyclerView.Recycler recycler, int i5) {
        float fI = I(i5);
        while (i5 >= 0) {
            float fC = C(fI, this.f12482h.g() / 2.0f);
            d dVarE0 = e0(this.f12482h.h(), fC, false);
            float fH = H(fC, dVarE0);
            if (h0(fH, dVarE0)) {
                return;
            }
            fI = D(fI, this.f12482h.g());
            if (!g0(fH, dVarE0)) {
                View viewForPosition = recycler.getViewForPosition(i5);
                B(viewForPosition, 0, new b(viewForPosition, fC, fH, dVarE0));
            }
            i5--;
        }
    }

    private float H(float f5, d dVar) {
        e.c cVar = dVar.f12497a;
        float f6 = cVar.f12531b;
        e.c cVar2 = dVar.f12498b;
        float fB = C0553a.b(f6, cVar2.f12531b, cVar.f12530a, cVar2.f12530a, f5);
        if (dVar.f12498b != this.f12482h.d() && dVar.f12497a != this.f12482h.k()) {
            return fB;
        }
        e.c cVar3 = dVar.f12498b;
        return fB + ((f5 - cVar3.f12530a) * (1.0f - cVar3.f12532c));
    }

    private float I(int i5) {
        return C(Z() - this.f12475a, this.f12482h.g() * i5);
    }

    private int J(RecyclerView.State state, f fVar) {
        boolean zF0 = f0();
        e eVarL = zF0 ? fVar.l() : fVar.h();
        e.c cVarB = zF0 ? eVarL.b() : eVarL.i();
        int itemCount = (int) (((((state.getItemCount() - 1) * eVarL.g()) * (zF0 ? -1.0f : 1.0f)) - (cVarB.f12530a - Z())) + (((zF0 ? -1 : 1) * cVarB.f12533d) / 2.0f));
        return zF0 ? Math.min(0, itemCount) : Math.max(0, itemCount);
    }

    private static int L(int i5, int i6, int i7, int i8) {
        int i9 = i6 + i5;
        return i9 < i7 ? i7 - i6 : i9 > i8 ? i8 - i6 : i5;
    }

    private int M(f fVar) {
        boolean zF0 = f0();
        e eVarH = zF0 ? fVar.h() : fVar.l();
        return (int) (Z() - D((zF0 ? eVarH.i() : eVarH.b()).f12530a, eVarH.g() / 2.0f));
    }

    private void N(RecyclerView.Recycler recycler, RecyclerView.State state) {
        n0(recycler);
        if (getChildCount() == 0) {
            G(recycler, this.f12483i - 1);
            F(recycler, state, this.f12483i);
        } else {
            int position = getPosition(getChildAt(0));
            int position2 = getPosition(getChildAt(getChildCount() - 1));
            G(recycler, position - 1);
            F(recycler, state, position2 + 1);
        }
        v0();
    }

    private int O() {
        return r() ? a() : b();
    }

    private float P(View view) {
        super.getDecoratedBoundsWithMargins(view, new Rect());
        return r() ? r0.centerX() : r0.centerY();
    }

    private int Q() {
        int i5;
        int i6;
        if (getChildCount() <= 0) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) getChildAt(0).getLayoutParams();
        if (this.f12485k.f12507a == 0) {
            i5 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            i6 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        } else {
            i5 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            i6 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return i5 + i6;
    }

    private e R(f fVar) {
        return f0() ? fVar.h() : fVar.l();
    }

    private e S(int i5) {
        e eVar;
        Map<Integer, e> map = this.f12484j;
        return (map == null || (eVar = map.get(Integer.valueOf(B.a.b(i5, 0, Math.max(0, getItemCount() + (-1)))))) == null) ? this.f12481g.g() : eVar;
    }

    private int T() {
        if (getClipToPadding()) {
            return 0;
        }
        return getOrientation() == 1 ? getPaddingTop() : getPaddingLeft();
    }

    private float U(float f5, d dVar) {
        e.c cVar = dVar.f12497a;
        float f6 = cVar.f12533d;
        e.c cVar2 = dVar.f12498b;
        return C0553a.b(f6, cVar2.f12533d, cVar.f12531b, cVar2.f12531b, f5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int W() {
        return this.f12485k.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int X() {
        return this.f12485k.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Y() {
        return this.f12485k.h();
    }

    private int Z() {
        return this.f12485k.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a0() {
        return this.f12485k.j();
    }

    private int b0() {
        if (getClipToPadding()) {
            return 0;
        }
        return getOrientation() == 1 ? getPaddingBottom() : getPaddingRight();
    }

    private int c0(int i5, e eVar) {
        return (int) (f0() ? ((O() - eVar.i().f12530a) - (i5 * eVar.g())) - (eVar.g() / 2.0f) : ((i5 * eVar.g()) - eVar.b().f12530a) + (eVar.g() / 2.0f));
    }

    private int convertFocusDirectionToLayoutDirection(int i5) {
        int orientation = getOrientation();
        if (i5 == 1) {
            return -1;
        }
        if (i5 == 2) {
            return 1;
        }
        if (i5 == 17) {
            if (orientation == 0) {
                return f0() ? 1 : -1;
            }
            return Integer.MIN_VALUE;
        }
        if (i5 == 33) {
            return orientation == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i5 == 66) {
            if (orientation == 0) {
                return f0() ? -1 : 1;
            }
            return Integer.MIN_VALUE;
        }
        if (i5 == 130) {
            return orientation == 1 ? 1 : Integer.MIN_VALUE;
        }
        Log.d("CarouselLayoutManager", "Unknown focus request:" + i5);
        return Integer.MIN_VALUE;
    }

    private int d0(int i5, e eVar) {
        int i6 = Integer.MAX_VALUE;
        for (e.c cVar : eVar.f()) {
            float fG = (i5 * eVar.g()) + (eVar.g() / 2.0f);
            int iO = (f0() ? (int) ((O() - cVar.f12530a) - fG) : (int) (fG - cVar.f12530a)) - this.f12475a;
            if (Math.abs(i6) > Math.abs(iO)) {
                i6 = iO;
            }
        }
        return i6;
    }

    private static d e0(List<e.c> list, float f5, boolean z5) {
        float f6 = Float.MAX_VALUE;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        float f7 = -3.4028235E38f;
        float f8 = Float.MAX_VALUE;
        float f9 = Float.MAX_VALUE;
        for (int i9 = 0; i9 < list.size(); i9++) {
            e.c cVar = list.get(i9);
            float f10 = z5 ? cVar.f12531b : cVar.f12530a;
            float fAbs = Math.abs(f10 - f5);
            if (f10 <= f5 && fAbs <= f6) {
                i5 = i9;
                f6 = fAbs;
            }
            if (f10 > f5 && fAbs <= f8) {
                i7 = i9;
                f8 = fAbs;
            }
            if (f10 <= f9) {
                i6 = i9;
                f9 = f10;
            }
            if (f10 > f7) {
                i8 = i9;
                f7 = f10;
            }
        }
        if (i5 == -1) {
            i5 = i6;
        }
        if (i7 == -1) {
            i7 = i8;
        }
        return new d(list.get(i5), list.get(i7));
    }

    private boolean g0(float f5, d dVar) {
        float fD = D(f5, U(f5, dVar) / 2.0f);
        return f0() ? fD < 0.0f : fD > ((float) O());
    }

    private View getChildClosestToEnd() {
        return getChildAt(f0() ? 0 : getChildCount() - 1);
    }

    private View getChildClosestToStart() {
        return getChildAt(f0() ? getChildCount() - 1 : 0);
    }

    private boolean h0(float f5, d dVar) {
        float fC = C(f5, U(f5, dVar) / 2.0f);
        return f0() ? fC > ((float) O()) : fC < 0.0f;
    }

    private void i0() {
        if (this.f12478d && Log.isLoggable("CarouselLayoutManager", 3)) {
            Log.d("CarouselLayoutManager", "internal representation of views on the screen");
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                View childAt = getChildAt(i5);
                Log.d("CarouselLayoutManager", "item position " + getPosition(childAt) + ", center:" + P(childAt) + ", child index:" + i5);
            }
            Log.d("CarouselLayoutManager", "==============");
        }
    }

    private b j0(RecyclerView.Recycler recycler, float f5, int i5) {
        View viewForPosition = recycler.getViewForPosition(i5);
        measureChildWithMargins(viewForPosition, 0, 0);
        float fC = C(f5, this.f12482h.g() / 2.0f);
        d dVarE0 = e0(this.f12482h.h(), fC, false);
        return new b(viewForPosition, fC, H(fC, dVarE0), dVarE0);
    }

    private float k0(View view, float f5, float f6, Rect rect) {
        float fC = C(f5, f6);
        d dVarE0 = e0(this.f12482h.h(), fC, false);
        float fH = H(fC, dVarE0);
        super.getDecoratedBoundsWithMargins(view, rect);
        s0(view, fC, dVarE0);
        this.f12485k.m(view, rect, f6, fH);
        return fH;
    }

    private void l0(RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(0);
        measureChildWithMargins(viewForPosition, 0, 0);
        e eVarG = this.f12480f.g(this, viewForPosition);
        if (f0()) {
            eVarG = e.p(eVarG, O());
        }
        this.f12481g = f.f(this, eVarG, Q(), T(), b0(), this.f12480f.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        this.f12481g = null;
        requestLayout();
    }

    private void n0(RecyclerView.Recycler recycler) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            float fP = P(childAt);
            if (!h0(fP, e0(this.f12482h.h(), fP, true))) {
                break;
            } else {
                removeAndRecycleView(childAt, recycler);
            }
        }
        while (getChildCount() - 1 >= 0) {
            View childAt2 = getChildAt(getChildCount() - 1);
            float fP2 = P(childAt2);
            if (!g0(fP2, e0(this.f12482h.h(), fP2, true))) {
                return;
            } else {
                removeAndRecycleView(childAt2, recycler);
            }
        }
    }

    private void o0(RecyclerView recyclerView, int i5) {
        if (r()) {
            recyclerView.scrollBy(i5, 0);
        } else {
            recyclerView.scrollBy(0, i5);
        }
    }

    private void q0(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0418k.f7043S);
            p0(typedArrayObtainStyledAttributes.getInt(C0418k.f7049T, 0));
            setOrientation(typedArrayObtainStyledAttributes.getInt(R.styleable.RecyclerView_android_orientation, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void s0(View view, float f5, d dVar) {
        if (view instanceof g) {
            e.c cVar = dVar.f12497a;
            float f6 = cVar.f12532c;
            e.c cVar2 = dVar.f12498b;
            float fB = C0553a.b(f6, cVar2.f12532c, cVar.f12530a, cVar2.f12530a, f5);
            float height = view.getHeight();
            float width = view.getWidth();
            RectF rectFE = this.f12485k.e(height, width, C0553a.b(0.0f, height / 2.0f, 0.0f, 1.0f, fB), C0553a.b(0.0f, width / 2.0f, 0.0f, 1.0f, fB));
            float fH = H(f5, dVar);
            RectF rectF = new RectF(fH - (rectFE.width() / 2.0f), fH - (rectFE.height() / 2.0f), fH + (rectFE.width() / 2.0f), (rectFE.height() / 2.0f) + fH);
            RectF rectF2 = new RectF(X(), a0(), Y(), W());
            if (this.f12480f.e() == c.a.CONTAINED) {
                this.f12485k.a(rectFE, rectF, rectF2);
            }
            this.f12485k.l(rectFE, rectF, rectF2);
            ((g) view).a(rectFE);
        }
    }

    private int scrollBy(int i5, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i5 == 0) {
            return 0;
        }
        if (this.f12481g == null) {
            l0(recycler);
        }
        if (getItemCount() <= R(this.f12481g).n()) {
            return 0;
        }
        int iL = L(i5, this.f12475a, this.f12476b, this.f12477c);
        this.f12475a += iL;
        t0(this.f12481g);
        float fG = this.f12482h.g() / 2.0f;
        float fI = I(getPosition(getChildAt(0)));
        Rect rect = new Rect();
        float f5 = f0() ? this.f12482h.i().f12531b : this.f12482h.b().f12531b;
        float f6 = Float.MAX_VALUE;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            float fAbs = Math.abs(f5 - k0(childAt, fI, fG, rect));
            if (childAt != null && fAbs < f6) {
                this.f12488n = getPosition(childAt);
                f6 = fAbs;
            }
            fI = C(fI, this.f12482h.g());
        }
        N(recycler, state);
        return iL;
    }

    private void t0(f fVar) {
        int i5 = this.f12477c;
        int i6 = this.f12476b;
        if (i5 <= i6) {
            this.f12482h = R(fVar);
        } else {
            this.f12482h = fVar.j(this.f12475a, i6, i5);
        }
        this.f12479e.a(this.f12482h.h());
    }

    private void u0() {
        int itemCount = getItemCount();
        int i5 = this.f12487m;
        if (itemCount == i5 || this.f12481g == null) {
            return;
        }
        if (this.f12480f.h(this, i5)) {
            m0();
        }
        this.f12487m = itemCount;
    }

    public static /* synthetic */ void v(final CarouselLayoutManager carouselLayoutManager, View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        carouselLayoutManager.getClass();
        if (i7 - i5 == i11 - i9 && i8 - i6 == i12 - i10) {
            return;
        }
        view.post(new Runnable() { // from class: e1.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f16647a.m0();
            }
        });
    }

    private void v0() {
        if (!this.f12478d || getChildCount() < 1) {
            return;
        }
        int i5 = 0;
        while (i5 < getChildCount() - 1) {
            int position = getPosition(getChildAt(i5));
            int i6 = i5 + 1;
            int position2 = getPosition(getChildAt(i6));
            if (position > position2) {
                i0();
                throw new IllegalStateException("Detected invalid child order. Child at index [" + i5 + "] had adapter position [" + position + "] and child at index [" + i6 + "] had adapter position [" + position2 + "].");
            }
            i5 = i6;
        }
    }

    int K(int i5) {
        return (int) (this.f12475a - c0(i5, S(i5)));
    }

    int V(int i5, e eVar) {
        return c0(i5, eVar) - this.f12475a;
    }

    @Override // e1.InterfaceC0682a
    public int a() {
        return getWidth();
    }

    @Override // e1.InterfaceC0682a
    public int b() {
        return getHeight();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return r();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return !r();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0 || this.f12481g == null || getItemCount() <= 1) {
            return 0;
        }
        return (int) (getWidth() * (this.f12481g.g().g() / computeHorizontalScrollRange(state)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return this.f12475a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return this.f12477c - this.f12476b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i5) {
        if (this.f12481g == null) {
            return null;
        }
        int iV = V(i5, S(i5));
        return r() ? new PointF(iV, 0.0f) : new PointF(0.0f, iV);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0 || this.f12481g == null || getItemCount() <= 1) {
            return 0;
        }
        return (int) (getHeight() * (this.f12481g.g().g() / computeVerticalScrollRange(state)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return this.f12475a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return this.f12477c - this.f12476b;
    }

    boolean f0() {
        return r() && getLayoutDirection() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        super.getDecoratedBoundsWithMargins(view, rect);
        float fCenterY = rect.centerY();
        if (r()) {
            fCenterY = rect.centerX();
        }
        float fU = U(fCenterY, e0(this.f12482h.h(), fCenterY, true));
        float fWidth = r() ? (rect.width() - fU) / 2.0f : 0.0f;
        float fHeight = r() ? 0.0f : (rect.height() - fU) / 2.0f;
        rect.set((int) (rect.left + fWidth), (int) (rect.top + fHeight), (int) (rect.right - fWidth), (int) (rect.bottom - fHeight));
    }

    public int getOrientation() {
        return this.f12485k.f12507a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void measureChildWithMargins(View view, int i5, int i6) {
        if (!(view instanceof g)) {
            throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        Rect rect = new Rect();
        calculateItemDecorationsForChild(view, rect);
        int i7 = i5 + rect.left + rect.right;
        int i8 = i6 + rect.top + rect.bottom;
        f fVar = this.f12481g;
        float fG = (fVar == null || this.f12485k.f12507a != 0) ? ((ViewGroup.MarginLayoutParams) layoutParams).width : fVar.g().g();
        f fVar2 = this.f12481g;
        view.measure(RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i7, (int) fG, canScrollHorizontally()), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i8, (int) ((fVar2 == null || this.f12485k.f12507a != 1) ? ((ViewGroup.MarginLayoutParams) layoutParams).height : fVar2.g().g()), canScrollVertically()));
    }

    @Override // e1.InterfaceC0682a
    public int o() {
        return this.f12489o;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.f12480f.f(recyclerView.getContext());
        m0();
        recyclerView.addOnLayoutChangeListener(this.f12486l);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        recyclerView.removeOnLayoutChangeListener(this.f12486l);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View view, int i5, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int iConvertFocusDirectionToLayoutDirection;
        if (getChildCount() == 0 || (iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i5)) == Integer.MIN_VALUE) {
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
    public void onItemsAdded(RecyclerView recyclerView, int i5, int i6) {
        super.onItemsAdded(recyclerView, i5, i6);
        u0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        super.onItemsChanged(recyclerView);
        u0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i5, int i6) {
        super.onItemsRemoved(recyclerView, i5, i6);
        u0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.getItemCount() <= 0 || O() <= 0.0f) {
            removeAndRecycleAllViews(recycler);
            this.f12483i = 0;
            return;
        }
        boolean zF0 = f0();
        f fVar = this.f12481g;
        boolean z5 = fVar == null;
        if (z5 || fVar.g().a() != O()) {
            l0(recycler);
        }
        int iM = M(this.f12481g);
        int iJ = J(state, this.f12481g);
        this.f12476b = zF0 ? iJ : iM;
        if (zF0) {
            iJ = iM;
        }
        this.f12477c = iJ;
        if (z5) {
            this.f12475a = iM;
            this.f12484j = this.f12481g.i(getItemCount(), this.f12476b, this.f12477c, f0());
            int i5 = this.f12488n;
            if (i5 != -1) {
                this.f12475a = c0(i5, S(i5));
            }
        }
        int i6 = this.f12475a;
        this.f12475a = i6 + L(0, i6, this.f12476b, this.f12477c);
        this.f12483i = B.a.b(this.f12483i, 0, state.getItemCount());
        t0(this.f12481g);
        detachAndScrapAttachedViews(recycler);
        N(recycler, state);
        this.f12487m = getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        if (getChildCount() == 0) {
            this.f12483i = 0;
        } else {
            this.f12483i = getPosition(getChildAt(0));
        }
        v0();
    }

    public void p0(int i5) {
        this.f12489o = i5;
        m0();
    }

    @Override // e1.InterfaceC0682a
    public boolean r() {
        return this.f12485k.f12507a == 0;
    }

    public void r0(com.google.android.material.carousel.c cVar) {
        this.f12480f = cVar;
        m0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z5, boolean z6) {
        int iD0;
        if (this.f12481g == null || (iD0 = d0(getPosition(view), S(getPosition(view)))) == 0) {
            return false;
        }
        o0(recyclerView, d0(getPosition(view), this.f12481g.j(this.f12475a + L(iD0, this.f12475a, this.f12476b, this.f12477c), this.f12476b, this.f12477c)));
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i5, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollHorizontally()) {
            return scrollBy(i5, recycler, state);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i5) {
        this.f12488n = i5;
        if (this.f12481g == null) {
            return;
        }
        this.f12475a = c0(i5, S(i5));
        this.f12483i = B.a.b(i5, 0, Math.max(0, getItemCount() - 1));
        t0(this.f12481g);
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i5, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollVertically()) {
            return scrollBy(i5, recycler, state);
        }
        return 0;
    }

    public void setOrientation(int i5) {
        if (i5 != 0 && i5 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i5);
        }
        assertNotInLayoutOrScroll(null);
        com.google.android.material.carousel.b bVar = this.f12485k;
        if (bVar == null || i5 != bVar.f12507a) {
            this.f12485k = com.google.android.material.carousel.b.c(this, i5);
            m0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i5) {
        a aVar = new a(recyclerView.getContext());
        aVar.setTargetPosition(i5);
        startSmoothScroll(aVar);
    }

    public CarouselLayoutManager(com.google.android.material.carousel.c cVar) {
        this(cVar, 0);
    }

    public CarouselLayoutManager(com.google.android.material.carousel.c cVar, int i5) {
        this.f12478d = false;
        this.f12479e = new c();
        this.f12483i = 0;
        this.f12486l = new View.OnLayoutChangeListener() { // from class: e1.b
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
                CarouselLayoutManager.v(this.f16646a, view, i6, i7, i8, i9, i10, i11, i12, i13);
            }
        };
        this.f12488n = -1;
        this.f12489o = 0;
        r0(cVar);
        setOrientation(i5);
    }

    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i5, int i6) {
        this.f12478d = false;
        this.f12479e = new c();
        this.f12483i = 0;
        this.f12486l = new View.OnLayoutChangeListener() { // from class: e1.b
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i62, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
                CarouselLayoutManager.v(this.f16646a, view, i62, i7, i8, i9, i10, i11, i12, i13);
            }
        };
        this.f12488n = -1;
        this.f12489o = 0;
        r0(new h());
        q0(context, attributeSet);
    }
}
