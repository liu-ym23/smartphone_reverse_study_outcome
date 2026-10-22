package androidx.appsearch.platformstorage.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.util.Preconditions;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class AppSearchVersionUtil {
    public static final long APPSEARCH_M2023_11_VERSION_CODE = 341113000;
    public static final long APPSEARCH_M2024_11_VERSION_CODE = 351112060;
    private static final String APPSEARCH_MODULE_NAME = "com.android.appsearch";
    public static final long APPSEARCH_U_BASE_VERSION_CODE = 340800000;
    public static final long APPSEARCH_V_BASE_VERSION_CODE = 350700000;
    private static volatile long sAppSearchVersionCode = -1;

    @RequiresApi(29)
    public static class ApiHelperForQ {
        private ApiHelperForQ() {
        }

        @DoNotInline
        public static String getAppSearchPackageName(PackageManager packageManager) throws PackageManager.NameNotFoundException {
            return packageManager.getModuleInfo(AppSearchVersionUtil.APPSEARCH_MODULE_NAME, 1).getPackageName();
        }

        @DoNotInline
        public static long getPackageInfoLongVersionCode(PackageInfo packageInfo) {
            return packageInfo.getLongVersionCode();
        }
    }

    private AppSearchVersionUtil() {
    }

    @RequiresApi(29)
    public static long getAppSearchVersionCode(Context context) {
        Preconditions.checkNotNull(context);
        if (sAppSearchVersionCode != -1) {
            return sAppSearchVersionCode;
        }
        synchronized (AppSearchVersionUtil.class) {
            if (sAppSearchVersionCode == -1) {
                long packageInfoLongVersionCode = 0;
                try {
                    PackageManager packageManager = context.getPackageManager();
                    String appSearchPackageName = ApiHelperForQ.getAppSearchPackageName(packageManager);
                    if (appSearchPackageName != null) {
                        packageInfoLongVersionCode = ApiHelperForQ.getPackageInfoLongVersionCode(packageManager.getPackageInfo(appSearchPackageName, BasicMeasure.EXACTLY));
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
                sAppSearchVersionCode = packageInfoLongVersionCode;
            }
        }
        return sAppSearchVersionCode;
    }

    @ChecksSdkIntAtLeast(api = 36, codename = "Baklava")
    public static boolean isAtLeastB() {
        int i = Build.VERSION.SDK_INT;
        if (i < 36) {
            return i >= 35 && Build.VERSION.CODENAME.equals("Baklava");
        }
        return true;
    }
}
