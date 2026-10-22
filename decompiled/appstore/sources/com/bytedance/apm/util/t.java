package com.bytedance.apm.util;

import com.bytedance.librarian.LibrarianImpl;

/* JADX INFO: loaded from: classes.dex */
public abstract class t {
    public static String a(Throwable r10) {
        return b(r10, 30);
    }

    public static String b(Throwable r10, int r11) {
        StackTraceElement[] r12 = r10.getStackTrace();
        StringBuilder r13 = new StringBuilder();
        int r14 = r12.length;
        int r15 = 0;
        int r16 = 0;
    L3:
        if (r15 >= r14) goto L9;
        StackTraceElement r17 = r12[r15];
        r16 = r16 + 1;
        r13.append("\tat " + r17.getClassName());
        r13.append(LibrarianImpl.Constants.DOT);
        r13.append(r17.getMethodName());
        r13.append("(");
        r13.append(r17.getFileName());
        r13.append(":");
        r13.append(r17.getLineNumber());
        r13.append(")\n");
        if (r16 > r11) goto L9;
        r15 = r15 + 1;
    L9:
        return r13.toString();
    }

    public static String c(StackTraceElement[] r10) {
        if (r10 == null) goto L24;
        if (r10.length <= 0) goto L24;
        StringBuilder r11 = new StringBuilder(r10.length * 30);
        int r12 = 0;
    L7:
        if (r12 >= r10.length) goto L22;
        if (r12 > 40) goto L22;
        if (r12 != 0) goto L15;
        if ("getThreadStackTrace".equals(r10[0].getMethodName()) == false) goto L15;
    L20:
        r12 = r12 + 1;
    L15:
        if (r12 == 1) goto L17;
    L19:
        r11.append("\tat " + r10[r12].getClassName());
        r11.append(LibrarianImpl.Constants.DOT);
        r11.append(r10[r12].getMethodName());
        r11.append("(");
        r11.append(r10[r12].getFileName());
        r11.append(":");
        r11.append(r10[r12].getLineNumber());
        r11.append(")\n");
        goto L20
    L17:
        if ("getStackTrace".equals(r10[1].getMethodName()) == false) goto L19;
    L22:
        return r11.toString();
    L24:
        throw new IllegalArgumentException("stackTraceElements must not be null or empty");
    }
}
