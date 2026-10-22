package com.byted.cast.common;

import java.util.Vector;

/* JADX INFO: loaded from: classes39.dex */
public class ListenerList extends Vector {
    public ListenerList() {
    }

    @Override // java.util.Vector, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object r100) {
        if (indexOf(r100) < 0) goto L7;
        return false;
    L7:
        return super.add(r100);
    }
}
