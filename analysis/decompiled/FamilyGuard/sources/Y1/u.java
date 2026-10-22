package Y1;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.os.Process;
import android.os.UserManager;
import android.text.TextUtils;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import com.stepos.minor.Minor;
import f2.C0702g;
import g2.C0736f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import x3.AbstractC1286b;

/* loaded from: classes.dex */
public class u {

    /* renamed from: b, reason: collision with root package name */
    private static Method f6474b;

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f6473a = R1.a.f("SuspendedUtils", R1.a.f4966b);

    /* renamed from: c, reason: collision with root package name */
    private static final Handler f6475c = new Handler(Looper.getMainLooper());

    public static /* synthetic */ void b(String[] strArr, final ActivityManager activityManager, boolean z5) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean z6 = false;
        for (String str : strArr) {
            if (!C2.c.a(PackageUtils.f14710i, str)) {
                try {
                    C0702g.b("SuspendedUtils", "forceStopPackage packageName = " + str);
                    if (f6474b == null) {
                        f6474b = ActivityManager.class.getMethod("forceStopPackage", String.class);
                    }
                    f6474b.invoke(activityManager, str);
                } catch (Exception e6) {
                    Throwable cause = e6 instanceof InvocationTargetException ? ((InvocationTargetException) e6).getCause() : e6;
                    StringBuilder sb = new StringBuilder();
                    sb.append("forceStopPackage failed packageName = ");
                    sb.append(str);
                    sb.append(" err = ");
                    sb.append(cause != null ? cause.getMessage() : e6.getMessage());
                    C0702g.O("SuspendedUtils", sb.toString());
                    if (cause instanceof SecurityException) {
                        z6 = true;
                    }
                }
            }
        }
        if (z5 && n(activityManager, strArr)) {
            f6475c.post(new Runnable() { // from class: Y1.t
                @Override // java.lang.Runnable
                public final void run() throws SecurityException {
                    u.d(activityManager);
                }
            });
        } else if (z5) {
            R1.a.e("SuspendedUtils", "target left foreground, keep current desktop");
        } else if (z6) {
            C0702g.O("SuspendedUtils", "forceStop denied and target not foreground, skip goHome");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean c(android.content.pm.PackageManager r10, java.lang.String[] r11, java.lang.String[] r12, boolean r13, android.os.PersistableBundle r14, android.os.PersistableBundle r15, java.lang.String r16) {
        /*
            java.lang.Class<android.os.PersistableBundle> r12 = android.os.PersistableBundle.class
            r1 = 0
            if (r11 == 0) goto L9e
            int r0 = r11.length
            if (r0 != 0) goto La
            goto L9e
        La:
            boolean r0 = T1.c.f5394b
            java.lang.String r2 = "SuspendedUtils"
            r3 = 1
            if (r0 == 0) goto L55
            java.lang.Class<android.content.pm.PackageManager> r0 = android.content.pm.PackageManager.class
            N1.h$g r0 = N1.h.a(r0)     // Catch: java.lang.Exception -> L38
            java.lang.String r4 = "setPackagesSuspended"
            java.lang.Class<java.lang.String[]> r5 = java.lang.String[].class
            java.lang.Class r6 = java.lang.Boolean.TYPE     // Catch: java.lang.Exception -> L38
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            java.lang.Class[] r12 = new java.lang.Class[]{r5, r6, r12, r12, r7}     // Catch: java.lang.Exception -> L38
            N1.h$i r12 = r0.a(r4, r12)     // Catch: java.lang.Exception -> L38
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r13)     // Catch: java.lang.Exception -> L38
            r8 = r16
            java.lang.Object[] r0 = new java.lang.Object[]{r11, r0, r14, r15, r8}     // Catch: java.lang.Exception -> L35
            r12.a(r10, r0)     // Catch: java.lang.Exception -> L35
            return r3
        L35:
            r0 = move-exception
        L36:
            r10 = r0
            goto L3c
        L38:
            r0 = move-exception
            r8 = r16
            goto L36
        L3c:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "AOSP setPackagesSuspended failed: "
            r12.append(r0)
            java.lang.String r10 = r10.getMessage()
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            f2.C0702g.O(r2, r10)
            goto L57
        L55:
            r8 = r16
        L57:
            boolean r10 = T1.c.f5395c
            if (r10 == 0) goto L99
            android.app.Application r10 = P1.a.a()     // Catch: java.lang.Exception -> L7d
            java.lang.String r12 = "user"
            java.lang.Object r10 = r10.getSystemService(r12)     // Catch: java.lang.Exception -> L7d
            android.os.UserManager r10 = (android.os.UserManager) r10     // Catch: java.lang.Exception -> L7d
            int[] r10 = k(r10)     // Catch: java.lang.Exception -> L7d
            int r12 = r10.length     // Catch: java.lang.Exception -> L7d
            r0 = r1
        L6d:
            if (r0 >= r12) goto L80
            r9 = r10[r0]     // Catch: java.lang.Exception -> L7d
            r4 = r11
            r5 = r13
            r6 = r14
            r7 = r15
            l(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L7d
            int r0 = r0 + 1
            r8 = r16
            goto L6d
        L7d:
            r0 = move-exception
            r10 = r0
            goto L81
        L80:
            return r3
        L81:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "PackageManagerExt setPackagesSuspended failed: "
            r11.append(r12)
            java.lang.String r10 = r10.getMessage()
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            f2.C0702g.O(r2, r10)
        L99:
            java.lang.String r10 = "all setPackagesSuspended paths failed"
            f2.C0702g.p(r2, r10)
        L9e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: Y1.u.c(android.content.pm.PackageManager, java.lang.String[], java.lang.String[], boolean, android.os.PersistableBundle, android.os.PersistableBundle, java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(ActivityManager activityManager) throws SecurityException {
        try {
            ComponentName componentNameP = p();
            if (activityManager != null && componentNameP != null) {
                List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(30);
                if (runningTasks != null) {
                    for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                        ComponentName componentName = runningTaskInfo.baseActivity;
                        if (componentName != null && TextUtils.equals(componentNameP.getPackageName(), componentName.getPackageName())) {
                            activityManager.moveTaskToFront(runningTaskInfo.taskId, 2);
                            R1.a.e("SuspendedUtils", "move launcher task to front id=" + runningTaskInfo.taskId);
                            return;
                        }
                    }
                }
                R1.a.l("SuspendedUtils", "launcher task not found, skip CATEGORY_HOME");
                return;
            }
            R1.a.l("SuspendedUtils", "bringCurrentDesktopToFront home unresolved");
        } catch (Exception e6) {
            R1.a.b("SuspendedUtils", "bringCurrentDesktopToFront failed: " + e6.getMessage());
        }
    }

    public static String[] e(PackageManager packageManager, String[] strArr, boolean z5, PersistableBundle persistableBundle, PersistableBundle persistableBundle2, String str) {
        boolean z6 = f6473a;
        if (z6) {
            R1.a.a("SuspendedUtils", "doPackagesSuspend packages = " + C0702g.h(strArr) + " suspended = " + z5 + " dialogMessage = " + str);
        }
        if (C0736f.f17232c) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            str = "Cancel " + C0702g.h(strArr);
        }
        String str2 = str;
        if (strArr == null || strArr.length == 0) {
            if (z6) {
                R1.a.l("SuspendedUtils", "packages empty return ");
            }
            return new String[0];
        }
        R1.a.a("SuspendedUtils", str2);
        String[] strArrG = g(strArr, PackageUtils.f14710i);
        C0702g.b("SuspendedUtils", "filteredPackages = " + C0702g.h(strArrG));
        C0702g.b("SuspendedUtils", "applyPackagesSuspended result = " + c(packageManager, strArrG, strArr, z5, persistableBundle, persistableBundle2, str2) + " suspended = " + z5);
        if (z5) {
            i((ActivityManager) P1.a.a().getSystemService("activity"), strArr, m(strArr));
        }
        return new String[0];
    }

    public static String[] f(String[] strArr, boolean z5, String str) {
        return e(P1.a.a().getPackageManager(), strArr, z5, null, null, str);
    }

    private static String[] g(String[] strArr, String[] strArr2) {
        if (strArr == null) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        List listAsList = Arrays.asList(strArr2);
        for (String str : strArr) {
            if (!listAsList.contains(str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static void h(ActivityManager activityManager, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            C0702g.b("SuspendedUtils", "forceStopPackage packageName = " + str);
            if (f6474b == null) {
                f6474b = ActivityManager.class.getMethod("forceStopPackage", String.class);
            }
            f6474b.invoke(activityManager, str);
        } catch (Exception e6) {
            C0702g.O("SuspendedUtils", "forceStopPackage failed packageName = " + str + " err = " + e6.getMessage());
        }
    }

    public static void i(final ActivityManager activityManager, final String[] strArr, final boolean z5) {
        AbstractC1286b.c(new D3.a() { // from class: Y1.s
            @Override // D3.a
            public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                u.b(strArr, activityManager, z5);
            }
        }).j(T3.a.a()).f();
    }

    private static Object j(Context context) {
        return Class.forName("stepos.pm.PackageManagerExt", true, Object.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context);
    }

    private static int[] k(UserManager userManager) throws InvocationTargetException {
        try {
            List list = (List) N1.h.a(UserManager.class).a("getUsers", new Class[0]).a(userManager, new Object[0]);
            int size = list == null ? 0 : list.size();
            int[] iArr = new int[size];
            for (int i5 = 0; i5 < size; i5++) {
                iArr[i5] = N1.h.c("android.content.pm.UserInfo").b(Minor.COLUMN_ID).c(list.get(i5));
            }
            return iArr;
        } catch (InvocationTargetException e6) {
            Throwable cause = e6.getCause();
            if (!(cause instanceof SecurityException)) {
                throw e6;
            }
            C0702g.O("SuspendedUtils", "getUsers permission denied, fallback to current user: " + cause.getMessage());
            return new int[]{Process.myUid() / 100000};
        }
    }

    private static void l(String[] strArr, boolean z5, PersistableBundle persistableBundle, PersistableBundle persistableBundle2, String str, int i5) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        String[] strArr2;
        PersistableBundle persistableBundle3;
        PersistableBundle persistableBundle4;
        String str2;
        Object objJ = j(P1.a.a());
        Class<?> cls = objJ.getClass();
        try {
            strArr2 = strArr;
            persistableBundle3 = persistableBundle;
            persistableBundle4 = persistableBundle2;
            str2 = str;
            try {
                cls.getMethod("setPackagesSuspended", String[].class, Boolean.TYPE, PersistableBundle.class, PersistableBundle.class, String.class, Integer.TYPE).invoke(objJ, strArr2, Boolean.valueOf(z5), persistableBundle3, persistableBundle4, str2, Integer.valueOf(i5));
            } catch (NoSuchMethodException unused) {
                cls.getMethod("setPackagesSuspended", String[].class, Boolean.TYPE, PersistableBundle.class, PersistableBundle.class, String.class).invoke(objJ, strArr2, Boolean.valueOf(z5), persistableBundle3, persistableBundle4, str2);
            }
        } catch (NoSuchMethodException unused2) {
            strArr2 = strArr;
            persistableBundle3 = persistableBundle;
            persistableBundle4 = persistableBundle2;
            str2 = str;
        }
    }

    private static boolean m(String[] strArr) {
        boolean z5 = false;
        if (strArr != null && strArr.length != 0) {
            String strU = com.stepos.digitalwellbeing.server.e.u();
            if (!TextUtils.isEmpty(strU) && C2.c.a(strArr, strU)) {
                z5 = true;
            }
            C0702g.b("SuspendedUtils", "isAnyPackageForeground lastResumed = " + strU + " match = " + z5);
        }
        return z5;
    }

    private static boolean n(ActivityManager activityManager, String[] strArr) throws SecurityException {
        if (activityManager == null) {
            return false;
        }
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
            if (runningTasks != null && !runningTasks.isEmpty() && runningTasks.get(0).topActivity != null) {
                String packageName = runningTasks.get(0).topActivity.getPackageName();
                boolean zA = C2.c.a(strArr, packageName);
                R1.a.e("SuspendedUtils", "isTargetStillTop top=" + packageName + " match=" + zA);
                return zA;
            }
            return false;
        } catch (Exception e6) {
            R1.a.l("SuspendedUtils", "isTargetStillTop failed: " + e6.getMessage());
            return false;
        }
    }

    public static String[] o(String[] strArr, String str) {
        PackageManager packageManager = P1.a.a().getPackageManager();
        if (f6473a) {
            R1.a.a("SuspendedUtils", "refreshSuspendDialog packages = " + C0702g.h(strArr) + " dialogMessage = " + str);
        }
        if (C0736f.f17232c || strArr == null || strArr.length == 0) {
            return new String[0];
        }
        if (TextUtils.isEmpty(str)) {
            str = "Cancel " + C0702g.h(strArr);
        }
        c(packageManager, g(strArr, PackageUtils.f14710i), strArr, true, null, null, str);
        return new String[0];
    }

    private static ComponentName p() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveInfoResolveActivity = P1.a.a().getPackageManager().resolveActivity(intent, 65536);
        if (resolveInfoResolveActivity == null || resolveInfoResolveActivity.activityInfo == null) {
            return null;
        }
        ActivityInfo activityInfo = resolveInfoResolveActivity.activityInfo;
        return new ComponentName(activityInfo.packageName, activityInfo.name);
    }
}
