package q1;

import com.google.android.material.carousel.CarouselLayoutManager;

/* loaded from: classes.dex */
public final class e extends f {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f13992b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(CarouselLayoutManager carouselLayoutManager) {
        super(0);
        this.f13992b = carouselLayoutManager;
    }

    @Override // q1.f
    public final int a() {
        CarouselLayoutManager carouselLayoutManager = this.f13992b;
        return carouselLayoutManager.getHeight() - carouselLayoutManager.getPaddingBottom();
    }

    @Override // q1.f
    public final int b() {
        return 0;
    }

    @Override // q1.f
    public final int c() {
        return this.f13992b.getWidth();
    }

    @Override // q1.f
    public final int d() {
        CarouselLayoutManager carouselLayoutManager = this.f13992b;
        if (carouselLayoutManager.h()) {
            return carouselLayoutManager.getWidth();
        }
        return 0;
    }

    @Override // q1.f
    public final int e() {
        return this.f13992b.getPaddingTop();
    }
}
