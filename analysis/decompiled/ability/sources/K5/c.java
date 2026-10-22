package K5;

import android.content.Context;
import android.content.SharedPreferences;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import z2.l;

/* loaded from: classes3.dex */
public final class c {
    public static final Object b = new Object();
    public static c c;

    /* renamed from: a, reason: collision with root package name */
    public Context f909a;

    public static c a(Context context) {
        if (c == null) {
            synchronized (b) {
                try {
                    if (c == null) {
                        c cVar = new c();
                        cVar.f909a = context;
                        c = cVar;
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public final NetResponse b(HashMap map, String str) {
        byte[] byteArray;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        try {
            httpURLConnection.setRequestProperty("Connection", "keep-alive");
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
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
            W5.c.a("NetRequester", "code = " + responseCode);
            if (responseCode == 200) {
                try {
                    String headerField = httpURLConnection.getHeaderField("Last-Modified");
                    W5.c.a("NetRequester", "get lastModified = " + headerField);
                    String headerField2 = httpURLConnection.getHeaderField("ETag");
                    W5.c.a("NetRequester", "get ETag = " + headerField);
                    Context context = this.f909a;
                    W5.c.d("SharedPreferencesHelper", "init SharedPreferences, name: com.stepos.statsapp.v3.serverconfig");
                    SharedPreferences sharedPreferences = context.getSharedPreferences("com.stepos.statsapp.v3.serverconfig", 0);
                    W5.c.a("SharedPreferencesHelper", "com.stepos.statsapp.v3.serverconfig structure complete");
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putString("lastModified", headerField);
                    editorEdit.putString("ETag", headerField2);
                    editorEdit.commit();
                } catch (Exception e) {
                    W5.c.a("NetRequester", "lastModified error = " + e);
                }
            }
            InputStream inputStream2 = httpURLConnection.getInputStream();
            if (inputStream2 != null) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int i = inputStream2.read();
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(i);
                        } catch (Throwable th2) {
                            l.o(byteArrayOutputStream);
                            throw th2;
                        }
                    }
                    byteArray = byteArrayOutputStream.toByteArray();
                    l.o(byteArrayOutputStream);
                    if (byteArray != null) {
                        try {
                            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                            cipher.init(2, new SecretKeySpec("3CB48439E16F4BB2".getBytes("UTF-8"), "AES"));
                            byteArray = cipher.doFinal(byteArray);
                        } catch (Exception e6) {
                            W5.c.a("NetRequester", "secret error = " + e6);
                        }
                    }
                } catch (Throwable th3) {
                    inputStream = inputStream2;
                    th = th3;
                    l.o(inputStream);
                    httpURLConnection.disconnect();
                    throw th;
                }
            } else {
                byteArray = null;
            }
            W5.c.a("NetRequester", "body = " + byteArray);
            if (byteArray != null) {
                NetResponse netResponse = new NetResponse(responseCode, new String(byteArray));
                l.o(inputStream2);
                httpURLConnection.disconnect();
                return netResponse;
            }
            NetResponse netResponse2 = new NetResponse(responseCode, null);
            l.o(inputStream2);
            httpURLConnection.disconnect();
            return netResponse2;
        } catch (Throwable th4) {
            th = th4;
            l.o(inputStream);
            httpURLConnection.disconnect();
            throw th;
        }
    }
}
