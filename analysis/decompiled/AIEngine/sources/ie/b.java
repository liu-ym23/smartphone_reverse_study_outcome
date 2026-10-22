package ie;

import android.view.ViewGroup;
import h1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements d.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f9594a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f9595b;

    public b(d dVar, boolean z) {
        this.f9595b = dVar;
        this.f9594a = z;
    }

    @Override // h1.d.l
    public final void a(float f8) {
        d dVar = this.f9595b;
        ViewGroup viewGroup = dVar.f9598b;
        dVar.d(viewGroup.getTranslationX(), viewGroup.getTranslationY());
        dVar.B = this.f9594a ? viewGroup.getTranslationY() : viewGroup.getTranslationX();
    }
}
