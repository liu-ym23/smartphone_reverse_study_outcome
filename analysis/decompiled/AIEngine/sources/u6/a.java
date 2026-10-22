package u6;

import h0.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f13165a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13166b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13167c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13168d;

    /* renamed from: e, reason: collision with root package name */
    public final int f13169e;

    /* renamed from: f, reason: collision with root package name */
    public final long f13170f;

    public a(String str, String modelId, int i10, int i11, int i12, long j10) {
        g.f(modelId, "modelId");
        this.f13165a = str;
        this.f13166b = modelId;
        this.f13167c = i10;
        this.f13168d = i11;
        this.f13169e = i12;
        this.f13170f = j10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f13165a.equals(aVar.f13165a) && g.b(this.f13166b, aVar.f13166b) && this.f13167c == aVar.f13167c && this.f13168d == aVar.f13168d && this.f13169e == aVar.f13169e && this.f13170f == aVar.f13170f;
    }

    public final int hashCode() {
        return Long.hashCode(0L) + a0.a.c(ai.onnxruntime.a.d(this.f13169e, ai.onnxruntime.a.d(this.f13168d, ai.onnxruntime.a.d(this.f13167c, d.a(this.f13165a.hashCode() * 31, 31, this.f13166b), 31), 31), 31), this.f13170f, 31);
    }

    public final String toString() {
        StringBuilder sbS = ai.onnxruntime.a.s("CrashMarker(filePath=", this.f13165a, ", modelId=", this.f13166b, ", signal=");
        e.l(sbS, this.f13167c, ", pid=", this.f13168d, ", tid=");
        com.stepos.core.ota.d.s(sbS, this.f13169e, ", monoNs=", this.f13170f);
        sbS.append(", wallClockMs=0)");
        return sbS.toString();
    }
}
