package aa;

import android.content.Context;
import android.text.TextUtils;
import com.monitor.cloudmessage.utils.NetworkUtils;
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
public abstract class e {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.InputStream] */
    public static File a(Context r13, JSONObject r14) {
        String r15 = r14.optString("domain");
        OutputStream r10 = null;
        if (TextUtils.isEmpty(r15) == true) goto L108;
        JSONObject r11 = new JSONObject();
        if (r15.startsWith("http://") == false) goto L7;
    L9:
        String r12 = null;
    L129:
        String r16 = new URL(r15).getHost();     // Catch: Throwable -> L14 Exception -> L16
        String r17 = com.monitor.cloudmessage.utils.b.h(r13).getAbsolutePath();     // Catch: Throwable -> L14 Exception -> L16
        String r18 = r17 + File.separator + String.format("%s.txt", new Object[]{r16});     // Catch: Throwable -> L14 Exception -> L16
        r11.put("networkType", NetworkUtils.e(r13));     // Catch: Throwable -> L14 Exception -> L16
        r11.put("currentNativeIP", NetworkUtils.d());     // Catch: Throwable -> L14 Exception -> L16
        r11.put("localDNS", NetworkUtils.c(r13));     // Catch: Throwable -> L14 Exception -> L16
        r11.put("localGateway", NetworkUtils.b(r13));     // Catch: Throwable -> L14 Exception -> L16
        r11.put("uploadSpeed", NetworkUtils.j(r13));     // Catch: Throwable -> L14 Exception -> L16
        r11.put("downloadSpeed", NetworkUtils.a(r13));     // Catch: Throwable -> L14 Exception -> L16
        r11.put("cdn", r16);     // Catch: Throwable -> L14 Exception -> L16
        r11.put("domainNameParse", NetworkUtils.m(r16));     // Catch: Throwable -> L14 Exception -> L16
        if (NetworkUtils.n(r15, r11) == true) goto L19;
        if (r12 == null) goto L19;
        NetworkUtils.n(r12, r11);     // Catch: Throwable -> L14 Exception -> L16
    L19:
        Process r19 = Runtime.getRuntime().exec("ping -c 5 " + r16);     // Catch: Throwable -> L14 Exception -> L16
        OutputStream r110 = r19.getOutputStream();     // Catch: Throwable -> L14 Exception -> L16
    L137:
        r110.close();     // Catch: Throwable -> L63 Exception -> L65
        long r20 = System.nanoTime();     // Catch: Throwable -> L63 Exception -> L65
        InputStream r21 = r19.getInputStream();     // Catch: Throwable -> L63 Exception -> L65
        BufferedReader r22 = new BufferedReader(new InputStreamReader(r21, "UTF8"));     // Catch: Throwable -> L29 Exception -> L31
        JSONArray r23 = new JSONArray();     // Catch: Throwable -> L29 Exception -> L31
        float r24 = 0.0f;
    L22:
        String r111 = r22.readLine();     // Catch: Throwable -> L29 Exception -> L31
        if (r111 == null) goto L34;
        r23.put(r111);     // Catch: Throwable -> L29 Exception -> L31
        if (r111.contains("From") == true) goto L33;
        if (r111.contains("from") == false) goto L22;
    L33:
        r24 = (System.nanoTime() - r20) / 1000000.0f;     // Catch: Throwable -> L29 Exception -> L31
        goto L22
    L34:
        r19.destroy();     // Catch: Throwable -> L29 Exception -> L31
        r11.put("pingResults", r23);     // Catch: Throwable -> L29 Exception -> L31
        r11.put("elapsedTime", r24);     // Catch: Throwable -> L29 Exception -> L31
        File r112 = new File(r17);     // Catch: Throwable -> L29 Exception -> L31
        if (r112.exists() == true) goto L37;
        r112.mkdirs();     // Catch: Throwable -> L29 Exception -> L31
    L37:
        FileWriter r113 = new FileWriter(r18);     // Catch: Throwable -> L29 Exception -> L31
    L135:
        BufferedWriter r25 = new BufferedWriter(r113);     // Catch: Throwable -> L59 Exception -> L61
        r25.write(r11.toString());     // Catch: Throwable -> L55 Exception -> L57
        r110.close();     // Catch: IOException -> L42
    L44:
        if (r21 == null) goto L127;
        r21.close();     // Catch: IOException -> L47
    L47:
        e = move-exception;
        e.printStackTrace();
    L127:
        r25.close();     // Catch: IOException -> L51
        r113.close();     // Catch: IOException -> L51
    L54:
        return new File(r18);
    L51:
        e = move-exception;
        e.printStackTrace();
    L42:
        e = move-exception;
        e.printStackTrace();
        goto L44
    L57:
        e = e;
    L58:
        FileWriter r114 = r113;
        e = e;
        OutputStream r26 = r110;
        ?? r27 = r21;
    L119:
        e.printStackTrace();     // Catch: Throwable -> L87
        if (r26 != null) goto L115;
    L73:
        if (r27 != 0) goto L109;
    L78:
        if (r25 != null) goto L123;
    L82:
        if (r114 == null) goto L86;
        r114.close();     // Catch: IOException -> L80
    L80:
        e = move-exception;
        e.printStackTrace();
    L86:
        return null;
    L123:
        r25.close();     // Catch: IOException -> L80
        goto L82
    L109:
        r27.close();     // Catch: IOException -> L76
    L76:
        e = move-exception;
        e.printStackTrace();
        goto L78
    L115:
        r26.close();     // Catch: IOException -> L71
    L71:
        e = move-exception;
        e.printStackTrace();
    L87:
        th = th;
        r10 = r26;
        ?? r28 = r27;
    L89:
        if (r10 != null) goto L111;
    L94:
        if (r28 != 0) goto L125;
    L99:
        if (r25 != null) goto L117;
    L103:
        if (r114 == null) goto L145;
        r114.close();     // Catch: IOException -> L101
        throw th;
    L101:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L145:
        throw th;
    L117:
        r25.close();     // Catch: IOException -> L101
        goto L103
    L125:
        r28.close();     // Catch: IOException -> L97
    L97:
        e = move-exception;
        e.printStackTrace();
        goto L99
    L111:
        r10.close();     // Catch: IOException -> L92
    L92:
        e = move-exception;
        e.printStackTrace();
    L55:
        th = th;
    L56:
        r10 = r110;
        r114 = r113;
        th = th;
        r28 = r21;
        goto L89
    L61:
        e = e;
        r25 = null;
    L59:
        th = th;
        r25 = null;
    L31:
        e = e;
        r26 = r110;
        r114 = null;
        r25 = null;
        r27 = r21;
    L29:
        th = th;
        r25 = null;
        r10 = r110;
        r114 = null;
        r28 = r21;
        goto L89
    L65:
        e = e;
        r26 = r110;
        r114 = null;
        r25 = null;
    L18:
        r27 = r25;
    L63:
        th = th;
        r25 = null;
        r28 = 0;
        r10 = r110;
        r114 = null;
    L16:
        e = e;
        r114 = null;
        r26 = null;
        r25 = null;
    L14:
        th = th;
        r114 = null;
        r25 = null;
        r28 = 0;
        goto L89
    L7:
        if (r15.startsWith("https://") == true) goto L9;
        r12 = "http://" + r15;
        r15 = "https://" + r15;
        goto L129
    L108:
        return null;
    }
}
