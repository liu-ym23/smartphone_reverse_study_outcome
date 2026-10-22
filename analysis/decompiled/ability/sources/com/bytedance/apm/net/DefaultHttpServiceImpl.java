package com.bytedance.apm.net;

import B.b;
import B.e;
import H.h;
import S0.a;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.services.apm.api.IHttpService;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import u0.C2030b;

/* loaded from: classes2.dex */
public class DefaultHttpServiceImpl implements IHttpService {
    private static String METHOD_GET = "GET";
    private static String METHOD_POST = "POST";

    private b doRequest(String str, byte[] bArr, String str2, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        byte[] byteArray;
        if (str2 == null) {
            throw new IllegalArgumentException("request method is not null");
        }
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                D2.b.g(httpURLConnection);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (entry != null) {
                            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (!TextUtils.isEmpty(h.f718w)) {
                    httpURLConnection.setRequestProperty("aid", h.a());
                    httpURLConnection.setRequestProperty("x-auth-token", h.f718w);
                }
                if (TextUtils.equals(str2, METHOD_POST)) {
                    httpURLConnection.setDoOutput(true);
                } else {
                    httpURLConnection.setDoOutput(false);
                }
                httpURLConnection.setRequestMethod(str2);
                if (bArr != null && bArr.length > 0) {
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(bArr);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    b bVar = new b(responseCode, null);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception unused) {
                    }
                    return bVar;
                }
                inputStream = httpURLConnection.getInputStream();
                try {
                    String contentEncoding = httpURLConnection.getContentEncoding();
                    if (TextUtils.isEmpty(contentEncoding) || !contentEncoding.equalsIgnoreCase("gzip")) {
                        byteArray = toByteArray(inputStream);
                    } else {
                        GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
                        byteArray = toByteArray(gZIPInputStream);
                        gZIPInputStream.close();
                    }
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    HashMap map2 = new HashMap();
                    for (String str3 : headerFields.keySet()) {
                        List<String> list = headerFields.get(str3);
                        if (list != null && !S0.b.a0(list)) {
                            map2.put(str3, list.get(0));
                        }
                    }
                    b bVar2 = new b(responseCode, map2, byteArray);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception unused3) {
                    }
                    return bVar2;
                } catch (Throwable th) {
                    th = th;
                    try {
                        String str4 = a.f1163a;
                        th.getMessage();
                        S0.b.m(10, th);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception unused4) {
                            }
                        }
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused5) {
                            }
                        }
                        return null;
                    } finally {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            inputStream = null;
        }
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 == i) {
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public e buildMultipartUpload(String str, String str2, boolean z10) {
        return new C2030b(str, str2, null, z10);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public b doGet(String str, Map<String, String> map) {
        return doRequest(str, null, METHOD_GET, map);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public b doPost(String str, byte[] bArr, Map<String, String> map) {
        return doRequest(str, bArr, METHOD_POST, map);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    @Nullable
    public b uploadFiles(String str, List<File> list, Map<String, String> map) {
        return S0.b.f(str, list, map);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public e buildMultipartUpload(String str, String str2, Map<String, String> map, boolean z10) {
        return new C2030b(str, str2, map, z10);
    }
}
