package com.baidu.sec.privacy.f;

import android.content.Context;
import android.os.Process;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class e {
    public static boolean a(Context r100, String[] r101) {
        if (r101 != null) goto L16;
        return true;
    L16:
        int r102 = r101.length;     // Catch: Throwable -> L11
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L20;
        if (com_baidu_sec_privacy_f_e_android_content_Context_checkPermission(r100, r101[r103], Process.myPid(), Process.myUid()) == (-1)) goto L9;
        r103 = r103 + 1;
        goto L5
    L9:
        return false;
    L20:
        return true;
    L11:
        th = move-exception;
        c.a(th);
        return false;
    }

    private static int com_baidu_sec_privacy_f_e_android_content_Context_checkPermission(Context r110, String r111, int r210, int r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, Integer.valueOf(r210), Integer.valueOf(r211)};
        f06.b r112 = new f06.b("auto_cert_com_baidu_sec_privacy_f_e_android_content_Context_checkPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102607);
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
        f06.d r107 = r106.preInvoke(102607, "android/content/Context", "checkPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkPermission(r111, r210, r211);
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
}
