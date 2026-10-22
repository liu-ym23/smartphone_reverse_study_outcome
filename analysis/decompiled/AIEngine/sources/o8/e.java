package o8;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f10800a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10801b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10802c;

    public e(String str, String str2, String str3) {
        this.f10800a = str;
        this.f10801b = str2;
        this.f10802c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return kotlin.jvm.internal.g.b(this.f10800a, eVar.f10800a) && kotlin.jvm.internal.g.b(this.f10801b, eVar.f10801b) && kotlin.jvm.internal.g.b(this.f10802c, eVar.f10802c);
    }

    public final int hashCode() {
        String str = this.f10800a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f10801b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f10802c;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        return ai.onnxruntime.a.o(ai.onnxruntime.a.s("SensitiveResult(status=", this.f10800a, ", decision=", this.f10801b, ", level="), this.f10802c, ")");
    }
}
