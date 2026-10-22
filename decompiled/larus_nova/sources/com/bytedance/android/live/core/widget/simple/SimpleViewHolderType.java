package com.bytedance.android.live.core.widget.simple;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes45.dex */
public abstract class SimpleViewHolderType<F extends T, T> extends ViewHolderType<T> {
    public abstract void bind(SimpleViewHolder r100, F r101, int r102);

    public abstract int getLayoutResId();

    public void unBind(SimpleViewHolder r100, F r101) {
    }

    public SimpleViewHolderType() {
    }

    @Override // com.bytedance.android.live.core.widget.simple.ViewHolderType
    public RecyclerView.ViewHolder create(ViewGroup r100) {
        return new SimpleViewHolder(LayoutInflater.from(r100.getContext()).inflate(getLayoutResId(), r100, false));
    }
}
