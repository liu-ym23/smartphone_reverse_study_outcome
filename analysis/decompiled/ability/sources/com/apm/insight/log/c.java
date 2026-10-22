package com.apm.insight.log;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.apm.insight.log.a.e;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* loaded from: classes2.dex */
public class c implements e {
    public static boolean a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static String b() {
        return Application.getProcessName();
    }

    public static String d(Context context) {
        File file = new File(context.getFilesDir(), "volc_log");
        if (file.exists() && !file.isDirectory()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, "cache");
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file2.getAbsolutePath();
    }

    @Override // com.apm.insight.log.a.e
    public void c() {
        System.loadLibrary("volc_log");
    }

    public static boolean a(Context context) {
        String strB = b();
        if (strB == null || strB.contains(":")) {
            return false;
        }
        return strB.equals(context.getPackageName()) || strB.equals(context.getApplicationInfo().processName);
    }

    public static String b(Context context) {
        String str;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            str = null;
        }
        return TextUtils.isEmpty(str) ? EnvironmentCompat.MEDIA_UNKNOWN : str;
    }

    public static File c(Context context) {
        File file = new File(context.getFilesDir(), "volc_log");
        if (file.exists() && !file.isDirectory()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, "logs");
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file2;
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            if (cause instanceof UnknownHostException) {
                return "ALOG:UnknownHostException";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            th.printStackTrace(printWriter);
        } catch (Throwable unused) {
        }
        printWriter.flush();
        return stringWriter.toString();
    }
}
