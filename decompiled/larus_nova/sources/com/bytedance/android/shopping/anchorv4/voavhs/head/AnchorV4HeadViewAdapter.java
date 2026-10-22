package com.bytedance.android.shopping.anchorv4.voavhs.head;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.modifiedtime.ModifiedTimeWatch;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/AnchorV4HeadViewAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4HeadViewAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<View, com.bytedance.android.shopping.anchorv4.voavhs.head.base.a> f168419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f168420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.voavhs.head.base.a f168421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.base.f f168422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<? extends com.bytedance.android.shopping.anchorv4.voavhs.head.base.a> f168423e;

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f168423e.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getItemPosition(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "object");
        LinkedHashMap r101 = (LinkedHashMap) this.f168419a;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.a r102 = (com.bytedance.android.shopping.anchorv4.voavhs.head.base.a) r101.get((View) r100);
        int r103 = CollectionsKt.indexOf(this.f168423e, r102);
        if (r103 != (-1)) goto L6;
        return -2;
    L6:
        return r103;
    }

    public AnchorV4HeadViewAdapter(com.bytedance.android.shopping.anchorv4.voavhs.head.base.f r100, List<? extends com.bytedance.android.shopping.anchorv4.voavhs.head.base.a> r101) {
        Intrinsics.checkNotNullParameter(r100, "viewPagerCallback");
        Intrinsics.checkNotNullParameter(r101, "holders");
        this.f168422d = r100;
        this.f168423e = r101;
        this.f168419a = new LinkedHashMap();
        this.f168420b = -1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.a r102 = (com.bytedance.android.shopping.anchorv4.voavhs.head.base.a) ListProtector.get(this.f168423e, r101);
        View r103 = r102.b();
        r100.addView(r103);
        this.f168419a.put(r103, r102);
        r102.d();
        return r103;
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
        View r103 = (View) r102;
        r100.removeView(r103);
        Object r104 = ((LinkedHashMap) this.f168419a).get(r103);
        if ((r104 instanceof com.bytedance.android.shopping.anchorv4.voavhs.head.base.h) == true) goto L5;
        r104 = null;
    L5:
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.h r105 = (com.bytedance.android.shopping.anchorv4.voavhs.head.base.h) r104;
        if (r105 == null) goto L9;
        r105.j();
        return;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void setPrimaryItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "object");
        super.setPrimaryItem(r100, r101, r102);
        LinkedHashMap r103 = (LinkedHashMap) this.f168419a;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.a r104 = (com.bytedance.android.shopping.anchorv4.voavhs.head.base.a) r103.get((View) r102);
        int r105 = this.f168420b;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.a r106 = this.f168421c;
        this.f168420b = r101;
        this.f168421c = r104;
        if (r105 == r101) goto L10;
        if (r104 == null) goto L10;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.f r107 = this.f168422d;
        if (r105 != (-1)) goto L8;
        boolean r108 = true;
    L9:
        r107.c(r101, r108, r104.g());
        goto L10
    L8:
        r108 = false;
    L10:
        if (r105 == r101) goto L14;
        if (r106 == null) goto L15;
        this.f168422d.e(r106.g());
        return;
    L15:
        return;
    }
}
