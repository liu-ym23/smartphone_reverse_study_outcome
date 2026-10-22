package com.stepos.statsapp.v3.lib.plugin.tracker.subject;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.stepos.personal.info.PersonalInfoHelper;
import com.stepos.statsapp.v3.InitConfig;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.tracker.subject.a;
import com.stepos.statsapp.v3.lib.plugin.tracker.subject.b;
import com.stepos.statsapp.v3.lib.plugin.utils.StepOSUtils;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: e, reason: collision with root package name */
    private static final String f30996e = "c";

    /* renamed from: a, reason: collision with root package name */
    private com.stepos.statsapp.v3.lib.plugin.tracker.subject.b f30997a;

    /* renamed from: b, reason: collision with root package name */
    private com.stepos.statsapp.v3.lib.plugin.tracker.subject.a f30998b;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f30999c;

    /* renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<String, Object> f31000d;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private Context f31001a = null;

        /* renamed from: b, reason: collision with root package name */
        private String f31002b;

        /* renamed from: c, reason: collision with root package name */
        private int f31003c;

        /* renamed from: d, reason: collision with root package name */
        private String f31004d;

        /* renamed from: e, reason: collision with root package name */
        private String f31005e;

        public b a(Context context) {
            this.f31001a = context;
            return this;
        }

        public b b(String str) {
            this.f31005e = str;
            return this;
        }

        public b c(String str) {
            this.f31004d = str;
            return this;
        }

        public b a(String str) {
            this.f31002b = str;
            return this;
        }

        public b a(int i10) {
            this.f31003c = i10;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }

    private void b(String str) {
        a(Parameters.SDK_VER, str);
    }

    private void d(Context context) {
        String packageName = context.getPackageName();
        a(Parameters.PKG_NAME, packageName);
        a(Parameters.PKG_VER, StepOSUtils.getPackageVersion(packageName, context));
        a(Parameters.PKG_VER_CODE, StepOSUtils.getPackageCode(packageName, context));
    }

    private void e() {
        a(Parameters.DEBUG, false);
    }

    private void f() {
        a(Parameters.STEPOS_VER, Build.DISPLAY);
    }

    public void a(boolean z10) {
        a(Parameters.DEBUG, z10);
    }

    public void c(Context context) {
        Logger.i(f30996e, "setContextualParams start");
        this.f30997a = new b.C0372b().a(context).a();
        this.f30998b = new a.b().a(context).a();
    }

    private c(b bVar) throws PackageManager.NameNotFoundException {
        this.f30999c = new ConcurrentHashMap<>();
        this.f31000d = new ConcurrentHashMap<>();
        long jCurrentTimeMillis = System.currentTimeMillis();
        e();
        f();
        String str = f30996e;
        Logger.d(str, "##### Subject step 1, " + (System.currentTimeMillis() - jCurrentTimeMillis));
        if (bVar.f31001a != null) {
            c(bVar.f31001a);
            if (TextUtils.isEmpty(bVar.f31005e)) {
                d(bVar.f31001a);
            } else {
                a(bVar.f31001a, bVar.f31005e);
            }
            a(bVar.f31002b);
            a(bVar.f31003c);
            b(bVar.f31004d);
        }
        Logger.d(str, "##### Subject step 2, " + (System.currentTimeMillis() - jCurrentTimeMillis));
        Logger.d(str, "Subject created successfully.");
    }

    private void a(Context context, String str) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        Logger.d(f30996e, "### setReplacePackage, replacePackage: " + str);
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (PackageManager.NameNotFoundException e10) {
            Logger.e(f30996e, "setReplacePackage error, " + e10.getMessage());
            packageInfo = null;
        }
        String packageName = context.getPackageName();
        String packageVersion = StepOSUtils.getPackageVersion(packageName, context);
        String str2 = StepOSUtils.getPackageCode(packageName, context) + "";
        if (packageInfo != null) {
            a(Parameters.PKG_NAME, packageInfo.packageName);
            a(Parameters.PKG_VER, packageInfo.versionName);
            a(Parameters.PKG_VER_CODE, packageInfo.versionCode);
            Logger.d(f30996e, "setReplacePackage, packageInfo: " + packageInfo);
        } else {
            a(Parameters.PKG_NAME, packageName);
            a(Parameters.PKG_VER, packageVersion);
            a(Parameters.PKG_VER_CODE, str2);
        }
        this.f30999c.put("_my_pkg_name_", packageName);
        this.f30999c.put("_my_pkg_ver_", packageVersion);
        this.f30999c.put("_my_pkg_ver_code_", str2);
    }

    public void b(Context context) {
        this.f30997a = new b.C0372b().a(context).a();
    }

    public Map<String, Object> b() {
        return this.f30997a.a();
    }

    public Map<String, Object> c() {
        return this.f30999c;
    }

    public Map<String, Object> d() {
        return this.f31000d;
    }

    private void a(String str) {
        a(Parameters.PKG_KEY, str);
    }

    private void a(int i10) {
        a(Parameters.PKG_TYPE, i10);
    }

    private void a(String str, String str2) {
        if (str == null || str.isEmpty() || str2 == null) {
            return;
        }
        this.f31000d.put(str, str2);
    }

    private void a(String str, int i10) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f31000d.put(str, Integer.valueOf(i10));
    }

    private void a(String str, boolean z10) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.f31000d.put(str, Boolean.valueOf(z10));
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            this.f30999c = new ConcurrentHashMap<>();
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null && !key.isEmpty() && value != null) {
                this.f30999c.put(key, value);
            }
        }
    }

    public Map<String, Object> a(Context context) {
        HashMap map = new HashMap();
        map.put(Parameters.LONGITUDE, Double.valueOf(PersonalInfoHelper.getLocationLongitude()));
        map.put(Parameters.LATITUDE, Double.valueOf(PersonalInfoHelper.getLocationLatitude()));
        map.put(Parameters.LOC_TIME, Long.valueOf(PersonalInfoHelper.getLocationTime()));
        map.put(Parameters.OPERATOR, PersonalInfoHelper.getOperator());
        map.put(Parameters.STEPOS_UID, PersonalInfoHelper.getStepOSUid());
        map.put(Parameters.LLA, StepOSUtils.getLocationLanguage(context));
        Logger.d(f30996e, "getVolatileProperty ..." + map);
        return map;
    }

    public Map<String, Object> a() {
        return this.f30998b.a();
    }

    public static c a(Context context, String str, int i10, String str2) {
        String str3 = InitConfig.replacePackage;
        Logger.i(f30996e, "buildSubject start， replacePackage: " + str3);
        if (TextUtils.isEmpty(str3)) {
            return new b().a(context).a(str).a(i10).c(str2).a();
        }
        return new b().a(context).a(str).a(i10).c(str2).b(str3).a();
    }
}
