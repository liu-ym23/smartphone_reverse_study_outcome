package com.bytedance.android.shopping.anchorv3.detail.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.modifiedtime.ModifiedTimeWatch;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/detail/widget/VideoImageTransformAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoImageTransformAdapter extends PagerAdapter {
    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        throw null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getItemPosition(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "object");
        View r101 = (View) r100;
        throw null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        r100.addView(((l) ListProtector.get(null, r101)).b());
        throw null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, ModifiedTimeWatch.WATCH_TYPE_SPECIFIC);
        return Intrinsics.areEqual(r100, r101);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "object");
        r100.removeView((View) r102);
        throw null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void setPrimaryItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "object");
        super.setPrimaryItem(r100, r101, r102);
        new ArrayList();
        throw null;
    }
}
