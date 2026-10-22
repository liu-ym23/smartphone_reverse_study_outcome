package z4;

import java.util.LinkedHashMap;

/* renamed from: z4.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2171c {

    /* renamed from: a, reason: collision with root package name */
    public final String f6957a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final String f;
    public final String g;
    public final LinkedHashMap h;

    public C2171c(String str, String str2, String str3, String str4, int i, String str5, String str6, LinkedHashMap linkedHashMap) {
        this.f6957a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = i;
        this.f = str5;
        this.g = str6;
        this.h = linkedHashMap;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2171c)) {
            return false;
        }
        C2171c c2171c = (C2171c) obj;
        return this.f6957a.equals(c2171c.f6957a) && this.b.equals(c2171c.b) && this.c.equals(c2171c.c) && this.d.equals(c2171c.d) && this.e == c2171c.e && kotlin.jvm.internal.k.b(this.f, c2171c.f) && kotlin.jvm.internal.k.b(this.g, c2171c.g) && this.h.equals(c2171c.h);
    }

    public final int hashCode() {
        int iA = androidx.constraintlayout.core.dsl.a.a(this.e, B7.a.c(B7.a.c(B7.a.c(this.f6957a.hashCode() * 31, 31, this.b), 31, this.c), 31, this.d), 31);
        String str = this.f;
        int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.g;
        return this.h.hashCode() + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sbW = B7.a.w("AuthSession(toolCallId=", this.f6957a, ", traceId=", this.b, ", sessionId=");
        androidx.constraintlayout.core.dsl.a.A(sbW, this.c, ", toolName=", this.d, ", errorCode=");
        sbW.append(this.e);
        sbW.append(", businessContent=");
        sbW.append(this.f);
        sbW.append(", appName=");
        sbW.append(this.g);
        sbW.append(", executionGrant=");
        sbW.append(this.h);
        sbW.append(")");
        return sbW.toString();
    }
}
