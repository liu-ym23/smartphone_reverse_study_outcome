package com.bytedance.platform.godzilla.utils;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class RomUtils {
    private static final CharSequence AMIGO = null;

    private RomUtils() {
    }

    static {
        AMIGO = "amigo";
    }

    public static boolean isColorOS() {
        String r0 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return false;
    L5:
        return r0.toLowerCase(Locale.getDefault()).contains("oppo");
    }

    public static boolean isAmigo() {
        if (TextUtils.isEmpty(Build.DISPLAY) == false) goto L5;
    L7:
        return false;
    L5:
        if (Build.DISPLAY.toLowerCase(Locale.getDefault()).contains(AMIGO) == false) goto L7;
        return true;
    }
}
