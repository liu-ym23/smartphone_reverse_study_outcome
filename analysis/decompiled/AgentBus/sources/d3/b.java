package d3;

import m.x;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f2802a;

    /* renamed from: b, reason: collision with root package name */
    public final float f2803b;

    /* renamed from: c, reason: collision with root package name */
    public final float f2804c;

    /* renamed from: d, reason: collision with root package name */
    public final float f2805d;

    /* renamed from: e, reason: collision with root package name */
    public final long f2806e;

    public b(int i2, float f10, float f11, float f12, long j2) {
        this.f2802a = i2;
        this.f2803b = f10;
        this.f2804c = f11;
        this.f2805d = f12;
        this.f2806e = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            return this.f2804c == bVar.f2804c && this.f2805d == bVar.f2805d && this.f2803b == bVar.f2803b && this.f2802a == bVar.f2802a && this.f2806e == bVar.f2806e;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f2806e) + n.f.b(this.f2802a, x.d(this.f2803b, x.d(this.f2805d, Float.hashCode(this.f2804c) * 31, 31), 31), 31);
    }

    public final String toString() {
        return "NavigationEvent(touchX=" + this.f2804c + ", touchY=" + this.f2805d + ", progress=" + this.f2803b + ", swipeEdge=" + this.f2802a + ", frameTimeMillis=" + this.f2806e + ')';
    }
}
