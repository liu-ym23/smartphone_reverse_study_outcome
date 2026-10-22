package d7;

import com.stepos.base.model.data.ComputeType;
import com.stepos.base.model.data.PowerProfile;
import h0.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final ComputeType f8392a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8393b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8394c;

    /* renamed from: d, reason: collision with root package name */
    public final PowerProfile f8395d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f8396e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f8397f;

    /* renamed from: g, reason: collision with root package name */
    public final int f8398g;
    public final int h;

    /* renamed from: i, reason: collision with root package name */
    public final String f8399i;

    public a(ComputeType computeType, int i10, int i11, PowerProfile powerProfile, boolean z, boolean z3, int i12, int i13, String str) {
        g.f(computeType, "computeType");
        g.f(powerProfile, "powerProfile");
        this.f8392a = computeType;
        this.f8393b = i10;
        this.f8394c = i11;
        this.f8395d = powerProfile;
        this.f8396e = z;
        this.f8397f = z3;
        this.f8398g = i12;
        this.h = i13;
        this.f8399i = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f8392a == aVar.f8392a && this.f8393b == aVar.f8393b && this.f8394c == aVar.f8394c && this.f8395d == aVar.f8395d && this.f8396e == aVar.f8396e && this.f8397f == aVar.f8397f && this.f8398g == aVar.f8398g && this.h == aVar.h && g.b(this.f8399i, aVar.f8399i);
    }

    public final int hashCode() {
        int iD = ai.onnxruntime.a.d(this.h, ai.onnxruntime.a.d(this.f8398g, ai.onnxruntime.a.f(ai.onnxruntime.a.f((this.f8395d.hashCode() + ai.onnxruntime.a.d(this.f8394c, ai.onnxruntime.a.d(this.f8393b, this.f8392a.hashCode() * 31, 31), 31)) * 31, 31, this.f8396e), 31, this.f8397f), 31), 31);
        String str = this.f8399i;
        return iD + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ModelDescriptor(computeType=");
        sb2.append(this.f8392a);
        sb2.append(", memoryMB=");
        sb2.append(this.f8393b);
        sb2.append(", latencyMs=");
        sb2.append(this.f8394c);
        sb2.append(", powerProfile=");
        sb2.append(this.f8395d);
        sb2.append(", supportsStreaming=");
        sb2.append(this.f8396e);
        sb2.append(", supportsBatching=");
        sb2.append(this.f8397f);
        sb2.append(", maxBatchSize=");
        e.l(sb2, this.f8398g, ", maxContextLength=", this.h, ", quantization=");
        return ai.onnxruntime.a.o(sb2, this.f8399i, ")");
    }
}
