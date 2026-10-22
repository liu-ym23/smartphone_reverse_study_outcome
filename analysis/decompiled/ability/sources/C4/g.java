package C4;

import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f296a;
    public final int b;
    public final String c;
    public final String d;
    public final int e;
    public final int f;
    public final int g = 50;
    public final String h;
    public final Integer i;

    public g(String str, int i, String str2, String str3, int i6, int i10, String str4, Integer num) {
        this.f296a = str;
        this.b = i;
        this.c = str2;
        this.d = str3;
        this.e = i6;
        this.f = i10;
        this.h = str4;
        this.i = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return k.b(this.f296a, gVar.f296a) && this.b == gVar.b && k.b(this.c, gVar.c) && k.b(this.d, gVar.d) && this.e == gVar.e && this.f == gVar.f && this.g == gVar.g && k.b(this.h, gVar.h) && k.b(this.i, gVar.i);
    }

    public final int hashCode() {
        int iA = androidx.constraintlayout.core.dsl.a.a(this.g, androidx.constraintlayout.core.dsl.a.a(this.f, androidx.constraintlayout.core.dsl.a.a(this.e, B7.a.c(B7.a.c(androidx.constraintlayout.core.dsl.a.a(this.b, this.f296a.hashCode() * 31, 31), 31, this.c), 31, this.d), 31), 31), 31);
        String str = this.h;
        int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.i;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbT = androidx.appfunctions.metadata.a.t(this.b, "WakeupWord(id=", this.f296a, ", displayNameRes=", ", trackName=");
        androidx.constraintlayout.core.dsl.a.A(sbT, this.c, ", uimAsset=", this.d, ", firstStageKwLevel=");
        androidx.constraintlayout.core.dsl.a.y(sbT, this.e, ", secondStageKwLevel=", this.f, ", userConfidenceLevel=");
        sbT.append(this.g);
        sbT.append(", phonetic=");
        sbT.append(this.h);
        sbT.append(", phoneticAudioRes=");
        sbT.append(this.i);
        sbT.append(")");
        return sbT.toString();
    }
}
