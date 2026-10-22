package com.bytedance.crash.o;

import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: compiled from: Stack.java */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final StackTraceElement f7683a = null;

    public static StringBuilder a(StackTraceElement r2, StringBuilder r3) {
        String r0 = r2.getClassName();
        r3.append("  at ").append(r0).append(".").append(r2.getMethodName()).append("(").append(r2.getFileName()).append(":").append(r2.getLineNumber()).append(")\n");
        return r3;
    }

    /* JADX WARN: Unreachable blocks removed: 3, instructions: 3 */
    public static String a(Throwable r2) {
        StringWriter r0 = new StringWriter();
        PrintWriter r1 = new PrintWriter(r0);
        a(r2, r1);     // Catch: Throwable -> L6
        String r3 = r0.toString();     // Catch: Throwable -> L6
        r1.close();
        return r3;
    L7:
        r1.close();
        return "";
    }

    static {
        f7683a = new StackTraceElement("", "", "", 0);
    }

    private static void a(Throwable r12, PrintWriter r13) {
        if (r12 == null) goto L38;
        if (r13 == null) goto L40;
        Set r0 = Collections.newSetFromMap(new IdentityHashMap());
        r0.add(r12);
        r13.println(r12);
        StackTraceElement[] r8 = r12.getStackTrace();
        if (r8.length <= 384) goto L8;
        boolean r1 = true;
    L9:
        int r2 = r8.length;
        int r4 = 0;
        int r5 = 0;
    L11:
        if (r4 >= r2) goto L18;
        StackTraceElement r7 = r8[r4];
        if (r1 == false) goto L17;
        if (r5 <= 256) goto L17;
        r13.println("\t... skip " + ((r8.length - r5) - 128) + " lines");
    L17:
        r13.println("\tat " + r7);
        r5 = r5 + 1;
        r4 = r4 + 1;
    L18:
        if (r1 == false) goto L24;
        int r3 = r8.length - 128;
    L21:
        if (r3 >= r8.length) goto L24;
        r13.println("\tat " + r8[r3]);
        r3 = r3 + 1;
    L24:
        if (Build.VERSION.SDK_INT < 19) goto L28;
        Throwable[] r9 = r12.getSuppressed();
        int r10 = r9.length;
        int r11 = 0;
    L26:
        if (r11 >= r10) goto L28;
        a(r9[r11], r13, r8, "Suppressed: ", "\t", r0, 128);
        r11 = r11 + 1;
    L28:
        Throwable r6 = r12.getCause();
        if (r6 == null) goto L39;
        a(r6, r13, r8, "Caused by: ", "", r0, 128);
        return;
    L39:
        return;
    L8:
        r1 = false;
        goto L9
    L40:
        return;
    }

    private static void a(Throwable r18, PrintWriter r19, StackTraceElement[] r20, String r21, String r22, Set<Throwable> r23, int r24) {
        Set r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r23, Set.class, "com.obric.aiagent.plugin");
        if (r11.contains(r18) == false) goto L5;
        r19.println("\t[CIRCULAR REFERENCE:" + r18 + "]");
        return;
    L5:
        r11.add(r18);
        StackTraceElement[] r12 = r18.getStackTrace();
        if (r12.length <= r24) goto L8;
        boolean r1 = true;
    L9:
        r19.println(r22 + r21 + r18);
        int r3 = r12.length;
        int r4 = 0;
        int r5 = 0;
    L11:
        if (r4 >= r3) goto L17;
        StackTraceElement r7 = r12[r4];
        if (r1 == false) goto L16;
        if (r5 <= r24) goto L16;
        r19.println("\t... skip " + ((r12.length - r5) - (r24 / 2)) + " lines");
    L16:
        r19.println("\tat " + r7);
        r5 = r5 + 1;
        r4 = r4 + 1;
    L17:
        if (r1 == false) goto L23;
        int r2 = r12.length - (r24 / 2);
    L20:
        if (r2 >= r12.length) goto L23;
        r19.println("\tat " + r12[r2]);
        r2 = r2 + 1;
    L23:
        if (Build.VERSION.SDK_INT < 19) goto L31;
        Throwable[] r14 = r18.getSuppressed();
        int r15 = r14.length;
        int r8 = 0;
    L25:
        if (r8 >= r15) goto L31;
        Throwable r6 = r14[r8];
        String r9 = r22 + "\t";
        int r10 = r24 / 2;
        if (r10 <= 10) goto L29;
        int r16 = r10;
    L30:
        a(r6, r19, r12, "Suppressed: ", r9, r11, r16);
        r8 = r8 + 1;
        goto L25
    L29:
        r16 = 10;
    L31:
        Throwable r0 = r18.getCause();
        if (r0 == null) goto L48;
        int r13 = r24 / 2;
        if (r13 <= 10) goto L36;
        int r17 = r13;
    L37:
        a(r0, r19, r12, "Caused by: ", r22, r11, r17);
        return;
    L36:
        r17 = 10;
        goto L37
    L48:
        return;
    L8:
        r1 = false;
        goto L9
    }
}
