package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.view.View;
import java.nio.CharBuffer;

/* JADX INFO: loaded from: classes.dex */
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
}
