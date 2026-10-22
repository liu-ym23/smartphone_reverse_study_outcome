package com.bytedance.android.livesdk.widget.board;

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
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/widget/board/ExpressionSectionPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExpressionSectionPagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Function3<Integer, Integer, com.bytedance.android.livesdk.model.h, Unit>> f161443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Integer, k> f161444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<Pair<Integer, Integer>, Integer> f161445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<Integer> f161446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f161447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f161448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.model.h> f161449g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f161450h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f161451i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewPager f161452j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ExpressionContext f161453k;

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int r100, float r101, int r102) {
    }

    public final void j() {
        Iterator<Map.Entry<Integer, k>> r100 = this.f161444b.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().getValue().unbind();
        goto L4
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f161450h;
    }

    public final int f(int r100) {
        Iterator<Map.Entry<Pair<Integer, Integer>, Integer>> r101 = this.f161445c.entrySet().iterator();
    L3:
        boolean r102 = false;
        if (r101.hasNext() == false) goto L13;
        Map.Entry<Pair<Integer, Integer>, Integer> r103 = r101.next();
        Pair<Integer, Integer> r104 = r103.getKey();
        int r105 = r104.getFirst().intValue();
        int r106 = r104.getSecond().intValue();
        if (r105 > r100) goto L10;
        if (r106 < r100) goto L10;
        r102 = true;
    L10:
        if (r102 == false) goto L3;
        return r103.getValue().intValue();
    L13:
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getItemPosition(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "object");
        return super.getItemPosition(r100);
    }

    public final void h(List<com.bytedance.android.livesdk.model.h> r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        ((ArrayList) this.f161449g).clear();
        ((ArrayList) this.f161449g).addAll(r100);
        this.f161450h = 0;
        this.f161445c.clear();
        this.f161446d.clear();
        Iterator<T> r101 = r100.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L9;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        com.bytedance.android.livesdk.model.h r105 = (com.bytedance.android.livesdk.model.h) r103;
        HashMap<Pair<Integer, Integer>, Integer> r106 = this.f161445c;
        Integer r107 = Integer.valueOf(this.f161450h);
        int r108 = this.f161450h;
        r105.getPageCount();
        r106.put(TuplesKt.to(r107, Integer.valueOf((r108 + 1) - 1)), Integer.valueOf(r102));
        this.f161446d.add(Integer.valueOf(this.f161450h));
        int r109 = this.f161450h;
        r105.getPageCount();
        this.f161450h = r109 + 1;
        r102 = r104;
        goto L4
    L9:
        this.f161447e = 0;
        this.f161448f = 0;
        notifyDataSetChanged();
        if (((ArrayList) this.f161449g).isEmpty() == true) goto L16;
        g(this.f161447e, this.f161448f);
        return;
    }

    public final void i(int r100) {
        this.f161452j.setCurrentItem(((Number) ListProtector.get(this.f161446d, r100)).intValue(), false);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int r100) {
        Iterator<Map.Entry<Integer, k>> r101 = this.f161444b.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().getValue().a();
        goto L4
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int r100) {
        int r101 = f(r100);
        this.f161448f = r100;
        this.f161447e = r101;
        g(r101, r100);
    }

    public final void g(int r100, int r101) {
        Iterator<T> r102 = this.f161443a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((Function3) r102.next()).invoke(Integer.valueOf(r100), Integer.valueOf(r101), ListProtector.get(this.f161449g, r100));
        goto L4
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        int r102 = f(r101);
        com.bytedance.android.livesdk.model.h r103 = (com.bytedance.android.livesdk.model.h) ListProtector.get(this.f161449g, r102);
        View r104 = r103.a(this.f161451i).getRootView();
        k r105 = r103.c(this.f161451i, r104);
        r105.b(this.f161453k);
        r100.addView(r105.getRootView(), -1, new ViewGroup.LayoutParams(-1, -1));
        this.f161444b.put(Integer.valueOf(r101), r105);
        return r105;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "object");
        if ((r101 instanceof k) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r100, ((k) r101).getRootView());
    }

    public ExpressionSectionPagerAdapter(Context r100, SSViewPager r101, ExpressionContext r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "viewPager");
        Intrinsics.checkNotNullParameter(r102, "expressionContext");
        this.f161451i = r100;
        this.f161452j = r101;
        this.f161453k = r102;
        r101.setAdapter(this);
        r101.addOnPageChangeListener(this);
        this.f161443a = new ArrayList();
        this.f161444b = new HashMap();
        this.f161445c = new HashMap();
        this.f161446d = new ArrayList();
        this.f161449g = new ArrayList();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "sectionPage");
        if ((r102 instanceof k) == false) goto L6;
        k r103 = (k) r102;
        r103.unbind();
        r100.removeView(r103.getRootView());
        this.f161444b.remove(Integer.valueOf(r101));
        return;
    }
}
