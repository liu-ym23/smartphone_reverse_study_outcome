package w5;

import y.k0;

/* loaded from: classes.dex */
public final class w implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f10769f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f10770g;

    public w(String str, long j2) {
        this.f10769f = str;
        this.f10770g = j2;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        b0.p pVar = (b0.p) obj;
        if ((((Number) obj2).intValue() & 3) == 2 && pVar.z()) {
            pVar.O();
        } else {
            k0.a(this.f10769f, androidx.compose.foundation.layout.a.e(n0.j.f6796a, 6, 2), this.f10770g, s7.a.z(10), v1.k.f10359i, null, 0L, 0L, 0, false, 0, 0, null, pVar, 199728, 0, 131024);
        }
        return c7.r.f1986a;
    }
}
