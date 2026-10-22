package com.bytedance.android.ec.vlayout.extend;

import android.util.Log;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Closeable;

/* JADX INFO: loaded from: classes44.dex */
public final class InnerRecycledViewPool extends RecyclerView.RecycledViewPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.RecycledViewPool f49097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseIntArray f49098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseIntArray f49099c;

    public InnerRecycledViewPool() {
        this(new RecyclerView.RecycledViewPool());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public final void clear() {
        int r100 = this.f49098b.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L8;
        int r102 = this.f49098b.keyAt(r101);
        RecyclerView.ViewHolder r103 = this.f49097a.getRecycledView(r102);
    L5:
        if (r103 == null) goto L7;
        a(r103);
        r103 = this.f49097a.getRecycledView(r102);
        goto L5
    L7:
        r101 = r101 + 1;
        goto L3
    L8:
        this.f49098b.clear();
        super.clear();
    }

    public InnerRecycledViewPool(RecyclerView.RecycledViewPool r100) {
        this.f49098b = new SparseIntArray();
        this.f49099c = new SparseIntArray();
        this.f49097a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(RecyclerView.ViewHolder r100) {
        KeyEvent.Callback r101 = r100.itemView;
        if ((r101 instanceof Closeable) == false) goto L9;
        ((Closeable) r101).close();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        Log.getStackTraceString(e);
    L9:
        if ((r100 instanceof Closeable) == false) goto L19;
        ((Closeable) r100).close();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        Log.getStackTraceString(e);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public final RecyclerView.ViewHolder getRecycledView(int r100) {
        RecyclerView.ViewHolder r101 = this.f49097a.getRecycledView(r100);
        if (r101 != null) goto L5;
    L10:
        return r101;
    L5:
        if (this.f49098b.indexOfKey(r100) < 0) goto L7;
        int r102 = this.f49098b.get(r100);
    L8:
        if (r102 <= 0) goto L10;
        this.f49098b.put(r100, r102 - 1);
        goto L10
    L7:
        r102 = 0;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public final void putRecycledView(RecyclerView.ViewHolder r100) {
        int r101 = r100.getItemViewType();
        if (this.f49099c.indexOfKey(r101) >= 0) goto L6;
        this.f49099c.put(r101, 20);
        setMaxRecycledViews(r101, 20);
    L6:
        if (this.f49098b.indexOfKey(r101) < 0) goto L8;
        int r102 = this.f49098b.get(r101);
    L10:
        if (this.f49099c.get(r101) <= r102) goto L12;
        this.f49097a.putRecycledView(r100);
        this.f49098b.put(r101, r102 + 1);
        return;
    L12:
        a(r100);
        return;
    L8:
        r102 = 0;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public final void setMaxRecycledViews(int r100, int r101) {
        RecyclerView.ViewHolder r102 = this.f49097a.getRecycledView(r100);
    L3:
        if (r102 == null) goto L5;
        a(r102);
        r102 = this.f49097a.getRecycledView(r100);
        goto L3
    L5:
        this.f49099c.put(r100, r101);
        this.f49098b.put(r100, 0);
        this.f49097a.setMaxRecycledViews(r100, r101);
    }
}
