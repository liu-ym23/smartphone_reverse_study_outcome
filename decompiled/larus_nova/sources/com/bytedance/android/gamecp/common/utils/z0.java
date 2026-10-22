package com.bytedance.android.gamecp.common.utils;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.common.utility.Logger;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Locale;

/* JADX INFO: loaded from: classes44.dex */
public final class z0 extends n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f57330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f57331b;

    public static boolean c() {
        String r100 = Build.MANUFACTURER;
        if (r100 == null) goto L9;
        if (r100.toLowerCase(Locale.getDefault()).equals(DimLocationCheckUtil.VIVO) == false) goto L9;
        return true;
    L9:
        return a("VIVO");
    }

    public static boolean a(String r100) {
        String r101 = f57330a;
        if (r101 == null) goto L7;
        return r101.equals(r100);
    L7:
        if (TextUtils.isEmpty(b("ro.miui.ui.version.name")) == true) goto L10;
        f57331b = b("ro.miui.ui.version.name");
        f57330a = "MIUI";
    L26:
        return f57330a.equals(r100);
    L10:
        if (TextUtils.isEmpty(b(com.alipay.sdk.m.c.a.f25238a)) == true) goto L13;
        f57331b = b(com.alipay.sdk.m.c.a.f25238a);
        f57330a = "EMUI";
        goto L26
    L13:
        if (TextUtils.isEmpty(b("ro.build.version.opporom")) == true) goto L16;
        f57331b = b("ro.build.version.opporom");
        f57330a = "OPPO";
        goto L26
    L16:
        if (TextUtils.isEmpty(b("ro.vivo.os.version")) == true) goto L19;
        f57331b = b("ro.vivo.os.version");
        f57330a = "VIVO";
        goto L26
    L19:
        if (TextUtils.isEmpty(b("ro.smartisan.version")) == true) goto L21;
        f57331b = b("ro.smartisan.version");
        f57330a = "SMARTISAN";
        goto L26
    L21:
        String r102 = Build.DISPLAY;
        f57331b = r102;
        if (r102.toUpperCase(Locale.getDefault()).contains("FLYME") == false) goto L24;
        f57330a = "FLYME";
        goto L26
    L24:
        f57331b = "unknown";
        f57330a = Build.MANUFACTURER.toUpperCase(Locale.getDefault());
        goto L26
    }

    public static String b(String r100) {
        Class r101 = h1.a();     // Catch: Exception -> L8
        String r102 = (String) r101.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r101, new Object[]{r100});     // Catch: Exception -> L8
        Logger.d("SystemPropertiesUtil", "key is:" + r100 + " prop is: " + r102);     // Catch: Exception -> L6
    L11:
        return r102;
    L6:
        e = e;
    L10:
        Logger.e("SystemPropertiesUtil", "read the content of build.prop exception.", e);
    L8:
        e = e;
        r102 = "";
        goto L10
    }
}
