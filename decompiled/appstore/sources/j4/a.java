package j4;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.e;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.google.common.primitives.UnsignedBytes;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f20903a;

    static {
    }

    public static String a(byte[] r10) {
        StringBuilder r11 = new StringBuilder("");
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L10;
        String r13 = Integer.toHexString(r10[r12] & UnsignedBytes.MAX_VALUE);
        if (r13.length() != 1) goto L8;
        r13 = AdReportParam.ClickPosType.SKIP + r13;
    L8:
        r11.append(r13);
        r11.append(" ");
        r12 = r12 + 1;
        goto L4
    L10:
        return r11.toString().toUpperCase().trim();
    }

    public static String b(Context r10) {
        String r11 = f20903a;
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
        f20903a = r15;     // Catch: Exception -> L13
        return r15;
    L18:
        String r16 = c();
        f20903a = r16;
        return r16;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    public static String c() {
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

    public static String d(long r10) {
        return DateFormat.getDateTimeInstance().format(new Date(r10));
    }

    public static boolean e(Context r10) {
        String r11 = b(r10);
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

    public static boolean f(Context r10, String r11) {
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

    public static boolean g(String r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (r10.endsWith(":push") == false) goto L6;
        return true;
    }

    public static String h(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L17;
        return "";
    L17:
        byte[] r11 = MessageDigest.getInstance("MD5").digest(r10.getBytes());     // Catch: NoSuchAlgorithmException -> L10
        StringBuilder r12 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L10
        int r13 = r11.length;     // Catch: NoSuchAlgorithmException -> L10
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L13;
        String r15 = Integer.toHexString(r11[r14] & UnsignedBytes.MAX_VALUE);     // Catch: NoSuchAlgorithmException -> L10
        if (r15.length() != 1) goto L12;
        r15 = AdReportParam.ClickPosType.SKIP + r15;     // Catch: NoSuchAlgorithmException -> L10
    L12:
        r12.append(r15);     // Catch: NoSuchAlgorithmException -> L10
        r14 = r14 + 1;     // Catch: NoSuchAlgorithmException -> L10
        goto L6
    L13:
        return r12.toString();
    L10:
        e = move-exception;
        e.printStackTrace();
        return "";
    }
}
