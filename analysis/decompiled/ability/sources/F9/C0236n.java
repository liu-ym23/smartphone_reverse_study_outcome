package F9;

import java.text.DateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/* renamed from: F9.n, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0236n {

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f651j = Pattern.compile("(\\d{2,4})[^\\d]*");
    public static final Pattern k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    public static final Pattern l = Pattern.compile("(\\d{1,2})[^\\d]*");
    public static final Pattern m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a, reason: collision with root package name */
    public final String f652a;
    public final String b;
    public final long c;
    public final String d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    public C0236n(String str, String str2, long j5, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f652a = str;
        this.b = str2;
        this.c = j5;
        this.d = str3;
        this.e = str4;
        this.f = z10;
        this.g = z11;
        this.h = z12;
        this.i = z13;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0236n)) {
            return false;
        }
        C0236n c0236n = (C0236n) obj;
        return kotlin.jvm.internal.k.b(c0236n.f652a, this.f652a) && kotlin.jvm.internal.k.b(c0236n.b, this.b) && c0236n.c == this.c && kotlin.jvm.internal.k.b(c0236n.d, this.d) && kotlin.jvm.internal.k.b(c0236n.e, this.e) && c0236n.f == this.f && c0236n.g == this.g && c0236n.h == this.h && c0236n.i == this.i;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.i) + androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d(B7.a.c(B7.a.c(androidx.appfunctions.metadata.a.c(B7.a.c(B7.a.c(527, 31, this.f652a), 31, this.b), 31, this.c), 31, this.d), 31, this.e), 31, this.f), 31, this.g), 31, this.h);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f652a);
        sb.append('=');
        sb.append(this.b);
        if (this.h) {
            long j5 = this.c;
            if (j5 == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                String str = ((DateFormat) K9.d.f914a.get()).format(new Date(j5));
                kotlin.jvm.internal.k.e(str, "STANDARD_DATE_FORMAT.get().format(this)");
                sb.append(str);
            }
        }
        if (!this.i) {
            sb.append("; domain=");
            sb.append(this.d);
        }
        sb.append("; path=");
        sb.append(this.e);
        if (this.f) {
            sb.append("; secure");
        }
        if (this.g) {
            sb.append("; httponly");
        }
        String string = sb.toString();
        kotlin.jvm.internal.k.e(string, "toString()");
        return string;
    }
}
