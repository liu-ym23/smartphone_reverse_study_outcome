package com.amap.api.services.core;

import android.content.Context;
import android.content.pm.Signature;
import com.amap.api.col.s.i;
import java.security.MessageDigest;
import java.util.Locale;
import kotlin.UByte;

/* JADX INFO: loaded from: classes28.dex */
public class SearchUtils {
    public SearchUtils() {
    }

    public static String getVersion() {
        return "7.7.0";
    }

    public static String getPkgName(Context r100) {
        return r100.getApplicationContext().getPackageName();
    L4:
        th = move-exception;
        i.a(th, "SearchUtils", "getPkgName");
        return null;
    }

    public static String getSHA1(Context r100) {
        Signature[] r101 = r100.getApplicationContext().getPackageManager().getPackageInfo(r100.getPackageName(), 64).signatures;     // Catch: Throwable -> L11
        int r102 = 0;
        byte[] r103 = r101[0].toByteArray();     // Catch: Throwable -> L11
        byte[] r104 = MessageDigest.getInstance("SHA1").digest(r103);     // Catch: Throwable -> L11
        StringBuffer r105 = new StringBuffer();     // Catch: Throwable -> L11
    L4:
        if (r102 >= r104.length) goto L9;
        String r106 = Integer.toHexString(r104[r102] & UByte.MAX_VALUE).toUpperCase(Locale.US);     // Catch: Throwable -> L11
        if (r106.length() != 1) goto L8;
        r105.append("0");     // Catch: Throwable -> L11
    L8:
        r105.append(r106);     // Catch: Throwable -> L11
        r105.append(":");     // Catch: Throwable -> L11
        r102 = r102 + 1;     // Catch: Throwable -> L11
        goto L4
    L9:
        return r105.toString();
    L11:
        th = move-exception;
        i.a(th, "SearchUtils", "getSHA1");
        return null;
    }
}
