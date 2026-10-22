package U2;

import com.google.android.material.carousel.CarouselLayoutManager;

/* loaded from: classes3.dex */
public final class d extends f {
    public final /* synthetic */ CarouselLayoutManager b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(CarouselLayoutManager carouselLayoutManager) {
        super(1);
        this.b = carouselLayoutManager;
    }

    @Override // U2.f
    public final int a() {
        return this.b.getHeight();
    }

    @Override // U2.f
    public final int b() {
        return this.b.getPaddingLeft();
    }

    @Override // U2.f
    public final int c() {
        CarouselLayoutManager carouselLayoutManager = this.b;
        return carouselLayoutManager.getWidth() - carouselLayoutManager.getPaddingRight();
    }

    @Override // U2.f
    public final int d() {
        return 0;
    }

    @Override // U2.f
    public final int e() {
        return 0;
    }
}
