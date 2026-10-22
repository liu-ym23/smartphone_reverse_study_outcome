package com.android.contacts;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Collapser {

    public interface Collapsible<T> {
        boolean collapseWith(T r1);

        boolean shouldCollapseWith(T r1);
    }

    private Collapser() {
    }

    public static <T extends Collapsible<T>> void collapseList(List<T> r6) {
        int r0 = r6.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L15;
        T r2 = r6.get(r1);
        if (r2 == null) goto L14;
        int r3 = r1 + 1;
    L7:
        if (r3 >= r0) goto L14;
        T r4 = r6.get(r3);
        if (r4 == null) goto L13;
        if (r2.shouldCollapseWith(r4) == false) goto L13;
        r2.collapseWith(r4);
        r6.set(r3, null);
    L13:
        r3 = r3 + 1;
    L14:
        r1 = r1 + 1;
        goto L3
    L15:
        Iterator<T> r7 = r6.iterator();
    L17:
        if (r7.hasNext() == false) goto L21;
        if (r7.next() != null) goto L17;
        r7.remove();
        goto L17
    }
}
