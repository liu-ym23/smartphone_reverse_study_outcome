package com.bytedance.apm.util;

import com.android.contacts.common.SimContactsConstants;
import com.bytedance.librarian.LibrarianImpl;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes2.dex */
public class StackUtils {
    private static final int MAX_STACKTRACE_DEPTH = 40;

    public StackUtils() {
    }

    public static String getThrowableStack(Throwable r2) {
        StringWriter r0 = new StringWriter();
        PrintWriter r1 = new PrintWriter(r0);
        r2.printStackTrace(r1);
        Throwable r3 = r2.getCause();
        if (r3 == null) goto L7;
        r3.printStackTrace(r1);
        Throwable r4 = r3.getCause();
        if (r4 == null) goto L7;
        r4.printStackTrace(r1);
    L7:
        String r5 = r0.toString();
        r1.close();
        if (r5.length() > 1024) goto L10;
        return r5;
    L10:
        return r5.substring(0, 1024);
    }

    public static String getStack(Throwable r1) {
        return getStackLimit(r1, 30);
    }

    public static String getStackLimit(Throwable r7, int r8) {
        StackTraceElement[] r9 = r7.getStackTrace();
        StringBuilder r0 = new StringBuilder();
        int r1 = r9.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L9;
        StackTraceElement r4 = r9[r2];
        r3 = r3 + 1;
        r0.append("\tat " + r4.getClassName()).append(LibrarianImpl.Constants.DOT).append(r4.getMethodName()).append("(").append(r4.getFileName()).append(SimContactsConstants.ANR_SEP).append(r4.getLineNumber()).append(")\n");
        if (r3 > r8) goto L9;
        r2 = r2 + 1;
    L9:
        return r0.toString();
    }

    public static String getStackTraces(StackTraceElement[] r5) throws IllegalArgumentException {
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
        r0.append("\tat " + r5[r2].getClassName()).append(LibrarianImpl.Constants.DOT).append(r5[r2].getMethodName()).append("(").append(r5[r2].getFileName()).append(SimContactsConstants.ANR_SEP).append(r5[r2].getLineNumber()).append(")\n");
        goto L20
    L17:
        if ("getStackTrace".equals(r5[1].getMethodName()) == false) goto L19;
    L22:
        return r0.toString();
    L24:
        throw new IllegalArgumentException("stackTraceElements must not be null or empty");
    }
}
