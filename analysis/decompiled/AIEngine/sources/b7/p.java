package b7;

import com.stepos.base.protocol.ProtocolType;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final String f3114a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3115b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<ProtocolType> f3116c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3117d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f3118e;

    public p() {
        throw null;
    }

    public p(String str, Set protocolTypes) {
        kotlin.jvm.internal.g.f(protocolTypes, "protocolTypes");
        this.f3114a = str;
        this.f3115b = "primary";
        this.f3116c = protocolTypes;
        this.f3117d = "主模型";
        this.f3118e = true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return kotlin.jvm.internal.g.b(this.f3114a, pVar.f3114a) && kotlin.jvm.internal.g.b(this.f3115b, pVar.f3115b) && kotlin.jvm.internal.g.b(this.f3116c, pVar.f3116c) && kotlin.jvm.internal.g.b(this.f3117d, pVar.f3117d) && this.f3118e == pVar.f3118e;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f3118e) + ai.onnxruntime.a.d(0, v1.d.a((this.f3116c.hashCode() + v1.d.a(this.f3114a.hashCode() * 31, 31, this.f3115b)) * 31, 31, this.f3117d), 31);
    }

    public final String toString() {
        StringBuilder sbS = ai.onnxruntime.a.s("ModelProtocol(modelId=", this.f3114a, ", protocol=", this.f3115b, ", protocolTypes=");
        sbS.append(this.f3116c);
        sbS.append(", description=");
        sbS.append(this.f3117d);
        sbS.append(", priority=0, isRequired=");
        return a0.a.m(sbS, this.f3118e, ")");
    }
}
