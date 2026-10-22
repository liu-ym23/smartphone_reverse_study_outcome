package V2;

import android.content.Context;
import android.content.SharedPreferences;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;
import f3.C0719a;
import f3.C0720b;
import g3.C0742e;
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

/* loaded from: classes.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static final Object f5520b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static b f5521c;

    /* renamed from: a, reason: collision with root package name */
    private Context f5522a;

    private b(Context context) {
        this.f5522a = context;
    }

    public static b a(Context context) {
        if (f5521c == null) {
            synchronized (f5520b) {
                try {
                    if (f5521c == null) {
                        f5521c = new b(context);
                    }
                } finally {
                }
            }
        }
        return f5521c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.io.DataOutputStream] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v2 */
    private NetResponse b(String str, String str2, Map<String, String> map, String str3) throws Throwable {
        OutputStream outputStream;
        InputStream inputStream;
        ?? dataOutputStream;
        InputStream inputStream2;
        byte[] bArrD;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        try {
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
                        C0742e.c("NetRequester", "content:\n" + stringBuffer.toString());
                        dataOutputStream.flush();
                        inputStream2 = dataOutputStream;
                    } catch (Throwable th2) {
                        th = th2;
                        C0719a.a(dataOutputStream);
                        C0719a.a(outputStream);
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
                    C0719a.a(outputStream);
                    C0719a.a(inputStream3);
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
            C0742e.c("NetRequester", "code = " + responseCode);
            if (responseCode == 200) {
                try {
                    String headerField = httpURLConnection.getHeaderField("Last-Modified");
                    C0742e.c("NetRequester", "get lastModified = " + headerField);
                    String headerField2 = httpURLConnection.getHeaderField("ETag");
                    C0742e.c("NetRequester", "get ETag = " + headerField);
                    SharedPreferences.Editor editorH = new C0720b(this.f5522a, "com.stepos.statsapp.v3.serverconfig").h();
                    editorH.putString("lastModified", headerField);
                    editorH.putString("ETag", headerField2);
                    editorH.commit();
                } catch (Exception e6) {
                    C0742e.c("NetRequester", "lastModified error = " + e6);
                }
            }
            inputStream = httpURLConnection.getInputStream();
            if (inputStream != null) {
                try {
                    bArrD = d(inputStream);
                    if (bArrD != null) {
                        try {
                            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                            cipher.init(2, new SecretKeySpec("3CB48439E16F4BB2".getBytes("UTF-8"), "AES"));
                            bArrD = cipher.doFinal(bArrD);
                        } catch (Exception e7) {
                            C0742e.c("NetRequester", "secret error = " + e7);
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    inputStream3 = inputStream2;
                    dataOutputStream = inputStream3;
                    inputStream3 = inputStream;
                    C0719a.a(dataOutputStream);
                    C0719a.a(outputStream);
                    C0719a.a(inputStream3);
                    httpURLConnection.disconnect();
                    throw th;
                }
            } else {
                bArrD = null;
            }
            C0742e.c("NetRequester", "body = " + bArrD);
            if (bArrD != null) {
                NetResponse netResponse = new NetResponse(responseCode, new String(bArrD));
                C0719a.a(inputStream2);
                C0719a.a(outputStream);
                C0719a.a(inputStream);
                httpURLConnection.disconnect();
                return netResponse;
            }
            NetResponse netResponse2 = new NetResponse(responseCode, null);
            C0719a.a(inputStream2);
            C0719a.a(outputStream);
            C0719a.a(inputStream);
            httpURLConnection.disconnect();
            return netResponse2;
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
            inputStream3 = inputStream2;
            dataOutputStream = inputStream3;
            inputStream3 = inputStream;
            C0719a.a(dataOutputStream);
            C0719a.a(outputStream);
            C0719a.a(inputStream3);
            httpURLConnection.disconnect();
            throw th;
        }
    }

    private byte[] d(InputStream inputStream) throws IOException {
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

    public NetResponse c(String str, Map<String, String> map) {
        return b(str, "GET", map, null);
    }
}
