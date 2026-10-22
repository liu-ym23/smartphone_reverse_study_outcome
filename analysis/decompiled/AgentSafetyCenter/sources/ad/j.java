package ad;

import java.text.DateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f521j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k, reason: collision with root package name */
    public static final Pattern f522k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f523l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f524m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a, reason: collision with root package name */
    public String f525a;

    /* renamed from: b, reason: collision with root package name */
    public String f526b;

    /* renamed from: c, reason: collision with root package name */
    public long f527c;

    /* renamed from: d, reason: collision with root package name */
    public String f528d;

    /* renamed from: e, reason: collision with root package name */
    public String f529e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f530f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f531g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f532h;
    public boolean i;

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return jVar.f525a.equals(this.f525a) && jVar.f526b.equals(this.f526b) && jVar.f527c == this.f527c && jVar.f528d.equals(this.f528d) && jVar.f529e.equals(this.f529e) && jVar.f530f == this.f530f && jVar.f531g == this.f531g && jVar.f532h == this.f532h && jVar.i == this.i;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.i) + k0.a.h(k0.a.h(k0.a.h(androidx.activity.b.d(androidx.activity.b.d(k0.a.i(this.f527c, androidx.activity.b.d(androidx.activity.b.d(527, 31, this.f525a), 31, this.f526b), 31), 31, this.f528d), 31, this.f529e), 31, this.f530f), 31, this.f531g), 31, this.f532h);
    }

    public final String toString() {
        long j10 = this.f527c;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f525a);
        sb2.append('=');
        sb2.append(this.f526b);
        if (this.f532h) {
            if (j10 == Long.MIN_VALUE) {
                sb2.append("; max-age=0");
            } else {
                sb2.append("; expires=");
                String str = ((DateFormat) fd.c.f4059a.get()).format(new Date(j10));
                str.getClass();
                sb2.append(str);
            }
        }
        if (!this.i) {
            sb2.append("; domain=");
            sb2.append(this.f528d);
        }
        sb2.append("; path=");
        sb2.append(this.f529e);
        if (this.f530f) {
            sb2.append("; secure");
        }
        if (this.f531g) {
            sb2.append("; httponly");
        }
        return sb2.toString();
    }
}
