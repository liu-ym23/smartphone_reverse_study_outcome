package x9;

import android.net.Uri;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f13759a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13760b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f13761c;

    public a(String str, String str2, Uri uri) {
        this.f13759a = str;
        this.f13760b = str2;
        this.f13761c = uri;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return kotlin.jvm.internal.g.b(this.f13759a, aVar.f13759a) && kotlin.jvm.internal.g.b(this.f13760b, aVar.f13760b) && kotlin.jvm.internal.g.b(this.f13761c, aVar.f13761c);
    }

    public final int hashCode() {
        String str = this.f13759a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f13760b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Uri uri = this.f13761c;
        return iHashCode2 + (uri != null ? uri.hashCode() : 0);
    }

    public final String toString() {
        Uri uri = this.f13761c;
        StringBuilder sbS = ai.onnxruntime.a.s("ComponentInternalInfo(processName=", this.f13759a, ", stateServiceClassName=", this.f13760b, ", authority=");
        sbS.append(uri);
        sbS.append(")");
        return sbS.toString();
    }
}
