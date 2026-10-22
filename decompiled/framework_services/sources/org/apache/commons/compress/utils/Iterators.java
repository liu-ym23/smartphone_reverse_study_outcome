package org.apache.commons.compress.utils;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class Iterators {
    public static <T> boolean addAll(Collection<T> collection, Iterator<? extends T> iterator) {
        collection.getClass();
        iterator.getClass();
        boolean wasModified = false;
    L4:
        if (iterator.hasNext() == false) goto L6;
        wasModified = wasModified | collection.add(iterator.next());
        goto L4
    L6:
        return wasModified;
    }

    private Iterators() {
    }
}
