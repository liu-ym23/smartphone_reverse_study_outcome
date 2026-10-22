package j7;

import kotlin.jvm.internal.k;

/* renamed from: j7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1599a {

    /* renamed from: a, reason: collision with root package name */
    public final String f4775a;
    public final String b;
    public final String c;
    public final long d;
    public final String e;
    public final boolean f;

    public C1599a(String str, String str2, String str3, long j5, String str4, boolean z10) {
        this.f4775a = str;
        this.b = str2;
        this.c = str3;
        this.d = j5;
        this.e = str4;
        this.f = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1599a)) {
            return false;
        }
        C1599a c1599a = (C1599a) obj;
        return k.b(this.f4775a, c1599a.f4775a) && k.b(this.b, c1599a.b) && k.b(this.c, c1599a.c) && this.d == c1599a.d && k.b(this.e, c1599a.e) && this.f == c1599a.f;
    }

    public final int hashCode() {
        int iC = B7.a.c(this.f4775a.hashCode() * 31, 31, this.b);
        String str = this.c;
        return Boolean.hashCode(this.f) + B7.a.c(androidx.appfunctions.metadata.a.c((iC + (str == null ? 0 : str.hashCode())) * 31, 31, this.d), 31, this.e);
    }

    public final String toString() {
        StringBuilder sbW = B7.a.w("AppInfo(packageName=", this.f4775a, ", signatureHash=", this.b, ", versionName=");
        B7.a.y(this.d, this.c, ", versionCode=", sbW);
        sbW.append(", appName=");
        sbW.append(this.e);
        sbW.append(", isSystemApp=");
        sbW.append(this.f);
        sbW.append(")");
        return sbW.toString();
    }
}
