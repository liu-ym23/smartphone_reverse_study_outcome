package p6;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.e;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.RequestHandler;
import com.bytedance.frameworks.baselib.network.http.util.g;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    public static class a implements RequestHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f23345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HttpURLConnection f23346b;

        public a(String r10, HttpURLConnection r11) {
            this.f23345a = r10;
            this.f23346b = r11;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.RequestHandler
        public void abort() {
            HttpURLConnection r10 = this.f23346b;     // Catch: Throwable -> L6
            if (r10 == null) goto L9;
            r10.disconnect();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.RequestHandler
        public URI getURI() {
            return g.b(this.f23345a);
        L4:
            return null;
        }
    }

    public static String a(String r10, Map r11, Map r12, p6.a r13) {
        HttpURLConnection r14 = null;
        if (e.b(r10) == true) goto L90;
        if (r13 == null) goto L90;
        if (NetworkUtils.l(TTNetInit.getTTNetDepend().getContext()) == true) goto L98;
        return null;
    L98:
    L18:
        th = th;
    L94:
        th.printStackTrace();     // Catch: Throwable -> L86
        throw th;     // Catch: Throwable -> L86
    L86:
        th = move-exception;
        if (r14 != null) goto L100;
    L89:
        throw th;
    L100:
        r14.disconnect();     // Catch: Exception -> L93
        goto L89
    L10:
        if (r13.f23339g == false) goto L26;
        String r15 = NetworkParams.a(r10, true);     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r15) == true) goto L26;
        if (r15.equals(r10) == false) goto L25;
        StringBuilder r16 = new StringBuilder(r15);     // Catch: Throwable -> L18
        if (r15.indexOf(63) >= 0) goto L20;
        r16.append("?");     // Catch: Throwable -> L18
    L21:
        r16.append("aid=");     // Catch: Throwable -> L18
        r16.append(TTNetInit.getTTNetDepend().getAppId());     // Catch: Throwable -> L18
        r16.append("&device_platform=");     // Catch: Throwable -> L18
        r16.append("android");     // Catch: Throwable -> L18
        if (TTNetInit.getCronetProvider() == null) goto L24;
        r16.append("&version_code=");     // Catch: Throwable -> L18
        r16.append(TTNetInit.getCronetProvider().getVersionCode());     // Catch: Throwable -> L18
        r16.append("&channel=");     // Catch: Throwable -> L18
        r16.append(TTNetInit.getCronetProvider().getChannel());     // Catch: Throwable -> L18
        r16.append("device_id");     // Catch: Throwable -> L18
        r16.append(TTNetInit.getCronetProvider().getDeviceId());     // Catch: Throwable -> L18
    L24:
        r10 = r16.toString();     // Catch: Throwable -> L18
        goto L26
    L20:
        r16.append("&");     // Catch: Throwable -> L18
        goto L21
    L25:
        r10 = r15;
    L26:
        HttpURLConnection r17 = (HttpURLConnection) new URL(r10).openConnection();     // Catch: Throwable -> L18
        r17.setRequestMethod("GET");     // Catch: Throwable -> L30
        r17.setConnectTimeout(NetworkParams.g());     // Catch: Throwable -> L30
        r17.setReadTimeout(NetworkParams.k());     // Catch: Throwable -> L30
        r17.setInstanceFollowRedirects(true);     // Catch: Throwable -> L30
        r17.setRequestProperty("Accept-Encoding", "gzip");     // Catch: Throwable -> L30
        if (r13.f23338f == false) goto L32;
        String r18 = " HttpsURLConnection";
    L33:
        r17.setRequestProperty("User-Agent", "ttnet" + r18);     // Catch: Throwable -> L30
        if (r11 != null) goto L36;
    L41:
        int r19 = r17.getResponseCode();     // Catch: Throwable -> L30
        r13.f23333a = r19;     // Catch: Throwable -> L30
        if (r12 == null) goto L54;
        if (r17.getHeaderFields() == null) goto L54;
        Map<String, List<String>> r20 = r17.getHeaderFields();     // Catch: Throwable -> L30
        if (r20 == null) goto L54;
        Iterator<Map.Entry<String, List<String>>> r21 = r20.entrySet().iterator();     // Catch: Throwable -> L30
    L49:
        if (r21.hasNext() == false) goto L54;
        Map.Entry<String, List<String>> r22 = r21.next();     // Catch: Throwable -> L30
        String r23 = r22.getKey();     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r23) == true) goto L49;
        r12.put(r23.toLowerCase(), r22.getValue());     // Catch: Throwable -> L30
    L54:
        if (r13.f23338f == true) goto L56;
        r13.f23337e = r17.getHeaderField("X-SS-SIGN");     // Catch: Throwable -> L30
    L56:
        r13.f23340h = r17.getHeaderField("x-ss-etag");     // Catch: Throwable -> L30
        r13.f23341i = r17.getHeaderField("x-tt-tnc-abtest");     // Catch: Throwable -> L30
        r13.f23342j = r17.getHeaderField("x-tt-tnc-control");     // Catch: Throwable -> L30
        r13.f23343k = r17.getHeaderField("x-tt-tnc-config");     // Catch: Throwable -> L30
        r13.f23344l = r17.getHeaderField("x-ss-canary");     // Catch: Throwable -> L30
        if (r19 != 200) goto L83;
        InputStream r24 = r17.getInputStream();     // Catch: Throwable -> L30
        boolean r25 = "gzip".equals(r17.getHeaderField("Content-Encoding"));     // Catch: Throwable -> L30
        String r110 = r17.getHeaderField("Content-Type");     // Catch: Throwable -> L30
        boolean r111 = v4.c.k(r110);     // Catch: Throwable -> L30
        Pair r112 = RetrofitUtils.i(r110);     // Catch: Throwable -> L30
        if (r112 == null) goto L65;
        Object r113 = r112.second;     // Catch: Throwable -> L30
        if (r113 == null) goto L65;
        if (Charset.isSupported((String) r113) == false) goto L65;
        String r114 = (String) r112.second;     // Catch: Throwable -> L30
    L66:
        if (r114 != null) goto L68;
        r114 = "UTF-8";
    L68:
        int[] r26 = {0};     // Catch: Throwable -> L30
        byte[] r27 = v4.c.h(r25, r17.getHeaderFields(), -1, r24, r26, new a(r10, r17));     // Catch: Throwable -> L30
        if (r27 == null) goto L102;
        int r28 = r26[0];     // Catch: Throwable -> L30
        if (r28 <= 0) goto L102;
        if (r28 > r27.length) goto L102;
        if (r111 == false) goto L77;
        v4.c.a(r27, r28);     // Catch: Throwable -> L30
    L77:
        String r115 = new String(r27, 0, r26[0], r114);     // Catch: Throwable -> L30
        r17.disconnect();     // Catch: Exception -> L91
    L79:
        return r115;
    L102:
        r17.disconnect();     // Catch: Exception -> L92
    L81:
        return null;
    L65:
        r114 = null;
        goto L66
    L83:
        throw new IOException("err status = " + r19);     // Catch: Throwable -> L30
    L36:
        if (r11.size() <= 0) goto L41;
        Iterator r116 = r11.entrySet().iterator();     // Catch: Throwable -> L30
    L39:
        if (r116.hasNext() == false) goto L41;
        Map.Entry r29 = (Map.Entry) r116.next();     // Catch: Throwable -> L30
        r17.setRequestProperty((String) r29.getKey(), (String) r29.getValue());     // Catch: Throwable -> L30
        goto L39
    L32:
        r18 = " HttpURLConnection";
    L30:
        th = th;
        r14 = r17;
    L90:
        return null;
    }
}
