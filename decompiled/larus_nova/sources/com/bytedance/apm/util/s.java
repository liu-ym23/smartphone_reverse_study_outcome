package com.bytedance.apm.util;

/* JADX INFO: loaded from: classes6.dex */
public final class s {
    public static String a(Throwable r100, int r101) {
        StackTraceElement[] r102 = r100.getStackTrace();
        StringBuilder r103 = new StringBuilder();
        int r104 = r102.length;
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r105 >= r104) goto L9;
        StackTraceElement r107 = r102[r105];
        r106 = r106 + 1;
        r103.append("\tat " + r107.getClassName());
        r103.append(".");
        r103.append(r107.getMethodName());
        r103.append("(");
        r103.append(r107.getFileName());
        r103.append(":");
        r103.append(r107.getLineNumber());
        r103.append(")\n");
        if (r106 > r101) goto L9;
        r105 = r105 + 1;
    L9:
        return r103.toString();
    }
}
