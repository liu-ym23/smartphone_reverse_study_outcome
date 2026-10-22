package t0;

import m.x;
import n7.o;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final float f9660a;

    /* renamed from: b, reason: collision with root package name */
    public final float f9661b;

    /* renamed from: c, reason: collision with root package name */
    public final float f9662c;

    /* renamed from: d, reason: collision with root package name */
    public final float f9663d;

    /* renamed from: e, reason: collision with root package name */
    public final long f9664e;

    /* renamed from: f, reason: collision with root package name */
    public final long f9665f;

    /* renamed from: g, reason: collision with root package name */
    public final long f9666g;

    /* renamed from: h, reason: collision with root package name */
    public final long f9667h;

    static {
        o.c(0.0f, 0.0f, 0.0f, 0.0f, 0L);
    }

    public d(float f10, float f11, float f12, float f13, long j2, long j4, long j10, long j11) {
        this.f9660a = f10;
        this.f9661b = f11;
        this.f9662c = f12;
        this.f9663d = f13;
        this.f9664e = j2;
        this.f9665f = j4;
        this.f9666g = j10;
        this.f9667h = j11;
    }

    public final float a() {
        return this.f9663d - this.f9661b;
    }

    public final float b() {
        return this.f9662c - this.f9660a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Float.compare(this.f9660a, dVar.f9660a) == 0 && Float.compare(this.f9661b, dVar.f9661b) == 0 && Float.compare(this.f9662c, dVar.f9662c) == 0 && Float.compare(this.f9663d, dVar.f9663d) == 0 && o.l(this.f9664e, dVar.f9664e) && o.l(this.f9665f, dVar.f9665f) && o.l(this.f9666g, dVar.f9666g) && o.l(this.f9667h, dVar.f9667h);
    }

    public final int hashCode() {
        return Long.hashCode(this.f9667h) + x.f(this.f9666g, x.f(this.f9665f, x.f(this.f9664e, x.d(this.f9663d, x.d(this.f9662c, x.d(this.f9661b, Float.hashCode(this.f9660a) * 31, 31), 31), 31), 31), 31), 31);
    }

    public final String toString() {
        String str = n7.a.D(this.f9660a) + ", " + n7.a.D(this.f9661b) + ", " + n7.a.D(this.f9662c) + ", " + n7.a.D(this.f9663d);
        long j2 = this.f9664e;
        long j4 = this.f9665f;
        boolean zL = o.l(j2, j4);
        long j10 = this.f9666g;
        long j11 = this.f9667h;
        if (!zL || !o.l(j4, j10) || !o.l(j10, j11)) {
            return "RoundRect(rect=" + str + ", topLeft=" + ((Object) o.E(j2)) + ", topRight=" + ((Object) o.E(j4)) + ", bottomRight=" + ((Object) o.E(j10)) + ", bottomLeft=" + ((Object) o.E(j11)) + ')';
        }
        int i2 = (int) (j2 >> 32);
        int i10 = (int) (j2 & 4294967295L);
        if (Float.intBitsToFloat(i2) == Float.intBitsToFloat(i10)) {
            return "RoundRect(rect=" + str + ", radius=" + n7.a.D(Float.intBitsToFloat(i2)) + ')';
        }
        return "RoundRect(rect=" + str + ", x=" + n7.a.D(Float.intBitsToFloat(i2)) + ", y=" + n7.a.D(Float.intBitsToFloat(i10)) + ')';
    }
}
