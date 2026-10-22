package s0;

import m0.f;
import n0.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e.a f11827a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11828b;

    public a(e.a aVar, int i10) {
        this.f11827a = aVar;
        this.f11828b = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.c cVar = this.f11827a.f10598c;
        if (cVar != null) {
            cVar.b(this.f11828b);
        }
    }
}
