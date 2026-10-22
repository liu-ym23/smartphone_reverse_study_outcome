package o8;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f10822a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10823b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10824c;

    public h() {
        throw null;
    }

    public h(String str, String str2, String str3) {
        this.f10822a = str;
        this.f10823b = str2;
        this.f10824c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return kotlin.jvm.internal.g.b(this.f10822a, hVar.f10822a) && kotlin.jvm.internal.g.b(this.f10823b, hVar.f10823b) && kotlin.jvm.internal.g.b(this.f10824c, hVar.f10824c);
    }

    public final int hashCode() {
        int iHashCode = this.f10822a.hashCode() * 29791;
        String str = this.f10823b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f10824c;
        return (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 961;
    }

    public final String toString() {
        return ai.onnxruntime.a.o(ai.onnxruntime.a.s("UploadRequest(uriOrPath=", this.f10822a, ", fileName=null, contentType=null, bizCode=", this.f10823b, ", sourceType="), this.f10824c, ", expiresSeconds=null, bindings=null)");
    }
}
