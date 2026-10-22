package k1;

import com.google.android.material.carousel.CarouselLayoutManager;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f3543a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3544b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f3545c;

    public c(int i8) {
        this.f3543a = i8;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(CarouselLayoutManager carouselLayoutManager, int i8) {
        this(1);
        this.f3544b = i8;
        switch (i8) {
            case 1:
                this.f3545c = carouselLayoutManager;
                this(0);
                break;
            default:
                this.f3545c = carouselLayoutManager;
                break;
        }
    }
}
