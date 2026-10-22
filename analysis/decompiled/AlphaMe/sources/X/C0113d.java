package X;

import android.os.Build;

/* renamed from: X.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0113d extends B0.f {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f2047b;

    public C0113d(e eVar) {
        this.f2047b = eVar;
    }

    @Override // B0.f
    public final void U(Throwable th) {
        ((j) this.f2047b.f12410b).d(th);
    }

    @Override // B0.f
    public final void V(t.d dVar) {
        e eVar = this.f2047b;
        eVar.f2049d = dVar;
        t.d dVar2 = eVar.f2049d;
        Object obj = eVar.f12410b;
        j jVar = (j) obj;
        y1.f fVar = jVar.f2061g;
        C0112c c0112c = jVar.f2063i;
        ((j) obj).getClass();
        eVar.f2048c = new t(dVar2, fVar, c0112c, Build.VERSION.SDK_INT >= 34 ? o.a() : com.airbnb.lottie.h.p());
        ((j) eVar.f12410b).e();
    }
}
