package r6;

import com.stepos.base.awareness.data.SceneType;
import com.stepos.base.inference.data.BackendType;
import com.stepos.core.ability.speech.VadSessionManager;
import h0.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final SceneType f11737a;

    /* renamed from: b, reason: collision with root package name */
    public final BackendType f11738b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11739c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11740d;

    /* renamed from: e, reason: collision with root package name */
    public final long f11741e;

    /* renamed from: f, reason: collision with root package name */
    public final long f11742f;

    /* renamed from: g, reason: collision with root package name */
    public final int f11743g;
    public final int h;

    /* renamed from: i, reason: collision with root package name */
    public final int f11744i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f11745j;

    /* renamed from: k, reason: collision with root package name */
    public final long f11746k;

    public a(SceneType sceneType, BackendType backendType, String poolType, int i10, long j10, long j11, int i11, int i12, int i13, boolean z, long j12) {
        g.f(backendType, "backendType");
        g.f(poolType, "poolType");
        this.f11737a = sceneType;
        this.f11738b = backendType;
        this.f11739c = poolType;
        this.f11740d = i10;
        this.f11741e = j10;
        this.f11742f = j11;
        this.f11743g = i11;
        this.h = i12;
        this.f11744i = i13;
        this.f11745j = z;
        this.f11746k = j12;
    }

    public static a a(a aVar, BackendType backendType, int i10, long j10, int i11, int i12) {
        SceneType scene = aVar.f11737a;
        BackendType backendType2 = (i12 & 2) != 0 ? aVar.f11738b : backendType;
        String poolType = aVar.f11739c;
        long j11 = (i12 & 16) != 0 ? aVar.f11741e : j10;
        long j12 = aVar.f11742f;
        int i13 = aVar.f11743g;
        aVar.getClass();
        int i14 = aVar.h;
        int i15 = (i12 & VadSessionManager.FRAME_BYTES) != 0 ? aVar.f11744i : i11;
        boolean z = aVar.f11745j;
        long j13 = aVar.f11746k;
        aVar.getClass();
        g.f(scene, "scene");
        g.f(backendType2, "backendType");
        g.f(poolType, "poolType");
        return new a(scene, backendType2, poolType, i10, j11, j12, i13, i14, i15, z, j13);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f11737a == aVar.f11737a && this.f11738b == aVar.f11738b && g.b(this.f11739c, aVar.f11739c) && this.f11740d == aVar.f11740d && this.f11741e == aVar.f11741e && this.f11742f == aVar.f11742f && this.f11743g == aVar.f11743g && this.h == aVar.h && this.f11744i == aVar.f11744i && this.f11745j == aVar.f11745j && this.f11746k == aVar.f11746k;
    }

    public final int hashCode() {
        return Long.hashCode(this.f11746k) + ai.onnxruntime.a.f(ai.onnxruntime.a.d(this.f11744i, ai.onnxruntime.a.d(this.h, ai.onnxruntime.a.f(ai.onnxruntime.a.d(this.f11743g, a0.a.c(a0.a.c(ai.onnxruntime.a.d(this.f11740d, d.a((this.f11738b.hashCode() + (this.f11737a.hashCode() * 31)) * 31, 31, this.f11739c), 31), this.f11741e, 31), this.f11742f, 31), 31), 31, false), 31), 31), 31, this.f11745j);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ScheduleDecision(scene=");
        sb2.append(this.f11737a);
        sb2.append(", backendType=");
        sb2.append(this.f11738b);
        sb2.append(", poolType=");
        com.stepos.core.ota.d.o(this.f11740d, this.f11739c, ", threadCount=", ", timeoutMs=", sb2);
        sb2.append(this.f11741e);
        a0.a.s(this.f11742f, ", timeout=", ", maxConcurrentTasks=", sb2);
        e.l(sb2, this.f11743g, ", enableBatching=false, batchSize=", this.h, ", priority=");
        sb2.append(this.f11744i);
        sb2.append(", allowDegradation=");
        sb2.append(this.f11745j);
        sb2.append(", timestamp=");
        return ai.onnxruntime.a.m(sb2, this.f11746k, ")");
    }

    public /* synthetic */ a(SceneType sceneType, BackendType backendType, String str, int i10, long j10, int i11, int i12, int i13) {
        this(sceneType, (i13 & 2) != 0 ? BackendType.f6256j : backendType, (i13 & 4) != 0 ? "COMPUTE" : str, i10, j10, j10, (i13 & 64) != 0 ? 2 : i11, 1, (i13 & VadSessionManager.FRAME_BYTES) != 0 ? 50 : i12, true, System.currentTimeMillis());
    }
}
