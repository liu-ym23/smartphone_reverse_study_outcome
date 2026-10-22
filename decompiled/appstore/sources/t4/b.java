package t4;

import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.i;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.SsCall;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24721a = "b";

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public static String a(String r12, String r13) {
        Logger.d(f24721a, "start execute httpdns get " + r12);
        long r10 = System.currentTimeMillis();
        StringBuilder r11 = new StringBuilder();
        SsCall r14 = null;
        String r15 = null;
        BufferedReader r16 = null;
        r14 = null;
        int r17 = 0;
        g6.b r18 = new g6.b.a().c(r12).a();     // Catch: Throwable -> L41 Exception -> L43
        r18.N(new RetrofitMetrics());     // Catch: Throwable -> L41 Exception -> L43
        SsCall r19 = i.H(com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.b.q().h().getContext()).newSsCall(r18);     // Catch: Throwable -> L41 Exception -> L43
        g6.c r20 = r19.execute();     // Catch: Throwable -> L24 Exception -> L26
        if (r20 != null) goto L7;
        ?? r21 = 0;
        InputStream r22 = null;
    L32:
        r19.cancel();
        if (r16 != null) goto L83;
    L37:
        if (r22 == null) goto L57;
        r22.close();     // Catch: IOException -> L35
    L35:
        e = move-exception;
        e.printStackTrace();
    L57:
        long r23 = System.currentTimeMillis() - r10;
        ?? r24 = new JSONObject();     // Catch: JSONException -> L62
        r24.put("request_url", r12);     // Catch: JSONException -> L62
        r24.put("httpdns_domain", r13);     // Catch: JSONException -> L62
        if (r21 != 0) goto L64;
        r24.put("result", "");     // Catch: JSONException -> L62
    L65:
        r24.put("response_code", r17);     // Catch: JSONException -> L62
        r24.put("rtt", r23);     // Catch: JSONException -> L62
        Logger.d(f24721a, r24.toString());     // Catch: JSONException -> L62
    L68:
        return r21;
    L64:
        r24.put("result", r21);     // Catch: JSONException -> L62
    L62:
        e = move-exception;
        e.printStackTrace();
        goto L68
    L83:
        r16.close();     // Catch: IOException -> L35
        goto L37
    L7:
        if (r20.g() == true) goto L9;
    L28:
        r22 = null;
        BufferedReader r25 = null;
    L29:
        r15 = r11.toString();     // Catch: Throwable -> L15 Exception -> L17
        r17 = r20.e();     // Catch: Throwable -> L15 Exception -> L17
        r21 = r15;
        r16 = r25;
        goto L32
    L17:
        e = e;
        ?? r26 = r15;
        r14 = r19;
    L85:
        e.printStackTrace();     // Catch: Throwable -> L69
        if (r14 == null) goto L48;
        r14.cancel();
    L48:
        if (r25 != null) goto L81;
    L52:
        if (r22 == null) goto L56;
        r22.close();     // Catch: IOException -> L50
    L50:
        e = move-exception;
        e.printStackTrace();
    L56:
        r21 = r26;
        goto L57
    L81:
        r25.close();     // Catch: IOException -> L50
    L69:
        th = th;
    L70:
        if (r14 == null) goto L72;
        r14.cancel();
    L72:
        if (r25 != null) goto L89;
    L76:
        if (r22 == null) goto L80;
        r22.close();     // Catch: IOException -> L74
    L74:
        e = move-exception;
        e.printStackTrace();
    L80:
        throw th;
    L89:
        r25.close();     // Catch: IOException -> L74
    L15:
        th = th;
    L16:
        r14 = r19;
        goto L70
    L9:
        if (r20.a() == null) goto L28;
        r22 = r20.a().in();     // Catch: Throwable -> L24 Exception -> L26
    L93:
        r25 = new BufferedReader(new InputStreamReader(r22, "UTF-8"));     // Catch: Throwable -> L19 Exception -> L21
    L95:
        String r27 = r25.readLine();     // Catch: Throwable -> L15 Exception -> L17
        if (r27 == null) goto L29;
        r11.append(r27);     // Catch: Throwable -> L15 Exception -> L17
    L21:
        e = e;
        r25 = null;
    L23:
        r14 = r19;
        r26 = r25;
    L19:
        th = th;
        r25 = null;
    L26:
        e = e;
        r22 = null;
        r25 = null;
    L24:
        th = th;
        r22 = null;
        r25 = null;
        goto L16
    L43:
        e = e;
        r26 = 0;
        r22 = null;
        r25 = null;
    L41:
        th = th;
        r22 = null;
        r25 = null;
        goto L70
    }
}
