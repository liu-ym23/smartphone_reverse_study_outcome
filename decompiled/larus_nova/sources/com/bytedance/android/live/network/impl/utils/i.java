package com.bytedance.android.live.network.impl.utils;

import android.os.Build;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes46.dex */
public final class i {
    public static int b() {
        boolean r100 = false;
        if (Build.VERSION.SDK_INT < 33) goto L10;
        if (a("android.permission.ACCESS_FINE_LOCATION") == true) goto L7;
    L14:
        if (r100 == false) goto L16;
        return 1;
    L16:
        return 2;
    L7:
        if (a("android.permission.ACCESS_COARSE_LOCATION") == false) goto L14;
    L8:
        r100 = true;
        goto L14
    L10:
        if (a("android.permission.ACCESS_FINE_LOCATION") == true) goto L8;
        if (a("android.permission.ACCESS_COARSE_LOCATION") == false) goto L14;
        goto L14
    }

    public static boolean a(String r100) {
        if (ContextCompat.checkSelfPermission(jc1.a.b().getApplicationContext(), r100) != 0) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        e.getLocalizedMessage();
        return false;
    }
}
