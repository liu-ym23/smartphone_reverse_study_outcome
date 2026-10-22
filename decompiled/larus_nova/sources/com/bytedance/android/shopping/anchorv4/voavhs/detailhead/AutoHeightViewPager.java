package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AutoHeightViewPager;", "Landroidx/viewpager/widget/ViewPager;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AutoHeightViewPager extends ViewPager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f168198a;

    public final void h(int r100) {
        PagerAdapter r101 = getAdapter();
        if (r101 == null) goto L5;
        int r102 = r101.getCount();
    L6:
        if (r102 <= r100) goto L12;
        ViewGroup.LayoutParams r103 = getLayoutParams();
        if (r103 == null) goto L11;
        LinearLayout.LayoutParams r104 = (LinearLayout.LayoutParams) r103;
        r104.height = this.f168198a;
        setLayoutParams(r104);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L12:
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public AutoHeightViewPager(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        addOnPageChangeListener(new AutoHeightViewPager$addPageChangeListener$1(this));
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final void onMeasure(int r100, int r101) {
        PagerAdapter r102 = getAdapter();
        View r103 = null;
        if ((r102 instanceof FragmentPagerAdapter) == true) goto L5;
        r102 = null;
    L5:
        FragmentPagerAdapter r104 = (FragmentPagerAdapter) r102;
        if (r104 == null) goto L10;
        Fragment r105 = r104.getItem(getCurrentItem());
        if (r105 == null) goto L10;
        r103 = r105.getView();
    L10:
        if (r103 == null) goto L12;
        r103.measure(r100, View.MeasureSpec.makeMeasureSpec(0, 0));
        this.f168198a = r103.getMeasuredHeight();
    L12:
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(this.f168198a, 1073741824));
    }
}
