package ia;

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
import t.o;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f5934b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static c f5935c;

    /* renamed from: a, reason: collision with root package name */
    public Context f5936a;

    public static c b(Context context) {
        if (f5935c == null) {
            synchronized (f5934b) {
                try {
                    if (f5935c == null) {
                        c cVar = new c();
                        cVar.f5936a = context;
                        f5935c = cVar;
                    }
                } finally {
                }
            }
        }
        return f5935c;
    }

    public final NetResponse a(String str, HashMap map) {
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
            ua.c.a("NetRequester", "code = " + responseCode);
            if (responseCode == 200) {
                try {
                    String headerField = httpURLConnection.getHeaderField("Last-Modified");
                    ua.c.a("NetRequester", "get lastModified = " + headerField);
                    String headerField2 = httpURLConnection.getHeaderField("ETag");
                    ua.c.a("NetRequester", "get ETag = " + headerField);
                    Context context = this.f5936a;
                    ua.c.d("SharedPreferencesHelper", "init SharedPreferences, name: com.stepos.statsapp.v3.serverconfig");
                    SharedPreferences sharedPreferences = context.getSharedPreferences("com.stepos.statsapp.v3.serverconfig", 0);
                    ua.c.a("SharedPreferencesHelper", "com.stepos.statsapp.v3.serverconfig structure complete");
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putString("lastModified", headerField);
                    editorEdit.putString("ETag", headerField2);
                    editorEdit.commit();
                } catch (Exception e10) {
                    ua.c.a("NetRequester", "lastModified error = " + e10);
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
                            o.e(byteArrayOutputStream);
                            throw th2;
                        }
                    }
                    byteArray = byteArrayOutputStream.toByteArray();
                    o.e(byteArrayOutputStream);
                    if (byteArray != null) {
                        try {
                            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                            cipher.init(2, new SecretKeySpec("3CB48439E16F4BB2".getBytes("UTF-8"), "AES"));
                            byteArray = cipher.doFinal(byteArray);
                        } catch (Exception e11) {
                            ua.c.a("NetRequester", "secret error = " + e11);
                        }
                    }
                } catch (Throwable th3) {
                    inputStream = inputStream2;
                    th = th3;
                    o.e(inputStream);
                    httpURLConnection.disconnect();
                    throw th;
                }
            } else {
                byteArray = null;
            }
            ua.c.a("NetRequester", "body = " + byteArray);
            if (byteArray != null) {
                NetResponse netResponse = new NetResponse(responseCode, new String(byteArray));
                o.e(inputStream2);
                httpURLConnection.disconnect();
                return netResponse;
            }
            NetResponse netResponse2 = new NetResponse(responseCode, null);
            o.e(inputStream2);
            httpURLConnection.disconnect();
            return netResponse2;
        } catch (Throwable th4) {
            th = th4;
            o.e(inputStream);
            httpURLConnection.disconnect();
            throw th;
        }
    }
}
