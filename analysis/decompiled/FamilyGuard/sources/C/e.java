package C;

import android.util.Base64;
import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final String f254a;

    /* renamed from: b, reason: collision with root package name */
    private final String f255b;

    /* renamed from: c, reason: collision with root package name */
    private final String f256c;

    /* renamed from: d, reason: collision with root package name */
    private final List<List<byte[]>> f257d;

    /* renamed from: e, reason: collision with root package name */
    private final int f258e = 0;

    /* renamed from: f, reason: collision with root package name */
    private final String f259f;

    public e(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f254a = (String) D.h.e(str);
        this.f255b = (String) D.h.e(str2);
        this.f256c = (String) D.h.e(str3);
        this.f257d = (List) D.h.e(list);
        this.f259f = a(str, str2, str3);
    }

    private String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List<List<byte[]>> b() {
        return this.f257d;
    }

    public int c() {
        return this.f258e;
    }

    String d() {
        return this.f259f;
    }

    public String e() {
        return this.f254a;
    }

    public String f() {
        return this.f255b;
    }

    public String g() {
        return this.f256c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f254a + ", mProviderPackage: " + this.f255b + ", mQuery: " + this.f256c + ", mCertificates:");
        for (int i5 = 0; i5 < this.f257d.size(); i5++) {
            sb.append(" [");
            List<byte[]> list = this.f257d.get(i5);
            for (int i6 = 0; i6 < list.size(); i6++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i6), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f258e);
        return sb.toString();
    }
}
