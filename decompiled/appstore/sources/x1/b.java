package x1;

import i5.d;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static LinkedList a(int r14) {
        File[] r15 = new File("/proc/" + r14 + "/task/").listFiles();
        LinkedList r10 = new LinkedList();
        int r11 = r15.length;
        BufferedReader r12 = null;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L18;
        BufferedReader r16 = new BufferedReader(new InputStreamReader(new FileInputStream(r15[r13].getPath() + "/stat")), 1000);     // Catch: Throwable -> L11 Exception -> L19 FileNotFoundException -> L16
        String r17 = r16.readLine();     // Catch: Throwable -> L8 Exception -> L10
        int r18 = r17.lastIndexOf(41);     // Catch: Throwable -> L8 Exception -> L10
        String r19 = r17.substring(0, r18);     // Catch: Throwable -> L8 Exception -> L10
        String r20 = r17.substring(r18 + 4);     // Catch: Throwable -> L8 Exception -> L10
        int r21 = r19.indexOf(40);     // Catch: Throwable -> L8 Exception -> L10
        int r22 = Integer.valueOf(r19.substring(0, r21 - 1)).intValue();     // Catch: Throwable -> L8 Exception -> L10
        String r23 = r19.substring(r21 + 1);     // Catch: Throwable -> L8 Exception -> L10
        String[] r24 = r20.split(" ");     // Catch: Throwable -> L8 Exception -> L10
        r10.add(new a(r22, r23, Long.parseLong(r24[10]) + Long.parseLong(r24[11])));     // Catch: Throwable -> L8 Exception -> L10
        d.b(r16);
        r12 = r16;
    L17:
        r13 = r13 + 1;
        goto L3
    L10:
        r12 = r16;
    L8:
        th = th;
        r12 = r16;
    L12:
        d.b(r12);
        throw th;
    L16:
        d.b(r12);
    L11:
        th = th;
    L14:
        d.b(r12);
        return null;
    L18:
        return r10;
    }
}
