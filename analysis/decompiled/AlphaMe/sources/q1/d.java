package q1;

import com.google.android.material.carousel.CarouselLayoutManager;

/* loaded from: classes.dex */
public final class d extends f {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f13991b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(CarouselLayoutManager carouselLayoutManager) {
        super(1);
        this.f13991b = carouselLayoutManager;
    }

    @Override // q1.f
    public final int a() {
        return this.f13991b.getHeight();
    }

    @Override // q1.f
    public final int b() {
        return this.f13991b.getPaddingLeft();
    }

    @Override // q1.f
    public final int c() {
        CarouselLayoutManager carouselLayoutManager = this.f13991b;
        return carouselLayoutManager.getWidth() - carouselLayoutManager.getPaddingRight();
    }

    @Override // q1.f
    public final int d() {
        return 0;
    }

    @Override // q1.f
    public final int e() {
        return 0;
    }
}
