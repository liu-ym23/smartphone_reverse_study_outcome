package com.tmall.wireless.tangram.core.adapter;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.tmall.wireless.tangram.core.protocol.ControlBinder;

/* JADX INFO: loaded from: classes4.dex */
public class BinderViewHolder<C, V extends View> extends RecyclerView.ViewHolder implements VirtualLayoutManager.CacheViewHolder {
    public ControlBinder<C, V> controller;
    public C data;
    public V itemView;

    public BinderViewHolder(V r10, @NonNull ControlBinder<C, V> r11) {
        super(r10);
        this.itemView = r10;
        this.controller = r11;
    }

    public void bind(C r10) {
        this.controller.mountView(r10, this.itemView);
        this.data = r10;
    }

    @Override // com.alibaba.android.vlayout.VirtualLayoutManager.CacheViewHolder
    public boolean needCached() {
        C r10 = this.data;
        if ((r10 instanceof CacheItem) == true) goto L5;
        return false;
    L5:
        return ((CacheItem) r10).isStableCache();
    }

    public void unbind() {
        C r10 = this.data;
        if (r10 == null) goto L6;
        this.controller.unmountView(r10, this.itemView);
        return;
    }
}
