package I2;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;

/* loaded from: classes2.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public final int f3357a;

    public class a extends e {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CarouselLayoutManager f3358b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i10, CarouselLayoutManager carouselLayoutManager) {
            super(i10, null);
            this.f3358b = carouselLayoutManager;
        }

        @Override // I2.e
        public void a(RectF rectF, RectF rectF2, RectF rectF3) {
            float f10 = rectF2.top;
            float f11 = rectF3.top;
            if (f10 < f11 && rectF2.bottom > f11) {
                float f12 = f11 - f10;
                rectF.top += f12;
                rectF3.top += f12;
            }
            float f13 = rectF2.bottom;
            float f14 = rectF3.bottom;
            if (f13 <= f14 || rectF2.top >= f14) {
                return;
            }
            float f15 = f13 - f14;
            rectF.bottom = Math.max(rectF.bottom - f15, rectF.top);
            rectF2.bottom = Math.max(rectF2.bottom - f15, rectF2.top);
        }

        @Override // I2.e
        public RectF e(float f10, float f11, float f12, float f13) {
            return new RectF(0.0f, f12, f11, f10 - f12);
        }

        @Override // I2.e
        public int f() {
            return this.f3358b.getHeight();
        }

        @Override // I2.e
        public int g() {
            return this.f3358b.getPaddingLeft();
        }

        @Override // I2.e
        public int h() {
            return this.f3358b.getWidth() - this.f3358b.getPaddingRight();
        }

        @Override // I2.e
        public int i() {
            return j();
        }

        @Override // I2.e
        public int j() {
            return 0;
        }

        @Override // I2.e
        public void k(View view, int i10, int i11) {
            int iG = g();
            this.f3358b.layoutDecoratedWithMargins(view, iG, i10, iG + n(view), i11);
        }

        @Override // I2.e
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

        @Override // I2.e
        public void m(View view, Rect rect, float f10, float f11) {
            view.offsetTopAndBottom((int) (f11 - (rect.top + f10)));
        }

        public int n(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f3358b.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }
    }

    public class b extends e {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CarouselLayoutManager f3359b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i10, CarouselLayoutManager carouselLayoutManager) {
            super(i10, null);
            this.f3359b = carouselLayoutManager;
        }

        @Override // I2.e
        public void a(RectF rectF, RectF rectF2, RectF rectF3) {
            float f10 = rectF2.left;
            float f11 = rectF3.left;
            if (f10 < f11 && rectF2.right > f11) {
                float f12 = f11 - f10;
                rectF.left += f12;
                rectF2.left += f12;
            }
            float f13 = rectF2.right;
            float f14 = rectF3.right;
            if (f13 <= f14 || rectF2.left >= f14) {
                return;
            }
            float f15 = f13 - f14;
            rectF.right = Math.max(rectF.right - f15, rectF.left);
            rectF2.right = Math.max(rectF2.right - f15, rectF2.left);
        }

        @Override // I2.e
        public RectF e(float f10, float f11, float f12, float f13) {
            return new RectF(f13, 0.0f, f11 - f13, f10);
        }

        @Override // I2.e
        public int f() {
            return this.f3359b.getHeight() - this.f3359b.getPaddingBottom();
        }

        @Override // I2.e
        public int g() {
            return 0;
        }

        @Override // I2.e
        public int h() {
            return this.f3359b.getWidth();
        }

        @Override // I2.e
        public int i() {
            return this.f3359b.f0() ? h() : g();
        }

        @Override // I2.e
        public int j() {
            return this.f3359b.getPaddingTop();
        }

        @Override // I2.e
        public void k(View view, int i10, int i11) {
            int iJ = j();
            this.f3359b.layoutDecoratedWithMargins(view, i10, iJ, i11, iJ + n(view));
        }

        @Override // I2.e
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

        @Override // I2.e
        public void m(View view, Rect rect, float f10, float f11) {
            view.offsetLeftAndRight((int) (f11 - (rect.left + f10)));
        }

        public int n(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f3359b.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
    }

    public /* synthetic */ e(int i10, a aVar) {
        this(i10);
    }

    public static e b(CarouselLayoutManager carouselLayoutManager) {
        return new b(0, carouselLayoutManager);
    }

    public static e c(CarouselLayoutManager carouselLayoutManager, int i10) {
        if (i10 == 0) {
            return b(carouselLayoutManager);
        }
        if (i10 == 1) {
            return d(carouselLayoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static e d(CarouselLayoutManager carouselLayoutManager) {
        return new a(1, carouselLayoutManager);
    }

    public abstract void a(RectF rectF, RectF rectF2, RectF rectF3);

    public abstract RectF e(float f10, float f11, float f12, float f13);

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract void k(View view, int i10, int i11);

    public abstract void l(RectF rectF, RectF rectF2, RectF rectF3);

    public abstract void m(View view, Rect rect, float f10, float f11);

    public e(int i10) {
        this.f3357a = i10;
    }
}
