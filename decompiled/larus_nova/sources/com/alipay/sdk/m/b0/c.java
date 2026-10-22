package com.alipay.sdk.m.b0;

import android.os.Environment;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: classes28.dex */
public final class c {
    public static String a(String r100) {
        if (a() == false) goto L9;
        PolarisFileWrapper r101 = new PolarisFileWrapper(Environment.getExternalStorageDirectory().getAbsolutePath(), r100);     // Catch: Exception -> L11
        if (r101.exists() == false) goto L14;
        r101.delete();     // Catch: Exception -> L11
        return "";
    L14:
        return null;
    L9:
        return null;
    L15:
        return null;
    }

    public static boolean a() {
        String r100 = Environment.getExternalStorageState();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.length() > 0) goto L7;
        return false;
    L7:
        if (r100.equals("mounted") == true) goto L11;
        if (r100.equals("mounted_ro") == true) goto L11;
        return false;
    L11:
        if (Environment.getExternalStorageDirectory() == null) goto L18;
        return true;
    L18:
        return false;
    }
}
