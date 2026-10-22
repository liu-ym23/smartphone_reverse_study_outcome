package com.android.contacts.PinnedHeaderList;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

/* JADX INFO: loaded from: classes.dex */
public interface HeadersAdapter extends ListAdapter {
    long getHeaderId(int r1);

    View getHeaderView(int r1, View r2, ViewGroup r3);
}
