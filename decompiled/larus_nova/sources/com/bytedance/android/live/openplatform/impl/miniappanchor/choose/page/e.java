package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page;

import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements TabLayout.OnTabSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MiniAppChooseContainerFragment f84164a;

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabReselected(TabLayout.Tab r100) {
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabUnselected(TabLayout.Tab r100) {
    }

    public e(MiniAppChooseContainerFragment r100) {
        this.f84164a = r100;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabSelected(TabLayout.Tab r100) {
        if (r100 == null) goto L19;
        Integer r101 = Integer.valueOf(r100.getPosition());
        if (r101.intValue() == this.f84164a.f84132p) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L10;
        r101 = null;
    L10:
        if (r101 == null) goto L15;
        int r103 = r101.intValue();
        if (r103 != 0) goto L14;
        this.f84164a.U90();
    L14:
        this.f84164a.f84132p = r103;
    L15:
        Iterator r104 = ((ArrayList) this.f84164a.f84124h).iterator();
    L17:
        if (r104.hasNext() == false) goto L21;
        ((c) r104.next()).MX(r100.getPosition());
        goto L17
    L21:
        return;
    L6:
        r102 = false;
        goto L7
    }
}
