package ak5;

import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes18.dex */
public final class x implements l {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f4059j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, String> f4062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, String> f4063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, String> f4064e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, List<String>> f4065f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, List<String>> f4066g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f4067h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f4068i;

    @Override // ak5.l
    public final String a() {
        String r100 = this.f4067h;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        String r101 = this.f4061b;
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        if (r100.toLowerCase().startsWith("https://") == false) goto L12;
        r100 = r100.replaceFirst("https://", "");
    L12:
        if (r100.toLowerCase().startsWith("http://") == false) goto L14;
        r100 = r100.replaceFirst("http://", "");
        boolean r102 = true;
    L15:
        Uri.Builder r103 = new Uri.Builder();
        if (r102 == false) goto L18;
        Uri.Builder r104 = r103.scheme("http");
    L19:
        Uri.Builder r105 = r104.authority(r100);
        if (r101.contains("?") == false) goto L42;
        String r106 = this.f4067h;
        if (r106 != null) goto L24;
        r106 = "";
    L24:
        String r107 = this.f4061b;
        if (r107 != null) goto L28;
        r107 = "";
    L28:
        if (r106.endsWith(HTTP.URL_DEFAULT) == true) goto L31;
        r106 = r106.concat(HTTP.URL_DEFAULT);
    L31:
        if (r106.startsWith("http") == true) goto L34;
        r106 = "https://".concat(r106);
    L34:
        if (r107.startsWith(HTTP.URL_DEFAULT) == false) goto L36;
        r107 = r107.replaceFirst(HTTP.URL_DEFAULT, "");
    L36:
        Uri r108 = UriProtector.parse(r106 + r107);
        r105.path(r108.getPath());
        Set<String> r109 = UriProtector.getQueryParameterNames(r108);
        if (r109 == null) goto L43;
        Iterator<String> r110 = r109.iterator();
    L40:
        if (r110.hasNext() == false) goto L43;
        String r111 = r110.next();
        r105.appendQueryParameter(r111, UriProtector.getQueryParameter(r108, r111));
    L43:
        Iterator<Map.Entry<String, String>> r112 = this.f4064e.entrySet().iterator();
    L45:
        if (r112.hasNext() == false) goto L47;
        Map.Entry<String, String> r113 = r112.next();
        r105.appendQueryParameter(r113.getKey(), r113.getValue());
        goto L45
    L47:
        Map<String, List<String>> r114 = this.f4065f;
        if (r114 == null) goto L63;
        if (r114.size() <= 0) goto L63;
        Iterator<Map.Entry<String, List<String>>> r115 = this.f4065f.entrySet().iterator();
    L53:
        if (r115.hasNext() == false) goto L63;
        Map.Entry<String, List<String>> r116 = r115.next();
        List<String> r117 = r116.getValue();
        if (r117 == null) goto L53;
        if (r117.size() <= 0) goto L53;
        Iterator<String> r118 = r117.iterator();
    L60:
        if (r118.hasNext() == false) goto L53;
        r105.appendQueryParameter(r116.getKey(), r118.next());
    L63:
        return r105.build().toString();
    L42:
        r105.path(this.f4061b);
        goto L43
    L18:
        r104 = r103.scheme("https");
        goto L19
    L14:
        r102 = false;
        goto L15
    }

    public final String toString() {
        return "SimpleNetRequest{requestMethod=" + this.f4060a + ", mPath='" + this.f4061b + "', mBodyParams=" + this.f4062c + ", mHeaderParams=" + this.f4063d + ", mUrlParams=" + this.f4064e + ", mHost='" + this.f4067h + "'}";
    }

    @Override // ak5.l
    public final Map<String, String> b() {
        return this.f4063d;
    }

    @Override // ak5.l
    public final Map<String, List<String>> c() {
        return this.f4066g;
    }

    @Override // ak5.l
    public final String d() {
        return this.f4068i;
    }

    @Override // ak5.l
    public final Map<String, String> e() {
        return this.f4062c;
    }

    @Override // ak5.l
    public final int getRequestType() {
        return this.f4060a;
    }

    public x(String r100) {
        this.f4060a = 2;
        this.f4062c = new HashMap();
        this.f4063d = new HashMap();
        this.f4064e = new HashMap();
        this.f4067h = f4059j;
        this.f4061b = r100;
    }
}
