package D2;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f374a = new ConcurrentHashMap();
    public static final ConcurrentHashMap b = new ConcurrentHashMap();

    public static boolean a(Context context, String str) {
        boolean zEquals;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        String str2 = context.hashCode() + "@" + str;
        ConcurrentHashMap concurrentHashMap = f374a;
        synchronized (concurrentHashMap) {
            try {
                if (!concurrentHashMap.containsKey(str2)) {
                    try {
                        concurrentHashMap.put(str2, Boolean.valueOf(context.getPackageManager().getPackageInfo(str, 16384) != null));
                    } catch (Throwable unused) {
                        f374a.put(str2, Boolean.FALSE);
                    }
                }
                zEquals = Boolean.TRUE.equals(f374a.get(str2));
            } catch (Throwable th) {
                throw th;
            }
        }
        return zEquals;
    }

    public static PackageInfo b(Context context, String str, int i) {
        PackageInfo packageInfo;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        String str2 = i + ":" + context.hashCode() + "@" + str;
        ConcurrentHashMap concurrentHashMap = b;
        synchronized (concurrentHashMap) {
            if (!concurrentHashMap.containsKey(str2)) {
                try {
                    concurrentHashMap.put(str2, context.getPackageManager().getPackageInfo(str, i));
                } catch (Throwable unused) {
                }
            }
            packageInfo = (PackageInfo) b.get(str2);
        }
        return packageInfo;
    }

    public static String c(Context context) {
        PackageInfo packageInfoB = b(context, context.getPackageName(), 0);
        return packageInfoB != null ? packageInfoB.versionName : "";
    }
}
