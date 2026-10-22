package com.baidu.mshield.utility;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.baidu.mshield.MyProvider;
import com.baidu.mshield.ac.F;
import com.baidu.mshield.rp.Report;
import com.baidu.mshield.x0.EngineImpl;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.locationmessage.ui.navigation.MapRouteService;
import com.tencent.connect.common.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.UByte;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f32445a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f32446b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f32447c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f32448d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f32449e = -1;

    public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    public static String a() {
        Calendar r100 = Calendar.getInstance();
        return r100.get(1) + "" + r100.get(2) + "" + r100.get(5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.lang.StringBuilder] */
    public static String a(int r100) {
        ?? r101 = 0;
        r101 = 0;
    L32:
        th = th;
    L33:
        a(th);
        ?? r102 = r101;
    L34:
        return r102;
    L4:
        if (Build.VERSION.SDK_INT < 28) goto L12;
        String r103 = Application.getProcessName();     // Catch: Throwable -> L32
    L10:
        th = th;
        r101 = r103;
        goto L33
    L7:
        if (TextUtils.isEmpty(r103) == true) goto L35;
        com.baidu.mshield.b.c.a.b("getProcessName return by P+:" + r103);     // Catch: Throwable -> L10
        return r103.trim();
    L35:
    L24:
        th = move-exception;
        a(th);     // Catch: Throwable -> L32
    L28:
        r101 = a(String.format("/proc/%d/cmdline", new Object[]{Integer.valueOf(r100)}));     // Catch: Throwable -> L32
        boolean r104 = TextUtils.isEmpty(r101);     // Catch: Throwable -> L32
        r102 = r101;
        if (r104 == true) goto L34;
        com.baidu.mshield.b.c.a.b("getProcessName return by cmdline:" + r101);     // Catch: Throwable -> L32
        return r101.trim();
    L16:
        Method r105 = INVOKESTATIC_com_baidu_mshield_utility_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L24
        r105.setAccessible(true);     // Catch: Throwable -> L24
        Object r106 = r105.invoke(null, new Object[0]);     // Catch: Throwable -> L24
        r101 = r106 instanceof String;     // Catch: Throwable -> L24
        if (r101 == 0) goto L20;
        r103 = (String) r106;     // Catch: Throwable -> L24
    L20:
        if (TextUtils.isEmpty(r103) == true) goto L28;
        com.baidu.mshield.b.c.a.b("getProcessName return by reflect:" + r103);     // Catch: Throwable -> L24
        return r103.trim();
    L12:
        r103 = null;
        goto L35
    }

    public static JSONObject b(Context r100) {
        JSONObject r101 = new JSONObject();
        String r102 = com.baidu.xclient.gdid.a.a(r100);     // Catch: Throwable -> L58
        String r103 = "";
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        r101.put("0", r102);     // Catch: Throwable -> L58
        String r104 = com.baidu.xclient.gdid.a.b(r100);     // Catch: Throwable -> L58
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        r101.put("1", r104);     // Catch: Throwable -> L58
        String r105 = com.baidu.xclient.gdid.a.e(r100);     // Catch: Throwable -> L58
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        r101.put("2", r105);     // Catch: Throwable -> L58
        String r106 = Build.HOST;     // Catch: Throwable -> L58
        if (r106 != null) goto L19;
        r106 = "";
    L19:
        r101.put("3", r106);     // Catch: Throwable -> L58
        String r107 = c.a();     // Catch: Throwable -> L58
        if (r107 != null) goto L23;
        r107 = "";
    L23:
        r101.put("4", r107);     // Catch: Throwable -> L58
        String r108 = com.baidu.xclient.gdid.a.h(r100);     // Catch: Throwable -> L58
        if (r108 != null) goto L27;
        r108 = "";
    L27:
        r101.put("5", r108);     // Catch: Throwable -> L58
        String r109 = Build.VERSION.CODENAME;     // Catch: Throwable -> L58
        if (r109 != null) goto L31;
        r109 = "";
    L31:
        r101.put("6", r109);     // Catch: Throwable -> L58
        String r110 = Build.VERSION.INCREMENTAL;     // Catch: Throwable -> L58
        if (r110 != null) goto L35;
        r110 = "";
    L35:
        r101.put("7", r110);     // Catch: Throwable -> L58
        r101.put("8", c.b(r100));     // Catch: Throwable -> L58
        String r111 = com.baidu.xclient.gdid.a.g(r100);     // Catch: Throwable -> L58
        if (r111 != null) goto L41;
        r111 = "";
    L41:
        r101.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, r111);     // Catch: Throwable -> L58
        String r112 = com.baidu.mshield.core.a.a("mod");     // Catch: Throwable -> L58
        if (r112 != null) goto L45;
        r112 = "";
    L45:
        r101.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, r112);     // Catch: Throwable -> L58
        r101.put("11", c.g(r100));     // Catch: Throwable -> L58
        String r113 = com.baidu.mshield.core.a.a("arv");     // Catch: Throwable -> L58
        if (r113 == null) goto L52;
        r103 = r113;
    L52:
        r101.put("12", r103);     // Catch: Throwable -> L58
        r101.put("13", c.h(r100));     // Catch: Throwable -> L58
        r101.put("20", com.baidu.mshield.core.a.a("arl"));     // Catch: Throwable -> L58
    L60:
        return r101;
    L58:
        th = move-exception;
        a(th);
        goto L60
    }

    public static String[] c(Context r100) {
        if (TextUtils.isEmpty(f32445a) == false) goto L5;
    L8:
        String r101 = com.baidu.mshield.sharedpreferences.a.a(r100).K();
        if (TextUtils.isEmpty(r101) == true) goto L20;
        String[] r102 = r101.split("-");
        if (r102 == null) goto L18;
        if (r102.length != 2) goto L18;
        f32445a = r102[0];
        f32446b = r102[1];
        return r102;
    L18:
        return new String[2];
    L20:
        return new String[0];
    L5:
        if (TextUtils.isEmpty(f32446b) == true) goto L8;
        return new String[]{f32445a, f32446b};
    }

    public static int d(Context r100) {
        NetworkInfo r101 = com.baidu.mshield.b.e.b.a(r100);     // Catch: Throwable -> L4
    L6:
        if (r101 != null) goto L10;
        return 0;
    L10:
        if (1 != r101.getType()) goto L13;
        return 2;
    L13:
        r101.getType();
        return 1;
    L4:
        th = move-exception;
        a(th);
        r101 = null;
        goto L6
    }

    public static String e(Context r100) {
    L19:
        th = move-exception;
        a(th);
    L21:
        f32449e = 1;
        return f32448d;
    L4:
        if (TextUtils.isEmpty(f32448d) == false) goto L18;
        if (f32449e == 1) goto L18;
        ProviderInfo r101 = r100.getPackageManager().resolveContentProvider(r100.getPackageName() + ".mshield.ac.provider", 0);     // Catch: Throwable -> L15
        if (r101 == null) goto L21;
        if (r101.multiprocess == true) goto L21;
        f32448d = r101.processName;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        a(th);     // Catch: Throwable -> L19
    L18:
        return f32448d;
    }

    public static String f(Context r100) {
        StringBuilder r101 = new StringBuilder("host=");     // Catch: Throwable -> L5
        String r102 = f.f32457a;     // Catch: Throwable -> L5
        r101.append(r102);     // Catch: Throwable -> L5
        com.baidu.mshield.b.c.a.b(r101.toString());     // Catch: Throwable -> L5
        byte[] r103 = Base64.decode(r102, 0);     // Catch: Throwable -> L5
        return new String(F.getInstance().ad(r103, com.baidu.mshield.b.f.a.a(16)));
    L5:
        return "";
    }

    public static void g(Context r100) {
        com.baidu.mshield.sharedpreferences.a r101 = com.baidu.mshield.sharedpreferences.a.a(r100);
        if ((System.currentTimeMillis() - r101.b()) <= 86400000) goto L5;
        HashMap r102 = new HashMap();
        r102.put("0", Integer.valueOf(r101.l() + 1));
        r101.a(0);
        r101.k();
        a(r100, "1067119", r102);
        return;
    L5:
        r101.a(r101.l() + 1);
    }

    public static int h(Context r100) {
    L17:
        th = move-exception;
        a(th);
        return -1;
    L3:
        if (MyProvider.a() == false) goto L6;
        return 1;
    L6:
        if (TextUtils.isEmpty(e(r100)) == false) goto L8;
        return 1;
    L8:
        int r101 = a(r100);     // Catch: Throwable -> L17
        if (r101 != 1) goto L12;
        return 1;
    L12:
        if (r101 != 2) goto L15;
        return 0;
    L15:
        return MyProvider.a() ? 1 : 0;
    }

    public static String[] i(Context r100) {
        String r101 = f32445a;
        String r102 = f32446b;
        if (TextUtils.isEmpty(r101) == true) goto L9;
        if (TextUtils.isEmpty(r102) == true) goto L9;
        com.baidu.mshield.b.c.a.b("get key key select by in memory!");
        return new String[]{r101, r102};
    L9:
        if (TextUtils.isEmpty(r101) == false) goto L11;
    L12:
        String r103 = com.baidu.mshield.sharedpreferences.a.a(r100).K();
        if (TextUtils.isEmpty(r103) == true) goto L19;
        String[] r104 = r103.split("-");
        if (r104.length != 2) goto L19;
        com.baidu.mshield.b.c.a.b("get key key select by  from Info");
        return r104;
    L19:
        if (TextUtils.isEmpty(r101) == false) goto L21;
    L22:
        String r105 = com.baidu.mshield.sharedpreferences.a.a(r100).a();
        if (TextUtils.isEmpty(r105) == true) goto L29;
        String[] r106 = r105.split("-");
        if (r106.length != 2) goto L29;
        com.baidu.mshield.b.c.a.b("get key key select by  in mark");
        return r106;
    L29:
        if (TextUtils.isEmpty(r101) == false) goto L31;
    L32:
        com.baidu.mshield.b.c.a.b("get key key select by by default");
        r101 = "985050001";
        r102 = "83162820e470e3b72501f0683504560e";
    L34:
        return new String[]{r101, r102};
    L31:
        if (TextUtils.isEmpty(r102) == false) goto L34;
    L21:
        if (TextUtils.isEmpty(r102) == false) goto L29;
    L11:
        if (TextUtils.isEmpty(r102) == false) goto L19;
        goto L12
    }

    public static int a(Context r100) {
        String r101 = e(r100);     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(f32447c) == false) goto L7;
        f32447c = a(Process.myPid());     // Catch: Throwable -> L23
    L7:
        if (TextUtils.isEmpty(f32447c) == false) goto L10;
        return 0;
    L10:
        if (TextUtils.isEmpty(r101) == true) goto L18;
        if (r101.equals(f32447c) == false) goto L15;
        return 1;
    L15:
        return 2;
    L18:
        if (r100.getPackageName().equals(f32447c) == false) goto L21;
        return 3;
    L21:
        return 4;
    L23:
        th = move-exception;
        a(th);
        return 0;
    }

    public static String a(byte[] r100) {
        String r101 = "";
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L9;
        String r103 = Integer.toHexString(r100[r102] & UByte.MAX_VALUE);
        if (r103.length() != 1) goto L8;
        r103 = "0".concat(r103);
    L8:
        r101 = r101 + r103.toUpperCase();
        r102 = r102 + 1;
        goto L4
    L9:
        return r101;
    }

    public static String a(String r100) {
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L12
        String r102 = a(r101);     // Catch: Throwable -> L10
        r101.close();     // Catch: Throwable -> L7
    L9:
        return r102;
    L7:
        th = move-exception;
        a(th);
    L10:
        th = th;
    L32:
        a(th);     // Catch: Throwable -> L21
        if (r101 != null) goto L28;
    L20:
        return null;
    L28:
        r101.close();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        a(th);
    L21:
        th = move-exception;
        if (r101 != null) goto L36;
    L27:
        throw th;
    L36:
        r101.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        a(th);
    L12:
        th = th;
        r101 = null;
        goto L32
    }

    public static String a(InputStream r100) throws IOException {
        BufferedReader r101 = new BufferedReader(new InputStreamReader(r100, "UTF-8"));
        StringBuilder r102 = new StringBuilder();
        boolean r103 = true;
    L3:
        String r104 = r101.readLine();
        if (r104 == null) goto L10;
        if (r103 == true) goto L7;
        r102.append('\n');
    L8:
        r102.append(r104);
        goto L3
    L7:
        r103 = false;
        goto L8
    L10:
        return r102.toString();
    }

    public static void a(Throwable r100) {
        com.baidu.mshield.b.c.a.a(r100);
    }

    public static JSONObject a(Context r110, JSONObject r111) {
        JSONObject r100 = new JSONObject();
        long r101 = System.currentTimeMillis();
        JSONObject r102 = r111.getJSONObject("Common_section");     // Catch: Throwable -> L5
    L8:
        if (r102 == null) goto L10;
        String r103 = r102.optString(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        long r112 = r102.optLong("0");
        String r104 = r102.optString("1");
        String r113 = r102.optString("3");
        String r114 = r102.optString("8");
        String r115 = r114;
        String r116 = r113;
        String r117 = r104;
        String r105 = r103;
        String r106 = r102.optString(Constants.VIA_SHARE_TYPE_MINI_PROGRAM);
    L72:
        String r107 = r110.getApplicationInfo().loadLabel(r110.getPackageManager()).toString();     // Catch: Throwable -> L20
        String r118 = r107;
        String r119 = "";
        String r108 = com.baidu.mshield.b.e.c.a(r110, r110.getPackageName(), 0).versionName;     // Catch: Throwable -> L16
        String r120 = r118;
    L23:
        r100.put("1", r120);     // Catch: Throwable -> L59
        r100.put("2", com.baidu.mshield.core.a.a("p"));     // Catch: Throwable -> L59
        r100.put("3", r108);     // Catch: Throwable -> L59
        r100.put("4", c.b(r110));     // Catch: Throwable -> L59
        r100.put("5", r105);     // Catch: Throwable -> L59
        r100.put("6", r112);     // Catch: Throwable -> L59
        r100.put("7", r117);     // Catch: Throwable -> L59
        r100.put("8", r116);     // Catch: Throwable -> L59
        r100.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, r115);     // Catch: Throwable -> L59
        r100.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, r106);     // Catch: Throwable -> L59
        com.baidu.mshield.sharedpreferences.a r109 = com.baidu.mshield.sharedpreferences.a.a(r110);     // Catch: Throwable -> L59
        r100.put("11", r109.o());     // Catch: Throwable -> L59
        r100.put("12", r109.t());     // Catch: Throwable -> L59
        r100.put("13", 0);     // Catch: Throwable -> L59
        r100.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, com.baidu.mshield.core.a.a("ws"));     // Catch: Throwable -> L59
        r100.put("20", c.j(r110));     // Catch: Throwable -> L59
        r100.put("21", c.d(r110));     // Catch: Throwable -> L59
        r100.put("22", c.h(r110));     // Catch: Throwable -> L59
        String r121 = r109.r();     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r121) == true) goto L67;
    L45:
        r100.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, r121);     // Catch: Throwable -> L59
        r100.put(Constants.VIA_REPORT_TYPE_CHAT_AUDIO, com.baidu.mshield.rp.a.b(r110));     // Catch: Throwable -> L59
        r100.put("26", com.baidu.mshield.rp.a.a(r110));     // Catch: Throwable -> L59
        r100.put("27", com.baidu.mshield.rp.a.c(r110));     // Catch: Throwable -> L59
        r100.put("28", EngineImpl.getInstance(r110).getNui());     // Catch: Throwable -> L59
        r100.put(BDLocationException.ERROR_SDK_NO_PERMISSION, r119);     // Catch: Throwable -> L59
        Object r122 = r111.get("Module_section");     // Catch: Throwable -> L59
        if ((r122 instanceof JSONArray) == false) goto L57;
        r100.put("module_section", r122);     // Catch: Throwable -> L59
    L69:
    L61:
        return r100;
    L59:
        th = move-exception;
        a(th);
        goto L61
    L57:
        r100.put("module_section", new JSONArray().put(r122));     // Catch: Throwable -> L59
        goto L69
    L67:
        r121 = com.baidu.xclient.gdid.a.c(r110);     // Catch: Throwable -> L62
        if (TextUtils.isEmpty(r121) == false) goto L44;
        r121 = r119;
    L44:
        r109.j(r121);     // Catch: Throwable -> L62
    L16:
        th = th;
    L70:
        a(th);     // Catch: Throwable -> L59
        r120 = r118;
        r108 = r119;
    L18:
        th = th;
        r118 = r107;
        r119 = "";
    L20:
        th = th;
        r119 = "";
        r118 = r119;
        goto L70
    L10:
        r112 = r101;
        r106 = "";
        r105 = r106;
        r117 = r105;
        r116 = r117;
        r115 = r116;
    L5:
        th = move-exception;
        a(th);
        r102 = null;
        goto L8
    }

    public static void b(Context r110, String r111) {
        JSONObject r100 = new JSONObject(r111).optJSONObject("Common_section");     // Catch: Throwable -> L7
        long r101 = r100.optLong("0");     // Catch: Throwable -> L7
        String r102 = r100.optString(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);     // Catch: Throwable -> L7
        int r103 = r100.optInt("5");     // Catch: Throwable -> L7
        int r104 = r100.optInt("6");     // Catch: Throwable -> L7
        int r105 = r100.optInt("7");     // Catch: Throwable -> L7
        int r106 = r100.optInt("11");     // Catch: Throwable -> L7
        String r107 = r100.optString("12", "");     // Catch: Throwable -> L7
        if (r104 != 0) goto L5;
        r104 = 1;
    L5:
        com.baidu.mshield.rp.d.a r108 = new com.baidu.mshield.rp.d.a();     // Catch: Throwable -> L7
        r108.f32404d = r111;     // Catch: Throwable -> L7
        r108.f32402b = r102;     // Catch: Throwable -> L7
        r108.f32407g = r103;     // Catch: Throwable -> L7
        r108.f32403c = 3;     // Catch: Throwable -> L7
        r108.f32405e = r101;     // Catch: Throwable -> L7
        r108.f32406f = r104;     // Catch: Throwable -> L7
        r108.f32408h = r105;     // Catch: Throwable -> L7
        r108.f32409i = r106;     // Catch: Throwable -> L7
        r108.f32410j = r107;     // Catch: Throwable -> L7
        b.a(r110).a(r108);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        a(th);
    }

    public static void a(Context r100, String r101) {
        String r102 = "";
        com.baidu.mshield.sharedpreferences.a r103 = com.baidu.mshield.sharedpreferences.a.a(r100);
        JSONObject r104 = new JSONObject(r101);     // Catch: Throwable -> L36
        JSONObject r105 = r104.optJSONObject("0");     // Catch: Throwable -> L15
        if (r105 == null) goto L41;
        String r106 = "";
    L8:
        if (r105.keys().hasNext() == false) goto L12;
        r106 = String.valueOf(r105.keys().next());     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r106) == true) goto L8;
    L12:
        if (TextUtils.isEmpty(r106) == true) goto L41;
        r103.a(r106, r105.optString(r106));     // Catch: Throwable -> L15
    L41:
        JSONObject r107 = r104.optJSONObject("1");     // Catch: Throwable -> L27
        if (r107 != null) goto L20;
    L39:
        JSONArray r108 = r104.optJSONArray("2");     // Catch: Throwable -> L33
        if (r108 == null) goto L53;
        com.baidu.mshield.b.c.a.b("setAliveData rp= " + r108.toString());     // Catch: Throwable -> L33
        r103.f(r108.toString());     // Catch: Throwable -> L33
        return;
    L53:
        return;
    L33:
        th = move-exception;
        a(th);
        return;
    L20:
        if (r107.keys().hasNext() == false) goto L24;
        r102 = String.valueOf(r107.keys().next());     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r102) == true) goto L20;
    L24:
        if (TextUtils.isEmpty(r102) == true) goto L39;
        r103.b(r102, r107.optString(r102));     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        a(th);
    L15:
        th = move-exception;
        a(th);
    L36:
        th = move-exception;
        a(th);
    }

    public static void a(Context r100, long r101) {
        AlarmManager r102 = (AlarmManager) r100.getSystemService("alarm");     // Catch: Throwable -> L19
        if (Build.VERSION.SDK_INT < 23) goto L6;
        int r103 = 201326592;
    L7:
        new Intent("com.b.r.p").setPackage(r100.getPackageName());     // Catch: Throwable -> L19
        PendingIntent r104 = PendingIntent.getBroadcast(r100, 101, new Intent("com.b.r.p"), r103);     // Catch: Throwable -> L19
        r102.cancel(r104);     // Catch: Throwable -> L10
    L25:
        r102.set(0, System.currentTimeMillis() + r101, r104);     // Catch: Throwable -> L16
    L27:
        return;
    L16:
        th = move-exception;
        a(th);     // Catch: Throwable -> L19
        return;
    L10:
        th = move-exception;
        a(th);     // Catch: Throwable -> L19
        goto L25
    L6:
        r103 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
    L19:
        th = move-exception;
        a(th);
    }

    public static void a(Context r100, byte[] r101) {
        String[] r102 = i(r100);     // Catch: Throwable -> L19
        if (r102.length != 2) goto L18;
        int r103 = 0;
        if (TextUtils.isEmpty(r102[0]) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r102[1]) == false) goto L10;
        return;
    L10:
        if ("200080".equals(r102[0]) == true) goto L12;
        return;
    L12:
        if (r100.getPackageName().equals(MapRouteService.MapPackageName.PACKAGE_NAME_BAIDUMAP) == false) goto L26;
        if (r101 != null) goto L15;
        return;
    L15:
        if (r103 >= r101.length) goto L29;
        r101[r103] = (byte) (r101[r103] ^ 246);     // Catch: Throwable -> L19
        r103 = r103 + 1;
        goto L15
    L29:
        return;
    L26:
        return;
    L18:
        return;
    }

    public static void a(String r100, String r101) {
        f32445a = r100;
        f32446b = r101;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_baidu_mshield_utility_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static void a(Context r100, String r101, Map<String, Object> r110) {
        if (TextUtils.isEmpty(r101) == false) goto L30;
        return;
    L30:
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L27
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L27
        r103.put("0", System.currentTimeMillis());     // Catch: Throwable -> L27
        r103.put("1", "");     // Catch: Throwable -> L27
        r103.put("2", "");     // Catch: Throwable -> L27
        String[] r104 = i(r100);     // Catch: Throwable -> L27
        if (r104 != null) goto L10;
    L17:
        String r105 = "985050001";
    L18:
        r103.put("3", r105);     // Catch: Throwable -> L27
        r103.put("4", 0);     // Catch: Throwable -> L27
        r103.put("5", 0);     // Catch: Throwable -> L27
        r103.put("6", 1);     // Catch: Throwable -> L27
        r103.put("7", 0);     // Catch: Throwable -> L27
        r103.put("8", "mshield");     // Catch: Throwable -> L27
        r103.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, "4.2.9");     // Catch: Throwable -> L27
        r103.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, r101);     // Catch: Throwable -> L27
        r102.put("Common_section", r103);     // Catch: Throwable -> L27
        if (r110 != null) goto L22;
    L24:
        r102.put("Module_section", new JSONObject());     // Catch: Throwable -> L27
    L25:
        Report r106 = Report.getInstance(r100);     // Catch: Throwable -> L27
        String r107 = r102.toString();     // Catch: Throwable -> L27
        com.baidu.mshield.b.c.a.b("sendEventUDC:" + r107);     // Catch: Throwable -> L27
        r106.s(r107);     // Catch: Throwable -> L27
        return;
    L22:
        if (r110.size() <= 0) goto L24;
        r102.put("Module_section", new JSONObject(r110));     // Catch: Throwable -> L27
        goto L25
    L10:
        if (r104.length != 2) goto L17;
        if (TextUtils.isEmpty(r104[0]) == true) goto L17;
        if (TextUtils.isEmpty(r104[1]) == true) goto L17;
        r105 = r104[0];     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        a(th);
    }

    public static JSONObject a(Context r100, com.baidu.mshield.rp.b.a r101, String r102, boolean r103) {
        String r104 = r101.f32392a;
        String r105 = r101.f32394c;
        if (r103 == false) goto L5;
        String r106 = r101.f32395d;
    L7:
        return a(r100, r104, r105, r106, r102);
    L5:
        r106 = r101.f32396e;
        goto L7
    }

    public static JSONObject a(Context r100, String r101, String r102, String r103, String r110) {
        JSONObject r104 = new JSONObject();
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L16
        r105.put("0", System.currentTimeMillis());     // Catch: Throwable -> L16
        r105.put("1", "0");     // Catch: Throwable -> L16
        r105.put("2", "0");     // Catch: Throwable -> L16
        String[] r106 = i(r100);     // Catch: Throwable -> L16
        if (r106.length != 2) goto L7;
        r105.put("3", r106[0]);     // Catch: Throwable -> L16
    L8:
        r105.put("4", 0);     // Catch: Throwable -> L16
        r105.put("5", 0);     // Catch: Throwable -> L16
        r105.put("6", 1);     // Catch: Throwable -> L16
        r105.put("7", 0);     // Catch: Throwable -> L16
        r105.put("8", r101);     // Catch: Throwable -> L16
        r105.put(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, r102);     // Catch: Throwable -> L16
        r105.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, r103);     // Catch: Throwable -> L16
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r110) == false) goto L21;
    L14:
        r104.put("Common_section", r105);     // Catch: Throwable -> L16
        r104.put("Module_section", r107);     // Catch: Throwable -> L16
    L18:
        return r104;
    L21:
        r107 = new JSONObject(r110);     // Catch: Throwable -> L12
        goto L14
    L12:
        th = move-exception;
        a(th);     // Catch: Throwable -> L16
        goto L14
    L7:
        r105.put("3", "985050001");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        a(th);
        goto L18
    }

    public static void a(Context r100, String r101, String r102, String r103, String r104, String r105) {
        b.a(r100).a(false);
        b.a(r100).e();
        com.baidu.mshield.rp.b.a r106 = new com.baidu.mshield.rp.b.a();
        r106.f32392a = r101;
        r106.f32393b = r102;
        r106.f32394c = r103;
        r106.f32395d = r104;
        r106.f32396e = r105;
        if (TextUtils.isEmpty(r104) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r105) == true) goto L21;
        com.baidu.mshield.sharedpreferences.a r107 = com.baidu.mshield.sharedpreferences.a.a(r100);
        List<com.baidu.mshield.rp.b.a> r108 = r107.p();
        if (r108 != null) goto L11;
        r107.a(r106);
    L14:
        if (r107.e(r106.f32396e) == true) goto L16;
        b.a(r100).a(r106);
    L16:
        b.a(r100).b();
        b.a(r100).d();
        return;
    L11:
        if (r108.contains(r106) == true) goto L18;
        r107.a(r106);
        goto L14
    L18:
        r107.a(r108, r106);
        b.a(r100).b();
        return;
    }
}
