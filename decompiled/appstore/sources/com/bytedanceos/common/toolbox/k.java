package com.bytedanceos.common.toolbox;

import com.google.common.base.Ascii;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Object f10065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static char[] f10066b;

    static {
        f10065a = new Object();
        f10066b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static void a(byte r10, StringBuffer r11) {
        char[] r12 = f10066b;
        char r13 = r12[(r10 & 240) >> 4];
        char r14 = r12[r10 & Ascii.SI];
        r11.append(r13);
        r11.append(r14);
    }

    public static String b(byte[] r10) {
        return c(r10, 0, r10.length);
    }

    public static String c(byte[] r10, int r11, int r12) {
        StringBuffer r13 = new StringBuffer(r12 * 2);
        int r14 = r12 + r11;
    L3:
        if (r11 >= r14) goto L6;
        a(r10[r11], r13);
        r11 = r11 + 1;
        goto L3
    L6:
        return r13.toString();
    }

    public static String d(byte[] r10) {
        char[] r11 = new char[r10.length * 2];
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r12 >= r10.length) goto L7;
        int r14 = r13 + 1;
        char[] r15 = f10066b;
        byte r16 = r10[r12];
        r11[r13] = r15[(r16 >>> 4) & 15];
        r13 = r13 + 2;
        r11[r14] = r15[r16 & Ascii.SI];
        r12 = r12 + 1;
        goto L4
    L7:
        return new String(r11);
    }

    public static String e(File r10) {
        DigestInputStream r11 = null;
        DigestInputStream r12 = new DigestInputStream(new FileInputStream(r10), MessageDigest.getInstance("MD5"));     // Catch: Throwable -> L19 Exception -> L21
        byte[] r13 = new byte[8192];     // Catch: Throwable -> L15 Exception -> L17
    L7:
        if (r12.read(r13) > 0) goto L7;
        String r14 = d(r12.getMessageDigest().digest());     // Catch: Throwable -> L15 Exception -> L17
        r12.close();     // Catch: IOException -> L12
    L14:
        return r14;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L17:
        e = e;
        r11 = r12;
    L22:
        e.printStackTrace();     // Catch: Throwable -> L19
        if (r11 == null) goto L48;
        r11.close();     // Catch: IOException -> L26
        return "";
    L26:
        e = move-exception;
        e.printStackTrace();
        return "";
    L48:
        return "";
    L15:
        th = th;
        r11 = r12;
    L30:
        if (r11 != null) goto L41;
    L35:
        throw th;
    L41:
        r11.close();     // Catch: IOException -> L33
    L33:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = e;
    L19:
        th = th;
        goto L30
    }

    public static String f(String r10) {
        if (r10 != null) goto L5;
        return r10;
    L5:
        return g(c0.a(r10));
    }

    public static String g(byte[] r10) {
        Object r11 = f10065a;
        monitor-enter(r11);
        MessageDigest r12 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L7 Exception -> L9
        r12.update(r10);     // Catch: Throwable -> L7 Exception -> L9
        String r13 = b(r12.digest());     // Catch: Throwable -> L7 Exception -> L9
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r13;
    L7:
        th = move-exception;
        throw th;
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L7
        return "unKnown";
    }
}
