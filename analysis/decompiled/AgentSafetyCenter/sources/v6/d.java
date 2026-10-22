package v6;

import com.google.android.material.carousel.CarouselLayoutManager;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends e {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f14816b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(CarouselLayoutManager carouselLayoutManager) {
        super(0);
        this.f14816b = carouselLayoutManager;
    }

    @Override // v6.e
    public final int a() {
        CarouselLayoutManager carouselLayoutManager = this.f14816b;
        return carouselLayoutManager.getHeight() - carouselLayoutManager.getPaddingBottom();
    }

    @Override // v6.e
    public final int b() {
        return 0;
    }

    @Override // v6.e
    public final int c() {
        return this.f14816b.getWidth();
    }

    @Override // v6.e
    public final int d() {
        CarouselLayoutManager carouselLayoutManager = this.f14816b;
        if (carouselLayoutManager.c()) {
            return carouselLayoutManager.getWidth();
        }
        return 0;
    }

    @Override // v6.e
    public final int e() {
        return this.f14816b.getPaddingTop();
    }
}
