package v6;

import com.google.android.material.carousel.CarouselLayoutManager;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends e {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f14815b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(CarouselLayoutManager carouselLayoutManager) {
        super(1);
        this.f14815b = carouselLayoutManager;
    }

    @Override // v6.e
    public final int a() {
        return this.f14815b.getHeight();
    }

    @Override // v6.e
    public final int b() {
        return this.f14815b.getPaddingLeft();
    }

    @Override // v6.e
    public final int c() {
        CarouselLayoutManager carouselLayoutManager = this.f14815b;
        return carouselLayoutManager.getWidth() - carouselLayoutManager.getPaddingRight();
    }

    @Override // v6.e
    public final int d() {
        return 0;
    }

    @Override // v6.e
    public final int e() {
        return 0;
    }
}
