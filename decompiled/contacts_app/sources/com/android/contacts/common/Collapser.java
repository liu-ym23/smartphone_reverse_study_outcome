package com.android.contacts.common;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Collapser {
    private static final int MAX_LISTSIZE_TO_COLLAPSE = 20;

    public interface Collapsible<T> {
        void collapseWith(T r1);

        boolean shouldCollapseWith(T r1, Context r2);
    }

    private Collapser() {
    }

    public static <T extends Collapsible<T>> void collapseList(List<T> r7, Context r8) {
        int r0 = r7.size();
        if (r0 <= 20) goto L5;
        return;
    L5:
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L21;
        T r2 = r7.get(r1);
        if (r2 == null) goto L20;
        int r3 = r1 + 1;
    L10:
        if (r3 >= r0) goto L20;
        T r4 = r7.get(r3);
        if (r4 == null) goto L19;
        if (r2.shouldCollapseWith(r4, r8) == false) goto L17;
        r2.collapseWith(r4);
        r7.set(r3, null);
        goto L19
    L17:
        if (r4.shouldCollapseWith(r2, r8) == false) goto L19;
        r4.collapseWith(r2);
        r7.set(r1, null);
    L19:
        r3 = r3 + 1;
    L20:
        r1 = r1 + 1;
        goto L6
    L21:
        Iterator<T> r9 = r7.iterator();
    L23:
        if (r9.hasNext() == false) goto L27;
        if (r9.next() != null) goto L23;
        r9.remove();
        goto L23
    }
}
