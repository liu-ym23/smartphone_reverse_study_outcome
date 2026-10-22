package com.alibaba.android.vlayout;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.android.vlayout.extend.InnerRecycledViewPool;

/* JADX INFO: loaded from: classes.dex */
public abstract class RecyclablePagerAdapter<VH extends RecyclerView.ViewHolder> extends PagerAdapter {
    private RecyclerView.Adapter mAdapter;
    private InnerRecycledViewPool mRecycledViewPool;

    public RecyclablePagerAdapter(RecyclerView.Adapter r10, RecyclerView.RecycledViewPool r11) {
        this.mAdapter = r10;
        if ((r11 instanceof InnerRecycledViewPool) == false) goto L5;
        this.mRecycledViewPool = (InnerRecycledViewPool) r11;
        return;
    L5:
        this.mRecycledViewPool = new InnerRecycledViewPool(r11);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup r10, int r11, Object r12) {
        if ((r12 instanceof RecyclerView.ViewHolder) == false) goto L6;
        RecyclerView.ViewHolder r13 = (RecyclerView.ViewHolder) r12;
        r10.removeView(r13.itemView);
        this.mRecycledViewPool.putRecycledView(r13);
        return;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public abstract int getCount();

    public abstract int getItemViewType(int r10);

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup r10, int r11) {
        int r12 = getItemViewType(r11);
        RecyclerView.ViewHolder r13 = this.mRecycledViewPool.getRecycledView(r12);
        if (r13 != null) goto L5;
        r13 = this.mAdapter.createViewHolder(r10, r12);
    L5:
        onBindViewHolder(r13, r11);
        r10.addView(r13.itemView, new ViewPager.LayoutParams());
        return r13;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View r10, Object r11) {
        if ((r11 instanceof RecyclerView.ViewHolder) == true) goto L5;
    L7:
        return false;
    L5:
        if (((RecyclerView.ViewHolder) r11).itemView != r10) goto L7;
        return true;
    }

    public abstract void onBindViewHolder(VH r10, int r11);
}
