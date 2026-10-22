package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.view.View;
import java.nio.CharBuffer;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static String a() {
        StackTraceElement r10 = new Throwable().getStackTrace()[1];
        return ".(" + r10.getFileName() + ":" + r10.getLineNumber() + ") " + r10.getMethodName() + "()";
    }

    public static String b() {
        StackTraceElement r10 = new Throwable().getStackTrace()[1];
        return ".(" + r10.getFileName() + ":" + r10.getLineNumber() + ")";
    }

    public static String c(Context r10, int r11) {
        if (r11 != (-1)) goto L10;
        return "UNKNOWN";
    L10:
        return r10.getResources().getResourceEntryName(r11);
    L9:
        return "?" + r11;
    }

    public static String d(View r10) {
        return r10.getContext().getResources().getResourceEntryName(r10.getId());
    L4:
        return "UNKNOWN";
    }

    public static String e(MotionLayout r10, int r11) {
        return f(r10, r11, -1);
    }

    public static String f(MotionLayout r10, int r11, int r12) {
        if (r11 != (-1)) goto L6;
        return "UNDEFINED";
    L6:
        String r13 = r10.getContext().getResources().getResourceEntryName(r11);
        if (r12 != (-1)) goto L9;
        return r13;
    L9:
        if (r13.length() <= r12) goto L12;
        r13 = r13.replaceAll("([^_])[aeiou]+", "$1");
    L12:
        if (r13.length() <= r12) goto L18;
        int r14 = r13.replaceAll("[^_]", "").length();
        if (r14 > 0) goto L16;
        return r13;
    L16:
        return r13.replaceAll(CharBuffer.allocate((r13.length() - r12) / r14).toString().replace(0, '.') + "_", "_");
    L18:
        return r13;
    }

    public static void g(String r10, String r11, int r12) {
        StackTraceElement[] r13 = new Throwable().getStackTrace();
        int r14 = 1;
        int r15 = Math.min(r12, r13.length - 1);
        String r16 = " ";
    L3:
        if (r14 > r15) goto L5;
        StackTraceElement r17 = r13[r14];
        r16 = r16 + " ";
        Log.v(r10, r11 + r16 + (".(" + r13[r14].getFileName() + ":" + r13[r14].getLineNumber() + ") " + r13[r14].getMethodName()) + r16);
        r14 = r14 + 1;
        goto L3
    }
}
