package x6;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface b {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f13750a;

        /* renamed from: b, reason: collision with root package name */
        public final long f13751b;

        /* renamed from: c, reason: collision with root package name */
        public final long f13752c;

        /* renamed from: d, reason: collision with root package name */
        public final long f13753d;

        /* renamed from: e, reason: collision with root package name */
        public final int f13754e;

        public a(long j10, long j11, long j12, long j13, int i10) {
            this.f13750a = j10;
            this.f13751b = j11;
            this.f13752c = j12;
            this.f13753d = j13;
            this.f13754e = i10;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f13750a == aVar.f13750a && this.f13751b == aVar.f13751b && this.f13752c == aVar.f13752c && this.f13753d == aVar.f13753d && this.f13754e == aVar.f13754e;
        }

        public final int hashCode() {
            return Integer.hashCode(this.f13754e) + a0.a.c(a0.a.c(a0.a.c(Long.hashCode(this.f13750a) * 31, this.f13751b, 31), this.f13752c, 31), this.f13753d, 31);
        }

        public final String toString() {
            StringBuilder sbQ = ai.onnxruntime.a.q(this.f13750a, "ExecutorStatistics(totalInferences=", ", successfulInferences=");
            sbQ.append(this.f13751b);
            a0.a.s(this.f13752c, ", failedInferences=", ", averageLatencyMs=", sbQ);
            sbQ.append(this.f13753d);
            sbQ.append(", runningTaskCount=");
            sbQ.append(this.f13754e);
            sbQ.append(")");
            return sbQ.toString();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: x6.b$b, reason: collision with other inner class name */
    public interface InterfaceC0168b {
        void d();

        void onComplete();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface c {
        void onComplete(y6.c cVar);

        void onDropAfterCancel(int i10);

        void onError(int i10, String str);

        void onError(int i10, String str, Throwable th);

        void onOutput(Object obj);
    }

    void executeStream(String str, long j10, Object obj, r6.a aVar, c cVar);
}
