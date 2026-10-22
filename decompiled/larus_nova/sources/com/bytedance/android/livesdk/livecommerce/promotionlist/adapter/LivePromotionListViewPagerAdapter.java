package com.bytedance.android.livesdk.livecommerce.promotionlist.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.Toggle;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.ToggleElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/adapter/LivePromotionListViewPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePromotionListViewPagerAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Toggle f150866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Integer, View> f150867b;

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "object");
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final float getPageWidth(int r100) {
        return 0.9706f;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        List<ToggleElement> r100 = this.f150866a.getElements();
        if (r100 != null) goto L7;
        return 1;
    L7:
        return r100.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final CharSequence getPageTitle(int r100) {
        List<ToggleElement> r101 = this.f150866a.getElements();
        if (r101 == null) goto L7;
        ToggleElement r102 = (ToggleElement) ListProtector.get(r101, r100);
        if (r102 == null) goto L7;
        return r102.getText();
    L7:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LivePromotionListViewPagerAdapter(Toggle r100, Function1<? super Integer, ? extends View> r101) {
        Intrinsics.checkNotNullParameter(r100, "toggle");
        Intrinsics.checkNotNullParameter(r101, "getPageView");
        this.f150866a = r100;
        this.f150867b = r101;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        View r102 = this.f150867b.invoke(Integer.valueOf(r101));
        r100.addView(r102);
        return r102;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "o");
        return Intrinsics.areEqual(r100, r101);
    }
}
