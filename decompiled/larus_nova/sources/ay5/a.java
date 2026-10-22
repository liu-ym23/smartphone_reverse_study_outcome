package ay5;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static InterfaceC0245a f16751a;

    /* JADX INFO: renamed from: ay5.a$a, reason: collision with other inner class name */
    public interface InterfaceC0245a {
        boolean isSsQueriesHeaderOpen();

        boolean isSsQueriesOpen();

        boolean isSsQueriesPlaintextOpen();
    }

    public static String b(String r100) {
        return URLEncoder.encode(r100, "UTF-8");
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String c(List r100, boolean r101) {
        StringBuilder r102 = new StringBuilder();
        Iterator r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L25;
        Pair r104 = (Pair) r103.next();
        String r105 = (String) r104.first;
        if (r101 == false) goto L8;
        r105 = b(r105);
    L8:
        List r106 = (List) r104.second;
        if (r106 == null) goto L4;
        if (r106.size() <= 0) goto L4;
        Iterator r107 = r106.iterator();
    L14:
        if (r107.hasNext() == false) goto L4;
        String r108 = (String) r107.next();
        if (r101 == false) goto L21;
        if (r108 == null) goto L19;
        r108 = b(r108);
        goto L21
    L19:
        r108 = "";
    L21:
        if (r102.length() <= 0) goto L23;
        r102.append("&");
    L23:
        r102.append(r105);
        r102.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r102.append(r108);
        goto L14
    L25:
        return r102.toString();
    }

    public static void d(Uri r100, Map<String, List<String>> r110) throws IOException {
        if (r100 == null) goto L25;
        String r101 = r100.getEncodedQuery();     // Catch: Throwable -> L21
        if (r101 == null) goto L20;
        String[] r102 = r101.split("&");     // Catch: Throwable -> L21
        int r103 = r102.length;     // Catch: Throwable -> L21
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L31;
        String r105 = r102[r104];     // Catch: Throwable -> L21
        int r106 = r105.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L21
        if (r106 < 0) goto L15;
        String r107 = URLDecoder.decode(r105.substring(0, r106), "UTF-8");     // Catch: Throwable -> L21
        List<String> r108 = (List) ((LinkedHashMap) r110).get(r107);     // Catch: Throwable -> L21
        if (r108 != null) goto L14;
        r108 = new LinkedList();     // Catch: Throwable -> L21
    L14:
        r108.add(URLDecoder.decode(r105.substring(r106 + 1), "UTF-8"));     // Catch: Throwable -> L21
        r110.put(r107, r108);     // Catch: Throwable -> L21
    L19:
        r104 = r104 + 1;
        goto L7
    L15:
        String r109 = URLDecoder.decode(r105, "UTF-8");     // Catch: Throwable -> L21
        List<String> r111 = (List) ((LinkedHashMap) r110).get(r109);     // Catch: Throwable -> L21
        if (r111 != null) goto L18;
        r111 = new LinkedList();     // Catch: Throwable -> L21
    L18:
        r111.add("");     // Catch: Throwable -> L21
        r110.put(r109, r111);     // Catch: Throwable -> L21
        goto L19
    L31:
        return;
    L20:
        return;
    L21:
        th = move-exception;
        th.printStackTrace();
        throw new IOException("parseUrl url is null !!!");
    L25:
        throw new IOException("parseUrl url is null !!!");
    }

    public static String f(String r110, List<Pair<String, String>> r111) {
        if (TextUtils.isEmpty(r110) == false) goto L6;
        return r110;
    L6:
        if (f16751a != null) goto L8;
        return r110;
    L8:
        LinkedHashMap r100 = new LinkedHashMap();
        Uri r101 = UriProtector.parse(r110);     // Catch: Throwable -> L32
        d(r101, r100);     // Catch: Throwable -> L32
        LinkedList r102 = new LinkedList();     // Catch: Throwable -> L32
        e(r100, r102, "device_id");     // Catch: Throwable -> L32
        e(r100, r102, "device_type");     // Catch: Throwable -> L32
        e(r100, r102, "device_brand");     // Catch: Throwable -> L32
        e(r100, r102, ST.UUID_DEVICE);     // Catch: Throwable -> L32
        e(r100, r102, "openudid");     // Catch: Throwable -> L32
        String r103 = c(r102, false);     // Catch: Throwable -> L32
        if (TextUtils.isEmpty(r103) == false) goto L12;
        return r110;
    L12:
        byte[] r104 = r103.getBytes();     // Catch: Throwable -> L32
        byte[] r105 = EncryptorUtil.b(r104, r104.length);     // Catch: Throwable -> L32
        if (r105 != null) goto L15;
        return r110;
    L15:
        String r106 = Base64.encodeToString(r105, 2);     // Catch: Throwable -> L32
        LinkedList r107 = new LinkedList();     // Catch: Throwable -> L32
        if (f16751a.isSsQueriesOpen() == false) goto L19;
        LinkedList r108 = new LinkedList();     // Catch: Throwable -> L32
        r108.add(r106);     // Catch: Throwable -> L32
        r107.add(new Pair("ss_queries", r108));     // Catch: Throwable -> L32
    L19:
        if (f16751a.isSsQueriesHeaderOpen() == false) goto L22;
        LinkedList r112 = (LinkedList) r111;     // Catch: Throwable -> L32
        r112.add(new Pair("X-SS-QUERIES", b(r106)));     // Catch: Throwable -> L32
    L22:
        if (r100.isEmpty() == true) goto L30;
        Iterator r113 = r100.entrySet().iterator();     // Catch: Throwable -> L32
    L25:
        if (r113.hasNext() == false) goto L30;
        Map.Entry r109 = (Map.Entry) r113.next();     // Catch: Throwable -> L32
        if (r109 == null) goto L25;
        r107.add(new Pair(r109.getKey(), r109.getValue()));     // Catch: Throwable -> L32
    L30:
        String r114 = c(r107, true);     // Catch: Throwable -> L32
        return a(r101.getScheme(), r101.getHost(), r101.getPort(), r101.getPath(), r114, r101.getFragment()).toString();
    L32:
        th = move-exception;
        th.printStackTrace();
        return r110;
    }

    public static void e(Map r100, List r101, String r102) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(r102) == false) goto L6;
        return;
    L6:
        if (r100.containsKey(r102) == false) goto L11;
        LinkedList r103 = (LinkedList) r101;
        r103.add(new Pair(r102, ((LinkedHashMap) r100).get(r102)));
        if (f16751a.isSsQueriesPlaintextOpen() == true) goto L12;
        r100.remove(r102);
        return;
    L12:
        return;
    }

    public static Uri a(String r100, String r101, int r102, String r103, String r104, String r105) {
        StringBuilder r106 = new StringBuilder();
        if (r101 == null) goto L9;
        if (r100 == null) goto L6;
        r106.append(r100);
        r106.append("://");
    L6:
        r106.append(r101);
        if (r102 <= 0) goto L9;
        r106.append(':');
        r106.append(r102);
    L9:
        if (r103 != null) goto L11;
    L12:
        r106.append('/');
    L13:
        if (r103 == null) goto L15;
        r106.append(r103);
    L15:
        if (r104 == null) goto L17;
        r106.append('?');
        r106.append(r104);
    L17:
        if (r105 == null) goto L20;
        r106.append('#');
        r106.append(r105);
    L20:
        return UriProtector.parse(r106.toString());
    L11:
        if (r103.startsWith(HTTP.URL_DEFAULT) == true) goto L13;
        goto L12
    }
}
