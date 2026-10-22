package d3;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/* renamed from: d3.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0669e {

    /* renamed from: a, reason: collision with root package name */
    public static String f16616a;

    public static String a(Context context) throws Throwable {
        if (!TextUtils.isEmpty(f16616a)) {
            return f16616a;
        }
        String strD = d();
        f16616a = strD;
        if (!TextUtils.isEmpty(strD)) {
            return f16616a;
        }
        String strC = c();
        f16616a = strC;
        if (!TextUtils.isEmpty(strC)) {
            return f16616a;
        }
        String strE = e();
        f16616a = strE;
        if (!TextUtils.isEmpty(strE)) {
            return f16616a;
        }
        String strB = b(context);
        f16616a = strB;
        return strB;
    }

    private static String b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            int iMyPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        return null;
    }

    private static String c() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, null);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String d() {
        return Application.getProcessName();
    }

    private static String e() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        String str;
        IOException e6;
        String line;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/proc/" + Process.myPid() + "/cmdline"))));
            } catch (Exception e7) {
                e = e7;
                str = null;
            }
        } catch (Throwable th2) {
            bufferedReader = bufferedReader2;
            th = th2;
        }
        try {
            line = bufferedReader.readLine();
            if (line != null) {
                line = line.trim();
            }
            try {
                bufferedReader.close();
                return line;
            } catch (IOException e8) {
                e6 = e8;
                e6.printStackTrace();
                return line;
            }
        } catch (Exception e9) {
            e = e9;
            str = null;
            bufferedReader2 = bufferedReader;
            e.printStackTrace();
            if (bufferedReader2 == null) {
                return str;
            }
            try {
                bufferedReader2.close();
                return str;
            } catch (IOException e10) {
                String str2 = str;
                e6 = e10;
                line = str2;
                e6.printStackTrace();
                return line;
            }
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            }
            throw th;
        }
    }
}
