package com.bytedance.android.livesdk.livecommerce.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public class FilterNullArrayList<E> extends ArrayList<E> {
    public FilterNullArrayList() {
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return super.add(r100);
    }
}
