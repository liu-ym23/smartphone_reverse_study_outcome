package s0;

import android.util.Base64;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f11836a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11837b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11838c;

    /* renamed from: d, reason: collision with root package name */
    public final List<List<byte[]>> f11839d;

    /* renamed from: e, reason: collision with root package name */
    public final String f11840e;

    /* renamed from: f, reason: collision with root package name */
    public final String f11841f;

    /* renamed from: g, reason: collision with root package name */
    public final String f11842g;

    public e() {
        throw null;
    }

    public e(String str, String str2, String str3, List<List<byte[]>> list, String str4, String str5) {
        str.getClass();
        this.f11836a = str;
        str2.getClass();
        this.f11837b = str2;
        this.f11838c = str3;
        list.getClass();
        this.f11839d = list;
        this.f11840e = str4;
        this.f11841f = str5;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("-");
        sb2.append(str2);
        sb2.append("-");
        sb2.append(str3);
        this.f11842g = com.stepos.core.ota.d.j(sb2, "-", str4, "-", str5);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FontRequest {mProviderAuthority: " + this.f11836a + ", mProviderPackage: " + this.f11837b + ", mQuery: " + this.f11838c + ", mSystemFont: " + this.f11840e + ", mVariationSettings: " + this.f11841f + ", mCertificates:");
        int i10 = 0;
        while (true) {
            List<List<byte[]>> list = this.f11839d;
            if (i10 >= list.size()) {
                sb2.append("}mCertificatesArray: 0");
                return sb2.toString();
            }
            sb2.append(" [");
            List<byte[]> list2 = list.get(i10);
            for (int i11 = 0; i11 < list2.size(); i11++) {
                sb2.append(" \"");
                sb2.append(Base64.encodeToString(list2.get(i11), 0));
                sb2.append("\"");
            }
            sb2.append(" ]");
            i10++;
        }
    }
}
