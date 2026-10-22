package b0;

import android.util.Base64;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f815a;

    /* renamed from: b, reason: collision with root package name */
    public final String f816b;

    /* renamed from: c, reason: collision with root package name */
    public final String f817c;
    public final List d;

    /* renamed from: e, reason: collision with root package name */
    public final String f818e;

    /* renamed from: f, reason: collision with root package name */
    public final String f819f;

    /* renamed from: g, reason: collision with root package name */
    public final String f820g;

    public e(String str, String str2, String str3, List list, String str4, String str5) {
        str.getClass();
        this.f815a = str;
        str2.getClass();
        this.f816b = str2;
        this.f817c = str3;
        list.getClass();
        this.d = list;
        this.f818e = str4;
        this.f819f = str5;
        this.f820g = str + "-" + str2 + "-" + str3 + "-" + str4 + "-" + str5;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f815a + ", mProviderPackage: " + this.f816b + ", mQuery: " + this.f817c + ", mSystemFont: " + this.f818e + ", mVariationSettings: " + this.f819f + ", mCertificates:");
        int i8 = 0;
        while (true) {
            List list = this.d;
            if (i8 >= list.size()) {
                sb.append("}mCertificatesArray: 0");
                return sb.toString();
            }
            sb.append(" [");
            List list2 = (List) list.get(i8);
            for (int i9 = 0; i9 < list2.size(); i9++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list2.get(i9), 0));
                sb.append("\"");
            }
            sb.append(" ]");
            i8++;
        }
    }
}
