package com.alibaba.android.vlayout.extend;

import android.util.Log;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public final class InnerRecycledViewPool extends RecyclerView.RecycledViewPool {
    private static final int DEFAULT_MAX_SIZE = 5;
    private static final String TAG = "InnerRecycledViewPool";
    private RecyclerView.RecycledViewPool mInnerPool;
    private SparseIntArray mMaxScrap;
    private SparseIntArray mScrapLength;

    public InnerRecycledViewPool(RecyclerView.RecycledViewPool r10) {
        this.mScrapLength = new SparseIntArray();
        this.mMaxScrap = new SparseIntArray();
        this.mInnerPool = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void destroyViewHolder(RecyclerView.ViewHolder r10) {
        KeyEvent.Callback r11 = r10.itemView;
        if ((r11 instanceof Closeable) == false) goto L9;
        ((Closeable) r11).close();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        Log.w(TAG, Log.getStackTraceString(e), e);
    L9:
        if ((r10 instanceof Closeable) == false) goto L19;
        ((Closeable) r10).close();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        Log.w(TAG, Log.getStackTraceString(e), e);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public void clear() {
        int r10 = this.mScrapLength.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        int r12 = this.mScrapLength.keyAt(r11);
        RecyclerView.ViewHolder r13 = this.mInnerPool.getRecycledView(r12);
    L5:
        if (r13 == null) goto L7;
        destroyViewHolder(r13);
        r13 = this.mInnerPool.getRecycledView(r12);
        goto L5
    L7:
        r11 = r11 + 1;
        goto L3
    L8:
        this.mScrapLength.clear();
        super.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public RecyclerView.ViewHolder getRecycledView(int r10) {
        RecyclerView.ViewHolder r11 = this.mInnerPool.getRecycledView(r10);
        if (r11 != null) goto L5;
    L10:
        return r11;
    L5:
        if (this.mScrapLength.indexOfKey(r10) < 0) goto L7;
        int r12 = this.mScrapLength.get(r10);
    L8:
        if (r12 <= 0) goto L10;
        this.mScrapLength.put(r10, r12 - 1);
        goto L10
    L7:
        r12 = 0;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public void putRecycledView(RecyclerView.ViewHolder r10) {
        int r11 = r10.getItemViewType();
        if (this.mMaxScrap.indexOfKey(r11) >= 0) goto L6;
        this.mMaxScrap.put(r11, 5);
        setMaxRecycledViews(r11, 5);
    L6:
        if (this.mScrapLength.indexOfKey(r11) < 0) goto L8;
        int r12 = this.mScrapLength.get(r11);
    L10:
        if (this.mMaxScrap.get(r11) <= r12) goto L12;
        this.mInnerPool.putRecycledView(r10);
        this.mScrapLength.put(r11, r12 + 1);
        return;
    L12:
        destroyViewHolder(r10);
        return;
    L8:
        r12 = 0;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public void setMaxRecycledViews(int r10, int r11) {
        RecyclerView.ViewHolder r12 = this.mInnerPool.getRecycledView(r10);
    L3:
        if (r12 == null) goto L5;
        destroyViewHolder(r12);
        r12 = this.mInnerPool.getRecycledView(r10);
        goto L3
    L5:
        this.mMaxScrap.put(r10, r11);
        this.mScrapLength.put(r10, 0);
        this.mInnerPool.setMaxRecycledViews(r10, r11);
    }

    public int size() {
        int r10 = this.mScrapLength.size();
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r12 = r12 + this.mScrapLength.valueAt(r11);
        r11 = r11 + 1;
        goto L3
    L5:
        return r12;
    }

    public InnerRecycledViewPool() {
        this(new RecyclerView.RecycledViewPool());
    }
}
