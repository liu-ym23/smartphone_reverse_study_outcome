package h1;

import d1.e;
import d1.l;
import f1.d;
import g5.f;
import o2.i;
import u1.i0;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends b {
    public final e i;

    /* renamed from: j, reason: collision with root package name */
    public final long f5272j;

    /* renamed from: k, reason: collision with root package name */
    public int f5273k = 1;

    /* renamed from: l, reason: collision with root package name */
    public final long f5274l;

    /* renamed from: m, reason: collision with root package name */
    public float f5275m;

    /* renamed from: n, reason: collision with root package name */
    public l f5276n;

    public a(e eVar, long j10) {
        int i;
        int i3;
        this.i = eVar;
        this.f5272j = j10;
        if (((int) 0) < 0 || ((int) 0) < 0 || (i = (int) (j10 >> 32)) < 0 || (i3 = (int) (4294967295L & j10)) < 0 || i > eVar.f2966a.getWidth() || i3 > eVar.f2966a.getHeight()) {
            f.s("Failed requirement.");
            throw null;
        }
        this.f5274l = j10;
        this.f5275m = 1.0f;
    }

    @Override // h1.b
    public final void d(float f5) {
        this.f5275m = f5;
    }

    @Override // h1.b
    public final void e(l lVar) {
        this.f5276n = lVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a(this.i, aVar.i) && i.b(0L, 0L) && o2.k.b(this.f5272j, aVar.f5272j) && this.f5273k == aVar.f5273k;
    }

    @Override // h1.b
    public final long h() {
        return ac.a.i0(this.f5274l);
    }

    public final int hashCode() {
        return Integer.hashCode(this.f5273k) + k0.a.i(this.f5272j, k0.a.i(0L, this.i.hashCode() * 31, 31), 31);
    }

    @Override // h1.b
    public final void i(i0 i0Var) {
        f1.b bVar = i0Var.f13838c;
        d.r(i0Var, this.i, this.f5272j, (Math.round(Float.intBitsToFloat((int) (bVar.e() >> 32))) << 32) | (Math.round(Float.intBitsToFloat((int) (bVar.e() & 4294967295L))) & 4294967295L), this.f5275m, this.f5276n, this.f5273k, 328);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BitmapPainter(image=");
        sb2.append(this.i);
        sb2.append(", srcOffset=");
        sb2.append((Object) i.e(0L));
        sb2.append(", srcSize=");
        sb2.append((Object) o2.k.c(this.f5272j));
        sb2.append(", filterQuality=");
        int i = this.f5273k;
        sb2.append((Object) (i == 0 ? "None" : i == 1 ? "Low" : i == 2 ? "Medium" : i == 3 ? "High" : "Unknown"));
        sb2.append(')');
        return sb2.toString();
    }
}
