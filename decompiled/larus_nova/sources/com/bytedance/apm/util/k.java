package com.bytedance.apm.util;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class k {
    public static String a(Object[] r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        boolean r103 = true;
        int r104 = 0;
    L6:
        if (r104 >= r102) goto L13;
        Object r105 = r100[r104];
        if (r103 == false) goto L10;
        r103 = false;
    L11:
        r101.append(r105.toString());
        r104 = r104 + 1;
        goto L6
    L10:
        r101.append("#");
        goto L11
    L13:
        return r101.toString();
    }

    public static boolean b(List<?> r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.size() == 0) goto L7;
        return false;
    }

    public static String[] c(Set<String> r100) {
        String[] r101 = new String[r100.size()];
        Iterator<String> r102 = r100.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L6;
        r101[r103] = r102.next();
        r103 = r103 + 1;
        goto L4
    L6:
        return r101;
    }
}
