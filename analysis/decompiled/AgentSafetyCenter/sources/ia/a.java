package ia;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import t.o;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f5932a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static a f5933b;

    public a(Context context) {
        try {
            System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (na.b.i == null) {
            synchronized (na.b.f8799j) {
                try {
                    if (na.b.i == null) {
                        na.b.i = new na.b(context);
                    }
                } finally {
                }
            }
        }
    }

    public static Map a() {
        HashMap map = new HashMap();
        byte[] bArr = na.b.i().f8804e;
        if (bArr != null && bArr.length > 0) {
            String str = new String(bArr);
            ua.c.a("HttpSecureRequester", "attach x_s_key: ".concat(str));
            map.put("X-S-Key", str);
            return map;
        }
        byte[] bArr2 = na.b.i().f8803d;
        if (bArr2 != null && bArr2.length > 0) {
            String str2 = new String(na.b.i().f8803d);
            ua.c.a("HttpSecureRequester", "attach x_a_key: ".concat(str2));
            map.put("X-A-Key", "V1:".concat(str2));
        }
        return map;
    }

    public static byte[] b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int i = inputStream.read();
                if (i == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    o.e(byteArrayOutputStream);
                    return byteArray;
                }
                byteArrayOutputStream.write(i);
            } catch (Throwable th) {
                o.e(byteArrayOutputStream);
                throw th;
            }
        }
    }

    public static URL c(URL url) {
        String strEncodeToString;
        URL url2 = null;
        try {
            byte[] bArrE = na.b.i().e(url.getFile().getBytes());
            if (bArrE == null) {
                strEncodeToString = null;
            } else {
                strEncodeToString = Base64.encodeToString(bArrE, 2);
                try {
                    strEncodeToString = URLEncoder.encode(strEncodeToString, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                }
                ua.c.a("HttpSecureRequester", "generated ef: " + strEncodeToString);
            }
            url2 = new URL(url.getProtocol(), url.getHost(), "lighttps?ef=" + strEncodeToString);
        } catch (MalformedURLException e10) {
            e10.printStackTrace();
        }
        return url2 == null ? url : url2;
    }

    public static a d(Context context) {
        if (f5933b == null) {
            synchronized (f5932a) {
                try {
                    if (f5933b == null) {
                        f5933b = new a(context);
                    }
                } finally {
                }
            }
        }
        return f5933b;
    }

    public static void e(HttpURLConnection httpURLConnection) {
        try {
            String headerField = httpURLConnection.getHeaderField("X-S-Key");
            ua.c.a("HttpSecureRequester", "get x_s_key = " + headerField);
            if (TextUtils.isEmpty(headerField)) {
                return;
            }
            na.b bVarI = na.b.i();
            byte[] bytes = headerField.getBytes();
            bVarI.f8804e = bytes;
            bVarI.f8806g.a("sKey64", new String(bytes));
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.stepos.statsapp.v3.lib.plugin.net.NetResponse f(java.net.URL r7, java.lang.String r8, java.util.Map r9, byte[] r10) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ia.a.f(java.net.URL, java.lang.String, java.util.Map, byte[]):com.stepos.statsapp.v3.lib.plugin.net.NetResponse");
    }

    public static NetResponse g(URL url, String str, Map map) {
        byte[] bArrB;
        InputStream inputStream = null;
        if (url == null) {
            ua.c.b("HttpSecureRequester", "url is null");
            return null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(30000);
        try {
            httpURLConnection.setRequestProperty("Host", str);
            httpURLConnection.setRequestProperty("Connection", "keep-alive");
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
            if (map.size() > 0) {
                for (Map.Entry entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            e(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            ua.c.a("HttpSecureRequester", "code = " + responseCode);
            InputStream inputStream2 = httpURLConnection.getInputStream();
            if (inputStream2 != null) {
                try {
                    bArrB = b(inputStream2);
                    if (bArrB != null) {
                        ua.c.a("HttpSecureRequester", "body = " + new String(bArrB));
                        bArrB = na.b.i().d(bArrB);
                        if (bArrB != null) {
                            ua.c.a("HttpSecureRequester", "decrypt body = " + new String(bArrB));
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream2;
                    o.e(inputStream);
                    httpURLConnection.disconnect();
                    throw th;
                }
            } else {
                bArrB = null;
            }
            if (responseCode != 200 && responseCode != 304) {
                if (responseCode == 495) {
                    na.b.i().j();
                }
                o.e(inputStream2);
                httpURLConnection.disconnect();
                return null;
            }
            if (bArrB != null) {
                NetResponse netResponse = new NetResponse(responseCode, new String(bArrB));
                o.e(inputStream2);
                httpURLConnection.disconnect();
                return netResponse;
            }
            NetResponse netResponse2 = new NetResponse(responseCode, null);
            o.e(inputStream2);
            httpURLConnection.disconnect();
            return netResponse2;
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
