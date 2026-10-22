package com.bytedance.android.ec.store.product.presenter.element.mainimage;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/store/product/presenter/element/mainimage/AutoScrollImageAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AutoScrollImageAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<SimpleDraweeView> f48297a;

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f48297a.size();
    }

    public AutoScrollImageAdapter(ArrayList<SimpleDraweeView> r100) {
        Intrinsics.checkNotNullParameter(r100, "views");
        this.f48297a = r100;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        r100.addView((View) ListProtector.get(this.f48297a, r101));
        return ListProtector.get(this.f48297a, r101);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "object");
        return Intrinsics.areEqual(r100, r101);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "object");
        r100.removeView((View) ListProtector.get(this.f48297a, r101));
    }
}
