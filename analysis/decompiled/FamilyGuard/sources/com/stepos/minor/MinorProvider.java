package com.stepos.minor;

import C2.d;
import C2.j;
import F2.e;
import F2.g;
import F2.y;
import I2.b;
import Y1.u;
import android.app.ActivityManager;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.digitalwellbeing.appwidget.AppWidgetManagerService;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import f2.C0702g;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class MinorProvider extends ContentProvider {

    /* renamed from: d, reason: collision with root package name */
    public static final Uri f15365d = Uri.parse("content://com.stepos.familyguard.MinorProvider/minors");

    /* renamed from: e, reason: collision with root package name */
    public static final Uri f15366e = Uri.parse("content://com.stepos.familyguard.MinorProvider/minors/#");

    /* renamed from: f, reason: collision with root package name */
    public static final Uri f15367f = Uri.parse("content://com.stepos.familyguard.MinorProvider/active_minor");

    /* renamed from: g, reason: collision with root package name */
    public static final Uri f15368g = Uri.parse("content://com.stepos.familyguard.MinorProvider/minor_mode");

    /* renamed from: h, reason: collision with root package name */
    public static final Uri f15369h = Uri.parse("content://com.stepos.familyguard.MinorProvider/whitelist");

    /* renamed from: i, reason: collision with root package name */
    public static final Uri f15370i = Uri.parse("content://com.stepos.familyguard.MinorProvider/has_password");

    /* renamed from: j, reason: collision with root package name */
    private static final UriMatcher f15371j;

    /* renamed from: k, reason: collision with root package name */
    private static final String f15372k;

    /* renamed from: a, reason: collision with root package name */
    private MinorDataBase f15373a;

    /* renamed from: b, reason: collision with root package name */
    private Context f15374b;

    /* renamed from: c, reason: collision with root package name */
    private ContentResolver f15375c;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f15371j = uriMatcher;
        f15372k = "has_minor_".concat(q());
        uriMatcher.addURI("com.stepos.familyguard.MinorProvider", "minors", 1);
        uriMatcher.addURI("com.stepos.familyguard.MinorProvider", "whitelist", 4);
        uriMatcher.addURI("com.stepos.familyguard.MinorProvider", "minors/#", 2);
        uriMatcher.addURI("com.stepos.familyguard.MinorProvider", "minor_mode", 5);
        uriMatcher.addURI("com.stepos.familyguard.MinorProvider", "active_minor", 3);
        uriMatcher.addURI("com.stepos.familyguard.MinorProvider", "has_password", 6);
    }

    private static void a(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        int i5 = Settings.Secure.getInt(contentResolver, "minors_mode_enabled", 0);
        long j5 = Settings.Secure.getLong(contentResolver, "active_minor_id", -1L);
        if (k(i5, j5)) {
            AppWidgetManagerService.n(context);
            return;
        }
        C0702g.O("MinorProvider", "skip widget update, minor env not settled mode=" + i5 + " minorId=" + j5);
    }

    public static long b(Context context) {
        return Settings.Secure.getLong(context.getContentResolver(), "active_minor_id", -1L);
    }

    private static String c(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(1)) != null && !runningTasks.isEmpty() && runningTasks.get(0).topActivity != null) {
                return runningTasks.get(0).topActivity.getPackageName();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private Bundle d(String str, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (TextUtils.equals("setSelectMinor", str)) {
            if (bundle != null) {
                bundle2.putBoolean("result", f(bundle.getLong(Minor.COLUMN_ID), bundle.getBoolean("active")));
                return bundle2;
            }
            bundle2.putBoolean("result", false);
            return bundle2;
        }
        if (!TextUtils.equals("setMinorMode", str)) {
            bundle2.putBoolean("result", false);
            return bundle2;
        }
        if (bundle != null) {
            bundle2.putBoolean("result", e(bundle.getBoolean("on")));
            return bundle2;
        }
        bundle2.putBoolean("result", false);
        return bundle2;
    }

    private boolean e(boolean z5) {
        e eVarT = this.f15373a.t();
        return (eVarT.g() != null) != z5 && y.G0(this.f15374b, eVarT, z5) > 0;
    }

    private boolean f(long j5, boolean z5) {
        Cursor cursorE = this.f15373a.t().e(j5);
        if (cursorE != null) {
            try {
                if (cursorE.getCount() != 0) {
                    cursorE.close();
                    e eVarT = this.f15373a.t();
                    return z5 ? y.a0(this.f15374b, eVarT, j5) > 0 : y.b0(this.f15374b, eVarT, j5) > 0;
                }
            } catch (Throwable th) {
                try {
                    cursorE.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (cursorE != null) {
            cursorE.close();
        }
        return false;
    }

    private static boolean g(long j5) {
        return j5 > 0 && j5 < 255;
    }

    public static boolean h(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "minors_mode_enabled", 0) == 1;
    }

    private static boolean i(Context context, String str) throws PackageManager.NameNotFoundException {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean j(Context context, String str) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            activityManager = (ActivityManager) context.getSystemService("activity");
        } catch (Exception unused) {
        }
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo != null) {
                if (TextUtils.equals(str, runningAppProcessInfo.processName)) {
                    return true;
                }
                String[] strArr = runningAppProcessInfo.pkgList;
                if (strArr != null) {
                    for (String str2 : strArr) {
                        if (TextUtils.equals(str, str2)) {
                            return true;
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    private static boolean k(int i5, long j5) {
        return (i5 == 1) == ((j5 > 0L ? 1 : (j5 == 0L ? 0 : -1)) > 0);
    }

    public static void l(Context context, long j5, long j6, int i5) {
        C0702g.b("MinorProvider", "notifyActiveChanged() called with: oldActive = [" + j5 + "], newActive = [" + j6 + "]");
        ContentResolver contentResolver = context.getContentResolver();
        Settings.Secure.putInt(contentResolver, "minors_mode_age_range", i5);
        Settings.Secure.putLong(contentResolver, "active_minor_id", j6);
        u(context, j5, j6, i5);
        a(context);
    }

    public static void m(Context context, long[] jArr) {
        C0702g.b("MinorProvider", "notifyMinorDelete() called with: deletedMinorArray = " + C0702g.g(jArr));
        w(context, jArr);
        context.getContentResolver().notifyChange(f15365d, null);
    }

    public static void n(Context context) {
        context.getContentResolver().notifyChange(f15365d, null);
    }

    public static void o(Context context, boolean z5) {
        ContentResolver contentResolver = context.getContentResolver();
        C0702g.b("MinorProvider", "notifyModeChanged() called with: minorsModeEnabled = [" + z5 + "]");
        contentResolver.notifyChange(f15368g, null);
        Settings.Secure.putInt(contentResolver, "minors_mode_enabled", z5 ? 1 : 0);
        Settings.Secure.putInt(contentResolver, "minors_mode", z5 ? 1 : 0);
        j.b(context, z5);
        x(context, z5 ? 1 : 0);
        a(context);
    }

    private static List<String> p(List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        if (arrayList.remove("com.tencent.mm")) {
            Log.i("MinorProvider", "skip WeChat mode broadcast, use Settings.Secure");
        }
        return arrayList;
    }

    private static String q() {
        return "password";
    }

    private static long r(Context context, int i5) {
        if (i5 == 0) {
            return -1L;
        }
        long jB = b(context);
        if (g(jB)) {
            return jB;
        }
        Minor minorG = g.a(context).b().t().g();
        if (minorG != null) {
            return minorG.getId();
        }
        Minor minorM = g.a(context).b().t().m();
        if (minorM == null) {
            return -1L;
        }
        return minorM.getId();
    }

    private static int s(Context context, int i5, long j5) {
        Minor minorD;
        if (i5 == 0) {
            return 0;
        }
        int i6 = Settings.Secure.getInt(context.getContentResolver(), "minors_mode_age_range", 0);
        if (i6 > 0) {
            return i6;
        }
        if (g(j5) && (minorD = g.a(context).b().t().d(j5)) != null) {
            return minorD.getAgeRange();
        }
        return 0;
    }

    private static void t(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (context == null || !i(context, "com.tencent.mm")) {
            return;
        }
        if (TextUtils.equals("com.tencent.mm", c(context))) {
            Log.i("MinorProvider", "skip force-stop WeChat after off, currently foreground");
        } else if (j(context, "com.tencent.mm")) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            Log.i("MinorProvider", "force-stop background WeChat after minors mode off");
            u.h(activityManager, "com.tencent.mm");
        }
    }

    public static void u(Context context, long j5, long j6, int i5) {
        PackageUtils packageUtilsH = PackageUtils.h(context);
        packageUtilsH.b();
        Intent intent = new Intent("active_minor_changed");
        intent.putExtra("active_minor_id", j6);
        intent.putExtra("minors_mode_age_range", i5);
        v(context, intent, p(packageUtilsH.l()));
        intent.putExtra("last_active_minor_id", j5);
        intent.putExtra("minors_mode_enabled", j6 > 0 ? 1 : 0);
        intent.setPackage("com.stepos.alphame");
        intent.addFlags(32);
        context.sendBroadcast(intent);
    }

    public static void v(Context context, Intent intent, List<String> list) {
        if (intent == null || list == null || list.isEmpty()) {
            return;
        }
        intent.addFlags(32);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            intent.setPackage(it.next());
            context.sendBroadcast(intent);
        }
    }

    public static void w(Context context, long[] jArr) {
        Intent intent = new Intent("delete_minors");
        intent.putExtra("deleted_minors_id", jArr);
        intent.setPackage("com.stepos.alphame");
        intent.addFlags(32);
        context.sendBroadcast(intent);
    }

    public static void x(Context context, int i5) {
        List<String> listP;
        C0702g.b("MinorProvider", "sendModeChangedBroadcast() called with: mode = [" + i5 + "]");
        PackageUtils packageUtilsH = PackageUtils.h(context);
        packageUtilsH.b();
        if (i5 == 1) {
            listP = p(packageUtilsH.l());
        } else {
            ArrayList arrayList = new ArrayList(packageUtilsH.l());
            if (i(context, "com.tencent.mm") && !arrayList.contains("com.tencent.mm")) {
                arrayList.add("com.tencent.mm");
            }
            listP = arrayList;
        }
        Log.i("MinorProvider", "sendModeChangedBroadcast mode = " + i5 + ", packages = " + listP);
        int i6 = i5 == 1 ? 0 : 1;
        Intent intent = new Intent(i5 == 1 ? "minors_mode_enabled_turn_on" : i5 == 0 ? "minors_mode_enabled_turn_off" : null);
        intent.putExtra("minors_mode_enabled", i5);
        long jR = r(context, i5);
        int iS = s(context, i5, jR);
        intent.putExtra("active_minor_id", jR);
        intent.putExtra("minors_mode_age_range", iS);
        Log.i("MinorProvider", "sendModeChangedBroadcast extras: mode = " + i5 + ", activeMinorId = " + jR + ", ageRange = " + iS);
        a.e(i5);
        v(context, intent, listP);
        if (i5 == 0) {
            t(context);
        }
        intent.putExtra("key_last_mode", i6);
        intent.setPackage("com.stepos.alphame");
        intent.addFlags(32);
        context.sendBroadcast(intent);
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, String str3, Bundle bundle) {
        Log.i("MinorProvider", "call() method = [" + str2 + "]");
        C0702g.b("MinorProvider", "call() method = [" + str2 + "], extras = [" + bundle + "]");
        if (d.a(this.f15374b)) {
            return d(str2, bundle);
        }
        C0702g.O("MinorProvider", "call rejected untrusted uid=" + Binder.getCallingUid());
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("result", false);
        return bundle2;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        C0702g.b("MinorProvider", "delete() called with: uri = [" + uri + "], , selection = [" + str + "], selectionArgs = " + C0702g.h(strArr));
        throw new IllegalStateException("not support operation");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        switch (f15371j.match(uri)) {
            case 1:
                return "vnd.android.cursor.dir/minors";
            case 2:
            case 3:
                return "vnd.android.cursor.item/minor";
            case 4:
                return "vnd.android.cursor.dir/whitelist";
            case 5:
                return "vnd.android.cursor.item/minor_mode";
            case 6:
                return "vnd.android.cursor.item/has_password";
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        C0702g.b("MinorProvider", "insert() called with: uri = [" + uri + "], values = [" + contentValues + "]");
        throw new IllegalStateException("not support operation");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        C0702g.b("MinorProvider", "onCreate() called");
        Context context = getContext();
        this.f15374b = context;
        this.f15375c = context.getContentResolver();
        this.f15373a = g.a(this.f15374b).b();
        a.c(this.f15374b);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        C0702g.b("MinorProvider", "query() called with: uri = [" + uri + "], , projection = " + C0702g.h(strArr) + ", selection = [" + str + "], selectionArgs = " + C0702g.h(strArr2) + ", sortOrder = [" + str2 + "]");
        if (!d.a(this.f15374b)) {
            C0702g.O("MinorProvider", "query rejected untrusted uid=" + Binder.getCallingUid());
            return new MatrixCursor(new String[0]);
        }
        switch (f15371j.match(uri)) {
            case 1:
                return this.f15373a.t().j(str, strArr2, str2);
            case 2:
                return this.f15373a.t().e(Long.parseLong(uri.getLastPathSegment()));
            case 3:
                return this.f15373a.t().h();
            case 4:
                Minor minorG = this.f15373a.t().g();
                return this.f15373a.u().d(minorG == null ? -1L : minorG.getId());
            case 5:
                int i5 = this.f15373a.t().g() != null ? 1 : 0;
                MatrixCursor matrixCursor = new MatrixCursor(new String[]{"minor_mode"});
                matrixCursor.addRow(new Object[]{Integer.valueOf(i5)});
                return matrixCursor;
            case 6:
                boolean zA = b.a(this.f15374b);
                MatrixCursor matrixCursor2 = new MatrixCursor(new String[]{f15372k});
                matrixCursor2.addRow(new Object[]{Integer.valueOf(zA ? 1 : 0)});
                return matrixCursor2;
            default:
                return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        C0702g.b("MinorProvider", "update() called with: uri = [" + uri + "], ,values = [" + contentValues + "], selection = [" + str + "], selectionArgs = " + C0702g.h(strArr));
        throw new IllegalStateException("not support operation");
    }
}
