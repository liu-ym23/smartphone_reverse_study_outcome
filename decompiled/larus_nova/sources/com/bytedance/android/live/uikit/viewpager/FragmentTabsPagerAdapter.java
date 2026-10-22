package com.bytedance.android.live.uikit.viewpager;

import android.view.ViewGroup;
import android.widget.TabHost;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes7.dex */
public class FragmentTabsPagerAdapter extends androidx.fragment.app.FragmentPagerAdapter implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {

    public static final class a {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int r100) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int r100, float r101, int r102) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        throw null;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public final Fragment getItem(int r100) {
        ((a) ListProtector.get(null, r100)).getClass();
        throw null;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int r100) {
        throw null;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public final void onTabChanged(String r100) {
        throw null;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        Object r102 = super.instantiateItem(r100, r101);
        if (r102 != null) goto L5;
    L10:
        return r102;
    L5:
        if ((r102 instanceof Fragment) == false) goto L10;
        if (r101 < 0) goto L10;
        throw null;
    }
}
