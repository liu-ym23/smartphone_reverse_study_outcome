package Q2;

import android.animation.TimeInterpolator;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public long f1099a;
    public long b;
    public TimeInterpolator c;
    public int d;
    public int e;

    public final TimeInterpolator a() {
        TimeInterpolator timeInterpolator = this.c;
        return timeInterpolator != null ? timeInterpolator : a.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f1099a == dVar.f1099a && this.b == dVar.b && this.d == dVar.d && this.e == dVar.e) {
            return a().getClass().equals(dVar.a().getClass());
        }
        return false;
    }

    public final int hashCode() {
        long j5 = this.f1099a;
        long j6 = this.b;
        return ((((a().getClass().hashCode() + (((((int) (j5 ^ (j5 >>> 32))) * 31) + ((int) ((j6 >>> 32) ^ j6))) * 31)) * 31) + this.d) * 31) + this.e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append(d.class.getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" delay: ");
        sb.append(this.f1099a);
        sb.append(" duration: ");
        sb.append(this.b);
        sb.append(" interpolator: ");
        sb.append(a().getClass());
        sb.append(" repeatCount: ");
        sb.append(this.d);
        sb.append(" repeatMode: ");
        return androidx.appfunctions.metadata.a.o(sb, "}\n", this.e);
    }
}
