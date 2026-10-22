package e1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f3339a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3340b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3341c;

    public c(String str, long j10, int i) {
        this.f3339a = str;
        this.f3340b = j10;
        this.f3341c = i;
        if (str.length() == 0) {
            g5.f.s("The name of a color space cannot be null and must contain at least 1 character");
            throw null;
        }
        if (i < -1 || i > 63) {
            g5.f.s("The id must be between -1 and 63");
            throw null;
        }
    }

    public abstract float a(int i);

    public abstract float b(int i);

    public boolean c() {
        return false;
    }

    public abstract long d(float f5, float f10, float f11);

    public abstract float e(float f5, float f10, float f11);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f3341c == cVar.f3341c && this.f3339a.equals(cVar.f3339a)) {
            return b.a(this.f3340b, cVar.f3340b);
        }
        return false;
    }

    public abstract long f(float f5, float f10, float f11, float f12, c cVar);

    public int hashCode() {
        int iHashCode = this.f3339a.hashCode() * 31;
        int i = b.f3338e;
        return k0.a.i(this.f3340b, iHashCode, 31) + this.f3341c;
    }

    public final String toString() {
        return this.f3339a + " (id=" + this.f3341c + ", model=" + ((Object) b.b(this.f3340b)) + ')';
    }
}
