package ab;

import java.text.DateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f558j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f559k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f560l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f561m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a, reason: collision with root package name */
    public final String f562a;

    /* renamed from: b, reason: collision with root package name */
    public final String f563b;

    /* renamed from: c, reason: collision with root package name */
    public final long f564c;

    /* renamed from: d, reason: collision with root package name */
    public final String f565d;

    /* renamed from: e, reason: collision with root package name */
    public final String f566e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f567f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f568g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f569h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f570i;

    public j(String str, String str2, long j2, String str3, String str4, boolean z4, boolean z10, boolean z11, boolean z12) {
        this.f562a = str;
        this.f563b = str2;
        this.f564c = j2;
        this.f565d = str3;
        this.f566e = str4;
        this.f567f = z4;
        this.f568g = z10;
        this.f569h = z11;
        this.f570i = z12;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return q7.k.a(jVar.f562a, this.f562a) && q7.k.a(jVar.f563b, this.f563b) && jVar.f564c == this.f564c && q7.k.a(jVar.f565d, this.f565d) && q7.k.a(jVar.f566e, this.f566e) && jVar.f567f == this.f567f && jVar.f568g == this.f568g && jVar.f569h == this.f569h && jVar.f570i == this.f570i;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f570i) + m.x.e(m.x.e(m.x.e(m.x.g(this.f566e, m.x.g(this.f565d, m.x.f(this.f564c, m.x.g(this.f563b, m.x.g(this.f562a, 527, 31), 31), 31), 31), 31), 31, this.f567f), 31, this.f568g), 31, this.f569h);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f562a);
        sb2.append('=');
        sb2.append(this.f563b);
        if (this.f569h) {
            long j2 = this.f564c;
            if (j2 == Long.MIN_VALUE) {
                sb2.append("; max-age=0");
            } else {
                sb2.append("; expires=");
                String str = ((DateFormat) fb.d.f3648a.get()).format(new Date(j2));
                q7.k.d(str, "STANDARD_DATE_FORMAT.get().format(this)");
                sb2.append(str);
            }
        }
        if (!this.f570i) {
            sb2.append("; domain=");
            sb2.append(this.f565d);
        }
        sb2.append("; path=");
        sb2.append(this.f566e);
        if (this.f567f) {
            sb2.append("; secure");
        }
        if (this.f568g) {
            sb2.append("; httponly");
        }
        String string = sb2.toString();
        q7.k.d(string, "toString()");
        return string;
    }
}
