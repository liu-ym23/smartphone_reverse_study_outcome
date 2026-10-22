package com.google.android.material.carousel;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
abstract class b {

    /* renamed from: a, reason: collision with root package name */
    final int f12507a;

    class a extends b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CarouselLayoutManager f12508b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i5, CarouselLayoutManager carouselLayoutManager) {
            super(i5, null);
            this.f12508b = carouselLayoutManager;
        }

        @Override // com.google.android.material.carousel.b
        public void a(RectF rectF, RectF rectF2, RectF rectF3) {
            float f5 = rectF2.top;
            float f6 = rectF3.top;
            if (f5 < f6 && rectF2.bottom > f6) {
                float f7 = f6 - f5;
                rectF.top += f7;
                rectF3.top += f7;
            }
            float f8 = rectF2.bottom;
            float f9 = rectF3.bottom;
            if (f8 <= f9 || rectF2.top >= f9) {
                return;
            }
            float f10 = f8 - f9;
            rectF.bottom = Math.max(rectF.bottom - f10, rectF.top);
            rectF2.bottom = Math.max(rectF2.bottom - f10, rectF2.top);
        }

        @Override // com.google.android.material.carousel.b
        public RectF e(float f5, float f6, float f7, float f8) {
            return new RectF(0.0f, f7, f6, f5 - f7);
        }

        @Override // com.google.android.material.carousel.b
        int f() {
            return this.f12508b.getHeight();
        }

        @Override // com.google.android.material.carousel.b
        int g() {
            return this.f12508b.getPaddingLeft();
        }

        @Override // com.google.android.material.carousel.b
        int h() {
            return this.f12508b.getWidth() - this.f12508b.getPaddingRight();
        }

        @Override // com.google.android.material.carousel.b
        int i() {
            return j();
        }

        @Override // com.google.android.material.carousel.b
        int j() {
            return 0;
        }

        @Override // com.google.android.material.carousel.b
        public void k(View view, int i5, int i6) {
            int iG = g();
            this.f12508b.layoutDecoratedWithMargins(view, iG, i5, iG + n(view), i6);
        }

        @Override // com.google.android.material.carousel.b
        public void l(RectF rectF, RectF rectF2, RectF rectF3) {
            if (rectF2.bottom <= rectF3.top) {
                float fFloor = ((float) Math.floor(rectF.bottom)) - 1.0f;
                rectF.bottom = fFloor;
                rectF.top = Math.min(rectF.top, fFloor);
            }
            if (rectF2.top >= rectF3.bottom) {
                float fCeil = ((float) Math.ceil(rectF.top)) + 1.0f;
                rectF.top = fCeil;
                rectF.bottom = Math.max(fCeil, rectF.bottom);
            }
        }

        @Override // com.google.android.material.carousel.b
        public void m(View view, Rect rect, float f5, float f6) {
            view.offsetTopAndBottom((int) (f6 - (rect.top + f5)));
        }

        int n(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f12508b.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }
    }

    /* renamed from: com.google.android.material.carousel.b$b, reason: collision with other inner class name */
    class C0161b extends b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CarouselLayoutManager f12509b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0161b(int i5, CarouselLayoutManager carouselLayoutManager) {
            super(i5, null);
            this.f12509b = carouselLayoutManager;
        }

        @Override // com.google.android.material.carousel.b
        public void a(RectF rectF, RectF rectF2, RectF rectF3) {
            float f5 = rectF2.left;
            float f6 = rectF3.left;
            if (f5 < f6 && rectF2.right > f6) {
                float f7 = f6 - f5;
                rectF.left += f7;
                rectF2.left += f7;
            }
            float f8 = rectF2.right;
            float f9 = rectF3.right;
            if (f8 <= f9 || rectF2.left >= f9) {
                return;
            }
            float f10 = f8 - f9;
            rectF.right = Math.max(rectF.right - f10, rectF.left);
            rectF2.right = Math.max(rectF2.right - f10, rectF2.left);
        }

        @Override // com.google.android.material.carousel.b
        public RectF e(float f5, float f6, float f7, float f8) {
            return new RectF(f8, 0.0f, f6 - f8, f5);
        }

        @Override // com.google.android.material.carousel.b
        int f() {
            return this.f12509b.getHeight() - this.f12509b.getPaddingBottom();
        }

        @Override // com.google.android.material.carousel.b
        int g() {
            return 0;
        }

        @Override // com.google.android.material.carousel.b
        int h() {
            return this.f12509b.getWidth();
        }

        @Override // com.google.android.material.carousel.b
        int i() {
            return this.f12509b.f0() ? h() : g();
        }

        @Override // com.google.android.material.carousel.b
        int j() {
            return this.f12509b.getPaddingTop();
        }

        @Override // com.google.android.material.carousel.b
        public void k(View view, int i5, int i6) {
            int iJ = j();
            this.f12509b.layoutDecoratedWithMargins(view, i5, iJ, i6, iJ + n(view));
        }

        @Override // com.google.android.material.carousel.b
        public void l(RectF rectF, RectF rectF2, RectF rectF3) {
            if (rectF2.right <= rectF3.left) {
                float fFloor = ((float) Math.floor(rectF.right)) - 1.0f;
                rectF.right = fFloor;
                rectF.left = Math.min(rectF.left, fFloor);
            }
            if (rectF2.left >= rectF3.right) {
                float fCeil = ((float) Math.ceil(rectF.left)) + 1.0f;
                rectF.left = fCeil;
                rectF.right = Math.max(fCeil, rectF.right);
            }
        }

        @Override // com.google.android.material.carousel.b
        public void m(View view, Rect rect, float f5, float f6) {
            view.offsetLeftAndRight((int) (f6 - (rect.left + f5)));
        }

        int n(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f12509b.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
    }

    /* synthetic */ b(int i5, a aVar) {
        this(i5);
    }

    private static b b(CarouselLayoutManager carouselLayoutManager) {
        return new C0161b(0, carouselLayoutManager);
    }

    static b c(CarouselLayoutManager carouselLayoutManager, int i5) {
        if (i5 == 0) {
            return b(carouselLayoutManager);
        }
        if (i5 == 1) {
            return d(carouselLayoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    private static b d(CarouselLayoutManager carouselLayoutManager) {
        return new a(1, carouselLayoutManager);
    }

    abstract void a(RectF rectF, RectF rectF2, RectF rectF3);

    abstract RectF e(float f5, float f6, float f7, float f8);

    abstract int f();

    abstract int g();

    abstract int h();

    abstract int i();

    abstract int j();

    abstract void k(View view, int i5, int i6);

    abstract void l(RectF rectF, RectF rectF2, RectF rectF3);

    abstract void m(View view, Rect rect, float f5, float f6);

    private b(int i5) {
        this.f12507a = i5;
    }
}
