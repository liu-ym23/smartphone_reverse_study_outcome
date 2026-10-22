package com.baidu.mshield.utility;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.miui.easygo.constant.EasyGoConstant;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f32458a = null;

    static {
        f32458a = new String[]{"On7h9W1_KIkIa50wk9Fnl1friw1cdOsubmr_O-Hrgss=", "73Ry_SRX9WDHPoeAkGWfJbuntGR7RQ3rde1s6KyyCoo=", "iQirV45vitYDQfzxgr68ylBY1DWLBKje2Pl428sE27Q=", "czwe2zUrt14MfnaeH474T5prOCIik3agOnBud_KwFa0=", "JzLix2JtXzSSsVkQFD0Cnf37028Rco5rGb7_-t_C8Qk=", "lUApGLCwwTIqYrpC4ZaqkVItjc8DeoJ5fB_pxizrjnc=", "6PzPHS4JINi0q8yUj180JTMbpq1Q44DuQggknxVmVPA=", "fCbyLrInjq1BOByP4wH4mUGBidquiIKIy6zcJCBuKtk=", "qEeaB7chq_oSIUyWhq_EwETFQIu3w3myIFyGD80p_u8=", "UNzyljxPfmKANfePasqvdfmpLS4aJ1v0S1Aj2BGl75o=", "8aRmj9NoeaLTFLe54rCmNLYIZoWE7hrVdjvM3xBfHQ4=", "WtGvBTWjt2PyMX5rQclkgiNR3aDxFtoBNe1UnNpbL1I="};
    }

    public static boolean a(String r100, String r101) {
        if (r100.equals(r101) == false) goto L6;
        return true;
    L6:
        String[] r102 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: Throwable -> L21
        String[] r103 = r101.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: Throwable -> L21
        int r104 = 0;
    L8:
        if (r104 >= r102.length) goto L17;
        if (r104 >= r103.length) goto L17;
        int r105 = Integer.valueOf(r102[r104]).intValue() - Integer.valueOf(r103[r104]).intValue();     // Catch: Throwable -> L21
        if (r105 != 0) goto L13;
        r104 = r104 + 1;     // Catch: Throwable -> L21
        goto L8
    L13:
        if (r105 <= 0) goto L27;
        return true;
    L27:
        return false;
    L17:
        if (r102.length <= r103.length) goto L28;
        return true;
    L28:
        return false;
    L29:
        return false;
    }

    private static ContentProviderClient com_baidu_mshield_utility_g_android_content_ContentResolver_acquireUnstableContentProviderClient(ContentResolver r110, Uri r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240008);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r110, r101, "android.content.ContentProviderClient", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ContentProviderClient) r107.f474983b;
    L21:
        return r110.acquireUnstableContentProviderClient(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Bundle a(Context r100, String r101, Bundle r102) {
        return a(r100, r101, r102, "mshield");
    }

    public static Bundle a(Context r100, String r101, Bundle r102, Uri r103) {
        ContentResolver r104 = r100.getApplicationContext().getContentResolver();     // Catch: Throwable -> L29
        int r105 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L29
        ContentProviderClient r106 = com_baidu_mshield_utility_g_android_content_ContentResolver_acquireUnstableContentProviderClient(r104, r103);     // Catch: Throwable -> L13
        Bundle r107 = r106.call(r101, null, r102);     // Catch: Throwable -> L11
        if (r105 >= 24) goto L9;
        r106.release();     // Catch: Throwable -> L29
    L10:
        return r107;
    L9:
        r106.close();     // Catch: Throwable -> L29
    L11:
        th = th;
    L35:
        a.a(th);     // Catch: Throwable -> L22
        if (r106 != null) goto L18;
    L21:
        return null;
    L18:
        if (Build.VERSION.SDK_INT >= 24) goto L20;
        r106.release();     // Catch: Throwable -> L29
        goto L21
    L20:
        r106.close();     // Catch: Throwable -> L29
        goto L21
    L22:
        th = move-exception;
        if (r106 != null) goto L25;
    L28:
        throw th;     // Catch: Throwable -> L29
    L25:
        if (Build.VERSION.SDK_INT >= 24) goto L27;
        r106.release();     // Catch: Throwable -> L29
        goto L28
    L27:
        r106.close();     // Catch: Throwable -> L29
    L13:
        th = th;
        r106 = null;
    L29:
        th = move-exception;
        a.a(th);
        return null;
    }

    public static Bundle a(Context r100, String r101, Bundle r102, String r103) {
        r100.getApplicationContext().getContentResolver();     // Catch: Throwable -> L4
        return a(r100, r101, r102, Uri.parse("content://" + r100.getPackageName() + "." + r103 + ".ac.provider"));
    L4:
        th = move-exception;
        a.a(th);
        return null;
    }

    public static Bundle a(Context r110, String r111, Bundle r112, boolean r113, String r210, boolean r211) {
        ProviderInfo[] r100 = r110.getPackageManager().getPackageInfo(r110.getPackageName(), 8).providers;     // Catch: Throwable -> L5
    L7:
        if (r100 != null) goto L9;
    L44:
        return null;
    L9:
        if (r100.length <= 0) goto L44;
        String[] r101 = f32458a;     // Catch: Throwable -> L45
        int r102 = r101.length;     // Catch: Throwable -> L45
        int r103 = 0;
        boolean r104 = false;
    L12:
        if (r103 >= r102) goto L47;
        String r105 = new String(com.baidu.mshield.b.f.d.a(Base64.decode(r101[r103], 10), com.baidu.mshield.b.f.a.a(16)), "UTF-8");     // Catch: Throwable -> L16
    L19:
        if (TextUtils.isEmpty(r105) == true) goto L43;
        if ("mshield".equals(r105) == false) goto L25;
        if (r113 == false) goto L23;
        r104 = true;
        goto L25
    L23:
        return null;
    L25:
        StringBuilder r106 = new StringBuilder("content://");     // Catch: Throwable -> L45
        r106.append(r110.getPackageName());     // Catch: Throwable -> L45
        r106.append(".");     // Catch: Throwable -> L45
        r106.append(r105);     // Catch: Throwable -> L45
        r106.append(".ac.provider");     // Catch: Throwable -> L45
        String r107 = r106.toString();     // Catch: Throwable -> L45
        com.baidu.mshield.b.c.a.b("request targetUri=" + r107);     // Catch: Throwable -> L45
        int r108 = r100.length;     // Catch: Throwable -> L45
        int r114 = 0;
    L26:
        if (r114 >= r108) goto L40;
        String r115 = r100[r114].authority;     // Catch: Throwable -> L45
        com.baidu.mshield.b.c.a.b("request authority=" + r115);     // Catch: Throwable -> L45
        if (r107.contains(r115) == false) goto L38;
        Bundle r116 = a(r110, r111, r112, Uri.parse(r106.toString()));     // Catch: Throwable -> L45
        if (r211 == false) goto L35;
        boolean r117 = r116.getBoolean("handle_flag");     // Catch: Throwable -> L45
        String r109 = r116.getString("server_version");     // Catch: Throwable -> L45
        if (r117 == false) goto L38;
        if (a(r109, r210) == false) goto L38;
    L35:
        return r116;
    L38:
        r114 = r114 + 1;
        goto L26
    L40:
        if (r104 == true) goto L47;
    L43:
        r103 = r103 + 1;
    L16:
        th = move-exception;
        a.a(th);     // Catch: Throwable -> L45
        r105 = null;
    L47:
        return null;
    L5:
        th = move-exception;
        a.a(th);     // Catch: Throwable -> L45
        r100 = null;
    L45:
        th = move-exception;
        a.a(th);
        goto L47
    }
}
