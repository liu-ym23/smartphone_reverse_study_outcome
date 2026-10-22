package com.bytedance.android.livesdk.interactivity.api.input.viewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.uikit.viewpager.SSViewPager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/input/viewpager/InputSectionPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InputSectionPagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Function2<Integer, b, Unit>> f133260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Integer, a> f133261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f133262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f133263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<b> f133264e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f133265f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewPager f133266g;

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int r100) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int r100, float r101, int r102) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f133263d;
    }

    public final void f(int r100) {
        Iterator<T> r101 = this.f133260a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((Function2) r101.next()).invoke(Integer.valueOf(r100), ListProtector.get(this.f133264e, r100));
        goto L4
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int r100) {
        this.f133262c = r100;
        f(r100);
    }

    public InputSectionPagerAdapter(Context r100, SSViewPager r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "viewPager");
        this.f133265f = r100;
        this.f133266g = r101;
        r101.setAdapter(this);
        r101.addOnPageChangeListener(this);
        this.f133260a = new ArrayList();
        this.f133261b = new HashMap();
        this.f133264e = new ArrayList();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        b r102 = (b) ListProtector.get(this.f133264e, r101);
        View r103 = r102.c(this.f133265f);
        a r104 = r102.a(this.f133265f, r103);
        r104.a();
        r100.addView(r104.getRootView(), -1, new ViewGroup.LayoutParams(-1, -1));
        this.f133261b.put(Integer.valueOf(r101), r104);
        return r104;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        if ((r101 instanceof a) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r100, ((a) r101).getRootView());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "sectionPage");
        if ((r102 instanceof a) == false) goto L6;
        a r103 = (a) r102;
        r103.unbind();
        r100.removeView(r103.getRootView());
        this.f133261b.remove(Integer.valueOf(r101));
        return;
    }
}
