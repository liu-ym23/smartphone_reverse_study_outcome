package r6;

import com.stepos.base.awareness.data.ThermalState;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: j, reason: collision with root package name */
    public static final b f11747j;

    /* renamed from: a, reason: collision with root package name */
    public final float f11748a;

    /* renamed from: b, reason: collision with root package name */
    public final float f11749b;

    /* renamed from: c, reason: collision with root package name */
    public final long f11750c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11751d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f11752e;

    /* renamed from: f, reason: collision with root package name */
    public final float f11753f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f11754g;
    public final ThermalState h;

    /* renamed from: i, reason: collision with root package name */
    public final long f11755i;

    static {
        ThermalState.a aVar = ThermalState.f6199a;
        f11747j = new b(30.0f, 50.0f, 2048L, 80, false, 35.0f, false, 256);
    }

    public b(float f8, float f9, long j10, int i10, boolean z, float f10, boolean z3, int i11) {
        ThermalState thermalState = ThermalState.f6200b;
        f8 = (i11 & 1) != 0 ? 0.0f : f8;
        f9 = (i11 & 2) != 0 ? 0.0f : f9;
        j10 = (i11 & 4) != 0 ? 0L : j10;
        i10 = (i11 & 8) != 0 ? 100 : i10;
        z = (i11 & 16) != 0 ? false : z;
        f10 = (i11 & 32) != 0 ? 25.0f : f10;
        z3 = (i11 & 64) != 0 ? false : z3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f11748a = f8;
        this.f11749b = f9;
        this.f11750c = j10;
        this.f11751d = i10;
        this.f11752e = z;
        this.f11753f = f10;
        this.f11754g = z3;
        this.h = thermalState;
        this.f11755i = jCurrentTimeMillis;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Float.compare(this.f11748a, bVar.f11748a) == 0 && Float.compare(this.f11749b, bVar.f11749b) == 0 && this.f11750c == bVar.f11750c && this.f11751d == bVar.f11751d && this.f11752e == bVar.f11752e && Float.compare(this.f11753f, bVar.f11753f) == 0 && this.f11754g == bVar.f11754g && this.h == bVar.h && this.f11755i == bVar.f11755i;
    }

    public final int hashCode() {
        return Long.hashCode(this.f11755i) + ((this.h.hashCode() + ai.onnxruntime.a.f(a0.a.a(this.f11753f, ai.onnxruntime.a.f(ai.onnxruntime.a.d(this.f11751d, a0.a.c(a0.a.a(this.f11749b, Float.hashCode(this.f11748a) * 31, 31), this.f11750c, 31), 31), 31, this.f11752e), 31), 31, this.f11754g)) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("SystemLoad(cpuUsage=");
        sb2.append(this.f11748a);
        sb2.append(", memoryUsage=");
        sb2.append(this.f11749b);
        sb2.append(", availableMemoryMB=");
        sb2.append(this.f11750c);
        sb2.append(", batteryLevel=");
        sb2.append(this.f11751d);
        sb2.append(", isCharging=");
        sb2.append(this.f11752e);
        sb2.append(", temperature=");
        sb2.append(this.f11753f);
        sb2.append(", isThermalThrottling=");
        sb2.append(this.f11754g);
        sb2.append(", thermalState=");
        sb2.append(this.h);
        return a0.a.d(this.f11755i, ", timestamp=", ")", sb2);
    }
}
