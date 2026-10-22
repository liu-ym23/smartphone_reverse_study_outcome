package k3;

import android.util.Base64;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f7213a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7214b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7215c;

    /* renamed from: d, reason: collision with root package name */
    public final List f7216d;

    /* renamed from: e, reason: collision with root package name */
    public final String f7217e;

    /* renamed from: f, reason: collision with root package name */
    public final String f7218f;

    /* renamed from: g, reason: collision with root package name */
    public final String f7219g;

    public c(String str, String str2, String str3, List list, String str4, String str5) {
        str.getClass();
        this.f7213a = str;
        str2.getClass();
        this.f7214b = str2;
        this.f7215c = str3;
        list.getClass();
        this.f7216d = list;
        this.f7217e = str4;
        this.f7218f = str5;
        this.f7219g = str + "-" + str2 + "-" + str3 + "-" + str4 + "-" + str5;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FontRequest {mProviderAuthority: " + this.f7213a + ", mProviderPackage: " + this.f7214b + ", mQuery: " + this.f7215c + ", mSystemFont: " + this.f7217e + ", mVariationSettings: " + this.f7218f + ", mCertificates:");
        int i = 0;
        while (true) {
            List list = this.f7216d;
            if (i >= list.size()) {
                sb2.append("}mCertificatesArray: 0");
                return sb2.toString();
            }
            sb2.append(" [");
            List list2 = (List) list.get(i);
            for (int i3 = 0; i3 < list2.size(); i3++) {
                sb2.append(" \"");
                sb2.append(Base64.encodeToString((byte[]) list2.get(i3), 0));
                sb2.append("\"");
            }
            sb2.append(" ]");
            i++;
        }
    }
}
