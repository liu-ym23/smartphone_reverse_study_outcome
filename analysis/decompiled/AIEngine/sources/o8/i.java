package o8;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f10825a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10826b;

    /* renamed from: c, reason: collision with root package name */
    public final Long f10827c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10828d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f10829e;

    /* renamed from: f, reason: collision with root package name */
    public final a f10830f;

    /* renamed from: g, reason: collision with root package name */
    public final e f10831g;
    public final Boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final Throwable f10832i;

    public i(String sourcePath, String str, Long l10, String str2, boolean z, a aVar, e eVar, Boolean bool, Throwable th) {
        kotlin.jvm.internal.g.f(sourcePath, "sourcePath");
        this.f10825a = sourcePath;
        this.f10826b = str;
        this.f10827c = l10;
        this.f10828d = str2;
        this.f10829e = z;
        this.f10830f = aVar;
        this.f10831g = eVar;
        this.h = bool;
        this.f10832i = th;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return kotlin.jvm.internal.g.b(this.f10825a, iVar.f10825a) && kotlin.jvm.internal.g.b(this.f10826b, iVar.f10826b) && kotlin.jvm.internal.g.b(this.f10827c, iVar.f10827c) && kotlin.jvm.internal.g.b(this.f10828d, iVar.f10828d) && this.f10829e == iVar.f10829e && kotlin.jvm.internal.g.b(this.f10830f, iVar.f10830f) && kotlin.jvm.internal.g.b(this.f10831g, iVar.f10831g) && kotlin.jvm.internal.g.b(this.h, iVar.h) && kotlin.jvm.internal.g.b(this.f10832i, iVar.f10832i);
    }

    public final int hashCode() {
        int iHashCode = this.f10825a.hashCode() * 31;
        String str = this.f10826b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l10 = this.f10827c;
        int iHashCode3 = (iHashCode2 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str2 = this.f10828d;
        int iF = ai.onnxruntime.a.f((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31, 31, this.f10829e);
        a aVar = this.f10830f;
        int iHashCode4 = (iF + (aVar == null ? 0 : aVar.hashCode())) * 31;
        e eVar = this.f10831g;
        int iHashCode5 = (iHashCode4 + (eVar == null ? 0 : eVar.hashCode())) * 31;
        Boolean bool = this.h;
        int iHashCode6 = (iHashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        Throwable th = this.f10832i;
        return iHashCode6 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbS = ai.onnxruntime.a.s("UploadResult(sourcePath=", this.f10825a, ", fileId=", this.f10826b, ", fileSize=");
        sbS.append(this.f10827c);
        sbS.append(", downloadUrl=");
        sbS.append(this.f10828d);
        sbS.append(", success=");
        sbS.append(this.f10829e);
        sbS.append(", audit=");
        sbS.append(this.f10830f);
        sbS.append(", sensitive=");
        sbS.append(this.f10831g);
        sbS.append(", detectPassed=");
        sbS.append(this.h);
        sbS.append(", error=");
        sbS.append(this.f10832i);
        sbS.append(")");
        return sbS.toString();
    }
}
