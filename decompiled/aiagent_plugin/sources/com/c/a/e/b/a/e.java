package com.c.a.e.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: NetworkFileGenerator.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.InputStream] */
    public static File a(Context r13, JSONObject r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        String r16 = r14.optString("domain");
        OutputStream r1 = null;
        if (TextUtils.isEmpty(r16) == true) goto L110;
        JSONObject r0 = new JSONObject();
        if (r16.startsWith("http://") == false) goto L7;
    L9:
        String r2 = null;
    L137:
        String r3 = new URL(r16).getHost();     // Catch: Throwable -> L64 Exception -> L66
        String r4 = com.c.a.i.b.a(r15).getAbsolutePath();     // Catch: Throwable -> L64 Exception -> L66
        String r5 = r4 + File.separator + String.format("%s.txt", new Object[]{r3});     // Catch: Throwable -> L64 Exception -> L66
        r0.put("networkType", com.c.a.i.c.g(r15));     // Catch: Throwable -> L64 Exception -> L66
        r0.put("currentNativeIP", com.c.a.i.c.a());     // Catch: Throwable -> L64 Exception -> L66
        r0.put("localDNS", com.c.a.i.c.c(r15));     // Catch: Throwable -> L64 Exception -> L66
        r0.put("localGateway", com.c.a.i.c.f(r15));     // Catch: Throwable -> L64 Exception -> L66
        r0.put("uploadSpeed", com.c.a.i.c.e(r15));     // Catch: Throwable -> L64 Exception -> L66
        r0.put("downloadSpeed", com.c.a.i.c.d(r15));     // Catch: Throwable -> L64 Exception -> L66
        r0.put("cdn", r3);     // Catch: Throwable -> L64 Exception -> L66
        r0.put("domainNameParse", com.c.a.i.c.a(r3));     // Catch: Throwable -> L64 Exception -> L66
        if (com.c.a.i.c.a(r16, r0) == true) goto L14;
        if (r2 == null) goto L14;
        com.c.a.i.c.a(r2, r0);     // Catch: Throwable -> L64 Exception -> L66
    L14:
        Process r17 = Runtime.getRuntime().exec("ping -c 5 " + r3);     // Catch: Throwable -> L64 Exception -> L66
        OutputStream r18 = r17.getOutputStream();     // Catch: Throwable -> L64 Exception -> L66
        r18.close();     // Catch: Throwable -> L60 Exception -> L62
        long r6 = System.nanoTime();     // Catch: Throwable -> L60 Exception -> L62
        float r7 = 0.0f;
        InputStream r8 = r17.getInputStream();     // Catch: Throwable -> L60 Exception -> L62
    L139:
        BufferedReader r9 = new BufferedReader(new InputStreamReader(r8, "UTF8"));     // Catch: Throwable -> L56 Exception -> L58
        JSONArray r10 = new JSONArray();     // Catch: Throwable -> L56 Exception -> L58
    L17:
        String r11 = r9.readLine();     // Catch: Throwable -> L56 Exception -> L58
        if (r11 == null) goto L24;
        r10.put(r11);     // Catch: Throwable -> L56 Exception -> L58
        if (r11.contains("From") == true) goto L23;
        if (r11.contains("from") == false) goto L17;
    L23:
        r7 = (System.nanoTime() - r6) / 1000000.0f;     // Catch: Throwable -> L56 Exception -> L58
        goto L17
    L24:
        r17.destroy();     // Catch: Throwable -> L56 Exception -> L58
        r0.put("pingResults", r10);     // Catch: Throwable -> L56 Exception -> L58
        r0.put("elapsedTime", r7);     // Catch: Throwable -> L56 Exception -> L58
        File r19 = new File(r4);     // Catch: Throwable -> L56 Exception -> L58
        if (r19.exists() == true) goto L27;
        r19.mkdirs();     // Catch: Throwable -> L56 Exception -> L58
    L27:
        FileWriter r110 = new FileWriter(r5);     // Catch: Throwable -> L56 Exception -> L58
        BufferedWriter r12 = new BufferedWriter(r110);     // Catch: Throwable -> L50 Exception -> L53
    L135:
        r12.write(r0.toString());     // Catch: Throwable -> L46 Exception -> L48
        if (r18 != null) goto L123;
    L35:
        if (r8 == null) goto L127;
        r8.close();     // Catch: IOException -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
    L127:
        r12.close();     // Catch: IOException -> L42
        r110.close();     // Catch: IOException -> L42
    L45:
        return new File(r5);
    L42:
        e = move-exception;
        e.printStackTrace();
        goto L45
    L123:
        r18.close();     // Catch: IOException -> L33
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L35
    L48:
        e = e;
    L55:
        FileWriter r111 = r110;
        e = e;
        OutputStream r20 = r18;
        ?? r21 = r8;
    L111:
        e.printStackTrace();     // Catch: Throwable -> L89
        if (r20 != null) goto L125;
    L75:
        if (r21 != 0) goto L119;
    L80:
        if (r12 != null) goto L113;
    L84:
        if (r111 == null) goto L88;
        r111.close();     // Catch: IOException -> L82
    L82:
        e = move-exception;
        e.printStackTrace();
    L88:
        return null;
    L113:
        r12.close();     // Catch: IOException -> L82
        goto L84
    L119:
        r21.close();     // Catch: IOException -> L78
    L78:
        e = move-exception;
        e.printStackTrace();
        goto L80
    L125:
        r20.close();     // Catch: IOException -> L73
    L73:
        e = move-exception;
        e.printStackTrace();
    L89:
        th = th;
        r1 = r20;
        ?? r22 = r21;
    L91:
        if (r1 != null) goto L121;
    L96:
        if (r22 != 0) goto L115;
    L101:
        if (r12 != null) goto L129;
    L105:
        if (r111 == null) goto L147;
        r111.close();     // Catch: IOException -> L103
        throw th;
    L103:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L147:
        throw th;
    L129:
        r12.close();     // Catch: IOException -> L103
        goto L105
    L115:
        r22.close();     // Catch: IOException -> L99
    L99:
        e = move-exception;
        e.printStackTrace();
        goto L101
    L121:
        r1.close();     // Catch: IOException -> L94
    L94:
        e = move-exception;
        e.printStackTrace();
    L46:
        th = th;
    L52:
        r1 = r18;
        r111 = r110;
        th = th;
        r22 = r8;
    L53:
        e = e;
        r12 = null;
    L50:
        th = th;
        r12 = null;
        goto L52
    L58:
        e = e;
        r20 = r18;
        r111 = null;
        r12 = null;
        r21 = r8;
    L56:
        th = th;
        r12 = null;
        r1 = r18;
        r111 = null;
        r22 = r8;
    L62:
        e = e;
        r20 = r18;
        r111 = null;
        r12 = null;
    L68:
        r21 = r12;
    L60:
        th = th;
        r12 = null;
        r22 = 0;
        r1 = r18;
        r111 = null;
        goto L91
    L66:
        e = e;
        r111 = null;
        r20 = null;
        r12 = null;
    L64:
        th = th;
        r111 = null;
        r12 = null;
        r22 = 0;
        goto L91
    L7:
        if (r16.startsWith("https://") == true) goto L9;
        r2 = "http://" + r16;
        r16 = "https://" + r16;
        goto L137
    L110:
        return null;
    }
}
