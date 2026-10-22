package c3;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import c3.C0583a;
import c3.b;
import d3.C0671g;
import g3.C0742e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class c {

    /* renamed from: e, reason: collision with root package name */
    private static final String f11966e = "c";

    /* renamed from: a, reason: collision with root package name */
    private c3.b f11967a;

    /* renamed from: b, reason: collision with root package name */
    private C0583a f11968b;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f11969c;

    /* renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<String, Object> f11970d;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private Context f11971a = null;

        /* renamed from: b, reason: collision with root package name */
        private String f11972b;

        /* renamed from: c, reason: collision with root package name */
        private int f11973c;

        /* renamed from: d, reason: collision with root package name */
        private String f11974d;

        /* renamed from: e, reason: collision with root package name */
        private String f11975e;

        public b b(int i5) {
            this.f11973c = i5;
            return this;
        }

        public b c(Context context) {
            this.f11971a = context;
            return this;
        }

        public b d(String str) {
            this.f11972b = str;
            return this;
        }

        public c e() {
            return new c(this);
        }

        public b f(String str) {
            this.f11975e = str;
            return this;
        }

        public b h(String str) {
            this.f11974d = str;
            return this;
        }
    }

    public static c a(Context context, String str, int i5, String str2) {
        String str3 = Q2.a.f4906b;
        C0742e.i(f11966e, "buildSubject start， replacePackage: " + str3);
        return TextUtils.isEmpty(str3) ? new b().c(context).d(str).b(i5).h(str2).e() : new b().c(context).d(str).b(i5).h(str2).f(str3).e();
    }

    private void d(int i5) {
        g("pkg_type", i5);
    }

    private void e(Context context, String str) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        C0742e.c(f11966e, "### setReplacePackage, replacePackage: " + str);
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (PackageManager.NameNotFoundException e6) {
            C0742e.d(f11966e, "setReplacePackage error, " + e6.getMessage());
            packageInfo = null;
        }
        String packageName = context.getPackageName();
        String strH = C0671g.h(packageName, context);
        String str2 = C0671g.g(packageName, context) + BuildConfig.FLAVOR;
        if (packageInfo != null) {
            h("pkg_name", packageInfo.packageName);
            h("pkg_ver", packageInfo.versionName);
            g("pkg_ver_code", packageInfo.versionCode);
            C0742e.c(f11966e, "setReplacePackage, packageInfo: " + packageInfo);
        } else {
            h("pkg_name", packageName);
            h("pkg_ver", strH);
            h("pkg_ver_code", str2);
        }
        this.f11969c.put("_my_pkg_name_", packageName);
        this.f11969c.put("_my_pkg_ver_", strH);
        this.f11969c.put("_my_pkg_ver_code_", str2);
    }

    private void f(String str) {
        h("pkg_key", str);
    }

    private void g(String str, int i5) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f11970d.put(str, Integer.valueOf(i5));
    }

    private void h(String str, String str2) {
        if (str == null || str.isEmpty() || str2 == null) {
            return;
        }
        this.f11970d.put(str, str2);
    }

    private void i(String str, boolean z5) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f11970d.put(str, Boolean.valueOf(z5));
    }

    private void m(String str) {
        h("sdk_ver", str);
    }

    private void q(Context context) {
        String packageName = context.getPackageName();
        h("pkg_name", packageName);
        h("pkg_ver", C0671g.h(packageName, context));
        g("pkg_ver_code", C0671g.g(packageName, context));
    }

    private void r() {
        i("debug", false);
    }

    private void s() {
        h("stepos_ver", Build.DISPLAY);
    }

    public Map<String, Object> b() {
        return this.f11968b.b();
    }

    public Map<String, Object> c(Context context) {
        HashMap map = new HashMap();
        map.put("longitude", Double.valueOf(O2.b.i()));
        map.put("latitude", Double.valueOf(O2.b.h()));
        map.put("loc_time", Long.valueOf(O2.b.j()));
        map.put("operator", O2.b.m());
        map.put("stepos_uid", O2.b.n());
        map.put("lla", C0671g.f(context));
        C0742e.c(f11966e, "getVolatileProperty ..." + map);
        return map;
    }

    public void j(Map<String, String> map) {
        if (map == null) {
            this.f11969c = new ConcurrentHashMap<>();
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null && !key.isEmpty() && value != null) {
                this.f11969c.put(key, value);
            }
        }
    }

    public void k(boolean z5) {
        i("debug", z5);
    }

    public Map<String, Object> l() {
        return this.f11967a.a();
    }

    public Map<String, Object> n() {
        return this.f11969c;
    }

    public void o(Context context) {
        C0742e.i(f11966e, "setContextualParams start");
        this.f11967a = new b.C0157b().b(context).c();
        this.f11968b = new C0583a.b().b(context).c();
    }

    public Map<String, Object> p() {
        return this.f11970d;
    }

    private c(b bVar) throws PackageManager.NameNotFoundException {
        this.f11969c = new ConcurrentHashMap<>();
        this.f11970d = new ConcurrentHashMap<>();
        long jCurrentTimeMillis = System.currentTimeMillis();
        r();
        s();
        String str = f11966e;
        C0742e.c(str, "##### Subject step 1, " + (System.currentTimeMillis() - jCurrentTimeMillis));
        if (bVar.f11971a != null) {
            o(bVar.f11971a);
            if (TextUtils.isEmpty(bVar.f11975e)) {
                q(bVar.f11971a);
            } else {
                e(bVar.f11971a, bVar.f11975e);
            }
            f(bVar.f11972b);
            d(bVar.f11973c);
            m(bVar.f11974d);
        }
        C0742e.c(str, "##### Subject step 2, " + (System.currentTimeMillis() - jCurrentTimeMillis));
        C0742e.c(str, "Subject created successfully.");
    }
}
