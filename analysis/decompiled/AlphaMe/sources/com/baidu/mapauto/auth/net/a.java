package com.baidu.mapauto.auth.net;

import android.text.TextUtils;
import ch.qos.logback.classic.spi.CallerData;
import com.baidu.mapauto.auth.util.LogUtil;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes.dex */
public final class a implements com.baidu.mapauto.auth.net.base.a {

    /* renamed from: b, reason: collision with root package name */
    public static final String f7671b = "a";

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ boolean f7672c = true;

    /* renamed from: a, reason: collision with root package name */
    public c f7673a;

    public a() {
    }

    public a(c cVar) {
        this.f7673a = cVar;
    }

    public static String a(InputStream inputStream) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            try {
                StringWriter stringWriter = new StringWriter();
                char[] cArr = new char[8192];
                while (true) {
                    int i4 = bufferedReader.read(cArr);
                    if (i4 < 0) {
                        String string = stringWriter.toString();
                        bufferedReader.close();
                        return string;
                    }
                    stringWriter.write(cArr, 0, i4);
                }
            } finally {
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public final b a(String str, HashMap map) throws Exception {
        HttpURLConnection httpURLConnection;
        com.baidu.mapauto.auth.net.format.a aVar = new com.baidu.mapauto.auth.net.format.a();
        HttpURLConnection httpURLConnection2 = null;
        try {
            c cVar = this.f7673a;
            if (!f7672c && !"POST".equals("POST") && !"POST".equals("GET")) {
                throw new AssertionError();
            }
            if (cVar == null) {
                throw new IllegalArgumentException("net config 不能为空");
            }
            String str2 = cVar.f7679b;
            if (TextUtils.isEmpty(str2) || !(str2.startsWith("https") || str2.startsWith("HTTPS"))) {
                throw new IllegalArgumentException("net config 检验失败");
            }
            String str3 = cVar.f7679b + str;
            if ("POST".equals("GET") && !map.isEmpty()) {
                str3 = CallerData.NA + aVar.a(map);
            }
            URL url = new URL(str3);
            if (str3.startsWith("https") || str3.startsWith("HTTPS")) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                try {
                    HostnameVerifier hostnameVerifier = cVar.f7681d;
                    httpURLConnection = httpsURLConnection;
                    if (hostnameVerifier != null) {
                        httpsURLConnection.setHostnameVerifier(hostnameVerifier);
                        httpURLConnection = httpsURLConnection;
                    }
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection2 = httpsURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection2 = httpURLConnection;
            httpURLConnection2.setRequestMethod("POST");
            if ("POST".equals("POST")) {
                httpURLConnection2.setDoInput(true);
            }
            httpURLConnection2.setDoOutput(true);
            httpURLConnection2.setReadTimeout(cVar.f7678a);
            httpURLConnection2.setConnectTimeout(5000);
            Map<String, Object> map2 = cVar.f7680c;
            if (map2 != null) {
                for (String str4 : map2.keySet()) {
                    Object obj = map2.get(str4);
                    Objects.requireNonNull(obj);
                    httpURLConnection2.setRequestProperty(str4, obj.toString());
                }
            }
            if ("POST".equals("POST")) {
                httpURLConnection2.setRequestProperty("content-type", "multipart/form-data; boundary=" + com.baidu.mapauto.auth.net.format.a.f7686a);
            }
            LogUtil logUtil = LogUtil.getInstance();
            String str5 = f7671b;
            logUtil.i(str5, "请求地址: " + str3);
            LogUtil.getInstance().i(str5, "请求方式: POST");
            LogUtil.getInstance().i(str5, "请求头: " + map2);
            LogUtil.getInstance().i(str5, "请求参数: " + map);
            if ("POST".equals("POST")) {
                OutputStream outputStream = httpURLConnection2.getOutputStream();
                String strA = aVar.a(map);
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                try {
                    dataOutputStream.writeBytes(strA);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                } finally {
                }
            }
            httpURLConnection2.connect();
            b bVar = new b();
            int responseCode = httpURLConnection2.getResponseCode();
            bVar.f7674a = Integer.valueOf(responseCode);
            bVar.f7675b = httpURLConnection2.getResponseMessage();
            if (responseCode == 200) {
                bVar.f7676c = a(httpURLConnection2.getInputStream());
            }
            httpURLConnection2.disconnect();
            return bVar;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
