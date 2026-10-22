package com.bytedance.apm6.util;

import android.util.Pair;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: ListUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public static boolean a(List<?> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
    L8:
        return true;
    L5:
        if (r3.size() == 0) goto L8;
        return false;
    }

    public static String[] a(Set<String> r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
        String[] r0 = new String[r6.size()];
        Iterator r7 = r6.iterator();
        int r2 = 0;
    L4:
        if (r7.hasNext() == false) goto L6;
        r0[r2] = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin");
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    public static String a(Collection r3, String r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L6;
        return null;
    L6:
        StringBuilder r0 = new StringBuilder();
        boolean r1 = true;
        Iterator r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L15;
        Object r2 = r6.next();
        if (r1 == false) goto L12;
        r1 = false;
    L13:
        r0.append(r2.toString());
        goto L8
    L12:
        r0.append(r4);
        goto L13
    L15:
        return r0.toString();
    }

    public static String a(Object[] r6, String r7) {
        if (r6 != null) goto L5;
        return "";
    L5:
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.length;
        boolean r3 = true;
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L13;
        Object r5 = r6[r4];
        if (r3 == false) goto L10;
        r3 = false;
    L11:
        r0.append(r5.toString());
        r4 = r4 + 1;
        goto L6
    L10:
        r0.append(r7);
        goto L11
    L13:
        return r0.toString();
    }

    public static Map<String, String> b(List<Pair<String, String>> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (a(r5) == true) goto L5;
        HashMap r0 = new HashMap();
        Iterator r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L15;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r6.next(), Pair.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L8;
        if (r2.first == null) goto L8;
        r0.put(r2.first, r2.second);
        goto L8
    L15:
        return r0;
    L5:
        return Collections.emptyMap();
    }
}
