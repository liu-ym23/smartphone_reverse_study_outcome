package K5;

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
import z2.l;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f908a = new Object();
    public static a b;

    public a(Context context) {
        try {
            System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (P5.b.i == null) {
            synchronized (P5.b.f1090j) {
                try {
                    if (P5.b.i == null) {
                        P5.b.i = new P5.b(context);
                    }
                } finally {
                }
            }
        }
    }

    public static Map a() {
        HashMap map = new HashMap();
        byte[] bArr = P5.b.i().e;
        if (bArr != null && bArr.length > 0) {
            String str = new String(bArr);
            W5.c.a("HttpSecureRequester", "attach x_s_key: ".concat(str));
            map.put("X-S-Key", str);
            return map;
        }
        byte[] bArr2 = P5.b.i().d;
        if (bArr2 != null && bArr2.length > 0) {
            String str2 = new String(P5.b.i().d);
            W5.c.a("HttpSecureRequester", "attach x_a_key: ".concat(str2));
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
                    l.o(byteArrayOutputStream);
                    return byteArray;
                }
                byteArrayOutputStream.write(i);
            } catch (Throwable th) {
                l.o(byteArrayOutputStream);
                throw th;
            }
        }
    }

    public static URL c(URL url) {
        String strEncodeToString;
        URL url2 = null;
        try {
            byte[] bArrE = P5.b.i().e(url.getFile().getBytes());
            if (bArrE == null) {
                strEncodeToString = null;
            } else {
                strEncodeToString = Base64.encodeToString(bArrE, 2);
                try {
                    strEncodeToString = URLEncoder.encode(strEncodeToString, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                }
                W5.c.a("HttpSecureRequester", "generated ef: " + strEncodeToString);
            }
            url2 = new URL(url.getProtocol(), url.getHost(), "lighttps?ef=" + strEncodeToString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url2 == null ? url : url2;
    }

    public static a d(Context context) {
        if (b == null) {
            synchronized (f908a) {
                try {
                    if (b == null) {
                        b = new a(context);
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public static void e(HttpURLConnection httpURLConnection) {
        try {
            String headerField = httpURLConnection.getHeaderField("X-S-Key");
            W5.c.a("HttpSecureRequester", "get x_s_key = " + headerField);
            if (TextUtils.isEmpty(headerField)) {
                return;
            }
            P5.b bVarI = P5.b.i();
            byte[] bytes = headerField.getBytes();
            bVarI.e = bytes;
            bVarI.g.a("sKey64", new String(bytes));
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.stepos.statsapp.v3.lib.plugin.net.NetResponse f(java.net.URL r6, java.lang.String r7, java.util.Map r8, byte[] r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: K5.a.f(java.net.URL, java.lang.String, java.util.Map, byte[]):com.stepos.statsapp.v3.lib.plugin.net.NetResponse");
    }

    public static NetResponse g(URL url, String str, Map map) {
        byte[] bArrB;
        InputStream inputStream = null;
        if (url == null) {
            W5.c.b("HttpSecureRequester", "url is null");
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
            W5.c.a("HttpSecureRequester", "code = " + responseCode);
            InputStream inputStream2 = httpURLConnection.getInputStream();
            if (inputStream2 != null) {
                try {
                    bArrB = b(inputStream2);
                    if (bArrB != null) {
                        W5.c.a("HttpSecureRequester", "body = " + new String(bArrB));
                        bArrB = P5.b.i().d(bArrB);
                        if (bArrB != null) {
                            W5.c.a("HttpSecureRequester", "decrypt body = " + new String(bArrB));
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream2;
                    l.o(inputStream);
                    httpURLConnection.disconnect();
                    throw th;
                }
            } else {
                bArrB = null;
            }
            if (responseCode != 200 && responseCode != 304) {
                if (responseCode == 495) {
                    P5.b.i().j();
                }
                l.o(inputStream2);
                httpURLConnection.disconnect();
                return null;
            }
            if (bArrB != null) {
                NetResponse netResponse = new NetResponse(responseCode, new String(bArrB));
                l.o(inputStream2);
                httpURLConnection.disconnect();
                return netResponse;
            }
            NetResponse netResponse2 = new NetResponse(responseCode, null);
            l.o(inputStream2);
            httpURLConnection.disconnect();
            return netResponse2;
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
