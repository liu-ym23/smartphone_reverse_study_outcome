package com.baidu.location.c.b;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class b implements a {
    public static int a(Object obj, String str) throws Exception {
        Method declaredMethod = obj.getClass().getDeclaredMethod(str, null);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return ((Integer) declaredMethod.invoke(obj, null)).intValue();
    }

    private static String b(Context context) {
        String absolutePath;
        if (context != null) {
            try {
                absolutePath = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES).getAbsolutePath();
            } catch (Exception unused) {
            }
        } else {
            absolutePath = null;
        }
        if (absolutePath != null) {
            try {
                File file = new File(absolutePath.concat("/baidu/tempdata"));
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return absolutePath;
    }

    public static String a(Context context) {
        String strB = b(context);
        if (strB == null) {
            return null;
        }
        return strB.concat("/baidu/tempdata");
    }

    public static boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable th) {
            if (a.f5616c) {
                th.printStackTrace();
            }
            return false;
        }
    }
}
