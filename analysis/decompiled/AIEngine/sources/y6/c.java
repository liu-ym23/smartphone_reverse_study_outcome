package y6;

import com.stepos.base.inference.data.BackendType;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.ota.d;
import h0.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f14155a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f14156b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14157c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14158d;

    /* renamed from: e, reason: collision with root package name */
    public final long f14159e;

    /* renamed from: f, reason: collision with root package name */
    public final long f14160f;

    /* renamed from: g, reason: collision with root package name */
    public final float f14161g;
    public final BackendType h;

    /* renamed from: i, reason: collision with root package name */
    public final int f14162i;

    /* renamed from: j, reason: collision with root package name */
    public final String f14163j;

    /* renamed from: k, reason: collision with root package name */
    public final long f14164k;

    /* renamed from: l, reason: collision with root package name */
    public final long f14165l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f14166m;

    public c(String taskId, boolean z, Object obj, int i10, long j10, long j11, float f8, BackendType backendType, int i11, String str, long j12, long j13, boolean z3, int i12) {
        Object obj2 = (i12 & 4) != 0 ? null : obj;
        int i13 = (i12 & 8) != 0 ? 0 : i10;
        long j14 = (i12 & 16) != 0 ? 0L : j10;
        long j15 = (i12 & 32) != 0 ? 0L : j11;
        float f9 = (i12 & 64) != 0 ? 0.0f : f8;
        BackendType backendType2 = (i12 & TraceIdKeys.MAX_LENGTH) != 0 ? null : backendType;
        int i14 = (i12 & 256) != 0 ? 0 : i11;
        String str2 = (i12 & VadSessionManager.FRAME_BYTES) != 0 ? null : str;
        long j16 = (i12 & 4096) != 0 ? 0L : j12;
        long j17 = (i12 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? 0L : j13;
        boolean z10 = (i12 & 16384) != 0 ? false : z3;
        g.f(taskId, "taskId");
        this.f14155a = taskId;
        this.f14156b = z;
        this.f14157c = obj2;
        this.f14158d = i13;
        this.f14159e = j14;
        this.f14160f = j15;
        this.f14161g = f9;
        this.h = backendType2;
        this.f14162i = i14;
        this.f14163j = str2;
        this.f14164k = j16;
        this.f14165l = j17;
        this.f14166m = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return g.b(this.f14155a, cVar.f14155a) && this.f14156b == cVar.f14156b && g.b(this.f14157c, cVar.f14157c) && this.f14158d == cVar.f14158d && this.f14159e == cVar.f14159e && this.f14160f == cVar.f14160f && Float.compare(this.f14161g, cVar.f14161g) == 0 && this.h == cVar.h && this.f14162i == cVar.f14162i && g.b(this.f14163j, cVar.f14163j) && this.f14164k == cVar.f14164k && this.f14165l == cVar.f14165l && this.f14166m == cVar.f14166m;
    }

    public final int hashCode() {
        int iF = ai.onnxruntime.a.f(this.f14155a.hashCode() * 31, 31, this.f14156b);
        Object obj = this.f14157c;
        int iA = a0.a.a(this.f14161g, a0.a.c(a0.a.c(ai.onnxruntime.a.d(this.f14158d, (iF + (obj == null ? 0 : obj.hashCode())) * 31, 31), this.f14159e, 31), this.f14160f, 31), 31);
        BackendType backendType = this.h;
        int iD = ai.onnxruntime.a.d(this.f14162i, (iA + (backendType == null ? 0 : backendType.hashCode())) * 31, 31);
        String str = this.f14163j;
        return Boolean.hashCode(this.f14166m) + a0.a.c(a0.a.c(a0.a.c(a0.a.c((iD + (str != null ? str.hashCode() : 0)) * 31, 0L, 31), 0L, 31), this.f14164k, 31), this.f14165l, 31);
    }

    public final String toString() {
        StringBuilder sbM = d.m("InferenceResult(taskId=", this.f14155a, ", success=", ", output=", this.f14156b);
        sbM.append(this.f14157c);
        sbM.append(", tokenCount=");
        sbM.append(this.f14158d);
        sbM.append(", firstTokenLatencyMs=");
        sbM.append(this.f14159e);
        a0.a.s(this.f14160f, ", totalLatencyMs=", ", tokensPerSecond=", sbM);
        sbM.append(this.f14161g);
        sbM.append(", backend=");
        sbM.append(this.h);
        sbM.append(", errorCode=");
        e.h(this.f14162i, ", errorMessage=", this.f14163j, ", startTime=0, endTime=0, preprocessTimeMs=", sbM);
        sbM.append(this.f14164k);
        a0.a.s(this.f14165l, ", postprocessTimeMs=", ", modelCacheHit=", sbM);
        return a0.a.m(sbM, this.f14166m, ")");
    }
}
