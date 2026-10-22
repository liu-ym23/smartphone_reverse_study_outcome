package u9;

import h0.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {
    public static volatile boolean h;

    /* renamed from: a, reason: collision with root package name */
    public final int f13181a;

    /* renamed from: b, reason: collision with root package name */
    public String f13182b;

    /* renamed from: c, reason: collision with root package name */
    public String f13183c;

    /* renamed from: d, reason: collision with root package name */
    public int f13184d;

    /* renamed from: e, reason: collision with root package name */
    public long f13185e;

    /* renamed from: f, reason: collision with root package name */
    public long f13186f;

    /* renamed from: g, reason: collision with root package name */
    public int f13187g;

    public a(int i10) {
        this.f13181a = i10;
    }

    public final String toString() {
        String str = this.f13182b;
        String str2 = this.f13183c;
        int i10 = this.f13184d;
        long j10 = this.f13185e;
        long j11 = this.f13186f;
        int i11 = this.f13187g;
        StringBuilder sbS = ai.onnxruntime.a.s("IpcState{serviceName='", str, "', methodName='", str2, "', type=");
        e.l(sbS, this.f13181a, ", result=", i10, ", degrade=0, costTime=");
        sbS.append(j10);
        a0.a.s(j11, ", invokeTime=", ", dataSize=", sbS);
        return ai.onnxruntime.a.j("}", i11, sbS);
    }
}
