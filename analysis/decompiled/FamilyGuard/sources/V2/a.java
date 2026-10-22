package V2;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;
import d3.C0665a;
import f3.C0719a;
import g3.C0742e;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static final Object f5516b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static a f5517c = null;

    /* renamed from: d, reason: collision with root package name */
    private static String f5518d = "******--W17By8q--";

    /* renamed from: a, reason: collision with root package name */
    private Context f5519a;

    private a(Context context) {
        this.f5519a = context;
        try {
            System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        Z2.b.b(context);
    }

    private Map<String, String> a(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        byte[] bArrN = Z2.b.l().n();
        if (bArrN != null && bArrN.length > 0) {
            String str = new String(bArrN);
            C0742e.c("HttpSecureRequester", "attach x_s_key: " + str);
            map.put("X-S-Key", str);
            return map;
        }
        byte[] bArrM = Z2.b.l().m();
        if (bArrM != null && bArrM.length > 0) {
            String str2 = new String(Z2.b.l().m());
            C0742e.c("HttpSecureRequester", "attach x_a_key: " + str2);
            map.put("X-A-Key", "V1:" + str2);
        }
        return map;
    }

    private String b(URL url) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        byte[] bArrI = Z2.b.l().i(url.getFile().getBytes());
        if (bArrI == null) {
            return null;
        }
        String strEncodeToString = Base64.encodeToString(bArrI, 2);
        try {
            strEncodeToString = URLEncoder.encode(strEncodeToString, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
        }
        C0742e.c("HttpSecureRequester", "generated ef: " + strEncodeToString);
        return strEncodeToString;
    }

    private byte[] c(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int i5 = inputStream.read();
                if (i5 == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    C0719a.a(byteArrayOutputStream);
                    return byteArray;
                }
                byteArrayOutputStream.write(i5);
            } catch (Throwable th) {
                C0719a.a(byteArrayOutputStream);
                throw th;
            }
        }
    }

    private URL d(URL url) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        URL url2;
        try {
            String strB = b(url);
            url2 = new URL(url.getProtocol(), url.getHost(), "lighttps?ef=" + strB);
        } catch (MalformedURLException e6) {
            e6.printStackTrace();
            url2 = null;
        }
        return url2 == null ? url : url2;
    }

    public static a e(Context context) {
        if (f5517c == null) {
            synchronized (f5516b) {
                try {
                    if (f5517c == null) {
                        f5517c = new a(context);
                    }
                } finally {
                }
            }
        }
        return f5517c;
    }

    private void f(URLConnection uRLConnection) {
        try {
            String headerField = uRLConnection.getHeaderField("X-S-Key");
            C0742e.c("HttpSecureRequester", "get x_s_key = " + headerField);
            if (TextUtils.isEmpty(headerField)) {
                return;
            }
            Z2.b.l().h(headerField);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.stepos.statsapp.v3.lib.plugin.net.NetResponse h(java.net.URL r8, java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10, byte[] r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: V2.a.h(java.net.URL, java.lang.String, java.util.Map, byte[]):com.stepos.statsapp.v3.lib.plugin.net.NetResponse");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [V2.a] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.DataOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v6 */
    private NetResponse i(URL url, String str, String str2, Map<String, String> map, String str3) throws Throwable {
        InputStream inputStream;
        ?? dataOutputStream;
        InputStream inputStream2;
        byte[] bArrC;
        InputStream inputStream3 = null;
        if (url == null) {
            C0742e.d("HttpSecureRequester", "url is null");
            return null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(30000);
        try {
            httpURLConnection.setRequestProperty("Host", str);
            httpURLConnection.setRequestProperty("Connection", "keep-alive");
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (str3 != null) {
            try {
                C0742e.c("HttpSecureRequester", "content:\n" + str3);
                httpURLConnection.setDoOutput(true);
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    byte[] bArrI = Z2.b.l().i(str3.getBytes());
                    inputStream2 = dataOutputStream;
                    if (bArrI != null) {
                        dataOutputStream.write(bArrI);
                        dataOutputStream.flush();
                        inputStream2 = dataOutputStream;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    C0719a.a(dataOutputStream);
                    C0719a.a(inputStream3);
                    httpURLConnection.disconnect();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
                dataOutputStream = inputStream3;
                inputStream3 = inputStream;
                C0719a.a(dataOutputStream);
                C0719a.a(inputStream3);
                httpURLConnection.disconnect();
                throw th;
            }
        } else {
            inputStream2 = null;
        }
        try {
            f(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            C0742e.c("HttpSecureRequester", "code = " + responseCode);
            inputStream = httpURLConnection.getInputStream();
            if (inputStream != null) {
                try {
                    bArrC = c(inputStream);
                    if (bArrC != null) {
                        C0742e.c("HttpSecureRequester", "body = " + new String(bArrC));
                        bArrC = Z2.b.l().e(bArrC);
                        if (bArrC != null) {
                            C0742e.c("HttpSecureRequester", "decrypt body = " + new String(bArrC));
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream3 = inputStream2;
                    dataOutputStream = inputStream3;
                    inputStream3 = inputStream;
                    C0719a.a(dataOutputStream);
                    C0719a.a(inputStream3);
                    httpURLConnection.disconnect();
                    throw th;
                }
            } else {
                bArrC = null;
            }
            if (responseCode != 200 && responseCode != 304) {
                if (responseCode == 495) {
                    Z2.b.l().p();
                }
                C0719a.a(inputStream2);
                C0719a.a(inputStream);
                httpURLConnection.disconnect();
                return null;
            }
            if (bArrC != null) {
                NetResponse netResponse = new NetResponse(responseCode, new String(bArrC));
                C0719a.a(inputStream2);
                C0719a.a(inputStream);
                httpURLConnection.disconnect();
                return netResponse;
            }
            NetResponse netResponse2 = new NetResponse(responseCode, null);
            C0719a.a(inputStream2);
            C0719a.a(inputStream);
            httpURLConnection.disconnect();
            return netResponse2;
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
        }
    }

    public NetResponse g(String str, Map<String, String> map, byte[] bArr) {
        NetResponse netResponseH = null;
        if (!C0665a.b("HttpSecureRequester.postMultipart")) {
            C0742e.l("HttpSecureRequester", "postMultipart fail, FailureRestrict check is false");
            return null;
        }
        try {
            URL url = new URL(str);
            URL urlD = d(url);
            Map<String, String> mapA = a(map);
            C0742e.c("HttpSecureRequester", "gslb conversion failure. efURL = " + urlD + ", host = " + url.getHost());
            try {
                netResponseH = h(urlD, url.getHost(), mapA, bArr);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            if (netResponseH == null || (netResponseH.c() > 400 && netResponseH.c() != 495)) {
                C0665a.a("HttpSecureRequester.postMultipart");
            }
            return netResponseH;
        } catch (MalformedURLException e7) {
            e7.printStackTrace();
            return null;
        }
    }

    public NetResponse j(String str, String str2, Map<String, String> map, String str3) throws Throwable {
        NetResponse netResponseI = null;
        if (!C0665a.b("HttpSecureRequester.stringPartRequest")) {
            return null;
        }
        try {
            URL url = new URL(str);
            try {
                netResponseI = i(d(url), url.getHost(), str2, a(map), str3);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            if (netResponseI == null || (netResponseI.c() > 400 && netResponseI.c() != 495)) {
                C0665a.a("HttpSecureRequester.stringPartRequest");
            }
            return netResponseI;
        } catch (MalformedURLException e7) {
            e7.printStackTrace();
            return null;
        }
    }
}
