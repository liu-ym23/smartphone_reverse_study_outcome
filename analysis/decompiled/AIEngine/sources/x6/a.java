package x6;

import com.stepos.base.inference.data.BackendType;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final BackendType f13747a;

    /* renamed from: b, reason: collision with root package name */
    public final long f13748b;

    /* renamed from: c, reason: collision with root package name */
    public final float f13749c;

    public a(BackendType backendType, long j10, float f8) {
        this.f13747a = backendType;
        this.f13748b = j10;
        this.f13749c = f8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f13747a == aVar.f13747a && this.f13748b == aVar.f13748b && Float.compare(this.f13749c, aVar.f13749c) == 0 && Float.compare(0.0f, 0.0f) == 0;
    }

    public final int hashCode() {
        return Integer.hashCode(0) + a0.a.a(0.0f, a0.a.a(this.f13749c, a0.a.c(ai.onnxruntime.a.f(this.f13747a.hashCode() * 31, 31, true), this.f13748b, 31), 31), 31);
    }

    public final String toString() {
        return "BackendPerformanceInfo(type=" + this.f13747a + ", available=true, estimatedFirstTokenLatency=" + this.f13748b + ", estimatedThroughput=" + this.f13749c + ", currentLoad=0.0, availableMemoryMb=0)";
    }
}
