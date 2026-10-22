package n4;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends f {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f10629b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(CarouselLayoutManager carouselLayoutManager) {
        super(0);
        this.f10629b = carouselLayoutManager;
    }

    @Override // n4.f
    public final void a(RectF rectF, RectF rectF2, RectF rectF3) {
        float f8 = rectF2.left;
        float f9 = rectF3.left;
        if (f8 < f9 && rectF2.right > f9) {
            float f10 = f9 - f8;
            rectF.left += f10;
            rectF2.left += f10;
        }
        float f11 = rectF2.right;
        float f12 = rectF3.right;
        if (f11 <= f12 || rectF2.left >= f12) {
            return;
        }
        float f13 = f11 - f12;
        rectF.right = Math.max(rectF.right - f13, rectF.left);
        rectF2.right = Math.max(rectF2.right - f13, rectF2.left);
    }

    @Override // n4.f
    public final RectF b(float f8, float f9, float f10, float f11) {
        return new RectF(f11, 0.0f, f9 - f11, f8);
    }

    @Override // n4.f
    public final int c() {
        CarouselLayoutManager carouselLayoutManager = this.f10629b;
        return carouselLayoutManager.getHeight() - carouselLayoutManager.getPaddingBottom();
    }

    @Override // n4.f
    public final int d() {
        return 0;
    }

    @Override // n4.f
    public final int e() {
        return this.f10629b.getWidth();
    }

    @Override // n4.f
    public final int f() {
        CarouselLayoutManager carouselLayoutManager = this.f10629b;
        if (carouselLayoutManager.n()) {
            return carouselLayoutManager.getWidth();
        }
        return 0;
    }

    @Override // n4.f
    public final int g() {
        return this.f10629b.getPaddingTop();
    }

    @Override // n4.f
    public final void h(View view, int i10, int i11) {
        CarouselLayoutManager carouselLayoutManager = this.f10629b;
        int paddingTop = carouselLayoutManager.getPaddingTop();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        carouselLayoutManager.layoutDecoratedWithMargins(view, i10, paddingTop, i11, carouselLayoutManager.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + paddingTop);
    }

    @Override // n4.f
    public final void i(RectF rectF, RectF rectF2, RectF rectF3) {
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

    @Override // n4.f
    public final void j(View view, Rect rect, float f8, float f9) {
        view.offsetLeftAndRight((int) (f9 - (rect.left + f8)));
    }
}
