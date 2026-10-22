package n1;

import android.animation.TimeInterpolator;
import s.AbstractC0831a;

/* renamed from: n1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0778d {

    /* renamed from: a, reason: collision with root package name */
    public long f13657a;

    /* renamed from: b, reason: collision with root package name */
    public long f13658b;

    /* renamed from: c, reason: collision with root package name */
    public TimeInterpolator f13659c;

    /* renamed from: d, reason: collision with root package name */
    public int f13660d;

    /* renamed from: e, reason: collision with root package name */
    public int f13661e;

    public final TimeInterpolator a() {
        TimeInterpolator timeInterpolator = this.f13659c;
        return timeInterpolator != null ? timeInterpolator : AbstractC0775a.f13651b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0778d)) {
            return false;
        }
        C0778d c0778d = (C0778d) obj;
        if (this.f13657a == c0778d.f13657a && this.f13658b == c0778d.f13658b && this.f13660d == c0778d.f13660d && this.f13661e == c0778d.f13661e) {
            return a().getClass().equals(c0778d.a().getClass());
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f13657a;
        long j5 = this.f13658b;
        return ((((a().getClass().hashCode() + (((((int) (j4 ^ (j4 >>> 32))) * 31) + ((int) ((j5 >>> 32) ^ j5))) * 31)) * 31) + this.f13660d) * 31) + this.f13661e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append(C0778d.class.getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" delay: ");
        sb.append(this.f13657a);
        sb.append(" duration: ");
        sb.append(this.f13658b);
        sb.append(" interpolator: ");
        sb.append(a().getClass());
        sb.append(" repeatCount: ");
        sb.append(this.f13660d);
        sb.append(" repeatMode: ");
        return AbstractC0831a.d(sb, this.f13661e, "}\n");
    }
}
