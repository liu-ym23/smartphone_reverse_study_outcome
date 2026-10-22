package y5;

import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f6900a;
    public final String b;
    public final Integer c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;
    public final long i;

    /* renamed from: j, reason: collision with root package name */
    public final long f6901j;
    public final long k;
    public final boolean l;
    public final Throwable m;
    public final String n;

    public d(String str, String method, Integer num, long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, boolean z10, Exception exc, String str2) {
        k.f(method, "method");
        this.f6900a = str;
        this.b = method;
        this.c = num;
        this.d = j5;
        this.e = j6;
        this.f = j10;
        this.g = j11;
        this.h = j12;
        this.i = j13;
        this.f6901j = j14;
        this.k = j15;
        this.l = z10;
        this.m = exc;
        this.n = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f6900a.equals(dVar.f6900a) && k.b(this.b, dVar.b) && k.b(this.c, dVar.c) && this.d == dVar.d && this.e == dVar.e && this.f == dVar.f && this.g == dVar.g && this.h == dVar.h && this.i == dVar.i && this.f6901j == dVar.f6901j && this.k == dVar.k && this.l == dVar.l && k.b(this.m, dVar.m) && k.b(this.n, dVar.n);
    }

    public final int hashCode() {
        int iC = B7.a.c(this.f6900a.hashCode() * 31, 31, this.b);
        Integer num = this.c;
        int iD = androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c((iC + (num == null ? 0 : num.hashCode())) * 31, 31, this.d), 31, this.e), 31, this.f), 31, this.g), 31, this.h), 31, this.i), 31, this.f6901j), 31, this.k), 31, this.l);
        Throwable th = this.m;
        int iHashCode = (iD + (th == null ? 0 : th.hashCode())) * 31;
        String str = this.n;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbW = B7.a.w("HttpMetrics(url=", this.f6900a, ", method=", this.b, ", statusCode=");
        sbW.append(this.c);
        sbW.append(", totalDurationMs=");
        sbW.append(this.d);
        androidx.compose.foundation.b.y(this.e, ", dnsDurationMs=", ", connectDurationMs=", sbW);
        sbW.append(this.f);
        androidx.compose.foundation.b.y(this.g, ", tlsDurationMs=", ", requestDurationMs=", sbW);
        sbW.append(this.h);
        androidx.compose.foundation.b.y(this.i, ", responseDurationMs=", ", requestSize=", sbW);
        sbW.append(this.f6901j);
        androidx.compose.foundation.b.y(this.k, ", responseSize=", ", connectionReused=", sbW);
        sbW.append(this.l);
        sbW.append(", error=");
        sbW.append(this.m);
        sbW.append(", traceId=");
        return B7.a.q(sbW, this.n, ")");
    }
}
