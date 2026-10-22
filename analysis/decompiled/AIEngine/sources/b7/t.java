package b7;

import com.stepos.base.model.ModelReleaseReason;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface t {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f3121a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3122b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f3123c;

        /* renamed from: d, reason: collision with root package name */
        public final int f3124d;

        /* renamed from: e, reason: collision with root package name */
        public final long f3125e;

        /* renamed from: f, reason: collision with root package name */
        public final long f3126f;

        /* renamed from: g, reason: collision with root package name */
        public final String f3127g;

        public a(String modelId, int i10, boolean z, int i11, long j10, long j11, String backendKey) {
            kotlin.jvm.internal.g.f(modelId, "modelId");
            kotlin.jvm.internal.g.f(backendKey, "backendKey");
            this.f3121a = modelId;
            this.f3122b = i10;
            this.f3123c = z;
            this.f3124d = i11;
            this.f3125e = j10;
            this.f3126f = j11;
            this.f3127g = backendKey;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.g.b(this.f3121a, aVar.f3121a) && this.f3122b == aVar.f3122b && this.f3123c == aVar.f3123c && this.f3124d == aVar.f3124d && this.f3125e == aVar.f3125e && this.f3126f == aVar.f3126f && kotlin.jvm.internal.g.b(this.f3127g, aVar.f3127g);
        }

        public final int hashCode() {
            return this.f3127g.hashCode() + a0.a.c(a0.a.c(ai.onnxruntime.a.d(this.f3124d, ai.onnxruntime.a.f(ai.onnxruntime.a.d(this.f3122b, this.f3121a.hashCode() * 31, 31), 31, this.f3123c), 31), this.f3125e, 31), this.f3126f, 31);
        }

        public final String toString() {
            StringBuilder sbF = h0.e.f("CacheEntry(modelId=", this.f3121a, ", version=", this.f3122b, ", isCurrent=");
            sbF.append(this.f3123c);
            sbF.append(", refCount=");
            sbF.append(this.f3124d);
            sbF.append(", loadedAt=");
            sbF.append(this.f3125e);
            a0.a.s(this.f3126f, ", sizeBytes=", ", backendKey=", sbF);
            return ai.onnxruntime.a.o(sbF, this.f3127g, ")");
        }
    }

    n acquire(String str);

    void deactivate(String str);

    int getCurrentVersion(String str);

    void preload(String str);

    void releaseHandle(String str, int i10, com.stepos.base.model.a aVar, String str2, ModelReleaseReason modelReleaseReason);

    boolean rollback(String str, int i10, String str2);

    List<a> snapshot();

    void switchVersion(String str, int i10, String str2, String str3);
}
