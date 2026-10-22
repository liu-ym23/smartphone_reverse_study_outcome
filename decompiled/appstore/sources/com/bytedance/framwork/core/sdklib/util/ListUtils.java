package com.bytedance.framwork.core.sdklib.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ListUtils {

    public interface ComparableDiffType<A, B> {
        boolean equals(A r10, B r11);
    }

    public static boolean a(List r10) {
        if (r10 != null) goto L4;
    L7:
        return true;
    L4:
        if (r10.size() == 0) goto L7;
        return false;
    }

    public static boolean b(Collection r10, Object r11, ComparableDiffType r12) {
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
}
