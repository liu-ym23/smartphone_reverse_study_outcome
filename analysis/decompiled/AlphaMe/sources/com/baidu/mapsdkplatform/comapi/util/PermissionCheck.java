package com.baidu.mapsdkplatform.comapi.util;

import B0.g;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.mapapi.CommonInfo;
import com.baidu.mapsdkplatform.comapi.Initializer;
import com.baidu.mshield.x6.EngineImpl;
import java.util.Hashtable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PermissionCheck {

    /* renamed from: a, reason: collision with root package name */
    private static final String f8167a = "PermissionCheck";

    /* renamed from: b, reason: collision with root package name */
    private static Context f8168b = null;

    /* renamed from: c, reason: collision with root package name */
    private static String f8169c = null;

    /* renamed from: d, reason: collision with root package name */
    private static Hashtable<String, String> f8170d = null;

    /* renamed from: e, reason: collision with root package name */
    private static LBSAuthManager f8171e = null;

    /* renamed from: f, reason: collision with root package name */
    private static LBSAuthManagerListener f8172f = null;

    /* renamed from: g, reason: collision with root package name */
    private static d f8173g = null;

    /* renamed from: h, reason: collision with root package name */
    private static int f8174h = 601;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f8175i = false;

    /* renamed from: j, reason: collision with root package name */
    public static int f8176j = 200;

    /* renamed from: k, reason: collision with root package name */
    public static int f8177k = 202;

    /* renamed from: l, reason: collision with root package name */
    public static int f8178l = 252;

    public static class b implements LBSAuthManagerListener {
        private b() {
        }

        @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
        public void onAuthResult(int i4, String str) {
            if (str == null) {
                Log.e(PermissionCheck.f8167a, "The result is null");
                g.z("onAuthResult try permissionCheck result is: ", PermissionCheck.permissionCheck(), PermissionCheck.f8167a);
                return;
            }
            c cVar = new c();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("status")) {
                    cVar.f8179a = jSONObject.optInt("status");
                }
                if (jSONObject.has("appid")) {
                    cVar.f8181c = jSONObject.optString("appid");
                }
                if (jSONObject.has("uid")) {
                    cVar.f8180b = jSONObject.optString("uid");
                }
                if (jSONObject.has("message")) {
                    cVar.f8182d = jSONObject.optString("message");
                }
                if (jSONObject.has("token")) {
                    cVar.f8183e = jSONObject.optString("token");
                }
                if (jSONObject.has("ak_permission")) {
                    cVar.f8184f = jSONObject.optInt("ak_permission");
                }
                if (jSONObject.has("user_permission")) {
                    cVar.f8185g = jSONObject.optInt("user_permission");
                }
                if (jSONObject.has("ap")) {
                    cVar.f8186h = jSONObject.optLong("ap");
                }
                if (jSONObject.has("up")) {
                    cVar.f8187i = jSONObject.optLong("up");
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            int unused = PermissionCheck.f8174h = cVar.f8179a;
            if (PermissionCheck.f8173g == null || !PermissionCheck.f8175i) {
                return;
            }
            PermissionCheck.f8173g.a(cVar);
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f8179a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f8180b = "-1";

        /* renamed from: c, reason: collision with root package name */
        public String f8181c = "-1";

        /* renamed from: d, reason: collision with root package name */
        public String f8182d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f8183e;

        /* renamed from: f, reason: collision with root package name */
        public int f8184f;

        /* renamed from: g, reason: collision with root package name */
        public int f8185g;

        /* renamed from: h, reason: collision with root package name */
        public long f8186h;

        /* renamed from: i, reason: collision with root package name */
        public long f8187i;

        public String toString() {
            return String.format("=============================================\n----------------- 鉴权错误信息 ------------\nsha1;package:%s\nkey:%s\nerrorcode: %d uid: %s appid %s msg: %s\n请仔细核查 SHA1、package与key申请信息是否对应，key是否删除，平台是否匹配\n=============================================\n", com.baidu.mapsdkplatform.comapi.util.a.a(PermissionCheck.f8168b), PermissionCheck.f8169c, Integer.valueOf(this.f8179a), this.f8180b, this.f8181c, this.f8182d);
        }
    }

    public interface d {
        void a(c cVar);
    }

    public static void destory() {
        f8173g = null;
        f8168b = null;
        f8172f = null;
    }

    public static String getApiKey() {
        return f8169c;
    }

    public static int getPermissionResult() {
        return f8174h;
    }

    public static void init(Context context) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        String string;
        f8168b = context;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(f8168b.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            applicationInfo = null;
        }
        if (applicationInfo != null && TextUtils.isEmpty(f8169c)) {
            f8169c = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
        }
        if (f8170d == null) {
            f8170d = new Hashtable<>();
        }
        if (f8171e == null) {
            f8171e = LBSAuthManager.getInstance(f8168b);
        }
        if (f8172f == null) {
            f8172f = new b();
        }
        try {
            string = context.getPackageManager().getPackageInfo(f8168b.getPackageName(), 0).applicationInfo.loadLabel(f8168b.getPackageManager()).toString();
        } catch (Exception e5) {
            e5.printStackTrace();
            string = "";
        }
        try {
            JSONObject jSONObject = new JSONObject(f.r());
            f8170d.put("mb", jSONObject.optString("mb"));
            f8170d.put("os", jSONObject.optString("os"));
            f8170d.put("sv", jSONObject.optString("sv"));
            f8170d.put("imt", "1");
            f8170d.put("net", jSONObject.optString("net"));
            f8170d.put("cpu", jSONObject.optString("cpu"));
            f8170d.put("glr", jSONObject.optString("glr"));
            f8170d.put("glv", jSONObject.optString("glv"));
            f8170d.put("resid", jSONObject.optString("resid"));
            f8170d.put("appid", "-1");
            f8170d.put("ver", "1");
            f8170d.put("screen", String.format("(%d,%d)", Integer.valueOf(jSONObject.optInt("screen_x")), Integer.valueOf(jSONObject.optInt("screen_y"))));
            f8170d.put("dpi", String.format("(%d,%d)", Integer.valueOf(jSONObject.optInt("dpi_x")), Integer.valueOf(jSONObject.optInt("dpi_y"))));
            f8170d.put("pcn", jSONObject.optString("pcn"));
            f8170d.put(EngineImpl.KEY_CUID, jSONObject.optString(EngineImpl.KEY_CUID));
            f8170d.put("name", string);
        } catch (Exception unused) {
        }
    }

    public static synchronized int permissionCheck() {
        try {
            if (!f8175i) {
                return 0;
            }
            LBSAuthManager lBSAuthManager = f8171e;
            if (lBSAuthManager != null && f8172f != null && f8168b != null) {
                lBSAuthManager.setKey(f8169c);
                CommonInfo commonInfo = Initializer.getCommonInfo();
                if (commonInfo != null) {
                    String androidID = commonInfo.getAndroidID();
                    if (!TextUtils.isEmpty(androidID)) {
                        f8171e.setAndroidId(androidID);
                    }
                }
                int iAuthenticate = f8171e.authenticate(false, "lbs_androidsdk", f8170d, f8172f);
                if (iAuthenticate != 0) {
                    Log.e(f8167a, "permission check result is: " + iAuthenticate);
                }
                return iAuthenticate;
            }
            Log.e(f8167a, "The authManager is: " + f8171e + "; the authCallback is: " + f8172f + "; the mContext is: " + f8168b);
            return 0;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void setApiKey(String str) {
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        f8169c = str;
    }

    public static void setPermissionCheckResultListener(d dVar) {
        f8173g = dVar;
    }

    public static void setPrivacyMode(boolean z4) {
        f8175i = z4;
        if (z4) {
            permissionCheck();
        } else {
            f.t();
        }
    }
}
