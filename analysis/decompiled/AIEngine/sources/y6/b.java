package y6;

import com.stepos.base.inference.data.BackendType;
import com.stepos.core.ability.speech.AsrFilePcmSegmentPolicy;
import com.stepos.core.ability.speech.TtsCloudConfig;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.ota.download.control.HysteresisStrategy;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final BackendType f14133a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14134b;

    /* renamed from: c, reason: collision with root package name */
    public final long f14135c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f14136d;

    /* renamed from: e, reason: collision with root package name */
    public final int f14137e;

    /* renamed from: f, reason: collision with root package name */
    public final float f14138f;

    /* renamed from: g, reason: collision with root package name */
    public final float f14139g;
    public final int h;

    /* renamed from: i, reason: collision with root package name */
    public final float f14140i;

    /* renamed from: j, reason: collision with root package name */
    public final int f14141j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f14142k;

    /* renamed from: l, reason: collision with root package name */
    public final int f14143l;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public BackendType f14144a = BackendType.f6254d;

        /* renamed from: b, reason: collision with root package name */
        public int f14145b = 4;

        /* renamed from: c, reason: collision with root package name */
        public long f14146c = AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS;

        /* renamed from: d, reason: collision with root package name */
        public boolean f14147d = true;

        /* renamed from: e, reason: collision with root package name */
        public final int f14148e = 2048;

        /* renamed from: f, reason: collision with root package name */
        public final float f14149f = 0.7f;

        /* renamed from: g, reason: collision with root package name */
        public final float f14150g = 0.9f;
        public final int h = 40;

        /* renamed from: i, reason: collision with root package name */
        public final float f14151i = 1.1f;

        /* renamed from: j, reason: collision with root package name */
        public final int f14152j = 4096;

        /* renamed from: k, reason: collision with root package name */
        public final boolean f14153k = true;

        /* renamed from: l, reason: collision with root package name */
        public final int f14154l = 1;
    }

    static {
        new b(null, 0, 0L, 0, 4095);
        BackendType backendType = BackendType.f6254d;
        int i10 = 4072;
        long j10 = HysteresisStrategy.DEFAULT_DWELL_MS;
        new b(backendType, 6, j10, 4096, i10);
        new b(backendType, 4, TtsCloudConfig.DEFAULT_AUDIO_DONE_IDLE_WATCHDOG_MS, VadSessionManager.FRAME_BYTES, 4064);
        new b(BackendType.f6256j, 2, j10, 1024, i10);
    }

    public b(BackendType backend, int i10, long j10, boolean z, int i11, float f8, float f9, int i12, float f10, int i13, boolean z3, int i14) {
        g.f(backend, "backend");
        this.f14133a = backend;
        this.f14134b = i10;
        this.f14135c = j10;
        this.f14136d = z;
        this.f14137e = i11;
        this.f14138f = f8;
        this.f14139g = f9;
        this.h = i12;
        this.f14140i = f10;
        this.f14141j = i13;
        this.f14142k = z3;
        this.f14143l = i14;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f14133a == bVar.f14133a && this.f14134b == bVar.f14134b && this.f14135c == bVar.f14135c && this.f14136d == bVar.f14136d && this.f14137e == bVar.f14137e && Float.compare(this.f14138f, bVar.f14138f) == 0 && Float.compare(this.f14139g, bVar.f14139g) == 0 && this.h == bVar.h && Float.compare(this.f14140i, bVar.f14140i) == 0 && this.f14141j == bVar.f14141j && this.f14142k == bVar.f14142k && this.f14143l == bVar.f14143l;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f14143l) + ai.onnxruntime.a.f(ai.onnxruntime.a.d(this.f14141j, a0.a.a(this.f14140i, ai.onnxruntime.a.d(this.h, a0.a.a(this.f14139g, a0.a.a(this.f14138f, ai.onnxruntime.a.d(this.f14137e, ai.onnxruntime.a.f(a0.a.c(ai.onnxruntime.a.d(this.f14134b, this.f14133a.hashCode() * 31, 31), this.f14135c, 31), 31, this.f14136d), 31), 31), 31), 31), 31), 31), 31, this.f14142k);
    }

    public final String toString() {
        return "InferenceOptions(backend=" + this.f14133a + ", threadCount=" + this.f14134b + ", timeout=" + this.f14135c + ", streaming=" + this.f14136d + ", maxTokens=" + this.f14137e + ", temperature=" + this.f14138f + ", topP=" + this.f14139g + ", topK=" + this.h + ", repeatPenalty=" + this.f14140i + ", contextLength=" + this.f14141j + ", enableKvCache=" + this.f14142k + ", batchSize=" + this.f14143l + ")";
    }

    public /* synthetic */ b(BackendType backendType, int i10, long j10, int i11, int i12) {
        this((i12 & 1) != 0 ? BackendType.f6254d : backendType, (i12 & 2) != 0 ? 4 : i10, (i12 & 4) != 0 ? 30000L : j10, true, (i12 & 16) != 0 ? 2048 : i11, 0.7f, 0.9f, 40, 1.1f, 4096, true, 1);
    }
}
