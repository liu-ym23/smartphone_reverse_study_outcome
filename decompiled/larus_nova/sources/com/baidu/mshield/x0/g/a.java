package com.baidu.mshield.x0.g;

import android.content.Context;
import android.os.Debug;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.x0.d.d;
import com.baidu.mshield.x0.h.b;
import com.baidu.mshield.x6.EngineImpl;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f32514a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f32515b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f32516c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f32517d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f32518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Map<Integer, Boolean> f32519f;

    static {
        f32519f = new HashMap(100);
    }

    public a() {
    }

    public static String a(List<String> r100) {
        if (r100 == null) goto L18;
    L11:
        th = move-exception;
        d.a(th);
        return "";
    L4:
        if (r100.size() <= 0) goto L19;
        StringBuffer r101 = new StringBuffer();     // Catch: Throwable -> L11
        Iterator<String> r102 = r100.iterator();     // Catch: Throwable -> L11
    L7:
        if (r102.hasNext() == false) goto L9;
        r101.append(r102.next());     // Catch: Throwable -> L11
        r101.append(i.f25853b);     // Catch: Throwable -> L11
        goto L7
    L9:
        return r101.substring(0, r101.length() - 1);
    L19:
        return "";
    L18:
        return "";
    }

    public static void a(Context r100, JSONObject r101) {
        e(r100, r101);
        b(r100, r101);
        c(r100, r101);
        i(r100, r101);
        d(r100, r101);
        f(r100, r101);
        g(r100, r101);
        h(r100, r101);
        j(r100, r101);
    }

    public static boolean b(Context r110, JSONObject r111) {
        boolean r100 = d.a(r110, "plc16", true);     // Catch: Throwable -> L21
        com.baidu.mshield.b.c.a.b("getSafetyFactor status key : KEY_POLICY_APP_DEBUG  status : " + r100);     // Catch: Throwable -> L21
        if (r100 == false) goto L27;
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L21
        String r102 = (String) com.baidu.xclient.gdid.a.a(18, d.h(r110), null, null);     // Catch: Throwable -> L21
        com.baidu.mshield.b.c.a.b("jni debug result=" + r102 + ", time cost=" + (System.currentTimeMillis() - r101));     // Catch: Throwable -> L21
        StringBuilder r103 = new StringBuilder("Debug.isDebuggerConnected()=");     // Catch: Throwable -> L21
        r103.append(Debug.isDebuggerConnected());     // Catch: Throwable -> L21
        com.baidu.mshield.b.c.a.b(r103.toString());     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r102) == true) goto L10;
        r102.startsWith("1");     // Catch: Throwable -> L21
    L10:
        if (TextUtils.isEmpty(r102) == false) goto L12;
        String r104 = " ";
    L13:
        com.baidu.mshield.x0.l.a r105 = new com.baidu.mshield.x0.l.a(r110);     // Catch: Throwable -> L21
        String r112 = r105.b("n_l_c_n_k_i_d");     // Catch: Throwable -> L21
        r105.a("n_l_c_n_k_i_d", r104);     // Catch: Throwable -> L21
        com.baidu.mshield.b.c.a.b("report debug : 2 compare: " + r112 + " : " + r104 + ":-" + r102);     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r102) == false) goto L16;
        r102 = "";
    L16:
        r111.put("2", r102);     // Catch: Throwable -> L21
        if (r104 == null) goto L28;
        if (r104.equalsIgnoreCase(r112) == true) goto L29;
        return true;
    L29:
        return false;
    L28:
        return false;
    L12:
        r104 = e.a(r102);     // Catch: Throwable -> L21
        goto L13
    L27:
        return false;
    L21:
        th = move-exception;
        d.a(th);
        return false;
    }

    public static boolean c(Context r100, JSONObject r101) {
        boolean r102 = d.a(r100, "plc20", true);     // Catch: Throwable -> L11
        com.baidu.mshield.b.c.a.b("getSafetyFactor status key : KEY_POLICY_USB_DEBUG  status : " + r102);     // Catch: Throwable -> L11
        if (r102 == false) goto L9;
        f32515b = d.o(r100) ? 1 : 0;     // Catch: Throwable -> L11
        com.baidu.mshield.x0.l.a r103 = new com.baidu.mshield.x0.l.a(r100);     // Catch: Throwable -> L11
        String r104 = r103.b("n_l_c_n_k_d_m");     // Catch: Throwable -> L11
        String r105 = String.valueOf(f32515b);     // Catch: Throwable -> L11
        r103.a("n_l_c_n_k_d_m", r105);     // Catch: Throwable -> L11
        com.baidu.mshield.b.c.a.b("report debug : 7 compare: " + r104 + " : " + r105);     // Catch: Throwable -> L11
        r101.put("7", r105);     // Catch: Throwable -> L11
        StringBuilder r106 = new StringBuilder("getSafetyFactor isDebugMode finish Time:");     // Catch: Throwable -> L11
        r106.append(f32515b);     // Catch: Throwable -> L11
        com.baidu.mshield.b.c.a.b(r106.toString());     // Catch: Throwable -> L11
        if (r105.equalsIgnoreCase(r104) == true) goto L15;
        return true;
    L15:
        return false;
    L9:
        f32515b = -1;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        d.a(th);
        return false;
    }

    public static void d(Context r100, JSONObject r101) {
    L7:
        th = move-exception;
        d.a(th);
        return;
    L4:
        if (d.a(r100, "plc36", true) == false) goto L12;
        r101.put(BDLocationException.ERROR_SDK_NO_PERMISSION, String.valueOf(b.e(r100)));     // Catch: Throwable -> L7
        return;
    }

    public static void e(Context r110, JSONObject r111) {
        int r100 = 1;
        if (d.a(r110, "plc03", true) == false) goto L21;
        com.baidu.mshield.b.c.a.b("injectStatus is true");     // Catch: Throwable -> L23
        com.baidu.mshield.x0.l.a r101 = new com.baidu.mshield.x0.l.a(r110);     // Catch: Throwable -> L23
        long r102 = System.currentTimeMillis();     // Catch: Throwable -> L23
        String r112 = (String) com.baidu.xclient.gdid.a.a(19, r110.getPackageName(), d.h(r110), Integer.valueOf(r101.g()));     // Catch: Throwable -> L23
        com.baidu.mshield.b.c.a.b("jni inject result=" + r112 + " , time cost=" + (System.currentTimeMillis() - r102));     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r112) == true) goto L17;
        if (r112.startsWith("1") == false) goto L12;
    L15:
        f32514a = r100;     // Catch: Throwable -> L23
        com.baidu.mshield.b.c.a.b("injectRet is not empty, isjnject: " + f32514a);     // Catch: Throwable -> L23
        goto L17
    L12:
        if (r112.startsWith("-1") == false) goto L14;
        r100 = -1;
        goto L15
    L14:
        r100 = 0;
    L17:
        if (TextUtils.isEmpty(r112) == false) goto L19;
        Object r103 = "";
    L20:
        r111.put("1", r103);     // Catch: Throwable -> L23
        com.baidu.mshield.b.c.a.b("getSafetyFactor isInject finish Time: " + r112);     // Catch: Throwable -> L23
        return;
    L19:
        r103 = r112;
        goto L20
    L21:
        f32514a = -1;     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        com.baidu.mshield.b.c.a.b("load jni lib fail: " + th);
        d.a(th);
    }

    public static void f(Context r100, JSONObject r101) {
    L12:
        th = move-exception;
        d.a(th);
        return;
    L3:
        if (d.a(r100, "plc84", true) == true) goto L15;
        return;
    L15:
        String r102 = b.b(r100);     // Catch: Throwable -> L7
    L10:
        r101.put("71", r102);     // Catch: Throwable -> L12
        return;
    L7:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L12
        r102 = "";
        goto L10
    }

    public static void g(Context r100, JSONObject r101) {
    L7:
        th = move-exception;
        d.a(th);
        return;
    L3:
        if (d.a(r100, "plc71", false) == true) goto L5;
        return;
    L5:
        r101.put("59", a(b.d(r100)));     // Catch: Throwable -> L7
    }

    public static boolean h(Context r100, JSONObject r101) {
        boolean r102 = d.a(r100, "plc18", true);     // Catch: Throwable -> L18
        com.baidu.mshield.b.c.a.b("getSafetyFactor status key : KEY_POLICY_PROXY  status : " + r102);     // Catch: Throwable -> L18
        if (r102 == false) goto L15;
        f32516c = d.a();     // Catch: Throwable -> L18
        com.baidu.mshield.x0.l.a r103 = new com.baidu.mshield.x0.l.a(r100);     // Catch: Throwable -> L18
        String r104 = r103.b("n_l_c_n_k_p_p");     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(f32516c) == false) goto L9;
        String r105 = " ";
    L10:
        r103.a("n_l_c_n_k_p_p", r105);     // Catch: Throwable -> L18
        com.baidu.mshield.b.c.a.b("report debug : 10 compare: " + r104 + " : " + r105);     // Catch: Throwable -> L18
        r101.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, f32516c);     // Catch: Throwable -> L18
        if (r105 != null) goto L13;
    L16:
        com.baidu.mshield.b.c.a.b("getSafetyFactor proxyIp finish Time:" + f32516c);     // Catch: Throwable -> L18
        return false;
    L13:
        if (r105.equalsIgnoreCase(r104) == true) goto L16;
        return true;
    L9:
        r105 = e.a(f32516c);     // Catch: Throwable -> L18
        goto L10
    L15:
        f32516c = "";     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        d.a(th);
        return false;
    }

    public static boolean i(Context r110, JSONObject r111) {
        boolean r100 = d.a(r110, "plc15", true);     // Catch: Throwable -> L16
        com.baidu.mshield.b.c.a.b("getSafetyFactor status key : KEY_POLICY_SAFE_SCAN_COMMON status : " + r100);     // Catch: Throwable -> L16
        if (r100 == false) goto L18;
        JSONObject r101 = d.g(r110);     // Catch: Throwable -> L16
        com.baidu.mshield.x0.l.a r102 = new com.baidu.mshield.x0.l.a(r110);     // Catch: Throwable -> L16
        String r112 = r102.b("n_l_c_n_k_i_r");     // Catch: Throwable -> L16
        StringBuilder r103 = new StringBuilder();     // Catch: Throwable -> L16
        int r104 = 0;
    L8:
        String[] r105 = d.f32486b;     // Catch: Throwable -> L16
        if (r104 >= r105.length) goto L11;
        r103.append(r101.opt(Integer.toString(r104)));     // Catch: Throwable -> L16
        r104 = r104 + 1;     // Catch: Throwable -> L16
        goto L8
    L11:
        r103.append(r101.opt(Integer.toString(r105.length)));     // Catch: Throwable -> L16
        r103.toString().contains("1");     // Catch: Throwable -> L16
        String r106 = e.a(r103.toString());     // Catch: Throwable -> L16
        r102.a("n_l_c_n_k_i_r", r106);     // Catch: Throwable -> L16
        com.baidu.mshield.b.c.a.b("report debug : 12 compare: " + r112 + " : " + r106);     // Catch: Throwable -> L16
        r111.put("12", r101);     // Catch: Throwable -> L16
        if (r106 == null) goto L18;
        if (r106.equalsIgnoreCase(r112) == true) goto L18;
        return true;
    L18:
        return false;
    L16:
        th = move-exception;
        d.a(th);
        goto L18
    }

    public static void j(Context r100, JSONObject r101) {
        boolean r102 = d.a(r100, "plc83", true);     // Catch: Throwable -> L10
        com.baidu.mshield.b.c.a.b("new roo=" + r102);     // Catch: Throwable -> L10
        if (r102 == true) goto L6;
        return;
    L6:
        r101.put("69", "");     // Catch: Throwable -> L10
        long r103 = System.currentTimeMillis();     // Catch: Throwable -> L10
        String r104 = (String) com.baidu.xclient.gdid.a.a(20, null, null, null);     // Catch: Throwable -> L10
        com.baidu.mshield.b.c.a.b("jni root result=" + r104 + " , time cost=" + (System.currentTimeMillis() - r103));     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r104) == true) goto L16;
        r101.put("69", r104);     // Catch: Throwable -> L10
        return;
    L16:
        return;
    L10:
        th = move-exception;
        d.a(th);
    }

    public static String a(Context r100, String r101, int r110, String r111) {
        monitor-enter(a.class);
        com.baidu.mshield.b.c.a.b("accountId: " + r101 + " eventId: " + r110);     // Catch: Throwable -> L39
        com.baidu.mshield.x0.l.a r102 = new com.baidu.mshield.x0.l.a(r100);     // Catch: Throwable -> L39
        ArrayList r112 = new ArrayList();     // Catch: Throwable -> L39
        String r103 = d.a(r100, r102, "plc104", "7");     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r103) == true) goto L16;
        JSONArray r104 = new JSONArray(r103);     // Catch: Throwable -> L13
        int r105 = 0;
    L10:
        if (r105 >= r104.length()) goto L16;
        r112.add(r104.getString(r105));     // Catch: Throwable -> L13
        r105 = r105 + 1;
        goto L10
    L16:
        if (f32517d != (-1)) goto L19;
        f32517d = r102.f();     // Catch: Throwable -> L39
    L19:
        if (f32518e != 0) goto L22;
        f32518e = r102.i();     // Catch: Throwable -> L39
    L22:
        if (r112.contains(String.valueOf(r110)) == false) goto L37;
        if (f32519f.get(Integer.valueOf(r110)) != null) goto L30;
        if (f32519f.size() > 100) goto L30;
        f32519f.put(Integer.valueOf(r110), Boolean.TRUE);     // Catch: Throwable -> L39
    L34:
        new com.baidu.mshield.x0.h.a().a(r100, 2, 0, 0);     // Catch: Throwable -> L39
        EngineImpl.getInstance(r100).bdsd(4, false);     // Catch: Throwable -> L39
        r102.b(System.currentTimeMillis());     // Catch: Throwable -> L39
        f32518e = System.currentTimeMillis();     // Catch: Throwable -> L39
    L42:
        monitor-exit(a.class);     // Catch: Throwable -> L44
        return "";
    L30:
        if ((System.currentTimeMillis() - f32518e) >= (f32517d * 1000)) goto L34;
        monitor-exit(a.class);     // Catch: Throwable -> L44
        return "";
    L37:
        monitor-exit(a.class);     // Catch: Throwable -> L44
        return "";
    L13:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;
    }
}
