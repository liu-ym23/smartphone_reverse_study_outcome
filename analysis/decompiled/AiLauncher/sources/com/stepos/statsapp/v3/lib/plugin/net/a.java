package com.stepos.statsapp.v3.lib.plugin.net;

import android.content.Context;
import android.content.SharedPreferences;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import com.stepos.statsapp.v3.utils.CommonUtils;
import com.stepos.statsapp.v3.utils.SharedPreferencesHelper;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static final String f30818b = "NetRequester";

    /* renamed from: c, reason: collision with root package name */
    private static final Object f30819c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static final String f30820d = "application/x-www-form-urlencoded";

    /* renamed from: e, reason: collision with root package name */
    private static a f30821e;

    /* renamed from: a, reason: collision with root package name */
    private Context f30822a;

    private a(Context context) {
        this.f30822a = context;
    }

    public static a a(Context context) {
        if (f30821e == null) {
            synchronized (f30819c) {
                try {
                    if (f30821e == null) {
                        f30821e = new a(context);
                    }
                } finally {
                }
            }
        }
        return f30821e;
    }

    private byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int i10 = inputStream.read();
                if (i10 != -1) {
                    byteArrayOutputStream.write(i10);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    CommonUtils.closeQuietly(byteArrayOutputStream);
                    return byteArray;
                }
            } catch (Throwable th) {
                CommonUtils.closeQuietly(byteArrayOutputStream);
                throw th;
            }
        }
    }

    public NetResponse a(String str, Map<String, String> map) throws IOException, RuntimeException {
        return a(str, "GET", map, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.io.DataOutputStream] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v2 */
    private NetResponse a(String str, String str2, Map<String, String> map, String str3) throws Throwable {
        OutputStream outputStream;
        InputStream inputStream;
        ?? dataOutputStream;
        InputStream inputStream2;
        byte[] bArrA;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        try {
            httpURLConnection.setRequestProperty(e.f30851j, "keep-alive");
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty("Content-Type", f30820d);
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        InputStream inputStream3 = null;
        if (str3 != null) {
            try {
                httpURLConnection.setDoOutput(true);
                outputStream = httpURLConnection.getOutputStream();
                try {
                    dataOutputStream = new DataOutputStream(outputStream);
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        dataOutputStream.writeBytes(str3);
                        Logger.d(f30818b, "content:\n" + stringBuffer.toString());
                        dataOutputStream.flush();
                        inputStream2 = dataOutputStream;
                    } catch (Throwable th2) {
                        th = th2;
                        CommonUtils.closeQuietly(dataOutputStream);
                        CommonUtils.closeQuietly(outputStream);
                        CommonUtils.closeQuietly(inputStream3);
                        httpURLConnection.disconnect();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    dataOutputStream = inputStream3;
                    inputStream3 = inputStream;
                    CommonUtils.closeQuietly(dataOutputStream);
                    CommonUtils.closeQuietly(outputStream);
                    CommonUtils.closeQuietly(inputStream3);
                    httpURLConnection.disconnect();
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                outputStream = null;
                inputStream = null;
            }
        } else {
            outputStream = null;
            inputStream2 = null;
        }
        try {
            int responseCode = httpURLConnection.getResponseCode();
            Logger.d(f30818b, "code = " + responseCode);
            if (responseCode == 200) {
                try {
                    String headerField = httpURLConnection.getHeaderField("Last-Modified");
                    Logger.d(f30818b, "get lastModified = " + headerField);
                    String headerField2 = httpURLConnection.getHeaderField("ETag");
                    Logger.d(f30818b, "get ETag = " + headerField);
                    SharedPreferences.Editor editorEdit = new SharedPreferencesHelper(this.f30822a, UxipConstants.f30684w).edit();
                    editorEdit.putString("lastModified", headerField);
                    editorEdit.putString("ETag", headerField2);
                    editorEdit.commit();
                } catch (Exception e10) {
                    Logger.d(f30818b, "lastModified error = " + e10);
                }
            }
            inputStream = httpURLConnection.getInputStream();
            if (inputStream != null) {
                try {
                    bArrA = a(inputStream);
                    if (bArrA != null) {
                        try {
                            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                            cipher.init(2, new SecretKeySpec(UxipConstants.f30665d.getBytes("UTF-8"), "AES"));
                            bArrA = cipher.doFinal(bArrA);
                        } catch (Exception e11) {
                            Logger.d(f30818b, "secret error = " + e11);
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    inputStream3 = inputStream2;
                    dataOutputStream = inputStream3;
                    inputStream3 = inputStream;
                    CommonUtils.closeQuietly(dataOutputStream);
                    CommonUtils.closeQuietly(outputStream);
                    CommonUtils.closeQuietly(inputStream3);
                    httpURLConnection.disconnect();
                    throw th;
                }
            } else {
                bArrA = null;
            }
            Logger.d(f30818b, "body = " + bArrA);
            if (bArrA != null) {
                NetResponse netResponse = new NetResponse(responseCode, new String(bArrA));
                CommonUtils.closeQuietly(inputStream2);
                CommonUtils.closeQuietly(outputStream);
                CommonUtils.closeQuietly(inputStream);
                httpURLConnection.disconnect();
                return netResponse;
            }
            NetResponse netResponse2 = new NetResponse(responseCode, null);
            CommonUtils.closeQuietly(inputStream2);
            CommonUtils.closeQuietly(outputStream);
            CommonUtils.closeQuietly(inputStream);
            httpURLConnection.disconnect();
            return netResponse2;
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
            inputStream3 = inputStream2;
            dataOutputStream = inputStream3;
            inputStream3 = inputStream;
            CommonUtils.closeQuietly(dataOutputStream);
            CommonUtils.closeQuietly(outputStream);
            CommonUtils.closeQuietly(inputStream3);
            httpURLConnection.disconnect();
            throw th;
        }
    }
}
