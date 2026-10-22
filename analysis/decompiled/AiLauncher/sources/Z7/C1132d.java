package Z7;

import android.util.Pair;
import com.amap.api.col.jmsl.s7;
import io.ktor.sse.ServerSentEventKt;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: Z7.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1132d {
    public static Pair<Integer, String> a(String str, String str2, Map<String, String> map) throws IOException {
        InputStream inputStream;
        DataOutputStream dataOutputStream;
        String message;
        HttpURLConnection httpURLConnection;
        InputStream errorStream;
        HttpURLConnection httpURLConnection2 = null;
        int responseCode = -1;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                d(httpURLConnection, map);
                httpURLConnection.setConnectTimeout(s7.DEFAULT_RETRY_TIMEOUT);
                httpURLConnection.setReadTimeout(s7.DEFAULT_RETRY_TIMEOUT);
                httpURLConnection.connect();
                byte[] bytes = str2.getBytes("UTF-8");
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream.write(bytes);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    responseCode = httpURLConnection.getResponseCode();
                    errorStream = responseCode >= 400 ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection2 = httpURLConnection;
                    inputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream = null;
                httpURLConnection2 = httpURLConnection;
                inputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            dataOutputStream = null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, "UTF-8"));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb2.append(line);
                sb2.append(ServerSentEventKt.END_OF_LINE);
            }
            bufferedReader.close();
            message = sb2.toString();
            c(null);
            c(errorStream);
            httpURLConnection.disconnect();
        } catch (Throwable th4) {
            httpURLConnection2 = httpURLConnection;
            inputStream = errorStream;
            th = th4;
            dataOutputStream = null;
            try {
                C1139k.g(th);
                message = th.getMessage();
                return new Pair<>(Integer.valueOf(responseCode), message);
            } finally {
                c(dataOutputStream);
                c(inputStream);
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            }
        }
        return new Pair<>(Integer.valueOf(responseCode), message);
    }

    public static Pair<Integer, String> b(List<String> list) {
        try {
            HashMap map = new HashMap();
            map.put("Atta-Type", "batch-report");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("attaid", "0d000062340").put(M5.b.CREDENTIAL_TOKEN, "2273782735").put("type", "batch").put("version", "v1.0.0");
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put("datas", jSONArray);
            return a("https://h.trace.qq.com/kv", jSONObject.toString(), map);
        } catch (Throwable th) {
            C1139k.g(th);
            return new Pair<>(-1, th.getMessage());
        }
    }

    public static void c(Closeable closeable) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e10) {
            C1139k.g(e10);
        }
    }

    public static void d(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (httpURLConnection == null || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }
}
