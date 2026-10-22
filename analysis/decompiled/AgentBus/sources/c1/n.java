package c1;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final long f1822a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1823b;

    /* renamed from: c, reason: collision with root package name */
    public final long f1824c;

    /* renamed from: d, reason: collision with root package name */
    public final long f1825d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f1826e;

    /* renamed from: f, reason: collision with root package name */
    public final float f1827f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1828g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f1829h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f1830i;

    /* renamed from: j, reason: collision with root package name */
    public final long f1831j;

    /* renamed from: k, reason: collision with root package name */
    public final long f1832k;

    public n(long j2, long j4, long j10, long j11, boolean z4, float f10, int i2, boolean z10, ArrayList arrayList, long j12, long j13) {
        this.f1822a = j2;
        this.f1823b = j4;
        this.f1824c = j10;
        this.f1825d = j11;
        this.f1826e = z4;
        this.f1827f = f10;
        this.f1828g = i2;
        this.f1829h = z10;
        this.f1830i = arrayList;
        this.f1831j = j12;
        this.f1832k = j13;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return k.a(this.f1822a, nVar.f1822a) && this.f1823b == nVar.f1823b && t0.b.b(this.f1824c, nVar.f1824c) && t0.b.b(this.f1825d, nVar.f1825d) && this.f1826e == nVar.f1826e && Float.compare(this.f1827f, nVar.f1827f) == 0 && this.f1828g == nVar.f1828g && this.f1829h == nVar.f1829h && this.f1830i.equals(nVar.f1830i) && t0.b.b(this.f1831j, nVar.f1831j) && t0.b.b(this.f1832k, nVar.f1832k);
    }

    public final int hashCode() {
        return Long.hashCode(this.f1832k) + m.x.f(this.f1831j, (this.f1830i.hashCode() + m.x.e(n.f.b(this.f1828g, m.x.d(this.f1827f, m.x.e(m.x.f(this.f1825d, m.x.f(this.f1824c, m.x.f(this.f1823b, Long.hashCode(this.f1822a) * 31, 31), 31), 31), 31, this.f1826e), 31), 31), 31, this.f1829h)) * 31, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("PointerInputEventData(id=");
        sb2.append((Object) k.b(this.f1822a));
        sb2.append(", uptime=");
        sb2.append(this.f1823b);
        sb2.append(", positionOnScreen=");
        sb2.append((Object) t0.b.i(this.f1824c));
        sb2.append(", position=");
        sb2.append((Object) t0.b.i(this.f1825d));
        sb2.append(", down=");
        sb2.append(this.f1826e);
        sb2.append(", pressure=");
        sb2.append(this.f1827f);
        sb2.append(", type=");
        int i2 = this.f1828g;
        sb2.append((Object) (i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "Unknown" : "Eraser" : "Stylus" : "Mouse" : "Touch"));
        sb2.append(", activeHover=");
        sb2.append(this.f1829h);
        sb2.append(", historical=");
        sb2.append(this.f1830i);
        sb2.append(", scrollDelta=");
        sb2.append((Object) t0.b.i(this.f1831j));
        sb2.append(", originalEventPosition=");
        sb2.append((Object) t0.b.i(this.f1832k));
        sb2.append(')');
        return sb2.toString();
    }
}
