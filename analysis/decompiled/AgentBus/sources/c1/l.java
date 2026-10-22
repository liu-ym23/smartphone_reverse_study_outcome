package c1;

import d7.z;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final long f1804a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1805b;

    /* renamed from: c, reason: collision with root package name */
    public final long f1806c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f1807d;

    /* renamed from: e, reason: collision with root package name */
    public final float f1808e;

    /* renamed from: f, reason: collision with root package name */
    public final long f1809f;

    /* renamed from: g, reason: collision with root package name */
    public final long f1810g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f1811h;

    /* renamed from: i, reason: collision with root package name */
    public final int f1812i;

    /* renamed from: j, reason: collision with root package name */
    public final long f1813j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f1814k;

    /* renamed from: l, reason: collision with root package name */
    public final long f1815l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1816m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1817n;

    /* renamed from: o, reason: collision with root package name */
    public l f1818o;

    public l(long j2, long j4, long j10, boolean z4, float f10, long j11, long j12, boolean z10, boolean z11, int i2, long j13) {
        this.f1804a = j2;
        this.f1805b = j4;
        this.f1806c = j10;
        this.f1807d = z4;
        this.f1808e = f10;
        this.f1809f = j11;
        this.f1810g = j12;
        this.f1811h = z10;
        this.f1812i = i2;
        this.f1813j = j13;
        this.f1815l = 0L;
        this.f1816m = z11;
        this.f1817n = z11;
    }

    public final void a() {
        l lVar = this.f1818o;
        if (lVar == null) {
            this.f1816m = true;
            this.f1817n = true;
        } else if (lVar != null) {
            lVar.a();
        }
    }

    public final boolean b() {
        l lVar = this.f1818o;
        return lVar != null ? lVar.b() : this.f1816m || this.f1817n;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("PointerInputChange(id=");
        sb2.append((Object) k.b(this.f1804a));
        sb2.append(", uptimeMillis=");
        sb2.append(this.f1805b);
        sb2.append(", position=");
        sb2.append((Object) t0.b.i(this.f1806c));
        sb2.append(", pressed=");
        sb2.append(this.f1807d);
        sb2.append(", pressure=");
        sb2.append(this.f1808e);
        sb2.append(", previousUptimeMillis=");
        sb2.append(this.f1809f);
        sb2.append(", previousPosition=");
        sb2.append((Object) t0.b.i(this.f1810g));
        sb2.append(", previousPressed=");
        sb2.append(this.f1811h);
        sb2.append(", isConsumed=");
        sb2.append(b());
        sb2.append(", type=");
        int i2 = this.f1812i;
        sb2.append((Object) (i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "Unknown" : "Eraser" : "Stylus" : "Mouse" : "Touch"));
        sb2.append(", historical=");
        Object obj = this.f1814k;
        if (obj == null) {
            obj = z.f2978f;
        }
        sb2.append(obj);
        sb2.append(",scrollDelta=");
        sb2.append((Object) t0.b.i(this.f1813j));
        sb2.append(')');
        return sb2.toString();
    }

    public l(long j2, long j4, long j10, boolean z4, float f10, long j11, long j12, boolean z10, int i2, ArrayList arrayList, long j13, long j14) {
        this(j2, j4, j10, z4, f10, j11, j12, z10, false, i2, j13);
        this.f1814k = arrayList;
        this.f1815l = j14;
    }
}
