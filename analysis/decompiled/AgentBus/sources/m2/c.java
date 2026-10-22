package m2;

import android.util.Base64;
import java.util.List;
import m.x;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f6135a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6136b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6137c;

    /* renamed from: d, reason: collision with root package name */
    public final List f6138d;

    /* renamed from: e, reason: collision with root package name */
    public final String f6139e;

    /* renamed from: f, reason: collision with root package name */
    public final String f6140f;

    public c(String str, String str2, String str3, List list, String str4, String str5) {
        str.getClass();
        this.f6135a = str;
        str2.getClass();
        this.f6136b = str2;
        this.f6137c = str3;
        list.getClass();
        this.f6138d = list;
        this.f6139e = str4;
        this.f6140f = str5;
        StringBuilder sbP = x.p(str, "-", str2, "-", str3);
        sbP.append("-");
        sbP.append(str4);
        sbP.append("-");
        sbP.append(str5);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FontRequest {mProviderAuthority: " + this.f6135a + ", mProviderPackage: " + this.f6136b + ", mQuery: " + this.f6137c + ", mSystemFont: " + this.f6139e + ", mVariationSettings: " + this.f6140f + ", mCertificates:");
        int i2 = 0;
        while (true) {
            List list = this.f6138d;
            if (i2 >= list.size()) {
                sb2.append("}mCertificatesArray: 0");
                return sb2.toString();
            }
            sb2.append(" [");
            List list2 = (List) list.get(i2);
            for (int i10 = 0; i10 < list2.size(); i10++) {
                sb2.append(" \"");
                sb2.append(Base64.encodeToString((byte[]) list2.get(i10), 0));
                sb2.append("\"");
            }
            sb2.append(" ]");
            i2++;
        }
    }
}
