package stepos.support.v7.app;

import stepos.support.v7.widget.PopupNestedScrollingLayout;

/* loaded from: classes2.dex */
public final class H implements W.j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14280a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ I f14281b;

    public /* synthetic */ H(I i4, int i5) {
        this.f14280a = i5;
        this.f14281b = i4;
    }

    @Override // W.j
    public final void a(float f4) {
        int i4 = this.f14280a;
        I i5 = this.f14281b;
        switch (i4) {
            case 0:
                PopupNestedScrollingLayout popupNestedScrollingLayout = i5.f14284b;
                popupNestedScrollingLayout.h(((int) f4) - popupNestedScrollingLayout.f14885p);
                break;
            default:
                float f5 = f4 / 100.0f;
                i5.f14284b.setScaleX(f5);
                i5.f14284b.setScaleY(f5);
                break;
        }
    }
}
