package l4;

import android.animation.TimeInterpolator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public long f10227a;

    /* renamed from: c, reason: collision with root package name */
    public TimeInterpolator f10229c = null;

    /* renamed from: d, reason: collision with root package name */
    public int f10230d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f10231e = 1;

    /* renamed from: b, reason: collision with root package name */
    public long f10228b = 150;

    public d(long j10) {
        this.f10227a = j10;
    }

    public final TimeInterpolator a() {
        TimeInterpolator timeInterpolator = this.f10229c;
        return timeInterpolator != null ? timeInterpolator : a.f10221b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f10227a == dVar.f10227a && this.f10228b == dVar.f10228b && this.f10230d == dVar.f10230d && this.f10231e == dVar.f10231e) {
            return a().getClass().equals(dVar.a().getClass());
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f10227a;
        long j11 = this.f10228b;
        return ((((a().getClass().hashCode() + (((((int) (j10 ^ (j10 >>> 32))) * 31) + ((int) ((j11 >>> 32) ^ j11))) * 31)) * 31) + this.f10230d) * 31) + this.f10231e;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("\n");
        sb2.append(d.class.getName());
        sb2.append('{');
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" delay: ");
        sb2.append(this.f10227a);
        sb2.append(" duration: ");
        sb2.append(this.f10228b);
        sb2.append(" interpolator: ");
        sb2.append(a().getClass());
        sb2.append(" repeatCount: ");
        sb2.append(this.f10230d);
        sb2.append(" repeatMode: ");
        return ai.onnxruntime.a.j("}\n", this.f10231e, sb2);
    }
}
