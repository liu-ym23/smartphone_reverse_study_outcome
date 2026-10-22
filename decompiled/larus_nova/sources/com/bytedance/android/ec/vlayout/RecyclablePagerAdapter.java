package com.bytedance.android.ec.vlayout;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.viewpager.widget.PagerAdapter;

/* JADX INFO: loaded from: classes44.dex */
public abstract class RecyclablePagerAdapter<VH extends RecyclerView.ViewHolder> extends PagerAdapter {
    public abstract int f(int r100);

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        f(r101);
        throw null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        if ((r101 instanceof RecyclerView.ViewHolder) == true) goto L5;
    L7:
        return false;
    L5:
        if (((RecyclerView.ViewHolder) r101).itemView != r100) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        if ((r102 instanceof RecyclerView.ViewHolder) == true) goto L5;
        return;
    L5:
        r100.removeView(((RecyclerView.ViewHolder) r102).itemView);
        throw null;
    }
}
