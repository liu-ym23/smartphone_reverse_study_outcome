package d6;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f19101a;

    public static String a() {
        BufferedReader r10 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L11
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L16
    L5:
        int r12 = r10.read();     // Catch: Throwable -> L16
        if (r12 <= 0) goto L8;
        r11.append((char) r12);     // Catch: Throwable -> L16
        goto L5
    L8:
        String r13 = r11.toString();     // Catch: Throwable -> L16
        r10.close();     // Catch: Exception -> L15
    L10:
        return r13;
    L12:
        if (r10 != null) goto L22;
    L14:
        return null;
    L22:
        r10.close();     // Catch: Exception -> L17
    L11:
        r10 = null;
        goto L12
    }

    public static String b(Context r10) {
        if (TextUtils.isEmpty(f19101a) == false) goto L5;
        int r11 = Process.myPid();     // Catch: Exception -> L13
        Iterator<ActivityManager.RunningAppProcessInfo> r12 = ((ActivityManager) r10.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L13
    L8:
        if (r12.hasNext() == false) goto L15;
        ActivityManager.RunningAppProcessInfo r13 = r12.next();     // Catch: Exception -> L13
        if (r13.pid != r11) goto L8;
        String r14 = r13.processName;     // Catch: Exception -> L13
        f19101a = r14;     // Catch: Exception -> L13
        return r14;
    L15:
        String r15 = a();
        f19101a = r15;
        return r15;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        return f19101a;
    }
}
