package aa;

import android.view.View;
import com.google.android.material.carousel.CarouselLayoutManager;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f323a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f324b;

    public /* synthetic */ i(int i) {
        this.f323a = i;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i3, int i10, int i11, int i12, int i13, int i14, int i15) {
        o oVar;
        int i16 = this.f323a;
        Object obj = this.f324b;
        switch (i16) {
            case 0:
                n nVar = (n) obj;
                if ((view.getWidth() != i14 - i12 || view.getHeight() != i15 - i13) && (oVar = nVar.f336g) != null) {
                    nVar.d(td.h.k(oVar));
                    break;
                }
                break;
            default:
                CarouselLayoutManager carouselLayoutManager = (CarouselLayoutManager) obj;
                if (i10 - i != i14 - i12 || i11 - i3 != i15 - i13) {
                    a4.t tVar = new a4.t(26);
                    tVar.f200f = carouselLayoutManager;
                    VarHandle.storeStoreFence();
                    view.post(tVar);
                    break;
                }
                break;
        }
    }
}
