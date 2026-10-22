package com.bytedance.android.livesdk.overscroll.adapters;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import ln2.b;

/* JADX INFO: loaded from: classes11.dex */
public class ViewPagerOverScrollDecorAdapter implements b, ViewPager.OnPageChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveVerticalViewPager f154162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f154163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f154164c;

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int r100) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int r100) {
    }

    @Override // ln2.b
    public final boolean a() {
        if (this.f154163b == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.f154164c != 0.0f) goto L7;
        return true;
    }

    @Override // ln2.b
    public final boolean b() {
        if (this.f154163b == (this.f154162a.getAdapter().getCount() - 1)) goto L5;
    L7:
        return false;
    L5:
        if (this.f154164c != 0.0f) goto L7;
        return true;
    }

    @Override // ln2.b
    public final View getView() {
        return this.f154162a;
    }

    public ViewPagerOverScrollDecorAdapter(LiveVerticalViewPager r100) {
        this.f154163b = 0;
        this.f154162a = r100;
        this.f154163b = r100.getCurrentItem();
        this.f154164c = 0.0f;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int r100, float r101, int r102) {
        this.f154163b = r100;
        this.f154164c = r101;
    }
}
