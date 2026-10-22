package y5;

import kotlin.jvm.internal.k;

/* renamed from: y5.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2132b {

    /* renamed from: a, reason: collision with root package name */
    public final long f6897a;
    public final String b;
    public final String c;
    public final Integer d;
    public final long e;
    public final Long f;
    public final Long g;
    public final String h;
    public final String i;

    /* renamed from: j, reason: collision with root package name */
    public final long f6898j;

    public C2132b(long j5, String method, String str, Integer num, long j6, Long l, Long l5, String str2, String str3, int i) {
        num = (i & 8) != 0 ? null : num;
        l5 = (i & 64) != 0 ? null : l5;
        str2 = (i & 128) != 0 ? null : str2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        k.f(method, "method");
        this.f6897a = j5;
        this.b = method;
        this.c = str;
        this.d = num;
        this.e = j6;
        this.f = l;
        this.g = l5;
        this.h = str2;
        this.i = str3;
        this.f6898j = jCurrentTimeMillis;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2132b)) {
            return false;
        }
        C2132b c2132b = (C2132b) obj;
        return this.f6897a == c2132b.f6897a && k.b(this.b, c2132b.b) && k.b(this.c, c2132b.c) && k.b(this.d, c2132b.d) && this.e == c2132b.e && k.b(this.f, c2132b.f) && k.b(this.g, c2132b.g) && k.b(this.h, c2132b.h) && k.b(this.i, c2132b.i) && this.f6898j == c2132b.f6898j;
    }

    public final int hashCode() {
        int iC = B7.a.c(B7.a.c(Long.hashCode(this.f6897a) * 31, 31, this.b), 31, this.c);
        Integer num = this.d;
        int iC2 = androidx.appfunctions.metadata.a.c((iC + (num == null ? 0 : num.hashCode())) * 31, 31, this.e);
        Long l = this.f;
        int iHashCode = (iC2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l5 = this.g;
        int iHashCode2 = (iHashCode + (l5 == null ? 0 : l5.hashCode())) * 31;
        String str = this.h;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.i;
        return Long.hashCode(this.f6898j) + ((iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Record(id=");
        sb.append(this.f6897a);
        sb.append(", method=");
        sb.append(this.b);
        sb.append(", url=");
        sb.append(this.c);
        sb.append(", statusCode=");
        sb.append(this.d);
        androidx.compose.foundation.b.y(this.e, ", durationMs=", ", requestSize=", sb);
        sb.append(this.f);
        sb.append(", responseSize=");
        sb.append(this.g);
        sb.append(", error=");
        androidx.constraintlayout.core.dsl.a.A(sb, this.h, ", traceId=", this.i, ", timestamp=");
        return androidx.constraintlayout.core.dsl.a.e(this.f6898j, ")", sb);
    }
}
