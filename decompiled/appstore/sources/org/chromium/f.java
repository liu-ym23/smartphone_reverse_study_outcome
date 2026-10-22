package org.chromium;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.NetworkException;
import com.ttnet.org.chromium.net.impl.NetworkExceptionImpl;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f23045a;

    static {
    }

    public static CronetException a(int r10, int r11, String r12) {
        return new NetworkExceptionImpl("Exception in CronetUrlRequest: " + r12, g(r10), r11);
    }

    public static List b(Class r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        ArrayList r11 = new ArrayList();
    L6:
        if (r10 == null) goto L21;
        Class<?>[] r12 = r10.getInterfaces();
        int r13 = 0;
    L9:
        if (r13 >= r12.length) goto L20;
        if (r11.contains(r12[r13]) == true) goto L13;
        r11.add(r12[r13]);
    L13:
        Iterator r14 = b(r12[r13]).iterator();
    L15:
        if (r14.hasNext() == false) goto L19;
        Class r15 = (Class) r14.next();
        if (r11.contains(r15) == true) goto L15;
        r11.add(r15);
        goto L15
    L19:
        r13 = r13 + 1;
        goto L9
    L20:
        r10 = r10.getSuperclass();
        goto L6
    L21:
        return r11;
    }

    public static String c(Context r10) {
        String r11 = f23045a;
        if (TextUtils.isEmpty(r11) == true) goto L20;
        return r11;
    L20:
        int r12 = Process.myPid();     // Catch: Exception -> L13
        Iterator<ActivityManager.RunningAppProcessInfo> r13 = ((ActivityManager) r10.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L13
    L7:
        if (r13.hasNext() == false) goto L18;
        ActivityManager.RunningAppProcessInfo r14 = r13.next();     // Catch: Exception -> L13
        if (r14.pid != r12) goto L7;
        if (d.a().loggerDebug() == false) goto L15;
        d.a().loggerD("Process", "processName = " + r14.processName);     // Catch: Exception -> L13
    L15:
        String r15 = r14.processName;     // Catch: Exception -> L13
        f23045a = r15;     // Catch: Exception -> L13
        return r15;
    L18:
        String r16 = d();
        f23045a = r16;
        return r16;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    public static String d() {
        BufferedReader r10 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L14
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L19
    L5:
        int r12 = r10.read();     // Catch: Throwable -> L19
        if (r12 <= 0) goto L9;
        r11.append((char) r12);     // Catch: Throwable -> L19
        goto L5
    L9:
        if (d.a().loggerDebug() == false) goto L11;
        d.a().loggerD("Process", "get processName = " + r11.toString());     // Catch: Throwable -> L19
    L11:
        String r13 = r11.toString();     // Catch: Throwable -> L19
        r10.close();     // Catch: Exception -> L18
    L13:
        return r13;
    L15:
        if (r10 != null) goto L27;
    L17:
        return null;
    L27:
        r10.close();     // Catch: Exception -> L20
    L14:
        r10 = null;
        goto L15
    }

    public static boolean e(Context r10) {
        String r11 = c(r10);
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

    public static boolean f(Context r10) {
        int r11 = c.N().w();
        if (d.a().loggerDebug() == false) goto L6;
        d.a().loggerD("Utils", "CronetAppProvider ProcessFlag: " + r11);
    L6:
        if (r11 != 1) goto L8;
        return true;
    L8:
        if (r11 != 2) goto L10;
        return false;
    L10:
        return e(r10);
    }

    public static int g(int r10) {
        switch(r10) {
            case 1: goto L27;
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L17;
            case 7: goto L15;
            case 8: goto L13;
            case 9: goto L11;
            case 10: goto L9;
            case 11: goto L7;
            default: goto L4;
        };
    L7:
        return 11;
    L9:
        return 10;
    L11:
        return 9;
    L13:
        return 8;
    L15:
        return 7;
    L17:
        return 6;
    L19:
        return 5;
    L21:
        return 4;
    L23:
        return 3;
    L25:
        return 2;
    L27:
        return 1;
    L4:
        if (d.a().loggerDebug() == false) goto L6;
        d.a().loggerD("monitor", "Unknown error code: " + r10);
    L6:
        return r10;
    }

    public static IOException h(CronetException r10) {
        if ((r10 instanceof NetworkException) == true) goto L6;
        return r10;
    L6:
        switch(((NetworkException) r10).getErrorCode()) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L12;
            case 8: goto L10;
            case 9: goto L8;
            default: goto L17;
        };
    L8:
        IOException r11 = new NoRouteToHostException(r10.getMessage());
    L16:
        return r11;
    L10:
        r11 = new SocketException("reset by peer " + r10.getMessage());
        goto L16
    L11:
        r11 = new ConnectTimeoutException(r10.getMessage());
        goto L16
    L12:
        r11 = new ConnectException(r10.getMessage());
        goto L16
    L13:
        r11 = new SocketTimeoutException(r10.getMessage());
        goto L16
    L14:
        r11 = new ConnectException(r10.getMessage());
        goto L16
    L15:
        r11 = new UnknownHostException(r10.getMessage());
        goto L16
    L17:
        return r10;
    }
}
