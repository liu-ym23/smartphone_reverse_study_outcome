package com.android.contacts.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SingleItemAdapter extends BaseAdapter {
    @Override // android.widget.Adapter
    public int getCount() {
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int r1) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return 0;
    }

    protected abstract View getView(View r1, ViewGroup r2);

    public SingleItemAdapter() {
    }

    @Override // android.widget.Adapter
    public View getView(int r1, View r2, ViewGroup r3) {
        return getView(r2, r3);
    }
}
