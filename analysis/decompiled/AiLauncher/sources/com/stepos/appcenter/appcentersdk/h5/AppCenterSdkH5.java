package com.stepos.appcenter.appcentersdk.h5;

import I6.a;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.ContextThemeWrapper;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.autonavi.aps.amapapi.config.Const;
import com.networknt.schema.keyword.PropertiesValidator;
import com.stepos.appcenter.appcentersdk.AppCenterSdk;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes3.dex */
public class AppCenterSdkH5 {
    public static final Set<String> mCachedOpen = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public AppCenterSdk f29469a;

    /* renamed from: e, reason: collision with root package name */
    public Context f29473e;

    /* renamed from: f, reason: collision with root package name */
    public final String f29474f;

    /* renamed from: g, reason: collision with root package name */
    public Handler f29475g;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<Pair<String, String>, AppCenterSdk.Listener> f29470b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, AppCenterSdk.Listener> f29471c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap<String, String> f29472d = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    public ExecutorService f29476h = Executors.newCachedThreadPool();

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f29477a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f29478b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f29479c;

        public a(String str, String str2, JSONObject jSONObject) {
            this.f29477a = str;
            this.f29478b = str2;
            this.f29479c = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCenterSdkH5.this.f29469a.statistics(this.f29477a, this.f29478b, this.f29479c);
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f29481a;

        public b(e eVar) {
            this.f29481a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCenterSdkH5.this.f29469a.registerGlobalListener(this.f29481a);
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f29483a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f29484b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f29485c;

        public c(String str, int i10, e eVar) {
            this.f29483a = str;
            this.f29484b = i10;
            this.f29485c = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCenterSdkH5.this.f29469a.registerListener(this.f29483a, this.f29484b, this.f29485c);
        }
    }

    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f29487a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f29488b;

        public d(String str, JSONObject jSONObject) {
            this.f29487a = str;
            this.f29488b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCenterSdkH5.this.f29469a.statistics(this.f29487a, null, this.f29488b);
            Log.d("AppCenterSdkH5", "onClickEvent: action = " + this.f29487a + " | property = " + this.f29488b.j());
        }
    }

    public class e implements AppCenterSdk.Listener {

        /* renamed from: a, reason: collision with root package name */
        public final String f29490a;

        /* renamed from: b, reason: collision with root package name */
        public final String f29491b;

        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ JSONObject f29493a;

            public a(JSONObject jSONObject) {
                this.f29493a = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                AppCenterSdkH5.a(AppCenterSdkH5.this);
            }
        }

        public e(String str, String str2) {
            this.f29490a = str;
            this.f29491b = str2;
        }

        @Override // com.stepos.appcenter.appcentersdk.AppCenterSdk.Listener
        public void onCallback(int i10, String str) {
            JSONObject jSONObject;
            if (Log.isLoggable("AppCenterSdkH5", 3)) {
                Log.d("AppCenterSdkH5", "onCallback: code = " + i10 + " | data = " + str);
            }
            try {
                jSONObject = G1.a.v(str);
            } catch (JSONException unused) {
                Log.d("AppCenterSdkH5", "DownloadCallback: is not a json string");
                jSONObject = null;
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
                jSONObject.put("data", str);
            }
            if (!jSONObject.containsKey("packageName") && !TextUtils.isEmpty(this.f29491b)) {
                jSONObject.put("packageName", this.f29491b);
            }
            jSONObject.put("code", Integer.valueOf(i10));
            if (TextUtils.isEmpty(this.f29490a) || AppCenterSdkH5.this.f29475g == null) {
                return;
            }
            AppCenterSdkH5.this.f29475g.post(new a(jSONObject));
        }
    }

    public class f implements AppCenterSdk.Listener {

        /* renamed from: a, reason: collision with root package name */
        public String f29495a;

        /* renamed from: b, reason: collision with root package name */
        public String f29496b;

        /* renamed from: c, reason: collision with root package name */
        public String f29497c;

        /* renamed from: d, reason: collision with root package name */
        public int f29498d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f29499e;

        public f(AppCenterSdkH5 appCenterSdkH5, String str, String str2, String str3) {
            this(str, str2, str3, false);
        }

        public final boolean a(String str) {
            JSONObject jSONObjectV = G1.a.v(str);
            if (jSONObjectV.containsKey("source_apkname")) {
                String strT = jSONObjectV.T("source_apkname");
                String strT2 = jSONObjectV.T("source_info");
                if (TextUtils.equals(strT, AppCenterSdkH5.this.f29474f) && TextUtils.equals(strT2, this.f29496b)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x00cc  */
        /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
        @Override // com.stepos.appcenter.appcentersdk.AppCenterSdk.Listener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onCallback(int r4, java.lang.String r5) {
            /*
                r3 = this;
                boolean r0 = r3.f29499e
                r1 = 3
                java.lang.String r2 = "AppCenterSdkH5"
                if (r0 == 0) goto L28
                boolean r0 = r3.a(r5)
                if (r0 != 0) goto L28
                boolean r3 = android.util.Log.isLoggable(r2, r1)
                if (r3 == 0) goto Le2
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "it is false when judge and dont stats | data is = "
                r3.append(r4)
                r3.append(r5)
                java.lang.String r3 = r3.toString()
                android.util.Log.d(r2, r3)
                return
            L28:
                int r0 = r3.f29498d
                if (r0 != r4) goto L2e
                goto Le2
            L2e:
                r3.f29498d = r4
                boolean r0 = android.util.Log.isLoggable(r2, r1)
                if (r0 == 0) goto L52
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "StatsDownloadCallback: code = "
                r0.append(r1)
                r0.append(r4)
                java.lang.String r1 = " | data = "
                r0.append(r1)
                r0.append(r5)
                java.lang.String r5 = r0.toString()
                android.util.Log.d(r2, r5)
            L52:
                r5 = 10
                if (r4 == r5) goto Lbe
                r5 = 13
                java.lang.String r0 = "install"
                if (r4 == r5) goto L98
                r5 = 21
                if (r4 == r5) goto L72
                r5 = 22
                if (r4 == r5) goto L66
                goto Le2
            L66:
                com.stepos.appcenter.appcentersdk.h5.AppCenterSdkH5 r4 = com.stepos.appcenter.appcentersdk.h5.AppCenterSdkH5.this
                java.lang.String r5 = r3.f29495a
                java.lang.String r0 = r3.f29496b
                java.lang.String r1 = r3.f29497c
                com.stepos.appcenter.appcentersdk.h5.AppCenterSdkH5.f(r4, r5, r0, r1)
                goto Lc9
            L72:
                I6.a$a r4 = I6.a.i()
                com.stepos.appcenter.appcentersdk.h5.AppCenterSdkH5 r5 = com.stepos.appcenter.appcentersdk.h5.AppCenterSdkH5.this
                java.lang.String r1 = r3.f29495a
                java.lang.String r5 = com.stepos.appcenter.appcentersdk.h5.AppCenterSdkH5.g(r5, r1)
                I6.a$a r5 = r4.g(r5)
                java.lang.String r1 = r3.f29496b
                I6.a$a r5 = r5.c(r1)
                java.lang.String r1 = r3.f29495a
                I6.a$a r5 = r5.d(r1)
                I6.a$a r5 = r5.b(r0)
                java.lang.String r0 = "2"
                r5.h(r0)
                goto Lca
            L98:
                I6.a$a r4 = I6.a.i()
                com.stepos.appcenter.appcentersdk.h5.AppCenterSdkH5 r5 = com.stepos.appcenter.appcentersdk.h5.AppCenterSdkH5.this
                java.lang.String r1 = r3.f29495a
                java.lang.String r5 = com.stepos.appcenter.appcentersdk.h5.AppCenterSdkH5.g(r5, r1)
                I6.a$a r5 = r4.g(r5)
                java.lang.String r1 = r3.f29496b
                I6.a$a r5 = r5.c(r1)
                java.lang.String r1 = r3.f29495a
                I6.a$a r5 = r5.d(r1)
                I6.a$a r5 = r5.b(r0)
                java.lang.String r0 = "1"
                r5.h(r0)
                goto Lca
            Lbe:
                com.stepos.appcenter.appcentersdk.h5.AppCenterSdkH5 r4 = com.stepos.appcenter.appcentersdk.h5.AppCenterSdkH5.this
                java.lang.String r5 = r3.f29495a
                java.lang.String r0 = r3.f29496b
                java.lang.String r1 = r3.f29497c
                com.stepos.appcenter.appcentersdk.h5.AppCenterSdkH5.e(r4, r5, r0, r1)
            Lc9:
                r4 = 0
            Lca:
                if (r4 == 0) goto Le2
                java.lang.String r5 = r3.f29497c
                r4.e(r5)
                com.stepos.appcenter.appcentersdk.h5.AppCenterSdkH5 r3 = com.stepos.appcenter.appcentersdk.h5.AppCenterSdkH5.this
                android.content.Context r3 = com.stepos.appcenter.appcentersdk.h5.AppCenterSdkH5.h(r3)
                I6.b r3 = I6.b.d(r3)
                I6.a r4 = r4.a()
                r3.e(r4)
            Le2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.appcenter.appcentersdk.h5.AppCenterSdkH5.f.onCallback(int, java.lang.String):void");
        }

        public f(String str, String str2, String str3, boolean z10) {
            this.f29495a = str;
            this.f29496b = str2;
            this.f29497c = str3;
            this.f29499e = z10;
        }
    }

    public interface g {
    }

    public AppCenterSdkH5(Activity activity, g gVar) {
        AppCenterSdk appCenterSdk = AppCenterSdk.getInstance();
        this.f29469a = appCenterSdk;
        this.f29473e = activity;
        if (activity == null) {
            throw new IllegalArgumentException("AppCenterSdkH5: argument context can not be null");
        }
        appCenterSdk.init(activity);
        this.f29474f = this.f29473e.getPackageName();
        this.f29475g = new Handler(Looper.getMainLooper());
    }

    public static /* synthetic */ g a(AppCenterSdkH5 appCenterSdkH5) {
        appCenterSdkH5.getClass();
        return null;
    }

    public String doAction(String str, String str2) {
        Boolean boolValueOf;
        Log.d("AppCenterSdkH5", "doAction: action = " + str + " args = " + str2);
        boolValueOf = Boolean.TRUE;
        str.getClass();
        switch (str) {
            case "open_deeplink":
                boolValueOf = Boolean.valueOf(s(str2));
                break;
            case "perform_download_click":
                try {
                    JSONObject jSONObjectV = G1.a.v(str2);
                    String strT = jSONObjectV.T("sourceInfo");
                    if (!TextUtils.isEmpty(strT)) {
                        com.stepos.appcenter.appcentersdk.a.k().r(strT);
                    }
                    String strT2 = jSONObjectV.T("packageName");
                    if (!TextUtils.isEmpty(strT2)) {
                        this.f29469a.performDownloadClick(new AppCenterSdk.c(strT2, jSONObjectV.Q("versionCode")).a(j(strT2)), l(strT2, strT, jSONObjectV.T("q")));
                        break;
                    } else {
                        boolValueOf = Boolean.FALSE;
                        Log.e("AppCenterSdkH5", "doAction: ACTION_PERFORM_DOWNLOAD_CLICK but args is illegal!");
                        break;
                    }
                } catch (Exception unused) {
                    Log.e("AppCenterSdkH5", "doAction Fail : action :" + str + " | args = " + str2);
                    boolValueOf = Boolean.FALSE;
                    break;
                }
            case "register_global_listener":
                if (com.stepos.appcenter.appcentersdk.a.k().o()) {
                    if (!TextUtils.isEmpty(str2)) {
                        synchronized (this.f29470b) {
                            try {
                                if (this.f29470b.containsKey(Pair.create(str2, ""))) {
                                    Log.w("AppCenterSdkH5", "doAction: has already register global listener");
                                } else {
                                    e eVar = new e(str2, null);
                                    this.f29470b.put(Pair.create(str2, ""), eVar);
                                    this.f29476h.execute(new b(eVar));
                                }
                            } finally {
                            }
                        }
                        break;
                    } else {
                        Log.e("AppCenterSdkH5", "doAction: callback is null when register all package listener");
                        boolValueOf = Boolean.FALSE;
                        break;
                    }
                }
                break;
            case "register_package_listener":
                if (com.stepos.appcenter.appcentersdk.a.k().o()) {
                    try {
                        JSONObject jSONObjectV2 = G1.a.v(str2);
                        String strT3 = jSONObjectV2.T("packageName");
                        String strT4 = jSONObjectV2.T("callback");
                        int iQ = jSONObjectV2.Q("versionCode");
                        if (!TextUtils.isEmpty(strT3) && !TextUtils.isEmpty(strT4)) {
                            synchronized (this.f29470b) {
                                try {
                                    if (this.f29470b.containsKey(Pair.create(strT4, strT3))) {
                                        Log.w("AppCenterSdkH5", "doAction: has already register package listener : " + strT3 + "_" + strT4);
                                    } else {
                                        e eVar2 = new e(strT4, strT3);
                                        this.f29470b.put(Pair.create(strT4, strT3), eVar2);
                                        this.f29476h.execute(new c(strT3, iQ, eVar2));
                                        if (com.stepos.appcenter.appcentersdk.c.d(this.f29473e, strT3)) {
                                            JSONObject jSONObject = new JSONObject();
                                            jSONObject.put("packageName", strT3);
                                            eVar2.onCallback(21, jSONObject.j());
                                        }
                                    }
                                } finally {
                                }
                            }
                            break;
                        } else {
                            boolValueOf = Boolean.FALSE;
                            Log.e("AppCenterSdkH5", "doAction: packageName or callback is null when register download package listener");
                            break;
                        }
                    } catch (Exception unused2) {
                        Log.e("AppCenterSdkH5", "doAction Fail : action :" + str + " | args = " + str2);
                        boolValueOf = Boolean.FALSE;
                        break;
                    }
                }
                break;
            case "statistics":
                boolValueOf = Boolean.valueOf(r(str2));
                break;
            case "goto_detail_and_download":
                try {
                    JSONObject jSONObjectV3 = G1.a.v(str2);
                    String strT5 = jSONObjectV3.T("sourceInfo");
                    if (!TextUtils.isEmpty(strT5)) {
                        com.stepos.appcenter.appcentersdk.a.k().r(strT5);
                    }
                    String strT6 = jSONObjectV3.T("packageName");
                    int iQ2 = jSONObjectV3.Q("versionCode");
                    long jS = jSONObjectV3.S("appid");
                    String strT7 = jSONObjectV3.T("q");
                    if (com.stepos.appcenter.appcentersdk.a.k().o()) {
                        if (!TextUtils.isEmpty(strT6)) {
                            if (!com.stepos.appcenter.appcentersdk.c.d(this.f29473e, strT6)) {
                                this.f29469a.performDownloadClick(new AppCenterSdk.c(strT6, iQ2).a(j(strT6)), l(strT6, strT5, strT7));
                                String strA = com.stepos.appcenter.appcentersdk.b.a(strT6, jS, this.f29474f, com.stepos.appcenter.appcentersdk.a.k().l());
                                if (!TextUtils.isEmpty(strT7)) {
                                    strA = strA + "&q=" + strT7;
                                }
                                s(strA);
                                break;
                            } else if (!com.stepos.appcenter.appcentersdk.c.e(this.f29473e, strT6)) {
                                Log.e("AppCenterSdkH5", "doAction: launch app fail : packageName = " + strT6);
                                boolValueOf = Boolean.FALSE;
                                break;
                            } else {
                                q(strT6, jSONObjectV3.T("appid"), strT5, strT7);
                                break;
                            }
                        } else {
                            boolValueOf = Boolean.FALSE;
                            Log.e("AppCenterSdkH5", "doAction: ACTION_PERFORM_DOWNLOAD_CLICK but args is illegal!");
                            break;
                        }
                    }
                } catch (Exception unused3) {
                    Log.e("AppCenterSdkH5", "doAction Fail : action :" + str + " | args = " + str2);
                    boolValueOf = Boolean.FALSE;
                    break;
                }
                break;
        }
        return String.valueOf(boolValueOf);
    }

    public String getUUID() {
        String string = UUID.randomUUID().toString();
        return string.substring(0, 8) + string.substring(9, 13) + string.substring(14, 18) + string.substring(19, 23) + string.substring(24);
    }

    public final boolean i(String str) {
        Uri uri = Uri.parse(str);
        if (str.startsWith("appstore://tag_list") || str.startsWith("appstore://category")) {
            return !TextUtils.isEmpty(uri.getQueryParameter("url"));
        }
        return true;
    }

    public final String j(String str) {
        return k(str, false);
    }

    public final String k(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        synchronized (this.f29472d) {
            if (!z10) {
                try {
                    if (this.f29472d.containsKey(str)) {
                        return this.f29472d.get(str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            String uuid = getUUID();
            Log.d("AppCenterSdkH5", "create requestId: " + uuid);
            this.f29472d.put(str, uuid);
            return uuid;
        }
    }

    public final AppCenterSdk.Listener l(String str, String str2, String str3) {
        String str4 = str + str2 + str3;
        if (this.f29471c.containsKey(str4)) {
            return this.f29471c.get(str4);
        }
        f fVar = new f(this, str, str2, str3);
        this.f29471c.put(str4, fVar);
        return fVar;
    }

    public final void m(String str, String str2, String str3) {
        a.C0054a c0054aI = I6.a.i();
        c0054aI.g(j(str)).c(str2).d(str).b(W4.b.STEP_INSTALL).e(str3).h("0");
        I6.b.d(this.f29473e).e(c0054aI.a());
    }

    public final void n(String str, String str2, JSONObject jSONObject) {
        a.C0054a c0054aI = I6.a.i();
        str.getClass();
        if (str.equals("exposure")) {
            String strT = jSONObject.T("hor_pos");
            String strT2 = jSONObject.T("pos");
            if (!TextUtils.isEmpty(strT)) {
                strT2 = strT2 + "_" + strT;
            }
            c0054aI.b(str).c(jSONObject.T("page")).f(strT2);
            String strT3 = jSONObject.T("apkname");
            if (!TextUtils.isEmpty(strT3)) {
                c0054aI.d(strT3).g(j(strT3));
            }
        } else {
            c0054aI.b(str).c(str2);
        }
        if (jSONObject != null && jSONObject.containsKey("q")) {
            c0054aI.e(jSONObject.T("q"));
        }
        I6.b.d(this.f29473e).e(c0054aI.a());
    }

    public final void o(String str, String str2, String str3) {
        Set<String> set = mCachedOpen;
        if (set.contains(str)) {
            return;
        }
        set.add(str);
        I6.b.d(this.f29473e).e(I6.a.i().b(W4.b.STEP_INSTALL).h("3").d(str).c(str2).g(j(str)).e(str3).a());
    }

    public void onDestroy() {
        synchronized (this.f29470b) {
            try {
                if (this.f29470b.size() > 0) {
                    for (Map.Entry<Pair<String, String>, AppCenterSdk.Listener> entry : this.f29470b.entrySet()) {
                        if (entry != null) {
                            String str = (String) entry.getKey().second;
                            AppCenterSdk.Listener value = entry.getValue();
                            if (TextUtils.isEmpty(str)) {
                                this.f29469a.unRegisterGlobalListener(value);
                            } else {
                                this.f29469a.unRegisterListener(str, 0, value);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f29470b.clear();
        this.f29471c.clear();
        this.f29472d.clear();
        this.f29475g.removeCallbacksAndMessages(null);
        this.f29473e = null;
        this.f29475g = null;
        com.stepos.appcenter.appcentersdk.a.k().r(null);
    }

    public final void p(String str, String str2) {
        a.C0054a c0054aI;
        String str3;
        String str4;
        if (com.stepos.appcenter.appcentersdk.a.k().o()) {
            JSONObject jSONObject = new JSONObject();
            Uri uri = Uri.parse(str);
            String queryParameter = uri.getQueryParameter("q");
            if (str.startsWith("appstore://details")) {
                String queryParameter2 = uri.getQueryParameter("app_id");
                String queryParameter3 = uri.getQueryParameter("package_name");
                jSONObject.put("appid", queryParameter2);
                jSONObject.put("apkname", queryParameter3);
                String strJ = j(queryParameter3);
                jSONObject.put("requestId", strJ);
                c0054aI = I6.a.i();
                c0054aI.b("detail").g(strJ).d(queryParameter3).e(queryParameter).c(str2);
                str3 = "click_detail";
            } else {
                if (str.startsWith("appstore://tag_list")) {
                    jSONObject.put("name", uri.getQueryParameter("title"));
                    String queryParameter4 = uri.getQueryParameter("package_name");
                    c0054aI = I6.a.i();
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        jSONObject.put("apkname", queryParameter4);
                        String strJ2 = j(queryParameter4);
                        jSONObject.put("requestId", strJ2);
                        c0054aI.g(strJ2);
                    }
                    str4 = "click_tag";
                    c0054aI.b("click_tag").d(queryParameter4).e(queryParameter).c(str2);
                } else if (str.startsWith("appstore://category")) {
                    jSONObject.put("name", uri.getQueryParameter("title"));
                    String queryParameter5 = uri.getQueryParameter("package_name");
                    c0054aI = I6.a.i();
                    if (!TextUtils.isEmpty(queryParameter5)) {
                        jSONObject.put("apkname", queryParameter5);
                        String strJ3 = j(queryParameter5);
                        jSONObject.put("requestId", strJ3);
                        c0054aI.g(strJ3);
                    }
                    str4 = "click_category";
                    c0054aI.b("click_category").d(queryParameter5).e(queryParameter).c(str2);
                } else {
                    c0054aI = null;
                    str3 = null;
                }
                str3 = str4;
            }
            if (str3 != null) {
                jSONObject.put("source_launch_way", "sdk");
                jSONObject.put("source_info", str2);
                jSONObject.put("source_apkname", this.f29474f);
                this.f29476h.execute(new d(str3, jSONObject));
                I6.b.d(this.f29473e).e(c0054aI.a());
            }
        }
    }

    public final void q(String str, String str2, String str3, String str4) {
        if (this.f29469a == null || !com.stepos.appcenter.appcentersdk.a.k().o()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("apkname", str);
        jSONObject.put("appid", str2);
        jSONObject.put("source_info", str3);
        jSONObject.put("source_apkname", this.f29474f);
        jSONObject.put("requestId", j(str));
        jSONObject.put("source_launch_way", "sdk");
        this.f29469a.statistics("open", str3, jSONObject);
        o(str, str3, str4);
    }

    public final boolean r(String str) {
        JSONObject jSONObjectV;
        if (!com.stepos.appcenter.appcentersdk.a.k().o()) {
            return false;
        }
        try {
            JSONObject jSONObjectV2 = G1.a.v(str);
            if (!jSONObjectV2.containsKey("actionName")) {
                Log.e("AppCenterSdkH5", "doAction: actionName is null when statistics");
                return false;
            }
            String strT = jSONObjectV2.T("actionName");
            String strT2 = jSONObjectV2.T("pageName");
            jSONObjectV2.remove("actionName");
            jSONObjectV2.remove("pageName");
            try {
                jSONObjectV = G1.a.v(jSONObjectV2.T(PropertiesValidator.PROPERTY));
            } catch (Exception unused) {
                Log.w("AppCenterSdkH5", "doAction: ACTION_STATISTICS but parse properties data to JSONObject fail ");
                jSONObjectV = null;
            }
            if (jSONObjectV != null && jSONObjectV.containsKey("apkname")) {
                jSONObjectV.put("requestId", k(jSONObjectV.T("apkname"), "exposure".equals(strT)));
            }
            jSONObjectV.put("source_launch_way", "sdk");
            jSONObjectV.put("source_apkname", this.f29474f);
            n(strT, strT2, jSONObjectV);
            if (!com.stepos.appcenter.appcentersdk.a.k().o()) {
                return false;
            }
            this.f29476h.execute(new a(strT, strT2, jSONObjectV));
            return true;
        } catch (Exception unused2) {
            Log.e("AppCenterSdkH5", "onStaticEvent Fail :  args = " + str);
            return false;
        }
    }

    public final boolean s(String str) {
        Uri uri = Uri.parse(str + Const.STR_MART_ADD + "source_apkname=" + this.f29474f);
        String queryParameter = uri.getQueryParameter("source_info");
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        boolean z10 = false;
        if (intent.resolveActivity(this.f29473e.getPackageManager()) != null && i(str)) {
            if (!(this.f29473e instanceof ContextThemeWrapper)) {
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            this.f29473e.startActivity(intent);
            if (str.startsWith("appstore://details")) {
                String queryParameter2 = uri.getQueryParameter("package_name");
                AppCenterSdk.getInstance().registerListener(queryParameter2, 0, l(queryParameter2, queryParameter, uri.getQueryParameter("q")));
            }
            z10 = true;
        } else if (!str.startsWith("appstore://details") && !str.startsWith("appstore://search") && !str.startsWith("appstore://tag_list") && !str.startsWith("appstore://category")) {
            Log.w("AppCenterSdkH5", "openDeeplink: fail with unkown uriStr : " + str);
        }
        p(str, queryParameter);
        return z10;
    }
}
