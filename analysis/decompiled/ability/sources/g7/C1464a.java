package g7;

import java.util.UUID;
import kotlin.jvm.internal.k;

/* renamed from: g7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1464a {

    /* renamed from: a, reason: collision with root package name */
    public final String f4487a;
    public final String b;
    public final String c;
    public final long d;
    public final long e;
    public final String f;

    public C1464a(String str, String str2, String str3, long j5) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String string = UUID.randomUUID().toString();
        k.e(string, "toString(...)");
        this.f4487a = str;
        this.b = str2;
        this.c = str3;
        this.d = j5;
        this.e = jCurrentTimeMillis;
        this.f = string;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1464a)) {
            return false;
        }
        C1464a c1464a = (C1464a) obj;
        return k.b(this.f4487a, c1464a.f4487a) && k.b(this.b, c1464a.b) && k.b(this.c, c1464a.c) && this.d == c1464a.d && this.e == c1464a.e && k.b(this.f, c1464a.f);
    }

    public final int hashCode() {
        int iC = B7.a.c(this.f4487a.hashCode() * 31, 31, this.b);
        String str = this.c;
        return this.f.hashCode() + androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c((iC + (str == null ? 0 : str.hashCode())) * 31, 31, this.d), 31, this.e);
    }

    public final String toString() {
        StringBuilder sbW = B7.a.w("AbilityCaller(packageName=", this.f4487a, ", signatureHash=", this.b, ", versionName=");
        B7.a.y(this.d, this.c, ", versionCode=", sbW);
        androidx.compose.foundation.b.y(this.e, ", timestamp=", ", idempotentKey=", sbW);
        return B7.a.q(sbW, this.f, ")");
    }
}
