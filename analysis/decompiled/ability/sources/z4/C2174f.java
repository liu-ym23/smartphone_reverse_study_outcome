package z4;

import java.util.Map;

/* renamed from: z4.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2174f {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f6960a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final Map h;
    public final String i;

    /* renamed from: j, reason: collision with root package name */
    public final Integer f6961j;

    public C2174f(boolean z10, String str, String str2, String str3, String str4, String str5, String str6, Map map, String str7, Integer num) {
        this.f6960a = z10;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = map;
        this.i = str7;
        this.f6961j = num;
    }

    public static C2174f a(C2174f c2174f, String str, String str2, String str3, String str4, int i) {
        boolean z10 = (i & 1) != 0 ? c2174f.f6960a : false;
        String str5 = c2174f.b;
        if ((i & 4) != 0) {
            str = c2174f.c;
        }
        String str6 = str;
        if ((i & 8) != 0) {
            str2 = c2174f.d;
        }
        return new C2174f(z10, str5, str6, str2, (i & 16) != 0 ? c2174f.e : str3, c2174f.f, c2174f.g, c2174f.h, (i & 256) != 0 ? c2174f.i : str4, c2174f.f6961j);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2174f)) {
            return false;
        }
        C2174f c2174f = (C2174f) obj;
        return this.f6960a == c2174f.f6960a && kotlin.jvm.internal.k.b(this.b, c2174f.b) && kotlin.jvm.internal.k.b(this.c, c2174f.c) && kotlin.jvm.internal.k.b(this.d, c2174f.d) && kotlin.jvm.internal.k.b(this.e, c2174f.e) && kotlin.jvm.internal.k.b(this.f, c2174f.f) && kotlin.jvm.internal.k.b(this.g, c2174f.g) && kotlin.jvm.internal.k.b(this.h, c2174f.h) && kotlin.jvm.internal.k.b(this.i, c2174f.i) && kotlin.jvm.internal.k.b(this.f6961j, c2174f.f6961j);
    }

    public final int hashCode() {
        int iC = B7.a.c(B7.a.c(B7.a.c(Boolean.hashCode(this.f6960a) * 31, 31, this.b), 31, this.c), 31, this.d);
        String str = this.e;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.g;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Map map = this.h;
        int iHashCode4 = (iHashCode3 + (map == null ? 0 : map.hashCode())) * 31;
        String str4 = this.i;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.f6961j;
        return iHashCode5 + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LauncherAuthCallback(agreed=");
        sb.append(this.f6960a);
        sb.append(", toolCallId=");
        sb.append(this.b);
        sb.append(", traceId=");
        androidx.constraintlayout.core.dsl.a.A(sb, this.c, ", sessionId=", this.d, ", toolName=");
        androidx.constraintlayout.core.dsl.a.A(sb, this.e, ", approvalId=", this.f, ", runId=");
        sb.append(this.g);
        sb.append(", executionGrant=");
        sb.append(this.h);
        sb.append(", sessionKey=");
        sb.append(this.i);
        sb.append(", expectedVersion=");
        sb.append(this.f6961j);
        sb.append(")");
        return sb.toString();
    }
}
