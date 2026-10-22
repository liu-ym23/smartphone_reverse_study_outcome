package com.bytedance.ttnet.http;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class HttpURLConnClient {
    public HttpURLConnClient() {
    }

    public static String executeGet(final String r12, Map<String, String> r13, Map<String, List<String>> r14, GetDomainContext r15) throws Throwable {
        HttpURLConnection r4 = null;
        if (StringUtils.isEmpty(r12) == true) goto L91;
        if (r15 == null) goto L91;
        if (NetworkUtils.isNetworkAvailable(TTNetInit.getTTNetDepend().getContext()) == true) goto L95;
        return null;
    L95:
    L84:
        th = th;
    L101:
        th.printStackTrace();     // Catch: Throwable -> L87
        throw th;     // Catch: Throwable -> L87
    L87:
        th = move-exception;
        if (r4 != null) goto L99;
    L90:
        throw th;
    L99:
        r4.disconnect();     // Catch: Exception -> L94
        goto L90
    L10:
        if (r15.addCommonParam == false) goto L24;
        String r3 = NetworkParams.addCommonParams(r12, true);     // Catch: Throwable -> L84
        if (TextUtils.isEmpty(r3) == true) goto L24;
        if (r3.equals(r12) == false) goto L23;
        StringBuilder r16 = new StringBuilder(r3);     // Catch: Throwable -> L84
        if (r3.indexOf(63) >= 0) goto L18;
        r16.append("?");     // Catch: Throwable -> L84
    L19:
        r16.append("aid=").append(TTNetInit.getTTNetDepend().getAppId()).append("&device_platform=android");     // Catch: Throwable -> L84
        if (TTNetInit.getCronetProvider() == null) goto L22;
        r16.append("&version_code=").append(TTNetInit.getCronetProvider().getVersionCode()).append("&channel=").append(TTNetInit.getCronetProvider().getChannel()).append("device_id").append(TTNetInit.getCronetProvider().getDeviceId());     // Catch: Throwable -> L84
    L22:
        r12 = r16.toString();     // Catch: Throwable -> L84
        goto L24
    L18:
        r16.append("&");     // Catch: Throwable -> L84
        goto L19
    L23:
        r12 = r3;
    L24:
        final HttpURLConnection r2 = (HttpURLConnection) new URL(r12).openConnection();     // Catch: Throwable -> L84
        r2.setRequestMethod(HttpMethodContrants.GET);     // Catch: Throwable -> L82
        r2.setConnectTimeout(NetworkParams.getConnectTimeout());     // Catch: Throwable -> L82
        r2.setReadTimeout(NetworkParams.getIoTimeout());     // Catch: Throwable -> L82
        r2.setInstanceFollowRedirects(true);     // Catch: Throwable -> L82
        r2.setRequestProperty("Accept-Encoding", "gzip");     // Catch: Throwable -> L82
        if (r15.useHttps == false) goto L28;
        String r5 = " HttpsURLConnection";
    L29:
        r2.setRequestProperty("User-Agent", ApmTrafficStats.KEY_TRAFFIC_SOURCE_TTNET.concat(r5));     // Catch: Throwable -> L82
        if (r13 != null) goto L32;
    L37:
        int r17 = r2.getResponseCode();     // Catch: Throwable -> L82
        r15.status = r17;     // Catch: Throwable -> L82
        if (r14 == null) goto L50;
        if (r2.getHeaderFields() == null) goto L50;
        Map<String, List<String>> r1 = r2.getHeaderFields();     // Catch: Throwable -> L82
        if (r1 == null) goto L50;
        Iterator<Map.Entry<String, List<String>>> r6 = r1.entrySet().iterator();     // Catch: Throwable -> L82
    L45:
        if (r6.hasNext() == false) goto L50;
        Map.Entry<String, List<String>> r7 = r6.next();     // Catch: Throwable -> L82
        String r8 = r7.getKey();     // Catch: Throwable -> L82
        if (TextUtils.isEmpty(r8) == true) goto L45;
        r14.put(r8.toLowerCase(), r7.getValue());     // Catch: Throwable -> L82
    L50:
        if (r15.useHttps == true) goto L52;
        r15.rawSign = r2.getHeaderField("X-SS-SIGN");     // Catch: Throwable -> L82
    L52:
        r15.tncEtag = r2.getHeaderField(StoreRegionManager.TNC_ETAG_HEADER);     // Catch: Throwable -> L82
        r15.tncAbTest = r2.getHeaderField("x-tt-tnc-abtest");     // Catch: Throwable -> L82
        r15.tncControl = r2.getHeaderField("x-tt-tnc-control");     // Catch: Throwable -> L82
        r15.tncConfigId = r2.getHeaderField(StoreRegionManager.TNC_CONFIG_HEADER);     // Catch: Throwable -> L82
        r15.tncCanary = r2.getHeaderField("x-ss-canary");     // Catch: Throwable -> L82
        r15.tncQueryRegion = r2.getHeaderField("x-tt-tnc-query-region");     // Catch: Throwable -> L82
        r15.logid = r2.getHeaderField("x-tt-logid");     // Catch: Throwable -> L82
        if (r17 != 200) goto L81;
        InputStream r9 = r2.getInputStream();     // Catch: Throwable -> L82
        boolean r10 = "gzip".equals(r2.getHeaderField("Content-Encoding"));     // Catch: Throwable -> L82
        String r18 = r2.getHeaderField("Content-Type");     // Catch: Throwable -> L82
        boolean r19 = StreamParser.testIsSSBinary(r18);     // Catch: Throwable -> L82
        Pair<String, String> r110 = RetrofitUtils.parseContentType(r18);     // Catch: Throwable -> L82
        if (r110 != null) goto L57;
    L61:
        String r111 = null;
    L62:
        if (r111 != null) goto L64;
        r111 = "UTF-8";
    L64:
        int[] r112 = {0};     // Catch: Throwable -> L82
        byte[] r113 = StreamParser.response2buf(r10, r2.getHeaderFields(), -1, r9, r112, new AnonymousClass1(r12, r2));     // Catch: Throwable -> L82
        if (r113 == null) goto L77;
        int r11 = r112[0];     // Catch: Throwable -> L82
        if (r11 <= 0) goto L77;
        if (r11 > r113.length) goto L77;
        if (r19 == false) goto L73;
        StreamParser.decodeSSBinary(r113, r11);     // Catch: Throwable -> L82
    L73:
        String r114 = new String(r113, 0, r112[0], r111);     // Catch: Throwable -> L82
        if (r2 != null) goto L97;
    L76:
        return r114;
    L97:
        r2.disconnect();     // Catch: Exception -> L92
    L77:
        if (r2 != null) goto L103;
    L79:
        return null;
    L103:
        r2.disconnect();     // Catch: Exception -> L93
        goto L79
    L57:
        if (r110.second == null) goto L61;
        if (Charset.isSupported((String) r110.second) == false) goto L61;
        r111 = (String) r110.second;     // Catch: Throwable -> L82
        goto L62
    L81:
        throw new IOException("err status = " + r17);     // Catch: Throwable -> L82
    L32:
        if (r13.size() <= 0) goto L37;
        Iterator<Map.Entry<String, String>> r115 = r13.entrySet().iterator();     // Catch: Throwable -> L82
    L35:
        if (r115.hasNext() == false) goto L37;
        Map.Entry<String, String> r20 = r115.next();     // Catch: Throwable -> L82
        r2.setRequestProperty(r20.getKey(), r20.getValue());     // Catch: Throwable -> L82
        goto L35
    L28:
        r5 = " HttpURLConnection";
    L82:
        th = th;
        r4 = r2;
    L91:
        return null;
    }
}
