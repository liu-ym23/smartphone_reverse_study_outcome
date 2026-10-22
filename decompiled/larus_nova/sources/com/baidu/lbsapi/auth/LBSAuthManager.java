package com.baidu.lbsapi.auth;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.android.bbalbs.common.util.DeviceId;
import com.baidu.mshield.x6.EngineImpl;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class LBSAuthManager {
    public static final int CODE_AUTHENTICATE_SUCC = 0;
    public static final int CODE_AUTHENTICATING = 602;
    public static final int CODE_INNER_ERROR = -1;
    public static final int CODE_KEY_NOT_EXIST = 101;
    public static final int CODE_NETWORK_FAILED = -11;
    public static final int CODE_NETWORK_INVALID = -10;
    public static final int CODE_UNAUTHENTICATE = 601;
    public static final String VERSION = "1.0.34";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f30420a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f30421b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f30422c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f30423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f30424e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static HandlerThread f30425h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Handler f30426i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Object f30427j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile boolean f30428k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static int f30429l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static Hashtable f30430m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static LBSAuthManager f30431n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static String f30432q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static String f30433r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static String f30434s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static boolean f30435t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static String f30436u;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private e f30437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private g f30438g;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f30439o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private byte[] f30440p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Handler f30441v;

    static {
        f30427j = new Object();
        f30428k = false;
        f30429l = 0;
        f30430m = new Hashtable();
        f30432q = "";
        f30433r = "";
        f30434s = "";
        f30435t = false;
        f30436u = null;
    }

    private LBSAuthManager(Context r100) {
        this.f30437f = null;
        this.f30438g = null;
        this.f30439o = false;
        this.f30441v = new l(this, Looper.getMainLooper());
        f30420a = r100;
        HandlerThread r101 = f30425h;
        if (r101 != null) goto L5;
    L7:
        b.b("BaiduApiAuth SDK Version:1.0.34");
        i();
        return;
    L5:
        if (ThreadMethodProxy.isAlive(r101) == true) goto L7;
        f30425h = null;
        goto L7
    }

    private int a(String r110) {
        int r100 = -1;
        JSONObject r101 = new JSONObject(r110);     // Catch: JSONException -> L25
        if (r101.has("status") == true) goto L6;
        r101.put("status", -1);     // Catch: JSONException -> L25
    L6:
        r100 = JSONObjectProtectorUtils.getInt(r101, "status");     // Catch: JSONException -> L25
        if (r101.has("current") == false) goto L18;
        if (r100 != 0) goto L18;
        long r102 = JSONObjectProtectorUtils.getLong(r101, "current");     // Catch: JSONException -> L25
        long r103 = System.currentTimeMillis();     // Catch: JSONException -> L25
        if (((r103 - r102) / 3600000.0d) < 24.0d) goto L13;
    L11:
        r100 = 601;
        goto L18
    L13:
        if (this.f30439o == false) goto L18;
        SimpleDateFormat r111 = new SimpleDateFormat("yyyy-MM-dd");     // Catch: JSONException -> L25
        if (r111.format(Long.valueOf(r103)).equals(r111.format(Long.valueOf(r102))) == false) goto L11;
    L18:
        if (r101.has("current") == false) goto L28;
        if (r100 != 602) goto L28;
        if (((System.currentTimeMillis() - JSONObjectProtectorUtils.getLong(r101, "current")) / 1000) <= 180.0d) goto L28;
        return 601;
    L28:
        return r100;
    L25:
        e = move-exception;
        e.printStackTrace();
        goto L28
    }

    private String a(int r100) throws IOException {
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper("/proc/" + r100 + "/cmdline");     // Catch: Throwable -> L21
        byte[] r102 = new byte[256];     // Catch: Throwable -> L19
        int r103 = 0;
    L6:
        int r104 = r101.read();     // Catch: Throwable -> L19
        if (r104 <= 0) goto L10;
        if (r103 >= 256) goto L10;
        r102[r103] = (byte) r104;     // Catch: Throwable -> L19
        r103 = r103 + 1;     // Catch: Throwable -> L19
    L10:
        if (r103 <= 0) goto L17;
        String r105 = new String(r102, 0, r103, "UTF-8");     // Catch: Throwable -> L19
        r101.close();     // Catch: IOException -> L14
    L16:
        return r105;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    L17:
        r101.close();     // Catch: IOException -> L27
    L43:
    L29:
        return null;
    L19:
        th = th;
    L39:
        th.printStackTrace();     // Catch: Throwable -> L30
        if (r101 == null) goto L29;
        r101.close();     // Catch: IOException -> L27
    L30:
        th = move-exception;
        if (r101 != null) goto L46;
    L36:
        throw th;
    L46:
        r101.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L21:
        th = th;
        r101 = null;
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    }

    private String a(Context r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        SharedPreferences r101 = r100.getSharedPreferences("Map_Privacy", 0);
        if (r101.contains("random_uuid") == false) goto L10;
        String r102 = r101.getString("random_uuid", "");
        if (TextUtils.isEmpty(r102) == true) goto L10;
        return r102;
    L10:
        String r103 = UUID.randomUUID().toString();
        SharedPreferences.Editor r104 = r101.edit();
        r104.putString("random_uuid", r103);
        r104.apply();
        return r103;
    }

    private String a(Context r100, String r101) {
        String r102 = "";
        if (TextUtils.isEmpty(f30432q) == false) goto L5;
        String r103 = r100.getPackageName();
        Bundle r104 = r100.getPackageManager().getApplicationInfo(r103, 128).metaData;     // Catch: PackageManager.NameNotFoundException -> L21
        if (r104 != null) goto L12;
        LBSAuthManagerListener r105 = (LBSAuthManagerListener) f30430m.get(r101);     // Catch: PackageManager.NameNotFoundException -> L21
        if (r105 == null) goto L28;
        r105.onAuthResult(101, ErrorMessage.a(101, "AndroidManifest.xml的application中没有meta-data标签"));     // Catch: PackageManager.NameNotFoundException -> L21
    L28:
    L25:
        return r102;
    L12:
        String r106 = r104.getString("com.baidu.lbsapi.API_KEY");     // Catch: PackageManager.NameNotFoundException -> L21
        if (r106 != null) goto L26;
    L16:
        LBSAuthManagerListener r107 = (LBSAuthManagerListener) f30430m.get(r101);     // Catch: PackageManager.NameNotFoundException -> L20
        if (r107 == null) goto L19;
        r107.onAuthResult(101, ErrorMessage.a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));     // Catch: PackageManager.NameNotFoundException -> L20
    L20:
        r102 = r106;
    L19:
        r102 = r106;
        goto L28
    L26:
        if (r106.equals("") == false) goto L19;
    L22:
        LBSAuthManagerListener r108 = (LBSAuthManagerListener) f30430m.get(r101);
        if (r108 == null) goto L25;
        r108.onAuthResult(101, ErrorMessage.a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
        goto L25
    L5:
        return f30432q;
    }

    public static /* synthetic */ Hashtable a() {
        return f30430m;
    }

    public static /* synthetic */ void a(LBSAuthManager r100, String r101, String r102, String r103) {
        r100.a(r101, r102, r103);
    }

    public static /* synthetic */ void a(LBSAuthManager r100, boolean r101, String r102, Hashtable r103, String r104, String r105, int r106, String r107, String r108) {
        r100.a(r101, r102, r103, r104, r105, r106, r107, r108);
    }

    public static /* synthetic */ void a(LBSAuthManager r100, boolean r101, String r102, Hashtable r103, String[] r104, String r105, String r106, int r107, String r108, String r109) {
        r100.a(r101, r102, r103, r104, r105, r106, r107, r108, r109);
    }

    private void a(String r100, String r101, String r110) {
        monitor-enter(LBSAuthManager.class);
        if (r101 == null) goto L48;
    L6:
        Message r102 = this.f30441v.obtainMessage();     // Catch: Throwable -> L45
        int r103 = -1;
        JSONObject r104 = new JSONObject(r101);     // Catch: JSONException -> L22 Throwable -> L45
        if (r104.has("status") == true) goto L12;
        r104.put("status", -1);     // Catch: JSONException -> L22 Throwable -> L45
    L12:
        if (r104.has("current") == true) goto L14;
        r104.put("current", System.currentTimeMillis());     // Catch: JSONException -> L22 Throwable -> L45
    L14:
        b(r100, r104.toString());     // Catch: JSONException -> L22 Throwable -> L45
        if (r104.has("current") == false) goto L17;
        r104.remove("current");     // Catch: JSONException -> L22 Throwable -> L45
    L17:
        r103 = r104.getInt("status");     // Catch: JSONException -> L22 Throwable -> L45
        r102.what = r103;     // Catch: JSONException -> L22 Throwable -> L45
        if (r103 != 0) goto L20;
        a(r104);     // Catch: JSONException -> L22 Throwable -> L45
    L20:
        r102.obj = r104;     // Catch: JSONException -> L22 Throwable -> L45
        Bundle r105 = new Bundle();     // Catch: JSONException -> L22 Throwable -> L45
        r105.putString("listenerKey", r110);     // Catch: JSONException -> L22 Throwable -> L45
        r102.setData(r105);     // Catch: JSONException -> L22 Throwable -> L45
        this.f30441v.sendMessage(r102);     // Catch: JSONException -> L22 Throwable -> L45
    L25:
        if (f30425h == null) goto L34;
        Object r106 = f30427j;     // Catch: Throwable -> L45
        monitor-enter(r106);     // Catch: Throwable -> L45
        f30428k = true;     // Catch: Throwable -> L31
        r106.notifyAll();     // Catch: Throwable -> L31
        monitor-exit(r106);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L45
    L34:
        f30429l--;     // Catch: Throwable -> L45
        b.a("httpRequest called mAuthCounter-- = " + f30429l);     // Catch: Throwable -> L45
        if (f30429l != 0) goto L43;
        Handler r107 = f30426i;     // Catch: Throwable -> L45
        if (r107 == null) goto L39;
        r107.removeCallbacksAndMessages(null);     // Catch: Throwable -> L45
        f30426i = null;     // Catch: Throwable -> L45
    L39:
        HandlerThread r108 = f30425h;     // Catch: Throwable -> L45
        if (r108 == null) goto L42;
        r108.quit();     // Catch: Throwable -> L45
        f30425h = null;     // Catch: Throwable -> L45
    L42:
        f30428k = false;     // Catch: Throwable -> L45
    L43:
        monitor-exit(LBSAuthManager.class);     // Catch: Throwable -> L45
        return;
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L45
        r102.what = r103;     // Catch: Throwable -> L45
        r102.obj = new JSONObject();     // Catch: Throwable -> L45
        Bundle r109 = new Bundle();     // Catch: Throwable -> L45
        r109.putString("listenerKey", r110);     // Catch: Throwable -> L45
        r102.setData(r109);     // Catch: Throwable -> L45
        this.f30441v.sendMessage(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    L48:
        r101 = c(r100);     // Catch: Throwable -> L45
        goto L6
    }

    private void a(HashMap r100, String r101, String r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() <= 0) goto L26;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.length() <= 0) goto L28;
        if (r102 != null) goto L10;
        return;
    L10:
        if (r102.length() <= 0) goto L30;
        String r103 = p.a(r102);     // Catch: Exception -> L19
        if (r103 != null) goto L15;
    L17:
        r100.put(r101, r102);     // Catch: Exception -> L19
    L21:
        return;
    L15:
        if (r103.length() <= 0) goto L17;
        r100.put(r101, r103);     // Catch: Exception -> L19
    L19:
        r100.put(r101, r102);
        return;
    L30:
        return;
    L28:
        return;
    }

    private void a(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() > 0) goto L7;
        return;
    L7:
        if (r100.has("en") == true) goto L10;
        return;
    L10:
        if (r100.optInt("en", 0) == 0) goto L12;
        a(r100, "ak");
        a(r100, CameraParam.TYPE_CK_CAMERA);
        a(r100, "sk");
        a(r100, "uid");
        b(r100);
        return;
    L12:
        if (r100.optString(CameraParam.TYPE_CK_CAMERA).length() <= 0) goto L17;
        this.f30440p = c.a(r100.optString(CameraParam.TYPE_CK_CAMERA).getBytes(StandardCharsets.UTF_8));
        return;
    }

    private void a(JSONObject r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() <= 0) goto L29;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.length() > 0) goto L10;
        return;
    L10:
        if (r100.has(r101) == false) goto L30;
        byte[] r102 = p.b(r100.optString(r101));     // Catch: Exception -> L22
        if (r102 != null) goto L15;
    L20:
        r100.put(r101, "");     // Catch: Exception -> L22
        r100.put("decode_status", -1);     // Catch: Exception -> L22
    L23:
        return;
    L15:
        if (r102.length <= 0) goto L20;
        r100.put(r101, new String(r102, StandardCharsets.UTF_8));     // Catch: Exception -> L22
        if (CameraParam.TYPE_CK_CAMERA.equals(r101) == false) goto L23;
        this.f30440p = r102;     // Catch: Exception -> L22
    L31:
        return;
    L30:
        return;
    }

    private void a(boolean r110, String r111, Hashtable r112, String r113, String r114, int r115, String r210, String r211) {
        String r100 = a(f30420a, r113);
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.equals("") == true) goto L63;
        HashMap r101 = new HashMap();
        p.a();
        if (p.b() == null) goto L10;
        String r102 = p.b();
    L11:
        r101.put(PbRequest.SwitchType.PK, r102);
        r101.put("url", "https://api.map.baidu.com/sdkcs/verify");
        b.a("url:https://api.map.baidu.com/sdkcs/verify");
        r101.put(BdpAppEventConstant.PARAMS_OUTPUT, "json");
        a(r101, "ak", r100);
        b.a("ak:" + ((String) r101.get("ak")));
        a(r101, "mcode", d.a(f30420a));
        r101.put("from", "lbs_yunsdk");
        if (r112 == null) goto L24;
        if (r112.size() <= 0) goto L24;
        Iterator r103 = r112.entrySet().iterator();
    L17:
        if (r103.hasNext() == false) goto L24;
        Map.Entry r104 = (Map.Entry) r103.next();
        String r105 = (String) r104.getKey();
        String r106 = (String) r104.getValue();
        if (TextUtils.isEmpty(r105) == true) goto L17;
        if (TextUtils.isEmpty(r106) == true) goto L17;
        r101.put(r105, r106);
    L24:
        if (TextUtils.isEmpty(f30433r) == true) goto L26;
        String r107 = getCUID();
    L27:
        b.a("cuid:" + f30436u);
        if (TextUtils.isEmpty(r107) == true) goto L30;
        r101.put(EngineImpl.KEY_CUID, r107);
    L31:
        r101.put("pcn", f30420a.getPackageName());
        r101.put("version", VERSION);
        r101.put("macaddr", "");
        String r108 = d.a();     // Catch: Exception -> L34
    L36:
        if (TextUtils.isEmpty(r108) == true) goto L38;
        r101.put("language", r108);
    L39:
        if (r110 == false) goto L45;
        if (r110 == false) goto L42;
        String r109 = "1";
    L43:
        r101.put("force", r109);
        goto L45
    L42:
        r109 = "0";
    L45:
        if (r111 != null) goto L47;
        r101.put("from_service", "");
    L48:
        String r116 = b(r111);
        if (TextUtils.isEmpty(r116) == true) goto L51;
        r101.put(GXTemplateKey.GAIAX_EXTEND, r116);
    L51:
        e r117 = new e(f30420a);
        this.f30437f = r117;
        r117.a(r101, r114, r115, r210, r211, new n(this, r111, r113));
        return;
    L47:
        r101.put("from_service", r111);
        goto L48
    L38:
        r101.put("language", "");
    L34:
        r108 = "";
        goto L36
    L30:
        r101.put(EngineImpl.KEY_CUID, "");
        goto L31
    L26:
        r107 = f30436u;
        goto L27
    L10:
        r102 = "";
        goto L11
    }

    private void a(boolean r110, String r111, Hashtable r112, String[] r113, String r210, String r211, int r212, String r213, String r214) {
        String r100 = a(f30420a, r210);
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.equals("") == true) goto L76;
        HashMap r101 = new HashMap();
        p.a();
        if (p.b() == null) goto L10;
        String r102 = p.b();
    L11:
        r101.put(PbRequest.SwitchType.PK, r102);
        r101.put("url", "https://api.map.baidu.com/sdkcs/verify");
        r101.put(BdpAppEventConstant.PARAMS_OUTPUT, "json");
        a(r101, "ak", r100);
        r101.put("from", "lbs_yunsdk");
        if (r112 == null) goto L24;
        if (r112.size() <= 0) goto L24;
        Iterator r103 = r112.entrySet().iterator();
    L17:
        if (r103.hasNext() == false) goto L24;
        Map.Entry r104 = (Map.Entry) r103.next();
        String r105 = (String) r104.getKey();
        String r106 = (String) r104.getValue();
        if (TextUtils.isEmpty(r105) == true) goto L17;
        if (TextUtils.isEmpty(r106) == true) goto L17;
        r101.put(r105, r106);
    L24:
        if (TextUtils.isEmpty(f30433r) == true) goto L26;
        String r107 = getCUID();
    L27:
        b.a("sendAuthRequests : cuid: " + r107);
        if (TextUtils.isEmpty(r107) == true) goto L30;
        r101.put(EngineImpl.KEY_CUID, r107);
    L31:
        r101.put("pcn", f30420a.getPackageName());
        r101.put("version", VERSION);
        r101.put("macaddr", "");
        String r108 = d.a();     // Catch: Exception -> L34
    L36:
        if (TextUtils.isEmpty(r108) == true) goto L38;
        r101.put("language", r108);
    L39:
        if (r110 == false) goto L45;
        if (r110 == false) goto L42;
        String r109 = "1";
    L43:
        r101.put("force", r109);
        goto L45
    L42:
        r109 = "0";
    L45:
        if (r111 != null) goto L47;
        r101.put("from_service", "");
    L48:
        String r114 = b(r111);
        if (TextUtils.isEmpty(r114) == true) goto L51;
        r101.put(GXTemplateKey.GAIAX_EXTEND, r114);
    L51:
        String[] r115 = new String[r113.length];
        int r116 = 0;
    L53:
        if (r116 >= r113.length) goto L61;
        String r117 = p.a(r113[r116]);
        if (r117 != null) goto L57;
    L59:
        r115[r116] = r113[r116];
    L60:
        r116 = r116 + 1;
        goto L53
    L57:
        if (r117.length() <= 0) goto L59;
        r115[r116] = r117;
        goto L60
    L61:
        g r118 = new g(f30420a);
        this.f30438g = r118;
        r118.a(r101, r115, r211, r212, r213, r214, new o(this, r111, r210));
        return;
    L47:
        r101.put("from_service", r111);
        goto L48
    L38:
        r101.put("language", "");
    L34:
        r108 = "";
        goto L36
    L30:
        r101.put(EngineImpl.KEY_CUID, "");
        goto L31
    L26:
        r107 = f30436u;
        goto L27
    L10:
        r102 = "";
        goto L11
    }

    public static /* synthetic */ boolean a(LBSAuthManager r100, String r101, String r102) {
        return r100.a(r101, r102);
    }

    private boolean a(String r100, String r101) {
        String r102 = a(f30420a, r101);
        JSONObject r103 = new JSONObject(c(r100));     // Catch: JSONException -> L13
        if (r103.has("ak") == true) goto L7;
        return true;
    L7:
        if (r103.has("en") == true) goto L9;
    L11:
        String r104 = JSONObjectProtectorUtils.getString(r103, "ak");     // Catch: JSONException -> L13
    L15:
        if (r102 == null) goto L20;
        if (r104 != null) goto L18;
        return false;
    L18:
        if (r102.equals(r104) == true) goto L25;
        return true;
    L25:
        return false;
    L20:
        return false;
    L9:
        if (JSONObjectProtectorUtils.getInt(r103, "en") != 1) goto L11;
        a(r103, "ak");     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        r104 = "";
        goto L15
    }

    public static /* synthetic */ Context b() {
        return f30420a;
    }

    private String b(Context r100) {
        if (Build.VERSION.SDK_INT < 28) goto L17;
        return Application.getProcessName();
    L17:
        String r101 = a(Process.myPid());     // Catch: IOException -> L9
    L10:
        if (r101 == null) goto L12;
        return r101;
    L12:
        if (r100 != null) goto L16;
        return "";
    L16:
        return r100.getPackageName();
    L9:
        r101 = null;
        goto L10
    }

    private String b(String r100) {
        JSONObject r101 = new JSONObject(c(r100));     // Catch: JSONException -> L8
        if (r101.has(GXTemplateKey.GAIAX_EXTEND) == true) goto L6;
        return "";
    L6:
        return JSONObjectProtectorUtils.getString(r101, GXTemplateKey.GAIAX_EXTEND);
    L8:
        return "";
    }

    private void b(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        r100 = "status";
    L5:
        f30420a.getSharedPreferences("authStatus_" + b(f30420a), 0).edit().putString(r100, r101).apply();
    }

    private void b(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() > 0) goto L7;
        return;
    L7:
        if (r100.has(CameraParam.TYPE_CK_CAMERA) == false) goto L10;
        r100.remove(CameraParam.TYPE_CK_CAMERA);
    L10:
        if (r100.has("en") == false) goto L14;
        r100.remove("en");
        return;
    }

    public static /* synthetic */ String c() {
        return f30421b;
    }

    private String c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r100 = "status";
    L6:
        return f30420a.getSharedPreferences("authStatus_" + b(f30420a), 0).getString(r100, "{\"status\":601}");
    }

    public static /* synthetic */ int d() {
        return f30422c;
    }

    public static /* synthetic */ String e() {
        return f30423d;
    }

    public static /* synthetic */ String f() {
        return f30424e;
    }

    public static /* synthetic */ Object g() {
        return f30427j;
    }

    public static LBSAuthManager getInstance(Context r100) {
        if (f30431n == null) goto L5;
        if (r100 == null) goto L16;
        f30420a = r100;
    L20:
        return f30431n;
    L16:
        if (b.f30442a == false) goto L20;
        b.c("input context is null");
        new RuntimeException("here").printStackTrace();
        goto L20
    L5:
        monitor-enter(LBSAuthManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f30431n != null) goto L9;
        f30431n = new LBSAuthManager(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(LBSAuthManager.class);     // Catch: Throwable -> L11
        goto L20
    }

    public static /* synthetic */ boolean h() {
        return f30428k;
    }

    private void i() {
        monitor-enter(LBSAuthManager.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f30425h != null) goto L7;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("auth");     // Catch: Throwable -> L9
        f30425h = r100;     // Catch: Throwable -> L9
        ThreadMethodProxy.start(r100);     // Catch: Throwable -> L9
        f30426i = new Handler(f30425h.getLooper());     // Catch: Throwable -> L9
    L7:
        monitor-exit(LBSAuthManager.class);     // Catch: Throwable -> L9
    }

    public int authenticate(boolean r110, String r111, Hashtable r112, LBSAuthManagerListener r113) {
        monitor-enter(LBSAuthManager.class);
        boolean r100 = false;
        if (r112 != null) goto L44;
    L12:
        this.f30439o = r100;     // Catch: Throwable -> L41
        String r101 = System.currentTimeMillis() + "";     // Catch: Throwable -> L41
        if (r113 == null) goto L15;
        f30430m.put(r101, r113);     // Catch: Throwable -> L41
    L15:
        String r102 = a(f30420a, r101);     // Catch: Throwable -> L41
        if (r102 != null) goto L18;
    L38:
        monitor-exit(LBSAuthManager.class);     // Catch: Throwable -> L41
        return 101;
    L18:
        if (r102.equals("") == true) goto L38;
        f30429l++;     // Catch: Throwable -> L41
        b.a(" mAuthCounter  ++ = " + f30429l);     // Catch: Throwable -> L41
        String r103 = c(r111);     // Catch: Throwable -> L41
        b.a("getAuthMessage from cache:" + r103);     // Catch: Throwable -> L41
        int r114 = a(r103);     // Catch: Throwable -> L41
        if (r114 == 601) goto L45;
    L27:
        i();     // Catch: Throwable -> L41
        if (f30425h != null) goto L30;
    L35:
        monitor-exit(LBSAuthManager.class);     // Catch: Throwable -> L41
        return -1;
    L30:
        if (f30426i == null) goto L35;
        b.a("mThreadLooper.mHandler = " + f30426i);     // Catch: Throwable -> L41
        f30426i.post(new m(this, r114, r110, r111, r101, r112));     // Catch: Throwable -> L41
        monitor-exit(LBSAuthManager.class);     // Catch: Throwable -> L41
        return r114;
    L45:
        b(r111, new JSONObject().put("status", 602).toString());     // Catch: JSONException -> L25 Throwable -> L41
    L25:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    L44:
        String r115 = (String) r112.get("zero_auth");     // Catch: Throwable -> L41
        if (r115 == null) goto L12;
        if (Integer.valueOf(r115).intValue() != 1) goto L12;
        r100 = true;
        goto L12
    }

    public String decodeAESMessage(String r100) {
        if (r100 != null) goto L5;
    L14:
        return null;
    L5:
        if (r100.length() <= 0) goto L14;
        byte[] r101 = this.f30440p;
        if (r101 == null) goto L14;
        if (r101.length <= 0) goto L14;
        byte[] r102 = c.a(r100.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L15
        byte[] r103 = this.f30440p;     // Catch: Exception -> L15
        return new String(a.a(r103, r103, r102), StandardCharsets.UTF_8);
    }

    public String getCUID() {
        if (TextUtils.isEmpty(f30436u) == false) goto L5;
        String r100 = "";
        if (f30420a != null) goto L19;
        return "";
    L19:
        b.a("mIsPrivacyMode " + f30435t);     // Catch: Exception -> L16
        if (TextUtils.isEmpty(f30433r) == true) goto L13;
        String r101 = f30433r;     // Catch: Exception -> L16
    L12:
        DeviceId.setAndroidId(r101);     // Catch: Exception -> L16
        r100 = DeviceId.getCUID(f30420a);     // Catch: Exception -> L16
        f30436u = r100;     // Catch: Exception -> L16
        b.a("getCUID: " + r100);     // Catch: Exception -> L16
        return r100;
    L13:
        r101 = a(f30420a);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
        return r100;
    L5:
        return f30436u;
    }

    public String getKey() {
        Context r100 = f30420a;
        if (r100 != null) goto L10;
        return "";
    L10:
        return getPublicKey(r100);
    L7:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public String getMCode() {
        Context r100 = f30420a;
        if (r100 != null) goto L7;
        return "";
    L7:
        return d.a(r100);
    }

    public boolean getPrivacyMode() {
        return f30435t;
    }

    public String getPublicKey(Context r100) throws PackageManager.NameNotFoundException {
        if (TextUtils.isEmpty(f30432q) == false) goto L5;
        String r101 = r100.getPackageName();
        Bundle r102 = r100.getPackageManager().getApplicationInfo(r101, 128).metaData;
        if (r102 != null) goto L11;
        return "";
    L11:
        return r102.getString("com.baidu.lbsapi.API_KEY");
    L5:
        return f30432q;
    }

    public void setAndroidId(String r100) {
        if (f30420a != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L10;
        f30433r = r100;
        return;
    }

    public void setHttpProxyUsernameAndPassword(String r100, String r101) {
        f30423d = r100;
        f30424e = r101;
    }

    public void setKey(String r100) {
        if (f30420a != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L10;
        f30432q = r100;
        return;
    }

    public void setPackageName(String r100) {
        f30434s = r100;
    }

    public void setPrivacyMode(boolean r100) {
        Context r101 = f30420a;
        if (r101 != null) goto L5;
        return;
    L5:
        SharedPreferences r102 = r101.getSharedPreferences("Map_Privacy", 0);
        SharedPreferences.Editor r103 = r102.edit();
        if (r100 == false) goto L8;
        r103.putBoolean("privacyMode", r100);
        r103.apply();
    L9:
        f30435t = r100;
        return;
    L8:
        r100 = r102.getBoolean("privacyMode", false);
        goto L9
    }

    public void setProxy(String r100, int r101) {
        f30421b = r100;
        f30422c = r101;
    }
}
