package I2;

import T2.d;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.stepos.activeview.utils.Constants;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;
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
import t0.J;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f836a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static a f837b;

    public a(Context context) {
        try {
            System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (M2.b.f1438i == null) {
            synchronized (M2.b.f1439j) {
                try {
                    if (M2.b.f1438i == null) {
                        M2.b.f1438i = new M2.b(context);
                    }
                } finally {
                }
            }
        }
    }

    public static Map a() {
        HashMap map = new HashMap();
        byte[] bArr = M2.b.i().f1444e;
        if (bArr != null && bArr.length > 0) {
            String str = new String(bArr);
            d.a("HttpSecureRequester", "attach x_s_key: ".concat(str));
            map.put("X-S-Key", str);
            return map;
        }
        byte[] bArr2 = M2.b.i().f1443d;
        if (bArr2 != null && bArr2.length > 0) {
            String str2 = new String(M2.b.i().f1443d);
            d.a("HttpSecureRequester", "attach x_a_key: ".concat(str2));
            map.put("X-A-Key", "V1:".concat(str2));
        }
        return map;
    }

    public static byte[] b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int i4 = inputStream.read();
                if (i4 == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    J.l(byteArrayOutputStream);
                    return byteArray;
                }
                byteArrayOutputStream.write(i4);
            } catch (Throwable th) {
                J.l(byteArrayOutputStream);
                throw th;
            }
        }
    }

    public static URL c(URL url) {
        String strEncodeToString;
        URL url2 = null;
        try {
            byte[] bArrE = M2.b.i().e(url.getFile().getBytes());
            if (bArrE == null) {
                strEncodeToString = null;
            } else {
                strEncodeToString = Base64.encodeToString(bArrE, 2);
                try {
                    strEncodeToString = URLEncoder.encode(strEncodeToString, Constants.UTF_8_CODE);
                } catch (UnsupportedEncodingException unused) {
                }
                d.a("HttpSecureRequester", "generated ef: " + strEncodeToString);
            }
            url2 = new URL(url.getProtocol(), url.getHost(), "lighttps?ef=" + strEncodeToString);
        } catch (MalformedURLException e4) {
            e4.printStackTrace();
        }
        return url2 == null ? url : url2;
    }

    public static a d(Context context) {
        if (f837b == null) {
            synchronized (f836a) {
                try {
                    if (f837b == null) {
                        f837b = new a(context);
                    }
                } finally {
                }
            }
        }
        return f837b;
    }

    public static void e(HttpURLConnection httpURLConnection) {
        try {
            String headerField = httpURLConnection.getHeaderField("X-S-Key");
            d.a("HttpSecureRequester", "get x_s_key = " + headerField);
            if (TextUtils.isEmpty(headerField)) {
                return;
            }
            M2.b bVarI = M2.b.i();
            byte[] bytes = headerField.getBytes();
            bVarI.f1444e = bytes;
            bVarI.f1446g.a("sKey64", new String(bytes));
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.stepos.statsapp.v3.lib.plugin.net.NetResponse f(java.net.URL r6, java.lang.String r7, java.util.Map r8, byte[] r9) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I2.a.f(java.net.URL, java.lang.String, java.util.Map, byte[]):com.stepos.statsapp.v3.lib.plugin.net.NetResponse");
    }

    public static NetResponse g(URL url, String str, Map map) {
        byte[] bArrB;
        InputStream inputStream = null;
        if (url == null) {
            d.b("HttpSecureRequester", "url is null");
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
            httpURLConnection.setRequestProperty("Charset", Constants.UTF_8_CODE);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
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
            d.a("HttpSecureRequester", "code = " + responseCode);
            InputStream inputStream2 = httpURLConnection.getInputStream();
            if (inputStream2 != null) {
                try {
                    bArrB = b(inputStream2);
                    if (bArrB != null) {
                        d.a("HttpSecureRequester", "body = " + new String(bArrB));
                        bArrB = M2.b.i().d(bArrB);
                        if (bArrB != null) {
                            d.a("HttpSecureRequester", "decrypt body = " + new String(bArrB));
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream2;
                    J.l(inputStream);
                    httpURLConnection.disconnect();
                    throw th;
                }
            } else {
                bArrB = null;
            }
            if (responseCode != 200 && responseCode != 304) {
                if (responseCode == 495) {
                    M2.b.i().j();
                }
                J.l(inputStream2);
                httpURLConnection.disconnect();
                return null;
            }
            if (bArrB != null) {
                NetResponse netResponse = new NetResponse(responseCode, new String(bArrB));
                J.l(inputStream2);
                httpURLConnection.disconnect();
                return netResponse;
            }
            NetResponse netResponse2 = new NetResponse(responseCode, null);
            J.l(inputStream2);
            httpURLConnection.disconnect();
            return netResponse2;
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
