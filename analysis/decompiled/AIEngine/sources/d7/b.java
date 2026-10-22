package d7;

import com.stepos.base.model.ModelState;
import com.stepos.base.model.data.BackendType;
import com.stepos.base.model.data.ModelType;
import h0.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f8400a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8401b;

    /* renamed from: c, reason: collision with root package name */
    public final ModelType f8402c;

    /* renamed from: d, reason: collision with root package name */
    public final String f8403d;

    /* renamed from: e, reason: collision with root package name */
    public final String f8404e;

    /* renamed from: f, reason: collision with root package name */
    public final String f8405f;

    /* renamed from: g, reason: collision with root package name */
    public final int f8406g;
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public final ModelState f8407i;

    /* renamed from: j, reason: collision with root package name */
    public final long f8408j;

    /* renamed from: k, reason: collision with root package name */
    public final BackendType f8409k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f8410l;

    /* renamed from: m, reason: collision with root package name */
    public final long f8411m;

    /* renamed from: n, reason: collision with root package name */
    public final long f8412n;

    public b(String str, String name, ModelType modelType, String modelPath, String str2, int i10, String str3, long j10, BackendType backendType, boolean z, long j11, long j12) {
        ModelState modelState = ModelState.f6327b;
        g.f(name, "name");
        g.f(modelPath, "modelPath");
        g.f(backendType, "backendType");
        this.f8400a = str;
        this.f8401b = name;
        this.f8402c = modelType;
        this.f8403d = "1.0.0";
        this.f8404e = modelPath;
        this.f8405f = str2;
        this.f8406g = i10;
        this.h = str3;
        this.f8407i = modelState;
        this.f8408j = j10;
        this.f8409k = backendType;
        this.f8410l = z;
        this.f8411m = j11;
        this.f8412n = j12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return g.b(this.f8400a, bVar.f8400a) && g.b(this.f8401b, bVar.f8401b) && this.f8402c == bVar.f8402c && g.b(this.f8403d, bVar.f8403d) && g.b(this.f8404e, bVar.f8404e) && g.b(this.f8405f, bVar.f8405f) && this.f8406g == bVar.f8406g && g.b(this.h, bVar.h) && this.f8407i == bVar.f8407i && this.f8408j == bVar.f8408j && this.f8409k == bVar.f8409k && this.f8410l == bVar.f8410l && this.f8411m == bVar.f8411m && this.f8412n == bVar.f8412n;
    }

    public final int hashCode() {
        int iA = d.a(d.a((this.f8402c.hashCode() + d.a(this.f8400a.hashCode() * 31, 31, this.f8401b)) * 31, 31, this.f8403d), 31, this.f8404e);
        String str = this.f8405f;
        return Long.hashCode(this.f8412n) + a0.a.c(ai.onnxruntime.a.f(ai.onnxruntime.a.d(0, (this.f8409k.hashCode() + ai.onnxruntime.a.d(0, a0.a.c(a0.a.c((this.f8407i.hashCode() + d.a(ai.onnxruntime.a.d(this.f8406g, a0.a.c((iA + (str == null ? 0 : str.hashCode())) * 31, 0L, 31), 31), 31, this.h)) * 31, this.f8408j, 31), 0L, 31), 31)) * 961, 31), 31, this.f8410l), this.f8411m, 31);
    }

    public final String toString() {
        StringBuilder sbS = ai.onnxruntime.a.s("ModelInfo(id=", this.f8400a, ", name=", this.f8401b, ", type=");
        sbS.append(this.f8402c);
        sbS.append(", version=");
        sbS.append(this.f8403d);
        sbS.append(", modelPath=");
        ai.onnxruntime.a.z(sbS, this.f8404e, ", configPath=", this.f8405f, ", sizeBytes=0, estimatedMemoryMb=");
        e.h(this.f8406g, ", description=", this.h, ", state=", sbS);
        sbS.append(this.f8407i);
        sbS.append(", loadedAt=");
        sbS.append(this.f8408j);
        sbS.append(", lastUsedAt=0, usageCount=0, backendType=");
        sbS.append(this.f8409k);
        sbS.append(", quantization=null, contextLength=0, supportsStreaming=");
        sbS.append(this.f8410l);
        a0.a.s(this.f8411m, ", measuredDspMmapMb=", ", measuredRssDeltaMb=", sbS);
        return ai.onnxruntime.a.m(sbS, this.f8412n, ")");
    }
}
