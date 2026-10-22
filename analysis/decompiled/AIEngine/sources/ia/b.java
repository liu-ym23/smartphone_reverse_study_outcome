package ia;

import android.content.Context;
import android.content.SharedPreferences;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import ta.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f9583b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static b f9584c;

    /* renamed from: a, reason: collision with root package name */
    public Context f9585a;

    public static b b(Context context) {
        if (f9584c == null) {
            synchronized (f9583b) {
                try {
                    if (f9584c == null) {
                        b bVar = new b();
                        bVar.f9585a = context;
                        f9584c = bVar;
                    }
                } finally {
                }
            }
        }
        return f9584c;
    }

    public final NetResponse a(String str, HashMap map) throws Throwable {
        byte[] byteArray;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        try {
            httpURLConnection.setRequestProperty("Connection", "keep-alive");
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            if (map != null && map.size() > 0) {
                for (Map.Entry entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        InputStream inputStream = null;
        try {
            int responseCode = httpURLConnection.getResponseCode();
            c.a("NetRequester", "code = " + responseCode);
            if (responseCode == 200) {
                try {
                    String headerField = httpURLConnection.getHeaderField("Last-Modified");
                    c.a("NetRequester", "get lastModified = " + headerField);
                    String headerField2 = httpURLConnection.getHeaderField("ETag");
                    c.a("NetRequester", "get ETag = " + headerField);
                    Context context = this.f9585a;
                    c.d("SharedPreferencesHelper", "init SharedPreferences, name: com.stepos.statsapp.v3.serverconfig");
                    SharedPreferences sharedPreferences = context.getSharedPreferences("com.stepos.statsapp.v3.serverconfig", 0);
                    c.a("SharedPreferencesHelper", "com.stepos.statsapp.v3.serverconfig structure complete");
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putString("lastModified", headerField);
                    editorEdit.putString("ETag", headerField2);
                    editorEdit.commit();
                } catch (Exception e10) {
                    c.a("NetRequester", "lastModified error = " + e10);
                }
            }
            InputStream inputStream2 = httpURLConnection.getInputStream();
            if (inputStream2 != null) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int i10 = inputStream2.read();
                            if (i10 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(i10);
                        } catch (Throwable th2) {
                            jd.b.m(byteArrayOutputStream);
                            throw th2;
                        }
                    }
                    byteArray = byteArrayOutputStream.toByteArray();
                    jd.b.m(byteArrayOutputStream);
                    if (byteArray != null) {
                        try {
                            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                            cipher.init(2, new SecretKeySpec("3CB48439E16F4BB2".getBytes("UTF-8"), "AES"));
                            byteArray = cipher.doFinal(byteArray);
                        } catch (Exception e11) {
                            c.a("NetRequester", "secret error = " + e11);
                        }
                    }
                } catch (Throwable th3) {
                    inputStream = inputStream2;
                    th = th3;
                    jd.b.m(inputStream);
                    httpURLConnection.disconnect();
                    throw th;
                }
            } else {
                byteArray = null;
            }
            c.a("NetRequester", "body = " + byteArray);
            if (byteArray != null) {
                NetResponse netResponse = new NetResponse(responseCode, new String(byteArray));
                jd.b.m(inputStream2);
                httpURLConnection.disconnect();
                return netResponse;
            }
            NetResponse netResponse2 = new NetResponse(responseCode, null);
            jd.b.m(inputStream2);
            httpURLConnection.disconnect();
            return netResponse2;
        } catch (Throwable th4) {
            th = th4;
            jd.b.m(inputStream);
            httpURLConnection.disconnect();
            throw th;
        }
    }
}
