package S5;

import A0.b;
import W5.c;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.stepos.ability.App;
import com.stepos.agentframework.adapter.bff.BuildConfig;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import u1.d;
import w0.C2086g;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public Q.a f1175a;
    public final C2086g b;
    public final ConcurrentHashMap c = new ConcurrentHashMap();
    public final ConcurrentHashMap d;

    public a(d dVar) throws PackageManager.NameNotFoundException {
        Bundle bundle;
        PackageInfo packageInfo;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.d = concurrentHashMap;
        long jCurrentTimeMillis = System.currentTimeMillis();
        concurrentHashMap.put(BuildConfig.BUILD_TYPE, Boolean.FALSE);
        d("stepos_ver", Build.DISPLAY);
        c.a("c", "##### Subject step 1, " + (System.currentTimeMillis() - jCurrentTimeMillis));
        Context context = (Context) dVar.b;
        if (context != null) {
            c.d("c", "setContextualParams start");
            b bVar = new b(2);
            bVar.b = context;
            this.f1175a = bVar.t();
            C2086g c2086g = new C2086g();
            c2086g.f6811a = new HashMap();
            PackageManager packageManager = context.getPackageManager();
            String strValueOf = "0";
            if (packageManager != null) {
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && bundle.get("uxip_channel_num") != null) {
                        strValueOf = String.valueOf(applicationInfo.metaData.get("uxip_channel_num"));
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    c.f("AppInfo", "Exception: " + e.toString() + " - Cause: " + e.getCause());
                }
            }
            ((HashMap) c2086g.f6811a).put("channel_id", strValueOf);
            c.e("AppInfo", "AppInfo created successfully.");
            this.b = c2086g;
            if (TextUtils.isEmpty((String) dVar.e)) {
                Context context2 = (Context) dVar.b;
                String packageName = context2.getPackageName();
                d("pkg_name", packageName);
                d("pkg_ver", T5.b.d(context2, packageName));
                c(T5.b.c(context2, packageName), "pkg_ver_code");
            } else {
                Context context3 = (Context) dVar.b;
                String str = (String) dVar.e;
                c.a("c", "### setReplacePackage, replacePackage: " + str);
                try {
                    packageInfo = context3.getPackageManager().getPackageInfo(str, 16384);
                } catch (PackageManager.NameNotFoundException e6) {
                    c.b("c", "setReplacePackage error, " + e6.getMessage());
                    packageInfo = null;
                }
                String packageName2 = context3.getPackageName();
                String strD = T5.b.d(context3, packageName2);
                String str2 = T5.b.c(context3, packageName2) + "";
                if (packageInfo != null) {
                    d("pkg_name", packageInfo.packageName);
                    d("pkg_ver", packageInfo.versionName);
                    c(packageInfo.versionCode, "pkg_ver_code");
                    c.a("c", "setReplacePackage, packageInfo: " + packageInfo);
                } else {
                    d("pkg_name", packageName2);
                    d("pkg_ver", strD);
                    d("pkg_ver_code", str2);
                }
                this.c.put("_my_pkg_name_", packageName2);
                this.c.put("_my_pkg_ver_", strD);
                this.c.put("_my_pkg_ver_code_", str2);
            }
            d("pkg_key", (String) dVar.c);
            c(0, "pkg_type");
            d("sdk_ver", (String) dVar.d);
        }
        c.a("c", "##### Subject step 2, " + (System.currentTimeMillis() - jCurrentTimeMillis));
        c.a("c", "Subject created successfully.");
    }

    public static a a(App app, String str, String str2) {
        c.d("c", "buildSubject start， replacePackage: ");
        if (TextUtils.isEmpty("")) {
            d dVar = new d(3);
            dVar.b = app;
            dVar.c = str;
            dVar.d = str2;
            return new a(dVar);
        }
        d dVar2 = new d(3);
        dVar2.b = app;
        dVar2.c = str;
        dVar2.d = str2;
        dVar2.e = "";
        return new a(dVar2);
    }

    public static HashMap b(Context context) {
        String strB;
        HashMap map = new HashMap();
        Double dValueOf = Double.valueOf(0.0d);
        map.put("longitude", dValueOf);
        map.put("latitude", dValueOf);
        map.put("loc_time", 0L);
        map.put("operator", "");
        map.put("stepos_uid", "");
        if (TextUtils.isEmpty(T5.b.g)) {
            Locale locale = context.getResources().getConfiguration().locale;
            String language = locale.getLanguage();
            String country = locale.getCountry();
            if (language == null) {
                language = "";
            }
            strB = B7.a.B(language, "_", country != null ? country : "");
            T5.b.g = strB;
        } else {
            strB = T5.b.g;
        }
        map.put("lla", strB);
        c.a("c", "getVolatileProperty ..." + map);
        return map;
    }

    public final void c(int i, String str) {
        if (str.isEmpty()) {
            return;
        }
        this.d.put(str, Integer.valueOf(i));
    }

    public final void d(String str, String str2) {
        if (str.isEmpty() || str2 == null) {
            return;
        }
        this.d.put(str, str2);
    }
}
