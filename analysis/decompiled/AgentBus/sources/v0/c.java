package v0;

import m.x;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f10269a;

    /* renamed from: b, reason: collision with root package name */
    public final long f10270b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10271c;

    public c(String str, long j2, int i2) {
        this.f10269a = str;
        this.f10270b = j2;
        this.f10271c = i2;
        if (str.length() == 0) {
            throw new IllegalArgumentException("The name of a color space cannot be null and must contain at least 1 character");
        }
        if (i2 < -1 || i2 > 63) {
            throw new IllegalArgumentException("The id must be between -1 and 63");
        }
    }

    public abstract float a(int i2);

    public abstract float b(int i2);

    public boolean c() {
        return false;
    }

    public abstract long d(float f10, float f11, float f12);

    public abstract float e(float f10, float f11, float f12);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f10271c == cVar.f10271c && q7.k.a(this.f10269a, cVar.f10269a)) {
            return b.a(this.f10270b, cVar.f10270b);
        }
        return false;
    }

    public abstract long f(float f10, float f11, float f12, float f13, c cVar);

    public int hashCode() {
        int iHashCode = this.f10269a.hashCode() * 31;
        int i2 = b.f10268e;
        return x.f(this.f10270b, iHashCode, 31) + this.f10271c;
    }

    public final String toString() {
        return this.f10269a + " (id=" + this.f10271c + ", model=" + ((Object) b.b(this.f10270b)) + ')';
    }
}
