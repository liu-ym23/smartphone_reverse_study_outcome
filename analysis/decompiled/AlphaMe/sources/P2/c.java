package P2;

import T2.d;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.BuildConfig;
import com.stepos.alphame.suggest.AppSuggestStorable;
import j.C0622a;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final a f1581a;

    /* renamed from: b, reason: collision with root package name */
    public final a f1582b;

    /* renamed from: c, reason: collision with root package name */
    public ConcurrentHashMap f1583c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap f1584d;

    public c(b bVar) throws PackageManager.NameNotFoundException {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.f1584d = concurrentHashMap;
        long jCurrentTimeMillis = System.currentTimeMillis();
        concurrentHashMap.put(BuildConfig.BUILD_TYPE, Boolean.FALSE);
        d("stepos_ver", Build.DISPLAY);
        d.a("c", "##### Subject step 1, " + (System.currentTimeMillis() - jCurrentTimeMillis));
        Context context = bVar.f1576a;
        if (context != null) {
            d.d("c", "setContextualParams start");
            C0622a c0622a = new C0622a(4);
            c0622a.f13046b = context;
            PackageInfo packageInfo = null;
            this.f1581a = new a(c0622a, (Object) null);
            C0622a c0622a2 = new C0622a(3);
            c0622a2.f13046b = context;
            this.f1582b = new a(c0622a2, 0);
            if (TextUtils.isEmpty((String) bVar.f1580e)) {
                Context context2 = bVar.f1576a;
                String packageName = context2.getPackageName();
                d(AppSuggestStorable.COLUMN_PKG_NAME, packageName);
                d("pkg_ver", Q2.c.c(context2, packageName));
                c("pkg_ver_code", Q2.c.b(context2, packageName));
            } else {
                Context context3 = bVar.f1576a;
                String str = (String) bVar.f1580e;
                d.a("c", "### setReplacePackage, replacePackage: " + str);
                try {
                    packageInfo = context3.getPackageManager().getPackageInfo(str, 16384);
                } catch (PackageManager.NameNotFoundException e4) {
                    d.b("c", "setReplacePackage error, " + e4.getMessage());
                }
                String packageName2 = context3.getPackageName();
                String strC = Q2.c.c(context3, packageName2);
                String str2 = Q2.c.b(context3, packageName2) + "";
                if (packageInfo != null) {
                    d(AppSuggestStorable.COLUMN_PKG_NAME, packageInfo.packageName);
                    d("pkg_ver", packageInfo.versionName);
                    c("pkg_ver_code", packageInfo.versionCode);
                    d.a("c", "setReplacePackage, packageInfo: " + packageInfo);
                } else {
                    d(AppSuggestStorable.COLUMN_PKG_NAME, packageName2);
                    d("pkg_ver", strC);
                    d("pkg_ver_code", str2);
                }
                this.f1583c.put("_my_pkg_name_", packageName2);
                this.f1583c.put("_my_pkg_ver_", strC);
                this.f1583c.put("_my_pkg_ver_code_", str2);
            }
            d("pkg_key", (String) bVar.f1578c);
            c("pkg_type", bVar.f1577b);
            d("sdk_ver", (String) bVar.f1579d);
        }
        d.a("c", "##### Subject step 2, " + (System.currentTimeMillis() - jCurrentTimeMillis));
        d.a("c", "Subject created successfully.");
    }

    public static c a(Application application, String str, int i4, String str2) {
        d.d("c", "buildSubject start， replacePackage: ");
        if (TextUtils.isEmpty("")) {
            b bVar = new b();
            bVar.f1576a = application;
            bVar.f1578c = str;
            bVar.f1577b = i4;
            bVar.f1579d = str2;
            return new c(bVar);
        }
        b bVar2 = new b();
        bVar2.f1576a = application;
        bVar2.f1578c = str;
        bVar2.f1577b = i4;
        bVar2.f1579d = str2;
        bVar2.f1580e = "";
        return new c(bVar2);
    }

    public static HashMap b(Context context) {
        String strQ;
        HashMap map = new HashMap();
        Double dValueOf = Double.valueOf(0.0d);
        map.put(AppSuggestStorable.COLUMN_LONGITUDE, dValueOf);
        map.put(AppSuggestStorable.COLUMN_LATITUDE, dValueOf);
        map.put("loc_time", 0L);
        map.put("operator", "");
        map.put("stepos_uid", "");
        if (TextUtils.isEmpty(Q2.c.f1653f)) {
            Locale locale = context.getResources().getConfiguration().locale;
            String language = locale.getLanguage();
            String country = locale.getCountry();
            if (language == null) {
                language = "";
            }
            strQ = AbstractC0351g.q(language, "_", country != null ? country : "");
            Q2.c.f1653f = strQ;
        } else {
            strQ = Q2.c.f1653f;
        }
        map.put("lla", strQ);
        d.a("c", "getVolatileProperty ..." + map);
        return map;
    }

    public final void c(String str, int i4) {
        if (str.isEmpty()) {
            return;
        }
        this.f1584d.put(str, Integer.valueOf(i4));
    }

    public final void d(String str, String str2) {
        if (str.isEmpty() || str2 == null) {
            return;
        }
        this.f1584d.put(str, str2);
    }
}
