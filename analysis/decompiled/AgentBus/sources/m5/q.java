package m5;

import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final long f6442a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f6443b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f6444c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f6445d;

    public q(long j2, LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2, LinkedHashMap linkedHashMap3) {
        this.f6442a = j2;
        this.f6443b = linkedHashMap;
        this.f6444c = linkedHashMap2;
        this.f6445d = linkedHashMap3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f6442a == qVar.f6442a && this.f6443b.equals(qVar.f6443b) && this.f6444c.equals(qVar.f6444c) && this.f6445d.equals(qVar.f6445d);
    }

    public final int hashCode() {
        return this.f6445d.hashCode() + ((this.f6444c.hashCode() + ((this.f6443b.hashCode() + (Long.hashCode(this.f6442a) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "MetricsSnapshot(timestamp=" + this.f6442a + ", counters=" + this.f6443b + ", gauges=" + this.f6444c + ", histograms=" + this.f6445d + ")";
    }
}
