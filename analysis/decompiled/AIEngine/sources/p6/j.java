package p6;

import com.stepos.core.common.util.TraceIdKeys;
import gc.q;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: k, reason: collision with root package name */
    public static final j f11447k = new j(0.0f, 0.0f, 0, 0, 0, 0, 0, false, 0, 1023);

    /* renamed from: a, reason: collision with root package name */
    public final float f11448a;

    /* renamed from: b, reason: collision with root package name */
    public final float f11449b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11450c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11451d;

    /* renamed from: e, reason: collision with root package name */
    public final int f11452e;

    /* renamed from: f, reason: collision with root package name */
    public final int f11453f;

    /* renamed from: g, reason: collision with root package name */
    public final int f11454g;
    public final boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final int f11455i;

    /* renamed from: j, reason: collision with root package name */
    public final Map<String, j> f11456j;

    public j() {
        this(0.0f, 0.0f, 0, 0, 0, 0, 0, false, 0, 1023);
    }

    public final j a(String str) {
        j jVar;
        if (str != null) {
            if (q.t0(str) || str.equals("unknown")) {
                str = null;
            }
            if (str != null && (jVar = this.f11456j.get(str)) != null) {
                return jVar;
            }
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return Float.compare(this.f11448a, jVar.f11448a) == 0 && Float.compare(this.f11449b, jVar.f11449b) == 0 && this.f11450c == jVar.f11450c && this.f11451d == jVar.f11451d && this.f11452e == jVar.f11452e && this.f11453f == jVar.f11453f && this.f11454g == jVar.f11454g && this.h == jVar.h && this.f11455i == jVar.f11455i && kotlin.jvm.internal.g.b(this.f11456j, jVar.f11456j);
    }

    public final int hashCode() {
        return this.f11456j.hashCode() + ai.onnxruntime.a.d(this.f11455i, ai.onnxruntime.a.f(ai.onnxruntime.a.d(this.f11454g, ai.onnxruntime.a.d(this.f11453f, ai.onnxruntime.a.d(this.f11452e, ai.onnxruntime.a.d(this.f11451d, ai.onnxruntime.a.d(this.f11450c, a0.a.a(this.f11449b, Float.hashCode(this.f11448a) * 31, 31), 31), 31), 31), 31), 31), 31, this.h), 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("VadConfig(threshold=");
        sb2.append(this.f11448a);
        sb2.append(", minSpeechRms=");
        sb2.append(this.f11449b);
        sb2.append(", speechStartMs=");
        h0.e.l(sb2, this.f11450c, ", silenceDurationMs=", this.f11451d, ", leadingSilenceTimeoutMs=");
        h0.e.l(sb2, this.f11452e, ", maxDurationMs=", this.f11453f, ", maxDurationCeilingMs=");
        sb2.append(this.f11454g);
        sb2.append(", levelEnabled=");
        sb2.append(this.h);
        sb2.append(", levelIntervalMs=");
        sb2.append(this.f11455i);
        sb2.append(", packageOverride=");
        sb2.append(this.f11456j);
        sb2.append(")");
        return sb2.toString();
    }

    public j(float f8, float f9, int i10, int i11, int i12, int i13, int i14, boolean z, int i15, Map<String, j> map) {
        this.f11448a = f8;
        this.f11449b = f9;
        this.f11450c = i10;
        this.f11451d = i11;
        this.f11452e = i12;
        this.f11453f = i13;
        this.f11454g = i14;
        this.h = z;
        this.f11455i = i15;
        this.f11456j = map;
    }

    public /* synthetic */ j(float f8, float f9, int i10, int i11, int i12, int i13, int i14, boolean z, int i15, int i16) {
        this((i16 & 1) != 0 ? 0.5f : f8, (i16 & 2) != 0 ? 0.01f : f9, (i16 & 4) != 0 ? 32 : i10, (i16 & 8) != 0 ? 800 : i11, (i16 & 16) != 0 ? 5000 : i12, (i16 & 32) != 0 ? 60000 : i13, (i16 & 64) != 0 ? 600000 : i14, (i16 & TraceIdKeys.MAX_LENGTH) != 0 ? false : z, (i16 & 256) != 0 ? 100 : i15, (Map<String, j>) kotlin.collections.b.d0());
    }
}
