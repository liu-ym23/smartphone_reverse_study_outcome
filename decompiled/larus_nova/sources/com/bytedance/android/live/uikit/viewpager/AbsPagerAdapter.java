package com.bytedance.android.live.uikit.viewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes7.dex */
public abstract class AbsPagerAdapter extends PagerAdapter {
    protected final Context mContext;
    protected final LayoutInflater mInflater;
    protected final LinkedList<View> mScrapViews;

    public abstract View getView(int r100, View r101, ViewGroup r102);

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View r100, Object r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    public void unbindView(View r100) {
    }

    public AbsPagerAdapter(Context r100, LayoutInflater r101) {
        this.mScrapViews = new LinkedList();
        this.mInflater = r101;
        this.mContext = r100;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup r100, int r101) {
        if (this.mScrapViews.isEmpty() == true) goto L5;
        View r102 = this.mScrapViews.removeFirst();
    L6:
        View r103 = getView(r101, r102, r100);
        r100.addView(r103);
        return r103;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup r100, int r101, Object r102) {
        if (r102 != null) goto L4;
        return;
    L4:
        View r103 = (View) r102;
        r100.removeView(r103);
        this.mScrapViews.add(r103);
        unbindView(r103);
    }
}
