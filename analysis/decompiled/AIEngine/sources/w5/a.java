package w5;

import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f13602a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13603b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13604c;

    /* renamed from: d, reason: collision with root package name */
    public final String f13605d;

    public a(String method, String description, String inputSchema, String packageName) {
        g.f(method, "method");
        g.f(description, "description");
        g.f(inputSchema, "inputSchema");
        g.f(packageName, "packageName");
        this.f13602a = method;
        this.f13603b = description;
        this.f13604c = inputSchema;
        this.f13605d = packageName;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return g.b(this.f13602a, aVar.f13602a) && g.b(this.f13603b, aVar.f13603b) && g.b(this.f13604c, aVar.f13604c) && g.b(this.f13605d, aVar.f13605d);
    }

    public final int hashCode() {
        return this.f13605d.hashCode() + d.a(d.a(this.f13602a.hashCode() * 31, 31, this.f13603b), 31, this.f13604c);
    }

    public final String toString() {
        return com.stepos.core.ota.d.j(ai.onnxruntime.a.s("AbilityMetaDataInfo(method=", this.f13602a, ", description=", this.f13603b, ", inputSchema="), this.f13604c, ", packageName=", this.f13605d, ")");
    }
}
