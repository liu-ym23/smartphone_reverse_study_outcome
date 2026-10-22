package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.r;
import com.bytedance.retrofit2.af;
import com.bytedance.retrofit2.b.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: HttpsURLConnClient.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String TAG = "b";

    static {
    }

    public b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static String a(String r12, String r13) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "start execute httpdns get " + r12);
    L5:
        long r1 = System.currentTimeMillis();
        StringBuilder r3 = new StringBuilder();
        int r4 = 0;
        e r5 = null;
        String r6 = null;
        BufferedReader r7 = null;
        r5 = null;
        com.bytedance.retrofit2.b.c r8 = new com.bytedance.retrofit2.b.c.a().a(r12).b();     // Catch: Throwable -> L46 Exception -> L48
        r8.a(new af());     // Catch: Throwable -> L46 Exception -> L48
        e r0 = r.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.e.getService().c().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).a(r8);     // Catch: Throwable -> L46 Exception -> L48
        com.bytedance.retrofit2.b.d r9 = r0.m();     // Catch: Throwable -> L40 Exception -> L43
        if (r9 != null) goto L10;
        ?? r10 = 0;
        InputStream r11 = null;
    L30:
        if (r0 == null) goto L32;
        r0.n();
    L32:
        if (r7 != null) goto L87;
    L36:
        if (r11 == null) goto L62;
        r11.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L62:
        long r14 = System.currentTimeMillis() - r1;
        ?? r2 = new JSONObject();     // Catch: JSONException -> L72
        r2.put("request_url", r12);     // Catch: JSONException -> L72
        r2.put("httpdns_domain", r13);     // Catch: JSONException -> L72
        if (r10 != 0) goto L67;
        r2.put("result", "");     // Catch: JSONException -> L72
    L68:
        r2.put("response_code", r4);     // Catch: JSONException -> L72
        r2.put("rtt", r14);     // Catch: JSONException -> L72
        if (Logger.debug() == false) goto L74;
        Logger.d(TAG, r2.toString());     // Catch: JSONException -> L72
    L74:
        return r10;
    L67:
        r2.put("result", r10);     // Catch: JSONException -> L72
    L72:
        e = move-exception;
        e.printStackTrace();
        goto L74
    L87:
        r7.close();     // Catch: IOException -> L34
        goto L36
    L10:
        if (r9.e() == true) goto L12;
    L22:
        r11 = null;
        BufferedReader r15 = null;
    L23:
        r6 = r3.toString();     // Catch: Throwable -> L25 Exception -> L27
        r4 = r9.b();     // Catch: Throwable -> L25 Exception -> L27
        r10 = r6;
        r7 = r15;
        goto L30
    L27:
        e = e;
        String r16 = r6;
        r5 = r0;
        ?? r17 = r16;
    L89:
        e.printStackTrace();     // Catch: Throwable -> L75
        if (r5 == null) goto L53;
        r5.n();
    L53:
        if (r15 != null) goto L91;
    L57:
        if (r11 == null) goto L61;
        r11.close();     // Catch: IOException -> L55
    L55:
        e = move-exception;
        e.printStackTrace();
    L61:
        r10 = r17;
        goto L62
    L91:
        r15.close();     // Catch: IOException -> L55
    L75:
        th = th;
    L76:
        if (r5 == null) goto L78;
        r5.n();
    L78:
        if (r15 != null) goto L95;
    L82:
        if (r11 == null) goto L86;
        r11.close();     // Catch: IOException -> L80
    L80:
        e = move-exception;
        e.printStackTrace();
    L86:
        throw th;
    L95:
        r15.close();     // Catch: IOException -> L80
    L25:
        th = th;
    L42:
        r5 = r0;
        goto L76
    L12:
        if (r9.d() == null) goto L22;
        r11 = r9.d().e_();     // Catch: Throwable -> L40 Exception -> L43
    L101:
        r15 = new BufferedReader(new InputStreamReader(r11, "UTF-8"));     // Catch: Throwable -> L18 Exception -> L20
    L97:
        String r18 = r15.readLine();     // Catch: Throwable -> L25 Exception -> L27
        if (r18 == null) goto L23;
        r3.append(r18);     // Catch: Throwable -> L25 Exception -> L27
        goto L97
    L20:
        e = e;
        r15 = null;
    L45:
        r5 = r0;
        r17 = r15;
    L18:
        th = th;
        r15 = null;
    L43:
        e = e;
        r11 = null;
        r15 = null;
    L40:
        th = th;
        r11 = null;
        r15 = null;
        goto L42
    L48:
        e = e;
        r17 = 0;
        r11 = null;
        r15 = null;
    L46:
        th = th;
        r11 = null;
        r15 = null;
        goto L76
    }
}
