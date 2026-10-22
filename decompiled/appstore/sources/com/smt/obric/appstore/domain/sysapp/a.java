package com.smt.obric.appstore.domain.sysapp;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.j;
import kotlin.Result;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static final /* synthetic */ String a(PackageInfo r10, Context r11) {
        return b(r10, r11);
    }

    public static final String b(PackageInfo r10, Context r11) {
        Object r12 = null;
        Result.a r13 = Result.Companion;     // Catch: Throwable -> L8
        ApplicationInfo r14 = r10.applicationInfo;     // Catch: Throwable -> L8
        if (r14 == null) goto L10;
        CharSequence r15 = r14.loadLabel(r11.getPackageManager());     // Catch: Throwable -> L8
        if (r15 == null) goto L10;
        String r16 = r15.toString();     // Catch: Throwable -> L8
    L11:
        Object r17 = Result.m35constructorimpl(r16);     // Catch: Throwable -> L8
    L15:
        if (Result.m41isFailureimpl(r17) == true) goto L18;
        r12 = r17;
    L18:
        String r18 = (String) r12;
        if (r18 != null) goto L24;
        return "";
    L24:
        return r18;
    L10:
        r16 = null;
    L8:
        th = move-exception;
        Result.a r19 = Result.Companion;
        r17 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L15
    }

    public static final AppInfo c(PackageInfo r10, Context r11) {
        q.g(r10, "<this>");
        q.g(r11, "context");
        String r12 = r10.packageName;
        if (r12 != null) goto L5;
        return null;
    L5:
        ApplicationInfo r13 = r10.applicationInfo;
        if (r13 != null) goto L8;
        return null;
    L8:
        String r14 = r10.versionName;
        if (r14 != null) goto L11;
        return null;
    L11:
        long r15 = r10.getLongVersionCode();
        AppInfo r16 = new AppInfo();
        r16.appPackageName = r12;
        String r17 = r13.loadLabel(r11.getPackageManager()).toString();
        if (q.b(r10.packageName, "com.obric.recorder") == false) goto L14;
        j.n("[SysAppNameDebug][LoadLaunchableSysAppUseCase] toAppInfo pkg=" + r12 + " label=" + r17 + " version=" + r15 + '/' + r14 + " labelRes=" + r13.labelRes + " nonLocalizedLabel=" + r13.nonLocalizedLabel + " flags=" + r13.flags + " sourceDir=" + r13.sourceDir + " publicSourceDir=" + r13.publicSourceDir);
    L14:
        r16.appName = r17;
        r16.appVersionName = r14;
        r16.appVersionCode = (int) r15;
        ke.a.C0288a r18 = ke.a.f21049b;
        String r19 = r10.packageName;
        q.f(r19, "packageName");
        r16.appIcon = r18.b(r19);
        return r16;
    }
}
