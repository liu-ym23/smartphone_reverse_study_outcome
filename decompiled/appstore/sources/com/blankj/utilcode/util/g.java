package com.blankj.utilcode.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6222a = null;

    static {
        f6222a = System.getProperty("line.separator");
    }

    public static String a(Throwable r10) {
        ArrayList r11 = new ArrayList();
    L3:
        if (r10 == null) goto L7;
        if (r11.contains(r10) == true) goto L7;
        r11.add(r10);
        r10 = r10.getCause();
    L7:
        int r12 = r11.size();
        ArrayList r13 = new ArrayList();
        int r14 = r12 - 1;
        List r15 = b((Throwable) r11.get(r14));
    L8:
        int r16 = r12 - 1;
        if (r16 < 0) goto L17;
        if (r16 == 0) goto L12;
        List r17 = b((Throwable) r11.get(r12 - 2));
        c(r15, r17);
    L13:
        if (r16 != r14) goto L15;
        r13.add(((Throwable) r11.get(r16)).toString());
    L16:
        r13.addAll(r15);
        r15 = r17;
        r12 = r16;
        goto L8
    L15:
        r13.add(" Caused by: " + ((Throwable) r11.get(r16)).toString());
        goto L16
    L12:
        r17 = r15;
        goto L13
    L17:
        StringBuilder r18 = new StringBuilder();
        Iterator r19 = r13.iterator();
    L19:
        if (r19.hasNext() == false) goto L22;
        r18.append((String) r19.next());
        r18.append(f6222a);
        goto L19
    L22:
        return r18.toString();
    }

    public static List b(Throwable r10) {
        StringWriter r11 = new StringWriter();
        r10.printStackTrace(new PrintWriter(r11, true));
        StringTokenizer r12 = new StringTokenizer(r11.toString(), f6222a);
        ArrayList r13 = new ArrayList();
        boolean r14 = false;
    L4:
        if (r12.hasMoreTokens() == false) goto L11;
        String r15 = r12.nextToken();
        int r16 = r15.indexOf("at");
        if (r16 == (-1)) goto L10;
        if (r15.substring(0, r16).trim().isEmpty() == false) goto L10;
        r13.add(r15);
        r14 = true;
    L10:
        if (r14 == false) goto L4;
    L11:
        return r13;
    }

    public static void c(List r10, List r11) {
        int r12 = r10.size() - 1;
        int r13 = r11.size() - 1;
    L3:
        if (r12 < 0) goto L9;
        if (r13 < 0) goto L14;
        if (((String) r10.get(r12)).equals((String) r11.get(r13)) == false) goto L8;
        r10.remove(r12);
    L8:
        r12 = r12 - 1;
        r13 = r13 - 1;
        goto L3
    L14:
        return;
    }
}
