package com.android.internal.util.jobs;

import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Binder;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.android.server.am.IZswContentProviderHelper;
import com.android.server.pm.PackageManagerService;
import com.android.server.scene.SceneUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public final class DumpUtils {
    public static final ComponentName[] CRITICAL_SECTION_COMPONENTS = null;
    private static final boolean DEBUG = false;
    private static final String TAG = "DumpUtils";

    public interface Dump {
        void dump(PrintWriter r1, String r2);
    }

    public interface KeyDumper {
        void dump(int r1, int r2);
    }

    public interface ValueDumper<T> {
        void dump(T r1);
    }

    public static /* synthetic */ boolean $r8$lambda$7L2IuHmi6ElsEnVZijGH47KxIzk(int r0, String r1, ComponentName.WithComponentName r2) {
        return lambda$filterRecord$2(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$FG505HlyvajkfrO9xmitenM2Nv8(ComponentName.WithComponentName r0) {
        return lambda$filterRecord$0(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$WK57pgle_yxeN7VzFLE0xvhrYrs(ComponentName r0, ComponentName.WithComponentName r1) {
        return lambda$filterRecord$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$xV6YgEaWJX4rlq6RkXJi5BssYRs(PrintWriter r0, String r1, int r2, int r3) {
        lambda$dumpSparseArrayValues$3(r0, r1, r2, r3);
    }

    static {
        CRITICAL_SECTION_COMPONENTS = new ComponentName[]{new ComponentName(SceneUtils.PKG_SYS_UI, "com.android.systemui.SystemUIService")};
    }

    private DumpUtils() {
    }

    public static void dumpAsync(Handler handler, final Dump dump, PrintWriter pw, final String prefix, long timeout) {
        final StringWriter sw = new StringWriter();
        if (handler.runWithScissors(new AnonymousClass1(sw, dump, prefix), timeout) == false) goto L5;
        pw.print(sw.toString());
        return;
    L5:
        pw.println("... timed out");
    }

    private static void logMessage(PrintWriter pw, String msg) {
        pw.println(msg);
    }

    public static boolean checkDumpPermission(Context context, String tag, PrintWriter pw) {
        if (context.checkCallingOrSelfPermission("android.permission.DUMP") == 0) goto L6;
        logMessage(pw, "Permission Denial: can't dump " + tag + " from from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + " due to missing android.permission.DUMP permission");
        return false;
    L6:
        return true;
    }

    public static boolean checkUsageStatsPermission(Context context, String tag, PrintWriter pw) {
        int uid = Binder.getCallingUid();
        switch(uid) {
            case 0: goto L20;
            case 1000: goto L20;
            case 1067: goto L20;
            case 2000: goto L20;
            default: goto L5;
        };
    L20:
        return true;
    L5:
        if (context.checkCallingOrSelfPermission("android.permission.PACKAGE_USAGE_STATS") == 0) goto L8;
        logMessage(pw, "Permission Denial: can't dump " + tag + " from from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + " due to missing android.permission.PACKAGE_USAGE_STATS permission");
        return false;
    L8:
        AppOpsManager appOps = (AppOpsManager) context.getSystemService(AppOpsManager.class);
        String[] pkgs = context.getPackageManager().getPackagesForUid(uid);
        if (pkgs == null) goto L18;
        int r8 = pkgs.length;
        int r9 = 0;
    L12:
        if (r9 >= r8) goto L18;
        String pkg = pkgs[r9];
        switch(appOps.noteOpNoThrow(43, uid, pkg)) {
            case 0: goto L17;
            case 3: goto L16;
            default: goto L15;
        };
    L15:
        r9 = r9 + 1;
        goto L12
    L16:
        return true;
    L17:
        return true;
    L18:
        logMessage(pw, "Permission Denial: can't dump " + tag + " from from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + " due to android:get_usage_stats app-op not allowed");
        return false;
    }

    public static boolean checkDumpAndUsageStatsPermission(Context context, String tag, PrintWriter pw) {
        if (checkDumpPermission(context, tag, pw) == true) goto L5;
    L7:
        return false;
    L5:
        if (checkUsageStatsPermission(context, tag, pw) == false) goto L7;
        return true;
    }

    public static boolean isPlatformPackage(String packageName) {
        if (packageName != null) goto L4;
    L10:
        return false;
    L4:
        if (packageName.equals(PackageManagerService.PLATFORM_PACKAGE_NAME) == false) goto L6;
    L9:
        return true;
    L6:
        if (packageName.startsWith("android.") == true) goto L9;
        if (packageName.startsWith("com.android.") == false) goto L10;
        goto L9
    }

    public static boolean isPlatformPackage(ComponentName cname) {
        if (cname != null) goto L4;
    L6:
        return false;
    L4:
        if (isPlatformPackage(cname.getPackageName()) == false) goto L6;
        return true;
    }

    public static boolean isPlatformPackage(ComponentName.WithComponentName wcn) {
        if (wcn != null) goto L4;
    L6:
        return false;
    L4:
        if (isPlatformPackage(wcn.getComponentName()) == false) goto L6;
        return true;
    }

    public static boolean isNonPlatformPackage(String packageName) {
        if (packageName != null) goto L4;
    L6:
        return false;
    L4:
        if (isPlatformPackage(packageName) == true) goto L6;
        return true;
    }

    public static boolean isNonPlatformPackage(ComponentName cname) {
        if (cname != null) goto L4;
    L6:
        return false;
    L4:
        if (isNonPlatformPackage(cname.getPackageName()) == false) goto L6;
        return true;
    }

    public static boolean isNonPlatformPackage(ComponentName.WithComponentName wcn) {
        if (wcn != null) goto L4;
    L6:
        return false;
    L4:
        if (isPlatformPackage(wcn.getComponentName()) == true) goto L6;
        return true;
    }

    private static boolean isCriticalPackage(ComponentName cname) {
        if (cname != null) goto L5;
        return false;
    L5:
        int i = 0;
    L7:
        if (i >= CRITICAL_SECTION_COMPONENTS.length) goto L14;
        if (cname.equals(CRITICAL_SECTION_COMPONENTS[i]) == true) goto L10;
        i = i + 1;
        goto L7
    L10:
        return true;
    L14:
        return false;
    }

    public static boolean isPlatformCriticalPackage(ComponentName.WithComponentName wcn) {
        if (wcn != null) goto L4;
    L8:
        return false;
    L4:
        if (isPlatformPackage(wcn.getComponentName()) == false) goto L8;
        if (isCriticalPackage(wcn.getComponentName()) == false) goto L8;
        return true;
    }

    public static boolean isPlatformNonCriticalPackage(ComponentName.WithComponentName wcn) {
        if (wcn != null) goto L4;
    L8:
        return false;
    L4:
        if (isPlatformPackage(wcn.getComponentName()) == false) goto L8;
        if (isCriticalPackage(wcn.getComponentName()) == true) goto L8;
        return true;
    }

    public static <TRec extends ComponentName.WithComponentName> Predicate<TRec> filterRecord(final String filterString) {
        if (TextUtils.isEmpty(filterString) == false) goto L7;
        return new DumpUtils$$ExternalSyntheticLambda1();
    L7:
        if (IZswContentProviderHelper.DUMP_ALL.equals(filterString) == false) goto L11;
        return new DumpUtils$$ExternalSyntheticLambda2();
    L11:
        if ("all-platform".equals(filterString) == false) goto L15;
        return new DumpUtils$$ExternalSyntheticLambda3();
    L15:
        if ("all-non-platform".equals(filterString) == false) goto L19;
        return new DumpUtils$$ExternalSyntheticLambda4();
    L19:
        if ("all-platform-critical".equals(filterString) == false) goto L23;
        return new DumpUtils$$ExternalSyntheticLambda5();
    L23:
        if ("all-platform-non-critical".equals(filterString) == true) goto L25;
        final ComponentName filterCname = ComponentName.unflattenFromString(filterString);
        if (filterCname != null) goto L29;
        final int id = ParseUtils.parseIntWithBase(filterString, 16, -1);
        return new DumpUtils$$ExternalSyntheticLambda8(id, filterString);
    L29:
        return new DumpUtils$$ExternalSyntheticLambda7(filterCname);
    L25:
        return new DumpUtils$$ExternalSyntheticLambda6();
    }

    private static /* synthetic */ boolean lambda$filterRecord$0(ComponentName.WithComponentName rec) {
        return false;
    }

    private static /* synthetic */ boolean lambda$filterRecord$1(ComponentName filterCname, ComponentName.WithComponentName rec) {
        if (rec != null) goto L4;
    L6:
        return false;
    L4:
        if (filterCname.equals(rec.getComponentName()) == false) goto L6;
        return true;
    }

    private static /* synthetic */ boolean lambda$filterRecord$2(int id, String filterString, ComponentName.WithComponentName rec) {
        ComponentName cn = rec.getComponentName();
        if (id == (-1)) goto L7;
        if (System.identityHashCode(rec) != id) goto L7;
    L8:
        return true;
    L7:
        if (cn.flattenToString().toLowerCase().contains(filterString.toLowerCase()) == true) goto L8;
        return false;
    }

    public static void dumpSparseArray(PrintWriter pw, String prefix, SparseArray<?> array, String name) {
        dumpSparseArray(pw, prefix, array, name, null, null);
    }

    public static <T> void dumpSparseArrayValues(final PrintWriter pw, final String prefix, SparseArray<T> array, String name) {
        dumpSparseArray(pw, prefix, array, name, new DumpUtils$$ExternalSyntheticLambda0(pw, prefix), null);
    }

    private static /* synthetic */ void lambda$dumpSparseArrayValues$3(PrintWriter pw, String prefix, int i, int k) {
        pw.printf("%s%s", new Object[]{prefix, prefix});
    }

    public static <T> void dumpSparseArray(PrintWriter pw, String prefix, SparseArray<T> array, String name, KeyDumper keyDumper, ValueDumper<T> valueDumper) {
        int size = array.size();
        if (size != 0) goto L6;
        pw.print(prefix);
        pw.print("No ");
        pw.print(name);
        pw.println("s");
        return;
    L6:
        pw.print(prefix);
        pw.print(size);
        pw.print(' ');
        pw.print(name);
        pw.println("(s):");
        String prefix2 = prefix + prefix;
        int i = 0;
    L7:
        if (i >= size) goto L19;
        int key = array.keyAt(i);
        T value = array.valueAt(i);
        if (keyDumper == null) goto L11;
        keyDumper.dump(i, key);
    L12:
        if (value != null) goto L14;
        pw.print("(null)");
    L17:
        pw.println();
        i = i + 1;
        goto L7
    L14:
        if (valueDumper == null) goto L16;
        valueDumper.dump(value);
        goto L17
    L16:
        pw.print(value);
        goto L17
    L11:
        pw.print(prefix2);
        pw.print(i);
        pw.print(": ");
        pw.print(key);
        pw.print("->");
        goto L12
    }
}
