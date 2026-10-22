package U2;

import com.google.android.material.carousel.CarouselLayoutManager;

/* loaded from: classes3.dex */
public final class e extends f {
    public final /* synthetic */ CarouselLayoutManager b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(CarouselLayoutManager carouselLayoutManager) {
        super(0);
        this.b = carouselLayoutManager;
    }

    @Override // U2.f
    public final int a() {
        CarouselLayoutManager carouselLayoutManager = this.b;
        return carouselLayoutManager.getHeight() - carouselLayoutManager.getPaddingBottom();
    }

    @Override // U2.f
    public final int b() {
        return 0;
    }

    @Override // U2.f
    public final int c() {
        return this.b.getWidth();
    }

    @Override // U2.f
    public final int d() {
        CarouselLayoutManager carouselLayoutManager = this.b;
        if (carouselLayoutManager.c()) {
            return carouselLayoutManager.getWidth();
        }
        return 0;
    }

    @Override // U2.f
    public final int e() {
        return this.b.getPaddingTop();
    }
}
