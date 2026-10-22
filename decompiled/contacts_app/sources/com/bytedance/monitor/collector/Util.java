package com.bytedance.monitor.collector;

import android.text.TextUtils;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.util.HanziToPinyin;
import com.bytedance.librarian.LibrarianImpl;

/* JADX INFO: loaded from: classes2.dex */
public class Util {
    private static final String INVALID_STACK = "Invalid Stack\n";
    public static boolean enable = false;
    public static boolean enableLooperObserver = false;
    public static boolean enableLooperOpt = false;

    static {
    }

    private Util() {
    }

    public static String parseMessageKey(String r9) {
        if (TextUtils.isEmpty(r9) == false) goto L43;
        return "unknown message";
    L43:
        String[] r3 = r9.split(SimContactsConstants.ANR_SEP);     // Catch: Throwable -> L40
        if (r3.length != 2) goto L10;
        String r4 = r3[1];     // Catch: Throwable -> L40
    L12:
        if (r9.contains("{") == true) goto L14;
    L17:
        String r5 = r9;
    L19:
        if (r9.contains("@") == false) goto L24;
        String[] r2 = r9.split("@");     // Catch: Throwable -> L38
        if (r2.length <= 1) goto L24;
        r9 = r2[0];     // Catch: Throwable -> L38
    L24:
        if (r9.contains("(") == false) goto L34;
        if (r9.contains(")") == false) goto L34;
        if (r9.endsWith(" null") == true) goto L34;
        String[] r6 = r9.split("\\(");     // Catch: Throwable -> L38
        if (r6.length <= 1) goto L32;
        r9 = r6[1];     // Catch: Throwable -> L38
    L32:
        r9 = r9.replace(")", "");     // Catch: Throwable -> L38
    L34:
        if (r9.startsWith(HanziToPinyin.Token.SEPARATOR) == false) goto L36;
        r9 = r9.replace(HanziToPinyin.Token.SEPARATOR, "");     // Catch: Throwable -> L38
    L36:
        return r9 + r4;
    L39:
        return r5;
    L14:
        if (r9.contains("}") == false) goto L17;
        r5 = r9.split("\\{")[0];     // Catch: Throwable -> L40
        r9 = r5 + r9.split("\\}")[1];     // Catch: Throwable -> L38
        goto L19
    L10:
        r4 = "";
    L45:
        return r9;
    }

    public static String stackToString(StackTraceElement[] r7) {
        if (r7 != null) goto L5;
        return INVALID_STACK;
    L5:
        StringBuilder r0 = new StringBuilder();
        int r1 = r7.length;
        int r2 = 0;
        int r3 = 0;
    L6:
        if (r2 >= r1) goto L12;
        StackTraceElement r4 = r7[r2];
        r3 = r3 + 1;
        r0.append("\tat " + r4.getClassName()).append(LibrarianImpl.Constants.DOT).append(r4.getMethodName()).append("(").append(r4.getFileName()).append(SimContactsConstants.ANR_SEP).append(r4.getLineNumber()).append(")\n");
        if (r3 > 40) goto L12;
        r2 = r2 + 1;
    L12:
        return r0.toString();
    }

    public static String stackToString(StackTraceElement[] r8, String r9) {
        if (r8 != null) goto L5;
        return INVALID_STACK;
    L5:
        StringBuilder r0 = new StringBuilder();
        int r1 = r8.length;
        int r2 = 0;
        int r3 = 0;
        boolean r4 = false;
    L6:
        if (r2 >= r1) goto L17;
        StackTraceElement r5 = r8[r2];
        r3 = r3 + 1;
        if (r4 == false) goto L10;
        r0.append("at " + r5.getClassName()).append(LibrarianImpl.Constants.DOT).append(r5.getMethodName()).append("(").append(r5.getFileName()).append(SimContactsConstants.ANR_SEP).append(r5.getLineNumber()).append(")\n");
        if (r3 > 40) goto L17;
    L15:
        r2 = r2 + 1;
        goto L6
    L10:
        if (r5.getMethodName().equals(r9) == false) goto L15;
        r4 = true;
    L17:
        return r0.toString();
    }

    public static String getTopMethodName(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L8;
        int r0 = r2.indexOf("at ") + 3;
        int r1 = r2.indexOf(40);
        if (r0 < r1) goto L7;
        return "unknownMethodName";
    L7:
        return r2.substring(r0, r1);
    L8:
        return "unknownMethodName";
    }

    public static String stackToStringWithESC(StackTraceElement[] r7) {
        if (r7 != null) goto L5;
        return INVALID_STACK;
    L5:
        StringBuilder r0 = new StringBuilder();
        int r1 = r7.length;
        int r2 = 0;
        int r3 = 0;
    L6:
        if (r2 >= r1) goto L12;
        StackTraceElement r4 = r7[r2];
        r3 = r3 + 1;
        r0.append("\\tat " + r4.getClassName()).append(LibrarianImpl.Constants.DOT).append(r4.getMethodName()).append("(").append(r4.getFileName()).append(SimContactsConstants.ANR_SEP).append(r4.getLineNumber()).append(")\\n");
        if (r3 > 40) goto L12;
        r2 = r2 + 1;
    L12:
        return r0.toString();
    }
}
