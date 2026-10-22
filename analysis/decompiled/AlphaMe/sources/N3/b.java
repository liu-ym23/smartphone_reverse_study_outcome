package N3;

import W.j;
import android.view.View;

/* loaded from: classes2.dex */
public final class b implements j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f1489a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f1490b;

    public b(d dVar, boolean z4) {
        this.f1490b = dVar;
        this.f1489a = z4;
    }

    @Override // W.j
    public final void a(float f4) {
        d dVar = this.f1490b;
        float translationX = dVar.f1498b.getTranslationX();
        View view = dVar.f1498b;
        dVar.d(translationX, view.getTranslationY());
        dVar.f1495B = this.f1489a ? view.getTranslationY() : view.getTranslationX();
    }
}
