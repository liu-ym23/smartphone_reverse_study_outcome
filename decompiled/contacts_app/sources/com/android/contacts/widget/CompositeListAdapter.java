package com.android.contacts.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class CompositeListAdapter extends BaseAdapter {
    private static final int INITIAL_CAPACITY = 2;
    private ListAdapter[] mAdapters;
    private boolean mAllItemsEnabled;
    private boolean mCacheValid;
    private int mCount;
    private int[] mCounts;
    private DataSetObserver mDataSetObserver;
    private int mSize;
    private int mViewTypeCount;
    private int[] mViewTypeCounts;

    public CompositeListAdapter() {
        this(2);
    }

    public CompositeListAdapter(int r2) {
        this.mSize = 0;
        this.mCount = 0;
        this.mViewTypeCount = 0;
        this.mAllItemsEnabled = true;
        this.mCacheValid = true;
        this.mDataSetObserver = new AnonymousClass1(this);
        this.mAdapters = new ListAdapter[2];
        this.mCounts = new int[2];
        this.mViewTypeCounts = new int[2];
    }

    void addAdapter(ListAdapter r6) {
        int r0 = this.mSize;
        ListAdapter[] r1 = this.mAdapters;
        if (r0 < r1.length) goto L5;
        int r2 = r0 + 2;
        ListAdapter[] r3 = new ListAdapter[r2];
        System.arraycopy(r1, 0, r3, 0, r0);
        this.mAdapters = r3;
        int[] r4 = new int[r2];
        System.arraycopy(this.mCounts, 0, r4, 0, this.mSize);
        this.mCounts = r4;
        int[] r5 = new int[r2];
        System.arraycopy(this.mViewTypeCounts, 0, r5, 0, this.mSize);
        this.mViewTypeCounts = r5;
    L5:
        r6.registerDataSetObserver(this.mDataSetObserver);
        int r7 = r6.getCount();
        int r8 = r6.getViewTypeCount();
        ListAdapter[] r9 = this.mAdapters;
        int r10 = this.mSize;
        r9[r10] = r6;
        this.mCounts[r10] = r7;
        this.mCount += r7;
        this.mAllItemsEnabled = r6.areAllItemsEnabled() & this.mAllItemsEnabled;
        int[] r11 = this.mViewTypeCounts;
        int r12 = this.mSize;
        r11[r12] = r8;
        this.mViewTypeCount += r8;
        this.mSize = r12 + 1;
        notifyDataChanged();
    }

    protected void notifyDataChanged() {
        if (getCount() <= 0) goto L5;
        notifyDataSetChanged();
        return;
    L5:
        notifyDataSetInvalidated();
    }

    protected void invalidate() {
        this.mCacheValid = false;
    }

    protected void ensureCacheValid() {
        if (this.mCacheValid == false) goto L5;
        return;
    L5:
        int r0 = 0;
        this.mCount = 0;
        this.mAllItemsEnabled = true;
        this.mViewTypeCount = 0;
    L7:
        if (r0 >= this.mSize) goto L9;
        int r2 = this.mAdapters[r0].getCount();
        int r3 = this.mAdapters[r0].getViewTypeCount();
        this.mCounts[r0] = r2;
        this.mCount += r2;
        this.mAllItemsEnabled &= this.mAdapters[r0].areAllItemsEnabled();
        this.mViewTypeCount += r3;
        r0 = r0 + 1;
        goto L7
    L9:
        this.mCacheValid = true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ensureCacheValid();
        return this.mCount;
    }

    @Override // android.widget.Adapter
    public Object getItem(int r5) {
        ensureCacheValid();
        int r0 = 0;
        int r1 = 0;
    L3:
        int[] r2 = this.mCounts;
        if (r0 >= r2.length) goto L12;
        int r3 = r2[r0] + r1;
        if (r5 < r1) goto L10;
        if (r5 >= r3) goto L10;
        return this.mAdapters[r0].getItem(r5 - r1);
    L10:
        r0 = r0 + 1;
        r1 = r3;
        goto L3
    L12:
        throw new ArrayIndexOutOfBoundsException(r5);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r5) {
        ensureCacheValid();
        int r0 = 0;
        int r1 = 0;
    L3:
        int[] r2 = this.mCounts;
        if (r0 >= r2.length) goto L12;
        int r3 = r2[r0] + r1;
        if (r5 < r1) goto L10;
        if (r5 >= r3) goto L10;
        return this.mAdapters[r0].getItemId(r5 - r1);
    L10:
        r0 = r0 + 1;
        r1 = r3;
        goto L3
    L12:
        throw new ArrayIndexOutOfBoundsException(r5);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        ensureCacheValid();
        return this.mViewTypeCount;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int r6) {
        ensureCacheValid();
        int r0 = 0;
        int r1 = 0;
        int r2 = 0;
    L3:
        int[] r3 = this.mCounts;
        if (r0 >= r3.length) goto L12;
        int r4 = r3[r0] + r1;
        if (r6 < r1) goto L10;
        if (r6 >= r4) goto L10;
        return r2 + this.mAdapters[r0].getItemViewType(r6 - r1);
    L10:
        r2 = r2 + this.mViewTypeCounts[r0];
        r0 = r0 + 1;
        r1 = r4;
        goto L3
    L12:
        throw new ArrayIndexOutOfBoundsException(r6);
    }

    @Override // android.widget.Adapter
    public View getView(int r5, View r6, ViewGroup r7) {
        ensureCacheValid();
        int r0 = 0;
        int r1 = 0;
    L3:
        int[] r2 = this.mCounts;
        if (r0 >= r2.length) goto L12;
        int r3 = r2[r0] + r1;
        if (r5 < r1) goto L10;
        if (r5 >= r3) goto L10;
        return this.mAdapters[r0].getView(r5 - r1, r6, r7);
    L10:
        r0 = r0 + 1;
        r1 = r3;
        goto L3
    L12:
        throw new ArrayIndexOutOfBoundsException(r5);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        ensureCacheValid();
        return this.mAllItemsEnabled;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int r6) {
        ensureCacheValid();
        int r1 = 0;
        int r2 = 0;
    L3:
        int[] r3 = this.mCounts;
        if (r1 >= r3.length) goto L16;
        int r4 = r3[r1] + r2;
        if (r6 < r2) goto L14;
        if (r6 >= r4) goto L14;
        if (this.mAdapters[r1].areAllItemsEnabled() == false) goto L11;
    L12:
        return true;
    L11:
        if (this.mAdapters[r1].isEnabled(r6 - r2) == true) goto L12;
        return false;
    L14:
        r1 = r1 + 1;
        r2 = r4;
        goto L3
    L16:
        throw new ArrayIndexOutOfBoundsException(r6);
    }
}
