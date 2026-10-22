package com.stepos.digitalwellbeing.utils;

import R1.a;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import f2.C0702g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

/* loaded from: classes.dex */
public class PackageUtils {

    /* renamed from: h, reason: collision with root package name */
    private static PackageUtils f14709h;

    /* renamed from: a, reason: collision with root package name */
    private long f14715a;

    /* renamed from: b, reason: collision with root package name */
    private final List<String> f14716b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final List<String> f14717c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, AppInfo> f14718d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, AppInfo> f14719e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private final PackageManager f14720f;

    /* renamed from: g, reason: collision with root package name */
    private static final boolean f14708g = a.f("PackageUtils", a.f4966b);

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f14710i = {"com.stepos.familyguard", "com.stepos.safe", "com.android.dialer", "com.android.mms", "com.android.alarmclock", "com.android.settings", "com.stepos.launcher", "com.android.launcher3", "com.stepos.alivewallpaper", "com.android.systemui", "com.android.phone", "com.stepos.update", "com.stepos.netcontactservice", "com.android.incallui", "com.stepos.callsetting", "com.android.server.telecom", "com.stepos.steposbasestationsafe", "com.sohu.inputmethod.sogou.stepos", "com.stepos.alphame", "com.stepos.media.camera", "com.stepos.voiceassistant", "com.stabilitytest.sysmonkey", "com.stepos.logreport", "com.stepos.scheduledpower"};

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f14711j = {"com.stepos.familyguard", "com.android.alarmclock"};

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f14712k = {"com.stepos.suggestion", "com.stepos.assistant"};

    /* renamed from: l, reason: collision with root package name */
    public static final String[] f14713l = {"com.stepos.familyguard"};

    /* renamed from: m, reason: collision with root package name */
    private static final String[] f14714m = {"com.android.permissioncontroller", "com.android.captiveportallogin", "com.stepos.connectivitysettings", "com.android.packageinstaller", "com.stepos.setup", "com.stepos.safe", "com.stepos.feedback"};

    public static class AppInfo {
        public String iconUrl;
        public String iconUrlF8;
        public String label;
        public String packageName;
        public boolean system;

        public String toString() {
            return "AppInfo{packageName='" + this.packageName + "', label='" + this.label + "', iconUrl='" + this.iconUrl + "', iconUrlF8='" + this.iconUrlF8 + "', system=" + this.system + '}';
        }
    }

    private PackageUtils(Context context) {
        this.f14720f = context.getPackageManager();
    }

    private void a(Set<String> set) {
        String[] strArr = {"minors_mode_enabled_turn_on", "minors_mode_enabled_turn_off"};
        for (int i5 = 0; i5 < 2; i5++) {
            try {
                List<ResolveInfo> listQueryBroadcastReceivers = this.f14720f.queryBroadcastReceivers(new Intent(strArr[i5]), 128);
                if (listQueryBroadcastReceivers != null) {
                    Iterator<ResolveInfo> it = listQueryBroadcastReceivers.iterator();
                    while (it.hasNext()) {
                        ActivityInfo activityInfo = it.next().activityInfo;
                        if (activityInfo != null) {
                            set.add(activityInfo.packageName);
                        }
                    }
                }
            } catch (RuntimeException e6) {
                a.l("PackageUtils", "queryBroadcastReceivers failed: " + e6.getMessage());
            }
        }
    }

    private synchronized void c() {
        d(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0129  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d(boolean r11) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.digitalwellbeing.utils.PackageUtils.d(boolean):void");
    }

    private void e() {
        for (String str : f14713l) {
            if (!this.f14716b.contains(str)) {
                this.f14716b.add(str);
            }
        }
    }

    public static PackageUtils h(Context context) {
        if (f14709h == null) {
            f14709h = new PackageUtils(context);
        }
        return f14709h;
    }

    public static boolean q(String str) {
        return TextUtils.equals(str, "screen_off") || TextUtils.equals(str, "screen_locked");
    }

    public static boolean r(long j5, long j6) {
        if (j5 <= 0) {
            return false;
        }
        if (j5 >= 3000000) {
            return true;
        }
        return j6 >= 2700000 && j5 * 100 >= j6 * 85;
    }

    public static boolean s(long j5, long j6, long j7) {
        return t(j5, j6, j7);
    }

    public static boolean t(long j5, long j6, long j7) {
        if (j5 < 3600000) {
            return false;
        }
        long jMax = Math.max(0L, System.currentTimeMillis() - j7);
        if (jMax < 3600000) {
            return false;
        }
        return ((Math.abs(j5 - jMax) > 120000L ? 1 : (Math.abs(j5 - jMax) == 120000L ? 0 : -1)) <= 0 || (j5 > ((jMax * 9) / 10) ? 1 : (j5 == ((jMax * 9) / 10) ? 0 : -1)) >= 0) && ((j6 > 0L ? 1 : (j6 == 0L ? 0 : -1)) >= 0 && (j6 > 1800000L ? 1 : (j6 == 1800000L ? 0 : -1)) < 0 && ((j6 * 10) > j5 ? 1 : ((j6 * 10) == j5 ? 0 : -1)) < 0);
    }

    public static boolean u(String str) {
        return TextUtils.equals(str, "com.stepos.launcher") || TextUtils.equals(str, "com.android.launcher3") || TextUtils.equals(str, "com.youdao.hardware.panda");
    }

    public static boolean v(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : f14714m) {
            if (TextUtils.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    private List<ResolveInfo> w(Intent intent, int i5) {
        try {
            List<ResolveInfo> listQueryIntentActivities = this.f14720f.queryIntentActivities(intent, i5);
            return listQueryIntentActivities != null ? listQueryIntentActivities : new ArrayList();
        } catch (RuntimeException e6) {
            a.l("PackageUtils", "queryIntentActivities failed: " + e6.getMessage());
            return null;
        }
    }

    private void x() {
        Bundle bundle;
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> listW = w(intent, 128);
        if (listW == null) {
            return;
        }
        this.f14717c.clear();
        HashSet hashSet = new HashSet();
        for (ResolveInfo resolveInfo : listW) {
            if (!TextUtils.equals(resolveInfo.activityInfo.packageName, "com.stepos.update") && !u(resolveInfo.activityInfo.packageName) && (bundle = resolveInfo.activityInfo.metaData) != null && bundle.getInt("support_minors_mode", 0) == 1) {
                hashSet.add(resolveInfo.activityInfo.packageName);
            }
        }
        a(hashSet);
        try {
            for (ApplicationInfo applicationInfo : this.f14720f.getInstalledApplications(128)) {
                Bundle bundle2 = applicationInfo.metaData;
                if (bundle2 != null && bundle2.getInt("support_minors_mode", 0) == 1) {
                    hashSet.add(applicationInfo.packageName);
                }
            }
        } catch (RuntimeException e6) {
            a.l("PackageUtils", "getInstalledApplications failed: " + e6.getMessage());
        }
        this.f14717c.addAll(hashSet);
        this.f14715a = SystemClock.elapsedRealtime();
        Log.i("PackageUtils", "refreshMinorModeSensitivePackages size = " + this.f14717c.size());
    }

    public synchronized void A() {
        d(true);
    }

    public synchronized boolean B(String str) {
        if (v(str)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : f14713l) {
            if (TextUtils.equals(str, str2)) {
                return false;
            }
        }
        c();
        if (this.f14716b.contains(str)) {
            return false;
        }
        AppInfo appInfo = this.f14719e.get(str);
        if (appInfo != null) {
            return appInfo.system;
        }
        try {
            return (this.f14720f.getApplicationInfo(str, 0).flags & 1) != 0;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public synchronized void b() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!this.f14717c.isEmpty()) {
            long j5 = this.f14715a;
            if (j5 > 0 && jElapsedRealtime - j5 < 1800000) {
                return;
            }
        }
        x();
    }

    public synchronized List<String> f() {
        c();
        return new ArrayList(this.f14719e.keySet());
    }

    public synchronized List<String> g() {
        c();
        return new ArrayList(this.f14718d.keySet());
    }

    public synchronized AppInfo i(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        c();
        AppInfo appInfo = this.f14718d.get(str);
        if (appInfo != null) {
            return appInfo;
        }
        AppInfo appInfo2 = this.f14719e.get(str);
        if (appInfo2 != null) {
            return appInfo2;
        }
        try {
            ApplicationInfo applicationInfo = this.f14720f.getApplicationInfo(str, 0);
            AppInfo appInfo3 = new AppInfo();
            appInfo3.packageName = str;
            appInfo3.label = applicationInfo.loadLabel(this.f14720f).toString();
            appInfo3.system = (applicationInfo.flags & 1) != 0;
            this.f14719e.put(str, appInfo3);
            return appInfo3;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public synchronized List<AppInfo> j() {
        ArrayList arrayList;
        c();
        arrayList = new ArrayList();
        for (String str : this.f14718d.keySet()) {
            if (p(str)) {
                arrayList.add(this.f14718d.get(str));
            }
        }
        return arrayList;
    }

    public synchronized List<String> k() {
        c();
        return new ArrayList(this.f14716b);
    }

    public synchronized List<String> l() {
        return new ArrayList(this.f14717c);
    }

    public synchronized AppInfo m(String str) {
        c();
        return this.f14718d.get(str);
    }

    public synchronized List<AppInfo> n() {
        c();
        return new ArrayList(this.f14718d.values());
    }

    public synchronized boolean o(String str) {
        c();
        return this.f14718d.containsKey(str);
    }

    public synchronized boolean p(String str) {
        c();
        return this.f14716b.contains(str);
    }

    public synchronized void y() {
        this.f14718d.clear();
        this.f14719e.clear();
        this.f14716b.clear();
        C0702g.b("PackageUtils", "releaseHeavyCaches");
    }

    public synchronized void z(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        List<String> list = this.f14716b;
        Objects.requireNonNull(str);
        list.removeIf(new Predicate() { // from class: f2.h
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return str.equals((String) obj);
            }
        });
        this.f14717c.removeIf(new Predicate() { // from class: f2.h
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return str.equals((String) obj);
            }
        });
        this.f14718d.remove(str);
        this.f14719e.remove(str);
        C0702g.b("PackageUtils", "removeCachedPackage pkg=" + str);
    }
}
