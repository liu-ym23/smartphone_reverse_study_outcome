package i0;

import B0.g;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f12994a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12995b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f12996c;

    /* renamed from: d, reason: collision with root package name */
    public final int f12997d;

    /* renamed from: e, reason: collision with root package name */
    public final String f12998e;

    /* renamed from: f, reason: collision with root package name */
    public final int f12999f;

    /* renamed from: g, reason: collision with root package name */
    public final int f13000g;

    public b(String name, String type, boolean z4, int i4, String str, int i5) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        this.f12994a = name;
        this.f12995b = type;
        this.f12996c = z4;
        this.f12997d = i4;
        this.f12998e = str;
        this.f12999f = i5;
        int i6 = 5;
        if (type != null) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String upperCase = type.toUpperCase(US);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            if (StringsKt.c(upperCase, "INT")) {
                i6 = 3;
            } else if (StringsKt.c(upperCase, "CHAR") || StringsKt.c(upperCase, "CLOB") || StringsKt.c(upperCase, "TEXT")) {
                i6 = 2;
            } else if (!StringsKt.c(upperCase, "BLOB")) {
                i6 = (StringsKt.c(upperCase, "REAL") || StringsKt.c(upperCase, "FLOA") || StringsKt.c(upperCase, "DOUB")) ? 4 : 1;
            }
        }
        this.f13000g = i6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f12997d != bVar.f12997d) {
            return false;
        }
        if (!Intrinsics.areEqual(this.f12994a, bVar.f12994a) || this.f12996c != bVar.f12996c) {
            return false;
        }
        int i4 = bVar.f12999f;
        String str = bVar.f12998e;
        String str2 = this.f12998e;
        int i5 = this.f12999f;
        if (i5 == 1 && i4 == 2 && str2 != null && !AbstractC0618a.a(str2, str)) {
            return false;
        }
        if (i5 != 2 || i4 != 1 || str == null || AbstractC0618a.a(str, str2)) {
            return (i5 == 0 || i5 != i4 || (str2 == null ? str == null : AbstractC0618a.a(str2, str))) && this.f13000g == bVar.f13000g;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.f12994a.hashCode() * 31) + this.f13000g) * 31) + (this.f12996c ? 1231 : 1237)) * 31) + this.f12997d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Column{name='");
        sb.append(this.f12994a);
        sb.append("', type='");
        sb.append(this.f12995b);
        sb.append("', affinity='");
        sb.append(this.f13000g);
        sb.append("', notNull=");
        sb.append(this.f12996c);
        sb.append(", primaryKeyPosition=");
        sb.append(this.f12997d);
        sb.append(", defaultValue='");
        String str = this.f12998e;
        if (str == null) {
            str = "undefined";
        }
        return g.r(sb, str, "'}");
    }
}
