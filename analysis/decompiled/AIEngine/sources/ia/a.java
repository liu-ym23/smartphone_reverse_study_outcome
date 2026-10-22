package ia;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import ta.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f9581a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static a f9582b;

    public a(Context context) {
        try {
            System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (ma.b.f10536i == null) {
            synchronized (ma.b.f10537j) {
                try {
                    if (ma.b.f10536i == null) {
                        ma.b.f10536i = new ma.b(context);
                    }
                } finally {
                }
            }
        }
    }

    public static Map a() {
        HashMap map = new HashMap();
        byte[] bArr = ma.b.i().f10542e;
        if (bArr != null && bArr.length > 0) {
            String str = new String(bArr);
            c.a("HttpSecureRequester", "attach x_s_key: ".concat(str));
            map.put("X-S-Key", str);
            return map;
        }
        byte[] bArr2 = ma.b.i().f10541d;
        if (bArr2 != null && bArr2.length > 0) {
            String str2 = new String(ma.b.i().f10541d);
            c.a("HttpSecureRequester", "attach x_a_key: ".concat(str2));
            map.put("X-A-Key", "V1:".concat(str2));
        }
        return map;
    }

    public static byte[] b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int i10 = inputStream.read();
                if (i10 == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    jd.b.m(byteArrayOutputStream);
                    return byteArray;
                }
                byteArrayOutputStream.write(i10);
            } catch (Throwable th) {
                jd.b.m(byteArrayOutputStream);
                throw th;
            }
        }
    }

    public static URL c(URL url) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        String strEncodeToString;
        URL url2 = null;
        try {
            byte[] bArrE = ma.b.i().e(url.getFile().getBytes());
            if (bArrE == null) {
                strEncodeToString = null;
            } else {
                strEncodeToString = Base64.encodeToString(bArrE, 2);
                try {
                    strEncodeToString = URLEncoder.encode(strEncodeToString, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                }
                c.a("HttpSecureRequester", "generated ef: " + strEncodeToString);
            }
            url2 = new URL(url.getProtocol(), url.getHost(), "lighttps?ef=" + strEncodeToString);
        } catch (MalformedURLException e10) {
            e10.printStackTrace();
        }
        return url2 == null ? url : url2;
    }

    public static a d(Context context) {
        if (f9582b == null) {
            synchronized (f9581a) {
                try {
                    if (f9582b == null) {
                        f9582b = new a(context);
                    }
                } finally {
                }
            }
        }
        return f9582b;
    }

    public static void e(HttpURLConnection httpURLConnection) {
        try {
            String headerField = httpURLConnection.getHeaderField("X-S-Key");
            c.a("HttpSecureRequester", "get x_s_key = " + headerField);
            if (TextUtils.isEmpty(headerField)) {
                return;
            }
            ma.b bVarI = ma.b.i();
            byte[] bytes = headerField.getBytes();
            bVarI.f10542e = bytes;
            bVarI.f10544g.a("sKey64", new String(bytes));
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
        throw new UnsupportedOperationException("Method not decompiled: ia.a.f(java.net.URL, java.lang.String, java.util.Map, byte[]):com.stepos.statsapp.v3.lib.plugin.net.NetResponse");
    }

    public static NetResponse g(URL url, String str, Map map) throws Throwable {
        byte[] bArrB;
        InputStream inputStream = null;
        if (url == null) {
            c.b("HttpSecureRequester", "url is null");
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
            c.a("HttpSecureRequester", "code = " + responseCode);
            InputStream inputStream2 = httpURLConnection.getInputStream();
            if (inputStream2 != null) {
                try {
                    bArrB = b(inputStream2);
                    if (bArrB != null) {
                        c.a("HttpSecureRequester", "body = " + new String(bArrB));
                        bArrB = ma.b.i().d(bArrB);
                        if (bArrB != null) {
                            c.a("HttpSecureRequester", "decrypt body = " + new String(bArrB));
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream2;
                    jd.b.m(inputStream);
                    httpURLConnection.disconnect();
                    throw th;
                }
            } else {
                bArrB = null;
            }
            if (responseCode != 200 && responseCode != 304) {
                if (responseCode == 495) {
                    ma.b.i().j();
                }
                jd.b.m(inputStream2);
                httpURLConnection.disconnect();
                return null;
            }
            if (bArrB != null) {
                NetResponse netResponse = new NetResponse(responseCode, new String(bArrB));
                jd.b.m(inputStream2);
                httpURLConnection.disconnect();
                return netResponse;
            }
            NetResponse netResponse2 = new NetResponse(responseCode, null);
            jd.b.m(inputStream2);
            httpURLConnection.disconnect();
            return netResponse2;
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
