package com.baidu.mshield.utility;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.ac.F;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import kotlin.UByte;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class d {
    public static void a(Context r100) {
        com.baidu.mshield.sharedpreferences.a r101 = com.baidu.mshield.sharedpreferences.a.a(r100);     // Catch: Throwable -> L15
        if ((System.currentTimeMillis() - r101.y()) <= 86400000) goto L11;
        HashMap r102 = new HashMap();     // Catch: Throwable -> L15
        if (com.baidu.mshield.b.a.d.c(r100) == false) goto L8;
        r102.put("0", Integer.valueOf(r101.A() + 1));     // Catch: Throwable -> L15
        r102.put("1", Integer.valueOf(r101.z()));     // Catch: Throwable -> L15
    L9:
        r101.d(0);     // Catch: Throwable -> L15
        r101.e(0);     // Catch: Throwable -> L15
        r101.j();     // Catch: Throwable -> L15
        a.a(r100, "1067112", r102);     // Catch: Throwable -> L15
        return;
    L8:
        r102.put("0", Integer.valueOf(r101.A()));     // Catch: Throwable -> L15
        r102.put("1", Integer.valueOf(r101.z() + 1));     // Catch: Throwable -> L15
        goto L9
    L11:
        if (com.baidu.mshield.b.a.d.c(r100) == false) goto L13;
        r101.c(r101.A() + 1);     // Catch: Throwable -> L15
        return;
    L13:
        r101.b(r101.z() + 1);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        a.a(th);
    }

    public static byte[] a(byte[] r100) {
        byte[] r101 = new byte[256];
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= 256) goto L5;
        r101[r103] = (byte) r103;
        r103 = r103 + 1;
        goto L3
    L5:
        if (r100 != null) goto L7;
        return null;
    L7:
        if (r100.length == 0) goto L17;
        int r104 = 0;
        int r105 = 0;
    L10:
        if (r102 >= 256) goto L12;
        int r106 = r100[r104] & UByte.MAX_VALUE;
        byte r107 = r101[r102];
        r105 = ((r106 + (r107 & UByte.MAX_VALUE)) + r105) & 255;
        r101[r102] = r101[r105];
        r101[r105] = r107;
        r104 = (r104 + 1) % r100.length;
        r102 = r102 + 1;
        goto L10
    L12:
        return r101;
    L17:
        return null;
    }

    public static byte[] a(byte[] r100, byte[] r101) {
        if (r100 == null) goto L7;
        if (r101 != null) goto L6;
        return null;
    L6:
        return c(r100, r101);
    L7:
        return null;
    }

    public static byte[] b(byte[] r100, byte[] r101) {
        if (r100 == null) goto L7;
        if (r101 != null) goto L6;
        return null;
    L6:
        return c(r100, r101);
    L7:
        return null;
    }

    public static byte[] c(byte[] r100, byte[] r101) {
        byte[] r102 = a(r101);
        byte[] r103 = new byte[r100.length];
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L4:
        if (r104 >= r100.length) goto L6;
        r105 = (r105 + 1) & 255;
        byte r107 = r102[r105];
        r106 = ((r107 & UByte.MAX_VALUE) + r106) & 255;
        r102[r105] = r102[r106];
        r102[r106] = r107;
        int r108 = ((r102[r105] & UByte.MAX_VALUE) + (r107 & UByte.MAX_VALUE)) & 255;
        byte r109 = r100[r104];
        byte r110 = (byte) (r102[r108] ^ r109);
        r103[r104] = r110;
        r103[r104] = (byte) (r110 ^ 42);
        r104 = r104 + 1;
        goto L4
    L6:
        return r103;
    }

    public static String a(Context r100, String r101, boolean r102, boolean r110) throws Throwable {
        return a(r100, r101, "", r102, r110, true, null);
    }

    public static String a(Context r100, String r101, String r102, boolean r110, boolean r111) throws Throwable {
        return a(r100, r101, r102, r110, r111, false, "");
    }

    public static String a(Context r100, String r101, String r102, boolean r110, boolean r111, String r112) throws Throwable {
        return a(r100, r101, r102, r110, r111, false, r112);
    }

    public static String a(Context r100, String r101, String r110, boolean r111, boolean r112, boolean r113, String r114) throws Throwable {
        String r102 = "";
        if (com.baidu.mshield.b.e.a.d(r100) == true) goto L5;
        return "";
    L5:
        String[] r115 = a.i(r100);
        String r103 = r115[0];
        String r116 = r115[1];
        String r104 = String.valueOf(new Date().getTime() / 1000);
        String r117 = com.baidu.mshield.b.f.e.a(r103 + r104 + r116);
        byte[] r105 = com.baidu.mshield.core.b.a();
        com.baidu.mshield.b.c.a.b("after get aesKey:".concat(new String(r105)));
        com.baidu.mshield.b.c.a.b("after get aesKey:base64:" + Base64.encode(r105, 0));
        if (TextUtils.isEmpty(r110) == true) goto L8;
        byte[] r118 = com.baidu.mshield.b.a.c.a(r110.getBytes());
        com.baidu.mshield.b.c.a.b("afterGzipPostBody,length=" + r118.length);
        byte[] r119 = F.getInstance().ae(r118, r105);
    L9:
        com.baidu.mshield.b.c.a.b("afterEncryptPostBody length=" + r119.length + "," + new String(r119));
        byte[] r106 = com.baidu.mshield.b.f.e.a(c.b(r100)).getBytes();
        com.baidu.mshield.b.c.a.b("afterLoadRc4Key:".concat(new String(r106)));
        byte[] r107 = F.getInstance().re(r105, r106);
        com.baidu.mshield.b.c.a.b("after ar:sKey length=" + r107.length);
        String r108 = Base64.encodeToString(r107, 0);
        com.baidu.mshield.b.c.a.b("after Base64:sKey=" + r108);
        StringBuilder r109 = new StringBuilder();
        r109.append(r101);
        r109.append("/250/");
        r109.append(r103);
        r109.append(HTTP.URL_DEFAULT);
        r109.append(r104);
        r109.append(HTTP.URL_DEFAULT);
        r109.append(r117);
        if (TextUtils.isEmpty(r108) == true) goto L12;
        r109.append("?skey=");
        r109.append(URLEncoder.encode(r108, XML.CHARSET_UTF8));
    L12:
        com.baidu.mshield.b.c.a.b(r109.toString());
        if (r113 == false) goto L16;
        String r120 = new com.baidu.mshield.b.d.b(r100, null).a(r109.toString());     // Catch: Throwable -> L18
    L15:
        r102 = r120;
    L20:
        com.baidu.mshield.b.c.a.b("r:" + r102);
        if (r111 == true) goto L23;
    L27:
        if (r112 == true) goto L29;
        return r102;
    L29:
        JSONObject r121 = new JSONObject(r102);
        String r122 = r121.optString("skey");
        com.baidu.mshield.b.c.a.b("base sKey from server:" + r122);
        byte[] r123 = Base64.decode(r122, 0);
        com.baidu.mshield.b.c.a.b("after Base64 decode:server aeskey size=" + r123.length);
        byte[] r124 = F.getInstance().rd(r123, r106);
        com.baidu.mshield.b.c.a.b("after dr aes key:size=".concat(new String(r124)));
        String r125 = r121.optString("response");
        com.baidu.mshield.b.c.a.b("plugins:requestId:" + r121.optString("request_id"));
        com.baidu.mshield.b.c.a.b("plugins:response Base64:" + r125);
        byte[] r126 = Base64.decode(r125, 0);
        com.baidu.mshield.b.c.a.b("after Base64 decode:server aeskey size=" + r126.length);
        byte[] r127 = F.getInstance().ad(r126, r124);
        if (r126.length <= 0) goto L37;
        if (r127 != null) goto L33;
    L35:
        a.g(r100);
        throw new NetworkErrorException("aes is fail");
    L33:
        if (r127.length == 0) goto L35;
    L37:
        String r128 = new String(r127);
        com.baidu.mshield.b.c.a.b("sdk res:".concat(r128));
        return r128;
    L23:
        if (TextUtils.isEmpty(r102) == false) goto L27;
        a(r100);
        throw new NetworkErrorException("response is empty");
    L16:
        r120 = new com.baidu.mshield.b.d.b(r100, null).a(r109.toString(), r119);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        a.a(th);
        goto L20
    L8:
        r119 = "".getBytes();
        goto L9
    }
}
