package com.bytedance.android.window.shop.widget;

import android.view.KeyEvent;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements ECTabLayout.OnTabSelectedListener {
    public d() {
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final /* synthetic */ void onTabSelected(ECTabLayout.Tab r100, boolean r101) {
        ECTabLayout.BaseOnTabSelectedListener.CC.$default$onTabSelected(this, r100, r101);
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final void onTabReselected(ECTabLayout.Tab r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        KeyEvent.Callback r101 = r100.getCustomView();
        if ((r101 instanceof com.bytedance.android.window.shop.widget.category.a) == true) goto L7;
        r101 = null;
    L7:
        com.bytedance.android.window.shop.widget.category.a r102 = (com.bytedance.android.window.shop.widget.category.a) r101;
        if (r102 == null) goto L11;
        r102.u();
        return;
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final void onTabSelected(ECTabLayout.Tab r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        KeyEvent.Callback r101 = r100.getCustomView();
        if ((r101 instanceof com.bytedance.android.window.shop.widget.category.a) == true) goto L7;
        r101 = null;
    L7:
        com.bytedance.android.window.shop.widget.category.a r102 = (com.bytedance.android.window.shop.widget.category.a) r101;
        if (r102 == null) goto L11;
        r102.u();
        return;
    }

    @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
    public final void onTabUnselected(ECTabLayout.Tab r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        KeyEvent.Callback r101 = r100.getCustomView();
        if ((r101 instanceof com.bytedance.android.window.shop.widget.category.a) == true) goto L7;
        r101 = null;
    L7:
        com.bytedance.android.window.shop.widget.category.a r102 = (com.bytedance.android.window.shop.widget.category.a) r101;
        if (r102 == null) goto L11;
        r102.w();
        return;
    }
}
