package h6;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final String f9356a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9357b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9358c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9359d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f9360e;

    public x(String str, int i10, int i11, int i12, boolean z) {
        this.f9356a = str;
        this.f9357b = i10;
        this.f9358c = i11;
        this.f9359d = i12;
        this.f9360e = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return kotlin.jvm.internal.g.b(this.f9356a, xVar.f9356a) && this.f9357b == xVar.f9357b && this.f9358c == xVar.f9358c && this.f9359d == xVar.f9359d && this.f9360e == xVar.f9360e;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f9360e) + ai.onnxruntime.a.d(this.f9359d, ai.onnxruntime.a.d(this.f9358c, ai.onnxruntime.a.d(this.f9357b, this.f9356a.hashCode() * 31, 31), 31), 31);
    }

    public final String toString() {
        StringBuilder sbF = h0.e.f("TaskUiState(otaId=", this.f9356a, ", state=", this.f9357b, ", progress=");
        h0.e.l(sbF, this.f9358c, ", installedVersion=", this.f9359d, ", silent=");
        return a0.a.m(sbF, this.f9360e, ")");
    }
}
