package com.android.contacts.recyclebin;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public interface RecycleItemListener {
    boolean isSelected(RecycleItem r1);

    void onItemClick(boolean r1, int r2, long r3);

    void onItemLongClick(View r1, boolean r2, int r3, long r4, int r6, int r7);

    void umbButtonClicked(View r1, RecycleItem r2, int r3);
}
