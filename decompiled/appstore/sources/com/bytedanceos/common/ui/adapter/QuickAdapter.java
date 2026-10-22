package com.bytedanceos.common.ui.adapter;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class QuickAdapter<T> extends RecyclerView.Adapter {
    public List<T> mDatas;

    public static class VH extends RecyclerView.ViewHolder {
        public View mConvertView;
        private SparseArray<View> mViews;

        public VH(View r10) {
            super(r10);
            this.mConvertView = r10;
            this.mViews = new SparseArray();
        }

        public static VH get(ViewGroup r10, int r11) {
            return new VH(LayoutInflater.from(r10.getContext()).inflate(r11, r10, false));
        }

        /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(I)TT; */
        public View getView(int r10) {
            View r11 = this.mViews.get(r10);
            if (r11 != null) goto L6;
            View r12 = this.mConvertView.findViewById(r10);
            this.mViews.put(r10, r12);
            return r12;
        L6:
            return r11;
        }
    }

    public QuickAdapter(List<T> r10) {
        this.mDatas = new CopyOnWriteArrayList();
        if (r10 == null) goto L6;
        this.mDatas = r10;
        return;
    }

    public abstract void convert(VH r10, T r11, int r12);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDatas.size();
    }

    public abstract int getLayoutId(int r10);

    public abstract void initView(int r10, VH r11);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        onBindViewHolder((VH) r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        return onCreateViewHolder(r10, r11);
    }

    public void setData(List<T> r10) {
        if (r10 == null) goto L5;
        this.mDatas = r10;
        notifyDataSetChanged();
        return;
    }

    public void onBindViewHolder(VH r10, int r11) {
        convert(r10, this.mDatas.get(r11), r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup r10, int r11) {
        VH r12 = VH.get(r10, getLayoutId(r11));
        initView(r11, r12);
        return r12;
    }
}
