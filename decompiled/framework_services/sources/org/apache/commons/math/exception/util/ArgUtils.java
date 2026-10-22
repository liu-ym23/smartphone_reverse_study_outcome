package org.apache.commons.math.exception.util;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ArgUtils {
    private ArgUtils() {
    }

    public static Object[] flatten(Object[] array) {
        List<Object> list = new ArrayList();
        if (array == null) goto L16;
        int r1 = array.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L16;
        Object o = array[r3];
        if ((o instanceof Object[]) == false) goto L13;
        Object[] r5 = flatten((Object[]) o);
        int r6 = r5.length;
        int r7 = 0;
    L11:
        if (r7 >= r6) goto L14;
        Object oR = r5[r7];
        list.add(oR);
        r7 = r7 + 1;
    L14:
        r3 = r3 + 1;
        goto L6
    L13:
        list.add(o);
    L16:
        return list.toArray();
    }
}
