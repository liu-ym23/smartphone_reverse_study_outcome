package n6;

import java.text.DateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f4037k = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f4038l = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f4039m = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: n, reason: collision with root package name */
    public static final Pattern f4040n = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a, reason: collision with root package name */
    public final String f4041a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4042b;

    /* renamed from: c, reason: collision with root package name */
    public final long f4043c;
    public final String d;

    /* renamed from: e, reason: collision with root package name */
    public final String f4044e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f4045f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f4046g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f4047h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f4048i;

    /* renamed from: j, reason: collision with root package name */
    public final String f4049j;

    public i(String str, String str2, long j4, String str3, String str4, boolean z, boolean z2, boolean z8, boolean z9, String str5) {
        this.f4041a = str;
        this.f4042b = str2;
        this.f4043c = j4;
        this.d = str3;
        this.f4044e = str4;
        this.f4045f = z;
        this.f4046g = z2;
        this.f4047h = z8;
        this.f4048i = z9;
        this.f4049j = str5;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return kotlin.jvm.internal.p.a(iVar.f4041a, this.f4041a) && kotlin.jvm.internal.p.a(iVar.f4042b, this.f4042b) && iVar.f4043c == this.f4043c && kotlin.jvm.internal.p.a(iVar.d, this.d) && kotlin.jvm.internal.p.a(iVar.f4044e, this.f4044e) && iVar.f4045f == this.f4045f && iVar.f4046g == this.f4046g && iVar.f4047h == this.f4047h && iVar.f4048i == this.f4048i && kotlin.jvm.internal.p.a(iVar.f4049j, this.f4049j);
    }

    public final int hashCode() {
        int iG = a8.b.g(a8.b.g(a8.b.g(a8.b.g(a8.b.f(a8.b.f(a8.b.e(a8.b.f(a8.b.f(527, 31, this.f4041a), 31, this.f4042b), 31, this.f4043c), 31, this.d), 31, this.f4044e), 31, this.f4045f), 31, this.f4046g), 31, this.f4047h), 31, this.f4048i);
        String str = this.f4049j;
        return iG + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4041a);
        sb.append('=');
        sb.append(this.f4042b);
        if (this.f4047h) {
            long j4 = this.f4043c;
            if (j4 == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                String str = ((DateFormat) s6.d.f5244a.get()).format(new Date(j4));
                kotlin.jvm.internal.p.d(str, "format(...)");
                sb.append(str);
            }
        }
        if (!this.f4048i) {
            sb.append("; domain=");
            sb.append(this.d);
        }
        sb.append("; path=");
        sb.append(this.f4044e);
        if (this.f4045f) {
            sb.append("; secure");
        }
        if (this.f4046g) {
            sb.append("; httponly");
        }
        String str2 = this.f4049j;
        if (str2 != null) {
            sb.append("; samesite=");
            sb.append(str2);
        }
        String string = sb.toString();
        kotlin.jvm.internal.p.d(string, "toString(...)");
        return string;
    }
}
