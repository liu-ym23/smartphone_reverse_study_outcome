package Z7;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: Z7.f, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1134f {

    /* renamed from: c, reason: collision with root package name */
    public static C1134f f7503c;

    /* renamed from: a, reason: collision with root package name */
    public Context f7504a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, String> f7505b = null;

    public C1134f(Context context) {
        this.f7504a = context;
    }

    public static HttpURLConnection a(String str, String str2) {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(str2);
            Proxy proxy = C1141m.f7551a;
            if (proxy != null) {
                httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
            } else if (str == null || !str.toLowerCase(Locale.US).contains("wap")) {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")))));
            }
            httpURLConnection.setConnectTimeout(Const.I_LOC_JUMP_DELAY);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(false);
            return httpURLConnection;
        } catch (Throwable th) {
            if (C1139k.e(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static HttpURLConnection b(String str, byte[] bArr, String str2, Map<String, String> map) {
        if (str == null) {
            C1139k.j("destUrl is null.", new Object[0]);
            return null;
        }
        HttpURLConnection httpURLConnectionA = a(str2, str);
        if (httpURLConnectionA == null) {
            C1139k.j("Failed to get HttpURLConnection object.", new Object[0]);
            return null;
        }
        try {
            httpURLConnectionA.setRequestProperty("wup_version", "3.0");
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnectionA.setRequestProperty(entry.getKey(), URLEncoder.encode(entry.getValue(), "utf-8"));
                }
            }
            httpURLConnectionA.setRequestProperty("A37", URLEncoder.encode(str2, "utf-8"));
            httpURLConnectionA.setRequestProperty("A38", URLEncoder.encode(str2, "utf-8"));
            OutputStream outputStream = httpURLConnectionA.getOutputStream();
            if (bArr == null) {
                outputStream.write(0);
                return httpURLConnectionA;
            }
            outputStream.write(bArr);
            return httpURLConnectionA;
        } catch (Throwable th) {
            if (!C1139k.e(th)) {
                th.printStackTrace();
            }
            C1139k.j("Failed to upload, please check your network.", new Object[0]);
            return null;
        }
    }

    public static Map<String, String> c(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null || headerFields.size() == 0) {
            return null;
        }
        for (String str : headerFields.keySet()) {
            List<String> list = headerFields.get(str);
            if (list.size() > 0) {
                map.put(str, list.get(0));
            }
        }
        return map;
    }

    public static byte[] e(HttpURLConnection httpURLConnection) {
        BufferedInputStream bufferedInputStream;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int i10 = bufferedInputStream.read(bArr);
                    if (i10 <= 0) {
                        byteArrayOutputStream.flush();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            bufferedInputStream.close();
                            return byteArray;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return byteArray;
                        }
                    }
                    byteArrayOutputStream.write(bArr, 0, i10);
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!C1139k.e(th)) {
                        th.printStackTrace();
                    }
                    return null;
                } finally {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(5:114|25|26|115|27)|(6:29|(1:31)(2:32|33)|34|121|35|41)(11:48|(3:117|56|(4:58|106|59|65)(4:68|108|69|70))|124|71|(1:73)|74|110|75|81|131|130)|44|86|(1:88)|119|89|81|131|130) */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x016c, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0171, code lost:
    
        if (Z7.C1139k.e(r0) == false) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:128:0x007d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x014b A[PHI: r0 r10 r11 r12 r17 r18
      0x014b: PHI (r0v15 'th' java.lang.Throwable) = (r0v18 'th' java.lang.Throwable), (r0v30 'th' java.lang.Throwable) binds: [B:93:0x0171, B:79:0x0149] A[DONT_GENERATE, DONT_INLINE]
      0x014b: PHI (r10v5 java.lang.String) = (r10v7 java.lang.String), (r10v10 java.lang.String) binds: [B:93:0x0171, B:79:0x0149] A[DONT_GENERATE, DONT_INLINE]
      0x014b: PHI (r11v6 int) = (r11v8 int), (r11v10 int) binds: [B:93:0x0171, B:79:0x0149] A[DONT_GENERATE, DONT_INLINE]
      0x014b: PHI (r12v6 int) = (r12v8 int), (r12v12 int) binds: [B:93:0x0171, B:79:0x0149] A[DONT_GENERATE, DONT_INLINE]
      0x014b: PHI (r17v7 byte[]) = (r17v9 byte[]), (r17v10 byte[]) binds: [B:93:0x0171, B:79:0x0149] A[DONT_GENERATE, DONT_INLINE]
      0x014b: PHI (r18v4 int) = (r18v6 int), (r18v10 int) binds: [B:93:0x0171, B:79:0x0149] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0165 A[Catch: all -> 0x00d8, TRY_LEAVE, TryCatch #4 {all -> 0x00d8, blocks: (B:25:0x0099, B:27:0x009f, B:29:0x00b2, B:34:0x00c6, B:86:0x015f, B:88:0x0165, B:32:0x00c2, B:71:0x0133, B:74:0x013d, B:56:0x00f6, B:58:0x00fe, B:69:0x0122), top: B:114:0x0099 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] d(java.lang.String r20, byte[] r21, Z7.RunnableC1137i r22, java.util.Map<java.lang.String, java.lang.String> r23) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Z7.C1134f.d(java.lang.String, byte[], Z7.i, java.util.Map):byte[]");
    }
}
