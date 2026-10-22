package com.monitor.cloudmessage.internal.file.generator;

import android.content.Context;
import android.text.TextUtils;
import com.monitor.cloudmessage.utils.FileUtils;
import com.monitor.cloudmessage.utils.NetworkUtils;
import com.obric.contactsdk.loader.ContractKt;
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

/* JADX INFO: loaded from: classes3.dex */
public class NetworkFileGenerator {
    private static final int DEFAULT_PING_TIME = 5;
    private static final String FROM_PING = "From";
    private static final String SMALL_FROM_PING = "from";

    public NetworkFileGenerator() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static File generateFile(Context r13, JSONObject r14) {
        String r15 = r14.optString(ContractKt.PARAM_ACTION_DOMAIN);
        OutputStream r2 = null;
        if (TextUtils.isEmpty(r15) == true) goto L111;
        JSONObject r1 = new JSONObject();
        if (r15.startsWith("http://") == false) goto L7;
    L9:
        String r3 = null;
    L140:
        String r4 = new URL(r15).getHost();     // Catch: Throwable -> L65 Exception -> L67
        String r5 = FileUtils.getCloudMsgDir(r13).getAbsolutePath();     // Catch: Throwable -> L65 Exception -> L67
        String r6 = r5 + File.separator + String.format("%s.txt", new Object[]{r4});     // Catch: Throwable -> L65 Exception -> L67
        r1.put("networkType", NetworkUtils.getNetworkAccessType(r13));     // Catch: Throwable -> L65 Exception -> L67
        r1.put("currentNativeIP", NetworkUtils.getNativeIp());     // Catch: Throwable -> L65 Exception -> L67
        r1.put("localDNS", NetworkUtils.getLocalDNS(r13));     // Catch: Throwable -> L65 Exception -> L67
        r1.put("localGateway", NetworkUtils.getGateway(r13));     // Catch: Throwable -> L65 Exception -> L67
        r1.put("uploadSpeed", NetworkUtils.getUploadSpeed(r13));     // Catch: Throwable -> L65 Exception -> L67
        r1.put("downloadSpeed", NetworkUtils.getDownloadSpeed(r13));     // Catch: Throwable -> L65 Exception -> L67
        r1.put("cdn", r4);     // Catch: Throwable -> L65 Exception -> L67
        r1.put("domainNameParse", NetworkUtils.parseDomainName(r4));     // Catch: Throwable -> L65 Exception -> L67
        if (NetworkUtils.testGet(r15, r1) == true) goto L14;
        if (r3 == null) goto L14;
        NetworkUtils.testGet(r3, r1);     // Catch: Throwable -> L65 Exception -> L67
    L14:
        Process r16 = Runtime.getRuntime().exec("ping -c 5 " + r4);     // Catch: Throwable -> L65 Exception -> L67
        OutputStream r17 = r16.getOutputStream();     // Catch: Throwable -> L65 Exception -> L67
        r17.close();     // Catch: Throwable -> L60 Exception -> L63
        long r7 = System.nanoTime();     // Catch: Throwable -> L60 Exception -> L63
        InputStream r0 = r16.getInputStream();     // Catch: Throwable -> L60 Exception -> L63
        BufferedReader r8 = new BufferedReader(new InputStreamReader(r0, "UTF8"));     // Catch: Throwable -> L56 Exception -> L58
        JSONArray r9 = new JSONArray();     // Catch: Throwable -> L56 Exception -> L58
        float r10 = 0.0f;
    L17:
        String r11 = r8.readLine();     // Catch: Throwable -> L56 Exception -> L58
        if (r11 == null) goto L24;
        r9.put(r11);     // Catch: Throwable -> L56 Exception -> L58
        if (r11.contains("From") == true) goto L23;
        if (r11.contains("from") == false) goto L17;
    L23:
        r10 = (System.nanoTime() - r7) / 1000000.0f;     // Catch: Throwable -> L56 Exception -> L58
        goto L17
    L24:
        r16.destroy();     // Catch: Throwable -> L56 Exception -> L58
        r1.put("pingResults", r9);     // Catch: Throwable -> L56 Exception -> L58
        r1.put("elapsedTime", r10);     // Catch: Throwable -> L56 Exception -> L58
        File r18 = new File(r5);     // Catch: Throwable -> L56 Exception -> L58
        if (r18.exists() == true) goto L27;
        r18.mkdirs();     // Catch: Throwable -> L56 Exception -> L58
    L27:
        FileWriter r19 = new FileWriter(r6);     // Catch: Throwable -> L56 Exception -> L58
    L138:
        BufferedWriter r12 = new BufferedWriter(r19);     // Catch: Throwable -> L50 Exception -> L53
        r12.write(r1.toString());     // Catch: Throwable -> L46 Exception -> L48
        if (r17 != null) goto L120;
    L35:
        if (r0 == null) goto L124;
        r0.close();     // Catch: IOException -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
    L124:
        r12.close();     // Catch: IOException -> L42
        r19.close();     // Catch: IOException -> L42
    L45:
        return new File(r6);
    L42:
        e = move-exception;
        e.printStackTrace();
        goto L45
    L120:
        r17.close();     // Catch: IOException -> L33
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L35
    L48:
        e = e;
    L55:
        FileWriter r110 = r19;
        e = e;
        InputStream r20 = r0;
        OutputStream r21 = r17;
        BufferedWriter r22 = r12;
    L116:
        e.printStackTrace();     // Catch: Throwable -> L90
        if (r21 != null) goto L122;
    L76:
        if (r20 != null) goto L114;
    L81:
        if (r22 != 0) goto L128;
    L85:
        if (r110 == null) goto L89;
        r110.close();     // Catch: IOException -> L83
    L83:
        e = move-exception;
        e.printStackTrace();
    L89:
        return null;
    L128:
        r22.close();     // Catch: IOException -> L83
        goto L85
    L114:
        r20.close();     // Catch: IOException -> L79
    L79:
        e = move-exception;
        e.printStackTrace();
        goto L81
    L122:
        r21.close();     // Catch: IOException -> L74
    L74:
        e = move-exception;
        e.printStackTrace();
    L90:
        th = th;
        r2 = r21;
        r0 = r20;
        BufferedWriter r23 = r22;
        FileWriter r111 = r110;
    L92:
        if (r2 != null) goto L118;
    L97:
        if (r0 != null) goto L130;
    L102:
        if (r23 != 0) goto L126;
    L106:
        if (r111 == null) goto L148;
        r111.close();     // Catch: IOException -> L104
        throw th;
    L104:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L148:
        throw th;
    L126:
        r23.close();     // Catch: IOException -> L104
        goto L106
    L130:
        r0.close();     // Catch: IOException -> L100
    L100:
        e = move-exception;
        e.printStackTrace();
        goto L102
    L118:
        r2.close();     // Catch: IOException -> L95
    L95:
        e = move-exception;
        e.printStackTrace();
    L46:
        th = th;
    L52:
        r2 = r17;
        r111 = r19;
        th = th;
        r23 = r12;
        goto L92
    L53:
        e = e;
        r12 = null;
    L50:
        th = th;
        r12 = null;
    L58:
        e = e;
        r20 = r0;
        r22 = 0;
        r21 = r17;
        r110 = null;
    L56:
        th = th;
        FileWriter r24 = null;
    L62:
        r2 = r17;
        r111 = r24;
        r23 = r24;
        goto L92
    L63:
        e = e;
        r21 = r17;
        FileWriter r112 = null;
        r20 = null;
    L69:
        r22 = r20;
        r110 = r112;
    L60:
        th = th;
        r0 = null;
        r24 = null;
        goto L62
    L67:
        e = e;
        r112 = null;
        r21 = null;
        r20 = null;
    L65:
        th = th;
        r111 = null;
        r0 = null;
        r23 = 0;
        goto L92
    L7:
        if (r15.startsWith("https://") == true) goto L9;
        r3 = "http://" + r15;
        r15 = "https://" + r15;
        goto L140
    L111:
        return null;
    }
}
