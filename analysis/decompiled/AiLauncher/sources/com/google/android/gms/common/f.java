package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.internal.C1669j;
import com.google.errorprone.annotations.RestrictedInheritance;

@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
/* loaded from: classes2.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    public static f f19717b;

    /* renamed from: a, reason: collision with root package name */
    public final Context f19718a;

    public f(Context context) {
        this.f19718a = context.getApplicationContext();
    }

    public static f a(Context context) {
        C1669j.k(context);
        synchronized (f.class) {
            try {
                if (f19717b == null) {
                    m.a(context);
                    f19717b = new f(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f19717b;
    }

    public static final zzj b(PackageInfo packageInfo, zzj... zzjVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
            for (int i10 = 0; i10 < zzjVarArr.length; i10++) {
                if (zzjVarArr[i10].equals(zzkVar)) {
                    return zzjVarArr[i10];
                }
            }
        }
        return null;
    }

    public static final boolean c(PackageInfo packageInfo, boolean z10) {
        PackageInfo packageInfo2;
        if (!z10) {
            packageInfo2 = packageInfo;
        } else if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z10 = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
            }
            packageInfo2 = packageInfo;
        } else {
            packageInfo2 = null;
        }
        if (packageInfo != null && packageInfo2.signatures != null) {
            if ((z10 ? b(packageInfo2, l.f19858a) : b(packageInfo2, l.f19858a[0])) != null) {
                return true;
            }
        }
        return false;
    }
}
