package com.bytedance.apm.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class ListUtils {

    public interface ComparableDiffType<A, B> {
        boolean equals(A r10, B r11);
    }

    public static String a(Object[] r10, String r11) {
        if (r10 != null) goto L5;
        return "";
    L5:
        StringBuilder r12 = new StringBuilder();
        int r13 = r10.length;
        boolean r14 = true;
        int r15 = 0;
    L6:
        if (r15 >= r13) goto L13;
        Object r16 = r10[r15];
        if (r14 == false) goto L10;
        r14 = false;
    L11:
        r12.append(r16.toString());
        r15 = r15 + 1;
        goto L6
    L10:
        r12.append(r11);
        goto L11
    L13:
        return r12.toString();
    }

    public static boolean b(List r10) {
        if (r10 != null) goto L4;
    L7:
        return true;
    L4:
        if (r10.size() == 0) goto L7;
        return false;
    }

    public static String c(Collection r10, String r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        StringBuilder r12 = new StringBuilder();
        Iterator r13 = r10.iterator();
        boolean r14 = true;
    L7:
        if (r13.hasNext() == false) goto L14;
        Object r15 = r13.next();
        if (r14 == false) goto L11;
        r14 = false;
    L12:
        r12.append(r15.toString());
        goto L7
    L11:
        r12.append(r11);
        goto L12
    L14:
        return r12.toString();
    }

    public static boolean d(Collection r10, Object r11, ComparableDiffType r12) {
        Iterator r13 = r10.iterator();
        boolean r14 = false;
    L4:
        if (r13.hasNext() == false) goto L8;
        if (r12.equals(r13.next(), r11) == false) goto L4;
        r13.remove();
        r14 = true;
        goto L4
    L8:
        return r14;
    }

    public static String[] e(Set r10) {
        String[] r11 = new String[r10.size()];
        Iterator r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L6;
        r11[r13] = (String) r12.next();
        r13 = r13 + 1;
        goto L4
    L6:
        return r11;
    }
}
