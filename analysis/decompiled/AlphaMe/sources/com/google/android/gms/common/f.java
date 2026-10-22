package com.google.android.gms.common;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static f f9718a;

    public static final zzj a(PackageInfo packageInfo, zzj... zzjVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
        for (int i4 = 0; i4 < zzjVarArr.length; i4++) {
            if (zzjVarArr[i4].equals(zzkVar)) {
                return zzjVarArr[i4];
            }
        }
        return null;
    }

    public static final boolean b(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo;
        boolean z4 = packageInfo == null || !(("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) && ((applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 129) == 0));
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z4 ? a(packageInfo, i.f9724a) : a(packageInfo, i.f9724a[0])) != null) {
                return true;
            }
        }
        return false;
    }
}
