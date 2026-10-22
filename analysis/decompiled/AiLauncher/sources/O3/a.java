package O3;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public class a {
    public static String a(Context context, String str) {
        return e(context, str, "SHA1");
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c(str.getBytes(), "MD5");
    }

    public static String c(byte[] bArr, String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance(str).digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b10 : bArrDigest) {
                int i10 = b10 & 255;
                if (i10 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i10));
            }
            return stringBuffer.toString();
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static boolean d(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String packageName = context.getPackageName();
        return TextUtils.equals(str2, f(packageName + a(context, packageName) + str));
    }

    public static String e(Context context, String str, String str2) {
        try {
            return c(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray(), str2);
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String f(String str) {
        String strB = b(str);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        try {
            return strB.substring(8, 24);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
