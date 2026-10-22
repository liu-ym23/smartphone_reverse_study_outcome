package t1;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f9673a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9674b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f9675c;

    public c(int i2, int i10, boolean z4) {
        this.f9673a = i2;
        this.f9674b = i10;
        this.f9675c = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f9673a == cVar.f9673a && this.f9674b == cVar.f9674b && this.f9675c == cVar.f9675c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f9675c) + n.f.b(this.f9674b, Integer.hashCode(this.f9673a) * 31, 31);
    }

    public final String toString() {
        return "BidiRun(start=" + this.f9673a + ", end=" + this.f9674b + ", isRtl=" + this.f9675c + ')';
    }
}
