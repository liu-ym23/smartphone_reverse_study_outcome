package y0;

import O6.l;
import android.util.Base64;
import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f43760a;

    /* renamed from: b, reason: collision with root package name */
    public final String f43761b;

    /* renamed from: c, reason: collision with root package name */
    public final String f43762c;

    /* renamed from: d, reason: collision with root package name */
    public final List<List<byte[]>> f43763d;

    /* renamed from: e, reason: collision with root package name */
    public final int f43764e;

    /* renamed from: f, reason: collision with root package name */
    public final String f43765f;

    /* renamed from: g, reason: collision with root package name */
    public final String f43766g;

    /* renamed from: h, reason: collision with root package name */
    public final String f43767h;

    public e(String str, String str2, String str3, List<List<byte[]>> list) {
        this(str, str2, str3, list, null, null);
    }

    public final String a(String str, String str2, String str3, String str4, String str5) {
        return str + l.DATE_SEPARATOR + str2 + l.DATE_SEPARATOR + str3 + l.DATE_SEPARATOR + str4 + l.DATE_SEPARATOR + str5;
    }

    public List<List<byte[]>> b() {
        return this.f43763d;
    }

    public int c() {
        return this.f43764e;
    }

    public String d() {
        return this.f43767h;
    }

    public String e() {
        return this.f43760a;
    }

    public String f() {
        return this.f43761b;
    }

    public String g() {
        return this.f43762c;
    }

    public String h() {
        return this.f43765f;
    }

    public String i() {
        return this.f43766g;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FontRequest {mProviderAuthority: " + this.f43760a + ", mProviderPackage: " + this.f43761b + ", mQuery: " + this.f43762c + ", mSystemFont: " + this.f43765f + ", mVariationSettings: " + this.f43766g + ", mCertificates:");
        for (int i10 = 0; i10 < this.f43763d.size(); i10++) {
            sb2.append(" [");
            List<byte[]> list = this.f43763d.get(i10);
            for (int i11 = 0; i11 < list.size(); i11++) {
                sb2.append(" \"");
                sb2.append(Base64.encodeToString(list.get(i11), 0));
                sb2.append("\"");
            }
            sb2.append(" ]");
        }
        sb2.append("}");
        sb2.append("mCertificatesArray: " + this.f43764e);
        return sb2.toString();
    }

    public e(String str, String str2, String str3, List<List<byte[]>> list, String str4, String str5) {
        this.f43760a = (String) B0.h.f(str);
        this.f43761b = (String) B0.h.f(str2);
        this.f43762c = (String) B0.h.f(str3);
        this.f43763d = (List) B0.h.f(list);
        this.f43764e = 0;
        this.f43765f = str4;
        this.f43766g = str5;
        this.f43767h = a(str, str2, str3, str4, str5);
    }
}
