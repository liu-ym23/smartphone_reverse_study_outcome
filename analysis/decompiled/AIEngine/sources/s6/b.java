package s6;

import com.stepos.core.ability.speech.AsrFilePcmSegmentPolicy;
import com.stepos.core.ability.speech.TtsCloudConfig;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f11894a;

    /* renamed from: b, reason: collision with root package name */
    public final long f11895b;

    /* renamed from: c, reason: collision with root package name */
    public final long f11896c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static b a(long j10) {
            long jB = b(j10);
            long jMin = Math.min(7200000L, Math.max(600000L, b(j10) * 2));
            return new b(jB, jMin, AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS + jB + jMin);
        }

        public static long b(long j10) {
            return 1000 * (j10 <= 4194304 ? 30L : j10 <= 8388608 ? 60L : j10 <= 41943040 ? 300L : j10 <= 83886080 ? 600L : j10 <= 167772160 ? 1200L : j10 <= 251658240 ? TtsCloudConfig.DEFAULT_TAIL_SILENCE_PAD_MS : j10 <= 377487360 ? 2700L : j10 <= 503316480 ? 3600L : 4500L);
        }
    }

    public b(long j10, long j11, long j12) {
        this.f11894a = j10;
        this.f11895b = j11;
        this.f11896c = j12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f11894a == bVar.f11894a && this.f11895b == bVar.f11895b && this.f11896c == bVar.f11896c;
    }

    public final int hashCode() {
        return Long.hashCode(this.f11896c) + a0.a.c(Long.hashCode(this.f11894a) * 31, this.f11895b, 31);
    }

    public final String toString() {
        StringBuilder sbQ = ai.onnxruntime.a.q(this.f11894a, "CloudTimeoutBudget(uploadMs=", ", pollMs=");
        sbQ.append(this.f11895b);
        return a0.a.d(this.f11896c, ", e2eMs=", ")", sbQ);
    }
}
