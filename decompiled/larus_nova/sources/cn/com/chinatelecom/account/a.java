package cn.com.chinatelecom.account;

import android.content.Context;
import android.net.Network;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.CtAuth;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.texturerender.VideoSurfaceTexture;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24329a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static HashMap<String, String> f24330b;

    static {
        f24330b = new HashMap();
    }

    public static long a(Context r100) {
        return h.a(r100, "key_difference_time", 0);
    }

    public static k a(Context r100, HttpURLConnection r101, boolean r102) {
        if (r102 == true) goto L6;
        return null;
    L6:
        k r103 = new k();
        Map<String, List<String>> r104 = r101.getHeaderFields();     // Catch: Throwable -> L72
        List<String> r105 = r104.get("p");     // Catch: Throwable -> L72
        if (r105 != null) goto L10;
    L12:
        List<String> r106 = r104.get("Set-Cookie");     // Catch: Throwable -> L72
        if (r106 != null) goto L15;
    L25:
        List<String> r107 = r104.get("Log-Level");     // Catch: Throwable -> L72
        if (r107 != null) goto L28;
    L36:
        List<String> r108 = r104.get("p-reset");     // Catch: Throwable -> L72
        if (r108 != null) goto L39;
    L43:
        List<String> r109 = r104.get("p-ikgx");     // Catch: Throwable -> L72
        if (r109 != null) goto L46;
    L50:
        List<String> r110 = r104.get("dm");     // Catch: Throwable -> L72
        if (r110 != null) goto L53;
    L74:
        return r103;
    L53:
        if (r110.isEmpty() == true) goto L74;
        String r111 = r110.get(0);     // Catch: Throwable -> L72
        if (r111 == null) goto L74;
        if (r111.equals("1") == false) goto L60;
    L61:
        String r112 = r.g(r100);     // Catch: Throwable -> L72
        if (TextUtils.isEmpty(r112) == true) goto L66;
        if (r112.equals(r111) == true) goto L66;
    L69:
        r103.f24411e = true;     // Catch: Throwable -> L72
    L70:
        r.a(r100, r111);     // Catch: Throwable -> L72
    L66:
        if (TextUtils.isEmpty(r112) == false) goto L70;
        if (r111.equals("2") == false) goto L70;
    L60:
        if (r111.equals("2") == false) goto L74;
    L46:
        if (r109.isEmpty() == true) goto L50;
        String r113 = r109.get(0);     // Catch: Throwable -> L72
        if (TextUtils.isEmpty(r113) == true) goto L50;
        r103.f24409c = r113;     // Catch: Throwable -> L72
        r.f24448g = r113;     // Catch: Throwable -> L72
        goto L50
    L39:
        if (r108.isEmpty() == true) goto L43;
        String r114 = r108.get(0);     // Catch: Throwable -> L72
        if (TextUtils.isEmpty(r114) == true) goto L43;
        a(r100, r114);     // Catch: Throwable -> L72
        goto L43
    L28:
        if (r107.isEmpty() == true) goto L36;
        int r115 = 0;
    L31:
        if (r115 >= r107.size()) goto L36;
        String r116 = r107.get(0);     // Catch: Throwable -> L72
        if (TextUtils.isEmpty(r116) == true) goto L35;
        q.a(r100, r116);     // Catch: Throwable -> L72
    L35:
        r115 = r115 + 1;     // Catch: Throwable -> L72
        goto L31
    L15:
        if (r106.size() <= 0) goto L25;
        int r117 = 0;
    L18:
        if (r117 >= r106.size()) goto L25;
        String r118 = r106.get(0);     // Catch: Throwable -> L72
        if (TextUtils.isEmpty(r118) == true) goto L24;
        if (r118.contains("gw_auth") == false) goto L24;
        r103.f24407a = a(r118, "gw_auth");     // Catch: Throwable -> L72
    L24:
        r117 = r117 + 1;     // Catch: Throwable -> L72
        goto L18
    L10:
        if (r105.size() <= 0) goto L12;
        String r119 = r105.get(0);     // Catch: Throwable -> L72
        CtAuth.info(f24329a, "request protocol : " + r119);     // Catch: Throwable -> L72
        r103.f24408b = false;     // Catch: Throwable -> L72
    L72:
        th = move-exception;
        th.printStackTrace();
        goto L74
    }

    public static k a(HttpURLConnection r100) {
        k r101 = new k();
        Map<String, List<String>> r102 = r100.getHeaderFields();     // Catch: Throwable -> L16
        List<String> r103 = r102.get("rdt_allow");     // Catch: Throwable -> L16
        if (r103 != null) goto L6;
    L8:
        List<String> r104 = r102.get("p-ikgx");     // Catch: Throwable -> L16
        if (r104 != null) goto L11;
    L18:
        return r101;
    L11:
        if (r104.isEmpty() == true) goto L18;
        String r105 = r104.get(0);     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r105) == true) goto L18;
        r101.f24409c = r105;     // Catch: Throwable -> L16
        goto L18
    L6:
        if (r103.size() <= 0) goto L8;
        r101.f24410d = r103.get(0);     // Catch: Throwable -> L16
        CtAuth.info(f24329a, "request method : " + r101.f24410d);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();
        goto L18
    }

    public static synchronized String a(int r100) {
        monitor-enter(a.class);
        if (r100 != g.f24397a) goto L10;
        monitor-exit(a.class);
        return "presdk";
    L10:
        monitor-exit(a.class);
        return "preauthIfaa";
    L12:
        th = move-exception;
        throw th;
    }

    private static String a(String r100, String r101) {
        String[] r102 = r100.split(com.alipay.sdk.m.u.i.f25853b);     // Catch: Exception -> L10
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L12;
        if (r102[r103].contains(r101) == true) goto L7;
        r103 = r103 + 1;
        goto L4
    L7:
        return r102[r103].split(ContainerUtils.KEY_VALUE_DELIMITER)[1];
    L12:
        return "";
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public static JSONObject a(Context r100, x r110, String r111, Network r112, boolean r113, String r114) {
        if (r110 == null) goto L57;
        JSONObject r101 = r110.f24476b;
        if (r101 == null) goto L57;
    L53:
        e = move-exception;
        e.printStackTrace();
    L55:
        return r101;
    L8:
        if (r110.f24475a != (-1)) goto L10;
    L52:
        return r101;
    L10:
        if (TextUtils.isEmpty(r111) == true) goto L52;
        int r102 = r101.optInt("result");     // Catch: Exception -> L53
        String r103 = r101.optString("data");     // Catch: Exception -> L53
        if (TextUtils.isEmpty(r103) == true) goto L30;
        String r104 = t.a(r103, r111);     // Catch: Throwable -> L27
        if (r104.isEmpty() == false) goto L19;
        r101.put("result", 80107);     // Catch: Throwable -> L27
        r101.put("msg", h0.a(y.f24497r));     // Catch: Throwable -> L27
        goto L30
    L19:
        JSONObject r105 = new JSONObject(r104);     // Catch: Throwable -> L27
        if (r102 != 0) goto L23;
        r105.put("gwAuth", r110.f24477c);     // Catch: Throwable -> L27
    L23:
        if (r102 != (-10020)) goto L25;
        r101.put(DBDefinition.TASK_ID, r111);     // Catch: Throwable -> L27
    L25:
        r101.put("data", r105);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CtAuth.warn(f24329a, "dct", th);     // Catch: Exception -> L53
        r101.put("result", 80107);     // Catch: Exception -> L53
        r101.put("msg", h0.a(y.f24497r));     // Catch: Exception -> L53
        r101.put("data", null);     // Catch: Exception -> L53
    L30:
        if (r102 != 30002) goto L44;
        if (r113 == false) goto L44;
        JSONObject r115 = (JSONObject) r101.opt("data");     // Catch: Exception -> L53
        ArrayList r116 = new ArrayList();     // Catch: Exception -> L53
        JSONArray r117 = r115.optJSONArray("urls");     // Catch: Exception -> L53
        if (r117 == null) goto L39;
        int r106 = 0;
    L36:
        if (r106 >= r117.length()) goto L39;
        r116.add(JSONArrayProtectorUtils.getString(r117, r106));     // Catch: Exception -> L53
        r106 = r106 + 1;     // Catch: Exception -> L53
    L39:
        if (r116.isEmpty() == false) goto L42;
        return null;
    L42:
        return a(r100, r116, r111, r112, r114);
    L44:
        if (r102 != (-10009)) goto L46;
    L47:
        long r118 = r101.optLong(VideoSurfaceTexture.KEY_TIME, -1);     // Catch: Exception -> L53
        if (r118 != (-1)) goto L50;
        b(r100);     // Catch: Exception -> L53
        goto L55
    L50:
        a(r100, r118);     // Catch: Exception -> L53
        goto L55
    L46:
        if (r102 != (-30001)) goto L55;
    L57:
        return y.e();
    }

    private static JSONObject a(Context r110, List<String> r111, String r112, Network r113, String r114) {
        int r100 = 0;
    L4:
        if (r100 >= r111.size()) goto L31;
        String r101 = r111.get(r100);     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r101) == true) goto L29;
        r.l(r110);     // Catch: Throwable -> L26
        w.a r102 = new w.a();     // Catch: Throwable -> L26
        r102.b(r114);     // Catch: Throwable -> L24
        r102.a(r113);     // Catch: Throwable -> L22
        JSONObject r103 = a(r110, new f(r110).a(r101, "", 0, r102.a(), false), r112, r113, false, r114);     // Catch: Throwable -> L20
        if (r103 == null) goto L29;
        if (r103.optInt("result") != 0) goto L29;
        return r103;
    L20:
        th = th;
    L28:
        th.printStackTrace();
    L22:
        th = th;
    L24:
        th = th;
    L29:
        r100 = r100 + 1;
    L26:
        th = th;
        goto L28
    L31:
        return y.a(80001, h0.a(y.f24481b) + "- redirect 30002 ");
    }

    private static void a(Context r100, long r101) {
        if (r101 <= 0) goto L6;
        h.b(r100, "key_difference_time", r101 - System.currentTimeMillis());
        return;
    }

    private static void a(Context r100, String r101) {
        h.b(r100, "key_p_rset_v4.6.0", r101);
    }

    private static void b(Context r100) {
        String r101 = i.b();
        w.a r102 = new w.a();
        r102.a("reqTimestamp");
        r102.b(r101);
        w r103 = r102.a();
        JSONObject r104 = new f(r100).a(r.a(), "", 1, r103, false).f24476b;
        if (r104 == null) goto L6;
        a(r100, r104.optLong("msg", -1));
        return;
    }
}
