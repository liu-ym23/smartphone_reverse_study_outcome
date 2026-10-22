package com.baidu.mshield.x6.f;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.x6.EngineImpl;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.tencent.connect.common.Constants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f32617a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f32618b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f32619c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f32620d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f32621e = "";

    public static class a extends com.baidu.mshield.x6.f.m.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f32622b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f32623c;

        @Override // com.baidu.mshield.x6.f.m.a
        public void a() {
            com.baidu.mshield.b.c.a.a("token respone order trigger token delay : " + this.f32622b);     // Catch: Throwable -> L5
            Thread.sleep((long) (this.f32622b * 1000));     // Catch: Throwable -> L5
            com.baidu.mshield.x6.e.h.a(this.f32623c).a(7);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            f.b(th);
        }

        public a(int r100, Context r101) {
            this.f32622b = r100;
            this.f32623c = r101;
        }
    }

    public l() {
    }

    public static String a(Context r110) {
        com.baidu.mshield.x6.d.a r100 = new com.baidu.mshield.x6.d.a(r110, null);     // Catch: Throwable -> L45
        JSONObject r111 = new JSONObject();     // Catch: Throwable -> L45
        r111.put("4", com.baidu.mshield.b.b.a.a(r110));     // Catch: Throwable -> L45
        JSONObject r112 = new JSONObject();     // Catch: Throwable -> L45
        com.baidu.mshield.x6.b.b r113 = new com.baidu.mshield.x6.b.b(r110);     // Catch: Throwable -> L45
        JSONObject r114 = new JSONObject();     // Catch: Throwable -> L45
        r114.put("1", r113.x());     // Catch: Throwable -> L45
        String r115 = r113.L();     // Catch: Throwable -> L45
        if (TextUtils.isEmpty(r115) == false) goto L8;
        String r116 = com.baidu.mshield.b.a.g.a(r110);     // Catch: Throwable -> L45
        com.baidu.mshield.b.c.a.a(" manufacturer: " + r116.toLowerCase());     // Catch: Throwable -> L45
        if (TextUtils.isEmpty(r116) == true) goto L8;
        r115 = com.baidu.mshield.b.f.e.a(r116.toLowerCase());     // Catch: Throwable -> L45
        r113.l(r115);     // Catch: Throwable -> L45
    L8:
        r114.put("2", r115);     // Catch: Throwable -> L45
        String r101 = r113.M();     // Catch: Throwable -> L45
        if (TextUtils.isEmpty(r101) == false) goto L13;
        String r102 = EngineImpl.getInstance(r110).getPropertyByType("mod");     // Catch: Throwable -> L45
        com.baidu.mshield.b.c.a.a(" model: " + r102.toLowerCase());     // Catch: Throwable -> L45
        if (TextUtils.isEmpty(r102) == true) goto L13;
        r101 = com.baidu.mshield.b.f.e.a(r102.toLowerCase());     // Catch: Throwable -> L45
        r113.m(r101);     // Catch: Throwable -> L45
    L13:
        r114.put("3", r101);     // Catch: Throwable -> L45
        String r103 = r113.s();     // Catch: Throwable -> L45
        if (TextUtils.isEmpty(r103) == false) goto L16;
        String r104 = Build.ID.toLowerCase();     // Catch: Throwable -> L45
        com.baidu.mshield.b.c.a.a(" buildId: " + r104);     // Catch: Throwable -> L45
        r103 = com.baidu.mshield.b.f.e.a(r104);     // Catch: Throwable -> L45
        r113.d(r103);     // Catch: Throwable -> L45
    L16:
        r114.put("4", r103);     // Catch: Throwable -> L45
        String r105 = r113.d();     // Catch: Throwable -> L45
        if (TextUtils.isEmpty(r105) == false) goto L21;
        String r106 = com.baidu.mshield.b.a.g.b(r110);     // Catch: Throwable -> L45
        com.baidu.mshield.b.c.a.a(" romName: " + r106.toLowerCase());     // Catch: Throwable -> L45
        if (TextUtils.isEmpty(r106) == true) goto L21;
        r105 = com.baidu.mshield.b.f.e.a(r106.toLowerCase());     // Catch: Throwable -> L45
        r113.t(r105);     // Catch: Throwable -> L45
    L21:
        r114.put("5", r105);     // Catch: Throwable -> L45
        String r107 = r113.e();     // Catch: Throwable -> L45
        if (TextUtils.isEmpty(r107) == false) goto L27;
        String r108 = com.baidu.mshield.b.a.g.c(r110);     // Catch: Throwable -> L45
        com.baidu.mshield.b.c.a.a(" romVersion: " + r108.toLowerCase());     // Catch: Throwable -> L45
        if (TextUtils.isEmpty(r108) == true) goto L27;
        r107 = com.baidu.mshield.b.f.e.a(r108.toLowerCase());     // Catch: Throwable -> L45
        r113.u(r107);     // Catch: Throwable -> L45
    L27:
        r114.put("6", r107);     // Catch: Throwable -> L45
        String r109 = r113.t();     // Catch: Throwable -> L45
        if (TextUtils.isEmpty(r109) == false) goto L32;
        String r117 = EngineImpl.getInstance(r110).getPropertyByType("arv");     // Catch: Throwable -> L45
        com.baidu.mshield.b.c.a.a(" romVersion: " + r117.toLowerCase());     // Catch: Throwable -> L45
        if (TextUtils.isEmpty(r117) == true) goto L32;
        r109 = com.baidu.mshield.b.f.e.a(r117.toLowerCase());     // Catch: Throwable -> L45
        r113.e(r109);     // Catch: Throwable -> L45
    L32:
        r114.put("7", r109);     // Catch: Throwable -> L45
        String r118 = f.d(r110);     // Catch: Throwable -> L45
        if (TextUtils.isEmpty(r118) == false) goto L46;
        r114.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, "");     // Catch: Throwable -> L45
    L41:
        r112.put("f", r114);     // Catch: Throwable -> L45
        r111.put("module_section", new JSONArray().put(r112));     // Catch: Throwable -> L45
        com.baidu.mshield.b.c.a.a("f/2/sig post body : " + r111.toString());     // Catch: Throwable -> L45
        return r100.c(r111.toString());
    L46:
        r114.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, new JSONObject(r118).optString("2", ""));     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L45
    L45:
        return "";
    }

    public static boolean b(Context r100) {
        com.baidu.mshield.x6.b.b r101 = new com.baidu.mshield.x6.b.b(r100);     // Catch: Throwable -> L12
        long r102 = System.currentTimeMillis();     // Catch: Throwable -> L12
        if ((r102 - r101.I()) <= 86400000) goto L6;
        r101.e(1);     // Catch: Throwable -> L12
        r101.b(r102);     // Catch: Throwable -> L12
        com.baidu.mshield.b.c.a.a("time limit , reset last time and count");     // Catch: Throwable -> L12
    L6:
        int r103 = r101.H();     // Catch: Throwable -> L12
        if (r103 >= r101.k()) goto L10;
        int r104 = r103 + 1;     // Catch: Throwable -> L12
        r101.e(r104);     // Catch: Throwable -> L12
        com.baidu.mshield.b.c.a.a("count not limit return true , count : " + r104);     // Catch: Throwable -> L12
        return true;
    L10:
        com.baidu.mshield.b.c.a.a("count limit return false ");     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        f.b(th);
        return false;
    }

    public static int a(Context r110, String r111) {
        monitor-enter(l.class);
        com.baidu.mshield.x6.b.b r100 = new com.baidu.mshield.x6.b.b(r110);     // Catch: Throwable -> L73
        if ((System.currentTimeMillis() - r100.D()) >= 300000) goto L10;
        monitor-exit(l.class);     // Catch: Throwable -> L77
        return -1;
    L10:
        String r101 = null;
        String r112 = new com.baidu.mshield.x6.d.a(r110, null).b(r111);     // Catch: Throwable -> L73
        r100.a(System.currentTimeMillis());     // Catch: Throwable -> L73
        com.baidu.mshield.b.c.a.c("ret: " + r112);     // Catch: Throwable -> L73
        if (TextUtils.isEmpty(r112) == false) goto L14;
        monitor-exit(l.class);     // Catch: Throwable -> L77
        return -1;
    L14:
        JSONObject r102 = new JSONObject(r112);     // Catch: Throwable -> L73
        String r113 = r102.optString("status");     // Catch: Throwable -> L17
    L84:
        String r103 = r102.optString("xid");     // Catch: Throwable -> L22
    L80:
        String r104 = r102.optString("bs");     // Catch: Throwable -> L27
    L29:
        if (r113 == null) goto L36;
        if (r113.equals("99999999") == false) goto L36;
        monitor-exit(l.class);     // Catch: Throwable -> L77
        return -99;
    L36:
        if (TextUtils.isEmpty(r103) == true) goto L49;
        if (com.baidu.mshield.x6.c.b.b() == false) goto L40;
        String r114 = new com.baidu.mshield.x6.b.b(r110).Q();     // Catch: Throwable -> L73
        String r105 = b.b(r110, "x_o_b_d");     // Catch: Throwable -> L73
        String r106 = b.a(r110, ".x_o_b_d");     // Catch: Throwable -> L73
    L42:
        if (r103.equals(r105) == true) goto L44;
    L47:
        b.d(r110, r103);     // Catch: Throwable -> L73
        goto L49
    L44:
        if (r103.equals(r106) == false) goto L47;
        if (r103.equals(r114) == true) goto L49;
    L40:
        r114 = new com.baidu.mshield.x6.b.b(r110).A();     // Catch: Throwable -> L73
        r105 = b.b(r110, "x_b_d");     // Catch: Throwable -> L73
        r106 = b.a(r110, ".x_b_d");     // Catch: Throwable -> L73
    L49:
        if (TextUtils.isEmpty(r104) == false) goto L51;
    L88:
        r101 = r102.optString("ver");     // Catch: Throwable -> L65
        if (TextUtils.isEmpty(r101) == true) goto L68;
        b.e(r110, r101);     // Catch: Throwable -> L65
    L68:
        if (TextUtils.isEmpty(r101) == true) goto L70;
        b.e(r110, r101);     // Catch: Throwable -> L73
    L70:
        monitor-exit(l.class);     // Catch: Throwable -> L77
        return 0;
    L65:
        th = move-exception;
        com.baidu.mshield.b.c.a.c("1" + th.toString());     // Catch: Throwable -> L73
        f.b(th);     // Catch: Throwable -> L73
        goto L68
    L51:
        if (com.baidu.mshield.x6.c.b.b() == false) goto L53;
        String r115 = new com.baidu.mshield.x6.b.b(r110).P();     // Catch: Throwable -> L73
        String r107 = b.b(r110, "g_m_o_bs");     // Catch: Throwable -> L73
        String r108 = b.a(r110, ".g_m_o_bs");     // Catch: Throwable -> L73
    L55:
        if (r104.equals(r107) == true) goto L57;
    L60:
        b.c(r110, r104);     // Catch: Throwable -> L73
        goto L88
    L57:
        if (r104.equals(r108) == false) goto L60;
        if (r104.equals(r115) == true) goto L88;
    L53:
        r115 = new com.baidu.mshield.x6.b.b(r110).u();     // Catch: Throwable -> L73
        r107 = b.b(r110, "g_m_b_s");     // Catch: Throwable -> L73
        r108 = b.a(r110, ".g_m_b_s");     // Catch: Throwable -> L73
        goto L55
    L27:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L73
        r104 = null;
        goto L29
    L22:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L73
        r103 = null;
        goto L80
    L17:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L73
        r113 = null;
    L73:
        th = move-exception;
        com.baidu.mshield.b.c.a.c("2" + th.toString());     // Catch: Throwable -> L77
        f.b(th);     // Catch: Throwable -> L77
        return -1;
    L77:
        th = move-exception;
        throw th;
    }

    public static void b(Context r110, String r111) {
    L104:
        th = move-exception;
        f.b(th);
        return;
    L4:
        if (TextUtils.isEmpty(r111) == false) goto L6;
        return;
    L6:
        com.baidu.mshield.x6.b.b r112 = new com.baidu.mshield.x6.b.b(r110);     // Catch: Throwable -> L104
        JSONObject r113 = new JSONObject(r111);     // Catch: Throwable -> L104
        com.baidu.mshield.b.c.a.a("sdata:" + r111);     // Catch: Throwable -> L104
        JSONObject r100 = r113.optJSONObject("1");     // Catch: Throwable -> L104
        if (r100 == null) goto L9;
        r112.a(com.baidu.mshield.x6.b.b.f32552a, r100.toString());     // Catch: Throwable -> L104
    L9:
        JSONObject r101 = r113.optJSONObject("2");     // Catch: Throwable -> L104
        if (r101 == null) goto L12;
        r112.a(com.baidu.mshield.x6.b.b.f32553b, r101.toString());     // Catch: Throwable -> L104
    L12:
        JSONObject r102 = r113.optJSONObject("3");     // Catch: Throwable -> L104
        if (r102 == null) goto L15;
        r112.a(com.baidu.mshield.x6.b.b.f32554c, r102.toString());     // Catch: Throwable -> L104
    L15:
        JSONObject r103 = r113.optJSONObject("4");     // Catch: Throwable -> L104
        if (r103 == null) goto L18;
        r112.a(com.baidu.mshield.x6.b.b.f32555d, r103.toString());     // Catch: Throwable -> L104
    L18:
        JSONObject r104 = r113.optJSONObject("5");     // Catch: Throwable -> L104
        if (r104 == null) goto L21;
        r112.a(com.baidu.mshield.x6.b.b.f32556e, r104.toString());     // Catch: Throwable -> L104
    L21:
        JSONObject r105 = r113.optJSONObject("6");     // Catch: Throwable -> L104
        if (r105 == null) goto L24;
        r112.a(com.baidu.mshield.x6.b.b.f32557f, r105.toString());     // Catch: Throwable -> L104
    L24:
        JSONObject r106 = r113.optJSONObject("7");     // Catch: Throwable -> L104
        if (r106 == null) goto L27;
        r112.a(com.baidu.mshield.x6.b.b.f32558g, r106.toString());     // Catch: Throwable -> L104
    L27:
        JSONObject r107 = r113.optJSONObject("8");     // Catch: Throwable -> L104
        if (r107 == null) goto L30;
        r112.a(com.baidu.mshield.x6.b.b.f32559h, r107.toString());     // Catch: Throwable -> L104
    L30:
        JSONObject r108 = r113.optJSONObject(Constants.VIA_SHARE_TYPE_MINI_PROGRAM);     // Catch: Throwable -> L104
        if (r108 == null) goto L33;
        r112.a(com.baidu.mshield.x6.b.b.f32560i, r108.toString());     // Catch: Throwable -> L104
    L33:
        JSONObject r109 = r113.optJSONObject(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);     // Catch: Throwable -> L104
        if (r109 == null) goto L36;
        r112.a(com.baidu.mshield.x6.b.b.f32561j, r109.toString());     // Catch: Throwable -> L104
    L36:
        JSONObject r114 = r113.optJSONObject("11");     // Catch: Throwable -> L104
        if (r114 == null) goto L39;
        r112.a(com.baidu.mshield.x6.b.b.f32562k, r114.toString());     // Catch: Throwable -> L104
    L39:
        JSONObject r115 = r113.optJSONObject("12");     // Catch: Throwable -> L104
        if (r115 == null) goto L42;
        r112.a(com.baidu.mshield.x6.b.b.f32563l, r115.toString());     // Catch: Throwable -> L104
    L42:
        JSONObject r116 = r113.optJSONObject("13");     // Catch: Throwable -> L104
        if (r116 == null) goto L45;
        r112.a(com.baidu.mshield.x6.b.b.f32564m, r116.toString());     // Catch: Throwable -> L104
    L45:
        JSONObject r117 = r113.optJSONObject(Constants.VIA_REPORT_TYPE_MAKE_FRIEND);     // Catch: Throwable -> L104
        if (r117 != null) goto L111;
    L56:
        JSONObject r118 = r113.optJSONObject(Constants.VIA_REPORT_TYPE_WPA_STATE);     // Catch: Throwable -> L104
        if (r118 != null) goto L109;
    L67:
        JSONObject r119 = r113.optJSONObject(Constants.VIA_ACT_TYPE_NINETEEN);     // Catch: Throwable -> L104
        if (r119 == null) goto L76;
        com.baidu.mshield.b.c.a.a("emulator retry policy:" + r119.toString());     // Catch: Throwable -> L104
        JSONObject r120 = r119.optJSONObject("2");     // Catch: Throwable -> L104
        if (("emulator 2 json:" + r120) != null) goto L72;
        String r121 = "null";
    L73:
        com.baidu.mshield.b.c.a.a(r121);     // Catch: Throwable -> L104
        if (r120 == null) goto L76;
        int r122 = r120.optInt("1", 0);     // Catch: Throwable -> L104
        com.baidu.mshield.b.c.a.a("emulator set totalCount:" + r122);     // Catch: Throwable -> L104
        r112.c(r122);     // Catch: Throwable -> L104
        goto L76
    L72:
        r121 = r120.toString();     // Catch: Throwable -> L104
    L76:
        JSONObject r123 = r113.optJSONObject("20");     // Catch: Throwable -> L104
        if (r123 == null) goto L79;
        r112.a(com.baidu.mshield.x6.b.b.f32566o, r123.toString());     // Catch: Throwable -> L104
    L79:
        JSONObject r124 = r113.optJSONObject("22");     // Catch: Throwable -> L104
        if (r124 == null) goto L84;
        JSONObject r125 = r124.optJSONObject("2");     // Catch: Throwable -> L104
        com.baidu.mshield.b.c.a.b("intervalJson=" + r125);     // Catch: Throwable -> L104
        if (r125 == null) goto L84;
        r112.f(r125.optInt("1", 180));     // Catch: Throwable -> L104
        r112.h(r125.optInt("2", 360));     // Catch: Throwable -> L104
        r112.g(r125.optInt("3", 360));     // Catch: Throwable -> L104
        r112.b(r125.optInt("6", 10));     // Catch: Throwable -> L104
        r112.j(r125.optInt("7", 10));     // Catch: Throwable -> L104
    L84:
        JSONObject r126 = r113.optJSONObject(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);     // Catch: Throwable -> L104
        if (r126 == null) goto L87;
        r112.a(com.baidu.mshield.x6.b.b.f32567p, r126.toString());     // Catch: Throwable -> L104
    L87:
        JSONObject r127 = r113.optJSONObject("24");     // Catch: Throwable -> L104
        if (r127 == null) goto L90;
        r112.a(com.baidu.mshield.x6.b.b.f32568q, r127.toString());     // Catch: Throwable -> L104
    L90:
        JSONObject r128 = r113.optJSONObject(Constants.VIA_REPORT_TYPE_CHAT_AUDIO);     // Catch: Throwable -> L104
        if (r128 == null) goto L93;
        r112.a(com.baidu.mshield.x6.b.b.f32569r, r128.toString());     // Catch: Throwable -> L104
    L93:
        JSONObject r129 = r113.optJSONObject("26");     // Catch: Throwable -> L104
        if (r129 == null) goto L96;
        r112.a(com.baidu.mshield.x6.b.b.f32570s, r129.toString());     // Catch: Throwable -> L104
    L96:
        JSONObject r130 = r113.optJSONObject("27");     // Catch: Throwable -> L104
        if (r130 == null) goto L99;
        r112.a(com.baidu.mshield.x6.b.b.f32571t, r130.toString());     // Catch: Throwable -> L104
    L99:
        JSONObject r131 = r113.optJSONObject("28");     // Catch: Throwable -> L104
        if (r131 == null) goto L102;
        r112.a(com.baidu.mshield.x6.b.b.f32572u, r131.toString());     // Catch: Throwable -> L104
    L102:
        r112.r(f.c());     // Catch: Throwable -> L104
        com.baidu.mshield.b.c.a.a("pull static Policy for load success");     // Catch: Throwable -> L104
        return;
    L109:
        JSONObject r132 = r118.getJSONObject("2");     // Catch: Throwable -> L65
        if (r132 == null) goto L67;
        int r133 = r132.getInt("1");     // Catch: Throwable -> L65
        if (r133 == r112.o()) goto L67;
        if (r133 <= 0) goto L67;
        r112.l(r133);     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L104
        goto L67
    L111:
        JSONObject r134 = r117.optJSONObject("2");     // Catch: Throwable -> L53
        if (r134 != null) goto L50;
    L55:
        r112.a(com.baidu.mshield.x6.b.b.f32565n, r117.toString());     // Catch: Throwable -> L104
        goto L56
    L50:
        if (r134.has("1") == false) goto L55;
        String r135 = r134.optString("1");     // Catch: Throwable -> L53
        com.baidu.mshield.b.c.a.a("14 prv 1 origin : " + r135);     // Catch: Throwable -> L53
        r134.put("1", Base64.encodeToString(com.baidu.mshield.b.a.c.a(r135.getBytes()), 0));     // Catch: Throwable -> L53
        r117.put("2", r134);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L104
        goto L55
    }

    public static int a(Context r100, String r110, int r111) {
        com.baidu.mshield.x6.b.b r101 = new com.baidu.mshield.x6.b.b(r100);     // Catch: Throwable -> L71
        if (com.baidu.mshield.b.a.d.b(r100) == true) goto L7;
        r101.d(-1);     // Catch: Throwable -> L71
        return -100;
    L7:
        String r112 = new com.baidu.mshield.x6.d.a(r100, null).a(r110);     // Catch: Throwable -> L71
        if (TextUtils.isEmpty(r112) == true) goto L10;
        r101.x(r112);     // Catch: Throwable -> L71
        JSONObject r102 = new JSONObject(r112);     // Catch: Throwable -> L71
        com.baidu.mshield.x6.b.c r113 = new com.baidu.mshield.x6.b.c(r100);     // Catch: Throwable -> L71
        String r103 = r102.optString("token");     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r103) == true) goto L20;
        if (r111 != 1) goto L19;
        r113.b(r103);     // Catch: Throwable -> L22
        r113.c(String.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L22
        goto L20
    L19:
        r113.a(r103);     // Catch: Throwable -> L22
        r113.d(String.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L22
        r113.b("");     // Catch: Throwable -> L22
        r113.c("");     // Catch: Throwable -> L22
        r101.d(System.currentTimeMillis());     // Catch: Throwable -> L22
    L20:
        r101.g(true);     // Catch: Throwable -> L22
    L87:
        String r114 = r102.optString("nc");     // Catch: Throwable -> L26
    L29:
        if (r101.z() == false) goto L91;
        r101.a(false);     // Catch: Throwable -> L71
    L91:
        JSONObject r115 = r102.optJSONObject("rmf");     // Catch: Throwable -> L40
        if (r115 != null) goto L34;
        f32621e = "";     // Catch: Throwable -> L40
    L44:
        if (TextUtils.equals(r114, "1") == false) goto L46;
    L51:
        boolean r116 = b(r100);     // Catch: Throwable -> L71
    L52:
        if (r116 == true) goto L83;
        return 0;
    L83:
    L60:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L71
    L80:
        int r117 = r102.optInt("op");     // Catch: Throwable -> L68
        r101.w(r102.optJSONArray("da").toString());     // Catch: Throwable -> L68
        r101.i(r117);     // Catch: Throwable -> L68
        if (r102.has("nt") == true) goto L65;
    L67:
        return 0;
    L65:
        if (r102.optInt("nt") <= 0) goto L67;
        r101.g(false);     // Catch: Throwable -> L68
        int r118 = r102.optInt("nt");     // Catch: Throwable -> L68
        com.baidu.mshield.x6.f.m.c.b().a(new a(r118, r100));     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L71
    L79:
        return -100;
    L55:
        if (TextUtils.isEmpty(r114) == true) goto L80;
        if (TextUtils.equals(r114, "1") == false) goto L80;
        com.baidu.mshield.x6.e.h.a(r100).a(2, true);     // Catch: Throwable -> L60
    L46:
        if (r102.has("nt") == true) goto L48;
    L50:
        r116 = false;
        goto L52
    L48:
        if (r102.optInt("nt") <= 0) goto L50;
    L34:
        if (f.a(r100, false) == false) goto L36;
        r101.v(r115.toString());     // Catch: Throwable -> L40
        f32621e = "";     // Catch: Throwable -> L40
    L37:
        com.baidu.mshield.b.c.a.a("getZidChecktor ungzRmf : ".concat(new String(com.baidu.mshield.b.a.c.b(Base64.decode(r115.optString("1").getBytes(), 0)), XML.CHARSET_UTF8)));     // Catch: Throwable -> L40
        goto L44
    L36:
        f32621e = r115.toString();     // Catch: Throwable -> L40
        r101.p();     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L71
    L26:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L71
        r114 = "";
        goto L29
    L22:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L71
        goto L87
    L10:
        if (r101.F() != 0) goto L12;
        r101.d(-2);     // Catch: Throwable -> L71
    L12:
        return -100;
    L71:
        th = move-exception;
        f.b(th);
        com.baidu.mshield.x6.b.b r119 = new com.baidu.mshield.x6.b.b(r100);     // Catch: Throwable -> L77
        if (r119.F() != 0) goto L79;
        r119.d(-4);     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        f.b(th);
        goto L79
    }
}
