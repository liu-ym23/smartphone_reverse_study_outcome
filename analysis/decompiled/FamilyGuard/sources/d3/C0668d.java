package d3;

import g3.C0742e;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.libpag.BuildConfig;

/* renamed from: d3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0668d {

    /* renamed from: a, reason: collision with root package name */
    public static String f16613a = "NetRequestUtil";

    /* renamed from: b, reason: collision with root package name */
    public static String f16614b = "If-None-Match";

    /* renamed from: c, reason: collision with root package name */
    public static String f16615c = "If-Modified-Since";

    public static String a(String str, String str2, Map<String, String> map, Map<String, String> map2) {
        String path;
        HashMap map3 = new HashMap(map);
        try {
            path = new URI(str2).getPath();
        } catch (URISyntaxException e6) {
            C0742e.l(f16613a, "Exception: " + e6.toString() + " - Cause: " + e6.getCause());
            path = BuildConfig.FLAVOR;
        }
        map3.put("key", S2.a.f5235e);
        if (map2 != null && map2.containsKey(f16614b)) {
            String str3 = f16614b;
            map3.put(str3, map2.get(str3));
        }
        if (map2 != null && map2.containsKey(f16615c)) {
            String str4 = f16615c;
            map3.put(str4, map2.get(str4));
        }
        ArrayList arrayList = new ArrayList(map3.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            String str5 = (String) obj;
            sb.append("&");
            sb.append(b(str5));
            sb.append("=");
            sb.append(b((String) map3.get(str5)));
        }
        return C0672h.c((str + "\n" + path + "\n" + sb.toString().substring(1)).getBytes());
    }

    private static String b(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
