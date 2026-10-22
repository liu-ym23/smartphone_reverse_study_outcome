package com.stepos.alphame.utils;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.stepos.alphame.utils.AppUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class LargeBinderTransactionHelper extends SingleTaskQueue {
    @NonNull
    public static List<AppUtils.AppPkgItem> getClonedApplications(final PackageManager packageManager) {
        final Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        List<AppUtils.AppPkgItem> list = (List) SingleTaskQueue.runTaskAndWait(new Callable<List<AppUtils.AppPkgItem>>() { // from class: com.stepos.alphame.utils.LargeBinderTransactionHelper.4
            @Override // java.util.concurrent.Callable
            public List<AppUtils.AppPkgItem> call() throws Exception {
                List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                ArrayList arrayList = new ArrayList();
                for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                    arrayList.add(new AppUtils.AppPkgItem(resolveInfo.activityInfo.packageName, String.valueOf(resolveInfo.loadLabel(packageManager))));
                }
                return arrayList;
            }
        });
        return list == null ? new ArrayList() : list;
    }

    @NonNull
    public static List<ResolveInfo> getHomeApplications(final PackageManager packageManager) {
        final Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.HOME");
        List<ResolveInfo> list = (List) SingleTaskQueue.runTaskAndWait(new Callable<List<ResolveInfo>>() { // from class: com.stepos.alphame.utils.LargeBinderTransactionHelper.3
            @Override // java.util.concurrent.Callable
            public List<ResolveInfo> call() throws Exception {
                return packageManager.queryIntentActivities(intent, 0);
            }
        });
        return list == null ? new ArrayList() : list;
    }

    @NonNull
    public static List<ApplicationInfo> getInstalledApplications(final PackageManager packageManager, final int i4) {
        List<ApplicationInfo> list = (List) SingleTaskQueue.runTaskAndWait(new Callable<List<ApplicationInfo>>() { // from class: com.stepos.alphame.utils.LargeBinderTransactionHelper.2
            @Override // java.util.concurrent.Callable
            public List<ApplicationInfo> call() throws Exception {
                return packageManager.getInstalledApplications(i4);
            }
        });
        return list == null ? new ArrayList() : list;
    }

    @NonNull
    public static List<PackageInfo> getInstalledOnLauncherPackages(final PackageManager packageManager, final int i4) {
        List<PackageInfo> list = (List) SingleTaskQueue.runTaskAndWait(new Callable<List<PackageInfo>>() { // from class: com.stepos.alphame.utils.LargeBinderTransactionHelper.1
            @Override // java.util.concurrent.Callable
            public List<PackageInfo> call() throws Exception {
                return packageManager.getInstalledPackages(i4);
            }
        });
        return list == null ? new ArrayList() : list;
    }

    @NonNull
    public static List<ResolveInfo> getOnLauncherApplications(PackageManager packageManager) {
        List<ResolveInfo> listQueryIntentActivities = null;
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        try {
            listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        } catch (Throwable unused) {
        }
        return listQueryIntentActivities == null ? new ArrayList() : listQueryIntentActivities;
    }
}
