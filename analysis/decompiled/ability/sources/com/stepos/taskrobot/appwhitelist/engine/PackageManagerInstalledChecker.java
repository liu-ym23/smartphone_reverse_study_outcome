package com.stepos.taskrobot.appwhitelist.engine;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.m;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/taskrobot/appwhitelist/engine/PackageManagerInstalledChecker;", "Lcom/stepos/taskrobot/appwhitelist/engine/InstalledChecker;", "context", "Landroid/content/Context;", AppAgent.CONSTRUCT, "(Landroid/content/Context;)V", "isInstalled", "", "appName", "", "appwhitelist_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PackageManagerInstalledChecker implements InstalledChecker {
    private final Context context;

    public PackageManagerInstalledChecker(Context context) {
        k.f(context, "context");
        this.context = context;
    }

    @Override // com.stepos.taskrobot.appwhitelist.engine.InstalledChecker
    public boolean isInstalled(String appName) {
        String str;
        k.f(appName, "appName");
        if (m.s0(appName)) {
            return false;
        }
        Context context = this.context;
        k.f(context, "context");
        try {
            PackageManager packageManager = context.getPackageManager();
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
            k.e(installedPackages, "getInstalledPackages(...)");
            for (PackageInfo packageInfo : installedPackages) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                k.c(applicationInfo);
                if (appName.equals(applicationInfo.loadLabel(packageManager).toString())) {
                    str = packageInfo.packageName;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        str = null;
        return !(str == null || str.length() == 0);
    }
}
