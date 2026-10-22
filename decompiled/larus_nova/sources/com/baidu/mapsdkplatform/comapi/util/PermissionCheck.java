package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.mapapi.CommonInfo;
import com.baidu.mapapi.RequestAuthResultListener;
import com.baidu.mapsdkplatform.comapi.Initializer;
import com.baidu.mshield.x6.EngineImpl;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class PermissionCheck {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f32268a = "PermissionCheck";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f32269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f32270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Hashtable<String, String> f32271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static LBSAuthManager f32272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static LBSAuthManagerListener f32273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static d f32274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Set<RequestAuthResultListener> f32275h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Object f32276i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f32277j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f32278k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f32279l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f32280m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static int f32281n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f32282o;

    public static /* synthetic */ class a {
    }

    public static class b implements LBSAuthManagerListener {
        private b() {
        }

        public /* synthetic */ b(a r100) {
            this();
        }

        @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
        public void onAuthResult(int r100, String r101) {
            if (r101 != null) goto L16;
            PermissionCheck.a();
            PermissionCheck.permissionCheck();
            PermissionCheck.a();
            Object r102 = PermissionCheck.b();
            monitor-enter(r102);
            Iterator r103 = PermissionCheck.c().iterator();     // Catch: Throwable -> L13
        L7:
            if (r103.hasNext() == false) goto L11;
            RequestAuthResultListener r104 = (RequestAuthResultListener) r103.next();     // Catch: Throwable -> L13
            if (r104 == null) goto L7;
            r104.onAuthResult(2, RequestAuthResultListener.MESSAGE_AUTH_RESULT_NULL);     // Catch: Throwable -> L13
            goto L7
        L11:
            monitor-exit(r102);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        L16:
            c r105 = new c();
            JSONObject r106 = new JSONObject(r101);     // Catch: JSONException -> L45
            if (r106.has("status") == false) goto L21;
            r105.f32283a = r106.optInt("status");     // Catch: JSONException -> L45
        L21:
            if (r106.has("appid") == false) goto L24;
            r105.f32285c = r106.optString("appid");     // Catch: JSONException -> L45
        L24:
            if (r106.has("uid") == false) goto L27;
            r105.f32284b = r106.optString("uid");     // Catch: JSONException -> L45
        L27:
            if (r106.has("message") == false) goto L30;
            r105.f32286d = r106.optString("message");     // Catch: JSONException -> L45
        L30:
            if (r106.has("token") == false) goto L33;
            r105.f32287e = r106.optString("token");     // Catch: JSONException -> L45
        L33:
            if (r106.has("ak_permission") == false) goto L36;
            r105.f32288f = r106.optInt("ak_permission");     // Catch: JSONException -> L45
        L36:
            if (r106.has("user_permission") == false) goto L39;
            r105.f32289g = r106.optInt("user_permission");     // Catch: JSONException -> L45
        L39:
            if (r106.has("ap") == false) goto L42;
            r105.f32290h = r106.optLong("ap");     // Catch: JSONException -> L45
        L42:
            if (r106.has("up") == false) goto L47;
            r105.f32291i = r106.optLong("up");     // Catch: JSONException -> L45
        L47:
            PermissionCheck.a(r105.f32283a);
            if (PermissionCheck.d() == null) goto L50;
            PermissionCheck.d().a(r105);
        L50:
            Object r107 = PermissionCheck.b();
            monitor-enter(r107);
            Iterator r108 = PermissionCheck.c().iterator();     // Catch: Throwable -> L60
        L54:
            if (r108.hasNext() == false) goto L58;
            RequestAuthResultListener r109 = (RequestAuthResultListener) r108.next();     // Catch: Throwable -> L60
            if (r109 == null) goto L54;
            r109.onAuthResult(r105.f32283a, r105.f32286d);     // Catch: Throwable -> L60
            goto L54
        L58:
            monitor-exit(r107);     // Catch: Throwable -> L60
            return;
        L60:
            th = move-exception;
            throw th;
        L45:
            e = move-exception;
            e.printStackTrace();
            goto L47
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f32283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f32284b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f32285c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f32286d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f32287e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f32288f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f32289g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f32290h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f32291i;

        public String toString() {
            return String.format("=============================================\n----------------- 鉴权错误信息 ------------\nsha1;package:%s\nkey:%s\nerrorcode: %d uid: %s appid %s msg: %s\n请仔细核查 SHA1、package与key申请信息是否对应，key是否删除，平台是否匹配\n=============================================\n", new Object[]{com.baidu.mapsdkplatform.comapi.util.a.a(PermissionCheck.e()), PermissionCheck.f(), Integer.valueOf(this.f32283a), this.f32284b, this.f32285c, this.f32286d});
        }

        public c() {
            this.f32283a = 0;
            this.f32284b = "-1";
            this.f32285c = "-1";
            this.f32286d = "";
        }
    }

    public interface d {
        void a(c r100);
    }

    public static void destory() {
        f32274g = null;
        f32269b = null;
        f32273f = null;
    }

    static {
        f32275h = new HashSet();
        f32276i = new Object();
        f32277j = 601;
        f32278k = 200;
        f32279l = 202;
        f32280m = 252;
        f32281n = -11;
        f32282o = -10;
    }

    public static synchronized int permissionCheck() {
        monitor-enter(PermissionCheck.class);
        LBSAuthManager r100 = f32272e;     // Catch: Throwable -> L24
        if (r100 != null) goto L7;
    L21:
        Objects.toString(r100);     // Catch: Throwable -> L24
        Objects.toString(f32273f);     // Catch: Throwable -> L24
        Objects.toString(f32269b);     // Catch: Throwable -> L24
        monitor-exit(PermissionCheck.class);
        return 0;
    L7:
        if (f32273f == null) goto L21;
        if (f32269b == null) goto L21;
        r100.setKey(f32270c);     // Catch: Throwable -> L24
        CommonInfo r101 = Initializer.getCommonInfo();     // Catch: Throwable -> L24
        if (r101 == null) goto L16;
        String r102 = r101.getAndroidID();     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r102) == true) goto L16;
        f32272e.setAndroidId(r102);     // Catch: Throwable -> L24
    L16:
        int r103 = f32272e.authenticate(false, "lbs_androidsdk", f32271d, f32273f);     // Catch: Throwable -> L24
        if (r103 != 0) goto L19;
    L19:
        monitor-exit(PermissionCheck.class);
        return r103;
    L24:
        th = move-exception;
        throw th;
    }

    public PermissionCheck() {
    }

    public static /* synthetic */ String a() {
        return f32268a;
    }

    public static /* synthetic */ Object b() {
        return f32276i;
    }

    public static /* synthetic */ Set c() {
        return f32275h;
    }

    public static /* synthetic */ d d() {
        return f32274g;
    }

    public static /* synthetic */ Context e() {
        return f32269b;
    }

    public static /* synthetic */ String f() {
        return f32270c;
    }

    public static String getApiKey() {
        return f32270c;
    }

    public static int getPermissionResult() {
        return f32277j;
    }

    public static /* synthetic */ int a(int r100) {
        f32277j = r100;
        return r100;
    }

    public static void addRequestAuthResultListener(RequestAuthResultListener r100) {
        Object r101 = f32276i;
        monitor-enter(r101);
        if (r100 != null) goto L11;
    L6:
        monitor-exit(r101);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        f32275h.add(r100);     // Catch: Throwable -> L8
        goto L6
    }

    public static void init(Context r110) {
        f32269b = r110;
        a r111 = null;
        ApplicationInfo r100 = r110.getPackageManager().getApplicationInfo(f32269b.getPackageName(), 128);     // Catch: PackageManager.NameNotFoundException -> L5
    L7:
        if (r100 == null) goto L12;
        if (TextUtils.isEmpty(f32270c) == false) goto L12;
        f32270c = r100.metaData.getString("com.baidu.lbsapi.API_KEY");
    L12:
        if (f32271d != null) goto L15;
        f32271d = new Hashtable();
    L15:
        if (f32272e != null) goto L18;
        f32272e = LBSAuthManager.getInstance(f32269b);
    L18:
        if (f32273f != null) goto L33;
        f32273f = new b(r111);
    L33:
        String r101 = r110.getPackageManager().getPackageInfo(f32269b.getPackageName(), 0).applicationInfo.loadLabel(f32269b.getPackageManager()).toString();     // Catch: Exception -> L23
    L37:
        JSONObject r112 = new JSONObject(g.s());     // Catch: Exception -> L32
        f32271d.put(Keys.API_PARAM_KEY_MB, r112.optString(Keys.API_PARAM_KEY_MB));     // Catch: Exception -> L32
        f32271d.put("os", r112.optString("os"));     // Catch: Exception -> L32
        f32271d.put(com.alipay.sdk.m.s.a.f25762t, r112.optString(com.alipay.sdk.m.s.a.f25762t));     // Catch: Exception -> L32
        f32271d.put("imt", "1");     // Catch: Exception -> L32
        f32271d.put(com.alipay.sdk.m.k.b.f25406k, r112.optString(com.alipay.sdk.m.k.b.f25406k));     // Catch: Exception -> L32
        f32271d.put("cpu", r112.optString("cpu"));     // Catch: Exception -> L32
        f32271d.put("glr", r112.optString("glr"));     // Catch: Exception -> L32
        f32271d.put("glv", r112.optString("glv"));     // Catch: Exception -> L32
        f32271d.put("resid", r112.optString("resid"));     // Catch: Exception -> L32
        f32271d.put("appid", "-1");     // Catch: Exception -> L32
        f32271d.put("ver", "1");     // Catch: Exception -> L32
        f32271d.put("screen", String.format("(%d,%d)", new Object[]{Integer.valueOf(r112.optInt("screen_x")), Integer.valueOf(r112.optInt("screen_y"))}));     // Catch: Exception -> L32
        f32271d.put("dpi", String.format("(%d,%d)", new Object[]{Integer.valueOf(r112.optInt("dpi_x")), Integer.valueOf(r112.optInt("dpi_y"))}));     // Catch: Exception -> L32
        f32271d.put("pcn", r112.optString("pcn"));     // Catch: Exception -> L32
        f32271d.put(EngineImpl.KEY_CUID, r112.optString(EngineImpl.KEY_CUID));     // Catch: Exception -> L32
        f32271d.put("name", r101);     // Catch: Exception -> L32
        return;
    L39:
        return;
    L23:
        e = move-exception;
        e.printStackTrace();
        r101 = "";
    L5:
        e = move-exception;
        e.printStackTrace();
        r100 = null;
        goto L7
    }

    public static void removeRequestAuthResultListener(RequestAuthResultListener r100) {
        Object r101 = f32276i;
        monitor-enter(r101);
        if (r100 != null) goto L11;
    L6:
        monitor-exit(r101);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        f32275h.remove(r100);     // Catch: Throwable -> L8
        goto L6
    }

    public static void setApiKey(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.trim().length() <= 0) goto L8;
        f32270c = r100;
        return;
    }

    public static void setPermissionCheckResultListener(d r100) {
        f32274g = r100;
    }

    public static void setPrivacyMode(boolean r100) {
        if (r100 == false) goto L4;
        permissionCheck();
        return;
    L4:
        g.u();
    }
}
