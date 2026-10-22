package com.bytedance.android.gamecp.business.gallery.view.indicator;

import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.gamecp.business.gallery.transfer.d;
import com.bytedance.android.gamecp.business.gallery.transfer.e;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Metadata;
import ws.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/gamecp/business/gallery/view/indicator/TitleIndicator$mInternalPageChangeListener$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TitleIndicator$mInternalPageChangeListener$1 implements ViewPager.OnPageChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TitleIndicator f53371a;

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int r100) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int r100, float r101, int r102) {
    }

    public TitleIndicator$mInternalPageChangeListener$1(TitleIndicator r100) {
        this.f53371a = r100;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int r100) {
        a r101 = this.f53371a.f53369a;
        if (r101 == null) goto L7;
        d r102 = ((e) r101).getTransferConfig();
        if (r102 == null) goto L7;
        int r103 = r102.f53265u;
    L8:
        a r104 = this.f53371a.f53369a;
        String r105 = null;
        if (r104 == null) goto L20;
        d r106 = ((e) r104).getTransferConfig();
        if (r106 == null) goto L20;
        int r107 = r100 % r103;
        if (CollectionUtils.isEmpty(r106.f53254j) == true) goto L19;
        if (r107 < 0) goto L19;
        if (r107 >= r106.f53254j.size()) goto L19;
        String r108 = (String) ListProtector.get(r106.f53254j, r107);
    L22:
        if (r108 != null) goto L24;
    L31:
        this.f53371a.setVisibility(8);
    L32:
        this.f53371a.scrollTo(0, 0);
        return;
    L24:
        if (r108.length() <= 0) goto L26;
        boolean r109 = true;
    L27:
        if (r109 == false) goto L29;
        r105 = r108;
    L29:
        if (r105 == null) goto L31;
        this.f53371a.setText(r108);
        goto L32
    L26:
        r109 = false;
    L19:
        r108 = "";
    L20:
        r108 = null;
    L7:
        r103 = Integer.MAX_VALUE;
        goto L8
    }
}
