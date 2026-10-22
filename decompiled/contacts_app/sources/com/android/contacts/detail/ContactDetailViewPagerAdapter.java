package com.android.contacts.detail;

import android.os.Parcelable;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;

/* JADX INFO: loaded from: classes.dex */
public class ContactDetailViewPagerAdapter extends PagerAdapter {
    public static final String ABOUT_FRAGMENT_TAG = "view-pager-about-fragment";
    private static final int INDEX_ABOUT_FRAGMENT = 0;
    private static final int INDEX_UPDATES_FRAGMENT = 1;
    private static final int MAX_FRAGMENT_VIEW_COUNT = 2;
    public static final String UPDTES_FRAGMENT_TAG = "view-pager-updates-fragment";
    private View mAboutFragmentView;
    private int mFragmentViewCount;
    private View mUpdatesFragmentView;

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(View r1) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable r1, ClassLoader r2) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(View r1) {
    }

    public ContactDetailViewPagerAdapter() {
        this.mFragmentViewCount = 2;
    }

    public void setAboutFragmentView(View r1) {
        this.mAboutFragmentView = r1;
    }

    public void setUpdatesFragmentView(View r1) {
        this.mUpdatesFragmentView = r1;
    }

    public void enableSwipe(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 2;
    L5:
        this.mFragmentViewCount = r2;
        notifyDataSetChanged();
        return;
    L4:
        r2 = 1;
        goto L5
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mFragmentViewCount;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object r2) {
        if (r2 != this.mAboutFragmentView) goto L7;
        return 0;
    L7:
        if (r2 == this.mUpdatesFragmentView) goto L9;
        return -2;
    L9:
        if (this.mFragmentViewCount <= 1) goto L13;
        return 1;
    L13:
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(View r2, int r3) {
        if (r3 != 0) goto L5;
        this.mAboutFragmentView.setVisibility(0);
        return this.mAboutFragmentView;
    L5:
        if (r3 != 1) goto L9;
        this.mUpdatesFragmentView.setVisibility(0);
        return this.mUpdatesFragmentView;
    L9:
        throw new IllegalArgumentException("Invalid position: " + r3);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(View r1, int r2, Object r3) {
        ((View) r3).setVisibility(8);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View r1, Object r2) {
        if (((View) r2) != r1) goto L5;
        return true;
    L5:
        return false;
    }
}
