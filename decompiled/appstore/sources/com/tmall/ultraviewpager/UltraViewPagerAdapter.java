package com.tmall.ultraviewpager;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes4.dex */
public class UltraViewPagerAdapter extends PagerAdapter {
    private static final int INFINITE_RATIO = 400;
    private PagerAdapter adapter;
    private UltraViewPagerCenterListener centerListener;
    private boolean enableLoop;
    private boolean hasCentered;
    private int infiniteRatio;
    private float multiScrRatio;
    private int scrWidth;
    private SparseArray viewArray;

    public interface UltraViewPagerCenterListener {
        void center();

        void resetPosition();
    }

    public UltraViewPagerAdapter(PagerAdapter r10) {
        this.multiScrRatio = Float.NaN;
        this.viewArray = new SparseArray();
        this.adapter = r10;
        this.infiniteRatio = 400;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup r10, int r11, Object r12) {
        if (this.enableLoop == false) goto L8;
        if (this.adapter.getCount() == 0) goto L8;
        r11 = r11 % this.adapter.getCount();
    L8:
        if (isEnableMultiScr() == true) goto L10;
    L12:
        this.adapter.destroyItem(r10, r11, r12);
    L13:
        this.viewArray.remove(r11);
        return;
    L10:
        if ((r12 instanceof RelativeLayout) == false) goto L12;
        RelativeLayout r13 = (RelativeLayout) r12;
        View r14 = r13.getChildAt(0);
        r13.removeAllViews();
        this.adapter.destroyItem(r10, r11, r14);
        goto L13
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup r10) {
        if (this.hasCentered == false) goto L5;
    L9:
        this.hasCentered = true;
        this.adapter.finishUpdate(r10);
        return;
    L5:
        if (this.adapter.getCount() <= 0) goto L9;
        if (getCount() <= this.adapter.getCount()) goto L9;
        this.centerListener.center();
        goto L9
    }

    public PagerAdapter getAdapter() {
        return this.adapter;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.enableLoop == false) goto L9;
        if (this.adapter.getCount() != 0) goto L7;
        return 0;
    L7:
        int r10 = this.adapter.getCount();
        return this.infiniteRatio * r10;
    L9:
        return this.adapter.getCount();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object r10) {
        return this.adapter.getItemPosition(r10);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int r10) {
        int r11 = r10 % this.adapter.getCount();
        return this.adapter.getPageTitle(r11);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public float getPageWidth(int r10) {
        return this.adapter.getPageWidth(r10);
    }

    public int getRealCount() {
        return this.adapter.getCount();
    }

    public View getViewAtPosition(int r10) {
        return (View) this.viewArray.get(r10);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup r10, int r11) {
        if (this.enableLoop == true) goto L5;
    L7:
        Object r12 = this.adapter.instantiateItem(r10, r11);
        if ((r12 instanceof View) == false) goto L10;
        View r13 = (View) r12;
    L12:
        if ((r12 instanceof RecyclerView.ViewHolder) == false) goto L14;
        r13 = ((RecyclerView.ViewHolder) r12).itemView;
    L14:
        ViewPager r14 = (ViewPager) r10;
        int r15 = r14.getChildCount();
        int r16 = 0;
    L15:
        if (r16 >= r15) goto L21;
        View r17 = r14.getChildAt(r16);
        if (isViewFromObject(r17, r12) == true) goto L18;
        r16 = r16 + 1;
        goto L15
    L18:
        this.viewArray.put(r11, r17);
    L21:
        if (isEnableMultiScr() == true) goto L23;
        return r12;
    L23:
        if (this.scrWidth != 0) goto L25;
        this.scrWidth = r10.getResources().getDisplayMetrics().widthPixels;
    L25:
        RelativeLayout r18 = new RelativeLayout(r10.getContext());
        if (r13.getLayoutParams() == null) goto L28;
        RelativeLayout.LayoutParams r19 = new RelativeLayout.LayoutParams((int) (this.scrWidth * this.multiScrRatio), -1);
        r19.addRule(13, -1);
        r13.setLayoutParams(r19);
    L28:
        r10.removeView(r13);
        r18.addView(r13);
        r10.addView(r18);
        return r18;
    L10:
        r13 = null;
        goto L12
    L5:
        if (this.adapter.getCount() == 0) goto L7;
        r11 = r11 % this.adapter.getCount();
        goto L7
    }

    public boolean isEnableLoop() {
        return this.enableLoop;
    }

    public boolean isEnableMultiScr() {
        if (Float.isNaN(this.multiScrRatio) == false) goto L5;
    L7:
        return false;
    L5:
        if (this.multiScrRatio >= 1.0f) goto L7;
        return true;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View r10, Object r11) {
        return this.adapter.isViewFromObject(r10, r11);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.adapter.notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void registerDataSetObserver(DataSetObserver r10) {
        this.adapter.registerDataSetObserver(r10);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable r10, ClassLoader r11) {
        this.adapter.restoreState(r10, r11);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        return this.adapter.saveState();
    }

    public void setCenterListener(UltraViewPagerCenterListener r10) {
        this.centerListener = r10;
    }

    public void setEnableLoop(boolean r10) {
        this.enableLoop = r10;
        notifyDataSetChanged();
        if (r10 == true) goto L6;
        this.centerListener.resetPosition();
        return;
    }

    public void setInfiniteRatio(int r10) {
        this.infiniteRatio = r10;
    }

    public void setMultiScrRatio(float r10) {
        this.multiScrRatio = r10;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup r10, int r11, Object r12) {
        this.adapter.setPrimaryItem(r10, r11, r12);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup r10) {
        this.adapter.startUpdate(r10);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void unregisterDataSetObserver(DataSetObserver r10) {
        this.adapter.unregisterDataSetObserver(r10);
    }
}
