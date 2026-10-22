package com.bytedance.apm.util;

/* JADX INFO: compiled from: StackUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class u {
    public static String a(Throwable r1) {
        return a(r1, 30);
    }

    public static String a(Throwable r7, int r8) {
        StackTraceElement[] r9 = r7.getStackTrace();
        StringBuilder r0 = new StringBuilder();
        int r1 = r9.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L9;
        StackTraceElement r4 = r9[r2];
        r3 = r3 + 1;
        r0.append("\tat " + r4.getClassName()).append(".").append(r4.getMethodName()).append("(").append(r4.getFileName()).append(":").append(r4.getLineNumber()).append(")\n");
        if (r3 > r8) goto L9;
        r2 = r2 + 1;
    L9:
        return r0.toString();
    }

    public static String a(StackTraceElement[] r5) {
        if (r5 == null) goto L24;
        if (r5.length <= 0) goto L24;
        StringBuilder r0 = new StringBuilder(r5.length * 30);
        int r2 = 0;
    L7:
        if (r2 >= r5.length) goto L22;
        if (r2 > 40) goto L22;
        if (r2 != 0) goto L15;
        if ("getThreadStackTrace".equals(r5[0].getMethodName()) == false) goto L15;
    L20:
        r2 = r2 + 1;
    L15:
        if (r2 == 1) goto L17;
    L19:
        r0.append("\tat " + r5[r2].getClassName()).append(".").append(r5[r2].getMethodName()).append("(").append(r5[r2].getFileName()).append(":").append(r5[r2].getLineNumber()).append(")\n");
        goto L20
    L17:
        if ("getStackTrace".equals(r5[1].getMethodName()) == false) goto L19;
    L22:
        return r0.toString();
    L24:
        throw new IllegalArgumentException("stackTraceElements must not be null or empty");
    }
}
