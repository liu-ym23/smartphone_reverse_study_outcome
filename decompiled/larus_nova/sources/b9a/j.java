package b9a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.monitor.cloudmessage.utils.NetworkUtils;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class j extends a9a.a implements h9a.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PolarisFileWrapper f18366b;

    @Override // a9a.a
    public final String f() {
        return "network";
    }

    @Override // h9a.a
    public final List<String> a() {
        ArrayList r100 = new ArrayList(1);
        PolarisFileWrapper r101 = this.f18366b;
        if (r101 == null) goto L5;
        r100.add(r101.getAbsolutePath());
    L5:
        return r100;
    }

    public j() {
        this.f18366b = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.BufferedWriter] */
    /* JADX WARN: Type inference failed for: r7v4 */
    @Override // a9a.a
    public final boolean g(z8a.a r110) throws Exception {
        if (a9a.a.e(new JSONObject(r110.f570965a), r110) == false) goto L5;
        return true;
    L5:
        Context r100 = x8a.c.b().getContext();
        String r101 = "ping -c 5 ";
        String r102 = new JSONObject(r110.f570965a).optString("domain");
        if (TextUtils.isEmpty(r102) == true) goto L111;
        JSONObject r103 = new JSONObject();
        if (r102.startsWith("http://") == false) goto L10;
    L12:
        String r104 = null;
        String r105 = r102;
    L123:
        String r106 = new URL(r105).getHost();     // Catch: Throwable -> L61 Exception -> L65
        String r111 = com.monitor.cloudmessage.utils.a.e(r100).getAbsolutePath();     // Catch: Throwable -> L61 Exception -> L65
        String r112 = r111 + File.separator + String.format("%s.txt", new Object[]{r106});     // Catch: Throwable -> L61 Exception -> L65
        r103.put("networkType", NetworkUtils.e(r100));     // Catch: Throwable -> L61 Exception -> L65
        r103.put("currentNativeIP", NetworkUtils.d());     // Catch: Throwable -> L61 Exception -> L65
        r103.put(IVideoEventLogger.LOGGER_DNS_TYPE_LOCAL, NetworkUtils.c(r100));     // Catch: Throwable -> L61 Exception -> L65
        r103.put("localGateway", NetworkUtils.b(r100));     // Catch: Throwable -> L61 Exception -> L65
        r103.put("uploadSpeed", NetworkUtils.f(r100));     // Catch: Throwable -> L61 Exception -> L65
        r103.put("downloadSpeed", NetworkUtils.a(r100));     // Catch: Throwable -> L61 Exception -> L65
        r103.put("cdn", r106);     // Catch: Throwable -> L61 Exception -> L65
        r103.put("domainNameParse", NetworkUtils.h(r106));     // Catch: Throwable -> L61 Exception -> L65
        if (NetworkUtils.i(r105, r103) == true) goto L17;
        if (r104 == null) goto L17;
        NetworkUtils.i(r104, r103);     // Catch: Throwable -> L61 Exception -> L65
    L17:
        Process r107 = d9a.c.a(Runtime.getRuntime(), "ping -c 5 " + r106);     // Catch: Throwable -> L61 Exception -> L65
        OutputStream r108 = r107.getOutputStream();     // Catch: Throwable -> L61 Exception -> L65
        r108.close();     // Catch: Throwable -> L57 Exception -> L59
        long r109 = System.nanoTime();     // Catch: Throwable -> L57 Exception -> L59
        InputStream r113 = r107.getInputStream();     // Catch: Throwable -> L57 Exception -> L59
        BufferedReader r114 = new BufferedReader(new InputStreamReader(r113, "UTF8"));     // Catch: Throwable -> L53 Exception -> L55
        JSONArray r115 = new JSONArray();     // Catch: Throwable -> L53 Exception -> L55
        float r116 = 0.0f;
    L20:
        String r117 = r114.readLine();     // Catch: Throwable -> L53 Exception -> L55
        if (r117 == null) goto L27;
        r115.put(r117);     // Catch: Throwable -> L53 Exception -> L55
        if (r117.contains("From") == true) goto L26;
        if (r117.contains("from") == false) goto L20;
    L26:
        r116 = (System.nanoTime() - r109) / 1000000.0f;     // Catch: Throwable -> L53 Exception -> L55
        goto L20
    L27:
        r107.destroy();     // Catch: Throwable -> L53 Exception -> L55
        r103.put("pingResults", r115);     // Catch: Throwable -> L53 Exception -> L55
        r103.put("elapsedTime", r116);     // Catch: Throwable -> L53 Exception -> L55
        PolarisFileWrapper r118 = new PolarisFileWrapper(r111);     // Catch: Throwable -> L53 Exception -> L55
        if (r118.exists() == true) goto L30;
        r118.mkdirs();     // Catch: Throwable -> L53 Exception -> L55
    L30:
        PolarisFileWriterWrapper r119 = new PolarisFileWriterWrapper(r112);     // Catch: Throwable -> L53 Exception -> L55
    L140:
        BufferedWriter r120 = new BufferedWriter(r119);     // Catch: Throwable -> L49 Exception -> L51
        r120.write(r103.toString());     // Catch: Exception -> L47 Throwable -> L89
        r108.close();     // Catch: IOException -> L35
    L37:
        if (r113 != null) goto L124;
    L117:
        r120.close();     // Catch: IOException -> L44
        r119.close();     // Catch: IOException -> L44
    L46:
        PolarisFileWrapper r121 = new PolarisFileWrapper(r112);
    L112:
        if (r121 != null) goto L115;
        a9a.a.h("网络信息文件生成失败", r110);
        return true;
    L115:
        this.f18366b = r121;
        g9a.a.b(new i9a.a("json", r110.f570967c, this, null));
        return true;
    L44:
        e = move-exception;
        e.printStackTrace();
        goto L46
    L124:
        r113.close();     // Catch: IOException -> L40
    L40:
        e = move-exception;
        e.printStackTrace();
    L35:
        e = move-exception;
        e.printStackTrace();
    L47:
        e = e;
    L70:
        e.printStackTrace();     // Catch: Throwable -> L89
        if (r108 != null) goto L126;
    L76:
        if (r113 != null) goto L119;
    L81:
        if (r120 != null) goto L132;
    L85:
        if (r119 == null) goto L111;
        r119.close();     // Catch: IOException -> L83
    L83:
        e = move-exception;
        e.printStackTrace();
        goto L111
    L132:
        r120.close();     // Catch: IOException -> L83
        goto L85
    L119:
        r113.close();     // Catch: IOException -> L79
    L79:
        e = move-exception;
        e.printStackTrace();
        goto L81
    L126:
        r108.close();     // Catch: IOException -> L74
    L74:
        e = move-exception;
        e.printStackTrace();
        goto L76
    L51:
        e = e;
    L69:
        r120 = null;
    L49:
        th = th;
        String r122 = null;
        Object r123 = r108;
        Object r124 = r113;
    L91:
        Throwable r125 = th;
        String r126 = r122;
        PolarisFileWriterWrapper r127 = r119;
        ?? r128 = r126;
        ?? r129 = r123;
        ?? r130 = r124;
    L92:
        if (r129 != 0) goto L136;
    L97:
        if (r130 != 0) goto L128;
    L102:
        if (r128 != 0) goto L121;
    L106:
        if (r127 == null) goto L151;
        r127.close();     // Catch: IOException -> L104
        throw r125;
    L104:
        e = move-exception;
        e.printStackTrace();
        throw r125;
    L151:
        throw r125;
    L121:
        r128.close();     // Catch: IOException -> L104
        goto L106
    L128:
        r130.close();     // Catch: IOException -> L100
    L100:
        e = move-exception;
        e.printStackTrace();
        goto L102
    L136:
        r129.close();     // Catch: IOException -> L95
    L95:
        e = move-exception;
        e.printStackTrace();
    L55:
        e = e;
    L68:
        r119 = null;
    L53:
        th = th;
    L64:
        r125 = th;
        r128 = 0;
        r127 = null;
        r129 = r108;
        r130 = r113;
        goto L92
    L59:
        e = e;
    L67:
        r113 = null;
    L57:
        th = th;
    L63:
        r113 = null;
        goto L64
    L89:
        th = th;
        r122 = r104;
        r123 = r105;
        r124 = r101;
    L65:
        e = e;
        r108 = null;
    L61:
        th = th;
        r108 = null;
        goto L63
    L10:
        if (r102.startsWith("https://") == true) goto L12;
        r104 = "http://".concat(r102);
        r105 = "https://".concat(r102);
    L111:
        r121 = null;
        goto L112
    }
}
