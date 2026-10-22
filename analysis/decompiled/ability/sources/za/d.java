package za;

import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f7001a;
    public final String b;
    public final String c;
    public final boolean d;

    public /* synthetic */ d(int i, String str, String str2, boolean z10) {
        this(z10, (i & 2) != 0 ? null : str, str2, false);
    }

    public static d a(d dVar, String str) {
        boolean z10 = dVar.f7001a;
        String message = dVar.c;
        boolean z11 = dVar.d;
        k.f(message, "message");
        return new d(z10, str, message, z11);
    }

    public final boolean b() {
        return this.f7001a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f7001a == dVar.f7001a && k.b(this.b, dVar.b) && k.b(this.c, dVar.c) && this.d == dVar.d;
    }

    public final int hashCode() {
        int iHashCode = Boolean.hashCode(this.f7001a) * 31;
        String str = this.b;
        return Boolean.hashCode(this.d) + androidx.appfunctions.metadata.a.c(B7.a.c((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.c), 31, 0L);
    }

    public final String toString() {
        return "ExecutionResult(success=" + this.f7001a + ", sessionId=" + this.b + ", message=" + this.c + ", executionTime=0, isTakeoverRequested=" + this.d + ")";
    }

    public d(boolean z10, String str, String message, boolean z11) {
        k.f(message, "message");
        this.f7001a = z10;
        this.b = str;
        this.c = message;
        this.d = z11;
    }
}
