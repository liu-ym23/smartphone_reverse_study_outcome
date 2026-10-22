package h3;

import android.os.Process;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static String a(InputStream r10) {
        StringBuilder r11 = new StringBuilder();
        BufferedReader r12 = null;
        BufferedReader r13 = new BufferedReader(new InputStreamReader(r10));     // Catch: Throwable -> L12
    L18:
        String r14 = r13.readLine();     // Catch: Throwable -> L8
        if (r14 == null) goto L10;
        r11.append(r14);     // Catch: Throwable -> L8
        r11.append('\n');     // Catch: Throwable -> L8
        goto L18
    L10:
        r13.close();
        return r11.toString();
    L8:
        th = th;
        r12 = r13;
    L13:
        if (r12 == null) goto L15;
        r12.close();
    L15:
        throw th;
    L12:
        th = th;
        goto L13
    }

    public static String b(String r10) {
        FileInputStream r11 = new FileInputStream(new File(r10));     // Catch: Throwable -> L9
        String r12 = a(r11);     // Catch: Throwable -> L7
        r11.close();
        return r12;
    L7:
        Throwable th = th;
    L11:
        if (r11 == null) goto L13;
        r11.close();
    L13:
        throw th;
    L9:
        th = move-exception;
        r11 = null;
        th = th;
        goto L11
    }

    public static long c() {
        String[] r10 = b(String.format("/proc/%s/status", new Object[]{Integer.valueOf(Process.myPid())})).trim().split("\n");     // Catch: Exception -> L21
        int r11 = r10.length;     // Catch: Exception -> L21
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L15;
        String r13 = r10[r12];     // Catch: Exception -> L21
        if (r13.startsWith("VmSize") == false) goto L13;
        Matcher r14 = Pattern.compile("\\d+").matcher(r13);     // Catch: Exception -> L21
        if (r14.find() == false) goto L13;
        return Long.parseLong(r14.group());
    L13:
        r12 = r12 + 1;     // Catch: Exception -> L21
        goto L6
    L15:
        if (r10.length <= 12) goto L20;
        Matcher r15 = Pattern.compile("\\d+").matcher(r10[12]);     // Catch: Exception -> L21
        if (r15.find() == false) goto L20;
        return Long.parseLong(r15.group());
    L20:
        return -1;
    }
}
