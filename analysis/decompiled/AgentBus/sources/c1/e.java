package c1;

import k.z;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final d0.e f1793a = new d0.e(new d[16]);

    /* renamed from: b, reason: collision with root package name */
    public final z f1794b = new z(10);

    public boolean a(k.n nVar, g1.k kVar, q6.b bVar, boolean z4) {
        d0.e eVar = this.f1793a;
        Object[] objArr = eVar.f2749f;
        int i2 = eVar.f2751h;
        boolean z10 = false;
        for (int i10 = 0; i10 < i2; i10++) {
            z10 = ((d) objArr[i10]).a(nVar, kVar, bVar, z4) || z10;
        }
        return z10;
    }

    public void b(q6.b bVar) {
        d0.e eVar = this.f1793a;
        int i2 = eVar.f2751h;
        while (true) {
            i2--;
            if (-1 >= i2) {
                return;
            }
            if (((d) eVar.f2749f[i2]).f1786d.f2767g == 0) {
                eVar.j(i2);
            }
        }
    }
}
