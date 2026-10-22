package I2;

import T2.d;
import android.content.Context;
import android.content.SharedPreferences;
import com.stepos.activeview.utils.Constants;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import t0.J;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f838b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static b f839c;

    /* renamed from: a, reason: collision with root package name */
    public Context f840a;

    public static b a(Context context) {
        if (f839c == null) {
            synchronized (f838b) {
                try {
                    if (f839c == null) {
                        b bVar = new b();
                        bVar.f840a = context;
                        f839c = bVar;
                    }
                } finally {
                }
            }
        }
        return f839c;
    }

    public final NetResponse b(String str, HashMap map) {
        byte[] byteArray;
        NetResponse netResponse;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        try {
            httpURLConnection.setRequestProperty("Connection", "keep-alive");
            httpURLConnection.setRequestProperty("Charset", Constants.UTF_8_CODE);
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
            d.a("NetRequester", "code = " + responseCode);
            if (responseCode == 200) {
                try {
                    String headerField = httpURLConnection.getHeaderField("Last-Modified");
                    d.a("NetRequester", "get lastModified = " + headerField);
                    String headerField2 = httpURLConnection.getHeaderField("ETag");
                    d.a("NetRequester", "get ETag = " + headerField);
                    Context context = this.f840a;
                    d.d("SharedPreferencesHelper", "init SharedPreferences, name: com.stepos.statsapp.v3.serverconfig");
                    SharedPreferences sharedPreferences = context.getSharedPreferences("com.stepos.statsapp.v3.serverconfig", 0);
                    d.a("SharedPreferencesHelper", "com.stepos.statsapp.v3.serverconfig structure complete");
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putString("lastModified", headerField);
                    editorEdit.putString("ETag", headerField2);
                    editorEdit.commit();
                } catch (Exception e4) {
                    d.a("NetRequester", "lastModified error = " + e4);
                }
            }
            InputStream inputStream2 = httpURLConnection.getInputStream();
            if (inputStream2 != null) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int i4 = inputStream2.read();
                            if (i4 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(i4);
                        } catch (Throwable th2) {
                            J.l(byteArrayOutputStream);
                            throw th2;
                        }
                    }
                    byteArray = byteArrayOutputStream.toByteArray();
                    J.l(byteArrayOutputStream);
                    if (byteArray != null) {
                        try {
                            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                            cipher.init(2, new SecretKeySpec("3CB48439E16F4BB2".getBytes(Constants.UTF_8_CODE), "AES"));
                            byteArray = cipher.doFinal(byteArray);
                        } catch (Exception e5) {
                            d.a("NetRequester", "secret error = " + e5);
                        }
                    }
                } catch (Throwable th3) {
                    inputStream = inputStream2;
                    th = th3;
                    J.l(inputStream);
                    httpURLConnection.disconnect();
                    throw th;
                }
            } else {
                byteArray = null;
            }
            d.a("NetRequester", "body = " + byteArray);
            if (byteArray != null) {
                netResponse = new NetResponse(responseCode, new String(byteArray));
                J.l(inputStream2);
                httpURLConnection.disconnect();
            } else {
                netResponse = new NetResponse(responseCode, null);
                J.l(inputStream2);
                httpURLConnection.disconnect();
            }
            return netResponse;
        } catch (Throwable th4) {
            th = th4;
            J.l(inputStream);
            httpURLConnection.disconnect();
            throw th;
        }
    }
}
