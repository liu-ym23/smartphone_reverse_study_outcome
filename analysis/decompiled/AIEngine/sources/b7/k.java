package b7;

import com.stepos.base.model.InferenceConfig;
import com.stepos.base.protocol.ProtocolType;
import java.io.File;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final String f3090a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3091b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3092c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3093d;

    /* renamed from: e, reason: collision with root package name */
    public final String f3094e;

    /* renamed from: f, reason: collision with root package name */
    public final Set<ProtocolType> f3095f;

    /* renamed from: g, reason: collision with root package name */
    public final InferenceConfig f3096g;
    public final Set<String> h;

    /* renamed from: i, reason: collision with root package name */
    public final d7.a f3097i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f3098j;

    /* renamed from: k, reason: collision with root package name */
    public final List<String> f3099k;

    /* renamed from: l, reason: collision with root package name */
    public final List<String> f3100l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f3101m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f3102n;

    /* JADX WARN: Multi-variable type inference failed */
    public k(String str, String str2, String str3, String str4, String str5, Set<? extends ProtocolType> set, InferenceConfig inferenceConfig, Set<String> set2, d7.a aVar, boolean z, List<String> list, List<String> list2, boolean z3, boolean z10) {
        this.f3090a = str;
        this.f3091b = str2;
        this.f3092c = str3;
        this.f3093d = str4;
        this.f3094e = str5;
        this.f3095f = set;
        this.f3096g = inferenceConfig;
        this.h = set2;
        this.f3097i = aVar;
        this.f3098j = z;
        this.f3099k = list;
        this.f3100l = list2;
        this.f3101m = z3;
        this.f3102n = z10;
    }

    public static k a(k kVar, String str, String str2, d7.a aVar, int i10) {
        String str3 = kVar.f3090a;
        String modelPath = (i10 & 2) != 0 ? kVar.f3091b : str;
        String str4 = (i10 & 4) != 0 ? kVar.f3092c : str2;
        String str5 = kVar.f3093d;
        String str6 = str4;
        String str7 = kVar.f3094e;
        Set<ProtocolType> supportedProtocols = kVar.f3095f;
        InferenceConfig inferenceConfig = kVar.f3096g;
        Set<String> tags = kVar.h;
        d7.a aVar2 = (i10 & 256) != 0 ? kVar.f3097i : aVar;
        boolean z = kVar.f3098j;
        List<String> list = kVar.f3099k;
        List<String> list2 = kVar.f3100l;
        boolean z3 = kVar.f3101m;
        boolean z10 = kVar.f3102n;
        kotlin.jvm.internal.g.f(modelPath, "modelPath");
        kotlin.jvm.internal.g.f(supportedProtocols, "supportedProtocols");
        kotlin.jvm.internal.g.f(inferenceConfig, "inferenceConfig");
        kotlin.jvm.internal.g.f(tags, "tags");
        return new k(str3, modelPath, str6, str5, str7, supportedProtocols, inferenceConfig, tags, aVar2, z, list, list2, z3, z10);
    }

    public final String b() {
        String str = this.f3092c;
        if (str != null && str.length() != 0) {
            return str;
        }
        String str2 = this.f3091b;
        if (gc.o.e0(str2, ".json", false)) {
            return str2;
        }
        File file = new File(str2, "model_config.json");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public final boolean c(ProtocolType protocolType) {
        kotlin.jvm.internal.g.f(protocolType, "protocolType");
        return this.f3095f.contains(protocolType);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f3090a.equals(kVar.f3090a) && this.f3091b.equals(kVar.f3091b) && kotlin.jvm.internal.g.b(this.f3092c, kVar.f3092c) && kotlin.jvm.internal.g.b(this.f3093d, kVar.f3093d) && kotlin.jvm.internal.g.b(this.f3094e, kVar.f3094e) && kotlin.jvm.internal.g.b(this.f3095f, kVar.f3095f) && kotlin.jvm.internal.g.b(this.f3096g, kVar.f3096g) && kotlin.jvm.internal.g.b(this.h, kVar.h) && kotlin.jvm.internal.g.b(this.f3097i, kVar.f3097i) && this.f3098j == kVar.f3098j && kotlin.jvm.internal.g.b(this.f3099k, kVar.f3099k) && kotlin.jvm.internal.g.b(this.f3100l, kVar.f3100l) && this.f3101m == kVar.f3101m && this.f3102n == kVar.f3102n;
    }

    public final int hashCode() {
        int iA = v1.d.a(this.f3090a.hashCode() * 31, 31, this.f3091b);
        String str = this.f3092c;
        int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f3093d;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f3094e;
        int iHashCode3 = (this.h.hashCode() + ((this.f3096g.hashCode() + ((this.f3095f.hashCode() + ((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31)) * 31)) * 31)) * 31;
        d7.a aVar = this.f3097i;
        int iF = ai.onnxruntime.a.f((iHashCode3 + (aVar == null ? 0 : aVar.hashCode())) * 31, 31, this.f3098j);
        List<String> list = this.f3099k;
        int iHashCode4 = (iF + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.f3100l;
        return Boolean.hashCode(this.f3102n) + ai.onnxruntime.a.f((iHashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31, 31, this.f3101m);
    }

    public final String toString() {
        StringBuilder sbS = ai.onnxruntime.a.s("ModelConfig(modelId=", this.f3090a, ", modelPath=", this.f3091b, ", configPath=");
        ai.onnxruntime.a.z(sbS, this.f3092c, ", modelFile=", this.f3093d, ", description=");
        sbS.append(this.f3094e);
        sbS.append(", supportedProtocols=");
        sbS.append(this.f3095f);
        sbS.append(", inferenceConfig=");
        sbS.append(this.f3096g);
        sbS.append(", tags=");
        sbS.append(this.h);
        sbS.append(", descriptor=");
        sbS.append(this.f3097i);
        sbS.append(", isMock=");
        sbS.append(this.f3098j);
        sbS.append(", supportedSocs=");
        sbS.append(this.f3099k);
        sbS.append(", disabledDevices=");
        sbS.append(this.f3100l);
        sbS.append(", otaEnabled=");
        sbS.append(this.f3101m);
        sbS.append(", enable=");
        sbS.append(this.f3102n);
        sbS.append(")");
        return sbS.toString();
    }
}
