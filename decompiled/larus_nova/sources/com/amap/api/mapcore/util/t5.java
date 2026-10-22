package com.amap.api.mapcore.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Proxy;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.security.MessageDigest;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes28.dex */
public class t5 {
    private static String a() {
        String r100 = Proxy.getDefaultHost();     // Catch: Throwable -> L4
    L6:
        if (r100 != null) goto L11;
        return "null";
    L11:
        return r100;
    L4:
        th = move-exception;
        t6.a(th, "pu", "gdh");
        r100 = null;
        goto L6
    }

    private static int b() {
        return Proxy.getDefaultPort();
    L4:
        th = move-exception;
        t6.a(th, "pu", "gdp");
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r11v0, types: [android.content.ContentResolver, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v10 */
    /* JADX WARN: Type inference failed for: r17v11 */
    /* JADX WARN: Type inference failed for: r17v12 */
    /* JADX WARN: Type inference failed for: r17v13 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Type inference failed for: r17v8 */
    /* JADX WARN: Type inference failed for: r17v9 */
    private static java.net.Proxy a(Context r110) {
        if (o5.h(r110) != 0) goto L5;
        boolean r100 = true;
    L7:
        if (r100 == false) goto L130;
        Uri r111 = UriProtector.parse("content://telephony/carriers/preferapn");
        ?? r112 = r110.getContentResolver();
        String r113 = null;
        ?? r114 = 80;
        r114 = 80;
        r114 = 80;
        r114 = 80;
        r114 = 80;
        Cursor r115 = com_amap_api_mapcore_util_t5_android_content_ContentResolver_query(r112, r111, null, null, null, null);     // Catch: Throwable -> L62 SecurityException -> L74
        if (r115 != null) goto L141;
    L59:
        r113 = null;
        r114 = -1;
    L60:
        if (r115 != null) goto L134;
    L73:
        ?? r101 = r114;
        if (r113 != null) goto L132;
    L117:
        boolean r102 = false;
    L118:
        if (r102 == false) goto L130;
        return new java.net.Proxy(java.net.Proxy.Type.HTTP, InetSocketAddress.createUnresolved(r113, r101 == true ? 1 : 0));
    L115:
        th = move-exception;
        p6.a(th, "pu", "gp2");
        th.printStackTrace();
        goto L130
    L132:
        if (r113.length() <= 0) goto L117;
        if (r101 == (-1)) goto L117;
        r102 = true;
    L134:
        r115.close();     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        t6.a(th, "pu", "gPx2");
        goto L73
    L141:
    L57:
        e = e;
    L76:
        ?? r116 = -1;
    L77:
        r113 = null;
    L78:
        t6.a(e, "pu", "ghp");     // Catch: Throwable -> L122
        String r103 = o5.b(r110);     // Catch: Throwable -> L122
        if (r103 == null) goto L104;
        String r104 = r103.toLowerCase(Locale.US);     // Catch: Throwable -> L122
        String r117 = a();     // Catch: Throwable -> L122
        int r118 = b();     // Catch: Throwable -> L122
        if (r104.indexOf("ctwap") == (-1)) goto L93;
        if (TextUtils.isEmpty(r117) == false) goto L85;
    L87:
        boolean r105 = false;
    L88:
        if (r105 == true) goto L90;
        r113 = x5.b("QMTAuMC4wLjIwMA==");     // Catch: Throwable -> L122
    L90:
        if (r118 == (-1)) goto L105;
    L103:
        r114 = r118;
    L105:
        if (r115 == null) goto L73;
        r115.close();     // Catch: Throwable -> L108
    L108:
        th = move-exception;
        t6.a(th, "pu", "gPx2");
        goto L73
    L85:
        if (r117.equals("null") == true) goto L87;
        r113 = r117;
        r105 = true;
        goto L88
    L93:
        if (r104.indexOf("wap") == (-1)) goto L103;
        if (TextUtils.isEmpty(r117) == false) goto L97;
    L99:
        boolean r106 = false;
    L100:
        if (r106 == true) goto L105;
        r113 = x5.b("QMTAuMC4wLjE3Mg==");     // Catch: Throwable -> L122
        goto L105
    L97:
        if (r117.equals("null") == true) goto L99;
        r113 = r117;
        r106 = true;
        goto L100
    L104:
        r114 = r116;
    L55:
        th = th;
    L64:
        r116 = -1;
    L65:
        r113 = null;
    L66:
        t6.a(th, "pu", "gPx1");     // Catch: Throwable -> L122
        th.printStackTrace();     // Catch: Throwable -> L122
        r114 = r116;
        if (r115 == null) goto L73;
    L12:
        if (r115.moveToFirst() == false) goto L59;
        String r107 = r115.getString(r115.getColumnIndex("apn"));     // Catch: Throwable -> L55 SecurityException -> L57
        String r108 = r107;
        r116 = r111;
        if (r107 == null) goto L140;
        Locale r119 = Locale.US;     // Catch: Throwable -> L55 SecurityException -> L57
        r108 = r107.toLowerCase(r119);     // Catch: Throwable -> L55 SecurityException -> L57
        r116 = r119;
    L140:
        if (r108 != null) goto L18;
    L40:
        if (r108 == null) goto L59;
        if (r108.contains("wap") == false) goto L59;
        String r109 = a();     // Catch: Throwable -> L55 SecurityException -> L57
        int r120 = b();     // Catch: Throwable -> L55 SecurityException -> L57
        if (TextUtils.isEmpty(r109) == false) goto L47;
    L49:
        r113 = null;
        boolean r121 = false;
    L50:
        if (r121 == false) goto L52;
    L53:
        if (r120 == (-1)) goto L60;
    L35:
        r114 = r120;
        goto L60
    L52:
        r113 = x5.b("QMTAuMC4wLjE3Mg==");     // Catch: Throwable -> L29 SecurityException -> L31
        goto L53
    L47:
        if (r109.equals("null") == true) goto L49;
        r113 = r109;
        r121 = true;
        goto L50
    L18:
        if (r108.contains("ctwap") == false) goto L40;
        String r122 = a();     // Catch: Throwable -> L55 SecurityException -> L57
        r120 = b();     // Catch: Throwable -> L55 SecurityException -> L57
        if (TextUtils.isEmpty(r122) == false) goto L23;
    L25:
        r113 = null;
        boolean r123 = false;
    L26:
        if (r123 == true) goto L33;
        r113 = x5.b("QMTAuMC4wLjIwMA==");     // Catch: Throwable -> L29 SecurityException -> L31
    L33:
        if (r120 != (-1)) goto L35;
    L23:
        if (r122.equals("null") == true) goto L25;
        r113 = r122;
        r123 = true;
    L38:
        e = e;
    L36:
        th = th;
    L31:
        e = e;
    L29:
        th = th;
        goto L66
    L122:
        th = move-exception;
        if (r112 == 0) goto L143;
        r112.close();     // Catch: Throwable -> L127
        throw th;
    L127:
        th = move-exception;
        t6.a(th, "pu", "gPx2");
        throw th;
    L143:
        throw th;
    L74:
        e = e;
        r115 = null;
    L62:
        th = th;
        r115 = null;
    L130:
        return null;
    L5:
        r100 = false;
        goto L7
    }

    public static String b(String r100) {
    L24:
        th = th;
        PolarisFileInputStreamWrapper r101 = null;
    L42:
        p6.a(th, "MD5", "gfm");     // Catch: Throwable -> L33
        if (r101 != null) goto L50;
    L32:
        return null;
    L50:
        r101.close();     // Catch: IOException -> L30
    L30:
        e = move-exception;
        p6.a(e, "MD5", "gfm");
    L33:
        th = move-exception;
        if (r101 != null) goto L46;
    L39:
        throw th;
    L46:
        r101.close();     // Catch: IOException -> L37
    L37:
        e = move-exception;
        p6.a(e, "MD5", "gfm");
        goto L39
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);     // Catch: Throwable -> L24
        if (r102.isFile() == true) goto L9;
    L23:
        return null;
    L9:
        if (r102.exists() == false) goto L23;
        byte[] r103 = new byte[2048];     // Catch: Throwable -> L24
        MessageDigest r104 = MessageDigest.getInstance(x5.b("ETUQ1"));     // Catch: Throwable -> L24
        r101 = new PolarisFileInputStreamWrapper(r102);     // Catch: Throwable -> L24
    L48:
        int r105 = r101.read(r103);     // Catch: Throwable -> L21
        if (r105 == (-1)) goto L15;
        r104.update(r103, 0, r105);     // Catch: Throwable -> L21
        goto L48
    L15:
        String r106 = x5.a(r104.digest());     // Catch: Throwable -> L21
        r101.close();     // Catch: IOException -> L18
    L20:
        return r106;
    L18:
        e = move-exception;
        p6.a(e, "MD5", "gfm");
    L21:
        th = th;
        goto L42
    }

    public static String c(String r100) {
        if (r100 != null) goto L11;
        return null;
    L11:
        MessageDigest r101 = MessageDigest.getInstance(x5.b("ETUQ1"));     // Catch: Throwable -> L7
        r101.update(x5.e(r100));     // Catch: Throwable -> L7
        byte[] r102 = r101.digest();     // Catch: Throwable -> L7
    L10:
        return x5.a(r102);
    L7:
        th = move-exception;
        p6.a(th, "MD5", "gmb");
        r102 = new byte[0];
        goto L10
    }

    public static String a(String r100) {
        if (r100 != null) goto L16;
        byte[] r101 = null;
    L14:
        return x5.b(r101);
    L11:
        th = move-exception;
        p6.a(th, "ut", "csb2h");
        return null;
    L16:
        MessageDigest r102 = MessageDigest.getInstance(x5.b("ETUQ1"));     // Catch: Throwable -> L7
        r102.update(x5.e(r100));     // Catch: Throwable -> L7
        r101 = r102.digest();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.printStackTrace();
        r101 = new byte[0];
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.net.Proxy$Type] */
    /* JADX WARN: Type inference failed for: r0v4 */
    public static java.net.Proxy b(Context r100) {
        String r101 = "pu";
        java.net.Proxy r102 = null;
        URI r103 = new URI("http://restsdk.amap.com");     // Catch: Throwable -> L22
        if (o5.h(r100) != 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L28;
    L25:
    L24:
        return r102;
    L28:
        List<java.net.Proxy> r105 = ProxySelector.getDefault().select(r103);     // Catch: Throwable -> L19
        if (r105 == null) goto L25;
        if (r105.isEmpty() == true) goto L25;
        java.net.Proxy r106 = r105.get(0);     // Catch: Throwable -> L19
        if (r106 == null) goto L25;
        java.net.Proxy.Type r107 = r106.type();     // Catch: Throwable -> L19
        r101 = java.net.Proxy.Type.DIRECT;     // Catch: Throwable -> L19
        if (r107 == r101) goto L25;
        r102 = r106;
        goto L25
    L19:
        th = move-exception;
        t6.a(th, "pu", "gpsc");     // Catch: Throwable -> L22
        goto L25
    L7:
        r104 = false;
    L22:
        th = move-exception;
        t6.a(th, r101, "gp");
        goto L24
    }

    public static String a(byte[] r100) {
        MessageDigest r101 = MessageDigest.getInstance(x5.b("ETUQ1"));     // Catch: Throwable -> L5
        r101.update(r100);     // Catch: Throwable -> L5
        byte[] r102 = r101.digest();     // Catch: Throwable -> L5
    L8:
        return x5.a(r102);
    L5:
        th = move-exception;
        p6.a(th, "MD5", "gmb");
        r102 = null;
        goto L8
    }

    private static Cursor com_amap_api_mapcore_util_t5_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        f06.b r116 = new f06.b();
        f06.d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
