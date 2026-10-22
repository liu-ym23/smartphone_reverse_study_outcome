package ef;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.e;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f19427a;

    static {
    }

    public static String a(Context r10) {
        String r11 = f19427a;
        if (e.b(r11) == true) goto L20;
        return r11;
    L20:
        int r12 = Process.myPid();     // Catch: Exception -> L13
        Iterator<ActivityManager.RunningAppProcessInfo> r13 = ((ActivityManager) r10.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L13
    L7:
        if (r13.hasNext() == false) goto L18;
        ActivityManager.RunningAppProcessInfo r14 = r13.next();     // Catch: Exception -> L13
        if (r14.pid != r12) goto L7;
        if (Logger.debug() == false) goto L15;
        Logger.d("Process", "processName = " + r14.processName);     // Catch: Exception -> L13
    L15:
        String r15 = r14.processName;     // Catch: Exception -> L13
        f19427a = r15;     // Catch: Exception -> L13
        return r15;
    L18:
        String r16 = b();
        f19427a = r16;
        return r16;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    public static String b() {
        BufferedReader r10 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L14
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L19
    L5:
        int r12 = r10.read();     // Catch: Throwable -> L19
        if (r12 <= 0) goto L9;
        r11.append((char) r12);     // Catch: Throwable -> L19
        goto L5
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.d("Process", "get processName = " + r11.toString());     // Catch: Throwable -> L19
    L11:
        String r13 = r11.toString();     // Catch: Throwable -> L19
        r10.close();     // Catch: Exception -> L18
    L13:
        return r13;
    L15:
        if (r10 != null) goto L25;
    L17:
        return null;
    L25:
        r10.close();     // Catch: Exception -> L20
    L14:
        r10 = null;
        goto L15
    }

    public static boolean c(Context r10) {
        String r11 = a(r10);
        if (r11 != null) goto L5;
    L7:
        if (r11 != null) goto L9;
        return false;
    L9:
        if (r11.equals(r10.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r11.contains(":") == false) goto L7;
        return false;
    }
}
