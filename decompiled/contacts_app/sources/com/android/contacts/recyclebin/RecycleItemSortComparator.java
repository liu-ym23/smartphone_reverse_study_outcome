package com.android.contacts.recyclebin;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class RecycleItemSortComparator implements Comparator<RecycleItem> {
    public RecycleItemSortComparator() {
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(RecycleItem r1, RecycleItem r2) {
        return compare2(r1, r2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(RecycleItem r3, RecycleItem r4) {
        int r2 = r3.section - r4.section;
        if (r2 == 0) goto L6;
        return r2;
    L6:
        if ((r3.getRecycleDate() - r4.getRecycleDate()) <= 0) goto L8;
        return -1;
    L8:
        return 1;
    }
}
