package com.stepos.taskrobot.llmapi.stepfun;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.taskmemory.bean.AppInfo;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J$\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005J\u0018\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J \u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/PackageUtil;", "", AppAgent.CONSTRUCT, "()V", "getPackageNameByAppName", "", "context", "Landroid/content/Context;", "appName", "getAppInfoByPackageName", "Lkotlin/Pair;", "packageName", "getAppInfoByAppName", "Lcom/stepos/taskrobot/taskmemory/bean/AppInfo;", "loadAppIconBitmap", "Landroid/graphics/Bitmap;", "sizePx", "", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PackageUtil {
    public static final PackageUtil INSTANCE = new PackageUtil();

    private PackageUtil() {
    }

    public final AppInfo getAppInfoByAppName(Context context, String appName) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(appName, "appName");
        try {
            PackageManager packageManager = context.getPackageManager();
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
            kotlin.jvm.internal.k.e(installedPackages, "getInstalledPackages(...)");
            for (PackageInfo packageInfo : installedPackages) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                String strValueOf = String.valueOf(applicationInfo != null ? applicationInfo.loadLabel(packageManager) : null);
                if (appName.equals(strValueOf)) {
                    String packageName = packageInfo.packageName;
                    kotlin.jvm.internal.k.e(packageName, "packageName");
                    String str = packageInfo.versionName;
                    if (str == null) {
                        str = "Unknown";
                    }
                    return new AppInfo(packageName, strValueOf, str, packageInfo.getLongVersionCode());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public final Pair<String, String> getAppInfoByPackageName(Context context, String packageName) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(packageName, "packageName");
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            String strValueOf = String.valueOf(applicationInfo != null ? applicationInfo.loadLabel(packageManager) : null);
            String str = packageInfo.versionName;
            if (str == null) {
                str = "Unknown";
            }
            return new Pair<>(strValueOf, str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final String getPackageNameByAppName(Context context, String appName) {
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(appName, "appName");
        try {
            PackageManager packageManager = context.getPackageManager();
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
            kotlin.jvm.internal.k.e(installedPackages, "getInstalledPackages(...)");
            String lowerCase = appName.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.k.e(lowerCase, "toLowerCase(...)");
            for (PackageInfo packageInfo : installedPackages) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                kotlin.jvm.internal.k.c(applicationInfo);
                String lowerCase2 = applicationInfo.loadLabel(packageManager).toString().toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.k.e(lowerCase2, "toLowerCase(...)");
                if (lowerCase.equals(lowerCase2)) {
                    return packageInfo.packageName;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final Bitmap loadAppIconBitmap(Context context, String packageName, int sizePx) {
        Object objA;
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(packageName, "packageName");
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 0);
            kotlin.jvm.internal.k.e(applicationInfo, "getApplicationInfo(...)");
            Drawable applicationIcon = packageManager.getApplicationIcon(applicationInfo);
            kotlin.jvm.internal.k.e(applicationIcon, "getApplicationIcon(...)");
            objA = DrawableKt.toBitmap(applicationIcon, sizePx, sizePx, Bitmap.Config.ARGB_8888);
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        return (Bitmap) objA;
    }
}
