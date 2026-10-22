package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.col.jmsl.C1631z1;
import io.ktor.sse.ServerSentEventKt;
import java.security.MessageDigest;
import java.util.Locale;

/* loaded from: classes.dex */
public class SearchUtils {
    public static String getPkgName(Context context) {
        try {
            return context.getApplicationContext().getPackageName();
        } catch (Throwable th) {
            C1631z1.o(th, "SearchUtils", "getPkgName");
            return null;
        }
    }

    public static String getSHA1(Context context) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b10 : bArrDigest) {
                String upperCase = Integer.toHexString(b10 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(ServerSentEventKt.COLON);
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            C1631z1.o(th, "SearchUtils", "getSHA1");
            return null;
        }
    }

    public static String getVersion() {
        return "9.8.1";
    }
}
