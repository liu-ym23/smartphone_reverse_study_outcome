package qa;

import androidx.datastore.preferences.protobuf.b1;
import com.stepos.core.ota.domain.OtaAction;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {
    public static String a(String str, String str2, HashMap map) {
        String path;
        HashMap map2 = new HashMap(map);
        try {
            path = new URI(str2).getPath();
        } catch (URISyntaxException e10) {
            ta.c.f("NetRequestUtil", "Exception: " + e10.toString() + " - Cause: " + e10.getCause());
            path = "";
        }
        map2.put("key", b1.f1791n);
        ArrayList arrayList = new ArrayList(map2.keySet());
        Collections.sort(arrayList);
        StringBuilder sb2 = new StringBuilder();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            String str3 = (String) obj;
            sb2.append("&");
            sb2.append(b(str3));
            sb2.append("=");
            sb2.append(b((String) map2.get(str3)));
        }
        return h.a((str + "\n" + path + "\n" + sb2.toString().substring(1)).getBytes());
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, "UTF-8").replace("+", "%20").replace(OtaAction.GLOBAL, "%2A").replace("%7E", "~");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
