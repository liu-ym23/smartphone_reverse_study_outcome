package com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes9.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PublicScreenAreaPagerIndicatorV2 f133709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PublicScreenAreaPagerIndicatorV2.TabView f133710b;

    public h(PublicScreenAreaPagerIndicatorV2 r100, PublicScreenAreaPagerIndicatorV2.TabView r101) {
        this.f133709a = r100;
        this.f133710b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PublicScreenAreaPageType r101 = this.f133710b.f133681e;
        ViewPager r102 = this.f133709a.f133673c;
        if ((r102 instanceof PublicScreenAreaPagerLayout) == true) goto L5;
        r102 = null;
    L5:
        PublicScreenAreaPagerLayout r103 = (PublicScreenAreaPagerLayout) r102;
        if (r103 == null) goto L9;
        r103.k(r101, PublicScreenAreaPageChangeSource.TabClick);
        return;
    }
}
