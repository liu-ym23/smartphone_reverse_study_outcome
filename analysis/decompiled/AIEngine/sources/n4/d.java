package n4;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d extends f {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f10628b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(CarouselLayoutManager carouselLayoutManager) {
        super(1);
        this.f10628b = carouselLayoutManager;
    }

    @Override // n4.f
    public final void a(RectF rectF, RectF rectF2, RectF rectF3) {
        float f8 = rectF2.top;
        float f9 = rectF3.top;
        if (f8 < f9 && rectF2.bottom > f9) {
            float f10 = f9 - f8;
            rectF.top += f10;
            rectF3.top += f10;
        }
        float f11 = rectF2.bottom;
        float f12 = rectF3.bottom;
        if (f11 <= f12 || rectF2.top >= f12) {
            return;
        }
        float f13 = f11 - f12;
        rectF.bottom = Math.max(rectF.bottom - f13, rectF.top);
        rectF2.bottom = Math.max(rectF2.bottom - f13, rectF2.top);
    }

    @Override // n4.f
    public final RectF b(float f8, float f9, float f10, float f11) {
        return new RectF(0.0f, f10, f9, f8 - f10);
    }

    @Override // n4.f
    public final int c() {
        return this.f10628b.getHeight();
    }

    @Override // n4.f
    public final int d() {
        return this.f10628b.getPaddingLeft();
    }

    @Override // n4.f
    public final int e() {
        CarouselLayoutManager carouselLayoutManager = this.f10628b;
        return carouselLayoutManager.getWidth() - carouselLayoutManager.getPaddingRight();
    }

    @Override // n4.f
    public final int f() {
        return 0;
    }

    @Override // n4.f
    public final int g() {
        return 0;
    }

    @Override // n4.f
    public final void h(View view, int i10, int i11) {
        CarouselLayoutManager carouselLayoutManager = this.f10628b;
        int paddingLeft = carouselLayoutManager.getPaddingLeft();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        carouselLayoutManager.layoutDecoratedWithMargins(view, paddingLeft, i10, carouselLayoutManager.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + paddingLeft, i11);
    }

    @Override // n4.f
    public final void i(RectF rectF, RectF rectF2, RectF rectF3) {
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

    @Override // n4.f
    public final void j(View view, Rect rect, float f8, float f9) {
        view.offsetTopAndBottom((int) (f9 - (rect.top + f8)));
    }
}
