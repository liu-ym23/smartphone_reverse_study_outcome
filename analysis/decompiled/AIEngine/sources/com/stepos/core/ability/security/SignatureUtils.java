package com.stepos.core.ability.security;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import kotlin.jvm.internal.g;
import l7.a;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SignatureUtils {
    public static final SignatureUtils INSTANCE = new SignatureUtils();
    private static final String TAG = "SignatureUtils";

    private SignatureUtils() {
    }

    private final boolean hasSameSignature(String str, String str2) {
        try {
            Context context = a.f10344a;
            if (context != null) {
                return context.getPackageManager().checkSignatures(str, str2) == 0;
            }
            throw new IllegalStateException("ContextHolder must be initialized before use!");
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean isCallerTrusted(int i10) {
        ApplicationInfo applicationInfo;
        Context context = a.f10344a;
        if (context == null) {
            context = null;
        }
        if (context == null) {
            Log.w(TAG, "isCallerTrusted denied: service not ready (ContextHolder uninitialized), uid=" + i10);
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        String[] packagesForUid = packageManager.getPackagesForUid(i10);
        if (packagesForUid == null) {
            return false;
        }
        for (String str : packagesForUid) {
            try {
                applicationInfo = packageManager.getPackageInfo(str, 134217728).applicationInfo;
            } catch (PackageManager.NameNotFoundException unused) {
                a0.a.A("Package not found: ", str, TAG);
            }
            if (((applicationInfo != null ? applicationInfo.flags : 0) & 129) != 0) {
                return true;
            }
            String packageName = context.getPackageName();
            g.e(packageName, "getPackageName(...)");
            g.c(str);
            if (hasSameSignature(packageName, str)) {
                return true;
            }
        }
        Log.w(TAG, "Untrusted caller uid=" + i10 + ", packages=" + l.q0(packagesForUid));
        return false;
    }
}
