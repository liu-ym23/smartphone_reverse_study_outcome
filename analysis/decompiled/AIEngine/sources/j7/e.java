package j7;

import com.stepos.core.ability.speech.VadSessionManager;
import java.util.UUID;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f9710a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9711b;

    /* renamed from: c, reason: collision with root package name */
    public final String f9712c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f9713d;

    /* renamed from: e, reason: collision with root package name */
    public final int f9714e;

    /* renamed from: f, reason: collision with root package name */
    public final int f9715f;

    /* renamed from: g, reason: collision with root package name */
    public final String f9716g;
    public final long h;

    /* renamed from: i, reason: collision with root package name */
    public final h7.b f9717i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f9718j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f9719k;

    /* renamed from: l, reason: collision with root package name */
    public final long f9720l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f9721m;

    public e(String str, String abilityId, String modelId, Object input, int i10, int i11, String str2, h7.b bVar, boolean z, Object obj, long j10, boolean z3, int i12) {
        String id2 = (i12 & 1) != 0 ? UUID.randomUUID().toString() : str;
        int i13 = (i12 & 16) != 0 ? 0 : i10;
        int i14 = (i12 & 32) == 0 ? i11 : 0;
        String str3 = (i12 & 64) != 0 ? "" : str2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        h7.b bVar2 = (i12 & 256) != 0 ? null : bVar;
        boolean z10 = (i12 & VadSessionManager.FRAME_BYTES) != 0 ? true : z;
        Object obj2 = (i12 & 1024) == 0 ? obj : null;
        long j11 = (i12 & 2048) != 0 ? 0L : j10;
        boolean z11 = (i12 & 4096) != 0 ? true : z3;
        g.f(id2, "id");
        g.f(abilityId, "abilityId");
        g.f(modelId, "modelId");
        g.f(input, "input");
        this.f9710a = id2;
        this.f9711b = abilityId;
        this.f9712c = modelId;
        this.f9713d = input;
        this.f9714e = i13;
        this.f9715f = i14;
        this.f9716g = str3;
        this.h = jCurrentTimeMillis;
        this.f9717i = bVar2;
        this.f9718j = z10;
        this.f9719k = obj2;
        this.f9720l = j11;
        this.f9721m = z11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return g.b(this.f9710a, eVar.f9710a) && g.b(this.f9711b, eVar.f9711b) && g.b(this.f9712c, eVar.f9712c) && g.b(this.f9713d, eVar.f9713d) && this.f9714e == eVar.f9714e && this.f9715f == eVar.f9715f && g.b(this.f9716g, eVar.f9716g) && this.h == eVar.h && g.b(this.f9717i, eVar.f9717i) && this.f9718j == eVar.f9718j && g.b(this.f9719k, eVar.f9719k) && this.f9720l == eVar.f9720l && this.f9721m == eVar.f9721m;
    }

    public final int hashCode() {
        int iC = a0.a.c(v1.d.a(ai.onnxruntime.a.d(this.f9715f, ai.onnxruntime.a.d(this.f9714e, (this.f9713d.hashCode() + v1.d.a(v1.d.a(this.f9710a.hashCode() * 31, 31, this.f9711b), 31, this.f9712c)) * 31, 31), 31), 31, this.f9716g), this.h, 31);
        h7.b bVar = this.f9717i;
        int iF = ai.onnxruntime.a.f((iC + (bVar == null ? 0 : bVar.hashCode())) * 31, 31, this.f9718j);
        Object obj = this.f9719k;
        return Boolean.hashCode(this.f9721m) + a0.a.c((iF + (obj != null ? obj.hashCode() : 0)) * 31, this.f9720l, 31);
    }

    public final String toString() {
        StringBuilder sbS = ai.onnxruntime.a.s("TaskRequest(id=", this.f9710a, ", abilityId=", this.f9711b, ", modelId=");
        sbS.append(this.f9712c);
        sbS.append(", input=");
        sbS.append(this.f9713d);
        sbS.append(", callerUid=");
        h0.e.l(sbS, this.f9714e, ", callerPid=", this.f9715f, ", callerPackage=");
        com.stepos.core.ota.d.p(this.h, this.f9716g, ", createdAt=", sbS);
        sbS.append(", constraints=");
        sbS.append(this.f9717i);
        sbS.append(", isForeground=");
        sbS.append(this.f9718j);
        sbS.append(", powerTracker=");
        sbS.append(this.f9719k);
        sbS.append(", timeoutMs=");
        sbS.append(this.f9720l);
        sbS.append(", reportModelCallTerminal=");
        sbS.append(this.f9721m);
        sbS.append(")");
        return sbS.toString();
    }
}
