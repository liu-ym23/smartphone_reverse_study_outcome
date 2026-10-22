package org.apache.http.protocol;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class ChainBuilder<E> {
    private final LinkedList<E> list;
    private final Map<Class<?>, E> uniqueClasses;

    public ChainBuilder() {
        this.list = new LinkedList();
        this.uniqueClasses = new HashMap();
    }

    private void ensureUnique(E r10) {
        E r11 = this.uniqueClasses.remove(r10.getClass());
        if (r11 == null) goto L5;
        this.list.remove(r11);
    L5:
        this.uniqueClasses.put(r10.getClass(), r10);
    }

    public ChainBuilder<E> addAllFirst(Collection<E> r10) {
        if (r10 != null) goto L4;
        return this;
    L4:
        Iterator<E> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        addFirst(r11.next());
        goto L6
    L8:
        return this;
    }

    public ChainBuilder<E> addAllLast(Collection<E> r10) {
        if (r10 != null) goto L4;
        return this;
    L4:
        Iterator<E> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        addLast(r11.next());
        goto L6
    L8:
        return this;
    }

    public ChainBuilder<E> addFirst(E r10) {
        if (r10 != null) goto L4;
        return this;
    L4:
        ensureUnique(r10);
        this.list.addFirst(r10);
        return this;
    }

    public ChainBuilder<E> addLast(E r10) {
        if (r10 != null) goto L4;
        return this;
    L4:
        ensureUnique(r10);
        this.list.addLast(r10);
        return this;
    }

    public LinkedList<E> build() {
        return new LinkedList(this.list);
    }

    public ChainBuilder<E> addAllFirst(E... r10) {
        if (r10 != null) goto L4;
        return this;
    L4:
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L7;
        addFirst(r10[r12]);
        r12 = r12 + 1;
        goto L5
    L7:
        return this;
    }

    public ChainBuilder<E> addAllLast(E... r10) {
        if (r10 != null) goto L4;
        return this;
    L4:
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L7;
        addLast(r10[r12]);
        r12 = r12 + 1;
        goto L5
    L7:
        return this;
    }
}
